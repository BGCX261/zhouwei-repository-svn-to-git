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
import com.techstar.dmis.dto.RepRepresultDto;
import com.techstar.dmis.entity.RepRepresult;
import com.techstar.dmis.service.IRepRepresultService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.RepTree2resultDto;
import com.techstar.dmis.entity.RepTree2result;
	import com.techstar.dmis.dto.RepReptemplateDto;
import com.techstar.dmis.entity.RepReptemplate;
	import com.techstar.dmis.dto.RepResdataDto;
import com.techstar.dmis.entity.RepResdata;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class RepRepresultServiceImpl implements IRepRepresultService {
   //注册DAO
   private IRepRepresultDao repRepresultDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IRepTree2resultDao repTree2resultDao;
	 public void setRepTree2resultDao
	    (IRepTree2resultDao repTree2resultDao) {
		 this.repTree2resultDao = repTree2resultDao;
     }
		 private IRepReptemplateDao repReptemplateDao;
	 public void setRepReptemplateDao
	    (IRepReptemplateDao repReptemplateDao) {
		 this.repReptemplateDao = repReptemplateDao;
     }
		 private IRepResdataDao repResdataDao;
	 public void setRepResdataDao
	    (IRepResdataDao repResdataDao) {
		 this.repResdataDao = repResdataDao;
     }
	  	

	public RepRepresultServiceImpl() {}
	
	public void addRepRepresult(RepRepresultDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFrepresultid())){
		      if( StringUtils.isEmpty(dto.getFrepresultid())){
		          dto.setFrepresultid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		RepRepresult repRepresult = (RepRepresult) BeanHelper.buildBean(RepRepresult.class, dto);
		repRepresultDao.saveOrUpdate(repRepresult);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateRepRepresult(RepRepresultDto dto) {
		if (StringUtils.isEmpty(dto.getFrepresultid())){
		      if( StringUtils.isEmpty(dto.getFrepresultid())){
		          dto.setFrepresultid(new SequenceCreator().getUID());
		       }
		}
		RepRepresult repRepresult = (RepRepresult) BeanHelper.buildBean(RepRepresult.class, dto);
		repRepresultDao.saveOrUpdate(repRepresult);
	}
    //用于实现基本删除操作
	public void deleteRepRepresult(String repRepresultId) {
		RepRepresult repRepresult = new RepRepresult();
		repRepresult.setFrepresultid(repRepresultId);
		repRepresultDao.delete(repRepresult);
	}
	//用于实现基本删除集合操作
	public void deleteRepRepresult(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(RepRepresult.class, dtos);
		repRepresultDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public RepRepresultDto loadRepRepresult(String frepresultid) {
		RepRepresult repRepresult = (RepRepresult) repRepresultDao.findByPk(frepresultid);
		RepRepresultDto dto = (RepRepresultDto) BeanHelper.buildBean(RepRepresultDto.class, repRepresult);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listRepRepresult() {
		QueryListObj obj = repRepresultDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepRepresultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listRepRepresultByHql(String hql) {
		QueryListObj obj = repRepresultDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepRepresultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getRepRepresultByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = repRepresultDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepRepresultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = repRepresultDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @报表填写
	 	* @报表查询
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IRepRepresultDao getRepRepresultDao() {
		return repRepresultDao;
	}

	public void setRepRepresultDao(IRepRepresultDao repRepresultDao) {
		this.repRepresultDao = repRepresultDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateRepRepresult(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			RepRepresultDto repRepresultDto = (RepRepresultDto)dtos.get(i);
			RepRepresult repRepresult = (RepRepresult) BeanHelper.buildBean(RepRepresult.class, repRepresultDto);
		    pos.add(repRepresult);
		}
		
		repRepresultDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listRepTree2result() {
		QueryListObj obj = repTree2resultDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepTree2resultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateRepTree2result(RepTree2resultDto dto){
   
     if (StringUtils.isEmpty(dto.getF_relationid())){
		      if( StringUtils.isEmpty(dto.getF_relationid())){
		          dto.setF_relationid(new SequenceCreator().getUID());
		       }
		}
		RepTree2result repTree2result = (RepTree2result) BeanHelper.buildBean(RepTree2result.class, dto);
		repTree2resultDao.saveOrUpdate(repTree2result);
   
   }
   public void deleteRepTree2result(String f_relationid){
     
        RepTree2result repTree2result = new RepTree2result();
		repTree2result.setF_relationid(f_relationid);
		repTree2resultDao.delete(repTree2result);
   
   }
   public RepTree2resultDto loadRepTree2result(String f_relationid){
        RepTree2result repTree2result = (RepTree2result) repTree2resultDao.findByPk(f_relationid);
		RepTree2resultDto dto = (RepTree2resultDto) BeanHelper.buildBean(RepTree2resultDto.class, repTree2result);
		return dto;
   }
   public QueryListObj listRepTree2resultByHql(String hql){
      QueryListObj obj = repTree2resultDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepTree2resultDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateRepTree2result(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			RepTree2resultDto repTree2resultDto = (RepTree2resultDto)dtos.get(i);
			RepTree2result repTree2result = (RepTree2result) BeanHelper.buildBean(RepTree2result.class, repTree2resultDto);
		    pos.add(repTree2result);
		}
		
		repTree2resultDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteRepTree2result(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(RepTree2result.class, dtos);
		repTree2resultDao.deleteAll(pos);
   }
	
		

   public QueryListObj listRepReptemplate() {
		QueryListObj obj = repReptemplateDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepReptemplateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateRepReptemplate(RepReptemplateDto dto){
   
     if (StringUtils.isEmpty(dto.getF_reptmplid())){
		      if( StringUtils.isEmpty(dto.getF_reptmplid())){
		          dto.setF_reptmplid(new SequenceCreator().getUID());
		       }
		}
		RepReptemplate repReptemplate = (RepReptemplate) BeanHelper.buildBean(RepReptemplate.class, dto);
		repReptemplateDao.saveOrUpdate(repReptemplate);
   
   }
   public void deleteRepReptemplate(String f_reptmplid){
     
        RepReptemplate repReptemplate = new RepReptemplate();
		repReptemplate.setF_reptmplid(f_reptmplid);
		repReptemplateDao.delete(repReptemplate);
   
   }
   public RepReptemplateDto loadRepReptemplate(String f_reptmplid){
        RepReptemplate repReptemplate = (RepReptemplate) repReptemplateDao.findByPk(f_reptmplid);
		RepReptemplateDto dto = (RepReptemplateDto) BeanHelper.buildBean(RepReptemplateDto.class, repReptemplate);
		return dto;
   }
   public QueryListObj listRepReptemplateByHql(String hql){
      QueryListObj obj = repReptemplateDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepReptemplateDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateRepReptemplate(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			RepReptemplateDto repReptemplateDto = (RepReptemplateDto)dtos.get(i);
			RepReptemplate repReptemplate = (RepReptemplate) BeanHelper.buildBean(RepReptemplate.class, repReptemplateDto);
		    pos.add(repReptemplate);
		}
		
		repReptemplateDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteRepReptemplate(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(RepReptemplate.class, dtos);
		repReptemplateDao.deleteAll(pos);
   }
	
		

   public QueryListObj listRepResdata() {
		QueryListObj obj = repResdataDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepResdataDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateRepResdata(RepResdataDto dto){
   
     if (StringUtils.isEmpty(dto.getRes_id())){
		      if( StringUtils.isEmpty(dto.getRes_id())){
		          dto.setRes_id(new SequenceCreator().getUID());
		       }
		}
		RepResdata repResdata = (RepResdata) BeanHelper.buildBean(RepResdata.class, dto);
		repResdataDao.saveOrUpdate(repResdata);
   
   }
   public void deleteRepResdata(String res_id){
     
        RepResdata repResdata = new RepResdata();
		repResdata.setRes_id(res_id);
		repResdataDao.delete(repResdata);
   
   }
   public RepResdataDto loadRepResdata(String res_id){
        RepResdata repResdata = (RepResdata) repResdataDao.findByPk(res_id);
		RepResdataDto dto = (RepResdataDto) BeanHelper.buildBean(RepResdataDto.class, repResdata);
		return dto;
   }
   public QueryListObj listRepResdataByHql(String hql){
      QueryListObj obj = repResdataDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(RepResdataDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateRepResdata(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			RepResdataDto repResdataDto = (RepResdataDto)dtos.get(i);
			RepResdata repResdata = (RepResdata) BeanHelper.buildBean(RepResdata.class, repResdataDto);
		    pos.add(repResdata);
		}
		
		repResdataDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteRepResdata(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(RepResdata.class, dtos);
		repResdataDao.deleteAll(pos);
   }
	
	  	


	
}
