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

public interface IDdSwitchseqbillWFService {
    

    //启动
	public int start(WorkflowHandleDto dto) throws DataAccessException;
	//审核
	public int ddSwitchseqBillApprove(WorkflowHandleDto dto) throws DataAccessException;
	//执行
	public int ddSwitchseqBillExec(WorkflowHandleDto dto) throws DataAccessException;
	//修改
	public int ddSwitchseqBillModify(WorkflowHandleDto dto) throws DataAccessException;
	
	
}
