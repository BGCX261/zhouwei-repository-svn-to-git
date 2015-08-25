package com.techstar.framework.service.workflow.manager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.apache.commons.collections.set.ListOrderedSet;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.node.Decision;
import org.jbpm.graph.node.Join;
import org.jbpm.graph.node.TaskNode;
import org.jbpm.graph.node.Fork;
import org.jbpm.graph.node.State;
import org.jbpm.graph.node.StartState;
import org.jbpm.graph.node.EndState;
import org.jbpm.graph.node.NodeTypes;
import org.jbpm.logging.log.ProcessHisLog;
import org.jbpm.logging.log.ProcessLog;
import org.jbpm.graph.exe.ProcessInstance;


import org.jbpm.taskmgmt.def.Task;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.dao.DataAccessException;
import org.springmodules.workflow.jbpm31.ProcessTask;
import org.xml.sax.InputSource;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryDetailPair;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import com.techstar.framework.service.workflow.excep.WFManagerException;
import com.techstar.framework.service.workflow.bus.dto.ProcessDefinedDto;
import com.techstar.framework.service.workflow.bus.dto.TaskDto;
import com.techstar.framework.service.workflow.bus.dto.JbpmCmsDto;
import com.techstar.framework.service.workflow.bus.dto.TaskRoleDto;
import com.techstar.framework.service.workflow.bus.dto.NodeDto;
import com.techstar.framework.service.workflow.bus.dto.TaskInstanceDto;
import com.techstar.framework.service.workflow.bus.dto.ProcessInstanceDto;
import com.techstar.framework.service.workflow.bus.dto.TaskMessageDto;
import com.techstar.framework.service.workflow.dao.Jbpm_Promission;
import com.techstar.framework.service.workflow.dao.Jbpm_Message;
import com.techstar.framework.service.workflow.dao.Jbpm_Cms;
import com.techstar.framework.service.workflow.bus.WorkflowService;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import org.jbpm.taskmgmt.def.Task;



/**
 * 工作流管理类
 * @author yangj
 * @date   2007-02-24
 */



public class WFManagerServiceImpl implements IWFManagerService{
	
	private IWorkflowDao workFlowDao;
	private Map logCache = new HashMap();
	
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
	/**
	 * ϵͳ用于得到所有工作流列表
	 */
	public List getRunningWFList()throws WFManagerException{
		List workflows = new ArrayList();
		try{
			List wflows = workFlowDao.getRunningWF();
			for (int i=0;i<wflows.size();i++){
				
				ProcessDefinition processDefined = (ProcessDefinition)wflows.get(i);
				ProcessDefinedDto dto = new ProcessDefinedDto();
				dto.setProcessDefinedId(String.valueOf(processDefined.getId()));
				dto.setProcessDefinedName(processDefined.getName());
				
				workflows.add(dto);
			}
			
		}catch(Exception ex){
			System.out.println("得到工作流列表发生异常"+ex.getMessage());
		}
		return workflows;
		
	}
	
	public List getAllWFList() throws WFManagerException{
        List workflows = new ArrayList();
		
		return workflows;
		
	}
	/**
	 * 此函数用于得到当前工作流所有节点
	 * @param wfName　　　　　　　　当前工作流名称
	 * @return
	 * @throws WFManagerException
	 */
	public List getWFNodes(String wfName)throws WFManagerException{
		List nodes = new ArrayList();
		try{
			List nodelist = workFlowDao.getProcessNodes(wfName);
			for (int i=0;i<nodelist.size();i++){
				NodeDto nodeDto = new NodeDto();
				Node node = (Node)nodelist.get(i);
				nodeDto.setNode_name(node.getName());
				nodeDto.setNodeId(node.getId());
			
				
				if(node instanceof TaskNode){
					nodeDto.setNodeType(NodeDto.NODE_TASKNODE);
				}else if(node instanceof Decision){
					nodeDto.setNodeType(NodeDto.NODE_DECISION);
				}else if(node instanceof Join){
					nodeDto.setNodeType(NodeDto.NODE_JOIN);
				}else if(node instanceof Fork){
					nodeDto.setNodeType(NodeDto.NODE_FORK);
				}else if(node instanceof State){
					nodeDto.setNodeType(NodeDto.NODE_STATE);
				}else if(node instanceof StartState){
					nodeDto.setNodeType(NodeDto.NODE_STARTSTATE);
				}else if(node instanceof EndState){
					nodeDto.setNodeType(NodeDto.NODE_ENDSTATE);
				}else{
					nodeDto.setNodeType(NodeDto.NODE_SELF);
				}
				nodes.add(nodeDto);
		    }
			
		}catch(Exception ex){
		 System.out.println("得到工作流列表发生异常"+ex.getMessage());
		}
		return nodes;
	}
	
