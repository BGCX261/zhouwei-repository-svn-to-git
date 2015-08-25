package com.techstar.dmis.service.workflow.impl;

import org.springframework.dao.DataAccessException;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IZdhReceptionWFService;
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;

/**
 * 工作流操作服务类
 * @author 
 * @date
 */
public class ZdhReceptionWFServiceImpl implements IZdhReceptionWFService{
	
	private IWorkflowDao workFlowDao;
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
	
	IHandleHistoryDao handleHistoryDao;
	public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao) {
		this.handleHistoryDao = handleHistoryDao;
	}
	
	public int projectrecptionApproveFill(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1C".equals(transitionflag)) {// 市调通过
				
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.projection_WORKFLOW_CITY_ApproveFill_TRANSIT_YES_CITY,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("1A".equals(transitionflag)) {// 区调通过
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_ApproveFill_TRANSIT_YES_AREA,
						dto.getUserId(), dto.getNextTaskRoles());
				
			}else if 	("-1C".equals(transitionflag)) {// 市调驳回
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_ApproveFill_TRANSIT_NO_CITY,
						dto.getUserId(), dto.getNextTaskRoles());	
				
			}else if 	("-1A".equals(transitionflag)) {// 区调驳回
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_ApproveFill_TRANSIT_NO_AREA,
						dto.getUserId(), dto.getNextTaskRoles());				
				
			}
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionExec(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionKeepon(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionModify(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionReport(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionRunApply(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionRunApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1C".equals(transitionflag)) {// 市调通过
				
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.projection_WORKFLOW_CITY_RunApprove_TRANSIT_YES_CITY,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("1A".equals(transitionflag)) {// 区调通过
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_RunApprove_TRANSIT_YES_AREA,
						dto.getUserId(), dto.getNextTaskRoles());
			}else if 	("-1A".equals(transitionflag)) {// 区调驳回
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_RunApprove_TRANSIT_NO_AREA,
						dto.getUserId(), dto.getNextTaskRoles());				
			}else if 	("-1C".equals(transitionflag)) {// 市调驳回
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_RunApprove_TRANSIT_NO_CITY,
						dto.getUserId(), dto.getNextTaskRoles());				
			}
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int projectrecptionSpecApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1C".equals(transitionflag)) {// 市调通过
				
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.projection_WORKFLOW_CITY_SpecApprove_TRANSIT_YES_CITY,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("1A".equals(transitionflag)) {// 区调通过
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_SpecApprove_TRANSIT_YES_AREA,
						dto.getUserId(), dto.getNextTaskRoles());
			}else if 	("-1A".equals(transitionflag)) {// 区调驳回
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_SpecApprove_TRANSIT_NO_AREA,
						dto.getUserId(), dto.getNextTaskRoles());				
			}else if 	("-1C".equals(transitionflag)) {// 市调驳回
				
				this.workFlowDao
				.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.projection_WORKFLOW_CITY_SpecApprove_TRANSIT_NO_CITY,
						dto.getUserId(), dto.getNextTaskRoles());				
			}
			
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
							ZdhConstants.projection_WORKFLOW_CITY_PROCESSDIFINITION,
							dto.getBusId(), dto.getUserId(), dto
									.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		} catch (Exception ex) {
			throw new WorkflowException();
			
		}
		return 1;
	}
    

	
}
