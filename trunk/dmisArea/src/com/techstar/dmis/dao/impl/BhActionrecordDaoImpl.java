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
import com.techstar.dmis.dao.IBhActionrecordDao;
import com.techstar.dmis.entity.BhActionrecord;

public class BhActionrecordDaoImpl implements IBhActionrecordDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(BhActionrecord bhActionrecord){
		baseHbnDao.delete(bhActionrecord);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(BhActionrecord bhActionrecord) {
		baseHbnDao.saveOrUpdate("BhActionrecord", bhActionrecord);
	}

	public BhActionrecord findByPk(Object protectionrecordid) {
		return (BhActionrecord) baseHbnDao.findById(BhActionrecord.class, (Serializable) protectionrecordid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("BhActionrecord");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("BhActionrecord", beginPage, pageSize);
	}
	
	public void merge(BhActionrecord bhActionrecord){
    	baseHbnDao.merge("BhActionrecord", bhActionrecord);
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
