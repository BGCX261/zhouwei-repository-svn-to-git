package com.techstar.dmis.service.impl;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;

import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.entity.CtrlWflentityrel;
import com.techstar.dmis.entity.DdDoutageplan;
import com.techstar.dmis.entity.DdMoutageplan;
import com.techstar.dmis.service.IDdMoutageplanService;
import com.techstar.dmis.service.workflow.IDdMoutageplanWFService;
import com.techstar.dmis.util.DateUtil;

import org.springframework.dao.DataAccessException;

//注册子表DAO
import com.techstar.dmis.dto.DdRepairdetailDto;
import com.techstar.dmis.entity.DdRepairdetail;
import com.techstar.dmis.dto.DdPremethodDto;
import com.techstar.dmis.entity.DdPremethod;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;


//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口实现类
 *
 * @author
 * @date
 */
public class DdMoutageplanServiceImpl implements IDdMoutageplanService {
	// 注册DAO
	private IDdMoutageplanDao ddMoutageplanDao;

	private IBaseJdbcDao baseJdbcDao;

	// 注册管理DAO
	private IDdRepairdetailDao ddRepairdetailDao;

	//注册工作流
	private IDdMoutageplanWFService ddMoutageplanWFService;

    private ICtrlWflentityrelDao ctrlWflentityrelDao;

    private IWorkflowDao workFlowDao;

	public void setDdRepairdetailDao(IDdRepairdetailDao ddRepairdetailDao) {
		this.ddRepairdetailDao = ddRepairdetailDao;
	}

	private IDdPremethodDao ddPremethodDao;

	public void setDdPremethodDao(IDdPremethodDao ddPremethodDao) {
		this.ddPremethodDao = ddPremethodDao;
	}



	public DdMoutageplanServiceImpl() {
	}

	public void addDdMoutageplan(DdMoutageplanDto dto) {

		if (StringUtils.isEmpty(dto.getFmonthplanno())) {
			if (StringUtils.isEmpty(dto.getFmonthplanno())) {
				dto.setFmonthplanno(new SequenceCreator().getUID());
			}
		}
		// 新增时候,主对象不用管子对象的保存
		DdMoutageplan ddMoutageplan = (DdMoutageplan) BeanHelper.buildBean(
				DdMoutageplan.class, dto);
		ddMoutageplanDao.saveOrUpdate(ddMoutageplan);
	}

	// 用于实现基本增加或修改操作

	public void saveOrUpdateDdMoutageplan(DdMoutageplanDto dto) {
		if (StringUtils.isEmpty(dto.getFmonthplanno())) {
			if (StringUtils.isEmpty(dto.getFmonthplanno())) {
				dto.setFmonthplanno(new SequenceCreator().getUID());
			}
		}
		DdMoutageplan ddMoutageplan = (DdMoutageplan) BeanHelper.buildBean(
				DdMoutageplan.class, dto);
		ddMoutageplanDao.saveOrUpdate(ddMoutageplan);
	}

	// 用于实现基本删除操作
	public void deleteDdMoutageplan(String ddMoutageplanId, String version) {
		DdMoutageplan ddMoutageplan = new DdMoutageplan();
		ddMoutageplan.setFmonthplanno(ddMoutageplanId);
		ddMoutageplan.setVersion(Integer.valueOf(version).intValue());
		ddMoutageplanDao.delete(ddMoutageplan);
	}

