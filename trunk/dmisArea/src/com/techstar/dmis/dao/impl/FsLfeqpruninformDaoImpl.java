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
import com.techstar.dmis.dao.IFsLfeqpruninformDao;
import com.techstar.dmis.entity.FsLfeqpruninform;

public class FsLfeqpruninformDaoImpl implements IFsLfeqpruninformDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(FsLfeqpruninform fsLfeqpruninform){
		baseHbnDao.delete(fsLfeqpruninform);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(FsLfeqpruninform fsLfeqpruninform) {
		baseHbnDao.saveOrUpdate("FsLfeqpruninform", fsLfeqpruninform);
	}

	public FsLfeqpruninform findByPk(Object lfeqpruninformid) {
		return (FsLfeqpruninform) baseHbnDao.findById(FsLfeqpruninform.class, (Serializable) lfeqpruninformid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("FsLfeqpruninform");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("FsLfeqpruninform", beginPage, pageSize);
	}
	
	public void merge(FsLfeqpruninform fsLfeqpruninform){
    	baseHbnDao.merge("FsLfeqpruninform", fsLfeqpruninform);
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
