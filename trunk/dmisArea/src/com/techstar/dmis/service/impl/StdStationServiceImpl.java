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
import com.techstar.dmis.dto.StdStationDto;
import com.techstar.dmis.entity.StdStation;
import com.techstar.dmis.service.IStdStationService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.entity.ZdhTransrecord;
	import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.entity.DdHpoweroperaterrd;
	import com.techstar.dmis.dto.DdWaterheightDto;
import com.techstar.dmis.entity.DdWaterheight;
	import com.techstar.dmis.dto.BhAsregulateDto;
import com.techstar.dmis.entity.BhAsregulate;
	import com.techstar.dmis.dto.DdPowerchangrecordDto;
import com.techstar.dmis.entity.DdPowerchangrecord;
	import com.techstar.dmis.dto.ZdhRmrecDto;
import com.techstar.dmis.entity.ZdhRmrec;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class StdStationServiceImpl implements IStdStationService {
   //注册DAO
   private IStdStationDao stdStationDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
   /*
    	 private IZdhTransrecordDao zdhTransrecordDao;
	 public void setZdhTransrecordDao
	    (IZdhTransrecordDao zdhTransrecordDao) {
		 this.zdhTransrecordDao = zdhTransrecordDao;
     }
		 private IDdHpoweroperaterrdDao ddHpoweroperaterrdDao;
	 public void setDdHpoweroperaterrdDao
	    (IDdHpoweroperaterrdDao ddHpoweroperaterrdDao) {
		 this.ddHpoweroperaterrdDao = ddHpoweroperaterrdDao;
     }
		 private IDdWaterheightDao ddWaterheightDao;
	 public void setDdWaterheightDao
	    (IDdWaterheightDao ddWaterheightDao) {
		 this.ddWaterheightDao = ddWaterheightDao;
     }
		 private IBhAsregulateDao bhAsregulateDao;
	 public void setBhAsregulateDao
	    (IBhAsregulateDao bhAsregulateDao) {
		 this.bhAsregulateDao = bhAsregulateDao;
     }
		 private IDdPowerchangrecordDao ddPowerchangrecordDao;
	 public void setDdPowerchangrecordDao
	    (IDdPowerchangrecordDao ddPowerchangrecordDao) {
		 this.ddPowerchangrecordDao = ddPowerchangrecordDao;
     }
		 private IZdhRmrecDao zdhRmrecDao;
	 public void setZdhRmrecDao
	    (IZdhRmrecDao zdhRmrecDao) {
		 this.zdhRmrecDao = zdhRmrecDao;
     }
	  	*/

	public StdStationServiceImpl() {}
	
	public void addStdStation(StdStationDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		StdStation stdStation = (StdStation) BeanHelper.buildBean(StdStation.class, dto);
		stdStationDao.saveOrUpdate(stdStation);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateStdStation(StdStationDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdStation stdStation = (StdStation) BeanHelper.buildBean(StdStation.class, dto);
		stdStationDao.saveOrUpdate(stdStation);
	}
    //用于实现基本删除操作
	public void deleteStdStation(String stdStationId) {
		StdStation stdStation = new StdStation();
		stdStation.setId(stdStationId);
		stdStationDao.delete(stdStation);
	}
	
	//用于实现基本删除集合操作
	public void deleteStdStation(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdStation.class, dtos);
		stdStationDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public StdStationDto loadStdStation(String id) {
		StdStation stdStation = (StdStation) stdStationDao.findByPk(id);
		StdStationDto dto = (StdStationDto) BeanHelper.buildBean(StdStationDto.class, stdStation);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listStdStation() {
		QueryListObj obj = stdStationDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listStdStationByHql(String hql) {
		QueryListObj obj = stdStationDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getStdStationByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = stdStationDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = stdStationDao.getObjPropertySums(sql);
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
	
	public IStdStationDao getStdStationDao() {
		return stdStationDao;
	}

	public void setStdStationDao(IStdStationDao stdStationDao) {
		this.stdStationDao = stdStationDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateStdStation(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdStationDto stdStationDto = (StdStationDto)dtos.get(i);
			StdStation stdStation = (StdStation) BeanHelper.buildBean(StdStation.class, stdStationDto);
		    pos.add(stdStation);
		}
		
		stdStationDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	
  /*
   public QueryListObj listZdhTransrecord() {
		QueryListObj obj = zdhTransrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhTransrecord(ZdhTransrecordDto dto){
   
     if (StringUtils.isEmpty(dto.getTransrecordid())){
		      if( StringUtils.isEmpty(dto.getTransrecordid())){
		          dto.setTransrecordid(new SequenceCreator().getUID());
		       }
		}
		ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.buildBean(ZdhTransrecord.class, dto);
		zdhTransrecordDao.saveOrUpdate(zdhTransrecord);
   
   }
   public void deleteZdhTransrecord(String transrecordid){
     
        ZdhTransrecord zdhTransrecord = new ZdhTransrecord();
		zdhTransrecord.setTransrecordid(transrecordid);
		zdhTransrecordDao.delete(zdhTransrecord);
   
   }
   public ZdhTransrecordDto loadZdhTransrecord(String transrecordid){
        ZdhTransrecord zdhTransrecord = (ZdhTransrecord) zdhTransrecordDao.findByPk(transrecordid);
		ZdhTransrecordDto dto = (ZdhTransrecordDto) BeanHelper.buildBean(ZdhTransrecordDto.class, zdhTransrecord);
		return dto;
   }
   public QueryListObj listZdhTransrecordByHql(String hql){
      QueryListObj obj = zdhTransrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhTransrecord(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhTransrecordDto zdhTransrecordDto = (ZdhTransrecordDto)dtos.get(i);
			ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.buildBean(ZdhTransrecord.class, zdhTransrecordDto);
		    pos.add(zdhTransrecord);
		}
		
		zdhTransrecordDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhTransrecord(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhTransrecord.class, dtos);
		zdhTransrecordDao.deleteAll(pos);
   }
	
		

   public QueryListObj listDdHpoweroperaterrd() {
		QueryListObj obj = ddHpoweroperaterrdDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdHpoweroperaterrdDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdHpoweroperaterrd(DdHpoweroperaterrdDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) BeanHelper.buildBean(DdHpoweroperaterrd.class, dto);
		ddHpoweroperaterrdDao.saveOrUpdate(ddHpoweroperaterrd);
   
   }
   public void deleteDdHpoweroperaterrd(String fid){
     
        DdHpoweroperaterrd ddHpoweroperaterrd = new DdHpoweroperaterrd();
		ddHpoweroperaterrd.setFid(fid);
		ddHpoweroperaterrdDao.delete(ddHpoweroperaterrd);
   
   }
   public DdHpoweroperaterrdDto loadDdHpoweroperaterrd(String fid){
        DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) ddHpoweroperaterrdDao.findByPk(fid);
		DdHpoweroperaterrdDto dto = (DdHpoweroperaterrdDto) BeanHelper.buildBean(DdHpoweroperaterrdDto.class, ddHpoweroperaterrd);
		return dto;
   }
   public QueryListObj listDdHpoweroperaterrdByHql(String hql){
      QueryListObj obj = ddHpoweroperaterrdDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdHpoweroperaterrdDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdHpoweroperaterrd(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdHpoweroperaterrdDto ddHpoweroperaterrdDto = (DdHpoweroperaterrdDto)dtos.get(i);
			DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) BeanHelper.buildBean(DdHpoweroperaterrd.class, ddHpoweroperaterrdDto);
		    pos.add(ddHpoweroperaterrd);
		}
		
		ddHpoweroperaterrdDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdHpoweroperaterrd(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdHpoweroperaterrd.class, dtos);
		ddHpoweroperaterrdDao.deleteAll(pos);
   }
	
		

   public QueryListObj listDdWaterheight() {
		QueryListObj obj = ddWaterheightDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdWaterheightDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdWaterheight(DdWaterheightDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdWaterheight ddWaterheight = (DdWaterheight) BeanHelper.buildBean(DdWaterheight.class, dto);
		ddWaterheightDao.saveOrUpdate(ddWaterheight);
   
   }
   public void deleteDdWaterheight(String fid){
     
        DdWaterheight ddWaterheight = new DdWaterheight();
		ddWaterheight.setFid(fid);
		ddWaterheightDao.delete(ddWaterheight);
   
   }
   public DdWaterheightDto loadDdWaterheight(String fid){
        DdWaterheight ddWaterheight = (DdWaterheight) ddWaterheightDao.findByPk(fid);
		DdWaterheightDto dto = (DdWaterheightDto) BeanHelper.buildBean(DdWaterheightDto.class, ddWaterheight);
		return dto;
   }
   public QueryListObj listDdWaterheightByHql(String hql){
      QueryListObj obj = ddWaterheightDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdWaterheightDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdWaterheight(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdWaterheightDto ddWaterheightDto = (DdWaterheightDto)dtos.get(i);
			DdWaterheight ddWaterheight = (DdWaterheight) BeanHelper.buildBean(DdWaterheight.class, ddWaterheightDto);
		    pos.add(ddWaterheight);
		}
		
		ddWaterheightDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdWaterheight(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdWaterheight.class, dtos);
		ddWaterheightDao.deleteAll(pos);
   }
	
		

   public QueryListObj listBhAsregulate() {
		QueryListObj obj = bhAsregulateDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateBhAsregulate(BhAsregulateDto dto){
   
     if (StringUtils.isEmpty(dto.getAsregulateid())){
		      if( StringUtils.isEmpty(dto.getAsregulateid())){
		          dto.setAsregulateid(new SequenceCreator().getUID());
		       }
		}
		BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, dto);
		bhAsregulateDao.saveOrUpdate(bhAsregulate);
   
   }
   public void deleteBhAsregulate(String asregulateid){
     
        BhAsregulate bhAsregulate = new BhAsregulate();
		bhAsregulate.setAsregulateid(asregulateid);
		bhAsregulateDao.delete(bhAsregulate);
   
   }
   public BhAsregulateDto loadBhAsregulate(String asregulateid){
        BhAsregulate bhAsregulate = (BhAsregulate) bhAsregulateDao.findByPk(asregulateid);
		BhAsregulateDto dto = (BhAsregulateDto) BeanHelper.buildBean(BhAsregulateDto.class, bhAsregulate);
		return dto;
   }
   public QueryListObj listBhAsregulateByHql(String hql){
      QueryListObj obj = bhAsregulateDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhAsregulateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateBhAsregulate(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			BhAsregulateDto bhAsregulateDto = (BhAsregulateDto)dtos.get(i);
			BhAsregulate bhAsregulate = (BhAsregulate) BeanHelper.buildBean(BhAsregulate.class, bhAsregulateDto);
		    pos.add(bhAsregulate);
		}
		
		bhAsregulateDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteBhAsregulate(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(BhAsregulate.class, dtos);
		bhAsregulateDao.deleteAll(pos);
   }
	
		

   public QueryListObj listDdPowerchangrecord() {
		QueryListObj obj = ddPowerchangrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPowerchangrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdPowerchangrecord(DdPowerchangrecordDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) BeanHelper.buildBean(DdPowerchangrecord.class, dto);
		ddPowerchangrecordDao.saveOrUpdate(ddPowerchangrecord);
   
   }
   public void deleteDdPowerchangrecord(String fid){
     
        DdPowerchangrecord ddPowerchangrecord = new DdPowerchangrecord();
		ddPowerchangrecord.setFid(fid);
		ddPowerchangrecordDao.delete(ddPowerchangrecord);
   
   }
   public DdPowerchangrecordDto loadDdPowerchangrecord(String fid){
        DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) ddPowerchangrecordDao.findByPk(fid);
		DdPowerchangrecordDto dto = (DdPowerchangrecordDto) BeanHelper.buildBean(DdPowerchangrecordDto.class, ddPowerchangrecord);
		return dto;
   }
   public QueryListObj listDdPowerchangrecordByHql(String hql){
      QueryListObj obj = ddPowerchangrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPowerchangrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdPowerchangrecord(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdPowerchangrecordDto ddPowerchangrecordDto = (DdPowerchangrecordDto)dtos.get(i);
			DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) BeanHelper.buildBean(DdPowerchangrecord.class, ddPowerchangrecordDto);
		    pos.add(ddPowerchangrecord);
		}
		
		ddPowerchangrecordDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdPowerchangrecord(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdPowerchangrecord.class, dtos);
		ddPowerchangrecordDao.deleteAll(pos);
   }
	
		

   public QueryListObj listZdhRmrec() {
		QueryListObj obj = zdhRmrecDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRmrecDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhRmrec(ZdhRmrecDto dto){
   
     if (StringUtils.isEmpty(dto.getRecordno())){
		      if( StringUtils.isEmpty(dto.getRecordno())){
		          dto.setRecordno(new SequenceCreator().getUID());
		       }
		}
		ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.buildBean(ZdhRmrec.class, dto);
		zdhRmrecDao.saveOrUpdate(zdhRmrec);
   
   }
   public void deleteZdhRmrec(String recordno){
     
        ZdhRmrec zdhRmrec = new ZdhRmrec();
		zdhRmrec.setRecordno(recordno);
		zdhRmrecDao.delete(zdhRmrec);
   
   }
   public ZdhRmrecDto loadZdhRmrec(String recordno){
        ZdhRmrec zdhRmrec = (ZdhRmrec) zdhRmrecDao.findByPk(recordno);
		ZdhRmrecDto dto = (ZdhRmrecDto) BeanHelper.buildBean(ZdhRmrecDto.class, zdhRmrec);
		return dto;
   }
   public QueryListObj listZdhRmrecByHql(String hql){
      QueryListObj obj = zdhRmrecDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRmrecDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhRmrec(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhRmrecDto zdhRmrecDto = (ZdhRmrecDto)dtos.get(i);
			ZdhRmrec zdhRmrec = (ZdhRmrec) BeanHelper.buildBean(ZdhRmrec.class, zdhRmrecDto);
		    pos.add(zdhRmrec);
		}
		
		zdhRmrecDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhRmrec(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhRmrec.class, dtos);
		zdhRmrecDao.deleteAll(pos);
   }
	
	  	
    */

	
}
