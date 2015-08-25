package com.techstar.dmis.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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

import com.techstar.dmis.util.DateUtil;
import com.techstar.dmis.web.facade.ZdhEligiblermrateFacade;
import com.techstar.dmis.web.facade.ZdhWorkbillFacade;
import com.techstar.dmis.web.form.ZdhEligiblermrateForm;
import com.techstar.dmis.dto.ZdhEligiblermrateDto;
import com.techstar.dmis.entity.ZdhEligiblermrate;
import com.techstar.dmis.entity.ZdhFaultlist;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class ZdhEligiblermrateAction extends BaseDispatchAction {
	private ZdhEligiblermrateFacade zdhEligiblermrateFacade;

	private ZdhWorkbillFacade zdhWorkbillFacade;

	private SysUiGridFacade sysUiGridFacade;

	public ZdhEligiblermrateAction() {
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
		List list = zdhEligiblermrateFacade.listZdhEligiblermrate();
		request.getSession().setAttribute("ZdhEligiblermrateList", list);

		// 记录操作日志
		// saveLog("ZdhEligiblermrateer", "查询列表");
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
		ZdhEligiblermrateForm zdhEligiblermrateForm = (ZdhEligiblermrateForm) form;
		ZdhEligiblermrateDto dto = zdhEligiblermrateForm
				.getZdhEligiblermrateDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFid())) {
			dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号

		}
		zdhEligiblermrateFacade.addZdhEligiblermrate(dto);

		// saveLog("ZdhEligiblermrateer", "增加记录");
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
		ZdhEligiblermrateForm zdhEligiblermrateForm = (ZdhEligiblermrateForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			ZdhEligiblermrateDto dto = zdhEligiblermrateFacade
					.getZdhEligiblermrateById(fid);
			zdhEligiblermrateForm.setZdhEligiblermrateDto(dto);
		}

		// saveLog("ZdhEligiblermrateer", "初始化记录操作");
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
		String fidStr = request.getParameter("fid");
		String versionStr = request.getParameter("version");
		String[] primArra = fidStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String fid = primArra[i];
			int version = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(fid)) {
				zdhEligiblermrateFacade.deleteZdhEligiblermrate(fid, version);
				// request.getSession().setAttribute("ZdhEligiblermrateList",
				// list);
			}
		}

		// saveLog("ZdhEligiblermrateer", "删除记录操作");
		return this.printResponseMes(request, response, mapping, "null",
				"遥测合格率数据删除成功");
	}

	public void setZdhEligiblermrateFacade(
			ZdhEligiblermrateFacade zdhEligiblermrateFacade) {
		this.zdhEligiblermrateFacade = zdhEligiblermrateFacade;
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
			QueryListObj queryObj = zdhEligiblermrateFacade
					.getZdhEligiblermrateByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"zdhEligiblermrategrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward zdhEligiblermratetoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      <id>ZdhEligiblermrate</id>      <name>遥测合格率</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("zdhEligiblermratetoolbar");
	}

	// 初始化tab页

	public ActionForward zdhEligiblermratetab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhEligiblermratetab");
	}

	public ActionForward zdhEligiblermrateframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhEligiblermrateframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhEligiblermrateForm zdhEligiblermrateForm = (ZdhEligiblermrateForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhEligiblermrateDto zdhEligiblermrateDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhEligiblermrateDto = zdhEligiblermrateFacade
						.getZdhEligiblermrateById(mainId);
				zdhEligiblermrateDto.setVersion(0);
				zdhEligiblermrateDto.setFid(null);
				if (zdhEligiblermrateDto.getZzdheligiblermrate1() != null) {
					request.setAttribute("currno", zdhEligiblermrateDto
							.getZzdheligiblermrate1().getOndutyno());
				} else {
					request.setAttribute("currno", "");
				}
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhEligiblermrateDto = zdhEligiblermrateFacade
						.getZdhEligiblermrateById(mainId);
				if (zdhEligiblermrateDto.getZzdheligiblermrate1() != null) {
					request.setAttribute("currno", zdhEligiblermrateDto
							.getZzdheligiblermrate1().getOndutyno());
				} else {
					request.setAttribute("currno", "");
				}
			} else {//新增
				zdhEligiblermrateDto = new ZdhEligiblermrateDto();
				request.setAttribute("currno", "");
			}
		}
		if(zdhEligiblermrateDto.getReportsdate() == null){
			zdhEligiblermrateDto.setReportsdate(DateUtil.stringToSqlDate(DateUtil.getCurrentTimestamp().toString()));
		}
		
		String ondutyno = zdhWorkbillFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);

		zdhEligiblermrateForm.setZdhEligiblermrateDto(zdhEligiblermrateDto);
		return mapping.findForward("zdhEligiblermratedetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhEligiblermrateForm zdhEligiblermrateForm = (ZdhEligiblermrateForm) form;
		ZdhEligiblermrateDto zdhEligiblermrateDto = zdhEligiblermrateForm
				.getZdhEligiblermrateDto();
		if (StringUtils.isEmpty(zdhEligiblermrateDto.getZzdheligiblermrate1().getOndutyno())) {
			zdhEligiblermrateDto
					.setZzdheligiblermrate1(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
			String ondutyno = zdhWorkbillFacade.getOndutyno();
			zdhEligiblermrateDto.getZzdheligiblermrate1().setOndutyno(ondutyno);
		}
		zdhEligiblermrateFacade.addZdhEligiblermrate(zdhEligiblermrateDto);
		zdhEligiblermrateDto = zdhEligiblermrateFacade
				.getZdhEligiblermrateById(zdhEligiblermrateDto.getFid());
		String ondutyno = zdhWorkbillFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		if (zdhEligiblermrateDto.getZzdheligiblermrate1() != null) {
			request.setAttribute("currno", zdhEligiblermrateDto
					.getZzdheligiblermrate1().getOndutyno());
		} else {
			request.setAttribute("currno", "");
		}

		zdhEligiblermrateForm.setZdhEligiblermrateDto(zdhEligiblermrateDto);
		saveMessages(request, "message.save.success",
				new String[] { "遥测合格率Dto" });
		return mapping.findForward("zdhEligiblermratedetail");
	}

	/*
	 * 交接班
	 * 
	 */
	public ActionForward extInitDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhEligiblermrateForm zdhEligiblermrateForm = (ZdhEligiblermrateForm) form;
		String mainId = (String) request.getParameter("mainId");

		ZdhEligiblermrateDto zdhEligiblermrateDto = new ZdhEligiblermrateDto();

		if (StringUtils.isNotEmpty(mainId)) {// 

			QueryListObj queryObj = zdhEligiblermrateFacade
					.getZdhEligiblermrateByHql("from ZdhEligiblermrate where OndutyNo='"
							+ mainId + "'");
			Iterator it = queryObj.getElemList().iterator();
			if (it.hasNext()) {
				zdhEligiblermrateDto = (ZdhEligiblermrateDto) it.next();
			}
		}

		zdhEligiblermrateForm.setZdhEligiblermrateDto(zdhEligiblermrateDto);
		return mapping.findForward("extEligiblermratedetail");
	}
	
	public ActionForward toolbarOperation(ActionMapping mapping,
			   							  ActionForm form, 
			   							  HttpServletRequest request,
			   							  HttpServletResponse response) throws Exception {
				String hqlStr 	= "";
				
				GridInfoObj gridInfo = sysUiGridFacade.getGenGridInfo(request, hqlStr);
				String hqlSql 		 = gridInfo.getHqlSql();
				int beginPage 		 = gridInfo.getBeginPage();
				int pageSize 		 = gridInfo.getPageSize();
				String sumSql 		 = gridInfo.getSumSql();
				
				
				int count = 0;
				List dtolist = new ArrayList();
				List sumInfo = new ArrayList();
				if (!StringUtils.isEmpty(hqlSql)) {
				QueryListObj qObj = zdhEligiblermrateFacade.getZdhEligiblermrateByHql(hqlSql, beginPage, pageSize,sumSql);
				dtolist = qObj.getElemList();
				count = qObj.getCount();
				sumInfo = qObj.getPropertySum();
				}
				ZdhEligiblermrate zdhEligiblermrate = (ZdhEligiblermrate)dtolist.get(0);
				String mainId   = zdhEligiblermrate.getFid();
				
				return this.printResponseMes(request, response, mapping,
							"null", mainId+"");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setZdhWorkbillFacade(ZdhWorkbillFacade zdhWorkbillFacade) {
		this.zdhWorkbillFacade = zdhWorkbillFacade;
	}

	/**
	 * @business method list
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
