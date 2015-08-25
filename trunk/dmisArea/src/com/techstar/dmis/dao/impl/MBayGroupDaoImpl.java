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
import com.techstar.dmis.dao.IMBayGroupDao;
import com.techstar.dmis.entity.MBayGroup;

public class MBayGroupDaoImpl implements IMBayGroupDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(MBayGroup mBayGroup){
		baseHbnDao.delete(mBayGroup);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(MBayGroup mBayGroup) {
		baseHbnDao.saveOrUpdate("MBayGroup", mBayGroup);
	}

	public MBayGroup findByPk(Object fid) {
		return (MBayGroup) baseHbnDao.findById(MBayGroup.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("MBayGroup");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("MBayGroup", beginPage, pageSize);
	}
	
	public void merge(MBayGroup mBayGroup){
    	baseHbnDao.merge("MBayGroup", mBayGroup);
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
