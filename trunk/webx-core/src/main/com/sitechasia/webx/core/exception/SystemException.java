package com.sitechasia.webx.core.exception;

/**
 * 系统异常.
 *
 * 在基于webx的应用中，所有系统级异常（主要指JDK／J2ee等抛出的异常）都应该包装成这个异常再抛出。
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class SystemException extends BaseUnCheckedException {
	private static final long serialVersionUID = -6261781900635353686L;

	/**
	 * 指定异常信息的构造器
	 *
	 * @param msg
	 *            异常信息
	 */
	public SystemException(String msg) {
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
	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