	/**
	 * 用于得到当前工作流所有节点
	 * @param processId
	 * @return
	 * @throws WFManagerException
	 */
	public List getWFNodes(long processId)throws WFManagerException{
		List nodes = new ArrayList();
		Map cache = new HashMap();
		try{
			
		
		if(cache.containsKey(String.valueOf(processId))==false){
			
			List nodelist = workFlowDao.getProcessNodes(processId);
			Node startNode = workFlowDao.getProcessStartNode(processId);
			
			for (int i=0;i<nodelist.size();i++){
				NodeDto nodeDto = new NodeDto();
				Node node = (Node)nodelist.get(i);
				nodeDto.setNode_name(node.getName());
				nodeDto.setNodeId(node.getId());
				
               
				if(node instanceof TaskNode){
					nodeDto.setNodeType(NodeDto.NODE_TASKNODE);
					TaskNode tasknode = (TaskNode)node;
					Set tasks = tasknode.getTasks();
					ListOrderedSet listSet =  ListOrderedSet.decorate(tasks);
					List l = listSet.asList();
					List ls = new ArrayList();
					
					for (int j=0;j<l.size();j++){
						TaskDto taskDto = new TaskDto();
						Task task = (Task)l.get(j);
						taskDto.setTaskId(String.valueOf(task.getId()));
						taskDto.setTaskName(task.getName());
						taskDto.setActorId(task.getActorIdExpression());
						taskDto.setCreateDate(task.getDueDate());
						ls.add(taskDto);
					
					}
					nodeDto.setTasks(ls);
				}else if(node instanceof Decision){
					nodeDto.setNodeType(NodeDto.NODE_DECISION);
				}else if(node instanceof Join){
					nodeDto.setNodeType(NodeDto.NODE_JOIN);
				}else if(node instanceof Fork){
					nodeDto.setNodeType(NodeDto.NODE_FORK);
				}else if(node instanceof State){
					nodeDto.setNodeType(NodeDto.NODE_STATE);
					
				}else if(node instanceof StartState){
					nodeDto.setNodeType(NodeDto.NODE_STARTSTATE);
				}else if(node instanceof EndState){
					nodeDto.setNodeType(NodeDto.NODE_ENDSTATE);
				}else{
					if (node.getName().equalsIgnoreCase(startNode.getName())){
						nodeDto.setNodeType(NodeDto.NODE_STARTSTATE);
					}else{
					nodeDto.setNodeType(NodeDto.NODE_SELF);
					}
				}
				nodes.add(nodeDto);
		    }
			    cache.put(String.valueOf(processId), nodes);
		}else{
			 return (List)cache.get(String.valueOf(processId));
		}
			
			
		}catch(Exception ex){
		 System.out.println("得到工作流列表发生异常"+ex.getMessage());
		}
		return nodes;
	}
	
