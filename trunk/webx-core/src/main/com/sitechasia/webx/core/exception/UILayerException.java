package com.sitechasia.webx.core.exception;


/**
 * 表示层异常.
 *
 * 在基于webx的应用中，所有在表示层抛出的异常都应包装成这个异常或者它的子类
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class UILayerException extends BaseUnCheckedException {
	private static final long serialVersionUID = 6558618122888338723L;

	/**
	 * 指定异常信息的构造器
	 *
	 * @param msg
	 *            异常信息
	 */
	public UILayerException(String msg) {
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
	public UILayerException(String message, Throwable cause) {
		super(message, cause);
	}
}