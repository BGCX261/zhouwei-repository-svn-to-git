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
import com.techstar.dmis.dao.IBhFixedvaluebilldetailDao;
import com.techstar.dmis.entity.BhFixedvaluebilldetail;

public class BhFixedvaluebilldetailDaoImpl implements IBhFixedvaluebilldetailDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhFixedvaluebilldetail bhFixedvaluebilldetail){
		baseHbnDao.delete(bhFixedvaluebilldetail);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhFixedvaluebilldetail bhFixedvaluebilldetail) {
		baseHbnDao.saveOrUpdate("BhFixedvaluebilldetail", bhFixedvaluebilldetail);
	}

	public BhFixedvaluebilldetail findByPk(Object serialno) {
		return (BhFixedvaluebilldetail) baseHbnDao.findById(BhFixedvaluebilldetail.class, (Serializable) serialno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhFixedvaluebilldetail");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhFixedvaluebilldetail", beginPage, pageSize);
	}
	
	public void merge(BhFixedvaluebilldetail bhFixedvaluebilldetail){
    	baseHbnDao.merge("BhFixedvaluebilldetail", bhFixedvaluebilldetail);
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
