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
import com.techstar.dmis.web.facade.DdClassondutylogFacade;
import com.techstar.dmis.web.facade.DdWaterheightFacade;
import com.techstar.dmis.web.form.DdWaterheightForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.dto.DdWaterheightDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;


/**
 * @author 
 * @date
 */
public class DdWaterheightAction 
              extends BaseDispatchAction {
	private DdWaterheightFacade ddWaterheightFacade;
    private SysUiGridFacade sysUiGridFacade;
    private DdClassondutylogFacade ddClassdutylogfacade;
	public DdWaterheightAction() {
	}
	//	初始化
	public void iniDefaultValue(HttpServletRequest request,DdWaterheightDto dto){
		
		long nCurrentTime = System.currentTimeMillis();
			java.sql.Timestamp fCurTime = new java.sql.Timestamp(
					nCurrentTime);
			BusinessDetailHelper ss = new BusinessDetailHelper();
			BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
			dto.setSys_filldept(defaultdto.getUserDeptName());
			dto.setSys_filltime(fCurTime);
			dto.setSys_dataowner(defaultdto.getDataOwnerName());
			dto.setSys_fille(defaultdto.getUserName());	
	}
//	班志编号
	public void SetLogno(DdWaterheightDto dto){
//		增加班志编号
        DdClassondutylogDto ddc = this.ddClassdutylogfacade.getLogNo();
        dto.setZddwaterheight3(ddc);
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
		List list = ddWaterheightFacade.listDdWaterheight();
		request.getSession().setAttribute("DdWaterheightList", list);

		// 记录操作日志
		//saveLog("DdWaterheighter", "查询列表");
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
		DdWaterheightForm ddWaterheightForm = (DdWaterheightForm) form;
		DdWaterheightDto dto = ddWaterheightForm.getDdWaterheightDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFid())){
             dto.setFid( new SequenceCreator().getUID() ); //生成内部序列号
             long   nCurrentTime   =   System.currentTimeMillis();   
   		  	java.sql.Date  flogdate   =   new   java.sql.Date(nCurrentTime); 
             dto.setFlogdate(flogdate);//填写当前日期
             iniDefaultValue(request,dto);
             SetLogno(dto);

        }
			ddWaterheightFacade.addDdWaterheight(dto);
		
		
		//saveLog("DdWaterheighter", "增加记录");
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
		DdWaterheightForm ddWaterheightForm = (DdWaterheightForm) form;
		String fid= request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdWaterheightDto dto = ddWaterheightFacade.getDdWaterheightById(fid);
			ddWaterheightForm.setDdWaterheightDto(dto);
		}
		
		//saveLog("DdWaterheighter", "初始化记录操作");
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
		
		
		String fidStr   = request.getParameter("fid");
		String versionStr    = request.getParameter("version");
		String[] primArra    = fidStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for(int i=0; i<primArra.length; i++){
			String fid = primArra[i];
			int version     = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(fid)) {
				List list = ddWaterheightFacade.deleteDdWaterheight(fid,version);
				request.getSession().setAttribute("DdWaterheightList", list);
			}
		}	
		

		//saveLog("DdWaterheighter", "删除记录操作");
		return this.printResponseMes(request,response,mapping,"null","删除成功");
	}

	public void setDdWaterheightFacade(DdWaterheightFacade ddWaterheightFacade) {
		this.ddWaterheightFacade = ddWaterheightFacade;
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
		DdWaterheightFacadeDto ddWaterheightDto = new DdWaterheightDto();
					//ddWaterheightDto.setCustom_id("custom_id");
					//ddWaterheightDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ddWaterheightDto);
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
//		gridObj.setBusName("DdWaterheightDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("DdWaterheight");
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
			QueryListObj queryObj = ddWaterheightFacade.getDdWaterheightByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ddWaterheightgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ddWaterheighttoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>DdWaterheight</id>      <name>水电运行(水位)记录</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ddWaterheighttoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ddWaterheighttab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddWaterheighttab");
	     }
		   


     
  
  		
		public ActionForward ddWaterheightframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddWaterheightframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdWaterheightForm ddWaterheightForm = (DdWaterheightForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdWaterheightDto ddWaterheightDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddWaterheightDto = ddWaterheightFacade.getDdWaterheightById(mainId);
				ddWaterheightDto.setVersion(0);
				ddWaterheightDto.setFid(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddWaterheightDto = ddWaterheightFacade.getDdWaterheightById(mainId);
			} else {// 新增
				ddWaterheightDto = new DdWaterheightDto();
				long   nCurrentTime   =   System.currentTimeMillis();   
	   		  	java.sql.Date  flogdate   =   new   java.sql.Date(nCurrentTime); 
	   		    ddWaterheightDto.setFlogdate(flogdate);//填写当前日期
				iniDefaultValue(request,ddWaterheightDto);
	            SetLogno(ddWaterheightDto);//班志
			}
		}
		ddWaterheightForm.setDdWaterheightDto(ddWaterheightDto);
		   return mapping.findForward("ddWaterheightdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdWaterheightForm  ddWaterheightForm = ( DdWaterheightForm) form;
		 DdWaterheightDto  ddWaterheightDto = ddWaterheightForm.getDdWaterheightDto();
		 //判断厂站ID是否为空
		 if (ddWaterheightDto.getZddwaterheight2().getId() == null){
			 ddWaterheightDto.setZddwaterheight2(null);
		 }
		ddWaterheightFacade.addDdWaterheight(ddWaterheightDto);
		ddWaterheightDto = ddWaterheightFacade.getDdWaterheightById(ddWaterheightDto.getFid());
		ddWaterheightForm.setDdWaterheightDto(ddWaterheightDto);
		saveMessages(request, "message.save.success", new String[] { "水电运行(水位)记录Dto" });
		return mapping.findForward("ddWaterheightdetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	public void setDdClassdutylogfacade(DdClassondutylogFacade ddClassdutylogfacade) {
		this.ddClassdutylogfacade = ddClassdutylogfacade;
	}

	
	
	
  /**
    * @business method list
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
