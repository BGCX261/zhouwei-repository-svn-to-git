package com.techstar.dmis.web.action;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.techstar.framework.service.dto.DictionaryBaseDto;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.dmis.web.facade.DictionaryBaseFacade;
import com.techstar.dmis.web.form.DictionaryBaseForm;

//please add your business methods start
	// to do it
//add your business method end

/**
 * 业务字典统一处理action类
 * @author 
 * @date
 */
public class DictionaryBaseAction extends BaseDispatchAction {
	private DictionaryBaseFacade dicBaseFacade;

	public DictionaryBaseAction() {
	}
	/**
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
		String poName = request.getParameter("poName");		
		// 查询列表
		List list = dicBaseFacade.listDic(poName);	
		request.getSession().setAttribute("list", list);
        
		// 记录操作日志
		//saveLog("dictest", "显示字典"+poName +"列表");
		return mapping.findForward(poName+"_list");
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
		String poName = request.getParameter("poName");
		
		DictionaryBaseForm dbf = (DictionaryBaseForm)form;
		DictionaryBaseDto dtoobj = dbf.getDtoInstance(poName);
		if( dtoobj == null ) return mapping.findForward("error");
		
		List list = dicBaseFacade.addDic(poName, dtoobj);
		request.getSession().setAttribute("list", list);
		request.setAttribute("msg", "操作成功");
		
		//saveLog("dictest", "增加字典"+poName +"记录");
		return mapping.findForward(poName + "_list");
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
	public ActionForward initAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String poName = request.getParameter("poName");
		return mapping.findForward(poName + "_add");
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
		String poName = request.getParameter("poName");
		String id = request.getParameter("id");
		
		DictionaryBaseForm dbf = (DictionaryBaseForm)form;
		if ( !StringUtils.isEmpty(id)) {
			Object dtoobj = dicBaseFacade.getDicById(poName, id);
			dbf.setDtoInstance(dtoobj);
		}
		
		//saveLog("dictest", "初始化字典"+poName +"记录");
		return mapping.findForward(poName+"_add");
	}
	
	/**
	 * 删除字典记录
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
		String poName = request.getParameter("poName");
		String id = request.getParameter("id");
		
		
		if ( !StringUtils.isEmpty(id)) {
			List list = dicBaseFacade.deleteDic(poName, id);
			request.getSession().setAttribute("list", list);
			request.setAttribute("msg", "操作成功!");
		}

		//saveLog("dictest", "删除指定字典"+poName +"记录:"+ id);
		return mapping.findForward(poName+"_list");
	}


	public void setDicBaseFacade(DictionaryBaseFacade dicBaseFacade) {
		this.dicBaseFacade = dicBaseFacade;
	}
	//please add your business methods start
	// to do it
    //add your business method end
}