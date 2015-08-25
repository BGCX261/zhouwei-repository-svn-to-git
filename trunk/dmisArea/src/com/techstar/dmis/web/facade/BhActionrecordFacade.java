package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IBhActionrecordService;
import com.techstar.dmis.dto.BhActionrecordDto;

    import com.techstar.dmis.dto.StdBhtresponseDto;
	import com.techstar.dmis.dto.StdPreasontypeDto;
	import com.techstar.dmis.dto.StdBheqpfaultDto;
	import com.techstar.dmis.dto.DdAccidentbriefDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class BhActionrecordFacade {
	private IBhActionrecordService bhActionrecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listBhActionrecord() {
		return bhActionrecordService.listBhActionrecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addBhActionrecord(BhActionrecordDto dto) {
		bhActionrecordService.saveOrUpdateBhActionrecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param BhActionrecordId
	 *           ֵ

	 */
	public BhActionrecordDto getBhActionrecordById(String  bhActionrecordId) {
		BhActionrecordDto dto = bhActionrecordService.loadBhActionrecord(bhActionrecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param BhActionrecordId
	 *         ֵ

	 */
	public List deleteBhActionrecord(String bhActionrecordId) {
		bhActionrecordService.deleteBhActionrecord(bhActionrecordId);
		return bhActionrecordService.listBhActionrecord().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteBhActionrecord(List dtos) {
		bhActionrecordService.deleteBhActionrecord(dtos);
		return bhActionrecordService.listBhActionrecord().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listBhActionrecord4dwr() {
		return bhActionrecordService.listBhActionrecord().getElemList();
	}

	public void setBhActionrecordService(IBhActionrecordService bhActionrecordService) {
		this.bhActionrecordService = bhActionrecordService;		
	}
	
	public QueryListObj getBhActionrecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.bhActionrecordService.getBhActionrecordByHql(hql, beginPage, pageSize, sql);
	}
	public BhActionrecordDto loadBhActionrecord(String bhActionrecordId){
		return this.bhActionrecordService.loadBhActionrecord(bhActionrecordId);
	}
	

		

 /**
    * @business method list
	 	* @选择故障
	 	* @选择设备
	  */	
 
 
 
 	//注册子表facade方法
    	public StdBhtresponseDto loadStdBhtresponse(String id){
		return this.bhActionrecordService.loadStdBhtresponse(id);
	}
	
	public List deleteStdBhtresponse(String id) {
		bhActionrecordService.deleteStdBhtresponse(id);
		return bhActionrecordService.listStdBhtresponse().getElemList();
	}
	public List deleteStdBhtresponse(List dtos) {
		bhActionrecordService.deleteStdBhtresponse(dtos);
		return bhActionrecordService.listStdBhtresponse().getElemList();
	}
	public void addStdBhtresponse(StdBhtresponseDto dto) {
		bhActionrecordService.saveOrUpdateStdBhtresponse(dto);
	}

		public StdPreasontypeDto loadStdPreasontype(String id){
		return this.bhActionrecordService.loadStdPreasontype(id);
	}
	
	public List deleteStdPreasontype(String id) {
		bhActionrecordService.deleteStdPreasontype(id);
		return bhActionrecordService.listStdPreasontype().getElemList();
	}
	public List deleteStdPreasontype(List dtos) {
		bhActionrecordService.deleteStdPreasontype(dtos);
		return bhActionrecordService.listStdPreasontype().getElemList();
	}
	public void addStdPreasontype(StdPreasontypeDto dto) {
		bhActionrecordService.saveOrUpdateStdPreasontype(dto);
	}

		public StdBheqpfaultDto loadStdBheqpfault(String id){
		return this.bhActionrecordService.loadStdBheqpfault(id);
	}
	
	public List deleteStdBheqpfault(String id) {
		bhActionrecordService.deleteStdBheqpfault(id);
		return bhActionrecordService.listStdBheqpfault().getElemList();
	}
	public List deleteStdBheqpfault(List dtos) {
		bhActionrecordService.deleteStdBheqpfault(dtos);
		return bhActionrecordService.listStdBheqpfault().getElemList();
	}
	public void addStdBheqpfault(StdBheqpfaultDto dto) {
		bhActionrecordService.saveOrUpdateStdBheqpfault(dto);
	}

		public DdAccidentbriefDto loadDdAccidentbrief(String faccidentid){
		return this.bhActionrecordService.loadDdAccidentbrief(faccidentid);
	}
	
	public List deleteDdAccidentbrief(String faccidentid) {
		bhActionrecordService.deleteDdAccidentbrief(faccidentid);
		return bhActionrecordService.listDdAccidentbrief().getElemList();
	}
	public List deleteDdAccidentbrief(List dtos) {
		bhActionrecordService.deleteDdAccidentbrief(dtos);
		return bhActionrecordService.listDdAccidentbrief().getElemList();
	}
	public void addDdAccidentbrief(DdAccidentbriefDto dto) {
		bhActionrecordService.saveOrUpdateDdAccidentbrief(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
