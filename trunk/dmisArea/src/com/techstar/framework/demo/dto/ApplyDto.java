package com.techstar.framework.demo.dto;

import java.util.Date;

//import com.techstar.framework.demo.workflow.dto.TaskDto;

public class ApplyDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String applyId;
	
	private String applyTitle;

	private Date applyTime;

	private String department;

	private String applyer;

	private String warranter;

	private String relateScale;

	private String status;

	private String proprity;

	private String packageDest;
	
	private String taskId;
	
	private String taskName;
	
	private byte[] attachment;
	
	private String attachmentName;
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[ATTR_CNNAEM:申请编号&ATTR_ENNAME:applyId&ATTR_TYPE:string&ATTR_LENGTH:32&ATTR_VALUE:" + this.getApplyId() + "]");
		sb.append("$%$[ATTR_CNNAEM:申请标题&ATTR_ENNAME:applyTitle&ATTR_TYPE:string&ATTR_LENGTH:150&ATTR_VALUE:" + this.getApplyTitle() + "]");
		sb.append("$%$[ATTR_CNNAEM:申请时间&ATTR_ENNAME:applyTime&ATTR_TYPE:date&ATTR_LENGTH:50&ATTR_VALUE:" + this.getApplyTime() + "]");
		sb.append("$%$[ATTR_CNNAEM:申请部门&ATTR_ENNAME:department&ATTR_TYPE:string&ATTR_LENGTH:200&ATTR_VALUE:" + this.getDepartment() + "]");
		sb.append("$%$[ATTR_CNNAEM:申请人&ATTR_ENNAME:applyer&ATTR_TYPE:string&ATTR_LENGTH:50&ATTR_VALUE:" + this.getApplyer() + "]");
		return sb.toString();
	}
	
	//注册工作流dto
	/*private TaskDto taskDto;
	
	public TaskDto getTaskDto() {
		return taskDto;
	}

	public void setTaskDto(TaskDto taskDto) {
		this.taskDto = taskDto;
	}*/

	public ApplyDto() {
	}

	public String getApplyId() {
		return this.applyId;
	}
	
	
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	
	
	public String getApplyTitle() {
		return this.applyTitle;
	}
	
	
	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getApplyer() {
		return this.applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getWarranter() {
		return this.warranter;
	}

	public void setWarranter(String warranter) {
		this.warranter = warranter;
	}

	public String getRelateScale() {
		return this.relateScale;
	}

	public void setRelateScale(String relateScale) {
		this.relateScale = relateScale;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProprity() {
		return this.proprity;
	}

	public void setProprity(String proprity) {
		this.proprity = proprity;
	}

	public String getPackageDest() {
		return this.packageDest;
	}

	public void setPackageDest(String packageDest) {
		this.packageDest = packageDest;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}	

	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}	
	
	/*public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" applyid:" + this.applyId);
		sb.append(" ������:" + this.applyer);
		sb.append(" ����: " + this.department);
		sb.append(" ʱ��: " + this.applyTime);
		return sb.toString();
	}*/

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	

	/*public CompanyDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}*/

}