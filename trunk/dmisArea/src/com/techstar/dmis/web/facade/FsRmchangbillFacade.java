package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IFsRmchangbillService;
import com.techstar.dmis.dto.FsRmchangbillDto;

    import com.techstar.dmis.dto.DdfsModechangelistDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class FsRmchangbillFacade {
	private IFsRmchangbillService fsRmchangbillService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listFsRmchangbill() {
		return fsRmchangbillService.listFsRmchangbill().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addFsRmchangbill(FsRmchangbillDto dto) {
		fsRmchangbillService.saveOrUpdateFsRmchangbill(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param FsRmchangbillId
	 *           ֵ

	 */
	public FsRmchangbillDto getFsRmchangbillById(String  fsRmchangbillId) {
		FsRmchangbillDto dto = fsRmchangbillService.loadFsRmchangbill(fsRmchangbillId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param FsRmchangbillId
	 *         ֵ

	 */
	public List deleteFsRmchangbill(String fsRmchangbillId) {
		fsRmchangbillService.deleteFsRmchangbill(fsRmchangbillId);
		return fsRmchangbillService.listFsRmchangbill().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteFsRmchangbill(List dtos) {
		fsRmchangbillService.deleteFsRmchangbill(dtos);
		return fsRmchangbillService.listFsRmchangbill().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listFsRmchangbill4dwr() {
		return fsRmchangbillService.listFsRmchangbill().getElemList();
	}

	public void setFsRmchangbillService(IFsRmchangbillService fsRmchangbillService) {
		this.fsRmchangbillService = fsRmchangbillService;		
	}
	
	public QueryListObj getFsRmchangbillByHql(String hql, int beginPage, int pageSize, String sql){
		return this.fsRmchangbillService.getFsRmchangbillByHql(hql, beginPage, pageSize, sql);
	}
	public FsRmchangbillDto loadFsRmchangbill(String fsRmchangbillId){
		return this.fsRmchangbillService.loadFsRmchangbill(fsRmchangbillId);
	}
	

		

 /**
    * @business method list
	 	* @拟定操作票
	 	* @电网实时方式分析单
	 	* @方式恢复
	 	* @执行完毕
	  */	
 
 
 
 	//注册子表facade方法
    	public DdfsModechangelistDto loadDdfsModechangelist(String fid){
		return this.fsRmchangbillService.loadDdfsModechangelist(fid);
	}
	
	public List deleteDdfsModechangelist(String fid) {
		fsRmchangbillService.deleteDdfsModechangelist(fid);
		return fsRmchangbillService.listDdfsModechangelist().getElemList();
	}
	public List deleteDdfsModechangelist(List dtos) {
		fsRmchangbillService.deleteDdfsModechangelist(dtos);
		return fsRmchangbillService.listDdfsModechangelist().getElemList();
	}
	public void addDdfsModechangelist(DdfsModechangelistDto dto) {
		fsRmchangbillService.saveOrUpdateDdfsModechangelist(dto);
	}

	 
 
//please add your business methods start
	// to do it
//add your business method end
	
}
