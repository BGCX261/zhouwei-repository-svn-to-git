package com.techstar.dmis.service.workflow;

import java.util.List;
import java.util.Map;
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象工作流服务接口类
 * @author 
 * @date
 */
import org.springframework.dao.DataAccessException;

import com.techstar.dmis.helper.dto.WorkflowHandleDto;

public interface IZdhSrapplicationWFService {
    
    //启动
	public int start(WorkflowHandleDto dto) throws DataAccessException;
	//变电公司自动化专工审批
	public int zdhSrapplBdspecApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//变电运行单位修改申请
	public int zdhSrapplBdrunModify(WorkflowHandleDto dto) throws DataAccessException ;	
	//变电公司领导审批
	public int zdhSrapplBdheaderApprove(WorkflowHandleDto dto) throws DataAccessException ;	
	//自动化运行处处长审批
	public int zdhSrapplZdhrunApprove(WorkflowHandleDto dto) throws DataAccessException ;	
	//自动化运行处修改
	public int zdhSrapplZdhrunModify(WorkflowHandleDto dto) throws DataAccessException ;
	//变电自动化专工任务下发
	public int zdhSrapplBdrunTasksent(WorkflowHandleDto dto) throws DataAccessException ;
	//运行单位执行
	public int zdhSrapplRunExec(WorkflowHandleDto dto) throws DataAccessException ;
	//下发审批任务
	public int zdhSrapplSentResult(WorkflowHandleDto dto) throws DataAccessException ;
	//主任审批
	public int zdhSrapplDirectorApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//主管主任审批
	public int zdhSrapplMDicrecterApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//将审批意见下发
	public int zdhSrapplSentComment(WorkflowHandleDto dto) throws DataAccessException ;
	//专工审批
	public int zdhSrapplSpecApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//专工归档
	public int zdhSrapplSpecKeepon(WorkflowHandleDto dto) throws DataAccessException ;
	//处长审批
	public int zdhSrapplHeaderApprove(WorkflowHandleDto dto) throws DataAccessException ;
	
}
