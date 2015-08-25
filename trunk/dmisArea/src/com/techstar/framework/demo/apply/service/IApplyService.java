package com.techstar.framework.demo.apply.service;

import java.util.List;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.dto.ApplyDto;

public interface IApplyService {
	/**
	 * 进行申请增加或修改操作业务处理
	 * 
	 * @param dto
	 *            ApplyDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateApply(ApplyDto dto);

	/**
	 * 进行申请加载的业务操作
	 * 
	 * @param applyId
	 *            Integer 主键值
	 * 
	 */
	public ApplyDto loadApply(String applyId);

	/**
	 * 删除指定的业务
	 * 
	 * @param applyId
	 *            Integer 主键值
	 * 
	 */
	public void deleteApply(String applyId);

	/**
	 * 进行申请查询操作业务处理
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj listApply();
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj getQueryList(int beginPage, int pageSize);

	public List getLogicElemDtoList(CommonQueryObj queryobj);
	
	/**
	 * 启动流程
	 */
	public void start(String processDefinition); 
	/**
	 * 启动流程
	 */	    
	public void start(String processDefinition,String businessId) ;	    
	/**
	 * 
	 */
    public  List findTransitionLog(long processInstance) ;

	/**
	 * 
	 */
    public List findPooledTaskInstances(String actorId) ;
	/**
	 * 流程挂起
	 */
    public void suspend(long processInstance);
	/**
	 * 结束任务
	 */		
    public void endTask(long taskInstance,String applyId);
	/**
	 * 流程挂起
	 */		
    public String retrieveByteArraysOfGpd(long taskInstanceId);
    
	/**
	 * function :获取当前用户创建的业务申请单和其他用户创建,但需要该用户处理的所有数据列表,该方法为配合现有工作流-demo,暂不考虑效率问题
	 * date : 2006-12-06
	 */
    public List getApplyList(String actorid) ;
	
}
