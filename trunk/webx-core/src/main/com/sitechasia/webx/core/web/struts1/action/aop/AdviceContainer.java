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

import java.util.Set;

import org.aopalliance.aop.Advice;

/**
 * 用于包含一组Advice的容器
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class AdviceContainer {
	private Set<Advice> advices;

	public Set<Advice> getAdvices() {
		return advices;
	}

	public void setAdvices(Set<Advice> advices) {
		this.advices = advices;
	}
}
