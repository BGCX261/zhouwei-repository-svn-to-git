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
import com.techstar.dmis.dao.IParaHISwitchDao;
import com.techstar.dmis.entity.ParaHISwitch;

public class ParaHISwitchDaoImpl implements IParaHISwitchDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaHISwitch paraHISwitch){
		baseHbnDao.delete(paraHISwitch);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaHISwitch paraHISwitch) {
		baseHbnDao.saveOrUpdate("ParaHISwitch", paraHISwitch);
	}

	public ParaHISwitch findByPk(Object feqpid) {
		return (ParaHISwitch) baseHbnDao.findById(ParaHISwitch.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaHISwitch");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaHISwitch", beginPage, pageSize);
	}
	
	public void merge(ParaHISwitch paraHISwitch){
    	baseHbnDao.merge("ParaHISwitch", paraHISwitch);
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
