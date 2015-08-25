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
import com.techstar.dmis.dao.IDdSeqbilldetailDao;
import com.techstar.dmis.entity.DdSeqbilldetail;

public class DdSeqbilldetailDaoImpl implements IDdSeqbilldetailDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdSeqbilldetail ddSeqbilldetail){
		baseHbnDao.delete(ddSeqbilldetail);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdSeqbilldetail ddSeqbilldetail) {
		baseHbnDao.saveOrUpdate("DdSeqbilldetail", ddSeqbilldetail);
	}

	public DdSeqbilldetail findByPk(Object foperationstepno) {
		return (DdSeqbilldetail) baseHbnDao.findById(DdSeqbilldetail.class, (Serializable) foperationstepno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdSeqbilldetail");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdSeqbilldetail", beginPage, pageSize);
	}
	
	public void merge(DdSeqbilldetail ddSeqbilldetail){
    	baseHbnDao.merge("DdSeqbilldetail", ddSeqbilldetail);
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
