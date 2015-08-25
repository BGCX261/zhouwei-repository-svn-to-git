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
import com.techstar.dmis.dao.ISystemdicDao;
import com.techstar.dmis.entity.Systemdic;

public class SystemdicDaoImpl implements ISystemdicDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(Systemdic systemdic){
		baseHbnDao.delete(systemdic);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(Systemdic systemdic) {
		baseHbnDao.saveOrUpdate("Systemdic", systemdic);
	}

	public Systemdic findByPk(Object systemdicid) {
		return (Systemdic) baseHbnDao.findById(Systemdic.class, (Serializable) systemdicid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Systemdic");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Systemdic", beginPage, pageSize);
	}
	
	public void merge(Systemdic systemdic){
    	baseHbnDao.merge("Systemdic", systemdic);
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
