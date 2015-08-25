package com.sitechasia.webx.core.exception.support;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/**
 * 异常信息包装类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public class ExceptionWrapper {
	public static final String Code = "Code";
	public static final String Type = "Type";
	public static final String Severity = "Severity";
	public static final String Description = "Description";
	public static final String Message = "Message";
	private ExceptionInfo exceptionInfo;
	private Throwable cause;

	public ExceptionWrapper(ExceptionInfo exceptionInfo, Throwable cause) {
		this.exceptionInfo = exceptionInfo;
		this.cause = cause;
	}

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return exceptionInfo == null ? null : this.exceptionInfo.getCode();
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return exceptionInfo == null ? null : this.exceptionInfo.getDescription();
	}

	/**
	 * @return Returns the severity.
	 */
	public int getSeverity() {
		return exceptionInfo == null ? 0 : this.exceptionInfo.getSeverity();
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return exceptionInfo == null ? null : this.exceptionInfo.getType();
	}

	/**
	 * @return Returns the cause.
	 */
	public Throwable getCause() {
		return cause;
	}

	public String getCauseStackTrace() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintWriter pw = new PrintWriter(baos);
		cause.printStackTrace(pw);
		pw.flush();
		return new String(baos.toByteArray());
	}

	/**
	 *
	 * @return Return the messgae
	 */
	public String getMessage() {
		return cause == null ? null : cause.getMessage();
	}
}
