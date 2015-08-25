package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IStdStationService;
import com.techstar.dmis.dto.StdStationDto;

    import com.techstar.dmis.dto.ZdhTransrecordDto;
	import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
	import com.techstar.dmis.dto.DdWaterheightDto;
	import com.techstar.dmis.dto.BhAsregulateDto;
	import com.techstar.dmis.dto.DdPowerchangrecordDto;
	import com.techstar.dmis.dto.ZdhRmrecDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class StdStationFacade {
	private IStdStationService stdStationService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listStdStation() {
		return stdStationService.listStdStation().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addStdStation(StdStationDto dto) {
		stdStationService.saveOrUpdateStdStation(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param StdStationId
	 *           ֵ

	 */
	public StdStationDto getStdStationById(String  stdStationId) {
		StdStationDto dto = stdStationService.loadStdStation(stdStationId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param StdStationId
	 *         ֵ

	 */
	public List deleteStdStation(String stdStationId) {
		stdStationService.deleteStdStation(stdStationId);
		return stdStationService.listStdStation().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteStdStation(List dtos) {
		stdStationService.deleteStdStation(dtos);
		return stdStationService.listStdStation().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listStdStation4dwr() {
		return stdStationService.listStdStation().getElemList();
	}

	public void setStdStationService(IStdStationService stdStationService) {
		this.stdStationService = stdStationService;		
	}
	
	public QueryListObj getStdStationByHql(String hql, int beginPage, int pageSize, String sql){
		return this.stdStationService.getStdStationByHql(hql, beginPage, pageSize, sql);
	}
	public StdStationDto loadStdStation(String stdStationId){
		return this.stdStationService.loadStdStation(stdStationId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 /*
 	//注册子表facade方法
    	public ZdhTransrecordDto loadZdhTransrecord(String transrecordid){
		return this.stdStationService.loadZdhTransrecord(transrecordid);
	}
	
	public List deleteZdhTransrecord(String transrecordid) {
		stdStationService.deleteZdhTransrecord(transrecordid);
		return stdStationService.listZdhTransrecord().getElemList();
	}
	public List deleteZdhTransrecord(List dtos) {
		stdStationService.deleteZdhTransrecord(dtos);
		return stdStationService.listZdhTransrecord().getElemList();
	}
	public void addZdhTransrecord(ZdhTransrecordDto dto) {
		stdStationService.saveOrUpdateZdhTransrecord(dto);
	}

		public DdHpoweroperaterrdDto loadDdHpoweroperaterrd(String fid){
		return this.stdStationService.loadDdHpoweroperaterrd(fid);
	}
	
	public List deleteDdHpoweroperaterrd(String fid) {
		stdStationService.deleteDdHpoweroperaterrd(fid);
		return stdStationService.listDdHpoweroperaterrd().getElemList();
	}
	public List deleteDdHpoweroperaterrd(List dtos) {
		stdStationService.deleteDdHpoweroperaterrd(dtos);
		return stdStationService.listDdHpoweroperaterrd().getElemList();
	}
	public void addDdHpoweroperaterrd(DdHpoweroperaterrdDto dto) {
		stdStationService.saveOrUpdateDdHpoweroperaterrd(dto);
	}

		public DdWaterheightDto loadDdWaterheight(String fid){
		return this.stdStationService.loadDdWaterheight(fid);
	}
	
	public List deleteDdWaterheight(String fid) {
		stdStationService.deleteDdWaterheight(fid);
		return stdStationService.listDdWaterheight().getElemList();
	}
	public List deleteDdWaterheight(List dtos) {
		stdStationService.deleteDdWaterheight(dtos);
		return stdStationService.listDdWaterheight().getElemList();
	}
	public void addDdWaterheight(DdWaterheightDto dto) {
		stdStationService.saveOrUpdateDdWaterheight(dto);
	}

		public BhAsregulateDto loadBhAsregulate(String asregulateid){
		return this.stdStationService.loadBhAsregulate(asregulateid);
	}
	
	public List deleteBhAsregulate(String asregulateid) {
		stdStationService.deleteBhAsregulate(asregulateid);
		return stdStationService.listBhAsregulate().getElemList();
	}
	public List deleteBhAsregulate(List dtos) {
		stdStationService.deleteBhAsregulate(dtos);
		return stdStationService.listBhAsregulate().getElemList();
	}
	public void addBhAsregulate(BhAsregulateDto dto) {
		stdStationService.saveOrUpdateBhAsregulate(dto);
	}

		public DdPowerchangrecordDto loadDdPowerchangrecord(String fid){
		return this.stdStationService.loadDdPowerchangrecord(fid);
	}
	
	public List deleteDdPowerchangrecord(String fid) {
		stdStationService.deleteDdPowerchangrecord(fid);
		return stdStationService.listDdPowerchangrecord().getElemList();
	}
	public List deleteDdPowerchangrecord(List dtos) {
		stdStationService.deleteDdPowerchangrecord(dtos);
		return stdStationService.listDdPowerchangrecord().getElemList();
	}
	public void addDdPowerchangrecord(DdPowerchangrecordDto dto) {
		stdStationService.saveOrUpdateDdPowerchangrecord(dto);
	}

		public ZdhRmrecDto loadZdhRmrec(String recordno){
		return this.stdStationService.loadZdhRmrec(recordno);
	}
	
	public List deleteZdhRmrec(String recordno) {
		stdStationService.deleteZdhRmrec(recordno);
		return stdStationService.listZdhRmrec().getElemList();
	}
	public List deleteZdhRmrec(List dtos) {
		stdStationService.deleteZdhRmrec(dtos);
		return stdStationService.listZdhRmrec().getElemList();
	}
	public void addZdhRmrec(ZdhRmrecDto dto) {
		stdStationService.saveOrUpdateZdhRmrec(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	*/
}
