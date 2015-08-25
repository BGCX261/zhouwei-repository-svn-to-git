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
import com.techstar.dmis.dto.DdWaterproofplanDto;
import com.techstar.dmis.entity.DdWaterproofplan;
import com.techstar.dmis.service.IDdWaterproofplanService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DdWaterproofplanServiceImpl implements IDdWaterproofplanService {
   //注册DAO
   private IDdWaterproofplanDao ddWaterproofplanDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdClassondutylogDao ddClassondutylogDao;
	 public void setDdClassondutylogDao
	    (IDdClassondutylogDao ddClassondutylogDao) {
		 this.ddClassondutylogDao = ddClassondutylogDao;
     }
	  	

	public DdWaterproofplanServiceImpl() {}
	
	public void addDdWaterproofplan(DdWaterproofplanDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		DdWaterproofplan ddWaterproofplan = (DdWaterproofplan) BeanHelper.buildBean(DdWaterproofplan.class, dto);
		ddWaterproofplanDao.saveOrUpdate(ddWaterproofplan);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDdWaterproofplan(DdWaterproofplanDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdWaterproofplan ddWaterproofplan = (DdWaterproofplan) BeanHelper.mapBean(DdWaterproofplan.class, dto);
		ddWaterproofplanDao.saveOrUpdate(ddWaterproofplan);
	}
    //用于实现基本删除操作
	public void deleteDdWaterproofplan(String ddWaterproofplanId) {
		DdWaterproofplan ddWaterproofplan = new DdWaterproofplan();
		ddWaterproofplan.setFid(ddWaterproofplanId);
		ddWaterproofplanDao.delete(ddWaterproofplan);
	}
//	用于实现基本删除操作
	public void deleteDdWaterproofplan(String ddWaterproofplanId,int version) {
		DdWaterproofplan ddWaterproofplan = new DdWaterproofplan();
		ddWaterproofplan.setFid(ddWaterproofplanId);
		ddWaterproofplan.setVersion(version);
		ddWaterproofplanDao.delete(ddWaterproofplan);
	}
   //用于实现基本DTOLOAD操作
	public DdWaterproofplanDto loadDdWaterproofplan(String fid) {
		DdWaterproofplan ddWaterproofplan = (DdWaterproofplan) ddWaterproofplanDao.findByPk(fid);
		DdWaterproofplanDto dto = (DdWaterproofplanDto) BeanHelper.mapBean(DdWaterproofplanDto.class, ddWaterproofplan);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdWaterproofplan() {
		QueryListObj obj = ddWaterproofplanDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdWaterproofplanDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdWaterproofplanByHql(String hql) {
		QueryListObj obj = ddWaterproofplanDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdWaterproofplan.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdWaterproofplanByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddWaterproofplanDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdWaterproofplan.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddWaterproofplanDao.getObjPropertySums(sql);
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
	
	public IDdWaterproofplanDao getDdWaterproofplanDao() {
		return ddWaterproofplanDao;
	}

	public void setDdWaterproofplanDao(IDdWaterproofplanDao ddWaterproofplanDao) {
		this.ddWaterproofplanDao = ddWaterproofplanDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdWaterproofplan(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdWaterproofplanDto ddWaterproofplanDto = (DdWaterproofplanDto)dtos.get(i);
			DdWaterproofplan ddWaterproofplan = (DdWaterproofplan) BeanHelper.mapBean(DdWaterproofplan.class, ddWaterproofplanDto);
		    pos.add(ddWaterproofplan);
		}
		
		ddWaterproofplanDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
