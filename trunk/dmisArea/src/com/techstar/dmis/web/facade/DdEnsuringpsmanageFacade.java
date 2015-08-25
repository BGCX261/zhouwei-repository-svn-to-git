package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdEnsuringpsmanageService;
import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
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
public class DdEnsuringpsmanageFacade {
	private IDdEnsuringpsmanageService ddEnsuringpsmanageService;

	// private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdEnsuringpsmanage() {
		return ddEnsuringpsmanageService.listDdEnsuringpsmanage().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdEnsuringpsmanage(DdEnsuringpsmanageDto dto) {
		ddEnsuringpsmanageService.saveOrUpdateDdEnsuringpsmanage(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdEnsuringpsmanageId ֵ
	 * 
	 */
	public DdEnsuringpsmanageDto getDdEnsuringpsmanageById(
			String ddEnsuringpsmanageId) {
		DdEnsuringpsmanageDto dto = ddEnsuringpsmanageService
				.loadDdEnsuringpsmanage(ddEnsuringpsmanageId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdEnsuringpsmanageId ֵ
	 * 
	 */
	public List deleteDdEnsuringpsmanage(String ddEnsuringpsmanageId,
			int version) {
		ddEnsuringpsmanageService.deleteDdEnsuringpsmanage(
				ddEnsuringpsmanageId, version);
		return ddEnsuringpsmanageService.listDdEnsuringpsmanage().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * 
	 * @return List
	 */
	public List listDdEnsuringpsmanage4dwr() {
		return ddEnsuringpsmanageService.listDdEnsuringpsmanage().getElemList();
	}

	public void setDdEnsuringpsmanageService(
			IDdEnsuringpsmanageService ddEnsuringpsmanageService) {
		this.ddEnsuringpsmanageService = ddEnsuringpsmanageService;
	}

	public QueryListObj getDdEnsuringpsmanageByHql(String hql, int beginPage,
			int pageSize, String sql) {
		return this.ddEnsuringpsmanageService.getDdEnsuringpsmanageByHql(hql,
				beginPage, pageSize, sql);
	}

	public DdEnsuringpsmanageDto loadDdEnsuringpsmanage(
			String ddEnsuringpsmanageId) {
		return this.ddEnsuringpsmanageService
				.loadDdEnsuringpsmanage(ddEnsuringpsmanageId);
	}

	/*********************************工作流************************************/
	public void start(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.start( dto);
	}

	public void appReback(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.approve(dto);
	}

	public void approve(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.approve(dto);
	}

	public void countersign(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.countersign(dto);
	}

	public void execute(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.execute(dto);
	}

	public void keepon(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.keepon(dto);
	}

	public void modify(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.modify(dto);
	}

	public void sent(WorkflowHandleDto dto) {
		ddEnsuringpsmanageService.sent(dto);
	}


	/*********************************工作流服务结束***************************************/	
	/**
	 * @business method list
	 * @盖执行章
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
