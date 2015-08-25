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
import com.techstar.dmis.dao.IFsRmchangbillDao;
import com.techstar.dmis.entity.FsRmchangbill;

public class FsRmchangbillDaoImpl implements IFsRmchangbillDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsRmchangbill fsRmchangbill){
		baseHbnDao.delete(fsRmchangbill);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsRmchangbill fsRmchangbill) {
		baseHbnDao.saveOrUpdate("FsRmchangbill", fsRmchangbill);
	}

	public FsRmchangbill findByPk(Object fchangno) {
		return (FsRmchangbill) baseHbnDao.findById(FsRmchangbill.class, (Serializable) fchangno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsRmchangbill");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsRmchangbill", beginPage, pageSize);
	}
	
	public void merge(FsRmchangbill fsRmchangbill){
    	baseHbnDao.merge("FsRmchangbill", fsRmchangbill);
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
