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
import com.techstar.dmis.dao.IZdhReceptioneqprelDao;
import com.techstar.dmis.entity.ZdhReceptioneqprel;

public class ZdhReceptioneqprelDaoImpl implements IZdhReceptioneqprelDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhReceptioneqprel zdhReceptioneqprel){
		baseHbnDao.delete(zdhReceptioneqprel);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhReceptioneqprel zdhReceptioneqprel) {
		baseHbnDao.saveOrUpdate("ZdhReceptioneqprel", zdhReceptioneqprel);
	}

	public ZdhReceptioneqprel findByPk(Object receptioneqprelid) {
		return (ZdhReceptioneqprel) baseHbnDao.findById(ZdhReceptioneqprel.class, (Serializable) receptioneqprelid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhReceptioneqprel");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhReceptioneqprel", beginPage, pageSize);
	}
	
	public void merge(ZdhReceptioneqprel zdhReceptioneqprel){
    	baseHbnDao.merge("ZdhReceptioneqprel", zdhReceptioneqprel);
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
