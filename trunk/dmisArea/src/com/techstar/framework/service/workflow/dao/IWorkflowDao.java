package com.techstar.framework.service.workflow.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.springframework.dao.DataAccessException;

public interface IWorkflowDao {

	void start(String processDefinition) throws DataAccessException;

	void start(String processDefinition, String businessId, String preUserId,
			String[] curUserIds) throws DataAccessException;

	void suspend(long processInstance) throws DataAccessException;

	void end(long processInstance) throws DataAccessException;

	void endTask(long taskInstanceId, String preUserId, String[] curUserIds)
			throws DataAccessException;

	void endTask(long taskInstanceId, String transitionName, String preUserId,
			String[] curUserIds) throws DataAccessException;

	List findPooledTaskInstances(String actorId) throws DataAccessException;

	List findTaskInstances(String actorId) throws DataAccessException;

	List findTransitionLogs(long taskInstanceId) throws DataAccessException;

	String isOverForCountersign(long taskInstanceId, String roleId,
			int isApprove) throws DataAccessException;

	String retrieveByteArraysOfGpd(long taskInstanceId)
			throws DataAccessException;

	List getRunningWF() throws DataAccessException;

	public List getProcessNodes(String wfName) throws DataAccessException;

	public ProcessDefinition getProcessDefinitionById(long processId)
			throws DataAccessException;

	public List getProcessNodes(long processId) throws DataAccessException;

	public List getTaskRoles(long process_id, long task_id)
			throws DataAccessException;

	public List getTaskRoles(long task_id) throws DataAccessException;

	public List getTaskMessages(long process_id, long task_id)
			throws DataAccessException;

	public void saveOrUpdateJbpm_Promission(Jbpm_Promission jbmp_promission)
			throws DataAccessException;

	public void saveOrUpdateJbpm_Message(Jbpm_Message jbmp_message)
			throws DataAccessException;

	public Jbpm_Promission findByPk(Object pk) throws DataAccessException;

	String oneTicketNoForCountersign(long taskInstanceId, String roleId,
			int isApprove) throws DataAccessException;

	void endWaitingByProcessInstance(final long processInstanceId)
			throws DataAccessException;

	void endWaitingByTaskInstance(final long taskInstanceId)
			throws DataAccessException;

	public String retrieveByteArraysOfProcess(String processDef)
			throws DataAccessException;

	public Node getProcessStartNode(long processId) throws DataAccessException;

	public List getProcessInstancesByProcess(long wf_defId)
			throws DataAccessException;

	public List getProcessInstanceTasks(long instanceId)
			throws DataAccessException;

	public String getWFDtoName(String wfName) throws DataAccessException;

	public ProcessInstance findProcessInstance(long processInstanceId)
			throws DataAccessException;

	public void setWFDto(Collection entities) throws DataAccessException;

	public void delWFDto(Collection entities) throws DataAccessException;

	public ProcessDefinition getProcessDefinitionByProcessId(long processId)
			throws DataAccessException;

	public void updateJbpm(String agentcy, long task_id, long process_id)
			throws DataAccessException;

	public List getTaskMessages(long process_id, long task_id, int tasktype)
			throws DataAccessException;

	public void updateMessage(long process_id, long task_id, int message_type,
			String content, String dtoname, String receive, int tasktype)
			throws DataAccessException;

	public void setMessage(int message_id, long process_id, long task_id,
			int message_type, String content, String dtoname, String receive,
			int tasktype) throws DataAccessException;

	public List getTaskMessages(long task_id, int tasktype)
			throws DataAccessException;

	public List getWFALLTask(String wfName) throws DataAccessException;
	// public void saveOrUpdateEntity(List entitys,String pack,String
	// entityName,String qName,String alias,int sign)throws DataAccessException;
}
