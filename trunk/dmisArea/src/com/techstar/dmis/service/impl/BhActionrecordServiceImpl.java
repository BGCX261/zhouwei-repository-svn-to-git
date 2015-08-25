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
import com.techstar.dmis.dto.BhActionrecordDto;
import com.techstar.dmis.entity.BhActionrecord;
import com.techstar.dmis.service.IBhActionrecordService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.StdBhtresponseDto;
import com.techstar.dmis.entity.StdBhtresponse;
	import com.techstar.dmis.dto.StdPreasontypeDto;
import com.techstar.dmis.entity.StdPreasontype;
	import com.techstar.dmis.dto.StdBheqpfaultDto;
import com.techstar.dmis.entity.StdBheqpfault;
	import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.entity.DdAccidentbrief;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class BhActionrecordServiceImpl implements IBhActionrecordService {
   //注册DAO
   private IBhActionrecordDao bhActionrecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IStdBhtresponseDao stdBhtresponseDao;
	 public void setStdBhtresponseDao
	    (IStdBhtresponseDao stdBhtresponseDao) {
		 this.stdBhtresponseDao = stdBhtresponseDao;
     }
		 private IStdPreasontypeDao stdPreasontypeDao;
	 public void setStdPreasontypeDao
	    (IStdPreasontypeDao stdPreasontypeDao) {
		 this.stdPreasontypeDao = stdPreasontypeDao;
     }
		 private IStdBheqpfaultDao stdBheqpfaultDao;
	 public void setStdBheqpfaultDao
	    (IStdBheqpfaultDao stdBheqpfaultDao) {
		 this.stdBheqpfaultDao = stdBheqpfaultDao;
     }
		 private IDdAccidentbriefDao ddAccidentbriefDao;
	 public void setDdAccidentbriefDao
	    (IDdAccidentbriefDao ddAccidentbriefDao) {
		 this.ddAccidentbriefDao = ddAccidentbriefDao;
     }
	  	

	public BhActionrecordServiceImpl() {}
	
	public void addBhActionrecord(BhActionrecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getProtectionrecordid())){
		      if( StringUtils.isEmpty(dto.getProtectionrecordid())){
		          dto.setProtectionrecordid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		BhActionrecord bhActionrecord = (BhActionrecord) BeanHelper.buildBean(BhActionrecord.class, dto);
		bhActionrecordDao.saveOrUpdate(bhActionrecord);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateBhActionrecord(BhActionrecordDto dto) {
		if (StringUtils.isEmpty(dto.getProtectionrecordid())){
		      if( StringUtils.isEmpty(dto.getProtectionrecordid())){
		          dto.setProtectionrecordid(new SequenceCreator().getUID());
		       }
		}
		BhActionrecord bhActionrecord = (BhActionrecord) BeanHelper.buildBean(BhActionrecord.class, dto);
		bhActionrecordDao.saveOrUpdate(bhActionrecord);
	}
    //用于实现基本删除操作
	public void deleteBhActionrecord(String bhActionrecordId) {
		BhActionrecord bhActionrecord = new BhActionrecord();
		bhActionrecord.setProtectionrecordid(bhActionrecordId);
		bhActionrecordDao.delete(bhActionrecord);
	}
	//用于实现基本删除集合操作
	public void deleteBhActionrecord(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhActionrecord.class, dtos);
		bhActionrecordDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public BhActionrecordDto loadBhActionrecord(String protectionrecordid) {
		BhActionrecord bhActionrecord = (BhActionrecord) bhActionrecordDao.findByPk(protectionrecordid);
		BhActionrecordDto dto = (BhActionrecordDto) BeanHelper.buildBean(BhActionrecordDto.class, bhActionrecord);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listBhActionrecord() {
		QueryListObj obj = bhActionrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhActionrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listBhActionrecordByHql(String hql) {
		QueryListObj obj = bhActionrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhActionrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getBhActionrecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = bhActionrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhActionrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = bhActionrecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @选择故障
	 	* @选择设备
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IBhActionrecordDao getBhActionrecordDao() {
		return bhActionrecordDao;
	}

	public void setBhActionrecordDao(IBhActionrecordDao bhActionrecordDao) {
		this.bhActionrecordDao = bhActionrecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateBhActionrecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhActionrecordDto bhActionrecordDto = (BhActionrecordDto)dtos.get(i);
			BhActionrecord bhActionrecord = (BhActionrecord) BeanHelper.buildBean(BhActionrecord.class, bhActionrecordDto);
		    pos.add(bhActionrecord);
		}
		
		bhActionrecordDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listStdBhtresponse() {
		QueryListObj obj = stdBhtresponseDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdBhtresponseDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateStdBhtresponse(StdBhtresponseDto dto){
   
     if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdBhtresponse stdBhtresponse = (StdBhtresponse) BeanHelper.buildBean(StdBhtresponse.class, dto);
		stdBhtresponseDao.saveOrUpdate(stdBhtresponse);
   
   }
   public void deleteStdBhtresponse(String id){
     
        StdBhtresponse stdBhtresponse = new StdBhtresponse();
		stdBhtresponse.setId(id);
		stdBhtresponseDao.delete(stdBhtresponse);
   
   }
   public StdBhtresponseDto loadStdBhtresponse(String id){
        StdBhtresponse stdBhtresponse = (StdBhtresponse) stdBhtresponseDao.findByPk(id);
		StdBhtresponseDto dto = (StdBhtresponseDto) BeanHelper.buildBean(StdBhtresponseDto.class, stdBhtresponse);
		return dto;
   }
   public QueryListObj listStdBhtresponseByHql(String hql){
      QueryListObj obj = stdBhtresponseDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdBhtresponseDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateStdBhtresponse(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdBhtresponseDto stdBhtresponseDto = (StdBhtresponseDto)dtos.get(i);
			StdBhtresponse stdBhtresponse = (StdBhtresponse) BeanHelper.buildBean(StdBhtresponse.class, stdBhtresponseDto);
		    pos.add(stdBhtresponse);
		}
		
		stdBhtresponseDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteStdBhtresponse(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdBhtresponse.class, dtos);
		stdBhtresponseDao.deleteAll(pos);
   }
	
		

   public QueryListObj listStdPreasontype() {
		QueryListObj obj = stdPreasontypeDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdPreasontypeDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateStdPreasontype(StdPreasontypeDto dto){
   
     if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdPreasontype stdPreasontype = (StdPreasontype) BeanHelper.buildBean(StdPreasontype.class, dto);
		stdPreasontypeDao.saveOrUpdate(stdPreasontype);
   
   }
   public void deleteStdPreasontype(String id){
     
        StdPreasontype stdPreasontype = new StdPreasontype();
		stdPreasontype.setId(id);
		stdPreasontypeDao.delete(stdPreasontype);
   
   }
   public StdPreasontypeDto loadStdPreasontype(String id){
        StdPreasontype stdPreasontype = (StdPreasontype) stdPreasontypeDao.findByPk(id);
		StdPreasontypeDto dto = (StdPreasontypeDto) BeanHelper.buildBean(StdPreasontypeDto.class, stdPreasontype);
		return dto;
   }
   public QueryListObj listStdPreasontypeByHql(String hql){
      QueryListObj obj = stdPreasontypeDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdPreasontypeDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateStdPreasontype(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdPreasontypeDto stdPreasontypeDto = (StdPreasontypeDto)dtos.get(i);
			StdPreasontype stdPreasontype = (StdPreasontype) BeanHelper.buildBean(StdPreasontype.class, stdPreasontypeDto);
		    pos.add(stdPreasontype);
		}
		
		stdPreasontypeDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteStdPreasontype(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdPreasontype.class, dtos);
		stdPreasontypeDao.deleteAll(pos);
   }
	
		

   public QueryListObj listStdBheqpfault() {
		QueryListObj obj = stdBheqpfaultDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdBheqpfaultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateStdBheqpfault(StdBheqpfaultDto dto){
   
     if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdBheqpfault stdBheqpfault = (StdBheqpfault) BeanHelper.buildBean(StdBheqpfault.class, dto);
		stdBheqpfaultDao.saveOrUpdate(stdBheqpfault);
   
   }
   public void deleteStdBheqpfault(String id){
     
        StdBheqpfault stdBheqpfault = new StdBheqpfault();
		stdBheqpfault.setId(id);
		stdBheqpfaultDao.delete(stdBheqpfault);
   
   }
   public StdBheqpfaultDto loadStdBheqpfault(String id){
        StdBheqpfault stdBheqpfault = (StdBheqpfault) stdBheqpfaultDao.findByPk(id);
		StdBheqpfaultDto dto = (StdBheqpfaultDto) BeanHelper.buildBean(StdBheqpfaultDto.class, stdBheqpfault);
		return dto;
   }
   public QueryListObj listStdBheqpfaultByHql(String hql){
      QueryListObj obj = stdBheqpfaultDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdBheqpfaultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateStdBheqpfault(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdBheqpfaultDto stdBheqpfaultDto = (StdBheqpfaultDto)dtos.get(i);
			StdBheqpfault stdBheqpfault = (StdBheqpfault) BeanHelper.buildBean(StdBheqpfault.class, stdBheqpfaultDto);
		    pos.add(stdBheqpfault);
		}
		
		stdBheqpfaultDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteStdBheqpfault(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdBheqpfault.class, dtos);
		stdBheqpfaultDao.deleteAll(pos);
   }
	
		

   public QueryListObj listDdAccidentbrief() {
		QueryListObj obj = ddAccidentbriefDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdAccidentbriefDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdAccidentbrief(DdAccidentbriefDto dto){
   
     if (StringUtils.isEmpty(dto.getFaccidentid())){
		      if( StringUtils.isEmpty(dto.getFaccidentid())){
		          dto.setFaccidentid(new SequenceCreator().getUID());
		       }
		}
		DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) BeanHelper.buildBean(DdAccidentbrief.class, dto);
		ddAccidentbriefDao.saveOrUpdate(ddAccidentbrief);
   
   }
   public void deleteDdAccidentbrief(String faccidentid){
     
        DdAccidentbrief ddAccidentbrief = new DdAccidentbrief();
		ddAccidentbrief.setFaccidentid(faccidentid);
		ddAccidentbriefDao.delete(ddAccidentbrief);
   
   }
   public DdAccidentbriefDto loadDdAccidentbrief(String faccidentid){
        DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) ddAccidentbriefDao.findByPk(faccidentid);
		DdAccidentbriefDto dto = (DdAccidentbriefDto) BeanHelper.buildBean(DdAccidentbriefDto.class, ddAccidentbrief);
		return dto;
   }
   public QueryListObj listDdAccidentbriefByHql(String hql){
      QueryListObj obj = ddAccidentbriefDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdAccidentbriefDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdAccidentbrief(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdAccidentbriefDto ddAccidentbriefDto = (DdAccidentbriefDto)dtos.get(i);
			DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) BeanHelper.buildBean(DdAccidentbrief.class, ddAccidentbriefDto);
		    pos.add(ddAccidentbrief);
		}
		
		ddAccidentbriefDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdAccidentbrief(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdAccidentbrief.class, dtos);
		ddAccidentbriefDao.deleteAll(pos);
   }
	
	  	


	
}
