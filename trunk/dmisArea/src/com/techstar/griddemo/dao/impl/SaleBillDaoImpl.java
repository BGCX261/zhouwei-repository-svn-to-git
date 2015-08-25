/**
 * 持久化对象数据操纵实现类
 * @author 
 * @date
 */
package com.techstar.griddemo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.griddemo.dao.ISaleBillDao;
import com.techstar.griddemo.entity.SaleBill;

public class SaleBillDaoImpl implements ISaleBillDao {
	
	private IBaseHbnDao baseHbnDao;
	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}
	private IBaseJdbcDao baseJdbcDao;
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	} 
    
    public void delete(SaleBill saleBill){
    	baseHbnDao.delete(saleBill);
	}    
    
    public void saveOrUpdateAll(Collection objs){
    	baseHbnDao.saveOrUpdateAll(objs);
    }
    public void merge(SaleBill saleBill){
    	baseHbnDao.merge("SaleBill", saleBill);
    }
	public void saveOrUpdate(SaleBill saleBill) {
		baseHbnDao.saveOrUpdate("SaleBill", saleBill);
	}

	public SaleBill findByPk(Object id) {
		return (SaleBill) baseHbnDao.findById(SaleBill.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("SaleBill");
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
	
}
