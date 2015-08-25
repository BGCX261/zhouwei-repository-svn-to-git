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
import com.techstar.dmis.dao.IFsYearlfplanDao;
import com.techstar.dmis.entity.FsYearlfplan;

public class FsYearlfplanDaoImpl implements IFsYearlfplanDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsYearlfplan fsYearlfplan){
		baseHbnDao.delete(fsYearlfplan);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsYearlfplan fsYearlfplan) {
		baseHbnDao.saveOrUpdate("FsYearlfplan", fsYearlfplan);
	}

	public FsYearlfplan findByPk(Object fprogramid) {
		return (FsYearlfplan) baseHbnDao.findById(FsYearlfplan.class, (Serializable) fprogramid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsYearlfplan");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsYearlfplan", beginPage, pageSize);
	}
	
	public void merge(FsYearlfplan fsYearlfplan){
    	baseHbnDao.merge("FsYearlfplan", fsYearlfplan);
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
