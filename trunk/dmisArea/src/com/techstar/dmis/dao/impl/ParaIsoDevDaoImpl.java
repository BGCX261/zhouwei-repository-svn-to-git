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
import com.techstar.dmis.dao.IParaIsoDevDao;
import com.techstar.dmis.entity.ParaIsoDev;

public class ParaIsoDevDaoImpl implements IParaIsoDevDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaIsoDev paraIsoDev){
		baseHbnDao.delete(paraIsoDev);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaIsoDev paraIsoDev) {
		baseHbnDao.saveOrUpdate("ParaIsoDev", paraIsoDev);
	}

	public ParaIsoDev findByPk(Object fid) {
		return (ParaIsoDev) baseHbnDao.findById(ParaIsoDev.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaIsoDev");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaIsoDev", beginPage, pageSize);
	}
	
	public void merge(ParaIsoDev paraIsoDev){
    	baseHbnDao.merge("ParaIsoDev", paraIsoDev);
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
