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
import com.techstar.dmis.dto.DdPowerchangrecordDto;
import com.techstar.dmis.entity.DdPowerchangrecord;
import com.techstar.dmis.service.IDdPowerchangrecordService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现�?
 * @author 
 * @date
 */
public class DdPowerchangrecordServiceImpl implements IDdPowerchangrecordService {
   //注册DAO
   private IDdPowerchangrecordDao ddPowerchangrecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdClassondutylogDao ddClassondutylogDao;
	 public void setDdClassondutylogDao
	    (IDdClassondutylogDao ddClassondutylogDao) {
		 this.ddClassondutylogDao = ddClassondutylogDao;
     }
		 private IStdStationDao stdStationDao;
	 public void setStdStationDao
	    (IStdStationDao stdStationDao) {
		 this.stdStationDao = stdStationDao;
     }
	  	

	public DdPowerchangrecordServiceImpl() {}
	
	public void addDdPowerchangrecord(DdPowerchangrecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时�?主对象不用管子对象的保存
		DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) BeanHelper.buildBean(DdPowerchangrecord.class, dto);
		ddPowerchangrecordDao.saveOrUpdate(ddPowerchangrecord);		
	}
	
    //用于实现基本增加或修改操�?
	public void saveOrUpdateDdPowerchangrecord(DdPowerchangrecordDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) BeanHelper.mapBean(DdPowerchangrecord.class, dto);
		ddPowerchangrecordDao.saveOrUpdate(ddPowerchangrecord);
	}
    //用于实现基本删除操作
	public void deleteDdPowerchangrecord(String ddPowerchangrecordId) {
		DdPowerchangrecord ddPowerchangrecord = new DdPowerchangrecord();
		ddPowerchangrecord.setFid(ddPowerchangrecordId);
		ddPowerchangrecordDao.delete(ddPowerchangrecord);
	}
//	用于实现基本删除操作
	public void deleteDdPowerchangrecord(String ddPowerchangrecordId,int version) {
		DdPowerchangrecord ddPowerchangrecord = new DdPowerchangrecord();
		ddPowerchangrecord.setFid(ddPowerchangrecordId);
		ddPowerchangrecord.setVersion(version);
		ddPowerchangrecordDao.delete(ddPowerchangrecord);
	}
   //用于实现基本DTOLOAD操作
	public DdPowerchangrecordDto loadDdPowerchangrecord(String fid) {
		DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) ddPowerchangrecordDao.findByPk(fid);
		DdPowerchangrecordDto dto = (DdPowerchangrecordDto) BeanHelper.mapBean(DdPowerchangrecordDto.class, ddPowerchangrecord);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdPowerchangrecord() {
		QueryListObj obj = ddPowerchangrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdPowerchangrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdPowerchangrecordByHql(String hql) {
		QueryListObj obj = ddPowerchangrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdPowerchangrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdPowerchangrecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddPowerchangrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPowerchangrecord.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddPowerchangrecordDao.getObjPropertySums(sql);
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
	
	public IDdPowerchangrecordDao getDdPowerchangrecordDao() {
		return ddPowerchangrecordDao;
	}

	public void setDdPowerchangrecordDao(IDdPowerchangrecordDao ddPowerchangrecordDao) {
		this.ddPowerchangrecordDao = ddPowerchangrecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdPowerchangrecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdPowerchangrecordDto ddPowerchangrecordDto = (DdPowerchangrecordDto)dtos.get(i);
			DdPowerchangrecord ddPowerchangrecord = (DdPowerchangrecord) BeanHelper.mapBean(DdPowerchangrecord.class, ddPowerchangrecordDto);
		    pos.add(ddPowerchangrecord);
		}
		
		ddPowerchangrecordDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
