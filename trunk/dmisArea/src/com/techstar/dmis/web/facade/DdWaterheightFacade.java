package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdWaterheightService;
import com.techstar.dmis.dto.DdWaterheightDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdWaterheightFacade {
	private IDdWaterheightService ddWaterheightService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdWaterheight() {
		return ddWaterheightService.listDdWaterheight().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdWaterheight(DdWaterheightDto dto) {
		ddWaterheightService.saveOrUpdateDdWaterheight(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdWaterheightId
	 *           ֵ

	 */
	public DdWaterheightDto getDdWaterheightById(String  ddWaterheightId) {
		DdWaterheightDto dto = ddWaterheightService.loadDdWaterheight(ddWaterheightId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdWaterheightId
	 *         ֵ

	 */
	public List deleteDdWaterheight(String ddWaterheightId) {
		ddWaterheightService.deleteDdWaterheight(ddWaterheightId);
		return ddWaterheightService.listDdWaterheight().getElemList();
	}
	/**
	 * 删除指定DTO
	 * 
	 * @param DdWaterheightId
	 *         ֵ

	 */
	public List deleteDdWaterheight(String ddWaterheightId,int version) {
		ddWaterheightService.deleteDdWaterheight(ddWaterheightId,version);
		return ddWaterheightService.listDdWaterheight().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdWaterheight4dwr() {
		return ddWaterheightService.listDdWaterheight().getElemList();
	}

	public void setDdWaterheightService(IDdWaterheightService ddWaterheightService) {
		this.ddWaterheightService = ddWaterheightService;		
	}
	
	public QueryListObj getDdWaterheightByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddWaterheightService.getDdWaterheightByHql(hql, beginPage, pageSize, sql);
	}
	public DdWaterheightDto loadDdWaterheight(String ddWaterheightId){
		return this.ddWaterheightService.loadDdWaterheight(ddWaterheightId);
	}
	

		

 /**
    * @business method list
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
