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
import com.techstar.dmis.dao.IFsAfrelDao;
import com.techstar.dmis.entity.FsAfrel;

public class FsAfrelDaoImpl implements IFsAfrelDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsAfrel fsAfrel){
		baseHbnDao.delete(fsAfrel);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsAfrel fsAfrel) {
		baseHbnDao.saveOrUpdate("FsAfrel", fsAfrel);
	}

	public FsAfrel findByPk(Object fapprovfixrelno) {
		return (FsAfrel) baseHbnDao.findById(FsAfrel.class, (Serializable) fapprovfixrelno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsAfrel");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsAfrel", beginPage, pageSize);
	}
	
	public void merge(FsAfrel fsAfrel){
    	baseHbnDao.merge("FsAfrel", fsAfrel);
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
