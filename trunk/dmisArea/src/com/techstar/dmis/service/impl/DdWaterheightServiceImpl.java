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
import com.techstar.dmis.dto.DdWaterheightDto;
import com.techstar.dmis.entity.DdWaterheight;
import com.techstar.dmis.service.IDdWaterheightService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DdWaterheightServiceImpl implements IDdWaterheightService {
   //注册DAO
   private IDdWaterheightDao ddWaterheightDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IStdStationDao stdStationDao;
	 public void setStdStationDao
	    (IStdStationDao stdStationDao) {
		 this.stdStationDao = stdStationDao;
     }
		 private IDdClassondutylogDao ddClassondutylogDao;
	 public void setDdClassondutylogDao
	    (IDdClassondutylogDao ddClassondutylogDao) {
		 this.ddClassondutylogDao = ddClassondutylogDao;
     }
	  	

	public DdWaterheightServiceImpl() {}
	
	public void addDdWaterheight(DdWaterheightDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		DdWaterheight ddWaterheight = (DdWaterheight) BeanHelper.buildBean(DdWaterheight.class, dto);
		ddWaterheightDao.saveOrUpdate(ddWaterheight);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDdWaterheight(DdWaterheightDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdWaterheight ddWaterheight = (DdWaterheight) BeanHelper.mapBean(DdWaterheight.class, dto);
		ddWaterheightDao.saveOrUpdate(ddWaterheight);
	}
    //用于实现基本删除操作
	public void deleteDdWaterheight(String ddWaterheightId) {
		DdWaterheight ddWaterheight = new DdWaterheight();
		ddWaterheight.setFid(ddWaterheightId);
		ddWaterheightDao.delete(ddWaterheight);
	}
//	用于实现基本删除操作
	public void deleteDdWaterheight(String ddWaterheightId,int version) {
		DdWaterheight ddWaterheight = new DdWaterheight();
		ddWaterheight.setFid(ddWaterheightId);
		ddWaterheight.setVersion(version);
		ddWaterheightDao.delete(ddWaterheight);
	}
   //用于实现基本DTOLOAD操作
	public DdWaterheightDto loadDdWaterheight(String fid) {
		DdWaterheight ddWaterheight = (DdWaterheight) ddWaterheightDao.findByPk(fid);
		DdWaterheightDto dto = (DdWaterheightDto) BeanHelper.mapBean(DdWaterheightDto.class, ddWaterheight);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdWaterheight() {
		QueryListObj obj = ddWaterheightDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdWaterheightDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdWaterheightByHql(String hql) {
		QueryListObj obj = ddWaterheightDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdWaterheight.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdWaterheightByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddWaterheightDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdWaterheight.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddWaterheightDao.getObjPropertySums(sql);
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
	
	public IDdWaterheightDao getDdWaterheightDao() {
		return ddWaterheightDao;
	}

	public void setDdWaterheightDao(IDdWaterheightDao ddWaterheightDao) {
		this.ddWaterheightDao = ddWaterheightDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdWaterheight(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdWaterheightDto ddWaterheightDto = (DdWaterheightDto)dtos.get(i);
			DdWaterheight ddWaterheight = (DdWaterheight) BeanHelper.mapBean(DdWaterheight.class, ddWaterheightDto);
		    pos.add(ddWaterheight);
		}
		
		ddWaterheightDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
