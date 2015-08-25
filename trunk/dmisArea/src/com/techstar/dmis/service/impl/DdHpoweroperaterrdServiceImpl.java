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
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.entity.DdHpoweroperaterrd;
import com.techstar.dmis.service.IDdHpoweroperaterrdService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现�?
 * @author 
 * @date
 */
public class DdHpoweroperaterrdServiceImpl implements IDdHpoweroperaterrdService {
   //注册DAO
   private IDdHpoweroperaterrdDao ddHpoweroperaterrdDao;
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
	  	

	public DdHpoweroperaterrdServiceImpl() {}
	
	public void addDdHpoweroperaterrd(DdHpoweroperaterrdDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时�?主对象不用管子对象的保存
		DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) BeanHelper.buildBean(DdHpoweroperaterrd.class, dto);
		ddHpoweroperaterrdDao.saveOrUpdate(ddHpoweroperaterrd);		
	}
	
    //用于实现基本增加或修改操�?
	public void saveOrUpdateDdHpoweroperaterrd(DdHpoweroperaterrdDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) BeanHelper.mapBean(DdHpoweroperaterrd.class, dto);
		ddHpoweroperaterrdDao.saveOrUpdate(ddHpoweroperaterrd);
	}
    //用于实现基本删除操作
	public void deleteDdHpoweroperaterrd(String ddHpoweroperaterrdId) {
		DdHpoweroperaterrd ddHpoweroperaterrd = new DdHpoweroperaterrd();
		ddHpoweroperaterrd.setFid(ddHpoweroperaterrdId);
		ddHpoweroperaterrdDao.delete(ddHpoweroperaterrd);
	}
//	用于实现基本删除操作
	public void deleteDdHpoweroperaterrd(String ddHpoweroperaterrdId,int version) {
		DdHpoweroperaterrd ddHpoweroperaterrd = new DdHpoweroperaterrd();
		ddHpoweroperaterrd.setFid(ddHpoweroperaterrdId);
		ddHpoweroperaterrd.setVersion(version);
		ddHpoweroperaterrdDao.delete(ddHpoweroperaterrd);
	}
   //用于实现基本DTOLOAD操作
	public DdHpoweroperaterrdDto loadDdHpoweroperaterrd(String fid) {
		DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) ddHpoweroperaterrdDao.findByPk(fid);
		DdHpoweroperaterrdDto dto = (DdHpoweroperaterrdDto) BeanHelper.mapBean(DdHpoweroperaterrdDto.class, ddHpoweroperaterrd);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdHpoweroperaterrd() {
		QueryListObj obj = ddHpoweroperaterrdDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdHpoweroperaterrdDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdHpoweroperaterrdByHql(String hql) {
		QueryListObj obj = ddHpoweroperaterrdDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdHpoweroperaterrd.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdHpoweroperaterrdByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddHpoweroperaterrdDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdHpoweroperaterrd.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddHpoweroperaterrdDao.getObjPropertySums(sql);
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
	
	public IDdHpoweroperaterrdDao getDdHpoweroperaterrdDao() {
		return ddHpoweroperaterrdDao;
	}

	public void setDdHpoweroperaterrdDao(IDdHpoweroperaterrdDao ddHpoweroperaterrdDao) {
		this.ddHpoweroperaterrdDao = ddHpoweroperaterrdDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdHpoweroperaterrd(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdHpoweroperaterrdDto ddHpoweroperaterrdDto = (DdHpoweroperaterrdDto)dtos.get(i);
			DdHpoweroperaterrd ddHpoweroperaterrd = (DdHpoweroperaterrd) BeanHelper.buildBean(DdHpoweroperaterrd.class, ddHpoweroperaterrdDto);
		    pos.add(ddHpoweroperaterrd);
		}
		
		ddHpoweroperaterrdDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
