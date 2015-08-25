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
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.entity.DdHloadrecord;
import com.techstar.dmis.service.IDdHloadrecordService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现�?
 * @author 
 * @date
 */
public class DdHloadrecordServiceImpl implements IDdHloadrecordService {
   //注册DAO
   private IDdHloadrecordDao ddHloadrecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdClassondutylogDao ddClassondutylogDao;
	 public void setDdClassondutylogDao
	    (IDdClassondutylogDao ddClassondutylogDao) {
		 this.ddClassondutylogDao = ddClassondutylogDao;
     }
		 private IEtsEquipmentDao etsEquipmentDao;
	 public void setEtsEquipmentDao
	    (IEtsEquipmentDao etsEquipmentDao) {
		 this.etsEquipmentDao = etsEquipmentDao;
     }
	  	

	public DdHloadrecordServiceImpl() {}
	
	public void addDdHloadrecord(DdHloadrecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时�?主对象不用管子对象的保存
		DdHloadrecord ddHloadrecord = (DdHloadrecord) BeanHelper.buildBean(DdHloadrecord.class, dto);
		ddHloadrecordDao.saveOrUpdate(ddHloadrecord);		
	}
	
    //用于实现基本增加或修改操�?
	public void saveOrUpdateDdHloadrecord(DdHloadrecordDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdHloadrecord ddHloadrecord = (DdHloadrecord) BeanHelper.mapBean(DdHloadrecord.class, dto);
		ddHloadrecordDao.saveOrUpdate(ddHloadrecord);
	}
    //用于实现基本删除操作
	public void deleteDdHloadrecord(String ddHloadrecordId) {
		DdHloadrecord ddHloadrecord = new DdHloadrecord();
		ddHloadrecord.setFid(ddHloadrecordId);
		ddHloadrecordDao.delete(ddHloadrecord);
	}
	//删除操作，带version
	public void deleteDdHloadrecordobj(String ddHloadrecordId,int version){
		DdHloadrecord ddHloadrecord = new DdHloadrecord();
		ddHloadrecord.setFid(ddHloadrecordId);
		ddHloadrecord.setVersion(version);
		ddHloadrecordDao.delete(ddHloadrecord);
	}
   //用于实现基本DTOLOAD操作
	public DdHloadrecordDto loadDdHloadrecord(String fid) {
		DdHloadrecord ddHloadrecord = (DdHloadrecord) ddHloadrecordDao.findByPk(fid);
		DdHloadrecordDto dto = (DdHloadrecordDto) BeanHelper.mapBean(DdHloadrecordDto.class, ddHloadrecord);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdHloadrecord() {
		QueryListObj obj = ddHloadrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdHloadrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdHloadrecordByHql(String hql) {
		QueryListObj obj = ddHloadrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdHloadrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdHloadrecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddHloadrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdHloadrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddHloadrecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @从设备获得数�?
	 	* @从应急系统获得过负荷记录
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDdHloadrecordDao getDdHloadrecordDao() {
		return ddHloadrecordDao;
	}

	public void setDdHloadrecordDao(IDdHloadrecordDao ddHloadrecordDao) {
		this.ddHloadrecordDao = ddHloadrecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdHloadrecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdHloadrecordDto ddHloadrecordDto = (DdHloadrecordDto)dtos.get(i);
			DdHloadrecord ddHloadrecord = (DdHloadrecord) BeanHelper.mapBean(DdHloadrecord.class, ddHloadrecordDto);
		    pos.add(ddHloadrecord);
		}
		
		ddHloadrecordDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
