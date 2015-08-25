package com.techstar.framework.service.security.modelout;

public class UserOut {
	private String TOKEN;

	private String USERNAME;

	private String REALNAME;

	private String USERATTR;

	private String UNITID;

	private String UNITCODE;

	private String UNITNAME;

	private String FUllUNITNAME;

	public String getFUllUNITNAME() {
		return FUllUNITNAME;
	}

	public void setFUllUNITNAME(String ullUNITNAME) {
		FUllUNITNAME = ullUNITNAME;
	}

	public String getREALNAME() {
		return REALNAME;
	}

	public void setREALNAME(String realname) {
		REALNAME = realname;
	}

	public String getTOKEN() {
		return TOKEN;
	}

	public void setTOKEN(String token) {
		TOKEN = token;
	}

	public String getUNITCODE() {
		return UNITCODE;
	}

	public void setUNITCODE(String unitcode) {
		UNITCODE = unitcode;
	}

	public String getUNITID() {
		return UNITID;
	}

	public void setUNITID(String unitid) {
		UNITID = unitid;
	}

	public String getUNITNAME() {
		return UNITNAME;
	}

	public void setUNITNAME(String unitname) {
		UNITNAME = unitname;
	}

	public String getUSERATTR() {
		return USERATTR;
	}

	public void setUSERATTR(String userattr) {
		USERATTR = userattr;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String username) {
		USERNAME = username;
	}

}
