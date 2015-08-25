package com.techstar.dmis.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.DdRepairrisklistDto;
import com.techstar.dmis.entity.DdRepairrisklist;
import com.techstar.dmis.service.IDdMoutageplanService;
import com.techstar.dmis.service.IDdRepairrisklistService;
import org.springframework.dao.DataAccessException;

//注册子表DAO
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.entity.DdMoutageplan;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

import com.techstar.dmis.service.workflow.IDdRepairrisklistWFService;

//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口实现类
 * 
 * @author
 * @date
 */
public class DdRepairrisklistServiceImpl implements IDdRepairrisklistService {
	// 注册DAO
	private IDdRepairrisklistDao ddRepairrisklistDao;

	private IBaseJdbcDao baseJdbcDao;

	private IDdMoutageplanService ddMoutageplanService;

	// 注册管理DAO
	private IDdMoutageplanDao ddMoutageplanDao;

	public void setDdMoutageplanDao(IDdMoutageplanDao ddMoutageplanDao) {
		this.ddMoutageplanDao = ddMoutageplanDao;
	}

	// 注册工作流

	private IDdRepairrisklistWFService ddRepairrisklistWFService;

	public DdRepairrisklistServiceImpl() {
	}

	public void addDdRepairrisklist(DdRepairrisklistDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		// 新增时候,主对象不用管子对象的保存
		DdRepairrisklist ddRepairrisklist = (DdRepairrisklist) BeanHelper
				.buildBean(DdRepairrisklist.class, dto);
		ddRepairrisklistDao.saveOrUpdate(ddRepairrisklist);
	}

	// 用于实现基本增加或修改操作

