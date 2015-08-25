package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;

import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.dto.ZdhSrapplicationDto;
import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.entity.CtrlWflentityrel;
import com.techstar.dmis.entity.ZdhSrapplication;
import com.techstar.dmis.service.IZdhSrapplicationService;
import com.techstar.dmis.service.IZdhTransrecordService;


import com.techstar.dmis.service.workflow.IZdhSrapplicationWFService;
import com.techstar.dmis.service.workflow.IZdhWorkbillWFService;

import org.springframework.dao.DataAccessException;
//消息处理
import com.techstar.exchange.convert.*;
import com.techstar.exchange.dto.control.AttachmentDto;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.*;

import com.techstar.dmis.util.*;
//注册子表DAO
import com.techstar.dmis.dto.ZdhSrappeqprelDto;
import com.techstar.dmis.entity.ZdhSrappeqprel;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
	
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class ZdhSrapplicationServiceImpl implements IZdhSrapplicationService {
   //注册DAO
   private IZdhSrapplicationDao zdhSrapplicationDao;
   private IBaseJdbcDao baseJdbcDao;
   
  	//注册管理DAO
    	 private IZdhSrappeqprelDao zdhSrappeqprelDao;
	 public void setZdhSrappeqprelDao
	    (IZdhSrappeqprelDao zdhSrappeqprelDao) {
		 this.zdhSrappeqprelDao = zdhSrappeqprelDao;
     }
	  	
	//注册工作流
    private IZdhSrapplicationWFService zdhSrapplicationWFServiceImpl;
    
	public IZdhSrapplicationWFService getZdhSrapplicationWFServiceImpl() {
		return zdhSrapplicationWFServiceImpl;
	}

	public void setZdhSrapplicationWFServiceImpl(IZdhSrapplicationWFService zdhSrapplicationWFServiceImpl) {
		this.zdhSrapplicationWFServiceImpl = zdhSrapplicationWFServiceImpl;
	}
    //注册传动记录service
	IZdhTransrecordService zdhTransrecordService;
	
	public IZdhTransrecordService getZdhTransrecordService() {
		return zdhTransrecordService;
	}

	public void setZdhTransrecordService(
			IZdhTransrecordService zdhTransrecordService) {
		this.zdhTransrecordService = zdhTransrecordService;
	}
    //注册停复役与传动记录的对应关系
	ICtrlWflentityrelDao ctrlWflentityrelDao;
	
	public ICtrlWflentityrelDao getCtrlWflentityrelDao() {
		return ctrlWflentityrelDao;
	}

	public void setCtrlWflentityrelDao(ICtrlWflentityrelDao ctrlWflentityrelDao) {
		this.ctrlWflentityrelDao = ctrlWflentityrelDao;
	}

	public ZdhSrapplicationServiceImpl() {}
	/**
	 * 保存新增的数据
	 */
	public void addZdhSrapplication(ZdhSrapplicationDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFapplicationno())){
		      if( StringUtils.isEmpty(dto.getFapplicationno())){
		          dto.setFapplicationno(new SequenceCreator().getUID());
		       }
		}
    	//将数据所属单位修改为DMIS_ZD_STD_DISPATCHUNIT表中的ESHIRTNAME英文简称
    	String dataOwnerName = dto.getSys_dataowner();
    	String eshirtname = this.getDataOwner(dataOwnerName);
    	dto.setSys_dataowner(eshirtname);
    	//新增时候,主对象不用管子对象的保存
		ZdhSrapplication zdhSrapplication = (ZdhSrapplication) BeanHelper.buildBean(ZdhSrapplication.class, dto);
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateZdhSrapplication(ZdhSrapplicationDto dto) {
		if (StringUtils.isEmpty(dto.getFapplicationno())){
		      if( StringUtils.isEmpty(dto.getFapplicationno())){
		          dto.setFapplicationno(new SequenceCreator().getUID());
		       }
		}
		//将数据所属单位修改为DMIS_ZD_STD_DISPATCHUNIT表中的ESHIRTNAME英文简称
    	String dataOwnerName = dto.getSys_dataowner();
    	String eshirtname = this.getDataOwner(dataOwnerName);
    	dto.setSys_dataowner(eshirtname);
    	
		ZdhSrapplication zdhSrapplication = (ZdhSrapplication) BeanHelper.buildBean(ZdhSrapplication.class, dto);
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
		
		//生成传动记录(要在)
		//this.genTransrecord(dto);
	}
    //用于实现基本删除操作
	public void deleteZdhSrapplication(String zdhSrapplicationId) {
		ZdhSrapplication zdhSrapplication = new ZdhSrapplication();
		zdhSrapplication.setFapplicationno(zdhSrapplicationId);
		zdhSrapplicationDao.delete(zdhSrapplication);
	}
	//用于实现基本删除集合操作
	public void deleteZdhSrapplication(List dtos){
		List pos = new ArrayList();
		pos = (List)BeanHelper.mapBeans(ZdhSrapplication.class, dtos);
		zdhSrapplicationDao.deleteAll(pos);			
	}	
   //用于实现基本DTOLOAD操作
	public ZdhSrapplicationDto loadZdhSrapplication(String fapplicationno) {
		ZdhSrapplication zdhSrapplication = (ZdhSrapplication) zdhSrapplicationDao.findByPk(fapplicationno);
		ZdhSrapplicationDto dto = (ZdhSrapplicationDto) BeanHelper.buildBean(ZdhSrapplicationDto.class, zdhSrapplication);
		return dto;
	}
   //用于实现列表操作
   public QueryListObj listZdhSrapplication() {
		QueryListObj obj = zdhSrapplicationDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSrapplicationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listZdhSrapplicationByHql(String hql) {
		QueryListObj obj = zdhSrapplicationDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSrapplicationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getZdhSrapplicationByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = zdhSrapplicationDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSrapplicationDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = zdhSrapplicationDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	 	* @申请单执行完成
	 	* @审批意见下发
	 	* @报上级调度
	 	* @停复役申请归档
	 	* @从设备台帐选择多台设备
	    */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IZdhSrapplicationDao getZdhSrapplicationDao() {
		return zdhSrapplicationDao;
	}

	public void setZdhSrapplicationDao(IZdhSrapplicationDao zdhSrapplicationDao) {
		this.zdhSrapplicationDao = zdhSrapplicationDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateZdhSrapplication(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhSrapplicationDto zdhSrapplicationDto = (ZdhSrapplicationDto)dtos.get(i);
			ZdhSrapplication zdhSrapplication = (ZdhSrapplication) BeanHelper.buildBean(ZdhSrapplication.class, zdhSrapplicationDto);
		    pos.add(zdhSrapplication);
		}
		
		zdhSrapplicationDao.saveOrUpdateAll(pos);	
		//生成传动记录
		/*for(int i=0;i<dtos.size();i++){
			ZdhSrapplicationDto zdhSrapplicationDto = (ZdhSrapplicationDto)dtos.get(i);
			this.genTransrecord(zdhSrapplicationDto);
		}
		*/
		
	}
	
		
	
	 	//子表处理DAO
    	

   public QueryListObj listZdhSrappeqprel() {
		QueryListObj obj = zdhSrappeqprelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSrappeqprelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
		
	
   public void saveOrUpdateZdhSrappeqprel(ZdhSrappeqprelDto dto){
   
     if (StringUtils.isEmpty(dto.getFid())){
		      if( StringUtils.isEmpty(dto.getFid())){
		          dto.setFid(new SequenceCreator().getUID());
		       }
		}
		ZdhSrappeqprel zdhSrappeqprel = (ZdhSrappeqprel) BeanHelper.buildBean(ZdhSrappeqprel.class, dto);
		zdhSrappeqprelDao.saveOrUpdate(zdhSrappeqprel);
   
   }
   public void deleteZdhSrappeqprel(String fid){
     
        ZdhSrappeqprel zdhSrappeqprel = new ZdhSrappeqprel();
		zdhSrappeqprel.setFid(fid);
		zdhSrappeqprelDao.delete(zdhSrappeqprel);
   
   }
   public ZdhSrappeqprelDto loadZdhSrappeqprel(String fid){
        ZdhSrappeqprel zdhSrappeqprel = (ZdhSrappeqprel) zdhSrappeqprelDao.findByPk(fid);
		ZdhSrappeqprelDto dto = (ZdhSrappeqprelDto) BeanHelper.buildBean(ZdhSrappeqprelDto.class, zdhSrappeqprel);
		return dto;
   }
   public QueryListObj listZdhSrappeqprelByHql(String hql){
      QueryListObj obj = zdhSrappeqprelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhSrappeqprelDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
   }
   public void saveOrUpdateZdhSrappeqprel(List dtos){
     
   List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			ZdhSrappeqprelDto zdhSrappeqprelDto = (ZdhSrappeqprelDto)dtos.get(i);
			ZdhSrappeqprel zdhSrappeqprel = (ZdhSrappeqprel) BeanHelper.buildBean(ZdhSrappeqprel.class, zdhSrappeqprelDto);
		    pos.add(zdhSrappeqprel);
		}
		
		zdhSrappeqprelDao.saveOrUpdateAll(pos);	
   
   }
   
   public void deleteZdhSrappeqprel(List dtos){
      List pos = new ArrayList();
	  pos = (List)BeanHelper.buildBean(ZdhSrappeqprel.class, dtos);
	  zdhSrappeqprelDao.deleteAll(pos);
   }
   /**
    * 根据数据所属单位名称获取数据所属单位的缩写
    * 即在表DMIS_ZD_STD_DISPATCHUNIT中,根据UNITNAME的值获取ESHIRTNAME的值
    * @param dataownerName
    * @return
    */
   public String getDataOwner(String dataownerName){
	   System.out.println("dataownerName:"+dataownerName);
	   if (dataownerName == null || dataownerName.equalsIgnoreCase("") ) {
		   return "CQ";
	   }	
	   
	   String hql = "select a.eshirtname from StdDispatchunit a where trim(a.unitname) = '"+dataownerName.trim()+"'";
	   System.out.println("hql:"+hql);
	   QueryListObj obj = zdhSrapplicationDao.getQueryListByHql(hql);
	   if (obj == null) { 
			return "";
	   }
	   List list = obj.getElemList();
	   if (list == null || list.size() < 1){
			return "";
	   }
	   //提取当前的数据所属单位的英文简称(BD、DD... ...)
	   String eshirtname = (String)list.iterator().next();
	   System.out.println("当前的数据所属单位的英文简称:"+eshirtname);
	   
	  
	   return eshirtname;
   }
   /**
	 * 提取当前的班号
	 */
	public String getOndutyno(){
		//定义hql，以“接班时间”最大的为查询条件
		String hql = "select a.ondutyno from ZdhAutoondutylog a where a.successiontime = (select max(b.successiontime)  from ZdhAutoondutylog b)";
		QueryListObj obj = zdhSrapplicationDao.getQueryListByHql(hql);
		if (obj == null) { 
			return "";
		}
		List list = obj.getElemList();
		if (list == null || list.size() < 1){
			return "";
		}
		//提取当前的班号
		String ondutyno = (String)list.iterator().next();
		
		return ondutyno;
	}

   /**
    * 生成传动记录(主管主任审批时调用,要同时区分是市调还是区调)
    * @param dto
    * 
    */
   public void genTransrecord(ZdhSrapplication zdhSrapplication){
	   ZdhTransrecordDto dto = new ZdhTransrecordDto();
	   //填写人
	   dto.setSys_fille(zdhSrapplication.getSys_fille());
	   //填写单位
	   dto.setSys_filldept(zdhSrapplication.getSys_filldept());
	   //填写时间
	   dto.setSys_filltime(null);
	   //数据所属单位
	   dto.setSys_dataowner(zdhSrapplication.getSys_dataowner());
	   //任务来源编号
	   dto.setSourcetaskno(zdhSrapplication.getFapplicationno());
	   dto.setTasksource(ZdhConstants.ZdhTransrecord_BUSINESS_REASON_ZDHSRAPP);
	   //厂站名称
	   dto.setFstationname(zdhSrapplication.getFstationname());
	   //传动内容说明
	   dto.setExplanation(zdhSrapplication.getFeqpclassname());
	   //传动原因
	   dto.setTransreason(ZdhConstants.ZdhTransrecord_BUSINESS_REASON_ZDHSRAPP);
	   //设置当前的班号
	   String ondutyno = this.getOndutyno();
	   ZdhAutoondutylogDto  ondutylogDto = new ZdhAutoondutylogDto();
	   ondutylogDto.setOndutyno(ondutyno);	   
	   dto.setZzdhtransrecord3(ondutylogDto);
	   
	   zdhTransrecordService.saveOrUpdateZdhTransrecord(dto);
   }
   /**
    * 传动记录和停复役的对应关系
    */
   public void genSrappToTransrecord (ZdhSrapplication zdhSrapplication,WorkflowHandleDto dto){
	   CtrlWflentityrel ctrlWflentityrel=new CtrlWflentityrel();
       ctrlWflentityrel.setEntityid(zdhSrapplication.getFapplicationno());
       ctrlWflentityrel.setEntityname(ZdhConstants.ZdhSrappl_BUSINESS_WORKSOURCE);
       ctrlWflentityrel.setTaskid(dto.getTaskInstanceId());//当前任务id
       ctrlWflentityrel.setFrelid(new SequenceCreator().getUID());
       ctrlWflentityrelDao.saveOrUpdate(ctrlWflentityrel);

   }
   /**
	 * 根据申请单编号获取数据所属单位(在需要数据所属单位时调用该方法)
	 * @param id
	 * @return
	 */
	private String getSysDataownerById(String id){		
		ZdhSrapplicationDto dto = this.loadZdhSrapplication(id);
		String dataowner = dto.getSys_dataowner();
		System.out.println("getSysDataownerById数据所属单位:"+dataowner);
		return dataowner;
	}
	
	/**
	 * 发送业务对象信息
	 *  dto  工作流dto
	 *  toFalg 接收方编号
	 */    
	private void sendBussObj (WorkflowHandleDto dto,int toFalg,ZdhSrapplication zdhSrapplication) throws Exception {
		/***********获取message.properties中的key值********************/
		//发送方服务IP
		String provider_url = MessageConfig.getValue("JNDI_PROVIDER_URL");
		//发送方编码
		String local_node = MessageConfig.getValue("LOCAL_NODE");
		//接收方编码(以逗号隔开的)
		String recv_queues = MessageConfig.getValue("RECV_QUEUE");
		/*
		//市局
		String recv_queueForSJ = recv_queues.split(",")[0];
		//城区
		String recv_queueForCQ = recv_queues.split(",")[1];
		*/
		//模块名称(以逗号隔开的)
		String modules = MessageConfig.getValue("MODULE");
		
		//消息传递对象的包结构
		String transDtoPackage = MessageConfig.getValue("transDtoPackage");
		
		//业务对象的包结构
		String bussDtoPackage = MessageConfig.getValue("bussDtoPackage");
		
		//dozer映射文件的绝对路径
		String mappingFileHome = MessageConfig.getValue("mappingFileHome");
		
		/*************设置控制dto(ControlDto)的属性***************/
		ControlDto controlDto = new ControlDto();
		
		//设置发送方编码
		controlDto.setFrom(local_node);
		//设置接收方编码 此处无需设置
		/*switch (toFalg) {
		case 1:
			//市局
			controlDto.setTo("sj");
			break;
		case 2:
			//城区
			controlDto.setTo("cq");
			break;
		}
		*/
		//设置模块名   通过bussinessSign到数据库中获取，此处无需设置
		//controlDto.setModule("");
		//业务标识,需要到表MESSAGE_QNAME中进行查询  BUSS_SIGN字段
		controlDto.setBussinessSign("ZdhSrapplication");
		
		//通知内容:该信息是跟随esb消息发送时，需要发通知的内容.此项不为空，需要设置PersonDto的属性
		controlDto.setNotifyContent("");		
		//中心任务Id
		controlDto.setCenterTaskId(dto.getTaskId());
		
		//二级单位任务Id
		controlDto.setAreaTaskId("");
		
		//类型 1-通知 2-公告 3-业务
		controlDto.setType("3");
		
		//版本  备用
		controlDto.setContentVersion("");
		
		//是否触发器  (就是自动触发某业务方法)  0  no  1 yes
		controlDto.setIsTrigger("1");
		
		//业务对象名称    applicationContext_dmis_service.xml中的service对应的id
		controlDto.setObjectName("iZdhSrapplicationService");
		//业务方法名称    具体的service类中所对应的方法
		controlDto.setMethodName("recBussData");
		
		
		//跟踪号  备用
		controlDto.setTraceNumber("");
		
		//发送时间 sendTime
		java.sql.Timestamp sendTime = DateUtil.getCurrentTimestamp();
		controlDto.setSendTime(sendTime.toString());
		
		//接收时间
		controlDto.setRecvTime("");		
		
		
		/*************设置接收方信息***************/
		//到市局 start
		RecvDto rdto = new RecvDto();	
		switch (toFalg) {
		case 1:
			//市局
			rdto.setTo("sj");
			break;
		case 2:
			//城区
			rdto.setTo("cq");
			break;
		}
		
		
		List recvDtos = new ArrayList();
		recvDtos.add(rdto);
		
		controlDto.setRecvDtos(recvDtos);//接收方信息RecvDto集合
		
		/*设置附件*/
		
		List attachments = new ArrayList();
		AttachmentDto adto = new AttachmentDto();
		byte[] bytes = zdhSrapplication.getFannexexplanation();
		if (bytes.length < 1) {
		   adto.setContent(bytes);
		   adto.setId(dto.getBusId());
		   attachments.add(adto);
		   controlDto.setAttachments(attachments);//附件集合，List中均为AttachmentDto
		}
		
		/************业务DTO**************/
		ZdhSrapplicationDto zdhSrapplicationDto = loadZdhSrapplication(dto.getBusId());
		IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());

		/**************发送*************/

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		service.sendMessage(controlDto, zdhSrapplicationDto);

		stopwatch.stop();
		System.out.println("发送耗时: " + stopwatch.getTime());
	}
   /**
    * 将接收的业务对象保存到本地的数据库
    * @param obj
    */
	 public void recBussData (List list){
		   System.out.println("recBussData start:"+list.size());
		   
		   ControlDto dto = (ControlDto) list.get(0);
		   
		 
		  
		   ZdhSrapplicationDto zdhSrapplicationDto = (ZdhSrapplicationDto)list.get(1);
		  
		   ZdhSrapplicationDto dto2 = new ZdhSrapplicationDto();
		   dto2.setFapplicationno(zdhSrapplicationDto.getFapplicationno());
		   
		   ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(zdhSrapplicationDto.getFapplicationno());
		   /*
		   if (zdhSrapplication != null) {
		      int version = zdhSrapplication.getVersion();
		      dto2.setVersion(version);
		   } else {
			   dto2.setVersion(0);
		   }
		   */
		   dto2.setFapplicationono(zdhSrapplicationDto.getFapplicationono());
		   dto2.setFcenteropinion1(zdhSrapplicationDto.getFcenteropinion1());
		   dto2.setFattribute(zdhSrapplicationDto.getFattribute());
		   dto2.setFannexexplanation(zdhSrapplicationDto.getFannexexplanation());
		   dto2.setFapplicationendime(zdhSrapplicationDto.getFapplicationendime());
		   dto2.setFapplicationno(zdhSrapplicationDto.getFapplicationno());
		   dto2.setFapplicationstarttime(zdhSrapplicationDto.getFapplicationstarttime());
		   dto2.setFapplicationtype(zdhSrapplicationDto.getFapplicationtype());
		   dto2.setFapprovalendtime(zdhSrapplicationDto.getFapprovalendtime());
		   dto2.setFapprovalstarttime(zdhSrapplicationDto.getFapprovalstarttime());
		   dto2.setFcenteropinion2(zdhSrapplicationDto.getFcenteropinion2());
		   dto2.setFcenteropinion3(zdhSrapplicationDto.getFcenteropinion3());
		   dto2.setFeqpclassname(zdhSrapplicationDto.getFeqpclassname());
		   dto2.setFeqpclasstype(zdhSrapplicationDto.getFeqpclasstype());
		   dto2.setFexcutestatus(zdhSrapplicationDto.getFexcutestatus());
		   dto2.setSys_filltime(zdhSrapplicationDto.getSys_filltime());
		   //以下是测试使用
		   dto2.setFstatus("1");
		   dto2.setFexcutestatus("草稿");
		   dto2.setSys_dataowner("CQ");		  
		   
		   this.saveOrUpdateZdhSrapplication(dto2);
		   
		   String strentityId=zdhSrapplicationDto.getFapplicationno();
//		   String sql=" FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='"+strentityId+"'";	   
//		   QueryListObj obj=zdhSrapplicationDao.getQueryListByHql(sql);
//		   List ctlList=obj.getElemList();
//		  Iterator ctlit= ctlList.iterator();
//		  if(ctlit.hasNext())
//		  {
//			  CtrlWflentityrel ctrlWflentityrel=(CtrlWflentityrel)ctlit.next();				  
//			  long taskId=new Long(ctrlWflentityrel.getTaskid()).longValue();
//			   workFlowDao.endWaitingByTaskInstance(taskId);
//			   ZdhSrapplication zdhSrapplication=zdhSrapplicationDao.findByPk(strentityId);
//			 //椹冲洖
//			   zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_AREA_STATUS_NEW);
//			   zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_BUSINESS_AREA_MODI);
//			 //纭
//			   zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_AREA_STATUS_NEW);
//			   zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_BUSINESS_AREA_APPROVED);
//			   zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
//
//		  }

		   
		   
		   //淇濆瓨闄勪欢(blob绫诲瀷鐨勬暟鎹?
	       //鎺у埗dto,绗竴涓厓绱犲瓨鏀炬帶鍒禿to
		   
		   //鑾峰彇闄勪欢
//		   List attachments = dto.getAttachments();
//		   AttachmentDto adto = (AttachmentDto) attachments.get(0);
//		   zdhSrapplicationDto.setFannexexplanation(adto.getContent());
//		   System.out.println("@@@@@@@"+adto.getContent());
//		   this.saveOrUpdateZdhSrapplication(zdhSrapplicationDto);
		   
	   }
   
   
   
   
   /*******************************工作流***********************************/
   /**
    * 启动
    */
	public void start(WorkflowHandleDto dto) throws DataAccessException {
        //根据数据所属单位进行控制
		String dataowner = getSysDataownerById(dto.getBusId());
		if (dataowner.equalsIgnoreCase("") || dataowner == null || dataowner == "") {
			System.out.println("未能获取数据所属单位");
			return;
		}
		int iReturn = zdhSrapplicationWFServiceImpl.start(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		
		if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS.indexOf(dataowner.toUpperCase()) >= 0) {
            /***********变电公司********************/
			
            //设置流转状态为"变电公司专工审批"
			zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDSPECAPPROVE);	
            //设置业务状态为"审核中"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
		} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD.indexOf(dataowner.toUpperCase()) >= 0) {
			/***********区调********************/
			
			//设置流转状态为"自动化专工审批"
			zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SPECAPPROVE);	
            //设置业务状态为"审核中"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
		} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC.indexOf(dataowner.toUpperCase()) >= 0) {
			/*************自动化运行处*******************/
            //设置流转状态为"自动化运行处处长审批"
			zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_ZDHRUNAPPROVE);	
            //设置业务状态为"审核中"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
		}
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
	}
    

	/**
	 * 变电公司自动化专工审批  2
	 */
	public void zdhSrapplBdspecApprove(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplBdspecApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1: 
				/******变电公司自动化专工审批不通过*******/
                //设置流转状态为"变电运行单位修改申请"
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDRUNMODIFY);	
                //设置业务状态为"审批驳回"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
				break;
			case 1:
				/*****变电公司自动化专工审批通过******/
				//设置流转状态	为"变电公司领导审批"
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDHEADERAPPROVE);			
				//设置业务状态为审核中
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
				break;
		}
		
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
	}
    /**
     * 变电运行单位修改申请
     * @param dto
     * @throws DataAccessException
     */
	public void zdhSrapplBdrunModify(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplBdrunModify(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
        //设置流转状态	为"变电公司自动化专工审批"
		zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDSPECAPPROVE);			
		//设置业务状态为"审批驳回"
		zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
	}
	/**
	 * 变电公司领导审批 4
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplBdheaderApprove(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplBdheaderApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1:
				/*********审批不通过*************/
				//设置流转状态	为"变电运行单位修改申请"
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDRUNMODIFY);			
				//设置业务状态为"审批驳回"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
				
				break;
			case 1:
				/*********审批通过*************/
                //设置流转状态	为"自动化专工审批"
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SPECAPPROVE);			
				//设置业务状态为"审核中"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
				break;
		}
        
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
		
	}
	/**
	 * 自动化运行处处长审批
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplZdhrunApprove(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplZdhrunApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
        //设置流转状态	为自动化专工审批
		zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SPECAPPROVE);			
		//设置业务状态为审核中
		zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
	}
	/**
	 * 自动化运行处修改(自动化运行处修改申请)
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplZdhrunModify(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplZdhrunModify(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
        //设置流转状态	为自动化运行处处长审批
		zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_ZDHRUNAPPROVE);			
		//设置业务状态为审核中
		zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
	}
	/**
	 * 变电自动化专工任务下发 7
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplBdrunTasksent(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplBdrunTasksent(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
        //停役性质
		String fattribute = zdhSrapplication.getFattribute().trim();
		if (fattribute.equalsIgnoreCase(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK)) {
			/**********检修**********/
            //生成传动记录
			this.genTransrecord(zdhSrapplication);
			//生成传动记录和停复役的对应关系
			this.genSrappToTransrecord(zdhSrapplication,dto);
			//设置流转状态为"运行单位执行"
			//zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_RUNEXEC);
            //设置业务状态为"等待传动记录"
			//zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_WAITTRANS);
			
			zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
			
		} else if (fattribute.equalsIgnoreCase(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_REBACK)) {
			/**********退运**********/
            //设置流转状态为"运行单位执行"
			zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_RUNEXEC);
            //设置业务状态为"已报上级调度"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_REPSUPERIOR);
			
			zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
		}	
		
	}
	/**
	 * 运行单位执行 8
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplRunExec(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplRunExec(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
        //设置流转状态为"专工归档"
		zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SPECKEEPON);
			
        //设置业务状态为"已执行"
		zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_EXECUTED);
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
	}
	/**
	 * 下发审批结果
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSentResult(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplSentResult(dto);        
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());		
		try{
            //设置业务状态为"中调审批未通过"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_AREA_MidApprove_NO);
			//设置流转状态为"新建"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_AREA_STATUS_NEW);
			zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);			
			///发送业务对象
			sendBussObj(dto,2,zdhSrapplication);
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 主任审批(运维中心主任审批)
	 */
	public void zdhSrapplDirectorApprove(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplDirectorApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1: 
				/******运维中心主任审批不通过*******/                
				//设置流转状态为自动化专工下发未批准意见
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SENTCOMMENT);
					
                //设置业务状态为"审批驳回"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
			case 1:
				/*****运维中心主任审批通过******/
                //设置流转状态为"处长审批"                   
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_HEADERAPPROVE);
					
                //设置业务状态为"审核中"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
		}
		
	}
	/**
	 * 主管主任审批  11
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplMDicrecterApprove(WorkflowHandleDto dto) throws DataAccessException {
		//根据数据所属单位进行控制
		String dataowner = getSysDataownerById(dto.getBusId());
		if (dataowner.equalsIgnoreCase("") || dataowner == null || dataowner == "") {
			System.out.println("未能获取数据所属单位");
			return;
		}
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplMDicrecterApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		//停役性质
		String fattribute = zdhSrapplication.getFattribute().trim();
		//审批通过标志
		String transitionFlag = dto.getTransitionFlag();
		
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1: 
				/******主管主任审批不通过*******/                
				//设置流转状态为自动化专工下发未批准意见
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SENTCOMMENT);
					
                //设置业务状态为"审批驳回"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
			case 1:
				/*****主管主任审批通过******/
                
				if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS.indexOf(dataowner.toUpperCase()) >= 0) {
		            /************变电公司**************/					
			        //设置流转状态为"变电自动化专工任务下发"
					zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDTASKSENT);						
			        //设置业务状态为"下发执行"
					zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_EXECUTING);				
					zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD.indexOf(dataowner.toUpperCase()) >= 0) {
					/*********区调*************/
					System.out.println("主管主任审批通过,下发批准信息... ...");
					try{
						//设置业务状态为"审批通过"
						zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_AREA_MidApprove_YES);
						//设置流转状态为区调的"自动化专工任务下发",为了触发区调的工作流
						zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_AREA_STATUS_SPECTASKSENT);

						zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
						
						sendBussObj(dto,2,zdhSrapplication);
					} catch (Exception e){
						e.printStackTrace();
					}
				} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC.indexOf(dataowner.toUpperCase()) >= 0) {
					/****************自动化运行处********************/
					if (fattribute.equalsIgnoreCase(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK)) {
						/**********检修**********/
						//设置流转状态为"运行单位执行"
						//zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_RUNEXEC);
                        //设置业务状态为"等待传动记录"
						//zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_WAITTRANS);
						//生成传动记录
						this.genTransrecord(zdhSrapplication);
						//生成传动记录和停复役的对应关系
						this.genSrappToTransrecord(zdhSrapplication,dto);
						zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
					} else if (fattribute.equalsIgnoreCase(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsWorkType_REBACK)){
						/**********退运**********/
                        //设置流转状态为"运行单位执行"
						zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_RUNEXEC);
                        //设置业务状态为"已报上级调度"
						zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_REPSUPERIOR);
						zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
					}
				}
				
				break;
		}
		
	}
	/**
	 * 将审批意见下发(自动化专工下发未批准意见)
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSentComment(WorkflowHandleDto dto) throws DataAccessException {
        //根据数据所属单位进行控制
		String dataowner = getSysDataownerById(dto.getBusId());
		if (dataowner.equalsIgnoreCase("") || dataowner == null || dataowner == "") {
			System.out.println("未能获取数据所属单位");
			return;
		}
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplSentComment(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		
		if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS.indexOf(dataowner.toUpperCase()) >= 0) {
			/**********变电公司***************/
            //设置流转状态为"变电运行单位修改申请"
			zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_BDRUNMODIFY);
	        //设置业务状态为"审核驳回"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
			
		} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC.indexOf(dataowner.toUpperCase()) >= 0){
			/**********自动化运行处***************/
            //设置流转状态为"自动化运行处修改申请"
			zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_ZDHRUNMODIFY);
	        //设置业务状态为"审核驳回"
			zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
			
		} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD.indexOf(dataowner.toUpperCase()) >= 0) {
			/**********区调 自动下发审批结果********/
			System.out.println("自动化专工下发未批准意见... ...");
			try{
				sendBussObj(dto,2,zdhSrapplication);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
		
	}
	/**
	 * 自动化专工审批    13
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSpecApprove(WorkflowHandleDto dto) throws DataAccessException {
		System.out.println("workflow taskid is:"+dto.getTaskInstanceId());
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplSpecApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1: 
				/******自动化专工审批不通过*******/                
				//设置流转状态为自动化专工下发未批准意见
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SENTCOMMENT);
					
                //设置业务状态为"审批驳回"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
			case 1:
				/*****自动化专工审批通过******/
                //设置流转状态为"运维中心主任审批"
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_DIRECTORAPPROVE);
					
                //设置业务状态为审核中
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
		}
	}
	/**
	 * 专工归档 14
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplSpecKeepon(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplSpecKeepon(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
        //设置流转状态为"结束"
		zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_OVER);
			
        //设置业务状态为"已归档"
		zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_CONFORMED);
	}
	/**
	 * 处长审批 15
	 * @param dto
	 * @throws DataAccessException
	 */
	public void zdhSrapplHeaderApprove(WorkflowHandleDto dto) throws DataAccessException {
		int iReturn = zdhSrapplicationWFServiceImpl.zdhSrapplHeaderApprove(dto);
		ZdhSrapplication zdhSrapplication = zdhSrapplicationDao.findByPk(dto.getBusId());
		String transitionFlag = dto.getTransitionFlag();
		switch (Integer.valueOf(transitionFlag).intValue()) {
			case -1: 
				/******处长审批不通过*******/                
				//设置流转状态为自动化专工下发未批准意见
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_SENTCOMMENT);
					
                //设置业务状态为"审批驳回"
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
			case 1:
				/*****处长审批通过******/
                //设置流转状态为"主管主任审批"
				zdhSrapplication.setFstatus(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_STATUS_MDICRECTERAPPROVE);
					
                //设置业务状态为审核中
				zdhSrapplication.setFexcutestatus(ZdhConstants.ZdhSrappl_BUSINESS_CITY_APPROVING);
				zdhSrapplicationDao.saveOrUpdate(zdhSrapplication);
				break;
		}
	}
	
	
}
