package com.techstar.dmis.service.impl;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.ICtrlWflentityrelDao;
import com.techstar.dmis.dao.IDayplancoopraterelDao;
import com.techstar.dmis.dao.IDdDayplandelaylistDao;
import com.techstar.dmis.dao.IDdDayplanexcutelistDao;
import com.techstar.dmis.dao.IDdDoutageplanDao;
import com.techstar.dmis.dao.IDdfsModechangelistDao;
import com.techstar.dmis.dao.IZdhOpexaminelistDao;
import com.techstar.dmis.dto.DayplancoopraterelDto;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdDayplandelaylistDto;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.dto.DdWoutageplanDto;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.entity.CtrlWflentityrel;
import com.techstar.dmis.entity.Dayplancoopraterel;
import com.techstar.dmis.entity.DdAccidentbrief;
import com.techstar.dmis.entity.DdDayplandelaylist;
import com.techstar.dmis.entity.DdDayplanexcutelist;
import com.techstar.dmis.entity.DdDoutageplan;
import com.techstar.dmis.entity.DdMoutageplan;
import com.techstar.dmis.entity.DdWoutageplan;
import com.techstar.dmis.entity.DdfsModechangelist;
import com.techstar.dmis.entity.ZdhOpexaminelist;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.IDdAccidentbriefService;
import com.techstar.dmis.service.IDdDoutageplanService;
import com.techstar.dmis.service.IDdMoutageplanService;
import com.techstar.dmis.service.IDdWoutageplanService;
import com.techstar.dmis.service.workflow.IDdDoutageplanWFService;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.techstar.framework.dao.IBaseJdbcDao;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import com.techstar.framework.ui.web.tag.engine.DateUtil;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.springframework.dao.DataAccessException;

//注册子表DAO
import com.techstar.dmis.dto.DdRepairdetailDto;
import com.techstar.dmis.entity.DdRepairdetail;
import com.techstar.dmis.dto.DdDayplandelaylistDto;
import com.techstar.dmis.entity.DdDayplandelaylist;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.entity.DdDayplanexcutelist;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.entity.DdfsModechangelist;
import com.techstar.dmis.dto.DayplancoopraterelDto;
import com.techstar.dmis.entity.Dayplancoopraterel;
import com.techstar.dmis.dto.DdDayplanfixvaluerelDto;
import com.techstar.dmis.entity.DdDayplanfixvaluerel;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.entity.ZdhOpexaminelist;
import com.techstar.dmis.dto.StdUnfinishreasonDto;
import com.techstar.dmis.entity.StdUnfinishreason;
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
public class DdDoutageplanServiceImpl implements IDdDoutageplanService {
	// 注册DAO
	private IDdDoutageplanDao ddDoutageplanDao;

	private IBaseJdbcDao baseJdbcDao;

	private IDdDoutageplanWFService ddDoutageplanWFService;

	private IDdAccidentbriefService ddAccidentbriefService;
	private IDdMoutageplanService   ddMoutageplanService;
    private IDdWoutageplanService ddwoutageService;

    private ICtrlWflentityrelDao ctrlWflentityrelDao;
	// 注册管理DAOqqwqwqwqwqwqw


	private IDdDayplandelaylistDao ddDayplandelaylistDao;

    private IWorkflowDao workFlowDao;

	public void setDdDayplandelaylistDao(
			IDdDayplandelaylistDao ddDayplandelaylistDao) {
		this.ddDayplandelaylistDao = ddDayplandelaylistDao;
	}

	private IDdDayplanexcutelistDao ddDayplanexcutelistDao;

	public void setDdDayplanexcutelistDao(
			IDdDayplanexcutelistDao ddDayplanexcutelistDao) {
		this.ddDayplanexcutelistDao = ddDayplanexcutelistDao;
	}

	private IDdfsModechangelistDao ddfsModechangelistDao;

	public void setDdfsModechangelistDao(
			IDdfsModechangelistDao ddfsModechangelistDao) {
		this.ddfsModechangelistDao = ddfsModechangelistDao;
	}

	private IDayplancoopraterelDao dayplancoopraterelDao;

	public void setDayplancoopraterelDao(
			IDayplancoopraterelDao dayplancoopraterelDao) {
		this.dayplancoopraterelDao = dayplancoopraterelDao;
	}
	/*
	private IDdDayplanfixvaluerelDao ddDayplanfixvaluerelDao;


	public void setDdDayplanfixvaluerelDao(
			IDdDayplanfixvaluerelDao ddDayplanfixvaluerelDao) {
		this.ddDayplanfixvaluerelDao = ddDayplanfixvaluerelDao;
	}
	private IDdRepairdetailDao ddRepairdetailDao;

	public void setDdRepairdetailDao(IDdRepairdetailDao ddRepairdetailDao) {
		this.ddRepairdetailDao = ddRepairdetailDao;
	}*/
	private IZdhOpexaminelistDao zdhOpexaminelistDao;

	public void setZdhOpexaminelistDao(IZdhOpexaminelistDao zdhOpexaminelistDao) {
		this.zdhOpexaminelistDao = zdhOpexaminelistDao;
	}




	public DdDoutageplanServiceImpl() {
	}

	public void addDdDoutageplan(DdDoutageplanDto dto) {

		if (StringUtils.isEmpty(dto.getFdayplanno())) {
			if (StringUtils.isEmpty(dto.getFdayplanno())) {
				dto.setFdayplanno(new SequenceCreator().getUID());
			}
		}
		// 新增时候,主对象不用管子对象的保存
		DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.buildBean(
				DdDoutageplan.class, dto);
		ddDoutageplanDao.saveOrUpdate(ddDoutageplan);
	}

