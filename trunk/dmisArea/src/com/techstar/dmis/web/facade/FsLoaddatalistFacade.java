package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IFsLoaddatalistService;
import com.techstar.dmis.dto.FsLoaddatalistDto;

    import com.techstar.dmis.dto.FsLfparalistDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class FsLoaddatalistFacade {
	private IFsLoaddatalistService fsLoaddatalistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listFsLoaddatalist() {
		return fsLoaddatalistService.listFsLoaddatalist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addFsLoaddatalist(FsLoaddatalistDto dto) {
		fsLoaddatalistService.saveOrUpdateFsLoaddatalist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param FsLoaddatalistId
	 *           ֵ

	 */
	public FsLoaddatalistDto getFsLoaddatalistById(String  fsLoaddatalistId) {
		FsLoaddatalistDto dto = fsLoaddatalistService.loadFsLoaddatalist(fsLoaddatalistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param FsLoaddatalistId
	 *         ֵ

	 */
	public List deleteFsLoaddatalist(String fsLoaddatalistId) {
		fsLoaddatalistService.deleteFsLoaddatalist(fsLoaddatalistId);
		return fsLoaddatalistService.listFsLoaddatalist().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteFsLoaddatalist(List dtos) {
		fsLoaddatalistService.deleteFsLoaddatalist(dtos);
		return fsLoaddatalistService.listFsLoaddatalist().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listFsLoaddatalist4dwr() {
		return fsLoaddatalistService.listFsLoaddatalist().getElemList();
	}

	public void setFsLoaddatalistService(IFsLoaddatalistService fsLoaddatalistService) {
		this.fsLoaddatalistService = fsLoaddatalistService;		
	}
	
	public QueryListObj getFsLoaddatalistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.fsLoaddatalistService.getFsLoaddatalistByHql(hql, beginPage, pageSize, sql);
	}
	public FsLoaddatalistDto loadFsLoaddatalist(String fsLoaddatalistId){
		return this.fsLoaddatalistService.loadFsLoaddatalist(fsLoaddatalistId);
	}
	

		

 /**
    * @business method list
	 	* @低周负荷数据采集
	  */	
 
 
 
 	//注册子表facade方法
    	public FsLfparalistDto loadFsLfparalist(String flinesno){
		return this.fsLoaddatalistService.loadFsLfparalist(flinesno);
	}
	
	public List deleteFsLfparalist(String flinesno) {
		fsLoaddatalistService.deleteFsLfparalist(flinesno);
		return fsLoaddatalistService.listFsLfparalist().getElemList();
	}
	public List deleteFsLfparalist(List dtos) {
		fsLoaddatalistService.deleteFsLfparalist(dtos);
		return fsLoaddatalistService.listFsLfparalist().getElemList();
	}
	public void addFsLfparalist(FsLfparalistDto dto) {
		fsLoaddatalistService.saveOrUpdateFsLfparalist(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
