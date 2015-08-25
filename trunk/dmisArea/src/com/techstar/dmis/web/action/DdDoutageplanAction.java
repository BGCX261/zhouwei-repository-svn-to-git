package com.techstar.dmis.web.action;

import java.util.*;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.entity.DdDoutageplan;
import com.techstar.dmis.entity.DdMoutageplan;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.ui.web.facade.TagEngineFacade;
import com.techstar.framework.ui.web.tag.engine.DateUtil;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.web.facade.DdDoutageplanFacade;
import com.techstar.dmis.web.facade.DdMoutageplanFacade;
import com.techstar.dmis.web.facade.DdAccidentbriefFacade;
import com.techstar.dmis.web.facade.DdSwitchseqbillFacade;
import com.techstar.dmis.web.facade.StdElectricstampFacade;
import com.techstar.dmis.web.facade.DdWoutageplanFacade;
import com.techstar.dmis.web.form.DdDoutageplanForm;
import com.techstar.dmis.dto.DdDayplandelaylistDto;
import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.dto.DayplancoopraterelDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.dto.DdWoutageplanDto;
import com.techstar.dmis.dto.DdSwitchseqbillDto;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.StdElectricstampDto;
import com.techstar.dmis.entity.Dayplancoopraterel;
import java.text.MessageFormat;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.SQLHealp;
import com.techstar.dmis.helper.dto.DayPlanWorkDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.helper.dto.showDaysPlanDto;

