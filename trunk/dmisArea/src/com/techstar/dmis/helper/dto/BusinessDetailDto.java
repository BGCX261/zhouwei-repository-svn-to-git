package com.techstar.dmis.helper.dto;

import java.sql.Timestamp;
import java.sql.Date;

public class BusinessDetailDto {

	String loginName;  			//用户登录名
	String userId;  			//用户ID
	String userName;			//用户名称
	Timestamp currentTime;			//当前时间
	Date currentDate;            //当前日期
	String userDeptId;			//用户部门ID
	String userDeptCode;		//用户部门CODE
	String userDeptName;		//用户部门名称
	String dataOwnerId;			//数据所属单位ID
	String dataOwnerName;		//数据所属单位名称	
	//String userRoleId;			//用户角色Id
	//String userRoleName;		//用户角色名称;
	String userWFRoleNames; 	//工作流岗位角色
	

	public String getDataOwnerId() {
		return dataOwnerId;
	}
	public void setDataOwnerId(String dataOwnerId) {
		this.dataOwnerId = dataOwnerId;
	}
	public String getDataOwnerName() {
		return dataOwnerName;
	}
	public void setDataOwnerName(String dataOwnerName) {
		this.dataOwnerName = dataOwnerName;
	}
	public String getUserDeptId() {
		return userDeptId;
	}
	public void setUserDeptId(String userDeptId) {
		this.userDeptId = userDeptId;
	}
	public String getUserDeptName() {
		return userDeptName;
	}
	public void setUserDeptName(String userDeptName) {
		this.userDeptName = userDeptName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserDeptCode() {
		return userDeptCode;
	}
	public void setUserDeptCode(String userDeptCode) {
		this.userDeptCode = userDeptCode;
	}
	public Timestamp getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getUserWFRoleNames() {
		return userWFRoleNames;
	}
	public void setUserWFRoleNames(String userWFRoleNames) {
		this.userWFRoleNames = userWFRoleNames;
	}
	
	
}
