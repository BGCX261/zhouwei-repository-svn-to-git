package com.sitechasia.webx.core.exception.support;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ExceptionHandler;

/**
 * Struts异常处理类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public final class StrutsExceptionHandler extends ExceptionHandler {
	private static final long serialVersionUID = 2631490367837964960L;
	private static final Logger logger = Logger.getLogger(StrutsExceptionHandler.class);
	public static final String WEBX_THE_EXCEPTION_KEY = "WEBX_THE_EXCEPTION_KEY";

	protected void storeException(HttpServletRequest request, String property, ActionMessage error,
			ActionForward forward, String scope) {
		Throwable cause = getExceptionFrmReqest(request);
		logger.warn("Exception Caught:", cause);
		ExceptionWrapper wrapper = ExceptionWrapperFactory.getExceptionWrapper(cause);
		if (wrapper != null) {
			error = ActionErrorUtil.getActionMessage(wrapper);
		} else {
			error = new ActionMessage(ActionErrorUtil.DEFAULT_ERR_CODE, cause.getMessage());
		}
		request.setAttribute(WEBX_THE_EXCEPTION_KEY, wrapper);
		property = error.getKey();
		super.storeException(request, property, error, forward, scope);
	}

	/**
	 * 得到一个请求异常
	 * @param request
	 * @return 相应的异常
	 */
	public Exception getExceptionFrmReqest(HttpServletRequest request) {
		return (Exception) request.getAttribute(Globals.EXCEPTION_KEY);
	}
}
