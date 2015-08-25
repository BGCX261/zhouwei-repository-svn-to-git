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
import com.techstar.dmis.dto.StdLineDto;
import com.techstar.dmis.entity.StdLine;
import com.techstar.dmis.service.IStdLineService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class StdLineServiceImpl implements IStdLineService {
   //注册DAO
   private IStdLineDao stdLineDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public StdLineServiceImpl() {}
	
	public void addStdLine(StdLineDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		StdLine stdLine = (StdLine) BeanHelper.buildBean(StdLine.class, dto);
		stdLineDao.saveOrUpdate(stdLine);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateStdLine(StdLineDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdLine stdLine = (StdLine) BeanHelper.buildBean(StdLine.class, dto);
		stdLineDao.saveOrUpdate(stdLine);
	}
    //用于实现基本删除操作
	public void deleteStdLine(String stdLineId) {
		StdLine stdLine = new StdLine();
		stdLine.setId(stdLineId);
		stdLineDao.delete(stdLine);
	}
	//用于实现基本删除集合操作
	public void deleteStdLine(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdLine.class, dtos);
		stdLineDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public StdLineDto loadStdLine(String id) {
		StdLine stdLine = (StdLine) stdLineDao.findByPk(id);
		StdLineDto dto = (StdLineDto) BeanHelper.buildBean(StdLineDto.class, stdLine);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listStdLine() {
		QueryListObj obj = stdLineDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdLineDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listStdLineByHql(String hql) {
		QueryListObj obj = stdLineDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdLineDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getStdLineByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = stdLineDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdLineDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = stdLineDao.getObjPropertySums(sql);
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
	
	public IStdLineDao getStdLineDao() {
		return stdLineDao;
	}

	public void setStdLineDao(IStdLineDao stdLineDao) {
		this.stdLineDao = stdLineDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateStdLine(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdLineDto stdLineDto = (StdLineDto)dtos.get(i);
			StdLine stdLine = (StdLine) BeanHelper.buildBean(StdLine.class, stdLineDto);
		    pos.add(stdLine);
		}
		
		stdLineDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
