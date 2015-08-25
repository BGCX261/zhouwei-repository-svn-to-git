package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IZdhMachineworklistService;
import com.techstar.dmis.service.IZdhWorkbillService;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
import com.techstar.dmis.dto.ZdhWorkbillDto;
//please add your business methods start
// to do it
//add your business method end
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

/**
 * facade类
 * @author 
 * @date
 */
public class ZdhWorkbillFacade {
	private IZdhWorkbillService zdhWorkbillService;	
		
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listZdhWorkbill() {
		return zdhWorkbillService.listZdhWorkbill().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addZdhWorkbill(ZdhWorkbillDto dto) {
		zdhWorkbillService.saveOrUpdateZdhWorkbill(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param ZdhWorkbillId
	 *           ֵ

	 */
	public ZdhWorkbillDto getZdhWorkbillById(String  zdhWorkbillId) {
		ZdhWorkbillDto dto = zdhWorkbillService.loadZdhWorkbill(zdhWorkbillId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param ZdhWorkbillId
	 *         ֵ

	 */
	public List deleteZdhWorkbill(String zdhWorkbillId) {
		zdhWorkbillService.deleteZdhWorkbill(zdhWorkbillId);
		return zdhWorkbillService.listZdhWorkbill().getElemList();
	}

	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listZdhWorkbill4dwr() {
		return zdhWorkbillService.listZdhWorkbill().getElemList();
	}

	public void setZdhWorkbillService(IZdhWorkbillService zdhWorkbillService) {
		this.zdhWorkbillService = zdhWorkbillService;		
	}
	
	public QueryListObj getZdhWorkbillByHql(String hql, int beginPage, int pageSize, String sql){
		return this.zdhWorkbillService.getZdhWorkbillByHql(hql, beginPage, pageSize, sql);
	}
	public ZdhWorkbillDto loadZdhWorkbill(String zdhWorkbillId){
		return this.zdhWorkbillService.loadZdhWorkbill(zdhWorkbillId);
	}
	
	

	/**
	 * 获取当前的班号
	 * @return
	 */
	public String getOndutyno(){
		return this.zdhWorkbillService.getOndutyno();
	}
    
	/**
	 * 删除指定DTO集合
	 */
	public List deleteZdhWorkbill(List dtos) {
		zdhWorkbillService.deleteZdhWorkbill(dtos);

		return zdhWorkbillService.listZdhWorkbill().getElemList();
	}
	
 /**
    * @business method list
 	* @写入机房工作
 	* @合格情况核定
 	* @盖工作票执行章
  */	
//please add your business methods start
	// to do it
//add your business method end
	/**
     * 启动
     */
	public void start(WorkflowHandleDto dto) throws DataAccessException {
	    zdhWorkbillService.start(dto);
    }
    /**
     * 运维中心主任签发
     */
	public void zdhworkbillCenterApprove(WorkflowHandleDto dto) throws DataAccessException {
		zdhWorkbillService.zdhworkbillCenterApprove(dto);
	}
    
    /**
     * 许可人签字
     */
	public void zdhworkbillPermit(WorkflowHandleDto dto) throws DataAccessException {
		zdhWorkbillService.zdhworkbillPermit(dto);
	}

    /**
     * 工作负责人签字
     */
	public void zdhworkbillWorkerSign(WorkflowHandleDto dto) throws DataAccessException {
		zdhWorkbillService.zdhworkbillWorkerSign(dto);
	}

    /**
     * 工作票修改
     */
	public void zdhworkbillModify(WorkflowHandleDto dto) throws DataAccessException {
		zdhWorkbillService.zdhworkbillModify(dto);
	}
}
