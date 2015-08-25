package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IFsLfparalistService;
import com.techstar.dmis.dto.FsLfparalistDto;

    import com.techstar.dmis.dto.FsLoaddatalistDto;
	import com.techstar.dmis.dto.StdLfroundDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class FsLfparalistFacade {
	private IFsLfparalistService fsLfparalistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listFsLfparalist() {
		return fsLfparalistService.listFsLfparalist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addFsLfparalist(FsLfparalistDto dto) {
		fsLfparalistService.saveOrUpdateFsLfparalist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param FsLfparalistId
	 *           ֵ

	 */
	public FsLfparalistDto getFsLfparalistById(String  fsLfparalistId) {
		FsLfparalistDto dto = fsLfparalistService.loadFsLfparalist(fsLfparalistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param FsLfparalistId
	 *         ֵ

	 */
	public List deleteFsLfparalist(String fsLfparalistId) {
		fsLfparalistService.deleteFsLfparalist(fsLfparalistId);
		return fsLfparalistService.listFsLfparalist().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteFsLfparalist(List dtos) {
		fsLfparalistService.deleteFsLfparalist(dtos);
		return fsLfparalistService.listFsLfparalist().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listFsLfparalist4dwr() {
		return fsLfparalistService.listFsLfparalist().getElemList();
	}

	public void setFsLfparalistService(IFsLfparalistService fsLfparalistService) {
		this.fsLfparalistService = fsLfparalistService;		
	}
	
	public QueryListObj getFsLfparalistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.fsLfparalistService.getFsLfparalistByHql(hql, beginPage, pageSize, sql);
	}
	public FsLfparalistDto loadFsLfparalist(String fsLfparalistId){
		return this.fsLfparalistService.loadFsLfparalist(fsLfparalistId);
	}
	

		

 /**
    * @business method list
	 	* @设定低周线路采集点
	  */	
 
 
 
 	//注册子表facade方法
    	public FsLoaddatalistDto loadFsLoaddatalist(String floaddatano){
		return this.fsLfparalistService.loadFsLoaddatalist(floaddatano);
	}
	
	public List deleteFsLoaddatalist(String floaddatano) {
		fsLfparalistService.deleteFsLoaddatalist(floaddatano);
		return fsLfparalistService.listFsLoaddatalist().getElemList();
	}
	public List deleteFsLoaddatalist(List dtos) {
		fsLfparalistService.deleteFsLoaddatalist(dtos);
		return fsLfparalistService.listFsLoaddatalist().getElemList();
	}
	public void addFsLoaddatalist(FsLoaddatalistDto dto) {
		fsLfparalistService.saveOrUpdateFsLoaddatalist(dto);
	}

		public StdLfroundDto loadStdLfround(String id){
		return this.fsLfparalistService.loadStdLfround(id);
	}
	
	public List deleteStdLfround(String id) {
		fsLfparalistService.deleteStdLfround(id);
		return fsLfparalistService.listStdLfround().getElemList();
	}
	public List deleteStdLfround(List dtos) {
		fsLfparalistService.deleteStdLfround(dtos);
		return fsLfparalistService.listStdLfround().getElemList();
	}
	public void addStdLfround(StdLfroundDto dto) {
		fsLfparalistService.saveOrUpdateStdLfround(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
