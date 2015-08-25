package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdMoutageplanService;
import com.techstar.dmis.dto.DdMoutageplanDto;

import com.techstar.dmis.dto.DdRepairdetailDto;
import com.techstar.dmis.dto.DdPremethodDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * facade类
 *
 *
 * @author
 * @date
 */
public class DdMoutageplanFacade {
	private IDdMoutageplanService ddMoutageplanService;

	// private IApplyService applyService;

	/**
	 * 得到列表数据
	 *
	 * @return List
	 */
	public List listDdMoutageplan() {
		return ddMoutageplanService.listDdMoutageplan().getElemList();
	}

	/**
	 * 增加DTO
	 *
	 * @param dto
	 */
	public void addDdMoutageplan(DdMoutageplanDto dto) {
		ddMoutageplanService.saveOrUpdateDdMoutageplan(dto);
	}

	public void addDdMoutageplanByList(List list) {
		ddMoutageplanService.saveOrUpdateDdMoutageplan(list);
	}

	/**
	 * 得到指定DTO
	 *
	 * @param DdMoutageplanId ֵ
	 *
	 */
	public DdMoutageplanDto getDdMoutageplanById(String ddMoutageplanId) {
		DdMoutageplanDto dto = ddMoutageplanService
				.loadDdMoutageplan(ddMoutageplanId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 *
	 * @param DdMoutageplanId ֵ
	 *
	 */
	public List deleteDdMoutageplan(String ddMoutageplanId, String version) {
		ddMoutageplanService.deleteDdMoutageplan(ddMoutageplanId, version);
		return ddMoutageplanService.listDdMoutageplan().getElemList();
	}

	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdMoutageplan(List dtos) {
		ddMoutageplanService.deleteDdMoutageplan(dtos);
		return ddMoutageplanService.listDdMoutageplan().getElemList();
	}

	/**
	 * 得到业务对象列表
	 *
	 * @return List
	 */
	public List listDdMoutageplan4dwr() {
		return ddMoutageplanService.listDdMoutageplan().getElemList();
	}

	public void setDdMoutageplanService(
			IDdMoutageplanService ddMoutageplanService) {
		this.ddMoutageplanService = ddMoutageplanService;
	}

	public QueryListObj getDdMoutageplanByHql(String hql, int beginPage,
			int pageSize, String sql) {
		return this.ddMoutageplanService.getDdMoutageplanByHql(hql, beginPage,
				pageSize, sql);
	}

	public DdMoutageplanDto loadDdMoutageplan(String ddMoutageplanId) {
		return this.ddMoutageplanService.loadDdMoutageplan(ddMoutageplanId);
	}

	/**
	 * @business method list
	 * @月计划归档
	 *
	 * @生成日计划
	 *
	 * @未批准计划/未完成计划导入
	 *
	 * @预案查询
	 * @设备参数维护
	 * @电网周风险维护
	 *
	 * @月计划合并
	 *
	 * @从间隔获得停电范围及设备列表
	 */

	// 注册子表facade方法
	public DdRepairdetailDto loadDdRepairdetail(String fid) {
		return this.ddMoutageplanService.loadDdRepairdetail(fid);
	}

	public List deleteDdRepairdetail(String fid) {
		ddMoutageplanService.deleteDdRepairdetail(fid);
		return ddMoutageplanService.listDdRepairdetail().getElemList();
	}

	public List deleteDdRepairdetail(List dtos) {
		ddMoutageplanService.deleteDdRepairdetail(dtos);
		return ddMoutageplanService.listDdRepairdetail().getElemList();
	}

	public void addDdRepairdetail(DdRepairdetailDto dto) {
		ddMoutageplanService.saveOrUpdateDdRepairdetail(dto);
	}

	public DdPremethodDto loadDdPremethod(String fpremethodid) {
		return this.ddMoutageplanService.loadDdPremethod(fpremethodid);
	}

	public List deleteDdPremethod(String fpremethodid) {
		ddMoutageplanService.deleteDdPremethod(fpremethodid);
		return ddMoutageplanService.listDdPremethod().getElemList();
	}

	public List deleteDdPremethod(List dtos) {
		ddMoutageplanService.deleteDdPremethod(dtos);
		return ddMoutageplanService.listDdPremethod().getElemList();
	}

	public void addDdPremethod(DdPremethodDto dto) {
		ddMoutageplanService.saveOrUpdateDdPremethod(dto);
	}

	public QueryListObj listDdMoutageplanByHql(String hql) {

		return ddMoutageplanService.listDdMoutageplanByHql(hql);
	}

	public void start(WorkflowHandleDto dto) {
		ddMoutageplanService.start(dto);
	}

	public void ddMonthPlanCleanUp(WorkflowHandleDto dto) {
		ddMoutageplanService.ddMonthPlanCleanUp(dto);
	}

	public void ddMonthPlanSentResult(WorkflowHandleDto dto) {
		ddMoutageplanService.ddMonthPlanSentResult(dto);
	}

	public void ddMonthPlanApproveAndSend(WorkflowHandleDto dto) {
		ddMoutageplanService.ddMonthPlanApproveAndSend(dto);
	}

	public void ddMonthPlanModify(WorkflowHandleDto dto) {
		ddMoutageplanService.ddMonthPlanModify(dto);
	}

	public void ddMonthPlanCleanUpResult(WorkflowHandleDto dto) {
		ddMoutageplanService.ddMonthPlanCleanUpResult(dto);
	}

}
