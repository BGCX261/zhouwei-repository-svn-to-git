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
import com.techstar.dmis.dao.IDdClassondutylogDao;
import com.techstar.dmis.entity.DdClassondutylog;

public class DdClassondutylogDaoImpl implements IDdClassondutylogDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdClassondutylog ddClassondutylog){
	baseHbnDao.delete(ddClassondutylog);
	}
	public void saveOrUpdate(DdClassondutylog ddClassondutylog) {
		baseHbnDao.saveOrUpdate("DdClassondutylog", ddClassondutylog);
	}

	public DdClassondutylog findByPk(Object fid) {
		return (DdClassondutylog) baseHbnDao.findById(DdClassondutylog.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdClassondutylog");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdClassondutylog", beginPage, pageSize);
	}
	
	public void merge(DdClassondutylog ddClassondutylog){
    	baseHbnDao.merge("DdClassondutylog", ddClassondutylog);
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
