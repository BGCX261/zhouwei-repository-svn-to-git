package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdSasusprecordService;
import com.techstar.dmis.dto.DdSasusprecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdSasusprecordFacade {
	private IDdSasusprecordService ddSasusprecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdSasusprecord() {
		return ddSasusprecordService.listDdSasusprecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdSasusprecord(DdSasusprecordDto dto) {
		ddSasusprecordService.saveOrUpdateDdSasusprecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdSasusprecordId
	 *           ֵ

	 */
	public DdSasusprecordDto getDdSasusprecordById(String  ddSasusprecordId) {
		DdSasusprecordDto dto = ddSasusprecordService.loadDdSasusprecord(ddSasusprecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdSasusprecordId
	 *         ֵ

	 */
	public List deleteDdSasusprecord(String ddSasusprecordId) {
		ddSasusprecordService.deleteDdSasusprecord(ddSasusprecordId);
		return ddSasusprecordService.listDdSasusprecord().getElemList();
	}
	/**
	 * 删除指定DTO
	 * 
	 * @param DdSasusprecordId
	 * @param version
	 *         ֵ

	 */
	public List deleteDdSasusprecordobj(String ddSasusprecordId,int version) {
		ddSasusprecordService.deleteDdSasusprecordobj(ddSasusprecordId,version);
		return ddSasusprecordService.listDdSasusprecord().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdSasusprecord4dwr() {
		return ddSasusprecordService.listDdSasusprecord().getElemList();
	}

	public void setDdSasusprecordService(IDdSasusprecordService ddSasusprecordService) {
		this.ddSasusprecordService = ddSasusprecordService;		
	}
	
	public QueryListObj getDdSasusprecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddSasusprecordService.getDdSasusprecordByHql(hql, beginPage, pageSize, sql);
	}
	public DdSasusprecordDto loadDdSasusprecord(String ddSasusprecordId){
		return this.ddSasusprecordService.loadDdSasusprecord(ddSasusprecordId);
	}
	

		

 /**
    * @business method list
	 	* @从SCADA获得自投数据
	 	* @拟定操作票
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
