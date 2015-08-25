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
import com.techstar.dmis.dao.IRepReporttreeDao;
import com.techstar.dmis.entity.RepReporttree;

public class RepReporttreeDaoImpl implements IRepReporttreeDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(RepReporttree repReporttree){
		baseHbnDao.delete(repReporttree);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(RepReporttree repReporttree) {
		baseHbnDao.saveOrUpdate("RepReporttree", repReporttree);
	}

	public RepReporttree findByPk(Object f_treeid) {
		return (RepReporttree) baseHbnDao.findById(RepReporttree.class, (Serializable) f_treeid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("RepReporttree");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("RepReporttree", beginPage, pageSize);
	}
	
	public void merge(RepReporttree repReporttree){
    	baseHbnDao.merge("RepReporttree", repReporttree);
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
