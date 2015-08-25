package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IBhFaultlistService;
import com.techstar.dmis.dto.BhFaultlistDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class BhFaultlistFacade {
	private IBhFaultlistService bhFaultlistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listBhFaultlist() {
		return bhFaultlistService.listBhFaultlist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addBhFaultlist(BhFaultlistDto dto) {
		bhFaultlistService.saveOrUpdateBhFaultlist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param BhFaultlistId
	 *           ֵ

	 */
	public BhFaultlistDto getBhFaultlistById(String  bhFaultlistId) {
		BhFaultlistDto dto = bhFaultlistService.loadBhFaultlist(bhFaultlistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param BhFaultlistId
	 *         ֵ

	 */
	public List deleteBhFaultlist(String bhFaultlistId) {
		bhFaultlistService.deleteBhFaultlist(bhFaultlistId);
		return bhFaultlistService.listBhFaultlist().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteBhFaultlist(List dtos) {
		bhFaultlistService.deleteBhFaultlist(dtos);
		return bhFaultlistService.listBhFaultlist().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listBhFaultlist4dwr() {
		return bhFaultlistService.listBhFaultlist().getElemList();
	}

	public void setBhFaultlistService(IBhFaultlistService bhFaultlistService) {
		this.bhFaultlistService = bhFaultlistService;		
	}
	
	public QueryListObj getBhFaultlistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.bhFaultlistService.getBhFaultlistByHql(hql, beginPage, pageSize, sql);
	}
	public BhFaultlistDto loadBhFaultlist(String bhFaultlistId){
		return this.bhFaultlistService.loadBhFaultlist(bhFaultlistId);
	}
	

		

 /**
    * @business method list
	 	* @从设备台帐取值
	 	* @选择故障
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
