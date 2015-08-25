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
package com.sitechasia.webx.components.jmx;

import com.sitechasia.webx.core.exception.SystemException;

/**
 * 自定义的内部使用的异常
 *
 * @author CE
 * @version 1.2 , 2008/5/12
 * @since JDK1.5
 */
public class JMXRuntimeException extends SystemException {

	static final long serialVersionUID = Long.MIN_VALUE;

	public JMXRuntimeException(String message) {
		super(message);
	}

	public JMXRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
