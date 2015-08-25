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

public interface IZdhReceptionWFService {
    
    //启动
	public int start(WorkflowHandleDto dto) throws DataAccessException;
	//市调专工审核
	public int projectrecptionSpecApprove(WorkflowHandleDto dto) throws DataAccessException;
	//填报角色修改申请
	public int projectrecptionModify(WorkflowHandleDto dto) throws DataAccessException;
    //填报角色上报验收资料
	public int projectrecptionReport(WorkflowHandleDto dto) throws DataAccessException;
	//市调专工审核资料完整性
	public int projectrecptionApproveFill(WorkflowHandleDto dto) throws DataAccessException;
	//市调专工归档
	public int projectrecptionKeepon(WorkflowHandleDto dto) throws DataAccessException;
	//运行投运申请
	public int projectrecptionRunApply(WorkflowHandleDto dto) throws DataAccessException;
	//专工投运审核
	public int projectrecptionRunApprove(WorkflowHandleDto dto) throws DataAccessException;
	//执行
	public int projectrecptionExec(WorkflowHandleDto dto) throws DataAccessException;
	
}
