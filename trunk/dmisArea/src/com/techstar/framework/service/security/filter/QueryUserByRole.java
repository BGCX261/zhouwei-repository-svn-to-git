package com.techstar.framework.service.security.filter;

import java.util.List;

public class QueryUserByRole extends FilterBase {
	private String ROLES_REF;

	private List ROLES;

	public String getROLES_REF() {
		return ROLES_REF;
	}

	public void setROLES_REF(String roles_ref) {
		ROLES_REF = roles_ref;
	}

	public List getROLES() {
		return ROLES;
	}

	public void setROLES(List roles) {
		ROLES = roles;
	}

}
