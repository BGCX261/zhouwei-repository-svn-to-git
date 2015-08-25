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
import com.techstar.dmis.dao.IBhFixedvaluetempDao;
import com.techstar.dmis.entity.BhFixedvaluetemp;

public class BhFixedvaluetempDaoImpl implements IBhFixedvaluetempDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhFixedvaluetemp bhFixedvaluetemp){
		baseHbnDao.delete(bhFixedvaluetemp);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhFixedvaluetemp bhFixedvaluetemp) {
		baseHbnDao.saveOrUpdate("BhFixedvaluetemp", bhFixedvaluetemp);
	}

	public BhFixedvaluetemp findByPk(Object ftempleteno) {
		return (BhFixedvaluetemp) baseHbnDao.findById(BhFixedvaluetemp.class, (Serializable) ftempleteno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhFixedvaluetemp");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhFixedvaluetemp", beginPage, pageSize);
	}
	
	public void merge(BhFixedvaluetemp bhFixedvaluetemp){
    	baseHbnDao.merge("BhFixedvaluetemp", bhFixedvaluetemp);
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
