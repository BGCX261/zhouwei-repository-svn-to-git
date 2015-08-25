package com.techstar.dmis.web.action;

import java.io.File;
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
import org.apache.struts.upload.FormFile;

import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.dto.DdOperationnotebookDto;
import com.techstar.dmis.dto.DdSeqbilldetailDto;
import com.techstar.dmis.dto.DdSwitchseqbillDto;
import com.techstar.dmis.util.DateUtil;
import com.techstar.dmis.web.facade.DdClassondutylogFacade;
import com.techstar.dmis.web.form.DdClassondutylogForm;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.ui.web.facade.TagEngineFacade;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.web.facade.DdHloadrecordFacade;
import com.techstar.dmis.web.facade.DdHpoweroperaterrdFacade;
import com.techstar.dmis.web.facade.DdPowerchangrecordFacade;
import com.techstar.dmis.web.facade.DdWaterheightFacade;
import com.techstar.dmis.web.facade.DdSasusprecordFacade;
import com.techstar.dmis.web.facade.DdWaterproofplanFacade;









//please add your business methods start
// to do it
//add your business method end

/**
 * @author
 * @date
 */
public class DdClassondutylogAction extends BaseDispatchAction {
	private DdClassondutylogFacade ddClassondutylogFacade;
	private DdHloadrecordFacade ddHloadrecordFacade;
	DdHpoweroperaterrdFacade ddHpoweroperaterrdFacade;
	DdPowerchangrecordFacade ddPowerchangrecordFacade;
	DdWaterheightFacade ddWaterheightFacade;
	DdSasusprecordFacade ddSasusprecordFacade;
	DdWaterproofplanFacade ddWaterproofplanFacade;

	private SysUiGridFacade sysUiGridFacade;

	public DdClassondutylogAction() {
	}
	public void iniDefaultValue(HttpServletRequest request,DdClassondutylogDto dto){
		
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
		List list = ddClassondutylogFacade.listDdClassondutylog();
		request.getSession().setAttribute("DdClassondutylogList", list);

		// 记录操作日志
		// saveLog("DdClassondutyloger", "查询列表");
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
		DdClassondutylogForm ddClassondutylogForm = (DdClassondutylogForm) form;
		DdClassondutylogDto dto = ddClassondutylogForm.getDdClassondutylogDto();
		
		
		// 附件处理

		FormFile content = ddClassondutylogForm.getContent();
		if (content != null) {
			dto.setContent(content.getFileData());
		}

		// 如果主键为空，则生成主键

		if (StringUtils.isEmpty(dto.getFid())) {
			dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号
			// gcy need add增加确省默认值			
			long nCurrentTime = System.currentTimeMillis();
			java.sql.Timestamp fsuccessiontime = new java.sql.Timestamp(
					nCurrentTime);
			//开始时间
			dto.setFsuccessiontime(fsuccessiontime);
			
			//缺省值处理
			BusinessDetailHelper ss = new BusinessDetailHelper();
			BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
			dto.setSys_filldept(defaultdto.getUserDeptName());
			dto.setSys_filltime(fsuccessiontime);
			dto.setSys_dataowner(defaultdto.getDataOwnerName());
			dto.setSys_fille(defaultdto.getUserName());			

		}
		ddClassondutylogFacade.addDdClassondutylog(dto);

		// saveLog("DdClassondutyloger", "增加记录");
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
		DdClassondutylogForm ddClassondutylogForm = (DdClassondutylogForm) form;
		String fid = request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdClassondutylogDto dto = ddClassondutylogFacade
					.getDdClassondutylogById(fid);
			ddClassondutylogForm.setDdClassondutylogDto(dto);
		}

