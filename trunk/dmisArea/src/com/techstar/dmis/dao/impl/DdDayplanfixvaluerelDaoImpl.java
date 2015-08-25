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
import com.techstar.dmis.dao.IDdDayplanfixvaluerelDao;
import com.techstar.dmis.entity.DdDayplanfixvaluerel;

public class DdDayplanfixvaluerelDaoImpl implements IDdDayplanfixvaluerelDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdDayplanfixvaluerel ddDayplanfixvaluerel){
		baseHbnDao.delete(ddDayplanfixvaluerel);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdDayplanfixvaluerel ddDayplanfixvaluerel) {
		baseHbnDao.saveOrUpdate("DdDayplanfixvaluerel", ddDayplanfixvaluerel);
	}

	public DdDayplanfixvaluerel findByPk(Object frelid) {
		return (DdDayplanfixvaluerel) baseHbnDao.findById(DdDayplanfixvaluerel.class, (Serializable) frelid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdDayplanfixvaluerel");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdDayplanfixvaluerel", beginPage, pageSize);
	}
	
	public void merge(DdDayplanfixvaluerel ddDayplanfixvaluerel){
    	baseHbnDao.merge("DdDayplanfixvaluerel", ddDayplanfixvaluerel);
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
