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
import com.techstar.dmis.dao.IBhAsregulatedetailDao;
import com.techstar.dmis.entity.BhAsregulatedetail;

public class BhAsregulatedetailDaoImpl implements IBhAsregulatedetailDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhAsregulatedetail bhAsregulatedetail){
		baseHbnDao.delete(bhAsregulatedetail);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhAsregulatedetail bhAsregulatedetail) {
		baseHbnDao.saveOrUpdate("BhAsregulatedetail", bhAsregulatedetail);
	}

	public BhAsregulatedetail findByPk(Object asregulatedetailid) {
		return (BhAsregulatedetail) baseHbnDao.findById(BhAsregulatedetail.class, (Serializable) asregulatedetailid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhAsregulatedetail");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhAsregulatedetail", beginPage, pageSize);
	}
	
	public void merge(BhAsregulatedetail bhAsregulatedetail){
    	baseHbnDao.merge("BhAsregulatedetail", bhAsregulatedetail);
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
