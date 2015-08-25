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
import com.techstar.dmis.dao.IStdDdaccidentreasonDao;
import com.techstar.dmis.entity.StdDdaccidentreason;

public class StdDdaccidentreasonDaoImpl implements IStdDdaccidentreasonDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdDdaccidentreason stdDdaccidentreason){
		baseHbnDao.delete(stdDdaccidentreason);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(StdDdaccidentreason stdDdaccidentreason) {
		baseHbnDao.saveOrUpdate("StdDdaccidentreason", stdDdaccidentreason);
	}

	public StdDdaccidentreason findByPk(Object id) {
		return (StdDdaccidentreason) baseHbnDao.findById(StdDdaccidentreason.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdDdaccidentreason");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdDdaccidentreason", beginPage, pageSize);
	}
	
	public void merge(StdDdaccidentreason stdDdaccidentreason){
    	baseHbnDao.merge("StdDdaccidentreason", stdDdaccidentreason);
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
