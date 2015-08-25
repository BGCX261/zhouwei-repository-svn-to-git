package com.techstar.dmis.web.action;

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

import com.techstar.dmis.web.facade.DdAccidentbriefFacade;
import com.techstar.dmis.web.facade.DdSwitchseqbillFacade;
import com.techstar.dmis.web.form.DdSwitchseqbillForm;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.dto.DdSeqbilldetailDto;
import com.techstar.dmis.dto.DdSwitchseqbillDto;
import com.techstar.dmis.dto.DdfsModechangelistDto;
//please add your business methods start
// to do it
//add your business method end
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.util.DateUtil;

/**
 * @author
 * @date
 */
public class DdSwitchseqbillAction extends BaseDispatchAction {
	private DdSwitchseqbillFacade ddSwitchseqbillFacade;

	private DdAccidentbriefFacade ddAccidentbriefFacade;// 周玮 故障简报

	private SysUiGridFacade sysUiGridFacade;

	public DdSwitchseqbillAction() {
	}

	/**
	 * 初始化
	 * 
	 * @param request
	 * @param dto
	 */
	public void iniDefaultValue(HttpServletRequest request,
			DdSwitchseqbillDto dto) {

		long nCurrentTime = System.currentTimeMillis();
		//java.sql.Timestamp fCurTime = new java.sql.Timestamp(nCurrentTime);
		BusinessDetailHelper ss = new BusinessDetailHelper();
		BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
		dto.setSys_filldept(defaultdto.getUserDeptName());
		dto.setSys_filltime(DateUtil.getCurrentTimestamp());
		dto.setSys_dataowner(defaultdto.getDataOwnerName());
		dto.setSys_fille(defaultdto.getUserName());
		// 操作日期
		java.sql.Date curdate = new java.sql.Date(nCurrentTime);

		dto.setFdate(curdate);

		// 默认状态

		dto.setFexcutestatus(DispatchConstants.ddSwitchSeqbill_NEW);
		dto.setFstatus(DispatchConstants.DdSwitchseqBill_WORKFLOW_CITY_STATUS_NEW);
		// 执行编号
		dto.setFmanualno(ddSwitchseqbillFacade.getMaxfmanualno());

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
		List list = ddSwitchseqbillFacade.listDdSwitchseqbill();
		request.getSession().setAttribute("DdSwitchseqbillList", list);

		// 记录操作日志
		// saveLog("DdSwitchseqbiller", "查询列表");
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
		DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
		DdSwitchseqbillDto dto = ddSwitchseqbillForm.getDdSwitchseqbillDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFcomputerno())) {
			dto.setFcomputerno(new SequenceCreator().getUID()); // 生成内部序列号

			iniDefaultValue(request, dto);

		}
		ddSwitchseqbillFacade.addDdSwitchseqbill(dto);

		// saveLog("DdSwitchseqbiller", "增加记录");
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
		DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
		String fcomputerno = request.getParameter("fcomputerno");
		if (StringUtils.isNotEmpty(fcomputerno)) {
			DdSwitchseqbillDto dto = ddSwitchseqbillFacade
					.getDdSwitchseqbillById(fcomputerno);
			ddSwitchseqbillForm.setDdSwitchseqbillDto(dto);
		}

		// saveLog("DdSwitchseqbiller", "初始化记录操作");
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
		String fcomputernoStr = request.getParameter("fcomputerno");
		String versionStr = request.getParameter("version");
		String[] primArra = fcomputernoStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String fcomputerno = primArra[i];
			int version = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(fcomputerno)) {
				List list = ddSwitchseqbillFacade.deleteDdSwitchseqbill(
						fcomputerno, version);
				request.getSession().setAttribute("DdSwitchseqbillList", list);
			}
		}

		return this
				.printResponseMes(request, response, mapping, "null", "删除成功");

	}

	public void setDdSwitchseqbillFacade(
			DdSwitchseqbillFacade ddSwitchseqbillFacade) {
		this.ddSwitchseqbillFacade = ddSwitchseqbillFacade;
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
		 * List dtolist = new ArrayList(); DdSwitchseqbillFacadeDto
		 * ddSwitchseqbillDto = new DdSwitchseqbillDto();
		 * //ddSwitchseqbillDto.setCustom_id("custom_id");
		 * //ddSwitchseqbillDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddSwitchseqbillDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdSwitchseqbillDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdSwitchseqbill");
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
			QueryListObj queryObj = ddSwitchseqbillFacade
					.getDdSwitchseqbillByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddSwitchseqbillgrid", xmlStr);
	}

	// 初始化表格

	public ActionForward standGridQuery1(ActionMapping mapping,
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

		/*
		 * List dtolist = new ArrayList(); DdSwitchseqbillFacadeDto
		 * ddSwitchseqbillDto = new DdSwitchseqbillDto();
		 * //ddSwitchseqbillDto.setCustom_id("custom_id");
		 * //ddSwitchseqbillDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddSwitchseqbillDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdSwitchseqbillDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdSwitchseqbill");
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
			QueryListObj queryObj = ddSwitchseqbillFacade
					.getDdSwitchseqbillByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddSwitchseqbillgrid1", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddSwitchseqbilltoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      "
				+ "<id>DdSwitchseqbill</id>      "
				+ "<name>调度操作票</name>  "
				+ " </Business>  "
				+ " <ReportUrl>/report.do</ReportUrl> "
				+ "  <OperItem Text='合格情况核定' id='DDPASSedCheck' href='DDPASSedCheck' title=''></OperItem> "
				+ "  <OperItem Text='盖执行章' id='DDexcuteseal' href='DDexcuteseal' title=''></OperItem>  "
				+ "  <OperItem Text='盖作废章' id='DDCancelbill' href='DDCancelbill' title=''></OperItem>  "
				+ " <OperItem Text='操作票终止' id='DDstopswitchseqbill' href='DDstopswitchseqbill' title=''></OperItem>"
				+ " <OperItem Text='转为典型票' id='TransTypicalbill' href='TransTypicalbill' title=''></OperItem>"
				+ " <OperItem Text='从典型票生成操作票' id='CreateSwitchbill' href='CreateSwitchbill' title=''></OperItem>"
				+ " <OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title=''></OperItem>"
				+ "</Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddSwitchseqbilltoolbar");
	}

	// 初始化tab页

	public ActionForward ddSwitchseqbilltab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddSwitchseqbilltab");
	}

	public ActionForward ddSwitchseqbillframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddSwitchseqbillframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdSwitchseqbillDto ddSwitchseqbillDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddSwitchseqbillDto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(mainId);
				ddSwitchseqbillDto.setVersion(0);
				ddSwitchseqbillDto.setFcomputerno(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddSwitchseqbillDto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(mainId);
			} else {// 新增
				ddSwitchseqbillDto = new DdSwitchseqbillDto();
				iniDefaultValue(request, ddSwitchseqbillDto);
			}
		}
		ddSwitchseqbillForm.setDdSwitchseqbillDto(ddSwitchseqbillDto);
		return mapping.findForward("ddSwitchseqbilldetail");
	}

	// 处理DETAIL操作票执行页面

	public ActionForward initDetailexe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdSwitchseqbillDto ddSwitchseqbillDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddSwitchseqbillDto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(mainId);
				ddSwitchseqbillDto.setVersion(0);
				ddSwitchseqbillDto.setFcomputerno(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddSwitchseqbillDto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(mainId);
			} else {// 新增
				ddSwitchseqbillDto = new DdSwitchseqbillDto();
				iniDefaultValue(request, ddSwitchseqbillDto);
			}
		}
		ddSwitchseqbillForm.setDdSwitchseqbillDto(ddSwitchseqbillDto);
		return mapping.findForward("ddSwitchseqbilldetail3");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
		DdSwitchseqbillDto ddSwitchseqbillDto = ddSwitchseqbillForm
				.getDdSwitchseqbillDto();
		ddSwitchseqbillFacade.addDdSwitchseqbill(ddSwitchseqbillDto);
		ddSwitchseqbillDto = ddSwitchseqbillFacade
				.getDdSwitchseqbillById(ddSwitchseqbillDto.getFcomputerno());
		ddSwitchseqbillForm.setDdSwitchseqbillDto(ddSwitchseqbillDto);
		saveMessages(request, "message.save.success",
				new String[] { "调度操作票" });
		return mapping.findForward("ddSwitchseqbilldetail");
	}

	// 处理DETAIL页面
	public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("ddSwitchseqbilldetail1");
	}

	public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("ddSwitchseqbilldetail1");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	/**
	 * 操作步骤查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward SeqBillDetailGridQuery(ActionMapping mapping,
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
		String hql = "select d from DdSeqbilldetail d "
				+ "where d.zddseqbilldetail1.fcomputerno='" + parentid + "'"
				+ " order by d.fserialno asc";
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		QueryListObj queryObj = ddSwitchseqbillFacade
				.listDdSeqbilldetailByHql(hql);
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
	 * 保存操作步骤
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveSeqbilldetailGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			String parentid = request.getParameter("parentid");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath = "";
			if (files.length > 0) {
				String path = files[0].getParent();
				classPath += path + "\\" + "DdSwitchseqbillDto1" + ".xml";
			}
			// return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdSeqbilldetailDto detaildto = new DdSeqbilldetailDto();
			DdSeqbilldetailDto detaildto1 = new DdSeqbilldetailDto();
			DdSwitchseqbillDto ddto = new DdSwitchseqbillDto();

			ddto.setFcomputerno(parentid);
			detaildto.setZddseqbilldetail1(ddto);
			List list = engine.getDtoList(head, dates, detaildto, filePath);
			List listnew = new ArrayList();
			BusinessDetailHelper ss = new BusinessDetailHelper();
			BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
			
			for (int i = 0; i < list.size(); i++) {
				detaildto1 = (DdSeqbilldetailDto) list.get(i);
				detaildto1.setFserialno(i + 1);
				
				detaildto1.setSys_filldept(defaultdto.getUserDeptName());
				detaildto1.setSys_filltime(DateUtil.getCurrentTimestamp());
				detaildto1.setSys_dataowner(defaultdto.getDataOwnerName());
				detaildto1.setSys_fille(defaultdto.getUserName());
				listnew.add(detaildto1);
			}

			ddSwitchseqbillFacade.saveOrUpdateDdSeqbilldetail(listnew);

			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;

	}

	/**
	 * 保存执行操作步骤
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveSeqbilldetailGridexe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			String parentid = request.getParameter("parentid");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath = "";
			if (files.length > 0) {
				String path = files[0].getParent();
				classPath += path + "\\" + "DdSwitchseqbillDto1" + ".xml";
			}
			// return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdSeqbilldetailDto detaildto = new DdSeqbilldetailDto();
			DdSeqbilldetailDto detaildto1 = new DdSeqbilldetailDto();
			DdSwitchseqbillDto ddto = new DdSwitchseqbillDto();

			ddto.setFcomputerno(parentid);
			detaildto.setZddseqbilldetail1(ddto);
			List list = engine.getDtoList(head, dates, detaildto, filePath);

			ddSwitchseqbillFacade.saveOrUpdateDdSeqbilldetail(list);

			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;

	}

	/**
	 * 删除操作步骤
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteSeqbilldetailGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("ids");
			String version = request.getParameter("version");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(ids);
			String[] idds = ids.split(";");
			String[] versions = version.split(";");
			int fserialno = 0;
			String fcomputerno = "";
			// ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdSeqbilldetailDto dto = new DdSeqbilldetailDto();
				dto.setFoperationstepno(idds[i]);
				dto.setVersion(Integer.parseInt(versions[i]));
				DdSeqbilldetailDto dto1 = ddSwitchseqbillFacade
						.loadDdSeqbilldetail(idds[i]);
				fcomputerno = dto1.getZddseqbilldetail1().getFcomputerno();
				fserialno = dto1.getFserialno();
				dto.setZddseqbilldetail1(null);
				// dto.setZddfsmodechangelist5(null);
				ddSwitchseqbillFacade.deleteDdSeqbilldetail(dto);
				// list.add(dto);
			}

			ddSwitchseqbillFacade
					.setSerialnoafterdelete(fcomputerno, fserialno);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * 合格情况核定保存
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward SaveSeqbillCheck(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("fcomputerno");
			String[] idds = ids.split("^");

			DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
			DdSwitchseqbillDto ddSwitchseqbillDto = ddSwitchseqbillForm
					.getDdSwitchseqbillDto();

			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdSwitchseqbillDto dto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(idds[i]);
				dto.setIspassed(ddSwitchseqbillDto.getIspassed());
				dto.setPasschecktime(ddSwitchseqbillDto.getPasschecktime());
				dto.setReason(ddSwitchseqbillDto.getReason());
				dto.setPassedchecker(ddSwitchseqbillDto.getPassedchecker());
				dto.setFddseqbilldetail1(null);

				list.add(dto);
			}
			ddSwitchseqbillFacade.saveOrUpdateDdSwitchseqbill(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return mapping.findForward("ddSwitchseqbillgrid");
	}

	/**
	 * 盖执行章,将操作步骤状态为空的记录改为已执行，不包括空行，计算步骤数，主表的状态为已执行
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward DDexcuteseal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			String ids = request.getParameter("fcomputerno");
			String[] idds = ids.split("^");

			DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
			DdSwitchseqbillDto ddSwitchseqbillDto = ddSwitchseqbillForm
					.getDdSwitchseqbillDto();

			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				//执行状态
				ddSwitchseqbillFacade.setexecutestatus(ids);
				ddSwitchseqbillFacade.setswitchbillexestutas(ids);
				//操作步骤数
				ddSwitchseqbillFacade.getSwitchbillsteps(ids);
			}
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}
	/**
	 * 作废
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward DDCancelbill(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {

			String ids = request.getParameter("fcomputerno");
			String[] idds = ids.split("^");

			DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
			DdSwitchseqbillDto ddSwitchseqbillDto = ddSwitchseqbillForm
					.getDdSwitchseqbillDto();

			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
//				作废状态
				ddSwitchseqbillFacade.setcancelstatus(ids);
				
//				操作步骤数
				//ddSwitchseqbillFacade.getSwitchbillsteps(ids);
			}
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}
		return null;
	}
	

	/**
	 * 操作票终止，将操作步骤没有执行的改为终止，操作票的状态为已执行
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward DDstopswitchseqbill(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("fcomputerno");
			String[] idds = ids.split("^");

			DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
			DdSwitchseqbillDto ddSwitchseqbillDto = ddSwitchseqbillForm
					.getDdSwitchseqbillDto();

			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdSwitchseqbillDto dto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(idds[i]);
				dto.setFstopreason(ddSwitchseqbillDto.getFstopreason());

				dto.setFddseqbilldetail1(null);

				list.add(dto);
				// 终止
				ddSwitchseqbillFacade.setStopStatus(idds[i]);
				ddSwitchseqbillFacade.setswitchbillstopstatus(idds[i]);
				
				//操作步骤数
				ddSwitchseqbillFacade.getSwitchbillsteps(idds[i]);
			}
			ddSwitchseqbillFacade.saveOrUpdateDdSwitchseqbill(list);
			
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}
		return null;
	}
	
	/**
	 * 从典型票生成操作票
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward CreateSwitchbill(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String newmainId = new SequenceCreator().getUID();
		DdSwitchseqbillDto ddSwitchseqbillDto = null;
		DdSwitchseqbillDto dto = new DdSwitchseqbillDto();
		if (StringUtils.isNotEmpty(mainId)) {
			ddSwitchseqbillDto = ddSwitchseqbillFacade
					.getDdSwitchseqbillById(mainId);
			dto.setVersion(0);
			//ddSwitchseqbillDto.setVersion(0);
			dto.setFcomputerno(newmainId);
			dto.setFbillsource(ddSwitchseqbillDto.getFbillsource());
			dto.setFdate(ddSwitchseqbillDto.getFdate());
			dto.setFddseqbilldetail1(null);
			dto.setFeqpid(ddSwitchseqbillDto.getFeqpid());
			dto.setFexcutestatus("");
			dto.setFistypicalbill("否");
			dto.setFlinename(ddSwitchseqbillDto.getFlinename());
			//dto.setFmanualno(ddSwitchseqbillFacade.getMaxfmanualno());
			dto.setFmission(ddSwitchseqbillDto.getFmission());
			dto.setFoperate(ddSwitchseqbillDto.getFoperate());
			dto.setFremark(ddSwitchseqbillDto.getFremark());
			dto.setReason(ddSwitchseqbillDto.getReason());
			dto.setFsrcbillno(ddSwitchseqbillDto.getFsrcbillno());
			dto.setFstationname(ddSwitchseqbillDto.getFstationname());
			iniDefaultValue(request,dto);
			
		}
		//保存操作票
		ddSwitchseqbillFacade.addDdSwitchseqbill(dto);
		//拷贝操作步骤
		String hql ="from DdSeqbilldetail t where t.zddseqbilldetail1.fcomputerno='"+mainId+"'";
		QueryListObj obj= ddSwitchseqbillFacade.listDdSeqbilldetailByHql(hql);
		List listobj = new ArrayList();
		
		if (obj == null) { 
			
		}
		List list = obj.getElemList();
		if (list == null || list.size() < 1){
			
		}
		else{
			for(int i=0 ;i<list.size();i++){
				DdSeqbilldetailDto detail = new DdSeqbilldetailDto();
				DdSeqbilldetailDto dtodetail = (DdSeqbilldetailDto) list.get(i);
				detail.setVersion(0);
				detail.setFcontent(dtodetail.getFcontent());
				detail.setFstationname(dtodetail.getFstationname()); 
				detail.setFstep(dtodetail.getFstep());
				detail.setFserialno(dtodetail.getFserialno());
				detail.setZddseqbilldetail1(dto);
				System.out.println("aaaaaaaaaaaaaa"+dto.getFcomputerno());
				detail.setFoperationstepno(null);
				listobj.add(detail);
			}
			//保存操作步骤
			ddSwitchseqbillFacade.saveOrUpdateDdSeqbilldetail(listobj);
			
		}
		
		response.getWriter().println("1");
		//ddSwitchseqbillForm.setDdSwitchseqbillDto(ddSwitchseqbillDto);
		//return mapping.findForward("ddSwitchseqbilldetail");
		return null;
	}
	/**
	 * 转为典型票
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ActionForward TransTypicalbill(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String ids = request.getParameter("fcomputerno");
			String[] idds = ids.split("^");

			DdSwitchseqbillForm ddSwitchseqbillForm = (DdSwitchseqbillForm) form;
			DdSwitchseqbillDto ddSwitchseqbillDto = ddSwitchseqbillForm
					.getDdSwitchseqbillDto();

			ArrayList list = new ArrayList();
			for (int i = 0; i < idds.length; i++) {
				DdSwitchseqbillDto dto = ddSwitchseqbillFacade
						.getDdSwitchseqbillById(idds[i]);
				dto.setFistypicalbill("是");

				dto.setFddseqbilldetail1(null);

				list.add(dto);
			}
			ddSwitchseqbillFacade.saveOrUpdateDdSwitchseqbill(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;

	}

	public void setDdAccidentbriefFacade(
			DdAccidentbriefFacade ddAccidentbriefFacade) {
		this.ddAccidentbriefFacade = ddAccidentbriefFacade;
	}

	/**
	 * @business method list
	 * @合格情况核定
	 * @盖执行章
	 * @操作票终止
	 * 
	 * @从典型票输入
	 */
	// please add your business methods start
	// to do it
	// add your business method end
	
	
	/**
	 * 工作流处理
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

		
		String busId 			= request.getParameter("wf_busId");			//业务ID
		String taskId 			= request.getParameter("wf_taskId");			//任务实例ID
		String taskInstanceId 	= request.getParameter("wf_taskInstanceId");			//任务实例ID
		String status 			= request.getParameter("wf_status");			//状

		String notices 			= request.getParameter("notice"); 			//处理意见
		String messages 		= request.getParameter("message"); 			//消息内容
		String sentPersons 		= request.getParameter("sentPersons"); 		//消息接收人


		String isSms = request.getParameter("isSms"); 					//是否发送手机短信


		String taskRoles = request.getParameter("nextTaskRoles");   //流转人员安排
		String[] nextTaskRoles = taskRoles.split(",");
		//if(nextTaskRoles == null){
		//	nextTaskRoles = new String[1];
		//}
//		for(int i=0;i<nextTaskRoles.length;i++){
//			System.out.println(nextTaskRoles[i]);
//		}baibai
		String transitionFlag = request.getParameter("transitionFlag"); 				//流转处理标记
		
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
				this.ddSwitchseqbillFacade.start(dto);
				break;
			case 2:// 审核　－－－＞　执行／修改
				this.ddSwitchseqbillFacade.ddSwitchseqBillApprove(dto);
				break;
			case 101: //
				this.ddSwitchseqbillFacade.ddSwitchseqBillModify(dto);
				break;
			case 3://审批
				this.ddSwitchseqbillFacade.ddSwitchseqBillExec(dto);
				
				break;
		
			}

		}

		return mapping.findForward("");
	}
	
	
	public ActionForward toolbarOperation( ActionMapping mapping,

            ActionForm form, 

            HttpServletRequest request,

            HttpServletResponse response) throws Exception {

			String hqlStr     = "";
			
			GridInfoObj gridInfo = sysUiGridFacade.getGenGridInfo(request, hqlStr);
			
			String hqlSql         = gridInfo.getHqlSql();
			
			int beginPage         = gridInfo.getBeginPage();
			
			int pageSize          = gridInfo.getPageSize();
			
			String sumSql         = gridInfo.getSumSql();
			
			
			
			int count = 0;
			
			List dtolist = new ArrayList();
			
			List sumInfo = new ArrayList();
			/*
			 * int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj queryObj = ddSwitchseqbillFacade
					.getDdSwitchseqbillByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddSwitchseqbillgrid", xmlStr);
			 */
			
			if (!StringUtils.isEmpty(hqlSql)) {
			
			QueryListObj qObj = ddSwitchseqbillFacade.getDdSwitchseqbillByHql(hqlSql, beginPage, pageSize,sumSql);
			
			dtolist = qObj.getElemList();
			
			}
			
			DdSwitchseqbillDto dto = (DdSwitchseqbillDto)dtolist.get(0);
			
			String mainId   = dto.getFcomputerno();
			
			return this.printResponseMes(request, response, mapping,"null", mainId+"");

	}


}
