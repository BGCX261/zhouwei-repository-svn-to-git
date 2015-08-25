package com.techstar.framework.service.workflow.bus.dto;

public class TaskInstanceDto {
	
	private String actionId;
	private java.util.Date create;
	private java.util.Date dueDate;
	private String name;
	private boolean hasEnded;
	private long id;
	private String description;
	private String create_str;
	private String duedate_str;
	private String node_name;
	private String node_actor;
	
	public String getNode_actor() {
		return node_actor;
	}
	public void setNode_actor(String node_action) {
		this.node_actor = node_actor;
	}
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	public String getCreate_str() {
		return create_str;
	}
	public void setCreate_str(String create_str) {
		this.create_str = create_str;
	}
	public String getDuedate_str() {
		return duedate_str;
	}
	public void setDuedate_str(String duedate_str) {
		this.duedate_str = duedate_str;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public java.util.Date getCreate() {
		return create;
	}
	public void setCreate(java.util.Date create) {
		this.create = create;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public java.util.Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(java.util.Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean getHasEnded() {
		return hasEnded;
	}
	public void setHasEnded(boolean hasEnded) {
		this.hasEnded = hasEnded;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
