package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhSrapplicationDto;

	//注册子表DAO
import com.techstar.dmis.dto.ZdhSrappeqprelDto;
import com.techstar.dmis.entity.ZdhSrapplication;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhSrapplicationService {

    public void addZdhSrapplication(ZdhSrapplicationDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhSrapplicationDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhSrapplication(ZdhSrapplicationDto dto);
	public void saveOrUpdateZdhSrapplication(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhSrapplicationId
	 *            Integer 主键值ֵ
	 */
	public ZdhSrapplicationDto loadZdhSrapplication(String zdhSrapplicationId);

	/**
	 * 删除指定的业务
	 * @param zdhSrapplicationId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhSrapplication(String zdhSrapplicationId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhSrapplication(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhSrapplication();
	 public QueryListObj listZdhSrapplicationByHql(String hql);
	 public QueryListObj getZdhSrapplicationByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end
	 public void recBussData(List list);
	
	

 	//子表处理DAO
       public QueryListObj listZdhSrappeqprel();
   public void saveOrUpdateZdhSrappeqprel(ZdhSrappeqprelDto dto);
   public void deleteZdhSrappeqprel(String fid);
   public ZdhSrappeqprelDto loadZdhSrappeqprel(String fid);
   public QueryListObj listZdhSrappeqprelByHql(String hql);
   public void saveOrUpdateZdhSrappeqprel(List dtos);
   public void deleteZdhSrappeqprel(List dtos);
   //生成传动记录
   public void genTransrecord(ZdhSrapplication zdhSrapplication);
   //生成传动记录和停复役的对应关系
   public void genSrappToTransrecord (ZdhSrapplication zdhSrapplication,WorkflowHandleDto dto);
	//please add your business methods start
	// to do it
	//add your business method end
	
    //启动
	public void start(WorkflowHandleDto dto) throws DataAccessException;
	//变电公司自动化专工审批
	public void zdhSrapplBdspecApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//变电运行单位修改申请
	public void zdhSrapplBdrunModify(WorkflowHandleDto dto) throws DataAccessException ;	
	//变电公司领导审批
	public void zdhSrapplBdheaderApprove(WorkflowHandleDto dto) throws DataAccessException ;	
	//自动化运行处处长审批
	public void zdhSrapplZdhrunApprove(WorkflowHandleDto dto) throws DataAccessException ;	
	//自动化运行处修改
	public void zdhSrapplZdhrunModify(WorkflowHandleDto dto) throws DataAccessException ;
	//变电自动化专工任务下发
	public void zdhSrapplBdrunTasksent(WorkflowHandleDto dto) throws DataAccessException ;
	//运行单位执行
	public void zdhSrapplRunExec(WorkflowHandleDto dto) throws DataAccessException ;
	//下发审批任务
	public void zdhSrapplSentResult(WorkflowHandleDto dto) throws DataAccessException ;
	//主任审批
	public void zdhSrapplDirectorApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//主管主任审批
	public void zdhSrapplMDicrecterApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//将审批意见下发
	public void zdhSrapplSentComment(WorkflowHandleDto dto) throws DataAccessException ;
	//专工审批
	public void zdhSrapplSpecApprove(WorkflowHandleDto dto) throws DataAccessException ;
	//专工归档
	public void zdhSrapplSpecKeepon(WorkflowHandleDto dto) throws DataAccessException ;
	//处长审批
	public void zdhSrapplHeaderApprove(WorkflowHandleDto dto) throws DataAccessException ;
}
