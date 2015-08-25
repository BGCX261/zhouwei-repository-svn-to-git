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
import com.techstar.dmis.dto.StdManufacturerDto;
import com.techstar.dmis.entity.StdManufacturer;
import com.techstar.dmis.service.IStdManufacturerService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.EtsEquipmentDto;
import com.techstar.dmis.entity.EtsEquipment;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class StdManufacturerServiceImpl implements IStdManufacturerService {
   //注册DAO
   private IStdManufacturerDao stdManufacturerDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IEtsEquipmentDao etsEquipmentDao;
	 public void setEtsEquipmentDao
	    (IEtsEquipmentDao etsEquipmentDao) {
		 this.etsEquipmentDao = etsEquipmentDao;
     }
	  	

	public StdManufacturerServiceImpl() {}
	
	public void addStdManufacturer(StdManufacturerDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		StdManufacturer stdManufacturer = (StdManufacturer) BeanHelper.buildBean(StdManufacturer.class, dto);
		stdManufacturerDao.saveOrUpdate(stdManufacturer);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateStdManufacturer(StdManufacturerDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdManufacturer stdManufacturer = (StdManufacturer) BeanHelper.buildBean(StdManufacturer.class, dto);
		stdManufacturerDao.saveOrUpdate(stdManufacturer);
	}
    //用于实现基本删除操作
	public void deleteStdManufacturer(String stdManufacturerId) {
		StdManufacturer stdManufacturer = new StdManufacturer();
		stdManufacturer.setId(stdManufacturerId);
		stdManufacturerDao.delete(stdManufacturer);
	}
	//用于实现基本删除集合操作
	public void deleteStdManufacturer(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdManufacturer.class, dtos);
		stdManufacturerDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public StdManufacturerDto loadStdManufacturer(String id) {
		StdManufacturer stdManufacturer = (StdManufacturer) stdManufacturerDao.findByPk(id);
		StdManufacturerDto dto = (StdManufacturerDto) BeanHelper.buildBean(StdManufacturerDto.class, stdManufacturer);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listStdManufacturer() {
		QueryListObj obj = stdManufacturerDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdManufacturerDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listStdManufacturerByHql(String hql) {
		QueryListObj obj = stdManufacturerDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdManufacturerDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getStdManufacturerByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = stdManufacturerDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdManufacturerDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = stdManufacturerDao.getObjPropertySums(sql);
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
	
	public IStdManufacturerDao getStdManufacturerDao() {
		return stdManufacturerDao;
	}

	public void setStdManufacturerDao(IStdManufacturerDao stdManufacturerDao) {
		this.stdManufacturerDao = stdManufacturerDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateStdManufacturer(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdManufacturerDto stdManufacturerDto = (StdManufacturerDto)dtos.get(i);
			StdManufacturer stdManufacturer = (StdManufacturer) BeanHelper.buildBean(StdManufacturer.class, stdManufacturerDto);
		    pos.add(stdManufacturer);
		}
		
		stdManufacturerDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listEtsEquipment() {
		QueryListObj obj = etsEquipmentDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(EtsEquipmentDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateEtsEquipment(EtsEquipmentDto dto){
   
     if (StringUtils.isEmpty(dto.getFeqpid())){
		      if( StringUtils.isEmpty(dto.getFeqpid())){
		          dto.setFeqpid(new SequenceCreator().getUID());
		       }
		}
		EtsEquipment etsEquipment = (EtsEquipment) BeanHelper.buildBean(EtsEquipment.class, dto);
		etsEquipmentDao.saveOrUpdate(etsEquipment);
   
   }
   public void deleteEtsEquipment(String feqpid){
     
        EtsEquipment etsEquipment = new EtsEquipment();
		etsEquipment.setFeqpid(feqpid);
		etsEquipmentDao.delete(etsEquipment);
   
   }
   public EtsEquipmentDto loadEtsEquipment(String feqpid){
        EtsEquipment etsEquipment = (EtsEquipment) etsEquipmentDao.findByPk(feqpid);
		EtsEquipmentDto dto = (EtsEquipmentDto) BeanHelper.buildBean(EtsEquipmentDto.class, etsEquipment);
		return dto;
   }
   public QueryListObj listEtsEquipmentByHql(String hql){
      QueryListObj obj = etsEquipmentDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(EtsEquipmentDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateEtsEquipment(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			EtsEquipmentDto etsEquipmentDto = (EtsEquipmentDto)dtos.get(i);
			EtsEquipment etsEquipment = (EtsEquipment) BeanHelper.buildBean(EtsEquipment.class, etsEquipmentDto);
		    pos.add(etsEquipment);
		}
		
		etsEquipmentDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteEtsEquipment(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(EtsEquipment.class, dtos);
		etsEquipmentDao.deleteAll(pos);
   }
	
	  	


	
}
