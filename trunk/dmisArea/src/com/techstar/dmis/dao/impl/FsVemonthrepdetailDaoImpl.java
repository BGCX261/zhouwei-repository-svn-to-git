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
import com.techstar.dmis.dao.IFsVemonthrepdetailDao;
import com.techstar.dmis.entity.FsVemonthrepdetail;

public class FsVemonthrepdetailDaoImpl implements IFsVemonthrepdetailDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsVemonthrepdetail fsVemonthrepdetail){
		baseHbnDao.delete(fsVemonthrepdetail);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsVemonthrepdetail fsVemonthrepdetail) {
		baseHbnDao.saveOrUpdate("FsVemonthrepdetail", fsVemonthrepdetail);
	}

	public FsVemonthrepdetail findByPk(Object reportdetailid) {
		return (FsVemonthrepdetail) baseHbnDao.findById(FsVemonthrepdetail.class, (Serializable) reportdetailid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsVemonthrepdetail");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsVemonthrepdetail", beginPage, pageSize);
	}
	
	public void merge(FsVemonthrepdetail fsVemonthrepdetail){
    	baseHbnDao.merge("FsVemonthrepdetail", fsVemonthrepdetail);
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
