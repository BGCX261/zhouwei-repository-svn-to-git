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
 * 由展现层调用jbpm的接口
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public interface IProcessExecutor {

	public static final String TRANSITION_NAME = "TRANSITION_NAME";

	public static final String FORWARD_NAME = "FORWARD_NAME";

	public ProcessResult execute(Map<String, Object> params);
}
