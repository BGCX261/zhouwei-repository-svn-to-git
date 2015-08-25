package com.techstar.framework.service.security.modelout;

import java.util.List;

public class ResourceOut {

	private String RESOURCEID;

	private String PERMID;

	private String PERMPARENTID;

	private String RESOURCENAME;

	private String RESOURCETYPE;

	private String DESC;

	private List RESOURCEATTRS;

	public String getDESC() {
		return DESC;
	}

	public void setDESC(String desc) {
		DESC = desc;
	}

	public String getPERMID() {
		return PERMID;
	}

	public void setPERMID(String permid) {
		PERMID = permid;
	}

	public String getPERMPARENTID() {
		return PERMPARENTID;
	}

	public void setPERMPARENTID(String permparentid) {
		PERMPARENTID = permparentid;
	}

	public List getRESOURCEATTRS() {
		return RESOURCEATTRS;
	}

	public void setRESOURCEATTRS(List resourceattrs) {
		RESOURCEATTRS = resourceattrs;
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

	public String getRESOURCETYPE() {
		return RESOURCETYPE;
	}

	public void setRESOURCETYPE(String resourcetype) {
		RESOURCETYPE = resourcetype;
	}


}
