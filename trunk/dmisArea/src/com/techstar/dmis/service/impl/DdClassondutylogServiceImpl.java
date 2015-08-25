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
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdSeqbilldetailDto;
import com.techstar.dmis.dto.DdOperationnotebookDto;
import com.techstar.dmis.entity.DdClassondutylog;
import com.techstar.dmis.entity.DdOperationnotebook;
import com.techstar.dmis.entity.DdSeqbilldetail;
import com.techstar.dmis.service.IDdClassondutylogService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现�?
 * @author 
 * @date
 */
public class DdClassondutylogServiceImpl implements IDdClassondutylogService {
   //注册DAO
   private IDdClassondutylogDao ddClassondutylogDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IDdPowerplantoperlogDao ddPowerplantoperlogDao;
	 public void setDdPowerplantoperlogDao
	    (IDdPowerplantoperlogDao ddPowerplantoperlogDao) {
		 this.ddPowerplantoperlogDao = ddPowerplantoperlogDao;
     }
		 private IDdOperationnotebookDao ddOperationnotebookDao;
	 public void setDdOperationnotebookDao
	    (IDdOperationnotebookDao ddOperationnotebookDao) {
		 this.ddOperationnotebookDao = ddOperationnotebookDao;
     }
		 private IDdSasusprecordDao ddSasusprecordDao;
	 public void setDdSasusprecordDao
	    (IDdSasusprecordDao ddSasusprecordDao) {
		 this.ddSasusprecordDao = ddSasusprecordDao;
     }
		 private IDdWaterheightDao ddWaterheightDao;
	 public void setDdWaterheightDao
	    (IDdWaterheightDao ddWaterheightDao) {
		 this.ddWaterheightDao = ddWaterheightDao;
     }
		 private IDdWaterproofplanDao ddWaterproofplanDao;
	 public void setDdWaterproofplanDao
	    (IDdWaterproofplanDao ddWaterproofplanDao) {
		 this.ddWaterproofplanDao = ddWaterproofplanDao;
     }
		 private IDdHloadrecordDao ddHloadrecordDao;
	 public void setDdHloadrecordDao
	    (IDdHloadrecordDao ddHloadrecordDao) {
		 this.ddHloadrecordDao = ddHloadrecordDao;
     }
		 private IDdPowerchangrecordDao ddPowerchangrecordDao;
	 public void setDdPowerchangrecordDao
	    (IDdPowerchangrecordDao ddPowerchangrecordDao) {
		 this.ddPowerchangrecordDao = ddPowerchangrecordDao;
     }
		 private IDdHpoweroperaterrdDao ddHpoweroperaterrdDao;
	 public void setDdHpoweroperaterrdDao
	    (IDdHpoweroperaterrdDao ddHpoweroperaterrdDao) {
		 this.ddHpoweroperaterrdDao = ddHpoweroperaterrdDao;
     }
	  	

	public DdClassondutylogServiceImpl() {}
	
	public void addDdClassondutylog(DdClassondutylogDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
    	//新增时�?主对象不用管子对象的保存
		DdClassondutylog ddClassondutylog = (DdClassondutylog) BeanHelper.buildBean(DdClassondutylog.class, dto);
		ddClassondutylogDao.saveOrUpdate(ddClassondutylog);		
	}
	
