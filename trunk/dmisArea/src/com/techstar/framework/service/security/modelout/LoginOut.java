package com.techstar.framework.service.security.modelout;

public class LoginOut {
	private String ISVALID;

	private UserOut USERINFO;

	public String getISVALID() {
		return ISVALID;
	}

	public void setISVALID(String isvalid) {
		ISVALID = isvalid;
	}

	public UserOut getUSERINFO() {
		return USERINFO;
	}

	public void setUSERINFO(UserOut userinfo) {
		USERINFO = userinfo;
	}

}
