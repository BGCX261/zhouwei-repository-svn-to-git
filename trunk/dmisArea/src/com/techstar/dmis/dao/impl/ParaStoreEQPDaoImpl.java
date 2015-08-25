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
import com.techstar.dmis.dao.IParaStoreEQPDao;
import com.techstar.dmis.entity.ParaStoreEQP;

public class ParaStoreEQPDaoImpl implements IParaStoreEQPDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaStoreEQP paraStoreEQP){
		baseHbnDao.delete(paraStoreEQP);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaStoreEQP paraStoreEQP) {
		baseHbnDao.saveOrUpdate("ParaStoreEQP", paraStoreEQP);
	}

	public ParaStoreEQP findByPk(Object feqpid) {
		return (ParaStoreEQP) baseHbnDao.findById(ParaStoreEQP.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaStoreEQP");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaStoreEQP", beginPage, pageSize);
	}
	
	public void merge(ParaStoreEQP paraStoreEQP){
    	baseHbnDao.merge("ParaStoreEQP", paraStoreEQP);
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
