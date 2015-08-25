package com.techstar.framework.demo.apply.web.facade;

import java.util.List;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.demo.entity.Apply;
import com.techstar.framework.demo.apply.service.IApplyService;
import com.techstar.framework.demo.workflow.service.IDemoWorkflowService;
import com.techstar.framework.utils.BeanHelper;

public class ApplyFacade {
	private IApplyService applyService;	

	/**
	 * 得到申请列表
	 * 
	 * @return List
	 */
	public List listApply() {
		return applyService.listApply().getElemList();
	}

	/**
	 * 增加申请列表
	 * 
	 * @param dto
	 */
	public void addApply(ApplyDto dto) {
		applyService.saveOrUpdateApply(dto);
	}

	/**
	 * 根据ID得到申请Dto
	 * 
	 * @param applyId
	 *            Integer 主键值
	 */
	public ApplyDto getApplyById(String applyId) {
		ApplyDto dto = applyService.loadApply(applyId);
		return dto;
	}

	/**
	 * 删除指定的申请并且重新查询列表
	 * 
	 * @param applyId
	 *            Integer 主键值
	 */
	public List deleteApply(String applyId) {
		applyService.deleteApply(applyId);
		return applyService.listApply().getElemList();
	}

	/**
	 * 得到申请列表
	 * 
	 * @return List
	 */
	public List listApply4dwr() {
		return applyService.listApply().getElemList();
	}

	public void setApplyService(IApplyService applyService) {
		this.applyService = applyService;		
	}
		
	public void saveOrUpdateApply(ApplyDto dto) {
		applyService.saveOrUpdateApply(dto);
	}

	
	/**
	 * function : 在业务对象处理中加入对工作流接口的简单调用--发起流程
	 * date : 2006-12-5
	 */
    public void start(String processDefinition) {
    	applyService.start(processDefinition);
    }
    
    public void start(String processDefinition,String businessId) {
    	applyService.start(processDefinition, businessId);
    }

	public  List findTransitionLog(long processInstance) {		
		return applyService.findTransitionLog(processInstance);
	}

	public List findPooledTaskInstances(String actorId) {		
		return applyService.findPooledTaskInstances(actorId);
	}

	public void suspend(long processInstance){		
		applyService.suspend(processInstance);
	}	
	
	public void endTask(long taskInstance,String applyId){		
		applyService.endTask(taskInstance,applyId);
	}	
	
	public String retrieveByteArraysOfGpd(long taskInstanceId){
		return applyService.retrieveByteArraysOfGpd(taskInstanceId);
	}    		
	
	
	/**
	 * 根据申请单页面的的条件查询条件范围内的申请单列表
	 * date : 2006-12-05
	 */	
	public List getLogicElemDtoList(CommonQueryObj queryobj) {
		return applyService.getLogicElemDtoList(queryobj);
	}
		
	public List getApplyList(String actorid) {
		return applyService.getApplyList(actorid);
	}
	
}
