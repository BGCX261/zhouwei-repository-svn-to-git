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
import com.techstar.dmis.dto.StdElectricstampDto;
import com.techstar.dmis.entity.StdElectricstamp;
import com.techstar.dmis.service.IStdElectricstampService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class StdElectricstampServiceImpl implements IStdElectricstampService {
   //注册DAO
   private IStdElectricstampDao stdElectricstampDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public StdElectricstampServiceImpl() {}
	
	public void addStdElectricstamp(StdElectricstampDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		StdElectricstamp stdElectricstamp = (StdElectricstamp) BeanHelper.buildBean(StdElectricstamp.class, dto);
		stdElectricstampDao.saveOrUpdate(stdElectricstamp);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateStdElectricstamp(StdElectricstampDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdElectricstamp stdElectricstamp = (StdElectricstamp) BeanHelper.buildBean(StdElectricstamp.class, dto);
		stdElectricstampDao.saveOrUpdate(stdElectricstamp);
	}
    //用于实现基本删除操作
	public void deleteStdElectricstamp(String stdElectricstampId) {
		StdElectricstamp stdElectricstamp = new StdElectricstamp();
		stdElectricstamp.setId(stdElectricstampId);
		stdElectricstampDao.delete(stdElectricstamp);
	}
	//用于实现基本删除集合操作
	public void deleteStdElectricstamp(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdElectricstamp.class, dtos);
		stdElectricstampDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public StdElectricstampDto loadStdElectricstamp(String id) {
		StdElectricstamp stdElectricstamp = (StdElectricstamp) stdElectricstampDao.findByPk(id);
		StdElectricstampDto dto = (StdElectricstampDto) BeanHelper.buildBean(StdElectricstampDto.class, stdElectricstamp);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listStdElectricstamp() {
		QueryListObj obj = stdElectricstampDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdElectricstampDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listStdElectricstampByHql(String hql) {
		QueryListObj obj = stdElectricstampDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdElectricstampDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getStdElectricstampByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = stdElectricstampDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdElectricstampDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = stdElectricstampDao.getObjPropertySums(sql);
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
	
	public IStdElectricstampDao getStdElectricstampDao() {
		return stdElectricstampDao;
	}

	public void setStdElectricstampDao(IStdElectricstampDao stdElectricstampDao) {
		this.stdElectricstampDao = stdElectricstampDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateStdElectricstamp(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdElectricstampDto stdElectricstampDto = (StdElectricstampDto)dtos.get(i);
			StdElectricstamp stdElectricstamp = (StdElectricstamp) BeanHelper.buildBean(StdElectricstamp.class, stdElectricstampDto);
		    pos.add(stdElectricstamp);
		}
		
		stdElectricstampDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
