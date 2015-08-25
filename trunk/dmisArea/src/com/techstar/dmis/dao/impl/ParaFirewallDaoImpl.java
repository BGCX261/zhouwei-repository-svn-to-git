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
import com.techstar.dmis.dao.IParaFirewallDao;
import com.techstar.dmis.entity.ParaFirewall;

public class ParaFirewallDaoImpl implements IParaFirewallDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(ParaFirewall paraFirewall){
		baseHbnDao.delete(paraFirewall);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	public void saveOrUpdate(ParaFirewall paraFirewall) {
		baseHbnDao.saveOrUpdate("ParaFirewall", paraFirewall);
	}

	public ParaFirewall findByPk(Object fid) {
		return (ParaFirewall) baseHbnDao.findById(ParaFirewall.class, (Serializable) fid);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("ParaFirewall");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("ParaFirewall", beginPage, pageSize);
	}
	
	public void merge(ParaFirewall paraFirewall){
    	baseHbnDao.merge("ParaFirewall", paraFirewall);
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
