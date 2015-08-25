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
public class ZdhSrapplIsDpt implements IDecision {

    public String decide(ExecutionContext arg0) throws Exception {


    	String busId =(String)arg0.getContextInstance().getVariable("businessId");
    	String fillDept = "";
    	
	    Connection connection = arg0.getJbpmContext().getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select SYS_DATAOWNER from DMIS_ZDH_SRAPPLICATION where FAPPLICATIONNO='"+busId+"' ");
	    
	    while(resultSet.next()){
	    	fillDept = resultSet.getString("SYS_DATAOWNER");
	    }
	    resultSet.close();
	    statement.close();    	
	    if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS.indexOf(fillDept.toUpperCase()) >= 0){//变电公司
	    	//arg0.leaveNode(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS);
	    	//return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS;
	    	return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGSTmp;
	    } else if(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC.indexOf(fillDept.toUpperCase()) >= 0){//自动化运行处
	    	//arg0.leaveNode(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC);
	    	//return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC;
	    	return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXCTmp;
	    } else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD.indexOf(fillDept.toUpperCase()) >= 0){//区调
	    	//arg0.leaveNode(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD);
	    	return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsArea_SENTAREA;
	    	//return ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QDTmp;
	    }
	   return null;
	    
   }
  
	
}