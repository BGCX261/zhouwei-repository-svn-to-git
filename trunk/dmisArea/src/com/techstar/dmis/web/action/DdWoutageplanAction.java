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

import com.techstar.dmis.web.facade.DdWoutageplanFacade;
import com.techstar.dmis.web.form.DdWoutageplanForm;
import com.techstar.dmis.dto.DdWoutageplanDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class DdWoutageplanAction 
              extends BaseDispatchAction {
	private DdWoutageplanFacade ddWoutageplanFacade;
    private SysUiGridFacade sysUiGridFacade;
	public DdWoutageplanAction() {
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
		//  查询列表
		List list = ddWoutageplanFacade.listDdWoutageplan();
		request.getSession().setAttribute("DdWoutageplanList", list);

		// 记录操作日志
		//saveLog("DdWoutageplaner", "查询列表");
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
		DdWoutageplanForm ddWoutageplanForm = (DdWoutageplanForm) form;
		DdWoutageplanDto dto = ddWoutageplanForm.getDdWoutageplanDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFwplanno())){
             dto.setFwplanno( new SequenceCreator().getUID() ); //生成内部序列号
        }
			ddWoutageplanFacade.addDdWoutageplan(dto);
		
		
		//saveLog("DdWoutageplaner", "增加记录");
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
		DdWoutageplanForm ddWoutageplanForm = (DdWoutageplanForm) form;
		String fwplanno= request.getParameter("fwplanno");
		if (StringUtils.isNotEmpty(fwplanno)) {
			DdWoutageplanDto dto = ddWoutageplanFacade.getDdWoutageplanById(fwplanno);
			ddWoutageplanForm.setDdWoutageplanDto(dto);
		}
		
		//saveLog("DdWoutageplaner", "初始化记录操作");
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
		String fwplanno = request.getParameter("fwplanno");
		if (StringUtils.isNotEmpty(fwplanno)) {
			List list = ddWoutageplanFacade.deleteDdWoutageplan(fwplanno);
			request.getSession().setAttribute("DdWoutageplanList", list);
		}

		//saveLog("DdWoutageplaner", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setDdWoutageplanFacade(DdWoutageplanFacade ddWoutageplanFacade) {
		this.ddWoutageplanFacade = ddWoutageplanFacade;
	}
    
		

		

	
	//noEditGrid editGrid tab toolbar detail
 			
		
			//初始化表格
	  public ActionForward standGridQuery(ActionMapping mapping, ActionForm form,
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
		DdWoutageplanFacadeDto ddWoutageplanDto = new DdWoutageplanDto();
					//ddWoutageplanDto.setCustom_id("custom_id");
					//ddWoutageplanDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ddWoutageplanDto);
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
//		gridObj.setBusName("DdWoutageplanDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("DdWoutageplan");
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
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = ddWoutageplanFacade.getDdWoutageplanByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ddWoutageplangrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ddWoutageplantoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>DdWoutageplan</id>      <name>旬停电计划</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ddWoutageplantoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ddWoutageplantab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddWoutageplantab");
	     }
		   


     
  
  		
		public ActionForward ddWoutageplanframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddWoutageplanframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdWoutageplanForm ddWoutageplanForm = (DdWoutageplanForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdWoutageplanDto ddWoutageplanDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddWoutageplanDto = ddWoutageplanFacade.getDdWoutageplanById(mainId);
				ddWoutageplanDto.setVersion(0);
				//ddWoutageplanDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddWoutageplanDto = ddWoutageplanFacade.getDdWoutageplanById(mainId);
			} else {// 新增
				ddWoutageplanDto = new DdWoutageplanDto();
			}
		}
		ddWoutageplanForm.setDdWoutageplanDto(ddWoutageplanDto);
		   return mapping.findForward("ddWoutageplandetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdWoutageplanForm  ddWoutageplanForm = ( DdWoutageplanForm) form;
		 DdWoutageplanDto  ddWoutageplanDto = ddWoutageplanForm.getDdWoutageplanDto();
		ddWoutageplanFacade.addDdWoutageplan(ddWoutageplanDto);
		ddWoutageplanDto = ddWoutageplanFacade.getDdWoutageplanById(ddWoutageplanDto.getFwplanno());
		ddWoutageplanForm.setDdWoutageplanDto(ddWoutageplanDto);
		saveMessages(request, "message.save.success", new String[] { "旬停电计划Dto" });
		return mapping.findForward("ddWoutageplandetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
