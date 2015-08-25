package com.techstar.dmis.service.workflow.handler;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.Assignable;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import com.techstar.framework.service.workflow.IAction;

//please add your business methods start
	// to do it
//add your business method end

/**
 * 工作流操作类
 * @author 
 * @date
 */
public class LimitLineSeqFormSentResult implements IAction {

    public void execute(ExecutionContext arg0) throws Exception {
//    	String busId =(String)arg0.getContextInstance().getVariable("businessId");
//    	String FPlanClass = "";
//    	
//	    Connection connection = arg0.getJbpmContext().getConnection();
//	    Statement statement = connection.createStatement();
//	    ResultSet resultSet = statement.executeQuery("select FPlanClass from DMIS_DD_DOUTAGEPLAN where FDAYPLANNO='"+busId+"' ");
//	    
//	    while(resultSet.next()){
//	    	FPlanClass = resultSet.getString("FPlanClass");
//	    }
//	    resultSet.close();
//	    statement.close();    	
	    
	    
	    //审批结果下发
	    
	    arg0.leaveNode();
   }
  
	
}