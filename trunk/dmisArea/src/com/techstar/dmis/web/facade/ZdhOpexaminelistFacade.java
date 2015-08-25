package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhOpexaminelistService;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;

    import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhOpexaminelistFacade {
	private IZdhOpexaminelistService zdhOpexaminelistService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhOpexaminelist() {
		return zdhOpexaminelistService.listZdhOpexaminelist().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhOpexaminelist(ZdhOpexaminelistDto dto) {
		zdhOpexaminelistService.saveOrUpdateZdhOpexaminelist(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhOpexaminelistId
	 *           ֵ

	 */
	public ZdhOpexaminelistDto getZdhOpexaminelistById(String  zdhOpexaminelistId) {
		ZdhOpexaminelistDto dto = zdhOpexaminelistService.loadZdhOpexaminelist(zdhOpexaminelistId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhOpexaminelistId
	 *         ֵ

	 */
	public List deleteZdhOpexaminelist(String zdhOpexaminelistId) {
		zdhOpexaminelistService.deleteZdhOpexaminelist(zdhOpexaminelistId);
		return zdhOpexaminelistService.listZdhOpexaminelist().getElemList();
	}
	public QueryListObj initDdDoutageplan(int beginPage,int pageSize,String sumSql){
		return zdhOpexaminelistService.initDdDoutageplan(beginPage, pageSize, sumSql);
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhOpexaminelist(List dtos) {
		zdhOpexaminelistService.deleteZdhOpexaminelist(dtos);
		return zdhOpexaminelistService.listZdhOpexaminelist().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhOpexaminelist4dwr() {
		return zdhOpexaminelistService.listZdhOpexaminelist().getElemList();
	}

	public void setZdhOpexaminelistService(IZdhOpexaminelistService zdhOpexaminelistService) {
		this.zdhOpexaminelistService = zdhOpexaminelistService;		
	}
	
	public QueryListObj getZdhOpexaminelistByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhOpexaminelistService.getZdhOpexaminelistByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhOpexaminelistDto loadZdhOpexaminelist(String zdhOpexaminelistId){
		return this.zdhOpexaminelistService.loadZdhOpexaminelist(zdhOpexaminelistId);
	}
	//得到班号
	 public String getOndutyno(){
			return this.zdhOpexaminelistService.getOndutyno();
		}
		
		//初始化日志 
	 public void saveDdDoutageplan() {
		 this.zdhOpexaminelistService.saveDdDoutageplan();
	 }
 /**
    * @business method list
	 	* @完成情况核查
	 	* @开始情况核查
	  */	
 
 
 
 	//注册子表facade方法
    	public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno){
		return this.zdhOpexaminelistService.loadZdhAutoondutylog(ondutyno);
	}
	
	public List deleteZdhAutoondutylog(String ondutyno) {
		zdhOpexaminelistService.deleteZdhAutoondutylog(ondutyno);
		return zdhOpexaminelistService.listZdhAutoondutylog().getElemList();
	}
	public List deleteZdhAutoondutylog(List dtos) {
		zdhOpexaminelistService.deleteZdhAutoondutylog(dtos);
		return zdhOpexaminelistService.listZdhAutoondutylog().getElemList();
	}
	public void addZdhAutoondutylog(ZdhAutoondutylogDto dto) {
		zdhOpexaminelistService.saveOrUpdateZdhAutoondutylog(dto);
	}

		public DdDoutageplanDto loadDdDoutageplan(String fdayplanno){
		return this.zdhOpexaminelistService.loadDdDoutageplan(fdayplanno);
	}
	
	public List deleteDdDoutageplan(String fdayplanno) {
		zdhOpexaminelistService.deleteDdDoutageplan(fdayplanno);
		return zdhOpexaminelistService.listDdDoutageplan().getElemList();
	}
	public List deleteDdDoutageplan(List dtos) {
		zdhOpexaminelistService.deleteDdDoutageplan(dtos);
		return zdhOpexaminelistService.listDdDoutageplan().getElemList();
	}
	public void addDdDoutageplan(DdDoutageplanDto dto) {
		zdhOpexaminelistService.saveOrUpdateDdDoutageplan(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
