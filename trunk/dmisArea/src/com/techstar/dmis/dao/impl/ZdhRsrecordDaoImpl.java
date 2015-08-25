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
import com.techstar.dmis.dao.IZdhRsrecordDao;
import com.techstar.dmis.entity.ZdhRsrecord;

public class ZdhRsrecordDaoImpl implements IZdhRsrecordDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhRsrecord zdhRsrecord){
		baseHbnDao.delete(zdhRsrecord);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhRsrecord zdhRsrecord) {
		baseHbnDao.saveOrUpdate("ZdhRsrecord", zdhRsrecord);
	}

	public ZdhRsrecord findByPk(Object recordid) {
		return (ZdhRsrecord) baseHbnDao.findById(ZdhRsrecord.class, (Serializable) recordid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhRsrecord");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhRsrecord", beginPage, pageSize);
	}
	
	public void merge(ZdhRsrecord zdhRsrecord){
    	baseHbnDao.merge("ZdhRsrecord", zdhRsrecord);
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