	// 用于实现基本增加或修改操作

	public void saveOrUpdateDdDoutageplan(DdDoutageplanDto dto) {
			if (StringUtils.isEmpty(dto.getFdayplanno())) {
				dto.setFdayplanno(new SequenceCreator().getUID());
			}

		DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.mapBean(
				DdDoutageplan.class, dto);
		ddDoutageplanDao.saveOrUpdate(ddDoutageplan);
	}


	public void saveOrUpdateDdDoutageplan(DdDoutageplanDto daydto,DdWoutageplanDto woudto,DdAccidentbriefDto ddacdto){

		DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.mapBean(
				DdDoutageplan.class, daydto);
		ddDoutageplanDao.saveOrUpdate(ddDoutageplan);
		if(woudto!=null){
			this.ddwoutageService.saveOrUpdateDdWoutageplan(woudto);
		}
		if(ddacdto!=null){
			this.ddAccidentbriefService.saveOrUpdateDdAccidentbrief(ddacdto);
		}

	}

	/**
	 * 取消日计划
	 * @param wdto
	 * @param daydto
	 * @param monthedto
	 * @param ddacdto
	 */
	public void cancleDdDoutageplan(WorkflowHandleDto wdto,DdDoutageplanDto daydto,DdWoutageplanDto woutdto){
		int ireturn = ddDoutageplanWFService.ddDayPlanEnd(wdto);
		if(ireturn==1){
			saveOrUpdateDdDoutageplan(daydto,woutdto,null);
		}
	}

	// 用于实现基本删除操作
	public void deleteDdDoutageplan(String ddDoutageplanId) {
		DdDoutageplan ddDoutageplan = new DdDoutageplan();
		ddDoutageplan.setFdayplanno(ddDoutageplanId);
		ddDoutageplanDao.delete(ddDoutageplan);
	}

