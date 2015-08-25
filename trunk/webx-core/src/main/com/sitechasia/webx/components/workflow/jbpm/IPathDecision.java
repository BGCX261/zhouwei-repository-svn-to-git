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

/**
 * 用于分支选择的实现所必需继承的接口
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public interface IPathDecision {

	/**
	 * 进行分支选择所要实现的方法
	 * @param objs 进行分支选择所需要的参数
	 * @return 被选择的路径名称
	 */
	public String calculatePath(Object... objs);

}
