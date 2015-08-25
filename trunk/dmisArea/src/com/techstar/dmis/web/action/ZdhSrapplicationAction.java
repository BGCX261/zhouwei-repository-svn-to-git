package com.techstar.dmis.web.action;

import java.sql.Timestamp;
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

import com.techstar.dmis.web.facade.ZdhSrapplicationFacade;
import com.techstar.dmis.web.form.ZdhSrapplicationForm;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.dmis.dto.ZdhSrapplicationDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;


/**
 * @author 
 * @date
 */
public class ZdhSrapplicationAction 
              extends BaseDispatchAction {
	private ZdhSrapplicationFacade zdhSrapplicationFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhSrapplicationAction() {
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
		List list = zdhSrapplicationFacade.listZdhSrapplication();
		request.getSession().setAttribute("ZdhSrapplicationList", list);

		// 记录操作日志
		//saveLog("ZdhSrapplicationer", "查询列表");
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
		ZdhSrapplicationForm zdhSrapplicationForm = (ZdhSrapplicationForm) form;
		ZdhSrapplicationDto dto = zdhSrapplicationForm.getZdhSrapplicationDto();
	   
		
		//附件处理									
		FormFile fannexexplanation = zdhSrapplicationForm.getFannexexplanation();
		if( fannexexplanation != null ){
	        	dto.setFannexexplanation( fannexexplanation.getFileData() );
		  }
	    
						//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFapplicationno())){
             dto.setFapplicationno( new SequenceCreator().getUID() ); //生成内部序列号
        }
	    zdhSrapplicationFacade.addZdhSrapplication(dto);
		
		
		//saveLog("ZdhSrapplicationer", "增加记录");
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
		ZdhSrapplicationForm zdhSrapplicationForm = (ZdhSrapplicationForm) form;
		String fapplicationno= request.getParameter("fapplicationno");
		if (StringUtils.isNotEmpty(fapplicationno)) {
			ZdhSrapplicationDto dto = zdhSrapplicationFacade.getZdhSrapplicationById(fapplicationno);
			zdhSrapplicationForm.setZdhSrapplicationDto(dto);
		}
		
		//saveLog("ZdhSrapplicationer", "初始化记录操作");
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
		String fapplicationno = request.getParameter("fapplicationno");
		if (StringUtils.isNotEmpty(fapplicationno)) {
			List list = zdhSrapplicationFacade.deleteZdhSrapplication(fapplicationno);
			request.getSession().setAttribute("ZdhSrapplicationList", list);
		}
		
		//saveLog("ZdhSrapplicationer", "删除记录操作");
		return mapping.findForward("list");
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
		String fapplicationnoStr = request.getParameter("fapplicationno");
		String versionStr = request.getParameter("versions");
		System.out.println("主键参数:"+fapplicationnoStr);
		System.out.println("版本参数:"+versionStr);
		try{
			List dtos = new ArrayList();
			String[] fapplicationnoArr = fapplicationnoStr.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i=0;i<fapplicationnoArr.length;i++){
				ZdhSrapplicationDto dto = new ZdhSrapplicationDto();
				//设置主键值
			    dto.setFapplicationno(fapplicationnoArr[i]);
			    //设置版本号
				dto.setVersion(Integer.valueOf(versionArr[i]).intValue());
				//设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
				dto.setFzdhsrappeqprel1(null);
				dtos.add(dto);
			}
			zdhSrapplicationFacade.deleteZdhSrapplication(dtos);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void setZdhSrapplicationFacade(ZdhSrapplicationFacade zdhSrapplicationFacade) {
		this.zdhSrapplicationFacade = zdhSrapplicationFacade;
	}
    
			
    //提供对大字段文件下载的方法		
	public ActionForward download_fannexexplanation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String fapplicationno = request.getParameter("fapplicationno");
		ZdhSrapplicationDto dto = zdhSrapplicationFacade.getZdhSrapplicationById(fapplicationno);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFannexexplanation());
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
		String userId = BusinessDetailHelper.getBusDetailInfo(request).getUserName(); // 用户ID

		//取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
		
		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();
		
		
		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = zdhSrapplicationFacade.getZdhSrapplicationByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhSrapplicationgrid",xmlStr);
	}
		
			//初始化表格
	  public ActionForward standGridQuery1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//由业务自行定义的
		String hqlStr = ""; 	//业务HQL
		String userId = BusinessDetailHelper.getBusDetailInfo(request).getUserName(); // 用户ID

		//取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
		
		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();	
		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = zdhSrapplicationFacade.getZdhSrapplicationByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhSrapplicationgrid1",xmlStr);
	}
		
		
		 //初始化toolbar
	     public ActionForward zdhSrapplicationtoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {			
	    	
	    	 String method =  "<Toolbar>   <Business>      <id>ZdhSrapplication</id>      <name>停复役申请</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   ";
	    	 method += "<OperItem Text='申请单执行完成' id='zdh_SRexcute' href='' title=''></OperItem>";
	    	 method += "<OperItem Text='审批意见下发' id='zdh_SRapplicationDistribute' href='' title=''></OperItem>";
	    	 method += "<OperItem Text='报上级调度' id='zdh_Sendtocenter' href='' title=''></OperItem>";
			 method += "<OperItem Text='归档申请单' id='zdh_comfirmApp' href='comfirmApp' title='归档工作票'></OperItem>";
			 method += "<OperItem Text='作废申请单' id='zdh_abateApp' href='abateApp' title='作废申请单'></OperItem>";
			 method += "<OperItem Text='工作流-处理历史' id='zdh_wf_history' href='wf_history' title='工作流-处理历史'></OperItem>";
			
			 method += "</Toolbar>";
			 
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhSrapplicationtoolbar");
	    }

		
	    //初始化tab页
			public ActionForward zdhSrapplicationtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhSrapplicationtab");
	     }
		   
		public ActionForward zdhSrapplicationframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhSrapplicationframe");
	}	
		

  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhSrapplicationForm zdhSrapplicationForm = (ZdhSrapplicationForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhSrapplicationDto zdhSrapplicationDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhSrapplicationDto = zdhSrapplicationFacade.getZdhSrapplicationById(mainId);
				zdhSrapplicationDto.setVersion(0);
				zdhSrapplicationDto.setFapplicationno(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhSrapplicationDto = zdhSrapplicationFacade.getZdhSrapplicationById(mainId);
			} else {// 新增
				zdhSrapplicationDto = new ZdhSrapplicationDto();
				//初始化
			}
		}
		zdhSrapplicationForm.setZdhSrapplicationDto(zdhSrapplicationDto);
		   return mapping.findForward("zdhSrapplicationdetail");
		   }
	  /**
	   * 保存详情页
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
		 ZdhSrapplicationForm  zdhSrapplicationForm = ( ZdhSrapplicationForm) form;
		 ZdhSrapplicationDto  zdhSrapplicationDto = zdhSrapplicationForm.getZdhSrapplicationDto();		 
		 //正式编号
	     String fapplicationono=BusinessDetailHelper.genBusinessNumber("ZdhSrapplication");
	     zdhSrapplicationDto.setFapplicationono(fapplicationono);
		 //附件处理
		FormFile fannexexplanation = zdhSrapplicationForm.getFannexexplanation();
		if( fannexexplanation != null ){
			zdhSrapplicationDto.setFannexexplanation( fannexexplanation.getFileData() );
		 }
		
		Timestamp tFrealstart=zdhSrapplicationDto.getFrealstarttime();
		Timestamp tFrealend=zdhSrapplicationDto.getFrealendtime();
		if(tFrealstart!=null&&tFrealend!=null)
		{
		
			Long lFkeept=new Long((tFrealend.getTime()-tFrealstart.getTime())/60000);
			
			zdhSrapplicationDto.setFkeeptime(lFkeept.intValue());
		}
		
		zdhSrapplicationFacade.addZdhSrapplication(zdhSrapplicationDto);
		zdhSrapplicationDto = zdhSrapplicationFacade.getZdhSrapplicationById(zdhSrapplicationDto.getFapplicationno());
		zdhSrapplicationForm.setZdhSrapplicationDto(zdhSrapplicationDto);
		saveMessages(request, "message.save.success", new String[] { "停复役申请Dto" });
		return mapping.findForward("zdhSrapplicationdetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	 	* @申请单执行完成
	 	* @审批意见下发
	 	* @报上级调度
	 	* @停复役申请归档
	 	* @从设备台帐选择多台设备
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
	/**
	 * 改变状态(归档、作废)
	 * 
	 * @author sbt 2007-4-18 
	 */	
	public ActionForward  changeStatus(ActionMapping mapping, ActionForm form,
			 HttpServletRequest request, HttpServletResponse response) {
		 String zdhSrapplicationIds = request.getParameter("mainId");
		 String excutestatus = request.getParameter("updateFlag");
		 String message = "改变状态成功";
		 System.out.println("zdhSrapplicationIds:"+zdhSrapplicationIds+"   excutestatus:"+excutestatus);
	     try {		 
		    //获取dto
		    //fapplicationno^B6542BA6FFFC44111D159E4B34DED2E
		    String[] zdhSrapplicationId = zdhSrapplicationIds.split("\\^");
		    for (int i=0;i<zdhSrapplicationId.length;i++){
		        ZdhSrapplicationDto dto = zdhSrapplicationFacade.getZdhSrapplicationById(zdhSrapplicationId[i]);
		        //设置属性值
		        dto.setFexcutestatus(excutestatus);
		        //保存
		        zdhSrapplicationFacade.addZdhSrapplication(dto);
		    }
		    saveMessages(request, "message.save.success", new String[] { "停复役申请Dto" });
	     } catch (Exception e){
	         message = "改变状态失败";
		    e.printStackTrace();	 
	     } 

	     return this.printResponseMes(request,response,mapping,"null",message);
	}
	/**
	 * 根据申请单编号获取数据所属单位
	 * @param id
	 * @return
	 */
	private String getSysDataownerById(String id){		
		ZdhSrapplicationDto dto = zdhSrapplicationFacade.getZdhSrapplicationById(id);
		String dataowner = dto.getSys_dataowner();
		
		return dataowner;
	}
	/**
	 * 传动机录显示停复役信息
	 * 
	 */
	public ActionForward showSrapplicationdetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhSrapplicationForm  zdhSrapplicationForm = ( ZdhSrapplicationForm) form;

	
		String mainId = "";	
		mainId=(String)request.getParameter("mainId");
	
		ZdhSrapplicationDto  zdhSrapplicationDto = null;		
		zdhSrapplicationDto = zdhSrapplicationFacade.getZdhSrapplicationById(mainId);
		zdhSrapplicationForm.setZdhSrapplicationDto(zdhSrapplicationDto);
		return mapping.findForward("zdhTransrecordshowSrapplicationdetail");
		
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
		UserProfile userP = (UserProfile) (request.getSession().getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
		
		String userId = userP.getUserName();
		String roleId = "temp";
		
		String busId = request.getParameter("wf_busId");			//业务ID
		String sysdataowner = getSysDataownerById(busId);  //数据所属单位
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
	
		String transitionFlag = request.getParameter("transitionFlag"); //流转处理标记
		//将审批意见下发(自动化专工下发未批准意见)时，区分数据所属单位
		if (Integer.parseInt(status) == 12) {
			if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS.indexOf(sysdataowner.toUpperCase()) >= 0) {
				/**********变电公司***************/
				transitionFlag = "1";
			} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC.indexOf(sysdataowner.toUpperCase()) >= 0) {
				/**********自动化运行处***************/
				transitionFlag = "2";
			} else if (ZdhConstants.ZdhSrappl_WORKFLOW_CITY_IsDpt_QD.indexOf(sysdataowner.toUpperCase()) >= 0) {
				/**********区调 自动下发审批结果********/
				transitionFlag = "3";
			}
		}
		
		
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
				zdhSrapplicationFacade.start(dto);
				break;
			case 2: //变电公司自动化专工审批
				zdhSrapplicationFacade.zdhSrapplBdspecApprove(dto);
				break;
			case 3: //变电运行单位修改申请
				zdhSrapplicationFacade.zdhSrapplBdrunModify(dto);
				break;
			case 4: //变电公司领导审批
				zdhSrapplicationFacade.zdhSrapplBdheaderApprove(dto);
				break;			
			case 5: //自动化运行处处长审批
				zdhSrapplicationFacade.zdhSrapplZdhrunApprove(dto);
				break;
			case 6: //自动化运行处修改
				zdhSrapplicationFacade.zdhSrapplZdhrunModify(dto);
				break;
			case 7:  //变电自动化专工任务下发
				zdhSrapplicationFacade.zdhSrapplBdrunTasksent(dto);
				break;
			case 8: //运行单位执行
				zdhSrapplicationFacade.zdhSrapplRunExec(dto);
				break;
			case 9:  //下发审批任务
				zdhSrapplicationFacade.zdhSrapplSentResult(dto);
				break;
			case 10: //主任审批
				zdhSrapplicationFacade.zdhSrapplDirectorApprove(dto);
				break;
			case 11: //主管主任审批
				zdhSrapplicationFacade.zdhSrapplMDicrecterApprove(dto);
				break;
			case 12: //将审批意见下发
				zdhSrapplicationFacade.zdhSrapplSentComment(dto);
				break;
			case 13: //专工审批
				zdhSrapplicationFacade.zdhSrapplSpecApprove(dto);
				break;
			case 14: //专工归档
				zdhSrapplicationFacade.zdhSrapplSpecKeepon(dto);
				break;
			case 15:  //处长审批
				zdhSrapplicationFacade.zdhSrapplHeaderApprove(dto);
				break;
								
			}
		}
		return mapping.findForward("");
	}
	/**
	 * 显示文档
	 */
	public ActionForward showInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String mainId = (String) request.getParameter("primaryInfo");
		if(StringUtils.isNotEmpty(mainId))
			mainId=mainId.substring(mainId.lastIndexOf("^")+1);
		ZdhSrapplicationDto zdhSrapplicationDto = zdhSrapplicationFacade.getZdhSrapplicationById(mainId);
		request.setAttribute("zdhSrapplicationDto", zdhSrapplicationDto);
		if(zdhSrapplicationDto.getFannexexplanation()!=null&&zdhSrapplicationDto.getFannexexplanation().length>0)
			return mapping.findForward("showInfo");
		else
		{
			String message = "没有附件，请上传";
			OutputStream os = response.getOutputStream();
			os.write(message.getBytes());
			return null;
		}
			
	}
}