    //用于实现基本增加或修改操�?
	public void saveOrUpdateDdClassondutylog(DdClassondutylogDto dto) {
		if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		DdClassondutylog ddClassondutylog = (DdClassondutylog) BeanHelper.buildBean(DdClassondutylog.class, dto);
		ddClassondutylogDao.saveOrUpdate(ddClassondutylog);
	}
    //用于实现基本删除操作
	public void deleteDdClassondutylog(String ddClassondutylogId) {
		DdClassondutylog ddClassondutylog = new DdClassondutylog();
		ddClassondutylog.setFid(ddClassondutylogId);
		ddClassondutylogDao.delete(ddClassondutylog);
	}
    //用于实现基本删除操作
	public void deleteDdClassondutylog(String ddClassondutylogId,int version) {
		DdClassondutylog ddClassondutylog = new DdClassondutylog();
		ddClassondutylog.setFid(ddClassondutylogId);
		ddClassondutylog.setVersion(version);
		ddClassondutylogDao.delete(ddClassondutylog);
	}
   //用于实现基本DTOLOAD操作
	public DdClassondutylogDto loadDdClassondutylog(String fid) {
		DdClassondutylog ddClassondutylog = (DdClassondutylog) ddClassondutylogDao.findByPk(fid);
		DdClassondutylogDto dto = (DdClassondutylogDto) BeanHelper.mapBean(DdClassondutylogDto.class, ddClassondutylog);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listDdClassondutylog() {
		QueryListObj obj = ddClassondutylogDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdClassondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listDdClassondutylogByHql(String hql) {
		QueryListObj obj = ddClassondutylogDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdClassondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getDdClassondutylogByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddClassondutylogDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdClassondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddClassondutylogDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}
//	运行记事处理DAO
	public QueryListObj getDdOperationnotebookByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = ddOperationnotebookDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdOperationnotebookDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = ddOperationnotebookDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}
 	
	

	   public QueryListObj listDdOperationnotebook() {
			QueryListObj obj = this.ddOperationnotebookDao.getQueryList();
			if (obj.getElemList() != null) {
				List dtos = (List) BeanHelper.buildBeans(DdOperationnotebookDto.class, obj
						.getElemList());
				obj.setElemList(dtos);
			}
			return obj;
		}
			
		
	   public void saveOrUpdateDdSeqbilldetail(DdOperationnotebookDto dto){
	   
	     if (StringUtils.isEmpty(dto.getFid())){
			      if( StringUtils.isEmpty(dto.getFid())){
			          dto.setFid(new SequenceCreator().getUID());
			       }
			}
	     DdOperationnotebook ddOperationnotebook = (DdOperationnotebook) BeanHelper.mapBean(DdOperationnotebook.class, dto);
			ddOperationnotebookDao.saveOrUpdate(ddOperationnotebook);
	   
	   }
	   public void deleteDdOperationnotebook(String fid,int version){
	     
		   DdOperationnotebook ddOperationnotebook = new DdOperationnotebook();
		   ddOperationnotebook.setFid(fid);
		   ddOperationnotebook.setVersion(version);
			ddOperationnotebookDao.delete(ddOperationnotebook);
	   
	   }
	   public void deleteDdOperationnotebook(DdOperationnotebookDto dto){
		     
		   DdOperationnotebook ddOperationnotebook = new DdOperationnotebook();
		   ddOperationnotebook.setFid(dto.getFid());
		   ddOperationnotebook.setVersion(dto.getVersion());
		   ddOperationnotebookDao.delete(ddOperationnotebook);
	  
	  }
	   public DdOperationnotebookDto loadDdOperationnotebook(String fid){
		   DdOperationnotebook ddOperationnotebook = (DdOperationnotebook) ddOperationnotebookDao.findByPk(fid);
		   DdOperationnotebookDto dto = (DdOperationnotebookDto) BeanHelper.mapBean(DdOperationnotebookDto.class, ddOperationnotebook);
			return dto;
	   }
	   public QueryListObj listDdOperationnotebookByHql(String hql){
	      QueryListObj obj = ddOperationnotebookDao.getQueryListByHql(hql);
			if (obj.getElemList() != null&&obj.getElemList().size()!=0) {
				List dtos = (List) BeanHelper.mapBeans(DdOperationnotebookDto.class, obj
						.getElemList());
				obj.setElemList(dtos);
			}
			return obj;
	   }
	   public void saveOrUpdateDdOperationnotebook(List dtos){
	     
	   List pos = new ArrayList();
			for(int i=0;i<dtos.size();i++){
				DdOperationnotebookDto ddOperationnotebookDto = (DdOperationnotebookDto)dtos.get(i);
				//加主键

				 if( StringUtils.isEmpty(ddOperationnotebookDto.getFid())){
					 ddOperationnotebookDto.setFid(new SequenceCreator().getUID());
			       }
				 DdOperationnotebook ddOperationnotebook = (DdOperationnotebook) BeanHelper.mapBean(DdOperationnotebook.class, ddOperationnotebookDto);
			    pos.add(ddOperationnotebook);
			}
			ddOperationnotebookDao.saveOrUpdateAll(pos);	
	   
	   }
	   
	   public void deleteDdOperationnotebook(List dtos){
	      List pos = new ArrayList();
			pos = (List)BeanHelper.buildBeans(DdOperationnotebook.class, dtos);
			ddOperationnotebookDao.deleteAll(pos);
	   }
	   
	   

	public  DdClassondutylogDto getLogNo(){
		String hql ="from DdClassondutylog d  order by d.fsuccessiontime desc";
		 QueryListObj obj = this.listDdClassondutylogByHql(hql);
		 List list = obj.getElemList();
		 
		 int count = list.size();
		 DdClassondutylogDto dd = null;
		 if (count >0){
			 dd = (DdClassondutylogDto)list.get(0) ;
			 
		 }
		 return dd;
	}
  /**
    * @business method list
	 	* @按照指定的格式生成打印预览文�?
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IDdClassondutylogDao getDdClassondutylogDao() {
		return ddClassondutylogDao;
	}

	public void setDdClassondutylogDao(IDdClassondutylogDao ddClassondutylogDao) {
		this.ddClassondutylogDao = ddClassondutylogDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateDdClassondutylog(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			DdClassondutylogDto ddClassondutylogDto = (DdClassondutylogDto)dtos.get(i);
			DdClassondutylog ddClassondutylog = (DdClassondutylog) BeanHelper.mapBean(DdClassondutylog.class, ddClassondutylogDto);
		    pos.add(ddClassondutylog);
		}
		
		ddClassondutylogDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
