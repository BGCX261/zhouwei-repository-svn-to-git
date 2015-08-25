package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IEtsEquipmentService;
import com.techstar.dmis.dto.EtsEquipmentDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class EtsEquipmentFacade {
	private IEtsEquipmentService etsEquipmentService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listEtsEquipment() {
		return etsEquipmentService.listEtsEquipment().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addEtsEquipment(EtsEquipmentDto dto) {
		etsEquipmentService.saveOrUpdateEtsEquipment(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param EtsEquipmentId
	 *           ֵ

	 */
	public EtsEquipmentDto getEtsEquipmentById(String  etsEquipmentId) {
		EtsEquipmentDto dto = etsEquipmentService.loadEtsEquipment(etsEquipmentId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param EtsEquipmentId
	 *         ֵ

	 */
	public List deleteEtsEquipment(String etsEquipmentId) {
		etsEquipmentService.deleteEtsEquipment(etsEquipmentId);
		return etsEquipmentService.listEtsEquipment().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listEtsEquipment4dwr() {
		return etsEquipmentService.listEtsEquipment().getElemList();
	}

	public void setEtsEquipmentService(IEtsEquipmentService etsEquipmentService) {
		this.etsEquipmentService = etsEquipmentService;		
	}
	
	public QueryListObj getEtsEquipmentByHql(String hql, int beginPage, int pageSize, String sql){
		return this.etsEquipmentService.getEtsEquipmentByHql(hql, beginPage, pageSize, sql);
	}
	public EtsEquipmentDto loadEtsEquipment(String etsEquipmentId){
		return this.etsEquipmentService.loadEtsEquipment(etsEquipmentId);
	}
	

		

 /**
    * @business method list
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
