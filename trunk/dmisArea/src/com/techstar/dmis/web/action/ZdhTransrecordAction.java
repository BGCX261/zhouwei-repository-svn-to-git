package com.techstar.dmis.web.action;

import java.util.List;
import java.util.Map;
import java.io.IOException;
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

import com.techstar.dmis.web.facade.ZdhTransrecordFacade;
import com.techstar.dmis.web.form.ZdhTransrecordForm;
import com.techstar.dmis.dto.ZdhSrapplicationDto;
import com.techstar.dmis.dto.ZdhTransrecordDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class ZdhTransrecordAction extends BaseDispatchAction {
	private ZdhTransrecordFacade zdhTransrecordFacade;

	private SysUiGridFacade sysUiGridFacade;

	public ZdhTransrecordAction() {
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
		List list = zdhTransrecordFacade.listZdhTransrecord();
		request.getSession().setAttribute("ZdhTransrecordList", list);

		// 记录操作日志
		// saveLog("ZdhTransrecorder", "查询列表");
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
		ZdhTransrecordForm zdhTransrecordForm = (ZdhTransrecordForm) form;
		ZdhTransrecordDto dto = zdhTransrecordForm.getZdhTransrecordDto();

		// 附件处理

		FormFile annexsequence = zdhTransrecordForm.getAnnexsequence();
		if (annexsequence != null) {
			dto.setAnnexsequence(annexsequence.getFileData());
		}

		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getTransrecordid())) {
			dto.setTransrecordid(new SequenceCreator().getUID()); // 生成内部序列号

		}
		zdhTransrecordFacade.addZdhTransrecord(dto);

		// saveLog("ZdhTransrecorder", "增加记录");
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
		ZdhTransrecordForm zdhTransrecordForm = (ZdhTransrecordForm) form;
		String transrecordid = request.getParameter("transrecordid");
		if (StringUtils.isNotEmpty(transrecordid)) {
			ZdhTransrecordDto dto = zdhTransrecordFacade
					.getZdhTransrecordById(transrecordid);
			zdhTransrecordForm.setZdhTransrecordDto(dto);
		}

		// saveLog("ZdhTransrecorder", "初始化记录操作");
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
		String transrecordid = request.getParameter("transrecordid");
		if (StringUtils.isNotEmpty(transrecordid)) {
			List list = zdhTransrecordFacade
					.deleteZdhTransrecord(transrecordid);
			request.getSession().setAttribute("ZdhTransrecordList", list);
		}

		// saveLog("ZdhTransrecorder", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setZdhTransrecordFacade(
			ZdhTransrecordFacade zdhTransrecordFacade) {
		this.zdhTransrecordFacade = zdhTransrecordFacade;
	}

	// 提供对大字段文件下载的方法
	public ActionForward download_annexsequence(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String transrecordid = request.getParameter("transrecordid");
		ZdhTransrecordDto dto = zdhTransrecordFacade
				.getZdhTransrecordById(transrecordid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getAnnexsequence());
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

		/**
		 * 表格控件基础对象
		 */

		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj queryObj = zdhTransrecordFacade
					.getZdhTransrecordByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"zdhTransrecordgrid", xmlStr);
	}

	// 交接班列表

	public ActionForward extStandGridQuery(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/**
		 * 表格控件基础对象
		 */

		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj queryObj = zdhTransrecordFacade
					.getZdhTransrecordByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"extZdhTransrecordgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward zdhTransrecordtoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>      <id>ZdhTransrecord</id>      <name>传动记录</name>   </Business>   ";
		method += "<ReportUrl>/report.do</ReportUrl>    ";
		method += "<OperItem Text='盖传动章' id='comfirmApp' href='changeStatus' title='盖传动章'></OperItem>";

		method += "</Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("zdhTransrecordtoolbar");
	}

	// 初始化tab页

	public ActionForward zdhTransrecordtab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhTransrecordtab");
	}

	public ActionForward zdhTransrecordframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhTransrecordframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhTransrecordForm zdhTransrecordForm = (ZdhTransrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhTransrecordDto zdhTransrecordDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhTransrecordDto = zdhTransrecordFacade
						.getZdhTransrecordById(mainId);
				zdhTransrecordDto.setVersion(0);

				if (zdhTransrecordDto.getZzdhtransrecord3() != null) {
					request.setAttribute("currno", zdhTransrecordDto
							.getZzdhtransrecord3().getOndutyno());
				} else {
					request.setAttribute("currno", "");

				}
				request.setAttribute("fexStatus", "");
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhTransrecordDto = zdhTransrecordFacade
						.getZdhTransrecordById(mainId);
				if (zdhTransrecordDto.getZzdhtransrecord3() != null) {
					request.setAttribute("currno", zdhTransrecordDto
							.getZzdhtransrecord3().getOndutyno());
				} else {
					request.setAttribute("currno", "");
					request.setAttribute("fexStatus", zdhTransrecordDto
							.getFexcutestatus());
					// zdhTransrecordDto.setId(null);
				}
			} else {// 新增
				zdhTransrecordDto = new ZdhTransrecordDto();
				zdhTransrecordDto
						.setZzdhtransrecord3(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
				String ondutyno = zdhTransrecordFacade.getOndutyno();
				request.setAttribute("currno", "");
				request.setAttribute("fexStatus", "");
				zdhTransrecordDto.getZzdhtransrecord3().setOndutyno(ondutyno);

			}
		}
		String ondutyno = zdhTransrecordFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		zdhTransrecordForm.setZdhTransrecordDto(zdhTransrecordDto);
		return mapping.findForward("zdhTransrecorddetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhTransrecordForm zdhTransrecordForm = (ZdhTransrecordForm) form;
		ZdhTransrecordDto zdhTransrecordDto = zdhTransrecordForm
				.getZdhTransrecordDto();
		FormFile formFile = zdhTransrecordForm.getAnnexsequence();

		if (formFile != null) {
			byte[] filedd = formFile.getFileData();
			// System.out.println("filedd:"+filedd.toString());
			zdhTransrecordDto.setAnnexsequence(formFile.getFileData());

		}
		zdhTransrecordDto.setZzdhtransrecord1(null);
		zdhTransrecordFacade.addZdhTransrecord(zdhTransrecordDto);
		zdhTransrecordDto = zdhTransrecordFacade
				.getZdhTransrecordById(zdhTransrecordDto.getTransrecordid());

		zdhTransrecordForm.setZdhTransrecordDto(zdhTransrecordDto);
		saveMessages(request, "message.save.success",
				new String[] { "传动记录Dto" });
		String ondutyno = zdhTransrecordFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		request.setAttribute("currno", zdhTransrecordDto.getZzdhtransrecord3()
				.getOndutyno());
		request.setAttribute("fexStatus", zdhTransrecordDto.getFexcutestatus());
		return mapping.findForward("zdhTransrecorddetail");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public ActionForward showDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ZdhTransrecordForm zdhTransrecordForm = (ZdhTransrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		if (mainId != null && mainId.trim().length() > 0) {

		} else {
			mainId = (String) request.getParameter("primaryInfo");
			// primaryInfo transinfoid^string^id
			// System.out.println(request.getParameterNames());
			mainId = mainId.substring(mainId.lastIndexOf("^") + 1);
		}

		ZdhTransrecordDto zdhTransrecordDto = null;
		zdhTransrecordDto = zdhTransrecordFacade.getZdhTransrecordById(mainId);
		zdhTransrecordForm.setZdhTransrecordDto(zdhTransrecordDto);
		return mapping.findForward("zdhTransrecordshowdetail");

	}

	public ActionForward showImg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ZdhTransrecordForm zdhTransrecordForm = (ZdhTransrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		ZdhTransrecordDto zdhTransrecordDto = null;

		zdhTransrecordDto = zdhTransrecordFacade.getZdhTransrecordById(mainId);
		zdhTransrecordForm.setZdhTransrecordDto(zdhTransrecordDto);
		request.setAttribute("zdhTransrecordDto", zdhTransrecordDto);
		return mapping.findForward("zdhTransrecordshowImg");

	}

	/**
	 * 成批删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author sbt 2007-4-18
	 */
	public ActionForward deleteRows(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strTransrecordid = request.getParameter("transrecordid");
		String versionStr = request.getParameter("versions");
		// System.out.println("主键参数:" + strTransrecordid);
		// System.out.println("版本参数:" + versionStr);
		try {
			List dtos = new ArrayList();
			String[] transrecordidArr = strTransrecordid.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i = 0; i < transrecordidArr.length; i++) {
				ZdhTransrecordDto zdhTransrecordDto = new ZdhTransrecordDto();
				// 设置主键值

				zdhTransrecordDto.setTransrecordid(transrecordidArr[i]);
				// 设置版本号

				zdhTransrecordDto.setVersion(Integer.valueOf(versionArr[i])
						.intValue());
				// 设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
				zdhTransrecordDto.setZzdhtransrecord3(null);
				zdhTransrecordDto.setZzdhtransrecord1(null);
				dtos.add(zdhTransrecordDto);
			}
			zdhTransrecordFacade.deleteZdhTransrecord(dtos);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 盖传动章
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zzt 2007-5-10
	 */
	public ActionForward changeStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strTransrecordid = request.getParameter("transrecordid");
		String versionStr = request.getParameter("versions");

		try {
			List dtos = new ArrayList();
			String[] transrecordidArr = strTransrecordid.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i = 0; i < transrecordidArr.length; i++) {
				zdhTransrecordFacade.changeStatus(transrecordidArr[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

			QueryListObj qObj = zdhTransrecordFacade.getZdhTransrecordByHql(hqlSql, beginPage, pageSize,
					sumSql);
					

			dtolist = qObj.getElemList();

		}

		ZdhTransrecordDto zdhTransrecordDto = (ZdhTransrecordDto) dtolist
				.get(0);

		String mainId = zdhTransrecordDto.getTransrecordid();

		return this.printResponseMes(request, response, mapping, "null", mainId
				+ "");

	}

	/**
	 * @business method list
	 * @数据校核完成
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
