package com.techstar.framework.service.security.modelout;

public class UnitOut {
	private String UNITID;

	private String UNITNAME;

	private String PARENTID;

	private String UNITCODE;

	private int SORTNUMBER;

	private int UNITLEVEL;

	private String POWCODE;

	public String getPARENTID() {
		return PARENTID;
	}

	public void setPARENTID(String parentid) {
		PARENTID = parentid;
	}

	public String getPOWCODE() {
		return POWCODE;
	}

	public void setPOWCODE(String powcode) {
		POWCODE = powcode;
	}

	public int getSORTNUMBER() {
		return SORTNUMBER;
	}

	public void setSORTNUMBER(int sortnumber) {
		SORTNUMBER = sortnumber;
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

	public int getUNITLEVEL() {
		return UNITLEVEL;
	}

	public void setUNITLEVEL(int unitlevel) {
		UNITLEVEL = unitlevel;
	}

	public String getUNITNAME() {
		return UNITNAME;
	}

	public void setUNITNAME(String unitname) {
		UNITNAME = unitname;
	}

}
