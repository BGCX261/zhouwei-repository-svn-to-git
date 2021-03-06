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
import com.techstar.dmis.dao.IDdWoutageplanDao;
import com.techstar.dmis.entity.DdWoutageplan;

public class DdWoutageplanDaoImpl implements IDdWoutageplanDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdWoutageplan ddWoutageplan){
		baseHbnDao.delete(ddWoutageplan);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdWoutageplan ddWoutageplan) {
		baseHbnDao.saveOrUpdate("DdWoutageplan", ddWoutageplan);
	}

	public DdWoutageplan findByPk(Object fwplanno) {
		return (DdWoutageplan) baseHbnDao.findById(DdWoutageplan.class, (Serializable) fwplanno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdWoutageplan");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdWoutageplan", beginPage, pageSize);
	}
	
	public void merge(DdWoutageplan ddWoutageplan){
    	baseHbnDao.merge("DdWoutageplan", ddWoutageplan);
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
