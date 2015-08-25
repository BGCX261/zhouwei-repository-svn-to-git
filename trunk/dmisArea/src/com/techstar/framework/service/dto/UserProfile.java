package com.techstar.framework.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.techstar.framework.service.security.modelout.UnitOut;
import com.techstar.framework.service.security.modelout.UserOut;
import com.techstar.framework.service.security.SecurityContext;

public class UserProfile implements Serializable {
	public static final UserProfile ANONYMOUS = new UserProfile(
			SecurityContext.ANONYMOUS_ID, "anonymous");

	private String userName; // 用户登录名

	private String userPass; // 口令

	private UserOut user; // 用户信息

	private UnitOut unit; // 组织机构信息

	private List roles; // 角色数组(当前用户的所有角色)

	private List meun; // 资源菜单

	// private List permissionsList; // 当前人员所能操作的所有权限集合。    private UnitOut UnitOfDatas; //数据所属单位

	private String ip; // 当前登陆IP

	public UserProfile() {
		super();
	}

	public UserProfile(String id, String userName) {
		super();
		List actRoles = new ArrayList();
		actRoles.add(id);
		this.userName = userName;
	}

	public static UserProfile getANONYMOUS() {
		return ANONYMOUS;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public List getMeun() {
		return meun;
	}

	public void setMeun(List meun) {
		this.meun = meun;
	}

	public UnitOut getUnit() {
		return unit;
	}

	public void setUnit(UnitOut unit) {
		this.unit = unit;
	}

	public UserOut getUser() {
		return user;
	}

	public void setUser(UserOut user) {
		this.user = user;
	}

	public UnitOut getUnitOfDatas() {
		return UnitOfDatas;
	}

	public void setUnitOfDatas(UnitOut unitOfDatas) {
		UnitOfDatas = unitOfDatas;
	}



}
