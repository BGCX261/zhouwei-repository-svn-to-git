package com.techstar.dmis.web.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.web.facade.DdEnsuringpsmanageFacade;
import com.techstar.dmis.web.form.DdEnsuringpsmanageForm;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.web.action.BaseDispatchAction;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdEnsuringpsmanageAction extends BaseDispatchAction {
	private DdEnsuringpsmanageFacade ddEnsuringpsmanageFacade;

	private SysUiGridFacade sysUiGridFacade;

	public DdEnsuringpsmanageAction() {
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
		List list = ddEnsuringpsmanageFacade.listDdEnsuringpsmanage();
		request.getSession().setAttribute("DdEnsuringpsmanageList", list);

		// 记录操作日志
		// saveLog("DdEnsuringpsmanageer", "查询列表");
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
	public ActionForward initModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdEnsuringpsmanageForm ddEnsuringpsmanageForm = (DdEnsuringpsmanageForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdEnsuringpsmanageDto dto = ddEnsuringpsmanageFacade
					.getDdEnsuringpsmanageById(fid);
			ddEnsuringpsmanageForm.setDdEnsuringpsmanageDto(dto);
		}

		// saveLog("DdEnsuringpsmanageer", "初始化记录操作");
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
		int version = Integer.parseInt(request.getParameter("version"));

		if (StringUtils.isNotEmpty(fid)) {
			List list = ddEnsuringpsmanageFacade.deleteDdEnsuringpsmanage(fid,
					version);
			request.getSession().setAttribute("DdEnsuringpsmanageList", list);
		}

		// saveLog("DdEnsuringpsmanageer", "删除记录操作");
		return this
				.printResponseMes(request, response, mapping, "null", "删除成功");
	}

	public void setDdEnsuringpsmanageFacade(
			DdEnsuringpsmanageFacade ddEnsuringpsmanageFacade) {
		this.ddEnsuringpsmanageFacade = ddEnsuringpsmanageFacade;
	}

	// 提供对大字段文件下载的方法

	public ActionForward download_fcommunication(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fid = request.getParameter("fid");
		DdEnsuringpsmanageDto dto = ddEnsuringpsmanageFacade
				.getDdEnsuringpsmanageById(fid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFcommunication());
		os.flush();
		return null;
	}

	// 提供对大字段文件下载的方法

	public ActionForward download_fmeasarule(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fid = request.getParameter("fid");
		DdEnsuringpsmanageDto dto = ddEnsuringpsmanageFacade
				.getDdEnsuringpsmanageById(fid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFmeasarule());
		os.flush();
		return null;
	}

	// 提供对大字段文件下载的方法

	public ActionForward download_fadditonal(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fid = request.getParameter("fid");
		DdEnsuringpsmanageDto dto = ddEnsuringpsmanageFacade
				.getDdEnsuringpsmanageById(fid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFadditonal());
		os.flush();
		return null;
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

		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj queryObj = ddEnsuringpsmanageFacade
					.getDdEnsuringpsmanageByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddEnsuringpsmanagegrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddEnsuringpsmanagetoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   "
				+ "<Business>      "
				+ "<id>DdEnsuringpsmanage</id>      "
				+ "<name>政治保电管理</name>   "
				+ "</Business>   "
				+ "<ReportUrl>/report.do</ReportUrl>"
				+ "<OperItem Text='工作流-启动' id='wf_start' href='wf_start' title=''></OperItem>"
				+ "<OperItem Text='工作流-流转' id='wf_goto' href='wf_goto' title=''></OperItem>"
				+ "<OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title=''></OperItem>"
				+ "</Toolbar>";
		request.setAttribute("xmlData", method);
		return mapping.findForward("ddEnsuringpsmanagetoolbar");
	}

	// 初始化tab页

	public ActionForward ddEnsuringpsmanagetab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddEnsuringpsmanagetab");
	}

	public ActionForward ddEnsuringpsmanageframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddEnsuringpsmanageframe");
	}

	// 处理DETAIL页面
	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdEnsuringpsmanageForm ddEnsuringpsmanageForm = (DdEnsuringpsmanageForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdEnsuringpsmanageDto ddEnsuringpsmanageDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddEnsuringpsmanageDto = ddEnsuringpsmanageFacade
						.getDdEnsuringpsmanageById(mainId);
				ddEnsuringpsmanageDto.setVersion(0);
				// ddEnsuringpsmanageDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddEnsuringpsmanageDto = ddEnsuringpsmanageFacade
						.getDdEnsuringpsmanageById(mainId);
			} else {// 新增
				ddEnsuringpsmanageDto = new DdEnsuringpsmanageDto();
			}
		}
		ddEnsuringpsmanageForm.setDdEnsuringpsmanageDto(ddEnsuringpsmanageDto);
		return mapping.findForward("ddEnsuringpsmanagedetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdEnsuringpsmanageForm ddEnsuringpsmanageForm = (DdEnsuringpsmanageForm) form;
		DdEnsuringpsmanageDto ddEnsuringpsmanageDto = ddEnsuringpsmanageForm
				.getDdEnsuringpsmanageDto();

		String status = ddEnsuringpsmanageDto.getFstatus();
		if (status == null
				|| "".equals(status)
				|| DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_STATUS_NEW
						.equals(status)
				|| DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_STATUS_MODIFY
						.equals(status)) {
			// 设置填报信息
			BusinessDetailDto busDetailDto = BusinessDetailHelper
					.getBusDetailInfo(request);
			ddEnsuringpsmanageDto.setSys_fille(busDetailDto.getUserName());
			ddEnsuringpsmanageDto.setSys_filldept(busDetailDto
					.getUserDeptName());
			ddEnsuringpsmanageDto
					.setSys_filltime(busDetailDto.getCurrentTime());
			ddEnsuringpsmanageDto.setSys_dataowner(busDetailDto
					.getDataOwnerName());
			// 更新业务状态

			if (status == null || "".equals(status)) {
				ddEnsuringpsmanageDto
						.setFstatus(DispatchConstants.DdEnsuringpsmanage_WORKFLOW_CITY_STATUS_NEW);
				ddEnsuringpsmanageDto
						.setFexcutestatus(DispatchConstants.DdEnsuringpsmanage_BUSINESS_CITY_NEW);
			}
		}

		ddEnsuringpsmanageFacade.addDdEnsuringpsmanage(ddEnsuringpsmanageDto);
		ddEnsuringpsmanageDto = ddEnsuringpsmanageFacade
				.getDdEnsuringpsmanageById(ddEnsuringpsmanageDto.getFid());

		ddEnsuringpsmanageForm.setDdEnsuringpsmanageDto(ddEnsuringpsmanageDto);
		saveMessages(request, "message.save.success",
				new String[] { "政治保电管理Dto" });
		return mapping.findForward("ddEnsuringpsmanagedetail");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
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

			QueryListObj qObj = ddEnsuringpsmanageFacade.getDdEnsuringpsmanageByHql(hqlSql, beginPage, pageSize,
							sumSql);

			dtolist = qObj.getElemList();

		}

		DdEnsuringpsmanageDto ddEnsuringpsmanageDto = (DdEnsuringpsmanageDto) dtolist
				.get(0);

		String mainId = ddEnsuringpsmanageDto.getFid();

		return this.printResponseMes(request, response, mapping, "null", mainId
				+ "");

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
			case 1:// 新建、修改，启动
				ddEnsuringpsmanageFacade.start(dto);
				break;
			case 2: // 进行会签
				ddEnsuringpsmanageFacade.countersign(dto);
				break;
			case 3: // 进行审批
				ddEnsuringpsmanageFacade.approve(dto);
				break;
			case 4: // 进行下发
				ddEnsuringpsmanageFacade.sent(dto);
				break;
			case 5: // 进行执行
				ddEnsuringpsmanageFacade.execute(dto);
				break;
			case 6: // 进行归档
				ddEnsuringpsmanageFacade.keepon(dto);
				break;
			}
		}

		return mapping.findForward("");
	}

	/**
	 * @business method list
	 * @盖执行章
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
