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
import com.techstar.dmis.dao.IBhFixedvaluebillDao;
import com.techstar.dmis.entity.BhFixedvaluebill;

public class BhFixedvaluebillDaoImpl implements IBhFixedvaluebillDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhFixedvaluebill bhFixedvaluebill){
		baseHbnDao.delete(bhFixedvaluebill);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhFixedvaluebill bhFixedvaluebill) {
		baseHbnDao.saveOrUpdate("BhFixedvaluebill", bhFixedvaluebill);
	}

	public BhFixedvaluebill findByPk(Object fixvaluebillno) {
		return (BhFixedvaluebill) baseHbnDao.findById(BhFixedvaluebill.class, (Serializable) fixvaluebillno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhFixedvaluebill");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhFixedvaluebill", beginPage, pageSize);
	}
	
	public void merge(BhFixedvaluebill bhFixedvaluebill){
    	baseHbnDao.merge("BhFixedvaluebill", bhFixedvaluebill);
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
