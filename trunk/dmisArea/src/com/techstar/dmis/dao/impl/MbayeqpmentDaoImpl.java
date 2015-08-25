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
import com.techstar.dmis.dao.IMbayeqpmentDao;
import com.techstar.dmis.entity.Mbayeqpment;

public class MbayeqpmentDaoImpl implements IMbayeqpmentDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(Mbayeqpment mbayeqpment){
		baseHbnDao.delete(mbayeqpment);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(Mbayeqpment mbayeqpment) {
		baseHbnDao.saveOrUpdate("Mbayeqpment", mbayeqpment);
	}

	public Mbayeqpment findByPk(Object fid) {
		return (Mbayeqpment) baseHbnDao.findById(Mbayeqpment.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Mbayeqpment");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Mbayeqpment", beginPage, pageSize);
	}
	
	public void merge(Mbayeqpment mbayeqpment){
    	baseHbnDao.merge("Mbayeqpment", mbayeqpment);
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
