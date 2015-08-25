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

import com.techstar.dmis.service.workflow.impl.helper.DimsWorkflowHelper;
import com.techstar.framework.service.workflow.IAssignment;

//please add your business methods start
	// to do it
//add your business method end

/**
 * 工作流操作类
 * @author 
 * @date
 */
public class DDEnsuringPSSent implements IAssignment {

    public void assign(Assignable arg0, ExecutionContext arg1) throws Exception {
		arg1.getTaskInstance().setBussId((String)arg1.getContextInstance().getVariable("businessId"));
		
		//获得当前任务实例的任务编号

		long taskId = arg1.getTaskInstance().getTask().getId();
		//long processId = arg1.getTaskInstance().getTask().getProcessDefinition().getId();
		//获取当前任务实例的允许分配的角色对应人员
		String taskRoles ="";
		String agencyRoles = "";
		
	    Connection connection = arg1.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    //ResultSet resultSet = statement.executeQuery("select task_role from JBPM_EXT_PERMISSION where task_id='"+taskId+"' and process_id='"+processId+"'");
	    ResultSet resultSet = statement.executeQuery("select TASK_ROLE,AGENCY_ROLE from JBPM_EXT_PERMISSION where task_id='"+taskId+"' ");
	    
	    while(resultSet.next()){
	    	taskRoles = resultSet.getString("TASK_ROLE");
	    	agencyRoles = resultSet.getString("AGENCY_ROLE");
	    }

	    resultSet.close();
	    statement.close();
	    
    	String[] currentUserIds = DimsWorkflowHelper.getCurrentUsers(taskRoles, agencyRoles);
		arg0.setPooledActors(currentUserIds);
   }
  
	
}