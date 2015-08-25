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
import com.techstar.dmis.dao.IParaDryReactorDao;
import com.techstar.dmis.entity.ParaDryReactor;

public class ParaDryReactorDaoImpl implements IParaDryReactorDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaDryReactor paraDryReactor){
		baseHbnDao.delete(paraDryReactor);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaDryReactor paraDryReactor) {
		baseHbnDao.saveOrUpdate("ParaDryReactor", paraDryReactor);
	}

	public ParaDryReactor findByPk(Object feqpid) {
		return (ParaDryReactor) baseHbnDao.findById(ParaDryReactor.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaDryReactor");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaDryReactor", beginPage, pageSize);
	}
	
	public void merge(ParaDryReactor paraDryReactor){
    	baseHbnDao.merge("ParaDryReactor", paraDryReactor);
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
