package com.techstar.dmis.service.impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.techstar.dmis.dao.IDdfsModechangelistDao;
import com.techstar.dmis.dao.IDdDayplanexcutelistDao;
import com.techstar.dmis.dao.IDdDayplandelaylistDao;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdDayplandelaylistDto;
import com.techstar.dmis.entity.DdDoutageplan;
import com.techstar.dmis.entity.DdfsModechangelist;
import com.techstar.dmis.entity.DdDayplanexcutelist;
import com.techstar.dmis.entity.DdDayplandelaylist;
import com.techstar.dmis.service.IDdfsModechangelistService;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
public class DdfsModechangelistServiceImpl implements IDdfsModechangelistService{
	
	private IDdfsModechangelistDao dao ;
	private IDdDayplanexcutelistDao dao2;
	private IDdDayplandelaylistDao dao3;

	public void setDao(IDdfsModechangelistDao dao) {
		this.dao = dao;
	}
	public void setDao2(IDdDayplanexcutelistDao dao2) {
		this.dao2 = dao2;
	}
	public void setDao3(IDdDayplandelaylistDao dao3) {
		this.dao3 = dao3;
	}
	public QueryListObj listDdfsModechangelistByHql(String hql){
		QueryListObj obj = dao.getQueryListByHql(hql);
		//DdfsModechangelist po =(DdfsModechangelist)obj.getElemList().get(0);
		//DdfsModechangelistDto dto =(DdfsModechangelistDto)BeanHelper.buildBean(DdfsModechangelistDto.class, po);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdfsModechangelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
			obj.setCount(dtos.size());
		}
		return obj;
	}

	public void saveOrUpdateDdfsModechangelist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdfsModechangelistDto dto = (DdfsModechangelistDto)dtos.get(i);
			DdfsModechangelist entity = (DdfsModechangelist) BeanHelper.mapBean(DdfsModechangelist.class, dto);
			if(StringUtils.isEmpty(entity.getFid()))
				entity.setFid(new SequenceCreator().getUID());
			entity.setZddfsmodechangelist5(null);
		    pos.add(entity);
		}
		dao.saveOrUpdateAll(pos);	
	}
	
	 //用于实现基本删除操作
	public void deleteDdfsModechangelist(String ddmid,int version) {
		DdfsModechangelist ddm = new DdfsModechangelist();
		ddm.setFid(ddmid);
		ddm.setVersion(version);
		dao.delete(ddm);
	}
	
	
	public void deleteDdfsModechangelists(List dtos){
		
		for(int i=0;i<dtos.size();i++){
			DdfsModechangelistDto dto = (DdfsModechangelistDto)dtos.get(i);
			DdfsModechangelist ddm = (DdfsModechangelist)BeanHelper.buildBean(DdfsModechangelist.class, dto);
			dao.delete(ddm);
		}
		
	}

	//日计划下令
	public QueryListObj listDdDayplanexcutelistByHql(String hql){
		QueryListObj obj = dao3.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdDayplanexcutelistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
			obj.setCount(dtos.size());
		}
		return obj;
	}

	public void saveOrUpdateDdDayplanexcutelist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdDayplanexcutelistDto dto = (DdDayplanexcutelistDto)dtos.get(i);
			DdDayplanexcutelist entity = (DdDayplanexcutelist) BeanHelper.mapBean(DdDayplanexcutelist.class, dto);
			if(StringUtils.isEmpty(entity.getFid()))
				entity.setFid(new SequenceCreator().getUID());
			//entity.setZddfsmodechangelist5(null);
		    pos.add(entity);
		}
		dao3.saveOrUpdateAll(pos);	
	}
	
	public void deleteDdDayplanexcutelists(List dtos){
			
			for(int i=0;i<dtos.size();i++){
				DdDayplanexcutelistDto dto = (DdDayplanexcutelistDto)dtos.get(i);
				DdDayplanexcutelist ddm = (DdDayplanexcutelist)BeanHelper.buildBean(DdDayplanexcutelist.class, dto);
				dao2.delete(ddm);
			}
			
	}
	
	//计划延期
	public QueryListObj listDdDayplandelaylistByHql(String hql){
		QueryListObj obj = dao3.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdDayplandelaylistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
			obj.setCount(dtos.size());
		}
		return obj;
	}

	public void saveOrUpdateDdDayplandelaylist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdDayplandelaylistDto dto = (DdDayplandelaylistDto)dtos.get(i);
			DdDayplandelaylist entity = (DdDayplandelaylist) BeanHelper.mapBean(DdDayplandelaylist.class, dto);
			if(StringUtils.isEmpty(entity.getFid()))
				entity.setFid(new SequenceCreator().getUID());
			//entity.setZddfsmodechangelist5(null);
		    pos.add(entity);
		}
		dao3.saveOrUpdateAll(pos);	
	}
	
	public void deleteDdDayplandelaylist(List dtos){
			for(int i=0;i<dtos.size();i++){
				DdDayplandelaylistDto dto = (DdDayplandelaylistDto)dtos.get(i);
				DdDayplandelaylist ddm = (DdDayplandelaylist)BeanHelper.buildBean(DdDayplandelaylist.class, dto);
				dao3.delete(ddm);
			}
			
	}
	
}