    /**
     * 系统用于得到当前工作流当前任务的角色列表
     * @param process_id
     * @param task_id
     * @return
     */
	public List getTaskRoles(long process_id,long task_id){
		List roles = new ArrayList();
		try{
			List taskroles = workFlowDao.getTaskRoles(process_id, task_id);
		
			for (int i=0;i<taskroles.size();i++){
				TaskRoleDto dto = new TaskRoleDto();
				Jbpm_Promission jbpm_pro=(Jbpm_Promission)taskroles.get(i);
				dto.setAgency_role(jbpm_pro.getAgency_role());
				dto.setTask_role(jbpm_pro.getTask_role());
				dto.setNeccesory(jbpm_pro.getNeccesory());
				dto.setProcess_id(jbpm_pro.getProcess_id());
				dto.setTask_id(jbpm_pro.getTask_id());
				dto.setTask_name(jbpm_pro.getTask_name());
				dto.setPremission_id(jbpm_pro.getPremission_id());
				roles.add(dto);
				
			}
			
		}catch(Exception ex){
		 System.out.println("get wkflow"+ex.getMessage());
		 ex.printStackTrace();
		}
		return roles;
	}
	
	
	
	public List getTaskRoles(long task_id){
		List roles = new ArrayList();
		try{
			List taskroles = workFlowDao.getTaskRoles(task_id);
		
			for (int i=0;i<taskroles.size();i++){
				TaskRoleDto dto = new TaskRoleDto();
				Jbpm_Promission jbpm_pro=(Jbpm_Promission)taskroles.get(i);
				dto.setAgency_role(jbpm_pro.getAgency_role());
				dto.setTask_role(jbpm_pro.getTask_role());
				dto.setNeccesory(jbpm_pro.getNeccesory());
				dto.setProcess_id(jbpm_pro.getProcess_id());
				dto.setTask_id(jbpm_pro.getTask_id());
				dto.setTask_name(jbpm_pro.getTask_name());
				dto.setPremission_id(jbpm_pro.getPremission_id());
				roles.add(dto);
				
			}
			
		}catch(Exception ex){
		 System.out.println("get wkflow"+ex.getMessage());
		 ex.printStackTrace();
		}
		return roles;
	}
	
	/**
	 * 用于更新工作流权限数据
	 * @param dto
	 */
	public void saveOrUpdateJbpm_Promission(TaskRoleDto dto) {
		if (StringUtils.isEmpty(String.valueOf(dto.getPremission_id()))){
		      if( StringUtils.isEmpty(String.valueOf(dto.getPremission_id()))){
		          dto.setPremission_id(Long.parseLong(new SequenceCreator().getUID()));
		       }
		}
		Jbpm_Promission jbpm_Promission = (Jbpm_Promission) BeanHelper.buildBean(
				Jbpm_Promission.class, dto);
		workFlowDao.saveOrUpdateJbpm_Promission(jbpm_Promission);
	}
	
	
	public TaskRoleDto loadJbpm_Promission(String id) {
		Jbpm_Promission jbpm_promission = (Jbpm_Promission) workFlowDao.findByPk(id);
//		TaskRoleDto dto = (TaskRoleDto) BeanHelper.buildBean(
//				Day_ScheduleDto.class, jbpm_promission);
		//return dto;
		return null;
	}
	
	/**
	 * 得到当前任务对应的所有角色名称
	 * @param task_id
	 * @return
	 */
	public String[] getTask_roles(long task_id){
		String [] actors = null;
		List roles  =getTaskRoles(task_id);
	   if (roles.size()>0){
		TaskRoleDto dto = (TaskRoleDto)roles.get(0);
		 actors = dto.getTask_roles();
	  }
		return actors;
	}
	
	/**
	 * 用于得到当前任务所有对应的ACTORS
	 * @param process_id
	 * @param task_id
	 * @return
	 */
	public String[] getCurrentActors(long process_id,long task_id){
		String [] actors = null;
		List roles  =getTaskRoles(process_id,task_id);
		
	  if (roles.size()>0){
		TaskRoleDto dto = (TaskRoleDto)roles.get(0);
		if (StringUtils.isNotEmpty(dto.getAgency_role())){
			actors = dto.getAgency_roles();
		}else{
			actors = dto.getTask_roles();
		}
	  }
		
		return actors;
	}
	
	/**
	 * 用于得到当前工作流当前任务所有用户
	 * @param process_id
	 * @param task_id
	 * @return
	 */
	public String[] getCurrentUsers(long process_id,long task_id){
		String[] users = null;
		users = new String[]{"tester","tester2"};
		return users;
	}
	
