package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdCutofflistService;
import com.techstar.dmis.dto.DdCutofflistDto;

    import com.techstar.dmis.dto.DdCutoffdetaillistDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdCutofflistFacade {
	private IDdCutofflistService ddCutofflistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdCutofflist() {
		return ddCutofflistService.listDdCutofflist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdCutofflist(DdCutofflistDto dto) {
		ddCutofflistService.saveOrUpdateDdCutofflist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdCutofflistId
	 *           ֵ

	 */
	public DdCutofflistDto getDdCutofflistById(String  ddCutofflistId) {
		DdCutofflistDto dto = ddCutofflistService.loadDdCutofflist(ddCutofflistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdCutofflistId
	 *         ֵ

	 */
	public List deleteDdCutofflist(String ddCutofflistId) {
		ddCutofflistService.deleteDdCutofflist(ddCutofflistId);
		return ddCutofflistService.listDdCutofflist().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdCutofflist(List dtos) {
		ddCutofflistService.deleteDdCutofflist(dtos);
		return ddCutofflistService.listDdCutofflist().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdCutofflist4dwr() {
		return ddCutofflistService.listDdCutofflist().getElemList();
	}

	public void setDdCutofflistService(IDdCutofflistService ddCutofflistService) {
		this.ddCutofflistService = ddCutofflistService;		
	}
	
	public QueryListObj getDdCutofflistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddCutofflistService.getDdCutofflistByHql(hql, beginPage, pageSize, sql);
	}
	public DdCutofflistDto loadDdCutofflist(String ddCutofflistId){
		return this.ddCutofflistService.loadDdCutofflist(ddCutofflistId);
	}
	

		

 /**
    * @business method list
	 	* @归档
	 	* @拉路序位选择
	 	* @拉路负荷分配比例维护
	 	* @拉限任务分配
	  */	
 
 
 
 	//注册子表facade方法
    	public DdCutoffdetaillistDto loadDdCutoffdetaillist(String fdetailid){
		return this.ddCutofflistService.loadDdCutoffdetaillist(fdetailid);
	}
	
	public List deleteDdCutoffdetaillist(String fdetailid) {
		ddCutofflistService.deleteDdCutoffdetaillist(fdetailid);
		return ddCutofflistService.listDdCutoffdetaillist().getElemList();
	}
	public List deleteDdCutoffdetaillist(List dtos) {
		ddCutofflistService.deleteDdCutoffdetaillist(dtos);
		return ddCutofflistService.listDdCutoffdetaillist().getElemList();
	}
	public void addDdCutoffdetaillist(DdCutoffdetaillistDto dto) {
		ddCutofflistService.saveOrUpdateDdCutoffdetaillist(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
