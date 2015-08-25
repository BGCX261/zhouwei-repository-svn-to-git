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
import com.techstar.dmis.dao.IDdDispatcherDao;
import com.techstar.dmis.entity.DdDispatcher;

public class DdDispatcherDaoImpl implements IDdDispatcherDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdDispatcher ddDispatcher){
		baseHbnDao.delete(ddDispatcher);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdDispatcher ddDispatcher) {
		baseHbnDao.saveOrUpdate("DdDispatcher", ddDispatcher);
	}

	public DdDispatcher findByPk(Object id) {
		return (DdDispatcher) baseHbnDao.findById(DdDispatcher.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdDispatcher");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdDispatcher", beginPage, pageSize);
	}
	
	public void merge(DdDispatcher ddDispatcher){
    	baseHbnDao.merge("DdDispatcher", ddDispatcher);
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
