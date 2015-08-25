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
import com.techstar.dmis.dto.DdPremethodDto;
import com.techstar.dmis.entity.DdPremethod;
import com.techstar.dmis.service.IDdPremethodService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.entity.DdMoutageplan;
	import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
import com.techstar.dmis.entity.DdEnsuringpsmanage;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DdPremethodServiceImpl implements IDdPremethodService {
   //注册DAO
   private IDdPremethodDao ddPremethodDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdMoutageplanDao ddMoutageplanDao;
	 public void setDdMoutageplanDao
	    (IDdMoutageplanDao ddMoutageplanDao) {
		 this.ddMoutageplanDao = ddMoutageplanDao;
     }
		 private IDdEnsuringpsmanageDao ddEnsuringpsmanageDao;
	 public void setDdEnsuringpsmanageDao
	    (IDdEnsuringpsmanageDao ddEnsuringpsmanageDao) {
		 this.ddEnsuringpsmanageDao = ddEnsuringpsmanageDao;
     }
	  	

	public DdPremethodServiceImpl() {}
	
	public void addDdPremethod(DdPremethodDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFpremethodid())){
		      if( StringUtils.isEmpty(dto.getFpremethodid())){
		          dto.setFpremethodid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		DdPremethod ddPremethod = (DdPremethod) BeanHelper.buildBean(DdPremethod.class, dto);
		ddPremethodDao.saveOrUpdate(ddPremethod);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDdPremethod(DdPremethodDto dto) {
		if (StringUtils.isEmpty(dto.getFpremethodid())){
		      if( StringUtils.isEmpty(dto.getFpremethodid())){
		          dto.setFpremethodid(new SequenceCreator().getUID());
		       }
		}
		DdPremethod ddPremethod = (DdPremethod) BeanHelper.mapBean(DdPremethod.class, dto);
		ddPremethodDao.saveOrUpdate(ddPremethod);
	}
    //用于实现基本删除操作
	public void deleteDdPremethod(String ddPremethodId) {
		DdPremethod ddPremethod = new DdPremethod();
		ddPremethod.setFpremethodid(ddPremethodId);
		ddPremethodDao.delete(ddPremethod);
	}
	//用于实现基本删除集合操作
	public void deleteDdPremethod(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdPremethod.class, dtos);
		ddPremethodDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public DdPremethodDto loadDdPremethod(String fpremethodid) {
		DdPremethod ddPremethod = (DdPremethod) ddPremethodDao.findByPk(fpremethodid);
		DdPremethodDto dto = (DdPremethodDto) BeanHelper.buildBean(DdPremethodDto.class, ddPremethod);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listDdPremethod() {
		QueryListObj obj = ddPremethodDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPremethodDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdPremethodByHql(String hql) {
		QueryListObj obj = ddPremethodDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPremethodDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdPremethodByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddPremethodDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPremethodDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddPremethodDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @归档
	 	* @保电预案编制
	 	* @月计划预案编制
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDdPremethodDao getDdPremethodDao() {
		return ddPremethodDao;
	}

	public void setDdPremethodDao(IDdPremethodDao ddPremethodDao) {
		this.ddPremethodDao = ddPremethodDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdPremethod(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdPremethodDto ddPremethodDto = (DdPremethodDto)dtos.get(i);
			DdPremethod ddPremethod = (DdPremethod) BeanHelper.buildBean(DdPremethod.class, ddPremethodDto);
		    pos.add(ddPremethod);
		}
		
		ddPremethodDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listDdMoutageplan() {
		QueryListObj obj = ddMoutageplanDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdMoutageplanDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdMoutageplan(DdMoutageplanDto dto){
   
     if (StringUtils.isEmpty(dto.getFmonthplanno())){
		      if( StringUtils.isEmpty(dto.getFmonthplanno())){
		          dto.setFmonthplanno(new SequenceCreator().getUID());
		       }
		}
		DdMoutageplan ddMoutageplan = (DdMoutageplan) BeanHelper.buildBean(DdMoutageplan.class, dto);
		ddMoutageplanDao.saveOrUpdate(ddMoutageplan);
   
   }
   public void deleteDdMoutageplan(String fmonthplanno){
     
        DdMoutageplan ddMoutageplan = new DdMoutageplan();
		ddMoutageplan.setFmonthplanno(fmonthplanno);
		ddMoutageplanDao.delete(ddMoutageplan);
   
   }
   public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno){
        DdMoutageplan ddMoutageplan = (DdMoutageplan) ddMoutageplanDao.findByPk(fmonthplanno);
		DdMoutageplanDto dto = (DdMoutageplanDto) BeanHelper.buildBean(DdMoutageplanDto.class, ddMoutageplan);
		return dto;
   }
   public QueryListObj listDdMoutageplanByHql(String hql){
      QueryListObj obj = ddMoutageplanDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdMoutageplanDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdMoutageplan(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdMoutageplanDto ddMoutageplanDto = (DdMoutageplanDto)dtos.get(i);
			DdMoutageplan ddMoutageplan = (DdMoutageplan) BeanHelper.buildBean(DdMoutageplan.class, ddMoutageplanDto);
		    pos.add(ddMoutageplan);
		}
		
		ddMoutageplanDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdMoutageplan(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdMoutageplan.class, dtos);
		ddMoutageplanDao.deleteAll(pos);
   }
	
		

   public QueryListObj listDdEnsuringpsmanage() {
		QueryListObj obj = ddEnsuringpsmanageDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdEnsuringpsmanageDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdEnsuringpsmanage(DdEnsuringpsmanageDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdEnsuringpsmanage ddEnsuringpsmanage = (DdEnsuringpsmanage) BeanHelper.buildBean(DdEnsuringpsmanage.class, dto);
		ddEnsuringpsmanageDao.saveOrUpdate(ddEnsuringpsmanage);
   
   }
   public void deleteDdEnsuringpsmanage(String fid){
     
        DdEnsuringpsmanage ddEnsuringpsmanage = new DdEnsuringpsmanage();
		ddEnsuringpsmanage.setFid(fid);
		ddEnsuringpsmanageDao.delete(ddEnsuringpsmanage);
   
   }
   public DdEnsuringpsmanageDto loadDdEnsuringpsmanage(String fid){
        DdEnsuringpsmanage ddEnsuringpsmanage = (DdEnsuringpsmanage) ddEnsuringpsmanageDao.findByPk(fid);
		DdEnsuringpsmanageDto dto = (DdEnsuringpsmanageDto) BeanHelper.buildBean(DdEnsuringpsmanageDto.class, ddEnsuringpsmanage);
		return dto;
   }
   public QueryListObj listDdEnsuringpsmanageByHql(String hql){
      QueryListObj obj = ddEnsuringpsmanageDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdEnsuringpsmanageDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdEnsuringpsmanage(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdEnsuringpsmanageDto ddEnsuringpsmanageDto = (DdEnsuringpsmanageDto)dtos.get(i);
			DdEnsuringpsmanage ddEnsuringpsmanage = (DdEnsuringpsmanage) BeanHelper.buildBean(DdEnsuringpsmanage.class, ddEnsuringpsmanageDto);
		    pos.add(ddEnsuringpsmanage);
		}
		
		ddEnsuringpsmanageDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdEnsuringpsmanage(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdEnsuringpsmanage.class, dtos);
		ddEnsuringpsmanageDao.deleteAll(pos);
   }


public QueryListObj listDdPremethodByHQL(String hql) {
	return ddPremethodDao.getQueryListByHql(hql);
}
	
	  	


	
}
