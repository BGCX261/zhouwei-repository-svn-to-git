package com.techstar.dmis.web.action;

import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
import com.techstar.dmis.dto.DdPremethodDto;
import com.techstar.dmis.dto.DdRepairrisklistDto;
import com.techstar.dmis.entity.DdPremethod;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.web.facade.DdEnsuringpsmanageFacade;
import com.techstar.dmis.web.facade.DdMoutageplanFacade;
import com.techstar.dmis.web.facade.DdPremethodFacade;
import com.techstar.dmis.web.facade.DdRepairrisklistFacade;
import com.techstar.dmis.web.form.DdPremethodForm;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.web.action.BaseDispatchAction;

/**
 * @author
 * @date
 */
public class DdPremethodAction extends BaseDispatchAction {
	private DdPremethodFacade ddPremethodFacade;

	private DdRepairrisklistFacade ddRepairrisklistFacade;

	private DdMoutageplanFacade ddMoutageplanFacade;

	private DdEnsuringpsmanageFacade ddEnsuringpsmanageFacade;

	private SysUiGridFacade sysUiGridFacade;

	public DdPremethodAction() {
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
		List list = ddPremethodFacade.listDdPremethod();
		request.getSession().setAttribute("DdPremethodList", list);

		// 记录操作日志
		// saveLog("DdPremethoder", "查询列表");
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
		DdPremethodForm ddPremethodForm = (DdPremethodForm) form;
		DdPremethodDto dto = ddPremethodForm.getDdPremethodDto();

		request.setCharacterEncoding("utf-8");
		//
		String primaryId = request.getParameter("primaryId");

		//
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

		dto.setSys_dataowner(dataOwnerName);
		dto.setSys_filldept(userDeptName);
		dto.setSys_fille(userName);
		dto.setSys_filltime(currentTime);

		// 附件处理

		FormFile fpremethodcontent = ddPremethodForm.getFpremethodcontent();
		if (fpremethodcontent.getFileData().length != 0) {
			DdRepairrisklistDto repairrisklistDto = ddRepairrisklistFacade
					.getDdRepairrisklistById(primaryId);
			dto.setFpremethodcontent(fpremethodcontent.getFileData());
			dto.setF_appendixtype(fpremethodcontent.getContentType());
			dto.setPremethodname(fpremethodcontent.getFileName());
			dto.setZddpremethod5(repairrisklistDto.getZddrepairrisklist4());
			dto.setSrc(DispatchConstants.ddMoutageplan_plansourcetype_mplan);
			// 如果主键为空，则生成主键
			if (StringUtils.isEmpty(dto.getFpremethodid())) {
				dto.setFpremethodid(new SequenceCreator().getUID()); // 生成内部序列号

			}
			ddPremethodFacade.addDdPremethod(dto);
			request.setAttribute("upload_message", "up_s");
		} else
			request.setAttribute("upload_message", "up_e");
		request.setAttribute("primaryId", primaryId);
		return mapping.findForward("upload");

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
	public ActionForward addEnsurmanageFexis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DdPremethodForm ddPremethodForm = (DdPremethodForm) form;
		DdPremethodDto dto = ddPremethodForm.getDdPremethodDto();

		request.setCharacterEncoding("utf-8");
		//
		String primaryId = request.getParameter("primaryId");

		//
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

		dto.setSys_dataowner(dataOwnerName);
		dto.setSys_filldept(userDeptName);
		dto.setSys_fille(userName);
		dto.setSys_filltime(currentTime);

		// 附件处理

		FormFile fpremethodcontent = ddPremethodForm.getFpremethodcontent();
		if (fpremethodcontent.getFileData().length != 0) {
			DdEnsuringpsmanageDto edto = ddEnsuringpsmanageFacade
					.getDdEnsuringpsmanageById(primaryId);
			dto.setFpremethodcontent(fpremethodcontent.getFileData());
			dto.setF_appendixtype(fpremethodcontent.getContentType());
			dto.setPremethodname(fpremethodcontent.getFileName());
			dto.setZddpremethod4(edto);
//			dto.setSrc(DispatchConstants.DdEnsuringpsmanage_plansourcetype_mplan);

			// 如果主键为空，则生成主键
			if (StringUtils.isEmpty(dto.getFpremethodid())) {
				dto.setFpremethodid(new SequenceCreator().getUID()); // 生成内部序列号

			}
			ddPremethodFacade.addDdPremethod(dto);
			request.setAttribute("upload_message", "up_s");
		} else
			request.setAttribute("upload_message", "up_e");
		request.setAttribute("primaryId", primaryId);
		return mapping.findForward("upload");

	}

	public ActionForward showContent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fpremethodid = request.getParameter("fpremethodid");

		if (fpremethodid == null)
			return null;

		DdPremethodDto dto = ddPremethodFacade.getDdPremethodById(fpremethodid);

		request.setAttribute("ddPremethodDto", dto);

		if (dto.getF_appendixtype().equals("application/msword")
				|| dto.getF_appendixtype().equals("application/octet-stream")
				|| dto.getF_appendixtype().equals("text/plain"))
			return mapping.findForward("bottom_doc");

		return mapping.findForward("bottom");
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
		DdPremethodForm ddPremethodForm = (DdPremethodForm) form;
		String fpremethodid = request.getParameter("fpremethodid");
		if (StringUtils.isNotEmpty(fpremethodid)) {
			DdPremethodDto dto = ddPremethodFacade
					.getDdPremethodById(fpremethodid);
			ddPremethodForm.setDdPremethodDto(dto);
		}

