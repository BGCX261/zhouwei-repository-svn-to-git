package com.techstar.dmis.service.workflow.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.Assignable;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import com.techstar.framework.service.workflow.IAssignment;

//please add your business methods start
	// to do it
//add your business method end

/**
 * 工作流操作类
 * @author 
 * @date
 */
public class DDEnsuringPSCountersign implements IAssignment {

    public void assign(Assignable arg0, ExecutionContext arg1) throws Exception {
    //please add your business methods start
	// to do it
    	arg1.getTaskInstance().setBussId((String)arg1.getContextInstance().getVariable("businessId"));
    	
    	//获取界面传递过来的信息
    	String[] actors = (String[])arg1.getContextInstance().getVariable("currentUserIds");
    	String strActors = "";
    	for(int i=0;i<actors.length;i++){
    		if(i==0)strActors=actors[i];
    		else strActors=strActors+";"+actors[i];
    	}
		//获得当前任务实例的任务编号
		long taskId = arg1.getTaskInstance().getTask().getId();
		long processId = arg1.getTaskInstance().getTask().getProcessDefinition().getId();
		//获取当前任务实例的允许分配的角色对应人员
		List currentUserList = new ArrayList();
		String taskRoles ;
		
	    Connection connection = arg1.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select task_role from JBPM_EXT_PERMISSION where task_id='"+taskId+"' and process_id='"+processId+"'");
	    while(resultSet.next()){
	    	taskRoles = resultSet.getString("task_role");
	    }
	    
    	//根据角色取道用户信息
    	currentUserList.add("COURSIGN");
//	    IUserService userService  = (IUserService)ServiceLocator.getInstance().getService("iUserService");
//	    userService.q
	    
	    resultSet.close();
	    statement.close();    	
    	
	    String[] currentUserIds = new String[currentUserList.size()];
	    for(int i=0;i<currentUserList.size();i++){
	    	currentUserIds[i]=(String)currentUserList.get(i);
	    }
	    if(currentUserIds==null || currentUserIds.length==0) currentUserIds = new String[]{"coursign"}; //测试
    	arg0.setPooledActors(currentUserIds);
    	//初始化基本设置
    	arg1.getContextInstance().setVariable("init",strActors);    	
//add your business method end
   }
  
 
}