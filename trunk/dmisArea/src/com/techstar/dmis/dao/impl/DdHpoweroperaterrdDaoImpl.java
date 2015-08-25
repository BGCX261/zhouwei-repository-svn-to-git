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
import com.techstar.dmis.dao.IDdHpoweroperaterrdDao;
import com.techstar.dmis.entity.DdHpoweroperaterrd;

public class DdHpoweroperaterrdDaoImpl implements IDdHpoweroperaterrdDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdHpoweroperaterrd ddHpoweroperaterrd){
	baseHbnDao.delete(ddHpoweroperaterrd);
	}
    public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdHpoweroperaterrd ddHpoweroperaterrd) {
		baseHbnDao.saveOrUpdate("DdHpoweroperaterrd", ddHpoweroperaterrd);
	}

	public DdHpoweroperaterrd findByPk(Object fid) {
		return (DdHpoweroperaterrd) baseHbnDao.findById(DdHpoweroperaterrd.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdHpoweroperaterrd");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdHpoweroperaterrd", beginPage, pageSize);
	}
	
	public void merge(DdHpoweroperaterrd ddHpoweroperaterrd){
    	baseHbnDao.merge("DdHpoweroperaterrd", ddHpoweroperaterrd);
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
