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
import com.techstar.dmis.dao.IBhMonthrepDao;
import com.techstar.dmis.entity.BhMonthrep;

public class BhMonthrepDaoImpl implements IBhMonthrepDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhMonthrep bhMonthrep){
		baseHbnDao.delete(bhMonthrep);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhMonthrep bhMonthrep) {
		baseHbnDao.saveOrUpdate("BhMonthrep", bhMonthrep);
	}

	public BhMonthrep findByPk(Object reportid) {
		return (BhMonthrep) baseHbnDao.findById(BhMonthrep.class, (Serializable) reportid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhMonthrep");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhMonthrep", beginPage, pageSize);
	}
	
	public void merge(BhMonthrep bhMonthrep){
    	baseHbnDao.merge("BhMonthrep", bhMonthrep);
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
