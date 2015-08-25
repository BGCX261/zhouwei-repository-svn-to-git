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
import com.techstar.dmis.dto.ZdhEligiblermrateDto;
import com.techstar.dmis.entity.ZdhEligiblermrate;
import com.techstar.dmis.service.IZdhEligiblermrateService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhEligiblermrateServiceImpl implements IZdhEligiblermrateService {
   //注册DAO
   private IZdhEligiblermrateDao zdhEligiblermrateDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
	  	

	public ZdhEligiblermrateServiceImpl() {}
	
	public void addZdhEligiblermrate(ZdhEligiblermrateDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhEligiblermrate zdhEligiblermrate = (ZdhEligiblermrate) BeanHelper.buildBean(ZdhEligiblermrate.class, dto);
		zdhEligiblermrateDao.saveOrUpdate(zdhEligiblermrate);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhEligiblermrate(ZdhEligiblermrateDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		ZdhEligiblermrate zdhEligiblermrate = (ZdhEligiblermrate) BeanHelper.mapBean(ZdhEligiblermrate.class, dto);
		zdhEligiblermrateDao.saveOrUpdate(zdhEligiblermrate);
	}
    //用于实现基本删除操作
	public void deleteZdhEligiblermrate(String zdhEligiblermrateId) {
		ZdhEligiblermrate zdhEligiblermrate = new ZdhEligiblermrate();
		zdhEligiblermrate.setFid(zdhEligiblermrateId);
		zdhEligiblermrateDao.delete(zdhEligiblermrate);
	}
	
	public void deleteZdhEligiblermrate(String zdhEligiblermrateId,int version) {
		ZdhEligiblermrate zdhEligiblermrate = new ZdhEligiblermrate();
		zdhEligiblermrate.setFid(zdhEligiblermrateId);
		zdhEligiblermrate.setVersion(version);
		zdhEligiblermrateDao.delete(zdhEligiblermrate);
	}
   //用于实现基本DTOLOAD操作
	public ZdhEligiblermrateDto loadZdhEligiblermrate(String fid) {
		ZdhEligiblermrate zdhEligiblermrate = (ZdhEligiblermrate) zdhEligiblermrateDao.findByPk(fid);
		ZdhEligiblermrateDto dto = (ZdhEligiblermrateDto) BeanHelper.mapBean(ZdhEligiblermrateDto.class, zdhEligiblermrate);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listZdhEligiblermrate() {
		QueryListObj obj = zdhEligiblermrateDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhEligiblermrateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhEligiblermrateByHql(String hql) {
		QueryListObj obj = zdhEligiblermrateDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhEligiblermrate.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhEligiblermrateByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhEligiblermrateDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhEligiblermrate.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhEligiblermrateDao.getObjPropertySums(sql);
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
	
	public IZdhEligiblermrateDao getZdhEligiblermrateDao() {
		return zdhEligiblermrateDao;
	}

	public void setZdhEligiblermrateDao(IZdhEligiblermrateDao zdhEligiblermrateDao) {
		this.zdhEligiblermrateDao = zdhEligiblermrateDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhEligiblermrate(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhEligiblermrateDto zdhEligiblermrateDto = (ZdhEligiblermrateDto)dtos.get(i);
			ZdhEligiblermrate zdhEligiblermrate = (ZdhEligiblermrate) BeanHelper.buildBean(ZdhEligiblermrate.class, zdhEligiblermrateDto);
		    pos.add(zdhEligiblermrate);
		}
		
		zdhEligiblermrateDao.saveOrUpdateAll(pos);	
	}
	
		
	/*
	 * 交接班使用
	 */
	public QueryListObj getZdhEligiblermrateByHql(String hql) {	   
		
		QueryListObj obj = zdhEligiblermrateDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhEligiblermrateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		
		return obj;
	}		

	
}
