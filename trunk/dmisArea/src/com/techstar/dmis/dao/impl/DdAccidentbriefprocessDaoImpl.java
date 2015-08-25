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
import com.techstar.dmis.dao.IDdAccidentbriefprocessDao;
import com.techstar.dmis.entity.DdAccidentbriefprocess;

public class DdAccidentbriefprocessDaoImpl implements IDdAccidentbriefprocessDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdAccidentbriefprocess ddAccidentbriefprocess){
		baseHbnDao.delete(ddAccidentbriefprocess);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdAccidentbriefprocess ddAccidentbriefprocess) {
		baseHbnDao.saveOrUpdate("DdAccidentbriefprocess", ddAccidentbriefprocess);
	}

	public DdAccidentbriefprocess findByPk(Object fstepid) {
		return (DdAccidentbriefprocess) baseHbnDao.findById(DdAccidentbriefprocess.class, (Serializable) fstepid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdAccidentbriefprocess");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdAccidentbriefprocess", beginPage, pageSize);
	}
	
	public void merge(DdAccidentbriefprocess ddAccidentbriefprocess){
    	baseHbnDao.merge("DdAccidentbriefprocess", ddAccidentbriefprocess);
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
