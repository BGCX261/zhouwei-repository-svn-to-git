package com.techstar.framework.service.security.filter;

import com.techstar.framework.service.security.modelin.Resource;

public class EditResource extends FilterBase {
	private Resource RESOURCE;

	public Resource getRESOURCE() {
		return RESOURCE;
	}

	public void setRESOURCE(Resource resource) {
		RESOURCE = resource;
	}
}
