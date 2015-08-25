package com.techstar.framework.demo.workflow.web.facade;

import java.util.List;
import java.util.Map;

import com.techstar.framework.demo.workflow.service.IDemoWorkflowService;

public class WorkflowFacade {

	private IDemoWorkflowService workflowService;

	public void setWorkflowService(IDemoWorkflowService workflowService) {
		this.workflowService = workflowService;
	}
	
	public  List findTransitionLog(long processInstance) {
		// TODO Auto-generated method stub
		return workflowService.findTransitionLog(processInstance);
	}

	public List findPooledTaskInstances(String actorId) {
		// TODO Auto-generated method stub
		return workflowService.findPooledTaskInstances(actorId);
	}

	public void start(String processDefinition) {
		// TODO Auto-generated method stub
		workflowService.start(processDefinition);
	}

	public void start(String processDefinition,String businessId){
		// TODO Auto-generated method stub
		workflowService.start(processDefinition,businessId);
	}
	
	public void suspend(long processInstance){
		// TODO Auto-generated method stub
		workflowService.suspend(processInstance);
	}	
	
	public void endTask(long taskInstance){
		// TODO Auto-generated method stub
		workflowService.endTask(taskInstance);
	}	
	
	public String retrieveByteArraysOfGpd(long taskInstanceId){
		return workflowService.retrieveByteArraysOfGpd(taskInstanceId);
	}
	
}
