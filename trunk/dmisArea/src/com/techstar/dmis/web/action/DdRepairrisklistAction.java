package com.techstar.dmis.web.action;

import java.sql.Timestamp;
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

import com.techstar.dmis.web.facade.DdMoutageplanFacade;
import com.techstar.dmis.web.facade.DdRepairrisklistFacade;
import com.techstar.dmis.web.form.DdRepairrisklistForm;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdCutofftitleDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.dto.DdRepairrisklistDto;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdRepairrisklistAction extends BaseDispatchAction {
	private DdRepairrisklistFacade ddRepairrisklistFacade;

	private DdMoutageplanFacade ddMoutageplanFacade;

	private SysUiGridFacade sysUiGridFacade;

	public DdRepairrisklistAction() {
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
		List list = ddRepairrisklistFacade.listDdRepairrisklist();
		request.getSession().setAttribute("DdRepairrisklistList", list);

		// 记录操作日志
		// saveLog("DdRepairrisklister", "查询列表");
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
		DdRepairrisklistForm ddRepairrisklistForm = (DdRepairrisklistForm) form;
		DdRepairrisklistDto dto = ddRepairrisklistForm.getDdRepairrisklistDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFid())) {
			dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号

		}
		ddRepairrisklistFacade.addDdRepairrisklist(dto);

		// saveLog("DdRepairrisklister", "增加记录");
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
		DdRepairrisklistForm ddRepairrisklistForm = (DdRepairrisklistForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdRepairrisklistDto dto = ddRepairrisklistFacade
					.getDdRepairrisklistById(fid);
			ddRepairrisklistForm.setDdRepairrisklistDto(dto);
		}

		// saveLog("DdRepairrisklister", "初始化记录操作");
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
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			List list = ddRepairrisklistFacade.deleteDdRepairrisklist(fid);
			request.getSession().setAttribute("DdRepairrisklistList", list);
		}

		// saveLog("DdRepairrisklister", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setDdRepairrisklistFacade(
			DdRepairrisklistFacade ddRepairrisklistFacade) {
		this.ddRepairrisklistFacade = ddRepairrisklistFacade;
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
		 * List dtolist = new ArrayList(); DdRepairrisklistFacadeDto
		 * ddRepairrisklistDto = new DdRepairrisklistDto();
		 * //ddRepairrisklistDto.setCustom_id("custom_id");
		 * //ddRepairrisklistDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddRepairrisklistDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdRepairrisklistDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdRepairrisklist");
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
			QueryListObj queryObj = ddRepairrisklistFacade
					.getDdRepairrisklistByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddRepairrisklistgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddRepairrisklisttoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      <id>DdRepairrisklist</id>      <name>电网风险提示</name>   </Business>   <ReportUrl>/report.do</ReportUrl>  <OperItem Text='风险预案导入' id='upload' href='upload' title=''></OperItem> <OperItem Text='根据月计划生成电网风险分析' id='newByMplan' href='newByMplan' title=''></OperItem><OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title=''></OperItem></Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddRepairrisklisttoolbar");
	}

	// 初始化tab页

	public ActionForward ddRepairrisklisttab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddRepairrisklisttab");
	}

	public ActionForward ddRepairrisklistframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddRepairrisklistframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdRepairrisklistForm ddRepairrisklistForm = (DdRepairrisklistForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdRepairrisklistDto ddRepairrisklistDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddRepairrisklistDto = ddRepairrisklistFacade
						.getDdRepairrisklistById(mainId);
				ddRepairrisklistDto.setVersion(0);
				// ddRepairrisklistDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddRepairrisklistDto = ddRepairrisklistFacade
						.getDdRepairrisklistById(mainId);
			} else {// 新增
				ddRepairrisklistDto = new DdRepairrisklistDto();
			}
		}
		ddRepairrisklistForm.setDdRepairrisklistDto(ddRepairrisklistDto);
		return mapping.findForward("ddRepairrisklistdetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdRepairrisklistForm ddRepairrisklistForm = (DdRepairrisklistForm) form;
		DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistForm
				.getDdRepairrisklistDto();
		ddRepairrisklistFacade.addDdRepairrisklist(ddRepairrisklistDto);
		ddRepairrisklistDto = ddRepairrisklistFacade
				.getDdRepairrisklistById(ddRepairrisklistDto.getFid());
		ddRepairrisklistForm.setDdRepairrisklistDto(ddRepairrisklistDto);
		saveMessages(request, "message.save.success",
				new String[] { "电网风险提示" });
		return mapping.findForward("ddRepairrisklistdetail");
	}

	// 处理DETAIL页面
	public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("ddRepairrisklistdetail1");
	}

	public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("ddRepairrisklistdetail1");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public ActionForward newByMplan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String hql = "select A from DdMoutageplan A where not exists(select A from DdRepairrisklist B where B.zddrepairrisklist4.fmonthplanno=A.fmonthplanno) and A.fexcutestatus='"
				+ DispatchConstants.ddMoutageplan_auditing + "'";
		QueryListObj queryObj = ddMoutageplanFacade.listDdMoutageplanByHql(hql);
		List list = queryObj.getElemList();
		request.getSession().setAttribute("DdMoutageplanList", list);
		//
		return mapping.findForward("newByMplan_page");
	}

	public ActionForward doNewByMplan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String para = request.getParameter("pars");
		//
		request.setCharacterEncoding("utf-8");

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
		//

		try {
			String[] keys = StringUtils.split(para, "^");

			ddRepairrisklistFacade.addDdRepairrisklistByMplans(keys,
					dataOwnerName, userDeptName, userName, currentTime);
			return this.printResponseMes(request, response, mapping, "null",
					"生成风险成功");
		} catch (Exception e) {
			return this.printResponseMes(request, response, mapping, "null",
					"生成风险失败");
		}

	}

	/**
	 * @business method list
	 * @周风险发布
	 * @风险预案导入
	 * @选择月计划
	 */
	// please add your business methods start
	// to do it
	// add your business method end
	public void setDdMoutageplanFacade(DdMoutageplanFacade ddMoutageplanFacade) {
		this.ddMoutageplanFacade = ddMoutageplanFacade;
	}

	/**
	 *
	 * 工作流
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
		// String[] nextTaskRoles = request.getParameterValues("nextTaskRoles");
		// // 流转人员安排
		// for(int i=0;i<nextTaskRoles.length;i++){
		// System.out.println(nextTaskRoles[i]);
		// }baibai
		String transitionFlag = request.getParameter("transitionFlag"); // 流转处理标记

		WorkflowHandleDto dto = new WorkflowHandleDto();
		dto.setBusId(busId);
		dto.setIsSms(isSms);
		dto.setMessages(messages);
		// dto.setNextTaskRoles(nextTaskRoles);
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
					.equals(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_NEW)) {
				System.out.println("转审核....");
				ddRepairrisklistFacade.start(dto);
				DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistFacade
						.getDdRepairrisklistById(busId);
				ddRepairrisklistDto
						.setFstatus(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_APPROVE);
				ddRepairrisklistDto
						.setFexcutestatus(DispatchConstants.PowerRiskAnalysis_STATUS_APPROVE);
				ddRepairrisklistDto.setZddrepairrisklist4(null);
				ddRepairrisklistFacade.addDdRepairrisklist(ddRepairrisklistDto);
				System.out.println("转审核结束....");
			}
			if (status
					.equals(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_MODIFY)) {
				System.out.println("修改->审核....");
				ddRepairrisklistFacade.modify(dto);
				DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistFacade
						.getDdRepairrisklistById(busId);
				ddRepairrisklistDto
						.setFstatus(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_APPROVE);
				ddRepairrisklistDto
						.setFexcutestatus(DispatchConstants.PowerRiskAnalysis_STATUS_APPROVE);
				ddRepairrisklistDto.setZddrepairrisklist4(null);
				ddRepairrisklistFacade.addDdRepairrisklist(ddRepairrisklistDto);
				System.out.println("修改->审核 结束....");
			}
			if (status
					.equals(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_APPROVE)) {

				System.out.println("开始审核....");
				ddRepairrisklistFacade.approve(dto);
				if (dto.getTransitionFlag().equals("-1")) {
					DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistFacade
							.getDdRepairrisklistById(busId);
					ddRepairrisklistDto
							.setFstatus(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_MODIFY);
					ddRepairrisklistDto
							.setFexcutestatus(DispatchConstants.PowerRiskAnalysis_STATUS_APPROVE_NO);
					ddRepairrisklistDto.setZddrepairrisklist4(null);
					ddRepairrisklistFacade
							.addDdRepairrisklist(ddRepairrisklistDto);

				}
				if (dto.getTransitionFlag().equals("1")) {
					DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistFacade
							.getDdRepairrisklistById(busId);
					ddRepairrisklistDto
							.setFstatus(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_RELEASE);
					ddRepairrisklistDto
							.setFexcutestatus(DispatchConstants.PowerRiskAnalysis_STATUS_APPROVE_YES);
					ddRepairrisklistDto.setZddrepairrisklist4(null);
					ddRepairrisklistFacade
							.addDdRepairrisklist(ddRepairrisklistDto);

				}
				System.out.println("审核结束....");
			}
			if (status
					.equals(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_RELEASE)) {

				System.out.println("发布....");
				ddRepairrisklistFacade.Release(dto);
				DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistFacade
						.getDdRepairrisklistById(busId);
				ddRepairrisklistDto
						.setFstatus(DispatchConstants.PowerRiskAnalysis_WORKFLOW_CITY_STATUS_END);
				ddRepairrisklistDto
						.setFexcutestatus(DispatchConstants.PowerRiskAnalysis_STATUS_RELEASE);
				ddRepairrisklistDto.setZddrepairrisklist4(null);
				ddRepairrisklistFacade.addDdRepairrisklist(ddRepairrisklistDto);
				System.out.println("发布结束....");
			}
		}

		return mapping.findForward("");
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

			QueryListObj qObj = ddRepairrisklistFacade.getDdRepairrisklistByHql(
					hqlSql, beginPage, pageSize, sumSql);

			dtolist = qObj.getElemList();

		}

		DdRepairrisklistDto ddRepairrisklistDto = (DdRepairrisklistDto) dtolist
				.get(0);

		String mainId = ddRepairrisklistDto.getFid();

		return this.printResponseMes(request, response, mapping, "null", mainId
				+ "");

	}




}
