/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.web.struts1.action.aop;

import com.sitechasia.webx.core.exception.BaseUnCheckedException;

/**
 * 用于控制对Action层进行AOP操作的管理器
 *
 * @author Administrator
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */

public class AbortFollowingProcessException extends BaseUnCheckedException {
	private static final long serialVersionUID = -3529981079133506603L;

	/**
	 * 用于控制取消处理流程后的返回路径
	 */
	private String forward;

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	/**
	 * 构造方法
	 *
	 * @param msg
	 * 			出现异常后提示信息
	 */
	public AbortFollowingProcessException(String msg) {
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
	public AbortFollowingProcessException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
