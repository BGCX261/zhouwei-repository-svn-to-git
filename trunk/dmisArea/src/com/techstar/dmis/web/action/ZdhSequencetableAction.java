package com.techstar.dmis.web.action;

import java.util.List;
import java.util.Map;
import java.io.File;
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
import com.techstar.framework.ui.web.facade.TagEngineFacade;

import com.techstar.dmis.web.facade.ZdhSequencetableFacade;
import com.techstar.dmis.web.form.ZdhSequencetableForm;
import com.techstar.dmis.dto.ZdhSequencetableDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.dto.ZdhTransrecordDto;

import com.techstar.framework.utils.ConfigurationHelper;
/**
 * @author 
 * @date
 */
public class ZdhSequencetableAction 
              extends BaseDispatchAction {
	private ZdhSequencetableFacade zdhSequencetableFacade;
    private SysUiGridFacade sysUiGridFacade;
	public ZdhSequencetableAction() {
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
		List list = zdhSequencetableFacade.listZdhSequencetable();
		request.getSession().setAttribute("ZdhSequencetableList", list);

		// 记录操作日志
		//saveLog("ZdhSequencetableer", "查询列表");
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
		ZdhSequencetableForm zdhSequencetableForm = (ZdhSequencetableForm) form;
		ZdhSequencetableDto dto = zdhSequencetableForm.getZdhSequencetableDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFsequenceno())){
             dto.setFsequenceno( new SequenceCreator().getUID() ); //生成内部序列号
        }
			zdhSequencetableFacade.addZdhSequencetable(dto);
		
		
		//saveLog("ZdhSequencetableer", "增加记录");
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
		ZdhSequencetableForm zdhSequencetableForm = (ZdhSequencetableForm) form;
		String fsequenceno= request.getParameter("fsequenceno");
		if (StringUtils.isNotEmpty(fsequenceno)) {
			ZdhSequencetableDto dto = zdhSequencetableFacade.getZdhSequencetableById(fsequenceno);
			zdhSequencetableForm.setZdhSequencetableDto(dto);
		}
		
		//saveLog("ZdhSequencetableer", "初始化记录操作");
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
		String fsequenceno = request.getParameter("fsequenceno");
		if (StringUtils.isNotEmpty(fsequenceno)) {
			List list = zdhSequencetableFacade.deleteZdhSequencetable(fsequenceno);
			request.getSession().setAttribute("ZdhSequencetableList", list);
		}

		//saveLog("ZdhSequencetableer", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setZdhSequencetableFacade(ZdhSequencetableFacade zdhSequencetableFacade) {
		this.zdhSequencetableFacade = zdhSequencetableFacade;
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
		ZdhSequencetableFacadeDto zdhSequencetableDto = new ZdhSequencetableDto();
					//zdhSequencetableDto.setCustom_id("custom_id");
					//zdhSequencetableDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(zdhSequencetableDto);
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
//		gridObj.setBusName("ZdhSequencetableDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("ZdhSequencetable");
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
			QueryListObj queryObj = zdhSequencetableFacade.getZdhSequencetableByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"zdhSequencetablegrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward zdhSequencetabletoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>ZdhSequencetable</id>      <name>序位表</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='excel导入' id='FExcelin' href='importExcel' title=''></OperItem></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("zdhSequencetabletoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward zdhSequencetabletab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("zdhSequencetabletab");
	     }
		   


     
  
  		
		public ActionForward zdhSequencetableframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("zdhSequencetableframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhSequencetableForm zdhSequencetableForm = (ZdhSequencetableForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		ZdhSequencetableDto zdhSequencetableDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				zdhSequencetableDto = zdhSequencetableFacade.getZdhSequencetableById(mainId);
				zdhSequencetableDto.setVersion(0);
				//zdhSequencetableDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				zdhSequencetableDto = zdhSequencetableFacade.getZdhSequencetableById(mainId);
			} else {// 新增
				zdhSequencetableDto = new ZdhSequencetableDto();
			}
		}
		zdhSequencetableForm.setZdhSequencetableDto(zdhSequencetableDto);
		   return mapping.findForward("zdhSequencetabledetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ZdhSequencetableForm  zdhSequencetableForm = ( ZdhSequencetableForm) form;
		 ZdhSequencetableDto  zdhSequencetableDto = zdhSequencetableForm.getZdhSequencetableDto();
		zdhSequencetableFacade.addZdhSequencetable(zdhSequencetableDto);
		zdhSequencetableDto = zdhSequencetableFacade.getZdhSequencetableById(zdhSequencetableDto.getFsequenceno());
		zdhSequencetableForm.setZdhSequencetableDto(zdhSequencetableDto);
		saveMessages(request, "message.save.success", new String[] { "序位表Dto" });
		return mapping.findForward("zdhSequencetabledetail");
	}
	 	
	   
     
  
  	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	/**
	 * excl信息导入
	 */
	public ActionForward importExcel(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		return mapping.findForward("importExcel");
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
		String strFsequenceno = request.getParameter("fsequenceno");
		String versionStr = request.getParameter("versions");
		System.out.println("主键参数:"+strFsequenceno);
		System.out.println("版本参数:"+versionStr);
		try{
			List dtos = new ArrayList();
			String[] fsequencenoArr = strFsequenceno.split("\\^");
			String[] versionArr = versionStr.split("\\^");
			for (int i=0;i<fsequencenoArr.length;i++){
				
				ZdhSequencetableDto zdhSequencetableDto = new ZdhSequencetableDto();
								//设置主键值
				zdhSequencetableDto.setFsequenceno(fsequencenoArr[i]);
				
			  			    //设置版本号

				zdhSequencetableDto.setVersion(Integer.valueOf(versionArr[i]).intValue());
				//设置子对象,因为只能删除临时状态的单据,不必考虑当前的单据是否被引用
			
				dtos.add(zdhSequencetableDto);
			}
			zdhSequencetableFacade.deleteZdhSequencetable(dtos);
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	  public ActionForward saveModechangeGrid(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
		throws Exception {
			try{
				String head = request.getParameter("head");
				String dates = request.getParameter("dates");
				String parentid = request.getParameter("parentid");
				response.setContentType("text/xml;charset=utf-8");
				System.out.println(head);
				System.out.println(dates);
				File[] files = ConfigurationHelper.getGridDisFile();
				String classPath  = "";
				if(files.length > 0){
					String path = files[0].getParent();
					classPath  += path+"\\"+"ZdhSequencetableDto"+".xml";
				}
				//return classPath;
				TagEngineFacade engine = new TagEngineFacade();
				String filePath = classPath;
				ZdhSequencetableDto zdhSequencetableDto = new ZdhSequencetableDto();
				List list = engine.getDtoList(head, dates,zdhSequencetableDto,filePath);
				zdhSequencetableFacade.saveOrUpdateDdfsModechangelist(list);
				String strUrl="";
				strUrl=request.getRealPath("")+"\\common\\excel\\importSql.xml";
				//strUrl=request.getContextPath()+"/common/excel/importSql.xml";
				zdhSequencetableFacade.RepDelete(strUrl);
				response.getWriter().println("1");
			}catch(Exception e){
				e.printStackTrace();
				response.getWriter().println("0");
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

						QueryListObj qObj = zdhSequencetableFacade.getZdhSequencetableByHql(hqlSql, beginPage, pageSize,
								sumSql);
								

						dtolist = qObj.getElemList();

					}

					ZdhSequencetableDto zdhSequencetableDto = (ZdhSequencetableDto) dtolist.get(0);

					String mainId = zdhSequencetableDto.getFsequenceno();

					return this.printResponseMes(request, response, mapping, "null", mainId
							+ "");

				}
	
  /**
    * @business method list
	 	* @excel导入
	  */	
	//please add your business methods start
	// to do it
    //add your business method end
}
