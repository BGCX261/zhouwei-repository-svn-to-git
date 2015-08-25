package com.techstar.framework.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.techstar.framework.service.dto.LogInfoDTO;
import com.techstar.framework.service.log.ILogService;
import com.techstar.framework.web.servlet.SqlDateConverter;
import com.techstar.framework.web.servlet.SqlTimestampConverter;

/**
 * ���ദ��Ϊ����ܵĻ����Ļ�DispatchAction�࣬������Ҫ�̳�STRUTS�Ļ�DispatchAction��
 * 
 * @author caojian Nov 1, 2006
 * 
 */
public class BaseDispatchAction extends DispatchAction {
	Logger logger = Logger.getLogger(getClass());

	private ILogService logService;
	
	public BaseDispatchAction() {
		super();
	}
	
	//注册自定义的转换类，解决提交form时日期、时间不能为空的问题
    static {
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
    }
    
	public ActionMessages getMessages(HttpServletRequest request) {
		ActionMessages messages = null;
		HttpSession session = request.getSession();

		if (request.getAttribute(Globals.MESSAGE_KEY) != null) {
			messages = (ActionMessages) request
					.getAttribute(Globals.MESSAGE_KEY);
			saveMessages(request, messages);
		} else if (session.getAttribute(Globals.MESSAGE_KEY) != null) {
			messages = (ActionMessages) session
					.getAttribute(Globals.MESSAGE_KEY);
			saveMessages(request, messages);
			session.removeAttribute(Globals.MESSAGE_KEY);
		} else {
			messages = new ActionMessages();
		}
		return messages;
	}

	public void saveMessages(HttpServletRequest request, String messageKey,
			Object[] params) {
		ActionMessages messages = (ActionMessages) request
				.getAttribute(Globals.MESSAGE_KEY);
		if (messages == null) {
			messages = new ActionMessages();
		}
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				messageKey, params));
		saveMessages(request, messages);
	}
	
	/**
	 * 向客户端打印response字串[用于表格]
	 * 
	 * @param request
	 * @param response
	 * @param mapping        
	 * @param jumpAddress    跳转地址
	 * @param xmlStr         预打印字串
	 * @return 
	 */ //add By MaJian
	public ActionForward printResponseMes(HttpServletRequest request,
										  HttpServletResponse response,
										  ActionMapping mapping,
										  String jumpAddress,
										  String xmlStr){
		ActionForward actionForward = null;
		try{
			
			
			if(!StringUtils.isEmpty(xmlStr)){
				response.setContentType("text/xml;charset=UTF-8");
				response.setHeader("Cache-Control", "no-cache");
				
				PrintWriter out = response.getWriter(); 
				out.print(xmlStr);
			}
			
			if(StringUtils.isEmpty(request.getParameter("gridSign"))){
				actionForward = mapping.findForward(jumpAddress);
			}
		}catch(Exception e){
			System.out.println("<=============================printResponseMes==============================>");
				e.printStackTrace();
			System.out.println("<=============================printResponseMes==============================>");
		}
		return actionForward;
		
	}

	//��¼������־
	public void saveLog(String userName, String msg) throws Exception{
		logService.saveLogToDb(new LogInfoDTO(userName,
				new java.sql.Timestamp(System.currentTimeMillis()), msg));
	}
	
	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
}
