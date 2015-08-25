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

public interface IDdAccidentbriefWFService {
    
	public int start(WorkflowHandleDto dto) throws DataAccessException;
	
	public int ddAccidentBriefApprove(WorkflowHandleDto dto) throws DataAccessException; 
	
	public int ddAccidentBriefModify(WorkflowHandleDto dto) throws DataAccessException; 
	
	public int ddAccidentBriefExecute(WorkflowHandleDto dto) throws DataAccessException; 
	
}
