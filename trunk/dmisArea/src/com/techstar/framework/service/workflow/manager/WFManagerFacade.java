package com.techstar.framework.service.workflow.manager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jbpm.graph.def.ProcessDefinition;


import com.techstar.framework.service.workflow.excep.WFManagerException;
import com.techstar.framework.service.workflow.manager.IWFManagerService;
import com.techstar.framework.service.workflow.bus.IWorkflowService;
import com.techstar.framework.service.workflow.bus.dto.TaskRoleDto;
import com.techstar.framework.service.workflow.bus.dto.TaskMessageDto;
import com.techstar.framework.service.workflow.bus.dto.ProcessDefinedDto;
import com.techstar.framework.ui.utils.grid.parseIndividuation;
import com.techstar.framework.ui.web.tag.engine.ObjtoGridXmlHelper;
import com.techstar.framework.ui.web.tag.utils.TagXmlHelper;

public class WFManagerFacade {
	
	
	private IWFManagerService wfmanagerservice;
	private IWorkflowService wfcommonservice;
	
	public IWorkflowService getWfcommonservice() {
		return wfcommonservice;
	}
	public void setWfcommonservice(IWorkflowService wfcommonservice) {
		this.wfcommonservice = wfcommonservice;
	}
	public void setWfmanagerservice(IWFManagerService wfmanagerservice) {
		this.wfmanagerservice = wfmanagerservice;
	}
	/**
	 * 此函数用于得到系统中所有运行态工作流
	 * @return
	 */
	public List  getRunningWF(){
		List runningwf = new ArrayList();
		String wfListView ="";
		try {
			 runningwf = wfmanagerservice.getRunningWFList();
				    
		} catch (WFManagerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return runningwf;
	}
	
	/**
	 * 此函数用于得到当前工作流所有节点名称
	 * @param wfName 工作流名称
	 * @return
	 */
	public List getWFNodes(String _wfName){
		List wfNodes = new ArrayList();
		try {
			wfNodes =wfmanagerservice.getWFNodes(_wfName);
		} catch (WFManagerException e) {
			e.printStackTrace();
		}
		return wfNodes;
	}
	
	
	public List getWFNodes(long processId){
		List wfNodes = new ArrayList();
		try {
			wfNodes =wfmanagerservice.getWFNodes(processId);
		} catch (WFManagerException e) {
			e.printStackTrace();
		}
		return wfNodes;
	}
	
	
	public boolean startWF(String _wfName){
		boolean isok = false;
		try{
			wfcommonservice.start(_wfName);
			isok  =true;	
		}catch(Exception ex){
			System.out.println("start wf is exception "+ex.getMessage());
		}
		return isok;
	}
	
	public List getTaskByActorId(String actorId){
		List tasks = wfcommonservice.findPooledTaskInstances(actorId);
	 return tasks;	
	}
	
	public boolean finishTaskById(long taskId){
		boolean isok =false;
		try{
		wfcommonservice.endTask(taskId,null,null);
		isok = true;
		}catch(Exception ex){
			System.out.println("ex is "+ex.getMessage());
		}
		 return isok;	
	}
	
	public List getTaskRoles(long process_id,long task_id){
		List taskroles = new ArrayList();
		try{
			taskroles = wfmanagerservice.getTaskRoles(process_id, task_id);
		}catch(Exception ex){
			System.out.println("start wf is exception "+ex.getMessage());
		}
		return taskroles;
		
	}
/**
 * 用于加入任务对应的权限
 * @param dto
 */
	public void addTaskRoleDto(TaskRoleDto dto) {
		try {
			wfmanagerservice.saveOrUpdateJbpm_Promission(dto);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用于更新改任务对应的权限
	 * @param dto
	 */
	public void updateTaskRoleDto(TaskRoleDto dto) {
		try {
			wfmanagerservice.saveOrUpdateJbpm_Promission(dto);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用于得到当前工作流及任务对应的角色
	 * @param process_id
	 * @param task_id
	 * @return
	 */
	public String[] getCurrentWFActors(long process_id,long task_id){
		String[] actors = null;
		try{
			actors = wfmanagerservice.getCurrentActors(process_id, task_id);
		}catch(Exception ex){
			System.out.println("start wf is exception "+ex.getMessage());
		}
		return actors;
	}
	
	public String[] getTask_roles(long task_id){
		String[] actors = new String[100];
		try{
			//System.out.println("actors start******");
			actors = wfmanagerservice.getTask_roles(task_id);
			//System.out.println("actors end******"+actors.length);
		}catch(Exception ex){
			System.out.println("start wf is exception "+ex.getMessage());
		}
		return actors;
	}
	
	/**
	 * 用于得到当前工作流任务节点对应的消息配置
	 * @param process_id
	 * @param task_id
	 * @return
	 */
	public List getTaskMessages(long process_id,long task_id){
		List messages = new ArrayList();
		try{
			messages = wfmanagerservice.getTaskMessages(process_id, task_id);
		}catch(Exception ex){
			System.out.println("start wf is exception "+ex.getMessage());
		}
		return messages;
		
	}
/**
 * 用于加入任务对应的消息配置
 * @param dto
 */
	public void addTaskMessageDto(TaskMessageDto dto) {
		try {
			wfmanagerservice.saveOrUpdateTaskMessage(dto);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用于更新任务对应的消息配置
	 * @param dto
	 */
	public void updateTaskMessageDto(TaskMessageDto dto) {
		try {
			wfmanagerservice.saveOrUpdateTaskMessage(dto);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用于得到当前工作流名称
	 * @param processId
	 * @return
	 */
	public String getWFNameByDefId(long defId){
		String wf_name ="";
		try {
			wf_name= wfmanagerservice.getProcessDefinitionById(defId).getName();
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wf_name;
	}
	
	
	public String getWFNameByProcessId(long defId){
		String wf_name ="";
		try {
			wf_name= wfmanagerservice.getProcessDefinitionById(defId).getName();
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wf_name;
	}
	
	/**
	 * 通过流程id得到工作流图形
	 * @param processId
	 * @return
	 */
	public String getWfGraphicByProcess (long processId){
		
		String svg="";
		//System.out.println("processId="+processId);
		try{
			//String wf_name = getWFNameByProcessId(processId);
			ProcessDefinition p = wfmanagerservice.getProcessDefinitionByProcessId(processId);
			//System.out.println("p.getName()="+p.getName());
			svg = wfmanagerservice.retrieveByteArraysOfProcess(p.getName());
		}catch(Exception ex){
			System.out.println("ex=="+ex.getMessage());
		}
		return svg;
		
	}
	
	
	//
	
	
//	
	/**
	 * 用于得到工作流图形
	 * @param processId
	 * @return
	 */
	public String getWfGraphic (long defId){
		String wf_name = getWFNameByDefId(defId);
		String svg_wf="";
		try {
			 svg_wf = wfmanagerservice.retrieveByteArraysOfProcess(wf_name);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return svg_wf;
	}
	
	/**
	 * 用于得到当前工作流的实例
	 * @param wf_defId
	 * @return
	 */
	public List getProcessInstancesByProcess(long wf_defId){
		 
		List processInstance = new ArrayList();
		try {
			processInstance = wfmanagerservice.getProcessInstancesByProcess(wf_defId);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return processInstance;
	}

    /**
     * 用于得到当前工作流实例对应的任务列表
     * @param instanceId
     * @return
     */
	public List getProcessInstanceTasks(long instanceId){
		 
		List taskInstances = new ArrayList();
		try {
			taskInstances = wfmanagerservice.getProcessInstanceTasks(instanceId);
		} catch (WFManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskInstances;
	}
	
	/**
	 * 
	 * @param wfName
	 * @return
	 */
	 public String getDtoNameByWfName(String wfName){
		 String dtoName ="";
		 try{
			 dtoName= wfmanagerservice.getDtoNameByWfName(wfName);
		 }catch(Exception ex){
			 System.out.println("系统得到工作流对应的DTO名称发生异常"+ex.getMessage());
		 }
		 return dtoName;
	 }
	 
	 public String getDtoNameByWfId(String processdefId){
		 String dtoName ="";
		 try{
			 String wfName = getWFNameByProcessId(Long.parseLong(processdefId));
			 dtoName= wfmanagerservice.getDtoNameByWfName(wfName);
		 }catch(Exception ex){
			 System.out.println("系统得到工作流对应的DTO名称发生异常"+ex.getMessage());
		 }
		 return dtoName;
	 }
	 
	 /**
	  * 用于得到日至发生异常
	  * @param processId
	  * @return
	  */
	 public List getLogsByProcessId(long processId){
		 List logs = new ArrayList();
			try {
				logs= wfmanagerservice.getInstanceLog(processId);
			} catch (WFManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return logs;
		}
	 
	 /**
	  * 用于得到当前工作流的列表
	  * @param processId
	  * @return
	  */
	 public List getTasksByProcessId(long processId){
		 List tasks = new ArrayList();
		 try{
			 tasks = wfmanagerservice.getProcessInstanceTasks(processId);
			 
		 }catch(Exception ex){
			 System.out.println("用于得到当前工作流运行的任务发生异常"+ex.getMessage());
		 } 
		 return tasks;
		 
	 }
	 
	 /**
	  * 设置工作流dto
	  * @param dtos
	  */
	 public void setWFDto (List dtos){
		try{
			wfmanagerservice.saveOrUpdateWFDto(dtos); 
		 }catch(Exception ex){
			 System.out.println("ex=="+ex.getMessage());
		 }
	 }
	 
	 /**
	  * 用于删除数据库中工作流对应的dto
	  * @param dtos
	  */
	 public void deleteWFDto (List dtos){
			try{
				wfmanagerservice.deleteWFDto(dtos); 
			 }catch(Exception ex){
				 System.out.println("ex=="+ex.getMessage());
			 }
		 }
	/**
	 * 得到当前任务的svg图形
	 * @param task_instanceId
	 * @return
	 */
	public String getTaskSvg(long task_instanceId){
		String str="";
		try{
			str  = wfmanagerservice.retrieveByteArraysOfGpd(task_instanceId);
			//System.out.println("str==="+str);
		 }catch(Exception ex){
			 System.out.println("ex=="+ex.getMessage());
		 }
		 
		 return str;
		
	}
	/**
	 * 系统用于结束指定工作实例
	 * @param processId
	 */
	public void endProcess(long processId){
		try{
		wfmanagerservice.endProcess(processId);
		}catch(Exception ex){
			System.out.println("系统结束指定工作流信息发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public String getTaskDefNameByTaskDefId(long processdef_id,long taskdef_id){
		return wfmanagerservice.getTaskDefNameByTaskDefId(processdef_id, taskdef_id);
	}
	
	public void updateJbpm(String agentcy,long taskdef_id,long processdef_id){
		wfmanagerservice.updateJbpm(agentcy, taskdef_id, processdef_id);
	}
	
	public java.util.Collection getTaskMessages(long process_id, long task_id, int tasktype) {
		return wfmanagerservice.getTaskMessages(process_id, task_id, tasktype);
	}

	public void updateMessage(long process_id, long task_id, int message_type,
			String content, String dtoname, String receive, int tasktype) {
		wfmanagerservice.updateMessage(process_id, task_id, message_type,
				content, dtoname, receive, tasktype);
	}

	public void setMessage(int message_id, long process_id, long task_id,
			int message_type, String content, String dtoname, String receive,
			int tasktype) {
		wfmanagerservice.setMessage(message_id, process_id, task_id,
				message_type, content, dtoname, receive, tasktype);
	}
	
	 public List getWFALLTask(String wfName){
		 return wfmanagerservice.getWFALLTask(wfName);
	 }
   
}
