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

import com.techstar.dmis.web.facade.GgRelpersonFacade;
import com.techstar.dmis.web.form.GgRelpersonForm;
import com.techstar.dmis.dto.GgRelpersonDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class GgRelpersonAction 
              extends BaseDispatchAction {
	private GgRelpersonFacade ggRelpersonFacade;
    private SysUiGridFacade sysUiGridFacade;
	public GgRelpersonAction() {
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
		List list = ggRelpersonFacade.listGgRelperson();
		request.getSession().setAttribute("GgRelpersonList", list);

		// 记录操作日志
		//saveLog("GgRelpersoner", "查询列表");
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
		GgRelpersonForm ggRelpersonForm = (GgRelpersonForm) form;
		GgRelpersonDto dto = ggRelpersonForm.getGgRelpersonDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getId())){
             dto.setId( new SequenceCreator().getUID() ); //生成内部序列号
        }
			ggRelpersonFacade.addGgRelperson(dto);
		
		
		//saveLog("GgRelpersoner", "增加记录");
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
		GgRelpersonForm ggRelpersonForm = (GgRelpersonForm) form;
		String id= request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			GgRelpersonDto dto = ggRelpersonFacade.getGgRelpersonById(id);
			ggRelpersonForm.setGgRelpersonDto(dto);
		}
		
		//saveLog("GgRelpersoner", "初始化记录操作");
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
			List list = ggRelpersonFacade.deleteGgRelperson(id);
			request.getSession().setAttribute("GgRelpersonList", list);
		}

		//saveLog("GgRelpersoner", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setGgRelpersonFacade(GgRelpersonFacade ggRelpersonFacade) {
		this.ggRelpersonFacade = ggRelpersonFacade;
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
		GgRelpersonFacadeDto ggRelpersonDto = new GgRelpersonDto();
					//ggRelpersonDto.setCustom_id("custom_id");
					//ggRelpersonDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ggRelpersonDto);
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
//		gridObj.setBusName("GgRelpersonDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("GgRelperson");
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
			QueryListObj queryObj = ggRelpersonFacade.getGgRelpersonByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ggRelpersongrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ggRelpersontoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>GgRelperson</id>      <name>外部人员</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ggRelpersontoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ggRelpersontab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ggRelpersontab");
	     }
		   


     
  
  		
		public ActionForward ggRelpersonframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ggRelpersonframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
	
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 GgRelpersonForm ggRelpersonForm = (GgRelpersonForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		GgRelpersonDto ggRelpersonDto = null;
		
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ggRelpersonDto = ggRelpersonFacade.getGgRelpersonById(mainId);
				ggRelpersonDto.setVersion(0);
				//ggRelpersonDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ggRelpersonDto = ggRelpersonFacade.getGgRelpersonById(mainId);
			} else {// 新增
				ggRelpersonDto = new GgRelpersonDto();
			}
		}
		ggRelpersonForm.setGgRelpersonDto(ggRelpersonDto);
		   return mapping.findForward("ggRelpersondetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GgRelpersonForm  ggRelpersonForm = ( GgRelpersonForm) form;
		GgRelpersonDto  ggRelpersonDto = ggRelpersonForm.getGgRelpersonDto();
		ggRelpersonFacade.addGgRelperson(ggRelpersonDto);
		ggRelpersonDto = ggRelpersonFacade.getGgRelpersonById(ggRelpersonDto.getId());
		ggRelpersonForm.setGgRelpersonDto(ggRelpersonDto);
		saveMessages(request, "message.save.success", new String[] { "外部人员Dto" });
		return mapping.findForward("ggRelpersondetail");
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
