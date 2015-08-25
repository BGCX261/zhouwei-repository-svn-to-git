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
import com.techstar.dmis.web.facade.DdWaterproofplanFacade;
import com.techstar.dmis.web.form.DdWaterproofplanForm;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdWaterheightDto;
import com.techstar.dmis.dto.DdWaterproofplanDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;


/**
 * @author 
 * @date
 */
public class DdWaterproofplanAction 
              extends BaseDispatchAction {
	private DdWaterproofplanFacade ddWaterproofplanFacade;
    private SysUiGridFacade sysUiGridFacade;
    private DdClassondutylogFacade ddClassdutylogfacade;
	public DdWaterproofplanAction() {
	}
	
//	初始化
	public void iniDefaultValue(HttpServletRequest request,DdWaterproofplanDto dto){
		
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
	public void SetLogno(DdWaterproofplanDto dto){
//		增加班志编号
        DdClassondutylogDto ddc = this.ddClassdutylogfacade.getLogNo();
        dto.setZddwaterproofplan2(ddc);
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
		List list = ddWaterproofplanFacade.listDdWaterproofplan();
		request.getSession().setAttribute("DdWaterproofplanList", list);

		// 记录操作日志
		//saveLog("DdWaterproofplaner", "查询列表");
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
		DdWaterproofplanForm ddWaterproofplanForm = (DdWaterproofplanForm) form;
		DdWaterproofplanDto dto = ddWaterproofplanForm.getDdWaterproofplanDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFid())){
             dto.setFid( new SequenceCreator().getUID() ); //生成内部序列号
             iniDefaultValue(request,dto);
             SetLogno(dto);

        }
			ddWaterproofplanFacade.addDdWaterproofplan(dto);
		
		
		//saveLog("DdWaterproofplaner", "增加记录");
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
		DdWaterproofplanForm ddWaterproofplanForm = (DdWaterproofplanForm) form;
		String fid= request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdWaterproofplanDto dto = ddWaterproofplanFacade.getDdWaterproofplanById(fid);
			ddWaterproofplanForm.setDdWaterproofplanDto(dto);
		}
		
		//saveLog("DdWaterproofplaner", "初始化记录操作");
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
				List list = ddWaterproofplanFacade.deleteDdWaterproofplan(fid,version);
				request.getSession().setAttribute("DdWaterproofplanList", list);
			}
		}	

		//saveLog("DdWaterproofplaner", "删除记录操作");
		return this.printResponseMes(request,response,mapping,"null","删除成功");
	}

	public void setDdWaterproofplanFacade(DdWaterproofplanFacade ddWaterproofplanFacade) {
		this.ddWaterproofplanFacade = ddWaterproofplanFacade;
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
		DdWaterproofplanFacadeDto ddWaterproofplanDto = new DdWaterproofplanDto();
					//ddWaterproofplanDto.setCustom_id("custom_id");
					//ddWaterproofplanDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ddWaterproofplanDto);
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
//		gridObj.setBusName("DdWaterproofplanDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("DdWaterproofplan");
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
			QueryListObj queryObj = ddWaterproofplanFacade.getDdWaterproofplanByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ddWaterproofplangrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ddWaterproofplantoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>DdWaterproofplan</id>      <name>水电运行(计划放水)记录</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ddWaterproofplantoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ddWaterproofplantab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddWaterproofplantab");
	     }
		   


     
  
  		
		public ActionForward ddWaterproofplanframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddWaterproofplanframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdWaterproofplanForm ddWaterproofplanForm = (DdWaterproofplanForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdWaterproofplanDto ddWaterproofplanDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddWaterproofplanDto = ddWaterproofplanFacade.getDdWaterproofplanById(mainId);
				ddWaterproofplanDto.setVersion(0);
				ddWaterproofplanDto.setFid(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddWaterproofplanDto = ddWaterproofplanFacade.getDdWaterproofplanById(mainId);
			} else {// 新增
				ddWaterproofplanDto = new DdWaterproofplanDto();
				iniDefaultValue(request,ddWaterproofplanDto);
	            SetLogno(ddWaterproofplanDto);
			}
		}
		ddWaterproofplanForm.setDdWaterproofplanDto(ddWaterproofplanDto);
		   return mapping.findForward("ddWaterproofplandetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdWaterproofplanForm  ddWaterproofplanForm = ( DdWaterproofplanForm) form;
		 DdWaterproofplanDto  ddWaterproofplanDto = ddWaterproofplanForm.getDdWaterproofplanDto();
		ddWaterproofplanFacade.addDdWaterproofplan(ddWaterproofplanDto);
		ddWaterproofplanDto = ddWaterproofplanFacade.getDdWaterproofplanById(ddWaterproofplanDto.getFid());
		ddWaterproofplanForm.setDdWaterproofplanDto(ddWaterproofplanDto);
		saveMessages(request, "message.save.success", new String[] { "水电运行(计划放水)记录Dto" });
		return mapping.findForward("ddWaterproofplandetail");
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
