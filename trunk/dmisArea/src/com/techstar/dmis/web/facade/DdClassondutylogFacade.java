package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdClassondutylogService;
import com.techstar.dmis.dto.DdClassondutylogDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.DdOperationnotebookDto;

/**
 * facade类
 * @author 
 * @date
 */
public class DdClassondutylogFacade {
	private IDdClassondutylogService ddClassondutylogService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdClassondutylog() {
		return ddClassondutylogService.listDdClassondutylog().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdClassondutylog(DdClassondutylogDto dto) {
		ddClassondutylogService.saveOrUpdateDdClassondutylog(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdClassondutylogId
	 *           ֵ

	 */
	public DdClassondutylogDto getDdClassondutylogById(String  ddClassondutylogId) {
		DdClassondutylogDto dto = ddClassondutylogService.loadDdClassondutylog(ddClassondutylogId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdClassondutylogId
	 *         ֵ

	 */
	public List deleteDdClassondutylog(String ddClassondutylogId) {
		ddClassondutylogService.deleteDdClassondutylog(ddClassondutylogId);
		return ddClassondutylogService.listDdClassondutylog().getElemList();
	}
	/**
	 * 删除指定DTO
	 * 
	 * @param DdClassondutylogId
	 *  @param version       ֵ

	 */
	public List deleteDdClassondutylog(String ddClassondutylogId,int version) {
		ddClassondutylogService.deleteDdClassondutylog(ddClassondutylogId,version);
		return ddClassondutylogService.listDdClassondutylog().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdClassondutylog4dwr() {
		return ddClassondutylogService.listDdClassondutylog().getElemList();
	}

	public void setDdClassondutylogService(IDdClassondutylogService ddClassondutylogService) {
		this.ddClassondutylogService = ddClassondutylogService;		
	}
	public QueryListObj listDdClassondutylogByHql(String hql){
		return this.ddClassondutylogService.listDdClassondutylogByHql(hql);
	}
	public QueryListObj getDdClassondutylogByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddClassondutylogService.getDdClassondutylogByHql(hql, beginPage, pageSize, sql);
	}
	public DdClassondutylogDto loadDdClassondutylog(String ddClassondutylogId){
		return this.ddClassondutylogService.loadDdClassondutylog(ddClassondutylogId);
	}
	
	/**运行记事**/
	public QueryListObj listDdOperationnotebook(){
		return this.ddClassondutylogService.listDdOperationnotebook();
	}
	public void saveOrUpdateDdSeqbilldetail(DdOperationnotebookDto dto){
		this.ddClassondutylogService.saveOrUpdateDdSeqbilldetail(dto);
	}
	public void deleteDdOperationnotebook(String fid,int version){
		this.ddClassondutylogService.deleteDdOperationnotebook(fid,version);
	}
	public void deleteDdOperationnotebook(DdOperationnotebookDto dto){
		this.ddClassondutylogService.deleteDdOperationnotebook(dto);
	}
	public DdOperationnotebookDto loadDdOperationnotebook(String fid){
		return this.ddClassondutylogService.loadDdOperationnotebook(fid);
	}
	public QueryListObj listDdOperationnotebookByHql(String hql){
		return this.ddClassondutylogService.listDdOperationnotebookByHql(hql);
	}
	public void saveOrUpdateDdOperationnotebook(List dtos){
		this.ddClassondutylogService.saveOrUpdateDdOperationnotebook(dtos);
	}
	public void deleteDdOperationnotebook(List dtos){
		this.ddClassondutylogService.deleteDdOperationnotebook(dtos);
	}
	
	public QueryListObj getDdOperationnotebookByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddClassondutylogService.getDdOperationnotebookByHql(hql, beginPage, pageSize, sql);
	}
	
	/**end**/
	
	//	获得最新的班志
	public DdClassondutylogDto getLogNo(){

		return this.ddClassondutylogService.getLogNo();
		 
	}
	

		

 /**
    * @business method list
	 	* @按照指定的格式生成打印预览文件
	  */	
//please add your business methods start
	// to do it
//add your business method end
	
}
