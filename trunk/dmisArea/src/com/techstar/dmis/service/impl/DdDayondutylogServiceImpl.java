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
import com.techstar.dmis.dto.DdDayondutylogDto;
import com.techstar.dmis.entity.DdDayondutylog;
import com.techstar.dmis.service.IDdDayondutylogService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.DdOperationnotebookDto;
import com.techstar.dmis.entity.DdOperationnotebook;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class DdDayondutylogServiceImpl implements IDdDayondutylogService {
   //注册DAO
   private IDdDayondutylogDao ddDayondutylogDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdOperationnotebookDao ddOperationnotebookDao;
	 public void setDdOperationnotebookDao
	    (IDdOperationnotebookDao ddOperationnotebookDao) {
		 this.ddOperationnotebookDao = ddOperationnotebookDao;
     }
	  	

	public DdDayondutylogServiceImpl() {}
	
	public void addDdDayondutylog(DdDayondutylogDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFondutyid())){
		      if( StringUtils.isEmpty(dto.getFondutyid())){
		          dto.setFondutyid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		DdDayondutylog ddDayondutylog = (DdDayondutylog) BeanHelper.buildBean(DdDayondutylog.class, dto);
		ddDayondutylogDao.saveOrUpdate(ddDayondutylog);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateDdDayondutylog(DdDayondutylogDto dto) {
		if (StringUtils.isEmpty(dto.getFondutyid())){
		      if( StringUtils.isEmpty(dto.getFondutyid())){
		          dto.setFondutyid(new SequenceCreator().getUID());
		       }
		}
		DdDayondutylog ddDayondutylog = (DdDayondutylog) BeanHelper.buildBean(DdDayondutylog.class, dto);
		ddDayondutylogDao.saveOrUpdate(ddDayondutylog);
	}
    //用于实现基本删除操作
	public void deleteDdDayondutylog(String ddDayondutylogId) {
		DdDayondutylog ddDayondutylog = new DdDayondutylog();
		ddDayondutylog.setFondutyid(ddDayondutylogId);
		ddDayondutylogDao.delete(ddDayondutylog);
	}
	//用于实现基本删除集合操作
	public void deleteDdDayondutylog(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdDayondutylog.class, dtos);
		ddDayondutylogDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public DdDayondutylogDto loadDdDayondutylog(String fondutyid) {
		DdDayondutylog ddDayondutylog = (DdDayondutylog) ddDayondutylogDao.findByPk(fondutyid);
		DdDayondutylogDto dto = (DdDayondutylogDto) BeanHelper.buildBean(DdDayondutylogDto.class, ddDayondutylog);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listDdDayondutylog() {
		QueryListObj obj = ddDayondutylogDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDayondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdDayondutylogByHql(String hql) {
		QueryListObj obj = ddDayondutylogDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDayondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdDayondutylogByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddDayondutylogDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDayondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddDayondutylogDao.getObjPropertySums(sql);
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
	
	public IDdDayondutylogDao getDdDayondutylogDao() {
		return ddDayondutylogDao;
	}

	public void setDdDayondutylogDao(IDdDayondutylogDao ddDayondutylogDao) {
		this.ddDayondutylogDao = ddDayondutylogDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdDayondutylog(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdDayondutylogDto ddDayondutylogDto = (DdDayondutylogDto)dtos.get(i);
			DdDayondutylog ddDayondutylog = (DdDayondutylog) BeanHelper.buildBean(DdDayondutylog.class, ddDayondutylogDto);
		    pos.add(ddDayondutylog);
		}
		
		ddDayondutylogDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listDdOperationnotebook() {
		QueryListObj obj = ddOperationnotebookDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdOperationnotebookDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateDdOperationnotebook(DdOperationnotebookDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdOperationnotebook ddOperationnotebook = (DdOperationnotebook) BeanHelper.buildBean(DdOperationnotebook.class, dto);
		ddOperationnotebookDao.saveOrUpdate(ddOperationnotebook);
   
   }
   public void deleteDdOperationnotebook(String fid){
     
        DdOperationnotebook ddOperationnotebook = new DdOperationnotebook();
		ddOperationnotebook.setFid(fid);
		ddOperationnotebookDao.delete(ddOperationnotebook);
   
   }
   public DdOperationnotebookDto loadDdOperationnotebook(String fid){
        DdOperationnotebook ddOperationnotebook = (DdOperationnotebook) ddOperationnotebookDao.findByPk(fid);
		DdOperationnotebookDto dto = (DdOperationnotebookDto) BeanHelper.buildBean(DdOperationnotebookDto.class, ddOperationnotebook);
		return dto;
   }
   public QueryListObj listDdOperationnotebookByHql(String hql){
      QueryListObj obj = ddOperationnotebookDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdOperationnotebookDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateDdOperationnotebook(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdOperationnotebookDto ddOperationnotebookDto = (DdOperationnotebookDto)dtos.get(i);
			DdOperationnotebook ddOperationnotebook = (DdOperationnotebook) BeanHelper.buildBean(DdOperationnotebook.class, ddOperationnotebookDto);
		    pos.add(ddOperationnotebook);
		}
		
		ddOperationnotebookDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteDdOperationnotebook(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(DdOperationnotebook.class, dtos);
		ddOperationnotebookDao.deleteAll(pos);
   }
	
	  	


	
}
