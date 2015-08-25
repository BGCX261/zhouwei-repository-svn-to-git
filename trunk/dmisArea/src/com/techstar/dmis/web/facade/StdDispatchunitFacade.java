package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IStdDispatchunitService;
import com.techstar.dmis.dto.StdDispatchunitDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class StdDispatchunitFacade {
	private IStdDispatchunitService stdDispatchunitService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listStdDispatchunit() {
		return stdDispatchunitService.listStdDispatchunit().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addStdDispatchunit(StdDispatchunitDto dto) {
		stdDispatchunitService.saveOrUpdateStdDispatchunit(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param StdDispatchunitId
	 *           ֵ

	 */
	public StdDispatchunitDto getStdDispatchunitById(String  stdDispatchunitId) {
		StdDispatchunitDto dto = stdDispatchunitService.loadStdDispatchunit(stdDispatchunitId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param StdDispatchunitId
	 *         ֵ

	 */
	public List deleteStdDispatchunit(String stdDispatchunitId) {
		stdDispatchunitService.deleteStdDispatchunit(stdDispatchunitId);
		return stdDispatchunitService.listStdDispatchunit().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteStdDispatchunit(List dtos) {
		stdDispatchunitService.deleteStdDispatchunit(dtos);
		return stdDispatchunitService.listStdDispatchunit().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listStdDispatchunit4dwr() {
		return stdDispatchunitService.listStdDispatchunit().getElemList();
	}

	public void setStdDispatchunitService(IStdDispatchunitService stdDispatchunitService) {
		this.stdDispatchunitService = stdDispatchunitService;		
	}
	
	public QueryListObj getStdDispatchunitByHql(String hql, int beginPage, int pageSize, String sql){
		return this.stdDispatchunitService.getStdDispatchunitByHql(hql, beginPage, pageSize, sql);
	}
	public StdDispatchunitDto loadStdDispatchunit(String stdDispatchunitId){
		return this.stdDispatchunitService.loadStdDispatchunit(stdDispatchunitId);
	}
	
	public String getDataOwner(String dataownerName){
		return this.stdDispatchunitService.getDataOwner(dataownerName);
	}
		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
