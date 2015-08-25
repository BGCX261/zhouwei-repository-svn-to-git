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
public class ProjectrecptionSentResult implements IAction {

    public void execute(ExecutionContext arg0) throws Exception {
    	String busId =(String)arg0.getContextInstance().getVariable("businessId");
    	String fillDept = "";
    	
	    Connection connection = arg0.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select SYS_DATAOWNER from DMIS_ZDH_RECEPTION where FAPPLICATIONID='"+busId+"' ");
	    
	    while(resultSet.next()){
	    	fillDept = resultSet.getString("SYS_DATAOWNER");
	    }
	    resultSet.close();
	    statement.close();   
	    
	    //传送消息给数据所属单位
	    ///////
	    
	    arg0.leaveNode(ZdhConstants.projection_WORKFLOW_CITY_TRANSIT_END);
   }
  
	
}