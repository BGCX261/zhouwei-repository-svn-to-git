package com.sitechasia.webx.core.exception;


/**
 * 框架异常.
 *
 * 在基于webx的应用中，所有在框架层（spring／hibernate）抛出的异常都应包装成这个异常或者它的子类
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class FrameworkException extends BaseUnCheckedException {
	private static final long serialVersionUID = 6423595491411633215L;

	/**
	 * 指定异常信息的构造器
	 *
	 * @param msg
	 *            异常信息
	 */
	public FrameworkException(String msg) {
		super(msg);
	}

	/**
	 * 同时指定父异常和异常信息的构造器
	 *
	 * @param message
	 *            异常信息
	 * @param cause
	 *            父异常
	 */
	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}
}