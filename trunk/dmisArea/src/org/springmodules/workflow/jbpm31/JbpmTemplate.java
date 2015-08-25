/**
 * Created on Feb 20, 2006
 *
 * $Id: JbpmTemplate.java,v 1.6 2006/09/15 13:32:06 costin Exp $
 * $Revision: 1.6 $
 */
package org.springmodules.workflow.jbpm31;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.db.GraphSession;
import org.jbpm.file.def.FileDefinition;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Jbpm 3.1 Template. Requires a jbpmConfiguration and accepts also a
 * hibernateTemplate and processDefinition. Jbpm Persistence Service can be
 * managed by Spring through the given HibernateTemplate, allowing jBPM to work
 * with a user configured session factory and thread-bound session depending on
 * the HibernateTemplate settings. However, due to the nature of jBPM
 * architecture, on each execute the jbpmContext will try to close the user
 * Hibernate session which is undesireable when working with a thread-bound
 * session or a transaction. One can overcome this undesired behavior by setting
 * 'exposeNative' property on the HibernateTemplate to false (default).
 * 
 * @see org.springframework.orm.hibernate3.HibernateTemplate
 * @author Costin Leau
 * 
 */
public class JbpmTemplate extends JbpmAccessor implements JbpmOperations {
	// TODO: persistence is not always required

	/**
	 * Optional process definition.
	 */
	private ProcessDefinition processDefinition;

	/**
	 * Required if jBPM has persistence services.
	 */
	private HibernateTemplate hibernateTemplate;

	/**
	 * Boolean used to determine if the persistence service is used or not. If
	 * so, hibernateTemplate will be required and used internally.
	 */
	private boolean hasPersistenceService;

	/**
	 * jBPM context name. defaults to null which is equivalent to
	 * JbpmContext.DEFAULT_JBPM_CONTEXT_NAME
	 */
	private String contextName = JbpmContext.DEFAULT_JBPM_CONTEXT_NAME;

