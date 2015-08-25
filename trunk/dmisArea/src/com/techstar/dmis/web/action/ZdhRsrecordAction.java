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

import com.techstar.dmis.service.impl.DdAccidentbriefServiceImpl;
import com.techstar.dmis.web.facade.ZdhRsrecordFacade;
import com.techstar.dmis.web.facade.ZdhWorkbillFacade;
import com.techstar.dmis.web.form.ZdhRsrecordForm;
import com.techstar.dmis.dto.ZdhRsrecordDto;
import com.techstar.dmis.entity.ZdhEligiblermrate;
import com.techstar.dmis.entity.ZdhRsrecord;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class ZdhRsrecordAction extends BaseDispatchAction {
	private ZdhRsrecordFacade zdhRsrecordFacade;

	private ZdhWorkbillFacade zdhWorkbillFacade;

	private SysUiGridFacade sysUiGridFacade;

	public ZdhRsrecordAction() {
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
		List list = zdhRsrecordFacade.listZdhRsrecord();
		request.getSession().setAttribute("ZdhRsrecordList", list);

		// 记录操作日志
		// saveLog("ZdhRsrecorder", "查询列表");
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
		ZdhRsrecordForm zdhRsrecordForm = (ZdhRsrecordForm) form;
		ZdhRsrecordDto dto = zdhRsrecordForm.getZdhRsrecordDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getRecordid())) {
			dto.setRecordid(new SequenceCreator().getUID()); // 生成内部序列号

		}
		zdhRsrecordFacade.addZdhRsrecord(dto);

		// saveLog("ZdhRsrecorder", "增加记录");
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
	public ActionForward initModify(ActionMapping mapping, 
									ActionForm form,
									HttpServletRequest request, 
									HttpServletResponse response)
									throws Exception {
		ZdhRsrecordForm zdhRsrecordForm = (ZdhRsrecordForm) form;
		String recordid = request.getParameter("recordid");
		if (StringUtils.isNotEmpty(recordid)) {
			ZdhRsrecordDto dto = zdhRsrecordFacade.getZdhRsrecordById(recordid);
			zdhRsrecordForm.setZdhRsrecordDto(dto);
		}

		// saveLog("ZdhRsrecorder", "初始化记录操作");
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
		String recordidStr = request.getParameter("recordid");
		String versionStr = request.getParameter("version");
		String[] primArra = recordidStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String recordid = primArra[i];
			int version = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(recordid)) {
				zdhRsrecordFacade.deleteZdhRsrecordObj(recordid, version);
				// request.getSession().setAttribute("ZdhRsrecordList", list);
			}
		}

		// saveLog("ZdhRsrecorder", "删除记录操作");
		return this.printResponseMes(request, response, mapping, "null",
				"遥信记录删除成功");
	}

	public void setZdhRsrecordFacade(ZdhRsrecordFacade zdhRsrecordFacade) {
		this.zdhRsrecordFacade = zdhRsrecordFacade;
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
			QueryListObj queryObj = zdhRsrecordFacade.getCurrAccidentbrieByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"zdhRsrecordgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward zdhRsrecordtoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   "
				+ "<Business>      "
				+ "<id>ZdhRsrecord</id>      "
				+ "<name>遥信记录</name>   "
				+ "</Business>   "
				+ "<ReportUrl>/report.do</ReportUrl>   "
				+ "<OperItem Text='当日故障查洵' id='selectAccidnt' href='selectAccidnt' title=''></OperItem>"
				+ "</Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("zdhRsrecordtoolbar");
	}

	// 初始化tab页

	public ActionForward zdhRsrecordtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhRsrecordtab");
	}

	public ActionForward zdhRsrecordframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhRsrecordframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ZdhRsrecordForm zdhRsrecordForm = (ZdhRsrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhRsrecordDto zdhRsrecordDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhRsrecordDto = zdhRsrecordFacade.getZdhRsrecordById(mainId);
				zdhRsrecordDto.setVersion(0);
				// zdhRsrecordDto.setId(null);
				if (zdhRsrecordDto.getZzdhrsrecord2() != null) {
					request.setAttribute("currno", zdhRsrecordDto
							.getZzdhrsrecord2().getOndutyno());
				} else {
					request.setAttribute("currno", "");
				}
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhRsrecordDto = zdhRsrecordFacade.getZdhRsrecordById(mainId);
				if (zdhRsrecordDto.getZzdhrsrecord2() != null) {
					request.setAttribute("currno", zdhRsrecordDto
							.getZzdhrsrecord2().getOndutyno());
				} else {
					request.setAttribute("currno", "");
				}
				request.setAttribute("currno", "");
			} else {// 新增
				zdhRsrecordDto = new ZdhRsrecordDto();
				request.setAttribute("currno", "");
			}
		}
		String ondutyno = zdhWorkbillFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		zdhRsrecordForm.setZdhRsrecordDto(zdhRsrecordDto);
		return mapping.findForward("zdhRsrecorddetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhRsrecordForm zdhRsrecordForm = (ZdhRsrecordForm) form;
		ZdhRsrecordDto zdhRsrecordDto = zdhRsrecordForm.getZdhRsrecordDto();
		String ondutyno = zdhWorkbillFacade.getOndutyno();
		if(zdhRsrecordDto.getZzdhrsrecord2() == null){
			zdhRsrecordDto.setZzdhrsrecord2(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
			zdhRsrecordDto.getZzdhrsrecord2().setOndutyno(ondutyno);
		} else {
			if(StringUtils.isEmpty(zdhRsrecordDto.getZzdhrsrecord2().getOndutyno())){
				zdhRsrecordDto.getZzdhrsrecord2().setOndutyno(ondutyno);
			}
		}
		zdhRsrecordFacade.addZdhRsrecord(zdhRsrecordDto);
		zdhRsrecordDto = zdhRsrecordFacade.getZdhRsrecordById(zdhRsrecordDto
				.getRecordid());
		request.setAttribute("ondutyno", ondutyno);
		if(zdhRsrecordDto.getZzdhrsrecord2() == null){
			request.setAttribute("currno", "");
		} else {
			request.setAttribute("currno", zdhRsrecordDto.getZzdhrsrecord2().getOndutyno());
		}
		
		zdhRsrecordForm.setZdhRsrecordDto(zdhRsrecordDto);
		saveMessages(request, "message.save.success",
				new String[] { "遥信记录Dto" });
		return mapping.findForward("zdhRsrecorddetail");
	}

	/*
	 * 初始化交接班列表
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
			QueryListObj queryObj = zdhRsrecordFacade.getCurrAccidentbrieByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"extZdhRsrecordgrid", xmlStr);
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
			QueryListObj qObj = zdhRsrecordFacade.getZdhRsrecordByHql(hqlSql, beginPage, pageSize,sumSql);
			dtolist = qObj.getElemList();
			count 	= qObj.getCount();
			sumInfo = qObj.getPropertySum();
		}
		ZdhRsrecord zdhRsrecord = (ZdhRsrecord) dtolist.get(0);
		String mainId = zdhRsrecord.getRecordid();

		return this.printResponseMes(request, response, mapping, "null", mainId+"");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setZdhWorkbillFacade(ZdhWorkbillFacade zdhWorkbillFacade) {
		this.zdhWorkbillFacade = zdhWorkbillFacade;
	}

	/**
	 * @business method list
	 * @当日故障查洵
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
