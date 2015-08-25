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
import com.techstar.dmis.dao.IDdDayondutylogDao;
import com.techstar.dmis.entity.DdDayondutylog;

public class DdDayondutylogDaoImpl implements IDdDayondutylogDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdDayondutylog ddDayondutylog){
		baseHbnDao.delete(ddDayondutylog);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdDayondutylog ddDayondutylog) {
		baseHbnDao.saveOrUpdate("DdDayondutylog", ddDayondutylog);
	}

	public DdDayondutylog findByPk(Object fondutyid) {
		return (DdDayondutylog) baseHbnDao.findById(DdDayondutylog.class, (Serializable) fondutyid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdDayondutylog");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdDayondutylog", beginPage, pageSize);
	}
	
	public void merge(DdDayondutylog ddDayondutylog){
    	baseHbnDao.merge("DdDayondutylog", ddDayondutylog);
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
