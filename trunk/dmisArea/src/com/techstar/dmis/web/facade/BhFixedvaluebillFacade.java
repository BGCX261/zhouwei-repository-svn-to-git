package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IBhFixedvaluebillService;
import com.techstar.dmis.dto.BhFixedvaluebillDto;

    import com.techstar.dmis.dto.BhFixedvaluebilldetailDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class BhFixedvaluebillFacade {
	private IBhFixedvaluebillService bhFixedvaluebillService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listBhFixedvaluebill() {
		return bhFixedvaluebillService.listBhFixedvaluebill().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addBhFixedvaluebill(BhFixedvaluebillDto dto) {
		bhFixedvaluebillService.saveOrUpdateBhFixedvaluebill(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param BhFixedvaluebillId
	 *           ֵ

	 */
	public BhFixedvaluebillDto getBhFixedvaluebillById(String  bhFixedvaluebillId) {
		BhFixedvaluebillDto dto = bhFixedvaluebillService.loadBhFixedvaluebill(bhFixedvaluebillId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param BhFixedvaluebillId
	 *         ֵ

	 */
	public List deleteBhFixedvaluebill(String bhFixedvaluebillId) {
		bhFixedvaluebillService.deleteBhFixedvaluebill(bhFixedvaluebillId);
		return bhFixedvaluebillService.listBhFixedvaluebill().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteBhFixedvaluebill(List dtos) {
		bhFixedvaluebillService.deleteBhFixedvaluebill(dtos);
		return bhFixedvaluebillService.listBhFixedvaluebill().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listBhFixedvaluebill4dwr() {
		return bhFixedvaluebillService.listBhFixedvaluebill().getElemList();
	}

	public void setBhFixedvaluebillService(IBhFixedvaluebillService bhFixedvaluebillService) {
		this.bhFixedvaluebillService = bhFixedvaluebillService;		
	}
	
	public QueryListObj getBhFixedvaluebillByHql(String hql, int beginPage, int pageSize, String sql){
		return this.bhFixedvaluebillService.getBhFixedvaluebillByHql(hql, beginPage, pageSize, sql);
	}
	public BhFixedvaluebillDto loadBhFixedvaluebill(String bhFixedvaluebillId){
		return this.bhFixedvaluebillService.loadBhFixedvaluebill(bhFixedvaluebillId);
	}
	

		

 /**
    * @business method list
	 	* @从设备台帐取值
	 	* @归档并作废旧定值
	  */	
 
 
 
 	//注册子表facade方法
    	public BhFixedvaluebilldetailDto loadBhFixedvaluebilldetail(String serialno){
		return this.bhFixedvaluebillService.loadBhFixedvaluebilldetail(serialno);
	}
	
	public List deleteBhFixedvaluebilldetail(String serialno) {
		bhFixedvaluebillService.deleteBhFixedvaluebilldetail(serialno);
		return bhFixedvaluebillService.listBhFixedvaluebilldetail().getElemList();
	}
	public List deleteBhFixedvaluebilldetail(List dtos) {
		bhFixedvaluebillService.deleteBhFixedvaluebilldetail(dtos);
		return bhFixedvaluebillService.listBhFixedvaluebilldetail().getElemList();
	}
	public void addBhFixedvaluebilldetail(BhFixedvaluebilldetailDto dto) {
		bhFixedvaluebillService.saveOrUpdateBhFixedvaluebilldetail(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
