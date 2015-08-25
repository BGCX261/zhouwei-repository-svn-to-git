package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhReceptionDto;

	//注册子表DAO
import com.techstar.dmis.dto.ZdhReceptioneqprelDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhReceptionService {

    public void addZdhReception(ZdhReceptionDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhReceptionDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhReception(ZdhReceptionDto dto);
	public void saveOrUpdateZdhReception(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhReceptionId
	 *            Integer 主键值ֵ
	 */
	public ZdhReceptionDto loadZdhReception(String zdhReceptionId);

	/**
	 * 删除指定的业务
	 * @param zdhReceptionId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhReception(String zdhReceptionId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhReception(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhReception();
	 public QueryListObj listZdhReceptionByHql(String hql);
	 public QueryListObj getZdhReceptionByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listZdhReceptioneqprel();
   public void saveOrUpdateZdhReceptioneqprel(ZdhReceptioneqprelDto dto);
   public void deleteZdhReceptioneqprel(String receptioneqprelid);
   public ZdhReceptioneqprelDto loadZdhReceptioneqprel(String receptioneqprelid);
   public QueryListObj listZdhReceptioneqprelByHql(String hql);
   public void saveOrUpdateZdhReceptioneqprel(List dtos);
   public void deleteZdhReceptioneqprel(List dtos);
	
//工作流
   //启动
	public void start(WorkflowHandleDto dto) throws DataAccessException;
	//市调专工审核
	public void projectrecptionSpecApprove(WorkflowHandleDto dto) throws DataAccessException;
	//填报角色修改申请
	public void projectrecptionModify(WorkflowHandleDto dto) throws DataAccessException;
   //填报角色上报验收资料
	public void projectrecptionReport(WorkflowHandleDto dto) throws DataAccessException;
	//市调专工审核资料完整性
	public void projectrecptionApproveFill(WorkflowHandleDto dto) throws DataAccessException;
	//市调专工归档
	public void projectrecptionKeepon(WorkflowHandleDto dto) throws DataAccessException;
	//运行投运申请
	public void projectrecptionRunApply(WorkflowHandleDto dto) throws DataAccessException;
	//专工投运审核
	public void projectrecptionRunApprove(WorkflowHandleDto dto) throws DataAccessException;
	//执行
	public void projectrecptionExec(WorkflowHandleDto dto) throws DataAccessException;

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
