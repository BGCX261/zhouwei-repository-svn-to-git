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

import com.techstar.dmis.web.facade.FsLfparalistFacade;
import com.techstar.dmis.web.form.FsLfparalistForm;
import com.techstar.dmis.dto.FsLfparalistDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class FsLfparalistAction 
              extends BaseDispatchAction {
	private FsLfparalistFacade fsLfparalistFacade;
    private SysUiGridFacade sysUiGridFacade;
	public FsLfparalistAction() {
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
		List list = fsLfparalistFacade.listFsLfparalist();
		request.getSession().setAttribute("FsLfparalistList", list);

		// 记录操作日志
		//saveLog("FsLfparalister", "查询列表");
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
		FsLfparalistForm fsLfparalistForm = (FsLfparalistForm) form;
		FsLfparalistDto dto = fsLfparalistForm.getFsLfparalistDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFlinesno())){
             dto.setFlinesno( new SequenceCreator().getUID() ); //生成内部序列号
        }
			fsLfparalistFacade.addFsLfparalist(dto);
		
		
		//saveLog("FsLfparalister", "增加记录");
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
		FsLfparalistForm fsLfparalistForm = (FsLfparalistForm) form;
		String flinesno= request.getParameter("flinesno");
		if (StringUtils.isNotEmpty(flinesno)) {
			FsLfparalistDto dto = fsLfparalistFacade.getFsLfparalistById(flinesno);
			fsLfparalistForm.setFsLfparalistDto(dto);
		}
		
		//saveLog("FsLfparalister", "初始化记录操作");
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
		String flinesno = request.getParameter("flinesno");
		if (StringUtils.isNotEmpty(flinesno)) {
			List list = fsLfparalistFacade.deleteFsLfparalist(flinesno);
			request.getSession().setAttribute("FsLfparalistList", list);
		}

		//saveLog("FsLfparalister", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setFsLfparalistFacade(FsLfparalistFacade fsLfparalistFacade) {
		this.fsLfparalistFacade = fsLfparalistFacade;
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
		FsLfparalistFacadeDto fsLfparalistDto = new FsLfparalistDto();
					//fsLfparalistDto.setCustom_id("custom_id");
					//fsLfparalistDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(fsLfparalistDto);
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
//		gridObj.setBusName("FsLfparalistDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("FsLfparalist");
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
			QueryListObj queryObj = fsLfparalistFacade.getFsLfparalistByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"fsLfparalistgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward fsLfparalisttoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>FsLfparalist</id>      <name>低频减载装置参数的属性清单</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='设定低周线路采集点' id='FS_setLFmeasurepoint' href='#' title=''></OperItem></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("fsLfparalisttoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward fsLfparalisttab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsLfparalisttab");
	     }
		   


     
  
  		
		public ActionForward fsLfparalistframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("fsLfparalistframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 FsLfparalistForm fsLfparalistForm = (FsLfparalistForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		FsLfparalistDto fsLfparalistDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				fsLfparalistDto = fsLfparalistFacade.getFsLfparalistById(mainId);
				fsLfparalistDto.setVersion(0);
				//fsLfparalistDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				fsLfparalistDto = fsLfparalistFacade.getFsLfparalistById(mainId);
			} else {// 新增
				fsLfparalistDto = new FsLfparalistDto();
			}
		}
		fsLfparalistForm.setFsLfparalistDto(fsLfparalistDto);
		   return mapping.findForward("fsLfparalistdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 FsLfparalistForm  fsLfparalistForm = ( FsLfparalistForm) form;
		 FsLfparalistDto  fsLfparalistDto = fsLfparalistForm.getFsLfparalistDto();
		fsLfparalistFacade.addFsLfparalist(fsLfparalistDto);
		fsLfparalistDto = fsLfparalistFacade.getFsLfparalistById(fsLfparalistDto.getFlinesno());
		fsLfparalistForm.setFsLfparalistDto(fsLfparalistDto);
		saveMessages(request, "message.save.success", new String[] { "低频减载装置参数的属性清单Dto" });
		return mapping.findForward("fsLfparalistdetail");
	}
	 	
	   
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsLfparalistdetail1");
	}
	     public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("fsLfparalistdetail1");
	}
       
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	 	* @设定低周线路采集点
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
