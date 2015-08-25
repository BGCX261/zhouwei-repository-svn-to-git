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
import com.techstar.dmis.web.facade.DdClassondutylogFacade;
import com.techstar.dmis.web.facade.DdPowerchangrecordFacade;
import com.techstar.dmis.web.form.DdPowerchangrecordForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.dto.DdPowerchangrecordDto;
import com.techstar.dmis.dto.DdSasusprecordDto;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.dto.StdStationDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdPowerchangrecordAction extends BaseDispatchAction {
	private DdPowerchangrecordFacade ddPowerchangrecordFacade;

	private SysUiGridFacade sysUiGridFacade;
	
	private DdClassondutylogFacade ddClassdutylogfacade;

	public DdPowerchangrecordAction() {
	}
	
	public void iniDefaultValue(HttpServletRequest request,DdPowerchangrecordDto dto){
		
		long nCurrentTime = System.currentTimeMillis();
			java.sql.Timestamp fCurTime = new java.sql.Timestamp(
					nCurrentTime);
			BusinessDetailHelper ss = new BusinessDetailHelper();
			BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
			dto.setSys_filldept(defaultdto.getUserDeptName());
			dto.setSys_filltime(fCurTime);
			dto.setSys_dataowner(defaultdto.getDataOwnerName());
			dto.setSys_fille(defaultdto.getUserName());	
	}
	
	public void SetLogno(DdPowerchangrecordDto dto){
//		增加班志编号
		
        DdClassondutylogDto ddc = this.ddClassdutylogfacade.getLogNo();
        dto.setZddpowerchangrecord4(ddc);
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
		List list = ddPowerchangrecordFacade.listDdPowerchangrecord();
		request.getSession().setAttribute("DdPowerchangrecordList", list);

		// 记录操作日志
		// saveLog("DdPowerchangrecorder", "查询列表");
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
		DdPowerchangrecordForm ddPowerchangrecordForm = (DdPowerchangrecordForm) form;
		DdPowerchangrecordDto dto = ddPowerchangrecordForm
				.getDdPowerchangrecordDto();

		// 附件处理
		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFid())) {
			dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号			 //缺省值处理
	         iniDefaultValue(request,dto);
	         SetLogno(dto);

		}
		ddPowerchangrecordFacade.addDdPowerchangrecord(dto);

		// saveLog("DdPowerchangrecorder", "增加记录");
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
		DdPowerchangrecordForm ddPowerchangrecordForm = (DdPowerchangrecordForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdPowerchangrecordDto dto = ddPowerchangrecordFacade
					.getDdPowerchangrecordById(fid);
			ddPowerchangrecordForm.setDdPowerchangrecordDto(dto);
		}

		// saveLog("DdPowerchangrecorder", "初始化记录操作");
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
		
		
		String fidStr   = request.getParameter("fid");
		String versionStr    = request.getParameter("version");
		String[] primArra    = fidStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for(int i=0; i<primArra.length; i++){
			String fid = primArra[i];
			int version     = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(fid)) {
				List list = ddPowerchangrecordFacade.deleteDdPowerchangrecordobj(fid,version);
				request.getSession().setAttribute("DdPowerchangrecordList", list);
			}
		}	

		// saveLog("DdPowerchangrecorder", "删除记录操作");
		// return mapping.findForward("list");
		return this
				.printResponseMes(request, response, mapping, "null", "删除成功");
	}

	public void setDdPowerchangrecordFacade(
			DdPowerchangrecordFacade ddPowerchangrecordFacade) {
		this.ddPowerchangrecordFacade = ddPowerchangrecordFacade;
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
		 * List dtolist = new ArrayList(); DdPowerchangrecordFacadeDto
		 * ddPowerchangrecordDto = new DdPowerchangrecordDto();
		 * //ddPowerchangrecordDto.setCustom_id("custom_id");
		 * //ddPowerchangrecordDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddPowerchangrecordDto); } int count = dtolist.size();
		 * List sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdPowerchangrecordDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdPowerchangrecord");
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
			QueryListObj queryObj = ddPowerchangrecordFacade
					.getDdPowerchangrecordByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddPowerchangrecordgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddPowerchangrecordtoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   <Business>   +"
						+"<id>DdPowerchangrecord</id>  "
						+"<name>电网运行方式调整记录</name> "
						+"</Business>  " 
						+" <ReportUrl>/report.do</ReportUrl></Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("ddPowerchangrecordtoolbar");
	}

	// 初始化tab页

	public ActionForward ddPowerchangrecordtab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddPowerchangrecordtab");
	}

	public ActionForward ddPowerchangrecordframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddPowerchangrecordframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdPowerchangrecordForm ddPowerchangrecordForm = (DdPowerchangrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdPowerchangrecordDto ddPowerchangrecordDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddPowerchangrecordDto = ddPowerchangrecordFacade
						.getDdPowerchangrecordById(mainId);
				ddPowerchangrecordDto.setVersion(0);
				 ddPowerchangrecordDto.setFid(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddPowerchangrecordDto = ddPowerchangrecordFacade
						.getDdPowerchangrecordById(mainId);
			} else {// 新增
				ddPowerchangrecordDto = new DdPowerchangrecordDto();
				 //缺省值处理
		         iniDefaultValue(request,ddPowerchangrecordDto);
		         SetLogno(ddPowerchangrecordDto);
			}
		}
		ddPowerchangrecordForm.setDdPowerchangrecordDto(ddPowerchangrecordDto);
		return mapping.findForward("ddPowerchangrecorddetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdPowerchangrecordForm ddPowerchangrecordForm = (DdPowerchangrecordForm) form;
		DdPowerchangrecordDto ddPowerchangrecordDto = ddPowerchangrecordForm
				.getDdPowerchangrecordDto();
		
		System.out.println("curlogno="+ddPowerchangrecordDto.getZddpowerchangrecord4().getFid());
		System.out.println("stationno="+ddPowerchangrecordDto.getZddpowerchangrecord6().getId());
		
		//不处理厂站
		if (ddPowerchangrecordDto.getZddpowerchangrecord6().getId() ==null || ddPowerchangrecordDto.getZddpowerchangrecord6().getId().equals("")){
			ddPowerchangrecordDto.setZddpowerchangrecord6(null);
		}
		
		
		ddPowerchangrecordFacade.addDdPowerchangrecord(ddPowerchangrecordDto);
		
		ddPowerchangrecordDto = ddPowerchangrecordFacade
				.getDdPowerchangrecordById(ddPowerchangrecordDto.getFid());
		ddPowerchangrecordForm.setDdPowerchangrecordDto(ddPowerchangrecordDto);
		saveMessages(request, "message.save.success",
				new String[] { "电网运行方式调整记录Dto" });
		return mapping.findForward("ddPowerchangrecorddetail");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	public void setDdClassondutylogFacade(DdClassondutylogFacade ddClassdutylogFacade){
		this.ddClassdutylogfacade = ddClassdutylogFacade;
	}

	
	/**
	 * @business method list
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
