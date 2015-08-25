package com.techstar.framework.service.messaging.message;


import com.techstar.framework.service.messaging.message.TSSPHeader;

/**
 * 继承框架消息服务消息头
 * 
 * @author caojian Apr 3, 2007
 * modify by xiongcf 2007-4-26
 */
public class EXTSSPHeader extends TSSPHeader {
	private String bussinessSign;

	private String centerTaskId;

	private String areaTaskId;

	private String type;

	private String isTrigger;

	private String objectName;

	private String methodName;
	
	//增加通知内容
	private String notifyContent;

	public EXTSSPHeader() {
	}

	public EXTSSPHeader(String from, String to, String bussinessSign,
			String centerTaskId, String areaTaskId, String type,
			String contentVersion, String isTrigger, String objectName,
			String methodName, String timestamp, String traceNumber,
			String contentType, String title , String notifyContent) {
		super(from, to, title, timestamp, traceNumber, contentType,
				contentVersion);
		this.bussinessSign = bussinessSign;
		this.centerTaskId = centerTaskId;
		this.areaTaskId = areaTaskId;
		this.type = type;
		this.isTrigger = isTrigger;
		this.objectName = objectName;
		this.methodName = methodName;
		this.notifyContent = notifyContent;
	}

	public String getAreaTaskId() {
		return areaTaskId;
	}

	public void setAreaTaskId(String areaTaskId) {
		this.areaTaskId = areaTaskId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotifyContent() {
		return notifyContent;
	}

	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}

}
