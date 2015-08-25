package com.techstar.framework.demo.apply.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.apply.dao.IApplyDao;
import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.demo.entity.Apply;
import com.techstar.framework.demo.apply.service.IApplyService;
import com.techstar.framework.demo.apply.service.help.ApplyServiceHelper;
import com.techstar.framework.demo.workflow.service.IDemoWorkflowService;
import com.techstar.framework.service.commonquery.ICommonQueryService;
import com.techstar.framework.service.workflow.bus.dto.TaskDto;
import com.techstar.framework.utils.BeanHelper;

/**
 * 此类用于提供本DEMO应用层接口，通过此类用户可得到申请服务
 * 
 * @author xcf
 */
public class ApplyServiceImpl implements IApplyService {

	private IApplyDao applyDao;
	private IDemoWorkflowService applyWorkflowService;
	private ICommonQueryService applyCommonQueryService;
	
	/**
	 * 在此注册子表dao
	 * 例：
	 * private IApplySubDao applySubDao;
	 * public void setApplySubDao(IApplySubDao applySubDao) {
		this.applySubDao = applySubDao;
	   }
	**/
	
	public ApplyServiceImpl() {
	}

	public void saveOrUpdateApply(ApplyDto dto) {
		Apply apply = (Apply) BeanHelper.buildBean(Apply.class, dto);
		applyDao.saveOrUpdate(apply);
	}

	public void deleteApply(String applyId) {
		Apply apply = new Apply();
		apply.setApplyId(applyId);
		applyDao.delete(apply);
	}

	public ApplyDto loadApply(String applyId) {
		Apply apply = (Apply) applyDao.findByPk(applyId);
		ApplyDto dto = (ApplyDto) BeanHelper.buildBean(ApplyDto.class, apply);
		return dto;
	}

	public QueryListObj listApply() {
		QueryListObj obj = applyDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ApplyDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getQueryList(int beginPage, int pageSize) {
		QueryListObj obj = applyDao.getQueryList(beginPage,
				pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ApplyDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		return obj;
	}

	public IApplyDao getApplyDao() {
		return applyDao;
	}

	public void setApplyDao(IApplyDao applyDao) {
		this.applyDao = applyDao;
	}
	

	public void setApplyWorkflowService(IDemoWorkflowService applyWorkflowService) {
		this.applyWorkflowService = applyWorkflowService;
	}
	
	public void setapplyCommonQueryService(ICommonQueryService applyCommonQueryService) {
		this.applyCommonQueryService = applyCommonQueryService;
	}
	
	/**
	 * function : 在业务对象处理中加入对工作流接口的简单调用--发起流程
	 * date : 2006-12-5
	 */
    public void start(String processDefinition) {
    	applyWorkflowService.start(processDefinition);
    }
    
    public void start(String processDefinition,String applyId) {
    	applyWorkflowService.start(processDefinition, applyId);
    	setApplyStatus(applyId);
    }

	public  List findTransitionLog(long processInstance) {		
		return applyWorkflowService.findTransitionLog(processInstance);
	}

	public List findPooledTaskInstances(String actorId) {		
		return applyWorkflowService.findPooledTaskInstances(actorId);
	}

	public void suspend(long processInstance){		
		applyWorkflowService.suspend(processInstance);
	}	
	
	public void endTask(long taskInstance,String applyId){		
		applyWorkflowService.endTask(taskInstance);
		setApplyStatus(applyId);	
	}	
	
	public String retrieveByteArraysOfGpd(long taskInstanceId){
		return applyWorkflowService.retrieveByteArraysOfGpd(taskInstanceId);
	}    	
	
	/**
	 * 根据申请单页面的的条件查询条件范围内的申请单列表
	 * 
	 */	
	public List getLogicElemDtoList(CommonQueryObj queryobj) {
		return applyCommonQueryService.getLogicElemDtoList(queryobj);
	}
	
	
	/**
	 * function :获取当前用户创建的业务申请单和其他用户创建,但需要该用户处理的所有数据列表,该方法为配合现有工作流-demo,暂不考虑效率问题
	 * date : 2006-12-06
	 */	
	public List getApplyList(String actorid) {		
		ApplyServiceHelper helper = new ApplyServiceHelper();	
		List applyList = listApply().getElemList();
		List taskList = findPooledTaskInstances(actorid);		
		return helper.getApplyList(applyList,taskList,actorid);
	} 
	
   
	/**
	 * function :设置业务表单处理状态,该方法为配合现有工作流-demo
	 * date : 2006-12-06
	 */
	private void setApplyStatus(String applyId){
		if (StringUtils.isNotEmpty(applyId)) {
			Apply apply = (Apply) applyDao.findByPk(applyId);
			String status = apply.getStatus();
			int istatus = 0;
			if(status == null || status.equals("0")) {
				istatus = 2;
			}
			else {
				istatus = Integer.parseInt(apply.getStatus())+1;
			}
			
			apply.setStatus(Integer.toString(istatus));
			applyDao.saveOrUpdate(apply);
		}		
	}
	
}