	/**
	 * 用于得到当前工作流的消息节点配置
	 * @param process_id
	 * @param task_id
	 * @return
	 */
	public List getTaskMessages(long process_id,long task_id){
		List messages = new ArrayList();
		try{
			List taskmessages = workFlowDao.getTaskMessages(process_id, task_id);
		
			for (int i=0;i<taskmessages.size();i++){
				TaskMessageDto dto = new TaskMessageDto();
				Jbpm_Message jbpm_message=(Jbpm_Message)taskmessages.get(i);
				
				dto.setMessage_id(jbpm_message.getMessage_id());
				dto.setMessage_from_name(jbpm_message.getMessage_from_name());
				dto.setMessage_from_queue(jbpm_message.getMessage_from_queue());
				dto.setMessage_to_name(jbpm_message.getMessage_to_name());
				dto.setMessage_to_queue(jbpm_message.getMessage_to_queue());
				dto.setProcess_id(jbpm_message.getProcess_id());
				dto.setTask_id(jbpm_message.getTask_id());
				messages.add(dto);
			}
			
		}catch(Exception ex){
		 System.out.println("get wkflow"+ex.getMessage());
		 ex.printStackTrace();
		}
		return messages;
	}
	/**
	 * 用于更新工作流消息节点配置
	 * @param dto
	 */
	public void saveOrUpdateTaskMessage(TaskMessageDto dto) {
		if (StringUtils.isEmpty(String.valueOf(dto.getMessage_id()))){
		      if( StringUtils.isEmpty(String.valueOf(dto.getMessage_id()))){
		          dto.setMessage_id(Long.parseLong(new SequenceCreator().getUID()));
		       }
		}
		Jbpm_Message jbpm_message = (Jbpm_Message) BeanHelper.buildBean(
				Jbpm_Message.class, dto);
		workFlowDao.saveOrUpdateJbpm_Message(jbpm_message);
	}
	
	/**
	 * 用于得到工作流定义
	 */
	public ProcessDefinition getProcessDefinitionById(long processId){
		// System.out.println("p get name by processId is"+processId);
		 ProcessDefinition p =workFlowDao.getProcessDefinitionById(processId);
		// System.out.println("p get name is"+p.getName());
		 return p;
	}
	
	public ProcessDefinition getProcessDefinitionByProcessId(long processId){
		 //System.out.println("p get name by processId is"+processId);
		 ProcessDefinition p =workFlowDao.getProcessDefinitionByProcessId(processId);
		 //System.out.println("p get name is"+p.getName());
		 return p;
	}
	
	
	
