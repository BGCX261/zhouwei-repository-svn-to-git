package com.techstar.framework.demo.workflow.web.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jbpm.graph.exe.Token;
import org.jbpm.logging.log.ProcessLog;

import com.techstar.framework.demo.workflow.web.facade.WorkflowFacade;
import com.techstar.framework.demo.workflow.web.form.WorkflowForm;
import com.techstar.framework.web.action.BaseDispatchAction;

public class WorkflowAction extends  BaseDispatchAction{
	private WorkflowFacade workflowFacade;
	public void setWorkflowFacade(WorkflowFacade workflowFacade) {
		this.workflowFacade = workflowFacade;
	}
	
	

	public ActionForward start(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		workflowFacade.start("demo","test");
		return mapping.findForward("success");
	}
	
	public ActionForward getTasks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		WorkflowForm workflowForm = (WorkflowForm)form;
		
		List list = workflowFacade.findPooledTaskInstances(workflowForm.getActor());
		
		request.setAttribute("objectlist", list);
		return mapping.findForward("list");
	}	
	
	public ActionForward endTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String taskId = request.getParameter("taskId");
		workflowFacade.endTask(Long.valueOf(taskId).longValue());
		return mapping.findForward("success");
	}
	
	public ActionForward getGpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String processId = request.getParameter("processId");
		System.out.println(processId);
		System.out.println("logtest:");
		List list = workflowFacade.findTransitionLog(Long.parseLong(processId));

		String taskId = request.getParameter("taskId");
		String xml = workflowFacade.retrieveByteArraysOfGpd(Long.valueOf(taskId).longValue());
		request.setAttribute("xml", xml);
		return mapping.findForward("xml");
	}	

}
