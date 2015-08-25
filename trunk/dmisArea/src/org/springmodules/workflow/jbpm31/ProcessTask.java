package org.springmodules.workflow.jbpm31;

public class ProcessTask {

	long processId;
	String processName;
	long processVersion;
	long taskId;
	String taskName;
	
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public long getProcessVersion() {
		return processVersion;
	}
	public void setProcessVersion(long processVersion) {
		this.processVersion = processVersion;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
	
}
