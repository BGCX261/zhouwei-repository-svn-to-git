package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdPremethodService;
import com.techstar.dmis.dto.DdPremethodDto;

    import com.techstar.dmis.dto.DdMoutageplanDto;
	import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdPremethodFacade {
	private IDdPremethodService ddPremethodService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdPremethod() {
		return ddPremethodService.listDdPremethod().getElemList();
	}

	public QueryListObj listDdPremethodByHQL(String hql) {
		return ddPremethodService.listDdPremethodByHQL(hql);
	}
	
	
	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdPremethod(DdPremethodDto dto) {
		ddPremethodService.saveOrUpdateDdPremethod(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdPremethodId
	 *           ֵ

	 */
	public DdPremethodDto getDdPremethodById(String  ddPremethodId) {
		DdPremethodDto dto = ddPremethodService.loadDdPremethod(ddPremethodId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdPremethodId
	 *         ֵ

	 */
	public List deleteDdPremethod(String ddPremethodId) {
		ddPremethodService.deleteDdPremethod(ddPremethodId);
		return ddPremethodService.listDdPremethod().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdPremethod(List dtos) {
		ddPremethodService.deleteDdPremethod(dtos);
		return ddPremethodService.listDdPremethod().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdPremethod4dwr() {
		return ddPremethodService.listDdPremethod().getElemList();
	}

	public void setDdPremethodService(IDdPremethodService ddPremethodService) {
		this.ddPremethodService = ddPremethodService;		
	}
	
	public QueryListObj getDdPremethodByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddPremethodService.getDdPremethodByHql(hql, beginPage, pageSize, sql);
	}
	public DdPremethodDto loadDdPremethod(String ddPremethodId){
		return this.ddPremethodService.loadDdPremethod(ddPremethodId);
	}
	

		

 /**
    * @business method list
	 	* @归档
	 	* @保电预案编制
	 	* @月计划预案编制
	  */	
 
 
 
 	//注册子表facade方法
    	public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno){
		return this.ddPremethodService.loadDdMoutageplan(fmonthplanno);
	}
	
	public List deleteDdMoutageplan(String fmonthplanno) {
		ddPremethodService.deleteDdMoutageplan(fmonthplanno);
		return ddPremethodService.listDdMoutageplan().getElemList();
	}
	public List deleteDdMoutageplan(List dtos) {
		ddPremethodService.deleteDdMoutageplan(dtos);
		return ddPremethodService.listDdMoutageplan().getElemList();
	}
	public void addDdMoutageplan(DdMoutageplanDto dto) {
		ddPremethodService.saveOrUpdateDdMoutageplan(dto);
	}

		public DdEnsuringpsmanageDto loadDdEnsuringpsmanage(String fid){
		return this.ddPremethodService.loadDdEnsuringpsmanage(fid);
	}
	
	public List deleteDdEnsuringpsmanage(String fid) {
		ddPremethodService.deleteDdEnsuringpsmanage(fid);
		return ddPremethodService.listDdEnsuringpsmanage().getElemList();
	}
	public List deleteDdEnsuringpsmanage(List dtos) {
		ddPremethodService.deleteDdEnsuringpsmanage(dtos);
		return ddPremethodService.listDdEnsuringpsmanage().getElemList();
	}
	public void addDdEnsuringpsmanage(DdEnsuringpsmanageDto dto) {
		ddPremethodService.saveOrUpdateDdEnsuringpsmanage(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
