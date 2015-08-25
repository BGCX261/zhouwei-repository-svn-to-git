package com.techstar.dmis.service.workflow.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.Assignable;

import com.techstar.dmis.common.ZdhConstants;
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
public class ProjectrecptionSpecApprove implements IAssignment {

    public void assign(Assignable arg0, ExecutionContext arg1) throws Exception {
    	String bus_id = (String)arg1.getContextInstance().getVariable("businessId");
		arg1.getTaskInstance().setBussId(bus_id);
		
		//获得当前任务实例的任务编号
		String taskRoles = "";
		String agencyRoles = "";

		
	    Connection connection = arg1.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select FSTATIONNAME,FSYSTEMTYPE from DMIS_ZDH_RECEPTION where FAPPLICATIONID='"+bus_id+"' ");
	    
	    String FSTATIONNAME = "";
	    String FSYSTEMTYPE = "";
	    while(resultSet.next()){
	    	FSTATIONNAME = resultSet.getString("FSTATIONNAME");
	    	FSYSTEMTYPE = resultSet.getString("FSYSTEMTYPE");
	    }

	    resultSet.close();
	    statement.close();
	    
	    //"电量专工";
	    if((ZdhConstants.projection_WORKFLOW_CITY_Fstationname).equals(FSTATIONNAME)){
	    	taskRoles = ZdhConstants.projection_WORKFLOW_CITY_ROLE_DL;
	    }
	    
	    //子站专工
	    if((ZdhConstants.projection_WORKFLOW_CITY_Fsystemtype).equals(FSYSTEMTYPE)){
	    	if(taskRoles.equals(""))
	    		taskRoles = ZdhConstants.projection_WORKFLOW_CITY_ROLE_ZZ;
	    	else
	    		taskRoles = taskRoles+";"+ZdhConstants.projection_WORKFLOW_CITY_ROLE_ZZ;
	    }	    
	    
    	String[] currentUserIds = DimsWorkflowHelper.getCurrentUsers(taskRoles, agencyRoles);
		arg0.setPooledActors(currentUserIds);
   }
  
	
}