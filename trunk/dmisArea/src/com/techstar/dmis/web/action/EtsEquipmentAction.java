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

import com.techstar.dmis.web.facade.EtsEquipmentFacade;
import com.techstar.dmis.web.form.EtsEquipmentForm;
import com.techstar.dmis.dto.EtsEquipmentDto;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class EtsEquipmentAction 
              extends BaseDispatchAction {
	private EtsEquipmentFacade etsEquipmentFacade;
    private SysUiGridFacade sysUiGridFacade;
	public EtsEquipmentAction() {
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
		List list = etsEquipmentFacade.listEtsEquipment();
		request.getSession().setAttribute("EtsEquipmentList", list);

		// 记录操作日志
		//saveLog("EtsEquipmenter", "查询列表");
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
		EtsEquipmentForm etsEquipmentForm = (EtsEquipmentForm) form;
		EtsEquipmentDto dto = etsEquipmentForm.getEtsEquipmentDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFeqpid())){
             dto.setFeqpid( new SequenceCreator().getUID() ); //生成内部序列号
        }
			etsEquipmentFacade.addEtsEquipment(dto);
		
		
		//saveLog("EtsEquipmenter", "增加记录");
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
		EtsEquipmentForm etsEquipmentForm = (EtsEquipmentForm) form;
		String feqpid= request.getParameter("feqpid");
		if (StringUtils.isNotEmpty(feqpid)) {
			EtsEquipmentDto dto = etsEquipmentFacade.getEtsEquipmentById(feqpid);
			etsEquipmentForm.setEtsEquipmentDto(dto);
		}
		
		//saveLog("EtsEquipmenter", "初始化记录操作");
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
		String feqpid = request.getParameter("feqpid");
		if (StringUtils.isNotEmpty(feqpid)) {
			List list = etsEquipmentFacade.deleteEtsEquipment(feqpid);
			request.getSession().setAttribute("EtsEquipmentList", list);
		}

		//saveLog("EtsEquipmenter", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setEtsEquipmentFacade(EtsEquipmentFacade etsEquipmentFacade) {
		this.etsEquipmentFacade = etsEquipmentFacade;
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
		EtsEquipmentFacadeDto etsEquipmentDto = new EtsEquipmentDto();
					//etsEquipmentDto.setCustom_id("custom_id");
					//etsEquipmentDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(etsEquipmentDto);
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
//		gridObj.setBusName("EtsEquipmentDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("EtsEquipment");
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
			QueryListObj queryObj = etsEquipmentFacade.getEtsEquipmentByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"etsEquipmentgrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward etsEquipmenttoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>EtsEquipment</id>      <name>所有设备公用参数</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("etsEquipmenttoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward etsEquipmenttab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("etsEquipmenttab");
	     }
		   


     
  
  		
		public ActionForward etsEquipmentframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("etsEquipmentframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 EtsEquipmentForm etsEquipmentForm = (EtsEquipmentForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		EtsEquipmentDto etsEquipmentDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				etsEquipmentDto = etsEquipmentFacade.getEtsEquipmentById(mainId);
				etsEquipmentDto.setVersion(0);
				//etsEquipmentDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				etsEquipmentDto = etsEquipmentFacade.getEtsEquipmentById(mainId);
			} else {// 新增
				etsEquipmentDto = new EtsEquipmentDto();
			}
		}
		etsEquipmentForm.setEtsEquipmentDto(etsEquipmentDto);
		   return mapping.findForward("etsEquipmentdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 EtsEquipmentForm  etsEquipmentForm = ( EtsEquipmentForm) form;
		 EtsEquipmentDto  etsEquipmentDto = etsEquipmentForm.getEtsEquipmentDto();
		etsEquipmentFacade.addEtsEquipment(etsEquipmentDto);
		etsEquipmentDto = etsEquipmentFacade.getEtsEquipmentById(etsEquipmentDto.getFeqpid());
		etsEquipmentForm.setEtsEquipmentDto(etsEquipmentDto);
		saveMessages(request, "message.save.success", new String[] { "所有设备公用参数Dto" });
		return mapping.findForward("etsEquipmentdetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
