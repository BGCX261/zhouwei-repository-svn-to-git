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
import com.techstar.dmis.dao.IDdDoutageplanDao;
import com.techstar.dmis.entity.DdDoutageplan;

public class DdDoutageplanDaoImpl implements IDdDoutageplanDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdDoutageplan ddDoutageplan){
		baseHbnDao.delete(ddDoutageplan);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdDoutageplan ddDoutageplan) {
		baseHbnDao.saveOrUpdate("DdDoutageplan", ddDoutageplan);
	}

	public DdDoutageplan findByPk(Object fdayplanno) {
		return (DdDoutageplan) baseHbnDao.findById(DdDoutageplan.class, (Serializable) fdayplanno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdDoutageplan");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdDoutageplan", beginPage, pageSize);
	}
	
	public void merge(DdDoutageplan ddDoutageplan){
    	baseHbnDao.merge("DdDoutageplan", ddDoutageplan);
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
