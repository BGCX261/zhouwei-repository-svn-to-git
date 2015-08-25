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
import com.techstar.dmis.dto.DaymodeanalyseDto;
import com.techstar.dmis.entity.Daymodeanalyse;
import com.techstar.dmis.service.IDaymodeanalyseService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DaymodeanalyseServiceImpl implements IDaymodeanalyseService {
   //注册DAO
   private IDaymodeanalyseDao daymodeanalyseDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public DaymodeanalyseServiceImpl() {}
	
	public void addDaymodeanalyse(DaymodeanalyseDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		Daymodeanalyse daymodeanalyse = (Daymodeanalyse) BeanHelper.buildBean(Daymodeanalyse.class, dto);
		daymodeanalyseDao.saveOrUpdate(daymodeanalyse);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDaymodeanalyse(DaymodeanalyseDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		Daymodeanalyse daymodeanalyse = (Daymodeanalyse) BeanHelper.buildBean(Daymodeanalyse.class, dto);
		daymodeanalyseDao.saveOrUpdate(daymodeanalyse);
	}
    //用于实现基本删除操作
	public void deleteDaymodeanalyse(String daymodeanalyseId) {
		Daymodeanalyse daymodeanalyse = new Daymodeanalyse();
		daymodeanalyse.setFid(daymodeanalyseId);
		daymodeanalyseDao.delete(daymodeanalyse);
	}
	//用于实现基本删除集合操作
	public void deleteDaymodeanalyse(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(Daymodeanalyse.class, dtos);
		daymodeanalyseDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public DaymodeanalyseDto loadDaymodeanalyse(String fid) {
		Daymodeanalyse daymodeanalyse = (Daymodeanalyse) daymodeanalyseDao.findByPk(fid);
		DaymodeanalyseDto dto = (DaymodeanalyseDto) BeanHelper.buildBean(DaymodeanalyseDto.class, daymodeanalyse);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listDaymodeanalyse() {
		QueryListObj obj = daymodeanalyseDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DaymodeanalyseDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDaymodeanalyseByHql(String hql) {
		QueryListObj obj = daymodeanalyseDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DaymodeanalyseDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDaymodeanalyseByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = daymodeanalyseDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DaymodeanalyseDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = daymodeanalyseDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDaymodeanalyseDao getDaymodeanalyseDao() {
		return daymodeanalyseDao;
	}

	public void setDaymodeanalyseDao(IDaymodeanalyseDao daymodeanalyseDao) {
		this.daymodeanalyseDao = daymodeanalyseDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDaymodeanalyse(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DaymodeanalyseDto daymodeanalyseDto = (DaymodeanalyseDto)dtos.get(i);
			Daymodeanalyse daymodeanalyse = (Daymodeanalyse) BeanHelper.buildBean(Daymodeanalyse.class, daymodeanalyseDto);
		    pos.add(daymodeanalyse);
		}
		
		daymodeanalyseDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
