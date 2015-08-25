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
import com.techstar.dmis.dao.IParaWaterTBSysDao;
import com.techstar.dmis.entity.ParaWaterTBSys;

public class ParaWaterTBSysDaoImpl implements IParaWaterTBSysDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaWaterTBSys paraWaterTBSys){
		baseHbnDao.delete(paraWaterTBSys);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaWaterTBSys paraWaterTBSys) {
		baseHbnDao.saveOrUpdate("ParaWaterTBSys", paraWaterTBSys);
	}

	public ParaWaterTBSys findByPk(Object feqpid) {
		return (ParaWaterTBSys) baseHbnDao.findById(ParaWaterTBSys.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaWaterTBSys");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaWaterTBSys", beginPage, pageSize);
	}
	
	public void merge(ParaWaterTBSys paraWaterTBSys){
    	baseHbnDao.merge("ParaWaterTBSys", paraWaterTBSys);
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
