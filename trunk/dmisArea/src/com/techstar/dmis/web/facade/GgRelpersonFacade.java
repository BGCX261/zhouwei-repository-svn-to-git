package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IGgRelpersonService;
import com.techstar.dmis.dto.GgRelpersonDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class GgRelpersonFacade {
	private IGgRelpersonService ggRelpersonService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listGgRelperson() {
		return ggRelpersonService.listGgRelperson().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addGgRelperson(GgRelpersonDto dto) {
		ggRelpersonService.saveOrUpdateGgRelperson(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param GgRelpersonId
	 *           ֵ

	 */
	public GgRelpersonDto getGgRelpersonById(String  ggRelpersonId) {
		GgRelpersonDto dto = ggRelpersonService.loadGgRelperson(ggRelpersonId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param GgRelpersonId
	 *         ֵ

	 */
	public List deleteGgRelperson(String ggRelpersonId) {
		ggRelpersonService.deleteGgRelperson(ggRelpersonId);
		return ggRelpersonService.listGgRelperson().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteGgRelperson(List dtos) {
		ggRelpersonService.deleteGgRelperson(dtos);
		return ggRelpersonService.listGgRelperson().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listGgRelperson4dwr() {
		return ggRelpersonService.listGgRelperson().getElemList();
	}

	public void setGgRelpersonService(IGgRelpersonService ggRelpersonService) {
		this.ggRelpersonService = ggRelpersonService;		
	}
	
	public QueryListObj getGgRelpersonByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ggRelpersonService.getGgRelpersonByHql(hql, beginPage, pageSize, sql);
	}
	public GgRelpersonDto loadGgRelperson(String ggRelpersonId){
		return this.ggRelpersonService.loadGgRelperson(ggRelpersonId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
