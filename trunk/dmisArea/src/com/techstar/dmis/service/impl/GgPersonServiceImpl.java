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
import com.techstar.dmis.dto.GgPersonDto;
import com.techstar.dmis.entity.GgPerson;
import com.techstar.dmis.service.IGgPersonService;
import org.springframework.dao.DataAccessException;


//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class GgPersonServiceImpl implements IGgPersonService {
   //注册DAO
   private IGgPersonDao ggPersonDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	

	public GgPersonServiceImpl() {}
	
	public void addGgPerson(GgPersonDto dto) {
	
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		GgPerson ggPerson = (GgPerson) BeanHelper.buildBean(GgPerson.class, dto);
		ggPersonDao.saveOrUpdate(ggPerson);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateGgPerson(GgPersonDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		GgPerson ggPerson = (GgPerson) BeanHelper.buildBean(GgPerson.class, dto);
		ggPersonDao.saveOrUpdate(ggPerson);
	}
    //用于实现基本删除操作
	public void deleteGgPerson(String ggPersonId) {
		GgPerson ggPerson = new GgPerson();
		ggPerson.setId(ggPersonId);
		ggPersonDao.delete(ggPerson);
	}
	//用于实现基本删除集合操作
	public void deleteGgPerson(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(GgPerson.class, dtos);
		ggPersonDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public GgPersonDto loadGgPerson(String id) {
		GgPerson ggPerson = (GgPerson) ggPersonDao.findByPk(id);
		GgPersonDto dto = (GgPersonDto) BeanHelper.buildBean(GgPersonDto.class, ggPerson);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listGgPerson() {
		QueryListObj obj = ggPersonDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(GgPersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listGgPersonByHql(String hql) {
		QueryListObj obj = ggPersonDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(GgPersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getGgPersonByHql(String hql, int beginPage, int pageSize, String sql) {
		String dd = "";
		QueryListObj obj = ggPersonDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null&&obj.getElemList().size()>0) {
			List dtos = (List) BeanHelper.buildBeans(GgPersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ggPersonDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	public QueryListObj getGgPersonByHql(String hql) {
		QueryListObj obj = ggPersonDao.getQueryListByHql(hql);
		if (obj.getElemList() != null&&obj.getElemList().size()>0) {
			List dtos = (List) BeanHelper.buildBeans(GgPersonDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
  /**
    * @business method list
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IGgPersonDao getGgPersonDao() {
		return ggPersonDao;
	}

	public void setGgPersonDao(IGgPersonDao ggPersonDao) {
		this.ggPersonDao = ggPersonDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateGgPerson(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			GgPersonDto ggPersonDto = (GgPersonDto)dtos.get(i);
			GgPerson ggPerson = (GgPerson) BeanHelper.buildBean(GgPerson.class, ggPersonDto);
		    pos.add(ggPerson);
		}
		
		ggPersonDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	


	
}
