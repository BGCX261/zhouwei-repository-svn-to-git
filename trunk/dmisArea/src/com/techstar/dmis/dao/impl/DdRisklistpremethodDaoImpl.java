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
import com.techstar.dmis.dao.IDdRisklistpremethodDao;
import com.techstar.dmis.entity.DdRisklistpremethod;

public class DdRisklistpremethodDaoImpl implements IDdRisklistpremethodDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdRisklistpremethod ddRisklistpremethod){
	baseHbnDao.delete(ddRisklistpremethod);
	}
	public void saveOrUpdate(DdRisklistpremethod ddRisklistpremethod) {
		baseHbnDao.saveOrUpdate("DdRisklistpremethod", ddRisklistpremethod);
	}

	public DdRisklistpremethod findByPk(Object fpremethodid) {
		return (DdRisklistpremethod) baseHbnDao.findById(DdRisklistpremethod.class, (Serializable) fpremethodid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdRisklistpremethod");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdRisklistpremethod", beginPage, pageSize);
	}
	
	public void merge(DdRisklistpremethod ddRisklistpremethod){
    	baseHbnDao.merge("DdRisklistpremethod", ddRisklistpremethod);
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
