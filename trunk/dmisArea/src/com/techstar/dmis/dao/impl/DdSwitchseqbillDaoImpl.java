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
import com.techstar.dmis.dao.IDdSwitchseqbillDao;
import com.techstar.dmis.entity.DdSwitchseqbill;

public class DdSwitchseqbillDaoImpl implements IDdSwitchseqbillDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdSwitchseqbill ddSwitchseqbill){
		baseHbnDao.delete(ddSwitchseqbill);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdSwitchseqbill ddSwitchseqbill) {
		baseHbnDao.saveOrUpdate("DdSwitchseqbill", ddSwitchseqbill);
	}

	public DdSwitchseqbill findByPk(Object fcomputerno) {
		return (DdSwitchseqbill) baseHbnDao.findById(DdSwitchseqbill.class, (Serializable) fcomputerno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdSwitchseqbill");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdSwitchseqbill", beginPage, pageSize);
	}
	
	public void merge(DdSwitchseqbill ddSwitchseqbill){
    	baseHbnDao.merge("DdSwitchseqbill", ddSwitchseqbill);
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
