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
import com.techstar.dmis.dao.IDdSasusprecordDao;
import com.techstar.dmis.entity.DdSasusprecord;

public class DdSasusprecordDaoImpl implements IDdSasusprecordDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdSasusprecord ddSasusprecord){
	baseHbnDao.delete(ddSasusprecord);
	}
	public void saveOrUpdate(DdSasusprecord ddSasusprecord) {
		baseHbnDao.saveOrUpdate("DdSasusprecord", ddSasusprecord);
	}

	public DdSasusprecord findByPk(Object fid) {
		return (DdSasusprecord) baseHbnDao.findById(DdSasusprecord.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdSasusprecord");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdSasusprecord", beginPage, pageSize);
	}
	
	public void merge(DdSasusprecord ddSasusprecord){
    	baseHbnDao.merge("DdSasusprecord", ddSasusprecord);
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
