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
import com.techstar.dmis.dto.DdCutofflistDto;
import com.techstar.dmis.entity.DdCutofflist;
import com.techstar.dmis.service.IDdCutofflistService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.DdCutoffdetaillistDto;
import com.techstar.dmis.entity.DdCutoffdetaillist;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DdCutofflistServiceImpl implements IDdCutofflistService {
   //注册DAO
   private IDdCutofflistDao ddCutofflistDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdCutoffdetaillistDao ddCutoffdetaillistDao;
	 public void setDdCutoffdetaillistDao
	    (IDdCutoffdetaillistDao ddCutoffdetaillistDao) {
		 this.ddCutoffdetaillistDao = ddCutoffdetaillistDao;
     }
	  	

	public DdCutofflistServiceImpl() {}
	
	public void addDdCutofflist(DdCutofflistDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		DdCutofflist ddCutofflist = (DdCutofflist) BeanHelper.buildBean(DdCutofflist.class, dto);
		ddCutofflistDao.saveOrUpdate(ddCutofflist);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDdCutofflist(DdCutofflistDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdCutofflist ddCutofflist = (DdCutofflist) BeanHelper.buildBean(DdCutofflist.class, dto);
		ddCutofflistDao.saveOrUpdate(ddCutofflist);
	}
    //用于实现基本删除操作
	public void deleteDdCutofflist(String ddCutofflistId) {
		DdCutofflist ddCutofflist = new DdCutofflist();
		ddCutofflist.setFid(ddCutofflistId);
		ddCutofflistDao.delete(ddCutofflist);
	}
	//用于实现基本删除集合操作
	public void deleteDdCutofflist(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdCutofflist.class, dtos);
		ddCutofflistDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public DdCutofflistDto loadDdCutofflist(String fid) {
		DdCutofflist ddCutofflist = (DdCutofflist) ddCutofflistDao.findByPk(fid);
		DdCutofflistDto dto = (DdCutofflistDto) BeanHelper.buildBean(DdCutofflistDto.class, ddCutofflist);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listDdCutofflist() {
		QueryListObj obj = ddCutofflistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutofflistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdCutofflistByHql(String hql) {
		QueryListObj obj = ddCutofflistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutofflistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdCutofflistByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddCutofflistDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutofflistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddCutofflistDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @归档
	 	* @拉路序位选择
	 	* @拉路负荷分配比例维护
	 	* @拉限任务分配
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDdCutofflistDao getDdCutofflistDao() {
		return ddCutofflistDao;
	}

	public void setDdCutofflistDao(IDdCutofflistDao ddCutofflistDao) {
		this.ddCutofflistDao = ddCutofflistDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdCutofflist(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdCutofflistDto ddCutofflistDto = (DdCutofflistDto)dtos.get(i);
			DdCutofflist ddCutofflist = (DdCutofflist) BeanHelper.buildBean(DdCutofflist.class, ddCutofflistDto);
		    pos.add(ddCutofflist);
		}
		
		ddCutofflistDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listDdCutoffdetaillist() {
		QueryListObj obj = ddCutoffdetaillistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutoffdetaillistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdCutoffdetaillist(DdCutoffdetaillistDto dto){
   
     if (StringUtils.isEmpty(dto.getFdetailid())){
		      if( StringUtils.isEmpty(dto.getFdetailid())){
		          dto.setFdetailid(new SequenceCreator().getUID());
		       }
		}
		DdCutoffdetaillist ddCutoffdetaillist = (DdCutoffdetaillist) BeanHelper.buildBean(DdCutoffdetaillist.class, dto);
		ddCutoffdetaillistDao.saveOrUpdate(ddCutoffdetaillist);
   
   }
   public void deleteDdCutoffdetaillist(String fdetailid){
     
        DdCutoffdetaillist ddCutoffdetaillist = new DdCutoffdetaillist();
		ddCutoffdetaillist.setFdetailid(fdetailid);
		ddCutoffdetaillistDao.delete(ddCutoffdetaillist);
   
   }
   public DdCutoffdetaillistDto loadDdCutoffdetaillist(String fdetailid){
        DdCutoffdetaillist ddCutoffdetaillist = (DdCutoffdetaillist) ddCutoffdetaillistDao.findByPk(fdetailid);
		DdCutoffdetaillistDto dto = (DdCutoffdetaillistDto) BeanHelper.buildBean(DdCutoffdetaillistDto.class, ddCutoffdetaillist);
		return dto;
   }
   public QueryListObj listDdCutoffdetaillistByHql(String hql){
      QueryListObj obj = ddCutoffdetaillistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutoffdetaillistDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdCutoffdetaillist(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdCutoffdetaillistDto ddCutoffdetaillistDto = (DdCutoffdetaillistDto)dtos.get(i);
			DdCutoffdetaillist ddCutoffdetaillist = (DdCutoffdetaillist) BeanHelper.buildBean(DdCutoffdetaillist.class, ddCutoffdetaillistDto);
		    pos.add(ddCutoffdetaillist);
		}
		
		ddCutoffdetaillistDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdCutoffdetaillist(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdCutoffdetaillist.class, dtos);
		ddCutoffdetaillistDao.deleteAll(pos);
   }
	
	  	


	
}
