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
import com.techstar.dmis.dao.IMbasevoltageDao;
import com.techstar.dmis.entity.Mbasevoltage;

public class MbasevoltageDaoImpl implements IMbasevoltageDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(Mbasevoltage mbasevoltage){
		baseHbnDao.delete(mbasevoltage);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(Mbasevoltage mbasevoltage) {
		baseHbnDao.saveOrUpdate("Mbasevoltage", mbasevoltage);
	}

	public Mbasevoltage findByPk(Object fid) {
		return (Mbasevoltage) baseHbnDao.findById(Mbasevoltage.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Mbasevoltage");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Mbasevoltage", beginPage, pageSize);
	}
	
	public void merge(Mbasevoltage mbasevoltage){
    	baseHbnDao.merge("Mbasevoltage", mbasevoltage);
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
