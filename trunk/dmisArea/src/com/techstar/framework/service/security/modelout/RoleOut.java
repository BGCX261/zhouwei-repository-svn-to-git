package com.techstar.framework.service.security.modelout;

public class RoleOut {
	private String ROLENAME;

	private String ROLEID;
	
	private String TYPEID;
	
	private String GROUPID;

	public String getROLEID() {
		return ROLEID;
	}

	public void setROLEID(String roleid) {
		ROLEID = roleid;
	}

	public String getROLENAME() {
		return ROLENAME;
	}

	public void setROLENAME(String rolename) {
		ROLENAME = rolename;
	}

	public String getGROUPID() {
		return GROUPID;
	}

	public void setGROUPID(String groupid) {
		GROUPID = groupid;
	}

	public String getTYPEID() {
		return TYPEID;
	}

	public void setTYPEID(String typeid) {
		TYPEID = typeid;
	}


}
