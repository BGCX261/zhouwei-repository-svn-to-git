package com.techstar.dmis.web.facade;

import com.techstar.dmis.service.ISystemdicService;
import com.techstar.framework.dao.model.QueryListObj;

public class SystemdicFacade {
	ISystemdicService systemdicservice;
	public QueryListObj listSystemticByHql(String hql) {
		return systemdicservice.listSystemticByHql(hql);
	}
	public void setSystemdicservice(ISystemdicService systemdicservice) {
		this.systemdicservice = systemdicservice;
	}
}
