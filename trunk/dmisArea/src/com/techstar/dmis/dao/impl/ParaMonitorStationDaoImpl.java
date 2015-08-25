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
import com.techstar.dmis.dao.IParaMonitorStationDao;
import com.techstar.dmis.entity.ParaMonitorStation;

public class ParaMonitorStationDaoImpl implements IParaMonitorStationDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaMonitorStation paraMonitorStation){
		baseHbnDao.delete(paraMonitorStation);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaMonitorStation paraMonitorStation) {
		baseHbnDao.saveOrUpdate("ParaMonitorStation", paraMonitorStation);
	}

	public ParaMonitorStation findByPk(Object feqpid) {
		return (ParaMonitorStation) baseHbnDao.findById(ParaMonitorStation.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaMonitorStation");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaMonitorStation", beginPage, pageSize);
	}
	
	public void merge(ParaMonitorStation paraMonitorStation){
    	baseHbnDao.merge("ParaMonitorStation", paraMonitorStation);
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
