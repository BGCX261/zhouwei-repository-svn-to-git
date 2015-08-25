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
import com.techstar.dmis.dto.StdModelDto;
import com.techstar.dmis.entity.StdModel;
import com.techstar.dmis.service.IStdModelService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class StdModelServiceImpl implements IStdModelService {
   //注册DAO
   private IStdModelDao stdModelDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public StdModelServiceImpl() {}
	
	public void addStdModel(StdModelDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		StdModel stdModel = (StdModel) BeanHelper.buildBean(StdModel.class, dto);
		stdModelDao.saveOrUpdate(stdModel);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateStdModel(StdModelDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdModel stdModel = (StdModel) BeanHelper.buildBean(StdModel.class, dto);
		stdModelDao.saveOrUpdate(stdModel);
	}
    //用于实现基本删除操作
	public void deleteStdModel(String stdModelId) {
		StdModel stdModel = new StdModel();
		stdModel.setId(stdModelId);
		stdModelDao.delete(stdModel);
	}
	//用于实现基本删除集合操作
	public void deleteStdModel(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdModel.class, dtos);
		stdModelDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public StdModelDto loadStdModel(String id) {
		StdModel stdModel = (StdModel) stdModelDao.findByPk(id);
		StdModelDto dto = (StdModelDto) BeanHelper.buildBean(StdModelDto.class, stdModel);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listStdModel() {
		QueryListObj obj = stdModelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdModelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listStdModelByHql(String hql) {
		QueryListObj obj = stdModelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdModelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getStdModelByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = stdModelDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdModelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = stdModelDao.getObjPropertySums(sql);
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
	
	public IStdModelDao getStdModelDao() {
		return stdModelDao;
	}

	public void setStdModelDao(IStdModelDao stdModelDao) {
		this.stdModelDao = stdModelDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateStdModel(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdModelDto stdModelDto = (StdModelDto)dtos.get(i);
			StdModel stdModel = (StdModel) BeanHelper.buildBean(StdModel.class, stdModelDto);
		    pos.add(stdModel);
		}
		
		stdModelDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
