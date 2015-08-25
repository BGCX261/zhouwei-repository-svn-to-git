package com.techstar.dmis.web.facade;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.service.IDdDoutageplanService;
import com.techstar.dmis.dto.DdDoutageplanDto;

import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.dto.DdWoutageplanDto;
import com.techstar.dmis.dto.DdRepairdetailDto;
import com.techstar.dmis.dto.DdDayplandelaylistDto;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.dto.DayplancoopraterelDto;
import com.techstar.dmis.dto.DdDayplanfixvaluerelDto;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.dto.StdUnfinishreasonDto;
import com.techstar.dmis.entity.DdDayplandelaylist;
import com.techstar.dmis.entity.DdDayplanexcutelist;
import com.techstar.dmis.entity.DdfsModechangelist;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	
//please add your business methods start
	// to do it
//add your business method end

/**
 * facade类
 * @author 
 * @date
 */
public class DdDoutageplanFacade {
	private IDdDoutageplanService ddDoutageplanService;	
	//private IApplyService applyService;

	/**
	 * 得到列表数据
	 * 
	 * @return List
	 */
	public List listDdDoutageplan() {
		return ddDoutageplanService.listDdDoutageplan().getElemList();
	}

	/**
	 * 增加DTO
	 * 
	 * @param dto
	 */
	public void addDdDoutageplan(DdDoutageplanDto dto) {
		ddDoutageplanService.saveOrUpdateDdDoutageplan(dto);
	}

	/**
	 * 得到指定DTO
	 * 
	 * @param DdDoutageplanId
	 *           ֵ

	 */
	public DdDoutageplanDto getDdDoutageplanById(String  ddDoutageplanId) {
		DdDoutageplanDto dto = ddDoutageplanService.loadDdDoutageplan(ddDoutageplanId);
		return dto;
	}
	
	/**
	 * 删除指定DTO
	 * 
	 * @param DdDoutageplanId
	 *         ֵ

	 */
	public List deleteDdDoutageplan(String ddDoutageplanId) {
		ddDoutageplanService.deleteDdDoutageplan(ddDoutageplanId);
		return ddDoutageplanService.listDdDoutageplan().getElemList();
	}
	
	/**
	 * 删除指定DTO集合
	 */
	public List deleteDdDoutageplan(List dtos) {
		ddDoutageplanService.deleteDdDoutageplan(dtos);
		return ddDoutageplanService.listDdDoutageplan().getElemList();
	}
	public void deleteDdDoutageplan(DdDoutageplanDto dto){
		ddDoutageplanService.deleteDdDoutageplan(dto);
	}
	/**
	 * 得到业务对象列表
	 * @return List
	 */
	public List listDdDoutageplan4dwr() {
		return ddDoutageplanService.listDdDoutageplan().getElemList();
	}

	public void setDdDoutageplanService(IDdDoutageplanService ddDoutageplanService) {
		this.ddDoutageplanService = ddDoutageplanService;		
	}
	
	public QueryListObj getDdDoutageplanByHql(String hql, int beginPage, int pageSize, String sql){
		return this.ddDoutageplanService.getDdDoutageplanByHql(hql, beginPage, pageSize, sql);
	}
	public DdDoutageplanDto loadDdDoutageplan(String ddDoutageplanId){
		return this.ddDoutageplanService.loadDdDoutageplan(ddDoutageplanId);
	}
	
	public QueryListObj listDdDoutageplanByHql(String hql){
		return ddDoutageplanService.listDdDoutageplanByHql(hql);
	}
	
	public void saveOrUpdateDdDoutageplan(List dtos){
		ddDoutageplanService.saveOrUpdateDdDoutageplan(dtos);
	}
		
	public QueryListObj getElearlydate(String hql){
		return this.ddDoutageplanService.getElearlydate(hql);
	}
	public void saveOrUpdateDdDoutageplan(DdDoutageplanDto daydto,DdWoutageplanDto wdto,DdAccidentbriefDto ddacdto){
		this.ddDoutageplanService.saveOrUpdateDdDoutageplan(daydto, wdto, ddacdto);
	}
	/**
	 * 取消日计划
	 * @param wdto
	 * @param daydto
	 * @param monthedto
	 */
	public void cancleDdDoutageplan(WorkflowHandleDto wdto,DdDoutageplanDto daydto,DdWoutageplanDto monthedto){
		this.ddDoutageplanService.cancleDdDoutageplan(wdto, daydto, monthedto);
	}
	
	
	public void saveOrUpdateDdDoutageplan(List days,List wplans,List accidents){
		this.ddDoutageplanService.saveOrUpdateDdDoutageplan(days,wplans,accidents);
	}
 /**
    * @business method list
	 	* @日计划查看
	 	* @设备参数输入
	 	* @调度日计划延迟
	 	* @拟定操作票
	 	* @施工组数牌
	 	* @更新设备参数
	 	* @从间隔获得停电范围和设备列表
	 	* @盖取消章
	 	* @盖执行章
	 	* @回填故障
	 	* @计划配合
	 	* @日计划批准
	 	* @电网实时方式分析单
	 	* @调度员填写临时日计划
	  */	
 
 
 
