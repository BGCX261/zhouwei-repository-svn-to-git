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
import com.techstar.dmis.dao.IBhFaultlistDao;
import com.techstar.dmis.entity.BhFaultlist;

public class BhFaultlistDaoImpl implements IBhFaultlistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhFaultlist bhFaultlist){
		baseHbnDao.delete(bhFaultlist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhFaultlist bhFaultlist) {
		baseHbnDao.saveOrUpdate("BhFaultlist", bhFaultlist);
	}

	public BhFaultlist findByPk(Object ffaultno) {
		return (BhFaultlist) baseHbnDao.findById(BhFaultlist.class, (Serializable) ffaultno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhFaultlist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhFaultlist", beginPage, pageSize);
	}
	
	public void merge(BhFaultlist bhFaultlist){
    	baseHbnDao.merge("BhFaultlist", bhFaultlist);
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
