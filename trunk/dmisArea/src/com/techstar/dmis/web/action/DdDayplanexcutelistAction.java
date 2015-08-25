package com.techstar.dmis.web.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import com.techstar.dmis.web.facade.DdDayplanexcutelistFacade;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;

public class DdDayplanexcutelistAction extends BaseDispatchAction {

	 private SysUiGridFacade sysUiGridFacade;
	 private DdDayplanexcutelistFacade executefacade;

	public void setExecutefacade(DdDayplanexcutelistFacade executefacade) {
		this.executefacade = executefacade;
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	
	public ActionForward initGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
//		由业务自行定义的
		String parentid = request.getParameter("parentid");
		String hqlStr = "select * from DdDayplanexcutelist a where a.dddoutageplan0.DdDoutageplan.fdayplanno='"+parentid+"'"; 	//业务HQL
		UserProfile userP = (UserProfile) (request.getSession()
				.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
		String userId = userP.getUserName();//用户ID

		//取到表格的信息


		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
		
		//String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();
		
		/*
		List dtolist = new ArrayList();
		BhActionrecordFacadeDto bhActionrecordDto = new BhActionrecordDto();
					//bhActionrecordDto.setCustom_id("custom_id");
					//bhActionrecordDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(bhActionrecordDto);
		}
		int count = dtolist.size();
		List sumInfo = new ArrayList();
		*/
		
		/**
		 *  表格控件基础对象
		 */
//		BaseGridObj gridObj = new BaseGridObj();
//		gridObj.setId("mygrid");
//		gridObj.setPageId("page");
//		gridObj.setDivHeight("400");
//		gridObj.setBusName("BhActionrecordDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("BhActionrecord");
//		gridObj.setIsFilterRow("1");
//		gridObj.setIsTotalRow("1");
//		gridObj.setColumnMove("custom_id,custom_name");
//		gridObj.setIsTotal("total");
//		gridObj.setListBox("cre_date#7^,custom_id#1^type=zzmm@@@parentId=,custom_name#2^src=SQDW,sale_mode#2^src=SQDW");
//		gridObj.setQueryPath("/ui.do?method=query");
//		gridObj.setIsDisplaySet("1");
//		gridObj.setIsQuerySet("1");
//		gridObj.setIsOutputSet("1");
//		gridObj.setIsStatSet("1");
//		gridObj.setIsPageSet("1");
//		request.setAttribute("gridObj",gridObj);
		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlStr)){
			QueryListObj queryObj = executefacade.listDdDayplanexcutelistByHql(hqlStr);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			//sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,null,xmlStr);
	}
	 
	 
}
