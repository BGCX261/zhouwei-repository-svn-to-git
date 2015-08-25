package com.techstar.dmis.web.action;

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
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;

import com.techstar.dmis.web.facade.ZdhReceptionFacade;
import com.techstar.dmis.web.form.ZdhReceptionForm;
import com.techstar.dmis.web.form.ZdhSrapplicationForm;
import com.techstar.dmis.web.form.ZdhTransrecordForm;

import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.dto.ZdhReceptionDto;
import com.techstar.dmis.dto.ZdhSrapplicationDto;
import com.techstar.dmis.dto.ZdhWorkbillDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.util.TypeTransUtil;

/**
 * @author 
 * @date
 */
public class ZdhReceptionAction 
              extends BaseDispatchAction {
	private ZdhReceptionFacade zdhReceptionFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhReceptionAction() { 
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
		List list = zdhReceptionFacade.listZdhReception();
		request.getSession().setAttribute("ZdhReceptionList", list);

		// 记录操作日志
		//saveLog("ZdhReceptioner", "查询列表");
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
		ZdhReceptionForm zdhReceptionForm = (ZdhReceptionForm) form;
		ZdhReceptionDto dto = zdhReceptionForm.getZdhReceptionDto();
	    
		//附件处理
									
		FormFile freceptiongraph = zdhReceptionForm.getFreceptiongraph();
		if( freceptiongraph != null ){
	        	dto.setFreceptiongraph( freceptiongraph.getFileData() );
		  }
	    
						
		FormFile freceptionreport = zdhReceptionForm.getFreceptionreport();
		if( freceptionreport != null ){
	        	dto.setFreceptionreport( freceptionreport.getFileData() );
		  }
	    
						
		FormFile fsequence = zdhReceptionForm.getFsequence();
		if( fsequence != null ){
	        	dto.setFsequence( fsequence.getFileData() );
		  }
	    
						
		FormFile ftranrec = zdhReceptionForm.getFtranrec();
		if( ftranrec != null ){
	        	dto.setFtranrec( ftranrec.getFileData() );
		  }
	    
						
//		FormFile runeqpcontent = zdhReceptionForm.getRuneqpcontent();
//		if( runeqpcontent != null ){
//	        	dto.setRuneqpcontent( runeqpcontent.getFileData() );
//		  }
	    
						//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFapplicationid())){
             dto.setFapplicationid( new SequenceCreator().getUID() ); //生成内部序列号
        }
			zdhReceptionFacade.addZdhReception(dto);
		
		
		//saveLog("ZdhReceptioner", "增加记录");
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
		ZdhReceptionForm zdhReceptionForm = (ZdhReceptionForm) form;
		String fapplicationid= request.getParameter("fapplicationid");
		if (StringUtils.isNotEmpty(fapplicationid)) {
			ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(fapplicationid);
			zdhReceptionForm.setZdhReceptionDto(dto);
		}
		
		//saveLog("ZdhReceptioner", "初始化记录操作");
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
		String fapplicationid = request.getParameter("fapplicationid");
		if (StringUtils.isNotEmpty(fapplicationid)) {
			List list = zdhReceptionFacade.deleteZdhReception(fapplicationid);
			request.getSession().setAttribute("ZdhReceptionList", list);
		}

		//saveLog("ZdhReceptioner", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setZdhReceptionFacade(ZdhReceptionFacade zdhReceptionFacade) {
		this.zdhReceptionFacade = zdhReceptionFacade;
	}
    
			
			//提供对大字段文件下载的方法		
	public ActionForward download_freceptiongraph(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapplicationid = request.getParameter("fapplicationid");
		ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(fapplicationid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFreceptiongraph());
		os.flush();
		return null;
	}
		//提供对大字段文件下载的方法		
	public ActionForward download_freceptionreport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapplicationid = request.getParameter("fapplicationid");
		ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(fapplicationid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFreceptionreport());
		os.flush();
		return null;
	}
		//提供对大字段文件下载的方法		
	public ActionForward download_fsequence(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapplicationid = request.getParameter("fapplicationid");
		ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(fapplicationid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFsequence());
		os.flush();
		return null;
	}
		//提供对大字段文件下载的方法		
	public ActionForward download_ftranrec(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapplicationid = request.getParameter("fapplicationid");
		ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(fapplicationid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFtranrec());
		os.flush();
		return null;
	}
		//提供对大字段文件下载的方法		
	public ActionForward download_runeqpcontent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapplicationid = request.getParameter("fapplicationid");
		ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(fapplicationid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getRuneqpcontent());
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
		ZdhReceptionFacadeDto zdhReceptionDto = new ZdhReceptionDto();
					//zdhReceptionDto.setCustom_id("custom_id");
					//zdhReceptionDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(zdhReceptionDto);
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
//		gridObj.setBusName("ZdhReceptionDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("ZdhReception");
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
			QueryListObj queryObj = zdhReceptionFacade.getZdhReceptionByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhReceptiongrid",xmlStr);
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
		ZdhReceptionFacadeDto zdhReceptionDto = new ZdhReceptionDto();
					//zdhReceptionDto.setCustom_id("custom_id");
					//zdhReceptionDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(zdhReceptionDto);
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
//		gridObj.setBusName("ZdhReceptionDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("ZdhReception");
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
			QueryListObj queryObj = zdhReceptionFacade.getZdhReceptionByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhReceptiongrid1",xmlStr); 
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward zdhReceptiontoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>ZdhReception</id>      <name>基改建工程自动化设备验收投运</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   ";
			method+= "<OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title=''></OperItem>";
			//method+="<OperItem Text='归档' id='Zdhreceptionfile' href='changeStatus' title=''></OperItem>";
			//method+="   <OperItem Text='送上级相关专工' id='zdhsendtospecial' href='#' title=''></OperItem>   <OperItem Text='输入投运设备清单' id='zdheqprunlist' href='#' title=''></OperItem>";
			method+="</Toolbar>";
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhReceptiontoolbar"); 
	    }

	 	/**
	 	 * 改变状态(归档、作废)
	 	 */
	 	public ActionForward  changeStatus(ActionMapping mapping, ActionForm form,
	 			 HttpServletRequest request, HttpServletResponse response) {
	 		 String mainId = request.getParameter("fapplicationid");
	 		 String excutestatus = request.getParameter("updateFlag");
	 		 String message = "改变状态成功";
//	 		 System.out.println("fapplicationid:"+mainId+"   excutestatus:"+excutestatus);
	 	     try {		 
	 		    //获取dto
	 		    //fapplicationno^B6542BA6FFFC44111D159E4B34DED2E
	 		    String[] zdReceptionId = mainId.split("\\^");
	 		    for (int i=0;i<zdReceptionId.length;i++){
	                //获取dto
	 		    	ZdhReceptionDto dto = zdhReceptionFacade.getZdhReceptionById(zdReceptionId[i]);
				    //设置执行状态属性值

		            dto.setFexcutestatus(excutestatus);		   
				    //保存
		            zdhReceptionFacade.addZdhReception(dto);
			    }
	 		       
	 	 		    
	 		    saveMessages(request, "message.save.success", new String[] { "基改建Dto" });
	 	     } catch (Exception e){
	 	    	 message = "改变状态失败";
	 		    e.printStackTrace();
	 		    
	 		 
	 	     } 

	 	     return this.printResponseMes(request,response,mapping,"null",message);
	 	}
	 	
		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward zdhReceptiontab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhReceptiontab");
	     }
		   


     
  
  		
		public ActionForward zdhReceptionframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhReceptionframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhReceptionForm zdhReceptionForm = (ZdhReceptionForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhReceptionDto zdhReceptionDto = null;
		//工程验收资料录入
		String project_data="";//0：工程附件上传功能隐藏，1：工程附件上传功能可以修改
		String strFexcutestatus="";
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(mainId);
				zdhReceptionDto.setVersion(0);
				//zdhReceptionDto.setId(null);
			}
			request.setAttribute("project_data", "0");
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(mainId);
				strFexcutestatus=zdhReceptionDto.getFexcutestatus();
				//只有传动记录盖完章后才能上传工程附件
				if(StringUtils.isEmpty(strFexcutestatus)||
						strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_NEW)||
						strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_MODIFY_OK)||
						strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_AUDITING)||
						strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_ACCEPT_YES)||
						strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_ACCEPT_NO))
				{
					request.setAttribute("project_data", "0");
				}
				else
				{
					request.setAttribute("project_data", "1");
				}
			} else {// 新增
				zdhReceptionDto = new ZdhReceptionDto();
				request.setAttribute("project_data", "0");
			}
		}
		zdhReceptionForm.setZdhReceptionDto(zdhReceptionDto);
		   return mapping.findForward("zdhReceptiondetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhReceptionForm  zdhReceptionForm = ( ZdhReceptionForm) form;
		 ZdhReceptionDto  zdhReceptionDto = zdhReceptionForm.getZdhReceptionDto();
		 //附件处理
			FormFile freceptiongraph = zdhReceptionForm.getFreceptiongraph();//竣工图
			if( freceptiongraph != null ){
				zdhReceptionDto.setFreceptiongraph( freceptiongraph.getFileData() );
			  }
		    
							
			FormFile freceptionreport = zdhReceptionForm.getFreceptionreport();//验收报告
			if( freceptionreport != null ){
				zdhReceptionDto.setFreceptionreport( freceptionreport.getFileData() );
			  }
		    
							
			FormFile fsequence = zdhReceptionForm.getFsequence();//序位表
			if( fsequence != null ){
				zdhReceptionDto.setFsequence( fsequence.getFileData() );
			  }
		    
							
			FormFile ftranrec = zdhReceptionForm.getFtranrec();//传动记录
			if( ftranrec != null ){
				zdhReceptionDto.setFtranrec( ftranrec.getFileData() );
			  }
			if(StringUtils.isEmpty(zdhReceptionDto.getFapplicationid()))
			{
				zdhReceptionDto.setFstatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_STATUS_NEW);
				zdhReceptionDto.setFexcutestatus(ZdhConstants.ZdhReception_WORKFLOW_CITY_NEW);
				zdhReceptionDto.setSys_dataowner(ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsArea_CITY);
			}
		    String project_data=request.getParameter("project_data");
			request.setAttribute("project_data", project_data);
		zdhReceptionFacade.addZdhReception(zdhReceptionDto);
		zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(zdhReceptionDto.getFapplicationid());
		zdhReceptionForm.setZdhReceptionDto(zdhReceptionDto);
		saveMessages(request, "message.save.success", new String[] { "基改建工程自动化设备验收投运Dto" });
		return mapping.findForward("zdhReceptiondetail");
	}
	 	
	   
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			//
				 ZdhReceptionForm zdhReceptionForm = (ZdhReceptionForm) form;
					String mainId = (String) request.getParameter("mainId");
					String isCopy = (String) request.getParameter("isCopy");
					ZdhReceptionDto zdhReceptionDto = null;
					String strFexcutestatus="";
					String isShow="";
					if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
						if (StringUtils.isNotEmpty(mainId)) {
							zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(mainId);
							zdhReceptionDto.setVersion(0);
							//zdhReceptionDto.setId(null);
							request.setAttribute("isShow", "0");
						}
					} else {
						if (StringUtils.isNotEmpty(mainId)) {// 修改
							zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(mainId);
							zdhReceptionForm.setRuneqpcontent(TypeTransUtil.BlobToString(zdhReceptionDto.getRuneqpcontent()));
							//只有运行申请后才能批准，批准后才能执行
							strFexcutestatus=zdhReceptionDto.getFexcutestatus();
							if(StringUtils.isNotEmpty(strFexcutestatus)&&strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_APP))
							{
								request.setAttribute("isShow", "1");
							}
							else if(StringUtils.isNotEmpty(strFexcutestatus)&&strFexcutestatus.equals(ZdhConstants.ZdhReception_WORKFLOW_CITY_RECPETION_YES))
							{
								request.setAttribute("isShow", "2");
							}
							else
							{
								request.setAttribute("isShow", "0");
							}
						} else {// 新增
							zdhReceptionDto = new ZdhReceptionDto();
							request.setAttribute("isShow", "0");
						}
					}
					zdhReceptionForm.setZdhReceptionDto(zdhReceptionDto);
				
			//
		    return mapping.findForward("zdhReceptiondetail1");
	}
	     public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			 ZdhReceptionForm  zdhReceptionForm = ( ZdhReceptionForm) form;
			 ZdhReceptionDto  zdhReceptionDto = zdhReceptionForm.getZdhReceptionDto();
			 zdhReceptionDto.setRuneqpcontent(TypeTransUtil.stringToBlob(zdhReceptionForm.getRuneqpcontent()));	
			    String project_data=request.getParameter("project_data");
				request.setAttribute("project_data", project_data);
			zdhReceptionFacade.addZdhReception(zdhReceptionDto);
			zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(zdhReceptionDto.getFapplicationid());
			zdhReceptionForm.setZdhReceptionDto(zdhReceptionDto);
			

						

			saveMessages(request, "message.save.success", new String[] { "基改建工程自动化设备验收投运Dto" });
		 return mapping.findForward("zdhReceptiondetail1");
	}
       
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	/**
	 * 成批删除
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author sbt 2007-4-18 
	 */
	public ActionForward deleteRows(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strFapplicationid = request.getParameter("fapplicationid");
		String versionStr = request.getParameter("versions");
		System.out.println("主键参数:"+strFapplicationid);
		System.out.println("版本参数:"+versionStr);
		try{
			List dtos = new ArrayList();
			String[] fapplicationidArr = strFapplicationid.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i=0;i<fapplicationidArr.length;i++){
				ZdhReceptionDto zdhReceptionDto = new ZdhReceptionDto();
				
								//设置主键值
				zdhReceptionDto.setFapplicationid(fapplicationidArr[i]);
			  			    //设置版本号

				zdhReceptionDto.setVersion(Integer.valueOf(versionArr[i]).intValue());
				//设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
				
				dtos.add(zdhReceptionDto);
			}
			zdhReceptionFacade.deleteZdhReception(dtos);
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}	
	/**
	 * 工作流处理
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward workflowHandle(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserProfile userP = (UserProfile) (request.getSession()
				.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
		
		String userId = userP.getUserName();
		String roleId = "dd";
		
		String busId = request.getParameter("wf_busId");			//业务ID
		String taskId = request.getParameter("wf_taskId");			//任务实例ID
		String taskInstanceId = request.getParameter("wf_taskInstanceId");			//任务实例ID
		String status = request.getParameter("wf_status");			//状态
		String notices = request.getParameter("notice"); 			//处理意见
		String messages = request.getParameter("message"); 			//消息内容
		String sentPersons = request.getParameter("sentPersons"); 		//消息接收人
		String isSms = request.getParameter("isSms"); 					//是否发送手机短信
		String[] nextTaskRoles = request.getParameterValues("nextTaskRoles"); 				//流转人员安排

		String transitionFlag = request.getParameter("transitionFlag"); 				//流转处理标记
		//得到dto
		ZdhReceptionDto zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(busId);	
		String strDataowner=zdhReceptionDto.getSys_dataowner();
		
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
			case 1://启动
				zdhReceptionFacade.start(dto);
			
				break;
			case 2: //市调专工审核
				if(!StringUtils.isEmpty(strDataowner))
				{
					if(strDataowner.equals(ZdhConstants.ZdhReception_CITY))
					{
						if(transitionFlag.equals("1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_CITY_YES);
						}
						else if(transitionFlag.equals("-1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_CITY_NO);
						}
					}
					else if(strDataowner.equals(ZdhConstants.ZdhReception_AREA))
					{
						if(transitionFlag.equals("1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_AREA_YES);
						}
						else if(transitionFlag.equals("-1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS__AREA_NO);
						}
					}
				}
				zdhReceptionFacade.projectrecptionSpecApprove(dto);
			
				break;
			case 3: //填报角色修改申请
				zdhReceptionFacade.projectrecptionModify(dto);
				break;
			case 4: //填报角色上报验收资料
				zdhReceptionFacade.projectrecptionReport(dto);
				break;			
			case 5: //市调专工审核资料完整性
				if(!StringUtils.isEmpty(strDataowner))
				{
					if(strDataowner.equals(ZdhConstants.ZdhReception_CITY))
					{
						if(transitionFlag.equals("1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_CITY_YES);
						}
						else if(transitionFlag.equals("-1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_CITY_NO);
						}
					}
					else if(strDataowner.equals(ZdhConstants.ZdhReception_AREA))
					{
						if(transitionFlag.equals("1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_AREA_YES);
						}
						else if(transitionFlag.equals("-1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS__AREA_NO);
						}
					}
				}
				zdhReceptionFacade.projectrecptionApproveFill(dto);
				break;
			case 6: //运行投运申请
				zdhReceptionFacade.projectrecptionRunApply(dto);
				break;	
			case 7: //专工投运审核
				if(!StringUtils.isEmpty(strDataowner))
				{
					if(strDataowner.equals(ZdhConstants.ZdhReception_CITY))
					{
						if(transitionFlag.equals("1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_CITY_YES);
						}
						else if(transitionFlag.equals("-1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_CITY_NO);
						}
					}
					else if(strDataowner.equals(ZdhConstants.ZdhReception_AREA))
					{
						if(transitionFlag.equals("1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS_AREA_YES);
						}
						else if(transitionFlag.equals("-1"))
						{
							dto.setTransitionFlag(ZdhConstants.ZdhReception_WORKFLOW_STATUS__AREA_NO);
						}
					}
				}
				zdhReceptionFacade.projectrecptionRunApprove(dto);
				break;	
			case 8: //执行
				zdhReceptionFacade.projectrecptionExec(dto);
				break;	
			case 9: //归档
				zdhReceptionFacade.projectrecptionKeepon(dto);
				break;	
			}
		}
		
		return mapping.findForward("");
	}			

	public ActionForward showReceptiondetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String mainId = "";	
		mainId=(String)request.getParameter("mainId");
		ZdhReceptionForm  zdhReceptionForm = ( ZdhReceptionForm) form;
		ZdhReceptionDto  zdhReceptionDto = null;	
		zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(mainId);
		zdhReceptionForm.setZdhReceptionDto(zdhReceptionDto);
	
		return mapping.findForward("zdhTransrecordshowReceptiondetail");
		
	}
	/**
	 * 显示图片
	 * 
	 */
	public ActionForward showImg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ZdhReceptionForm  zdhReceptionForm = ( ZdhReceptionForm) form;
		String mainId = (String) request.getParameter("primaryInfo");
		if(StringUtils.isNotEmpty(mainId))
			mainId=mainId.substring(mainId.lastIndexOf("^")+1);
		String strType=(String)request.getParameter("type");
		ZdhReceptionDto zdhReceptionDto = null;

		zdhReceptionDto = zdhReceptionFacade.getZdhReceptionById(mainId);
		zdhReceptionForm.setZdhReceptionDto(zdhReceptionDto);		
		request.setAttribute("zdhReceptionDto", zdhReceptionDto);
		request.setAttribute("type", strType);
		return mapping.findForward("zdhReceptionshowImg");

	}
	/*
	 * 翻页
	 */
	public ActionForward toolbarOperation(ActionMapping mapping,

			ActionForm form,

			HttpServletRequest request,

			HttpServletResponse response) throws Exception {

				String hqlStr = "";

				GridInfoObj gridInfo = sysUiGridFacade.getGenGridInfo(request, hqlStr);

				String hqlSql = gridInfo.getHqlSql();

				int beginPage = gridInfo.getBeginPage();

				int pageSize = gridInfo.getPageSize();

				String sumSql = gridInfo.getSumSql();

				int count = 0;

				List dtolist = new ArrayList();

				List sumInfo = new ArrayList();

				if (!StringUtils.isEmpty(hqlSql)) {

					QueryListObj qObj = zdhReceptionFacade.getZdhReceptionByHql(hqlSql, beginPage, pageSize, sumSql);
							

					dtolist = qObj.getElemList();

				}

				ZdhReceptionDto  zdhReceptionDto = (ZdhReceptionDto) dtolist.get(0);

				String mainId = zdhReceptionDto.getFapplicationid();

				return this.printResponseMes(request, response, mapping, "null", mainId+ "");

			}	

  /**
    * @business method list
	 	* @申请单归档
	 	* @送上级相关专工
	 	* @输入投运设备清单
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
