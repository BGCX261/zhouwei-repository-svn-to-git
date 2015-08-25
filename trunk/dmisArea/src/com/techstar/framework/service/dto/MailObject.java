//Source file: C:\\test\\com\\techstar\\framework\\service\\dto\\MailObject.java
/**
 * Sep 11, 2006
 * @author xcf
 */
package com.techstar.framework.service.dto;

import com.techstar.framework.utils.ConfigurationHelper;

public class MailObject {
	/**
	 * 邮件主题
	 * */
	private String topic;
	/**
	 * 邮件内容
	 * */
	private String text;
	/**
	 * 附件
	 * */
	private String[] attachements;
	/**
	 * 收件人
	 * */
	private String[] recipients;
	
	/**
	 * 抄送人
	 * */
	private String[] tocc;
	/**
	 * 发件人
	 * */
	private String sender;
	
	/**
	 * 发送人邮件服务器地址
	 * */
	private String senderHost;
	
	/**
	 * 发送人密码
	 * */
	private String senderPwd;
	
	private String sendDate;
	
	
	/**
	 * @roseuid 44EA63B10258
	 */
	public MailObject() {

	}

	public String[] getAttachements() {
		return attachements;
	}

	public void setAttachements(String[] attachements) {
		this.attachements = attachements;
	}

	public String[] getRecipients() {
		return recipients;
	}

	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSender() {
		if( sender == null || "".equals(sender)){
			sender = ConfigurationHelper.getMailUser();
		}
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderHost() {
		if( senderHost == null || "".equals(senderHost)){
			senderHost = ConfigurationHelper.getMailHost();
		}
		return senderHost;
	}

	public void setSenderHost(String senderHost) {
		this.senderHost = senderHost;
	}

	public String getSenderPwd() {
		if( senderPwd == null || "".equals(senderPwd)){
			senderPwd = ConfigurationHelper.getMailPwd();
		}
		return senderPwd;
	}

	public void setSenderPwd(String senderPwd) {
		this.senderPwd = senderPwd;
	}

	public String[] getTocc() {
		return tocc;
	}

	public void setTocc(String[] tocc) {
		this.tocc = tocc;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
}
