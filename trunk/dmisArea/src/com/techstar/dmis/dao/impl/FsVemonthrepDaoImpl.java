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
import com.techstar.dmis.dao.IFsVemonthrepDao;
import com.techstar.dmis.entity.FsVemonthrep;

public class FsVemonthrepDaoImpl implements IFsVemonthrepDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsVemonthrep fsVemonthrep){
		baseHbnDao.delete(fsVemonthrep);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsVemonthrep fsVemonthrep) {
		baseHbnDao.saveOrUpdate("FsVemonthrep", fsVemonthrep);
	}

	public FsVemonthrep findByPk(Object repmonthid) {
		return (FsVemonthrep) baseHbnDao.findById(FsVemonthrep.class, (Serializable) repmonthid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsVemonthrep");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsVemonthrep", beginPage, pageSize);
	}
	
	public void merge(FsVemonthrep fsVemonthrep){
    	baseHbnDao.merge("FsVemonthrep", fsVemonthrep);
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
