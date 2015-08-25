package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhAutoondutylogService;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;

    import com.techstar.dmis.dto.ZdhWorkbillDto;
	import com.techstar.dmis.dto.ZdhMachineworklistDto;
	import com.techstar.dmis.dto.ZdhRmrecDto;
	import com.techstar.dmis.dto.ZdhRsrecordDto;
	import com.techstar.dmis.dto.ZdhCharalterrecordDto;
	import com.techstar.dmis.dto.ZdhFaultlistDto;
	import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhAutoondutylogFacade {
	private IZdhAutoondutylogService zdhAutoondutylogService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhAutoondutylog() {
		return zdhAutoondutylogService.listZdhAutoondutylog().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhAutoondutylog(ZdhAutoondutylogDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhAutoondutylog(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhAutoondutylogId
	 *           ֵ

	 */
	public ZdhAutoondutylogDto getZdhAutoondutylogById(String  zdhAutoondutylogId) {
		ZdhAutoondutylogDto dto = zdhAutoondutylogService.loadZdhAutoondutylog(zdhAutoondutylogId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhAutoondutylogId
	 *         ֵ

	 */
	public List deleteZdhAutoondutylog(String zdhAutoondutylogId) {
		zdhAutoondutylogService.deleteZdhAutoondutylog(zdhAutoondutylogId);
		return zdhAutoondutylogService.listZdhAutoondutylog().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhAutoondutylog(List dtos) {
		zdhAutoondutylogService.deleteZdhAutoondutylog(dtos);
		return zdhAutoondutylogService.listZdhAutoondutylog().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhAutoondutylog4dwr() {
		return zdhAutoondutylogService.listZdhAutoondutylog().getElemList();
	}

	public void setZdhAutoondutylogService(IZdhAutoondutylogService zdhAutoondutylogService) {
		this.zdhAutoondutylogService = zdhAutoondutylogService;		
	}
	
	public QueryListObj getZdhAutoondutylogByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhAutoondutylogService.getZdhAutoondutylogByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhAutoondutylogDto loadZdhAutoondutylog(String zdhAutoondutylogId){
		return this.zdhAutoondutylogService.loadZdhAutoondutylog(zdhAutoondutylogId);
	}
	

		

 /**
    * @business method list
	 	* @交接班
	  */	
 
 
 
 	//注册子表facade方法
    	public ZdhWorkbillDto loadZdhWorkbill(String workbillid){
		return this.zdhAutoondutylogService.loadZdhWorkbill(workbillid);
	}
	
	public List deleteZdhWorkbill(String workbillid) {
		zdhAutoondutylogService.deleteZdhWorkbill(workbillid);
		
		return zdhAutoondutylogService.listZdhWorkbill().getElemList();
	}
	public List deleteZdhWorkbill(List dtos) {
		zdhAutoondutylogService.deleteZdhWorkbill(dtos);
		return zdhAutoondutylogService.listZdhWorkbill().getElemList();
	}
	public void addZdhWorkbill(ZdhWorkbillDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhWorkbill(dto);
	}

		public ZdhMachineworklistDto loadZdhMachineworklist(String jobid){
		return this.zdhAutoondutylogService.loadZdhMachineworklist(jobid);
	}
	
	public List deleteZdhMachineworklist(String jobid) {
		zdhAutoondutylogService.deleteZdhMachineworklist(jobid);
		return zdhAutoondutylogService.listZdhMachineworklist().getElemList();
	}
	public List deleteZdhMachineworklist(List dtos) {
		zdhAutoondutylogService.deleteZdhMachineworklist(dtos);
		return zdhAutoondutylogService.listZdhMachineworklist().getElemList();
	}
	public void addZdhMachineworklist(ZdhMachineworklistDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhMachineworklist(dto);
	}

		public ZdhRmrecDto loadZdhRmrec(String recordno){
		return this.zdhAutoondutylogService.loadZdhRmrec(recordno);
	}
	
	public List deleteZdhRmrec(String recordno) {
		zdhAutoondutylogService.deleteZdhRmrec(recordno);
		return zdhAutoondutylogService.listZdhRmrec().getElemList();
	}
	public List deleteZdhRmrec(List dtos) {
		zdhAutoondutylogService.deleteZdhRmrec(dtos);
		return zdhAutoondutylogService.listZdhRmrec().getElemList();
	}
	public void addZdhRmrec(ZdhRmrecDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhRmrec(dto);
	}

		public ZdhRsrecordDto loadZdhRsrecord(String recordid){
		return this.zdhAutoondutylogService.loadZdhRsrecord(recordid);
	}
	
	public List deleteZdhRsrecord(String recordid) {
		zdhAutoondutylogService.deleteZdhRsrecord(recordid);
		return zdhAutoondutylogService.listZdhRsrecord().getElemList();
	}
	public List deleteZdhRsrecord(List dtos) {
		zdhAutoondutylogService.deleteZdhRsrecord(dtos);
		return zdhAutoondutylogService.listZdhRsrecord().getElemList();
	}
	public void addZdhRsrecord(ZdhRsrecordDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhRsrecord(dto);
	}

		public ZdhCharalterrecordDto loadZdhCharalterrecord(String recordsno){
		return this.zdhAutoondutylogService.loadZdhCharalterrecord(recordsno);
	}
	
	public List deleteZdhCharalterrecord(String recordsno) {
		zdhAutoondutylogService.deleteZdhCharalterrecord(recordsno);
		return zdhAutoondutylogService.listZdhCharalterrecord().getElemList();
	}
	public List deleteZdhCharalterrecord(List dtos) {
		zdhAutoondutylogService.deleteZdhCharalterrecord(dtos);
		return zdhAutoondutylogService.listZdhCharalterrecord().getElemList();
	}
	public void addZdhCharalterrecord(ZdhCharalterrecordDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhCharalterrecord(dto);
	}

		public ZdhFaultlistDto loadZdhFaultlist(String ffaultno){
		return this.zdhAutoondutylogService.loadZdhFaultlist(ffaultno);
	}
	
	public List deleteZdhFaultlist(String ffaultno) {
		zdhAutoondutylogService.deleteZdhFaultlist(ffaultno);
		return zdhAutoondutylogService.listZdhFaultlist().getElemList();
	}
	public List deleteZdhFaultlist(List dtos) {
		zdhAutoondutylogService.deleteZdhFaultlist(dtos);
		return zdhAutoondutylogService.listZdhFaultlist().getElemList();
	}
	public void addZdhFaultlist(ZdhFaultlistDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhFaultlist(dto);
	}

		public ZdhTransrecordDto loadZdhTransrecord(String transrecordid){
		return this.zdhAutoondutylogService.loadZdhTransrecord(transrecordid);
	}
	
	public List deleteZdhTransrecord(String transrecordid) {
		zdhAutoondutylogService.deleteZdhTransrecord(transrecordid);
		return zdhAutoondutylogService.listZdhTransrecord().getElemList();
	}
	public List deleteZdhTransrecord(List dtos) {
		zdhAutoondutylogService.deleteZdhTransrecord(dtos);
		return zdhAutoondutylogService.listZdhTransrecord().getElemList();
	}
	public void addZdhTransrecord(ZdhTransrecordDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhTransrecord(dto);
	}

		public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid){
		return this.zdhAutoondutylogService.loadZdhOpexaminelist(examinationid);
	}
	
	public List deleteZdhOpexaminelist(String examinationid) {
		zdhAutoondutylogService.deleteZdhOpexaminelist(examinationid);
		return zdhAutoondutylogService.listZdhOpexaminelist().getElemList();
	}
	public List deleteZdhOpexaminelist(List dtos) {
		zdhAutoondutylogService.deleteZdhOpexaminelist(dtos);
		return zdhAutoondutylogService.listZdhOpexaminelist().getElemList();
	}
	public void addZdhOpexaminelist(ZdhOpexaminelistDto dto) {
		zdhAutoondutylogService.saveOrUpdateZdhOpexaminelist(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	/**
	 * 交接班操作
	 * ondutyno 班号
	 * @author sbt 2007-4-17 
	 */
	public String carryOn(String ondutyno){		
		return zdhAutoondutylogService.carryOn(ondutyno);
	}
}
