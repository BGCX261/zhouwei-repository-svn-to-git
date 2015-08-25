//Source file: C:\\test\\com\\techstar\\framework\\service\\dto\\MailObject.java
/**
 * Sep 11, 2006
 * @author xcf
 */
package com.techstar.framework.service.dto;

import com.techstar.framework.utils.ConfigurationHelper;

public class MailObject {
	/**
	 * �ʼ�����
	 * */
	private String topic;
	/**
	 * �ʼ�����
	 * */
	private String text;
	/**
	 * ����
	 * */
	private String[] attachements;
	/**
	 * �ռ���
	 * */
	private String[] recipients;
	
	/**
	 * ������
	 * */
	private String[] tocc;
	/**
	 * ������
	 * */
	private String sender;
	
	/**
	 * �������ʼ���������ַ
	 * */
	private String senderHost;
	
	/**
	 * ����������
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
