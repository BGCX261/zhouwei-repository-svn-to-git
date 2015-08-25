package com.techstar.dmis.web.action;

import java.util.LinkedHashMap;
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

import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.utils.SequenceCreator;

import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.utils.grid.GridXMLHelper;
import com.techstar.framework.ui.utils.grid.NullHanlder;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;

import com.techstar.dmis.web.facade.ZdhCharalterrecordFacade;
import com.techstar.dmis.web.form.ZdhCharalterrecordForm;
import com.techstar.dmis.web.form.ZdhTransrecordForm;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dto.ZdhCharalterrecordDto;
import com.techstar.dmis.dto.ZdhTransrecordDto;
//please add your business methods start
// to do it
//add your business method end
import com.techstar.dmis.dto.ZdhFaultlistDto;
import com.techstar.dmis.entity.ZdhCharalterrecord;
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

/**
 * @author
 * @date
 */
public class ZdhCharalterrecordAction extends BaseDispatchAction {
	private ZdhCharalterrecordFacade zdhCharalterrecordFacade;
	
	private SysUiGridFacade sysUiGridFacade;

	public ZdhCharalterrecordAction() {
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
		List list = zdhCharalterrecordFacade.listZdhCharalterrecord();
		request.getSession().setAttribute("ZdhCharalterrecordList", list);

		// 记录操作日志
		// saveLog("ZdhCharalterrecorder", "查询列表");
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
		ZdhCharalterrecordForm zdhCharalterrecordForm = (ZdhCharalterrecordForm) form;
		ZdhCharalterrecordDto dto = zdhCharalterrecordForm
				.getZdhCharalterrecordDto();

		// 附件处理

		FormFile mdiagram = zdhCharalterrecordForm.getMdiagram();
		if (mdiagram != null) {
			dto.setMdiagram(mdiagram.getFileData());
		}

		// 如果主键为空，则生成主键
		if (StringUtils.isEmpty(dto.getRecordsno())) {
			dto.setRecordsno(new SequenceCreator().getUID()); // 生成内部序列号
		}
		zdhCharalterrecordFacade.addZdhCharalterrecord(dto);

		// saveLog("ZdhCharalterrecorder", "增加记录");
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
		ZdhCharalterrecordForm zdhCharalterrecordForm = (ZdhCharalterrecordForm) form;
		String recordsno = request.getParameter("recordsno");
		if (StringUtils.isNotEmpty(recordsno)) {
			ZdhCharalterrecordDto dto = zdhCharalterrecordFacade
					.getZdhCharalterrecordById(recordsno);
			zdhCharalterrecordForm.setZdhCharalterrecordDto(dto);
		}

		// saveLog("ZdhCharalterrecorder", "初始化记录操作");
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
		String recordsnoStr = request.getParameter("recordsno");
		String versionStr = request.getParameter("version");
		String[] primArra = recordsnoStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String recordsno = primArra[i];
			int version = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(recordsno)) {
				zdhCharalterrecordFacade.deleteZdhCharalterrecord(recordsno,
						version);
				// request.getSession().setAttribute("ZdhCharalterrecordList",
				// list);
			}
		}
		// saveLog("ZdhCharalterrecorder", "删除记录操作");
		return this
				.printResponseMes(request, response, mapping, "null", "删除成功");
	}

	public void setZdhCharalterrecordFacade(
			ZdhCharalterrecordFacade zdhCharalterrecordFacade) {
		this.zdhCharalterrecordFacade = zdhCharalterrecordFacade;
	}

	// 提供对大字段文件下载的方法
	public ActionForward download_mdiagram(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String recordsno = request.getParameter("recordsno");
		ZdhCharalterrecordDto dto = zdhCharalterrecordFacade
				.getZdhCharalterrecordById(recordsno);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getMdiagram());
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
			QueryListObj queryObj = zdhCharalterrecordFacade
					.getZdhCharalterrecordByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"zdhCharalterrecordgrid", xmlStr);
	}

	// 初始化toolbar
	public ActionForward zdhCharalterrecordtoolbar(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String method = "<Toolbar>   "
				+ "<Business>      "
				+ "<id>ZdhCharalterrecord</id>      "
				+ "<name>系统图修改记录</name>   "
				+ "</Business>   "
				+ "<ReportUrl>/report.do</ReportUrl>   "
				+ "<OperItem Text='遥测数据修改' id='rmdatamodify' href='rmdatamodify' title=''></OperItem>   "
				+ "<OperItem Text='关联批准书查询' id='queryapprovebook' href='queryapprovebook' title=''></OperItem>   "
				+ "<OperItem Text='系统图同步' id='syschartsysn' href='syschartsysn' title=''></OperItem>"
				+ "<OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title=''></OperItem>"
				+ "</Toolbar>";

		request.setAttribute("xmlData", method);
		return mapping.findForward("zdhCharalterrecordtoolbar");
	}

	// 初始化tab页

	public ActionForward zdhCharalterrecordtab(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhCharalterrecordtab");
	}

	public ActionForward zdhCharalterrecordframe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("zdhCharalterrecordframe");
	}

	// 处理DETAIL页面

	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhCharalterrecordForm zdhCharalterrecordForm = (ZdhCharalterrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		String primaryInfo = (String) request.getParameter("primaryInfo");
		ZdhCharalterrecordDto zdhCharalterrecordDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhCharalterrecordDto = zdhCharalterrecordFacade
						.getZdhCharalterrecordById(mainId);
				zdhCharalterrecordDto.setVersion(0);
				zdhCharalterrecordDto.setRecordsno(null);
				request.setAttribute("taskExplan", zdhCharalterrecordDto
						.getTaskexplanation());
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhCharalterrecordDto = zdhCharalterrecordFacade
						.getZdhCharalterrecordById(mainId);
				request.setAttribute("taskExplan", zdhCharalterrecordDto
						.getTaskexplanation());
			} else {// 新增
				zdhCharalterrecordDto = new ZdhCharalterrecordDto();
				request.setAttribute("taskExplan", "");
			}
		}

		// 根椐外键取系统图数据集
		if (!StringUtils.isEmpty(primaryInfo)) {
			// recordno^string^95C5468FFFC44EF54197C6F9C8DC
			String primaryKey = "";
			String[] strArra = primaryInfo.split("\\^");
			if (strArra.length == 3) {
				primaryKey = strArra[2];
			}
			ZdhCharalterrecordDto zdhCharrecordDto = zdhCharalterrecordFacade
					.getZdhCharRecordByForeign(primaryKey);
			if (zdhCharrecordDto != null) {
				zdhCharalterrecordDto = zdhCharrecordDto;
				if(!StringUtils.isEmpty(zdhCharalterrecordDto.getTaskexplanation())){
					request.setAttribute("taskExplan", zdhCharalterrecordDto
							.getTaskexplanation());
				}
			}
		}
		
		zdhCharalterrecordForm.setZdhCharalterrecordDto(zdhCharalterrecordDto);
		return mapping.findForward("zdhCharalterrecorddetail");
	}

	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhCharalterrecordForm zdhCharalterrecordForm = (ZdhCharalterrecordForm) form;
		ZdhCharalterrecordDto zdhCharalterrecordDto = zdhCharalterrecordForm
				.getZdhCharalterrecordDto();
		FormFile formFile = zdhCharalterrecordForm.getMdiagram();
		
		if( formFile != null ){
			byte[] filedd = formFile.getFileData();
			System.out.println("filedd:"+filedd.toString());
			zdhCharalterrecordDto.setMdiagram(formFile.getFileData());
	    }
		
		
		// 新建
		if (StringUtils.isEmpty(zdhCharalterrecordDto.getRecordsno())) {
			zdhCharalterrecordDto.setFexcutestatus(this.getStatus("new"));
		}
		String status = zdhCharalterrecordDto.getFstatus();
		if(status ==null ||  "".equals(status)){
			//设置填报信息
			//BusinessDetailDto busDetailDto= BusinessDetailHelper.getBusDetailInfo(request); 
			//zdhCharalterrecordDto.setSys_fille(busDetailDto.getUserName());
			//zdhCharalterrecordDto.setSys_filldept(busDetailDto.getUserDeptName());
			//zdhCharalterrecordDto.setSys_filltime(busDetailDto.getCurrentTime());
			//zdhCharalterrecordDto.setSys_dataowner(busDetailDto.getDataOwnerName());
			//更新业务状态

			if(status==null || "".equals(status)){
				zdhCharalterrecordDto.setFstatus(ZdhConstants.ZdhCharalterrecord_WORKFLOW_CITY_STATUS_NEW);
				zdhCharalterrecordDto.setFexcutestatus(ZdhConstants.ZDH_DRAFT);
			}
		}
		zdhCharalterrecordFacade.addZdhCharalterrecord(zdhCharalterrecordDto);
		zdhCharalterrecordDto = zdhCharalterrecordFacade
				.getZdhCharalterrecordById(zdhCharalterrecordDto.getRecordsno());
		zdhCharalterrecordForm.setZdhCharalterrecordDto(zdhCharalterrecordDto);
		request.setAttribute("taskExplan", zdhCharalterrecordDto
				.getTaskexplanation());
		saveMessages(request, "message.save.success",
				new String[] { "系统图修改记录Dto" });
		return mapping.findForward("zdhCharalterrecorddetail");
	}
	/**
	 * 显示停电图
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward  showImg(ActionMapping mapping, ActionForm form,
			 HttpServletRequest request, HttpServletResponse response) throws IOException {
		    ZdhCharalterrecordForm zdhCharalterrecordForm = (ZdhCharalterrecordForm) form;
		    String primaryInfo = (String) request.getParameter("primaryInfo");
			String mainId = "";
		    //根椐外键取系统图数据集
			if (!StringUtils.isEmpty(primaryInfo)) {
				// recordno^string^95C5468FFFC44EF54197C6F9C8DC
				String primaryKey = "";
				String[] strArra = primaryInfo.split("\\^");
				if (strArra.length == 3) {
					primaryKey = strArra[2];
					mainId = primaryKey;
				}
			}	
			
			ZdhCharalterrecordDto zdhCharalterrecordDto = null;		
			
			zdhCharalterrecordDto = zdhCharalterrecordFacade.getZdhCharalterrecordById(mainId);
			zdhCharalterrecordForm.setZdhCharalterrecordDto(zdhCharalterrecordDto);
			request.setAttribute("zdhCharalterrecordDto", zdhCharalterrecordDto);
			return mapping.findForward("zdhCharalterrecordshowImg");
	
		
	}

	/**
	 * 转换业务状态
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
		String status 		= request.getParameter("status");
		String mainId 		= request.getParameter("mainId");
		String sendPerson 	= request.getParameter("sendPerson");
		String sendMessage 	= request.getParameter("sendMessage");
		String sendMobile 	= request.getParameter("sendMobile");

		ZdhCharalterrecordDto zdhCharalterrecordDto = null;
		if (!StringUtils.isEmpty(mainId)) {
			zdhCharalterrecordDto = zdhCharalterrecordFacade
					.getZdhCharalterrecordById(mainId);
		}

		String message = "操作失败";
		if (!StringUtils.isEmpty(status)) {
			if (!StringUtils.isEmpty(zdhCharalterrecordDto.getFstatus())) {
				int sign = 0;
				if (status.equalsIgnoreCase("executed")) {
					if(zdhCharalterrecordDto.getFstatus().equalsIgnoreCase(this.getStatus("new"))){
						sign = 1;
						message = "系统图同步完成!";
						zdhCharalterrecordDto
								.setFexcutestatus(this.getStatus("executed"));
					} else {
						message = "系统图同步失败,此状态不可同步";
					}
				}
				if (sign == 1) {
					zdhCharalterrecordFacade
							.addZdhCharalterrecord(zdhCharalterrecordDto);
				}
			}
		}
		return this.printResponseMes(request, response, mapping, "null",
				message);
	}

	/**
	 * 得到缺陷业务对象对应状态
	 * 
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
			} else if (str.equalsIgnoreCase("dispose")) {
				status = ZdhConstants.ZDH_DISPOSE;
			} else if (str.equalsIgnoreCase("executed")) {
				status = ZdhConstants.ZDH_EXECUTED;
			} else {
				status = ZdhConstants.ZDH_DRAFT;
			}
		}
		return status;
	}

	/*
	 * 交接班列表使用
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
			QueryListObj queryObj = zdhCharalterrecordFacade
					.getZdhCharalterrecordByHql(hqlSql, beginPage, pageSize,
							sumSql);
			dtolist = queryObj.getElemList();
			count = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"extZdhCharalterrecordgrid", xmlStr);
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
			QueryListObj qObj = zdhCharalterrecordFacade.getZdhCharalterrecordByHql(hqlSql, beginPage, pageSize,sumSql);
			dtolist = qObj.getElemList();
			count = qObj.getCount();
			sumInfo = qObj.getPropertySum();
		}
		ZdhCharalterrecord zdhCharalterrecord = (ZdhCharalterrecord)dtolist.get(0);

		return this.printResponseMes(request, response, mapping,
				"null", zdhCharalterrecord.getRecordsno()+"");
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
	public ActionForward workflowHandle(ActionMapping mapping,
										ActionForm form, 
										HttpServletRequest request,
										HttpServletResponse response) throws Exception {
		UserProfile userP = (UserProfile) (request.getSession()
				.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
		
		String userId = userP.getUserName();
		String roleId = "tuxing"; 
		
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
			switch(statusFlag){
			case 1://新建、修改，启动
				zdhCharalterrecordFacade.start(dto);
				break;
			case 2: //调度室领导签字
				zdhCharalterrecordFacade.zdhCharalterrecordSign(dto);
				break;
			case 3: //运维中心任务分配
				zdhCharalterrecordFacade.zdhCharalterrecordAssign(dto);
				break;
			case 4: //图形和数据会签处理
				zdhCharalterrecordFacade.zdhCharalterrecordCoursign(dto);
				break;			
			case 5: //调度审核
				zdhCharalterrecordFacade.zdhCharalterrecordApprove(dto);
				break;
			case 6: //盖执行章[系统图同步]
				zdhCharalterrecordFacade.zdhCharalterrecordExec(dto);
				break;						
			}
		}
		return mapping.findForward("");
	}
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	/**
	 * @business method list
	 * @遥测数据修改
	 * @关联批准书查询
	 * 
	 */
	// please add your business methods start
	// to do it
	// add your business method end
}
