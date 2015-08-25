/**
 * 持久化对象数据操纵实现类
 * @author 
 * @date
 */
package com.techstar.framework.ui.dao.impl;

import java.io.Serializable;

import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.dao.ISysUiGridDao;
import com.techstar.framework.ui.entity.SysUiGrid;

public class SysUiGridDaoImpl implements ISysUiGridDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(SysUiGrid sysUiGrid){
    	baseHbnDao.delete(sysUiGrid);
	}
	public void saveOrUpdate(SysUiGrid sysUiGrid) {
		baseHbnDao.saveOrUpdate("SysUiGrid", sysUiGrid);
	}

	public SysUiGrid findByPk(Object id) {
		return (SysUiGrid) baseHbnDao.findById(SysUiGrid.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("SysUiGrid");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("SysUiGrid", beginPage, pageSize);
	}
    
	public QueryListObj getQueryListByHql(String hql, int beginPage, int pageSize) {
		// TODO Auto-generated method stub
		return baseHbnDao.getQueryList(hql,beginPage,pageSize);
	}
	public QueryListObj getQueryListByHql(String hql) {
		// TODO Auto-generated method stub
		return baseHbnDao.getQueryListByHql(hql);
	}
	
	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}
}
