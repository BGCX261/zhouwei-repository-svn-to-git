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
import com.techstar.dmis.entity.DdClassondutylog;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;

import com.techstar.dmis.web.facade.DdHloadrecordFacade;
import com.techstar.dmis.web.facade.DdClassondutylogFacade;
import com.techstar.dmis.web.form.DdHloadrecordForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.dto.DdPowerchangrecordDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;
import com.techstar.dmis.util.DateUtil;


/**
 * @author 
 * @date
 */
public class DdHloadrecordAction 
              extends BaseDispatchAction {
	private DdHloadrecordFacade ddHloadrecordFacade;
    private SysUiGridFacade sysUiGridFacade;
    private DdClassondutylogFacade ddcfacade;
    
	public DdHloadrecordAction() {
	}
	
	public void iniDefaultValue(HttpServletRequest request,DdHloadrecordDto dto){
		
		long nCurrentTime = System.currentTimeMillis();
			java.sql.Timestamp fCurTime = new java.sql.Timestamp(
					nCurrentTime);
			BusinessDetailHelper ss = new BusinessDetailHelper();
			BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
			dto.setSys_filldept(defaultdto.getUserDeptName());
			dto.setSys_filltime(fCurTime);
			dto.setSys_dataowner(defaultdto.getDataOwnerName());
			dto.setSys_fille(defaultdto.getUserName());	
			java.sql.Date adate = new java.sql.Date(nCurrentTime);
			dto.setFlogdate(adate);
	}
	
	public void SetLogno(DdHloadrecordDto dto){
//		增加班志编号
		
        DdClassondutylogDto ddc = this.ddcfacade.getLogNo();
        dto.setZddhloadrecord4(ddc);
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
		List list = ddHloadrecordFacade.listDdHloadrecord();
		request.getSession().setAttribute("DdHloadrecordList", list);

		// 记录操作日志
		//saveLog("DdHloadrecorder", "查询列表");
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
		DdHloadrecordForm ddHloadrecordForm = (DdHloadrecordForm) form;
		DdHloadrecordDto dto = ddHloadrecordForm.getDdHloadrecordDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFid())){
             dto.setFid( new SequenceCreator().getUID() ); //生成内部序列号         //缺省值处理
         iniDefaultValue(request,dto);
         SetLogno(dto);
 					

        }
			ddHloadrecordFacade.addDdHloadrecord(dto);
		
		
		//saveLog("DdHloadrecorder", "增加记录");
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
		DdHloadrecordForm ddHloadrecordForm = (DdHloadrecordForm) form;
		String fid= request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdHloadrecordDto dto = ddHloadrecordFacade.getDdHloadrecordById(fid);
			ddHloadrecordForm.setDdHloadrecordDto(dto);
		}
		
		//saveLog("DdHloadrecorder", "初始化记录操作");
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
				List list = ddHloadrecordFacade.deleteDdHloadrecordobj(fid,version);
				request.getSession().setAttribute("DdHloadrecordList", list);
			}
		}	
		

		//saveLog("DdHloadrecorder", "删除记录操作");
		return this.printResponseMes(request,response,mapping,"null","删除成功");
		
	}

	public void setDdHloadrecordFacade(DdHloadrecordFacade ddHloadrecordFacade) {
		this.ddHloadrecordFacade = ddHloadrecordFacade;
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
		DdHloadrecordFacadeDto ddHloadrecordDto = new DdHloadrecordDto();
					//ddHloadrecordDto.setCustom_id("custom_id");
					//ddHloadrecordDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ddHloadrecordDto);
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
//		gridObj.setBusName("DdHloadrecordDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("DdHloadrecord");
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
			QueryListObj queryObj = ddHloadrecordFacade.getDdHloadrecordByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ddHloadrecordgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ddHloadrecordtoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>DdHloadrecord</id>      <name>设备重载记录</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ddHloadrecordtoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ddHloadrecordtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddHloadrecordtab");
	     }
		   


     
  
  		
		public ActionForward ddHloadrecordframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddHloadrecordframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdHloadrecordForm ddHloadrecordForm = (DdHloadrecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdHloadrecordDto ddHloadrecordDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddHloadrecordDto = ddHloadrecordFacade.getDdHloadrecordById(mainId);
				ddHloadrecordDto.setVersion(0);
				ddHloadrecordDto.setFid(null);
				
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddHloadrecordDto = ddHloadrecordFacade.getDdHloadrecordById(mainId);
			} else {// 新增
				ddHloadrecordDto = new DdHloadrecordDto();
				 //缺省值处理
		         iniDefaultValue(request,ddHloadrecordDto);
		         SetLogno(ddHloadrecordDto);
			}
		}
		ddHloadrecordForm.setDdHloadrecordDto(ddHloadrecordDto);
		   return mapping.findForward("ddHloadrecorddetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdHloadrecordForm  ddHloadrecordForm = ( DdHloadrecordForm) form;
		 DdHloadrecordDto  ddHloadrecordDto = ddHloadrecordForm.getDdHloadrecordDto();
		 
		 //设备关系
		 ddHloadrecordDto.setZddhloadrecord6(null);
		 //设备的需要做
		ddHloadrecordFacade.addDdHloadrecord(ddHloadrecordDto);
		ddHloadrecordDto = ddHloadrecordFacade.getDdHloadrecordById(ddHloadrecordDto.getFid());
		ddHloadrecordForm.setDdHloadrecordDto(ddHloadrecordDto);
		saveMessages(request, "message.save.success", new String[] { "设备重载记录Dto" });
		return mapping.findForward("ddHloadrecorddetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public void setDdcfacade(DdClassondutylogFacade ddcfacade) {
		this.ddcfacade = ddcfacade;
	}

	
	
	
  /**
    * @business method list
	 	* @从应急系统获得过负荷记录
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
