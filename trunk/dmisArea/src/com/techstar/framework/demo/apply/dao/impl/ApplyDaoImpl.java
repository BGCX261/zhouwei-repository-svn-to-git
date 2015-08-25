/**
 * Oct 25, 2006
 * @author xcf
 */
package com.techstar.framework.demo.apply.dao.impl;

import java.io.Serializable;

import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.apply.dao.IApplyDao;
import com.techstar.framework.demo.entity.Apply;

public class ApplyDaoImpl implements IApplyDao {
	private IBaseHbnDao baseHbnDao;

	public void delete(Apply apply) {
		baseHbnDao.delete(apply);
	}

	public Apply findByPk(Object pk) {
		return (Apply) baseHbnDao.findById(Apply.class, (Serializable) pk);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Apply");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Apply", beginPage, pageSize);
	}

	public void saveOrUpdate(Apply apply) {
		baseHbnDao.saveOrUpdate("Apply", apply);
	}

	public IBaseHbnDao getBaseHbnDao() {
		return baseHbnDao;
	}

	public void setBaseHbnDao(IBaseHbnDao baseHbnDao) {
		this.baseHbnDao = baseHbnDao;
	}
}
