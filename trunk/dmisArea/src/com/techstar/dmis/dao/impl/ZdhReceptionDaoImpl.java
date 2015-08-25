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
import com.techstar.dmis.dao.IZdhReceptionDao;
import com.techstar.dmis.entity.ZdhReception;

public class ZdhReceptionDaoImpl implements IZdhReceptionDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhReception zdhReception){
		baseHbnDao.delete(zdhReception);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhReception zdhReception) {
		baseHbnDao.saveOrUpdate("ZdhReception", zdhReception);
	}

	public ZdhReception findByPk(Object fapplicationid) {
		return (ZdhReception) baseHbnDao.findById(ZdhReception.class, (Serializable) fapplicationid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhReception");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhReception", beginPage, pageSize);
	}
	
	public void merge(ZdhReception zdhReception){
    	baseHbnDao.merge("ZdhReception", zdhReception);
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
