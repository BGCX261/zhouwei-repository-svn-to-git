package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdCutoffsequenceService;
import com.techstar.dmis.dto.DdCutoffsequenceDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author
 * @date
 */
public class DdCutoffsequenceFacade {
	private IDdCutoffsequenceService ddCutoffsequenceService;
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 *
	 * @return List
	 */
	public List listDdCutoffsequence() {
		return ddCutoffsequenceService.listDdCutoffsequence().getElemList();
	}
	
	public QueryListObj listCutoffsequenceByHql(String hql) {
		return ddCutoffsequenceService.listDdCutoffsequenceByHql(hql);
	}

	/**
	 * 增加DTO
	 *
	 * @param dto
	 */
	public void addDdCutoffsequence(DdCutoffsequenceDto dto) {
		ddCutoffsequenceService.saveOrUpdateDdCutoffsequence(dto);
	}

	/**
	 * 得到指定DTO
	 *
	 * @param DdCutoffsequenceId
	 *           ֵ

	 */
	public DdCutoffsequenceDto getDdCutoffsequenceById(String  ddCutoffsequenceId) {
		DdCutoffsequenceDto dto = ddCutoffsequenceService.loadDdCutoffsequence(ddCutoffsequenceId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 *
	 * @param DdCutoffsequenceId
	 *         ֵ

	 */
	public List deleteDdCutoffsequence(String ddCutoffsequenceId,String version) {
		ddCutoffsequenceService.deleteDdCutoffsequence(ddCutoffsequenceId,version);
		return ddCutoffsequenceService.listDdCutoffsequence().getElemList();
	}
	
	public List deleteCutoffsequenceList(List list) {
		ddCutoffsequenceService.deleteCutoffsequenceList(list);
		return ddCutoffsequenceService.listDdCutoffsequence().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdCutoffsequence4dwr() {
		return ddCutoffsequenceService.listDdCutoffsequence().getElemList();
	}

	public void setDdCutoffsequenceService(IDdCutoffsequenceService ddCutoffsequenceService) {
		this.ddCutoffsequenceService = ddCutoffsequenceService;
	}

	public QueryListObj getDdCutoffsequenceByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddCutoffsequenceService.getDdCutoffsequenceByHql(hql, beginPage, pageSize, sql);
	}
	public DdCutoffsequenceDto loadDdCutoffsequence(String ddCutoffsequenceId){
		return this.ddCutoffsequenceService.loadDdCutoffsequence(ddCutoffsequenceId);
	}




 /**
    * @business method list
	  */
//please add your business methods start
	// to do it
//add your business method end

}
