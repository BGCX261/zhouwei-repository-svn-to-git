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
package com.sitechasia.webx.core.service.impl;

import org.apache.log4j.Logger;

import com.sitechasia.webx.core.service.IBaseService;


/**
 * 服务层基类,主要实现了对日志的封装
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public abstract class BaseService implements IBaseService {
	/**
	 * 日志对象.
	 *
	 * 在子类中不必单独定义日志对象，直接使用这里生成的即可
	 * 如:logger.info("*********");
	 */
	protected final Logger logger = Logger.getLogger(getClass());
}
