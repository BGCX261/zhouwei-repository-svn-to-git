package com.techstar.framework.service.mail.helper;

/**
 * 解析接收到的mail信息
 * Sep 11, 2006
 * @author xcf
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.techstar.framework.exception.BaseException;

public class ParseMailHelper {
	private MimeMessage mimeMessage = null;

	private String saveAttachPath = ""; //附件下载后的存放目录 

	private StringBuffer bodytext = new StringBuffer(); //存放邮件内容的StringBuffer对象 

	private String dateformat = "yy-MM-dd HH:mm"; //默认的日前显示格式 

	/** 
	 * 构造函数,初始化一个MimeMessage对象 
	 */
	public ParseMailHelper() {
	}

	public ParseMailHelper(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
//		System.out.println("create a PraseMimeMessage object........");
	}

	public void setMimeMessage(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	/** 
	 * 获得发件人的地址和姓名 
	 */
	public String getFrom() throws BaseException {
		try {
			InternetAddress address[] = (InternetAddress[]) mimeMessage
					.getFrom();
			String from = address[0].getAddress();
			if (from == null)
				from = "";
			String personal = address[0].getPersonal();
			if (personal == null)
				personal = "";
			String fromaddr = personal + "<" + from + ">";
			return fromaddr;
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/**
	 * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址
	 */
	public String[] getMailAddress(String type) throws BaseException {
		try {
			String[] mailaddr = null;
			String addtype = type.toUpperCase();
			InternetAddress[] address = null;
			if (addtype.equals("TO") || addtype.equals("CC")
					|| addtype.equals("BCC")) {
				if (addtype.equals("TO")) {
					address = (InternetAddress[]) mimeMessage
							.getRecipients(Message.RecipientType.TO);
				} else if (addtype.equals("CC")) {
					address = (InternetAddress[]) mimeMessage
							.getRecipients(Message.RecipientType.CC);
				} else {
					address = (InternetAddress[]) mimeMessage
							.getRecipients(Message.RecipientType.BCC);
				}
				if (address != null) {
					mailaddr = new String[address.length];
					for (int i = 0; i < address.length; i++) {
						String email = address[i].getAddress();
						if (email == null)
							email = "";
						else {
							email = MimeUtility.decodeText(email);
						}
						String personal = address[i].getPersonal();
						if (personal == null)
							personal = "";
						else {
							personal = MimeUtility.decodeText(personal);
						}
						String compositeto = personal + "<" + email + ">";
						mailaddr[i] = compositeto;
					}
				}
			} else {
				throw new BaseException("pps.mailServiceException.parseMail");
			}
			return mailaddr;
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 获得邮件主题 
	 */
	public String getSubject() throws BaseException {
		String subject = "";
		try {
			subject = MimeUtility.decodeText(mimeMessage.getSubject());
			if (subject == null)
				subject = "";
		} catch (Exception exce) {
		}
		return subject;
	}

	/** 
	 * 获得邮件发送日期 
	 */
	public String getSentDate() throws BaseException {
		try {
			Date sentdate = mimeMessage.getSentDate();
			SimpleDateFormat format = new SimpleDateFormat(dateformat);
			return format.format(sentdate);
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 获得邮件正文内容 
	 */
	public String getBodyText() {
		return bodytext.toString();
	}

	/** 
	 * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 
	 * 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析 
	 */
	public void getMailContent(Part part) throws BaseException {
		try {
			String contenttype = part.getContentType();
			int nameindex = contenttype.indexOf("name");
			boolean conname = false;
			if (nameindex != -1)
				conname = true;

//			System.out.println("CONTENTTYPE: " + contenttype);
			if (part.isMimeType("text/plain") && !conname) {
				bodytext.append((String) part.getContent());
			} else if (part.isMimeType("text/html") && !conname) {
				bodytext.append((String) part.getContent());
			} else if (part.isMimeType("multipart/*")) {
				Multipart multipart = (Multipart) part.getContent();
				int counts = multipart.getCount();
				for (int i = 0; i < counts; i++) {
					getMailContent(multipart.getBodyPart(i));
				}
			} else if (part.isMimeType("message/rfc822")) {
				getMailContent((Part) part.getContent());
			}
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false" 
	 */
	public boolean getReplySign() throws BaseException {
		try {
			boolean replysign = false;
			String needreply[] = mimeMessage
					.getHeader("Disposition-Notification-To");
			if (needreply != null) {
				replysign = true;
			}
			return replysign;
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 获得此邮件的Message-ID 
	 */
	public String getMessageId() throws BaseException {
		try {
			return mimeMessage.getMessageID();
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 【判断此邮件是否已读，如果未读返回返回false,反之返回true】 
	 */
	public boolean isNew() throws BaseException {
		try {
			boolean isnew = false;
			Flags flags = ((Message) mimeMessage).getFlags();
			Flags.Flag[] flag = flags.getSystemFlags();
//			System.out.println("flags's length: " + flag.length);
			for (int i = 0; i < flag.length; i++) {
				if (flag[i] == Flags.Flag.SEEN) {
					isnew = true;
//					System.out.println("seen Message.......");
					break;
				}
			}
			return isnew;
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 判断此邮件是否包含附件 
	 */
	public boolean isContainAttach(Part part) throws BaseException {
		try {
			boolean attachflag = false;			
			if (part.isMimeType("multipart/*")) {
				Multipart mp = (Multipart) part.getContent();
				for (int i = 0; i < mp.getCount(); i++) {
					BodyPart mpart = mp.getBodyPart(i);
					String disposition = mpart.getDisposition();
					if ((disposition != null)
							&& ((disposition.equals(Part.ATTACHMENT)) || (disposition
									.equals(Part.INLINE))))
						attachflag = true;
					else if (mpart.isMimeType("multipart/*")) {
						attachflag = isContainAttach((Part) mpart);
					} else {
						String contype = mpart.getContentType();
						if (contype.toLowerCase().indexOf("application") != -1)
							attachflag = true;
						if (contype.toLowerCase().indexOf("name") != -1)
							attachflag = true;
					}
				}
			} else if (part.isMimeType("message/rfc822")) {
				attachflag = isContainAttach((Part) part.getContent());
			}
			return attachflag;
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
	}

	/** 
	 * 【保存附件】 
	 */
	public String[] saveAttachMent(Part part) throws BaseException {
		String[] filenames = null;
		try {
			String fileName = "";			
			if (part.isMimeType("multipart/*")) {
				Multipart mp = (Multipart) part.getContent();
				filenames = new String[mp.getCount()-1];
				int k=0;
				for (int i = 0; i < mp.getCount(); i++) {
					BodyPart mpart = mp.getBodyPart(i);
					String disposition = mpart.getDisposition();
					if ((disposition != null)
							&& ((disposition.equals(Part.ATTACHMENT)) || (disposition
									.equals(Part.INLINE)))) {
						
						fileName = mpart.getFileName();
						if(fileName != null){
							fileName = MimeUtility.decodeText(fileName);						
							saveFile(fileName, mpart.getInputStream());
							filenames[k++] = fileName;							
						}
					} else if (mpart.isMimeType("multipart/*")) {
						saveAttachMent(mpart);
					} else {
						fileName = mpart.getFileName();
						if(fileName != null){
							fileName = MimeUtility.decodeText(fileName);
							saveFile(fileName, mpart.getInputStream());
							filenames[k++] = fileName;							
						}
					}
					
				}
			} else if (part.isMimeType("message/rfc822")) {
				saveAttachMent((Part) part.getContent());
			}
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		}
		return filenames;
	}

	/** 
	 * 【设置附件存放路径】 
	 */
	public void setAttachPath(String attachpath) {
		this.saveAttachPath = attachpath;
	}

	/** 
	 * 【设置日期显示格式】 
	 */
	public void setDateFormat(String format) throws BaseException {
		this.dateformat = format;
	}

	/** 
	 * 【获得附件存放路径】 
	 */
	public String getAttachPath() {
		return saveAttachPath;
	}

	/** 
	 * 【真正的保存附件到指定目录里】 
	 */
	private void saveFile(String fileName, InputStream in) throws BaseException {

		String storedir = getAttachPath();
		String separator = "";		
		File storefile = new File(storedir + separator + fileName);
//		System.out.println("storefile's path: " + storefile.toString());
		//for(int i=0;storefile.exists();i++){ 
		//storefile = new File(storedir+separator+fileName+i); 
		//} 
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(storefile));
			bis = new BufferedInputStream(in);
			int c;
			while ((c = bis.read()) != -1) {
				bos.write(c);
				bos.flush();
			}
		} catch (Exception ce) {
			throw new BaseException("pps.mailServiceException.parseMail", ce);
		} finally {
			try {
				bos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new BaseException("pps.mailServiceException.parseMail", e);
			}

		}
	}

}
