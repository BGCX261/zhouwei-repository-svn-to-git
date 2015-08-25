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

import com.techstar.dmis.web.facade.FsApprovebookFacade;
import com.techstar.dmis.web.form.FsApprovebookForm;
import com.techstar.dmis.dto.FsApprovebookDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class FsApprovebookAction 
              extends BaseDispatchAction {
	private FsApprovebookFacade fsApprovebookFacade;
    private SysUiGridFacade sysUiGridFacade;
	public FsApprovebookAction() {
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
		List list = fsApprovebookFacade.listFsApprovebook();
		request.getSession().setAttribute("FsApprovebookList", list);

		// 记录操作日志
		//saveLog("FsApprovebooker", "查询列表");
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
		FsApprovebookForm fsApprovebookForm = (FsApprovebookForm) form;
		FsApprovebookDto dto = fsApprovebookForm.getFsApprovebookDto();
	    
		//附件处理
									
		FormFile feqpcontent = fsApprovebookForm.getFeqpcontent();
		if( feqpcontent != null ){
	        	dto.setFeqpcontent( feqpcontent.getFileData() );
		  }
	    
						//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFapprovcomputerno())){
             dto.setFapprovcomputerno( new SequenceCreator().getUID() ); //生成内部序列号
        }
			fsApprovebookFacade.addFsApprovebook(dto);
		
		
		//saveLog("FsApprovebooker", "增加记录");
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
		FsApprovebookForm fsApprovebookForm = (FsApprovebookForm) form;
		String fapprovcomputerno= request.getParameter("fapprovcomputerno");
		if (StringUtils.isNotEmpty(fapprovcomputerno)) {
			FsApprovebookDto dto = fsApprovebookFacade.getFsApprovebookById(fapprovcomputerno);
			fsApprovebookForm.setFsApprovebookDto(dto);
		}
		
		//saveLog("FsApprovebooker", "初始化记录操作");
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
		String fapprovcomputerno = request.getParameter("fapprovcomputerno");
		if (StringUtils.isNotEmpty(fapprovcomputerno)) {
			List list = fsApprovebookFacade.deleteFsApprovebook(fapprovcomputerno);
			request.getSession().setAttribute("FsApprovebookList", list);
		}

		//saveLog("FsApprovebooker", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setFsApprovebookFacade(FsApprovebookFacade fsApprovebookFacade) {
		this.fsApprovebookFacade = fsApprovebookFacade;
	}
    
			
			//提供对大字段文件下载的方法		
	public ActionForward download_feqpcontent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapprovcomputerno = request.getParameter("fapprovcomputerno");
		FsApprovebookDto dto = fsApprovebookFacade.getFsApprovebookById(fapprovcomputerno);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFeqpcontent());
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
		FsApprovebookFacadeDto fsApprovebookDto = new FsApprovebookDto();
					//fsApprovebookDto.setCustom_id("custom_id");
					//fsApprovebookDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(fsApprovebookDto);
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
//		gridObj.setBusName("FsApprovebookDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("FsApprovebook");
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
			QueryListObj queryObj = fsApprovebookFacade.getFsApprovebookByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"fsApprovebookgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
			//初始化表格
	  public ActionForward standGridQuery1(ActionMapping mapping, ActionForm form,
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
		FsApprovebookFacadeDto fsApprovebookDto = new FsApprovebookDto();
					//fsApprovebookDto.setCustom_id("custom_id");
					//fsApprovebookDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(fsApprovebookDto);
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
//		gridObj.setBusName("FsApprovebookDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("FsApprovebook");
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
			QueryListObj queryObj = fsApprovebookFacade.getFsApprovebookByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"fsApprovebookgrid1",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward fsApprovebooktoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>FsApprovebook</id>      <name>发电批准书</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='拟定操作票' id='DD_switchseqBilleditor' href='#' title=''></OperItem>   <OperItem Text='自投规程导入' id='asregulationIn' href='#' title=''></OperItem>   <OperItem Text='发电批准书发布' id='ApproveBookFile' href='#' title=''></OperItem>   <OperItem Text='定值单导入' id='FixvalueIn' href='#' title=''></OperItem>   <OperItem Text='发电批准书执行' id='ApproveBookExcute' href='#' title=''></OperItem>   <OperItem Text='发电批准书上报' id='Approve' href='#' title=''></OperItem>   <OperItem Text='设备参数上报' id='EQPPara' href='#' title=''></OperItem>   <OperItem Text='批准书归档' id='FS_ApproveBookFile' href='#' title=''></OperItem>   <OperItem Text='电网实时方式分析单' id='ddrealtimemodeanalyse1' href='#' title=''></OperItem>   <OperItem Text='编制系统图改图任务单' id='systemchartalter' href='#' title=''></OperItem></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("fsApprovebooktoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward fsApprovebooktab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsApprovebooktab");
	     }
		   


     
  
  		
		public ActionForward fsApprovebookframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("fsApprovebookframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 FsApprovebookForm fsApprovebookForm = (FsApprovebookForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		FsApprovebookDto fsApprovebookDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				fsApprovebookDto = fsApprovebookFacade.getFsApprovebookById(mainId);
				fsApprovebookDto.setVersion(0);
				//fsApprovebookDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				fsApprovebookDto = fsApprovebookFacade.getFsApprovebookById(mainId);
			} else {// 新增
				fsApprovebookDto = new FsApprovebookDto();
			}
		}
		fsApprovebookForm.setFsApprovebookDto(fsApprovebookDto);
		   return mapping.findForward("fsApprovebookdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 FsApprovebookForm  fsApprovebookForm = ( FsApprovebookForm) form;
		 FsApprovebookDto  fsApprovebookDto = fsApprovebookForm.getFsApprovebookDto();
		fsApprovebookFacade.addFsApprovebook(fsApprovebookDto);
		fsApprovebookDto = fsApprovebookFacade.getFsApprovebookById(fsApprovebookDto.getFapprovcomputerno());
		fsApprovebookForm.setFsApprovebookDto(fsApprovebookDto);
		saveMessages(request, "message.save.success", new String[] { "发电批准书Dto" });
		return mapping.findForward("fsApprovebookdetail");
	}
	 	
	   
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsApprovebookdetail1");
	}
	     public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("fsApprovebookdetail1");
	}
       
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail2(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsApprovebookdetail2");
	}
	     public ActionForward saveDetail2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("fsApprovebookdetail2");
	}
       
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail3(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsApprovebookdetail3");
	}
	     public ActionForward saveDetail3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("fsApprovebookdetail3");
	}
       
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail4(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsApprovebookdetail4");
	}
	     public ActionForward saveDetail4(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("fsApprovebookdetail4");
	}
       
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail5(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsApprovebookdetail5");
	}
	     public ActionForward saveDetail5(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("fsApprovebookdetail5");
	}
       
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	 	* @拟定操作票
	 	* @自投规程导入
	 	* @发电批准书发布
	 	* @定值单导入
	 	* @发电批准书执行
	 	* @发电批准书上报
	 	* @设备参数上报
	 	* @批准书归档
	 	* @电网实时方式分析单
	 	* @编制系统图改图任务单
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
