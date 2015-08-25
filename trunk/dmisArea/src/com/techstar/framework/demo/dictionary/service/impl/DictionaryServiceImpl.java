package com.techstar.framework.demo.dictionary.service.impl;

import java.io.Serializable;
import java.util.List;

import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.dictionary.service.IDictionaryService;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.ReflectObjectHelper;

/**
 * 字典服务实现类
 * @author xcf  Nov 22, 2006 1:16:24 PM
 */
public class DictionaryServiceImpl implements IDictionaryService {
	/**
	 * 数据库操纵对象
	 */
	private IBaseHbnDao baseHbnDao;
	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}
	
	public boolean deleteById(String poName ,Object id) {
		// TODO Auto-generated method stub
			Object entity = baseHbnDao.findById(ReflectObjectHelper.getPoClassByFullname(poName), (Serializable)id);
			if( entity == null ) return false;
			baseHbnDao.delete(entity);
			return true;
	}

	
	public Object findById(String poName ,Object id)  {
		// TODO Auto-generated method stub			
			String dtoName = ReflectObjectHelper.transferName(poName , true);
			Object po = baseHbnDao.findById(ReflectObjectHelper.getPoClassByFullname(poName), (Serializable)id);
			Object dto = BeanHelper.buildBean(ReflectObjectHelper.getDtoClassByFullname(dtoName), po);
			return dto;
	}

	
	public QueryListObj getQueryList(String poName) {
		// TODO Auto-generated method stub
		String dtoName = ReflectObjectHelper.transferName(poName , true);
		QueryListObj listObj = baseHbnDao.getQueryListByEntityName(poName);
		listObj = transToDtolist(ReflectObjectHelper.getDtoClassByFullname(dtoName) , listObj);
		return listObj;
	}

	
	public QueryListObj getQueryList(String poName, int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		String dtoName = ReflectObjectHelper.transferName(poName , true);
		QueryListObj listObj = baseHbnDao.getQueryListByEntityName(poName , beginPage , pageSize);
		listObj = transToDtolist(ReflectObjectHelper.getDtoClassByFullname(dtoName) , listObj);
		return listObj;
	}

	
	public Object saveOrUpdate(String poName, Object dtoObj) {
		// TODO Auto-generated method stub
		
		Object poobj =  BeanHelper.buildBean(ReflectObjectHelper.getPoClassByFullname(poName), dtoObj);
		baseHbnDao.saveOrUpdate(poName, poobj);
		return dtoObj;
	}

	

	/**
	 * 将po实体集合转换成dto实体集合
	 * @return QueryListObj
	 */
	private QueryListObj transToDtolist(Class dtoClass , QueryListObj obj) {		
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(dtoClass, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
}