	// 用于实现基本删除集合操作
	public void deleteDdMoutageplan(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdMoutageplan.class, dtos);
		ddMoutageplanDao.deleteAll(pos);
	}

	// 用于实现基本DTOLOAD操作
	public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno) {
		DdMoutageplan ddMoutageplan = (DdMoutageplan) ddMoutageplanDao
				.findByPk(fmonthplanno);
		ddMoutageplan.getFddrepairdetail1();
		DdMoutageplanDto dto = (DdMoutageplanDto) BeanHelper.mapBean(
				DdMoutageplanDto.class, ddMoutageplan);
		return dto;
	}

	// 用于实现列表操作
	public QueryListObj listDdMoutageplan() {
		QueryListObj obj = ddMoutageplanDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdMoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj listDdMoutageplanByHql(String hql) {
		QueryListObj obj = ddMoutageplanDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdMoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getDdMoutageplanByHql(String hql, int beginPage,
			int pageSize, String sql) {
		QueryListObj obj = ddMoutageplanDao.getQueryListByHql(hql, beginPage,
				pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdMoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}

		List sumList = ddMoutageplanDao.getObjPropertySums(sql);
		// System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	/**
	 * @business method list
	 * @月计划归档
	 * @生成日计划
	 * @未批准计划/未完成计划导入
	 * @预案查询
	 * @设备参数维护
	 * @电网周风险维护
	 * @月计划合并
	 * @从间隔获得停电范围及设备列表
	 */

	// please add your business methods start
	// to do it
	// add your business method end
	public IDdMoutageplanDao getDdMoutageplanDao() {
		return ddMoutageplanDao;
	}

	public void setDdMoutageplanDao(IDdMoutageplanDao ddMoutageplanDao) {
		this.ddMoutageplanDao = ddMoutageplanDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void saveOrUpdateDdMoutageplan(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdMoutageplanDto ddMoutageplanDto = (DdMoutageplanDto) dtos.get(i);
			DdMoutageplan ddMoutageplan = (DdMoutageplan) BeanHelper.buildBean(
					DdMoutageplan.class, ddMoutageplanDto);
			pos.add(ddMoutageplan);
		}

		ddMoutageplanDao.saveOrUpdateAll(pos);
	}

	// 子表处理DAO

	public QueryListObj listDdRepairdetail() {
		QueryListObj obj = ddRepairdetailDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdRepairdetailDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdRepairdetail(DdRepairdetailDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		DdRepairdetail ddRepairdetail = (DdRepairdetail) BeanHelper.buildBean(
				DdRepairdetail.class, dto);
		ddRepairdetailDao.saveOrUpdate(ddRepairdetail);

	}

	public void deleteDdRepairdetail(String fid) {

		DdRepairdetail ddRepairdetail = new DdRepairdetail();
		ddRepairdetail.setFid(fid);
		ddRepairdetailDao.delete(ddRepairdetail);

	}

	public DdRepairdetailDto loadDdRepairdetail(String fid) {
		DdRepairdetail ddRepairdetail = (DdRepairdetail) ddRepairdetailDao
				.findByPk(fid);
		DdRepairdetailDto dto = (DdRepairdetailDto) BeanHelper.buildBean(
				DdRepairdetailDto.class, ddRepairdetail);
		return dto;
	}

	public QueryListObj listDdRepairdetailByHql(String hql) {
		QueryListObj obj = ddRepairdetailDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdRepairdetailDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdRepairdetail(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdRepairdetailDto ddRepairdetailDto = (DdRepairdetailDto) dtos
					.get(i);
			DdRepairdetail ddRepairdetail = (DdRepairdetail) BeanHelper
					.buildBean(DdRepairdetail.class, ddRepairdetailDto);
			pos.add(ddRepairdetail);
		}

		ddRepairdetailDao.saveOrUpdateAll(pos);

	}

	public void deleteDdRepairdetail(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdRepairdetail.class, dtos);
		ddRepairdetailDao.deleteAll(pos);
	}

	public QueryListObj listDdPremethod() {
		QueryListObj obj = ddPremethodDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPremethodDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdPremethod(DdPremethodDto dto) {

		if (StringUtils.isEmpty(dto.getFpremethodid())) {
			if (StringUtils.isEmpty(dto.getFpremethodid())) {
				dto.setFpremethodid(new SequenceCreator().getUID());
			}
		}
		DdPremethod ddPremethod = (DdPremethod) BeanHelper.buildBean(
				DdPremethod.class, dto);
		ddPremethodDao.saveOrUpdate(ddPremethod);

	}

	public void deleteDdPremethod(String fpremethodid) {

		DdPremethod ddPremethod = new DdPremethod();
		ddPremethod.setFpremethodid(fpremethodid);
		ddPremethodDao.delete(ddPremethod);

	}

	public DdPremethodDto loadDdPremethod(String fpremethodid) {
		DdPremethod ddPremethod = (DdPremethod) ddPremethodDao
				.findByPk(fpremethodid);
		DdPremethodDto dto = (DdPremethodDto) BeanHelper.buildBean(
				DdPremethodDto.class, ddPremethod);
		return dto;
	}

	public QueryListObj listDdPremethodByHql(String hql) {
		QueryListObj obj = ddPremethodDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdPremethodDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdPremethod(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdPremethodDto ddPremethodDto = (DdPremethodDto) dtos.get(i);
			DdPremethod ddPremethod = (DdPremethod) BeanHelper.buildBean(
					DdPremethod.class, ddPremethodDto);
			pos.add(ddPremethod);
		}

		ddPremethodDao.saveOrUpdateAll(pos);

	}

	public void deleteDdPremethod(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdPremethod.class, dtos);
		ddPremethodDao.deleteAll(pos);
	}



	public void setDdMoutageplanWFService(
			IDdMoutageplanWFService ddMoutageplanWFService) {
		this.ddMoutageplanWFService = ddMoutageplanWFService;
	}



    public void start(WorkflowHandleDto dto)
    {
        ddMoutageplanWFService.start(dto);
    }

    public void ddMonthPlanCleanUp(WorkflowHandleDto dto)
    {
        ddMoutageplanWFService.ddMonthPlanCleanUp(dto);
    }

    public void ddMonthPlanSentResult(WorkflowHandleDto dto)
    {
        ddMoutageplanWFService.ddMonthPlanSentResult(dto);
    }

    public void ddMonthPlanApproveAndSend(WorkflowHandleDto dto)
    {
        ddMoutageplanWFService.ddMonthPlanApproveAndSend(dto);
    }

    public void ddMonthPlanModify(WorkflowHandleDto dto)
    {
        ddMoutageplanWFService.ddMonthPlanModify(dto);
    }

    public void ddMonthPlanCleanUpResult(WorkflowHandleDto dto)
    {
        ddMoutageplanWFService.ddMonthPlanCleanUpResult(dto);
    }

    public void recBussData(List list)
    {
        System.out.println("recBussData start:" + list.size());
        ControlDto dto = (ControlDto)list.get(0);
        DdMoutageplanDto ddMoutageplanDto = (DdMoutageplanDto)list.get(1);
        String strentityId = ddMoutageplanDto.getFmonthplanno();
        String sql = " FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='" + strentityId + "'";
        QueryListObj obj = ctrlWflentityrelDao.getQueryListByHql(sql);
        List ctlList = obj.getElemList();
        Iterator ctlit = ctlList.iterator();
        if(ctlit.hasNext())
        {
            CtrlWflentityrel ctrlWflentityrel = (CtrlWflentityrel)ctlit.next();
            long taskId = (new Long(ctrlWflentityrel.getTaskid())).longValue();
            workFlowDao.endWaitingByTaskInstance(taskId);
            DdMoutageplan ddMoutageplan = ddMoutageplanDao.findByPk(strentityId);
            ddMoutageplan.setFexcutestatus(ddMoutageplanDto.getFexcutestatus());
            ddMoutageplanDao.saveOrUpdate(ddMoutageplan);
        }
    }

    public void recBussDataWaiting(List list)
    {
        System.out.println("recBussData start:" + list.size());
        ControlDto dto = (ControlDto)list.get(0);
        DdMoutageplanDto ddMoutageplanDto = (DdMoutageplanDto)list.get(1);
        String strentityId = ddMoutageplanDto.getFmonthplanno();
        String sql = " FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='" + strentityId + "'";
        QueryListObj obj = ctrlWflentityrelDao.getQueryListByHql(sql);
        List ctlList = obj.getElemList();
        Iterator ctlit = ctlList.iterator();
        if(ctlit.hasNext())
        {
            CtrlWflentityrel ctrlWflentityrel = (CtrlWflentityrel)ctlit.next();
            long taskId = (new Long(ctrlWflentityrel.getTaskid())).longValue();
            workFlowDao.endWaitingByTaskInstance(taskId);
            DdMoutageplan ddMoutageplan = ddMoutageplanDao.findByPk(strentityId);
            ddMoutageplan.setFexcutestatus(ddMoutageplanDto.getFexcutestatus());
            ddMoutageplan.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUpResult);
            ddMoutageplanDao.saveOrUpdate(ddMoutageplan);
        }
    }

    public void setCtrlWflentityrelDao(ICtrlWflentityrelDao ctrlWflentityrelDao)
    {
        this.ctrlWflentityrelDao = ctrlWflentityrelDao;
    }

    private void sendBussObj(WorkflowHandleDto dto, String toFalg, String Class_Method[])
        throws Exception
    {
        String provider_url = MessageConfig.getValue("JNDI_PROVIDER_URL");
        String local_node = MessageConfig.getValue("LOCAL_NODE");
        String recv_queues = MessageConfig.getValue("RECV_QUEUE");
        String modules = MessageConfig.getValue("MODULE");
        String transDtoPackage = MessageConfig.getValue("transDtoPackage");
        String bussDtoPackage = MessageConfig.getValue("bussDtoPackage");
        String mappingFileHome = MessageConfig.getValue("mappingFileHome");
        ControlDto controlDto = new ControlDto();
        controlDto.setFrom(local_node);
        controlDto.setBussinessSign("DdMoutageplan");
        controlDto.setNotifyContent("");
        controlDto.setAreaTaskId(Long.valueOf(dto.getTaskInstanceId()).toString());
        controlDto.setType("3");
        controlDto.setContentVersion("");
        controlDto.setIsTrigger("1");
        controlDto.setObjectName(Class_Method[0]);
        controlDto.setMethodName(Class_Method[1]);
        controlDto.setTraceNumber("");
        Timestamp sendTime = DateUtil.getCurrentTimestamp();
        controlDto.setSendTime(sendTime.toString());
        controlDto.setRecvTime("");
        RecvDto rdto = new RecvDto();
        rdto.setTo(toFalg);
        List recvDtos = new ArrayList();
        recvDtos.add(rdto);
        controlDto.setRecvDtos(recvDtos);
        IexchangeService service = new ExchangeServiceImpl();
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        DdMoutageplanDto ddMoutageplanDto = loadDdMoutageplan(dto.getBusId());
        service.sendMessage(controlDto, ddMoutageplanDto);
        stopwatch.stop();
        System.out.println("发送耗时: " + stopwatch.getTime());
        String busId = dto.getBusId();
        CtrlWflentityrel ctrlWflentityrel = new CtrlWflentityrel();
        ctrlWflentityrel.setEntityid(busId);
        ctrlWflentityrel.setEntityname("DdMoutageplan");
        ctrlWflentityrel.setTaskid(dto.getTaskInstanceId());
        ctrlWflentityrel.setFrelid((new SequenceCreator()).getUID());
        ctrlWflentityrelDao.saveOrUpdate(ctrlWflentityrel);
    }



	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}

}
