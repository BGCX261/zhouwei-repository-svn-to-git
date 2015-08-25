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
import com.techstar.dmis.dao.IZdhSequencetableDao;
import com.techstar.dmis.entity.ZdhSequencetable;

public class ZdhSequencetableDaoImpl implements IZdhSequencetableDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhSequencetable zdhSequencetable){
	baseHbnDao.delete(zdhSequencetable);
	}
	public void saveOrUpdate(ZdhSequencetable zdhSequencetable) {
		baseHbnDao.saveOrUpdate("ZdhSequencetable", zdhSequencetable);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public ZdhSequencetable findByPk(Object fsequenceno) {
		return (ZdhSequencetable) baseHbnDao.findById(ZdhSequencetable.class, (Serializable) fsequenceno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhSequencetable");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhSequencetable", beginPage, pageSize);
	}
	
	public void merge(ZdhSequencetable zdhSequencetable){
    	baseHbnDao.merge("ZdhSequencetable", zdhSequencetable);
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
