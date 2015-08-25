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
import com.techstar.dmis.dao.IParaParallReactorDao;
import com.techstar.dmis.entity.ParaParallReactor;

public class ParaParallReactorDaoImpl implements IParaParallReactorDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaParallReactor paraParallReactor){
		baseHbnDao.delete(paraParallReactor);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaParallReactor paraParallReactor) {
		baseHbnDao.saveOrUpdate("ParaParallReactor", paraParallReactor);
	}

	public ParaParallReactor findByPk(Object feqpid) {
		return (ParaParallReactor) baseHbnDao.findById(ParaParallReactor.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaParallReactor");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaParallReactor", beginPage, pageSize);
	}
	
	public void merge(ParaParallReactor paraParallReactor){
    	baseHbnDao.merge("ParaParallReactor", paraParallReactor);
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
