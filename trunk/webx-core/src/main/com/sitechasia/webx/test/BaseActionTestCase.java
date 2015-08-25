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
package com.sitechasia.webx.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servletunit.struts.MockStrutsTestCase;

/**
 * action单元测试基类, Mock对象则选用MockStrutsTestCase作为基类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public abstract class BaseActionTestCase extends MockStrutsTestCase {

	protected WebApplicationContext ctx = null;

	// ~ Constructors ===========================================================
	public BaseActionTestCase(String name) {
		super(name);
	}

	// ~ Methods ================================================================
	// 使用setUp和tearDown进行初始化，明确这两个函数的第一句话是调用super的方法。
	protected void setUp() throws Exception {

		super.setUp();
		// initialize Spring
		MockServletContext sc = new MockServletContext("");
		sc.addInitParameter(ContextLoader.CONFIG_LOCATION_PARAM, "classpath*:modules/spring.xml,"
				+ "classpath*:modules/**/spring-conf/*.xml");
		ServletContextListener contextListener = new ContextLoaderListener();
		ServletContextEvent event = new ServletContextEvent(sc);
		contextListener.contextInitialized(event);
		// magic bridge to make StrutsTestCase aware of Spring's Context
		getSession().getServletContext().setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
				sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE));
		ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getSession().getServletContext());
	}

	public void tearDown() throws Exception {
		super.tearDown();
		ctx = null;
	}
}