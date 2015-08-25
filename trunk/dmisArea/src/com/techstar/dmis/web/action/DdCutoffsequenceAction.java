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

import com.techstar.dmis.web.facade.DdCutoffsequenceFacade;
import com.techstar.dmis.web.form.DdCutoffsequenceForm;
import com.techstar.dmis.dto.DdCutoffsequenceDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdCutoffsequenceAction extends BaseDispatchAction {
	private DdCutoffsequenceFacade ddCutoffsequenceFacade;

	private SysUiGridFacade sysUiGridFacade;

	public DdCutoffsequenceAction() {
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
		List list = ddCutoffsequenceFacade.listDdCutoffsequence();
		request.getSession().setAttribute("DdCutoffsequenceList", list);

		// 记录操作日志
		// saveLog("DdCutoffsequenceer", "查询列表");
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
		DdCutoffsequenceForm ddCutoffsequenceForm = (DdCutoffsequenceForm) form;
		DdCutoffsequenceDto dto = ddCutoffsequenceForm.getDdCutoffsequenceDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFid())) {
			dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号

		}
		ddCutoffsequenceFacade.addDdCutoffsequence(dto);

		// saveLog("DdCutoffsequenceer", "增加记录");
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
		DdCutoffsequenceForm ddCutoffsequenceForm = (DdCutoffsequenceForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdCutoffsequenceDto dto = ddCutoffsequenceFacade
					.getDdCutoffsequenceById(fid);
			ddCutoffsequenceForm.setDdCutoffsequenceDto(dto);
		}

		// saveLog("DdCutoffsequenceer", "初始化记录操作");
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
		String version = request.getParameter("version");
		request.setCharacterEncoding("utf-8");
		//
		if (fid != null && version != null) {
			List list = ddCutoffsequenceFacade.deleteDdCutoffsequence(fid,
					version);
			request.getSession().setAttribute("DdCutoffsequenceList", list);
			return this.printResponseMes(request, response, mapping, "null",
					"删除成功");
		} else {
			return this.printResponseMes(request, response, mapping, "null",
					"删除失败");
		}

	}

	public void setDdCutoffsequenceFacade(
			DdCutoffsequenceFacade ddCutoffsequenceFacade) {
		this.ddCutoffsequenceFacade = ddCutoffsequenceFacade;
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
		 * List dtolist = new ArrayList(); DdCutoffsequenceFacadeDto
		 * ddCutoffsequenceDto = new DdCutoffsequenceDto();
		 * //ddCutoffsequenceDto.setCustom_id("custom_id");
		 * //ddCutoffsequenceDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddCutoffsequenceDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdCutoffsequenceDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdCutoffsequence");
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
			QueryListObj queryObj = ddCutoffsequenceFacade
					.getDdCutoffsequenceByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddCutoffsequencegrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddCutoffsequencetoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      <id>DdCutoffsequence</id>      <name>拉路序位</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddCutoffsequencetoolbar");
	}

	// 初始化tab页

	public ActionForward ddCutoffsequencetab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddCutoffsequencetab");
	}

	public ActionForward ddCutoffsequenceframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddCutoffsequenceframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdCutoffsequenceForm ddCutoffsequenceForm = (DdCutoffsequenceForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdCutoffsequenceDto ddCutoffsequenceDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddCutoffsequenceDto = ddCutoffsequenceFacade
						.getDdCutoffsequenceById(mainId);
				ddCutoffsequenceDto.setFid(null);
				ddCutoffsequenceDto.setVersion(0);
				// ddCutoffsequenceDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddCutoffsequenceDto = ddCutoffsequenceFacade
						.getDdCutoffsequenceById(mainId);
			} else {// 新增
				ddCutoffsequenceDto = new DdCutoffsequenceDto();
			}
		}
		ddCutoffsequenceForm.setDdCutoffsequenceDto(ddCutoffsequenceDto);
		return mapping.findForward("ddCutoffsequencedetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdCutoffsequenceForm ddCutoffsequenceForm = (DdCutoffsequenceForm) form;
		DdCutoffsequenceDto ddCutoffsequenceDto = ddCutoffsequenceForm
				.getDdCutoffsequenceDto();
		ddCutoffsequenceFacade.addDdCutoffsequence(ddCutoffsequenceDto);
		ddCutoffsequenceDto = ddCutoffsequenceFacade
				.getDdCutoffsequenceById(ddCutoffsequenceDto.getFid());
		ddCutoffsequenceForm.setDdCutoffsequenceDto(ddCutoffsequenceDto);
		saveMessages(request, "message.save.success",
				new String[] { "拉路序位Dto" });
		return mapping.findForward("ddCutoffsequencedetail");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	/**
	 * @business method list
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
