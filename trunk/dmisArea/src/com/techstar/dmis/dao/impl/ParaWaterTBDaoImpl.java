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
import com.techstar.dmis.dao.IParaWaterTBDao;
import com.techstar.dmis.entity.ParaWaterTB;

public class ParaWaterTBDaoImpl implements IParaWaterTBDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaWaterTB paraWaterTB){
		baseHbnDao.delete(paraWaterTB);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaWaterTB paraWaterTB) {
		baseHbnDao.saveOrUpdate("ParaWaterTB", paraWaterTB);
	}

	public ParaWaterTB findByPk(Object feqpid) {
		return (ParaWaterTB) baseHbnDao.findById(ParaWaterTB.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaWaterTB");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaWaterTB", beginPage, pageSize);
	}
	
	public void merge(ParaWaterTB paraWaterTB){
    	baseHbnDao.merge("ParaWaterTB", paraWaterTB);
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
