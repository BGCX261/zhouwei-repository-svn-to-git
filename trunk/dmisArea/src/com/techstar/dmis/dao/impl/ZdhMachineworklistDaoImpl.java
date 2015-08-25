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
import com.techstar.dmis.dao.IZdhMachineworklistDao;
import com.techstar.dmis.entity.ZdhMachineworklist;

public class ZdhMachineworklistDaoImpl implements IZdhMachineworklistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhMachineworklist zdhMachineworklist){
		baseHbnDao.delete(zdhMachineworklist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhMachineworklist zdhMachineworklist) {
		baseHbnDao.saveOrUpdate("ZdhMachineworklist", zdhMachineworklist);
	}

	public ZdhMachineworklist findByPk(Object jobid) {
		return (ZdhMachineworklist) baseHbnDao.findById(ZdhMachineworklist.class, (Serializable) jobid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhMachineworklist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhMachineworklist", beginPage, pageSize);
	}
	
	public void merge(ZdhMachineworklist zdhMachineworklist){
    	baseHbnDao.merge("ZdhMachineworklist", zdhMachineworklist);
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
