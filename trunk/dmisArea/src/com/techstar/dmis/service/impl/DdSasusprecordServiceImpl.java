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
import com.techstar.dmis.dto.DdSasusprecordDto;
import com.techstar.dmis.entity.DdSasusprecord;
import com.techstar.dmis.service.IDdSasusprecordService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现�?
 * @author 
 * @date
 */
public class DdSasusprecordServiceImpl implements IDdSasusprecordService {
   //注册DAO
   private IDdSasusprecordDao ddSasusprecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IEtsEquipmentDao etsEquipmentDao;
	 public void setEtsEquipmentDao
	    (IEtsEquipmentDao etsEquipmentDao) {
		 this.etsEquipmentDao = etsEquipmentDao;
     }
		 private IDdClassondutylogDao ddClassondutylogDao;
	 public void setDdClassondutylogDao
	    (IDdClassondutylogDao ddClassondutylogDao) {
		 this.ddClassondutylogDao = ddClassondutylogDao;
     }
	  	

	public DdSasusprecordServiceImpl() {}
	
	public void addDdSasusprecord(DdSasusprecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时�?主对象不用管子对象的保存
		DdSasusprecord ddSasusprecord = (DdSasusprecord) BeanHelper.buildBean(DdSasusprecord.class, dto);
		ddSasusprecordDao.saveOrUpdate(ddSasusprecord);		
	}
	
    //用于实现基本增加或修改操�?
	public void saveOrUpdateDdSasusprecord(DdSasusprecordDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdSasusprecord ddSasusprecord = (DdSasusprecord) BeanHelper.mapBean(DdSasusprecord.class, dto);
		ddSasusprecordDao.saveOrUpdate(ddSasusprecord);
	}
    //用于实现基本删除操作
	public void deleteDdSasusprecord(String ddSasusprecordId) {
		DdSasusprecord ddSasusprecord = new DdSasusprecord();
		ddSasusprecord.setFid(ddSasusprecordId);
		ddSasusprecordDao.delete(ddSasusprecord);
	}
	
//	用于实现基本删除操作
	public void deleteDdSasusprecordobj(String ddSasusprecordId,int version) {
		DdSasusprecord ddSasusprecord = new DdSasusprecord();
		ddSasusprecord.setFid(ddSasusprecordId);
		ddSasusprecord.setVersion(version);
		ddSasusprecordDao.delete(ddSasusprecord);
	}
   //用于实现基本DTOLOAD操作
	public DdSasusprecordDto loadDdSasusprecord(String fid) {
		DdSasusprecord ddSasusprecord = (DdSasusprecord) ddSasusprecordDao.findByPk(fid);
		DdSasusprecordDto dto = (DdSasusprecordDto) BeanHelper.mapBean(DdSasusprecordDto.class, ddSasusprecord);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdSasusprecord() {
		QueryListObj obj = ddSasusprecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdSasusprecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdSasusprecordByHql(String hql) {
		QueryListObj obj = ddSasusprecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdSasusprecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdSasusprecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddSasusprecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdSasusprecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddSasusprecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @从SCADA获得自投数据
	 	* @拟定操作�?
	 	* @从设备取数据
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDdSasusprecordDao getDdSasusprecordDao() {
		return ddSasusprecordDao;
	}

	public void setDdSasusprecordDao(IDdSasusprecordDao ddSasusprecordDao) {
		this.ddSasusprecordDao = ddSasusprecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdSasusprecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdSasusprecordDto ddSasusprecordDto = (DdSasusprecordDto)dtos.get(i);
			DdSasusprecord ddSasusprecord = (DdSasusprecord) BeanHelper.buildBean(DdSasusprecord.class, ddSasusprecordDto);
		    pos.add(ddSasusprecord);
		}
		
		ddSasusprecordDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
