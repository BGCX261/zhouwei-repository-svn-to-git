package com.techstar.dmis.service;

import java.util.List;

import com.techstar.dmis.entity.HandleHistory;
import com.techstar.framework.dao.model.QueryListObj;

public interface ITodolistService {
	//工作流待办
	public List getWorkflowTodolist(String objName,String actorId) ;
	//流转图
	public String retrieveByteArraysOfGpd(long taskInstanceId);
	//获取流转处理历史
	public QueryListObj listHandleHistorys(String businessId);
	//保存处理历史
	public void saveOrUpdate(HandleHistory handleHistory) ;
}
