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
	 * �õ������б�
	 * 
	 * @return List
	 */
	public List listApply() {
		return applyService.listApply().getElemList();
	}

	/**
	 * ���������б�
	 * 
	 * @param dto
	 */
	public void addApply(ApplyDto dto) {
		applyService.saveOrUpdateApply(dto);
	}

	/**
	 * ����ID�õ�����Dto
	 * 
	 * @param applyId
	 *            Integer ����ֵ
	 */
	public ApplyDto getApplyById(String applyId) {
		ApplyDto dto = applyService.loadApply(applyId);
		return dto;
	}

	/**
	 * ɾ��ָ�������벢�����²�ѯ�б�
	 * 
	 * @param applyId
	 *            Integer ����ֵ
	 */
	public List deleteApply(String applyId) {
		applyService.deleteApply(applyId);
		return applyService.listApply().getElemList();
	}

	/**
	 * �õ������б�
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
	 * function : ��ҵ��������м���Թ������ӿڵļ򵥵���--��������
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
	 * �������뵥ҳ��ĵ�������ѯ������Χ�ڵ����뵥�б�
	 * date : 2006-12-05
	 */	
	public List getLogicElemDtoList(CommonQueryObj queryobj) {
		return applyService.getLogicElemDtoList(queryobj);
	}
		
	public List getApplyList(String actorid) {
		return applyService.getApplyList(actorid);
	}
	
}
