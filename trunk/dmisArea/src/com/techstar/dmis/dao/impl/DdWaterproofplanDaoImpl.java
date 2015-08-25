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
import com.techstar.dmis.dao.IDdWaterproofplanDao;
import com.techstar.dmis.entity.DdWaterproofplan;

public class DdWaterproofplanDaoImpl implements IDdWaterproofplanDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdWaterproofplan ddWaterproofplan){
	baseHbnDao.delete(ddWaterproofplan);
	}
	public void saveOrUpdate(DdWaterproofplan ddWaterproofplan) {
		baseHbnDao.saveOrUpdate("DdWaterproofplan", ddWaterproofplan);
	}

	public DdWaterproofplan findByPk(Object fid) {
		return (DdWaterproofplan) baseHbnDao.findById(DdWaterproofplan.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdWaterproofplan");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdWaterproofplan", beginPage, pageSize);
	}
	
	public void merge(DdWaterproofplan ddWaterproofplan){
    	baseHbnDao.merge("DdWaterproofplan", ddWaterproofplan);
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
