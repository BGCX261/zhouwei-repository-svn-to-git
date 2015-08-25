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
import com.techstar.dmis.dao.IStdZdhfaulttypeDao;
import com.techstar.dmis.entity.StdZdhfaulttype;

public class StdZdhfaulttypeDaoImpl implements IStdZdhfaulttypeDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdZdhfaulttype stdZdhfaulttype){
	baseHbnDao.delete(stdZdhfaulttype);
	}
	public void saveOrUpdate(StdZdhfaulttype stdZdhfaulttype) {
		baseHbnDao.saveOrUpdate("StdZdhfaulttype", stdZdhfaulttype);
	}

	public StdZdhfaulttype findByPk(Object faulttypeid) {
		return (StdZdhfaulttype) baseHbnDao.findById(StdZdhfaulttype.class, (Serializable) faulttypeid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdZdhfaulttype");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdZdhfaulttype", beginPage, pageSize);
	}
	
	public void merge(StdZdhfaulttype stdZdhfaulttype){
    	baseHbnDao.merge("StdZdhfaulttype", stdZdhfaulttype);
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
