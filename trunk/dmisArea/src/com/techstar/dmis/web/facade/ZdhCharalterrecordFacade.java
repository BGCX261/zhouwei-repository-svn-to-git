package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhCharalterrecordService;
import com.techstar.dmis.dto.ZdhCharalterrecordDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhCharalterrecordFacade {
	private IZdhCharalterrecordService zdhCharalterrecordService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhCharalterrecord() {
		return zdhCharalterrecordService.listZdhCharalterrecord().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhCharalterrecord(ZdhCharalterrecordDto dto) {
		zdhCharalterrecordService.saveOrUpdateZdhCharalterrecord(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhCharalterrecordId
	 *           ֵ

	 */
	public ZdhCharalterrecordDto getZdhCharalterrecordById(String  zdhCharalterrecordId) {
		ZdhCharalterrecordDto dto = zdhCharalterrecordService.loadZdhCharalterrecord(zdhCharalterrecordId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhCharalterrecordId
	 *         ֵ

	 */
	public void deleteZdhCharalterrecord(String zdhCharalterrecordId,int version) {
		zdhCharalterrecordService.deleteZdhCharalterrecord(zdhCharalterrecordId,version);
		//return zdhCharalterrecordService.listZdhCharalterrecord().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhCharalterrecord4dwr() {
		return zdhCharalterrecordService.listZdhCharalterrecord().getElemList();
	}

	public void setZdhCharalterrecordService(IZdhCharalterrecordService zdhCharalterrecordService) {
		this.zdhCharalterrecordService = zdhCharalterrecordService;		
	}
	
	public QueryListObj getZdhCharalterrecordByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhCharalterrecordService.getZdhCharalterrecordByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhCharalterrecordDto loadZdhCharalterrecord(String zdhCharalterrecordId){
		return this.zdhCharalterrecordService.loadZdhCharalterrecord(zdhCharalterrecordId);
	}
	

	public ZdhCharalterrecordDto getZdhCharRecordByForeign(String foreignId){
		return zdhCharalterrecordService.getZdhCharRecordByForeign(foreignId);
	}

 /**
    * @business method list
	 	* @遥测数据修改
	 	* @关联批准书查询
	  */	
//please add your business methods start
	// to do it
//add your business method end
//	启动
	public void start(WorkflowHandleDto dto) throws DataAccessException {
		zdhCharalterrecordService.start(dto);
	}
	
//	调度室领导签字
	public void zdhCharalterrecordSign(WorkflowHandleDto dto) throws DataAccessException {
		zdhCharalterrecordService.zdhCharalterrecordSign(dto);
	}
	
//	盖执行章
	public void zdhCharalterrecordExec(WorkflowHandleDto dto) throws DataAccessException {
		zdhCharalterrecordService.zdhCharalterrecordExec(dto);
	}
	
//	运维中心任务分配
	public void zdhCharalterrecordAssign(WorkflowHandleDto dto) throws DataAccessException {
		zdhCharalterrecordService.zdhCharalterrecordAssign(dto);
	}
	
//	调度审核
	public void zdhCharalterrecordApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhCharalterrecordService.zdhCharalterrecordApprove(dto);
	}
	
//	图形和数据会签处理
	public void zdhCharalterrecordCoursign(WorkflowHandleDto dto) throws DataAccessException {
		zdhCharalterrecordService.zdhCharalterrecordCoursign(dto);
	}
}
