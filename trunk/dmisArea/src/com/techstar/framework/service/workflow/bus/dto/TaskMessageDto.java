package com.techstar.framework.service.workflow.bus.dto;

import org.apache.commons.lang.StringUtils;

public class TaskMessageDto {
	
	public final static int TASKTYPE_NODE=0;
	public final static int TASKTYPE_TASK=1;
	long message_id;
	long process_id;
	long task_id;
	String message_from_name;
	String message_to_name;
	String message_from_queue;
	String Message_to_queue;
	String[] message_to= new String[50];
	String[] message_to_queues = new String[50];
	int message_type;
	String receive;
	String content;
	String message_bus_name;
	int tasktype=0;
	
	public int getTasktype() {
		return tasktype;
	}

	public void setTasktype(int tasktype) {
		this.tasktype = tasktype;
	}

	public String getMessage_bus_name() {
		return message_bus_name;
	}

	public void setMessage_bus_name(String message_bus_name) {
		this.message_bus_name = message_bus_name;
	}

	public int getMessage_type() {
		return message_type;
	}

	public void setMessage_type(int message_type) {
		this.message_type = message_type;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String[] getMessage_to_queues() {
	   if(StringUtils.isNotEmpty(this.getMessage_from_queue())){
			message_to_queues = StringUtils.split(this.getMessage_from_queue(),";");
		}
		return message_to_queues;
	}
	
	public void setMessage_to_queues(String[] message_to_queues) {
		this.message_to_queues = message_to_queues;
	}
	
	public String[] getMessage_to() {	
	if(StringUtils.isNotEmpty(this.getMessage_to_name())){
		message_to = StringUtils.split(this.getMessage_to_name(),";");
	 }
			return message_to;
	}
	public void setMessage_to(String[] message_to) {
		this.message_to = message_to;
	}
	
	public String getMessage_from_queue() {
		return message_from_queue;
	}
	public void setMessage_from_queue(String message_from_queue) {
		this.message_from_queue = message_from_queue;
	}
	public long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public String getMessage_from_name() {
		return message_from_name;
	}
	public void setMessage_from_name(String message_from_name) {
		this.message_from_name = message_from_name;
	}
	public String getMessage_to_name() {
		return message_to_name;
	}
	public void setMessage_to_name(String message_to_name) {
		this.message_to_name = message_to_name;
	}
	public void setProcess_id(long process_id) {
		this.process_id = process_id;
	}
	public String getMessage_to_queue() {
		return Message_to_queue;
	}
	public void setMessage_to_queue(String message_to_queue) {
		Message_to_queue = message_to_queue;
	}
	public long getProcess_id() {
		return process_id;
	}

	public long getTask_id() {
		return task_id;
	}
	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
