package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhCharalterrecordDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhCharalterrecordService {

    public void addZdhCharalterrecord(ZdhCharalterrecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhCharalterrecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhCharalterrecord(ZdhCharalterrecordDto dto);
	public void saveOrUpdateZdhCharalterrecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhCharalterrecordId
	 *            Integer 主键值ֵ
	 */
	public ZdhCharalterrecordDto loadZdhCharalterrecord(String zdhCharalterrecordId);

	/**
	 * 删除指定的业务
	 * @param zdhCharalterrecordId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhCharalterrecord(String zdhCharalterrecordId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listZdhCharalterrecord();
public QueryListObj listZdhCharalterrecordByHql(String hql);
public QueryListObj getZdhCharalterrecordByHql(String hql,int beginPage, int pageSize,String sql);
public void deleteZdhCharalterrecord(String zdhCharalterrecordId,int version);
public ZdhCharalterrecordDto getZdhCharRecordByForeign(String foreignId);

//启动
public void start(WorkflowHandleDto dto);

//调度室领导签字
public void zdhCharalterrecordSign(WorkflowHandleDto dto);

//盖执行章
public void zdhCharalterrecordExec(WorkflowHandleDto dto);

//运维中心任务分配
public void zdhCharalterrecordAssign(WorkflowHandleDto dto);

//调度审核
public void zdhCharalterrecordApprove(WorkflowHandleDto dto);

//图形和数据会签处理
public void zdhCharalterrecordCoursign(WorkflowHandleDto dto);


	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
