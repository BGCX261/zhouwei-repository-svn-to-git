package com.techstar.exchange.dto.control;

import java.util.List;

/**
 * 控制信息DTO，用来构造SOAP消息头
 * 
 * @author caojian Apr 2, 2007
 * modify by xiongcf 2007-4-19
 */
public class ControlDto {
	/** 发送方编码 SJ 市调 HD 海淀.... */
	private String from;

	/** 接收方编码 SJ 市调 HD 海淀.... */
	private String to;

	/** 业务标识 */
	private String bussinessSign;
	
	/** 模块名 */
	private String module;
	
	/**通知内容:该信息是跟随esb消息发送时，需要发通知的内容**/
	private String notifyContent;
	
	/** 中心任务Id */
	private String centerTaskId;	
	
	/** 二级单位任务Id */
	private String areaTaskId;	
	
	/** 类型 1-通知 2-公告 3-业务*/
	private String type;	
	
	/** 版本*/
	private String contentVersion;	
	
	/** 是否触发器*/
	private String isTrigger;		
	
	/** 业务对象名称*/
	private String objectName;	
	
	/** 业务方法名称*/
	private String methodName;	
	
	/** 跟踪号*/
	private String traceNumber;
	
	/** 发送时间*/
	private String sendTime;
	
	/** 接收时间*/
	private String recvTime;
	
	/**是否发送短信0-不发 1-发送*/
//	private int sentSms; 
	
	/**接收方信息RecvDto集合*/
	private List recvDtos;
	
	/** 附件集合，List中均为AttachmentDto */
	private List attachments;

	public String getAreaTaskId() {
		return areaTaskId;
	}

	public void setAreaTaskId(String areaTaskId) {
		this.areaTaskId = areaTaskId;
	}

	public List getAttachments() {
		return attachments;
	}

	public void setAttachments(List attachments) {
		this.attachments = attachments;
	}

	public String getBussinessSign() {
		return bussinessSign;
	}

	public void setBussinessSign(String bussinessSign) {
		this.bussinessSign = bussinessSign;
	}

	public String getCenterTaskId() {
		return centerTaskId;
	}

	public void setCenterTaskId(String centerTaskId) {
		this.centerTaskId = centerTaskId;
	}

	public String getContentVersion() {
		return contentVersion;
	}

	public void setContentVersion(String contentVersion) {
		this.contentVersion = contentVersion;
	}

	public String getFrom() {
		
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getIsTrigger() {
		return isTrigger;
	}

	public void setIsTrigger(String isTrigger) {
		this.isTrigger = isTrigger;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecvTime() {
		return recvTime;
	}

	public void setRecvTime(String recvTime) {
		this.recvTime = recvTime;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public List getRecvDtos() {
		return recvDtos;
	}

	

	public void setRecvDtos(List recvDtos) {
		this.recvDtos = recvDtos;
	}

	

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getNotifyContent() {
		return notifyContent;
	}

	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
}