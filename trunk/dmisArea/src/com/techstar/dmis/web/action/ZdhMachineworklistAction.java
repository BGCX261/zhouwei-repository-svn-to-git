package com.techstar.dmis.web.action;

import java.util.List;
import java.util.Map;
import java.io.IOException;
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

import com.techstar.dmis.web.facade.ZdhMachineworklistFacade;
import com.techstar.dmis.web.form.ZdhMachineworklistForm;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.ZdhTransrecordDto;


/**
 * @author 
 * @date
 */
public class ZdhMachineworklistAction 
              extends BaseDispatchAction {
	private ZdhMachineworklistFacade zdhMachineworklistFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhMachineworklistAction() {
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
		List list = zdhMachineworklistFacade.listZdhMachineworklist();
		request.getSession().setAttribute("ZdhMachineworklistList", list);

		// 记录操作日志
		//saveLog("ZdhMachineworklister", "查询列表");
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
		ZdhMachineworklistForm zdhMachineworklistForm = (ZdhMachineworklistForm) form;
		ZdhMachineworklistDto dto = zdhMachineworklistForm.getZdhMachineworklistDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getJobid())){
             dto.setJobid( new SequenceCreator().getUID() ); //生成内部序列号

        }
			zdhMachineworklistFacade.addZdhMachineworklist(dto);
		
		
		//saveLog("ZdhMachineworklister", "增加记录");
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
		ZdhMachineworklistForm zdhMachineworklistForm = (ZdhMachineworklistForm) form;
		String jobid= request.getParameter("jobid");
		if (StringUtils.isNotEmpty(jobid)) {
			ZdhMachineworklistDto dto = zdhMachineworklistFacade.getZdhMachineworklistById(jobid);
			zdhMachineworklistForm.setZdhMachineworklistDto(dto);
		}
		
		//saveLog("ZdhMachineworklister", "初始化记录操作");
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
		String jobid = request.getParameter("jobid");
		if (StringUtils.isNotEmpty(jobid)) {
			List list = zdhMachineworklistFacade.deleteZdhMachineworklist(jobid);
			request.getSession().setAttribute("ZdhMachineworklistList", list);
		}

		//saveLog("ZdhMachineworklister", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setZdhMachineworklistFacade(ZdhMachineworklistFacade zdhMachineworklistFacade) {
		this.zdhMachineworklistFacade = zdhMachineworklistFacade;
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
		
		
		/**
		 *  表格控件基础对象
		 */

		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = zdhMachineworklistFacade.getZdhMachineworklistByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhMachineworklistgrid",xmlStr);
	}
	  /*
	   * 交接班需要初始化列表
	   */
		//
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
			
			
			/**
			 *  表格控件基础对象
			 */

			
			int count = 0;
			List dtolist = new ArrayList();
			List sumInfo = new ArrayList();
			if(!StringUtils.isEmpty(hqlSql)){
				QueryListObj queryObj = zdhMachineworklistFacade.getZdhMachineworklistByHql(hqlSql, beginPage, pageSize, sumSql);
				dtolist = queryObj.getElemList();
				count   = queryObj.getCount();
				sumInfo = queryObj.getPropertySum();
			}	
			
			String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
			return this.printResponseMes(request,response,mapping,"extZdhMachineworklistgrid",xmlStr);
		}
		
		   


     
  
  		
		
		
			   		 //初始化toolbar
	     public ActionForward zdhMachineworklisttoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>ZdhMachineworklist</id>      <name>机房工作</name>   </Business> ";
			method +=  "<ReportUrl>/report.do</ReportUrl>    ";
			//method += "<OperItem Text='查看原数据详情' id='comfirmApp' href='showDetail' title='查看原数据详情'></OperItem>";

			
			method += "</Toolbar>";
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhMachineworklisttoolbar");
	    }
		


     
  
  		
		
		
			    //初始化tab页

			public ActionForward zdhMachineworklisttab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhMachineworklisttab");
	     }
		   


     
  
  		
		public ActionForward zdhMachineworklistframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhMachineworklistframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhMachineworklistForm zdhMachineworklistForm = (ZdhMachineworklistForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhMachineworklistDto zdhMachineworklistDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhMachineworklistDto = zdhMachineworklistFacade.getZdhMachineworklistById(mainId);
				zdhMachineworklistDto.setVersion(0);
				 if(zdhMachineworklistDto.getZzdhmachineworklist1() != null){
					 request.setAttribute("currno",
							 zdhMachineworklistDto.getZzdhmachineworklist1().getOndutyno());
					 }else{
					 request.setAttribute("currno", "");
					
					 }
				//zdhMachineworklistDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhMachineworklistDto = zdhMachineworklistFacade.getZdhMachineworklistById(mainId);
				 if(zdhMachineworklistDto.getZzdhmachineworklist1() != null){
					 request.setAttribute("currno",
							 zdhMachineworklistDto.getZzdhmachineworklist1().getOndutyno());
					 }else{
					 request.setAttribute("currno", "");
					
					 }
			} else {// 新增
				zdhMachineworklistDto = new ZdhMachineworklistDto();
				zdhMachineworklistDto.setZzdhmachineworklist1(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
				String ondutyno=zdhMachineworklistFacade.getOndutyno();
			
				request.setAttribute("currno", "");
				zdhMachineworklistDto.getZzdhmachineworklist1().setOndutyno(ondutyno);
			}
		}
		String ondutyno = zdhMachineworklistFacade.getOndutyno();
		request.setAttribute("ondutyno", ondutyno);
		zdhMachineworklistForm.setZdhMachineworklistDto(zdhMachineworklistDto);
		   return mapping.findForward("zdhMachineworklistdetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhMachineworklistForm  zdhMachineworklistForm = ( ZdhMachineworklistForm) form;
		 ZdhMachineworklistDto  zdhMachineworklistDto = zdhMachineworklistForm.getZdhMachineworklistDto();
		 if(StringUtils.isEmpty(zdhMachineworklistDto.getZzdhmachineworklist1().getOndutyno()))
		 {
			 zdhMachineworklistDto.setZzdhmachineworklist1(new com.techstar.dmis.dto.ZdhAutoondutylogDto());
			 String ondutyno=zdhMachineworklistFacade.getOndutyno();			
			 zdhMachineworklistDto.getZzdhmachineworklist1().setOndutyno(ondutyno);
		 }

		zdhMachineworklistFacade.addZdhMachineworklist(zdhMachineworklistDto);
		zdhMachineworklistDto = zdhMachineworklistFacade.getZdhMachineworklistById(zdhMachineworklistDto.getJobid());
		zdhMachineworklistForm.setZdhMachineworklistDto(zdhMachineworklistDto);
		 if(zdhMachineworklistDto.getZzdhmachineworklist1() != null){
			 request.setAttribute("currno",
					 zdhMachineworklistDto.getZzdhmachineworklist1().getOndutyno());
			 }else{
			 request.setAttribute("currno", "");
			
			 }
		saveMessages(request, "message.save.success", new String[] { "机房工作Dto" });
		return mapping.findForward("zdhMachineworklistdetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

		public ActionForward  showDetail(ActionMapping mapping, ActionForm form,
			 HttpServletRequest request, HttpServletResponse response) throws IOException {
		 ZdhMachineworklistForm  zdhMachineworklistForm = ( ZdhMachineworklistForm) form;
		
			String mainId = "";	
			mainId=(String)request.getParameter("primaryInfo");
			//primaryInfo transinfoid^string^id
			//System.out.println(request.getParameterNames());
			mainId=mainId.substring(mainId.lastIndexOf("^")+1);
			ZdhMachineworklistDto  zdhMachineworklistDto = null;		
			zdhMachineworklistDto = zdhMachineworklistFacade.getZdhMachineworklistById(mainId);
			zdhMachineworklistForm.setZdhMachineworklistDto(zdhMachineworklistDto);
//			System.out.println("Jobcategory="+zdhMachineworklistForm.getZdhMachineworklistDto().getJobcategory());
			return mapping.findForward("zdhMachineworklistshowdetail");
		
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
			String strJobid = request.getParameter("jobid");
			String versionStr = request.getParameter("versions");
			System.out.println("主键参数:"+strJobid);
			System.out.println("版本参数:"+versionStr);
			try{
				List dtos = new ArrayList();
				String[] jobidArr = strJobid.split("\\^");
				String[] versionArr = versionStr.split("\\^");
				for (int i=0;i<jobidArr.length;i++){
					ZdhMachineworklistDto  zdhMachineworklistDto = new ZdhMachineworklistDto();	
					
									//设置主键值

					zdhMachineworklistDto.setJobid(jobidArr[i]);
					
				  			    //设置版本号

				
					zdhMachineworklistDto.setVersion(Integer.valueOf(versionArr[i]).intValue());
					//设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
					zdhMachineworklistDto.setZzdhmachineworklist1(null);
					
					dtos.add(zdhMachineworklistDto);
				}
				zdhMachineworklistFacade.deleteZdhMachineworklist(dtos);
				
				
			} catch (Exception e){
				e.printStackTrace();
			}
			return null;
		}
	/**
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

						QueryListObj qObj = zdhMachineworklistFacade.getZdhMachineworklistByHql(hqlSql, beginPage, pageSize,
								sumSql);
								

						dtolist = qObj.getElemList();

					}

					ZdhMachineworklistDto  zdhMachineworklistDto= (ZdhMachineworklistDto) dtolist.get(0);

					String mainId = zdhMachineworklistDto.getJobid();

					return this.printResponseMes(request, response, mapping, "null", mainId	+ "");

				}
  /**
    * @business method list
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
