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

public interface IZdhCharalterrecordWFService {
    

     	 
	 //please add your business methods start
	 // to do it
    //启动
	public int start(WorkflowHandleDto dto) throws DataAccessException;	
	//调度室领导签字
	public int zdhCharalterrecordSign(WorkflowHandleDto dto) throws DataAccessException ;
	//盖执行章
	public int zdhCharalterrecordExec(WorkflowHandleDto dto) throws DataAccessException ;
	//运维中心任务分配
	public int ZdhCharalterrecordAssign(WorkflowHandleDto dto) throws DataAccessException ;
	//调度审核
	public int zdhCharalterrecordApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//图形和数据会签处理
	public int zdhCharalterrecordCoursign(WorkflowHandleDto dto) throws DataAccessException ;
	//add your business method end
	
}
