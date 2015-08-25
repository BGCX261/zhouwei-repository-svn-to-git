package com.techstar.griddemo.service.impl;

import java.io.Serializable;
import java.util.List;

import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.griddemo.service.IDictionaryService;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.ReflectObjectHelper;
//please add your business methods start
	// to do it
//add your business method end

/**
 * 字典服务接口类
 * @author 
 * @date
 */
public class DictionaryServiceImpl implements IDictionaryService {
	
	private IBaseHbnDao baseHbnDao;
	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}
	/**
	 * 删除实体
	 */
	public boolean deleteById(String poName ,Object id) {
		// TODO Auto-generated method stub
			Object entity = baseHbnDao.findById(ReflectObjectHelper.getPoClassByFullname(poName), (Serializable)id);
			if( entity == null ) return false;
			baseHbnDao.delete(entity);
			return true;
	}

	/**
	 * 根据实体类型及实体主键得到实体对象
	 * */

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
	//please add your business methods start
	// to do it
    //add your business method end
	
}
