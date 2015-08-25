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

import com.techstar.dmis.web.facade.StdLineFacade;
import com.techstar.dmis.web.form.StdLineForm;
import com.techstar.dmis.dto.StdLineDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class StdLineAction 
              extends BaseDispatchAction {
	private StdLineFacade stdLineFacade;
    private SysUiGridFacade sysUiGridFacade;
	public StdLineAction() {
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
		List list = stdLineFacade.listStdLine();
		request.getSession().setAttribute("StdLineList", list);

		// 记录操作日志
		//saveLog("StdLineer", "查询列表");
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
		StdLineForm stdLineForm = (StdLineForm) form;
		StdLineDto dto = stdLineForm.getStdLineDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getId())){
             dto.setId( new SequenceCreator().getUID() ); //生成内部序列号
        }
			stdLineFacade.addStdLine(dto);
		
		
		//saveLog("StdLineer", "增加记录");
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
		StdLineForm stdLineForm = (StdLineForm) form;
		String id= request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			StdLineDto dto = stdLineFacade.getStdLineById(id);
			stdLineForm.setStdLineDto(dto);
		}
		
		//saveLog("StdLineer", "初始化记录操作");
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
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			List list = stdLineFacade.deleteStdLine(id);
			request.getSession().setAttribute("StdLineList", list);
		}

		//saveLog("StdLineer", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setStdLineFacade(StdLineFacade stdLineFacade) {
		this.stdLineFacade = stdLineFacade;
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
		StdLineFacadeDto stdLineDto = new StdLineDto();
					//stdLineDto.setCustom_id("custom_id");
					//stdLineDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(stdLineDto);
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
//		gridObj.setBusName("StdLineDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("StdLine");
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
			QueryListObj queryObj = stdLineFacade.getStdLineByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"stdLinegrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward stdLinetoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>StdLine</id>      <name>线路</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("stdLinetoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward stdLinetab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("stdLinetab");
	     }
		   


     
  
  		
		public ActionForward stdLineframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("stdLineframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 StdLineForm stdLineForm = (StdLineForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		StdLineDto stdLineDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				stdLineDto = stdLineFacade.getStdLineById(mainId);
				stdLineDto.setVersion(0);
				//stdLineDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				stdLineDto = stdLineFacade.getStdLineById(mainId);
			} else {// 新增
				stdLineDto = new StdLineDto();
			}
		}
		stdLineForm.setStdLineDto(stdLineDto);
		   return mapping.findForward("stdLinedetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 StdLineForm  stdLineForm = ( StdLineForm) form;
		 StdLineDto  stdLineDto = stdLineForm.getStdLineDto();
		stdLineFacade.addStdLine(stdLineDto);
		stdLineDto = stdLineFacade.getStdLineById(stdLineDto.getId());
		stdLineForm.setStdLineDto(stdLineDto);
		saveMessages(request, "message.save.success", new String[] { "线路Dto" });
		return mapping.findForward("stdLinedetail");
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