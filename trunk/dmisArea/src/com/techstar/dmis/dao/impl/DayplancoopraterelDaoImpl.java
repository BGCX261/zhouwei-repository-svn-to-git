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
import com.techstar.dmis.dao.IDayplancoopraterelDao;
import com.techstar.dmis.entity.Dayplancoopraterel;

public class DayplancoopraterelDaoImpl implements IDayplancoopraterelDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(Dayplancoopraterel dayplancoopraterel){
		baseHbnDao.delete(dayplancoopraterel);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(Dayplancoopraterel dayplancoopraterel) {
		baseHbnDao.saveOrUpdate("Dayplancoopraterel", dayplancoopraterel);
	}

	public Dayplancoopraterel findByPk(Object frelid) {
		return (Dayplancoopraterel) baseHbnDao.findById(Dayplancoopraterel.class, (Serializable) frelid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Dayplancoopraterel");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Dayplancoopraterel", beginPage, pageSize);
	}
	
	public void merge(Dayplancoopraterel dayplancoopraterel){
    	baseHbnDao.merge("Dayplancoopraterel", dayplancoopraterel);
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
