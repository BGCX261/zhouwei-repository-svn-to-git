package com.techstar.dmis.helper.dto;

public class WorkflowHandleDto {

	String userId ;			//当前处理人的用户ID
	String roleId ;			//当前处理人的角色ID
	String[] nextTaskRoles;	//下一任务处理人的角色集合
	String busId ;			//业务ID
	String taskId ;			//任务实例ID
	String taskInstanceId ;	//任务实例ID
	String status ;			//状态
	String transitionFlag ; //流转方向
	String notices ; 		//处理意见
	String messages ; 		//消息内容
	String sentPersons ; 	//消息接收人
	String isSms ; 			//是否发送手机短信
	
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getIsSms() {
		return isSms;
	}
	public void setIsSms(String isSms) {
		this.isSms = isSms;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getNotices() {
		return notices;
	}
	public void setNotices(String notices) {
		this.notices = notices;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getSentPersons() {
		return sentPersons;
	}
	public void setSentPersons(String sentPersons) {
		this.sentPersons = sentPersons;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskInstanceId() {
		return taskInstanceId;
	}
	public void setTaskInstanceId(String taskInstanceId) {
		this.taskInstanceId = taskInstanceId;
	}
	public String getTransitionFlag() {
		return transitionFlag;
	}
	public void setTransitionFlag(String transitionFlag) {
		this.transitionFlag = transitionFlag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String[] getNextTaskRoles() {
		return nextTaskRoles;
	}
	public void setNextTaskRoles(String[] nextTaskRoles) {
		this.nextTaskRoles = nextTaskRoles;
	}

	
	
}
