package com.sitechasia.webx.core.exception;

/**
 * 数据存取层异常.
 *
 * 在基于webx的应用中，所有在数据存取层出现的异常都应该是这个异常的子类
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class DataAccessLayerException extends BaseUnCheckedException {
	private static final long serialVersionUID = 2631490367837964952L;

	/**
	 * @param msg
	 *            消息
	 * @param ex
	 *            异常,通常是导致异常的原因
	 */
	public DataAccessLayerException(String msg, Throwable ex) {
		super(msg, ex);
	}

	/**
	 * @param msg
	 *            异常消息
	 */
	public DataAccessLayerException(String msg) {
		super(msg);
	}
}
