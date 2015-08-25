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
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.entity.HandleHistory;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.util.DateUtil;

public class HandleHistoryDaoImpl implements IHandleHistoryDao {
	private IBaseHbnDao baseHbnDao;
   
    public void delete(HandleHistory handleHistory){
		baseHbnDao.delete(handleHistory);
	}
	public void deleteAll(List pos){
		baseHbnDao.deleteAll(pos);
	}
	
	public void saveOrUpdate(WorkflowHandleDto dto) {
		HandleHistory handleHistory = new HandleHistory();
		handleHistory.setBus_id(dto.getBusId());
		handleHistory.setHandle_comment(dto.getNotices());
		handleHistory.setHandle_person(dto.getUserId());
		handleHistory.setHandle_result("");
		handleHistory.setHandle_time(DateUtil.getCurrentTimestamp());
		handleHistory.setId(new SequenceCreator().getUID());
		
		baseHbnDao.saveOrUpdate("HandleHistory", handleHistory);
	}
	
	public void saveOrUpdate(HandleHistory handleHistory) {
		baseHbnDao.saveOrUpdate("HandleHistory", handleHistory);
	}

	public HandleHistory findByPk(Object id) {
		return (HandleHistory) baseHbnDao.findById(HandleHistory.class, (Serializable) id);
	}

	public QueryListObj getQueryList() {
		return baseHbnDao.getQueryListByEntityName("HandleHistory");
	}

	public QueryListObj getQueryList(int beginPage,
			int pageSize) {
		return baseHbnDao.getQueryListByEntityName("HandleHistory", beginPage, pageSize);
	}
	
	public void merge(HandleHistory handleHistory){
    	baseHbnDao.merge("HandleHistory", handleHistory);
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
