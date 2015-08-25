package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhEligiblermrateService;
import com.techstar.dmis.dto.ZdhEligiblermrateDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhEligiblermrateFacade {
	private IZdhEligiblermrateService zdhEligiblermrateService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhEligiblermrate() {
		return zdhEligiblermrateService.listZdhEligiblermrate().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhEligiblermrate(ZdhEligiblermrateDto dto) {
		zdhEligiblermrateService.saveOrUpdateZdhEligiblermrate(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhEligiblermrateId
	 *           ֵ

	 */
	public ZdhEligiblermrateDto getZdhEligiblermrateById(String  zdhEligiblermrateId) {
		ZdhEligiblermrateDto dto = zdhEligiblermrateService.loadZdhEligiblermrate(zdhEligiblermrateId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhEligiblermrateId
	 *         ֵ

	 */
	public List deleteZdhEligiblermrate(String zdhEligiblermrateId) {
		zdhEligiblermrateService.deleteZdhEligiblermrate(zdhEligiblermrateId);
		return zdhEligiblermrateService.listZdhEligiblermrate().getElemList();
	}
	
	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhEligiblermrateId
	 *         ֵ

	 */
	public void deleteZdhEligiblermrate(String zdhEligiblermrateId,int version) {
		zdhEligiblermrateService.deleteZdhEligiblermrate(zdhEligiblermrateId,version);
		//return zdhEligiblermrateService.listZdhEligiblermrate().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhEligiblermrate4dwr() {
		return zdhEligiblermrateService.listZdhEligiblermrate().getElemList();
	}

	public void setZdhEligiblermrateService(IZdhEligiblermrateService zdhEligiblermrateService) {
		this.zdhEligiblermrateService = zdhEligiblermrateService;		
	}
	
	public QueryListObj getZdhEligiblermrateByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhEligiblermrateService.getZdhEligiblermrateByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhEligiblermrateDto loadZdhEligiblermrate(String zdhEligiblermrateId){
		return this.zdhEligiblermrateService.loadZdhEligiblermrate(zdhEligiblermrateId);
	}
	

	/*
	 * 交接班使用
	 */
	public QueryListObj getZdhEligiblermrateByHql(String hql){
		return this.zdhEligiblermrateService.getZdhEligiblermrateByHql(hql);
	}	

 /**
    * @business method list
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
