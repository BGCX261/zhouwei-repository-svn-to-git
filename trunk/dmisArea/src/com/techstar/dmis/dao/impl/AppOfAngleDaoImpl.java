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
import com.techstar.dmis.dao.IAppOfAngleDao;
import com.techstar.dmis.entity.AppOfAngle;

public class AppOfAngleDaoImpl implements IAppOfAngleDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(AppOfAngle appOfAngle){
		baseHbnDao.delete(appOfAngle);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(AppOfAngle appOfAngle) {
		baseHbnDao.saveOrUpdate("AppOfAngle", appOfAngle);
	}

	public AppOfAngle findByPk(Object id) {
		return (AppOfAngle) baseHbnDao.findById(AppOfAngle.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("AppOfAngle");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("AppOfAngle", beginPage, pageSize);
	}
	
	public void merge(AppOfAngle appOfAngle){
    	baseHbnDao.merge("AppOfAngle", appOfAngle);
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
