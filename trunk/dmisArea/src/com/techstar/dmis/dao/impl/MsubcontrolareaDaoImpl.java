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
import com.techstar.dmis.dao.IMsubcontrolareaDao;
import com.techstar.dmis.entity.Msubcontrolarea;

public class MsubcontrolareaDaoImpl implements IMsubcontrolareaDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(Msubcontrolarea msubcontrolarea){
		baseHbnDao.delete(msubcontrolarea);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(Msubcontrolarea msubcontrolarea) {
		baseHbnDao.saveOrUpdate("Msubcontrolarea", msubcontrolarea);
	}

	public Msubcontrolarea findByPk(Object fid) {
		return (Msubcontrolarea) baseHbnDao.findById(Msubcontrolarea.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Msubcontrolarea");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Msubcontrolarea", beginPage, pageSize);
	}
	
	public void merge(Msubcontrolarea msubcontrolarea){
    	baseHbnDao.merge("Msubcontrolarea", msubcontrolarea);
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
