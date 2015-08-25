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
import com.techstar.dmis.dao.IDdMoutageplanDao;
import com.techstar.dmis.entity.DdMoutageplan;

public class DdMoutageplanDaoImpl implements IDdMoutageplanDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdMoutageplan ddMoutageplan){
		baseHbnDao.delete(ddMoutageplan);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdMoutageplan ddMoutageplan) {
		baseHbnDao.saveOrUpdate("DdMoutageplan", ddMoutageplan);
	}

	public DdMoutageplan findByPk(Object fmonthplanno) {
		return (DdMoutageplan) baseHbnDao.findById(DdMoutageplan.class, (Serializable) fmonthplanno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdMoutageplan");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdMoutageplan", beginPage, pageSize);
	}
	
	public void merge(DdMoutageplan ddMoutageplan){
    	baseHbnDao.merge("DdMoutageplan", ddMoutageplan);
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
