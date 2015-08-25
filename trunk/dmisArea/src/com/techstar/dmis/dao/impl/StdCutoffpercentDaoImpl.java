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
import com.techstar.dmis.dao.IStdCutoffpercentDao;
import com.techstar.dmis.entity.StdCutoffpercent;

public class StdCutoffpercentDaoImpl implements IStdCutoffpercentDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdCutoffpercent stdCutoffpercent){
		baseHbnDao.delete(stdCutoffpercent);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(StdCutoffpercent stdCutoffpercent) {
		baseHbnDao.saveOrUpdate("StdCutoffpercent", stdCutoffpercent);
	}

	public StdCutoffpercent findByPk(Object id) {
		return (StdCutoffpercent) baseHbnDao.findById(StdCutoffpercent.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdCutoffpercent");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdCutoffpercent", beginPage, pageSize);
	}
	
	public void merge(StdCutoffpercent stdCutoffpercent){
    	baseHbnDao.merge("StdCutoffpercent", stdCutoffpercent);
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