		// saveLog("DdPremethoder", "初始化记录操作");
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
		String fpremethodid = request.getParameter("fpremethodid");
		if (StringUtils.isNotEmpty(fpremethodid)) {
			List list = ddPremethodFacade.deleteDdPremethod(fpremethodid);
			request.getSession().setAttribute("DdPremethodList", list);
		}

		// saveLog("DdPremethoder", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setDdPremethodFacade(DdPremethodFacade ddPremethodFacade) {
		this.ddPremethodFacade = ddPremethodFacade;
	}

	// 提供对大字段文件下载的方法

	public ActionForward download_fpremethodcontent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fpremethodid = request.getParameter("fpremethodid");
		DdPremethodDto dto = ddPremethodFacade.getDdPremethodById(fpremethodid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFpremethodcontent());
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

		/*
		 * List dtolist = new ArrayList(); DdPremethodFacadeDto ddPremethodDto =
		 * new DdPremethodDto(); //ddPremethodDto.setCustom_id("custom_id");
		 * //ddPremethodDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddPremethodDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdPremethodDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdPremethod");
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
			QueryListObj queryObj = ddPremethodFacade.getDdPremethodByHql(
					hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddPremethodgrid", xmlStr);
	}

	public ActionForward customGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String mainId = (String) request.getParameter("mainid");
		List list = null;
		int count = 0;

		try {
			DdRepairrisklistDto ddRepairrisklistDto = ddRepairrisklistFacade
					.getDdRepairrisklistById(mainId);
			String monthplanno = ddRepairrisklistDto.getZddrepairrisklist4()
					.getFmonthplanno();
			String hql = "select A from DdPremethod A where A.zddpremethod5.fmonthplanno='"
					+ monthplanno + "'";
			QueryListObj queryObj = ddPremethodFacade.listDdPremethodByHQL(hql);

			list = queryObj.getElemList();
			count = list.size();
		} catch (Exception e) {
			// return null;
		}

		// + monthplanno;
		// zddpremethod5.fmonthplanno

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		List sumInfo = new ArrayList();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), list, gridInfo.getBeginPage(), gridInfo
				.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddPremethodgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddPremethodtoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      <id>DdPremethod</id>      <name>电网预案</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='归档' id='premethodfile' href='#' title=''></OperItem>   <OperItem Text='保电预案编制' id='powerensurpremethod' href='#' title=''></OperItem>   <OperItem Text='月计划预案编制' id='Monthplanpremethodedit' href='#' title=''></OperItem></Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddPremethodtoolbar");
	}

	// 初始化tab页

	public ActionForward ddPremethodtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddPremethodtab");
	}

	public ActionForward ddPremethodframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddPremethodframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdPremethodForm ddPremethodForm = (DdPremethodForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdPremethodDto ddPremethodDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddPremethodDto = ddPremethodFacade.getDdPremethodById(mainId);
				ddPremethodDto.setVersion(0);
				// ddPremethodDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddPremethodDto = ddPremethodFacade.getDdPremethodById(mainId);
			} else {// 新增
				ddPremethodDto = new DdPremethodDto();
			}
		}
		ddPremethodForm.setDdPremethodDto(ddPremethodDto);
		return mapping.findForward("ddPremethoddetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdPremethodForm ddPremethodForm = (DdPremethodForm) form;
		DdPremethodDto ddPremethodDto = ddPremethodForm.getDdPremethodDto();

		ddPremethodDto
				.setFstatus((ddPremethodDto.getFpremethodid() == null)
						|| (ddPremethodDto.getFpremethodid().equals("")) ? DispatchConstants.ddPremethod_new
						: ddPremethodDto.getFstatus());

		ddPremethodFacade.addDdPremethod(ddPremethodDto);
		ddPremethodDto = ddPremethodFacade.getDdPremethodById(ddPremethodDto
				.getFpremethodid());
		ddPremethodForm.setDdPremethodDto(ddPremethodDto);
		saveMessages(request, "message.save.success",
				new String[] { "电网预案Dto" });
		return mapping.findForward("ddPremethoddetail");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setDdRepairrisklistFacade(
			DdRepairrisklistFacade ddRepairrisklistFacade) {
		this.ddRepairrisklistFacade = ddRepairrisklistFacade;
	}

	public void setDdEnsuringpsmanageFacade(
			DdEnsuringpsmanageFacade ddEnsuringpsmanageFacade) {
		this.ddEnsuringpsmanageFacade = ddEnsuringpsmanageFacade;
	}

	public void setDdMoutageplanFacade(DdMoutageplanFacade ddMoutageplanFacade) {
		this.ddMoutageplanFacade = ddMoutageplanFacade;
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
				DdPremethod ddPremethod = new DdPremethod();
				ddPremethod.setFpremethodid(idds[i]);
				ddPremethod.setVersion(Integer.parseInt(versions[i]));
				list.add(ddPremethod);
			}
			ddPremethodFacade.deleteDdPremethod(list);
			response.getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("0");
		}

		return null;
	}

	/**
	 * @business method list
	 * @归档
	 * @保电预案编制
	 * @月计划预案编制
	 *
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
