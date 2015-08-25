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
import com.techstar.dmis.dao.IDdEnsuringpsmanageDao;
import com.techstar.dmis.entity.DdEnsuringpsmanage;

public class DdEnsuringpsmanageDaoImpl implements IDdEnsuringpsmanageDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdEnsuringpsmanage ddEnsuringpsmanage){
		baseHbnDao.delete(ddEnsuringpsmanage);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdEnsuringpsmanage ddEnsuringpsmanage) {
		baseHbnDao.saveOrUpdate("DdEnsuringpsmanage", ddEnsuringpsmanage);
	}

	public DdEnsuringpsmanage findByPk(Object fid) {
		return (DdEnsuringpsmanage) baseHbnDao.findById(DdEnsuringpsmanage.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdEnsuringpsmanage");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdEnsuringpsmanage", beginPage, pageSize);
	}
	
	public void merge(DdEnsuringpsmanage ddEnsuringpsmanage){
    	baseHbnDao.merge("DdEnsuringpsmanage", ddEnsuringpsmanage);
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
