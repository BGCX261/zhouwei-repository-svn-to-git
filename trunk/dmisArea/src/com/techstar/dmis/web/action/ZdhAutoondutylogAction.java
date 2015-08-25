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

import com.techstar.dmis.web.facade.ZdhAutoondutylogFacade;
import com.techstar.dmis.web.form.ZdhAutoondutylogForm;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.ZdhSrapplicationDto;


/**
 * @author 
 * @date
 */
public class ZdhAutoondutylogAction 
              extends BaseDispatchAction {
	private ZdhAutoondutylogFacade zdhAutoondutylogFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhAutoondutylogAction() {
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
		List list = zdhAutoondutylogFacade.listZdhAutoondutylog();
		request.getSession().setAttribute("ZdhAutoondutylogList", list);

		// 记录操作日志
		//saveLog("ZdhAutoondutyloger", "查询列表");
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
		ZdhAutoondutylogForm zdhAutoondutylogForm = (ZdhAutoondutylogForm) form;
		ZdhAutoondutylogDto dto = zdhAutoondutylogForm.getZdhAutoondutylogDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getOndutyno())){
             dto.setOndutyno( new SequenceCreator().getUID() ); //生成内部序列号
        }
			zdhAutoondutylogFacade.addZdhAutoondutylog(dto);
		
		
		//saveLog("ZdhAutoondutyloger", "增加记录");
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
		ZdhAutoondutylogForm zdhAutoondutylogForm = (ZdhAutoondutylogForm) form;
		String ondutyno= request.getParameter("ondutyno");
		if (StringUtils.isNotEmpty(ondutyno)) {
			ZdhAutoondutylogDto dto = zdhAutoondutylogFacade.getZdhAutoondutylogById(ondutyno);
			zdhAutoondutylogForm.setZdhAutoondutylogDto(dto);
		}
		
		//saveLog("ZdhAutoondutyloger", "初始化记录操作");
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
		String ondutyno = request.getParameter("ondutyno");
		if (StringUtils.isNotEmpty(ondutyno)) {
			List list = zdhAutoondutylogFacade.deleteZdhAutoondutylog(ondutyno);
			request.getSession().setAttribute("ZdhAutoondutylogList", list);
		}

		//saveLog("ZdhAutoondutyloger", "删除记录操作");
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
		String ondutynoStr = request.getParameter("ondutyno");
		String versionStr = request.getParameter("versions");
		System.out.println("主键参数:"+ondutynoStr);
		System.out.println("版本参数:"+versionStr);
		String message  = "删除成功";
		try{
			List dtos = new ArrayList();
			String[] ondutynoArr = ondutynoStr.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i=0;i<ondutynoArr.length;i++){
				ZdhAutoondutylogDto dto = new ZdhAutoondutylogDto();
				//设置主键值
			    dto.setOndutyno(ondutynoArr[i]);
			    //设置版本号
				dto.setVersion(Integer.valueOf(versionArr[i]).intValue());
				//设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
				dto.setFzdhworkbill2(null);
				dtos.add(dto);
			}
			zdhAutoondutylogFacade.deleteZdhAutoondutylog(dtos);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return this.printResponseMes(request,response,mapping,"null",message);
	}
	public void setZdhAutoondutylogFacade(ZdhAutoondutylogFacade zdhAutoondutylogFacade) {
		this.zdhAutoondutylogFacade = zdhAutoondutylogFacade;
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid",xmlStr);
	}
	  //初始化表格
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid1",xmlStr);
	}
		
			//初始化表格
	  public ActionForward standGridQuery2(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid2",xmlStr);
	}
		
		
		
		   


     
  
  		
		
			//初始化表格
	  public ActionForward standGridQuery3(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid3",xmlStr);
	}
		
		
		
		   


     
  
  		
		
			//初始化表格
	  public ActionForward standGridQuery4(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid4",xmlStr);
	}
		
		
			//初始化表格
	  public ActionForward standGridQuery5(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid5",xmlStr);
	}
		
		
			//初始化表格
	  public ActionForward standGridQuery6(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid6",xmlStr);
	}
		
		
		
		   


     
  
  		
		
			//初始化表格
	  public ActionForward standGridQuery7(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid7",xmlStr);
	}
		
		
		
		   


     
  
  		
		
			//初始化表格
	  public ActionForward standGridQuery8(ActionMapping mapping, ActionForm form,
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
			QueryListObj queryObj = zdhAutoondutylogFacade.getZdhAutoondutylogByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhAutoondutyloggrid8",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward zdhAutoondutylogtoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {			
			String method =  "<Toolbar>   <Business>      <id>ZdhAutoondutylog</id>      <name>自动化值班日志</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   ";
			method +=  "<OperItem Text='交接班' id='carryOn' href='carryOn' title=''></OperItem>";
			method +=  "</Toolbar>";			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhAutoondutylogtoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward zdhAutoondutylogtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhAutoondutylogtab");
	     }
		   


     
  
  		
		public ActionForward zdhAutoondutylogframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhAutoondutylogframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhAutoondutylogForm zdhAutoondutylogForm = (ZdhAutoondutylogForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhAutoondutylogDto zdhAutoondutylogDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhAutoondutylogDto = zdhAutoondutylogFacade.getZdhAutoondutylogById(mainId);
				zdhAutoondutylogDto.setVersion(0);
				//zdhAutoondutylogDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhAutoondutylogDto = zdhAutoondutylogFacade.getZdhAutoondutylogById(mainId);
			} else {// 新增
				zdhAutoondutylogDto = new ZdhAutoondutylogDto();
			}
	  }
	  zdhAutoondutylogForm.setZdhAutoondutylogDto(zdhAutoondutylogDto);
		   return mapping.findForward("zdhAutoondutylogdetail");
      }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhAutoondutylogForm  zdhAutoondutylogForm = ( ZdhAutoondutylogForm) form;
		 ZdhAutoondutylogDto  zdhAutoondutylogDto = zdhAutoondutylogForm.getZdhAutoondutylogDto();
		zdhAutoondutylogFacade.addZdhAutoondutylog(zdhAutoondutylogDto);
		zdhAutoondutylogDto = zdhAutoondutylogFacade.getZdhAutoondutylogById(zdhAutoondutylogDto.getOndutyno());
		zdhAutoondutylogForm.setZdhAutoondutylogDto(zdhAutoondutylogDto);
		saveMessages(request, "message.save.success", new String[] { "自动化值班日志Dto" });
		return mapping.findForward("zdhAutoondutylogdetail");
	}
	 	
	   
     
  
  		
		
		
		   


  	//处理DETAIL页面
			public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhAutoondutylogdetail1");
	}
	     public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		 return mapping.findForward("zdhAutoondutylogdetail1");
	}
       
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	
	
	
  /**
    * @business method list
	 	* @交接班
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
	/**
	 * 交接班操作
	 * @author sbt 2007-4-17 
	 */
	public ActionForward carryOn (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取当前的班号
		String ondutyno = (String) request.getParameter("ondutyno");
		String message=zdhAutoondutylogFacade.carryOn(ondutyno);
		int ret = Integer.valueOf(message).intValue();		
		if (ret == 1) {
			System.out.println("不能进行交接班!");
		}
		return this.printResponseMes(request,response,mapping,"null",message);
	}
	
}
