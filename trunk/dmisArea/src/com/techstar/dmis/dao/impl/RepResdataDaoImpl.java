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
import com.techstar.dmis.dao.IRepResdataDao;
import com.techstar.dmis.entity.RepResdata;

public class RepResdataDaoImpl implements IRepResdataDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(RepResdata repResdata){
		baseHbnDao.delete(repResdata);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(RepResdata repResdata) {
		baseHbnDao.saveOrUpdate("RepResdata", repResdata);
	}

	public RepResdata findByPk(Object res_id) {
		return (RepResdata) baseHbnDao.findById(RepResdata.class, (Serializable) res_id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("RepResdata");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("RepResdata", beginPage, pageSize);
	}
	
	public void merge(RepResdata repResdata){
    	baseHbnDao.merge("RepResdata", repResdata);
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
