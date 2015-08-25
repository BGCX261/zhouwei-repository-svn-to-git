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
import com.techstar.dmis.dao.IDdCutoffdetaillistDao;
import com.techstar.dmis.entity.DdCutoffdetaillist;

public class DdCutoffdetaillistDaoImpl implements IDdCutoffdetaillistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdCutoffdetaillist ddCutoffdetaillist){
		baseHbnDao.delete(ddCutoffdetaillist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdCutoffdetaillist ddCutoffdetaillist) {
		baseHbnDao.saveOrUpdate("DdCutoffdetaillist", ddCutoffdetaillist);
	}

	public DdCutoffdetaillist findByPk(Object fdetailid) {
		return (DdCutoffdetaillist) baseHbnDao.findById(DdCutoffdetaillist.class, (Serializable) fdetailid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdCutoffdetaillist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdCutoffdetaillist", beginPage, pageSize);
	}
	
	public void merge(DdCutoffdetaillist ddCutoffdetaillist){
    	baseHbnDao.merge("DdCutoffdetaillist", ddCutoffdetaillist);
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
