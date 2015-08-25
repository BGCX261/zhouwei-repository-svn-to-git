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
import com.techstar.dmis.dao.IZdhWorkbillDao;
import com.techstar.dmis.entity.ZdhWorkbill;

public class ZdhWorkbillDaoImpl implements IZdhWorkbillDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhWorkbill zdhWorkbill){
		baseHbnDao.delete(zdhWorkbill);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhWorkbill zdhWorkbill) {
		baseHbnDao.saveOrUpdate("ZdhWorkbill", zdhWorkbill);
	}

	public ZdhWorkbill findByPk(Object workbillid) {
		return (ZdhWorkbill) baseHbnDao.findById(ZdhWorkbill.class, (Serializable) workbillid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhWorkbill");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhWorkbill", beginPage, pageSize);
	}
	
	public void merge(ZdhWorkbill zdhWorkbill){
    	baseHbnDao.merge("ZdhWorkbill", zdhWorkbill);
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
