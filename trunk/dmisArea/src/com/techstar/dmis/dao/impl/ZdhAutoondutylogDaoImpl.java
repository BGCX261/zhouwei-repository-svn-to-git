/**
 * 持久化对象数据操纵实现类
 * @author 
 * @date
 */
package com.techstar.dmis.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.techstar.framework.dao.IBaseHbnDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dao.IZdhAutoondutylogDao;
import com.techstar.dmis.entity.ZdhAutoondutylog;

public class ZdhAutoondutylogDaoImpl implements IZdhAutoondutylogDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhAutoondutylog zdhAutoondutylog){
		baseHbnDao.delete(zdhAutoondutylog);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhAutoondutylog zdhAutoondutylog) {
		baseHbnDao.saveOrUpdate("ZdhAutoondutylog", zdhAutoondutylog);
	}

	public ZdhAutoondutylog findByPk(Object ondutyno) {
		return (ZdhAutoondutylog) baseHbnDao.findById(ZdhAutoondutylog.class, (Serializable) ondutyno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhAutoondutylog");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhAutoondutylog", beginPage, pageSize);
	}
	
	public void merge(ZdhAutoondutylog zdhAutoondutylog){
    	baseHbnDao.merge("ZdhAutoondutylog", zdhAutoondutylog);
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
	public String carryOn(String ondutyno){
		//DMIS_ZDH_AUTOONDUTYLOG_PK(?,?)
		String procDefine = "DMIS_ZDH_AUTOONDUTYLOG_PK(?,?)";
		return baseHbnDao.executeProc(ondutyno,procDefine);
	}
	
}
