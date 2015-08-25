package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhSequencetableService;
import com.techstar.dmis.dto.ZdhSequencetableDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhSequencetableFacade {
	private IZdhSequencetableService zdhSequencetableService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhSequencetable() {
		return zdhSequencetableService.listZdhSequencetable().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhSequencetable(ZdhSequencetableDto dto) {
		zdhSequencetableService.saveOrUpdateZdhSequencetable(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhSequencetableId
	 *           ֵ

	 */
	public ZdhSequencetableDto getZdhSequencetableById(String  zdhSequencetableId) {
		ZdhSequencetableDto dto = zdhSequencetableService.loadZdhSequencetable(zdhSequencetableId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhSequencetableId
	 *         ֵ

	 */
	public List deleteZdhSequencetable(String zdhSequencetableId) {
		zdhSequencetableService.deleteZdhSequencetable(zdhSequencetableId);
		return zdhSequencetableService.listZdhSequencetable().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhSequencetable(List dtos) {
		zdhSequencetableService.deleteZdhSequencetable(dtos);
		return zdhSequencetableService.listZdhSequencetable().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhSequencetable4dwr() {
		return zdhSequencetableService.listZdhSequencetable().getElemList();
	}

	public void setZdhSequencetableService(IZdhSequencetableService zdhSequencetableService) {
		this.zdhSequencetableService = zdhSequencetableService;		
	}
	
	public QueryListObj getZdhSequencetableByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhSequencetableService.getZdhSequencetableByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhSequencetableDto loadZdhSequencetable(String zdhSequencetableId){
		return this.zdhSequencetableService.loadZdhSequencetable(zdhSequencetableId);
	}
	
	   public void saveOrUpdateDdfsModechangelist(List dtos){
		   zdhSequencetableService.saveOrUpdateZdhSequencetable(dtos);
	   }
		
	   public void RepDelete(String strXmlPath){
		   zdhSequencetableService.RepDelete(strXmlPath);
	   }
 /**
    * @business method list
	 	* @excel导入
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
