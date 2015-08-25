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
import com.techstar.dmis.dao.IZdhTransrecordDao;
import com.techstar.dmis.entity.ZdhTransrecord;

public class ZdhTransrecordDaoImpl implements IZdhTransrecordDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhTransrecord zdhTransrecord){
	baseHbnDao.delete(zdhTransrecord);
	}
	public void saveOrUpdate(ZdhTransrecord zdhTransrecord) {
		baseHbnDao.saveOrUpdate("ZdhTransrecord", zdhTransrecord);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public ZdhTransrecord findByPk(Object transrecordid) {
		return (ZdhTransrecord) baseHbnDao.findById(ZdhTransrecord.class, (Serializable) transrecordid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhTransrecord");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhTransrecord", beginPage, pageSize);
	}
	
	public void merge(ZdhTransrecord zdhTransrecord){
    	baseHbnDao.merge("ZdhTransrecord", zdhTransrecord);
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
