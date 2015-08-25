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
import com.techstar.dmis.dao.IBhAsregulateDao;
import com.techstar.dmis.entity.BhAsregulate;

public class BhAsregulateDaoImpl implements IBhAsregulateDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhAsregulate bhAsregulate){
		baseHbnDao.delete(bhAsregulate);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhAsregulate bhAsregulate) {
		baseHbnDao.saveOrUpdate("BhAsregulate", bhAsregulate);
	}

	public BhAsregulate findByPk(Object asregulateid) {
		return (BhAsregulate) baseHbnDao.findById(BhAsregulate.class, (Serializable) asregulateid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhAsregulate");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhAsregulate", beginPage, pageSize);
	}
	
	public void merge(BhAsregulate bhAsregulate){
    	baseHbnDao.merge("BhAsregulate", bhAsregulate);
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
