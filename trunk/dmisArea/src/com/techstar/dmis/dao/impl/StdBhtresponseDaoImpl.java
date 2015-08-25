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
import com.techstar.dmis.dao.IStdBhtresponseDao;
import com.techstar.dmis.entity.StdBhtresponse;

public class StdBhtresponseDaoImpl implements IStdBhtresponseDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdBhtresponse stdBhtresponse){
		baseHbnDao.delete(stdBhtresponse);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(StdBhtresponse stdBhtresponse) {
		baseHbnDao.saveOrUpdate("StdBhtresponse", stdBhtresponse);
	}

	public StdBhtresponse findByPk(Object id) {
		return (StdBhtresponse) baseHbnDao.findById(StdBhtresponse.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdBhtresponse");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdBhtresponse", beginPage, pageSize);
	}
	
	public void merge(StdBhtresponse stdBhtresponse){
    	baseHbnDao.merge("StdBhtresponse", stdBhtresponse);
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