		// saveLog("DdClassondutyloger", "初始化记录操作");
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
			List list = ddClassondutylogFacade.deleteDdClassondutylog(fid,
					version);
			request.getSession().setAttribute("DdClassondutylogList", list);
		}

		// saveLog("DdClassondutyloger", "删除记录操作");
		// return mapping.findForward("list");
		return this.printResponseMes(request, response, mapping, "null", "删除成功");
	}

	public void setDdClassondutylogFacade(
			DdClassondutylogFacade ddClassondutylogFacade) {
		this.ddClassondutylogFacade = ddClassondutylogFacade;
	}

	// 提供对大字段文件下载的方法
	public ActionForward download_content(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fid = request.getParameter("fid");
		DdClassondutylogDto dto = ddClassondutylogFacade
				.getDdClassondutylogById(fid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getContent());
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
		hqlSql += " order by t.fsuccessiontime desc";
		System.out.println("kkkkkkkkkkkkkkkkkkkkk");
		System.out.println("hqlsql="+hqlSql);
		System.out.println("kkkkkkkkkkkkkkkkkkkkk");
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/*
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = ddClassondutylogFacade
					.getDdClassondutylogByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			if (count ==0){
				
				DdClassondutylogDto dto = new DdClassondutylogDto();
//				 如果主键为空，则生成主键

				if (StringUtils.isEmpty(dto.getFid())) {
					dto.setFid(new SequenceCreator().getUID()); // 生成内部序列号
					// gcy need add增加确省默认值
					long nCurrentTime = System.currentTimeMillis();
					java.sql.Timestamp fsuccessiontime = new java.sql.Timestamp(
							nCurrentTime);
					//开始时间
					dto.setFsuccessiontime(fsuccessiontime);
					
					//缺省值处理
					BusinessDetailHelper ss = new BusinessDetailHelper();
					BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
					dto.setSys_filldept(defaultdto.getUserDeptName());
					dto.setSys_filltime(fsuccessiontime);
					dto.setSys_dataowner(defaultdto.getDataOwnerName());
					dto.setSys_fille(defaultdto.getUserName());			

				}
				ddClassondutylogFacade.addDdClassondutylog(dto);
				QueryListObj queryObj1 = ddClassondutylogFacade
				.getDdClassondutylogByHql(hqlSql, beginPage, pageSize,
						sumSql);
				dtolist = queryObj1.getElemList();
				count = queryObj1.getCount();
				
			}
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid", xmlStr);
	}

	// 初始化表格
	//设备重载
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
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = ddHloadrecordFacade
					.getDdHloadrecordByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid1", xmlStr);
	}

	// 初始化表格

	public ActionForward standGridQuery2(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		String swhere = request.getParameter("extWheres");
		System.out.println("########################");
		System.out.println(swhere);
		System.out.println("########################");

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/*
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = ddSasusprecordFacade
					.getDdSasusprecordByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid2", xmlStr);
	}

	// 初始化表格
	//运行记事
	public ActionForward standGridQuery3(ActionMapping mapping,
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
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = ddClassondutylogFacade
					.getDdOperationnotebookByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid3", xmlStr);
	}

	// 初始化表格
//DdPowerchangrecord
	public ActionForward standGridQuery4(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = "user"; // 用户ID

		// 取到表格的信息

		String swhere = request.getParameter("extWheres");
		System.out.print("########################");
		System.out.print(swhere);

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/*
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = this.ddPowerchangrecordFacade
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
				"ddClassondutyloggrid4", xmlStr);
	}

	// 初始化表格
//ddHpoweroperaterrd
	public ActionForward standGridQuery5(ActionMapping mapping,
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
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = this.ddHpoweroperaterrdFacade
					.getDdHpoweroperaterrdByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid5", xmlStr);
	}

	// 初始化表格
//DdWaterheight
	public ActionForward standGridQuery6(ActionMapping mapping,
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
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = this.ddWaterheightFacade
					.getDdWaterheightByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid6", xmlStr);
	}

	// 初始化表格
//DdWaterproofplan
	public ActionForward standGridQuery7(ActionMapping mapping,
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
		 * List dtolist = new ArrayList(); DdClassondutylogFacadeDto
		 * ddClassondutylogDto = new DdClassondutylogDto();
		 * //ddClassondutylogDto.setCustom_id("custom_id");
		 * //ddClassondutylogDto.setCustom_name("Custom_name"); for(int i=0;i<50;i++){
		 * dtolist.add(ddClassondutylogDto); } int count = dtolist.size(); List
		 * sumInfo = new ArrayList();
		 */

		/**
		 * 表格控件基础对象
		 */
		// BaseGridObj gridObj = new BaseGridObj();
		// gridObj.setId("mygrid");
		// gridObj.setPageId("page");
		// gridObj.setDivHeight("400");
		// gridObj.setBusName("DdClassondutylogDto");
		// gridObj.setSubName("general");
		// gridObj.setPageItems("4");
		// gridObj.setListType("3");
		// gridObj.setListKind("101");
		// gridObj.setFilterMode("2");
		// gridObj.setEntityName("DdClassondutylog");
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
			QueryListObj queryObj = this.ddWaterproofplanFacade
					.getDdWaterproofplanByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"ddClassondutyloggrid7", xmlStr);
	}

	// 初始化toolbar
	public ActionForward ddClassondutylogtoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>";
		 method += "<Business>";
		 method +="<id>DdClassondutylog</id>";
		 method +="<name>调度交接班记录</name>";
		 method +="</Business>";
		 method +="<ReportUrl>/report.do</ReportUrl>";
		 method +="<OperItem Text='交接班' id='turnOver' href='turnOver' title=''></OperItem>"; 
		 method +="<OperItem Text='按照指定的格式生成打印预览文件' id='PrintView' href='PrintView' title=''></OperItem>"; 			
		 method +="</Toolbar>";
		 /*
		 String method1 =  "<Toolbar>   " +
         "          <Business>      " +
         "             <id>ZdhFaultlist</id>       " +
         "             <name>自动化设备缺陷</name>   " +
         "          </Business>   " +
         "          <ReportUrl>/report.do</ReportUrl>   " +
         "          <OperItem Text='缺陷送检' id='sendCheck' href='sendCheck' title=''></OperItem>" +
         "          <OperItem Text='缺陷归档' id='pigeonhole' href='pigeonhole' title=''></OperItem>" +
         "        </Toolbar>";
*/
         //"        <OperItem Text='检修缺陷' id='operation1' href='operation1' title=''></OperItem>" +

         //"        <OperItem Text='缺陷恢复' id='operation2' href='operation2' title=''></OperItem>" +
		 
		request.setAttribute("xmlData", method);
		return mapping.findForward("ddClassondutylogtoolbar");
	}

	// 初始化tab页

	public ActionForward ddClassondutylogtab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddClassondutylogtab");
	}

	public ActionForward ddClassondutylogframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("ddClassondutylogframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdClassondutylogForm ddClassondutylogForm = (DdClassondutylogForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdClassondutylogDto ddClassondutylogDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddClassondutylogDto = ddClassondutylogFacade
						.getDdClassondutylogById(mainId);
				ddClassondutylogDto.setVersion(0);
				// ddClassondutylogDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddClassondutylogDto = ddClassondutylogFacade
						.getDdClassondutylogById(mainId);
			} else {// 新增
				ddClassondutylogDto = new DdClassondutylogDto();
				iniDefaultValue(request,ddClassondutylogDto);
			}
		}
		ddClassondutylogForm.setDdClassondutylogDto(ddClassondutylogDto);
		return mapping.findForward("ddClassondutylogdetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdClassondutylogForm ddClassondutylogForm = (DdClassondutylogForm) form;
		DdClassondutylogDto ddClassondutylogDto = ddClassondutylogForm
				.getDdClassondutylogDto();
		ddClassondutylogFacade.addDdClassondutylog(ddClassondutylogDto);
		ddClassondutylogDto = ddClassondutylogFacade
				.getDdClassondutylogById(ddClassondutylogDto.getFid());
		ddClassondutylogForm.setDdClassondutylogDto(ddClassondutylogDto);
		saveMessages(request, "message.save.success",
				new String[] { "调度交接班记录Dto" });
		return mapping.findForward("ddClassondutylogdetail");
	}

	// 处理DETAIL页面
	public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("ddClassondutylogdetail1");
	}

	public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return mapping.findForward("ddClassondutylogdetail1");
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	/**
	 * @business method list
	 * @按照指定的格式生成打印预览文件
	 */
	// please add your business methods start
	// to do it
	// add your business method end
	public ActionForward PrintView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		//saveMessages(request, "message.save.success", new String[] { "自动化设备缺陷Dto" });
		return this.printResponseMes(request,response,mapping,"null","打印预览");
	}
	
	
	/**
	 *交接班 ,生成下一班的记录
	 */
	public ActionForward turnover(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response) throws Exception{
		String fid = request.getParameter("fid");
		
		DdClassondutylogDto Curdutylogdto = ddClassondutylogFacade.getDdClassondutylogById(fid);
		DdClassondutylogDto Nextdutylogdto = new DdClassondutylogDto();
		//主键
		Nextdutylogdto.setFid(new SequenceCreator().getUID());
		
		long nCurrentTime = System.currentTimeMillis();
		java.sql.Timestamp fsuccessiontime = new java.sql.Timestamp(
				nCurrentTime);
		//开始时间
		Nextdutylogdto.setFsuccessiontime(fsuccessiontime);
		//结束时间
		//Nextdutylogdto.setFhandovertime(fsuccessiontime);
		//值班值长
		Nextdutylogdto.setFdelresponser(Curdutylogdto.getFminister());
		//值班正值
		Nextdutylogdto.setFdelattworkgroup(Curdutylogdto.getFmainattendant());
		//值班副职
		Nextdutylogdto.setFdelattworkgroup(Curdutylogdto.getFsecondattendant());
		//确省值接口--待做
		BusinessDetailHelper ss = new BusinessDetailHelper();
		BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
		Nextdutylogdto.setSys_filldept(defaultdto.getUserDeptName());
		Nextdutylogdto.setSys_filltime(fsuccessiontime);
		Nextdutylogdto.setSys_dataowner(defaultdto.getDataOwnerName());
		Nextdutylogdto.setSys_fille(defaultdto.getUserName());		
		
		//保存数据
		ddClassondutylogFacade.addDdClassondutylog(Nextdutylogdto);
		
		//将上一班的结束时间写入
		Curdutylogdto.setFhandovertime(DateUtil.getCurrentTimestamp());
		
			// 保存数据
		/*
		 *  private java.util.Collection fddpowerplantoperlog4; //班志编号
	      private java.util.Collection fddoperationnotebook4; //班志编号
	      private java.util.Collection fddsasusprecord3; //班志编号
	      private java.util.Collection fddwaterheight3; //班志编号
	      private java.util.Collection fddwaterproofplan2; //班志编号Ｆ
	      private java.util.Collection fddhloadrecord4; //班志编号
	      private java.util.Collection fddpowerchangrecord4; //班志编号
	      private java.util.Collection fddhpoweroperaterrd5; //班志编号
		 */
		Curdutylogdto.setFddpowerplantoperlog4(null);
		Curdutylogdto.setFddoperationnotebook4(null);
		Curdutylogdto.setFddsasusprecord3(null);
		Curdutylogdto.setFddwaterheight3(null);
		Curdutylogdto.setFddwaterproofplan2(null);
		Curdutylogdto.setFddhloadrecord4(null);
		Curdutylogdto.setFddpowerchangrecord4(null);
		Curdutylogdto.setFddhpoweroperaterrd5(null);
		ddClassondutylogFacade.addDdClassondutylog(Curdutylogdto);
		
		
		request.getSession().removeAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY);
		//return mapping.findForward("index");
		response.getWriter().print("交接班完成");
		return null;//this.printResponseMes(request,response,mapping,"","交接班完成");
		
		
	}
	
	/**运行记事**/
	/**
	 * 保存运行记事
	 */
	public ActionForward saveddOperationnotebookGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			String parentid = request.getParameter("parentid");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath  = "";
			if(files.length > 0){
				String path = files[0].getParent();
				classPath  += path+"\\"+"DdClassondutylogDto3"+".xml";
			}
			//return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			DdOperationnotebookDto dto = new DdOperationnotebookDto();
			
			
			//ddto.setFid(parentid);
			//dto.setZddoperationnotebook4(ddto);
			List list = engine.getDtoList(head, dates,dto,filePath);
			List listnew = new ArrayList();
			for(int i=0;i<list.size();i++){
				DdOperationnotebookDto dto1 = (DdOperationnotebookDto)list.get(i);
				
				BusinessDetailHelper ss = new BusinessDetailHelper();
				BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
				dto1.setSys_filldept(defaultdto.getUserDeptName());
				dto1.setSys_filltime(DateUtil.getCurrentTimestamp());
				dto1.setSys_dataowner(defaultdto.getDataOwnerName());
				dto1.setSys_fille(defaultdto.getUserName());
				//dto1.setZddoperationnotebook4(ddto);
				dto1.setZddoperationnotebook5(null);//需要修改
				listnew.add(dto1);
			}
			
			ddClassondutylogFacade.saveOrUpdateDdOperationnotebook(list);
			
			
			response.getWriter().println("1");
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().println("0");
		}
		return null;
				
	}
	/**
	 * 删除运行记事
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteddOperationnotebookGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String ids = request.getParameter("ids");
	        String version = request.getParameter("version");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(ids);
			String[] idds = ids.split(";");
			String [] versions = version.split(";");
			
			String fid="";
			//ArrayList list = new ArrayList();
			for(int i=0;i<idds.length;i++){
				DdOperationnotebookDto dto = new DdOperationnotebookDto();
				dto.setFid(idds[i]);
				dto.setVersion(Integer.parseInt(versions[i]));
				
				dto.setZddoperationnotebook5(null);
				dto.setZddoperationnotebook4(null);
				//dto.setZddfsmodechangelist5(null);
				ddClassondutylogFacade.deleteDdOperationnotebook(dto);
				//list.add(dto);
			}
			
			
			response.getWriter().println("1");
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().println("0");
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param ddHloadrecordFacade
	 */
	
	
	public void setDdHloadrecordFacade(DdHloadrecordFacade ddHloadrecordFacade) {
		this.ddHloadrecordFacade = ddHloadrecordFacade;
	}
	public void setDdHpoweroperaterrdFacade(
			DdHpoweroperaterrdFacade ddHpoweroperaterrdFacade) {
		this.ddHpoweroperaterrdFacade = ddHpoweroperaterrdFacade;
	}
	public void setDdPowerchangrecordFacade(
			DdPowerchangrecordFacade ddPowerchangrecordFacade) {
		this.ddPowerchangrecordFacade = ddPowerchangrecordFacade;
	}
	public void setDdWaterheightFacade(DdWaterheightFacade ddWaterheightFacade) {
		this.ddWaterheightFacade = ddWaterheightFacade;
	}
	public void setDdSasusprecordFacade(DdSasusprecordFacade ddSasusprecordFacade) {
		this.ddSasusprecordFacade = ddSasusprecordFacade;
	}
	public void setDdWaterproofplanFacade(
			DdWaterproofplanFacade ddWaterproofplanFacade) {
		this.ddWaterproofplanFacade = ddWaterproofplanFacade;
	}
}
