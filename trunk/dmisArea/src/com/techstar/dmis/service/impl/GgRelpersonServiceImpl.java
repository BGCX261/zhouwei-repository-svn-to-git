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
import com.techstar.dmis.dto.GgRelpersonDto;
import com.techstar.dmis.entity.GgRelperson;
import com.techstar.dmis.service.IGgRelpersonService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class GgRelpersonServiceImpl implements IGgRelpersonService {
   //注册DAO
   private IGgRelpersonDao ggRelpersonDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public GgRelpersonServiceImpl() {}
	
	public void addGgRelperson(GgRelpersonDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		GgRelperson ggRelperson = (GgRelperson) BeanHelper.buildBean(GgRelperson.class, dto);
		ggRelpersonDao.saveOrUpdate(ggRelperson);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateGgRelperson(GgRelpersonDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		GgRelperson ggRelperson = (GgRelperson) BeanHelper.buildBean(GgRelperson.class, dto);
		ggRelpersonDao.saveOrUpdate(ggRelperson);
	}
    //用于实现基本删除操作
	public void deleteGgRelperson(String ggRelpersonId) {
		GgRelperson ggRelperson = new GgRelperson();
		ggRelperson.setId(ggRelpersonId);
		ggRelpersonDao.delete(ggRelperson);
	}
	//用于实现基本删除集合操作
	public void deleteGgRelperson(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(GgRelperson.class, dtos);
		ggRelpersonDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public GgRelpersonDto loadGgRelperson(String id) {
		GgRelperson ggRelperson = (GgRelperson) ggRelpersonDao.findByPk(id);
		GgRelpersonDto dto = (GgRelpersonDto) BeanHelper.buildBean(GgRelpersonDto.class, ggRelperson);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listGgRelperson() {
		QueryListObj obj = ggRelpersonDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(GgRelpersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listGgRelpersonByHql(String hql) {
		QueryListObj obj = ggRelpersonDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(GgRelpersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getGgRelpersonByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ggRelpersonDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(GgRelpersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ggRelpersonDao.getObjPropertySums(sql);
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
	
	public IGgRelpersonDao getGgRelpersonDao() {
		return ggRelpersonDao;
	}

	public void setGgRelpersonDao(IGgRelpersonDao ggRelpersonDao) {
		this.ggRelpersonDao = ggRelpersonDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateGgRelperson(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			GgRelpersonDto ggRelpersonDto = (GgRelpersonDto)dtos.get(i);
			GgRelperson ggRelperson = (GgRelperson) BeanHelper.buildBean(GgRelperson.class, ggRelpersonDto);
		    pos.add(ggRelperson);
		}
		
		ggRelpersonDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
