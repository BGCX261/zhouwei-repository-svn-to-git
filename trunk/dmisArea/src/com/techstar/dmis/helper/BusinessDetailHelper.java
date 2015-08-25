package com.techstar.dmis.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.util.DateUtil;
import com.techstar.dmis.util.StringUtil;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.service.security.modelout.RoleOut;
import com.techstar.framework.service.security.modelout.UnitOut;
import com.techstar.framework.service.security.modelout.UserOut;
/**
 * 业务公用信息处理类
 * 1、统一提供填报信息给各业务模块
 * @author yjb
 *
 */
public class BusinessDetailHelper {	
	public static BusinessDetailDto getBusDetailInfo(HttpServletRequest request){
		BusinessDetailDto bd = new BusinessDetailDto();
		
		UserProfile userP = (UserProfile) (request.getSession()
				.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));

		UserOut user = userP.getUser();
		UnitOut unit = userP.getUnit();
		//userP.get
		UnitOut datasUnit = userP.getUnitOfDatas();
		
		bd.setLoginName(userP.getUserName());
		bd.setUserId(userP.getUserName());
		bd.setUserName(user.getREALNAME());
		bd.setUserDeptId(unit.getUNITID());
		bd.setUserDeptCode(unit.getUNITCODE());
		bd.setUserDeptName(unit.getUNITNAME());
		bd.setDataOwnerId(datasUnit.getUNITID());
		//bd.setDataOwnerName(datasUnit.getUNITNAME());
		bd.setDataOwnerName(userP.getUnitOfDatas().getUNITNAME());
		
		List roles = userP.getRoles();
		String wfRoles = "";
		for(int i=0;i<roles.size();i++){
			RoleOut roleout = (RoleOut)roles.get(i);
			if(roleout.getTYPEID().equals("6002")){
				if(i==0) wfRoles = roleout.getROLENAME();
				else wfRoles = wfRoles+";"+roleout.getROLENAME();
			}
		}
		bd.setUserWFRoleNames(wfRoles); //工作流角色
		
		bd.setCurrentTime(DateUtil.getCurrentTimestamp());
		//设置当前时间
		java.sql.Date currentDate = DateUtil.stringToSqlDate(DateUtil.getCurrentTimestamp().toString());
		bd.setCurrentDate(currentDate);
		
		
		return bd;
	}
	
	/**
	 * 获取业务的正式编号
	 * @param busName  业务名称
	 * @return
	 */
	public static String genBusinessNumber(String buskey){
		try{
			
			int ivalue = 0;
			String busvalue =  SysFileHelper.getPropertyValue(buskey);
			String currentValue ="0";
			String currentMonth = "";
			
			if(busvalue!=null && !"".equals(busvalue)){
				currentValue = busvalue.substring(3);
				currentMonth = busvalue.substring(0,2);
			}
					
			//判断是否是月初
			if((DateUtil.isMonthBegin() && !currentMonth.equals(DateUtil.getCurrentMonth())) || busvalue==null || "".equals(busvalue)){
				ivalue = 0;
			}else{
				ivalue = Integer.parseInt(currentValue)+1;
			}

			if(!currentMonth.equals(DateUtil.getCurrentMonth())){
				currentMonth = DateUtil.getCurrentMonth();
			}
			
			//更新
			SysFileHelper.modPropertyValue(buskey, currentMonth+"-"+ivalue);
			
			//System.out.println( DateUtil.getCurrentYear()+DateUtil.getCurrentMonth()+StringUtil.getNumberStrWithZero(Integer.toString(ivalue),5,"0"));
			
			return getSystemName()+DateUtil.getCurrentYear()+DateUtil.getCurrentMonth()+StringUtil.getNumberStrWithZero(Integer.toString(ivalue),5,"0");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 获得当前系统名称
	 * @return
	 */
	public static String  getSystemName(){
		try{
			return SysFileHelper.getPropertyValue("SYSTEM_NAME");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获得数据所属单位
	 * @return
	 */
	public static String  getDataOwner(){
		try{
			return SysFileHelper.getPropertyValue("DATA_OWNER");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] str){
		System.out.println(BusinessDetailHelper.genBusinessNumber("kkk"));
	}	
}
