package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IStdElectricstampService;
import com.techstar.dmis.dto.StdElectricstampDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class StdElectricstampFacade {
	private IStdElectricstampService stdElectricstampService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listStdElectricstamp() {
		return stdElectricstampService.listStdElectricstamp().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addStdElectricstamp(StdElectricstampDto dto) {
		stdElectricstampService.saveOrUpdateStdElectricstamp(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param StdElectricstampId
	 *           ֵ

	 */
	public StdElectricstampDto getStdElectricstampById(String  stdElectricstampId) {
		StdElectricstampDto dto = stdElectricstampService.loadStdElectricstamp(stdElectricstampId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param StdElectricstampId
	 *         ֵ

	 */
	public List deleteStdElectricstamp(String stdElectricstampId) {
		stdElectricstampService.deleteStdElectricstamp(stdElectricstampId);
		return stdElectricstampService.listStdElectricstamp().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteStdElectricstamp(List dtos) {
		stdElectricstampService.deleteStdElectricstamp(dtos);
		return stdElectricstampService.listStdElectricstamp().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listStdElectricstamp4dwr() {
		return stdElectricstampService.listStdElectricstamp().getElemList();
	}

	public void setStdElectricstampService(IStdElectricstampService stdElectricstampService) {
		this.stdElectricstampService = stdElectricstampService;		
	}
	
	public QueryListObj getStdElectricstampByHql(String hql, int beginPage, int pageSize, String sql){
		return this.stdElectricstampService.getStdElectricstampByHql(hql, beginPage, pageSize, sql);
	}
	public StdElectricstampDto loadStdElectricstamp(String stdElectricstampId){
		return this.stdElectricstampService.loadStdElectricstamp(stdElectricstampId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
