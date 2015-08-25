package com.techstar.dmis.web.facade;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdRepairrisklistService;
import com.techstar.dmis.dto.DdRepairrisklistDto;

import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * facade类
 * 
 * @author
 * @date
 */
public class DdRepairrisklistFacade {
	private IDdRepairrisklistService ddRepairrisklistService;

	// private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdRepairrisklist() {
		return ddRepairrisklistService.listDdRepairrisklist().getElemList();
	}

	public void addDdRepairrisklistByMplans(String[] strs,
			String sys_dataowner, String sys_filldept, String sys_fille,
			Timestamp sys_filltime) {

		ddRepairrisklistService.addDdRepairrisklistByMplans(strs,
				sys_dataowner, sys_filldept, sys_fille, sys_filltime);

	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdRepairrisklist(DdRepairrisklistDto dto) {
		ddRepairrisklistService.saveOrUpdateDdRepairrisklist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdRepairrisklistId ֵ
	 * 
	 */
	public DdRepairrisklistDto getDdRepairrisklistById(String ddRepairrisklistId) {
		DdRepairrisklistDto dto = ddRepairrisklistService
				.loadDdRepairrisklist(ddRepairrisklistId);
		dto.getZddrepairrisklist4();
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdRepairrisklistId ֵ
	 * 
	 */
	public List deleteDdRepairrisklist(String ddRepairrisklistId) {
		ddRepairrisklistService.deleteDdRepairrisklist(ddRepairrisklistId);
		return ddRepairrisklistService.listDdRepairrisklist().getElemList();
	}

	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdRepairrisklist(List dtos) {
		ddRepairrisklistService.deleteDdRepairrisklist(dtos);
		return ddRepairrisklistService.listDdRepairrisklist().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * 
	 * @return List
	 */
	public List listDdRepairrisklist4dwr() {
		return ddRepairrisklistService.listDdRepairrisklist().getElemList();
	}

	public void setDdRepairrisklistService(
			IDdRepairrisklistService ddRepairrisklistService) {
		this.ddRepairrisklistService = ddRepairrisklistService;
	}

	public QueryListObj getDdRepairrisklistByHql(String hql, int beginPage,
			int pageSize, String sql) {
		return this.ddRepairrisklistService.getDdRepairrisklistByHql(hql,
				beginPage, pageSize, sql);
	}
	public QueryListObj listDdMoutageplanByHql(String hql) {
		return this.ddRepairrisklistService.listDdMoutageplanByHql(hql);
	}
	
	public QueryListObj listDdRepairrisklistByHql(String hql) {
		return this.ddRepairrisklistService.listDdRepairrisklistByHql(hql);
	}
	
	

	public DdRepairrisklistDto loadDdRepairrisklist(String ddRepairrisklistId) {
		return this.ddRepairrisklistService
				.loadDdRepairrisklist(ddRepairrisklistId);
	}

	/**
	 * @business method list
	 * @周风险发布
	 * @风险预案导入
	 * @选择月计划
	 */

	// 注册子表facade方法
	public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno) {
		return this.ddRepairrisklistService.loadDdMoutageplan(fmonthplanno);
	}

	public List deleteDdMoutageplan(String fmonthplanno) {
		ddRepairrisklistService.deleteDdMoutageplan(fmonthplanno);
		return ddRepairrisklistService.listDdMoutageplan().getElemList();
	}

	public List deleteDdMoutageplan(List dtos) {
		ddRepairrisklistService.deleteDdMoutageplan(dtos);
		return ddRepairrisklistService.listDdMoutageplan().getElemList();
	}

	public void addDdMoutageplan(DdMoutageplanDto dto) {
		ddRepairrisklistService.saveOrUpdateDdMoutageplan(dto);
	}
	
	public void start(WorkflowHandleDto dto) {
		ddRepairrisklistService.start(dto);
	}
	public void approve(WorkflowHandleDto dto) {
		ddRepairrisklistService.approve(dto);
	}
	
	public void modify(WorkflowHandleDto dto) {
		ddRepairrisklistService.modify(dto);
	}
	
	public void Release(WorkflowHandleDto dto) {
		ddRepairrisklistService.Release(dto);
	}
	

	// please add your business methods start
	// to do it
	// add your business method end

}
