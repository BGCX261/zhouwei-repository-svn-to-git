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
import com.techstar.dmis.dao.IMtransformerwindingDao;
import com.techstar.dmis.entity.Mtransformerwinding;

public class MtransformerwindingDaoImpl implements IMtransformerwindingDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(Mtransformerwinding mtransformerwinding){
		baseHbnDao.delete(mtransformerwinding);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(Mtransformerwinding mtransformerwinding) {
		baseHbnDao.saveOrUpdate("Mtransformerwinding", mtransformerwinding);
	}

	public Mtransformerwinding findByPk(Object fid) {
		return (Mtransformerwinding) baseHbnDao.findById(Mtransformerwinding.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("Mtransformerwinding");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("Mtransformerwinding", beginPage, pageSize);
	}
	
	public void merge(Mtransformerwinding mtransformerwinding){
    	baseHbnDao.merge("Mtransformerwinding", mtransformerwinding);
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
