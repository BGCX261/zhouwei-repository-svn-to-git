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
import com.techstar.dmis.dao.IZdhCharalterrecordDao;
import com.techstar.dmis.entity.ZdhCharalterrecord;

public class ZdhCharalterrecordDaoImpl implements IZdhCharalterrecordDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ZdhCharalterrecord zdhCharalterrecord){
		baseHbnDao.delete(zdhCharalterrecord);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ZdhCharalterrecord zdhCharalterrecord) {
		baseHbnDao.saveOrUpdate("ZdhCharalterrecord", zdhCharalterrecord);
	}

	public ZdhCharalterrecord findByPk(Object recordsno) {
		return (ZdhCharalterrecord) baseHbnDao.findById(ZdhCharalterrecord.class, (Serializable) recordsno);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ZdhCharalterrecord");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ZdhCharalterrecord", beginPage, pageSize);
	}
	
	public void merge(ZdhCharalterrecord zdhCharalterrecord){
    	baseHbnDao.merge("ZdhCharalterrecord", zdhCharalterrecord);
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
