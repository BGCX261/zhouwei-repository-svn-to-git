package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.IDdDayplanexcutelistDao;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.entity.DdDayondutylog;
import com.techstar.dmis.entity.DdDayplanexcutelist;
import com.techstar.dmis.entity.DdDoutageplan;
import com.techstar.dmis.service.IDdDayplanexcutelistService;
import org.springframework.dao.DataAccessException;

public class DdDayplanexcutelistServiceImpl implements IDdDayplanexcutelistService {
    
	private IDdDayplanexcutelistDao dao;
	public void setDao(IDdDayplanexcutelistDao dao){
		this.dao = dao;
	}
	public void addDdDayplanexcutelist(DdDayplanexcutelistDto dto) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDdDayplanexcutelist(String DdDayplanexcutelistId) {
		// TODO Auto-generated method stub
		
	}

	public QueryListObj getDdDayplanexcutelistByHql(String hql, int beginPage, int pageSize, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryListObj listDdDayplanexcutelist() {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryListObj listDdDayplanexcutelistByHql(String hql) {
		QueryListObj obj = dao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDayplanexcutelist.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public DdDayplanexcutelistDto loadDdDayplanexcutelist(String ddDayplanexcutelistId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdateDdDayplanexcutelist(DdDayplanexcutelistDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	  /**
	   *  保存更新日计划执行
	   */
	public void saveOrUpdateDdDayplanexcutelist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdDayplanexcutelistDto dto = (DdDayplanexcutelistDto)dtos.get(i);
			DdDayplanexcutelist entity = (DdDayplanexcutelist) BeanHelper.buildBean(DdDayplanexcutelist.class, dto);
		    pos.add(entity);
		}
		
		dao.saveOrUpdateAll(pos);	
		
	}

}
