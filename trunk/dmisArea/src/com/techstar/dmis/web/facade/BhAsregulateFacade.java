package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IBhAsregulateService;
import com.techstar.dmis.dto.BhAsregulateDto;

    import com.techstar.dmis.dto.BhAsregulatedetailDto;
	import com.techstar.dmis.dto.StdStationDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class BhAsregulateFacade {
	private IBhAsregulateService bhAsregulateService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listBhAsregulate() {
		return bhAsregulateService.listBhAsregulate().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addBhAsregulate(BhAsregulateDto dto) {
		bhAsregulateService.saveOrUpdateBhAsregulate(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param BhAsregulateId
	 *           ֵ

	 */
	public BhAsregulateDto getBhAsregulateById(String  bhAsregulateId) {
		BhAsregulateDto dto = bhAsregulateService.loadBhAsregulate(bhAsregulateId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param BhAsregulateId
	 *         ֵ

	 */
	public List deleteBhAsregulate(String bhAsregulateId) {
		bhAsregulateService.deleteBhAsregulate(bhAsregulateId);
		return bhAsregulateService.listBhAsregulate().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteBhAsregulate(List dtos) {
		bhAsregulateService.deleteBhAsregulate(dtos);
		return bhAsregulateService.listBhAsregulate().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listBhAsregulate4dwr() {
		return bhAsregulateService.listBhAsregulate().getElemList();
	}

	public void setBhAsregulateService(IBhAsregulateService bhAsregulateService) {
		this.bhAsregulateService = bhAsregulateService;		
	}
	
	public QueryListObj getBhAsregulateByHql(String hql, int beginPage, int pageSize, String sql){
		return this.bhAsregulateService.getBhAsregulateByHql(hql, beginPage, pageSize, sql);
	}
	public BhAsregulateDto loadBhAsregulate(String bhAsregulateId){
		return this.bhAsregulateService.loadBhAsregulate(bhAsregulateId);
	}
	

		

 /**
    * @business method list
	 	* @自投规程归档
	  */	
 
 
 
 	//注册子表facade方法
    	public BhAsregulatedetailDto loadBhAsregulatedetail(String asregulatedetailid){
		return this.bhAsregulateService.loadBhAsregulatedetail(asregulatedetailid);
	}
	
	public List deleteBhAsregulatedetail(String asregulatedetailid) {
		bhAsregulateService.deleteBhAsregulatedetail(asregulatedetailid);
		return bhAsregulateService.listBhAsregulatedetail().getElemList();
	}
	public List deleteBhAsregulatedetail(List dtos) {
		bhAsregulateService.deleteBhAsregulatedetail(dtos);
		return bhAsregulateService.listBhAsregulatedetail().getElemList();
	}
	public void addBhAsregulatedetail(BhAsregulatedetailDto dto) {
		bhAsregulateService.saveOrUpdateBhAsregulatedetail(dto);
	}

		public StdStationDto loadStdStation(String id){
		return this.bhAsregulateService.loadStdStation(id);
	}
	
	public List deleteStdStation(String id) {
		bhAsregulateService.deleteStdStation(id);
		return bhAsregulateService.listStdStation().getElemList();
	}
	public List deleteStdStation(List dtos) {
		bhAsregulateService.deleteStdStation(dtos);
		return bhAsregulateService.listStdStation().getElemList();
	}
	public void addStdStation(StdStationDto dto) {
		bhAsregulateService.saveOrUpdateStdStation(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
