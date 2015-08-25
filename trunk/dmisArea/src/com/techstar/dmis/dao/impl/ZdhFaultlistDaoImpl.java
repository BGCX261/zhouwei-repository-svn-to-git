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
import com.techstar.dmis.dao.IZdhFaultlistDao;
import com.techstar.dmis.entity.ZdhFaultlist;

public class ZdhFaultlistDaoImpl implements IZdhFaultlistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhFaultlist zdhFaultlist){
		baseHbnDao.delete(zdhFaultlist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhFaultlist zdhFaultlist) {
		baseHbnDao.saveOrUpdate("ZdhFaultlist", zdhFaultlist);
	}

	public ZdhFaultlist findByPk(Object ffaultno) {
		return (ZdhFaultlist) baseHbnDao.findById(ZdhFaultlist.class, (Serializable) ffaultno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhFaultlist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhFaultlist", beginPage, pageSize);
	}
	
	public void merge(ZdhFaultlist zdhFaultlist){
    	baseHbnDao.merge("ZdhFaultlist", zdhFaultlist);
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
