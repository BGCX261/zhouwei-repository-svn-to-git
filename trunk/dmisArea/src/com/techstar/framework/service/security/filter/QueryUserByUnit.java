package com.techstar.framework.service.security.filter;

import java.util.List;

public class QueryUserByUnit extends FilterBase {
	private String UNITS_REF;

	private List UNITS;

	public List getUNITS() {
		return UNITS;
	}

	public void setUNITS(List units) {
		UNITS = units;
	}

	public String getUNITS_REF() {
		return UNITS_REF;
	}

	public void setUNITS_REF(String units_ref) {
		UNITS_REF = units_ref;
	}

}
