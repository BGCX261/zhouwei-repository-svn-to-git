package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhMachineworklistService;
import com.techstar.dmis.dto.ZdhMachineworklistDto;

    import com.techstar.dmis.dto.ZdhAutoondutylogDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhMachineworklistFacade {
	private IZdhMachineworklistService zdhMachineworklistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhMachineworklist() {
		return zdhMachineworklistService.listZdhMachineworklist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhMachineworklist(ZdhMachineworklistDto dto) {
		zdhMachineworklistService.saveOrUpdateZdhMachineworklist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhMachineworklistId
	 *           ֵ

	 */
	public ZdhMachineworklistDto getZdhMachineworklistById(String  zdhMachineworklistId) {
		ZdhMachineworklistDto dto = zdhMachineworklistService.loadZdhMachineworklist(zdhMachineworklistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhMachineworklistId
	 *         ֵ

	 */
	public List deleteZdhMachineworklist(String zdhMachineworklistId) {
		zdhMachineworklistService.deleteZdhMachineworklist(zdhMachineworklistId);
		return zdhMachineworklistService.listZdhMachineworklist().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhMachineworklist(List dtos) {
		zdhMachineworklistService.deleteZdhMachineworklist(dtos);
		return zdhMachineworklistService.listZdhMachineworklist().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhMachineworklist4dwr() {
		return zdhMachineworklistService.listZdhMachineworklist().getElemList();
	}

	public void setZdhMachineworklistService(IZdhMachineworklistService zdhMachineworklistService) {
		this.zdhMachineworklistService = zdhMachineworklistService;		
	}
	
	public QueryListObj getZdhMachineworklistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhMachineworklistService.getZdhMachineworklistByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhMachineworklistDto loadZdhMachineworklist(String zdhMachineworklistId){
		return this.zdhMachineworklistService.loadZdhMachineworklist(zdhMachineworklistId);
	}
	//得到班号
	public String getOndutyno(){
		return this.zdhMachineworklistService.getOndutyno();
	}

		

 /**
    * @business method list
	  */	
 
 
 
 	//注册子表facade方法
    	public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno){
		return this.zdhMachineworklistService.loadZdhAutoondutylog(ondutyno);
	}
	
	public List deleteZdhAutoondutylog(String ondutyno) {
		zdhMachineworklistService.deleteZdhAutoondutylog(ondutyno);
		return zdhMachineworklistService.listZdhAutoondutylog().getElemList();
	}
	public List deleteZdhAutoondutylog(List dtos) {
		zdhMachineworklistService.deleteZdhAutoondutylog(dtos);
		return zdhMachineworklistService.listZdhAutoondutylog().getElemList();
	}
	public void addZdhAutoondutylog(ZdhAutoondutylogDto dto) {
		zdhMachineworklistService.saveOrUpdateZdhAutoondutylog(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
