package com.techstar.dmis.service.workflow.impl;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IZdhWorkbillWFService;
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;

/**
 * 工作流操作服务类
 * @author 
 * @date
 */
public class ZdhWorkbillWFServiceImpl implements IZdhWorkbillWFService{
	
	private IWorkflowDao workFlowDao;
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
	
	IHandleHistoryDao handleHistoryDao;
	public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao) {
		this.handleHistoryDao = handleHistoryDao;
	}
	
	public int start(WorkflowHandleDto dto) throws DataAccessException {
		try{

			this.workFlowDao
					.start(
							ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_PROCESSDIFINITION,
							dto.getBusId(), dto.getUserId(), dto
									.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		} catch (Exception ex) {
			throw new WorkflowException();
			
		}
		return 1;
	}
	/**
	 * 运维中心主任签发
	 */
	public int zdhworkbillCenterApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_APPROVE_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_APPROVE_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhworkbillModify(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());		
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhworkbillPermit(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_PERMIT_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_PERMIT_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
				
				
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	/**
     * 工作负责人签字(归档)
     */
	public int zdhworkbillWorkerSign(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());				
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
    
		//please add your business methods start
	// to do it
	
	
	//add your business method end
	
}
