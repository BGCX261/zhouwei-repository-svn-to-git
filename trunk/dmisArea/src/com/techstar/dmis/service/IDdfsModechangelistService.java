package com.techstar.dmis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.entity.DdDayplandelaylist;
import com.techstar.dmis.entity.DdDayplanexcutelist;

public interface IDdfsModechangelistService {
	public QueryListObj listDdfsModechangelistByHql(String hql);
	public void saveOrUpdateDdfsModechangelist(List dtos);
	public void deleteDdfsModechangelist(String ddmid,int version);
	public void deleteDdfsModechangelists(List dtos);
	
	public QueryListObj listDdDayplanexcutelistByHql(String hql);
	public void saveOrUpdateDdDayplanexcutelist(List dtos) ;
	public void deleteDdDayplanexcutelists(List dtos);
	
	
//	计划延期
	public QueryListObj listDdDayplandelaylistByHql(String hql);
	public void saveOrUpdateDdDayplandelaylist(List dtos) ;
	
	public void deleteDdDayplandelaylist(List dtos);
}
