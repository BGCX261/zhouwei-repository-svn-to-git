package com.techstar.dmis.web.action;

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
import com.techstar.framework.utils.SequenceCreator;

import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;

import com.techstar.dmis.web.facade.ZdhFaultlistFacade;
import com.techstar.dmis.web.form.ZdhFaultlistForm;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dto.ZdhFaultlistDto;
import com.techstar.dmis.entity.ZdhCharalterrecord;
import com.techstar.dmis.entity.ZdhFaultlist;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class ZdhFaultlistAction extends BaseDispatchAction {
	private ZdhFaultlistFacade zdhFaultlistFacade;

	private SysUiGridFacade sysUiGridFacade;

	public ZdhFaultlistAction() {
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
		List list = zdhFaultlistFacade.listZdhFaultlist();
		request.getSession().setAttribute("ZdhFaultlistList", list);

		// 记录操作日志
		// saveLog("ZdhFaultlister", "查询列表");
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
		ZdhFaultlistForm zdhFaultlistForm = (ZdhFaultlistForm) form;
		ZdhFaultlistDto dto = zdhFaultlistForm.getZdhFaultlistDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFfaultno())) {
			dto.setFfaultno(new SequenceCreator().getUID()); // 生成内部序列号
		}
		zdhFaultlistFacade.addZdhFaultlist(dto);

		// saveLog("ZdhFaultlister", "增加记录");
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
		ZdhFaultlistForm zdhFaultlistForm = (ZdhFaultlistForm) form;
		String ffaultno = request.getParameter("ffaultno");
		if (StringUtils.isNotEmpty(ffaultno)) {
			ZdhFaultlistDto dto = zdhFaultlistFacade
					.getZdhFaultlistById(ffaultno);
			zdhFaultlistForm.setZdhFaultlistDto(dto);
		}

		// saveLog("ZdhFaultlister", "初始化记录操作");
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
		String ffaultnoStr = request.getParameter("ffaultno");
		String versionStr = request.getParameter("version");
		String[] primArra = ffaultnoStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String ffaultno = primArra[i];
			int version = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(ffaultno)) {
				List list = zdhFaultlistFacade.deleteZdhFaultlistObj(ffaultno,
						version);
				request.getSession().setAttribute("ZdhFaultlistList", list);
			}
		}
		// saveLog("ZdhFaultlister", "删除记录操作");
		return this
				.printResponseMes(request, response, mapping, "null", "删除成功");
	}

	public void setZdhFaultlistFacade(ZdhFaultlistFacade zdhFaultlistFacade) {
		this.zdhFaultlistFacade = zdhFaultlistFacade;
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
		 * List dtolist = new ArrayList(); ZdhFaultlistFacadeDto zdhFaultlistDto =
		 * new ZdhFaultlistDto(); //zdhFaultlistDto.setCustom_id("custom_id");
		 * //zdhFaultlistDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(zdhFaultlistDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("ZdhFaultlistDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("ZdhFaultlist");
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
			QueryListObj queryObj = zdhFaultlistFacade.getZdhFaultlistByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"zdhFaultlistgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward zdhFaultlisttoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   "
				+ "			<Business>      "
				+ "				<id>ZdhFaultlist</id>       "
				+ "				<name>自动化设备缺陷</name>   "
				+ "			</Business>   "
				+ "			<ReportUrl>/report.do</ReportUrl>   "
				+ "			<OperItem Text='缺陷送检' id='sendCheck' href='sendCheck' title=''></OperItem>"
				+ "			<OperItem Text='缺陷归档' id='pigeonhole' href='pigeonhole' title=''></OperItem>"
				+ "		  </Toolbar>";
		// " <OperItem Text='检修缺陷' id='operation1' href='operation1'
		// title=''></OperItem>" +
		// " <OperItem Text='缺陷恢复' id='operation2' href='operation2'
		// title=''></OperItem>" +
		request.setAttribute("xmlData", method);
		return mapping.findForward("zdhFaultlisttoolbar");
	}

	// 初始化tab页

	public ActionForward zdhFaultlisttab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhFaultlisttab");
	}

	public ActionForward zdhFaultlistframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhFaultlistframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhFaultlistForm zdhFaultlistForm = (ZdhFaultlistForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhFaultlistDto zdhFaultlistDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhFaultlistDto = zdhFaultlistFacade
						.getZdhFaultlistById(mainId);
				zdhFaultlistDto.setFfaultno(null);
				zdhFaultlistDto.setVersion(0);
				// zdhFaultlistDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhFaultlistDto = zdhFaultlistFacade
						.getZdhFaultlistById(mainId);
			} else {// 新增
				zdhFaultlistDto = new ZdhFaultlistDto();
			}
		}
		zdhFaultlistForm.setZdhFaultlistDto(zdhFaultlistDto);
		// 判断是否已归档操作

		if (!StringUtils.isEmpty(zdhFaultlistDto.getFstatus())
				&& zdhFaultlistDto.getFstatus().equalsIgnoreCase(
						ZdhConstants.ZDH_PIGEONHOLED)) {
			request.setAttribute("status", "true");
		} else {
			request.setAttribute("status", "false");
		}
		// 判断第一个组是否只读
		if (zdhFaultlistDto.getFstatus() != null) {
			request.setAttribute("fstatus", zdhFaultlistDto.getFstatus());
		} else {
			request.setAttribute("fstatus", "");
		}

		return mapping.findForward("zdhFaultlistdetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhFaultlistForm zdhFaultlistForm = (ZdhFaultlistForm) form;
		ZdhFaultlistDto zdhFaultlistDto = zdhFaultlistForm.getZdhFaultlistDto();

		System.out.println("###########" + zdhFaultlistDto.getRfilltime());
		// 新建缺陷
		if (StringUtils.isEmpty(zdhFaultlistDto.getFfaultno())) {
			zdhFaultlistDto.setFstatus(this.getStatus("new"));
		} else if (!StringUtils.isEmpty(zdhFaultlistDto.getFrepairunit())
				&& (zdhFaultlistDto.getRfilltime() == null)) {
			zdhFaultlistDto.setFstatus(this.getStatus("checked"));
		} else if (zdhFaultlistDto.getRfilltime() != null) {
			zdhFaultlistDto.setFstatus(this.getStatus("resumed"));
		}
		if (StringUtils.isEmpty(zdhFaultlistDto.getFstatus())) {
			zdhFaultlistDto.setFstatus(this.getStatus("new"));
		}
		zdhFaultlistFacade.addZdhFaultlist(zdhFaultlistDto);
		zdhFaultlistDto = zdhFaultlistFacade
				.getZdhFaultlistById(zdhFaultlistDto.getFfaultno());
		zdhFaultlistForm.setZdhFaultlistDto(zdhFaultlistDto);
		if (!StringUtils.isEmpty(zdhFaultlistDto.getFstatus())
				&& zdhFaultlistDto.getFstatus().equalsIgnoreCase(
						ZdhConstants.ZDH_PIGEONHOLED)) {
			request.setAttribute("status", "true");
		} else {
			request.setAttribute("status", "false");
		}
		// 判断第一个组是否只读
		if (zdhFaultlistDto.getFstatus() != null) {
			request.setAttribute("fstatus", zdhFaultlistDto.getFstatus());
		} else {
			request.setAttribute("fstatus", "");
		}
		request.setAttribute("fstatus", zdhFaultlistDto.getFstatus());
		saveMessages(request, "message.save.success",
				new String[] { "自动化设备缺陷Dto" });
		return mapping.findForward("zdhFaultlistdetail");
	}

	// 处理DETAIL页面
	public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhFaultlistdetail1");
	}

	public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("zdhFaultlistdetail1");
	}

	/**
	 * 转换业务状态
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward changeStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String status = request.getParameter("status");
		String mainId = request.getParameter("mainId");
		String sendPerson = request.getParameter("sendPerson");
		String sendMessage = request.getParameter("sendMessage");
		String sendMobile = request.getParameter("sendMobile");

		ZdhFaultlistDto zdhFaultlistDto = null;
		if (!StringUtils.isEmpty(mainId)) {
			if (!status.equalsIgnoreCase("pigeonholed")) {
				zdhFaultlistDto = zdhFaultlistFacade
						.getZdhFaultlistById(mainId);
			}
		}

		String message = "操作失败";
		if (!StringUtils.isEmpty(status)) {
			// if(!StringUtils.isEmpty(zdhFaultlistDto.getFstatus())){
			int sign = 0;
			if (status.equalsIgnoreCase("check")) { // 送检修

				if (zdhFaultlistDto.getFstatus().equalsIgnoreCase(
						this.getStatus("new"))) {
					sign = 1;
					message = "数据送检完成";
					zdhFaultlistDto.setFstatus(this.getStatus("check"));
					// /////////提交待办事项接口
				} else {
					message = "数据送检完成";
				}
			} else if (status.equalsIgnoreCase("checked")) {
				sign = 1;
				zdhFaultlistDto.setFstatus(this.getStatus("checked"));
			} else if (status.equalsIgnoreCase("resumed")) {
				sign = 1;
				zdhFaultlistDto.setFstatus(this.getStatus("resumed"));
			} else if (status.equalsIgnoreCase("pigeonholed")) { // 归档
				message = "数据归档完成";
				if (!StringUtils.isEmpty(mainId)) {
					String[] mainArra = mainId.split("\\^");
					for (int x = 0; x < mainArra.length; x++) {
						if (!StringUtils.isEmpty(mainArra[x])) {
							zdhFaultlistDto = zdhFaultlistFacade
									.getZdhFaultlistById(mainArra[x]);
							if (!StringUtils.isEmpty(zdhFaultlistDto
									.getFrepairunit())
									&& zdhFaultlistDto.getRfilltime() != null) {
								zdhFaultlistDto.setFstatus(this
										.getStatus("pigeonholed"));
								zdhFaultlistFacade
										.addZdhFaultlist(zdhFaultlistDto);
							} else {
								message = "数据归档失败,资料添写不全";
							}
						} else {
							message = "数据归档失败";
						}
					}
				} else {
					message = "数据归档失败,主键为空";
				}
			}
			if (sign == 1) {
				zdhFaultlistFacade.addZdhFaultlist(zdhFaultlistDto);
			}
			// }
		}

		saveMessages(request, "message.save.success",
				new String[] { "自动化设备缺陷Dto" });
		return this.printResponseMes(request, response, mapping, "null",
				message);
	}

	/**
	 * 得到缺陷业务对象对应状态
	 * 
	 * @param str
	 * @return
	 */
	public String getStatus(String str) {
		String status = "";
		if (!StringUtils.isEmpty(str)) {
			if (str.equalsIgnoreCase("new")) {
				status = ZdhConstants.ZDH_DRAFT;
			} else if (str.equalsIgnoreCase("check")) {
				status = ZdhConstants.ZDH_CHECK;
			} else if (str.equalsIgnoreCase("checked")) {
				status = ZdhConstants.ZDH_CHECKED;
			} else if (str.equalsIgnoreCase("resumed")) {
				status = ZdhConstants.ZDH_RESUMED;
			} else if (str.equalsIgnoreCase("pigeonholed")) {
				status = ZdhConstants.ZDH_PIGEONHOLED;
			} else {
				status = ZdhConstants.ZDH_DRAFT;
			}
		}
		return status;
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	/*
	 * 交接班使用
	 * 
	 */
	public ActionForward extStandGridQuery(ActionMapping mapping,
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

		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj queryObj = zdhFaultlistFacade.getZdhFaultlistByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"extZdhFaultlistgrid", xmlStr);
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
			QueryListObj qObj = zdhFaultlistFacade.getZdhFaultlistByHql(hqlSql,
					beginPage, pageSize, sumSql);
			dtolist = qObj.getElemList();
			count = qObj.getCount();
			sumInfo = qObj.getPropertySum();
		}
		ZdhFaultlist zdhFaultlist = (ZdhFaultlist) dtolist.get(0);

		return this.printResponseMes(request, response, mapping, "null",
				zdhFaultlist.getFfaultno() + "");
	}

	/*
	 * 
	 * 从传动记录显示详细
	 * 
	 */

	public ActionForward showFaultlistdetail(ActionMapping mapping,
											 ActionForm form,
											 HttpServletRequest request, 
											 HttpServletResponse response)
											 throws Exception {
		ZdhFaultlistForm zdhFaultlistForm = (ZdhFaultlistForm) form;
		String mainId = "";
		mainId = (String) request.getParameter("mainId");
		ZdhFaultlistDto zdhFaultlistDto = null;
		zdhFaultlistDto = zdhFaultlistFacade.getZdhFaultlistById(mainId);
		zdhFaultlistForm.setZdhFaultlistDto(zdhFaultlistDto);
		return mapping.findForward("zdhMachineworkshowFaultlistdetail");
	}

	/**
	 * @business method list
	 * @缺陷设备信息
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
