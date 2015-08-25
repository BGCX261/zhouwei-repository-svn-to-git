package com.techstar.framework.service.workflow.manager;

import java.util.*;

import org.jbpm.graph.def.ProcessDefinition;
import org.springframework.dao.DataAccessException;

import com.techstar.framework.service.workflow.excep.WFManagerException;
import com.techstar.framework.service.workflow.bus.IWorkflowService;
import com.techstar.framework.service.workflow.bus.dto.TaskMessageDto;
import com.techstar.framework.service.workflow.bus.dto.TaskRoleDto;

/**
 * 此服务用于工作流管理服务
 * @author 杨军
 *
 */
public interface IWFManagerService{

	
	/**
	 * 用于得到当前工作流列表
	 * @return
	 * @throws WFManagerException
	 */
	public List getRunningWFList()throws WFManagerException;

	/**
	 * 此函数用于得到当前工作流所有节点
	 * @param wfName
	 * @return
	 * @throws WFManagerException
	 */
	public List getWFNodes(String wfName)throws WFManagerException;
	
	public List getTaskRoles(long process_id,long task_id)throws WFManagerException;
	public void saveOrUpdateJbpm_Promission(TaskRoleDto dto)throws WFManagerException;
    public String[] getCurrentActors(long process_id,long task_id)throws WFManagerException;
    public String[] getTask_roles(long task_id)throws WFManagerException;
    public void saveOrUpdateTaskMessage(TaskMessageDto dto)throws WFManagerException;
    public List getTaskMessages(long process_id,long task_id)throws WFManagerException;
    public String[] getCurrentUsers(long process_id,long task_id)throws WFManagerException;
    public List getWFNodes(long processId)throws WFManagerException;
    public ProcessDefinition getProcessDefinitionById(long processId)throws WFManagerException; 
    public String retrieveByteArraysOfProcess(String wfName)throws WFManagerException;
    public List getProcessInstancesByProcess(long wf_defid)throws WFManagerException;
    public List getProcessInstanceTasks(long instanceId)throws WFManagerException;
    public String getDtoNameByWfName(String wfName)throws WFManagerException;
    public List getInstanceLog(long instance_id)throws WFManagerException;
    public void saveOrUpdateWFDto(List dtos)throws WFManagerException;
    public void deleteWFDto(List dtos)throws WFManagerException;
    public String getTaskSvg(long task_instance_id)throws WFManagerException;
    public String retrieveByteArraysOfGpd(long taskInstanceId) throws DataAccessException;
    public void endProcess(long processId)throws DataAccessException;
    public ProcessDefinition getProcessDefinitionByProcessId(long processId);
    public String getTaskDefNameByTaskDefId(long processdef_id,long taskdef_id);
    public void updateJbpm(String agentcy,long taskdef_id,long processdef_id);
    public java.util.Collection getTaskMessages(long process_id, long task_id, int tasktype);
    public void updateMessage(long process_id, long task_id, int message_type,
			String content, String dtoname, String receive, int tasktype);
    public void setMessage(int message_id, long process_id, long task_id,
			int message_type, String content, String dtoname, String receive,
			int tasktype);
    public String[] getRoleByTaskDefId(long taskdef_id);
    public String[] getAgencyByTaskDefId(long taskdef_id);
    public java.util.Collection getMessagesByTaskNodeId(long tasknode_id);
    public java.util.Collection getMessagesByTaskDefId(long taskdef_id);
    public List getWFALLTask(String wfName);
    
}
