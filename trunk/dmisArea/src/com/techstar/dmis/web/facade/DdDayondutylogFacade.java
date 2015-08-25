package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdDayondutylogService;
import com.techstar.dmis.dto.DdDayondutylogDto;

    import com.techstar.dmis.dto.DdOperationnotebookDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdDayondutylogFacade {
	private IDdDayondutylogService ddDayondutylogService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdDayondutylog() {
		return ddDayondutylogService.listDdDayondutylog().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdDayondutylog(DdDayondutylogDto dto) {
		ddDayondutylogService.saveOrUpdateDdDayondutylog(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdDayondutylogId
	 *           ֵ

	 */
	public DdDayondutylogDto getDdDayondutylogById(String  ddDayondutylogId) {
		DdDayondutylogDto dto = ddDayondutylogService.loadDdDayondutylog(ddDayondutylogId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdDayondutylogId
	 *         ֵ

	 */
	public List deleteDdDayondutylog(String ddDayondutylogId) {
		ddDayondutylogService.deleteDdDayondutylog(ddDayondutylogId);
		return ddDayondutylogService.listDdDayondutylog().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdDayondutylog(List dtos) {
		ddDayondutylogService.deleteDdDayondutylog(dtos);
		return ddDayondutylogService.listDdDayondutylog().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdDayondutylog4dwr() {
		return ddDayondutylogService.listDdDayondutylog().getElemList();
	}

	public void setDdDayondutylogService(IDdDayondutylogService ddDayondutylogService) {
		this.ddDayondutylogService = ddDayondutylogService;		
	}
	
	public QueryListObj getDdDayondutylogByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddDayondutylogService.getDdDayondutylogByHql(hql, beginPage, pageSize, sql);
	}
	public DdDayondutylogDto loadDdDayondutylog(String ddDayondutylogId){
		return this.ddDayondutylogService.loadDdDayondutylog(ddDayondutylogId);
	}
	

		

 /**
    * @business method list
	  */	
 
 
 
 	//注册子表facade方法
    	public DdOperationnotebookDto loadDdOperationnotebook(String fid){
		return this.ddDayondutylogService.loadDdOperationnotebook(fid);
	}
	
	public List deleteDdOperationnotebook(String fid) {
		ddDayondutylogService.deleteDdOperationnotebook(fid);
		return ddDayondutylogService.listDdOperationnotebook().getElemList();
	}
	public List deleteDdOperationnotebook(List dtos) {
		ddDayondutylogService.deleteDdOperationnotebook(dtos);
		return ddDayondutylogService.listDdOperationnotebook().getElemList();
	}
	public void addDdOperationnotebook(DdOperationnotebookDto dto) {
		ddDayondutylogService.saveOrUpdateDdOperationnotebook(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
