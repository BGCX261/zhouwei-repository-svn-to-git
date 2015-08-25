package com.techstar.framework.service.workflow.bus.dto;

import java.util.List;

public class ProcessInstanceDto {
	private long id;
	private boolean isEnd;
	private java.util.Date start_date;
	private java.util.Date end_date;
	private boolean isSuspend;
	private String actor_str;
	private String task_str;
	private String task_actor;
	
	
	private List logs;
	private long version;
	
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public boolean getIsSuspend() {
		return isSuspend;
	}
	public void setIsSuspend(boolean isSuspend) {
		this.isSuspend = isSuspend;
	}
	public List getLogs() {
		return logs;
	}
	public void setLogs(List logs) {
		this.logs = logs;
	}
	public java.util.Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(java.util.Date end_date) {
		this.end_date = end_date;
	}
	public java.util.Date getStart_date() {
		return start_date;
	}
	public void setStart_date(java.util.Date start_date) {
		this.start_date = start_date;
	}
	public String getActor_str() {
		return actor_str;
	}
	public void setActor_str(String actor_str) {
		this.actor_str = actor_str;
	}
	public String getTask_str() {
		return task_str;
	}
	public void setTask_str(String task_str) {
		this.task_str = task_str;
	}
	public String getTask_actor() {
		return task_actor;
	}
	public void setTask_actor(String task_actor) {
		this.task_actor = task_actor;
	}

}
