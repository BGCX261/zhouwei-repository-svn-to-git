package com.techstar.framework.demo.apply.web.action;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.techstar.framework.demo.apply.web.facade.ApplyFacade;
import com.techstar.framework.demo.apply.web.form.ApplyForm;
import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.web.action.BaseDispatchAction;

/**
 * @author caojian May 17, 2006
 * modify by xcf
 * modify by scg
 */
public class ApplyAction extends BaseDispatchAction {
	private ApplyFacade applyFacade;

	public ApplyAction() {
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
//		 查询列表
		List list = applyFacade.listApply();
		request.getSession().setAttribute("applyList", list);

		// 记录操作日志־
		saveLog("applyer", "查询申请列表");
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
		
		ApplyForm applyForm = (ApplyForm) form;
		ApplyDto dto = applyForm.getApplyDto();
		//附件处理
		FormFile attachment = applyForm.getAttachment();
		if( attachment != null ){
	        	dto.setAttachment( attachment.getFileData() );
	        	dto.setAttachmentName( attachment.getFileName() );
	    }
		
		//如果'申请标题'为空,则是第一次打开'新增业务'表单,否则为新建申请业务操作
		if(dto.getApplyTitle() != null) {
			if( StringUtils.isEmpty(dto.getApplyId())){
				dto.setApplyId( new SequenceCreator().getUID() ); //生成内部序列号
				applyFacade.addApply(dto);
			}
			saveLog("applyer", "增加申请记录");			
		}
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
		ApplyForm applyForm = (ApplyForm) form;
		String applyId = request.getParameter("applyId");
		if (StringUtils.isNotEmpty(applyId)) {
			ApplyDto dto = applyFacade.getApplyById(applyId);
			applyForm.setApplyDto(dto);
		}
		
		saveLog("applyer", "初始化申请记录操作");
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
		String applyId = request.getParameter("applyId");
		if (StringUtils.isNotEmpty(applyId)) {
			List list = applyFacade.deleteApply(applyId);
			request.getSession().setAttribute("applyList", list);
		}

		saveLog("applyer", "删除申请记录操作");
		return mapping.findForward("list");
	}

	public void setApplyFacade(ApplyFacade applyFacade) {
		this.applyFacade = applyFacade;
	}
	

	/**
	 * function : 发起新的流程
	 * date :  2006-12-06
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward start(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String applyId = request.getParameter("applyId");
		String actorId = request.getParameter("actorid");
		
		//发起流程，离开start节点
		applyFacade.start("demo",applyId);
		
		//记录系统日志	
		saveLog("applyer", "发起流程操作,applyid="+applyId);	
		
		List applyList = applyFacade.getApplyList(actorId);		
		request.getSession().setAttribute("applyList", applyList);
		request.setAttribute("actorid",actorId);
		return mapping.findForward("list");
	}	
	
	/**
	 * function :获取业务流程列表,该方法为配合现有工作流-demo
	 * date :  2006-12-06
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listApply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String actorid = request.getParameter("actorid");
		if(null == actorid) {
			actorid = "auditing";
		}	
        //获取缺省用户业务申请列表
		List applyList = applyFacade.getApplyList(actorid);	
		
		request.getSession().setAttribute("applyList", applyList);		
		request.setAttribute("actorid",actorid);		
		// 记录操作日志
		saveLog("applyer", "查询申请列表");
		return mapping.findForward("list");
	}	

	/**
	 * function : 执行当前任务,该方法为配合现有工作流-demo
	 * date :  2006-12-06
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward endTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取参数
		String taskId = request.getParameter("taskId");
		String applyId = request.getParameter("applyId");
		String actorId = request.getParameter("actorid");
		//执行当前任务
		applyFacade.endTask(Long.valueOf(taskId).longValue(),applyId);	
		List applyList = applyFacade.getApplyList(actorId);
		//日志记录
		saveLog("applyer", "流程流转操作");	
				
		request.getSession().setAttribute("applyList", applyList);
		request.setAttribute("actorid",actorId);
		
		return mapping.findForward("list");
	}

	/**
	 * 下载附件
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String applyId = request.getParameter("applyId");
		ApplyDto dto = applyFacade.getApplyById(applyId);
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;" + " filename="
				+ new String(dto.getAttachmentName().getBytes(), "ISO-8859-1"));

		OutputStream os = response.getOutputStream();
		os.write(dto.getAttachment());
		os.flush();
		return null;
	}
	

}
