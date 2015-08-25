package com.techstar.dmis.service.workflow.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.dto.DdAccidentbriefWFTaskDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IDdAccidentbriefWFService;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;

/**
 * 工作流操作服务类
 * @author 
 * @date
 */
public class DdAccidentbriefWFServiceImpl implements IDdAccidentbriefWFService{
	
	private IWorkflowDao workFlowDao;
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}

	IHandleHistoryDao handleHistoryDao;
	public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao) {
		this.handleHistoryDao = handleHistoryDao;
	}
	
	public int ddAccidentBriefApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_APPROVE_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_APPROVE_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}				
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int ddAccidentBriefExecute(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int ddAccidentBriefModify(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int start(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao
					.start(
							DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_PROCESSDIFINITION,
							dto.getBusId(), dto.getUserId(), dto
									.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		} catch (Exception ex) {
			throw new WorkflowException();
			
		}
		return 1;
	}
    

}
