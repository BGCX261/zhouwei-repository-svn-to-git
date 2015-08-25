package com.techstar.dmis.service.workflow.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.Assignable;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.techstar.dmis.common.ZdhConstants;
import com.techstar.framework.service.workflow.IAction;

//please add your business methods start
	// to do it
//add your business method end

/**
 * 工作流操作类
 * @author 
 * @date
 */
public class ZdhSrapplIsArea implements IAction {

    public void execute(ExecutionContext arg0) throws Exception {
    	String busId =(String)arg0.getContextInstance().getVariable("businessId");
    	String fillDept = "";
    	
	    Connection connection = arg0.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select sys_filldept from DMIS_ZDH_SRAPPLICATION where FAPPLICATIONNO='"+busId+"' ");
	    
	    while(resultSet.next()){
	    	fillDept = resultSet.getString("sys_filldept");
	    }
	    resultSet.close();
	    statement.close();    	
	    
	    if(fillDept.equalsIgnoreCase(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsArea_AREA)){//区调
	    	arg0.leaveNode("区调");
	    	//return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsArea_AREA;
	    }else{
	    	arg0.leaveNode("市调");
	    	//return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsArea_AREA;
	    }
   }
  
	
}