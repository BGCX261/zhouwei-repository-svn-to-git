package com.techstar.dmis.web.facade;

import java.util.List;

import com.techstar.dmis.entity.HandleHistory;
import com.techstar.dmis.service.ITodolistService;
import com.techstar.framework.dao.model.QueryListObj;

public class TodolistFacade {

	ITodolistService todolistService ;
	public void setTodolistService(ITodolistService todolistService) {
		this.todolistService = todolistService;
	}
	
	public List getWorkflowTodolist(String objName,String actorId) {
		return this.todolistService.getWorkflowTodolist(objName,actorId);
	} 
	
	public String retrieveByteArraysOfGpd(long taskInstanceId){
		return todolistService.retrieveByteArraysOfGpd(taskInstanceId);
	}
	
	public void saveOrUpdate(HandleHistory handleHistory){
		todolistService.saveOrUpdate(handleHistory);
	}
	
	public QueryListObj listHandleHistorys(String businessId) {
		return todolistService.listHandleHistorys(businessId);
	}
}
