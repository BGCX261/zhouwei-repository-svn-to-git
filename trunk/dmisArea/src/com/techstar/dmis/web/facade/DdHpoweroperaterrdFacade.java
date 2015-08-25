package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdHpoweroperaterrdService;
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdHpoweroperaterrdFacade {
	private IDdHpoweroperaterrdService ddHpoweroperaterrdService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdHpoweroperaterrd() {
		return ddHpoweroperaterrdService.listDdHpoweroperaterrd().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdHpoweroperaterrd(DdHpoweroperaterrdDto dto) {
		ddHpoweroperaterrdService.saveOrUpdateDdHpoweroperaterrd(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdHpoweroperaterrdId
	 *           ֵ

	 */
	public DdHpoweroperaterrdDto getDdHpoweroperaterrdById(String  ddHpoweroperaterrdId) {
		DdHpoweroperaterrdDto dto = ddHpoweroperaterrdService.loadDdHpoweroperaterrd(ddHpoweroperaterrdId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdHpoweroperaterrdId
	 *         ֵ

	 */
	public List deleteDdHpoweroperaterrd(String ddHpoweroperaterrdId) {
		ddHpoweroperaterrdService.deleteDdHpoweroperaterrd(ddHpoweroperaterrdId);
		return ddHpoweroperaterrdService.listDdHpoweroperaterrd().getElemList();
	}
	
	/**
	 * 删除指定DTO
	 * 
	 * @param DdHpoweroperaterrdId
	 *         ֵ

	 */
	public List deleteDdHpoweroperaterrd(String ddHpoweroperaterrdId,int version) {
		ddHpoweroperaterrdService.deleteDdHpoweroperaterrd(ddHpoweroperaterrdId,version);
		return ddHpoweroperaterrdService.listDdHpoweroperaterrd().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdHpoweroperaterrd4dwr() {
		return ddHpoweroperaterrdService.listDdHpoweroperaterrd().getElemList();
	}

	public void setDdHpoweroperaterrdService(IDdHpoweroperaterrdService ddHpoweroperaterrdService) {
		this.ddHpoweroperaterrdService = ddHpoweroperaterrdService;		
	}
	
	public QueryListObj getDdHpoweroperaterrdByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddHpoweroperaterrdService.getDdHpoweroperaterrdByHql(hql, beginPage, pageSize, sql);
	}
	public DdHpoweroperaterrdDto loadDdHpoweroperaterrd(String ddHpoweroperaterrdId){
		return this.ddHpoweroperaterrdService.loadDdHpoweroperaterrd(ddHpoweroperaterrdId);
	}
	

		

 /**
    * @business method list
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
