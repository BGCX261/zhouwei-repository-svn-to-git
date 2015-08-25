package com.techstar.exchange.dto.control;


/**
 * 附件DTO，用来存储附件信息
 * 
 * @author caojian Apr 2, 2007
 * 
 */
public class AttachmentDto {
	/** 编号，对应业务记录的32位逻辑编号 */
	private String id;
	
	/** 内容 */
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}
