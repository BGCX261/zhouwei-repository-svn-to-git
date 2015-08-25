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
import com.techstar.dmis.dao.IParaSwitchDao;
import com.techstar.dmis.entity.ParaSwitch;

public class ParaSwitchDaoImpl implements IParaSwitchDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaSwitch paraSwitch){
		baseHbnDao.delete(paraSwitch);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaSwitch paraSwitch) {
		baseHbnDao.saveOrUpdate("ParaSwitch", paraSwitch);
	}

	public ParaSwitch findByPk(Object fid) {
		return (ParaSwitch) baseHbnDao.findById(ParaSwitch.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaSwitch");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaSwitch", beginPage, pageSize);
	}
	
	public void merge(ParaSwitch paraSwitch){
    	baseHbnDao.merge("ParaSwitch", paraSwitch);
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
