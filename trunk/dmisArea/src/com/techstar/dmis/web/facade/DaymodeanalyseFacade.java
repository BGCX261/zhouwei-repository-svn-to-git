package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDaymodeanalyseService;
import com.techstar.dmis.dto.DaymodeanalyseDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DaymodeanalyseFacade {
	private IDaymodeanalyseService daymodeanalyseService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDaymodeanalyse() {
		return daymodeanalyseService.listDaymodeanalyse().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDaymodeanalyse(DaymodeanalyseDto dto) {
		daymodeanalyseService.saveOrUpdateDaymodeanalyse(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DaymodeanalyseId
	 *           ֵ

	 */
	public DaymodeanalyseDto getDaymodeanalyseById(String  daymodeanalyseId) {
		DaymodeanalyseDto dto = daymodeanalyseService.loadDaymodeanalyse(daymodeanalyseId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DaymodeanalyseId
	 *         ֵ

	 */
	public List deleteDaymodeanalyse(String daymodeanalyseId) {
		daymodeanalyseService.deleteDaymodeanalyse(daymodeanalyseId);
		return daymodeanalyseService.listDaymodeanalyse().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDaymodeanalyse(List dtos) {
		daymodeanalyseService.deleteDaymodeanalyse(dtos);
		return daymodeanalyseService.listDaymodeanalyse().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDaymodeanalyse4dwr() {
		return daymodeanalyseService.listDaymodeanalyse().getElemList();
	}

	public void setDaymodeanalyseService(IDaymodeanalyseService daymodeanalyseService) {
		this.daymodeanalyseService = daymodeanalyseService;		
	}
	
	public QueryListObj getDaymodeanalyseByHql(String hql, int beginPage, int pageSize, String sql){
		return this.daymodeanalyseService.getDaymodeanalyseByHql(hql, beginPage, pageSize, sql);
	}
	public DaymodeanalyseDto loadDaymodeanalyse(String daymodeanalyseId){
		return this.daymodeanalyseService.loadDaymodeanalyse(daymodeanalyseId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
