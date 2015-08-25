package com.techstar.dmis.service.workflow.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jbpm.graph.exe.ExecutionContext;

import com.techstar.dmis.common.ZdhConstants;
import com.techstar.framework.service.workflow.IDecision;

//please add your business methods start
// to do it
//add your business method end

/**
 * 工作流操作类
 * @author 
 * @date
 */
public class ZdhSrapplIsWorkType implements IDecision {

    public String decide(ExecutionContext arg0) throws Exception {
    	String busId =(String)arg0.getContextInstance().getVariable("businessId");
    	String fAttribute = "";
    	
	    Connection connection = arg0.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select FAttribute from DMIS_ZDH_SRAPPLICATION where FAPPLICATIONNO='"+busId+"' ");
	    
	    while(resultSet.next()){
	    	fAttribute = resultSet.getString("FAttribute");
	    }
	    resultSet.close();
	    statement.close();    	
	    
	    if(fAttribute.equals(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK)){//检修
	    	//arg0.leaveNode(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK);
	    	return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK;
	    }else{//退运
	    	//arg0.leaveNode(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_REBACK);
	    	return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_REBACK;
	    }
	    
	   // return null;
   }
  
	
}