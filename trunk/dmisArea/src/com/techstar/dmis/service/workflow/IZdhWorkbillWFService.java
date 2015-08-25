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

public interface IZdhWorkbillWFService {
    

     	 
    //启动
	public int start(WorkflowHandleDto dto) throws DataAccessException;
	//运维中心主任签发
	public int zdhworkbillCenterApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//许可人签字
	public int zdhworkbillPermit(WorkflowHandleDto dto) throws DataAccessException ;
	//工作人签字
	public int zdhworkbillWorkerSign(WorkflowHandleDto dto) throws DataAccessException ;
	//工作票修改
	public int zdhworkbillModify(WorkflowHandleDto dto) throws DataAccessException ;

	
	
}
