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
import com.techstar.dmis.dao.IRepTree2resultDao;
import com.techstar.dmis.entity.RepTree2result;

public class RepTree2resultDaoImpl implements IRepTree2resultDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(RepTree2result repTree2result){
		baseHbnDao.delete(repTree2result);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(RepTree2result repTree2result) {
		baseHbnDao.saveOrUpdate("RepTree2result", repTree2result);
	}

	public RepTree2result findByPk(Object f_relationid) {
		return (RepTree2result) baseHbnDao.findById(RepTree2result.class, (Serializable) f_relationid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("RepTree2result");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("RepTree2result", beginPage, pageSize);
	}
	
	public void merge(RepTree2result repTree2result){
    	baseHbnDao.merge("RepTree2result", repTree2result);
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
