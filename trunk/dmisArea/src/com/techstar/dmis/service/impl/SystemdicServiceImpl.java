package com.techstar.dmis.service.impl;

import java.util.List;

import com.techstar.dmis.dto.SystemdicDto;
import com.techstar.dmis.service.ISystemdicService;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.dmis.dao.ISystemdicDao;
public class SystemdicServiceImpl implements ISystemdicService{
	
	ISystemdicDao systemdicdao ;
	public QueryListObj listSystemticByHql(String hql) {
		QueryListObj obj = systemdicdao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(SystemdicDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	public void setSystemdicdao(ISystemdicDao systemdicdao) {
		this.systemdicdao = systemdicdao;
	}

}
