package com.techstar.griddemo.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.techstar.framework.dao.model.QueryListObj;

import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.ui.web.facade.TagEngineFacade;
import com.techstar.framework.ui.web.tag.engine.BaseGridObj;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.griddemo.dto.SaleBillDto;
import com.techstar.griddemo.dto.SaleDetailDto;
import com.techstar.griddemo.web.facade.SaleBillFacade;
import com.techstar.griddemo.web.form.SaleBillForm;
import com.techstar.framework.utils.ConfigurationHelper;

public class BusinessActon extends BaseDispatchAction {
	private SysUiGridFacade sysUiGridFacade;
	private SaleBillFacade saleBillFacade;
    


	public BusinessActon() {

	}

	/**
	 * 初始化Frame（工具栏+Tab页）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("initFrame");
	}
	
	/**
	 * 初始化Tab页

	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initTab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("tab");
	}
	
	/**
	 * 初始化工具栏
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initToolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StringBuffer xmlData = new StringBuffer();
		xmlData.append("<Toobar>");
		xmlData.append("	<Business>");
		xmlData.append("		<id>commonQuery</id>");
		xmlData.append("		<name>业务名称</name>");
		xmlData.append("	</Business>");
		xmlData.append("	<ReportUrl>http://localhost:8888/framework/</ReportUrl>");
		xmlData.append("	<OperItem Text='操作名称1' ");
		xmlData.append("			  id='operation1' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述1'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("	<OperItem Text='操作名称2' ");
		xmlData.append("			  id='operation2' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述2'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("	<OperItem Text='操作名称3' ");
		xmlData.append("			  id='operation3' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述3'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("	<OperItem Text='操作名称4' ");
		xmlData.append("			  id='operation4' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述4'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("</Toobar>");

		request.setAttribute("xmlData", xmlData.toString());
		// TODO 增加业务方法列表
		return mapping.findForward("toolbar");
	}
	
	/**
	 * 初始化详情页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SaleBillForm saleBillForm = (SaleBillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		SaleBillDto saleBillDto = null;
		if (!StringUtils.isEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (!StringUtils.isEmpty(mainId)) {
				saleBillDto = saleBillFacade.getSaleBillById(mainId);
				saleBillDto.setVersion(0);
				saleBillDto.setId(null);
			}
		} else {
			if (!StringUtils.isEmpty(mainId)) {// 修改
				saleBillDto = saleBillFacade.getSaleBillById(mainId);
			} else {// 新增getSaleBillById
				saleBillDto = new SaleBillDto();
			}
		}
		saleBillForm.setSaleBillDto(saleBillDto);
		return mapping.findForward("detail");
	}
	
	/**
	 * 初始化主卡片子表页面

	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initMainCardChildGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SaleBillForm saleBillForm = (SaleBillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		SaleBillDto saleBillDto = null;
		if (!StringUtils.isEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (!StringUtils.isEmpty(mainId)) {
				saleBillDto = saleBillFacade.getSaleBillById(mainId);
				saleBillDto.setVersion(0);
				saleBillDto.setId(null);
			}
		} else {
			if (!StringUtils.isEmpty(mainId)) {// 修改
				saleBillDto = saleBillFacade.getSaleBillById(mainId);
			} else {// 新增getSaleBillById
				saleBillDto = new SaleBillDto();
			}
		}
		saleBillForm.setSaleBillDto(saleBillDto);
		return mapping.findForward("mainCardChildGrid");
	}
	
	/**
	 * 初始化主表子卡片页面

	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initMainGridChildCard(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SaleBillForm saleBillForm = (SaleBillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		SaleBillDto saleBillDto = null;
		if (!StringUtils.isEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {// 复制
			if (!StringUtils.isEmpty(mainId)) {
				saleBillDto = saleBillFacade.getSaleBillById(mainId);
				saleBillDto.setVersion(0);
				saleBillDto.setId(null);
			}
		} else {
			if (!StringUtils.isEmpty(mainId)) {// 修改
				saleBillDto = saleBillFacade.getSaleBillById(mainId);
			} else {// 新增getSaleBillById
				saleBillDto = new SaleBillDto();
			}
		}
		saleBillForm.setSaleBillDto(saleBillDto);
		return mapping.findForward("mainGridChildCard");
	}
	
	/**
	 * 初始化列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// request.setAttribute("message","222222222222222");
		return mapping.findForward("grid");
	}

	/**
	 * 作用:普通列表Action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//由业务自行定义的
		String hqlStr = ""; 	//业务HQL
		String userId = "user"; //用户ID

		//取到表格的信息
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
		
		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();
		
		/*
		List dtolist = new ArrayList();
		SaleBillDto billDto = new SaleBillDto();
					billDto.setCustom_id("custom_id");
					billDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(billDto);
		}
		int count = dtolist.size();
		List sumInfo = new ArrayList();
		*/
		
