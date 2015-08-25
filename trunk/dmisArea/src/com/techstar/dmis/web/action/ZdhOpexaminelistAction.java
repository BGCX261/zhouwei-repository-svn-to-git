package com.techstar.dmis.web.action;

import java.text.SimpleDateFormat;
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

import com.techstar.dmis.web.facade.ZdhOpexaminelistFacade;
import com.techstar.dmis.web.form.ZdhOpexaminelistForm;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import  com.techstar.dmis.dto.ZdhAutoondutylogDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.ZdhTransrecordDto;


/**
 * @author 
 * @date
 */
public class ZdhOpexaminelistAction 
              extends BaseDispatchAction {
	private ZdhOpexaminelistFacade zdhOpexaminelistFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhOpexaminelistAction() {
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
		List list = zdhOpexaminelistFacade.listZdhOpexaminelist();
		request.getSession().setAttribute("ZdhOpexaminelistList", list);

		// 记录操作日志
		//saveLog("ZdhOpexaminelister", "查询列表");
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
		ZdhOpexaminelistForm zdhOpexaminelistForm = (ZdhOpexaminelistForm) form;
		ZdhOpexaminelistDto dto = zdhOpexaminelistForm.getZdhOpexaminelistDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getExaminationid())){
             dto.setExaminationid( new SequenceCreator().getUID() ); //生成内部序列号
        }
			zdhOpexaminelistFacade.addZdhOpexaminelist(dto);
		
		
		//saveLog("ZdhOpexaminelister", "增加记录");
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
		ZdhOpexaminelistForm zdhOpexaminelistForm = (ZdhOpexaminelistForm) form;
		String examinationid= request.getParameter("examinationid");
		if (StringUtils.isNotEmpty(examinationid)) {
			ZdhOpexaminelistDto dto = zdhOpexaminelistFacade.getZdhOpexaminelistById(examinationid);
			zdhOpexaminelistForm.setZdhOpexaminelistDto(dto);
		}
		
		//saveLog("ZdhOpexaminelister", "初始化记录操作");
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
		String examinationid = request.getParameter("examinationid");
		if (StringUtils.isNotEmpty(examinationid)) {
			List list = zdhOpexaminelistFacade.deleteZdhOpexaminelist(examinationid);
			request.getSession().setAttribute("ZdhOpexaminelistList", list);
		}

		//saveLog("ZdhOpexaminelister", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setZdhOpexaminelistFacade(ZdhOpexaminelistFacade zdhOpexaminelistFacade) {
		this.zdhOpexaminelistFacade = zdhOpexaminelistFacade;
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
		
		
		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = zdhOpexaminelistFacade.getZdhOpexaminelistByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhOpexaminelistgrid",xmlStr);
	}
		//交接班列表

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
			QueryListObj queryObj = zdhOpexaminelistFacade.getZdhOpexaminelistByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"extZdhOpexaminelistgrid",xmlStr);
	}	
		
		
		   
		   		 //初始化toolbar
	     public ActionForward zdhOpexaminelisttoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>ZdhOpexaminelist</id>      <name>日计划核查表</name>   </Business>";
			method +=  "<ReportUrl>/report.do</ReportUrl>    ";
