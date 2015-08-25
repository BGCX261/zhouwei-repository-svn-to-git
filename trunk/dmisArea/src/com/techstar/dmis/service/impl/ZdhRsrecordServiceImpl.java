package com.techstar.dmis.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.ZdhRsrecordDto;
import com.techstar.dmis.entity.DdAccidentbrief;
import com.techstar.dmis.entity.ZdhRsrecord;
import com.techstar.dmis.service.IDdAccidentbriefService;
import com.techstar.dmis.service.IZdhAutoondutylogService;
import com.techstar.dmis.service.IZdhRsrecordService;
import com.techstar.dmis.service.IZdhWorkbillService;

import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhRsrecordServiceImpl implements IZdhRsrecordService {
   //注册DAO
   private IZdhRsrecordDao zdhRsrecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   private IDdAccidentbriefService ddAccidentbriefService;
   private IZdhWorkbillService zdhWorkbillService;
   
  	//注册管理DAO
    	 private IDdAccidentbriefDao ddAccidentbriefDao;
	 public void setDdAccidentbriefDao
	    (IDdAccidentbriefDao ddAccidentbriefDao) {
		 this.ddAccidentbriefDao = ddAccidentbriefDao;
     }
		 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
	  	

	public ZdhRsrecordServiceImpl() {}
	
	public void addZdhRsrecord(ZdhRsrecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getRecordid())){
		      if( StringUtils.isEmpty(dto.getRecordid())){
		          dto.setRecordid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhRsrecord zdhRsrecord = (ZdhRsrecord) BeanHelper.buildBean(ZdhRsrecord.class, dto);
		zdhRsrecordDao.saveOrUpdate(zdhRsrecord);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhRsrecord(ZdhRsrecordDto dto) {
		if (StringUtils.isEmpty(dto.getRecordid())){
		      if( StringUtils.isEmpty(dto.getRecordid())){
		          dto.setRecordid(new SequenceCreator().getUID());
		       }
		}
		ZdhRsrecord zdhRsrecord = (ZdhRsrecord) BeanHelper.mapBean(ZdhRsrecord.class, dto);
		zdhRsrecordDao.saveOrUpdate(zdhRsrecord);
	}
    //用于实现基本删除操作
	public void deleteZdhRsrecord(String zdhRsrecordId) {
		ZdhRsrecord zdhRsrecord = new ZdhRsrecord();
		zdhRsrecord.setRecordid(zdhRsrecordId);
		zdhRsrecordDao.delete(zdhRsrecord);
	}
	
	public void deleteZdhRsrecordObj(String zdhRsrecordId,int version) {
		ZdhRsrecord zdhRsrecord = new ZdhRsrecord();
		zdhRsrecord.setRecordid(zdhRsrecordId);
		zdhRsrecord.setVersion(version);
		zdhRsrecordDao.delete(zdhRsrecord);
	}
	
   //用于实现基本DTOLOAD操作
	public ZdhRsrecordDto loadZdhRsrecord(String recordid) {
		ZdhRsrecord zdhRsrecord = (ZdhRsrecord) zdhRsrecordDao.findByPk(recordid);
		ZdhRsrecordDto dto = (ZdhRsrecordDto) BeanHelper.mapBean(ZdhRsrecordDto.class, zdhRsrecord);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listZdhRsrecord() {
		QueryListObj obj = zdhRsrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRsrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhRsrecordByHql(String hql) {
		QueryListObj obj = zdhRsrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRsrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhRsrecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhRsrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRsrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhRsrecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @当日故障查洵
	     */
	public QueryListObj getCurrAccidentbrieByHql(String hql, int beginPage, int pageSize, String sql){
		//提取当日事故简报数据插入本表
		this.operResrecordByAccident();
		QueryListObj obj = zdhRsrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhRsrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhRsrecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}
	
	/**
	 * 提取事故简报中的当日数据
	 * 插入到当前表中
	 */
	public void operResrecordByAccident(){
		QueryListObj queryList = ddAccidentbriefService.getAccidentList();
		List accidentList = queryList.getElemList();
		if(accidentList.size()>0){
			for(int i=0; i<accidentList.size(); i++){
				DdAccidentbrief ddAccidentbrief = (DdAccidentbrief)accidentList.get(i);
				if(this.getResrecordByForeign(ddAccidentbrief.getFaccidentid())!= true){
					ZdhRsrecord zdhRsrecord = new ZdhRsrecord();
					if (StringUtils.isEmpty(zdhRsrecord.getRecordid())){
					      if( StringUtils.isEmpty(zdhRsrecord.getRecordid())){
					    	  zdhRsrecord.setRecordid(new SequenceCreator().getUID());
					       }
					}
					if(ddAccidentbrief.getFaccidentname() != null){
						zdhRsrecord.setAccidentname(ddAccidentbrief.getFaccidentname());
					}
					if(ddAccidentbrief.getFaccidenttime() != null){
						zdhRsrecord.setAccidenttime(new Timestamp(ddAccidentbrief.getFaccidenttime().getTime()));
					}
					String onDutyOn = zdhWorkbillService.getOndutyno();
					if(onDutyOn != null){
						zdhRsrecord.setZzdhrsrecord2(new com.techstar.dmis.entity.ZdhAutoondutylog());
						zdhRsrecord.getZzdhrsrecord2().setOndutyno(onDutyOn);
					}
					zdhRsrecord.setZzdhrsrecord1(new com.techstar.dmis.entity.DdAccidentbrief());
					zdhRsrecord.getZzdhrsrecord1().setFaccidentid(ddAccidentbrief.getFaccidentid());
					zdhRsrecordDao.saveOrUpdate(zdhRsrecord);
				}
			}
		}
	}
	
	/**
	 * 判断事故简报表当日数据在本表中是否存在
	 * @param foreignKey 外键值
	 * @return
	 */
	public boolean getResrecordByForeign(String foreignKey){
		if(!StringUtils.isEmpty(foreignKey)){
			
			//String hql = " from ZdhRsrecord dda where dda.zzdhrsrecord1.faccidentid='"+foreignKey+"'";
			//QueryListObj queryObj = this.listZdhRsrecordByHql(hql);
			QueryListObj queryObj = zdhRsrecordDao.getQueryList();
			List resList = queryObj.getElemList();
			for(int i=0; i<resList.size(); i++){
				ZdhRsrecord zdhRsrecord = (ZdhRsrecord)resList.get(i);
				String faccidentId = zdhRsrecord.getZzdhrsrecord1().getFaccidentid();
				if(!StringUtils.isEmpty(faccidentId)){
					if(foreignKey.equalsIgnoreCase(faccidentId)){
						return true;
					}
				}
			}
			return false;
		} else {
			return true;
		}
	}

	//please add your business methods start
	// to do it
	//add your business method end


	public IZdhRsrecordDao getZdhRsrecordDao() {
		return zdhRsrecordDao;
	}

	public void setZdhRsrecordDao(IZdhRsrecordDao zdhRsrecordDao) {
		this.zdhRsrecordDao = zdhRsrecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhRsrecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhRsrecordDto zdhRsrecordDto = (ZdhRsrecordDto)dtos.get(i);
			ZdhRsrecord zdhRsrecord = (ZdhRsrecord) BeanHelper.buildBean(ZdhRsrecord.class, zdhRsrecordDto);
		    pos.add(zdhRsrecord);
		}
		
		zdhRsrecordDao.saveOrUpdateAll(pos);	
	}


	public void setDdAccidentbriefService(
			IDdAccidentbriefService ddAccidentbriefService) {
		this.ddAccidentbriefService = ddAccidentbriefService;
	}

	public void setZdhWorkbillService(IZdhWorkbillService zdhWorkbillService) {
		this.zdhWorkbillService = zdhWorkbillService;
	}
	
		


	
}
