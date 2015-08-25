package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdHloadrecordService;
import com.techstar.dmis.dto.DdHloadrecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdHloadrecordFacade {
	private IDdHloadrecordService ddHloadrecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdHloadrecord() {
		return ddHloadrecordService.listDdHloadrecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdHloadrecord(DdHloadrecordDto dto) {
		ddHloadrecordService.saveOrUpdateDdHloadrecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdHloadrecordId
	 *           ֵ

	 */
	public DdHloadrecordDto getDdHloadrecordById(String  ddHloadrecordId) {
		DdHloadrecordDto dto = ddHloadrecordService.loadDdHloadrecord(ddHloadrecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdHloadrecordId
	 *         ֵ

	 */
	public List deleteDdHloadrecord(String ddHloadrecordId) {
		ddHloadrecordService.deleteDdHloadrecord(ddHloadrecordId);
		return ddHloadrecordService.listDdHloadrecord().getElemList();
	}
	/**
	 * 删除指定DTO
	 * 
	 * @param DdHloadrecordId
	 * @param version        ֵ
		
	 */
	public List deleteDdHloadrecordobj(String ddHloadrecordId,int version) {
		ddHloadrecordService.deleteDdHloadrecordobj(ddHloadrecordId, version);
		return ddHloadrecordService.listDdHloadrecord().getElemList();
	}
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdHloadrecord4dwr() {
		return ddHloadrecordService.listDdHloadrecord().getElemList();
	}

	public void setDdHloadrecordService(IDdHloadrecordService ddHloadrecordService) {
		this.ddHloadrecordService = ddHloadrecordService;		
	}
	
	public QueryListObj getDdHloadrecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddHloadrecordService.getDdHloadrecordByHql(hql, beginPage, pageSize, sql);
	}
	public DdHloadrecordDto loadDdHloadrecord(String ddHloadrecordId){
		return this.ddHloadrecordService.loadDdHloadrecord(ddHloadrecordId);
	}
	

		

 /**
    * @business method list
	 	* @从应急系统获得过负荷记录
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
