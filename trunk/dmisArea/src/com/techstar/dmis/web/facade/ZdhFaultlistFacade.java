package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhFaultlistService;
import com.techstar.dmis.dto.ZdhFaultlistDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhFaultlistFacade {
	private IZdhFaultlistService zdhFaultlistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhFaultlist() {
		return zdhFaultlistService.listZdhFaultlist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhFaultlist(ZdhFaultlistDto dto) {
		zdhFaultlistService.saveOrUpdateZdhFaultlist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhFaultlistId
	 *           ֵ

	 */
	public ZdhFaultlistDto getZdhFaultlistById(String  zdhFaultlistId) {
		ZdhFaultlistDto dto = zdhFaultlistService.loadZdhFaultlist(zdhFaultlistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhFaultlistId
	 *         ֵ

	 */
	public List deleteZdhFaultlist(String zdhFaultlistId) {
		zdhFaultlistService.deleteZdhFaultlist(zdhFaultlistId);
		return zdhFaultlistService.listZdhFaultlist().getElemList();
	}
	
	/**
	 * 
	 * @param zdhFaultlistId
	 * @param version
	 * @return
	 */
	public List deleteZdhFaultlistObj(String zdhFaultlistId, int version){
		zdhFaultlistService.deleteZdhFaultlistObj(zdhFaultlistId, version);
		return zdhFaultlistService.listZdhFaultlist().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhFaultlist4dwr() {
		return zdhFaultlistService.listZdhFaultlist().getElemList();
	}

	public void setZdhFaultlistService(IZdhFaultlistService zdhFaultlistService) {
		this.zdhFaultlistService = zdhFaultlistService;		
	}
	
	public QueryListObj getZdhFaultlistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhFaultlistService.getZdhFaultlistByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhFaultlistDto loadZdhFaultlist(String zdhFaultlistId){
		return this.zdhFaultlistService.loadZdhFaultlist(zdhFaultlistId);
	}
	

		

 /**
    * @business method list
	 	* @缺陷设备信息
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
