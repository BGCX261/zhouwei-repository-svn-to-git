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
import com.techstar.dmis.dao.IRepRepresultDao;
import com.techstar.dmis.entity.RepRepresult;

public class RepRepresultDaoImpl implements IRepRepresultDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(RepRepresult repRepresult){
		baseHbnDao.delete(repRepresult);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(RepRepresult repRepresult) {
		baseHbnDao.saveOrUpdate("RepRepresult", repRepresult);
	}

	public RepRepresult findByPk(Object frepresultid) {
		return (RepRepresult) baseHbnDao.findById(RepRepresult.class, (Serializable) frepresultid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("RepRepresult");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("RepRepresult", beginPage, pageSize);
	}
	
	public void merge(RepRepresult repRepresult){
    	baseHbnDao.merge("RepRepresult", repRepresult);
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
