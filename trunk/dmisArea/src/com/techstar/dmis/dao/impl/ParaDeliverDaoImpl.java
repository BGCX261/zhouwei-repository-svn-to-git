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
import com.techstar.dmis.dao.IParaDeliverDao;
import com.techstar.dmis.entity.ParaDeliver;

public class ParaDeliverDaoImpl implements IParaDeliverDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaDeliver paraDeliver){
		baseHbnDao.delete(paraDeliver);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaDeliver paraDeliver) {
		baseHbnDao.saveOrUpdate("ParaDeliver", paraDeliver);
	}

	public ParaDeliver findByPk(Object feqpid) {
		return (ParaDeliver) baseHbnDao.findById(ParaDeliver.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaDeliver");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaDeliver", beginPage, pageSize);
	}
	
	public void merge(ParaDeliver paraDeliver){
    	baseHbnDao.merge("ParaDeliver", paraDeliver);
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
