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
import com.techstar.dmis.dao.IFsApproveeqprelDao;
import com.techstar.dmis.entity.FsApproveeqprel;

public class FsApproveeqprelDaoImpl implements IFsApproveeqprelDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsApproveeqprel fsApproveeqprel){
		baseHbnDao.delete(fsApproveeqprel);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsApproveeqprel fsApproveeqprel) {
		baseHbnDao.saveOrUpdate("FsApproveeqprel", fsApproveeqprel);
	}

	public FsApproveeqprel findByPk(Object fappeqprelid) {
		return (FsApproveeqprel) baseHbnDao.findById(FsApproveeqprel.class, (Serializable) fappeqprelid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsApproveeqprel");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsApproveeqprel", beginPage, pageSize);
	}
	
	public void merge(FsApproveeqprel fsApproveeqprel){
    	baseHbnDao.merge("FsApproveeqprel", fsApproveeqprel);
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
