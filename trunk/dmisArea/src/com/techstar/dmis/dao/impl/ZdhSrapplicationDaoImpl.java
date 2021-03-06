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
import com.techstar.dmis.dao.IZdhSrapplicationDao;
import com.techstar.dmis.entity.ZdhSrapplication;

public class ZdhSrapplicationDaoImpl implements IZdhSrapplicationDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhSrapplication zdhSrapplication){
		baseHbnDao.delete(zdhSrapplication);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhSrapplication zdhSrapplication) {
		baseHbnDao.saveOrUpdate("ZdhSrapplication", zdhSrapplication);
	}

	public ZdhSrapplication findByPk(Object fapplicationno) {
		return (ZdhSrapplication) baseHbnDao.findById(ZdhSrapplication.class, (Serializable) fapplicationno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhSrapplication");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhSrapplication", beginPage, pageSize);
	}
	
	public void merge(ZdhSrapplication zdhSrapplication){
    	baseHbnDao.merge("ZdhSrapplication", zdhSrapplication);
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
