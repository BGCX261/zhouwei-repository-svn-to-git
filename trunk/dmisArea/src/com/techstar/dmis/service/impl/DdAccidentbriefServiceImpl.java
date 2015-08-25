package com.techstar.dmis.service.impl;

import java.sql.Date;
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
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.entity.DdAccidentbrief;
import com.techstar.dmis.service.IDdAccidentbriefService;
import org.springframework.dao.DataAccessException;

//注册子表DAO
import com.techstar.dmis.dto.BhActionrecordDto;
import com.techstar.dmis.entity.BhActionrecord;
import com.techstar.dmis.dto.DdAccidentbriefprocessDto;
import com.techstar.dmis.entity.DdAccidentbriefprocess;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

import com.techstar.dmis.service.workflow.IDdAccidentbriefWFService;
import com.techstar.dmis.util.DateUtil;

//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口实现类
 * 
 * 
 * @author
 * @date
 */
public class DdAccidentbriefServiceImpl implements IDdAccidentbriefService {
	// 注册DAO
	private IDdAccidentbriefDao ddAccidentbriefDao;

	private IBaseJdbcDao baseJdbcDao;

	// 注册管理DAO
	private IBhActionrecordDao bhActionrecordDao;

	public void setBhActionrecordDao(IBhActionrecordDao bhActionrecordDao) {
		this.bhActionrecordDao = bhActionrecordDao;
	}

	private IDdAccidentbriefprocessDao ddAccidentbriefprocessDao;

	public void setDdAccidentbriefprocessDao(
			IDdAccidentbriefprocessDao ddAccidentbriefprocessDao) {
		this.ddAccidentbriefprocessDao = ddAccidentbriefprocessDao;
	}

	// 注册工作流

	private IDdAccidentbriefWFService ddAccidentbriefWFService;

	public DdAccidentbriefServiceImpl() {
	}

