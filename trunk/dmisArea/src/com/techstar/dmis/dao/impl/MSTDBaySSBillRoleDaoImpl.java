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
import com.techstar.dmis.dao.IMSTDBaySSBillRoleDao;
import com.techstar.dmis.entity.MSTDBaySSBillRole;

public class MSTDBaySSBillRoleDaoImpl implements IMSTDBaySSBillRoleDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(MSTDBaySSBillRole mSTDBaySSBillRole){
		baseHbnDao.delete(mSTDBaySSBillRole);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(MSTDBaySSBillRole mSTDBaySSBillRole) {
		baseHbnDao.saveOrUpdate("MSTDBaySSBillRole", mSTDBaySSBillRole);
	}

	public MSTDBaySSBillRole findByPk(Object fid) {
		return (MSTDBaySSBillRole) baseHbnDao.findById(MSTDBaySSBillRole.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("MSTDBaySSBillRole");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("MSTDBaySSBillRole", beginPage, pageSize);
	}
	
	public void merge(MSTDBaySSBillRole mSTDBaySSBillRole){
    	baseHbnDao.merge("MSTDBaySSBillRole", mSTDBaySSBillRole);
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
