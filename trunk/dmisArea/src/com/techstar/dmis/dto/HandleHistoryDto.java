package com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 处理日志 This classe is based on ValueObject Pattern
 * 
 * @author
 * @date
 */
public class HandleHistoryDto implements Serializable {

	public HandleHistoryDto() {
	}

	private String bus_id; // 业务编号

	private String handle_comment; // 处理意见

	private java.sql.Timestamp handle_time; // 处理日期

	private String handle_person; // 处理人

	private String handle_result; // 处理结果

	private String id; // ID

	private int version; // 数据库版本控制

	/**
	 * getters and setters
	 */
	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}

	public String getBus_id() {
		return bus_id;
	}

	public void setHandle_comment(String handle_comment) {
		this.handle_comment = handle_comment;
	}

	public String getHandle_comment() {
		return handle_comment;
	}

	public java.sql.Timestamp getHandle_time() {
		return handle_time;
	}

	public void setHandle_time(java.sql.Timestamp handle_time) {
		this.handle_time = handle_time;
	}

	public void setHandle_person(String handle_person) {
		this.handle_person = handle_person;
	}

	public String getHandle_person() {
		return handle_person;
	}

	public void setHandle_result(String handle_result) {
		this.handle_result = handle_result;
	}

	public String getHandle_result() {
		return handle_result;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

}