package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdCutofftitleService;
import com.techstar.dmis.dto.DdCutofftitleDto;

import com.techstar.dmis.dto.DdCutoffsequenceDto;
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
public class DdCutofftitleFacade {
	private IDdCutofftitleService ddCutofftitleService;

	// private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdCutofftitle() {
		return ddCutofftitleService.listDdCutofftitle().getElemList();
	}

	public QueryListObj listDdCutofftitleByHql(String hqlSql) {
		return ddCutofftitleService.listDdCutofftitleByHql(hqlSql);
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdCutofftitle(DdCutofftitleDto dto) {
		ddCutofftitleService.saveOrUpdateDdCutofftitle(dto);
	}

	public void addDdCutofftitleByList(List list) {
		ddCutofftitleService.saveOrUpdateDdCutoffsequence(list);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdCutofftitleId ֵ
	 * 
	 */
	public DdCutofftitleDto getDdCutofftitleById(String ddCutofftitleId) {
		DdCutofftitleDto dto = ddCutofftitleService
				.loadDdCutofftitle(ddCutofftitleId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdCutofftitleId ֵ
	 * 
	 */
	public List deleteDdCutofftitle(String ddCutofftitleId) {
		ddCutofftitleService.deleteDdCutofftitle(ddCutofftitleId);
		return ddCutofftitleService.listDdCutofftitle().getElemList();
	}

	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdCutofftitle(List dtos) {
		ddCutofftitleService.deleteDdCutofftitle(dtos);
		return ddCutofftitleService.listDdCutofftitle().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * 
	 * @return List
	 */
	public List listDdCutofftitle4dwr() {
		return ddCutofftitleService.listDdCutofftitle().getElemList();
	}

	public void setDdCutofftitleService(
			IDdCutofftitleService ddCutofftitleService) {
		this.ddCutofftitleService = ddCutofftitleService;
	}

	public QueryListObj getDdCutofftitleByHql(String hql, int beginPage,
			int pageSize, String sql) {
		return this.ddCutofftitleService.getDdCutofftitleByHql(hql, beginPage,
				pageSize, sql);
	}

	public DdCutofftitleDto loadDdCutofftitle(String ddCutofftitleId) {
		return this.ddCutofftitleService.loadDdCutofftitle(ddCutofftitleId);
	}

	/**
	 * @business method list
	 * @excel 导入
	 * @序位表发布
	 */

	// 注册子表facade方法
	public DdCutoffsequenceDto loadDdCutoffsequence(String fid) {
		return this.ddCutofftitleService.loadDdCutoffsequence(fid);
	}

	public List deleteDdCutoffsequence(String fid) {
		ddCutofftitleService.deleteDdCutoffsequence(fid);
		return ddCutofftitleService.listDdCutoffsequence().getElemList();
	}

	public List deleteDdCutoffsequence(List dtos) {
		ddCutofftitleService.deleteDdCutoffsequence(dtos);
		return ddCutofftitleService.listDdCutoffsequence().getElemList();
	}

	public void addDdCutoffsequence(DdCutoffsequenceDto dto) {
		ddCutofftitleService.saveOrUpdateDdCutoffsequence(dto);
	}

	public void start(WorkflowHandleDto dto) {
		ddCutofftitleService.start(dto);
	}

	// 调度处长审批拉路序位表
	public void headerApprove(WorkflowHandleDto dto) {
		ddCutofftitleService.headerApprove(dto);
	}

	// 拉路序位表发布
	public void release(WorkflowHandleDto dto) {
		ddCutofftitleService.release(dto);
	}

	// 拉路序位表修改
	public void modify(WorkflowHandleDto dto) {
		ddCutofftitleService.modify(dto);
	}

	// 负荷专工审核
	public void specApprove(WorkflowHandleDto dto) {
		ddCutofftitleService.specApprove(dto);

	}

	// please add your business methods start
	// to do it
	// add your business method end

}
