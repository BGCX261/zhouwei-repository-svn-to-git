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
package com.sitechasia.webx.core.web.struts1.servlet;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sitechasia.webx.core.utils.base.ResourceBinder;
import com.sitechasia.webx.core.utils.base.ResourceFinder;

/**
 * 扩展了Struts的ActionServlet，使其从固定位置读取配置信息。
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class MoudelConfigStrutsActionServlet extends ActionServlet {
	private static final long serialVersionUID = -3689460912954579063L;

//	public MoudelConfigStrutsActionServlet() {
//		ResourceBinder binder = getResourceBinder();
//		String[] strutsConfigFileArray = ResourceFinder.getStruts();
//		String files = "";
//		for (String configFile : strutsConfigFileArray) {
//			files += "/WEB-INF/classes/" + configFile + ",";
//		}
//		if (files.lastIndexOf(",") > -1) {
//			this.config = files.substring(0, files.lastIndexOf(","));
//		}
//	}

	/**
	 * 初始化ActionServlet
	 */
	public void init() throws ServletException {
		ResourceBinder binder = getResourceBinder();
		if(binder != null) {
			//新模式
			String[] strutsConfigFileArray = binder.getResourceFile();
			String files = "";
			for (String configFile : strutsConfigFileArray) {
				files += "/WEB-INF/classes/" + configFile + ",";
			}
			if (files.lastIndexOf(",") > -1) {
				super.config = files.substring(0, files.lastIndexOf(","));
			}
		} else {
			//1.2标准模式
			String[] strutsConfigFileArray = ResourceFinder.getStruts();
			String files = "";
			for (String configFile : strutsConfigFileArray) {
				files += "/WEB-INF/classes/" + configFile + ",";
			}
			if (files.lastIndexOf(",") > -1) {
				this.config = files.substring(0, files.lastIndexOf(","));
			}
		}
		
       super.init();
    }

	private ResourceBinder getResourceBinder() {
		try {
			WebApplicationContext wc = WebApplicationContextUtils
	        .getWebApplicationContext(this.getServletConfig().getServletContext());
			ResourceBinder binder = (ResourceBinder)wc.getBean("strutsResourceBinder");
			return binder; 
		} catch (Exception e) {
			return null;
		}
	}
}
