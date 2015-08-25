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
import com.techstar.dmis.dao.IZdhOpexaminelistDao;
import com.techstar.dmis.entity.ZdhOpexaminelist;

public class ZdhOpexaminelistDaoImpl implements IZdhOpexaminelistDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhOpexaminelist zdhOpexaminelist){
		baseHbnDao.delete(zdhOpexaminelist);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhOpexaminelist zdhOpexaminelist) {
		baseHbnDao.saveOrUpdate("ZdhOpexaminelist", zdhOpexaminelist);
	}

	public ZdhOpexaminelist findByPk(Object examinationid) {
		return (ZdhOpexaminelist) baseHbnDao.findById(ZdhOpexaminelist.class, (Serializable) examinationid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhOpexaminelist");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhOpexaminelist", beginPage, pageSize);
	}
	
	public void merge(ZdhOpexaminelist zdhOpexaminelist){
    	baseHbnDao.merge("ZdhOpexaminelist", zdhOpexaminelist);
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
