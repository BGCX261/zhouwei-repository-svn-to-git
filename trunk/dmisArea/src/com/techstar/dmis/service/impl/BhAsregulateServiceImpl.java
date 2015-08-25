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
import com.techstar.dmis.dto.BhAsregulateDto;
import com.techstar.dmis.entity.BhAsregulate;
import com.techstar.dmis.service.IBhAsregulateService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.BhAsregulatedetailDto;
import com.techstar.dmis.entity.BhAsregulatedetail;
	import com.techstar.dmis.dto.StdStationDto;
import com.techstar.dmis.entity.StdStation;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class BhAsregulateServiceImpl implements IBhAsregulateService {
   //注册DAO
   private IBhAsregulateDao bhAsregulateDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IBhAsregulatedetailDao bhAsregulatedetailDao;
	 public void setBhAsregulatedetailDao
	    (IBhAsregulatedetailDao bhAsregulatedetailDao) {
		 this.bhAsregulatedetailDao = bhAsregulatedetailDao;
     }
		 private IStdStationDao stdStationDao;
	 public void setStdStationDao
	    (IStdStationDao stdStationDao) {
		 this.stdStationDao = stdStationDao;
     }
	  	

	public BhAsregulateServiceImpl() {}
	
	public void addBhAsregulate(BhAsregulateDto dto) {
	
    	if (StringUtils.isEmpty(dto.getAsregulateid())){
		      if( StringUtils.isEmpty(dto.getAsregulateid())){
		          dto.setAsregulateid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, dto);
		bhAsregulateDao.saveOrUpdate(bhAsregulate);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateBhAsregulate(BhAsregulateDto dto) {
		if (StringUtils.isEmpty(dto.getAsregulateid())){
		      if( StringUtils.isEmpty(dto.getAsregulateid())){
		          dto.setAsregulateid(new SequenceCreator().getUID());
		       }
		}
		BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, dto);
		bhAsregulateDao.saveOrUpdate(bhAsregulate);
	}
    //用于实现基本删除操作
	public void deleteBhAsregulate(String bhAsregulateId) {
		BhAsregulate bhAsregulate = new BhAsregulate();
		bhAsregulate.setAsregulateid(bhAsregulateId);
		bhAsregulateDao.delete(bhAsregulate);
	}
	//用于实现基本删除集合操作
	public void deleteBhAsregulate(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhAsregulate.class, dtos);
		bhAsregulateDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public BhAsregulateDto loadBhAsregulate(String asregulateid) {
		BhAsregulate bhAsregulate = (BhAsregulate) bhAsregulateDao.findByPk(asregulateid);
		BhAsregulateDto dto = (BhAsregulateDto) BeanHelper.buildBean(BhAsregulateDto.class, bhAsregulate);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listBhAsregulate() {
		QueryListObj obj = bhAsregulateDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listBhAsregulateByHql(String hql) {
		QueryListObj obj = bhAsregulateDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getBhAsregulateByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = bhAsregulateDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = bhAsregulateDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @自投规程归档
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IBhAsregulateDao getBhAsregulateDao() {
		return bhAsregulateDao;
	}

	public void setBhAsregulateDao(IBhAsregulateDao bhAsregulateDao) {
		this.bhAsregulateDao = bhAsregulateDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateBhAsregulate(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhAsregulateDto bhAsregulateDto = (BhAsregulateDto)dtos.get(i);
			BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, bhAsregulateDto);
		    pos.add(bhAsregulate);
		}
		
		bhAsregulateDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listBhAsregulatedetail() {
		QueryListObj obj = bhAsregulatedetailDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulatedetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateBhAsregulatedetail(BhAsregulatedetailDto dto){
   
     if (StringUtils.isEmpty(dto.getAsregulatedetailid())){
		      if( StringUtils.isEmpty(dto.getAsregulatedetailid())){
		          dto.setAsregulatedetailid(new SequenceCreator().getUID());
		       }
		}
		BhAsregulatedetail bhAsregulatedetail = (BhAsregulatedetail) BeanHelper.buildBean(BhAsregulatedetail.class, dto);
		bhAsregulatedetailDao.saveOrUpdate(bhAsregulatedetail);
   
   }
   public void deleteBhAsregulatedetail(String asregulatedetailid){
     
        BhAsregulatedetail bhAsregulatedetail = new BhAsregulatedetail();
		bhAsregulatedetail.setAsregulatedetailid(asregulatedetailid);
		bhAsregulatedetailDao.delete(bhAsregulatedetail);
   
   }
   public BhAsregulatedetailDto loadBhAsregulatedetail(String asregulatedetailid){
        BhAsregulatedetail bhAsregulatedetail = (BhAsregulatedetail) bhAsregulatedetailDao.findByPk(asregulatedetailid);
		BhAsregulatedetailDto dto = (BhAsregulatedetailDto) BeanHelper.buildBean(BhAsregulatedetailDto.class, bhAsregulatedetail);
		return dto;
   }
   public QueryListObj listBhAsregulatedetailByHql(String hql){
      QueryListObj obj = bhAsregulatedetailDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulatedetailDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateBhAsregulatedetail(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhAsregulatedetailDto bhAsregulatedetailDto = (BhAsregulatedetailDto)dtos.get(i);
			BhAsregulatedetail bhAsregulatedetail = (BhAsregulatedetail) BeanHelper.buildBean(BhAsregulatedetail.class, bhAsregulatedetailDto);
		    pos.add(bhAsregulatedetail);
		}
		
		bhAsregulatedetailDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteBhAsregulatedetail(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhAsregulatedetail.class, dtos);
		bhAsregulatedetailDao.deleteAll(pos);
   }
	
		

   public QueryListObj listStdStation() {
		QueryListObj obj = stdStationDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateStdStation(StdStationDto dto){
   
     if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdStation stdStation = (StdStation) BeanHelper.buildBean(StdStation.class, dto);
		stdStationDao.saveOrUpdate(stdStation);
   
   }
   public void deleteStdStation(String id){
     
        StdStation stdStation = new StdStation();
		stdStation.setId(id);
		stdStationDao.delete(stdStation);
   
   }
   public StdStationDto loadStdStation(String id){
        StdStation stdStation = (StdStation) stdStationDao.findByPk(id);
		StdStationDto dto = (StdStationDto) BeanHelper.buildBean(StdStationDto.class, stdStation);
		return dto;
   }
   public QueryListObj listStdStationByHql(String hql){
      QueryListObj obj = stdStationDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateStdStation(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdStationDto stdStationDto = (StdStationDto)dtos.get(i);
			StdStation stdStation = (StdStation) BeanHelper.buildBean(StdStation.class, stdStationDto);
		    pos.add(stdStation);
		}
		
		stdStationDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteStdStation(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdStation.class, dtos);
		stdStationDao.deleteAll(pos);
   }
	
	  	


	
}
