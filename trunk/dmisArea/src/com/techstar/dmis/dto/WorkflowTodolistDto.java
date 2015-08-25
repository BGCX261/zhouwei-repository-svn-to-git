package com.techstar.dmis.dto;

import java.sql.Date;

public class WorkflowTodolistDto {

	String id;
	String content;
	String status;
	String bstatus;
	long taskInstanceId_;
	String taskName_;
	Date createTime_;
	long taskId_;
	long processdefinition_;
	
	

	public String getBstatus() {
		return bstatus;
	}
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime_() {
		return createTime_;
	}
	public void setCreateTime_(Date createTime_) {
		this.createTime_ = createTime_;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getProcessdefinition_() {
		return processdefinition_;
	}
	public void setProcessdefinition_(long processdefinition_) {
		this.processdefinition_ = processdefinition_;
	}
	public long getTaskId_() {
		return taskId_;
	}
	public void setTaskId_(long taskId_) {
		this.taskId_ = taskId_;
	}
	public long getTaskInstanceId_() {
		return taskInstanceId_;
	}
	public void setTaskInstanceId_(long taskInstanceId_) {
		this.taskInstanceId_ = taskInstanceId_;
	}
	public String getTaskName_() {
		return taskName_;
	}
	public void setTaskName_(String taskName_) {
		this.taskName_ = taskName_;
	}
	
	
}
