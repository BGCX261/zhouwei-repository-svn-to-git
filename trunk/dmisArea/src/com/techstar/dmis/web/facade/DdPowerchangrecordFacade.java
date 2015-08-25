package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdPowerchangrecordService;
import com.techstar.dmis.dto.DdPowerchangrecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdPowerchangrecordFacade {
	private IDdPowerchangrecordService ddPowerchangrecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdPowerchangrecord() {
		return ddPowerchangrecordService.listDdPowerchangrecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdPowerchangrecord(DdPowerchangrecordDto dto) {
		ddPowerchangrecordService.saveOrUpdateDdPowerchangrecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdPowerchangrecordId
	 *           ֵ

	 */
	public DdPowerchangrecordDto getDdPowerchangrecordById(String  ddPowerchangrecordId) {
		DdPowerchangrecordDto dto = ddPowerchangrecordService.loadDdPowerchangrecord(ddPowerchangrecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdPowerchangrecordId
	 *         ֵ

	 */
	public List deleteDdPowerchangrecord(String ddPowerchangrecordId) {
		ddPowerchangrecordService.deleteDdPowerchangrecord(ddPowerchangrecordId);
		return ddPowerchangrecordService.listDdPowerchangrecord().getElemList();
	}
	/**
	 * 删除指定DTO
	 * 
	 * @param DdPowerchangrecordId
	 * @param version        ֵ

	 */
	public List deleteDdPowerchangrecordobj(String ddPowerchangrecordId,int version) {
		ddPowerchangrecordService.deleteDdPowerchangrecord(ddPowerchangrecordId,version);
		return ddPowerchangrecordService.listDdPowerchangrecord().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdPowerchangrecord4dwr() {
		return ddPowerchangrecordService.listDdPowerchangrecord().getElemList();
	}

	public void setDdPowerchangrecordService(IDdPowerchangrecordService ddPowerchangrecordService) {
		this.ddPowerchangrecordService = ddPowerchangrecordService;		
	}
	
	public QueryListObj getDdPowerchangrecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddPowerchangrecordService.getDdPowerchangrecordByHql(hql, beginPage, pageSize, sql);
	}
	public DdPowerchangrecordDto loadDdPowerchangrecord(String ddPowerchangrecordId){
		return this.ddPowerchangrecordService.loadDdPowerchangrecord(ddPowerchangrecordId);
	}
	

		

 /**
    * @business method list
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
