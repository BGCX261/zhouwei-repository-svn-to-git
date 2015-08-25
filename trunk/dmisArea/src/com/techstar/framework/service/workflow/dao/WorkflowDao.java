package com.techstar.framework.service.workflow.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;
import org.springframework.dao.DataAccessException;
import org.springmodules.workflow.jbpm31.JbpmTemplate;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.beanutils.BeanUtils;

import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.dao.ICommonQueryDao;
import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryDetailPair;
import com.techstar.framework.service.workflow.bus.dto.JbpmCmsDto;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.service.workflow.manager.WFManagerHelper;



public class WorkflowDao implements IWorkflowDao {

	private JbpmTemplate jbpmTemplate= null;
	private IBaseHbnDao baseHbnDao;
	private IBaseJdbcDao baseJdbcDao;
	private ICommonQueryDao commonQueryDao;
	
	public ICommonQueryDao getCommonQueryDao() {
		return commonQueryDao;
	}

	public void setCommonQueryDao(ICommonQueryDao commonQueryDao) {
		this.commonQueryDao = commonQueryDao;
	}

	public IBaseHbnDao getBaseHbnDao() {
		return baseHbnDao;
	}

	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}

	public IBaseJdbcDao getBaseJdbcDao() {
		return baseJdbcDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void setJbpmTemplate(JbpmTemplate jbpmTemplate) {
		this.jbpmTemplate = jbpmTemplate;
	}

	private JbpmConfiguration jbpmConfiguration;
	public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}
	
	public List findTransitionLogs(long taskInstance) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.jbpmTemplate.findTransitionLogs(taskInstance);
	}

	public List findPooledTaskInstances(String actorId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.jbpmTemplate.findPooledTaskInstances(actorId);
	}
	
	public List findTaskInstances(String actorId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.jbpmTemplate.findTaskInstances(actorId);
	}	

	public void start(String processDefinition) throws DataAccessException {
		// TODO Auto-generated method stub
		this.jbpmTemplate.start(processDefinition);
	}

	public void start(String processDefinition,String businessId,String preUserId,String[] curUserIds) throws DataAccessException {
		// TODO Auto-generated method stub
		this.jbpmTemplate.start(processDefinition,businessId,preUserId,curUserIds);
	}
	
	public void suspend(long processInstance) throws DataAccessException {
		// TODO Auto-generated method stub
		this.jbpmTemplate.suspend(processInstance);		
	}
	
	public void end(long processInstance) throws DataAccessException {
		// TODO Auto-generated method stub
		this.jbpmTemplate.end(processInstance);		
	}	
	
	public void endTask(long taskInstanceId,String preUserId,String[] curUserIds){
		this.jbpmTemplate.endTask(taskInstanceId,preUserId,curUserIds);
	}

	public void endTask(long taskInstanceId, String transitionName,String preUserId,String[] curUserIds) throws DataAccessException {
		// TODO Auto-generated method stub
		this.jbpmTemplate.endTask(taskInstanceId,transitionName,preUserId,curUserIds);
	}

	public String retrieveByteArraysOfGpd(long taskInstanceId) throws DataAccessException {
		// TODO Auto-generated method stub
		String xmlString = null;
		try{
			byte[] bytes =  this.jbpmTemplate.retrieveByteArraysOfGpd(taskInstanceId);
			xmlString = new String(bytes,"UTF-8");
			//System.out.println(xmlString);
		}catch(Exception ex){}
		return xmlString;
	}
	
	public String retrieveByteArraysOfProcess(String processDef) throws DataAccessException {
		// TODO Auto-generated method stub
		String xmlString = null;
		try{
			byte[] bytes =  this.jbpmTemplate.retrieveByteArraysOfGpd(processDef);
			xmlString = new String(bytes,"UTF-8");
		}catch(Exception ex){}
		return xmlString;
	}
	
	
	
	public String isOverForCountersign(long taskInstanceId, String roleId, int isApprove) throws DataAccessException {
		return jbpmTemplate.isOverForCountersign(taskInstanceId, roleId, isApprove);
	}

	/**
	 * 用于得到所有工作流列表
	 */
	public List getRunningWF() throws DataAccessException {
		List runningWF = new ArrayList();
		try{
			runningWF = jbpmTemplate.findLatestProcessDefinitions();
		}catch(Exception ex){
		 System.out.println("ϵͳ工作流得到列表发生异常"+ex.getMessage());	
		}
		return runningWF;
		
	}
	/**
	 * 此函数用于通过一个工作流ID返回一个工作流实例
	 * @param processInstanceId
	 * @return
	 */
	public ProcessInstance findProcessInstance(long processInstanceId){
		ProcessInstance process = null;
		try{
			process = jbpmTemplate.findProcessInstance(new Long(processInstanceId));
		}catch(Exception ex){
			System.out.println("得到工作流实例发生异常"+ex.getMessage());
		}
		return process;	
	}
	/**
	 * 此方法用于得到当前工作流的所有节点
	 * @param processInstanceId
	 * @return
	 */
	public List getProcessNodes(String wfName){
		List nodes = new ArrayList();
		try{
			ProcessDefinition proDefinition = jbpmTemplate.findLatestProcessDefinition(wfName);
			if(proDefinition!=null){
			 nodes = proDefinition.getNodes();
			}else{
				System.out.println("proDefinition is null");
			}
		}catch(Exception ex){
			System.out.println("system get wf excep is"+ex.getMessage());
		}
		return nodes;
	}
	/**
	 * 用于得到工作流节点
	 */
	public List getProcessNodes(long processId){
		List nodes = new ArrayList();
		try{
			ProcessDefinition proDefinition = jbpmTemplate.findLatestProcessDefinitionById(processId);
			if(proDefinition!=null){
			 nodes = proDefinition.getNodes();
			}else{
				System.out.println("proDefinition is null");
			}
		}catch(Exception ex){
			System.out.println("system get wf excep is"+ex.getMessage());
		}
		return nodes;
	}
	
    public Node getProcessStartNode(long processId){
    	
    	Node node = null;
		try{
			ProcessDefinition proDefinition = jbpmTemplate.findLatestProcessDefinitionById(processId);
			if(proDefinition!=null){
				node = proDefinition.getStartState();
			}else{
				System.out.println("proDefinition is null");
			}
		}catch(Exception ex){
			System.out.println("system get wf excep is"+ex.getMessage());
		}
		return node;
    	
    }
	
	/**
	 * 用于得到当前工作流定义
	 * @param processId
	 * @return
	 */
	public ProcessDefinition getProcessDefinitionById(long processId){
		
		 ProcessDefinition p =jbpmTemplate.findLatestProcessDefinitionById(processId);
		 return p;
	}
	
	/**
	 * 通过工作流实例得到工作流定义
	 * @param processId
	 * @return
	 */
	public ProcessDefinition getProcessDefinitionByProcessId(long processId){
		ProcessInstance p=jbpmTemplate.findProcessInstance(new Long(processId));
		 return p.getProcessDefinition();
	}
	
	
	/**
	 * 用于得到当前工作流所有任务
	 * @param wfName
	 * @return
	 */
	public List getWFALLTask(String wfName){
		List tasks = new ArrayList();
		try{
			tasks = jbpmTemplate.findTaskOfProcess(wfName);
		}catch(Exception ex){
			System.out.println("得到工作流实例发生异常"+ex.getMessage());
		}
		return tasks;
	}
	/**
	 * 用于LOAD权限数据
	 * @param jbmp_promission
	 */
	public Jbpm_Promission findByPk(Object pk) {
		// TODO Auto-generated method stub
		Jbpm_Promission sa = (Jbpm_Promission)baseHbnDao.findByIdFlush(Jbpm_Promission.class, (Serializable) pk);
		//baseHbnDao.get
		return sa;
	}

	/**
	 * 用于创建更新权限数据
	 * @param jbmp_promission
	 */
	public void saveOrUpdateJbpm_Promission(Jbpm_Promission jbmp_promission) {
		baseHbnDao.saveOrUpdate("Jbpm_Promission", jbmp_promission);
	}
	/**
	 * 用于
	 * @param jbmp_message
	 */
	public void saveOrUpdateJbpm_Message(Jbpm_Message jbmp_message) {
		baseHbnDao.saveOrUpdate("Jbpm_Message", jbmp_message);
	}
	
	/**
	 * 用于得到当前工作流某个任务的所有角色
	 * @param process_id
	 * @param task_id
	 * @return
	 */
	public List getTaskRoles(long process_id,long task_id){
		List taskroles = new ArrayList();
		try{
			CommonQueryObj commqobj  =new CommonQueryObj();
			List details = new ArrayList();
			QueryDetailPair detaillPair = new QueryDetailPair();
			detaillPair.setName("promission.process_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(process_id));
			details.add(detaillPair);
			
			detaillPair = new QueryDetailPair();
			detaillPair.setName("promission.task_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(task_id));
			details.add(detaillPair);
            String viewstr ="";
			String seletype="string,string,long";
            commqobj.setSelectcolnames(viewstr);
            commqobj.setSelectcolTypes(seletype);
			commqobj.setEntityName("com.techstar.framework.service.workflow.dao.Jbpm_Promission");
			commqobj.setAlias("promission");
			commqobj.setDetailPairs(details);
			taskroles = commonQueryDao.getLogicElemList(commqobj).getElemList();

		}catch(Exception ex){
			System.out.println("系统得到当前工作流任务对应的角色发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return taskroles;

	} 
	
	public List getTaskRoles(long task_id){
		List taskroles = new ArrayList();
		try{
			CommonQueryObj commqobj  =new CommonQueryObj();
			List details = new ArrayList();
			QueryDetailPair detaillPair = new QueryDetailPair();
		
			detaillPair = new QueryDetailPair();
			detaillPair.setName("promission.task_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(task_id));
			details.add(detaillPair);
            String viewstr ="";
			String seletype="string,string,long";
            commqobj.setSelectcolnames(viewstr);
            commqobj.setSelectcolTypes(seletype);
			commqobj.setEntityName("com.techstar.framework.service.workflow.dao.Jbpm_Promission");
			commqobj.setAlias("promission");
			commqobj.setDetailPairs(details);
			taskroles = commonQueryDao.getLogicElemList(commqobj).getElemList();

		}catch(Exception ex){
			System.out.println("系统得到当前工作流任务对应的角色发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return taskroles;

	} 
	
	
	public List getTaskMessages(long process_id,long task_id){
		List messages = new ArrayList();
		try{
			CommonQueryObj commqobj  =new CommonQueryObj();
			List details = new ArrayList();
			QueryDetailPair detaillPair = new QueryDetailPair();
			detaillPair.setName("message.process_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(process_id));
			details.add(detaillPair);
			
			detaillPair = new QueryDetailPair();
			detaillPair.setName("message.task_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(task_id));
			details.add(detaillPair);
            String viewstr ="";
			String seletype="string,string,long";
            commqobj.setSelectcolnames(viewstr);
            commqobj.setSelectcolTypes(seletype);
			commqobj.setEntityName("com.techstar.framework.service.workflow.dao.Jbpm_Message");
			commqobj.setAlias("message");
			commqobj.setDetailPairs(details);
			messages = commonQueryDao.getLogicElemList(commqobj).getElemList();

		}catch(Exception ex){
			System.out.println("系统得到当前工作流任务对应的消息发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return messages;

	}
	
	
	/**
	 * 通过任务id得到消息列表
	 * @param task_id
	 * @return
	 */
	public List getTaskMessages(long task_id,int tasktype){
		List messages = new ArrayList();
		try{
			CommonQueryObj commqobj  =new CommonQueryObj();
			List details = new ArrayList();
			QueryDetailPair detaillPair = new QueryDetailPair();
			
			detaillPair.setName("message.tasktype");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(tasktype));
			details.add(detaillPair);
			
			detaillPair = new QueryDetailPair();
			detaillPair.setName("message.task_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(task_id));
			details.add(detaillPair);
			
			
            String viewstr ="";
			String seletype="string,string,long";
            commqobj.setSelectcolnames(viewstr);
            commqobj.setSelectcolTypes(seletype);
			commqobj.setEntityName("com.techstar.framework.service.workflow.dao.Jbpm_Message");
			commqobj.setAlias("message");
			commqobj.setDetailPairs(details);
			messages = commonQueryDao.getLogicElemList(commqobj).getElemList();

		}catch(Exception ex){
			System.out.println("系统得到当前工作流任务对应的消息发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return messages;

	}
	
	
	
	
	
	public String getWFDtoName(String wfName){
		String dtoName ="";
		try{
			CommonQueryObj commqobj  =new CommonQueryObj();
			List details = new ArrayList();
			QueryDetailPair detaillPair = new QueryDetailPair();
			detaillPair.setName("wf_cms_mapping.process_name");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(wfName);
			details.add(detaillPair);
			
		
            String viewstr ="";
			String seletype="string";
            commqobj.setSelectcolnames(viewstr);
            commqobj.setSelectcolTypes(seletype);
			commqobj.setEntityName("com.techstar.framework.service.workflow.dao.Jbpm_Cms");
			commqobj.setAlias("wf_cms_mapping");
			commqobj.setDetailPairs(details);
			List q = commonQueryDao.getLogicElemList(commqobj).getElemList();
		  
			if(q!=null&&q.size()>0){
			  Jbpm_Cms jbpm_cms = (Jbpm_Cms)q.get(0);
			  dtoName = jbpm_cms.getBus_name();
			}

		}catch(Exception ex){
			System.out.println("系统得到当前工作流任务对应的消息发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return dtoName;

	}
	
	/**
	 * 用于得到工作流的cms信息
	 */
	public void setWFDto(Collection entities){
		try{
			delJbpm();
			baseHbnDao.saveOrUpdateAll(entities);
		}catch(Exception ex){
			System.out.println("ex"+ex.getMessage());
		}
	}
	
	/**
	 * 用于删除目前系统中所有工作流
	 *
	 */
	public void delJbpm(){
		String sql ="delete from jbpm_ext_cms";
		try{
			baseJdbcDao.executeSql(sql);
		}catch(Exception ex){
			System.out.println("ex"+ex.getMessage());
		}
		
	}
	
	
   public void updateMessage(long process_id, long task_id, int message_type,
			String content, String dtoname, String receive, int tasktype) {

		String sql = "update JBPM_EXT_MESSAGE set message_bus_name='" + dtoname
				+ "'," + "receive='" + receive + "',content='" + content
				+ "' where " + "message_type=" + message_type + " and task_id="
				+ task_id + " and " + "process_id=" + process_id
				+ "and tasktype=" + tasktype;
		try {
			baseJdbcDao.executeSql(sql);
		} catch (Exception ex) {
			System.out.println("exception is" + ex.getMessage());
			ex.printStackTrace();
		}

	}
   
   public void setMessage(int message_id, long process_id, long task_id,
			int message_type, String content, String dtoname, String receive,
			int tasktype) {
		String sql = "insert into jbpm_ext_message (messageid,process_id,task_id,message_bus_name,"
				+ "receive,message_type,content,tasktype) values("
				+ message_id
				+ ","
				+ process_id
				+ ","
				+ task_id
				+ ",'"
				+ dtoname
				+ "','"
				+ receive
				+ "',"
				+ message_type
				+ ",'"
				+ content
				+ "',"
				+ tasktype + ")";
		System.out.println("sql="+sql);
		try {
			
			baseJdbcDao.executeSql(sql);
		} catch (Exception ex) {
			System.out.println("exception is" + ex.getMessage());
			ex.printStackTrace();
		}

	}
   
	public List getTaskMessages(long process_id,long task_id,int tasktype){
		List messages = new ArrayList();
		try{
			CommonQueryObj commqobj  =new CommonQueryObj();
			List details = new ArrayList();
			QueryDetailPair detaillPair = new QueryDetailPair();
			detaillPair.setName("message.process_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(process_id));
			details.add(detaillPair);
			
			detaillPair = new QueryDetailPair();
			detaillPair.setName("message.task_id");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(task_id));
			details.add(detaillPair);
			
			detaillPair = new QueryDetailPair();
			detaillPair.setName("message.tasktype");
			detaillPair.setOperInfo(QueryDetailPair.OPER_EQUAL);
			detaillPair.setStvalue(String.valueOf(tasktype));
			details.add(detaillPair);
			
            String viewstr ="";
			String seletype="long,long,int";
            commqobj.setSelectcolnames(viewstr);
            commqobj.setSelectcolTypes(seletype);
			commqobj.setEntityName("com.techstar.framework.service.workflow.dao.Jbpm_Message");
			commqobj.setAlias("message");
			commqobj.setDetailPairs(details);
			System.out.println("&&&&&");
			messages = commonQueryDao.getLogicElemList(commqobj).getElemList();
			System.out.println("&&&&& message size is"+messages);

		}catch(Exception ex){
			System.out.println("系统得到当前工作流任务对应的消息发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return messages;

	}
   
   
   
	
	public void updateJbpm(String agentcy,long task_id,long process_id){
		String sql ="update jbpm_ext_permission set agency_role='"+agentcy
		           +"' where task_id="+task_id+" and process_id="+process_id;
		try{
			baseJdbcDao.executeSql(sql);
		}catch(Exception ex){
			System.out.println("ex"+ex.getMessage());
		}
	}
	
      
	public void delWFDto(Collection entities){
		try{
			
			for (Iterator it=entities.iterator(); it.hasNext(); ) {
				  Jbpm_Cms element = (Jbpm_Cms)it.next();
				  
				  Jbpm_Cms entity = (Jbpm_Cms)baseHbnDao
				       .loadById(Jbpm_Cms.class, element.getId());
				  
				  if(entity!=null){
				     baseHbnDao.delete(entity);
				  }
			}
		}catch(Exception ex){
			System.out.println("ex"+ex.getMessage());
		}
	}

	public String oneTicketNoForCountersign(long taskInstanceId, String roleId, int isApprove) throws DataAccessException {
		return jbpmTemplate.oneTicketNoForCountersign(taskInstanceId, roleId, isApprove);
	}

	public void endWaitingByProcessInstance(long processInstanceId) throws DataAccessException {
		jbpmTemplate.endWaitingByProcessInstance(processInstanceId);
	}

	public void endWaitingByTaskInstance(long taskInstanceId) throws DataAccessException {
		jbpmTemplate.endWaitingByTaskInstance(taskInstanceId);
	}
    
	/**
	 * 用于得到当前工作流的实例
	 * @param processId
	 * @return
	 */
	public List getProcessInstancesByProcess(long wf_defId){
		List instances = new ArrayList();
		try{
			ProcessDefinition processDef = jbpmTemplate.findLatestProcessDefinitionById(wf_defId);
			jbpmTemplate.setProcessDefinition(processDef);
			instances = jbpmTemplate.findProcessInstances();
			
			
		}catch(Exception ex){
			System.out.println("得到工作流实例发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return instances;
	}
	
	

	
	
	
	
    
	/**
	 * 用于得到当前工作流实例的任务
	 * @param instanceId
	 * @return
	 */
	public List getProcessInstanceTasks (long instanceId){
		
		List tasks = new ArrayList();
		try{
			ProcessInstance instance = jbpmTemplate.findProcessInstance(new Long(instanceId));
			TaskMgmtInstance taskMgmt = instance.getTaskMgmtInstance();
			java.util.Collection c = taskMgmt.getTaskInstances();
			for (Iterator it=c.iterator(); it.hasNext(); ) {
		        Object element = it.next();
		        tasks.add(element);
		    }
		}catch(Exception ex){
			System.out.println("得到工作流实例任务实例发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		return tasks;
	}

  
  
  public static void main(String[] args){
	  
	  System.out.println("#####");
	  WorkflowDao dao = new WorkflowDao();
	  List entitys = new ArrayList();
	  
	  QueryDetailPair pair = new QueryDetailPair();
	  pair.setDelColValue("envalue");
	  entitys.add(pair);

	 // dao.saveOrUpdateEntity(entitys,"","QueryDetailPair","delColValue","alias",1);
	  
	  
	  
	  
	  
  }
	

}
