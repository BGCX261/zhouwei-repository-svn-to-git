package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IGgPersonService;
import com.techstar.dmis.dto.GgPersonDto;


//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class GgPersonFacade {
	private IGgPersonService ggPersonService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listGgPerson() {
		return ggPersonService.listGgPerson().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addGgPerson(GgPersonDto dto) {
		ggPersonService.saveOrUpdateGgPerson(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param GgPersonId
	 *           ֵ

	 */
	public GgPersonDto getGgPersonById(String  ggPersonId) {
		GgPersonDto dto = ggPersonService.loadGgPerson(ggPersonId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param GgPersonId
	 *         ֵ

	 */
	public List deleteGgPerson(String ggPersonId) {
		ggPersonService.deleteGgPerson(ggPersonId);
		return ggPersonService.listGgPerson().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteGgPerson(List dtos) {
		ggPersonService.deleteGgPerson(dtos);
		return ggPersonService.listGgPerson().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listGgPerson4dwr() {
		return ggPersonService.listGgPerson().getElemList();
	}

	public void setGgPersonService(IGgPersonService ggPersonService) {
		this.ggPersonService = ggPersonService;		
	}
	
	public QueryListObj getGgPersonByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ggPersonService.getGgPersonByHql(hql, beginPage, pageSize, sql);
	}
	public GgPersonDto loadGgPerson(String ggPersonId){
		return this.ggPersonService.loadGgPerson(ggPersonId);
	}
	
	public QueryListObj getGgPersonByHql(String hql){
		return this.ggPersonService.getGgPersonByHql(hql);
	}
		

 /**
    * @business method list
	  */	
 
 
 
  
 
//please add your business methods start
	// to do it
//add your business method end
	
}
