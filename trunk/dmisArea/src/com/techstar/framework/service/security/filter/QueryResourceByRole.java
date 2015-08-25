package com.techstar.framework.service.security.filter;

import java.util.List;

public class QueryResourceByRole extends FilterBase {
	private boolean ISRETURNATTR;

	private String ROLES_REF;

	private List ROLES;

	public boolean getISRETURNATTR() {
		return ISRETURNATTR;
	}

	public void setISRETURNATTR(boolean isreturnattr) {
		ISRETURNATTR = isreturnattr;
	}

	public List getROLES() {
		return ROLES;
	}

	public void setROLES(List roles) {
		ROLES = roles;
	}

	public String getROLES_REF() {
		return ROLES_REF;
	}

	public void setROLES_REF(String roles_ref) {
		ROLES_REF = roles_ref;
	}

}
