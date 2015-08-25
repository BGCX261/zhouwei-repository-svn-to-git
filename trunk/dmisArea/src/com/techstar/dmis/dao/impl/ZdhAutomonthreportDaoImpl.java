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
import com.techstar.dmis.dao.IZdhAutomonthreportDao;
import com.techstar.dmis.entity.ZdhAutomonthreport;

public class ZdhAutomonthreportDaoImpl implements IZdhAutomonthreportDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhAutomonthreport zdhAutomonthreport){
		baseHbnDao.delete(zdhAutomonthreport);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhAutomonthreport zdhAutomonthreport) {
		baseHbnDao.saveOrUpdate("ZdhAutomonthreport", zdhAutomonthreport);
	}

	public ZdhAutomonthreport findByPk(Object reportid) {
		return (ZdhAutomonthreport) baseHbnDao.findById(ZdhAutomonthreport.class, (Serializable) reportid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhAutomonthreport");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhAutomonthreport", beginPage, pageSize);
	}
	
	public void merge(ZdhAutomonthreport zdhAutomonthreport){
    	baseHbnDao.merge("ZdhAutomonthreport", zdhAutomonthreport);
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
