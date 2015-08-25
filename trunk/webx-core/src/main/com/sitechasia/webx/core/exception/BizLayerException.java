package com.sitechasia.webx.core.exception;


/**
 * 业务层异常.
 *
 * 在基于webx的应用中，所有在业务层出现的异常都应该是这个异常的子类
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class BizLayerException extends BaseUnCheckedException {
	private static final long serialVersionUID = 2631490367837964951L;

	/**
	 * 指定异常信息的构造器
	 *
	 * @param msg
	 *            异常信息
	 */
	public BizLayerException(String msg) {
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
	public BizLayerException(String message, Throwable cause) {
		super(message, cause);
	}
}
