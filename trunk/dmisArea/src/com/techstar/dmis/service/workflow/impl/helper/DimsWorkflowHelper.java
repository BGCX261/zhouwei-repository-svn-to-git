package com.techstar.dmis.service.workflow.impl.helper;

import java.util.ArrayList;
import java.util.List;

import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.service.security.filter.QueryUserByRole;
import com.techstar.framework.service.security.modelin.Role;
import com.techstar.framework.service.security.modelout.UserOut;


public class DimsWorkflowHelper {

	public static String[] getCurrentUsers(String taskRoles,String agencyUsers) throws Exception{
		//try{
    	String[] currentUserIds = null;
    	
	    if(agencyUsers!=null && agencyUsers.trim().length()>0 && !"0".equals(agencyUsers)){ //走代理人员
	    	currentUserIds = agencyUsers.split(";");
	 
	    }else{
	    	System.out.println("++++++++++++++++++++++++++++++++999999999999999999999999");
	    	
	    	System.out.println("++++++++++++++++++++++++++++++++"+taskRoles);
	    	System.out.println("++++++++++++++++++++++++++++++++999999999999999999999999");
	    	ArrayList roleList = new ArrayList();
	    	String[] taskRoleArrays = taskRoles.split(";");
	    	for(int i=0;i<taskRoleArrays.length;i++){
	    		Role role = new Role();
	    		role.setOPER_TYPE("equal");
	    		role.setROLENAME(taskRoleArrays[i]);
	    		roleList.add(role);
	    	}
	    	
	    	
			ISecurityService securityService  = (ISecurityService)ServiceLocator.getInstance().getService("iSecurityService");
			
			QueryUserByRole queryUserByRole = new QueryUserByRole();
			
			queryUserByRole.setROLES(roleList);
////			根据角色取道用户信息
			queryUserByRole.setROLES_REF("or");
			List userList = securityService.queryUserByRole(queryUserByRole);
//			List userList = new ArrayList();
//			userList.add("ddd");
			
			currentUserIds = new String[userList.size()];	    
			for(int i=0;i<userList.size();i++){
				UserOut userOut = (UserOut)userList.get(i);
				currentUserIds[i]=userOut.getUSERNAME();
			}	
			//currentUserIds[0]="ddd";
	    }		
        
		return currentUserIds;
	}
	
}
