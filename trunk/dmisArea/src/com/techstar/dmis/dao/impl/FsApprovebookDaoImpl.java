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
import com.techstar.dmis.dao.IFsApprovebookDao;
import com.techstar.dmis.entity.FsApprovebook;

public class FsApprovebookDaoImpl implements IFsApprovebookDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsApprovebook fsApprovebook){
		baseHbnDao.delete(fsApprovebook);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsApprovebook fsApprovebook) {
		baseHbnDao.saveOrUpdate("FsApprovebook", fsApprovebook);
	}

	public FsApprovebook findByPk(Object fapprovcomputerno) {
		return (FsApprovebook) baseHbnDao.findById(FsApprovebook.class, (Serializable) fapprovcomputerno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsApprovebook");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsApprovebook", beginPage, pageSize);
	}
	
	public void merge(FsApprovebook fsApprovebook){
    	baseHbnDao.merge("FsApprovebook", fsApprovebook);
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
