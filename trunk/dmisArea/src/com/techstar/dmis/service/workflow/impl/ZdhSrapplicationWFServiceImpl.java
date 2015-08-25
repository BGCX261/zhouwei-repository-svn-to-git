package com.techstar.dmis.service.workflow.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;

import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.dto.ZdhSrapplicationWFTaskDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IZdhSrapplicationWFService;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;

/**
 * 工作流操作服务类
 * @author 
 * @date
 */
public class ZdhSrapplicationWFServiceImpl implements IZdhSrapplicationWFService{
	
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

			this.workFlowDao.start(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_PROCESSDIFINITION,
							dto.getBusId(), dto.getUserId(), dto
									.getNextTaskRoles());
			
			handleHistoryDao.saveOrUpdate(dto);
		} catch (Exception ex) {
			throw new WorkflowException();
			
		}
		return 1;
	}
	
	public int zdhSrapplBdheaderApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdheaderApprove_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdheaderApprove_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplBdrunModify(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());	
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplBdrunTasksent(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());	
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplBdspecApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	/**
	 * 主任审批
	 */
	public int zdhSrapplDirectorApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_DirectorApprove_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_DirectorApprove_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	/**
	 * 处长审批
	 */
	public int zdhSrapplHeaderApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {//通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_HeaderApprove_TRANSIT_YES,
								dto.getUserId(), 
								dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_HeaderApprove_TRANSIT_NO,
								dto.getUserId(), 
								dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	/**
	 * 主管主任审批
	 */
	public int zdhSrapplMDicrecterApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_MDicrecterApprove_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {//不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_MDicrecterApprove_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplRunExec(WorkflowHandleDto dto) throws DataAccessException {
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
	 * 自动化专工下发未批准意见
	 */
	public int zdhSrapplSentComment(WorkflowHandleDto dto) throws DataAccessException {      
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {
                //没有通过审批,返回变电公司进行修改
				this.workFlowDao.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_SpecSentConceit_TOBD,
								dto.getUserId(), dto.getNextTaskRoles());
				
			} else if ("2".equals(transitionflag)) {
			   //没有通过审批,返回自动化运行处
				this.workFlowDao.endTask(
						Long.parseLong(dto.getTaskInstanceId()),
						ZdhConstants.ZdhSrappl_WORKFLOW_CITY_SpecSentConceit_TOZDHYXC,
						dto.getUserId(), dto.getNextTaskRoles());
			} else if ("3".equals(transitionflag)) {
				//没有通过审批,返回区调
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_SpecSentConceit_TOQD,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplSentResult(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());		
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplSpecApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			
			System.out.println(" start apply *******");
			if ("1".equals(transitionflag)) {// 通过
				
				System.out.println("000000000"+transitionflag);
				System.out.println("1111111"+dto.getTaskInstanceId());
				System.out.println("2222222"+ZdhConstants.ZdhSrappl_WORKFLOW_CITY_SpecApprove_TRANSIT_YES);
				System.out.println("333333333"+dto.getUserId());
				System.out.println("44444444"+dto.getNextTaskRoles());
				System.out.println("555555"+dto.getTaskId());
				
				
				
				
				this.workFlowDao
						.endTask(
								
								Long.parseLong(dto.getTaskInstanceId()),
								
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_SpecApprove_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
				
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_SpecApprove_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			System.out.println("ZdhSrapplicationWFServiceImpl 异常:"+ex.getMessage());
			ex.printStackTrace();
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplSpecKeepon(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());		
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	public int zdhSrapplZdhrunApprove(WorkflowHandleDto dto) throws DataAccessException {
		try{
			String transitionflag = dto.getTransitionFlag();
			if ("1".equals(transitionflag)) {// 通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_ZdhrunApprove_TRANSIT_YES,
								dto.getUserId(), dto.getNextTaskRoles());
			} else if ("-1".equals(transitionflag)) {// 不通过
				this.workFlowDao
						.endTask(
								Long.parseLong(dto.getTaskInstanceId()),
								ZdhConstants.ZdhSrappl_WORKFLOW_CITY_ZdhrunApprove_TRANSIT_NO,
								dto.getUserId(), dto.getNextTaskRoles());
			}			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
	
	
	public int zdhSrapplZdhrunModify(WorkflowHandleDto dto) throws DataAccessException {
		try{
			this.workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto
					.getUserId(), dto.getNextTaskRoles());			
			
			handleHistoryDao.saveOrUpdate(dto);
		}catch(Exception ex){
			throw new WorkflowException();
		}
		return 1;
	}
    

}
