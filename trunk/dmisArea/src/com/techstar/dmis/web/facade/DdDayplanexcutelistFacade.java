package com.techstar.dmis.web.facade;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdDayplanexcutelistService;
public class DdDayplanexcutelistFacade {
	
	private IDdDayplanexcutelistService service;
	public  void setService(IDdDayplanexcutelistService s){
		this.service = s;
	}
    
	public void saveOrUpdateDayplanexcutelisdto(List dtos){
		service.saveOrUpdateDdDayplanexcutelist(dtos);
	}
	
	
	public QueryListObj listDdDayplanexcutelistByHql(String hql){
		return service.listDdDayplanexcutelistByHql(hql);
	}
}
