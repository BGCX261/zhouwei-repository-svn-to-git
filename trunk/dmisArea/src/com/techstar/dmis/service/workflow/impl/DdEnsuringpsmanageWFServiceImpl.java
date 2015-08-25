package com.techstar.dmis.service.workflow.impl;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.entity.HandleHistory;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IDdEnsuringpsmanageWFService;
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;
import com.techstar.dmis.util.DateUtil;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import com.techstar.framework.utils.SequenceCreator;

/**
 * 工作流操作服务类
 * 
 * @author
 * @date
 */
public class DdEnsuringpsmanageWFServiceImpl implements
		IDdEnsuringpsmanageWFService {

	private IWorkflowDao workFlowDao;
	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
	
	IHandleHistoryDao handleHistoryDao;
	public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao) {
		this.handleHistoryDao = handleHistoryDao;
	}
	


	/**
	 * 撤回审批
	 */
	public int appReback(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao
					.endTask(
							Long.parseLong(dto.getTaskInstanceId()),
							DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_SENT_TRANSIT_REBACK,
							dto.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}

	/**
	 * 审批完毕
	 */
	public int approve(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}

	/**
	 * 会签
	 */
	public int countersign(WorkflowHandleDto dto) throws DataAccessException {
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
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_COURSIGN_TRANSIT_YES,
								dto.getUserId(), roles);
				ireturn = 1;
			} else if ("-1".equals(returnStr)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_COURSIGN_TRANSIT_NO,
								dto.getUserId(), roles);
				ireturn = -1;
			}
			
			handleHistoryDao.saveOrUpdate(dto);
		
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return ireturn;
	}

	/**
	 * 执行完毕
	 */
	public int execute(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}

	/**
	 * 归档完毕
	 */
	public int keepon(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}

	/**
	 * 修改完毕
	 */
	public int modify(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}

	/**
	 * 下发完毕
	 */
	public int sent(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao
					.endTask(
							Long.parseLong(dto.getTaskInstanceId()),
							DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_SENT_TRANSIT_GO,
							dto.getUserId(), dto.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}

	/**
	 * 启动工作流
	 */
	public int start(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao
					.start(
							DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_PROCESSDIFINITION,
							dto.getBusId(), dto.getUserId(), dto
									.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		} catch (Exception ex) {
			throw new WorkflowException();
			
		}
		return 1;
	}
	
	// please add your business methods start
	// to do it
	// add your business method end

}
