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

import com.techstar.dmis.web.facade.StdElectricstampFacade;
import com.techstar.dmis.web.form.StdElectricstampForm;
import com.techstar.dmis.dto.StdElectricstampDto;
import org.apache.struts.upload.FormFile;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class StdElectricstampAction 
              extends BaseDispatchAction {
	private StdElectricstampFacade stdElectricstampFacade;
    private SysUiGridFacade sysUiGridFacade;
	public StdElectricstampAction() {
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
		List list = stdElectricstampFacade.listStdElectricstamp();
		request.getSession().setAttribute("StdElectricstampList", list);

		// 记录操作日志
		//saveLog("StdElectricstamper", "查询列表");
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
		StdElectricstampForm stdElectricstampForm = (StdElectricstampForm) form;
		StdElectricstampDto dto = stdElectricstampForm.getStdElectricstampDto();
	    
		//附件处理
									
		FormFile fgraph = stdElectricstampForm.getFgraph();
		if( fgraph != null ){
	        	dto.setFgraph( fgraph.getFileData() );
		  }
	    
						//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getId())){
             dto.setId( new SequenceCreator().getUID() ); //生成内部序列号
        }
			stdElectricstampFacade.addStdElectricstamp(dto);
		
		
		//saveLog("StdElectricstamper", "增加记录");
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
		StdElectricstampForm stdElectricstampForm = (StdElectricstampForm) form;
		String id= request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			StdElectricstampDto dto = stdElectricstampFacade.getStdElectricstampById(id);
			stdElectricstampForm.setStdElectricstampDto(dto);
		}
		
		//saveLog("StdElectricstamper", "初始化记录操作");
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
			List list = stdElectricstampFacade.deleteStdElectricstamp(id);
			request.getSession().setAttribute("StdElectricstampList", list);
		}

		//saveLog("StdElectricstamper", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setStdElectricstampFacade(StdElectricstampFacade stdElectricstampFacade) {
		this.stdElectricstampFacade = stdElectricstampFacade;
	}
    
			
			//提供对大字段文件下载的方法		
	public ActionForward download_fgraph(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String id = request.getParameter("id");
		StdElectricstampDto dto = stdElectricstampFacade.getStdElectricstampById(id);
		response.setContentType("application/x-msdownload");
		OutputStream os = response.getOutputStream();
		os.write(dto.getFgraph());
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
		StdElectricstampFacadeDto stdElectricstampDto = new StdElectricstampDto();
					//stdElectricstampDto.setCustom_id("custom_id");
					//stdElectricstampDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(stdElectricstampDto);
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
//		gridObj.setBusName("StdElectricstampDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("StdElectricstamp");
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
			QueryListObj queryObj = stdElectricstampFacade.getStdElectricstampByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"stdElectricstampgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward stdElectricstamptoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>StdElectricstamp</id>      <name>电子章</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("stdElectricstamptoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward stdElectricstamptab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("stdElectricstamptab");
	     }
		   


     
  
  		
		public ActionForward stdElectricstampframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("stdElectricstampframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
	
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 StdElectricstampForm stdElectricstampForm = (StdElectricstampForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		StdElectricstampDto stdElectricstampDto = null;
		
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				stdElectricstampDto = stdElectricstampFacade.getStdElectricstampById(mainId);
				stdElectricstampDto.setVersion(0);
				//stdElectricstampDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				stdElectricstampDto = stdElectricstampFacade.getStdElectricstampById(mainId);
			} else {// 新增
				stdElectricstampDto = new StdElectricstampDto();
			}
		}
		stdElectricstampForm.setStdElectricstampDto(stdElectricstampDto);
		   return mapping.findForward("stdElectricstampdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StdElectricstampForm  stdElectricstampForm = ( StdElectricstampForm) form;
		StdElectricstampDto  stdElectricstampDto = stdElectricstampForm.getStdElectricstampDto();
		FormFile file = stdElectricstampForm.getFgraph();
		 if( file != null&&file.getFileName()!=null&&!file.getFileName().equals("")){
			 stdElectricstampDto.setFgraph(file.getFileData());
		 }
		stdElectricstampFacade.addStdElectricstamp(stdElectricstampDto);
		stdElectricstampDto = stdElectricstampFacade.getStdElectricstampById(stdElectricstampDto.getId());
		stdElectricstampForm.setStdElectricstampDto(stdElectricstampDto);
		saveMessages(request, "message.save.success", new String[] { "电子章Dto" });
		return mapping.findForward("stdElectricstampdetail");
	}
	     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public ActionForward loadstamps(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("ids");
		ArrayList list = new ArrayList();
		if(ids!=null&&!ids.equals("")){
		String[] stampids = ids.split(";");
			for(int i=0;i<stampids.length;i++){
				String id = stampids[i];
				StdElectricstampDto dto = stdElectricstampFacade.loadStdElectricstamp(id);
				list.add(dto);
			}
		}
		String edit = request.getParameter("edit");
		request.setAttribute("edit", edit);
		if(list.size()>0){
			request.setAttribute("stamps", list);
		}
		return mapping.findForward("dayplanstamps");
	}
	
	
  /**
    * @business method list
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
