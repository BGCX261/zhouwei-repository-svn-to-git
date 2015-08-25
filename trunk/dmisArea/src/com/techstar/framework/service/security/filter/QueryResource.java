package com.techstar.framework.service.security.filter;

import com.techstar.framework.service.security.modelin.Resource;
import com.techstar.framework.service.security.modelin.User;

public class QueryResource extends FilterBase {
	private  boolean ISRETURNATTR;

	private boolean ISRETURNCHILD;

	private User USER;

	private Resource RESOURCE;

	public boolean getISRETURNATTR() {
		return ISRETURNATTR;
	}

	public void setISRETURNATTR(boolean isreturnattr) {
		ISRETURNATTR = isreturnattr;
	}

	public boolean getISRETURNCHILD() {
		return ISRETURNCHILD;
	}

	public void setISRETURNCHILD(boolean isreturnchild) {
		ISRETURNCHILD = isreturnchild;
	}

	public Resource getRESOURCE() {
		return RESOURCE;
	}

	public void setRESOURCE(Resource resource) {
		RESOURCE = resource;
	}

	public User getUSER() {
		return USER;
	}

	public void setUSER(User user) {
		USER = user;
	}
}
