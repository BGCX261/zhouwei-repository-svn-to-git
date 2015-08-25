//Source file: C:\\test\\com\\techstar\\framework\\service\\mail\\MailServiceImpl.java

package com.techstar.framework.service.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.techstar.framework.exception.BaseException;
import com.techstar.framework.exception.MailServiceException;
import com.techstar.framework.service.dto.MailObject;
import com.techstar.framework.service.mail.helper.ParseMailHelper;
import com.techstar.framework.utils.ConfigurationHelper;

/**
 * mail服务实现类，完成邮件群发、附件发送、文本发送等功能
 * Sep 11, 2006
 * @author xcf
 */
public class MailServiceImpl implements IMailLocalService {

	private JavaMailSenderImpl sender;

	private MailObject mailObject;

	

	/**
	 * @roseuid 44EAB4E3029F
	 */
	public MailServiceImpl() {

	}

	/**
	 * 发送基本邮件内容，不包括附件，可群发
	 * @return Boolean
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44E16D840218
	 */
	private Boolean sendTextMsg() throws BaseException {
		try {
			configMailSender();

			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom(mailObject.getSender());
			msg.setSubject(mailObject.getTopic());
			msg.setText(mailObject.getText());
			msg.setTo(mailObject.getRecipients());
			msg.setCc(mailObject.getTocc());

			sender.send(msg);
			return Boolean.TRUE;
		} catch (Exception ce) {
			throw new MailServiceException("pps.mailServiceException", ce);
		}

	}
	
	/**
	 * 构造MailSender
	 * */
	private void configMailSender() {
		sender = new JavaMailSenderImpl();
		sender.setHost(mailObject.getSenderHost());
		sender.setUsername(mailObject.getSender());
		sender.setPassword(mailObject.getSenderPwd());
		Properties pt = new Properties();
		pt.setProperty("mail.smtp.auth", "true");
		sender.setJavaMailProperties(pt);
	}

	/**
	 * 发送带附件的邮件
	 * @return Boolean
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44E16D840219
	 */
	private Boolean sendAttacheMsg() throws BaseException {
		try {
		configMailSender();	
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(mailObject.getSender());
		helper.setSubject(mailObject.getTopic());
		helper.setText(mailObject.getText());
		helper.setTo(mailObject.getRecipients());
		helper.setCc(mailObject.getTocc());
		
		
		String[] attachements = mailObject.getAttachements(); //上传附件的本地绝对路径
		for(int i=0; i<attachements.length; i++){
			FileSystemResource res = new FileSystemResource(new File(attachements[i]));          
			helper.addAttachment(MimeUtility.encodeText(res.getFilename(), "GBK", null), res);
		}
		
		sender.send(message);
		removeAttachment(); //发送完附件后，删除服务器上的相应文件
		return Boolean.TRUE;
		}catch(Exception ce){
			throw new MailServiceException("pps.mailServiceException.sendAttacheMsg", ce);
		}
		
	}
	
	/**
	 * 删除附件
	 * */
	private void removeAttachment() {
		// TODO Auto-generated method stub
		String[] fileName = mailObject.getAttachements();
		for (int i = 0; i < fileName.length; i++) {
			if (!"".equals(fileName[i])) {
				String temp = fileName[i];
				System.out.println(temp);
				File file = new File(temp);
				file.delete();
			}
		}
	}

	/**
	 * @param mailObject
	 * @return Object
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44EAB4E302CD
	 */
	public Object sendMail(MailObject mo) throws BaseException {
		this.mailObject = mo;
		if (mailObject == null)
			return Boolean.FALSE;
		else {
			if (mailObject.getAttachements() != null
					&& mailObject.getAttachements().length > 0) {
				return this.sendAttacheMsg();
			} else {
				return this.sendTextMsg();
			}
		}

	}

	/**
	 * @return Object
	 * @throws com.techstar.framework.exception.BaseException
	 * @roseuid 44EAB4E3031C
	 */
	public Object receiveMail(String mailHost , String mailuser , String mailPwd) throws BaseException{
		try{
			String host = mailHost; 
	        String username = mailuser;      
	        String password = mailPwd;     

	        Properties props = new Properties(); 
	        Session session = Session.getDefaultInstance(props, null); 
	        Store store = session.getStore("pop3"); 
	        store.connect(host, username, password); 

	        Folder folder = store.getFolder("INBOX"); 
	        folder.open(Folder.READ_ONLY); 
	        Message message[] = folder.getMessages(); 

	        
	        ParseMailHelper pmm = null; 
	        List mailObjects = new ArrayList();
	        for(int i=0;i<message.length;i++){ 
	            pmm = new ParseMailHelper((MimeMessage)message[i]);
	            MailObject mo = new MailObject();
	            mo.setTopic(pmm.getSubject());
	            mo.setSendDate(pmm.getSentDate());
	            mo.setSender(pmm.getFrom());
	            mo.setRecipients(pmm.getMailAddress("to"));
	            mo.setTocc(pmm.getMailAddress("cc"));            
	            pmm.getMailContent((Part)message[i]);
	            mo.setText(pmm.getBodyText());	       
	            pmm.setAttachPath(ConfigurationHelper.getMailUploadFilePath()); 
		        String[] filenames = pmm.saveAttachMent((Part)message[i]); //得到附件名称(不带路径)
	            mo.setAttachements(filenames);	        
	            
	            mailObjects.add(mo);
	        } 
	        return mailObjects;
		}catch(Exception ce){
			throw new MailServiceException("pps.mailServiceException.sendAttacheMsg", ce);
		}

		
	}

	public MailObject getMailObject() {
		return mailObject;
	}

	public void setMailObject(MailObject mailObject) {
		this.mailObject = mailObject;
	}

}
