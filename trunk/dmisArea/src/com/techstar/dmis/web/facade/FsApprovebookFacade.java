package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IFsApprovebookService;
import com.techstar.dmis.dto.FsApprovebookDto;

    import com.techstar.dmis.dto.FsApprovebookdetailDto;
	import com.techstar.dmis.dto.FsAfrelDto;
	import com.techstar.dmis.dto.FsApproveeqprelDto;
	import com.techstar.dmis.dto.FsAllappendixDto;
	import com.techstar.dmis.dto.BhAsregulateDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class FsApprovebookFacade {
	private IFsApprovebookService fsApprovebookService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listFsApprovebook() {
		return fsApprovebookService.listFsApprovebook().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addFsApprovebook(FsApprovebookDto dto) {
		fsApprovebookService.saveOrUpdateFsApprovebook(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param FsApprovebookId
	 *           ֵ

	 */
	public FsApprovebookDto getFsApprovebookById(String  fsApprovebookId) {
		FsApprovebookDto dto = fsApprovebookService.loadFsApprovebook(fsApprovebookId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param FsApprovebookId
	 *         ֵ

	 */
	public List deleteFsApprovebook(String fsApprovebookId) {
		fsApprovebookService.deleteFsApprovebook(fsApprovebookId);
		return fsApprovebookService.listFsApprovebook().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteFsApprovebook(List dtos) {
		fsApprovebookService.deleteFsApprovebook(dtos);
		return fsApprovebookService.listFsApprovebook().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listFsApprovebook4dwr() {
		return fsApprovebookService.listFsApprovebook().getElemList();
	}

	public void setFsApprovebookService(IFsApprovebookService fsApprovebookService) {
		this.fsApprovebookService = fsApprovebookService;		
	}
	
	public QueryListObj getFsApprovebookByHql(String hql, int beginPage, int pageSize, String sql){
		return this.fsApprovebookService.getFsApprovebookByHql(hql, beginPage, pageSize, sql);
	}
	public FsApprovebookDto loadFsApprovebook(String fsApprovebookId){
		return this.fsApprovebookService.loadFsApprovebook(fsApprovebookId);
	}
	

		

 /**
    * @business method list
	 	* @拟定操作票
	 	* @自投规程导入
	 	* @发电批准书发布
	 	* @定值单导入
	 	* @发电批准书执行
	 	* @发电批准书上报
	 	* @设备参数上报
	 	* @批准书归档
	 	* @电网实时方式分析单
	 	* @编制系统图改图任务单
	  */	
 
 
 
 	//注册子表facade方法
    	public FsApprovebookdetailDto loadFsApprovebookdetail(String fapprovexcuteno){
		return this.fsApprovebookService.loadFsApprovebookdetail(fapprovexcuteno);
	}
	
	public List deleteFsApprovebookdetail(String fapprovexcuteno) {
		fsApprovebookService.deleteFsApprovebookdetail(fapprovexcuteno);
		return fsApprovebookService.listFsApprovebookdetail().getElemList();
	}
	public List deleteFsApprovebookdetail(List dtos) {
		fsApprovebookService.deleteFsApprovebookdetail(dtos);
		return fsApprovebookService.listFsApprovebookdetail().getElemList();
	}
	public void addFsApprovebookdetail(FsApprovebookdetailDto dto) {
		fsApprovebookService.saveOrUpdateFsApprovebookdetail(dto);
	}

		public FsAfrelDto loadFsAfrel(String fapprovfixrelno){
		return this.fsApprovebookService.loadFsAfrel(fapprovfixrelno);
	}
	
	public List deleteFsAfrel(String fapprovfixrelno) {
		fsApprovebookService.deleteFsAfrel(fapprovfixrelno);
		return fsApprovebookService.listFsAfrel().getElemList();
	}
	public List deleteFsAfrel(List dtos) {
		fsApprovebookService.deleteFsAfrel(dtos);
		return fsApprovebookService.listFsAfrel().getElemList();
	}
	public void addFsAfrel(FsAfrelDto dto) {
		fsApprovebookService.saveOrUpdateFsAfrel(dto);
	}

		public FsApproveeqprelDto loadFsApproveeqprel(String fappeqprelid){
		return this.fsApprovebookService.loadFsApproveeqprel(fappeqprelid);
	}
	
	public List deleteFsApproveeqprel(String fappeqprelid) {
		fsApprovebookService.deleteFsApproveeqprel(fappeqprelid);
		return fsApprovebookService.listFsApproveeqprel().getElemList();
	}
	public List deleteFsApproveeqprel(List dtos) {
		fsApprovebookService.deleteFsApproveeqprel(dtos);
		return fsApprovebookService.listFsApproveeqprel().getElemList();
	}
	public void addFsApproveeqprel(FsApproveeqprelDto dto) {
		fsApprovebookService.saveOrUpdateFsApproveeqprel(dto);
	}

		public FsAllappendixDto loadFsAllappendix(String f_id){
		return this.fsApprovebookService.loadFsAllappendix(f_id);
	}
	
	public List deleteFsAllappendix(String f_id) {
		fsApprovebookService.deleteFsAllappendix(f_id);
		return fsApprovebookService.listFsAllappendix().getElemList();
	}
	public List deleteFsAllappendix(List dtos) {
		fsApprovebookService.deleteFsAllappendix(dtos);
		return fsApprovebookService.listFsAllappendix().getElemList();
	}
	public void addFsAllappendix(FsAllappendixDto dto) {
		fsApprovebookService.saveOrUpdateFsAllappendix(dto);
	}

		public BhAsregulateDto loadBhAsregulate(String asregulateid){
		return this.fsApprovebookService.loadBhAsregulate(asregulateid);
	}
	
	public List deleteBhAsregulate(String asregulateid) {
		fsApprovebookService.deleteBhAsregulate(asregulateid);
		return fsApprovebookService.listBhAsregulate().getElemList();
	}
	public List deleteBhAsregulate(List dtos) {
		fsApprovebookService.deleteBhAsregulate(dtos);
		return fsApprovebookService.listBhAsregulate().getElemList();
	}
	public void addBhAsregulate(BhAsregulateDto dto) {
		fsApprovebookService.saveOrUpdateBhAsregulate(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
