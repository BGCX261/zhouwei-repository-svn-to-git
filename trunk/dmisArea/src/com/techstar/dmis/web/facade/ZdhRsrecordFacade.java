package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhRsrecordService;
import com.techstar.dmis.dto.ZdhRsrecordDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhRsrecordFacade {
	private IZdhRsrecordService zdhRsrecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhRsrecord() {
		return zdhRsrecordService.listZdhRsrecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhRsrecord(ZdhRsrecordDto dto) {
		zdhRsrecordService.saveOrUpdateZdhRsrecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhRsrecordId
	 *           ֵ

	 */
	public ZdhRsrecordDto getZdhRsrecordById(String  zdhRsrecordId) {
		ZdhRsrecordDto dto = zdhRsrecordService.loadZdhRsrecord(zdhRsrecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhRsrecordId
	 *         ֵ

	 */
	public List deleteZdhRsrecord(String zdhRsrecordId) {
		zdhRsrecordService.deleteZdhRsrecord(zdhRsrecordId);
		return zdhRsrecordService.listZdhRsrecord().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhRsrecord4dwr() {
		return zdhRsrecordService.listZdhRsrecord().getElemList();
	}

	public void setZdhRsrecordService(IZdhRsrecordService zdhRsrecordService) {
		this.zdhRsrecordService = zdhRsrecordService;		
	}
	
	public QueryListObj getZdhRsrecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhRsrecordService.getZdhRsrecordByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhRsrecordDto loadZdhRsrecord(String zdhRsrecordId){
		return this.zdhRsrecordService.loadZdhRsrecord(zdhRsrecordId);
	}
	
	public QueryListObj getCurrAccidentbrieByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhRsrecordService.getCurrAccidentbrieByHql(hql, beginPage, pageSize, sql);
	}
	
	/**
	 * 
	 * @param zdhRsrecordId
	 * @param version
	 * @return
	 */
	public void deleteZdhRsrecordObj(String zdhRsrecordId,int version) {
		zdhRsrecordService.deleteZdhRsrecordObj(zdhRsrecordId,version); 
		//return zdhRsrecordService.listZdhRsrecord().getElemList();
	}
		

 /**
    * @business method list
	 	* @当日故障查洵
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
