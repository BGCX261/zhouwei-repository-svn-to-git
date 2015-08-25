package com.techstar.framework.service.workflow.bus.dto;

public class ProcessDefinedDto {
	String processDefinedName ="";
    String processDefinedId="";
    String view_Instance="";
	public String getView_Instance() {
		return view_Instance;
	}
	public void setView_Instance(String view_Instance) {
		this.view_Instance = view_Instance;
	}
	public String getProcessDefinedId() {
		return processDefinedId;
	}
	public void setProcessDefinedId(String processDefinedId) {
		this.processDefinedId = processDefinedId;
	}
	public String getProcessDefinedName() {
		return processDefinedName;
	}
	public void setProcessDefinedName(String processDefinedName) {
		this.processDefinedName = processDefinedName;
	}
    

}
