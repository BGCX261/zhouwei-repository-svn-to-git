package com.techstar.dmis.web.action;

import java.util.HashMap;
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

import com.techstar.dmis.web.facade.GgPersonFacade;
import com.techstar.dmis.web.form.GgPersonForm;
import com.techstar.dmis.dto.GgPersonDto;
import com.techstar.dmis.helper.SQLHealp;
//please add your business methods start
	// to do it
//add your business method end


/**
 * @author 
 * @date
 */
public class GgPersonAction 
              extends BaseDispatchAction {
	private GgPersonFacade ggPersonFacade;
    private SysUiGridFacade sysUiGridFacade;
	public GgPersonAction() {
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
		List list = ggPersonFacade.listGgPerson();
		request.getSession().setAttribute("GgPersonList", list);

		// 记录操作日志
		//saveLog("GgPersoner", "查询列表");
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
		GgPersonForm ggPersonForm = (GgPersonForm) form;
		GgPersonDto dto = ggPersonForm.getGgPersonDto();
	    
		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getId())){
             dto.setId( new SequenceCreator().getUID() ); //生成内部序列号
        }
			ggPersonFacade.addGgPerson(dto);
		
		
		//saveLog("GgPersoner", "增加记录");
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
		GgPersonForm ggPersonForm = (GgPersonForm) form;
		String id= request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			GgPersonDto dto = ggPersonFacade.getGgPersonById(id);
			ggPersonForm.setGgPersonDto(dto);
		}
		
		//saveLog("GgPersoner", "初始化记录操作");
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
			List list = ggPersonFacade.deleteGgPerson(id);
			request.getSession().setAttribute("GgPersonList", list);
		}

		//saveLog("GgPersoner", "删除记录操作");
		return mapping.findForward("list");
	}

	public void setGgPersonFacade(GgPersonFacade ggPersonFacade) {
		this.ggPersonFacade = ggPersonFacade;
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

		
		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = ggPersonFacade.getGgPersonByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}	
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ggPersongrid",xmlStr);
	}
		
		
		
		   


     
  
  		
		
		
		   		 //初始化toolbar
	     public ActionForward ggPersontoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			String method =  "<Toolbar>   <Business>      <id>GgPerson</id>      <name>人员</name>   </Business>   <ReportUrl>/report.do</ReportUrl></Toolbar>";
			
		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ggPersontoolbar");
	    }

		


     
  
  		
		
		
			    //初始化tab页
			public ActionForward ggPersontab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ggPersontab");
	     }
		   


     
  
  		
		public ActionForward ggPersonframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ggPersonframe");
	}	
		
		
		   


     
  
  		
		
		
		   


  	//处理DETAIL页面
	
			
	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 GgPersonForm ggPersonForm = (GgPersonForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		GgPersonDto ggPersonDto = null;
		
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ggPersonDto = ggPersonFacade.getGgPersonById(mainId);
				ggPersonDto.setVersion(0);
				//ggPersonDto.setId(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ggPersonDto = ggPersonFacade.getGgPersonById(mainId);
			} else {// 新增
				ggPersonDto = new GgPersonDto();
			}
		}
		ggPersonForm.setGgPersonDto(ggPersonDto);
		   return mapping.findForward("ggPersondetail");
		   }
		
	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GgPersonForm  ggPersonForm = ( GgPersonForm) form;
		GgPersonDto  ggPersonDto = ggPersonForm.getGgPersonDto();
		ggPersonFacade.addGgPerson(ggPersonDto);
		ggPersonDto = ggPersonFacade.getGgPersonById(ggPersonDto.getId());
		ggPersonForm.setGgPersonDto(ggPersonDto);
		saveMessages(request, "message.save.success", new String[] { "人员Dto" });
		return mapping.findForward("ggPersondetail");
	}
	     
	  public ActionForward getDispatchPerson(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String userId = "user"; //用户ID
            String hqlStr="";
			//取到表格的信息
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			String outhql = gridInfo.getHqlSql();
			System.out.println(outhql);
			//FROM GgPerson t ORDER BY t.name asc
			//FROM GgPerson t  WHERE t.name LIKE '%dddd%'
			int count = 0;
			//通过日计划ID来查询方式变更
			
			String hql = "select t from GgPerson t, DdDispatcher d where d.zdddispatcher2.id = t.id";
			String  newhql = SQLHealp.analysisHQL(outhql,hql);
			
			List dtolist = new ArrayList();
			List sumInfo = new ArrayList();
			QueryListObj queryObj = ggPersonFacade.getGgPersonByHql(newhql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
			String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
			System.out.println(xmlStr);
			return this.printResponseMes(request,response,mapping,"",xmlStr);
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
