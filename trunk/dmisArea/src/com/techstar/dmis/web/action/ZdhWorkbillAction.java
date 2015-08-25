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

import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.utils.SequenceCreator;

import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;

import com.techstar.dmis.web.facade.ZdhMachineworklistFacade;
import com.techstar.dmis.web.facade.ZdhWorkbillFacade;
import com.techstar.dmis.web.form.ZdhWorkbillForm;
import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.dto.ZdhWorkbillDto;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.dto.WorkflowHandleDto;


/**
 * @author 
 * @date
 */
public class ZdhWorkbillAction 
              extends BaseDispatchAction {
	private ZdhWorkbillFacade zdhWorkbillFacade;
    private SysUiGridFacade sysUiGridFacade;
   
	public ZdhWorkbillAction() {
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
		List list = zdhWorkbillFacade.listZdhWorkbill();
		request.getSession().setAttribute("ZdhWorkbillList", list);

		// 记录操作日志
		//saveLog("ZdhWorkbiller", "查询列表");
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
		ZdhWorkbillForm zdhWorkbillForm = (ZdhWorkbillForm) form;
		ZdhWorkbillDto dto = zdhWorkbillForm.getZdhWorkbillDto();
	    
		//附件处理
									
		FormFile safetyremarks = zdhWorkbillForm.getSafetyremarks();
		if( safetyremarks != null ){
	        	dto.setSafetyremarks( safetyremarks.getFileData() );
		  }
	    
						
		FormFile analysereport = zdhWorkbillForm.getAnalysereport();
		if( analysereport != null ){
	        	dto.setAnalysereport( analysereport.getFileData() );
		  }
	    
		//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getWorkbillid())){
             dto.setWorkbillid( new SequenceCreator().getUID() ); //生成内部序列号
        }
			zdhWorkbillFacade.addZdhWorkbill(dto);
		
		
		//saveLog("ZdhWorkbiller", "增加记录");
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
		ZdhWorkbillForm zdhWorkbillForm = (ZdhWorkbillForm) form;
		String workbillid= request.getParameter("workbillid");
		if (StringUtils.isNotEmpty(workbillid)) {
			ZdhWorkbillDto dto = zdhWorkbillFacade.getZdhWorkbillById(workbillid);
			zdhWorkbillForm.setZdhWorkbillDto(dto);
		}
		
		//saveLog("ZdhWorkbiller", "初始化记录操作");
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
		String workbillid = request.getParameter("workbillid");
		if (StringUtils.isNotEmpty(workbillid)) {
			List list = zdhWorkbillFacade.deleteZdhWorkbill(workbillid);
			request.getSession().setAttribute("ZdhWorkbillList", list);
		}

		//saveLog("ZdhWorkbiller", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setZdhWorkbillFacade(ZdhWorkbillFacade zdhWorkbillFacade) {
		this.zdhWorkbillFacade = zdhWorkbillFacade;
	}
    
			
			//提供对大字段文件下载的方法		
	public ActionForward download_safetyremarks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String workbillid = request.getParameter("workbillid");
		ZdhWorkbillDto dto = zdhWorkbillFacade.getZdhWorkbillById(workbillid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getSafetyremarks());
		os.flush();
		return null;
	}
	//提供对大字段文件下载的方法		
	public ActionForward download_analysereport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String workbillid = request.getParameter("workbillid");
		ZdhWorkbillDto dto = zdhWorkbillFacade.getZdhWorkbillById(workbillid);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getAnalysereport());
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

		//根据日计划生成日计划核查记录
		
		
		//取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
		
		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();
		
		
		
		/**
		 *  表格控件基础对象
		 */

		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = zdhWorkbillFacade.getZdhWorkbillByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhWorkbillgrid",xmlStr);
	}	
	  //交接班列表
	  
	  public ActionForward extStandGridQuery(ActionMapping mapping, ActionForm form,			  
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {

			//由业务自行定义的
			String hqlStr = ""; 	//业务HQL
			String userId = "user"; //用户ID

			//根据日计划生成日计划核查记录
			
			
			//取到表格的信息


			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			
			String hqlSql = gridInfo.getHqlSql();
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();
			String sumSql = gridInfo.getSumSql();
			Map params = gridInfo.getGridPersonalInfo();
			
			
			
			/**
			 *  表格控件基础对象
			 */

			
			int count = 0;
			List dtolist = new ArrayList();
			List sumInfo = new ArrayList();
			if(!StringUtils.isEmpty(hqlSql)){
				QueryListObj queryObj = zdhWorkbillFacade.getZdhWorkbillByHql(hqlSql, beginPage, pageSize, sumSql);
				dtolist = queryObj.getElemList();
				count   = queryObj.getCount();
				sumInfo = queryObj.getPropertySum();
			}	
			
			String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
			return this.printResponseMes(request,response,mapping,"extZdhWorkbillgrid",xmlStr);
		}	
		
		 //初始化toolbar
	     public ActionForward zdhWorkbilltoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>ZdhWorkbill</id>      <name>工作票</name>   </Business>   <ReportUrl>/report.do</ReportUrl>";
			
			method += "<OperItem Text='归档工作票' id='comfirmWorkbill' href='comfirmWorkbill' title='归档工作票'></OperItem>";
			method += "<OperItem Text='作废工作票' id='abateWorkbill' href='abateWorkbill' title='作废工作票'></OperItem>";
			method += "<OperItem Text='工作流-处理历史' id='wf_history' href='wf_history' title='工作流-处理历史'></OperItem>";
			method += "</Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhWorkbilltoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward zdhWorkbilltab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhWorkbilltab");
	     }
		   


     
  
  		
		public ActionForward zdhWorkbillframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhWorkbillframe");
	}	
		


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhWorkbillForm zdhWorkbillForm = (ZdhWorkbillForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhWorkbillDto zdhWorkbillDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhWorkbillDto = zdhWorkbillFacade.getZdhWorkbillById(mainId);
				zdhWorkbillDto.setVersion(0);
				//zdhWorkbillDto.setId(null);
								
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhWorkbillDto = zdhWorkbillFacade.getZdhWorkbillById(mainId);
				
			} else {// 新增
				zdhWorkbillDto = new ZdhWorkbillDto();
                //设置当前的交接班记录号
				zdhWorkbillDto.setZzdhworkbill2(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
				String ondutyno = zdhWorkbillFacade.getOndutyno();				
				zdhWorkbillDto.getZzdhworkbill2().setOndutyno(ondutyno);
				
			}
		}
		
		
		
		zdhWorkbillForm.setZdhWorkbillDto(zdhWorkbillDto);
		   return mapping.findForward("zdhWorkbilldetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhWorkbillForm  zdhWorkbillForm = ( ZdhWorkbillForm) form;
		 ZdhWorkbillDto  zdhWorkbillDto = zdhWorkbillForm.getZdhWorkbillDto();
		 //将子对象Zzdhworkbill4屏蔽(共用设备的所有参数)
		zdhWorkbillDto.setZzdhworkbill4(null);
		zdhWorkbillFacade.addZdhWorkbill(zdhWorkbillDto);
		zdhWorkbillDto = zdhWorkbillFacade.getZdhWorkbillById(zdhWorkbillDto.getWorkbillid());
		zdhWorkbillForm.setZdhWorkbillDto(zdhWorkbillDto);		
				
		saveMessages(request, "message.save.success", new String[] { "工作票Dto" });
		
		
		//为确保保存blob数据成功，添加以下控制
		/*
		FormFile formFile = zdhWorkbillForm.getAnnexsequence();
		if( formFile != null ){
			ZdhWorkbillDto.setAnnexsequence(formFile.getFileData());
		}
        */
		
		return mapping.findForward("zdhWorkbilldetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
  /**
    * @business method list
	 	* @写入机房工作
	 	* @合格情况核定
	 	* @盖工作票执行章
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
	
	/**
	 * 改变状态(归档、作废)
	 */
	public ActionForward  changeStatus(ActionMapping mapping, ActionForm form,
			 HttpServletRequest request, HttpServletResponse response) {
		 //形如:B6542BA6FFFC44111D159E4B34DED2E^B6542BA6FFFC44111D159E4B34DED3E   各主键值之间使用^间隔
		 String zdhWorkbillIds = request.getParameter("mainId");
		 String excutestatus = request.getParameter("updateFlag");
		 String message = "改变状态成功";
		 System.out.println("zdhWorkbillIds:"+zdhWorkbillIds+"   excutestatus:"+excutestatus);
	     try {		    
		    String[] zdhWorkbillId = zdhWorkbillIds.split("\\^");
		    //循环修改各个主键对应记录的状态
		    for (int i=0;i<zdhWorkbillId.length;i++){
                //获取dto
		    	ZdhWorkbillDto dto = zdhWorkbillFacade.getZdhWorkbillById(zdhWorkbillId[i]);
			    //设置执行状态属性值
	            dto.setFexcutestatus(excutestatus);		   
			    //保存
	            zdhWorkbillFacade.addZdhWorkbill(dto);
		    }
		    
		    saveMessages(request, "message.save.success", new String[] { "工作票Dto" });
	     } catch (Exception e){
	    	 message = "改变状态失败";
	    	 System.out.println("改变状态失败:");
		     e.printStackTrace();		 
	     } 
	     return this.printResponseMes(request,response,mapping,"null",message);
	}
	
	/**
	 * 成批删除
	 * 
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
		String strWorkbillid = request.getParameter("workbillid");
		String versionStr = request.getParameter("versions");

		try {
			List dtos = new ArrayList();
			String[] workbillidArr = strWorkbillid.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i = 0; i < workbillidArr.length; i++) {
				ZdhWorkbillDto zdhWorkbillDto = new ZdhWorkbillDto();
				// 设置主键值

				zdhWorkbillDto.setWorkbillid(workbillidArr[i]) ;
				// 设置版本号

				zdhWorkbillDto.setVersion(Integer.valueOf(versionArr[i])
						.intValue());
				// 设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
				zdhWorkbillDto.setZzdhworkbill2(null);
				zdhWorkbillDto.setZzdhworkbill4(null);

				dtos.add(zdhWorkbillDto); 
			}
			zdhWorkbillFacade.deleteZdhWorkbill(dtos);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 机房显示工作票信息
	 * 
	 * 
	 */
	
	public ActionForward showWorkbilldetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZdhWorkbillForm  zdhWorkbillForm = ( ZdhWorkbillForm) form;
		String mainId = "";	
		mainId=(String)request.getParameter("mainId");
		//primaryInfo transinfoid^string^id
		//System.out.println(request.getParameterNames());
		
		ZdhWorkbillDto  zdhWorkbillDto = null;		
		zdhWorkbillDto = zdhWorkbillFacade.getZdhWorkbillById(mainId);
		zdhWorkbillForm.setZdhWorkbillDto(zdhWorkbillDto);
//		System.out.println("Jobcategory="+zdhMachineworklistForm.getZdhMachineworklistDto().getJobcategory());
		return mapping.findForward("zdhMachineworkshowWorkbilldetail");
		
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
		String roleId = "temp";
		
		String busId = request.getParameter("wf_busId");			//业务ID
		String taskId = request.getParameter("wf_taskId");			//任务实例ID
		String taskInstanceId = request.getParameter("wf_taskInstanceId");			//任务实例ID
		String status = request.getParameter("wf_status");			//状态

		String notices = request.getParameter("notice"); 			//处理意见
		String messages = request.getParameter("message"); 			//消息内容
		String sentPersons = request.getParameter("sentPersons"); 		//消息接收人

		String isSms = request.getParameter("isSms"); 					//是否发送手机短信

		String[] nextTaskRoles = request.getParameterValues("nextTaskRoles"); 				//流转人员安排
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
				zdhWorkbillFacade.start(dto);
				break;
			case 2: //运维中心主任签发
				zdhWorkbillFacade.zdhworkbillCenterApprove(dto);
				break;
			case 3: //许可人签字
				zdhWorkbillFacade.zdhworkbillPermit(dto);
				break;
			case 4: //工作负责人签字(就是归档、或已执行)
				zdhWorkbillFacade.zdhworkbillWorkerSign(dto);
				break;			
			case 5: //工作票修改
				zdhWorkbillFacade.zdhworkbillModify(dto);
				break;
								
			}
		}
		return mapping.findForward("");
	}
}