 	//注册子表facade方法
	/*
    	public DdRepairdetailDto loadDdRepairdetail(String fid){
		return this.ddDoutageplanService.loadDdRepairdetail(fid);
	}
	
	public List deleteDdRepairdetail(String fid) {
		ddDoutageplanService.deleteDdRepairdetail(fid);
		return ddDoutageplanService.listDdRepairdetail().getElemList();
	}
	public List deleteDdRepairdetail(List dtos) {
		ddDoutageplanService.deleteDdRepairdetail(dtos);
		return ddDoutageplanService.listDdRepairdetail().getElemList();
	}
	public void addDdRepairdetail(DdRepairdetailDto dto) {
		ddDoutageplanService.saveOrUpdateDdRepairdetail(dto);
	}*/

		public DdDayplandelaylistDto loadDdDayplandelaylist(String fid){
		return this.ddDoutageplanService.loadDdDayplandelaylist(fid);
	}
	
	public List deleteDdDayplandelaylist(String fid) {
		ddDoutageplanService.deleteDdDayplandelaylist(fid);
		return ddDoutageplanService.listDdDayplandelaylist().getElemList();
	}
	/**************日计划延期****************/
	public void deleteDdDayplandelaylist(List dtos) {
		ddDoutageplanService.deleteDdDayplandelaylist(dtos);
		
	}
	public void addDdDayplandelaylist(DdDayplandelaylistDto dto) {
		ddDoutageplanService.saveOrUpdateDdDayplandelaylist(dto);
	}
	 public QueryListObj listDdDayplandelaylistByHql(String hql){
		 return ddDoutageplanService.listDdDayplandelaylistByHql(hql);
	   }
	   public void saveOrUpdateDdDayplandelaylist(List dtos){
	     
		   ddDoutageplanService.saveOrUpdateDdDayplandelaylist(dtos);
	   
	   }
	   /****************************************/
	   
	   
	   
	 
		public DdDayplanexcutelistDto loadDdDayplanexcutelist(String fid){
		return this.ddDoutageplanService.loadDdDayplanexcutelist(fid);
	}
	
	public List deleteDdDayplanexcutelist(String fid) {
		ddDoutageplanService.deleteDdDayplanexcutelist(fid);
		return ddDoutageplanService.listDdDayplanexcutelist().getElemList();
	}
	  /*******日计划执行*****************/
	public void deleteDdDayplanexcutelist(List dtos) {
		ddDoutageplanService.deleteDdDayplanexcutelist(dtos);
		
	}
	public void addDdDayplanexcutelist(DdDayplanexcutelistDto dto) {
		ddDoutageplanService.saveOrUpdateDdDayplanexcutelist(dto);
	}
	public QueryListObj listDdDayplanexcutelistByHql(String hql){
		   return ddDoutageplanService.listDdDayplanexcutelistByHql(hql);
	   }
	   public void saveOrUpdateDdDayplanexcutelist(List dtos){
		   ddDoutageplanService.saveOrUpdateDdDayplanexcutelist(dtos);
	   
	   }
		public DdfsModechangelistDto loadDdfsModechangelist(String fid){
		return this.ddDoutageplanService.loadDdfsModechangelist(fid);
	}
	/*****************************************/
	public List deleteDdfsModechangelist(String fid) {
		ddDoutageplanService.deleteDdfsModechangelist(fid);
		return ddDoutageplanService.listDdfsModechangelist().getElemList();
	}
	public void deleteDdfsModechangelist(List dtos) {
		ddDoutageplanService.deleteDdfsModechangelist(dtos);
	}
	public void addDdfsModechangelist(DdfsModechangelistDto dto) {
		ddDoutageplanService.saveOrUpdateDdfsModechangelist(dto);
	}

	
		  public QueryListObj listDdfsModechangelistByHql(String hql){
			  return ddDoutageplanService.listDdfsModechangelistByHql(hql);
		   }
		   public void saveOrUpdateDdfsModechangelist(List dtos){
			   ddDoutageplanService.saveOrUpdateDdfsModechangelist(dtos);
		   }
		   
		   
	//日计划配合
	public DayplancoopraterelDto loadDayplancoopraterel(String frelid){
				return this.ddDoutageplanService.loadDayplancoopraterel(frelid);
			  }
	public List deleteDayplancoopraterel(String frelid) {
		ddDoutageplanService.deleteDayplancoopraterel(frelid);
		return ddDoutageplanService.listDayplancoopraterel().getElemList();
	}
	public List deleteDayplancoopraterel(List dtos) {
		ddDoutageplanService.deleteDayplancoopraterel(dtos);
		return ddDoutageplanService.listDayplancoopraterel().getElemList();
	}
	public void addDayplancoopraterel(DayplancoopraterelDto dto) {
		ddDoutageplanService.saveOrUpdateDayplancoopraterel(dto);
	}

