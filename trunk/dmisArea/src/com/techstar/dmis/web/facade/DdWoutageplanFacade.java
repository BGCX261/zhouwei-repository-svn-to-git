package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdWoutageplanService;
import com.techstar.dmis.dto.DdWoutageplanDto;

    import com.techstar.dmis.dto.DdRepairdetailDto;
	import com.techstar.dmis.dto.DdMoutageplanDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdWoutageplanFacade {
	private IDdWoutageplanService ddWoutageplanService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdWoutageplan() {
		return ddWoutageplanService.listDdWoutageplan().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdWoutageplan(DdWoutageplanDto dto) {
		ddWoutageplanService.saveOrUpdateDdWoutageplan(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdWoutageplanId
	 *           ֵ

	 */
	public DdWoutageplanDto getDdWoutageplanById(String  ddWoutageplanId) {
		DdWoutageplanDto dto = ddWoutageplanService.loadDdWoutageplan(ddWoutageplanId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdWoutageplanId
	 *         ֵ

	 */
	public List deleteDdWoutageplan(String ddWoutageplanId) {
		ddWoutageplanService.deleteDdWoutageplan(ddWoutageplanId);
		return ddWoutageplanService.listDdWoutageplan().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdWoutageplan(List dtos) {
		ddWoutageplanService.deleteDdWoutageplan(dtos);
		return ddWoutageplanService.listDdWoutageplan().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdWoutageplan4dwr() {
		return ddWoutageplanService.listDdWoutageplan().getElemList();
	}

	public void setDdWoutageplanService(IDdWoutageplanService ddWoutageplanService) {
		this.ddWoutageplanService = ddWoutageplanService;		
	}
	
	public QueryListObj getDdWoutageplanByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddWoutageplanService.getDdWoutageplanByHql(hql, beginPage, pageSize, sql);
	}
	public DdWoutageplanDto loadDdWoutageplan(String ddWoutageplanId){
		return this.ddWoutageplanService.loadDdWoutageplan(ddWoutageplanId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
 	//注册子表facade方法
    	public DdRepairdetailDto loadDdRepairdetail(String fid){
		return this.ddWoutageplanService.loadDdRepairdetail(fid);
	}
	
	public List deleteDdRepairdetail(String fid) {
		ddWoutageplanService.deleteDdRepairdetail(fid);
		return ddWoutageplanService.listDdRepairdetail().getElemList();
	}
	public List deleteDdRepairdetail(List dtos) {
		ddWoutageplanService.deleteDdRepairdetail(dtos);
		return ddWoutageplanService.listDdRepairdetail().getElemList();
	}
	public void addDdRepairdetail(DdRepairdetailDto dto) {
		ddWoutageplanService.saveOrUpdateDdRepairdetail(dto);
	}

		public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno){
		return this.ddWoutageplanService.loadDdMoutageplan(fmonthplanno);
	}
	
	public List deleteDdMoutageplan(String fmonthplanno) {
		ddWoutageplanService.deleteDdMoutageplan(fmonthplanno);
		return ddWoutageplanService.listDdMoutageplan().getElemList();
	}
	public List deleteDdMoutageplan(List dtos) {
		ddWoutageplanService.deleteDdMoutageplan(dtos);
		return ddWoutageplanService.listDdMoutageplan().getElemList();
	}
	public void addDdMoutageplan(DdMoutageplanDto dto) {
		ddWoutageplanService.saveOrUpdateDdMoutageplan(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