	public void addDdAccidentbrief(DdAccidentbriefDto dto) {

		if (StringUtils.isEmpty(dto.getFaccidentid())) {
			if (StringUtils.isEmpty(dto.getFaccidentid())) {
				dto.setFaccidentid(new SequenceCreator().getUID());
			}
		}
		// 新增时候,主对象不用管子对象的保存
		DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) BeanHelper
				.buildBean(DdAccidentbrief.class, dto);
		ddAccidentbriefDao.saveOrUpdate(ddAccidentbrief);
	}

	// 用于实现基本增加或修改操作

	public void saveOrUpdateDdAccidentbrief(DdAccidentbriefDto dto) {
		if (StringUtils.isEmpty(dto.getFaccidentid())) {
			if (StringUtils.isEmpty(dto.getFaccidentid())) {
				dto.setFaccidentid(new SequenceCreator().getUID());
			}
		}
		DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) BeanHelper.mapBean(
				DdAccidentbrief.class, dto);
		ddAccidentbriefDao.saveOrUpdate(ddAccidentbrief);
	}

	// 用于实现基本删除操作
	public void deleteDdAccidentbrief(String ddAccidentbriefId, String version) {
		DdAccidentbrief ddAccidentbrief = new DdAccidentbrief();
		ddAccidentbrief.setFaccidentid(ddAccidentbriefId);
		ddAccidentbrief.setVersion(Integer.valueOf(version).intValue());
		ddAccidentbriefDao.delete(ddAccidentbrief);
	}

	// 用于实现基本删除集合操作
	public void deleteDdAccidentbrief(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdAccidentbrief.class, dtos);
		ddAccidentbriefDao.deleteAll(pos);
	}

	// 用于实现基本DTOLOAD操作
	public DdAccidentbriefDto loadDdAccidentbrief(String faccidentid) {
		DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) ddAccidentbriefDao
				.findByPk(faccidentid);
		DdAccidentbriefDto dto = (DdAccidentbriefDto) BeanHelper.buildBean(
				DdAccidentbriefDto.class, ddAccidentbrief);
		return dto;
	}

	// 用于实现列表操作
	public QueryListObj listDdAccidentbrief() {
		QueryListObj obj = ddAccidentbriefDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdAccidentbriefDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj listDdAccidentbriefByHql(String hql) {
		QueryListObj obj = ddAccidentbriefDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdAccidentbriefDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getDdAccidentbriefByHql(String hql, int beginPage,
			int pageSize, String sql) {
		QueryListObj obj = ddAccidentbriefDao.getQueryListByHql(hql, beginPage,
				pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdAccidentbriefDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}

		List sumList = ddAccidentbriefDao.getObjPropertySums(sql);
		// System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	/**
	 * @business method list
	 * @拟定操作票
	 * 
	 * @工作流－调度值长审核故障简报
	 * 
	 * @盖处理完章
	 * 
	 * @合格性检查
	 * 
	 * @故障转计划
	 * 
	 * @工作流－执行
	 * @工作流－修改
	 * @工作流－归档
	 */

	// please add your business methods start
	// to do it
	// add your business method end
	public IDdAccidentbriefDao getDdAccidentbriefDao() {
		return ddAccidentbriefDao;
	}

	public void setDdAccidentbriefDao(IDdAccidentbriefDao ddAccidentbriefDao) {
		this.ddAccidentbriefDao = ddAccidentbriefDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void saveOrUpdateDdAccidentbrief(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdAccidentbriefDto ddAccidentbriefDto = (DdAccidentbriefDto) dtos
					.get(i);
			DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) BeanHelper
					.mapBean(DdAccidentbrief.class, ddAccidentbriefDto);
			pos.add(ddAccidentbrief);
		}

		ddAccidentbriefDao.saveOrUpdateAll(pos);
	}

	// 注册工作流服务

	public IDdAccidentbriefWFService getDdAccidentbriefWFService() {
		return ddAccidentbriefWFService;
	}

	public void setDdAccidentbriefWFService(
			IDdAccidentbriefWFService ddAccidentbriefWFService) {
		this.ddAccidentbriefWFService = ddAccidentbriefWFService;
	}

	// 子表处理DAO

	public QueryListObj getAccidentList() {

		Date dateStr = DateUtil.stringToSqlDate(DateUtil.getCurrentTimestamp()
				.toString());// to_char(sysdate,'yyyymmdd')

		StringBuffer hql = new StringBuffer();

		hql.append(" from DdAccidentbrief dba,StdStation ss ");

		hql.append(" where 1=1 ");

		hql.append(" and dba.fstationid = ss.id ");

		hql.append(" and ss.voltagelevel=220 ");

		// hql.append(" and dba.fvoltage=220 ");

		hql.append(" and dba.faccidenttime ");

		hql.append(" between to_date('" + dateStr
				+ " 00:00:00','YYYY-MM-DD HH24:MI:SS') ");

		hql.append(" and to_date('" + dateStr
				+ " 23:59:59','YYYY-MM-DD HH24:MI:SS') ");

		QueryListObj obj = ddAccidentbriefDao.getQueryListByHql(hql.toString());

		if (obj.getElemList() != null) {

			List dtos = (List) BeanHelper.buildBeans(DdAccidentbrief.class, obj

			.getElemList());

			obj.setElemList(dtos);

		}

		return obj;

	}

	public QueryListObj listBhActionrecord() {
		QueryListObj obj = bhActionrecordDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhActionrecordDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateBhActionrecord(BhActionrecordDto dto) {

		if (StringUtils.isEmpty(dto.getProtectionrecordid())) {
			if (StringUtils.isEmpty(dto.getProtectionrecordid())) {
				dto.setProtectionrecordid(new SequenceCreator().getUID());
			}
		}
		BhActionrecord bhActionrecord = (BhActionrecord) BeanHelper.buildBean(
				BhActionrecord.class, dto);
		bhActionrecordDao.saveOrUpdate(bhActionrecord);

	}

	public void deleteBhActionrecord(String protectionrecordid) {

		BhActionrecord bhActionrecord = new BhActionrecord();
		bhActionrecord.setProtectionrecordid(protectionrecordid);
		bhActionrecordDao.delete(bhActionrecord);

	}

	public BhActionrecordDto loadBhActionrecord(String protectionrecordid) {
		BhActionrecord bhActionrecord = (BhActionrecord) bhActionrecordDao
				.findByPk(protectionrecordid);
		BhActionrecordDto dto = (BhActionrecordDto) BeanHelper.buildBean(
				BhActionrecordDto.class, bhActionrecord);
		return dto;
	}

	public QueryListObj listBhActionrecordByHql(String hql) {
		QueryListObj obj = bhActionrecordDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(BhActionrecordDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateBhActionrecord(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			BhActionrecordDto bhActionrecordDto = (BhActionrecordDto) dtos
					.get(i);
			BhActionrecord bhActionrecord = (BhActionrecord) BeanHelper
					.buildBean(BhActionrecord.class, bhActionrecordDto);
			pos.add(bhActionrecord);
		}

		bhActionrecordDao.saveOrUpdateAll(pos);

	}

	public void deleteBhActionrecord(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(BhActionrecord.class, dtos);
		bhActionrecordDao.deleteAll(pos);
	}

	public QueryListObj listDdAccidentbriefprocess() {
		QueryListObj obj = ddAccidentbriefprocessDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DdAccidentbriefprocessDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdAccidentbriefprocess(DdAccidentbriefprocessDto dto) {

		if (StringUtils.isEmpty(dto.getFstepid())) {
			if (StringUtils.isEmpty(dto.getFstepid())) {
				dto.setFstepid(new SequenceCreator().getUID());
			}
		}
		DdAccidentbriefprocess ddAccidentbriefprocess = (DdAccidentbriefprocess) BeanHelper
				.buildBean(DdAccidentbriefprocess.class, dto);
		ddAccidentbriefprocessDao.saveOrUpdate(ddAccidentbriefprocess);

	}

	public void deleteDdAccidentbriefprocess(String fstepid) {

		DdAccidentbriefprocess ddAccidentbriefprocess = new DdAccidentbriefprocess();
		ddAccidentbriefprocess.setFstepid(fstepid);
		ddAccidentbriefprocessDao.delete(ddAccidentbriefprocess);

	}

	public DdAccidentbriefprocessDto loadDdAccidentbriefprocess(String fstepid) {
		DdAccidentbriefprocess ddAccidentbriefprocess = (DdAccidentbriefprocess) ddAccidentbriefprocessDao
				.findByPk(fstepid);
		DdAccidentbriefprocessDto dto = (DdAccidentbriefprocessDto) BeanHelper
				.buildBean(DdAccidentbriefprocessDto.class,
						ddAccidentbriefprocess);
		return dto;
	}

	public QueryListObj listDdAccidentbriefprocessByHql(String hql) {
		QueryListObj obj = ddAccidentbriefprocessDao.getQueryListByHql(hql);
		if (obj.getElemList() != null && obj.getElemList().size() > 0) {
			List dtos = (List) BeanHelper.mapBeans(
					DdAccidentbriefprocessDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdAccidentbriefprocess(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdAccidentbriefprocessDto ddAccidentbriefprocessDto = (DdAccidentbriefprocessDto) dtos
					.get(i);
			DdAccidentbriefprocess ddAccidentbriefprocess = (DdAccidentbriefprocess) BeanHelper
					.mapBean(DdAccidentbriefprocess.class,
							ddAccidentbriefprocessDto);

			if (StringUtils.isEmpty(ddAccidentbriefprocess.getFstepid())) {
				ddAccidentbriefprocess.setFstepid(new SequenceCreator()
						.getUID());
			}
			pos.add(ddAccidentbriefprocess);
		}

		ddAccidentbriefprocessDao.saveOrUpdateAll(pos);

	}

	public void deleteDdAccidentbriefprocess(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdAccidentbriefprocess.class, dtos);
		ddAccidentbriefprocessDao.deleteAll(pos);
	}

	public void start(WorkflowHandleDto dto) throws DataAccessException {
		int ireturn = ddAccidentbriefWFService.start(dto);
	}

	public void approve(WorkflowHandleDto dto) throws DataAccessException {

		int ireturn = ddAccidentbriefWFService.ddAccidentBriefApprove(dto);

		// else if (dto.getTransitionFlag().equals("1")) {
		//
		// DdAccidentbrief ddAccidentbrief = ddAccidentbriefDao.findByPk(dto
		// .getBusId());
		// ddAccidentbrief
		// .setFstatus(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_STATUS_EXE);
		// ddAccidentbrief
		// .setFexcutestatus(DispatchConstants.ddAccidentbrief_auditing);
		// ddAccidentbriefDao.saveOrUpdate(ddAccidentbrief);
		// }
	}

	public void modify(WorkflowHandleDto dto) {
		int ireturn = ddAccidentbriefWFService.ddAccidentBriefModify(dto);

	}

	public void execute(WorkflowHandleDto dto) {
		int ireturn = ddAccidentbriefWFService.ddAccidentBriefExecute(dto);

	}

}
