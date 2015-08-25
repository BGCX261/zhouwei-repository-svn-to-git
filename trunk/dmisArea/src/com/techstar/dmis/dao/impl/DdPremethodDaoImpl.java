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
import com.techstar.dmis.dao.IDdPremethodDao;
import com.techstar.dmis.entity.DdPremethod;

public class DdPremethodDaoImpl implements IDdPremethodDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdPremethod ddPremethod){
		baseHbnDao.delete(ddPremethod);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdPremethod ddPremethod) {
		baseHbnDao.saveOrUpdate("DdPremethod", ddPremethod);
	}

	public DdPremethod findByPk(Object fpremethodid) {
		return (DdPremethod) baseHbnDao.findById(DdPremethod.class, (Serializable) fpremethodid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdPremethod");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdPremethod", beginPage, pageSize);
	}
	
	public void merge(DdPremethod ddPremethod){
    	baseHbnDao.merge("DdPremethod", ddPremethod);
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
