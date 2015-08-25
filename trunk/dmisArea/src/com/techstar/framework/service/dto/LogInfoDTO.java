//Source file: C:\\test\\com\\techstar\\framework\\service\\dto\\LogInfoDto.java
/**
 * Sep 11, 2006
 * @author xcf
 */
package com.techstar.framework.service.dto;

import java.sql.Timestamp;;

/**
 * ����Ϊ��־��Ϣ���ݴ������
 */
public class LogInfoDTO {
	
	/**
	 * ���
	 * */
	private String logId;
	/**
	 * ������
	 */
	private String operator;

	/**
	 * ����ʱ��
	 */
	private Timestamp operateDate;

	/**
	 * ��������
	 */
	private String content;

	/**
	 * ������ʼʱ�䣨��־��ѯʱ������
	 */
	private String operateStartDate;

	/**
	 * ��������ʱ�䣨��־��ѯʱ������
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
		loginfo.append("����ʱ��:");
		loginfo.append(this.operateDate);
		loginfo.append("|������:");
		loginfo.append(this.operator);
		loginfo.append("|��������:");
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
