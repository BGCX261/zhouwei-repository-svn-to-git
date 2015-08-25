package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdAccidentbriefService;
import com.techstar.dmis.dto.DdAccidentbriefDto;

import com.techstar.dmis.dto.BhActionrecordDto;
import com.techstar.dmis.dto.DdAccidentbriefprocessDto;
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
public class DdAccidentbriefFacade {
	private IDdAccidentbriefService ddAccidentbriefService;

	// private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdAccidentbrief() {
		return ddAccidentbriefService.listDdAccidentbrief().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdAccidentbrief(DdAccidentbriefDto dto) {
		ddAccidentbriefService.saveOrUpdateDdAccidentbrief(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdAccidentbriefId ֵ
	 * 
	 */
	public DdAccidentbriefDto getDdAccidentbriefById(String ddAccidentbriefId) {
		DdAccidentbriefDto dto = ddAccidentbriefService
				.loadDdAccidentbrief(ddAccidentbriefId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdAccidentbriefId ֵ
	 * 
	 */
	public List deleteDdAccidentbrief(String ddAccidentbriefId, String version) {
		ddAccidentbriefService
				.deleteDdAccidentbrief(ddAccidentbriefId, version);
		return ddAccidentbriefService.listDdAccidentbrief().getElemList();
	}

	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdAccidentbrief(List dtos) {
		ddAccidentbriefService.deleteDdAccidentbrief(dtos);
		return ddAccidentbriefService.listDdAccidentbrief().getElemList();
	}

	/**
	 * 保存dtos
	 * 
	 * @param dtos
	 */
	public void saveOrUpdateDdAccidentbrief(List dtos) {
		ddAccidentbriefService.saveOrUpdateDdAccidentbrief(dtos);
	}

	/**
	 * 得到业务对象列表
	 * 
	 * @return List
	 */
	public List listDdAccidentbrief4dwr() {
		return ddAccidentbriefService.listDdAccidentbrief().getElemList();
	}

	public void setDdAccidentbriefService(
			IDdAccidentbriefService ddAccidentbriefService) {
		this.ddAccidentbriefService = ddAccidentbriefService;
	}

	public QueryListObj getDdAccidentbriefByHql(String hql, int beginPage,
			int pageSize, String sql) {
		return this.ddAccidentbriefService.getDdAccidentbriefByHql(hql,
				beginPage, pageSize, sql);
	}

	public QueryListObj getDdAccidentbriefProcessByHql(String hql) {
		return this.ddAccidentbriefService.listDdAccidentbriefprocessByHql(hql);
	}

	public DdAccidentbriefDto loadDdAccidentbrief(String ddAccidentbriefId) {
		return this.ddAccidentbriefService
				.loadDdAccidentbrief(ddAccidentbriefId);
	}

	/**
	 * @business method list
	 * @拟定操作票
	 * @工作流－调度值长审核故障简报
	 * @盖处理完章
	 * @合格性检查
	 * @故障转计划
	 * @工作流－执行
	 * @工作流－修改
	 * @工作流－归档
	 */

	// 注册子表facade方法
	public BhActionrecordDto loadBhActionrecord(String protectionrecordid) {
		return this.ddAccidentbriefService
				.loadBhActionrecord(protectionrecordid);
	}

	public List deleteBhActionrecord(String protectionrecordid) {
		ddAccidentbriefService.deleteBhActionrecord(protectionrecordid);
		return ddAccidentbriefService.listBhActionrecord().getElemList();
	}

	public List deleteBhActionrecord(List dtos) {
		ddAccidentbriefService.deleteBhActionrecord(dtos);
		return ddAccidentbriefService.listBhActionrecord().getElemList();
	}

	public void addBhActionrecord(BhActionrecordDto dto) {
		ddAccidentbriefService.saveOrUpdateBhActionrecord(dto);
	}

	public DdAccidentbriefprocessDto loadDdAccidentbriefprocess(String fstepid) {
		return this.ddAccidentbriefService.loadDdAccidentbriefprocess(fstepid);
	}

	public List deleteDdAccidentbriefprocess(String fstepid) {
		ddAccidentbriefService.deleteDdAccidentbriefprocess(fstepid);
		return ddAccidentbriefService.listDdAccidentbriefprocess()
				.getElemList();
	}

	public List deleteDdAccidentbriefprocess(List dtos) {
		ddAccidentbriefService.deleteDdAccidentbriefprocess(dtos);
		return ddAccidentbriefService.listDdAccidentbriefprocess()
				.getElemList();
	}

	public void addDdAccidentbriefprocess(DdAccidentbriefprocessDto dto) {
		ddAccidentbriefService.saveOrUpdateDdAccidentbriefprocess(dto);
	}

	public void addDdAccidentbriefprocessByList(List list) {
		ddAccidentbriefService.saveOrUpdateDdAccidentbriefprocess(list);
	}

	public void start(WorkflowHandleDto dto) {
		ddAccidentbriefService.start(dto);
	}
	public void approve(WorkflowHandleDto dto) {
		ddAccidentbriefService.approve(dto);
	}
	
	public void modify(WorkflowHandleDto dto) {
		ddAccidentbriefService.modify(dto);
	}
	
	public void execute(WorkflowHandleDto dto) {
		ddAccidentbriefService.execute(dto);
	}
	
	// please add your business methods start
	// to do it
	// add your business method end

}
