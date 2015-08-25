package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.BhFaultlistDto;
import com.techstar.dmis.entity.BhFaultlist;
import com.techstar.dmis.service.IBhFaultlistService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class BhFaultlistServiceImpl implements IBhFaultlistService {
   //注册DAO
   private IBhFaultlistDao bhFaultlistDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public BhFaultlistServiceImpl() {}
	
	public void addBhFaultlist(BhFaultlistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFfaultno())){
		      if( StringUtils.isEmpty(dto.getFfaultno())){
		          dto.setFfaultno(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		BhFaultlist bhFaultlist = (BhFaultlist) BeanHelper.buildBean(BhFaultlist.class, dto);
		bhFaultlistDao.saveOrUpdate(bhFaultlist);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateBhFaultlist(BhFaultlistDto dto) {
		if (StringUtils.isEmpty(dto.getFfaultno())){
		      if( StringUtils.isEmpty(dto.getFfaultno())){
		          dto.setFfaultno(new SequenceCreator().getUID());
		       }
		}
		BhFaultlist bhFaultlist = (BhFaultlist) BeanHelper.buildBean(BhFaultlist.class, dto);
		bhFaultlistDao.saveOrUpdate(bhFaultlist);
	}
    //用于实现基本删除操作
	public void deleteBhFaultlist(String bhFaultlistId) {
		BhFaultlist bhFaultlist = new BhFaultlist();
		bhFaultlist.setFfaultno(bhFaultlistId);
		bhFaultlistDao.delete(bhFaultlist);
	}
	//用于实现基本删除集合操作
	public void deleteBhFaultlist(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhFaultlist.class, dtos);
		bhFaultlistDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public BhFaultlistDto loadBhFaultlist(String ffaultno) {
		BhFaultlist bhFaultlist = (BhFaultlist) bhFaultlistDao.findByPk(ffaultno);
		BhFaultlistDto dto = (BhFaultlistDto) BeanHelper.buildBean(BhFaultlistDto.class, bhFaultlist);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listBhFaultlist() {
		QueryListObj obj = bhFaultlistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFaultlistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listBhFaultlistByHql(String hql) {
		QueryListObj obj = bhFaultlistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFaultlistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getBhFaultlistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = bhFaultlistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhFaultlistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = bhFaultlistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @从设备台帐取值
	 	* @选择故障
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IBhFaultlistDao getBhFaultlistDao() {
		return bhFaultlistDao;
	}

	public void setBhFaultlistDao(IBhFaultlistDao bhFaultlistDao) {
		this.bhFaultlistDao = bhFaultlistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateBhFaultlist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhFaultlistDto bhFaultlistDto = (BhFaultlistDto)dtos.get(i);
			BhFaultlist bhFaultlist = (BhFaultlist) BeanHelper.buildBean(BhFaultlist.class, bhFaultlistDto);
		    pos.add(bhFaultlist);
		}
		
		bhFaultlistDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
