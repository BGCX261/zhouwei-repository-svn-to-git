package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;

import com.techstar.dmis.dao.ICtrlWflentityrelDao;
import com.techstar.dmis.dao.IZdhReceptionDao;
import com.techstar.dmis.dao.IZdhReceptioneqprelDao;
import com.techstar.dmis.dao.IZdhTransrecordDao;
import com.techstar.dmis.dto.ZdhReceptionDto;
import com.techstar.dmis.entity.CtrlWflentityrel;
import com.techstar.dmis.entity.ZdhReception;
import com.techstar.dmis.entity.ZdhTransrecord;
import com.techstar.dmis.service.IZdhReceptionService;
import org.springframework.dao.DataAccessException;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IZdhReceptionWFService;
import com.techstar.dmis.service.workflow.impl.ZdhReceptionWFServiceImpl;
import com.techstar.dmis.service.IZdhTransrecordService;
	//注册子表DAO
  import com.techstar.dmis.dto.ZdhReceptioneqprelDto;
import com.techstar.dmis.entity.ZdhReceptioneqprel;
import com.techstar.dmis.dto.ZdhTransrecordDto;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhReceptionServiceImpl implements IZdhReceptionService {
   //注册DAO
   private IZdhReceptionDao zdhReceptionDao;
   private IBaseJdbcDao baseJdbcDao ;
   //注册传动记录
   private IZdhTransrecordDao zdhTransrecordDao;
   private ICtrlWflentityrelDao ctrlWflentityrelDao;

  	//注册管理DAO
    	 private IZdhReceptioneqprelDao zdhReceptioneqprelDao;
	 public void setZdhReceptioneqprelDao
	    (IZdhReceptioneqprelDao zdhReceptioneqprelDao) {
		 this.zdhReceptioneqprelDao = zdhReceptioneqprelDao;
     }
	  	
	 private IZdhReceptionWFService zdhReceptionWFService;
	 
	/**
	 * @return the zdhReceptionWFService
	 */
	public IZdhReceptionWFService getZdhReceptionWFService() {
		return zdhReceptionWFService;
	}

	/**
	 * @param zdhReceptionWFService the zdhReceptionWFService to set
	 */
	public void setZdhReceptionWFService(
			IZdhReceptionWFService zdhReceptionWFService) {
		this.zdhReceptionWFService = zdhReceptionWFService;
	}

	public ZdhReceptionServiceImpl() {}
	
	public void addZdhReception(ZdhReceptionDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFapplicationid())){
		      if( StringUtils.isEmpty(dto.getFapplicationid())){
		          dto.setFapplicationid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhReception zdhReception = (ZdhReception) BeanHelper.buildBean(ZdhReception.class, dto);
		zdhReceptionDao.saveOrUpdate(zdhReception);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhReception(ZdhReceptionDto dto) {
		if (StringUtils.isEmpty(dto.getFapplicationid())){
		      if( StringUtils.isEmpty(dto.getFapplicationid())){
		          dto.setFapplicationid(new SequenceCreator().getUID());
		       }
		}
		ZdhReception zdhReception = (ZdhReception) BeanHelper.buildBean(ZdhReception.class, dto);
		zdhReceptionDao.saveOrUpdate(zdhReception);
	}
    //用于实现基本删除操作
	public void deleteZdhReception(String zdhReceptionId) {
		ZdhReception zdhReception = new ZdhReception();
		zdhReception.setFapplicationid(zdhReceptionId);
		zdhReceptionDao.delete(zdhReception);
	}
	//用于实现基本删除集合操作
	public void deleteZdhReception(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhReception.class, dtos);
		zdhReceptionDao.deleteAll(pos);
	}	
   //用于实现基本DTOLOAD操作
	public ZdhReceptionDto loadZdhReception(String fapplicationid) {
		ZdhReception zdhReception = (ZdhReception) zdhReceptionDao.findByPk(fapplicationid);
		ZdhReceptionDto dto = (ZdhReceptionDto) BeanHelper.buildBean(ZdhReceptionDto.class, zdhReception);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhReception() {
		QueryListObj obj = zdhReceptionDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhReceptionDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhReceptionByHql(String hql) {
		QueryListObj obj = zdhReceptionDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhReceptionDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhReceptionByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhReceptionDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhReceptionDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhReceptionDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @申请单归档
	 	* @送上级相关专工
	 	* @输入投运设备清单
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhReceptionDao getZdhReceptionDao() {
		return zdhReceptionDao;
	}

	public void setZdhReceptionDao(IZdhReceptionDao zdhReceptionDao) {
		this.zdhReceptionDao = zdhReceptionDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhReception(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhReceptionDto zdhReceptionDto = (ZdhReceptionDto)dtos.get(i);
			ZdhReception zdhReception = (ZdhReception) BeanHelper.buildBean(ZdhReception.class, zdhReceptionDto);
		    pos.add(zdhReception);
		}
		
		zdhReceptionDao.saveOrUpdateAll(pos);	
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listZdhReceptioneqprel() {
		QueryListObj obj = zdhReceptioneqprelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhReceptioneqprelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhReceptioneqprel(ZdhReceptioneqprelDto dto){
   
     if (StringUtils.isEmpty(dto.getReceptioneqprelid())){
		      if( StringUtils.isEmpty(dto.getReceptioneqprelid())){
		          dto.setReceptioneqprelid(new SequenceCreator().getUID());
		       }
		}
		ZdhReceptioneqprel zdhReceptioneqprel = (ZdhReceptioneqprel) BeanHelper.buildBean(ZdhReceptioneqprel.class, dto);
		zdhReceptioneqprelDao.saveOrUpdate(zdhReceptioneqprel);
   
   }
   public void deleteZdhReceptioneqprel(String receptioneqprelid){
     
        ZdhReceptioneqprel zdhReceptioneqprel = new ZdhReceptioneqprel();
		zdhReceptioneqprel.setReceptioneqprelid(receptioneqprelid);
		zdhReceptioneqprelDao.delete(zdhReceptioneqprel);
   
   }
   public ZdhReceptioneqprelDto loadZdhReceptioneqprel(String receptioneqprelid){
        ZdhReceptioneqprel zdhReceptioneqprel = (ZdhReceptioneqprel) zdhReceptioneqprelDao.findByPk(receptioneqprelid);
		ZdhReceptioneqprelDto dto = (ZdhReceptioneqprelDto) BeanHelper.buildBean(ZdhReceptioneqprelDto.class, zdhReceptioneqprel);
		return dto;
   }
   public QueryListObj listZdhReceptioneqprelByHql(String hql){
      QueryListObj obj = zdhReceptioneqprelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhReceptioneqprelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhReceptioneqprel(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhReceptioneqprelDto zdhReceptioneqprelDto = (ZdhReceptioneqprelDto)dtos.get(i);
			ZdhReceptioneqprel zdhReceptioneqprel = (ZdhReceptioneqprel) BeanHelper.buildBean(ZdhReceptioneqprel.class, zdhReceptioneqprelDto);
		    pos.add(zdhReceptioneqprel);
		}
		
		zdhReceptioneqprelDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhReceptioneqprel(List dtos){
      List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhReceptioneqprel.class, dtos);
		zdhReceptioneqprelDao.deleteAll(pos);
   }
	
   
   
   
   /** ***************************工作流服务************************** */

   //开始
   public void start(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = zdhReceptionWFService.start(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		
		zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_AUDITING);
		zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_AUDITING);
		zdhReceptionDao.saveOrUpdate(zdhReception);	
   }//市调专工审核
	public void projectrecptionSpecApprove(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionSpecApprove(dto);
		String busId=dto.getBusId();
		ZdhReception zdhReception = zdhReceptionDao.findByPk(busId);
		 String transitionFlag =dto.getTransitionFlag();
		 if(transitionFlag.equals("1C"))//等待传动记录
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_ACCEPT_YES);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_NOTICED);
				//增加传动记录
				ZdhTransrecord zdhTransrecord= new ZdhTransrecord();
				//zdhTransrecordDto.getFstationname(zdhReception.getFstationname());
				zdhTransrecord.setTransreason(ZdhConstants.ZdhReception_WORKSOURCE);
				zdhTransrecord.setTransdate(zdhReception.getFreceptiondate());
				zdhTransrecord.setTasksource(ZdhConstants.ZdhReception_WORKSOURCE);
				zdhTransrecord.setSourcetaskno(zdhReception.getFapplicationid());
				zdhTransrecord.setExplanation(zdhReception.getFruneqoremark());
				zdhTransrecord.setFstationname(zdhReception.getFstationname());
				
				zdhTransrecord.setTransrecordid(new SequenceCreator().getUID());
				zdhTransrecordDao.saveOrUpdate(zdhTransrecord);
				
				   CtrlWflentityrel    ctrlWflentityrel=new CtrlWflentityrel();
				   ctrlWflentityrel.setEntityid(busId);
				   ctrlWflentityrel.setEntityname(ZdhConstants.ZdhReception_WORKSOURCE);
				
				   ctrlWflentityrel.setTaskid(dto.getTaskInstanceId());
				   ctrlWflentityrel.setFrelid(new SequenceCreator().getUID());
				   
				ctrlWflentityrelDao.saveOrUpdate(ctrlWflentityrel);
		 }else if(transitionFlag.equals("-1C"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_ACCEPT_NO);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_ROLE);
		 }else if(transitionFlag.equals("1A"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_ACCEPT_YES);
				zdhReception.setFstatus(ZdhConstants.projection_WORKFLOW_CITY_SpecApprove_TRANSIT_YES_AREA);
		 }else if(transitionFlag.equals("-1A"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_ACCEPT_NO);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_ROLE);
		 }

		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
	//填报角色修改申请
	public void projectrecptionModify(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionModify(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		
		zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_MODIFY_OK);
		zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_AUDITING);
		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
   //填报角色上报验收资料
	public void projectrecptionReport(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionReport(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		
		zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_NOTICED);
		zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_DATA_NOTICED);
		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
	//市调专工审核资料完整性
	public void projectrecptionApproveFill(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionApproveFill(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		 String transitionFlag =dto.getTransitionFlag();
		 if(transitionFlag.equals("1C"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_CHECKED);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_DATA_CHECK);
				
		 }else if(transitionFlag.equals("-1C"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_NO);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_DATA_APPROVED);
		 }else if(transitionFlag.equals("1A"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_CHECKED);
				zdhReception.setFstatus(ZdhConstants.projection_WORKFLOW_CITY_ApproveFill_TRANSIT_YES_AREA);
		 }else if(transitionFlag.equals("-1A"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_NO);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_ROLE);
		 }

		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
	//市调专工归档
	public void projectrecptionKeepon(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionKeepon(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		
		zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_PIGEONHOLED);
		zdhReception.setFstatus(ZdhConstants.projection_WORKFLOW_CITY_TRANSIT_END);
		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
	//运行投运申请
	public void projectrecptionRunApply(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionRunApply(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		
		zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_APP);
		zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_APP);
		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
	//专工投运审核
	public void projectrecptionRunApprove(WorkflowHandleDto dto) throws DataAccessException
	{
		int ireturn = zdhReceptionWFService.projectrecptionRunApprove(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		 String transitionFlag =dto.getTransitionFlag();
		 if(transitionFlag.equals("1C"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_RECPETION_YES);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_RECPETION);
				
		 }else if(transitionFlag.equals("-1C"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_NO);
				zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_DATA_CHECK);
		 }else if(transitionFlag.equals("1A"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_RECPETION_YES);
				zdhReception.setFstatus(ZdhConstants.projection_WORKFLOW_CITY_RunApprove_TRANSIT_YES_AREA);
		 }else if(transitionFlag.equals("-1A"))
		 {
				zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_RECPETION_NO);
				zdhReception.setFstatus(ZdhConstants.projection_WORKFLOW_CITY_RunApprove_TRANSIT_NO_AREA);
		 }

		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}
	//执行
	public void projectrecptionExec(WorkflowHandleDto dto) throws DataAccessException
	{
	int ireturn = zdhReceptionWFService.projectrecptionExec(dto);
		
		ZdhReception zdhReception = zdhReceptionDao.findByPk(dto.getBusId());
		
		zdhReception.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_EXECUTED);
		zdhReception.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_EXECUTED);
		zdhReceptionDao.saveOrUpdate(zdhReception);	
	}




	/**
	 * @param zdhTransrecordDao the zdhTransrecordDao to set
	 */
	public void setZdhTransrecordDao(IZdhTransrecordDao zdhTransrecordDao) {
		this.zdhTransrecordDao = zdhTransrecordDao;
	}

	/**
	 * @param ctrlWflentityrelDao the ctrlWflentityrelDao to set
	 */
	public void setCtrlWflentityrelDao(ICtrlWflentityrelDao ctrlWflentityrelDao) {
		this.ctrlWflentityrelDao = ctrlWflentityrelDao;
	}


	
	/** ************************************************************* */

   
   
   
	  	


	
}
