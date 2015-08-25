/**
 * 持久化对象数据操纵实现类
 * @author 
 * @date
 */
package com.techstar.dmis.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dao.IStdManufacturerDao;
import com.techstar.dmis.entity.StdManufacturer;

public class StdManufacturerDaoImpl implements IStdManufacturerDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdManufacturer stdManufacturer){
		baseHbnDao.delete(stdManufacturer);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(StdManufacturer stdManufacturer) {
		baseHbnDao.saveOrUpdate("StdManufacturer", stdManufacturer);
	}

	public StdManufacturer findByPk(Object id) {
		return (StdManufacturer) baseHbnDao.findById(StdManufacturer.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdManufacturer");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdManufacturer", beginPage, pageSize);
	}
	
	public void merge(StdManufacturer stdManufacturer){
    	baseHbnDao.merge("StdManufacturer", stdManufacturer);
    }
	
	public QueryListObj getQueryListByHql(String hql) {
		return baseHbnDao.getQueryListByHql(hql);
	}	

	public QueryListObj getQueryListByHql(String hql,int beginPage,int pageSize) {
		return baseHbnDao.getQueryListByHql(hql, beginPage, pageSize);
	}

	public List getObjPropertySums(String sql) {
		List result = new ArrayList();
		if(sql!=null && !"".equals(sql))
			result = baseHbnDao.queryList(sql);
		return result;
	}
    
	public void saveOrUpdateAll(Collection objs){
    	baseHbnDao.saveOrUpdateAll(objs);
    }
    
	public IBaseHbnDao getBaseHbnDao() {
		return baseHbnDao;
	}

	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}
}
