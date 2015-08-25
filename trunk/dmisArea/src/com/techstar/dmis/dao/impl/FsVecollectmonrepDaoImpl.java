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
import com.techstar.dmis.dao.IFsVecollectmonrepDao;
import com.techstar.dmis.entity.FsVecollectmonrep;

public class FsVecollectmonrepDaoImpl implements IFsVecollectmonrepDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsVecollectmonrep fsVecollectmonrep){
		baseHbnDao.delete(fsVecollectmonrep);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsVecollectmonrep fsVecollectmonrep) {
		baseHbnDao.saveOrUpdate("FsVecollectmonrep", fsVecollectmonrep);
	}

	public FsVecollectmonrep findByPk(Object reportid) {
		return (FsVecollectmonrep) baseHbnDao.findById(FsVecollectmonrep.class, (Serializable) reportid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsVecollectmonrep");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsVecollectmonrep", beginPage, pageSize);
	}
	
	public void merge(FsVecollectmonrep fsVecollectmonrep){
    	baseHbnDao.merge("FsVecollectmonrep", fsVecollectmonrep);
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