	// 用于实现基本删除集合操作
	public void deleteDdDoutageplan(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdDoutageplan.class, dtos);
		ddDoutageplanDao.deleteAll(pos);
	}

	// 用于实现基本DTOLOAD操作
	public DdDoutageplanDto loadDdDoutageplan(String fdayplanno) {
		DdDoutageplan ddDoutageplan = (DdDoutageplan) ddDoutageplanDao
				.findByPk(fdayplanno);
		DdDoutageplanDto dto = (DdDoutageplanDto) BeanHelper.mapBean(
				DdDoutageplanDto.class, ddDoutageplan);
		return dto;
	}

	// 用于实现列表操作
	public QueryListObj listDdDoutageplan() {
		QueryListObj obj = ddDoutageplanDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void deleteDdDoutageplan(DdDoutageplanDto dto) {
		if (dto != null) {
			DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.buildBean(
					DdDoutageplan.class, dto);
			ddDoutageplanDao.delete(ddDoutageplan);
		}
	}

	public QueryListObj listDdDoutageplanByHql(String hql) {
		QueryListObj obj = ddDoutageplanDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getDdDoutageplanByHql(String hql, int beginPage,
			int pageSize, String sql) {
		QueryListObj obj = ddDoutageplanDao.getQueryListByHql(hql, beginPage,
				pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdDoutageplanDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}

		List sumList = ddDoutageplanDao.getObjPropertySums(sql);
		// System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
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

	// please add your business methods start
	// to do it
	// add your business method end
	public IDdDoutageplanDao getDdDoutageplanDao() {
		return ddDoutageplanDao;
	}

	public void setDdDoutageplanDao(IDdDoutageplanDao ddDoutageplanDao) {
		this.ddDoutageplanDao = ddDoutageplanDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void saveOrUpdateDdDoutageplan(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdDoutageplanDto ddDoutageplanDto = (DdDoutageplanDto) dtos.get(i);
			DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.mapBean(
					DdDoutageplan.class, ddDoutageplanDto);
			pos.add(ddDoutageplan);
		}

		ddDoutageplanDao.saveOrUpdateAll(pos);
	}



	/**
	 * 日计划执行(不带工作流的)
	 * @param days
	 * @param monthes
	 * @param accidents
	 */
	public void saveOrUpdateDdDoutageplan(List days,List woutes,List accidents){
		List daylist = new ArrayList();
		List woutlist=null;
		List accdentlist=null ;
		for (int i = 0; i < days.size(); i++) {
			DdDoutageplanDto ddDoutageplanDto = (DdDoutageplanDto) days.get(i);
			DdDoutageplan ddDoutageplan = (DdDoutageplan) BeanHelper.mapBean(
					DdDoutageplan.class, ddDoutageplanDto);
			daylist.add(ddDoutageplan);
		}
		//回填旬计划
		if(woutes!=null&&woutes.size()!=0){
			woutlist = new ArrayList();
			for (int i = 0; i < woutes.size(); i++) {
				DdWoutageplanDto ddWoutageplanDto = (DdWoutageplanDto) woutes.get(i);
				DdWoutageplan ddwoutageplan = (DdWoutageplan) BeanHelper.buildBean(
						DdWoutageplan.class, ddWoutageplanDto);
				woutlist.add(ddwoutageplan);
			}
		}
		//回填事故
		if(accidents!=null&&accidents.size()!=0){
			accdentlist = new ArrayList();
			for (int i = 0; i < accidents.size(); i++) {
				DdAccidentbriefDto ddAccidentbriefDto = (DdAccidentbriefDto) accidents
						.get(i);
				DdAccidentbrief ddAccidentbrief = (DdAccidentbrief) BeanHelper
						.mapBean(DdAccidentbrief.class, ddAccidentbriefDto);
				accdentlist.add(ddAccidentbrief);
			}
		}

		ddDoutageplanDao.saveOrUpdateAll(daylist);
		if(woutlist!=null){
			ddDoutageplanDao.saveOrUpdateAll(woutlist);
		}

		if(accdentlist!=null){
			ddDoutageplanDao.saveOrUpdateAll(accdentlist);
		}
	}
	// 子表处理DAO
   /*
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
	}*/

	// 延期
	public QueryListObj listDdDayplandelaylist() {
		QueryListObj obj = ddDayplandelaylistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DdDayplandelaylistDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdDayplandelaylist(DdDayplandelaylistDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		DdDayplandelaylist ddDayplandelaylist = (DdDayplandelaylist) BeanHelper
				.buildBean(DdDayplandelaylist.class, dto);
		ddDayplandelaylistDao.saveOrUpdate(ddDayplandelaylist);

	}

	public void deleteDdDayplandelaylist(String fid) {

		DdDayplandelaylist ddDayplandelaylist = new DdDayplandelaylist();
		ddDayplandelaylist.setFid(fid);
		ddDayplandelaylistDao.delete(ddDayplandelaylist);

	}

	public DdDayplandelaylistDto loadDdDayplandelaylist(String fid) {
		DdDayplandelaylist ddDayplandelaylist = (DdDayplandelaylist) ddDayplandelaylistDao
				.findByPk(fid);
		DdDayplandelaylistDto dto = (DdDayplandelaylistDto) BeanHelper
				.buildBean(DdDayplandelaylistDto.class, ddDayplandelaylist);
		return dto;
	}

	public QueryListObj listDdDayplandelaylistByHql(String hql) {
		QueryListObj obj = ddDayplandelaylistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdDayplandelaylistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
			obj.setCount(dtos.size());
		}
		return obj;
	}

	public void saveOrUpdateDdDayplandelaylist(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdDayplandelaylistDto dto = (DdDayplandelaylistDto) dtos.get(i);
			DdDayplandelaylist entity = (DdDayplandelaylist) BeanHelper
					.mapBean(DdDayplandelaylist.class, dto);
			if (StringUtils.isEmpty(entity.getFid()))
				entity.setFid(new SequenceCreator().getUID());
			// entity.setZddfsmodechangelist5(null);
			pos.add(entity);
		}
		ddDayplandelaylistDao.saveOrUpdateAll(pos);

	}

	public void deleteDdDayplandelaylist(List dtos) {
		for (int i = 0; i < dtos.size(); i++) {
			DdDayplandelaylistDto dto = (DdDayplandelaylistDto) dtos.get(i);
			DdDayplandelaylist ddm = (DdDayplandelaylist) BeanHelper.buildBean(
					DdDayplandelaylist.class, dto);
			ddDayplandelaylistDao.delete(ddm);
		}
	}

	/*
	 * public QueryListObj listDdDayplandelaylistByHql(String hql){ QueryListObj
	 * obj = dao3.getQueryListByHql(hql); if (obj.getElemList() != null) { List
	 * dtos = (List) BeanHelper.mapBeans(DdDayplandelaylistDto.class, obj
	 * .getElemList()); obj.setElemList(dtos); obj.setCount(dtos.size()); }
	 * return obj; }
	 *
	 * public void saveOrUpdateDdDayplandelaylist(List dtos) { List pos = new
	 * ArrayList(); for(int i=0;i<dtos.size();i++){ DdDayplandelaylistDto dto =
	 * (DdDayplandelaylistDto)dtos.get(i); DdDayplandelaylist entity =
	 * (DdDayplandelaylist) BeanHelper.mapBean(DdDayplandelaylist.class, dto);
	 * if(StringUtils.isEmpty(entity.getFid())) entity.setFid(new
	 * SequenceCreator().getUID()); //entity.setZddfsmodechangelist5(null);
	 * pos.add(entity); } dao3.saveOrUpdateAll(pos); }
	 *
	 * public void deleteDdDayplandelaylist(List dtos){ for(int i=0;i<dtos.size();i++){
	 * DdDayplandelaylistDto dto = (DdDayplandelaylistDto)dtos.get(i);
	 * DdDayplandelaylist ddm =
	 * (DdDayplandelaylist)BeanHelper.buildBean(DdDayplandelaylist.class, dto);
	 * dao3.delete(ddm); }
	 *  }
	 *  }
	 */

	// 执行
	public QueryListObj listDdDayplanexcutelist() {
		QueryListObj obj = ddDayplanexcutelistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DdDayplanexcutelistDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdDayplanexcutelist(DdDayplanexcutelistDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		DdDayplanexcutelist ddDayplanexcutelist = (DdDayplanexcutelist) BeanHelper
				.mapBean(DdDayplanexcutelist.class, dto);
		ddDayplanexcutelistDao.saveOrUpdate(ddDayplanexcutelist);

	}

	public void deleteDdDayplanexcutelist(String fid) {

		DdDayplanexcutelist ddDayplanexcutelist = new DdDayplanexcutelist();
		ddDayplanexcutelist.setFid(fid);
		ddDayplanexcutelistDao.delete(ddDayplanexcutelist);

	}

	public DdDayplanexcutelistDto loadDdDayplanexcutelist(String fid) {
		DdDayplanexcutelist ddDayplanexcutelist = (DdDayplanexcutelist) ddDayplanexcutelistDao
				.findByPk(fid);
		DdDayplanexcutelistDto dto = (DdDayplanexcutelistDto) BeanHelper
				.mapBean(DdDayplanexcutelistDto.class, ddDayplanexcutelist);
		return dto;
	}

	public QueryListObj listDdDayplanexcutelistByHql(String hql) {
		QueryListObj obj = ddDayplanexcutelistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(
					DdDayplanexcutelistDto.class, obj.getElemList());
			obj.setElemList(dtos);
			obj.setCount(dtos.size());
		}
		return obj;
	}

	public void saveOrUpdateDdDayplanexcutelist(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdDayplanexcutelistDto dto = (DdDayplanexcutelistDto) dtos.get(i);
			DdDayplanexcutelist entity = (DdDayplanexcutelist) BeanHelper
					.mapBean(DdDayplanexcutelist.class, dto);
			if (StringUtils.isEmpty(entity.getFid()))
				entity.setFid(new SequenceCreator().getUID());
			// entity.setZddfsmodechangelist5(null);
			pos.add(entity);
		}
		ddDayplanexcutelistDao.saveOrUpdateAll(pos);

	}

	public void deleteDdDayplanexcutelist(List dtos) {
		for (int i = 0; i < dtos.size(); i++) {
			DdDayplanexcutelistDto dto = (DdDayplanexcutelistDto) dtos.get(i);
			DdDayplanexcutelist ddm = (DdDayplanexcutelist) BeanHelper
					.buildBean(DdDayplanexcutelist.class, dto);
			ddDayplanexcutelistDao.delete(ddm);
		}
	}

	/*
	 * public QueryListObj listDdDayplanexcutelistByHql(String hql){
	 * QueryListObj obj = dao3.getQueryListByHql(hql); if (obj.getElemList() !=
	 * null) { List dtos = (List)
	 * BeanHelper.mapBeans(DdDayplanexcutelistDto.class, obj .getElemList());
	 * obj.setElemList(dtos); obj.setCount(dtos.size()); } return obj; }
	 *
	 * public void saveOrUpdateDdDayplanexcutelist(List dtos) { List pos = new
	 * ArrayList(); for(int i=0;i<dtos.size();i++){ DdDayplanexcutelistDto dto =
	 * (DdDayplanexcutelistDto)dtos.get(i); DdDayplanexcutelist entity =
	 * (DdDayplanexcutelist) BeanHelper.mapBean(DdDayplanexcutelist.class, dto);
	 * if(StringUtils.isEmpty(entity.getFid())) entity.setFid(new
	 * SequenceCreator().getUID()); //entity.setZddfsmodechangelist5(null);
	 * pos.add(entity); } dao3.saveOrUpdateAll(pos); }
	 *
	 * public void deleteDdDayplanexcutelists(List dtos){
	 *
	 * for(int i=0;i<dtos.size();i++){ DdDayplanexcutelistDto dto =
	 * (DdDayplanexcutelistDto)dtos.get(i); DdDayplanexcutelist ddm =
	 * (DdDayplanexcutelist)BeanHelper.buildBean(DdDayplanexcutelist.class,
	 * dto); dao2.delete(ddm); }
	 *  }
	 */

	// 方式
	public QueryListObj listDdfsModechangelist() {
		QueryListObj obj = ddfsModechangelistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DdfsModechangelistDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdfsModechangelist(DdfsModechangelistDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		DdfsModechangelist ddfsModechangelist = (DdfsModechangelist) BeanHelper
				.buildBean(DdfsModechangelist.class, dto);
		ddfsModechangelistDao.saveOrUpdate(ddfsModechangelist);

	}

	public void deleteDdfsModechangelist(String fid) {

		DdfsModechangelist ddfsModechangelist = new DdfsModechangelist();
		ddfsModechangelist.setFid(fid);
		ddfsModechangelistDao.delete(ddfsModechangelist);

	}

	public DdfsModechangelistDto loadDdfsModechangelist(String fid) {
		DdfsModechangelist ddfsModechangelist = (DdfsModechangelist) ddfsModechangelistDao
				.findByPk(fid);
		DdfsModechangelistDto dto = (DdfsModechangelistDto) BeanHelper
				.buildBean(DdfsModechangelistDto.class, ddfsModechangelist);
		return dto;
	}

	public QueryListObj listDdfsModechangelistByHql(String hql) {
		QueryListObj obj = ddfsModechangelistDao.getQueryListByHql(hql);
		// DdfsModechangelist po =(DdfsModechangelist)obj.getElemList().get(0);
		// DdfsModechangelistDto dto
		// =(DdfsModechangelistDto)BeanHelper.buildBean(DdfsModechangelistDto.class,
		// po);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdfsModechangelistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
			obj.setCount(dtos.size());
		}
		return obj;
	}

	public void saveOrUpdateDdfsModechangelist(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdfsModechangelistDto dto = (DdfsModechangelistDto) dtos.get(i);
			DdfsModechangelist entity = (DdfsModechangelist) BeanHelper
					.mapBean(DdfsModechangelist.class, dto);
			if (StringUtils.isEmpty(entity.getFid()))
				entity.setFid(new SequenceCreator().getUID());
			entity.setZddfsmodechangelist5(null);
			pos.add(entity);
		}

		ddfsModechangelistDao.saveOrUpdateAll(pos);

	}

	public void deleteDdfsModechangelist(List dtos) {

		for (int i = 0; i < dtos.size(); i++) {
			DdfsModechangelistDto dto = (DdfsModechangelistDto) dtos.get(i);
			DdfsModechangelist ddm = (DdfsModechangelist) BeanHelper.buildBean(
					DdfsModechangelist.class, dto);
			ddfsModechangelistDao.delete(ddm);
		}
	}

	/*
	 *
	 * public QueryListObj listDdfsModechangelistByHql(String hql){ QueryListObj
	 * obj = dao.getQueryListByHql(hql); //DdfsModechangelist po
	 * =(DdfsModechangelist)obj.getElemList().get(0); //DdfsModechangelistDto
	 * dto
	 * =(DdfsModechangelistDto)BeanHelper.buildBean(DdfsModechangelistDto.class,
	 * po); if (obj.getElemList() != null) { List dtos = (List)
	 * BeanHelper.mapBeans(DdfsModechangelistDto.class, obj .getElemList());
	 * obj.setElemList(dtos); obj.setCount(dtos.size()); } return obj; }
	 *
	 * public void saveOrUpdateDdfsModechangelist(List dtos) { List pos = new
	 * ArrayList(); for(int i=0;i<dtos.size();i++){ DdfsModechangelistDto dto =
	 * (DdfsModechangelistDto)dtos.get(i); DdfsModechangelist entity =
	 * (DdfsModechangelist) BeanHelper.mapBean(DdfsModechangelist.class, dto);
	 * if(StringUtils.isEmpty(entity.getFid())) entity.setFid(new
	 * SequenceCreator().getUID()); entity.setZddfsmodechangelist5(null);
	 * pos.add(entity); } dao.saveOrUpdateAll(pos); }
	 *
	 * //用于实现基本删除操作 public void deleteDdfsModechangelist(String ddmid,int
	 * version) { DdfsModechangelist ddm = new DdfsModechangelist();
	 * ddm.setFid(ddmid); ddm.setVersion(version); dao.delete(ddm); }
	 *
	 *
	 * public void deleteDdfsModechangelists(List dtos){
	 *
	 * for(int i=0;i<dtos.size();i++){ DdfsModechangelistDto dto =
	 * (DdfsModechangelistDto)dtos.get(i); DdfsModechangelist ddm =
	 * (DdfsModechangelist)BeanHelper.buildBean(DdfsModechangelist.class, dto);
	 * dao.delete(ddm); }
	 *  }
	 */

	// 配合
	public QueryListObj listDayplancoopraterel() {
		QueryListObj obj = dayplancoopraterelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DayplancoopraterelDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDayplancoopraterel(DayplancoopraterelDto dto) {

		if (StringUtils.isEmpty(dto.getFrelid())) {
			if (StringUtils.isEmpty(dto.getFrelid())) {
				dto.setFrelid(new SequenceCreator().getUID());
			}
		}
		Dayplancoopraterel dayplancoopraterel = (Dayplancoopraterel) BeanHelper
				.buildBean(Dayplancoopraterel.class, dto);
		dayplancoopraterelDao.saveOrUpdate(dayplancoopraterel);

	}

	public void deleteDayplancoopraterel(String frelid) {

		Dayplancoopraterel dayplancoopraterel = new Dayplancoopraterel();
		dayplancoopraterel.setFrelid(frelid);
		dayplancoopraterelDao.delete(dayplancoopraterel);

	}

	public DayplancoopraterelDto loadDayplancoopraterel(String frelid) {
		Dayplancoopraterel dayplancoopraterel = (Dayplancoopraterel) dayplancoopraterelDao
				.findByPk(frelid);
		DayplancoopraterelDto dto = (DayplancoopraterelDto) BeanHelper
				.buildBean(DayplancoopraterelDto.class, dayplancoopraterel);
		return dto;
	}

	public QueryListObj listDayplancoopraterelByHql(String hql) {
		QueryListObj obj = dayplancoopraterelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null && obj.getElemList().size() != 0) {
			List dtos = (List) BeanHelper.mapBeans(DayplancoopraterelDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj listDayplancoopraterelByGroupHql(String hql) {
		QueryListObj obj = dayplancoopraterelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null && obj.getElemList().size() != 0) {
			ArrayList list = new ArrayList();
			for (int i = 0; i < obj.getElemList().size(); i++) {
				DayplancoopraterelDto dto = new DayplancoopraterelDto();
				Object[] dates = (Object[]) obj.getElemList().get(i);
				String name = (String) dates[0];
				Date date = (Date) dates[1];
				String dd = DateUtil.dateToString(date, "yyyy-MM-dd");
				java.sql.Date value = ("".equals(dd) || dd == null) ? null
						: DateUtil.stringToSqlDate(dd, "yyyy-MM-dd");
				dto.setCooperatedate(value);
				dto.setFcooperatename(name);
				list.add(dto);
			}
			obj.setElemList(list);
		}
		return obj;
	}
	public QueryListObj getElearlydate(String hql) {
		return dayplancoopraterelDao.getQueryListByHql(hql);

	}

	public void saveOrUpdateDayplancoopraterel(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DayplancoopraterelDto dayplancoopraterelDto = (DayplancoopraterelDto) dtos
					.get(i);
			Dayplancoopraterel dayplancoopraterel = (Dayplancoopraterel) BeanHelper
					.mapBean(Dayplancoopraterel.class, dayplancoopraterelDto);
			pos.add(dayplancoopraterel);
		}

		dayplancoopraterelDao.saveOrUpdateAll(pos);

	}

	public void deleteDayplancoopraterel(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(Dayplancoopraterel.class, dtos);
		dayplancoopraterelDao.deleteAll(pos);
	}

	public void joinDayplancoopraterel(String name, String date, String[] ids) {
		// select b from DdDoutageplan b ,Dayplancoopraterel d where
		// b.fdayplanno=d.zdayplancoopraterel1.fdayplanno and
		// to_char(d.cooperatedate,'YYYY-MM-DD')='"+cooperatedate+"' and
		// d.fcooperatename='"+fcooperatename+"'";
		String hql = "select d from Dayplancoopraterel d where  to_char(d.cooperatedate,'YYYY-MM-DD')='"
				+ date + "' and d.fcooperatename='" + name + "'";
		QueryListObj obj = this.listDayplancoopraterelByHql(hql);

		ArrayList list = new ArrayList();
		if (isNewcoopraterel(obj)) {
			// 第一次加配合
			for (int i = 0; i < ids.length; i++) {
				DayplancoopraterelDto dto = new DayplancoopraterelDto();
				if (i == 0) {
					dto = (DayplancoopraterelDto) (obj.getElemList().get(0));
				}
				dto.setCooperatedate(("".equals(date) || date == null) ? null
						: DateUtil.stringToSqlDate(date, "yyyy-MM-dd"));
				dto.setFcooperatename(name);
				DdDoutageplanDto dayplandto = new DdDoutageplanDto();
				dayplandto.setFdayplanno(ids[i]);
				dto.setZdayplancoopraterel1(dayplandto);
				list.add(dto);
			}

		} else {
			for (int i = 0; i < ids.length; i++) {
				DayplancoopraterelDto dto = new DayplancoopraterelDto();
				dto.setCooperatedate(("".equals(date) || date == null) ? null
						: DateUtil.stringToSqlDate(date, "yyyy-MM-dd"));
				dto.setFcooperatename(name);
				DdDoutageplanDto dayplandto = new DdDoutageplanDto();
				dayplandto.setFdayplanno(ids[i]);
				dto.setZdayplancoopraterel1(dayplandto);
				list.add(dto);
			}

		}

		this.saveOrUpdateDayplancoopraterel(list);

	}

	private boolean isNewcoopraterel(QueryListObj obj) {
		if (obj.getElemList().size() == 1) {
			DayplancoopraterelDto dto = (DayplancoopraterelDto) (obj
					.getElemList().get(0));
			if (dto.getZdayplancoopraterel1() == null) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
/*
	public QueryListObj listDdDayplanfixvaluerel() {
		QueryListObj obj = ddDayplanfixvaluerelDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DdDayplanfixvaluerelDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdDayplanfixvaluerel(DdDayplanfixvaluerelDto dto) {

		if (StringUtils.isEmpty(dto.getFrelid())) {
			if (StringUtils.isEmpty(dto.getFrelid())) {
				dto.setFrelid(new SequenceCreator().getUID());
			}
		}
		DdDayplanfixvaluerel ddDayplanfixvaluerel = (DdDayplanfixvaluerel) BeanHelper
				.buildBean(DdDayplanfixvaluerel.class, dto);
		ddDayplanfixvaluerelDao.saveOrUpdate(ddDayplanfixvaluerel);

	}

	public void deleteDdDayplanfixvaluerel(String frelid) {

		DdDayplanfixvaluerel ddDayplanfixvaluerel = new DdDayplanfixvaluerel();
		ddDayplanfixvaluerel.setFrelid(frelid);
		ddDayplanfixvaluerelDao.delete(ddDayplanfixvaluerel);

	}

	public DdDayplanfixvaluerelDto loadDdDayplanfixvaluerel(String frelid) {
		DdDayplanfixvaluerel ddDayplanfixvaluerel = (DdDayplanfixvaluerel) ddDayplanfixvaluerelDao
				.findByPk(frelid);
		DdDayplanfixvaluerelDto dto = (DdDayplanfixvaluerelDto) BeanHelper
				.buildBean(DdDayplanfixvaluerelDto.class, ddDayplanfixvaluerel);
		return dto;
	}

	public QueryListObj listDdDayplanfixvaluerelByHql(String hql) {
		QueryListObj obj = ddDayplanfixvaluerelDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(
					DdDayplanfixvaluerelDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdDayplanfixvaluerel(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdDayplanfixvaluerelDto ddDayplanfixvaluerelDto = (DdDayplanfixvaluerelDto) dtos
					.get(i);
			DdDayplanfixvaluerel ddDayplanfixvaluerel = (DdDayplanfixvaluerel) BeanHelper
					.buildBean(DdDayplanfixvaluerel.class,
							ddDayplanfixvaluerelDto);
			pos.add(ddDayplanfixvaluerel);
		}

		ddDayplanfixvaluerelDao.saveOrUpdateAll(pos);

	}

	public void deleteDdDayplanfixvaluerel(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdDayplanfixvaluerel.class, dtos);
		ddDayplanfixvaluerelDao.deleteAll(pos);
	}*/

	public QueryListObj listZdhOpexaminelist() {
		QueryListObj obj = zdhOpexaminelistDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateZdhOpexaminelist(ZdhOpexaminelistDto dto) {

		if (StringUtils.isEmpty(dto.getExaminationid())) {
			if (StringUtils.isEmpty(dto.getExaminationid())) {
				dto.setExaminationid(new SequenceCreator().getUID());
			}
		}
		ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper
				.buildBean(ZdhOpexaminelist.class, dto);
		zdhOpexaminelistDao.saveOrUpdate(zdhOpexaminelist);

	}

	public void deleteZdhOpexaminelist(String examinationid) {

		ZdhOpexaminelist zdhOpexaminelist = new ZdhOpexaminelist();
		zdhOpexaminelist.setExaminationid(examinationid);
		zdhOpexaminelistDao.delete(zdhOpexaminelist);

	}

	public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid) {
		ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) zdhOpexaminelistDao
				.findByPk(examinationid);
		ZdhOpexaminelistDto dto = (ZdhOpexaminelistDto) BeanHelper.buildBean(
				ZdhOpexaminelistDto.class, zdhOpexaminelist);
		return dto;
	}

	public QueryListObj listZdhOpexaminelistByHql(String hql) {
		QueryListObj obj = zdhOpexaminelistDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(ZdhOpexaminelistDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateZdhOpexaminelist(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			ZdhOpexaminelistDto zdhOpexaminelistDto = (ZdhOpexaminelistDto) dtos
					.get(i);
			ZdhOpexaminelist zdhOpexaminelist = (ZdhOpexaminelist) BeanHelper
					.buildBean(ZdhOpexaminelist.class, zdhOpexaminelistDto);
			pos.add(zdhOpexaminelist);
		}

		zdhOpexaminelistDao.saveOrUpdateAll(pos);

	}

	public void deleteZdhOpexaminelist(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(ZdhOpexaminelist.class, dtos);
		zdhOpexaminelistDao.deleteAll(pos);
	}

	public void setDdDoutageplanWFService(
			IDdDoutageplanWFService ddDoutageplanWFService) {
		this.ddDoutageplanWFService = ddDoutageplanWFService;
	}

	public void setDdAccidentbriefService(
			IDdAccidentbriefService ddAccidentbriefService) {
		this.ddAccidentbriefService = ddAccidentbriefService;
	}

	public void setDdMoutageplanService(IDdMoutageplanService ddMoutageplanService) {
		this.ddMoutageplanService = ddMoutageplanService;
	}

	/** ******************************************工作流******************************************** */

	// 会签
	public int ddDayPlanCoursign(WorkflowHandleDto dto)
			throws DataAccessException {

		DdDoutageplan dayplan = ddDoutageplanDao.findByPk(dto.getBusId());

		if (dto.getTransitionFlag().equals("1")) {//需要修改



//			dayplan
//					.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_SENT);
//			dayplan
//					.setFexcutestatus(DispatchConstants.AREA_DdDoutageplan_APPROVEED);

		} else if (dto.getTransitionFlag().equals("-1")) {
			dayplan
					.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_OVER);
			dayplan
					.setFexcutestatus(DispatchConstants.AREA_DdDoutageplan_UNAPPROVEED);

		} else
			new Exception("ddDayPlanCoursign TransitionFlag");

		ddDoutageplanDao.saveOrUpdate(dayplan);
		return ddDoutageplanWFService.ddDayPlanCoursign(dto);
	}

	// 客户中心进行日计划可否执行的批准操作
	public int ddDayPlanCustomerApprove(WorkflowHandleDto dto)
			throws DataAccessException {
		return ddDoutageplanWFService.ddDayPlanCustomerApprove(dto);

	}

	// 填写计划执行情况
	public int ddDayPlanFillExec(WorkflowHandleDto dto)
			throws DataAccessException {
		DdDoutageplan dayplan = ddDoutageplanDao.findByPk(dto.getBusId());
		dayplan
				.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_KEEPON);
		// dayplan
		// .setFexcutestatus(DispatchConstants.AREA_DdDoutageplan_UNAPPROVEED);
		ddDoutageplanDao.saveOrUpdate(dayplan);
		return ddDoutageplanWFService.ddDayPlanFillExec(dto);
	}

	// 处理日计划并通知客户
	public int ddDayPlanInfocustomer(WorkflowHandleDto dto)
			throws DataAccessException {
		return ddDoutageplanWFService.ddDayPlanInfocustomer(dto);
	}

	// 专工下发计划
	public int ddDayPlanSent(WorkflowHandleDto dto) throws DataAccessException {
		DdDoutageplan dayplan = ddDoutageplanDao.findByPk(dto.getBusId());

		if (dto.getTransitionFlag().equals("1")) {// 调度权限属于其他单位的计划
			dayplan
					.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_OVER);

		} else if (dto.getTransitionFlag().equals("-1")) {

		} else
			new Exception("ddDayPlanCoursign TransitionFlag");

		ddDoutageplanDao.saveOrUpdate(dayplan);

		return ddDoutageplanWFService.ddDayPlanSent(dto);
	}

	// 计划专工整理计划
	public int ddDayPlanSpecArrange(WorkflowHandleDto dto)
			throws DataAccessException {
		DdDoutageplan dayplan = ddDoutageplanDao.findByPk(dto.getBusId());

		if (dto.getTransitionFlag().equals("1")) {// 不需要其他调度审核
			dayplan
					.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_COURSIGN);
			dayplan
					.setFexcutestatus(DispatchConstants.AREA_DdDoutageplan_AUDITING);

		} else if (dto.getTransitionFlag().equals("2")) {// 需要其他调度审核			  try {
				sendBussObj(dto, dayplan.getSys_dataowner(), new String[] {
				      "iDdDoutageplanService", "recBussData"
				  });
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (dto.getTransitionFlag().equals("3")) {// 驳回
			dayplan
					.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_OVER);
			dayplan
					.setFexcutestatus(DispatchConstants.AREA_DdDoutageplan_UNAPPROVEED);

		} else
			new Exception("ddDayPlanCoursign TransitionFlag");

		ddDoutageplanDao.saveOrUpdate(dayplan);
		return ddDoutageplanWFService.ddDayPlanSpecArrange(dto);
	}

	// 计划专工归档
	public int ddDayPlanSpecKeepon(WorkflowHandleDto dto)
			throws DataAccessException {
		DdDoutageplan dayplan = ddDoutageplanDao.findByPk(dto.getBusId());

		dayplan
				.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_OVER);
		ddDoutageplanDao.saveOrUpdate(dayplan);
		return ddDoutageplanWFService.ddDayPlanSpecKeepon(dto);
	}

	// 启动
	public int start(WorkflowHandleDto dto) throws DataAccessException {
		DdDoutageplan dayplan = ddDoutageplanDao.findByPk(dto.getBusId());

		// dayplan
		// .setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_ARRAY);
		// ddDoutageplanDao.saveOrUpdate(dayplan);
		return ddDoutageplanWFService.start(dto);
	}




	public void setDdwoutageService(IDdWoutageplanService ddwoutageService) {
		this.ddwoutageService = ddwoutageService;
	}



    public void recBussData(List list)
    {
        System.out.println("recBussData start:" + list.size());
        ControlDto dto = (ControlDto)list.get(0);
        DdDoutageplanDto ddDoutageplanDto = (DdDoutageplanDto)list.get(1);
        String strentityId = ddDoutageplanDto.getFdayplanno();
        String sql = " FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='" + strentityId + "'";
        QueryListObj obj = ctrlWflentityrelDao.getQueryListByHql(sql);
        List ctlList = obj.getElemList();
        Iterator ctlit = ctlList.iterator();
        if(ctlit.hasNext())
        {
            CtrlWflentityrel ctrlWflentityrel = (CtrlWflentityrel)ctlit.next();
            long taskId = (new Long(ctrlWflentityrel.getTaskid())).longValue();
            workFlowDao.endWaitingByTaskInstance(taskId);
            DdDoutageplan ddDoutageplan = ddDoutageplanDao.findByPk(strentityId);
            ddDoutageplan.setFexcutestatus(ddDoutageplanDto.getFexcutestatus());
            ddDoutageplanDao.saveOrUpdate(ddDoutageplan);
        }
    }


    /**
     * 等待审批结果
     *
     * @param list
     */
    public void recBussDataWaiting(List list)
    {
        System.out.println("recBussData start:" + list.size());
        ControlDto dto = (ControlDto)list.get(0);
        DdDoutageplanDto ddDoutageplanDto = (DdDoutageplanDto)list.get(1);
        String strentityId = ddDoutageplanDto.getFdayplanno();
        String sql = " FROM CtrlWflentityrel as ctlwf where ctlwf.entityid='" + strentityId + "'";
        QueryListObj obj = ctrlWflentityrelDao.getQueryListByHql(sql);
        List ctlList = obj.getElemList();
        Iterator ctlit = ctlList.iterator();
        if(ctlit.hasNext())
        {
            CtrlWflentityrel ctrlWflentityrel = (CtrlWflentityrel)ctlit.next();
            long taskId = (new Long(ctrlWflentityrel.getTaskid())).longValue();
            workFlowDao.endWaitingByTaskInstance(taskId);
            DdDoutageplan ddDoutageplan = ddDoutageplanDao.findByPk(strentityId);
            ddDoutageplan.setFexcutestatus(ddDoutageplanDto.getFexcutestatus());
            ddDoutageplan.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_KEEPON);
            ddDoutageplanDao.saveOrUpdate(ddDoutageplan);
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
        controlDto.setBussinessSign("DdDoutageplan");
        controlDto.setNotifyContent("");
        controlDto.setAreaTaskId(Long.valueOf(dto.getTaskInstanceId()).toString());
        controlDto.setType("3");
        controlDto.setContentVersion("");
        controlDto.setIsTrigger("1");
        controlDto.setObjectName(Class_Method[0]);
        controlDto.setMethodName(Class_Method[1]);
        controlDto.setTraceNumber("");
        Timestamp sendTime = com.techstar.dmis.util.DateUtil.getCurrentTimestamp();
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
        DdDoutageplanDto ddDoutageplanDto = loadDdDoutageplan(dto.getBusId());
        service.sendMessage(controlDto, ddDoutageplanDto);
        stopwatch.stop();
        System.out.println("发送耗时: " + stopwatch.getTime());
        String busId = dto.getBusId();
        CtrlWflentityrel ctrlWflentityrel = new CtrlWflentityrel();
        ctrlWflentityrel.setEntityid(busId);
        ctrlWflentityrel.setEntityname("DdDoutageplan");
        ctrlWflentityrel.setTaskid(dto.getTaskInstanceId());
        ctrlWflentityrel.setFrelid((new SequenceCreator()).getUID());
        ctrlWflentityrelDao.saveOrUpdate(ctrlWflentityrel);
    }




	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}



}
