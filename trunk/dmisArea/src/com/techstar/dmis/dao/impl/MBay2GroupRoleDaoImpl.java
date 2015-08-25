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
import com.techstar.dmis.dao.IMBay2GroupRoleDao;
import com.techstar.dmis.entity.MBay2GroupRole;

public class MBay2GroupRoleDaoImpl implements IMBay2GroupRoleDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(MBay2GroupRole mBay2GroupRole){
		baseHbnDao.delete(mBay2GroupRole);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(MBay2GroupRole mBay2GroupRole) {
		baseHbnDao.saveOrUpdate("MBay2GroupRole", mBay2GroupRole);
	}

	public MBay2GroupRole findByPk(Object fid) {
		return (MBay2GroupRole) baseHbnDao.findById(MBay2GroupRole.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("MBay2GroupRole");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("MBay2GroupRole", beginPage, pageSize);
	}
	
	public void merge(MBay2GroupRole mBay2GroupRole){
    	baseHbnDao.merge("MBay2GroupRole", mBay2GroupRole);
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
