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

import com.techstar.dmis.web.facade.DdDayondutylogFacade;
import com.techstar.dmis.web.form.DdDayondutylogForm;
import com.techstar.dmis.dto.DdDayondutylogDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class DdDayondutylogAction 
              extends BaseDispatchAction {
	private DdDayondutylogFacade ddDayondutylogFacade;
    private SysUiGridFacade sysUiGridFacade;
	public DdDayondutylogAction() {
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
		List list = ddDayondutylogFacade.listDdDayondutylog();
		request.getSession().setAttribute("DdDayondutylogList", list);

		// 记录操作日志
		//saveLog("DdDayondutyloger", "查询列表");
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
		DdDayondutylogForm ddDayondutylogForm = (DdDayondutylogForm) form;
		DdDayondutylogDto dto = ddDayondutylogForm.getDdDayondutylogDto();
	    
		//附件处理
									
		FormFile content = ddDayondutylogForm.getContent();
		if( content != null ){
	        	dto.setContent( content.getFileData() );
		  }
	    
						//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFondutyid())){
             dto.setFondutyid( new SequenceCreator().getUID() ); //生成内部序列号
        }
			ddDayondutylogFacade.addDdDayondutylog(dto);
		
		
		//saveLog("DdDayondutyloger", "增加记录");
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
		DdDayondutylogForm ddDayondutylogForm = (DdDayondutylogForm) form;
		String fondutyid= request.getParameter("fondutyid");
		if (StringUtils.isNotEmpty(fondutyid)) {
			DdDayondutylogDto dto = ddDayondutylogFacade.getDdDayondutylogById(fondutyid);
			ddDayondutylogForm.setDdDayondutylogDto(dto);
		}
		
		//saveLog("DdDayondutyloger", "初始化记录操作");
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
		String fondutyid = request.getParameter("fondutyid");
		if (StringUtils.isNotEmpty(fondutyid)) {
			List list = ddDayondutylogFacade.deleteDdDayondutylog(fondutyid);
			request.getSession().setAttribute("DdDayondutylogList", list);
		}

		//saveLog("DdDayondutyloger", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setDdDayondutylogFacade(DdDayondutylogFacade ddDayondutylogFacade) {
		this.ddDayondutylogFacade = ddDayondutylogFacade;
	}
    
			
			//提供对大字段文件下载的方法		
	public ActionForward download_content(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fondutyid = request.getParameter("fondutyid");
		DdDayondutylogDto dto = ddDayondutylogFacade.getDdDayondutylogById(fondutyid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getContent());
		os.flush();
		return null;
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
		DdDayondutylogFacadeDto ddDayondutylogDto = new DdDayondutylogDto();
					//ddDayondutylogDto.setCustom_id("custom_id");
					//ddDayondutylogDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ddDayondutylogDto);
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
//		gridObj.setBusName("DdDayondutylogDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("DdDayondutylog");
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
			QueryListObj queryObj = ddDayondutylogFacade.getDdDayondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ddDayondutyloggrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ddDayondutylogtoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>DdDayondutylog</id>      <name>调度日志</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ddDayondutylogtoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ddDayondutylogtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddDayondutylogtab");
	     }
		   


     
  
  		
		public ActionForward ddDayondutylogframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddDayondutylogframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdDayondutylogForm ddDayondutylogForm = (DdDayondutylogForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdDayondutylogDto ddDayondutylogDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddDayondutylogDto = ddDayondutylogFacade.getDdDayondutylogById(mainId);
				ddDayondutylogDto.setVersion(0);
				//ddDayondutylogDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddDayondutylogDto = ddDayondutylogFacade.getDdDayondutylogById(mainId);
			} else {// 新增
				ddDayondutylogDto = new DdDayondutylogDto();
			}
		}
		ddDayondutylogForm.setDdDayondutylogDto(ddDayondutylogDto);
		   return mapping.findForward("ddDayondutylogdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdDayondutylogForm  ddDayondutylogForm = ( DdDayondutylogForm) form;
		 DdDayondutylogDto  ddDayondutylogDto = ddDayondutylogForm.getDdDayondutylogDto();
		ddDayondutylogFacade.addDdDayondutylog(ddDayondutylogDto);
		ddDayondutylogDto = ddDayondutylogFacade.getDdDayondutylogById(ddDayondutylogDto.getFondutyid());
		ddDayondutylogForm.setDdDayondutylogDto(ddDayondutylogDto);
		saveMessages(request, "message.save.success", new String[] { "调度日志Dto" });
		return mapping.findForward("ddDayondutylogdetail");
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
