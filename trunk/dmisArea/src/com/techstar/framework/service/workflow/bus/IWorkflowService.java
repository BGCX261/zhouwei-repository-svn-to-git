package com.techstar.framework.service.workflow.bus;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface IWorkflowService {

	 void start(String processDefinition) throws DataAccessException;
	 void start(String processDefinition,String businessId,String preUserId,String[] curUserIds) throws DataAccessException;
	 void suspend(long processInstance) throws DataAccessException;
	 void end(long processInstance) throws DataAccessException;
	 void endTask(long taskInstance,String preUserId,String[] curUserIds) throws DataAccessException;
	 void endTask(long taskInstance,String transition,String preUserId,String[] curUserIds) throws DataAccessException;
	 List findPooledTaskInstances(String actorId) throws DataAccessException;
	 List findTransitionLogs(long taskInstanceId) throws DataAccessException;
	 String retrieveByteArraysOfGpd(long taskInstanceId) throws DataAccessException;
	 String isOverForCountersign( long taskInstanceId, String roleId, int isApprove)throws DataAccessException;
	 void endWaitingByProcessInstance(final long processInstanceId) throws DataAccessException ;
	 void endWaitingByTaskInstance(final long taskInstanceId) throws DataAccessException ;	 
}
