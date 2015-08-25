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
import com.techstar.dmis.dao.IDdWaterheightDao;
import com.techstar.dmis.entity.DdWaterheight;

public class DdWaterheightDaoImpl implements IDdWaterheightDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdWaterheight ddWaterheight){
		baseHbnDao.delete(ddWaterheight);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdWaterheight ddWaterheight) {
		baseHbnDao.saveOrUpdate("DdWaterheight", ddWaterheight);
	}

	public DdWaterheight findByPk(Object fid) {
		return (DdWaterheight) baseHbnDao.findById(DdWaterheight.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdWaterheight");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdWaterheight", beginPage, pageSize);
	}
	
	public void merge(DdWaterheight ddWaterheight){
    	baseHbnDao.merge("DdWaterheight", ddWaterheight);
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
