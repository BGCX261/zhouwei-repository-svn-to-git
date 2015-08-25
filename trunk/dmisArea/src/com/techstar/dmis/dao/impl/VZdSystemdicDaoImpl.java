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
import com.techstar.dmis.dao.IVZdSystemdicDao;
import com.techstar.dmis.entity.VZdSystemdic;

public class VZdSystemdicDaoImpl implements IVZdSystemdicDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(VZdSystemdic vZdSystemdic){
		baseHbnDao.delete(vZdSystemdic);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(VZdSystemdic vZdSystemdic) {
		baseHbnDao.saveOrUpdate("VZdSystemdic", vZdSystemdic);
	}

	public VZdSystemdic findByPk(Object viewid) {
		return (VZdSystemdic) baseHbnDao.findById(VZdSystemdic.class, (Serializable) viewid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("VZdSystemdic");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("VZdSystemdic", beginPage, pageSize);
	}
	
	public void merge(VZdSystemdic vZdSystemdic){
    	baseHbnDao.merge("VZdSystemdic", vZdSystemdic);
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
