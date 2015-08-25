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

import com.techstar.dmis.web.facade.FsLoaddatalistFacade;
import com.techstar.dmis.web.form.FsLoaddatalistForm;
import com.techstar.dmis.dto.FsLoaddatalistDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class FsLoaddatalistAction 
              extends BaseDispatchAction {
	private FsLoaddatalistFacade fsLoaddatalistFacade;
    private SysUiGridFacade sysUiGridFacade;
	public FsLoaddatalistAction() {
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
		List list = fsLoaddatalistFacade.listFsLoaddatalist();
		request.getSession().setAttribute("FsLoaddatalistList", list);

		// 记录操作日志
		//saveLog("FsLoaddatalister", "查询列表");
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
		FsLoaddatalistForm fsLoaddatalistForm = (FsLoaddatalistForm) form;
		FsLoaddatalistDto dto = fsLoaddatalistForm.getFsLoaddatalistDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFloaddatano())){
             dto.setFloaddatano( new SequenceCreator().getUID() ); //生成内部序列号
        }
			fsLoaddatalistFacade.addFsLoaddatalist(dto);
		
		
		//saveLog("FsLoaddatalister", "增加记录");
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
		FsLoaddatalistForm fsLoaddatalistForm = (FsLoaddatalistForm) form;
		String floaddatano= request.getParameter("floaddatano");
		if (StringUtils.isNotEmpty(floaddatano)) {
			FsLoaddatalistDto dto = fsLoaddatalistFacade.getFsLoaddatalistById(floaddatano);
			fsLoaddatalistForm.setFsLoaddatalistDto(dto);
		}
		
		//saveLog("FsLoaddatalister", "初始化记录操作");
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
		String floaddatano = request.getParameter("floaddatano");
		if (StringUtils.isNotEmpty(floaddatano)) {
			List list = fsLoaddatalistFacade.deleteFsLoaddatalist(floaddatano);
			request.getSession().setAttribute("FsLoaddatalistList", list);
		}

		//saveLog("FsLoaddatalister", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setFsLoaddatalistFacade(FsLoaddatalistFacade fsLoaddatalistFacade) {
		this.fsLoaddatalistFacade = fsLoaddatalistFacade;
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
		FsLoaddatalistFacadeDto fsLoaddatalistDto = new FsLoaddatalistDto();
					//fsLoaddatalistDto.setCustom_id("custom_id");
					//fsLoaddatalistDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(fsLoaddatalistDto);
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
//		gridObj.setBusName("FsLoaddatalistDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("FsLoaddatalist");
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
			QueryListObj queryObj = fsLoaddatalistFacade.getFsLoaddatalistByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"fsLoaddatalistgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward fsLoaddatalisttoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>FsLoaddatalist</id>      <name>低频装置负荷数据表的属性清单</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='低周负荷数据采集' id='FS_LFloaddatafromscada' href='#' title=''></OperItem></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("fsLoaddatalisttoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward fsLoaddatalisttab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("fsLoaddatalisttab");
	     }
		   


     
  
  		
		public ActionForward fsLoaddatalistframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("fsLoaddatalistframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 FsLoaddatalistForm fsLoaddatalistForm = (FsLoaddatalistForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		FsLoaddatalistDto fsLoaddatalistDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				fsLoaddatalistDto = fsLoaddatalistFacade.getFsLoaddatalistById(mainId);
				fsLoaddatalistDto.setVersion(0);
				//fsLoaddatalistDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				fsLoaddatalistDto = fsLoaddatalistFacade.getFsLoaddatalistById(mainId);
			} else {// 新增
				fsLoaddatalistDto = new FsLoaddatalistDto();
			}
		}
		fsLoaddatalistForm.setFsLoaddatalistDto(fsLoaddatalistDto);
		   return mapping.findForward("fsLoaddatalistdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 FsLoaddatalistForm  fsLoaddatalistForm = ( FsLoaddatalistForm) form;
		 FsLoaddatalistDto  fsLoaddatalistDto = fsLoaddatalistForm.getFsLoaddatalistDto();
		fsLoaddatalistFacade.addFsLoaddatalist(fsLoaddatalistDto);
		fsLoaddatalistDto = fsLoaddatalistFacade.getFsLoaddatalistById(fsLoaddatalistDto.getFloaddatano());
		fsLoaddatalistForm.setFsLoaddatalistDto(fsLoaddatalistDto);
		saveMessages(request, "message.save.success", new String[] { "低频装置负荷数据表的属性清单Dto" });
		return mapping.findForward("fsLoaddatalistdetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	 	* @低周负荷数据采集
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
