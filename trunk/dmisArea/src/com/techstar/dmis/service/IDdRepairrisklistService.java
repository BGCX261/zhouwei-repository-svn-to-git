package com.techstar.dmis.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdRepairrisklistDto;

//注册子表DAO
import com.techstar.dmis.dto.DdMoutageplanDto;
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
public interface IDdRepairrisklistService {

	public void addDdRepairrisklistByMplans(String[] strs,
			String sys_dataowner, String sys_filldept, String sys_fille,
			Timestamp sys_filltime);

	public void addDdRepairrisklist(DdRepairrisklistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * 
	 * @param dto
	 *            DdRepairrisklistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdRepairrisklist(DdRepairrisklistDto dto);

	public void saveOrUpdateDdRepairrisklist(List dtos);

	/**
	 * 进行加载的业务操作
	 * 
	 * @param ddRepairrisklistId
	 *            Integer 主键值ֵ
	 * 
	 */
	public DdRepairrisklistDto loadDdRepairrisklist(String ddRepairrisklistId);

	/**
	 * 删除指定的业务
	 * 
	 * @param ddRepairrisklistId
	 *            Integer 主键值ֵ
	 * 
	 */
	public void deleteDdRepairrisklist(String ddRepairrisklistId);

	/**
	 * 删除指定的业务集合
	 * 
	 */
	public void deleteDdRepairrisklist(List dtos);

	/**
	 * 进行申请查询操作业务处理
	 */

	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 * 
	 */
	public QueryListObj listDdRepairrisklist();

	public QueryListObj listDdRepairrisklistByHql(String hql);

	public QueryListObj getDdRepairrisklistByHql(String hql, int beginPage,
			int pageSize, String sql);

	// please add your business methods start
	// to do it
	// add your business method end

	// 子表处理DAO
	public QueryListObj listDdMoutageplan();

	public void saveOrUpdateDdMoutageplan(DdMoutageplanDto dto);

	public void deleteDdMoutageplan(String fmonthplanno);

	public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno);

	public QueryListObj listDdMoutageplanByHql(String hql);

	public void saveOrUpdateDdMoutageplan(List dtos);

	public void deleteDdMoutageplan(List dtos);

	public void start(WorkflowHandleDto dto);

	public void approve(WorkflowHandleDto dto);

	public void modify(WorkflowHandleDto dto);

	public void Release(WorkflowHandleDto dto);

	// please add your business methods start
	// to do it
	// add your business method end

}
