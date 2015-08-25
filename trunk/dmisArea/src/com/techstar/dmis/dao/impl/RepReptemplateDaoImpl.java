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
import com.techstar.dmis.dao.IRepReptemplateDao;
import com.techstar.dmis.entity.RepReptemplate;

public class RepReptemplateDaoImpl implements IRepReptemplateDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(RepReptemplate repReptemplate){
		baseHbnDao.delete(repReptemplate);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(RepReptemplate repReptemplate) {
		baseHbnDao.saveOrUpdate("RepReptemplate", repReptemplate);
	}

	public RepReptemplate findByPk(Object f_reptmplid) {
		return (RepReptemplate) baseHbnDao.findById(RepReptemplate.class, (Serializable) f_reptmplid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("RepReptemplate");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("RepReptemplate", beginPage, pageSize);
	}
	
	public void merge(RepReptemplate repReptemplate){
    	baseHbnDao.merge("RepReptemplate", repReptemplate);
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
