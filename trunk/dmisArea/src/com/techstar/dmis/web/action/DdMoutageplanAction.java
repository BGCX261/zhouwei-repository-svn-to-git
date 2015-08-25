package com.techstar.dmis.web.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import com.techstar.framework.utils.SequenceCreator;

import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;

import com.techstar.dmis.service.impl.DdRepairrisklistServiceImpl;
import com.techstar.dmis.web.facade.DdDoutageplanFacade;
import com.techstar.dmis.web.facade.DdMoutageplanFacade;
import com.techstar.dmis.web.facade.DdRepairrisklistFacade;
import com.techstar.dmis.web.facade.DdWoutageplanFacade;
import com.techstar.dmis.web.form.DdMoutageplanForm;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.impl.DdRepairdetailDaoImpl;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.dto.DdRepairdetailDto;
import com.techstar.dmis.dto.DdRepairrisklistDto;
import com.techstar.dmis.dto.DdWoutageplanDto;
import com.techstar.dmis.entity.DdMoutageplan;
import com.techstar.dmis.entity.DdRepairdetail;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.ddmoutageplan.DdmoutageplanHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.web.facade.StdDispatchunitFacade;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdMoutageplanAction extends BaseDispatchAction {

	private final String mergeSuccess = "合并成功";

	private final String mergeError = "合并失败";

	private DdMoutageplanFacade ddMoutageplanFacade;

	private DdDoutageplanFacade ddDoutageplanFacade;

	private DdWoutageplanFacade ddWoutageplanFacade;

	private DdRepairrisklistFacade ddRepairrisklistFacade;

	private SysUiGridFacade sysUiGridFacade;

	private StdDispatchunitFacade stdDispatchFacade;

	public DdMoutageplanAction() {
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
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 查询列表
		List list = ddMoutageplanFacade.listDdMoutageplan();
		request.getSession().setAttribute("DdMoutageplanList", list);

		// 记录操作日志
		// saveLog("DdMoutageplaner", "查询列表");
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
		DdMoutageplanForm ddMoutageplanForm = (DdMoutageplanForm) form;
		DdMoutageplanDto dto = ddMoutageplanForm.getDdMoutageplanDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFmonthplanno())) {
			dto.setFmonthplanno(new SequenceCreator().getUID()); // 生成内部序列号

		}
		ddMoutageplanFacade.addDdMoutageplan(dto);

		// saveLog("DdMoutageplaner", "增加记录");
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
		DdMoutageplanForm ddMoutageplanForm = (DdMoutageplanForm) form;
		String fmonthplanno = request.getParameter("fmonthplanno");
		if (StringUtils.isNotEmpty(fmonthplanno)) {
			DdMoutageplanDto dto = ddMoutageplanFacade
					.getDdMoutageplanById(fmonthplanno);
			ddMoutageplanForm.setDdMoutageplanDto(dto);
		}

		// saveLog("DdMoutageplaner", "初始化记录操作");
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

		String fmonthplannoStr = request.getParameter("fmonthplanno");
		String versionStr = request.getParameter("version");
		String[] primArra = fmonthplannoStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String fmonthplanno = primArra[i];
			String version = versionArra[i];
			if (StringUtils.isNotEmpty(fmonthplanno)) {
				ddMoutageplanFacade.deleteDdMoutageplan(fmonthplanno, version);
			}
		}

		return this
				.printResponseMes(request, response, mapping, "null", "删除成功");
	}

	/**
	 *
	 * 填写未完成原因
	 *
	 *
	 *
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eomUpdataState(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdMoutageplanForm ddMoutageplanForm = (DdMoutageplanForm) form;

		String fmonthplanno = request.getParameter("fmonthplanno");
		String reason = request.getParameter("reason");
		String rcode = request.getParameter("rcode");

		if (fmonthplanno != null && reason != null && rcode != null) {
			DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
					.getDdMoutageplanById(fmonthplanno);
			ddMoutageplanDto.setFunfinishreasonid(rcode);
			ddMoutageplanDto.setFunfinishreason(reason);
			ddMoutageplanDto.setFddpremethod5(null);
			ddMoutageplanDto.setFddrepairdetail1(null);
			ddMoutageplanDto
					.setFexcutestatus(DispatchConstants.ddMoutageplan_unfinish);

			ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);

			return this.printResponseMes(request, response, mapping, "null",
					"填写未完成原因成功");
		} else {
			return this.printResponseMes(request, response, mapping, "null",
					"填写未完成原因失败!!!");
		}
		// return mapping.findForward("ddMoutageplanframe");
	}

	/**
	 *
	 * 从未完成计划生成新计划
	 *
	 *
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward newPlanFromNot(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);

		// 用户登录名

		String loginName = bdt.getLoginName();

		// 用户ID

		String userId = bdt.getUserId();

		// 用户名称

		String userName = bdt.getUserName();

		// 当前时间

		Timestamp currentTime = bdt.getCurrentTime();

		// 用户部门ID

		String userDeptId = bdt.getUserDeptId();

		// 用户部门CODE

		String userDeptCode = bdt.getUserDeptCode();

		// 用户部门名称

		String userDeptName = bdt.getUserDeptName();

		// 数据所属单位ID

		String dataOwnerId = bdt.getDataOwnerId();

		// 数据所属单位名称

		String dataOwnerName = bdt.getDataOwnerName();

		String fmonthplannoStr = request.getParameter("fmonthplanno");
		String[] primArra = fmonthplannoStr.split("\\^");
		//
		request.setCharacterEncoding("utf-8");

		for (int i = 0; i < primArra.length; i++) {
			String fmonthplanno = primArra[i];
			if (StringUtils.isNotEmpty(fmonthplanno)) {
				DdMoutageplanDto dto = ddMoutageplanFacade
						.getDdMoutageplanById(fmonthplanno);

				dto.setFplansourceno(dto.getFmonthplanno());
				dto.setFmonthplanno(null);
				dto.setVersion(0);
				dto.setFexcutestatus(DispatchConstants.ddMoutageplan_new);
				dto
						.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_NEW);
				dto
						.setFplansourcetype(DispatchConstants.ddMoutageplan_unfinish);

				dto.setSys_dataowner(dataOwnerName);
				dto.setSys_filldept(userDeptName);
				dto.setSys_fille(userName);
				dto.setSys_filltime(currentTime);
				dto.setIsmerge(null);

				dto.setFddpremethod5(null);
				dto.setFddrepairdetail1(null);

				ddMoutageplanFacade.addDdMoutageplan(dto);
			}
		}
		return this.printResponseMes(request, response, mapping, "null",
				"从未完成计划生成新计划成功");

	}

	public void setDdMoutageplanFacade(DdMoutageplanFacade ddMoutageplanFacade) {
		this.ddMoutageplanFacade = ddMoutageplanFacade;
	}

	// noEditGrid editGrid tab toolbar detail

	// 初始化表格

	public ActionForward standGridQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/*
		 * List dtolist = new ArrayList(); DdMoutageplanFacadeDto
		 * ddMoutageplanDto = new DdMoutageplanDto();
		 * //ddMoutageplanDto.setCustom_id("custom_id");
		 * //ddMoutageplanDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddMoutageplanDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdMoutageplanDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdMoutageplan");
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
			QueryListObj queryObj = ddMoutageplanFacade.getDdMoutageplanByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddMoutageplangrid", xmlStr);
	}

	public ActionForward customGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		List dtolist = (List) request.getSession().getAttribute(
				"DdMoutageplanList");

		int count = dtolist.size();
		List sumInfo = new ArrayList();
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, beginPage, pageSize, count,
				sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddMoutageplangrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddMoutageplantoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String method = "<Toolbar>   <Business>      <id>DdMoutageplan</id>      <name>月停电计划</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='月计划归档' id='ddm_pigeonhole' href='pigeonhole' title=''></OperItem>   <OperItem Text='生成日计划' id='ddm_dayPlan' href='dayPlan' title=''></OperItem> <OperItem Text='生成旬计划' id='wPlan' href='wPlan' title=''></OperItem> <OperItem Text='未完成计划生成月计划' id='ddm_newPlanFromNot' href='newPlanFromNot' title=''></OperItem> <OperItem Text='月计划合并 添加新内容' id='ddm_uniteByContent' href='uniteByContent' title=''></OperItem> <OperItem Text='月计划合并 添加新计划' id='ddm_uniteByObject' href='uniteByObject' title=''></OperItem> <OperItem Text='填写未完成原因' id='ddm_eomUpdataState' href='eomUpdataState' title=''></OperItem> <OperItem Text='从间隔获得停电范围及设备列表' id='ddm_dd_selectbayeqp' href='#' title=''></OperItem><OperItem Text='工作流-处理历史' id='ddm_wf_history' href='wf_history' title=''></OperItem></Toolbar>";
		request.setAttribute("xmlData", method);
		return mapping.findForward("ddMoutageplantoolbar");
	}

	// 初始化tab页

	public ActionForward ddMoutageplantab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddMoutageplantab");
	}

	public ActionForward ddMoutageplanframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddMoutageplanframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdMoutageplanForm ddMoutageplanForm = (DdMoutageplanForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdMoutageplanDto ddMoutageplanDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(mainId);
				ddMoutageplanDto.setFmonthplanno(null);
				ddMoutageplanDto.setVersion(0);
				ddMoutageplanDto.setFunfinishreason(null);
				ddMoutageplanDto.setFunfinishreasonid(null);
				ddMoutageplanDto.setIsmerge(null);
				ddMoutageplanDto.setFplansourcetype(null);
				ddMoutageplanDto.setFmergeid(null);
				ddMoutageplanDto.setFplansourceno(null);
				// ddMoutageplanDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(mainId);
			} else {// 新增
				ddMoutageplanDto = new DdMoutageplanDto();
				// 设置状态

				ddMoutageplanDto
						.setFexcutestatus(DispatchConstants.ddMoutageplan_new);
				ddMoutageplanDto
						.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_NEW);
			}
		}
		ddMoutageplanForm.setDdMoutageplanDto(ddMoutageplanDto);
		return mapping.findForward("ddMoutageplandetail");
	}

	/**
	 * 显示电网风险分析
	 *
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initRiskanalyse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String mainId = (String) request.getParameter("mainId");
		String hql = "select A from DdRepairrisklist A where A.zddrepairrisklist4.fmonthplanno='"
				+ mainId + "' ";

		QueryListObj queryObj = ddRepairrisklistFacade
				.listDdRepairrisklistByHql(hql);
		List list = queryObj.getElemList();

		if (list.size() != 1)
			request.setAttribute("initRiskanalyseDto",
					new DdRepairrisklistDto());
		else {

			request.setAttribute("initRiskanalyseDto",
					(DdRepairrisklistDto) list.get(0));
		}
		return mapping.findForward("initRiskanalyse_page");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdMoutageplanForm ddMoutageplanForm = (DdMoutageplanForm) form;
		DdMoutageplanDto ddMoutageplanDto = ddMoutageplanForm
				.getDdMoutageplanDto();

		if ((ddMoutageplanDto.getFmonthplanno() == null)
				|| (ddMoutageplanDto.getFmonthplanno().equals(""))) {

			ddMoutageplanDto.setSys_fille(BusinessDetailHelper
					.getBusDetailInfo(request).getUserName());
			ddMoutageplanDto.setSys_filldept(BusinessDetailHelper
					.getBusDetailInfo(request).getUserDeptName());
			ddMoutageplanDto.setSys_filltime(BusinessDetailHelper
					.getBusDetailInfo(request).getCurrentTime());

			// 数据所属单位

			ddMoutageplanDto.setSys_dataowner(stdDispatchFacade
					.getDataOwner(BusinessDetailHelper
							.getBusDetailInfo(request).getDataOwnerName()));
			// 手工编码
			ddMoutageplanDto.setFmonthplancode(BusinessDetailHelper
					.genBusinessNumber("DdMoutageplan"));

			ddMoutageplanDto
					.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_NEW);
			ddMoutageplanDto
					.setFexcutestatus(DispatchConstants.ddMoutageplan_new);
		}

		ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
		ddMoutageplanDto = ddMoutageplanFacade
				.getDdMoutageplanById(ddMoutageplanDto.getFmonthplanno());
		ddMoutageplanForm.setDdMoutageplanDto(ddMoutageplanDto);
		saveMessages(request, "message.save.success", new String[] { "月停电计划" });
		return mapping.findForward("ddMoutageplandetail");
	}

	// 处理DETAIL页面
	public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("ddMoutageplandetail1");
	}

	public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("ddMoutageplandetail1");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	/**
	 *
	 * 归档
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward pigeonhole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fmonthplannoStr = request.getParameter("fmonthplanno");
		String[] primArra = fmonthplannoStr.split("\\^");
		//
		request.setCharacterEncoding("utf-8");

		for (int i = 0; i < primArra.length; i++) {
			String fmonthplanno = primArra[i];
			if (StringUtils.isNotEmpty(fmonthplanno)) {
				DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(fmonthplanno);
				ddMoutageplanDto
						.setFexcutestatus(DispatchConstants.ddMoutageplan_pigeonholed);
				ddMoutageplanDto.setFddpremethod5(null);
				ddMoutageplanDto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
			}
		}
		return this
				.printResponseMes(request, response, mapping, "null", "归档成功");

	}

	/**
	 *
	 * 合并
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward unite(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		request.getSession().removeAttribute("DdMoutageplanList");

		String str = request.getParameter("unite_key");

		List list = new ArrayList();

		try {
			String[] fmonthplannos = StringUtils.split(str, "^");
			if (fmonthplannos != null) {
				int size = fmonthplannos.length;
				for (int i = 0; i < size; i++) {
					DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
							.getDdMoutageplanById(fmonthplannos[i]);
					list.add(ddMoutageplanDto);
				}
			}
		} catch (Exception e) {
			new Exception("合并异常");
		}
		request.getSession().setAttribute("DdMoutageplanList", list);
		//
		return mapping.findForward("unite_page");
	}

	/**
	 *
	 * 合并操作,按内容合
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward doUniteByContent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获得目标
		String fmonthplanno = request.getParameter("para");
		//
		request.setCharacterEncoding("utf-8");
		// 获得选择项

		List list = (List) request.getSession().getAttribute(
				"DdMoutageplanList");
		// 处理合并动作
		return this.printResponseMes(request, response, mapping, "null",
				mergeByContent(list, fmonthplanno));
	}

	/**
	 *
	 * 合并操作,按目标合
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward doUniteByObject(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获得目标
		String fmonthplanno = request.getParameter("para");
		//
		request.setCharacterEncoding("utf-8");
		// 获得选择项

		List list = (List) request.getSession().getAttribute(
				"DdMoutageplanList");
		// 处理合并动作
		return this.printResponseMes(request, response, mapping, "null",
				mergeByObject(list, fmonthplanno));
	}

	/**
	 * 合并,给目标计划添加内容
	 *
	 *
	 *
	 */
	private String mergeByContent(List list, String pk) {

		if (list == null || list.size() == 0)
			return mergeError;
		else {

			String fworkcontent = "";

			for (int i = 0; i < list.size(); i++) {
				DdMoutageplanDto dto = (DdMoutageplanDto) list.get(i);
				fworkcontent = fworkcontent + "，" + dto.getFworkcontent();

				if (dto.getFmonthplanno().equals(pk))
					continue;
				else {
					dto
							.setIsmerge(DispatchConstants.ddMoutageplan_merge_success);
					dto.setFddpremethod5(null);
					dto.setFddrepairdetail1(null);
					ddMoutageplanFacade.addDdMoutageplan(dto);
				}
			}
			// 更新工作内容
			DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
					.getDdMoutageplanById(pk);
			ddMoutageplanDto.setFworkcontent(fworkcontent);
			return mergeSuccess;
		}

	}

	/**
	 *
	 * 合并,按照目标计划生成新的月计划
	 *
	 */
	private String mergeByObject(List list, String pk) {
		if (list == null || list.size() == 0)
			return mergeError;
		else {
			String fworkcontent = "";

			DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
					.getDdMoutageplanById(pk);

			ddMoutageplanDto.setFplansourceno(ddMoutageplanDto
					.getFmonthplanno());

			ddMoutageplanDto.setFmonthplancode(BusinessDetailHelper
					.genBusinessNumber("DdMoutageplan"));

			ddMoutageplanDto.setFmonthplanno(null);
			// 更新状态

			ddMoutageplanDto
					.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_end);
			ddMoutageplanDto
					.setFexcutestatus(DispatchConstants.ddMoutageplan_approveed);
			//
			ddMoutageplanDto
					.setIsmerge(DispatchConstants.ddMoutageplan_merge_success);
			ddMoutageplanDto
					.setFplansourcetype(DispatchConstants.ddMoutageplan_plansourcetype_merge);// 计划来源->合并
			ddMoutageplanDto.setFddpremethod5(null);
			ddMoutageplanDto.setFddrepairdetail1(null);

			String mergerID = ddMoutageplanDto.getFmonthplanno();
			// 更新所有需要合并月计划的合并编号

			for (int i = 0; i < list.size(); i++) {
				DdMoutageplanDto dto = (DdMoutageplanDto) list.get(i);
				dto.setFmergeid(mergerID);
				dto.setIsmerge(DispatchConstants.ddMoutageplan_merge_success);
				dto.setFddpremethod5(null);
				dto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(dto);
				fworkcontent = fworkcontent + "，" + dto.getFworkcontent();
			}

			ddMoutageplanDto.setFworkcontent(fworkcontent);
			ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);

			// mergeContent(list, mergerID, true);
			return mergeSuccess;
		}
	}


	public ActionForward showModalDialog(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String key = request.getParameter("key");

		String hql_dayPlan = "select A from DdMoutageplan A where not exists(select A from  DdDoutageplan B where B.fplansourceno=A.fmonthplanno) and A.fexcutestatus='"
				+ DispatchConstants.ddMoutageplan_approveed + "'";

		String hql_newPlanFromNot = "select A from DdMoutageplan A where A.fexcutestatus='"
				+ DispatchConstants.ddMoutageplan_unfinish + "'";

		if (key.equals("dayPlan")) {
			QueryListObj queryObj = ddMoutageplanFacade
					.listDdMoutageplanByHql(hql_dayPlan);
			List list = queryObj.getElemList();
			request.getSession().setAttribute("DdMoutageplanList", list);
		}
		if (key.equals("newPlanFromNot")) {
			QueryListObj queryObj = ddMoutageplanFacade
					.listDdMoutageplanByHql(hql_newPlanFromNot);
			List list = queryObj.getElemList();
			request.getSession().setAttribute("DdMoutageplanList", list);
		}

		return mapping.findForward("showModalDialog_page");
	}

	public ActionForward doDayPlan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//
		String fmonthplannoStr = request.getParameter("fmonthplanno");
		String[] primArra = fmonthplannoStr.split("\\^");
		//
		request.setCharacterEncoding("utf-8");
		for (int i = 0; i < primArra.length; i++) {
			String fmonthplanno = primArra[i];
			if (StringUtils.isNotEmpty(fmonthplanno)) {
				creatDayPlan(fmonthplanno);
			}
		}
		return this.printResponseMes(request, response, mapping, "null",
				"生成日计划成功");
	}

	private void creatDayPlan(String key_id) {

		// DdDoutageplanDto ddDoutageplanDto = new DdDoutageplanDto();
		// ddDoutageplanFacade.addDdDoutageplan(ddDoutageplanDto);
		// 操作工作内容
		DdMoutageplanDto dto = ddMoutageplanFacade.getDdMoutageplanById(key_id);
		DdDoutageplanDto ddDoutageplanDto = new DdDoutageplanDto();

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

		// ddDoutageplanDto.setFapplytime((Date)
		// Calendar.getInstance().getTime()); // 申请时间
		// 不一致

		// ddDoutageplanDto.setFremark(dto.getfre); // 备注
		// ddDoutageplanDto.setFaddipicture; // 附图
		// ddDoutageplanDto.setFunmeasureannex(dto.getfu); // 反措附件
		// ddDoutageplanDto.setFattention(); // 注意事项
		// ddDoutageplanDto.setFpermitcontent(dto.getfp); // 许可内容
		// ddDoutageplanDto.setfapprooutageword; // 批准停电字

		// ddDoutageplanDto.setfapprooutageno; // 批准停电号

		// ddDoutageplanDto.setfapproworkstime; // 批准工作开始时间

		// ddDoutageplanDto.setfapproworketime; // 批准工作结束时间
		// ddDoutageplanDto.setfapprostime; // 批准停电开始时间

		// ddDoutageplanDto.setfapproetime; // 批准停电结束时间
		// ddDoutageplanDto.setfgenoutageseq; // 停发电操作顺序

		// ddDoutageplanDto.setfplanappropeople; // 中调计划批准人

		// ddDoutageplanDto.setfcanceltime; // 取消时间
		// ddDoutageplanDto.setfabolish; // 取消人

		ddDoutageplanDto
				.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_CITY_STATUS_NEW); // 状态

		ddDoutageplanDto
				.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_NEW);
		// ddDoutageplanDto.setfexcutestatus; // 执行状态

		// ddDoutageplanDto.setFmergeplanno(dto.getFmergeid()); // 合并计划编号
		// ddDoutageplanDto.setfreportdate; // 上报日期
		ddDoutageplanDto
				.setFplansourcetype(DispatchConstants.ddMoutageplan_plansourcetype_mplan); // 计划来源类型
		ddDoutageplanDto.setFplansourceno(dto.getFmonthplanno()); // 计划来源序号
		ddDoutageplanDto.setFstationid(dto.getFstationid()); // 变电站ID
		// ddDoutageplanDto.setFlinenameid(dto.getfl); // 线路名ID
		ddDoutageplanDto.setFapplyunitid(dto.getFapplyunitid()); // 申请单位ID
		// ddDoutageplanDto.setFfilltype(); // 是否调度员填写

		ddDoutageplanDto.setWorkcontent(dto.getFworkcontent()); // 工作内容
		// ddDoutageplanDto.setispassed; // 是否合格
		// ddDoutageplanDto.setfchecker; // 核查人

		// ddDoutageplanDto.setreason; // 核查不合格原因

		// ddDoutageplanDto.setfchecktime; // 核查时间
		ddDoutageplanDto.setSys_fille(dto.getSys_fille()); // 填写人

		ddDoutageplanDto.setSys_filldept(dto.getSys_filldept()); // 填写单位
		ddDoutageplanDto.setSys_filltime(dto.getSys_filltime()); // 填写时间
		ddDoutageplanDto.setSys_isvalid(dto.getSys_isvalid()); // 是否有效字段
		ddDoutageplanDto.setSys_dataowner(dto.getSys_dataowner()); // 数据所属单位

		// ddDoutageplanDto.setfplanclass; // 计划分类
		ddDoutageplanDto.setFvoltage(dto.getFvoltage()); // 电压等级
		ddDoutageplanDto.setFdayplanno(null); // 日计划编号
		// 数据所属单位

		// 手工编码
		ddDoutageplanDto.setFmanualno(BusinessDetailHelper
				.genBusinessNumber("DdMoutageplan"));

		// ddDoutageplanDto.setversion; // 数据库版本控制

		ddDoutageplanFacade.addDdDoutageplan(ddDoutageplanDto);

	}

	public void setDdDoutageplanFacade(DdDoutageplanFacade ddDoutageplanFacade) {
		this.ddDoutageplanFacade = ddDoutageplanFacade;
	}

	public void setDdRepairrisklistFacade(
			DdRepairrisklistFacade ddRepairrisklistFacade) {
		this.ddRepairrisklistFacade = ddRepairrisklistFacade;
	}

	public ActionForward toolbarOperation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
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

			QueryListObj qObj = ddMoutageplanFacade.getDdMoutageplanByHql(
					hqlSql, beginPage, pageSize, sumSql);

			dtolist = qObj.getElemList();

		}

		DdMoutageplanDto ddMoutageplan = (DdMoutageplanDto) dtolist.get(0);

		String mainId = ddMoutageplan.getFmonthplanno();

		return this.printResponseMes(request, response, mapping, "null", mainId
				+ "");

	}

	public StdDispatchunitFacade getStdDispatchFacade() {
		return stdDispatchFacade;
	}

	public void setStdDispatchFacade(StdDispatchunitFacade stdDispatchFacade) {
		this.stdDispatchFacade = stdDispatchFacade;
	}

	public ActionForward workflowHandle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserProfile userP = (UserProfile) request.getSession().getAttribute(
				"SECURITY_AUTHENTICATION");
		String userId = userP.getUserName();
		String roleId = "dd";
		String busId = request.getParameter("wf_busId");
		String taskId = request.getParameter("wf_taskId");
		String taskInstanceId = request.getParameter("wf_taskInstanceId");
		String status = request.getParameter("wf_status");
		String notices = request.getParameter("notice");
		String messages = request.getParameter("message");
		String sentPersons = request.getParameter("sentPersons");
		String isSms = request.getParameter("isSms");
		String transitionFlag = request.getParameter("transitionFlag");
		WorkflowHandleDto dto = new WorkflowHandleDto();
		dto.setBusId(busId);
		dto.setIsSms(isSms);
		dto.setMessages(messages);
		dto.setNotices(notices);
		dto.setRoleId(roleId);
		dto.setSentPersons(sentPersons);
		dto.setStatus(status);
		dto.setTaskId(taskId);
		dto.setTaskInstanceId(taskInstanceId);
		dto.setTransitionFlag(transitionFlag);
		dto.setUserId(userId);
		if (StringUtils.isNotEmpty(busId)) {
			if (status
					.equals(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_NEW)) {
				System.out.println("转审核....");
				ddMoutageplanFacade.start(dto);
				DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(busId);
				ddMoutageplanDto
						.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUp);
				ddMoutageplanDto
						.setFexcutestatus(DispatchConstants.ddMoutageplan_auditing);
				ddMoutageplanDto.setFddpremethod5(null);
				ddMoutageplanDto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
				System.out.println("转审核结束....");
			}
			if (status
					.equals(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUp)) {
				System.out.println("生技专工整理 开始....");
				ddMoutageplanFacade.ddMonthPlanCleanUp(dto);
				DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(busId);
				if (dto.getTransitionFlag().equals("1")) {
					ddMoutageplanDto
							.setFexcutestatus(DispatchConstants.ddMoutageplan_auditing);
					ddMoutageplanDto
							.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_SentResult);
				}
				ddMoutageplanDto.setFddpremethod5(null);
				ddMoutageplanDto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
				System.out.println("生技专工整理 结束....");
			}
			if (status
					.equals(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_SentResult)) {
				System.out.println("停电计划专工分发 开始....");
				ddMoutageplanFacade.ddMonthPlanSentResult(dto);
				System.out.println("停电计划专工分发 结束....");
			}
			if (status
					.equals(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_ApproveAndSend)) {
				System.out.println("生技专工任务批准分发 开始审核....");
				ddMoutageplanFacade.ddMonthPlanApproveAndSend(dto);
				DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(busId);
				if (dto.getTransitionFlag().equals("1")) {
					ddMoutageplanDto
							.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUpResult);
					ddMoutageplanDto
							.setFexcutestatus(DispatchConstants.ddMoutageplan_approveed);
				}
				if (dto.getTransitionFlag().equals("-1")) {
					ddMoutageplanDto
							.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_end);
					ddMoutageplanDto
							.setFexcutestatus(DispatchConstants.ddMoutageplan_approveed_approveed_no);
				}
				ddMoutageplanDto.setFddpremethod5(null);
				ddMoutageplanDto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
				System.out.println("生技专工任务批准分发 结束....");
			}
			if (status
					.equals(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_Modify)) {
				ddMoutageplanFacade.ddMonthPlanModify(dto);
				DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(busId);
				ddMoutageplanDto
						.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUp);
				ddMoutageplanDto
						.setFexcutestatus(DispatchConstants.ddMoutageplan_auditing);
				ddMoutageplanDto.setFddpremethod5(null);
				ddMoutageplanDto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
			}
			if (status
					.equals(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUpResult)) {
				ddMoutageplanFacade.ddMonthPlanCleanUpResult(dto);
				DdMoutageplanDto ddMoutageplanDto = ddMoutageplanFacade
						.getDdMoutageplanById(busId);
				ddMoutageplanDto
						.setFstatus(DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_end);
				ddMoutageplanDto.setFddpremethod5(null);
				ddMoutageplanDto.setFddrepairdetail1(null);
				ddMoutageplanFacade.addDdMoutageplan(ddMoutageplanDto);
			}
		}
		return mapping.findForward("");
	}

	/**
	 *
	 * 生成旬计划
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward doWPlan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fmonthplannoStr = request.getParameter("fmonthplanno");
		String primArra[] = fmonthplannoStr.split("\\^");
		request.setCharacterEncoding("utf-8");
		for (int i = 0; i < primArra.length; i++) {
			String fmonthplanno = primArra[i];
			if (StringUtils.isNotEmpty(fmonthplanno))
				creatWPlan(fmonthplanno);
		}

		return printResponseMes(request, response, mapping, "null", "生成旬计划成功");
	}

	/**
	 * 生成旬计划
	 *
	 * @param key_id
	 */
	private void creatWPlan(String key_id) {
		DdMoutageplanDto dto = ddMoutageplanFacade.getDdMoutageplanById(key_id);
		DdWoutageplanDto ddWoutageplanDto = new DdWoutageplanDto();
		ddWoutageplanDto.setFwplanno(BusinessDetailHelper
				.genBusinessNumber("DdWoutageplan"));
		ddWoutageplanDto.setFstationname(dto.getFstationname());
		ddWoutageplanDto.setFlinename(dto.getFlinename());
		ddWoutageplanDto.setFoutagearea(dto.getFoutagearea());
		ddWoutageplanDto.setFdispatchrange(dto.getFdispatchrange());
		ddWoutageplanDto.setFstarttime(dto.getFstarttime());
		ddWoutageplanDto.setFendtime(dto.getFendtime());
		ddWoutageplanDto.setFapplytime(dto.getFapplytime());
		ddWoutageplanDto.setFapplyunit(dto.getFapplyunit());
		ddWoutageplanDto.setFapplicant(dto.getFapplicant());
		ddWoutageplanDto
				.setFstatus(DispatchConstants.DdDoutageplan_WORKFLOW_CITY_STATUS_NEW);
		ddWoutageplanDto
				.setFexcutestatus(DispatchConstants.CITY_DdDoutageplan_NEW);
		ddWoutageplanDto
				.setFplansourcetype(DispatchConstants.ddMoutageplan_plansourcetype_mplan);
		ddWoutageplanDto.setFstationid(dto.getFstationid());
		ddWoutageplanDto.setFapplyunitid(dto.getFapplyunitid());
		ddWoutageplanDto.setFworkcontent(dto.getFworkcontent());
		ddWoutageplanDto.setSys_fille(dto.getSys_fille());
		ddWoutageplanDto.setSys_filldept(dto.getSys_filldept());
		ddWoutageplanDto.setSys_filltime(dto.getSys_filltime());
		ddWoutageplanDto.setSys_isvalid(dto.getSys_isvalid());
		ddWoutageplanDto.setSys_dataowner(dto.getSys_dataowner());
		ddWoutageplanDto.setFvoltage(dto.getFvoltage());
		ddWoutageplanDto.setZddwoutageplan5(dto);
		ddWoutageplanFacade.addDdWoutageplan(ddWoutageplanDto);
	}

	public void setDdWoutageplanFacade(DdWoutageplanFacade ddWoutageplanFacade) {
		this.ddWoutageplanFacade = ddWoutageplanFacade;
	}
}
