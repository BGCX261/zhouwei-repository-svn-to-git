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
import com.techstar.dmis.dao.IStdBheqpfaultDao;
import com.techstar.dmis.entity.StdBheqpfault;

public class StdBheqpfaultDaoImpl implements IStdBheqpfaultDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(StdBheqpfault stdBheqpfault){
		baseHbnDao.delete(stdBheqpfault);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(StdBheqpfault stdBheqpfault) {
		baseHbnDao.saveOrUpdate("StdBheqpfault", stdBheqpfault);
	}

	public StdBheqpfault findByPk(Object id) {
		return (StdBheqpfault) baseHbnDao.findById(StdBheqpfault.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("StdBheqpfault");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("StdBheqpfault", beginPage, pageSize);
	}
	
	public void merge(StdBheqpfault stdBheqpfault){
    	baseHbnDao.merge("StdBheqpfault", stdBheqpfault);
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
