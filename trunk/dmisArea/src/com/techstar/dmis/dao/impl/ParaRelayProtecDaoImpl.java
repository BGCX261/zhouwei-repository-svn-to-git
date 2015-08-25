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
import com.techstar.dmis.dao.IParaRelayProtecDao;
import com.techstar.dmis.entity.ParaRelayProtec;

public class ParaRelayProtecDaoImpl implements IParaRelayProtecDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaRelayProtec paraRelayProtec){
		baseHbnDao.delete(paraRelayProtec);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaRelayProtec paraRelayProtec) {
		baseHbnDao.saveOrUpdate("ParaRelayProtec", paraRelayProtec);
	}

	public ParaRelayProtec findByPk(Object feqpid) {
		return (ParaRelayProtec) baseHbnDao.findById(ParaRelayProtec.class, (Serializable) feqpid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaRelayProtec");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaRelayProtec", beginPage, pageSize);
	}
	
	public void merge(ParaRelayProtec paraRelayProtec){
    	baseHbnDao.merge("ParaRelayProtec", paraRelayProtec);
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