		/**
		 *  表格控件基础对象
		 */
		BaseGridObj gridObj = new BaseGridObj();
		gridObj.setId("mygrid");
		gridObj.setPageId("page");
		gridObj.setDivHeight("400");
		gridObj.setBusName("SaleBillDto");
		gridObj.setSubName("general");
		gridObj.setPageItems("4");
		gridObj.setListType("3");
		gridObj.setListKind("101");
		gridObj.setFilterMode("2");
		gridObj.setEntityName("SaleBill");
		gridObj.setIsFilterRow("1");
		gridObj.setIsTotalRow("1");
		gridObj.setColumnMove("custom_id,custom_name");
		gridObj.setIsTotal("total");
		gridObj.setListBox("cre_date#7^,custom_id#1^type=zzmm@@@parentId=,custom_name#2^src=SQDW,sale_mode#2^src=SQDW");
		gridObj.setQueryPath("/ui.do?method=query");
		gridObj.setIsDisplaySet("1");
		gridObj.setIsQuerySet("1");
		gridObj.setIsOutputSet("1");
		gridObj.setIsStatSet("1");
		gridObj.setIsPageSet("1");
		request.setAttribute("gridObj",gridObj);
		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = saleBillFacade.getSaleBillByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"grid",xmlStr);
	}
	
	/**
	 * 作用:普通列表Action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward childGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			//由业务自行定义的
			String hqlStr = ""; //业务HQL
			String userId = "user"; //用户ID

			//取到表格的信息
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			
			String hqlSql = gridInfo.getHqlSql();
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();
			String sumSql = gridInfo.getSumSql();
			System.out.println("#############:"+sumSql);
			Map params = gridInfo.getGridPersonalInfo();
			
			
			sumSql = "";
			beginPage = 1;
			pageSize = 50;
			List dtolist = new ArrayList();
		//接收客户端参数,解析生成HQL子句
		//调用服务器端方法生成DTO
			String saleDetailId = "1";
			if(StringUtils.isEmpty(saleDetailId)){
				if(!StringUtils.isEmpty(hqlSql)){
					QueryListObj queryObj = saleBillFacade.getSaleDetailByHql(hqlSql, beginPage, pageSize, sumSql);
					dtolist = queryObj.getElemList();
				}
			} else {
				SaleDetailDto dto = (SaleDetailDto)saleBillFacade.loadSaleDetail(saleDetailId);
				dtolist.add(dto);
			}
			
			
			
		//此处需要将是否过滤和操作列等信息重新整理

		//同时需要加入统计行信息的处理
		List sumInfo = new ArrayList();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), 50, sumInfo);
		
		return this.printResponseMes(request,response,mapping,"null",xmlStr);
	}
	
	/**
	 * 作用:普通列表Action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward mainGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			//由业务自行定义的
			String hqlStr = ""; //业务HQL
			String userId = "user"; //用户ID


			//取到表格的信息
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			
			String hqlSql = gridInfo.getHqlSql();
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();
			String sumSql = gridInfo.getSumSql();
			System.out.println("#############:"+sumSql);
			Map params = gridInfo.getGridPersonalInfo();
			
			
			sumSql = "";
		//接收客户端参数,解析生成HQL子句
		//调用服务器端方法生成DTO
		
			QueryListObj queryObj = saleBillFacade.getSaleBillByHql(hqlSql, beginPage, pageSize, sumSql);
			
			List dtolist = queryObj.getElemList();
		//此处需要将是否过滤和操作列等信息重新整理

		//同时需要加入统计行信息的处理
		//List sumInfo = new ArrayList();
		//Map tempMap = new HashMap();
		//tempMap.put("", "");
		//sumInfo.add(tempMap);
		List sumInfo = new ArrayList();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), 50, sumInfo);
		
		return this.printResponseMes(request,response,mapping,"null",xmlStr);

	}
	
	/**
	 * 作用:普通列表Action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward simpleGridOfTwoGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			//由业务自行定义的
			String hqlStr = ""; //业务HQL
			String userId = "user"; //用户ID


			//取到表格的信息
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			
			String hqlSql = gridInfo.getHqlSql();
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();
			String sumSql = gridInfo.getSumSql();
			System.out.println("#############:"+sumSql);
			Map params = gridInfo.getGridPersonalInfo();
			
			
			
		//接收客户端参数,解析生成HQL子句
		//调用服务器端方法生成DTO
		
		QueryListObj queryObj = saleBillFacade.getSaleBillByHql(hqlSql, beginPage, pageSize, sumSql);
			
		List dtolist = queryObj.getElemList();
		//此处需要将是否过滤和操作列等信息重新整理

		//同时需要加入统计行信息的处理
		//List sumInfo = new ArrayList();
		//Map tempMap = new HashMap();
		//tempMap.put("", "");
		//sumInfo.add(tempMap);
		List sumInfo = new ArrayList();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), 50, sumInfo);
		
		return this.printResponseMes(request,response,mapping,"null",xmlStr);
	}
	
	/**
	 * 作用:普通列表Action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateGridOfTwoGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

				//由业务自行定义的
				String hqlStr = ""; //业务HQL
				String userId = "user123"; //用户ID
				
				System.out.println("#########"+request.getParameter("wheres"));
				String wheres = request.getParameter("wheres");
				String parentId = "";
				if(!StringUtils.isEmpty(wheres)){
					if(wheres.indexOf("^") != -1){
						String[] arra = wheres.split("\\^");
						System.out.println(arra.length);
						parentId = arra[3];
					}
				}
				
				//取到表格的信息			
				GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
				
				String hqlSql = gridInfo.getHqlSql();
				int beginPage = gridInfo.getBeginPage();
				int pageSize = gridInfo.getPageSize();
				String sumSql = gridInfo.getSumSql();
				Map params = gridInfo.getGridPersonalInfo();
				/*
				sumSql = "";	
				List dtolist = new ArrayList();
				QueryListObj queryObj = saleBillFacade.getSaleDetailByHql(hqlSql, beginPage, pageSize, sumSql);
				dtolist = queryObj.getElemList();
				*/
				
				hqlSql = "FROM SaleDetail t where t.salebill.id='"+parentId+"'";
				QueryListObj queryObj = saleBillFacade.getSaleDetailByHql(hqlSql, 1, 100, "");
				List dtolist = queryObj.getElemList();
				
				List sumInfo = new ArrayList();
				
				String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), 50, sumInfo);
				
				return this.printResponseMes(request,response,mapping,"null",xmlStr);
	}

	/**
	 * 保存详情页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SaleBillForm saleBillForm = (SaleBillForm) form;
		SaleBillDto saleBillDto = saleBillForm.getSaleBillDto();
		saleBillFacade.saveOrUpdateSaleBill(saleBillDto);
		saleBillDto = saleBillFacade.getSaleBillById(saleBillDto.getId());
		saleBillForm.setSaleBillDto(saleBillDto);
		saveMessages(request, "message.save.success", new String[] { "主列表" });
		return mapping.findForward("detail");
	}
	
	/**
	 * 保存详情页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveMainCard(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SaleBillForm saleBillForm = (SaleBillForm) form;
		SaleBillDto saleBillDto = saleBillForm.getSaleBillDto();
		saleBillFacade.saveOrUpdateSaleBill(saleBillDto);
		saleBillDto = saleBillFacade.getSaleBillById(saleBillDto.getId());
		saleBillForm.setSaleBillDto(saleBillDto);
		saveMessages(request, "message.save.success", new String[] { "主卡片" });
		return mapping.findForward("mainCardChildGrid");
	}
	
	/**
	 * 保存详情页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveChildCard(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		SaleDetailForm saleDetailForm = (SaleDetailForm) form;
		SaleDetailDto saleDetailDto = saleDetailForm.getSaleDetailDto();
		saleBillFacade.saveOrUpdateSaleDetail(saleDetailDto);
		saleDetailDto = saleBillFacade.getSaleDetailById(saleDetailDto.getId());
		saleDetailForm.setSaleDetailDto(saleDetailDto);	
		*/
		SaleBillForm saleBillForm = (SaleBillForm) form;
		SaleBillDto saleBillDto = saleBillForm.getSaleBillDto();
		saleBillFacade.saveOrUpdateSaleBill(saleBillDto);
		saleBillDto = saleBillFacade.getSaleBillById(saleBillDto.getId());
		saleBillForm.setSaleBillDto(saleBillDto);
		saveMessages(request, "message.save.success", new String[] { "子卡片" });
		return mapping.findForward("mainGridChildCard");
	}

	
	/**
	 * 保存子表信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward saveChildGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		try{
			String head = request.getParameter("head");
			String dates = request.getParameter("dates");
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(head);
			System.out.println(dates);
			File[] files = ConfigurationHelper.getGridDisFile();
			String classPath  = "";
			if(files.length > 0){
				String path = files[0].getParent();
				classPath  += path+"\\"+"SaleDetail"+".xml";
			}
			//return classPath;
			TagEngineFacade engine = new TagEngineFacade();
			String filePath = classPath;
			SaleDetailDto detaildto = new SaleDetailDto();
			//detaildto.setSaleBillDto(new SaleBillDto());
			List list = engine.getDtoList(head, dates,detaildto,filePath);
			for(int i=0;i<list.size();i++){
				SaleDetailDto dto = (SaleDetailDto)list.get(i);
				System.out.println("billDtoId="+dto.getSaleBillDto().getId());
				System.out.println("detaildto="+dto.getPrint_no());
				
			}
			saleBillFacade.saveOrUpdateSaleDetails(list);
			response.getWriter().println("1");
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().println("0");
		}
				
		return null;
	}
	
		
		/**
	 * 作用:普通列表Action
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward detailchildGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			//由业务自行定义的
			String hqlStr = ""; //业务HQL
			String userId = "user"; //用户ID
            String parentid = request.getParameter("parentid");
            System.out.println();
			//取到表格的信息

			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			
			String hqlSql = gridInfo.getHqlSql();
			System.out.println("hqlSql="+hqlSql);
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();
			String sumSql = gridInfo.getSumSql();
			System.out.println("#############:"+sumSql);
			Map params = gridInfo.getGridPersonalInfo();
			
			
			sumSql = "";
			beginPage = 1;
			pageSize = 50;
			List dtolist = new ArrayList();
		//接收客户端参数,解析生成HQL子句
		//调用服务器端方法生成DTO
			//String saleDetailId = "FROM SaleDetail t where t.salebill.id='1'";
			hqlSql = "FROM SaleDetail t where t.salebill.id='"+parentid+"'";
			QueryListObj queryObj = saleBillFacade.getSaleDetailByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			/*if(StringUtils.isEmpty(saleDetailId)){
				QueryListObj queryObj = saleBillFacade.getSaleDetailByHql(hqlSql, beginPage, pageSize, sumSql);
				dtolist = queryObj.getElemList();
			} else {
				SaleDetailDto dto = (SaleDetailDto)saleBillFacade.loadSaleDetail(saleDetailId);
				dtolist.add(dto);
			}*/
			
			
			
		//此处需要将是否过滤和操作列等信息重新整理


		//同时需要加入统计行信息的处理

		List sumInfo = new ArrayList();

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), 50, sumInfo);
		
		return this.printResponseMes(request,response,mapping,"null",xmlStr);
	}
	
		
		

	
	
	public ActionForward deleteChildGrid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		try{
			String ids = request.getParameter("ids");
	
			response.setContentType("text/xml;charset=utf-8");
			System.out.println(ids);
			String[] idds = ids.split(";");
		    this.saleBillFacade.deleteSaleDetails(idds);
			response.getWriter().println("1");
		}catch(Exception e){
			e.printStackTrace();
			response.getWriter().println("0");
		}
		
		return null;
	}
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	public void setSaleBillFacade(SaleBillFacade saleBillFacade) {
		this.saleBillFacade = saleBillFacade;
	}
}
