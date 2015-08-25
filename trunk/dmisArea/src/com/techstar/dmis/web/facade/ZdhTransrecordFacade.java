package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhTransrecordService;
import com.techstar.dmis.dto.ZdhTransrecordDto;

    import com.techstar.dmis.dto.StdStationDto;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhTransrecordFacade {
	private IZdhTransrecordService zdhTransrecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhTransrecord() {
		return zdhTransrecordService.listZdhTransrecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhTransrecord(ZdhTransrecordDto dto) {
		zdhTransrecordService.saveOrUpdateZdhTransrecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhTransrecordId
	 *           ֵ

	 */
	public ZdhTransrecordDto getZdhTransrecordById(String  zdhTransrecordId) {
		ZdhTransrecordDto dto = zdhTransrecordService.loadZdhTransrecord(zdhTransrecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhTransrecordId
	 *         ֵ

	 */
	public List deleteZdhTransrecord(String zdhTransrecordId) {
		zdhTransrecordService.deleteZdhTransrecord(zdhTransrecordId);
		return zdhTransrecordService.listZdhTransrecord().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhTransrecord(List dtos) {
		zdhTransrecordService.deleteZdhTransrecord(dtos);
		return zdhTransrecordService.listZdhTransrecord().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhTransrecord4dwr() {
		return zdhTransrecordService.listZdhTransrecord().getElemList();
	}

	public void setZdhTransrecordService(IZdhTransrecordService zdhTransrecordService) {
		this.zdhTransrecordService = zdhTransrecordService;		
	}
	
	public QueryListObj getZdhTransrecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhTransrecordService.getZdhTransrecordByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhTransrecordDto loadZdhTransrecord(String zdhTransrecordId){
		return this.zdhTransrecordService.loadZdhTransrecord(zdhTransrecordId);
	}
	//得到班号
	public String getOndutyno(){
		return this.zdhTransrecordService.getOndutyno();
	}

		

 /**
    * @business method list
	 	* @数据校核完成
	  */	
 
 
 
 	//注册子表facade方法
    	public StdStationDto loadStdStation(String id){
		return this.zdhTransrecordService.loadStdStation(id);
	}
	
	public List deleteStdStation(String id) {
		zdhTransrecordService.deleteStdStation(id);
		return zdhTransrecordService.listStdStation().getElemList();
	}
	public List deleteStdStation(List dtos) {
		zdhTransrecordService.deleteStdStation(dtos);
		return zdhTransrecordService.listStdStation().getElemList();
	}
	public void addStdStation(StdStationDto dto) {
		zdhTransrecordService.saveOrUpdateStdStation(dto);
	}

		public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno){
		return this.zdhTransrecordService.loadZdhAutoondutylog(ondutyno);
	}
	
	public List deleteZdhAutoondutylog(String ondutyno) {
		zdhTransrecordService.deleteZdhAutoondutylog(ondutyno);
		return zdhTransrecordService.listZdhAutoondutylog().getElemList();
	}
	public List deleteZdhAutoondutylog(List dtos) {
		zdhTransrecordService.deleteZdhAutoondutylog(dtos);
		return zdhTransrecordService.listZdhAutoondutylog().getElemList();
	}
	public void addZdhAutoondutylog(ZdhAutoondutylogDto dto) {
		zdhTransrecordService.saveOrUpdateZdhAutoondutylog(dto);
	}
	 public void changeStatus(String transrecordid){
		 zdhTransrecordService.changeStatus(transrecordid);
	 }
	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