	/**
	 * 用于得到工作流图形
	 * @param wfName
	 * @return
	 */
	public String retrieveByteArraysOfProcess(String wfName){
		return workFlowDao.retrieveByteArraysOfProcess(wfName);
	}
	/**
	 * 用于得到定义工作流实例
	 * @param wf_def_id
	 * @return
	 */
	public List getProcessInstancesByProcess(long wf_defid){
		List instances = new ArrayList();
		
		
		List processInstances = workFlowDao.getProcessInstancesByProcess(wf_defid);
		
		try{
		for (int i=0;i<processInstances.size();i++){
			ProcessInstance instance = (ProcessInstance)processInstances.get(i);
			
			String tasknode_str = getTaskStrByInstance(instance);
			
			//List tasks = workFlowDao.getProcessInstanceTasks(instance.getId());
			ProcessInstanceDto dto = new ProcessInstanceDto();
			
			dto.setStart_date(instance.getStart());
			dto.setEnd_date(instance.getEnd());
			dto.setId(instance.getId());
			dto.setVersion(instance.getVersion());
			dto.setIsEnd(instance.hasEnded());
			dto.setIsSuspend(instance.isSuspended());
			//List logdtos = getInstanceLog(instance);
			dto.setTask_actor(tasknode_str);
			//dto.setLogs(logdtos);
			
			instances.add(dto);
			
		}
		
		}catch(Exception ex){
			System.out.println("exex"+ex.getMessage());
		}
		 return instances;
	}
	
	
	/**
	 * 用于得到该工作流实例对应的任务节点
	 * @param instanceId
	 * @return
	 */
	public String getTaskStrByInstance(ProcessInstance instance){
		String str="";
		try{
		
		List taskInstances = workFlowDao.getProcessInstanceTasks(instance.getId());	
		for (int j=0;j<taskInstances.size();j++){
				TaskInstance taskInstance =
					(TaskInstance) taskInstances.get(j);
				
				long processdef_id = instance.getProcessDefinition().getId();
				String tasknode_name = taskInstance.getToken().getNode().getName();
				long task_id = taskInstance.getTask().getTaskNode().getId();
				String[] actors = getCurrentActors(processdef_id,task_id);
				String actor="";
				
		if(actors!=null){
				for (int i =0;i<actors.length;i++){
					if(i==actors.length-1){
					    actor = actor+actors[i];
					}else{
						actor = actor+actors[i]+"#";   
					}
				}
			}
			//System.out.println("actor=="+actor);
	   if((j==taskInstances.size()-1)&&StringUtils.isNotEmpty(actor)){
				str = str +tasknode_name+"("+actor+")";
		 }else{
				str = str +tasknode_name+"("+actor+")@";
			 }
		}
			
		}catch(Exception ex){
			System.out.println("系统得到工作流实例的任务字符串发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return str;
		
	}
	
	
	/**
	 * 用于得到当前实例的log
	 * @param instance
	 * @return
	 */
	public List getInstanceLog(ProcessInstance instance){
		List returnlist = new ArrayList();
		if(logCache.containsKey(instance)){
			return (List)logCache.get(instance);
		}else{
		List logs = instance.getLoggingInstance().getLogs();
        for (int j=0;j<logs.size();j++){
			String str ="";
			ProcessLog processLog = (ProcessLog)logs.get(j);
			str = str+processLog.getActorId()+":"
			         +processLog.getDate();
			returnlist.add(str);    
			logCache.put(instance, returnlist);
		}
	 }
		return returnlist;
	}
	
	/**
	 * 用于得到log
	 * @param instance_id
	 * @return
	 */
	public List getInstanceLog(long instance_id){
		ProcessInstance processInstance
		= workFlowDao.findProcessInstance(instance_id);
		return getInstanceLog(processInstance);
		
	}
	
/**
 * 系统得到任务实例列表
 * @param instanceId
 * @return
 */
	public List getProcessInstanceTasks(long instanceId){
		
		List tasks = new ArrayList();
		try{
			
		 List taskInstances = workFlowDao.getProcessInstanceTasks(instanceId);
			
		   for (int i = 0; i < taskInstances.size(); i++) {
				TaskInstance taskInstance =
					(TaskInstance) taskInstances.get(i);
				TaskInstanceDto dto = new TaskInstanceDto();
				
				dto.setActionId(taskInstance.getActorId());
				
				dto.setCreate(taskInstance.getCreate());
				dto.setDescription(taskInstance.getDescription());
				dto.setDueDate(taskInstance.getDueDate());
				dto.setHasEnded(taskInstance.hasEnded());
				dto.setId(taskInstance.getId());
				dto.setName(taskInstance.getName());
				dto.setNode_name(taskInstance.getTask().getTaskNode().getName());
				tasks.add(dto);
			}
			
			
		}catch(Exception ex){
			System.out.println("系统得到任务"+ex.getMessage());
		}
		return tasks;
	}
	
	
	   public void saveOrUpdateWFDto(List dtos){ 
		   List pos = new ArrayList();
		   for(int i=0;i<dtos.size();i++){
					JbpmCmsDto jbpmcmsdto = (JbpmCmsDto)dtos.get(i);
					Jbpm_Cms jbpmcms = (Jbpm_Cms) BeanHelper.buildBean(Jbpm_Cms.class, jbpmcmsdto);
				    pos.add(jbpmcms);
				}
				workFlowDao.setWFDto(pos);
				
				//List entitys,String pack,String entityName,String qName,String alias,int sign
//				 saveOrUpdateEntity(pos,
//						"com.techstar.framework.service.workflow.dao",
//						"Jbpm_Cms","process_name","jbpm_cms",WFManagerHelper.MERGE_DELETE);
		   
		   }
	   
	   
	   public void deleteWFDto(List dtos){
		   List pos = new ArrayList();
		   
		   for(int i=0;i<dtos.size();i++){
					JbpmCmsDto jbpmcmsdto = (JbpmCmsDto)dtos.get(i);
					Jbpm_Cms jbpmcms = (Jbpm_Cms) BeanHelper.buildBean(Jbpm_Cms.class, jbpmcmsdto);
				    pos.add(jbpmcms);
				}
				workFlowDao.delWFDto(pos);
	   }
	   
	/**
	 * 用于得到当前工作流对应的业务对象DTO名称
	 * @param wfName
	 * @return
	 */
	public String getDtoNameByWfName(String wfName){
		String  dtoName ="";
		try{
			dtoName= workFlowDao.getWFDtoName(wfName);
		}catch(Exception ex){
			System.out.println();
		}
		return dtoName;
	}
	
	
	public String getTaskSvg(long task_instance_id){
		
		String str="";
		
		try{
			str = workFlowDao.retrieveByteArraysOfGpd(task_instance_id);
		}catch(Exception ex){
			System.out.println("得到当前任务实例svg图形"+ex.getMessage());
		}
		System.out.println("str==="+str);
		return str;
		
	}
	
	
	public String retrieveByteArraysOfGpd(long taskInstanceId) throws DataAccessException {
	       String xml = "";
	       try {
	           List logs = this.workFlowDao.findTransitionLogs(taskInstanceId);
	           List nodelist = new ArrayList();
	           if(logs.size()>0){
	           for (int i = 0; i < logs.size(); i++) {
	              ProcessHisLog log = (ProcessHisLog) logs.get(i);
	              //System.out.println("log.getName()===="+log.getName());
	              if(!nodelist.contains(log.getName()))
	                  nodelist.add(log.getName());
	              //System.out.println(log.getName());
	           }
	           }

	           xml = this.workFlowDao.retrieveByteArraysOfGpd(taskInstanceId);
	           SAXBuilder sb = new SAXBuilder(); 
	           Document doc = null;
	           try{
	        	 StringReader sr = new StringReader(xml);
	             InputSource is = new InputSource(sr);
	             is.setEncoding("UTF-8");
	            doc = sb.build(is);
	           }catch(Exception e){
	        	   System.out.println("e===="+doc);
	           }
	           
	           Element root = doc.getRootElement();
	           List g = root.getChildren("g");
	           for (int i = 0; i < g.size(); i++) {
	              Element rect = ((Element) g.get(i)).getChild("rect");
	              String id = rect.getAttributeValue("id");
	              if (nodelist.contains(id))
	                  rect.setAttribute("stroke", "red");
	           }

	          
	           Writer writer = new StringWriter();
	           XMLOutputter xo = new XMLOutputter(Format.getPrettyFormat()
	                  .setEncoding("UTF-8"));
	           xo.output(doc, writer);
               xml = writer.toString();
	         
	       } catch (Exception ex) {
	    	   System.out.println("ex==="+ex.getMessage());
	           ex.printStackTrace();
	       }
	       return xml;
	    }

	
	/**
	 * 系统用于结束指定工作流
	 * @param processId
	 */
	  public void endProcess(long processId){
		  try{
			  workFlowDao.end(processId);
		  }catch(Exception ex){
			  System.out.println("系统用于结束指定工作流实例");
		  }
		  
	  }
	  
	  /**
	   * 通过任务定义ID得到当前任务名称
	   * @param taskdef_id
	   * @return
	   */
	  public String getTaskDefNameByTaskDefId(long processdef_id,long taskdef_id){
		  String task_name ="";
		  
		  ProcessDefinition p =workFlowDao.getProcessDefinitionById(processdef_id);
		  
		  Map map = p.getTaskMgmtDefinition().getTasks();
		  Set set = map.keySet();
			Iterator it = set.iterator();
			while(it.hasNext()){
				String name = (String)it.next();
				Task task = (Task)map.get(name);
				if (task.getId()==taskdef_id){
					//System.out.println("task name is"+name);
					task_name = name;
				}
			}
		  return task_name;
		  
	  }
	  
public void updateJbpm(String agentcy,long taskdef_id,long processdef_id){
	workFlowDao.updateJbpm(agentcy, taskdef_id, processdef_id);
	
}

	public java.util.Collection getTaskMessages(long process_id, long task_id, int tasktype) {
		List a =  workFlowDao.getTaskMessages(process_id, task_id, tasktype);
	
		return BeanHelper.buildBeans(TaskMessageDto.class, a);
	}

	public void updateMessage(long process_id, long task_id, int message_type,
			String content, String dtoname, String receive, int tasktype) {
		workFlowDao.updateMessage(process_id, task_id, message_type, content,
				dtoname, receive, tasktype);
	}

	public void setMessage(int message_id, long process_id, long task_id,
			int message_type, String content, String dtoname, String receive,
			int tasktype) {
		
		workFlowDao.setMessage(message_id, process_id, task_id, message_type,
				content, dtoname, receive, tasktype);
	}
	
	/**
	 * 通过任务ID得到当前任务对应的角色列表
	 * @param taskdef_id
	 * @return
	 */
	public String[] getRoleByTaskDefId(long taskdef_id){
		String[] roles = new String[100];
		try{
			List taskroles = workFlowDao.getTaskRoles(taskdef_id);
			String str  ="";
			if(taskroles.size()>0){
				TaskRoleDto role = (TaskRoleDto)taskroles.get(0);
				 str = role.getTask_role();
			}
			roles = StringUtils.split(str, ";");
		}catch(Exception ex){
			System.out.println("系统得到角色列表发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return roles;
	}
	/**
	 * 通过任务ID得到当前代理列表
	 * @param taskdef_id
	 * @return
	 */
	public String[] getAgencyByTaskDefId(long taskdef_id){
		String[] agencys = new String[100];
		try{
			List taskroles = workFlowDao.getTaskRoles(taskdef_id);
			String str  ="";
			if(taskroles.size()>0){
				TaskRoleDto role = (TaskRoleDto)taskroles.get(0);
				 str = role.getAgency_role();
			}
			agencys = StringUtils.split(str, ";");
			
		}catch(Exception ex){
			System.out.println("系统得到代理发生异常"+ex.getMessage());
		}
		
		return agencys;
	}
	/**
	 * 通过节点id得到当前节点对应的消息
	 * @param taskdef_id
	 * @return
	 */
	public java.util.Collection getMessagesByTaskNodeId(long tasknode_id){
		
		List messages = new ArrayList();
		try{
		    messages = workFlowDao.getTaskMessages(tasknode_id, TaskMessageDto.TASKTYPE_NODE);
		}catch(Exception ex){
			System.out.println("系统通过任务节点id得到消息列表发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return BeanHelper.buildBeans(TaskMessageDto.class, messages);
	}
	/**
	 * 通过任务ID得到当前消息列表
	 * @param taskdef_id
	 * @return
	 */
	public java.util.Collection getMessagesByTaskDefId(long taskdef_id){
		List messages = new ArrayList();
		try{
			 messages = workFlowDao.getTaskMessages(taskdef_id, TaskMessageDto.TASKTYPE_TASK);
			
		}catch(Exception ex){
			System.out.println("系统通过任务得到消息发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return BeanHelper.buildBeans(TaskMessageDto.class, messages);
	}
	
	public List getWFALLTask(String wfName){
		List tasks =  workFlowDao.getWFALLTask(wfName);
		List dtos = new ArrayList();
		
		for (int i=0;i<tasks.size();i++){
			
			ProcessTask task = (ProcessTask)tasks.get(i);
			TaskDto dto = new TaskDto();
			dto.setTaskName(task.getTaskName());
			dto.setTaskId(String.valueOf(task.getTaskId()));
			dto.setProcessId(String.valueOf(task.getProcessId()));
			dtos.add(dto);
			
		}
		return dtos;
	}
	
	
}
