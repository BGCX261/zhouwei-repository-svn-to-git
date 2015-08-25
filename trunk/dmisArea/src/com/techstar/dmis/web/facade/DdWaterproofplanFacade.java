package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdWaterproofplanService;
import com.techstar.dmis.dto.DdWaterproofplanDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdWaterproofplanFacade {
	private IDdWaterproofplanService ddWaterproofplanService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdWaterproofplan() {
		return ddWaterproofplanService.listDdWaterproofplan().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdWaterproofplan(DdWaterproofplanDto dto) {
		ddWaterproofplanService.saveOrUpdateDdWaterproofplan(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdWaterproofplanId
	 *           ֵ

	 */
	public DdWaterproofplanDto getDdWaterproofplanById(String  ddWaterproofplanId) {
		DdWaterproofplanDto dto = ddWaterproofplanService.loadDdWaterproofplan(ddWaterproofplanId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdWaterproofplanId
	 *         ֵ

	 */
	public List deleteDdWaterproofplan(String ddWaterproofplanId) {
		ddWaterproofplanService.deleteDdWaterproofplan(ddWaterproofplanId);
		return ddWaterproofplanService.listDdWaterproofplan().getElemList();
	}
	/**
	 * 删除指定DTO
	 * 
	 * @param DdWaterproofplanId
	 *         ֵ

	 */
	public List deleteDdWaterproofplan(String ddWaterproofplanId,int version) {
		ddWaterproofplanService.deleteDdWaterproofplan(ddWaterproofplanId,version);
		return ddWaterproofplanService.listDdWaterproofplan().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdWaterproofplan4dwr() {
		return ddWaterproofplanService.listDdWaterproofplan().getElemList();
	}

	public void setDdWaterproofplanService(IDdWaterproofplanService ddWaterproofplanService) {
		this.ddWaterproofplanService = ddWaterproofplanService;		
	}
	
	public QueryListObj getDdWaterproofplanByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddWaterproofplanService.getDdWaterproofplanByHql(hql, beginPage, pageSize, sql);
	}
	public DdWaterproofplanDto loadDdWaterproofplan(String ddWaterproofplanId){
		return this.ddWaterproofplanService.loadDdWaterproofplan(ddWaterproofplanId);
	}
	

		

 /**
    * @business method list
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
