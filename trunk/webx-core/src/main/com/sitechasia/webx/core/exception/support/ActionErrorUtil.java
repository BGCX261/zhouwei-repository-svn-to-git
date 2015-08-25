package com.sitechasia.webx.core.exception.support;

import org.apache.struts.action.ActionMessage;

/**
 * Action常用的错误类信息
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public class ActionErrorUtil {
	/**
	 * 全局错误编码 GLOBAL_ERR_CODE=
	 * <li>错误码：{0}</li>
	 * <li>错误类别：{1}</li>
	 * <li>错误描述：{2}</li>
	 * <li>错误消息：{3}</li>
	 * DEFAULT_ERR_CODE=
	 * <li>错误消息：{0}</li>
	 */
	public static final String GLOBAL_ERR_CODE = "app.global.error";
	public static final String DEFAULT_ERR_CODE = "app.default.error";

	/**
	 * 从异常得到ActionError
	 *
	 * @param cause
	 * @return return ActionError
	 */
	public static ActionMessage getActionError(Throwable cause) {
		ExceptionWrapper wrapper = ExceptionWrapperFactory.getExceptionWrapper(cause);
		if (wrapper != null) {
			return getActionMessage(wrapper);
		} else {
			return new ActionMessage(DEFAULT_ERR_CODE, cause.getMessage());
		}
	}

	/**
	 * 从对异常的封装,得到ActionMessage
	 *
	 * @param exceptionWrapper
	 * @return return BaseError
	 */
	public static ActionMessage getActionMessage(ExceptionWrapper exceptionWrapper) {
		if (exceptionWrapper.getCode() == null) {
			return new ActionMessage(DEFAULT_ERR_CODE, exceptionWrapper.getMessage());
		} else {
			return new ActionMessage(GLOBAL_ERR_CODE, exceptionWrapper.getCode(), exceptionWrapper.getType(),
					exceptionWrapper.getDescription(), exceptionWrapper.getMessage());
		}
	}
}
