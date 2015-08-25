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
import com.techstar.dmis.dao.IDdHloadrecordDao;
import com.techstar.dmis.entity.DdHloadrecord;

public class DdHloadrecordDaoImpl implements IDdHloadrecordDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(DdHloadrecord ddHloadrecord){
	baseHbnDao.delete(ddHloadrecord);
	}
    
    public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(DdHloadrecord ddHloadrecord) {
		baseHbnDao.saveOrUpdate("DdHloadrecord", ddHloadrecord);
	}

	public DdHloadrecord findByPk(Object fid) {
		return (DdHloadrecord) baseHbnDao.findById(DdHloadrecord.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("DdHloadrecord");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("DdHloadrecord", beginPage, pageSize);
	}
	
	public void merge(DdHloadrecord ddHloadrecord){
    	baseHbnDao.merge("DdHloadrecord", ddHloadrecord);
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