	/**
	 * Execute the action specified by the given action object within a
	 * JbpmSession.
	 * 
	 * @param callback
	 * @return
	 */
	public Object execute(final JbpmCallback callback) {
		final JbpmContext context = getContext();

		try {
			// use the hibernateTemplate is present and if needed
			if (hibernateTemplate != null && hasPersistenceService) {

				// use hibernate template
				return hibernateTemplate.execute(new HibernateCallback() {
					/**
					 * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
					 */
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						// inject the session in the context
						context.setSession(session);
						return callback.doInJbpm(context);
					}
				});
			}

			// plain callback invocation (no template w/ persistence)
			return callback.doInJbpm(context);

		}
		catch (JbpmException ex) {
			throw convertJbpmException(ex);
		}
		finally {
			releaseContext(context);
		}

	}

	/**
	 * Hook for subclasses for adding custom behavior.
	 * 
	 * @param jbpmContext
	 */
	protected void releaseContext(JbpmContext jbpmContext) {
		jbpmContext.close();
	}

	/**
	 * Hook for subclasses for adding custom behavior.
	 * 
	 * @return created of fetched from the thread jbpm context.
	 */
	protected JbpmContext getContext() {
		JbpmContext context = jbpmConfiguration.createJbpmContext(contextName);

		return context;
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		// see if persistence is required
		// we don't have any other way to get the services then by creating a
		// jbpm context
		// secured in try/finally block
		JbpmContext dummy = getContext();
		try {

			if (JbpmUtils.hasPersistenceService(dummy)) {
				hasPersistenceService = true;
				logger.debug("jBPM persistence service present");
			}

			if (hibernateTemplate != null)
				logger.debug("hibernateTemplate present - jBPM persistence service will be managed by Spring");
			else {
				if (dummy.getSessionFactory() != null) {
					logger.debug("creating hibernateTemplate based on jBPM SessionFactory");
					hibernateTemplate = new HibernateTemplate(dummy.getSessionFactory());
				}
				else

					logger.debug("hibernateTemplate missing - jBPM will handle its own persistence");
			}

		}finally {
			dummy.close();
		}

	}

	public JbpmTemplate() {
	}

	public JbpmTemplate(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}

	public JbpmTemplate(JbpmConfiguration jbpmConfiguration, ProcessDefinition processDefinition) {
		this.jbpmConfiguration = jbpmConfiguration;
		this.processDefinition = processDefinition;
	}

	/**
	 * @return Returns the contextName.
	 */
	public String getContextName() {
		return contextName;
	}

	/**
	 * @param contextName The contextName to set.
	 */
	public void setContextName(String contextName) {
		this.contextName = contextName;
	}

	/**
	 * @return Returns the hibernateTemplate.
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate The hibernateTemplate to set.
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * @return Returns the processDefinition.
	 */
	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * @param processDefinition The processDefinition to set.
	 */
	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findProcessInstance(java.lang.Long)
	 */
	public ProcessInstance findProcessInstance(final Long processInstanceId) {
		return (ProcessInstance) execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				return context.getGraphSession().loadProcessInstance(processInstanceId.longValue());
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findProcessInstances()
	 */
	public List findProcessInstances() {
		return (List) execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				return context.getGraphSession().findProcessInstances(processDefinition.getId());
			}
		});
	}
	
	/**
	 * 获取流程实例 通过流程定义
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findProcessInstances()
	 */
	public List findProcessInstancesByProcess(final long processId) {
		return (List) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getGraphSession().findProcessInstances(processId);
			}
		});
	}	

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findPooledTaskInstances(java.lang.String)
	 */
	public List findPooledTaskInstances(final String actorId) {
		return (List) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getTaskMgmtSession().findPooledTaskInstances(actorId);
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findPooledTaskInstances(java.util.List)
	 */
	public List findPooledTaskInstances(final List actorIds) {
		return (List) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getTaskMgmtSession().findPooledTaskInstances(actorIds);
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findTaskInstances(java.lang.String)
	 */
	public List findTaskInstances(final String actorId) {
		return (List) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getTaskMgmtSession().findTaskInstances(actorId);
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findTaskInstances(java.lang.String[])
	 */
	public List findTaskInstances(final String[] actorIds) {
		return (List) execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				return context.getTaskMgmtSession().findTaskInstances(actorIds);
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findTaskInstances(java.util.List)
	 */
	public List findTaskInstances(final List actorIds) {
		return (List) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getTaskMgmtSession().findTaskInstances(actorIds);
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findTaskInstancesByToken(org.jbpm.graph.exe.Token)
	 */
	public List findTaskInstancesByToken(Token token) {
		return findTaskInstancesByToken(token.getId());
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#findTaskInstancesByToken(long)
	 */
	public List findTaskInstancesByToken(final long tokenId) {
		return (List) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getTaskMgmtSession().findTaskInstancesByToken(tokenId);
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#signal(org.jbpm.graph.exe.ProcessInstance)
	 */
	public void signal(final ProcessInstance processInstance) {
		execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				processInstance.signal();
				return null;
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#saveProcessInstance(org.jbpm.graph.exe.ProcessInstance)
	 */
	public Long saveProcessInstance(final ProcessInstance processInstance) {
		return (Long) execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				context.save(processInstance);
				return new Long(processInstance.getId());
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#signal(org.jbpm.graph.exe.ProcessInstance,
	 *      java.lang.String)
	 */
	public void signal(final ProcessInstance processInstance, final String transitionId) {
		execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				processInstance.signal(transitionId);
				return null;
			}
		});
	}

	/**
	 * @see org.springmodules.workflow.jbpm31.JbpmOperations#signal(org.jbpm.graph.exe.ProcessInstance,
	 *      org.jbpm.graph.def.Transition)
	 */
	public void signal(final ProcessInstance processInstance, final Transition transition) {
		execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				processInstance.signal(transition);
				return null;
			}
		});
		throw new UnsupportedOperationException();
	}


    /**
     * Signals a specific token in a process instance. Used to progress through execution paths other than the main one.
     * If the token could not be found, the root token is signaled (main execution path).
     *
     * @param processInstance process instance to progress through
     * @param tokenName name of the token to signal
     */
    public void signalToken(final ProcessInstance processInstance, final String tokenName) {
		execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				Token token = processInstance.getRootToken().findToken(tokenName);
                if (token == null) {
                    processInstance.signal();
                } else {
                    token.signal();
                }
                return null;
			}
		});
	}

    /**
     * Signals a specific token with the given transition to take.
     *
     * @see #signalToken(ProcessInstance, String)
     * @param processInstance process instance to progress through
     * @param tokenName name of the token to signal
     * @param transitionId transition to take in the execution path
     */
    public void signalToken(final ProcessInstance processInstance, final String tokenName, final String transitionId) {
		execute(new JbpmCallback() {

			public Object doInJbpm(JbpmContext context) {
				Token token = processInstance.getRootToken().findToken(tokenName);
                if (token == null) {
                    processInstance.signal(transitionId);
                } else {
                    token.signal(transitionId);
                }
                return null;
			}
		});
	}
    
    /**
     * 启动工作流
     * @param processDef 流程定义ID
     * @param businessId 业务ID
     */
    public void start(final String processDef,final String businessId,final String preUserId,final String[] curUserIds){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				GraphSession graphSession = context.getGraphSession();
				ProcessDefinition processDefinition = graphSession.findLatestProcessDefinition(processDef);
				ProcessInstance processInstance = new ProcessInstance(processDefinition);
				Token token = processInstance.getRootToken();
			
				ContextInstance contextInstance = (ContextInstance) processInstance.getInstance(ContextInstance.class);
				contextInstance.setVariable("businessId", businessId); 			//业务ID
				contextInstance.setVariable("preUserId", preUserId); 			//前一个步骤的操作人员ID
				contextInstance.setVariable("currentUserIds", curUserIds); 	//当前节点的操作人员ID
				//contextInstance.setVariable("currentRoleIds", ""); 	//当前节点的操作人员对应的角色ID
				
				token.signal();
				context.save(processInstance);
                return null;
			}
		});	
    }
    
    /**
     * 启动工作流
     * @param processDef 流程定义ID
     */
    public void start(final String processDef){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				GraphSession graphSession = context.getGraphSession();
				ProcessDefinition processDefinition = graphSession.findLatestProcessDefinition(processDef);
				ProcessInstance processInstance = new ProcessInstance(processDefinition);
				Token token = processInstance.getRootToken();
				token.signal();
				context.save(processInstance);
                return null;
			}
		});	
    }    
    
	/**
	 * 工作流实例终止
	 * @param processInstance 流程实例ID
	 * @return 
	 */
	public void suspend(final long processInstanceId){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = context.getGraphSession().getProcessInstance(processInstanceId);
				processInstance.suspend();
                return null;
			}
		});	
	}
	
	/**
	 * 结束流程实例
	 * @param processInstanceId
	 */
	public void end(final long processInstanceId){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = context.getGraphSession().getProcessInstance(processInstanceId);
				processInstance.end();
                return null;
			}
		});			
	}
	
	/**
	 * 得到该流程对应的任务节点
	 * @param processInstanceId
	 */
	public List getInstanceTask(final long processInstanceId){
	
		return (List)  execute(new JbpmCallback() {
			 
			public Object doInJbpm(JbpmContext context) {
				List a = new ArrayList();
				ProcessInstance processInstance = context.getGraphSession().getProcessInstance(processInstanceId);
				
				java.util.Collection taskInstances  = processInstance.getTaskMgmtInstance().getTaskInstances();
				
				for(Iterator it=taskInstances.iterator();it.hasNext();){
					  TaskInstance taskinstance =  (TaskInstance)it.next();
					  a.add(taskinstance.getTask());
				}
				
                return a;
			}
		});	
		
		
		
	}
	

	/**
	 * 结束任务
	 * @param taskInstanceId 任务实例ID
	 * @return 
	 */
	public void endTask(final long taskInstanceId,final String preUserId,final String[] curUserIds){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				TaskInstance taskInstance = context.getTaskMgmtSession().getTaskInstance(taskInstanceId);

				ProcessInstance processInstance = taskInstance.getContextInstance().getProcessInstance();
				Token token = processInstance.getRootToken();
				taskInstance.getContextInstance().setVariable("preUserId", preUserId,token);
				taskInstance.getContextInstance().setVariable("currentUserIds", curUserIds,token);
				taskInstance.end();
				context.save(taskInstance);
                return null;
			}
		});	
	}
	
	/**
	 * 依据transition结束任务
	 * @param taskInstanceId 任务实例ID
	 * @return 
	 */
	public void endTask(final long taskInstanceId,final String transitionName,final String preUserId,final String[] curUserIds){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				TaskInstance taskInstance = context.getTaskMgmtSession().getTaskInstance(taskInstanceId);

				ProcessInstance processInstance = taskInstance.getContextInstance().getProcessInstance();
				Token token = processInstance.getRootToken();
				taskInstance.getContextInstance().setVariable("preUserId", preUserId,token);
				taskInstance.getContextInstance().setVariable("currentUserIds", curUserIds,token);
				taskInstance.end(transitionName);
				context.save(taskInstance);	
                return null;
			}
		});	
	}	
	
	
	
	/**
	 * 获取最新流程定义
	 * @param 
	 * @return ProcessDefinition集合
	 */
	public List findLatestProcessDefinitions(){
		return (List)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getGraphSession().findLatestProcessDefinitions();
			}
		});			
	}
	
	public ProcessDefinition findLatestProcessDefinitionById(final long processId){
		return (ProcessDefinition)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
			 ProcessDefinition processDefinition = context.getGraphSession().getProcessDefinition(processId);
			 return 	processDefinition;
			}
		});			
	}
	
	/**
	 * 通过定义的工作流ID，得到该工作流定义信息
	 * @param wfName
	 * @return
	 */
	public ProcessDefinition findLatestProcessDefinition(final String wfName){
		return (ProcessDefinition)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
			 ProcessDefinition processDefinition = context.getGraphSession().findLatestProcessDefinition(wfName);
			 return 	processDefinition;
			}
		});			
	}
	
	/**
	 * 获取流程实例的历史信息
	 * @param processInstance 流程实例ID
	 * @return ProcessLog的Map集合
	 */
	public Map findLogsByTaskInstance(final long taskInstanceId){
		return (Map)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = context.getTaskMgmtSession().getTaskInstance(taskInstanceId).getContextInstance().getProcessInstance();
				return context.getLoggingSession().findLogsByProcessInstance(processInstance.getId());
			}
		});
	}
	
	/**
	 * 获取某Token上的历史信息
	 * @param processInstance 流程实例ID
	 * @return ProcessLog的LIST集合
	 */
	public List findLogsByToken(final long tokenId){
		return (List)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				return context.getLoggingSession().findLogsByToken(tokenId);
			}
		});
	}	
	
	/**
	 * 获取流程流转日志
	 * @param processInstanceId
	 * @return
	 */
	public List findTransitionLogs(final long taskInstanceId){
		return (List)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = context.getTaskMgmtSession().getTaskInstance(taskInstanceId).getContextInstance().getProcessInstance();
				return context.getLoggingSession().findTransitionLog(processInstance.getId());	
			}
		});		
	}
	
	/**
	 * 获取流程的任务列表
	 * @param processInstanceId
	 * @return ProcessTask集合
	 */
	public List findTaskOfProcess(final String processDef){
		return (List)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				GraphSession graphSession = context.getGraphSession();
				ProcessDefinition processDefinition = graphSession.findLatestProcessDefinition(processDef);
				Map map = processDefinition.getTaskMgmtDefinition().getTasks();
				
				List returnList = new ArrayList();
				Set set = map.keySet();
				Iterator it = set.iterator();
				while(it.hasNext()){
					String name = (String)it.next();
					Task task = (Task)map.get(name);
					ProcessTask pt = new ProcessTask();
					pt.setProcessId(processDefinition.getId());
					pt.setProcessName(processDefinition.getName());
					pt.setProcessVersion(processDefinition.getVersion());
					pt.setTaskId(task.getId());
					pt.setTaskName(task.getName());
					returnList.add(pt);
				}
				
				return returnList;
			}
		});		
	}	
	
	/**
	 * 获取图形定义文件
	 * @param processInstance 流程实例ID
	 * @return
	 */
	public byte[] retrieveByteArraysOfGpd(final long taskInstanceId){
		return (byte[])execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessDefinition processDefinition = context.getTaskMgmtSession().getTaskInstance(taskInstanceId).getTask().getProcessDefinition();
			    FileDefinition fileDefinition = processDefinition.getFileDefinition();
			    System.out.println("fileDefinition"+fileDefinition.getName());
			    byte[] bytes = fileDefinition.getBytes("gpd.xml");
			    return bytes;
			}
		});		
	}
	
   
	public byte[] retrieveByteArraysOfGpd(final String processDef){
		return (byte[])execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				GraphSession graphSession = context.getGraphSession();
				ProcessDefinition processDefinition = graphSession.findLatestProcessDefinition(processDef);
			    FileDefinition fileDefinition = processDefinition.getFileDefinition();
			    byte[] bytes = fileDefinition.getBytes("gpd.xml");
			    return bytes;
			}
		});		
	}
	
	/**
	 * 一票否决会签
	 * @param taskInstanceId
	 * @param roleId
	 * @param isApprove
	 * @return
	 */
	public String oneTicketNoForCountersign(final long taskInstanceId,final String roleId,final int isApprove){
		return (String)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				TaskInstance taskInstance =  context.getTaskMgmtSession().getTaskInstance(taskInstanceId);
				ProcessInstance processInstance = taskInstance.getContextInstance().getProcessInstance();
				Token token = taskInstance.getToken();
				//init代表分配的角色编号集合 dd1:dd2; baohu; zdh; fangshi;
				String init = (String)processInstance.getContextInstance().getVariable("init", token);
				//result代表会签通过的角色编号集合
				String result = (String)processInstance.getContextInstance().getVariable("result", token);
				//approve 代表流程运行中审批结果
				String approve = (String)processInstance.getContextInstance().getVariable("approve", token);

				if(result==null || "".equals(result)) result = "";
				if(approve==null || "".equals(approve)) approve = "0"; //初始化
				String[] roleArray = roleId.split(";");  //一个人可能拥有多个工作流岗位
				if(isApprove==1){
					for(int i=0;i<roleArray.length;i++){
						if(result.indexOf(roleArray[i])==-1 && init.indexOf(roleArray[i])!=-1){ //判断该角色是否已经会签过了,未会签过的则将进行通过累计
							approve = Integer.toString(Integer.parseInt(approve)+isApprove);
							result = result+";"+roleArray[i];
							break;
						}
					}

				}
				
				processInstance.getContextInstance().setVariable("approve", approve);
				processInstance.getContextInstance().setVariable("result", result);
				
				if(isApprove==0) //一票否决
					return "-1";
				else{
					String[] results = result.split(";");
					String[] inits = init.split(";");
					
					int initNum = inits.length;
					if(Integer.parseInt(approve)==initNum) //若审核通过数量多则通过
						return "1";
					else 
						return "0";					
				}
			}
		});				
	}
	
    /*
     * 会签处理
     * roleId 角色ID
     * isApprove 是否通过 1-通过 0-否决
     * return 返回值 1-代表会签通过 0-代表保持阻塞状态 -1代表不通过
     */
	public String isOverForCountersign(final long taskInstanceId,final String roleId,final int isApprove){
		return (String)execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				TaskInstance taskInstance =  context.getTaskMgmtSession().getTaskInstance(taskInstanceId);
				ProcessInstance processInstance = taskInstance.getContextInstance().getProcessInstance();
				Token token = taskInstance.getToken();
				//init代表分配的角色编号集合 dd1:dd2; baohu; zdh; fangshi;
				String init = (String)processInstance.getContextInstance().getVariable("init", token);
				//result代表会签通过的角色编号集合
				String result = (String)processInstance.getContextInstance().getVariable("result", token);
				//approve 代表流程运行中审批结果
				String approve = (String)processInstance.getContextInstance().getVariable("approve", token);
				
				//更新result
				if(result==null || "".equals(result)) result = roleId;
				else if(result.indexOf(roleId)==-1) //判断该角色是否已经会签过了,未会签过的则将进行追加
					result = result+";"+roleId;
				processInstance.getContextInstance().setVariable("result", result);
				
				//更新approve
				if(approve==null || "".equals(approve)) approve = "0"; //初始化
				if(isApprove==1){
					if(result.indexOf(roleId)==-1) //判断该角色是否已经会签过了,未会签过的则将进行通过累计
						approve = Integer.toString(Integer.parseInt(approve)+isApprove);
				}
				processInstance.getContextInstance().setVariable("approve", approve);
				
				if(isApprove==0) //一票否决
					return "-1";
				else{
					String[] results = result.split(";");
					String[] inits = init.split(";");
					
					int initNum = inits.length;
					if(Integer.parseInt(approve)>=initNum) //若审核通过数量多则通过
						return "1";
					else 
						return "0";					
				}
//				if("1".equals(type) && isApprove==0) //一票否决
//					return "-1";
//				else if("2".equals(type) && isApprove==1)//一票通过
//					return "1";
//				else if("3".equals(type)){
//					String[] results = result.split(";");
//					String[] inits = init.split(";");
//					
//					int initNum = inits.length;
//					int middleNum = (int)(Math.round(initNum/2));;
//					if(Integer.parseInt(approve)>middleNum) //若审核通过数量多则通过
//						return "1";
//					else if((results.length-Integer.parseInt(approve))>middleNum) //若审核通过少于否决数量则不通过
//						return "-1";
//					else 
//						return "0";
//				}else
//					return "0";
			}
		});		
		
	}

	/**
	 * 结束流程的等待状态,进行流转
	 * @param taskInstanceId  任务实例ID
	 */
	public void endWaitingByTaskInstance(final long taskInstanceId){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = context.getTaskInstance(taskInstanceId).getContextInstance().getProcessInstance();
				processInstance.signal();
                return null;
			}
		});			
	}
	
	/**
	 * 结束流程的等待状态,进行流转
	 * @param processInstanceId 流程实例ID
	 */
	public void endWaitingByProcessInstance(final long processInstanceId){
		execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) {
				ProcessInstance processInstance = context.getProcessInstance(processInstanceId);
				processInstance.signal();
                return null;
			}
		});			
	}	
	
	

	
}
