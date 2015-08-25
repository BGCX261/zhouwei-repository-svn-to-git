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
import com.techstar.dmis.dao.IStdDispatchunitDao;
import com.techstar.dmis.entity.StdDispatchunit;

public class StdDispatchunitDaoImpl implements IStdDispatchunitDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdDispatchunit stdDispatchunit){
		baseHbnDao.delete(stdDispatchunit);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(StdDispatchunit stdDispatchunit) {
		baseHbnDao.saveOrUpdate("StdDispatchunit", stdDispatchunit);
	}

	public StdDispatchunit findByPk(Object id) {
		return (StdDispatchunit) baseHbnDao.findById(StdDispatchunit.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdDispatchunit");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdDispatchunit", beginPage, pageSize);
	}
	
	public void merge(StdDispatchunit stdDispatchunit){
    	baseHbnDao.merge("StdDispatchunit", stdDispatchunit);
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
