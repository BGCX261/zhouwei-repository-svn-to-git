package com.sitechasia.webx.core.exception;

import org.springframework.core.NestedCheckedException;

/**
 * 所有checked异常的基类
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public class BaseCheckedException extends NestedCheckedException {
	private static final long serialVersionUID = 2631490367837964953L;

	/**
	 * 构造方法
	 *
	 * @param msg
	 * 			出现异常后提示信息
	 */
	public BaseCheckedException(String msg) {
		super(msg);
	}

	/**
	 * 构造方法
	 *
	 * @param msg
	 * 			出现异常后提示信息
	 * @param ex
	 * 			抛出的异常
	 */
	public BaseCheckedException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
