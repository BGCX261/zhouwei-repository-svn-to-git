package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhSrapplicationService;
import com.techstar.dmis.dto.ZdhSrapplicationDto;

import com.techstar.dmis.dto.ZdhSrappeqprelDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhSrapplicationFacade {
	private IZdhSrapplicationService zdhSrapplicationService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhSrapplication() {
		return zdhSrapplicationService.listZdhSrapplication().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhSrapplication(ZdhSrapplicationDto dto) {
		zdhSrapplicationService.saveOrUpdateZdhSrapplication(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhSrapplicationId
	 *           ֵ

	 */
	public ZdhSrapplicationDto getZdhSrapplicationById(String  zdhSrapplicationId) {
		ZdhSrapplicationDto dto = zdhSrapplicationService.loadZdhSrapplication(zdhSrapplicationId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhSrapplicationId
	 *         ֵ

	 */
	public List deleteZdhSrapplication(String zdhSrapplicationId) {
		zdhSrapplicationService.deleteZdhSrapplication(zdhSrapplicationId);
		return zdhSrapplicationService.listZdhSrapplication().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhSrapplication(List dtos) {
		zdhSrapplicationService.deleteZdhSrapplication(dtos);
		return zdhSrapplicationService.listZdhSrapplication().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhSrapplication4dwr() {
		return zdhSrapplicationService.listZdhSrapplication().getElemList();
	}

	public void setZdhSrapplicationService(IZdhSrapplicationService zdhSrapplicationService) {
		this.zdhSrapplicationService = zdhSrapplicationService;		
	}
	
	public QueryListObj getZdhSrapplicationByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhSrapplicationService.getZdhSrapplicationByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhSrapplicationDto loadZdhSrapplication(String zdhSrapplicationId){
		return this.zdhSrapplicationService.loadZdhSrapplication(zdhSrapplicationId);
	}
	

		

 /**
    * @business method list
	 	* @申请单执行完成
	 	* @审批意见下发
	 	* @报上级调度
	 	* @停复役申请归档
	 	* @从设备台帐选择多台设备
	  */	
 
 
 
 	//注册子表facade方法
    	public ZdhSrappeqprelDto loadZdhSrappeqprel(String fid){
		return this.zdhSrapplicationService.loadZdhSrappeqprel(fid);
	}
	
	public List deleteZdhSrappeqprel(String fid) {
		zdhSrapplicationService.deleteZdhSrappeqprel(fid);
		return zdhSrapplicationService.listZdhSrappeqprel().getElemList();
	}
	public List deleteZdhSrappeqprel(List dtos) {
		zdhSrapplicationService.deleteZdhSrappeqprel(dtos);
		return zdhSrapplicationService.listZdhSrappeqprel().getElemList();
	}
	public void addZdhSrappeqprel(ZdhSrappeqprelDto dto) {
		zdhSrapplicationService.saveOrUpdateZdhSrappeqprel(dto);
	}
    
 
//please add your business methods start
	// to do it
//add your business method end
   /**
    * 启动
    */
	public void start(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.start(dto);
	}
    

	/**
	 * 变电公司自动化专工审批
	 */
	public void zdhSrapplBdspecApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplBdspecApprove(dto);
	}
    /**
     * 变电运行单位修改申请
     * @param dto
     * @throws DataAccessException
     */
	public void zdhSrapplBdrunModify(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplBdrunModify(dto);
	}
	/**
	 * 变电公司领导审批
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplBdheaderApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplBdheaderApprove(dto);
	}
	/**
	 * 自动化运行处处长审批
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplZdhrunApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplZdhrunApprove(dto);
	}
	/**
	 * 自动化运行处修改
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplZdhrunModify(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplZdhrunModify(dto);
	}
	/**
	 * 变电自动化专工任务下发
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplBdrunTasksent(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplBdrunTasksent(dto);
	}
	/**
	 * 运行单位执行
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplRunExec(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplRunExec(dto);
	}
	/**
	 * 下发审批任务
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSentResult(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplSentResult(dto);
	}

	
	/**
	 * 主任审批
	 */
	public void zdhSrapplDirectorApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplDirectorApprove(dto);
	}
	/**
	 * 主管主任审批
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplMDicrecterApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplMDicrecterApprove(dto);
	}
	/**
	 * 将审批意见下发
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSentComment(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplSentComment(dto);
	}
	/**
	 * 专工审批
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSpecApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplSpecApprove(dto);
	}
	/**
	 * 专工归档
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSpecKeepon(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplSpecKeepon(dto);
	}
	/**
	 * 处长审批
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplHeaderApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhSrapplicationService.zdhSrapplHeaderApprove(dto);
	}
}
