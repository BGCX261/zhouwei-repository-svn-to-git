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
package com.sitechasia.webx.components.workflow.jbpm;

import java.util.Map;

/**
 * 流程执行完成后所返回的结果集
 *
 * @author Zal
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class ProcessResult {

	/**
	 * forward路径
	 */
	private String forwardPath;

	/**
	 * 在执行流程的过程中所有被传递过的参数集
	 */
	private Map params;

	public String getForwardPath() {
		return forwardPath;
	}

	public void setForwardPath(String forwardPath) {
		this.forwardPath = forwardPath;
	}

	public Map getParams() {
		return params;
	}

	public void setParams(Map params) {
		this.params = params;
	}
}
