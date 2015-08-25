package com.techstar.dmis.web.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.web.facade.TodolistFacade;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.web.action.BaseDispatchAction;

public class TodolistAction extends BaseDispatchAction {

	private TodolistFacade todolistFacade;

	private SysUiGridFacade sysUiGridFacade;

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setTodolistFacade(TodolistFacade todolistFacade) {
		this.todolistFacade = todolistFacade;
	}

	public ActionForward workflowTodolistGrid(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = BusinessDetailHelper.getBusDetailInfo(request).getUserId(); // 用户ID

		// 取到表格的信息
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
				userId);

		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		int count = 0;

		String objName = request.getParameter("objName");
		dtolist = todolistFacade.getWorkflowTodolist(objName,userId);
		count = dtolist.size();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"todolistGrid", xmlStr);

	}
	
	public ActionForward handleHistoryGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 由业务自行定义的
		String hqlStr = ""; // 业务HQL
		String userId = BusinessDetailHelper.getBusDetailInfo(request).getUserId(); // 用户ID

		String businessId = request.getParameter("busId");
		// businessId = "6A8E157AFFFC440210765E5D1620D3B";
		// 取到表格的信息
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,userId);

		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		int count = 0;

		QueryListObj queryObj = todolistFacade.listHandleHistorys(businessId);
		dtolist = queryObj.getElemList();
		count = dtolist.size();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
				.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(),
				gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request, response, mapping,
				"handlehistoryGrid", xmlStr);
	}
	
	public ActionForward transitionLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String taskInstanceId = request.getParameter("taskInstanceId");
		//taskInstanceId ="19657";
		String xml = this.todolistFacade.retrieveByteArraysOfGpd(Long.parseLong(taskInstanceId));
			
		response.setContentType("image/svg+xml;charset=UTF-8");
	    PrintWriter out = response.getWriter(); 
	    out.print(xml);

		return mapping.findForward("svg");
	}

}
