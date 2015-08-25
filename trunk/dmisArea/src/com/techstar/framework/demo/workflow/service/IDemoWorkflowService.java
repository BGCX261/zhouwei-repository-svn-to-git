package com.techstar.framework.demo.workflow.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface IDemoWorkflowService {

	 void start(String processDefinition) throws DataAccessException;
	 void start(String processDefinition,String businessId) throws DataAccessException;
	 void suspend(long processInstance) throws DataAccessException;
	 void endTask(long taskInstance) throws DataAccessException;
	 List findPooledTaskInstances(String actorId) throws DataAccessException;
	 List findTransitionLog(long processInstance) throws DataAccessException;
	 String retrieveByteArraysOfGpd(long taskInstanceId);
}
