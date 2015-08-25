package com.techstar.framework.service.security.filter;

import java.util.List;

import com.techstar.framework.service.security.modelin.Role;
import com.techstar.framework.service.security.modelin.Unit;
import com.techstar.framework.service.security.modelin.User;

public class QueryUser extends FilterBase {
	private String RESOURCES_REF;

	private List RESOURCES;

	private Unit UNIT;

	private User USER;

	private Role ROLE;

	public List getRESOURCES() {
		return RESOURCES;
	}

	public void setRESOURCES(List resources) {
		RESOURCES = resources;
	}

	public String getRESOURCES_REF() {
		return RESOURCES_REF;
	}

	public void setRESOURCES_REF(String resources_ref) {
		RESOURCES_REF = resources_ref;
	}

	public Role getROLE() {
		return ROLE;
	}

	public void setROLE(Role role) {
		ROLE = role;
	}

	public Unit getUNIT() {
		return UNIT;
	}

	public void setUNIT(Unit unit) {
		UNIT = unit;
	}

	public User getUSER() {
		return USER;
	}

	public void setUSER(User user) {
		USER = user;
	}
	
}
