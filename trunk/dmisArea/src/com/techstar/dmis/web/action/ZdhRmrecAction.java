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

import com.techstar.dmis.web.facade.ZdhRmrecFacade;
import com.techstar.dmis.web.facade.ZdhWorkbillFacade;
import com.techstar.dmis.web.form.ZdhRmrecForm;
import com.techstar.dmis.dto.ZdhRmrecDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.entity.ZdhEligiblermrate;
import com.techstar.dmis.entity.ZdhRmrec;


/**
 * @author 
 * @date
 */
public class ZdhRmrecAction 
              extends BaseDispatchAction {
	private ZdhRmrecFacade zdhRmrecFacade;
	private ZdhWorkbillFacade zdhWorkbillFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhRmrecAction() {
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
		List list = zdhRmrecFacade.listZdhRmrec();
		request.getSession().setAttribute("ZdhRmrecList", list);

		// 记录操作日志
		//saveLog("ZdhRmrecer", "查询列表");
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
		ZdhRmrecForm zdhRmrecForm = (ZdhRmrecForm) form;
		ZdhRmrecDto dto = zdhRmrecForm.getZdhRmrecDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getRecordno())){
             dto.setRecordno( new SequenceCreator().getUID() ); //生成内部序列号
        }
			zdhRmrecFacade.addZdhRmrec(dto);
		
		
		//saveLog("ZdhRmrecer", "增加记录");
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
		ZdhRmrecForm zdhRmrecForm = (ZdhRmrecForm) form;
		String recordno= request.getParameter("recordno");
		if (StringUtils.isNotEmpty(recordno)) {
			ZdhRmrecDto dto = zdhRmrecFacade.getZdhRmrecById(recordno);
			zdhRmrecForm.setZdhRmrecDto(dto);
		}
		
		//saveLog("ZdhRmrecer", "初始化记录操作");
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
		String recordnoStr   = request.getParameter("recordno");
		String versionStr    = request.getParameter("version");
		String[] primArra    = recordnoStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for(int i=0; i<primArra.length; i++){
			String recordno = primArra[i];
			int version     = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(recordno)) {
				zdhRmrecFacade.deleteZdhRmrec(recordno,version);
				//request.getSession().setAttribute("ZdhRmrecList", list);
			}
		}	
		//saveLog("ZdhRmrecer", "删除记录操作");
		return this.printResponseMes(request,response,mapping,"null","遥测数据修改记录删除成功");
	}

	public void setZdhRmrecFacade(ZdhRmrecFacade zdhRmrecFacade) {
		this.zdhRmrecFacade = zdhRmrecFacade;
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
		ZdhRmrecFacadeDto zdhRmrecDto = new ZdhRmrecDto();
					//zdhRmrecDto.setCustom_id("custom_id");
					//zdhRmrecDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(zdhRmrecDto);
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
//		gridObj.setBusName("ZdhRmrecDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("ZdhRmrec");
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
			QueryListObj queryObj = zdhRmrecFacade.getZdhRmrecByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhRmrecgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward zdhRmrectoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>ZdhRmrec</id>      <name>遥测数据修改记录</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhRmrectoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward zdhRmrectab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhRmrectab");
	     }
		   


     
  
  		
		public ActionForward zdhRmrecframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhRmrecframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhRmrecForm zdhRmrecForm = (ZdhRmrecForm) form;
		String mainId 		= (String) request.getParameter("mainId");
		String isCopy 		= (String) request.getParameter("isCopy");
		String charRecord 	= (String) request.getParameter("charRecord");
		ZdhRmrecDto zdhRmrecDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhRmrecDto = zdhRmrecFacade.getZdhRmrecById(mainId);
				zdhRmrecDto.setVersion(0);
				zdhRmrecDto.setRecordno(null);
				if(zdhRmrecDto.getZzdhrmrec1() != null){
					request.setAttribute("currno", zdhRmrecDto.getZzdhrmrec1().getOndutyno());
				} else {
					request.setAttribute("currno", "");
				}
				
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhRmrecDto = zdhRmrecFacade.getZdhRmrecById(mainId);
				if(zdhRmrecDto.getZzdhrmrec1() != null){
					request.setAttribute("currno", zdhRmrecDto.getZzdhrmrec1().getOndutyno());
				} else {
					request.setAttribute("currno", "");
				}
			} else {// 新增
				zdhRmrecDto = new ZdhRmrecDto();
				request.setAttribute("currno", "");
			}
		}
		
		//提取或设置系统图号
		if(!StringUtils.isEmpty(charRecord)){
			if(zdhRmrecFacade.getZdhRmrecByForeign(charRecord) != null){
				zdhRmrecDto = zdhRmrecFacade.getZdhRmrecByForeign(charRecord);
			} else {
				zdhRmrecDto.setZzdhrmrec2(new com.techstar.dmis.dto.ZdhCharalterrecordDto());
				zdhRmrecDto.getZzdhrmrec2().setRecordsno(charRecord);
			}
		}
		
		String ondutyno = zdhWorkbillFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		//提取或设置当前班志号
		
		zdhRmrecForm.setZdhRmrecDto(zdhRmrecDto);
		   return mapping.findForward("zdhRmrecdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhRmrecForm  zdhRmrecForm = ( ZdhRmrecForm) form;
		 ZdhRmrecDto  zdhRmrecDto = zdhRmrecForm.getZdhRmrecDto();
		 //得到班志号
		 if(StringUtils.isEmpty(zdhRmrecDto.getZzdhrmrec1().getOndutyno())){
			 zdhRmrecDto.setZzdhrmrec1(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
			 String ondutyno = zdhWorkbillFacade.getOndutyno();
			 zdhRmrecDto.getZzdhrmrec1().setOndutyno(ondutyno);
		 }
		zdhRmrecFacade.addZdhRmrec(zdhRmrecDto);
		zdhRmrecDto = zdhRmrecFacade.getZdhRmrecById(zdhRmrecDto.getRecordno());
		String ondutyno = zdhWorkbillFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		if(zdhRmrecDto.getZzdhrmrec1() != null){
			request.setAttribute("currno", zdhRmrecDto.getZzdhrmrec1().getOndutyno());
		} else {
			request.setAttribute("currno", "");
		}
		
		zdhRmrecForm.setZdhRmrecDto(zdhRmrecDto);
		saveMessages(request, "message.save.success", new String[] { "遥测数据修改记录Dto" });
		return mapping.findForward("zdhRmrecdetail");
	}
	 	
	   
	/*
	 * 交接班列表需要
	 */	
	  public ActionForward extStandGridQuery(ActionMapping mapping, ActionForm form,
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
			
		
			int count = 0;
			List dtolist = new ArrayList();
			List sumInfo = new ArrayList();
			if(!StringUtils.isEmpty(hqlSql)){
				QueryListObj queryObj = zdhRmrecFacade.getZdhRmrecByHql(hqlSql, beginPage, pageSize, sumSql);
				dtolist = queryObj.getElemList();
				count   = queryObj.getCount();
				sumInfo = queryObj.getPropertySum();
			}	
			
			String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
			return this.printResponseMes(request,response,mapping,"extZdhRmrecgrid",xmlStr);
		}	
			
	  
	  public ActionForward toolbarOperation(ActionMapping mapping,
				  							ActionForm form, 
				  							HttpServletRequest request,
				  							HttpServletResponse response) throws Exception {
			String hqlStr 	= "";
			
			GridInfoObj gridInfo = sysUiGridFacade.getGenGridInfo(request, hqlStr);
			String hqlSql 		 = gridInfo.getHqlSql();
			int beginPage 		 = gridInfo.getBeginPage();
			int pageSize 		 = gridInfo.getPageSize();
			String sumSql 		 = gridInfo.getSumSql();
			
			int count = 0;
			List dtolist = new ArrayList();
			List sumInfo = new ArrayList();
			if (!StringUtils.isEmpty(hqlSql)) {
			QueryListObj qObj = zdhRmrecFacade.getZdhRmrecByHql(hqlSql, beginPage, pageSize,sumSql);
			dtolist = qObj.getElemList();
			count = qObj.getCount();
			sumInfo = qObj.getPropertySum();
			}
			ZdhRmrec zdhRmrec = (ZdhRmrec)dtolist.get(0);
			String mainId   = zdhRmrec.getRecordno();
			
			return this.printResponseMes(request, response, mapping,"null", mainId+"");
	  }
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setZdhWorkbillFacade(ZdhWorkbillFacade zdhWorkbillFacade) {
		this.zdhWorkbillFacade = zdhWorkbillFacade;
	}

	
	
	
  /**
    * @business method list
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
