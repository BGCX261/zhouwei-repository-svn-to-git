package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Timestamp;
import java.sql.Date;

import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
import com.techstar.dmis.dto.ZdhWorkbillDto;
import com.techstar.dmis.entity.ZdhTransrecord;
import com.techstar.dmis.entity.ZdhWorkbill;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.IZdhMachineworklistService;
import com.techstar.dmis.service.IZdhWorkbillService;
import com.techstar.dmis.service.workflow.IDdEnsuringpsmanageWFService;
import com.techstar.dmis.service.workflow.IZdhWorkbillWFService;

import org.springframework.dao.DataAccessException;

//please add your business methods start
// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhWorkbillServiceImpl implements IZdhWorkbillService {
   //注册DAO
   private IZdhWorkbillDao zdhWorkbillDao;
   private IBaseJdbcDao baseJdbcDao ;
    // 注入机房工作的service
	private IZdhMachineworklistService zdhMachineworklistService;
	public void setZdhMachineworklistService(
			IZdhMachineworklistService zdhMachineworklistService) {
		this.zdhMachineworklistService = zdhMachineworklistService;
	}
  	//注册管理DAO
     private IZdhAutoondutylogDao zdhAutoondutylogDao;
	 public void setZdhAutoondutylogDao
	    (IZdhAutoondutylogDao zdhAutoondutylogDao) {
		 this.zdhAutoondutylogDao = zdhAutoondutylogDao;
     }
     private IEtsEquipmentDao etsEquipmentDao;
	 public void setEtsEquipmentDao
	    (IEtsEquipmentDao etsEquipmentDao) {
		 this.etsEquipmentDao = etsEquipmentDao;
     }
	  	
     //注册工作流

    private IZdhWorkbillWFService zdhWorkbillWFServiceImpl;
    //注册工作流服务
	public IZdhWorkbillWFService getZdhWorkbillWFServiceImpl() {
		return zdhWorkbillWFServiceImpl;
	}

	public void setZdhWorkbillWFServiceImpl(IZdhWorkbillWFService zdhWorkbillWFServiceImpl) {
		this.zdhWorkbillWFServiceImpl = zdhWorkbillWFServiceImpl;
	}
	public ZdhWorkbillServiceImpl() {}
	
	public void addZdhWorkbill(ZdhWorkbillDto dto) {
	
    	if (StringUtils.isEmpty(dto.getWorkbillid())){
		      if( StringUtils.isEmpty(dto.getWorkbillid())){
		          dto.setWorkbillid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		ZdhWorkbill zdhWorkbill = (ZdhWorkbill) BeanHelper.buildBean(ZdhWorkbill.class, dto);
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhWorkbill(ZdhWorkbillDto dto) {
		if (StringUtils.isEmpty(dto.getWorkbillid())){
		      if( StringUtils.isEmpty(dto.getWorkbillid())){
		          dto.setWorkbillid(new SequenceCreator().getUID());
		       }
		}
		ZdhWorkbill zdhWorkbill = (ZdhWorkbill) BeanHelper.mapBean(ZdhWorkbill.class, dto);
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
		//根据当前的工作票信息生成机房工作记录(只有审核通过后才可调用该方法,此处只做测试)
		this.genMachineworklist(dto);
	}
    //用于实现基本删除操作
	public void deleteZdhWorkbill(String zdhWorkbillId) {
		ZdhWorkbill zdhWorkbill = new ZdhWorkbill();
		zdhWorkbill.setWorkbillid(zdhWorkbillId);
		zdhWorkbillDao.delete(zdhWorkbill);
	}
   //用于实现基本DTOLOAD操作
	public ZdhWorkbillDto loadZdhWorkbill(String workbillid) {
		ZdhWorkbill zdhWorkbill = (ZdhWorkbill) zdhWorkbillDao.findByPk(workbillid);		
		ZdhWorkbillDto dto = (ZdhWorkbillDto) BeanHelper.mapBean(ZdhWorkbillDto.class, zdhWorkbill);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhWorkbill() {
		QueryListObj obj = zdhWorkbillDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhWorkbillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhWorkbillByHql(String hql) {
		QueryListObj obj = zdhWorkbillDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhWorkbill.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhWorkbillByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhWorkbillDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhWorkbill.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhWorkbillDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
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
	
	public IZdhWorkbillDao getZdhWorkbillDao() {
		return zdhWorkbillDao;
	}

	public void setZdhWorkbillDao(IZdhWorkbillDao zdhWorkbillDao) {
		this.zdhWorkbillDao = zdhWorkbillDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhWorkbill(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhWorkbillDto zdhWorkbillDto = (ZdhWorkbillDto)dtos.get(i);
			ZdhWorkbill zdhWorkbill = (ZdhWorkbill) BeanHelper.buildBean(ZdhWorkbill.class, zdhWorkbillDto);
		    pos.add(zdhWorkbill);
		}
		
		zdhWorkbillDao.saveOrUpdateAll(pos);	
	}
    
	/**
	 * 提取当前的班号
	 */
	public String getOndutyno(){
		//定义hql，以“接班时间”最大的为查询条件
		String hql = "select a.ondutyno from ZdhAutoondutylog a where a.successiontime = (select max(b.successiontime)  from ZdhAutoondutylog b)";
		QueryListObj obj = zdhWorkbillDao.getQueryListByHql(hql);
		if (obj == null) { 
			return "";
		}
		List list = obj.getElemList();
		if (list == null || list.size() < 1){
			return "";
		}
		//提取当前的班号
		String ondutyno = (String)list.iterator().next();
		//System.out.println("当前的班号:"+ondutyno);
		return ondutyno;
	}
	/**
     * 根据当前的工作票信息生成机房工作记录,只有审核通过后才可调用该方法
     * @param zdhWorkbillDto
     * @author sbt 2007-4-13 
     */
	public void genMachineworklist(ZdhWorkbillDto zdhWorkbillDto){
		ZdhMachineworklistDto zdhMachineworklistDto = new ZdhMachineworklistDto();
        //工作时间
		java.sql.Date worktime = zdhWorkbillDto.getWorktime();
        //申请单位
		String applicationunit = zdhWorkbillDto.getApplicationunit();
		//工作内容
		String workcontent = zdhWorkbillDto.getWorkcontent();
		//纪事内容
		String content = "申请单位:"+applicationunit+"   工作内容:"+workcontent;
        //工作类型
		String jobcategory = "工作票";
        //完成状态
		String fexcutestatus = "工作票状态";
		//工作来源(工作票的主键值)
		String workingsources = zdhWorkbillDto.getWorkbillid();
		//获取当前班号
		String ondutyno = this.getOndutyno();
		
		zdhMachineworklistDto.setContent(content);//纪事内容
		zdhMachineworklistDto.setFexcutestatus(fexcutestatus);//完成状态
		//zdhMachineworklistDto.setWorkingtime(worktime);//工作时间
		zdhMachineworklistDto.setJobcategory(jobcategory);//工作类型
		zdhMachineworklistDto.setWorkingsources(workingsources);//工作来源
		zdhMachineworklistDto.setVersion(0);  //版本
		zdhMachineworklistDto.setSys_isvalid(0); //有效字段
        //增加班号
		System.out.println("设置当前班号:"+ondutyno);
		zdhMachineworklistDto.setZzdhmachineworklist1(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
		zdhMachineworklistDto.getZzdhmachineworklist1().setOndutyno(ondutyno);
		//数据所属单位
		zdhMachineworklistDto.setSys_dataowner(zdhWorkbillDto.getSys_dataowner());
		//填单部门
		zdhMachineworklistDto.setSys_filldept(zdhWorkbillDto.getSys_filldept());
		//填单人
		zdhMachineworklistDto.setSys_fille(zdhWorkbillDto.getSys_fille());
		//填写时间
		zdhMachineworklistDto.setSys_filltime(zdhWorkbillDto.getSys_filltime());
		
		zdhMachineworklistService.addZdhMachineworklist(zdhMachineworklistDto);
	}
    /**
     * 修改相关的机房工作记录为"工作票状态"
     */	
	public void updateMachineworklistStatus(){
		ZdhMachineworklistDto zdhMachineworklistDto = new ZdhMachineworklistDto();
		//zdhMachineworklistDto.set
	}
	//用于实现基本删除集合操作
	public void deleteZdhWorkbill(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.buildBeans(ZdhWorkbill.class, dtos);
		zdhWorkbillDao.deleteAll(pos);
	}
	
    /**
     * 启动
     */
	public void start(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = zdhWorkbillWFServiceImpl.start(dto);	    
		ZdhWorkbill zdhWorkbill = zdhWorkbillDao.findByPk(dto.getBusId());
		//将流转状态、业务状态改为运维中心主任签发
		zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_YWZRINK);
		zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVED);
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
    }
    /**
     * 运维中心主任签发
     */
	public void zdhworkbillCenterApprove(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn =  zdhWorkbillWFServiceImpl.zdhworkbillCenterApprove(dto);
		ZdhWorkbill zdhWorkbill = zdhWorkbillDao.findByPk(dto.getBusId());
		
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1: 
				//不通过,将流转状态工作票修改
				zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_XKRINK);
				zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVED);
				break;
			case 1:
				//通过,将流转状态、业务状态改为许可人签字
				zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_XKRINK);
				zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVED);
				break;
		}
		
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
	}
    
    /**
     * 许可人签字
     */
	public void zdhworkbillPermit(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn =  zdhWorkbillWFServiceImpl.zdhworkbillPermit(dto);
		ZdhWorkbill zdhWorkbill = zdhWorkbillDao.findByPk(dto.getBusId());
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
		   case -1: 
               //不通过,将流转状态工作票修改			   
			   zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_MODIFY);
			   zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVED);
			   break;
		   case 1:
			   //将流转状态、业务状态改为工作负责人签字
			   zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_GZFZRINK);
				zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_APPROVED);
			   break;
		}
		
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
	}

    /**
     * 工作负责人签字(归档)
     */
	public void zdhworkbillWorkerSign(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn =  zdhWorkbillWFServiceImpl.zdhworkbillWorkerSign(dto);
		ZdhWorkbill zdhWorkbill = zdhWorkbillDao.findByPk(dto.getBusId());
		//将流转状态、业务状态改为归档
		zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_OVER);
		zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_KEEPONED);
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
	}

    /**
     * 工作票修改
     */
	public void zdhworkbillModify(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn =  zdhWorkbillWFServiceImpl.zdhworkbillModify(dto);
		ZdhWorkbill zdhWorkbill = zdhWorkbillDao.findByPk(dto.getBusId());
		//将流转状态、业务状态改为草稿
		zdhWorkbill.setFstatus(ZdhConstants.ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW);
		zdhWorkbill.setFexcutestatus(ZdhConstants.ZdhWorkbill_BUSINESS_CITY_NEW);
		zdhWorkbillDao.saveOrUpdate(zdhWorkbill);
	}

	
}
