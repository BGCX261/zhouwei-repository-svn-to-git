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
import com.techstar.dmis.dao.IGgRelpersonDao;
import com.techstar.dmis.entity.GgRelperson;

public class GgRelpersonDaoImpl implements IGgRelpersonDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(GgRelperson ggRelperson){
		baseHbnDao.delete(ggRelperson);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(GgRelperson ggRelperson) {
		baseHbnDao.saveOrUpdate("GgRelperson", ggRelperson);
	}

	public GgRelperson findByPk(Object id) {
		return (GgRelperson) baseHbnDao.findById(GgRelperson.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("GgRelperson");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("GgRelperson", beginPage, pageSize);
	}
	
	public void merge(GgRelperson ggRelperson){
    	baseHbnDao.merge("GgRelperson", ggRelperson);
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