	 public QueryListObj listDayplancoopraterelByHql(String hql){
		 return ddDoutageplanService.listDayplancoopraterelByHql(hql);
	 }
	 public void joinDayplancoopraterel(String name,String date,String[] ids){
		  ddDoutageplanService.joinDayplancoopraterel(name, date, ids);
	 }
	 public void saveOrUpdateDayplancoopraterel(List dtos){
		 ddDoutageplanService.saveOrUpdateDayplancoopraterel(dtos);
	 }
	 public QueryListObj listDayplancoopraterelByGroupHql(String hql){
		 return ddDoutageplanService.listDayplancoopraterelByGroupHql(hql);
	 }
	 /*
		public DdDayplanfixvaluerelDto loadDdDayplanfixvaluerel(String frelid){
		return this.ddDoutageplanService.loadDdDayplanfixvaluerel(frelid);
	}
	
	public List deleteDdDayplanfixvaluerel(String frelid) {
		ddDoutageplanService.deleteDdDayplanfixvaluerel(frelid);
		return ddDoutageplanService.listDdDayplanfixvaluerel().getElemList();
	}
	public List deleteDdDayplanfixvaluerel(List dtos) {
		ddDoutageplanService.deleteDdDayplanfixvaluerel(dtos);
		return ddDoutageplanService.listDdDayplanfixvaluerel().getElemList();
	}
	public void addDdDayplanfixvaluerel(DdDayplanfixvaluerelDto dto) {
		ddDoutageplanService.saveOrUpdateDdDayplanfixvaluerel(dto);
	}*/

		public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid){
		return this.ddDoutageplanService.loadZdhOpexaminelist(examinationid);
	}
	
	public List deleteZdhOpexaminelist(String examinationid) {
		ddDoutageplanService.deleteZdhOpexaminelist(examinationid);
		return ddDoutageplanService.listZdhOpexaminelist().getElemList();
	}
	public List deleteZdhOpexaminelist(List dtos) {
		ddDoutageplanService.deleteZdhOpexaminelist(dtos);
		return ddDoutageplanService.listZdhOpexaminelist().getElemList();
	}
	public void addZdhOpexaminelist(ZdhOpexaminelistDto dto) {
		ddDoutageplanService.saveOrUpdateZdhOpexaminelist(dto);
	}

	
	/** ***********************工作流开始************************************************* */
	// 启动
	public int start(WorkflowHandleDto dto) {
		return ddDoutageplanService.start(dto);
	}

	// 计划专工整理计划
	public int ddDayPlanSpecArrange(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanSpecArrange(dto);

	}

	// 专工下发计划
	public int ddDayPlanSent(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanSent(dto);

	}

	// 填写计划执行情况
	public int ddDayPlanFillExec(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanFillExec(dto);

	}

	// 处理日计划并通知客户
	public int ddDayPlanInfocustomer(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanInfocustomer(dto);

	}

	// 客户中心进行日计划可否执行的批准操作
	public int ddDayPlanCustomerApprove(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanCustomerApprove(dto);

	}

	// 会签
	public int ddDayPlanCoursign(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanCoursign(dto);

	}

	// 计划专工归档
	public int ddDayPlanSpecKeepon(WorkflowHandleDto dto) {
		return ddDoutageplanService.ddDayPlanSpecKeepon(dto);
	}

	// please add your business methods start
	// to do it
	// add your business method end
	
}
