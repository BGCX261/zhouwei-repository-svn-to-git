package com.techstar.dmis.web.facade;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.service.IDdSwitchseqbillService;
import com.techstar.dmis.dto.DdSwitchseqbillDto;

import com.techstar.dmis.dto.DdSeqbilldetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdSwitchseqbillFacade {
	private IDdSwitchseqbillService ddSwitchseqbillService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdSwitchseqbill() {
		return ddSwitchseqbillService.listDdSwitchseqbill().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdSwitchseqbill(DdSwitchseqbillDto dto) {
		ddSwitchseqbillService.saveOrUpdateDdSwitchseqbill(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdSwitchseqbillId
	 *           ֵ

	 */
	public DdSwitchseqbillDto getDdSwitchseqbillById(String  ddSwitchseqbillId) {
		DdSwitchseqbillDto dto = ddSwitchseqbillService.loadDdSwitchseqbill(ddSwitchseqbillId);
		return dto;
	}

	/**
	 * 删除指定DTO
	 * 
	 * @param DdSwitchseqbillId
	 *         ֵ

	 */
	public List deleteDdSwitchseqbill(String ddSwitchseqbillId) {
		ddSwitchseqbillService.deleteDdSwitchseqbill(ddSwitchseqbillId);
		return ddSwitchseqbillService.listDdSwitchseqbill().getElemList();
	}
	
	/**
	 * 删除指定DTO
	 * 
	 * @param DdSwitchseqbillId
	 *         ֵ

	 */
	public List deleteDdSwitchseqbill(String ddSwitchseqbillId,int version) {
		ddSwitchseqbillService.deleteDdSwitchseqbill(ddSwitchseqbillId,version);
		return ddSwitchseqbillService.listDdSwitchseqbill().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdSwitchseqbill(List dtos) {
		ddSwitchseqbillService.deleteDdSwitchseqbill(dtos);
		return ddSwitchseqbillService.listDdSwitchseqbill().getElemList();
	}
	
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdSwitchseqbill4dwr() {
		return ddSwitchseqbillService.listDdSwitchseqbill().getElemList();
	}

	public void setDdSwitchseqbillService(IDdSwitchseqbillService ddSwitchseqbillService) {
		this.ddSwitchseqbillService = ddSwitchseqbillService;		
	}
	
	public QueryListObj getDdSwitchseqbillByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddSwitchseqbillService.getDdSwitchseqbillByHql(hql, beginPage, pageSize, sql);
	}
	public DdSwitchseqbillDto loadDdSwitchseqbill(String ddSwitchseqbillId){
		return this.ddSwitchseqbillService.loadDdSwitchseqbill(ddSwitchseqbillId);
	}
	
	public void saveOrUpdateDdSwitchseqbill(List dtos){
		this.ddSwitchseqbillService.saveOrUpdateDdSwitchseqbill(dtos);
	}
	
	 public void deleteDdSeqbilldetail(DdSeqbilldetailDto dto){
		 ddSwitchseqbillService.deleteDdSeqbilldetail(dto);
	 }
	public String getMaxfmanualno(){
		return this.ddSwitchseqbillService.getMaxfmanualno();
	}
	   public int getMaxSerialno(String fcomputerno){
		   return this.getMaxSerialno(fcomputerno);
	   }
	   public void setSerialnoafterdelete(String fcomputerno, int serialno){
		   this.ddSwitchseqbillService.setSerialnoafterdelete(fcomputerno, serialno);
	   }
	   
	   public QueryListObj listDdSeqbilldetailByHql(String hql){
		   return this.ddSwitchseqbillService.listDdSeqbilldetailByHql(hql);
	   }
		
	   public void saveOrUpdateDdSeqbilldetail(List dtos){
		   this.ddSwitchseqbillService.saveOrUpdateDdSeqbilldetail(dtos);
	   }
	   
	   

 /**
    * @business method list
	 	* @合格情况核定
	 	* @盖执行章
	 	* @操作票终止
	 	* @从典型票输入
	  */	
 
	   /**
		 * 执行章
		 */
		 public void setexecutestatus(String fid){
			 this.ddSwitchseqbillService.setexecutestatus(fid);
		 }
		 /**
		  * 终止章
		  * @param fid
		  */
		 public void setStopStatus(String fid){
			this.ddSwitchseqbillService.setStopStatus(fid); 
		 }

 
 	//注册子表facade方法
    	public DdSeqbilldetailDto loadDdSeqbilldetail(String foperationstepno){
		return this.ddSwitchseqbillService.loadDdSeqbilldetail(foperationstepno);
	}
	
	public List deleteDdSeqbilldetail(String foperationstepno) {
		ddSwitchseqbillService.deleteDdSeqbilldetail(foperationstepno);
		return ddSwitchseqbillService.listDdSeqbilldetail().getElemList();
	}
	public List deleteDdSeqbilldetail(List dtos) {
		ddSwitchseqbillService.deleteDdSeqbilldetail(dtos);
		return ddSwitchseqbillService.listDdSeqbilldetail().getElemList();
	}
	public void addDdSeqbilldetail(DdSeqbilldetailDto dto) {
		ddSwitchseqbillService.saveOrUpdateDdSeqbilldetail(dto);
	}
	public void getSwitchbillsteps(String fcomputerno){
		ddSwitchseqbillService.getSwitchbillsteps(fcomputerno);
	}
	
	public void setswitchbillstopstatus(String fid){
		ddSwitchseqbillService.setswitchbillstopstatus(fid);
	}
	
	public void setswitchbillexestutas(String fid){
		ddSwitchseqbillService.setswitchbillexestutas(fid);
	}
	public void setcancelstatus(String fid){
		ddSwitchseqbillService.setcancelstatus(fid);
	}
	 
	   public void start(WorkflowHandleDto dto){
		   ddSwitchseqbillService.start(dto);
		   
	   }
	   public void ddSwitchseqBillApprove(WorkflowHandleDto dto){
		   ddSwitchseqbillService.ddSwitchseqBillApprove(dto);
	   }
	   public void ddSwitchseqBillExec(WorkflowHandleDto dto){
		   ddSwitchseqbillService.ddSwitchseqBillExec(dto);
	   }
	   public void ddSwitchseqBillModify(WorkflowHandleDto dto){
		   ddSwitchseqbillService.ddSwitchseqBillModify(dto);
	   }
//please add your business methods start
	// to do it
//add your business method end
	
}