	public void saveOrUpdateDdRepairrisklist(DdRepairrisklistDto dto) {
		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
				//状态
			}
		}
		DdRepairrisklist ddRepairrisklist = (DdRepairrisklist) BeanHelper
				.mapBean(DdRepairrisklist.class, dto);
		ddRepairrisklistDao.saveOrUpdate(ddRepairrisklist);
	}

	// 用于实现基本删除操作
	public void deleteDdRepairrisklist(String ddRepairrisklistId) {
		DdRepairrisklist ddRepairrisklist = new DdRepairrisklist();
		ddRepairrisklist.setFid(ddRepairrisklistId);
		ddRepairrisklistDao.delete(ddRepairrisklist);
	}

	// 用于实现基本删除集合操作
	public void deleteDdRepairrisklist(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdRepairrisklist.class, dtos);
		ddRepairrisklistDao.deleteAll(pos);
	}

	// 用于实现基本DTOLOAD操作
	public DdRepairrisklistDto loadDdRepairrisklist(String fid) {
		DdRepairrisklist ddRepairrisklist = (DdRepairrisklist) ddRepairrisklistDao
				.findByPk(fid);
		DdRepairrisklistDto dto = (DdRepairrisklistDto) BeanHelper.mapBean(
				DdRepairrisklistDto.class, ddRepairrisklist);
		return dto;
	}

	// 用于实现列表操作
	public QueryListObj listDdRepairrisklist() {
		QueryListObj obj = ddRepairrisklistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdRepairrisklistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj listDdRepairrisklistByHql(String hql) {
		QueryListObj obj = ddRepairrisklistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdRepairrisklistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getDdRepairrisklistByHql(String hql, int beginPage,
			int pageSize, String sql) {
		QueryListObj obj = ddRepairrisklistDao.getQueryListByHql(hql,
				beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdRepairrisklistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}

		List sumList = ddRepairrisklistDao.getObjPropertySums(sql);
		// System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	/**
	 * @business method list
	 * @周风险发布
	 * @风险预案导入
	 * @工作流－审核
	 * @工作流－发布
	 * @选择月计划
	 * @工作流－修改
	 */

	// please add your business methods start
	// to do it
	// add your business method end
	public IDdRepairrisklistDao getDdRepairrisklistDao() {
		return ddRepairrisklistDao;
	}

	public void setDdRepairrisklistDao(IDdRepairrisklistDao ddRepairrisklistDao) {
		this.ddRepairrisklistDao = ddRepairrisklistDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void saveOrUpdateDdRepairrisklist(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdRepairrisklistDto ddRepairrisklistDto = (DdRepairrisklistDto) dtos
					.get(i);
			DdRepairrisklist ddRepairrisklist = (DdRepairrisklist) BeanHelper
					.buildBean(DdRepairrisklist.class, ddRepairrisklistDto);
			pos.add(ddRepairrisklist);
		}

		ddRepairrisklistDao.saveOrUpdateAll(pos);
	}

	// 注册工作流服务

	public IDdRepairrisklistWFService getDdRepairrisklistWFService() {
		return ddRepairrisklistWFService;
	}

	public void setDdRepairrisklistWFService(
			IDdRepairrisklistWFService ddRepairrisklistWFService) {
		this.ddRepairrisklistWFService = ddRepairrisklistWFService;
	}

	// 子表处理DAO

	public QueryListObj listDdMoutageplan() {
		QueryListObj obj = ddMoutageplanDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdMoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

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

	public void deleteDdMoutageplan(String fmonthplanno) {

		DdMoutageplan ddMoutageplan = new DdMoutageplan();
		ddMoutageplan.setFmonthplanno(fmonthplanno);
		ddMoutageplanDao.delete(ddMoutageplan);

	}

	public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno) {
		DdMoutageplan ddMoutageplan = (DdMoutageplan) ddMoutageplanDao
				.findByPk(fmonthplanno);
		DdMoutageplanDto dto = (DdMoutageplanDto) BeanHelper.buildBean(
				DdMoutageplanDto.class, ddMoutageplan);
		return dto;
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

	public void deleteDdMoutageplan(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdMoutageplan.class, dtos);
		ddMoutageplanDao.deleteAll(pos);
	}

	public void addDdRepairrisklistByMplans(String[] strs,
			String sys_dataowner, String sys_filldept, String sys_fille,
			Timestamp sys_filltime) {

		for (int i = 0; i < strs.length; i++) {
			DdMoutageplanDto dto = ddMoutageplanService
					.loadDdMoutageplan(strs[i]);
			// DdMoutageplan ddMoutageplan = new DdMoutageplan();
			// ddMoutageplan.setFmonthplanno(dto.getFmonthplanno());
			//
			DdRepairrisklistDto ddRepairrisklistDto = new DdRepairrisklistDto();

			// ddRepairrisklist.setFdangerreason(dto.getfd);风险原因
			// ddRepairrisklist.setFforecast(fforecast);天气预报
			ddRepairrisklistDto.setFid(null);
			ddRepairrisklistDto.setFline(dto.getFlinename());
			ddRepairrisklistDto.setFoutageetime(dto.getFendtime());
			ddRepairrisklistDto.setFoutagestime(dto.getFstarttime());
			// ddRepairrisklist.setFriskprompt(dto.getfr);风险提示
			// ddRepairrisklist.setFriskunit(friskunit);风险相关单位
			// ddRepairrisklist.setFtransformer(dto.getftr);变压器
			ddRepairrisklistDto.setFworkcontent(dto.getFworkcontent());
			ddRepairrisklistDto.setSys_dataowner(sys_dataowner);
			ddRepairrisklistDto.setSys_filldept(sys_filldept);
			ddRepairrisklistDto.setSys_fille(sys_fille);
			ddRepairrisklistDto.setSys_filltime(sys_filltime);
			// ddRepairrisklist.setSys_isvalid(sys_isvalid);
			ddRepairrisklistDto.setZddrepairrisklist4(dto);
			
			ddRepairrisklistDto.setFstatus(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_NEW);
			ddRepairrisklistDto.setFexcutestatus(DispatchConstants.PowerRiskAnalysis_STATUS_NEW);

			// ddRepairrisklistDao.saveOrUpdate(ddRepairrisklist);

			saveOrUpdateDdRepairrisklist(ddRepairrisklistDto);

		}

	}

	public void setDdMoutageplanService(
			IDdMoutageplanService ddMoutageplanService) {
		this.ddMoutageplanService = ddMoutageplanService;
	}
	
	public void start(WorkflowHandleDto dto) {
		ddRepairrisklistWFService.start(dto);
	}
	public void approve(WorkflowHandleDto dto) {
		ddRepairrisklistWFService.ddRiskAnalyseApprove(dto);
	}
	
	public void modify(WorkflowHandleDto dto) {
		ddRepairrisklistWFService.ddRiskAnalyseModify(dto);
	}
	
	public void Release(WorkflowHandleDto dto) {
		ddRepairrisklistWFService.ddRiskAnalyseRelease(dto);
	}

}
