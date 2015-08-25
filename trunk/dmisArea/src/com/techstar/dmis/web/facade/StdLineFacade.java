package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IStdLineService;
import com.techstar.dmis.dto.StdLineDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class StdLineFacade {
	private IStdLineService stdLineService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listStdLine() {
		return stdLineService.listStdLine().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addStdLine(StdLineDto dto) {
		stdLineService.saveOrUpdateStdLine(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param StdLineId
	 *           ֵ

	 */
	public StdLineDto getStdLineById(String  stdLineId) {
		StdLineDto dto = stdLineService.loadStdLine(stdLineId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param StdLineId
	 *         ֵ

	 */
	public List deleteStdLine(String stdLineId) {
		stdLineService.deleteStdLine(stdLineId);
		return stdLineService.listStdLine().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteStdLine(List dtos) {
		stdLineService.deleteStdLine(dtos);
		return stdLineService.listStdLine().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listStdLine4dwr() {
		return stdLineService.listStdLine().getElemList();
	}

	public void setStdLineService(IStdLineService stdLineService) {
		this.stdLineService = stdLineService;		
	}
	
	public QueryListObj getStdLineByHql(String hql, int beginPage, int pageSize, String sql){
		return this.stdLineService.getStdLineByHql(hql, beginPage, pageSize, sql);
	}
	public StdLineDto loadStdLine(String stdLineId){
		return this.stdLineService.loadStdLine(stdLineId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
