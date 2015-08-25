package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhReceptionService;
import com.techstar.dmis.dto.ZdhReceptionDto;

import com.techstar.dmis.dto.ZdhReceptioneqprelDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhReceptionFacade {
	private IZdhReceptionService zdhReceptionService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhReception() {
		return zdhReceptionService.listZdhReception().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhReception(ZdhReceptionDto dto) {
		zdhReceptionService.saveOrUpdateZdhReception(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhReceptionId
	 *           ֵ

	 */
	public ZdhReceptionDto getZdhReceptionById(String  zdhReceptionId) {
		ZdhReceptionDto dto = zdhReceptionService.loadZdhReception(zdhReceptionId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhReceptionId
	 *         ֵ

	 */
	public List deleteZdhReception(String zdhReceptionId) {
		zdhReceptionService.deleteZdhReception(zdhReceptionId);
		return zdhReceptionService.listZdhReception().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhReception(List dtos) {
		zdhReceptionService.deleteZdhReception(dtos);
		return zdhReceptionService.listZdhReception().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhReception4dwr() {
		return zdhReceptionService.listZdhReception().getElemList();
	}

	public void setZdhReceptionService(IZdhReceptionService zdhReceptionService) {
		this.zdhReceptionService = zdhReceptionService;		
	}
	
	public QueryListObj getZdhReceptionByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhReceptionService.getZdhReceptionByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhReceptionDto loadZdhReception(String zdhReceptionId){
		return this.zdhReceptionService.loadZdhReception(zdhReceptionId);
	}
	

		

 /**
    * @business method list
	 	* @申请单归档
	 	* @送上级相关专工
	 	* @输入投运设备清单
	  */	
 
 
 
 	//注册子表facade方法
    	public ZdhReceptioneqprelDto loadZdhReceptioneqprel(String receptioneqprelid){
		return this.zdhReceptionService.loadZdhReceptioneqprel(receptioneqprelid);
	}
	
	public List deleteZdhReceptioneqprel(String receptioneqprelid) {
		zdhReceptionService.deleteZdhReceptioneqprel(receptioneqprelid);
		return zdhReceptionService.listZdhReceptioneqprel().getElemList();
	}
	public List deleteZdhReceptioneqprel(List dtos) {
		zdhReceptionService.deleteZdhReceptioneqprel(dtos);
		return zdhReceptionService.listZdhReceptioneqprel().getElemList();
	}
	public void addZdhReceptioneqprel(ZdhReceptioneqprelDto dto) {
		zdhReceptionService.saveOrUpdateZdhReceptioneqprel(dto);
	}
//	工作流
	   //启动
		public void start(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.start(dto);
		}
		//市调专工审核
		public void projectrecptionSpecApprove(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionSpecApprove(dto);
		}
		//填报角色修改申请
		public void projectrecptionModify(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionModify(dto);
		}
	   //填报角色上报验收资料
		public void projectrecptionReport(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionReport(dto);
		}
		//市调专工审核资料完整性
		public void projectrecptionApproveFill(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionApproveFill(dto);
		}
		//市调专工归档
		public void projectrecptionKeepon(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionKeepon(dto);
		}
		//运行投运申请
		public void projectrecptionRunApply(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionRunApply(dto);
		}
		//专工投运审核
		public void projectrecptionRunApprove(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionRunApprove(dto);
		}
		//执行
		public void projectrecptionExec(WorkflowHandleDto dto) throws DataAccessException
		{
			zdhReceptionService.projectrecptionExec(dto);
		}
	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