import java.sql.Timestamp;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdDoutageplanAction extends BaseDispatchAction {
	private DdDoutageplanFacade ddDoutageplanFacade;// 

	private SysUiGridFacade sysUiGridFacade;

	private DdMoutageplanFacade ddMoutageplanFacade;

	private DdAccidentbriefFacade ddAccidentbriefFacade;

	private DdSwitchseqbillFacade ddSwitchseqbillFacade;

	private StdElectricstampFacade stdElectricstampFacade;
	private DdWoutageplanFacade  ddwoutageplanFacade;

	public void setDdAccidentbriefFacade(
			DdAccidentbriefFacade ddAccidentbriefFacade) {
		this.ddAccidentbriefFacade = ddAccidentbriefFacade;
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setDdMoutageplanFacade(DdMoutageplanFacade ddMoutageplanFacade) {
		this.ddMoutageplanFacade = ddMoutageplanFacade;
	}

	public void setStdElectricstampFacade(
			StdElectricstampFacade stdElectricstampFacade) {
		this.stdElectricstampFacade = stdElectricstampFacade;
	}
	public void setDdwoutageplanFacade(DdWoutageplanFacade ddwoutageplanFacade) {
		this.ddwoutageplanFacade = ddwoutageplanFacade;
	}
	public DdDoutageplanAction() {
	}

	/**
	 * private String fstatus; //状态
	 * 
	 * private String fexcutestatus; //执行状态
	 * 
	 */
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 查询列表
		List list = ddDoutageplanFacade.listDdDoutageplan();
		request.getSession().setAttribute("DdDoutageplanList", list);

		// 记录操作日志
		// saveLog("DdDoutageplaner", "查询列表");
		return mapping.findForward("list");
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		DdDoutageplanDto dto = ddDoutageplanForm.getDdDoutageplanDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFdayplanno())) {
			dto.setFdayplanno(new SequenceCreator().getUID()); // 生成内部序列号

		}
		ddDoutageplanFacade.addDdDoutageplan(dto);

		// saveLog("DdDoutageplaner", "增加记录");
		return mapping.findForward("data");
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		String fdayplanno = request.getParameter("fdayplanno");
		if (StringUtils.isNotEmpty(fdayplanno)) {
			DdDoutageplanDto dto = ddDoutageplanFacade
					.getDdDoutageplanById(fdayplanno);
			ddDoutageplanForm.setDdDoutageplanDto(dto);
		}

		// saveLog("DdDoutageplaner", "初始化记录操作");
		return mapping.findForward("data");
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			// var para ="ids="+ids+"&version="+ver;
			String ids = request.getParameter("ids");
			String versions = request.getParameter("version");
			String[] idsarry = ids.split("\\^");
			String[] verarrays = versions.split("\\^");
			List plans = new ArrayList();
			for (int i = 0; i < idsarry.length; i++) {
				DdDoutageplanDto dto = ddDoutageplanFacade
						.loadDdDoutageplan(idsarry[i]);
				String fexstatus = dto.getFexcutestatus();
				if (!DispatchConstants.CITY_DdDoutageplan_NEW.equals(fexstatus)) {
					response.getWriter().print("0");
					return null;
				}
				dto.setVersion(Integer.parseInt(verarrays[i]));
				plans.add(dto);
			}
			this.ddDoutageplanFacade.deleteDdDoutageplan(plans);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}

		// saveLog("DdDoutageplaner", "删除记录操作");
		response.getWriter().print("1");
		return null;
	}

	/**
	 * 生成操作票
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createSeqBill(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String fdayplanno = request.getParameter("ids");
			// String version = request.getParameter("version");
			DdDoutageplanDto dto = ddDoutageplanFacade
					.loadDdDoutageplan(fdayplanno);
			DdSwitchseqbillDto bdto = new DdSwitchseqbillDto();
			bdto.setFcomputerno(new SequenceCreator().getUID());
			bdto.setFsrcbillno(dto.getFdayplanno());
			bdto
					.setFbillsource(DispatchConstants.ddSeqbillDetailSetpstatus_SOURCE_DAYPLAN);
			bdto.setSys_fille(BusinessDetailHelper.getBusDetailInfo(request)
					.getUserName());
			bdto.setSys_filldept(BusinessDetailHelper.getBusDetailInfo(request)
					.getUserDeptName());
			bdto.setSys_filltime(BusinessDetailHelper.getBusDetailInfo(request)
					.getCurrentTime());
			bdto.setFexcutestatus(DispatchConstants.ddSwitchSeqbill_NEW);
			bdto
					.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_NEW);
			bdto.setFmanualno(ddSwitchseqbillFacade.getMaxfmanualno());
			ddSwitchseqbillFacade.addDdSwitchseqbill(bdto);
			request.getSession()
					.setAttribute("ddadddid", bdto.getFcomputerno());
			response.getWriter().print("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}
		return null;

	}

	public void setDdDoutageplanFacade(DdDoutageplanFacade ddDoutageplanFacade) {
		this.ddDoutageplanFacade = ddDoutageplanFacade;
	}

	// noEditGrid editGrid tab toolbar detail

	// 初始化表格

	public ActionForward standGridQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = BusinessDetailHelper.getBusDetailInfo(request)
				.getUserName(); // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/*
		 * List dtolist = new ArrayList(); DdDoutageplanFacadeDto
		 * ddDoutageplanDto = new DdDoutageplanDto();
		 * //ddDoutageplanDto.setCustom_id("custom_id");
		 * //ddDoutageplanDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddDoutageplanDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdDoutageplanDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdDoutageplan");
		// gridObj.setIsFilterRow("1");
		// gridObj.setIsTotalRow("1");
		// gridObj.setColumnMove("custom_id,custom_name");
		// gridObj.setIsTotal("total");
		// gridObj.setListBox("cre_date#7^,custom_id#1^type=zzmm@@@parentId=,custom_name#2^src=SQDW,sale_mode#2^src=SQDW");
		// gridObj.setQueryPath("/ui.do?method=query");
		// gridObj.setIsDisplaySet("1");
		// gridObj.setIsQuerySet("1");
		// gridObj.setIsOutputSet("1");
		// gridObj.setIsStatSet("1");
		// gridObj.setIsPageSet("1");
		// request.setAttribute("gridObj",gridObj);
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj queryObj = ddDoutageplanFacade.getDdDoutageplanByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddDoutageplangrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddDoutageplantoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// String method = "<Toolbar> <Business> <id>DdDoutageplan</id>
		// <name>日检修计划</name> </Business> <ReportUrl>/report.do</ReportUrl>
		// <OperItem Text='从月计划生成日计划' id='DD_ExcuteStateChart'
		// href='createdddfromddm' title=''></OperItem> <OperItem
		// Text='从未完成计划生成' id='ETSParaModify' href='createdddfromnotfinish'
		// title=''></OperItem> <OperItem Text='日计划配合管理' id='dd_copprate'
		// href='showcopprate' title=''></OperItem> <OperItem Text='调度日计划延迟'
		// id='DD_DayplanDelay' href='#' title=''></OperItem> <OperItem
		// Text='拟定操作票' id='DD_switchseqbilleditor2' href='ddseqbill'
		// title=''></OperItem> <OperItem Text='施工组数牌'
		// id='DD_dayplanexcutegroup' href='#' title=''></OperItem> <OperItem
		// Text='从间隔获得停电范围和设备列表' id='DD_selectbayeqp2' href='#'
		// title=''></OperItem> <OperItem Text='日计划' id='DD_dayplanabloish'
		// href='abloishData' title=''></OperItem> <OperItem Text='日计划执行'
		// id='DD_DayplanExcute' href='finishData' title=''></OperItem>
		// <OperItem Text='日计划归档' id='DD_dayplanpigeonhole'
		// href='pigeonholeData' title=''></OperItem> <OperItem Text='日计划批准信息维护'
		// id='DD_approveInfo' href='#' title=''></OperItem> <OperItem
		// Text='上传章' id='uploadimg' href='uploadimg'
		// title=''></OperItem></Toolbar>";
		String method = "<Toolbar>   <Business>      <id>DdDoutageplan</id>      <name>日停电计划</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='从旬计划生成日计划' id='ddd_createdayplan' href='createdddfromddm' title=''></OperItem>    <OperItem Text='日计划配合管理' id='ddd_copprate' href='showcopprate' title=''></OperItem>     <OperItem Text='拟定操作票' id='ddd_switchbill' href='ddseqbill' title=''></OperItem>    <OperItem Text='从间隔获得停电范围和设备列表' id='ddd_selectbayeqp2' href='getEquip' title=''></OperItem>   <OperItem Text='日计划执行' id='ddd_dayplanexcute' href='finishData' title=''></OperItem>   <OperItem Text='工作流-处理历史' id='ddd_wf_history' href='wf_history' title=''></OperItem> </Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddDoutageplantoolbar");
	}

	// 初始化tab页

	public ActionForward ddDoutageplantab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddDoutageplantab");
	}

	public ActionForward ddDoutageplanframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddDoutageplanframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdDoutageplanDto ddDoutageplanDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddDoutageplanDto = ddDoutageplanFacade
						.getDdDoutageplanById(mainId);
				ddDoutageplanDto.setVersion(0);
				ddDoutageplanDto.setFdayplanno(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddDoutageplanDto = ddDoutageplanFacade
						.getDdDoutageplanById(mainId);
			} else {// 新增
				ddDoutageplanDto = new DdDoutageplanDto();
				/*
				 * private String fapplyunit; //申请单位 private String fapplicant;
				 * //申请人
				 * 
				 * private String fapplyunitid; //申请单位ID private java.sql.Date
				 * fapplytime; //申请时间
				 */
				// 设置默认的申请人 单位 时间 单位ID
				ddDoutageplanDto.setFapplyunit(BusinessDetailHelper
						.getBusDetailInfo(request).getUserDeptName());
				ddDoutageplanDto.setFapplicant(BusinessDetailHelper
						.getBusDetailInfo(request).getUserName());
				ddDoutageplanDto.setFapplytime(BusinessDetailHelper
						.getBusDetailInfo(request).getCurrentDate());
				ddDoutageplanDto.setFapplyunitid(BusinessDetailHelper
						.getBusDetailInfo(request).getUserDeptId());
			}
		}
		ddDoutageplanForm.setDdDoutageplanDto(ddDoutageplanDto);
		return mapping.findForward("ddDoutageplandetail");
	}

	/**
	 * 保存日计划详情和批准信息用
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		DdDoutageplanDto ddDoutageplanDto = ddDoutageplanForm
				.getDdDoutageplanDto();
		String op = request.getParameter("op");
		FormFile formFile = ddDoutageplanForm.getFaddipicture();
		if (formFile != null && formFile.getFileName() != null
				&& !formFile.getFileName().equals("")) {
			ddDoutageplanDto.setFaddipicture(formFile.getFileData());
		} else {
			// 如果是修改的日计划要把附件从数据库中取出来

			if (ddDoutageplanDto.getFdayplanno() != null
					&& !ddDoutageplanDto.getFdayplanno().equals("")) {
				// 得到附件
				DdDoutageplanDto oldDto = ddDoutageplanFacade
						.getDdDoutageplanById(ddDoutageplanDto.getFdayplanno());
				ddDoutageplanDto.setFaddipicture(oldDto.getFaddipicture());
				ddDoutageplanDto
						.setFunmeasureannex(oldDto.getFunmeasureannex());
			}
		}
		// 判断是否是新增加的日计划如果是设置为草稿状态

		if (StringUtils.isEmpty(ddDoutageplanDto.getFdayplanno())) {
			ddDoutageplanDto
					.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_CITY_STATUS_NEW);
			ddDoutageplanDto
					.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_NEW);

		}
		// 日计划详情

		if (op != null && op.equals("detail")) {
			/**
			 * sys_fille; //填写人
			 * 
			 * sys_filldept; //填写单位 sys_filltime; //填写时间 sys_dataowner; //数据所属单位
			 * 
			 */
			ddDoutageplanDto.setSys_fille(BusinessDetailHelper
					.getBusDetailInfo(request).getUserName());
			ddDoutageplanDto.setSys_filldept(BusinessDetailHelper
					.getBusDetailInfo(request).getUserDeptName());
			ddDoutageplanDto.setSys_filltime(BusinessDetailHelper
					.getBusDetailInfo(request).getCurrentTime());
			ddDoutageplanDto.setSys_dataowner(BusinessDetailHelper.getDataOwner());
       	    //手工编码
       	 	ddDoutageplanDto.setFmanualno(BusinessDetailHelper.genBusinessNumber("DAY_PLAN"));

		}
		// 日计划批准

		else {
			// 保存中调批准人

			ddDoutageplanDto.setFplanappropeople(BusinessDetailHelper
					.getBusDetailInfo(request).getUserName());
		}
		// 如果没有下令的信息要把下令信息初始化为默认的值

		setTimeInfo(ddDoutageplanDto);
		String clastyp = ddDoutageplanDto.getFplanclass();
		if (clastyp != null
				&& clastyp
						.equals(DispatchConstants.DdDayPlan_WORKFLOW_CITY_SentIsType_TRANSIT_LS)) {
			ddDoutageplanDto
					.setFfilltype(DispatchConstants.CITY_DdDoutageplan_TEMPERORY);
		} else {
			ddDoutageplanDto
					.setFfilltype(DispatchConstants.CITY_DdDoutageplan_COMMON);
		}
		ddDoutageplanFacade.addDdDoutageplan(ddDoutageplanDto);
		// DdfsModechangelistDto dd = new DdfsModechangelistDto();
		ddDoutageplanDto = ddDoutageplanFacade
				.getDdDoutageplanById(ddDoutageplanDto.getFdayplanno());
		ddDoutageplanForm.setDdDoutageplanDto(ddDoutageplanDto);
		saveMessages(request, "message.save.success",
				new String[] { "日检修计划Dto" });
		return mapping.findForward("ddDoutageplandetail");
	}

	/**
	 * 添加常用信息
	 * 
	 * @param dto
	 * @param request
	 */
	private void setTimeInfo(DdDoutageplanDto dto) {
		// 批准工作开始时间 默认 申请工作起始时间
		if (dto.getFapproworkstime() == null) {
			dto.setFapproworkstime(dto.getFapplystime());
		}
		// 批准工作结束时间 默认 申请工作结束时间
		if (dto.getFapproworketime() == null) {
			dto.setFapproworketime(dto.getFapplyetime());
		}
		// 批准停电开始时间 默认 申请停电时间
		if (dto.getFapprostime() == null) {
			dto.setFapprostime(dto.getFapplyoutagetime());
		}
		// 批准工作结束时间 默认 申请发电时间
		if (dto.getFapproetime() == null) {
			dto.setFapproetime(dto.getFapplyrestoretime());
		}
	}

	/**
	 * 查询未生成日计划的月计划
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ActionForward getDdMonthpaln(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = ""; // 用户ID

		// 取到表格的信息

		String parentid = (String) request.getParameter("parentid");
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		String hql = "select A from DdMoutageplan A where not exists(select A from  DdDoutageplan B where B.fplansourceno=A.fmonthplanno) and A.fexcutestatus='"
				+ DispatchConstants.ddMoutageplan_approveed + "'";

		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddMoutageplanFacade.listDdMoutageplanByHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 从月计划生成日计划
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward createDdoutplansFromMonth(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String monthIds = request.getParameter("ids");
			// fmonthplanno^3###fmonthplanno^1
			String[] ids = monthIds.split("###");

			for (int i = 0; i < ids.length; i++) {
				String id = (ids[i].split("\\^"))[1];
				System.out.println(id);
				DdMoutageplanDto mdto = ddMoutageplanFacade
						.loadDdMoutageplan(id);
				DdDoutageplanDto ddto = tranMdtoToddto(mdto);
				ddto.setFdayplanno(new SequenceCreator().getUID());
				ddDoutageplanFacade.addDdDoutageplan(ddto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}
		response.getWriter().print("1");
		return null;
	}

	private DdDoutageplanDto tranMdtoToddto(DdMoutageplanDto dto) {
		DdDoutageplanDto ddDoutageplanDto = new DdDoutageplanDto();
		ddDoutageplanDto.setFmanualno(null); // 手工编号
		ddDoutageplanDto.setFstationname(dto.getFstationname()); // 变电站

		ddDoutageplanDto.setFline(dto.getFlinename()); // 线路名

		// ddDoutageplanDto.setFworkarea(); // 工作地点
		ddDoutageplanDto.setFoutagearea(dto.getFoutagearea()); // 停电范围
		ddDoutageplanDto.setFdispatchrange(dto.getFdispatchrange()); // 调度范围
		ddDoutageplanDto.setFapplystime(dto.getFstarttime()); // 申请工作起始时间
		ddDoutageplanDto.setFapplyetime(dto.getFendtime()); // 申请工作结束时间
		// ddDoutageplanDto.setFapplyoutagetime(dto.getFapplytime()); //
		// 申请停电时间
		// ddDoutageplanDto.setfapplyrestoretime; // 申请发电时间
		ddDoutageplanDto.setFapplyunit(dto.getFapplyunit()); // 申请单位
		ddDoutageplanDto.setFapplicant(dto.getFapplicant()); // 申请人


		ddDoutageplanDto
				.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_CITY_STATUS_NEW); // 状态

		ddDoutageplanDto
				.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_NEW); // 执行状态
		ddDoutageplanDto
				.setFplansourcetype(DispatchConstants.CITY_DdDoutageplan_FROMSOURCE_MONTH); // 计划来源类型
		ddDoutageplanDto.setFplansourceno(dto.getFmonthplanno()); // 计划来源序号
		ddDoutageplanDto.setFstationid(dto.getFstationid()); // 变电站ID
		ddDoutageplanDto.setFapplyunitid(dto.getFapplyunitid()); // 申请单位ID
		ddDoutageplanDto.setWorkcontent(dto.getFworkcontent()); // 工作内容
		ddDoutageplanDto.setSys_fille(dto.getSys_fille()); // 填写人
		ddDoutageplanDto.setSys_filldept(dto.getSys_filldept()); // 填写单位
		ddDoutageplanDto.setSys_filltime(dto.getSys_filltime()); // 填写时间
		ddDoutageplanDto.setSys_isvalid(dto.getSys_isvalid()); // 是否有效字段
		ddDoutageplanDto.setSys_dataowner(dto.getSys_dataowner()); // 数据所属单位
		ddDoutageplanDto.setFvoltage(dto.getFvoltage()); // 电压等级
		return ddDoutageplanDto;
	}
    
	
	
	
	/**
	 * 执行日计划(已下令)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward finishdDdoutplans(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			String ids = request.getParameter("ids");
			String versions =request.getParameter("version");
			String[] idsarry = ids.split("\\^");
			String[] verarrays = versions.split("\\^");
 			List  plans = new ArrayList();
 			List wplans = new ArrayList();
 			List accidents  = new ArrayList();
			for(int i=0;i<idsarry.length;i++){
				DdDoutageplanDto dto = ddDoutageplanFacade.loadDdDoutageplan(idsarry[i]);
				String stype =  dto.getFplansourcetype();
				
				String status = dto.getFexcutestatus();
				if(!DispatchConstants.CITY_DdDoutageplan_ORDERED.equals(status)){
					response.getWriter().print("0");
					return null;
				}
				//回添事故
				if(stype!=null&&stype.equals(DispatchConstants.CITY_DdDoutageplan_FROMSOURCE_ACCIDENT)){
					String acid = dto.getFplansourceno();
					DdAccidentbriefDto adto = this.ddAccidentbriefFacade.loadDdAccidentbrief(acid);
					adto.setFexcutestatus(DispatchConstants.ddAccidentbrief_resume);
					adto.setFddaccidentbriefprocess1(null);
					adto.setFbhactionrecord10(null);
					accidents.add(adto);
				}
				//回添旬计划

				if(stype!=null&&stype.equals(DispatchConstants.AREA_DdDoutageplan_FROMSOURCE_WEEK)){
					String moid = dto.getFplansourceno();
					DdWoutageplanDto woutdto = ddwoutageplanFacade.loadDdWoutageplan(moid);
					woutdto.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_PERFORMED);
					woutdto.setFddrepairdetail3(null);
					woutdto.setFddplanuserrel3(null);
					woutdto.setZddwoutageplan5(null);
					wplans.add(woutdto);
				}
				dto.setVersion(Integer.parseInt(verarrays[i]));
				dto.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_PERFORMED);
				setCollectionnull(dto);
				//ddDoutageplanFacade.addDdDoutageplan(dto);
				plans.add(dto);
			}
			ddDoutageplanFacade.saveOrUpdateDdDoutageplan(plans,wplans,accidents);
			/*
			ddDoutageplanFacade.saveOrUpdateDdDoutageplan(plans);
			if(mplans.size()>0)
				ddMoutageplanFacade.addDdMoutageplanByList(mplans);
			if(accidents.size()>0)
				ddAccidentbriefFacade.saveOrUpdateDdAccidentbrief(accidents);*/
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().print("0");
		}
			response.getWriter().print("1");
		return null;
	}
	

	
	/**
	 * 保存取消原因 并且盖取消章
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward savecancleReason(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			// para = 'id='+id+'&cancleval='+val+'&code='+code;
			UserProfile userP = (UserProfile) (request.getSession()
					.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
			String val = request.getParameter("cancleval");
			String id = request.getParameter("id");
			String code = request.getParameter("code");
			String version = request.getParameter("version");
			DdDoutageplanDto dto = ddDoutageplanFacade.loadDdDoutageplan(id);
			String status = dto.getFexcutestatus();
			String stype = dto.getFplansourcetype();
			DdWoutageplanDto wdto = null;
			if (!DispatchConstants.CITY_DdDoutageplan_DISPATCHED.equals(status)
					&& !DispatchConstants.CITY_DdDoutageplan_ORDERED
							.equals(status)) {
				response.getWriter().print("0");
				return null;
			}
			dto.setFabolishReason(val);
			dto.setCancelcode(code);
			dto.setFabolish(BusinessDetailHelper.getBusDetailInfo(request)
					.getUserName());
			dto.setFcanceltime(BusinessDetailHelper.getBusDetailInfo(request)
					.getCurrentTime());
			dto.setVersion(Integer.parseInt(version));
			dto.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_CANCLED);
			this.setCollectionnull(dto);
			// 回添旬计划
            /*
             *  private java.util.Collection fddrepairdetail3; //旬计划编号
	      private java.util.Collection fddplanuserrel3; //旬计划编号
	      private com.techstar.dmis.dto.DdMoutageplanDto zddwoutageplan5; //计划来源编号
		 
             */
			if (stype != null
					&& stype.equals(DispatchConstants.AREA_DdDoutageplan_FROMSOURCE_WEEK)) {
				String moid = dto.getFplansourceno();
				wdto = ddwoutageplanFacade.loadDdWoutageplan(moid);
				wdto.setFunfinishreason(val);
				wdto.setFunfinishreasonid(code);
				wdto.setFexcutestatus(DispatchConstants.ddMoutageplan_cancled);
				wdto.setFddrepairdetail3(null);
				wdto.setFddplanuserrel3(null);
				wdto.setZddwoutageplan5(null);
				// ddMoutageplanFacade.addDdMoutageplan(mdto);
			}
			ddDoutageplanFacade.saveOrUpdateDdDoutageplan(dto, wdto, null);
			dto = ddDoutageplanFacade.getDdDoutageplanById(id);
			response.getWriter().print("1^" + dto.getVersion());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}

		return null;
	}

	/**
	 * 归档停电计划(已执行/已取消)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward pigeonholeDdoutplans(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("ids");
			String versions = request.getParameter("version");
			String[] idsarry = ids.split("\\^");
			String[] verarrays = versions.split("\\^");
			List plans = new ArrayList();
			for (int i = 0; i < idsarry.length; i++) {
				DdDoutageplanDto dto = ddDoutageplanFacade
						.loadDdDoutageplan(idsarry[i]);
				String status = dto.getFexcutestatus();
				if (!DispatchConstants.CITY_DdDoutageplan_CANCLED
						.equals(status)
						&& !DispatchConstants.CITY_DdDoutageplan_PERFORMED
								.equals(status)) {
					response.getWriter().print("0");
					return null;
				}
				dto.setVersion(Integer.parseInt(verarrays[i]));
				dto
						.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_PIGEONHOLED);
				setCollectionnull(dto);
				// ddDoutageplanFacade.addDdDoutageplan(dto);

				plans.add(dto);

			}
			ddDoutageplanFacade.saveOrUpdateDdDoutageplan(plans);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}
		response.getWriter().print("1");
		return null;
	}

	/**
	 * 把dto的cellection设置为空
	 * 
	 * @param dto
	 */
	private void setCollectionnull(DdDoutageplanDto dto) {
		dto.setFddrepairdetail2(null);
		dto.setFdddayplandelaylist1(null);
		dto.setFdddayplanexcutelist1(null);
		dto.setFddfsmodechangelist4(null);
		dto.setFdayplancoopraterel1(null);
		dto.setFdddayplanfixvaluerel2(null);
		dto.setFzdhopexaminelist6(null);
	}

	/**
	 * 显示图片
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward showImg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		// DdDoutageplanDto dto = ddDoutageplanForm.getDdDoutageplanDto();
		String mainId = (String) request.getParameter("mainId");
		DdDoutageplanDto dto = null;
		if (mainId != null && !"".equals(mainId)) {
			dto = ddDoutageplanFacade.loadDdDoutageplan(mainId);
		}
		request.setAttribute("dddto", dto);
		return mapping.findForward("image");
	}

	/**
	 * 核查日计划
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward dayPlanCheckup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			// para =
			// 'id='+id+'&version='+version+'&ispass='+ispass+'&reason='+reason;
			String fdayplanno = request.getParameter("id");
			String version = request.getParameter("version");
			String ispass = request.getParameter("ispass");
			String reason = request.getParameter("reason");
			DdDoutageplanDto dto = ddDoutageplanFacade
					.getDdDoutageplanById(fdayplanno);
			dto.setVersion(Integer.parseInt(version));
			dto.setIspassed(ispass);
			dto.setReason(reason);
			this.setCollectionnull(dto);
			ddDoutageplanFacade.addDdDoutageplan(dto);
			dto = ddDoutageplanFacade.getDdDoutageplanById(fdayplanno);
			int ver = dto.getVersion();
			response.getWriter().print("1^" + ver + "");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}

		return null;
	}

	/**
	 * 中调命令保存
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveReportOrder(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		// DdDoutageplanDto dto = ddDoutageplanForm.getDdDoutageplanDto();
		try {
			String fdayplanno = request.getParameter("id");
			String version = request.getParameter("version");
			String csendtime = request.getParameter("csendtime");
			String csender = request.getParameter("csender");
			String creceiver2 = request.getParameter("creceiver2");
			String cmdcontent = request.getParameter("cmdcontent");
			String creturntime = request.getParameter("creturntime");
			String creceiver1 = request.getParameter("creceiver1");
			String creturner = request.getParameter("creturner");
			String creturncontent = request.getParameter("creturncontent");
			DdDoutageplanDto dto = ddDoutageplanFacade
					.getDdDoutageplanById(fdayplanno);
			dto.setVersion(Integer.parseInt(version));
			dto.setCsendtime(("".equals(csendtime) || csendtime == null) ? null
					: DateUtil.stringToTimestamp(csendtime,
							"yyyy-MM-dd hh:mm:ss"));
			dto.setCsender(csender);
			dto.setCreceiver2(creceiver2);
			dto.setCmdcontent(cmdcontent);
			dto
					.setCreturntime(("".equals(creturntime) || creturntime == null) ? null
							: DateUtil.stringToTimestamp(creturntime,
									"yyyy-MM-dd hh:mm:ss"));
			dto.setCreceiver1(creceiver1);
			dto.setCreturner(creturner);
			dto.setCreturncontent(creturncontent);
			this.setCollectionnull(dto);
			ddDoutageplanFacade.addDdDoutageplan(dto);
			dto = ddDoutageplanFacade.getDdDoutageplanById(fdayplanno);
			int ver = dto.getVersion();
			response.getWriter().print("1^" + ver + "");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}

		return null;
	}

	/**
	 * 保存日计划盖章
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveGrafe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// para = 'id='+id+'&version='+version+'&gids='+vReturnValue;
		try {
			String id = request.getParameter("id");
			String version = request.getParameter("version");
			String gfids = request.getParameter("gids");
			DdDoutageplanDto dto = ddDoutageplanFacade.getDdDoutageplanById(id);
			String stampids = dto.getStampid();
			if (stampids != null)
				stampids += ";" + gfids;
			else
				stampids = gfids;
			dto.setVersion(Integer.parseInt(version));
			dto.setStampid(stampids);
			this.setCollectionnull(dto);
			ddDoutageplanFacade.addDdDoutageplan(dto);
			dto = ddDoutageplanFacade.loadDdDoutageplan(dto.getFdayplanno());
			response.getWriter().print(
					"1^" + dto.getVersion() + "^" + dto.getStampid());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}
		return null;
	}

	/**
	 * 删除电子章
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteGrafe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String id = request.getParameter("id");
			String version = request.getParameter("version");
			String gfids = request.getParameter("delids");
			DdDoutageplanDto dto = ddDoutageplanFacade.getDdDoutageplanById(id);
			String stampids = dto.getStampid();
			String newstampids = this.transtampids(stampids, gfids);
			dto.setVersion(Integer.parseInt(version));
			dto.setStampid(newstampids);
			this.setCollectionnull(dto);
			ddDoutageplanFacade.addDdDoutageplan(dto);
			dto = ddDoutageplanFacade.loadDdDoutageplan(dto.getFdayplanno());
			response.getWriter().print(
					"1^" + dto.getVersion() + "^" + dto.getStampid());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("0");
		}
		return null;
	}

	private String transtampids(String oldids, String deleteIds) {
		String[] oids = oldids.split(";");
		String[] delids = deleteIds.split(";");
		String tanstr = "";
		for (int i = 0; i < delids.length; i++) {

			String deid = delids[i];
			if (deid != null && !deid.equals("")) {
				tanstr = "";
				for (int j = 0; j < oids.length; j++) {
					String oid = oids[j];
					if (oid != null && !oid.equals("") && !oids[j].equals(deid)) {
						tanstr += oids[j] + ";";

					}
				}
			}
			oids = tanstr.split(";");

		}

		if (!tanstr.equals("")) {
			String nstr = tanstr.substring(0, tanstr.lastIndexOf(";"));
			System.out.println("ssssssss" + nstr);
			return nstr;
		} else {
			return "";
		}
	}

	/**
	 * 显示工作进度
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showwork(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 取出日计划状态为已下令String hql = "select A from DdMoutageplan A where not
		// exists(select A from DdDoutageplan B where
		// B.fplansourceno=A.fmonthplanno) and A.fstatus='已审批'";

		String hql1 = "select t from  DdDoutageplan t  where t.fexcutestatus ='"
				+ DispatchConstants.CITY_DdDoutageplan_ORDERED + "'";
		// String hql = "select d from DdDayplanexcutelist d where
		// d.zdddayplanexcutelist1.fdayplanno='"+parentid+"'"

		String dayplanhql = "select d from  DdDoutageplan d where d in ( select b  from DdDayplanexcutelist t,DdDoutageplan b  where b.fexcutestatus ='"
				+ DispatchConstants.CITY_DdDoutageplan_ORDERED
				+ "' or(b.fexcutestatus ='"
				+ DispatchConstants.CITY_DdDoutageplan_PERFORMED
				+ "' and To_Char(t.freturntime, 'YYYYMMDD')  = To_Char(sysdate, 'YYYYMMDD') and b.fdayplanno=t.zdddayplanexcutelist1.fdayplanno))";
		// 得到满足要求的日计划
		QueryListObj queryObj2 = this.ddDoutageplanFacade
				.listDdDoutageplanByHql(dayplanhql);
		String earlytimehql = "select min(to_char(d.fsendcmdtime,'YYYY-MM-DD HH:MM')) from  DdDayplanexcutelist d where d.zdddayplanexcutelist1 in ( select b  from DdDayplanexcutelist t,DdDoutageplan b  where b.fexcutestatus ='"
				+ DispatchConstants.CITY_DdDoutageplan_ORDERED
				+ "' or(b.fexcutestatus ='"
				+ DispatchConstants.CITY_DdDoutageplan_PERFORMED
				+ "' and To_Char(t.freturntime, 'YYYYMMDD')  = To_Char(sysdate, 'YYYYMMDD') and b.fdayplanno=t.zdddayplanexcutelist1.fdayplanno))";
		// 得到最早下令的时间
		QueryListObj queryObj3 = this.ddDoutageplanFacade
				.getElearlydate(earlytimehql);

		String earlytime = (String) queryObj3.getElemList().get(0);
		// 生成显示对象
		showDaysPlanDto showdaysplan = new showDaysPlanDto();
		showdaysplan.setMinTime(earlytime);
		if (queryObj2.getElemList() != null
				&& queryObj2.getElemList().size() > 0) {
			for (int i = 0; i < queryObj2.getElemList().size(); i++) {
				DdDoutageplanDto dto = (DdDoutageplanDto) queryObj2
						.getElemList().get(i);
				String earlyti = getEarlyTime(dto);
				DayPlanWorkDto workdto = new DayPlanWorkDto();
				workdto.setDto(dto);
				workdto.setEarlyTime(earlyti);
				showdaysplan.addDayPlanWorkDto(workdto);
			}
		}

		return null;
	}

	/**
	 * 得到日计划最早的下令日期
	 * 
	 * @param dto
	 * @return
	 */
	public String getEarlyTime(DdDoutageplanDto dto) {
		String hql = "select min(to_char(d.fsendcmdtime,'YYYY-MM-DD HH:MM')) from  DdDayplanexcutelist d where d.zdddayplanexcutelist1.fdayplanno='"
				+ dto.getFdayplanno() + "'";
		QueryListObj queryObj = this.ddDoutageplanFacade.getElearlydate(hql);
		if (queryObj.getElemList() != null && queryObj.getElemList().size() > 0)
			return (String) queryObj.getElemList().get(0);
		else {
			return null;
		}
	}

	/**
	 * 初始化执行页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdDoutageplanForm ddDoutageplanForm = (DdDoutageplanForm) form;
		String mainId = (String) request.getParameter("mainId");
		DdDoutageplanDto ddDoutageplanDto = null;
		if (StringUtils.isNotEmpty(mainId)) {// 修改
			ddDoutageplanDto = ddDoutageplanFacade.getDdDoutageplanById(mainId);
		}
		ddDoutageplanForm.setDdDoutageplanDto(ddDoutageplanDto);
		// 查找日计划配合记录

		/*
		 * 
		 * String hql = "select d from Dayplancoopraterel d where
		 * d.zdayplancoopraterel1.fdayplanno='"+planid+"'"; List dtolist = new
		 * ArrayList(); List sumInfo = new ArrayList(); QueryListObj queryObj =
		 * ddDoutageplanFacade.listDayplancoopraterelByHql(hql);
		 * if(queryObj.getElemList().size()!=0){ DayplancoopraterelDto dto =
		 * (DayplancoopraterelDto)queryObj.getElemList().get(0); java.sql.Date
		 * date = dto.getCooperatedate(); String name = dto.getFcooperatename();
		 * //to_char(d.cooperatedate,'YYYY-MM-DD')='"+date+"' and
		 * d.fcooperatename='"+name+"'"; String getplanhql="select p from
		 * DdDoutageplan p ,Dayplancoopraterel d where
		 * d.zdayplancoopraterel1.fdayplanno=p.fdayplanno and
		 * to_char(d.cooperatedate,'YYYY-MM-DD')='"+date+"' and
		 * d.fcooperatename='"+name+"' and p.fdayplanno!='"+planid+"'"; queryObj =
		 * ddDoutageplanFacade.listDdDoutageplanByHql(getplanhql); }
		 */
		String hql = "select d from Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno='"
				+ mainId + "'";
		QueryListObj queryObj = ddDoutageplanFacade
				.listDayplancoopraterelByHql(hql);
		if (queryObj.getElemList().size() != 0) {
			DayplancoopraterelDto dto = (DayplancoopraterelDto) queryObj
					.getElemList().get(0);
			java.sql.Date date = dto.getCooperatedate();
			String name = dto.getFcooperatename();
			// to_char(d.cooperatedate,'YYYY-MM-DD')='"+date+"' and
			// d.fcooperatename='"+name+"'";
			String getplanhql = "select p from DdDoutageplan p ,Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno=p.fdayplanno and to_char(d.cooperatedate,'YYYY-MM-DD')='"
					+ date
					+ "' and d.fcooperatename='"
					+ name
					+ "' and (p.fexcutestatus='"
					+ DispatchConstants.CITY_DdDoutageplan_DISPATCHED
					+ "' or p.fexcutestatus='"
					+ DispatchConstants.CITY_DdDoutageplan_ORDERED + "')";
			queryObj = ddDoutageplanFacade.listDdDoutageplanByHql(getplanhql);
			if (queryObj.getElemList() != null) {
				request.setAttribute("coopnum", queryObj.getElemList().size()
						+ "");
			} else {
				request.setAttribute("coopnum", "0");
			}
		} else {
			request.setAttribute("coopnum", "0");
		}
		return mapping.findForward("dddexecute");
	}

	/**
	 * @business method list
	 * @日计划查看
	 * 
	 * 
	 * @设备参数输入
	 * @调度日计划延迟
	 * 
	 * 
	 * @拟定操作票
	 * 
	 * 
	 * @施工组数牌
	 * 
	 * 
	 * @从间隔获得停电范围和设备列表
	 * @日计划取消
	 * 
	 * 
	 * @日计划执行
	 * 
	 * 
	 * @日计划批准信息维护
	 * 
	 * 
	 * @调度员填写临时日计划
	 */
	// please add your business methods start
	// to do it
	// add your business method end

	/**
	 * 方式变更查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modechangeGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		String parentid = (String) request.getParameter("parentid");
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		// 通过日计划ID来查询方式变更

		String hql = "select d from DdfsModechangelist d where d.zddfsmodechangelist4.fdayplanno='"
				+ parentid + "'";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade
				.listDdfsModechangelistByHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 保存方式变更可编辑表格
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveModechangeGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath = "";
			if (files.length > 0) {
				String path = files[0].getParent();
				classPath += path + "\\" + "DdDoutageplanDto1" + ".xml";
			}
			// return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdfsModechangelistDto modechange = new DdfsModechangelistDto();
			// DdDoutageplanDto ddto = new DdDoutageplanDto();
			List list = engine.getDtoList(head, dates, modechange, filePath);
			ArrayList nlist = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				DdfsModechangelistDto ndto = (DdfsModechangelistDto) list
						.get(i);
				ndto.setSys_fille(BusinessDetailHelper
						.getBusDetailInfo(request).getUserName());
				ndto.setSys_filldept(BusinessDetailHelper.getBusDetailInfo(
						request).getUserDeptName());
				ndto.setSys_filltime(BusinessDetailHelper.getBusDetailInfo(
						request).getCurrentTime());
				nlist.add(ndto);
			}
			ddDoutageplanFacade.saveOrUpdateDdfsModechangelist(nlist);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 删除方式变更
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteModechangeGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("ids");
			String version = request.getParameter("version");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(ids);
			String[] idds = ids.split(";");
			String[] versions = version.split(";");
			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdfsModechangelistDto dto = new DdfsModechangelistDto();
				dto.setFid(idds[i]);
				dto.setVersion(Integer.parseInt(versions[i]));
				list.add(dto);
			}
			ddDoutageplanFacade.deleteDdfsModechangelist(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 日计划下令查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward executeGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		String parentid = (String) request.getParameter("parentid");
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		String hql = "select d from DdDayplanexcutelist d where d.zdddayplanexcutelist1.fdayplanno='"
				+ parentid + "'";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade
				.listDdDayplanexcutelistByHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 保存日计划下令表格
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveExecuteGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			// String parentid = request.getParameter("parentid");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath = "";
			if (files.length > 0) {
				String path = files[0].getParent();
				classPath += path + "\\" + "DdDoutageplanDto2" + ".xml";
			}
			// return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdDayplanexcutelistDto exedto = new DdDayplanexcutelistDto();

			List list = engine.getDtoList(head, dates, exedto, filePath);
			ArrayList nlist = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				DdDayplanexcutelistDto ndto = (DdDayplanexcutelistDto) list
						.get(i);
				ndto.setSys_fille(BusinessDetailHelper
						.getBusDetailInfo(request).getUserName());
				ndto.setSys_filldept(BusinessDetailHelper.getBusDetailInfo(
						request).getUserDeptName());
				ndto.setSys_filltime(BusinessDetailHelper.getBusDetailInfo(
						request).getCurrentTime());
				nlist.add(ndto);
			}
			ddDoutageplanFacade.saveOrUpdateDdDayplanexcutelist(nlist);
			// 修改日计划的状态为已下令

			exedto = (DdDayplanexcutelistDto) list.get(0);
			DdDoutageplanDto dddto = exedto.getZdddayplanexcutelist1();
			dddto = ddDoutageplanFacade.getDdDoutageplanById(dddto
					.getFdayplanno());
			if (!dddto.getFexcutestatus().equals(
					DispatchConstants.CITY_DdDoutageplan_PERFORMED)) {
				dddto
						.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_ORDERED);
				this.setCollectionnull(dddto);
				ddDoutageplanFacade.addDdDoutageplan(dddto);
			}
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 删除日计划下令
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteExecuteGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("ids");
			String version = request.getParameter("version");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(ids);
			String[] idds = ids.split(";");
			String[] versions = version.split(";");
			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdDayplanexcutelistDto dto = new DdDayplanexcutelistDto();
				dto.setFid(idds[i]);
				dto.setVersion(Integer.parseInt(versions[i]));
				// dto.setZddfsmodechangelist4(null);
				// dto.setZddfsmodechangelist5(null);
				list.add(dto);
			}
			DdDayplanexcutelistDto exedto = (DdDayplanexcutelistDto) ddDoutageplanFacade
					.loadDdDayplanexcutelist(idds[0]);
			ddDoutageplanFacade.deleteDdDayplanexcutelist(list);

			// 删除后判断是否还有执行记录如果没有,把日计划的状态改为已下发
			// DdDayplanexcutelistDto
			// exedto=(DdDayplanexcutelistDto)list.get(0);
			DdDoutageplanDto dddto = exedto.getZdddayplanexcutelist1();
			String hql = "select d from DdDayplanexcutelist d where d.zdddayplanexcutelist1.fdayplanno='"
					+ dddto.getFdayplanno() + "'";
			List dtolist = new ArrayList();
			QueryListObj queryObj = ddDoutageplanFacade
					.listDdDayplanexcutelistByHql(hql);
			dtolist = queryObj.getElemList();
			if (dtolist.size() < 1) {
				dddto = ddDoutageplanFacade.getDdDoutageplanById(dddto
						.getFdayplanno());
				dddto
						.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_DISPATCHED);
				this.setCollectionnull(dddto);
				ddDoutageplanFacade.addDdDoutageplan(dddto);
			}

			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 日计划延期查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delayGridQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		String parentid = (String) request.getParameter("parentid");
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		String hql = "select d from DdDayplandelaylist d where d.zdddayplandelaylist1.fdayplanno='"
				+ parentid + "'";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade
				.listDdDayplandelaylistByHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 日计划延期保存
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveDelayGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			// String parentid = request.getParameter("parentid");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath = "";
			if (files.length > 0) {
				String path = files[0].getParent();
				classPath += path + "\\" + "DdDoutageplanDto3" + ".xml";
			}
			// return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdDayplandelaylistDto dldto = new DdDayplandelaylistDto();

			List list = engine.getDtoList(head, dates, dldto, filePath);
			ArrayList nlist = new ArrayList();
			for (int i = 0; i < list.size(); i++) {
				DdDayplandelaylistDto ndto = (DdDayplandelaylistDto) list
						.get(i);
				ndto.setSys_fille(BusinessDetailHelper
						.getBusDetailInfo(request).getUserName());
				ndto.setSys_filldept(BusinessDetailHelper.getBusDetailInfo(
						request).getUserDeptName());
				ndto.setSys_filltime(BusinessDetailHelper.getBusDetailInfo(
						request).getCurrentTime());
				nlist.add(ndto);
			}
			ddDoutageplanFacade.saveOrUpdateDdDayplandelaylist(nlist);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 日计划延期删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteDelayGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("ids");
			String version = request.getParameter("version");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(ids);
			String[] idds = ids.split(";");
			String[] versions = version.split(";");
			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdDayplandelaylistDto dto = new DdDayplandelaylistDto();
				dto.setFid(idds[i]);
				dto.setVersion(Integer.parseInt(versions[i]));
				// dto.setZddfsmodecdto.setVersion(Integer.parseInt(versions[i]));hangelist4(null);
				// dto.setZddfsmodechangelist5(null);
				list.add(dto);
			}
			ddDoutageplanFacade.deleteDdDayplandelaylist(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	// 日计划配合

	/**
	 * 查询配合关系
	 */
	public ActionForward coopratereGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		String hql = "select d.fcooperatename,d.cooperatedate from Dayplancoopraterel d  group by d.fcooperatename,d.cooperatedate order by d.cooperatedate desc";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade
				.listDayplancoopraterelByGroupHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	public static String analysisHQL(String outhql, String oldHql) {

		if (outhql == null && !outhql.equals(""))
			return oldHql;
		if (outhql.indexOf("WHERE") != -1) {
			String[] wheres = outhql.split("WHERE");
			if (oldHql.indexOf("order by") != -1) {

				if (oldHql.indexOf("group by") != -1) {

					String[] groups = oldHql.split("group by");
					oldHql = groups[0] + " and " + wheres[1] + " " + groups[1];
				} else {

					String[] orders = oldHql.split("order by");
					oldHql = orders[0] + " and " + wheres[1] + " " + orders[1];
				}
			} else {

				oldHql += " and " + wheres[1];
			}

		}
		if (outhql.indexOf("ORDER BY") != -1) {
			String[] orders = outhql.split("ORDER BY");
			oldHql += " " + orders[1];
		}

		return oldHql;
	}

	/**
	 * 查询当前配合下的日计划
	 * 
	 */

	public ActionForward coopratereDayPlanGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID
		String cooperatedate = request.getParameter("date");
		String fcooperatename = request.getParameter("name");
		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		String hql = "select b from DdDoutageplan b ,Dayplancoopraterel d where b.fdayplanno=d.zdayplancoopraterel1.fdayplanno and to_char(d.cooperatedate,'YYYY-MM-DD')='"
				+ cooperatedate
				+ "' and d.fcooperatename='"
				+ fcooperatename
				+ "'";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade.listDdDoutageplanByHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 查寻可供选择的日计划(状态为已下发和已下令的)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward dispatchedDayPlanGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		// String hqlSql = gridInfo.getHqlSql();
		int count = 0;
		// String hql = "select b from DdDoutageplan b ,Dayplancoopraterel d
		// where b.fdayplanno=d.zdayplancoopraterel1.fdayplanno and
		// to_char(d.cooperatedate,'YYYY-MM-DD')='"+cooperatedate+"' and
		// d.fcooperatename='"+fcooperatename+"'";
		String hql = "select A from DdDoutageplan A where not exists(select A from  Dayplancoopraterel B where B.zdayplancoopraterel1.fdayplanno=A.fdayplanno) and (A.fexcutestatus='"
				+ DispatchConstants.CITY_DdDoutageplan_DISPATCHED
				+ "' or A.fexcutestatus='"
				+ DispatchConstants.CITY_DdDoutageplan_ORDERED
				+ "') order by A.fapplytime ";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade.listDdDoutageplanByHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 显示配合详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showCopperateDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DayplancoopraterelDto dto = new DayplancoopraterelDto();
		try {
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String opp = request.getParameter("opp");
			if (opp.equals("update")) {
				dto.setCooperatedate(("".equals(date) || date == null) ? null
						: DateUtil.stringToSqlDate(date, "yyyy-MM-dd"));
				dto.setFcooperatename(name);
			}
			request.setAttribute("dayplancoopraterelDto", dto);
			request.setAttribute("opp", opp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("showCopperateDetail");
	}

	// 添加/修改日计划配合详情

	public ActionForward saveCopperate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String opp = request.getParameter("opp");
			if (opp.equals("add")) {
				// 新增日计划

				DayplancoopraterelDto dto = new DayplancoopraterelDto();
				dto.setFrelid(new SequenceCreator().getUID());
				dto.setCooperatedate(("".equals(date) || date == null) ? null
						: DateUtil.stringToSqlDate(date, "yyyy-MM-dd"));
				dto.setFcooperatename(name);
				ddDoutageplanFacade.addDayplancoopraterel(dto);
				dto = ddDoutageplanFacade.loadDayplancoopraterel(dto
						.getFrelid());
				request.setAttribute("dayplancoopraterelDto", dto);
				request.setAttribute("opp", opp);
			} else {
				// 修改日计划

				String oldname = request.getParameter("oldname");
				String olddate = request.getParameter("olddate");
				String hql = "select d from Dayplancoopraterel d where  to_char(d.cooperatedate,'YYYY-MM-DD')='"
						+ olddate + "' and d.fcooperatename='" + oldname + "'";
				QueryListObj obj = ddDoutageplanFacade
						.listDayplancoopraterelByHql(hql);
				List list = obj.getElemList();
				List newList = new ArrayList();
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						DayplancoopraterelDto dto = (DayplancoopraterelDto) list
								.get(i);
						dto.setFcooperatename(name);
						dto
								.setCooperatedate(("".equals(date) || date == null) ? null
										: DateUtil.stringToSqlDate(date,
												"yyyy-MM-dd"));
						newList.add(dto);
					}
					ddDoutageplanFacade.saveOrUpdateDayplancoopraterel(newList);
					request.setAttribute("dayplancoopraterelDto", newList
							.get(0));
					request.setAttribute("opp", opp);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("showCopperateDetail");
	}

	/**
	 * 日计划加入配合
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ActionForward joinCopperate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		try {

			String[] ids = (request.getParameter("ids")).split("###");
			// ddDoutageplanFacade.joinDayplancoopraterel(name,date,ids);
			String hql = "select d from Dayplancoopraterel d where  to_char(d.cooperatedate,'YYYY-MM-DD')='"
					+ date + "' and d.fcooperatename='" + name + "'";
			QueryListObj obj = ddDoutageplanFacade
					.listDayplancoopraterelByHql(hql);

			ArrayList list = new ArrayList();
			if (isNewcoopraterel(obj)) {
				// 第一次加配合
				for (int i = 0; i < ids.length; i++) {
					DayplancoopraterelDto dto = new DayplancoopraterelDto();
					dto.setFrelid(new SequenceCreator().getUID());
					if (i == 0) {
						dto = (DayplancoopraterelDto) (obj.getElemList().get(0));
					}
					dto
							.setCooperatedate(("".equals(date) || date == null) ? null
									: DateUtil.stringToSqlDate(date,
											"yyyy-MM-dd"));
					dto.setFcooperatename(name);
					DdDoutageplanDto dayplandto = new DdDoutageplanDto();
					dayplandto.setFdayplanno(ids[i]);
					dto.setZdayplancoopraterel1(dayplandto);
					list.add(dto);
				}

			} else {
				// 添加新的日计划配合

				for (int i = 0; i < ids.length; i++) {
					DayplancoopraterelDto dto = new DayplancoopraterelDto();
					dto.setFrelid(new SequenceCreator().getUID());
					dto
							.setCooperatedate(("".equals(date) || date == null) ? null
									: DateUtil.stringToSqlDate(date,
											"yyyy-MM-dd"));
					dto.setFcooperatename(name);
					DdDoutageplanDto dayplandto = new DdDoutageplanDto();
					dayplandto.setFdayplanno(ids[i]);
					dto.setZdayplancoopraterel1(dayplandto);
					list.add(dto);
				}

			}

			ddDoutageplanFacade.saveOrUpdateDayplancoopraterel(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String forward = mapping.findForward("copperatedispatchdayplan")
				.getPath();
		Object[] obj = { name, date };
		System.out.println("forward" + forward);
		forward = MessageFormat.format(forward, obj);
		return new ActionForward(forward);
		// return mapping.findForward("copperatedayplan");
	}

	/**
	 * 判断是否是新的配合
	 * 
	 * @param obj
	 * @return
	 */
	private boolean isNewcoopraterel(QueryListObj obj) {
		if (obj.getElemList().size() == 1) {
			DayplancoopraterelDto dto = (DayplancoopraterelDto) (obj
					.getElemList().get(0));
			if (dto.getZdayplancoopraterel1() == null
					|| dto.getZdayplancoopraterel1().getFdayplanno() == null
					|| dto.getZdayplancoopraterel1().getFdayplanno()
							.equalsIgnoreCase("")) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * 退出日计划配合
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward exitCooperate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		try {

			String[] ids = (request.getParameter("ids")).split("###");
			// ddDoutageplanFacade.joinDayplancoopraterel(name,date,ids);
			String hql = "select d from Dayplancoopraterel d where  to_char(d.cooperatedate,'YYYY-MM-DD')='"
					+ date + "' and d.fcooperatename='" + name + "'";
			QueryListObj obj = ddDoutageplanFacade
					.listDayplancoopraterelByHql(hql);
			List exitList = new ArrayList();
			for (int i = 0; i < obj.getElemList().size(); i++) {
				DayplancoopraterelDto dto = (DayplancoopraterelDto) obj
						.getElemList().get(i);
				for (int j = 0; j < ids.length; j++) {
					if (dto.getZdayplancoopraterel1() != null
							&& dto.getZdayplancoopraterel1().getFdayplanno()
									.equals(ids[j]))
						exitList.add(dto);
				}
			}
			System.out.println("exitListexitLis+" + exitList.size());
			ddDoutageplanFacade.deleteDayplancoopraterel(exitList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String forward = mapping.findForward("copperatedayplan").getPath();
		Object[] obj = { name, date };
		forward = MessageFormat.format(forward, obj);
		return new ActionForward(forward);
	}

	/**
	 * 查询配合里的日计划(不包括当前的日计划)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward coopratereDayPlanGridQuery2(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String planid = request.getParameter("planid");
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID
		int count = 0;
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		String hql = "select d from Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno='"
				+ planid + "'";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade
				.listDayplancoopraterelByHql(hql);
		if (queryObj.getElemList().size() != 0) {

			DayplancoopraterelDto dto = (DayplancoopraterelDto) queryObj
					.getElemList().get(0);
			java.sql.Date date = dto.getCooperatedate();
			String name = dto.getFcooperatename();
			// to_char(d.cooperatedate,'YYYY-MM-DD')='"+date+"' and
			// d.fcooperatename='"+name+"'";
			String getplanhql = "select p from DdDoutageplan p ,Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno=p.fdayplanno and to_char(d.cooperatedate,'YYYY-MM-DD')='"
					+ date
					+ "' and d.fcooperatename='"
					+ name
					+ "' and p.fdayplanno!='" + planid + "'";
			queryObj = ddDoutageplanFacade.listDdDoutageplanByHql(getplanhql);
		}
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);

	}

	/**
	 * 还没有完成的日计划配合查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward coopratereUnfinishedDayPlanGridQuery(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String planid = request.getParameter("planid");
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID
		int count = 0;
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);
		String hql = "select  d.fcooperatename,d.cooperatedate from DdDoutageplan p ,Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno=p.fdayplanno and (p.fexcutestatus='"
				+ DispatchConstants.CITY_DdDoutageplan_DISPATCHED
				+ "' or p.fexcutestatus='"
				+ DispatchConstants.CITY_DdDoutageplan_ORDERED
				+ "') group by d.fcooperatename,d.cooperatedate order by d.cooperatedate desc";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddDoutageplanFacade
				.listDayplancoopraterelByGroupHql(hql);
		dtolist = queryObj.getElemList();
		count = queryObj.getCount();
		sumInfo = queryObj.getPropertySum();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		System.out.println(xmlStr);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	/**
	 * 日计划加入配合(从日计划执行页面加入)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ActionForward dayplanjoinCopperate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String id = request.getParameter("ids");
		try {
			// ddDoutageplanFacade.joinDayplancoopraterel(name,date,ids);
			String hql = "select d from Dayplancoopraterel d where  to_char(d.cooperatedate,'YYYY-MM-DD')='"
					+ date + "' and d.fcooperatename='" + name + "'";
			QueryListObj obj = ddDoutageplanFacade
					.listDayplancoopraterelByHql(hql);

			ArrayList list = new ArrayList();
			if (isNewcoopraterel(obj)) {
				// 第一次加配合
				DayplancoopraterelDto dto = (DayplancoopraterelDto) (obj
						.getElemList().get(0));
				dto.setCooperatedate(("".equals(date) || date == null) ? null
						: DateUtil.stringToSqlDate(date, "yyyy-MM-dd"));
				dto.setFcooperatename(name);
				DdDoutageplanDto dayplandto = new DdDoutageplanDto();
				dayplandto.setFdayplanno(id);
				dto.setZdayplancoopraterel1(dayplandto);
				list.add(dto);
			} else {
				// 添加新的日计划配合

				// 判断是否已经加入日计划配合

				String checksql = "select p from DdDoutageplan p ,Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno='"
						+ id + "'";
				QueryListObj obj2 = ddDoutageplanFacade
						.listDdDoutageplanByHql(checksql);
				if (obj2.getElemList() != null && obj2.getElemList().size() > 0) {

				} else {
					DayplancoopraterelDto dto = new DayplancoopraterelDto();
					dto.setFrelid(new SequenceCreator().getUID());
					dto
							.setCooperatedate(("".equals(date) || date == null) ? null
									: DateUtil.stringToSqlDate(date,
											"yyyy-MM-dd"));
					dto.setFcooperatename(name);
					DdDoutageplanDto dayplandto = new DdDoutageplanDto();
					dayplandto.setFdayplanno(id);
					dto.setZdayplancoopraterel1(dayplandto);
					list.add(dto);
				}
			}
			ddDoutageplanFacade.saveOrUpdateDayplancoopraterel(list);
			// 计算共几张

			String getplanhql = "select p from DdDoutageplan p ,Dayplancoopraterel d where d.zdayplancoopraterel1.fdayplanno=p.fdayplanno and to_char(d.cooperatedate,'YYYY-MM-DD')='"
					+ date
					+ "' and d.fcooperatename='"
					+ name
					+ "' and (p.fexcutestatus='"
					+ DispatchConstants.CITY_DdDoutageplan_DISPATCHED
					+ "' or p.fexcutestatus='"
					+ DispatchConstants.CITY_DdDoutageplan_ORDERED + "')";
			obj = ddDoutageplanFacade.listDdDoutageplanByHql(getplanhql);
			if (obj.getElemList() != null) {
				request.setAttribute("coopnum", obj.getElemList().size() + "");
			} else {
				request.setAttribute("coopnum", "0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String forward = mapping.findForward("executecopperatedayplan")
				.getPath();
		Object[] obj = { id };
		System.out.println("forward" + forward);
		forward = MessageFormat.format(forward, obj);
		return new ActionForward(forward);
		// return mapping.findForward("copperatedayplan");
	}

	public void setDdSwitchseqbillFacade(
			DdSwitchseqbillFacade ddSwitchseqbillFacade) {
		this.ddSwitchseqbillFacade = ddSwitchseqbillFacade;
	}

	public ActionForward toolbarOperation(ActionMapping mapping,

	ActionForm form,

	HttpServletRequest request,

	HttpServletResponse response) throws Exception {

		String hqlStr = "";

		GridInfoObj gridInfo = sysUiGridFacade.getGenGridInfo(request, hqlStr);

		String hqlSql = gridInfo.getHqlSql();

		int beginPage = gridInfo.getBeginPage();

		int pageSize = gridInfo.getPageSize();

		String sumSql = gridInfo.getSumSql();

		int count = 0;

		List dtolist = new ArrayList();

		List sumInfo = new ArrayList();

		if (!StringUtils.isEmpty(hqlSql)) {

			QueryListObj qObj = ddDoutageplanFacade.getDdDoutageplanByHql(
					hqlSql, beginPage, pageSize, sumSql);

			dtolist = qObj.getElemList();

		}

		DdDoutageplanDto dto = (DdDoutageplanDto) dtolist.get(0);

		String mainId = dto.getFdayplanno();

		return this.printResponseMes(request, response, mapping, "null", mainId
				+ "");

	}

	/**
	 * 查询电子章
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward loadstamps(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("ids");
		ArrayList list = new ArrayList();
		if (ids != null && !ids.equals("") && !ids.equals("null")) {
			String[] stampids = ids.split(";");
			for (int i = 0; i < stampids.length; i++) {
				String id = stampids[i];
				StdElectricstampDto dto = stdElectricstampFacade
						.loadStdElectricstamp(id);
				list.add(dto);
			}
		}
		String edit = request.getParameter("edit");
		request.setAttribute("edit", edit);
		if (list.size() > 0) {
			request.setAttribute("stamps", list);
		}
		return mapping.findForward("dayplanstamps");
	}

	/**
	 * 工作流处理
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward workflowHandle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserProfile userP = (UserProfile) (request.getSession()
				.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));

		String userId = userP.getUserName();
		String roleId = "dd";

		String busId = request.getParameter("wf_busId"); // 业务ID
		String taskId = request.getParameter("wf_taskId"); // 任务实例ID
		String taskInstanceId = request.getParameter("wf_taskInstanceId"); // 任务实例ID
		String status = request.getParameter("wf_status"); // 状态

		String notices = request.getParameter("notice"); // 处理意见
		String messages = request.getParameter("message"); // 消息内容
		String sentPersons = request.getParameter("sentPersons"); // 消息接收人

		String isSms = request.getParameter("isSms"); // 是否发送手机短信

		String[] nextTaskRoles = request.getParameterValues("nextTaskRoles"); // 流转人员安排
		// for(int i=0;i<nextTaskRoles.length;i++){
		// System.out.println(nextTaskRoles[i]);
		// }baibai
		String transitionFlag = request.getParameter("transitionFlag"); // 流转处理标记

		WorkflowHandleDto dto = new WorkflowHandleDto();
		dto.setBusId(busId);
		dto.setIsSms(isSms);
		dto.setMessages(messages);
		dto.setNextTaskRoles(nextTaskRoles);
		dto.setNotices(notices);
		dto.setRoleId(roleId);
		dto.setSentPersons(sentPersons);
		dto.setStatus(status);
		dto.setTaskId(taskId);
		dto.setTaskInstanceId(taskInstanceId);
		dto.setTransitionFlag(transitionFlag);
		dto.setUserId(userId);
		if (StringUtils.isNotEmpty(busId)) {
			int statusFlag = Integer.parseInt(status);
			switch (statusFlag) {
			case 1:
				this.ddDoutageplanFacade.start(dto);
				break;
			case 2:
				this.ddDoutageplanFacade.ddDayPlanSpecArrange(dto);
				break;
			case 3:
				this.ddDoutageplanFacade.ddDayPlanCoursign(dto);
				break;
			case 4:
				this.ddDoutageplanFacade.ddDayPlanSent(dto);
				break;
			case 5:
				this.ddDoutageplanFacade.ddDayPlanFillExec(dto);
				break;
			case 6:
				this.ddDoutageplanFacade.ddDayPlanSpecKeepon(dto);
				break;
			case 7:{
				if(dto.getTransitionFlag().equals(""))
				this.ddDoutageplanFacade.ddDayPlanCustomerApprove(dto);
				else this.ddDoutageplanFacade.ddDayPlanInfocustomer(dto);		
			  break;
			}
		//	case 8:
		//		this.ddDoutageplanFacade.ddDayPlanInfocustomer(dto);
		//		break;
			default:
				new Exception();
				break;

			}

		}

		return mapping.findForward("");
	}


}
