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
import com.techstar.dmis.dao.IFsLfparalistDao;
import com.techstar.dmis.entity.FsLfparalist;

public class FsLfparalistDaoImpl implements IFsLfparalistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsLfparalist fsLfparalist){
		baseHbnDao.delete(fsLfparalist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsLfparalist fsLfparalist) {
		baseHbnDao.saveOrUpdate("FsLfparalist", fsLfparalist);
	}

	public FsLfparalist findByPk(Object flinesno) {
		return (FsLfparalist) baseHbnDao.findById(FsLfparalist.class, (Serializable) flinesno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsLfparalist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsLfparalist", beginPage, pageSize);
	}
	
	public void merge(FsLfparalist fsLfparalist){
    	baseHbnDao.merge("FsLfparalist", fsLfparalist);
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
