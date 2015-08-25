package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdMoutageplanDto;

//注册子表DAO
import com.techstar.dmis.dto.DdRepairdetailDto;
import com.techstar.dmis.dto.DdPremethodDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口类
 *
 * @author
 * @date
 */
public interface IDdMoutageplanService {

	public void addDdMoutageplan(DdMoutageplanDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 *
	 *
	 * @param dto
	 *            DdMoutageplanDto 业务传输对象
	 *
	 */
	public void saveOrUpdateDdMoutageplan(DdMoutageplanDto dto);

	public void saveOrUpdateDdMoutageplan(List dtos);

	/**
	 * 进行加载的业务操作
	 *
	 * @param ddMoutageplanId
	 *            Integer 主键值ֵ
	 *
	 */
	public DdMoutageplanDto loadDdMoutageplan(String ddMoutageplanId);

	/**
	 * 删除指定的业务
	 *
	 * @param ddMoutageplanId
	 *            Integer 主键值ֵ
	 *
	 */
	public void deleteDdMoutageplan(String ddMoutageplanId, String version);

	/**
	 * 删除指定的业务集合
	 *
	 */
	public void deleteDdMoutageplan(List dtos);

	/**
	 * 进行申请查询操作业务处理
	 */

	/**
	 * 进行申请查询操作业务处理(分页)
	 *
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 *
	 */
	public QueryListObj listDdMoutageplan();

	public QueryListObj listDdMoutageplanByHql(String hql);

	public QueryListObj getDdMoutageplanByHql(String hql, int beginPage,
			int pageSize, String sql);

	// please add your business methods start
	// to do it
	// add your business method end

	// 子表处理DAO
	public QueryListObj listDdRepairdetail();

	public void saveOrUpdateDdRepairdetail(DdRepairdetailDto dto);

	public void deleteDdRepairdetail(String fid);

	public DdRepairdetailDto loadDdRepairdetail(String fid);

	public QueryListObj listDdRepairdetailByHql(String hql);

	public void saveOrUpdateDdRepairdetail(List dtos);

	public void deleteDdRepairdetail(List dtos);

	public QueryListObj listDdPremethod();

	public void saveOrUpdateDdPremethod(DdPremethodDto dto);

	public void deleteDdPremethod(String fpremethodid);

	public DdPremethodDto loadDdPremethod(String fpremethodid);

	public QueryListObj listDdPremethodByHql(String hql);

	public void saveOrUpdateDdPremethod(List dtos);

	public void deleteDdPremethod(List dtos);

    public abstract void start(WorkflowHandleDto workflowhandledto);

    public abstract void ddMonthPlanCleanUp(WorkflowHandleDto workflowhandledto);

    public abstract void ddMonthPlanSentResult(WorkflowHandleDto workflowhandledto);

    public abstract void ddMonthPlanApproveAndSend(WorkflowHandleDto workflowhandledto);

    public abstract void ddMonthPlanModify(WorkflowHandleDto workflowhandledto);

    public abstract void ddMonthPlanCleanUpResult(WorkflowHandleDto workflowhandledto);

    public abstract void recBussData(List list);

    public abstract void recBussDataWaiting(List list);
}
