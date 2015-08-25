//Source file: C:\\test\\com\\techstar\\framework\\service\\dto\\LogInfoDto.java
/**
 * Sep 11, 2006
 * @author xcf
 */
package com.techstar.framework.service.dto;

import java.sql.Timestamp;;

/**
 * 此类为日志信息数据传输对象
 */
public class LogInfoDTO {
	
	/**
	 * 序号
	 * */
	private String logId;
	/**
	 * 操作人
	 */
	private String operator;

	/**
	 * 操作时间
	 */
	private Timestamp operateDate;

	/**
	 * 操作内容
	 */
	private String content;

	/**
	 * 操作开始时间（日志查询时参数）
	 */
	private String operateStartDate;

	/**
	 * 操作结束时间（日志查询时参数）
	 */
	private String operateEndDate;

	/**
	 * @roseuid 44EA63B10239
	 */
	public LogInfoDTO() {

	}

	public LogInfoDTO(String operator, Timestamp operateDate, String content) {
		super();
		this.operator = operator;
		this.operateDate = operateDate;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Timestamp operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateEndDate() {
		return operateEndDate;
	}

	public void setOperateEndDate(String operateEndDate) {
		this.operateEndDate = operateEndDate;
	}

	public String getOperateStartDate() {
		return operateStartDate;
	}

	public void setOperateStartDate(String operateStartDate) {
		this.operateStartDate = operateStartDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String toString(){
		StringBuffer loginfo = new StringBuffer();
		loginfo.append("操作时间:");
		loginfo.append(this.operateDate);
		loginfo.append("|操作人:");
		loginfo.append(this.operator);
		loginfo.append("|操作内容:");
		loginfo.append(this.content);
		return loginfo.toString();
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	
}
