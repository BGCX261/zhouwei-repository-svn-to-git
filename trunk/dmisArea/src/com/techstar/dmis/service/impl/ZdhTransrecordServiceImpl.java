package com.techstar.dmis.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.entity.CtrlWflentityrel;
import com.techstar.dmis.entity.ZdhReception;
import com.techstar.dmis.entity.ZdhSrapplication;
import com.techstar.dmis.entity.ZdhTransrecord;
import com.techstar.dmis.service.IZdhTransrecordService;
import org.springframework.dao.DataAccessException;

	//注册子表DAO
    import com.techstar.dmis.dto.StdStationDto;
import com.techstar.dmis.entity.StdStation;
	import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.entity.ZdhAutoondutylog;
import com.techstar.dmis.service.IZdhReceptionService;
import com.techstar.dmis.dto.ZdhReceptionDto;
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhTransrecordServiceImpl implements IZdhTransrecordService {
   //注册DAO
   private IZdhTransrecordDao zdhTransrecordDao;
   private IBaseJdbcDao baseJdbcDao ;
   private IZdhReceptionDao zdhReceptionDao;
  // private ICtrlWflentityrelDao ctrlWflentityrelDao;
   private IZdhSrapplicationDao zdhSrapplicationDao;
   
	private IWorkflowDao workFlowDao;
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
  // private ZdhReceptionDto zdhReceptionDto;
  // pirvate
  	//注册管理DAO
    	 private IStdStationDao stdStationDao;
	 public void setStdStationDao
	    (IStdStationDao stdStationDao) {
		 this.stdStationDao = stdStationDao;
     }
		 private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
	  	

	public ZdhTransrecordServiceImpl() {}
	
	public void addZdhTransrecord(ZdhTransrecordDto dto) {
	
    	if (StringUtils.isEmpty(dto.getTransrecordid())){
		      if( StringUtils.isEmpty(dto.getTransrecordid())){
		          dto.setTransrecordid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
    	System.out.println("addZdhTransrecord: 1");
		ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.mapBean(ZdhTransrecord.class, dto);
		System.out.println("addZdhTransrecord: 2");
		zdhTransrecordDao.saveOrUpdate(zdhTransrecord);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhTransrecord(ZdhTransrecordDto dto) {
		if (StringUtils.isEmpty(dto.getTransrecordid())){
		      if( StringUtils.isEmpty(dto.getTransrecordid())){
		          dto.setTransrecordid(new SequenceCreator().getUID());
		       }
		}
		
		ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.mapBean(ZdhTransrecord.class, dto);
		zdhTransrecordDao.saveOrUpdate(zdhTransrecord);
	}
    //用于实现基本删除操作
	public void deleteZdhTransrecord(String zdhTransrecordId) {
		ZdhTransrecord zdhTransrecord = new ZdhTransrecord();
		zdhTransrecord.setTransrecordid(zdhTransrecordId);
		zdhTransrecordDao.delete(zdhTransrecord);
	}
	//用于实现基本删除集合操作
	public void deleteZdhTransrecord(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhTransrecord.class, dtos);
		zdhTransrecordDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public ZdhTransrecordDto loadZdhTransrecord(String transrecordid) {
		ZdhTransrecord zdhTransrecord = (ZdhTransrecord) zdhTransrecordDao.findByPk(transrecordid);
		ZdhTransrecordDto dto = (ZdhTransrecordDto) BeanHelper.mapBean(ZdhTransrecordDto.class, zdhTransrecord);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhTransrecord() {
		QueryListObj obj = zdhTransrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhTransrecordByHql(String hql) {
		QueryListObj obj = zdhTransrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhTransrecordByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhTransrecordDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhTransrecordDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhTransrecordDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @数据校核完成
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	//得到班号
		public String getOndutyno(){
		String hql="select a.ondutyno from ZdhAutoondutylog a where ";
		hql+=" a.successiontime=(select max(b.successiontime)from ZdhAutoondutylog b)";
		QueryListObj obj=zdhTransrecordDao.getQueryListByHql(hql);
		if(obj == null){
			return "";
		}
		List list=obj.getElemList();
		if(list ==null|| list.size()<1){
			return "";
		}
		String ondutyno=(String)list.iterator().next();
		return ondutyno;		
		
	}
	public IZdhTransrecordDao getZdhTransrecordDao() {
		return zdhTransrecordDao;
	}

	public void setZdhTransrecordDao(IZdhTransrecordDao zdhTransrecordDao) {
		this.zdhTransrecordDao = zdhTransrecordDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhTransrecord(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhTransrecordDto zdhTransrecordDto = (ZdhTransrecordDto)dtos.get(i);
			ZdhTransrecord zdhTransrecord = (ZdhTransrecord) BeanHelper.mapBean(ZdhTransrecord.class, zdhTransrecordDto);
		    pos.add(zdhTransrecord);
		}
		
		zdhTransrecordDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listStdStation() {
		QueryListObj obj = stdStationDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateStdStation(StdStationDto dto){
   
     if (StringUtils.isEmpty(dto.getId())){ 
		      if( StringUtils.isEmpty(dto.getId())){
		    	  
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		StdStation stdStation = (StdStation) BeanHelper.mapBean(StdStation.class, dto);
		stdStationDao.saveOrUpdate(stdStation);
   
   } 
   public void deleteStdStation(String id){
     
        StdStation stdStation = new StdStation();
       
		stdStation.setId(id);
		stdStationDao.delete(stdStation);
   
   }
   public StdStationDto loadStdStation(String id){
        StdStation stdStation = (StdStation) stdStationDao.findByPk(id);
		StdStationDto dto = (StdStationDto) BeanHelper.buildBean(StdStationDto.class, stdStation);
		return dto;
   }
   public QueryListObj listStdStationByHql(String hql){
      QueryListObj obj = stdStationDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(StdStationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateStdStation(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			StdStationDto stdStationDto = (StdStationDto)dtos.get(i);
			StdStation stdStation = (StdStation) BeanHelper.buildBean(StdStation.class, stdStationDto);
		    pos.add(stdStation);
		}
		
		stdStationDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteStdStation(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(StdStation.class, dtos);
		
		stdStationDao.deleteAll(pos); 
   }
	
		

   public QueryListObj listZdhAutoondutylog() {
		QueryListObj obj = zdhAutoondutylogDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhAutoondutylog(ZdhAutoondutylogDto dto){
   
     if (StringUtils.isEmpty(dto.getOndutyno())){
		      if( StringUtils.isEmpty(dto.getOndutyno())){
		          dto.setOndutyno(new SequenceCreator().getUID());
		       }
		}
		ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.mapBean(ZdhAutoondutylog.class, dto);
		zdhAutoondutylogDao.saveOrUpdate(zdhAutoondutylog);
   
   }
   public void deleteZdhAutoondutylog(String ondutyno){
     
        ZdhAutoondutylog zdhAutoondutylog = new ZdhAutoondutylog();
		zdhAutoondutylog.setOndutyno(ondutyno);
		zdhAutoondutylogDao.delete(zdhAutoondutylog);
   
   }
   public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno){
        ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) zdhAutoondutylogDao.findByPk(ondutyno);
		ZdhAutoondutylogDto dto = (ZdhAutoondutylogDto) BeanHelper.mapBean(ZdhAutoondutylogDto.class, zdhAutoondutylog);
		return dto;
   }
   public QueryListObj listZdhAutoondutylogByHql(String hql){
      QueryListObj obj = zdhAutoondutylogDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhAutoondutylogDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhAutoondutylog(List dtos){
     
   List pos = new ArrayList(); 
		for(int i=0;i<dtos.size();i++){
			ZdhAutoondutylogDto zdhAutoondutylogDto = (ZdhAutoondutylogDto)dtos.get(i);
			ZdhAutoondutylog zdhAutoondutylog = (ZdhAutoondutylog) BeanHelper.mapBean(ZdhAutoondutylog.class, zdhAutoondutylogDto);
		    pos.add(zdhAutoondutylog);
		}
		
		zdhAutoondutylogDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhAutoondutylog(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhAutoondutylog.class, dtos);
		 
		zdhAutoondutylogDao.deleteAll(pos);
   }
	/**
	 * 盖章
	 *
	 */
   public void changeStatus(String transrecordid){
	   //转动记录修改状态--盖章
	   ZdhTransrecord zdhTransrecord= zdhTransrecordDao.findByPk(transrecordid);
	   String sourceNo=zdhTransrecord.getSourcetaskno();
	   String taskSource=zdhTransrecord.getTasksource();
	   zdhTransrecord.setFexcutestatus(ZdhConstants.ZdhTransrecord_DATA_APP);
	   zdhTransrecordDao.saveOrUpdate(zdhTransrecord);
	    CtrlWflentityrel ctrlWflentityrel=null;
	   if(!StringUtils.isEmpty(taskSource))
	   {
		   //基改建的需要起动工作流
		   if(taskSource.equals(ZdhConstants.ZdhReception_WORKSOURCE))
		   {
			   String sql=" FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='"+sourceNo+"'";
			   
			   QueryListObj obj=zdhTransrecordDao.getQueryListByHql(sql);
			   List ctlList=obj.getElemList();
//			   List ctlList= ctrlWflentityrelDao.getQueryListByHql(sql);
			  Iterator ctlit= ctlList.iterator();
			  if(ctlit.hasNext())
			  {
				  ctrlWflentityrel=(CtrlWflentityrel)ctlit.next();				  
				  long taskId=new Long(ctrlWflentityrel.getTaskid()).longValue();
				   workFlowDao.endWaitingByTaskInstance(taskId);
				   ZdhReception zdhReception=zdhReceptionDao.findByPk(sourceNo);
				   zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_APPROVED);
				   zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_DATA_APPROVED);
				   zdhReceptionDao.saveOrUpdate(zdhReception);

			  }

		   }
//		 停复役申请的需要起动工作流
		   else if(taskSource.equals(ZdhConstants.ZdhTransrecord_BUSINESS_REASON_ZDHSRAPP))
		   {
			   String sql=" FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='"+sourceNo+"'";
			   
			   QueryListObj obj=zdhTransrecordDao.getQueryListByHql(sql);
			   List ctlList=obj.getElemList();

			  Iterator ctlit= ctlList.iterator();
			  if(ctlit.hasNext())
			  {
				  ctrlWflentityrel=(CtrlWflentityrel)ctlit.next();				  
				  long taskId=new Long(ctrlWflentityrel.getTaskid()).longValue();
				   workFlowDao.endWaitingByTaskInstance(taskId);
				   ZdhSrapplication zdhSrapplication=zdhSrapplicationDao.findByPk(sourceNo);
				 
				   zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_DATACHECKED);
				   zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_RUNEXEC);
				   zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);

			  }
		   }
	   }
	   
	   
   }







	/**
	 * @param zdhReceptionDao the zdhReceptionDao to set
	 */
	public void setZdhReceptionDao(IZdhReceptionDao zdhReceptionDao) {
		this.zdhReceptionDao = zdhReceptionDao;
	}


	/**
	 * @param zdhSrapplicationDao the zdhSrapplicationDao to set
	 */
	public void setZdhSrapplicationDao(IZdhSrapplicationDao zdhSrapplicationDao) {
		this.zdhSrapplicationDao = zdhSrapplicationDao;
	}


	/**
	 * @param ctrlWflentityrelDao the ctrlWflentityrelDao to set
	 */
//	public void setCtrlWflentityrelDao(ICtrlWflentityrelDao ctrlWflentityrelDao) {
//		this.ctrlWflentityrelDao = ctrlWflentityrelDao;
//	}


	
}
