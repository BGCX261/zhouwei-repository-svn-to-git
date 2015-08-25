package com.techstar.dmis.service.workflow.impl;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IZdhCharalterrecordWFService;
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;

/**
 * 工作流操作服务类
 * @author 
 * @date
 */
public class ZdhCharalterrecordWFServiceImpl implements IZdhCharalterrecordWFService{
	
	private IWorkflowDao workFlowDao;
	private IHandleHistoryDao handleHistoryDao;
	
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}

	public int start(WorkflowHandleDto dto) throws DataAccessException {
		try{

			this.workFlowDao
					.start(
							ZdhConstants.ZDHCharalterrecord_WORKFLOW_CITY_PROCESSDIFINITION,
							dto.getBusId(), dto.getUserId(), dto
									.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new WorkflowException();
			
		}
		return 1;
	}
	
	public int zdhCharalterrecordApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZDHCharalterrecord_WORKFLOW_CITY_APPROVE_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZDHCharalterrecord_WORKFLOW_CITY_APPROVE_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int ZdhCharalterrecordAssign(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhCharalterrecordCoursign(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = 0;
		try{
			String[] roles = new String[] { "" };
			if (dto.getNextTaskRoles() != null) {
				roles = dto.getNextTaskRoles();
			}
			String returnStr = this.workFlowDao.oneTicketNoForCountersign(Long
					.parseLong(dto.getTaskInstanceId()), dto.getRoleId(), Integer
					.parseInt(dto.getTransitionFlag()));

			
			if ("1".equals(returnStr)) {// 通过
				this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
						.getUserId(), dto.getNextTaskRoles());
				ireturn = 1;
			}			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WorkflowException();
		}
		return ireturn;
	}
	
	public int zdhCharalterrecordExec(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhCharalterrecordSign(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new WorkflowException();
		}
		return 1;
	}
	
	public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao) {
		this.handleHistoryDao = handleHistoryDao;
	}

	public IHandleHistoryDao getHandleHistoryDao() {
		return handleHistoryDao;
	}
	
    
		//please add your business methods start
	// to do it
	
	
	
	//add your business method end
	
}