//			method += "<OperItem Text='完成情况核查' id='Mfinishcheck' href='#' title='完成情况核查'></OperItem>";
//			method += "<OperItem Text='开始情况核查' id='Mbegincheck' href='#' title='开始情况核查'></OperItem>";
			method += "<OperItem Text='初始化日计划' id='Cshrjh' href='initDdDoutageplan' title='初始化日计划'></OperItem>";
			method += "</Toolbar>";
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhOpexaminelisttoolbar");
	    }
		 
	     public ActionForward initDdDoutageplan(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				zdhOpexaminelistFacade.saveDdDoutageplan();
				return mapping.findForward("zdhOpexaminelistgrid");
			}	
     
  
  		
		
		
			    //初始化tab页
			public ActionForward zdhOpexaminelisttab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhOpexaminelisttab");
	     }
		   


     
  
  		
		public ActionForward zdhOpexaminelistframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhOpexaminelistframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhOpexaminelistForm zdhOpexaminelistForm = (ZdhOpexaminelistForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		String strFapplystime="";
		String strFapplyetime="";
		ZdhOpexaminelistDto zdhOpexaminelistDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhOpexaminelistDto = zdhOpexaminelistFacade.getZdhOpexaminelistById(mainId);
				zdhOpexaminelistDto.setVersion(0);
				 if(zdhOpexaminelistDto.getZzdhopexaminelist5() != null){
					 request.setAttribute("currno",
							 zdhOpexaminelistDto.getZzdhopexaminelist5().getOndutyno());
					 }else{
					 request.setAttribute("currno", "");
					
					 }
				//zdhOpexaminelistDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhOpexaminelistDto = zdhOpexaminelistFacade.getZdhOpexaminelistById(mainId);
				if(zdhOpexaminelistDto.getFapplystime()!=null)
				{
					strFapplystime=zdhOpexaminelistDto.getFapplystime().toString();
					strFapplystime=strFapplystime.substring(0,16);
				}
					
				if(zdhOpexaminelistDto.getFapplyetime()!=null)
				{
					strFapplyetime=zdhOpexaminelistDto.getFapplyetime().toString();
					strFapplyetime=strFapplyetime.substring(0,16);
				}
					request.setAttribute("fapplyetime", strFapplyetime);
					request.setAttribute("fapplystime", strFapplystime);
				 if(zdhOpexaminelistDto.getZzdhopexaminelist5() != null){
					 request.setAttribute("currno",	 zdhOpexaminelistDto.getZzdhopexaminelist5().getOndutyno());
					 }else{
						 String ondutyno = zdhOpexaminelistFacade.getOndutyno();	
						 zdhOpexaminelistDto.setZzdhopexaminelist5(new ZdhAutoondutylogDto());
						 zdhOpexaminelistDto.getZzdhopexaminelist5().setOndutyno(ondutyno)	;
					 request.setAttribute("currno",  zdhOpexaminelistDto.getZzdhopexaminelist5().getOndutyno());
					 }
				if(zdhOpexaminelistDto.getBeginchecktime()!=null)			
				{
					request.setAttribute("rBeginchecktime", zdhOpexaminelistDto.getBeginchecktime());	

				}
								
				else
				{
					zdhOpexaminelistDto.setZzdhopexaminelist5(new  com.techstar.dmis.dto.ZdhAutoondutylogDto());
					// String ondutyno = zdhOpexaminelistFacade.getOndutyno();	
					// zdhOpexaminelistDto.getZzdhopexaminelist5().setOndutyno(ondutyno)	;
					 request.setAttribute("rBeginchecktime", null);
				}
					
			} else {// 新增
				zdhOpexaminelistDto = new ZdhOpexaminelistDto();
				zdhOpexaminelistDto.setZzdhopexaminelist5(new  com.techstar.dmis.dto.ZdhAutoondutylogDto());
				 String ondutyno = zdhOpexaminelistFacade.getOndutyno();	
				 zdhOpexaminelistDto.getZzdhopexaminelist5().setOndutyno(ondutyno)	;
				 request.setAttribute("currno", "");
			}
		}
		String ondutyno = zdhOpexaminelistFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		zdhOpexaminelistForm.setZdhOpexaminelistDto(zdhOpexaminelistDto);
		   return mapping.findForward("zdhOpexaminelistdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
		 ZdhOpexaminelistForm  zdhOpexaminelistForm = ( ZdhOpexaminelistForm) form; 
		 ZdhOpexaminelistDto  zdhOpexaminelistDto = zdhOpexaminelistForm.getZdhOpexaminelistDto();
		zdhOpexaminelistFacade.addZdhOpexaminelist(zdhOpexaminelistDto);
		String strFapplystime="";
		String strFapplyetime="";
		zdhOpexaminelistDto = zdhOpexaminelistFacade.getZdhOpexaminelistById(zdhOpexaminelistDto.getExaminationid());
		zdhOpexaminelistForm.setZdhOpexaminelistDto(zdhOpexaminelistDto);
		String ondutyno = zdhOpexaminelistFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		request.setAttribute("currno", zdhOpexaminelistDto.getZzdhopexaminelist5().getOndutyno());
		if(zdhOpexaminelistDto.getFapplystime()!=null)
		{
			strFapplystime=zdhOpexaminelistDto.getFapplystime().toString();
			strFapplystime=strFapplystime.substring(0,16);
		}
			
		if(zdhOpexaminelistDto.getFapplyetime()!=null)
		{
			strFapplyetime=zdhOpexaminelistDto.getFapplyetime().toString();
			strFapplyetime=strFapplyetime.substring(0,16);
		}
			request.setAttribute("fapplyetime", strFapplyetime);
			request.setAttribute("fapplystime", strFapplystime);
		if(zdhOpexaminelistDto.getBeginchecktime()!=null)			
		{
			request.setAttribute("rBeginchecktime", zdhOpexaminelistDto.getBeginchecktime());	

		}
						
		else
		{
			zdhOpexaminelistDto.setZzdhopexaminelist5(new  com.techstar.dmis.dto.ZdhAutoondutylogDto());
			// String ondutyno = zdhOpexaminelistFacade.getOndutyno();	
			// zdhOpexaminelistDto.getZzdhopexaminelist5().setOndutyno(ondutyno)	;
			 request.setAttribute("rBeginchecktime", null);
		}
		saveMessages(request, "message.save.success", new String[] { "日计划核查表Dto" });
		return mapping.findForward("zdhOpexaminelistdetail");
	}
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	  public ActionForward standGridQuery1(ActionMapping mapping, ActionForm form,
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
				QueryListObj queryObj = zdhOpexaminelistFacade.initDdDoutageplan(beginPage, pageSize, sumSql);
				dtolist = queryObj.getElemList();
				count   = queryObj.getCount();
				sumInfo = queryObj.getPropertySum();
			}	
			
			String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
			return this.printResponseMes(request,response,mapping,"initDdDoutageplan",xmlStr);
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
			String strExaminationid = request.getParameter("examinationid");
			String versionStr = request.getParameter("versions");
			System.out.println("主键参数:"+strExaminationid);
			System.out.println("版本参数:"+versionStr);
			try{
				List dtos = new ArrayList();
				String[] examinationidArr = strExaminationid.split("\\^");
				String[] versionArr = versionStr.split("\\^");
				for (int i=0;i<examinationidArr.length;i++){
					ZdhOpexaminelistDto  zdhOpexaminelistDto=new ZdhOpexaminelistDto();
					
									//设置主键值
					zdhOpexaminelistDto.setExaminationid(examinationidArr[i]);
					
				  			    //设置版本号

					zdhOpexaminelistDto.setVersion(Integer.valueOf(versionArr[i]).intValue());
					//设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
					zdhOpexaminelistDto.setZzdhopexaminelist5(null);
					zdhOpexaminelistDto.setZzdhopexaminelist6(null);
				
					dtos.add(zdhOpexaminelistDto);
				}
				zdhOpexaminelistFacade.deleteZdhOpexaminelist(dtos);
				
				
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
		/*
		 * 翻页
		 */
		public ActionForward toolbarOperation(ActionMapping mapping,

				ActionForm form,

				HttpServletRequest request,

				HttpServletResponse response) throws Exception {

					String hqlStr = "";

					GridInfoObj gridInfo = sysUiGridFacade.getGenGridInfo(request, hqlStr);

					String hqlSql = gridInfo.getHqlSql();

					int beginPage = gridInfo.getBeginPage();

					int pageSize = gridInfo.getPageSize();

					String sumSql = gridInfo.getSumSql();

					int count = 0;

					List dtolist = new ArrayList();

					List sumInfo = new ArrayList();

					if (!StringUtils.isEmpty(hqlSql)) {

						QueryListObj qObj = zdhOpexaminelistFacade.getZdhOpexaminelistByHql(hqlSql, beginPage, pageSize,
								sumSql);
								

						dtolist = qObj.getElemList();

					}

					ZdhOpexaminelistDto  zdhOpexaminelistDto = (ZdhOpexaminelistDto) dtolist.get(0);

					String mainId = zdhOpexaminelistDto.getExaminationid();

					return this.printResponseMes(request, response, mapping, "null", mainId+ "");

				}	
	
  /**
    * @business method list
	 	* @完成情况核查
	 	* @开始情况核查
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
