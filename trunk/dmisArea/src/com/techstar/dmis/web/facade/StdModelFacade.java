package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IStdModelService;
import com.techstar.dmis.dto.StdModelDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class StdModelFacade {
	private IStdModelService stdModelService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listStdModel() {
		return stdModelService.listStdModel().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addStdModel(StdModelDto dto) {
		stdModelService.saveOrUpdateStdModel(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param StdModelId
	 *           ֵ

	 */
	public StdModelDto getStdModelById(String  stdModelId) {
		StdModelDto dto = stdModelService.loadStdModel(stdModelId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param StdModelId
	 *         ֵ

	 */
	public List deleteStdModel(String stdModelId) {
		stdModelService.deleteStdModel(stdModelId);
		return stdModelService.listStdModel().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteStdModel(List dtos) {
		stdModelService.deleteStdModel(dtos);
		return stdModelService.listStdModel().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listStdModel4dwr() {
		return stdModelService.listStdModel().getElemList();
	}

	public void setStdModelService(IStdModelService stdModelService) {
		this.stdModelService = stdModelService;		
	}
	
	public QueryListObj getStdModelByHql(String hql, int beginPage, int pageSize, String sql){
		return this.stdModelService.getStdModelByHql(hql, beginPage, pageSize, sql);
	}
	public StdModelDto loadStdModel(String stdModelId){
		return this.stdModelService.loadStdModel(stdModelId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
