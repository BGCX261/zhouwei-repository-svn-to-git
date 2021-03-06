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
import com.techstar.dmis.dao.IFsLfeqpfixinformDao;
import com.techstar.dmis.entity.FsLfeqpfixinform;

public class FsLfeqpfixinformDaoImpl implements IFsLfeqpfixinformDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsLfeqpfixinform fsLfeqpfixinform){
		baseHbnDao.delete(fsLfeqpfixinform);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsLfeqpfixinform fsLfeqpfixinform) {
		baseHbnDao.saveOrUpdate("FsLfeqpfixinform", fsLfeqpfixinform);
	}

	public FsLfeqpfixinform findByPk(Object fixinformid) {
		return (FsLfeqpfixinform) baseHbnDao.findById(FsLfeqpfixinform.class, (Serializable) fixinformid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsLfeqpfixinform");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsLfeqpfixinform", beginPage, pageSize);
	}
	
	public void merge(FsLfeqpfixinform fsLfeqpfixinform){
    	baseHbnDao.merge("FsLfeqpfixinform", fsLfeqpfixinform);
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
