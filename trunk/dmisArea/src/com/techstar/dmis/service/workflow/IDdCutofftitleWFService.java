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

public interface IDdCutofftitleWFService {
    

	public int start(WorkflowHandleDto dto) throws DataAccessException;
	//调度处长审批拉路序位表
	public int limitLineSeqFormHeaderApprove(WorkflowHandleDto dto) throws DataAccessException; 
	//拉路序位表发布
	public int limitLineSeqFormRelease(WorkflowHandleDto dto) throws DataAccessException; 
	//拉路序位表修改
	public int limitLineSeqFormModify(WorkflowHandleDto dto) throws DataAccessException; 
	//负荷专工审核
	public int limitLineSeqFormSpecApprove(WorkflowHandleDto dto) throws DataAccessException; 
	
}
