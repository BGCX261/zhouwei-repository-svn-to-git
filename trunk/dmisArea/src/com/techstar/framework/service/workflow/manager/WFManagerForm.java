package com.techstar.framework.service.workflow.manager;


import com.techstar.framework.web.form.BaseForm;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.service.workflow.bus.dto.TaskMessageDto;

public class WFManagerForm extends BaseForm {
	String wfName="";
	long   processInstanceId=0;
	long   processdefId=0;
	String primaryInfo="";
	long   node_id=0;
	String type="";
	String graphics="";
	String submit="";
	FormFile wf_cmsfile;
	int    isinit = 0;
	long   taskinstanceId;
	String roles="";
	TaskMessageDto messageDto = new TaskMessageDto();
	
	
	public TaskMessageDto getMessageDto() {
		return messageDto;
	}
	public void setMessageDto(TaskMessageDto messageDto) {
		this.messageDto = messageDto;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public long getTaskinstanceId() {
		return taskinstanceId;
	}
	public void setTaskinstanceId(long taskinstanceId) {
		this.taskinstanceId = taskinstanceId;
	}
	public int getIsinit() {
		return isinit;
	}
	public void setIsinit(int isinit) {
		this.isinit = isinit;
	}
	public String getGraphics() {
		return graphics;
	}
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrimaryInfo() {
		return primaryInfo;
	}
	public void setPrimaryInfo(String primaryInfo) {
		this.primaryInfo = primaryInfo;
	}
	public long getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getWfName() {
		return wfName;
	}
	public void setWfName(String wfName) {
		this.wfName = wfName;
	}
	
	public long getProcessIdByPara(){
		long processId  =0;
		try{
			
			String param = this.getPrimaryInfo();
			String[] str1 = StringUtils.split(param, "^");
			
			processId = Long.parseLong(str1[str1.length-1]);
			
		}catch(Exception ex){
			System.out.println("ex="+ex.getMessage());
		}
		return processId;
		
	}
	
	public static void main(String[] args){
		
		WFManagerForm theForm = new WFManagerForm();
		String str ="processDefinedId^string^345";
		
		
		
	}
	public long getNode_id() {
		return node_id;
	}
	public void setNode_id(long node_id) {
		this.node_id = node_id;
	}
	public long getProcessdefId() {
		return processdefId;
	}
	public void setProcessdefId(long processdefId) {
		this.processdefId = processdefId;
	}
	public FormFile getWf_cmsfile() {
		return wf_cmsfile;
	}
	public void setWf_cmsfile(FormFile wf_cmsfile) {
		this.wf_cmsfile = wf_cmsfile;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	
	
}
