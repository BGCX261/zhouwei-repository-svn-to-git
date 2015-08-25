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
import com.techstar.dmis.dao.IFsAllappendixDao;
import com.techstar.dmis.entity.FsAllappendix;

public class FsAllappendixDaoImpl implements IFsAllappendixDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsAllappendix fsAllappendix){
		baseHbnDao.delete(fsAllappendix);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsAllappendix fsAllappendix) {
		baseHbnDao.saveOrUpdate("FsAllappendix", fsAllappendix);
	}

	public FsAllappendix findByPk(Object f_id) {
		return (FsAllappendix) baseHbnDao.findById(FsAllappendix.class, (Serializable) f_id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsAllappendix");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsAllappendix", beginPage, pageSize);
	}
	
	public void merge(FsAllappendix fsAllappendix){
    	baseHbnDao.merge("FsAllappendix", fsAllappendix);
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
