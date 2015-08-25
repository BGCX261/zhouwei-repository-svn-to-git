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
import com.techstar.dmis.dao.IFsLoaddatalistDao;
import com.techstar.dmis.entity.FsLoaddatalist;

public class FsLoaddatalistDaoImpl implements IFsLoaddatalistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsLoaddatalist fsLoaddatalist){
		baseHbnDao.delete(fsLoaddatalist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsLoaddatalist fsLoaddatalist) {
		baseHbnDao.saveOrUpdate("FsLoaddatalist", fsLoaddatalist);
	}

	public FsLoaddatalist findByPk(Object floaddatano) {
		return (FsLoaddatalist) baseHbnDao.findById(FsLoaddatalist.class, (Serializable) floaddatano);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsLoaddatalist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsLoaddatalist", beginPage, pageSize);
	}
	
	public void merge(FsLoaddatalist fsLoaddatalist){
    	baseHbnDao.merge("FsLoaddatalist", fsLoaddatalist);
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
