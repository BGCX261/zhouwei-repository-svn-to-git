package com.techstar.dmis.web.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
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

import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.ui.web.facade.TagEngineFacade;

import com.techstar.dmis.web.facade.DdCutoffsequenceFacade;
import com.techstar.dmis.web.facade.DdCutofftitleFacade;
import com.techstar.dmis.web.form.DdCutoffsequenceForm;
import com.techstar.dmis.web.form.DdCutofftitleForm;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdCutofftitleDto;
//please add your business methods start
// to do it
//add your business method end
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdCutoffsequenceDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdRepairrisklistDto;
import com.techstar.dmis.dto.DdfsModechangelistDto;
import com.techstar.dmis.entity.DdCutoffsequence;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

/**
 * @author
 * @date
 */
public class DdCutofftitleAction extends BaseDispatchAction {
	private DdCutofftitleFacade ddCutofftitleFacade;

	private DdCutoffsequenceFacade ddCutoffsequenceFacade;

	private SysUiGridFacade sysUiGridFacade;

	public DdCutofftitleAction() {
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
		List list = ddCutofftitleFacade.listDdCutofftitle();
		request.getSession().setAttribute("DdCutofftitleList", list);

		// 记录操作日志
		// saveLog("DdCutofftitleer", "查询列表");
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
		DdCutofftitleForm ddCutofftitleForm = (DdCutofftitleForm) form;
		DdCutofftitleDto dto = ddCutofftitleForm.getDdCutofftitleDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFid())) {
			dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号

		}
		ddCutofftitleFacade.addDdCutofftitle(dto);

		// saveLog("DdCutofftitleer", "增加记录");
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
		DdCutofftitleForm ddCutofftitleForm = (DdCutofftitleForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdCutofftitleDto dto = ddCutofftitleFacade
					.getDdCutofftitleById(fid);
			ddCutofftitleForm.setDdCutofftitleDto(dto);
		}

		// saveLog("DdCutofftitleer", "初始化记录操作");
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
			List list = ddCutofftitleFacade.deleteDdCutofftitle(fid);
			request.getSession().setAttribute("DdCutofftitleList", list);
		}

		// saveLog("DdCutofftitleer", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setDdCutofftitleFacade(DdCutofftitleFacade ddCutofftitleFacade) {
		this.ddCutofftitleFacade = ddCutofftitleFacade;
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
		 * List dtolist = new ArrayList(); DdCutofftitleFacadeDto
		 * ddCutofftitleDto = new DdCutofftitleDto();
		 * //ddCutofftitleDto.setCustom_id("custom_id");
		 * //ddCutofftitleDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddCutofftitleDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdCutofftitleDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdCutofftitle");
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
			QueryListObj queryObj = ddCutofftitleFacade.getDdCutofftitleByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddCutofftitlegrid", xmlStr);
	}

	// 初始化表格

	public ActionForward standGridQuery1(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String parentid = request.getParameter("parentid");

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hql = "from DdCutoffsequence A where A.zddcutoffsequence5.fid='"
				+ parentid + "'";
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hql)) {
			QueryListObj queryObj = ddCutoffsequenceFacade
					.listCutoffsequenceByHql(hql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping, "", xmlStr);
	}

	public ActionForward saveModechangeGrid(ActionMapping mapping,
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
				classPath += path + "\\" + "DdCutofftitleDto1.xml";
			}
			// return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdCutoffsequenceDto modechange = new DdCutoffsequenceDto();
			// modechange.setFid(new SequenceCreator().getUID());
			// DdCutofftitleDto ddto = new DdCutofftitleDto();
			// ddto.setFid(parentid);
			// modechange.setZddcutoffsequence5(ddto);
			List list = engine.getDtoList(head, dates, modechange, filePath);
			ddCutofftitleFacade.addDdCutofftitleByList(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	// 初始化toolbar
	public ActionForward ddCutofftitletoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      <id>DdCutofftitle</id>      <name>拉路序位信息</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='excel 导入' id='importExcel' href='importExcel' title=''></OperItem> <OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title=''></OperItem></Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddCutofftitletoolbar");
	}

	// 初始化tab页

	public ActionForward ddCutofftitletab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddCutofftitletab");
	}

	public ActionForward ddCutofftitleframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddCutofftitleframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdCutofftitleForm ddCutofftitleForm = (DdCutofftitleForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdCutofftitleDto ddCutofftitleDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddCutofftitleDto = ddCutofftitleFacade
						.getDdCutofftitleById(mainId);
				ddCutofftitleDto.setVersion(0);
				// ddCutofftitleDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddCutofftitleDto = ddCutofftitleFacade
						.getDdCutofftitleById(mainId);
			} else {// 新增
				ddCutofftitleDto = new DdCutofftitleDto();
			}
		}
		ddCutofftitleForm.setDdCutofftitleDto(ddCutofftitleDto);
		return mapping.findForward("ddCutofftitledetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
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

		// String dataOwnerName = bdt.getDataOwnerName();

		DdCutofftitleForm ddCutofftitleForm = (DdCutofftitleForm) form;
		DdCutofftitleDto ddCutofftitleDto = ddCutofftitleForm
				.getDdCutofftitleDto();

		if (ddCutofftitleDto.getFid() == null
				|| ddCutofftitleDto.getFid().equals("")) {
			ddCutofftitleDto
					.setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_NEW);
			ddCutofftitleDto
					.setFexcutestatus(DispatchConstants.ddCutofftitle_new);
			ddCutofftitleDto.setSys_fille(userName);
			ddCutofftitleDto.setSys_filldept(userDeptName);
			ddCutofftitleDto.setSys_filltime(currentTime);
		}

		ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);
		ddCutofftitleDto = ddCutofftitleFacade
				.getDdCutofftitleById(ddCutofftitleDto.getFid());
		ddCutofftitleForm.setDdCutofftitleDto(ddCutofftitleDto);
		saveMessages(request, "message.save.success",
				new String[] { "拉路序位信息" });
		return mapping.findForward("ddCutofftitledetail");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setDdCutoffsequenceFacade(
			DdCutoffsequenceFacade ddCutoffsequenceFacade) {
		this.ddCutoffsequenceFacade = ddCutoffsequenceFacade;
	}

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
				DdCutoffsequence ddCutoffsequence = new DdCutoffsequence();
				ddCutoffsequence.setFid(idds[i]);
				ddCutoffsequence.setVersion(Integer.parseInt(versions[i]));
				list.add(ddCutoffsequence);
			}
			ddCutoffsequenceFacade.deleteCutoffsequenceList(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 
	 * 工作流
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
					.equals(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_NEW)) {
				System.out.println("转审核....");
				ddCutofftitleFacade.start(dto);
				// DdCutofftitleDto ddCutofftitleDto = ddCutofftitleFacade
				// .getDdCutofftitleById(busId);
				// ddCutofftitleDto
				// .setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_APPROVE);
				// ddCutofftitleDto
				// .setFexcutestatus(DispatchConstants.ddCutofftitle_approve);
				// ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);
				System.out.println("转审核结束....");
			}
			if (status
					.equals(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_MODIFY)) {
				System.out.println("修改->审核....");
				ddCutofftitleFacade.modify(dto);
				DdCutofftitleDto ddCutofftitleDto = ddCutofftitleFacade
						.getDdCutofftitleById(busId);
				ddCutofftitleDto
						.setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_APPROVE);
				ddCutofftitleDto
						.setFexcutestatus(DispatchConstants.ddCutofftitle_approve);
				ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);
				System.out.println("修改->审核 结束....");
			}
			if (status
					.equals(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_APPROVE)) {

				System.out.println("开始审核....");

				ddCutofftitleFacade.headerApprove(dto);

				if (dto.getTransitionFlag().equals("-1")) {
					DdCutofftitleDto ddCutofftitleDto = ddCutofftitleFacade
							.getDdCutofftitleById(busId);
					ddCutofftitleDto
							.setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_MODIFY);
					ddCutofftitleDto
							.setFexcutestatus(DispatchConstants.ddCutofftitle_approve_NO);
					ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);

				}
				if (dto.getTransitionFlag().equals("1")) {
					DdCutofftitleDto ddCutofftitleDto = ddCutofftitleFacade
							.getDdCutofftitleById(busId);
					ddCutofftitleDto
							.setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_RELEASE);
					ddCutofftitleDto
							.setFexcutestatus(DispatchConstants.ddCutofftitle_approve_YES);
					ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);

				}
				System.out.println("审核结束....");
			}
			if (status
					.equals(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_RELEASE)) {

				System.out.println("发布....");

				ddCutofftitleFacade.release(dto);

				DdCutofftitleDto ddCutofftitleDto = ddCutofftitleFacade
						.getDdCutofftitleById(busId);
				ddCutofftitleDto
						.setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_END);
				ddCutofftitleDto
						.setFexcutestatus(DispatchConstants.ddCutofftitle_release);
				ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);
				System.out.println("发布结束....");
			}
			if (status
					.equals(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_APPROVE_FH)) {

				System.out.println("下发审核结果....");

				ddCutofftitleFacade.specApprove(dto);

				DdCutofftitleDto ddCutofftitleDto = ddCutofftitleFacade
						.getDdCutofftitleById(busId);
				ddCutofftitleDto
						.setFstatus(DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_END);
				ddCutofftitleDto
						.setFexcutestatus(DispatchConstants.ddCutofftitle_SEND_TASK);
				ddCutofftitleFacade.addDdCutofftitle(ddCutofftitleDto);
				System.out.println("下发审核结果....");
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

			QueryListObj qObj = ddCutofftitleFacade.getDdCutofftitleByHql(
					hqlSql, beginPage, pageSize, sumSql);

			dtolist = qObj.getElemList();

		}

		DdCutofftitleDto ddCutofftitleDto = (DdCutofftitleDto) dtolist
				.get(0);

		String mainId = ddCutofftitleDto.getFid();

		return this.printResponseMes(request, response, mapping, "null", mainId
				+ "");

	}

}
