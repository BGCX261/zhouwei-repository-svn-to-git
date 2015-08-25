package com.techstar.framework.service.security.modelin;

import java.util.List;

public class Resource {

	private String OPER_TYPE;

	private String RESOURCEID;

	private String RESOURCENAME;

	private String DESC;

	private String RESOURCETYPE;

	private String RESOURCEPID;

	private String SOURID;

	private String DESTID;

	private String RESOURCEATTRS_REF;

	private List RESOURCEATTRS;

	public String getDESC() {
		return DESC;
	}

	public void setDESC(String desc) {
		DESC = desc;
	}

	public String getDESTID() {
		return DESTID;
	}

	public void setDESTID(String destid) {
		DESTID = destid;
	}

	public String getOPER_TYPE() {
		return OPER_TYPE;
	}

	public void setOPER_TYPE(String oper_type) {
		OPER_TYPE = oper_type;
	}

	public List getRESOURCEATTRS() {
		return RESOURCEATTRS;
	}

	public void setRESOURCEATTRS(List resourceattrs) {
		RESOURCEATTRS = resourceattrs;
	}

	public String getRESOURCEATTRS_REF() {
		return RESOURCEATTRS_REF;
	}

	public void setRESOURCEATTRS_REF(String resourceattrs_ref) {
		RESOURCEATTRS_REF = resourceattrs_ref;
	}

	public String getRESOURCEID() {
		return RESOURCEID;
	}

	public void setRESOURCEID(String resourceid) {
		RESOURCEID = resourceid;
	}

	public String getRESOURCENAME() {
		return RESOURCENAME;
	}

	public void setRESOURCENAME(String resourcename) {
		RESOURCENAME = resourcename;
	}

	public String getRESOURCEPID() {
		return RESOURCEPID;
	}

	public void setRESOURCEPID(String resourcepid) {
		RESOURCEPID = resourcepid;
	}

	public String getRESOURCETYPE() {
		return RESOURCETYPE;
	}

	public void setRESOURCETYPE(String resourcetype) {
		RESOURCETYPE = resourcetype;
	}

	public String getSOURID() {
		return SOURID;
	}

	public void setSOURID(String sourid) {
		SOURID = sourid;
	}

}
