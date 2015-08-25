package com.techstar.dmis.service.message.bean;

import java.util.List;

public class MessageBean {
	private List attachments;//附件
    private Object obj;  //业务对象
	public List getAttachments() {
		return attachments;
	}
	public void setAttachments(List attachments) {
		this.attachments = attachments;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
    
}
