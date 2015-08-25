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
package com.sitechasia.webx.core.utils.context;

import javax.servlet.http.HttpSession;

import com.sitechasia.webx.core.web.struts1.StrutsWebData;

/**
 * 一个会话内所使用的Context，该实现与Web应用中的HttpSession会话对象同时被销毁。
 *
 * @author Zal
 * @version 1.2 , 2008/5/8
 * @since JDK1.5
 */
public final class UserDataContext extends BaseContext {

	/**
	 * 用于将本对象保存到HttpSession中所使用的常量
	 */
	private static final String USER_DATA_CONTEXT = "SESSION_STORED_USER_DATA_CONTEXT_OBJECT";

	/**
	 * 私有的构造函数防止用户随意生成对象
	 */
	private UserDataContext() {}

	/**
	 * 静态的工厂方法返回一个UserDataContext对象，
	 * 如果session中已经存在一个UserDataContext对象则返回该对象
	 * 否则生成一个对象，放入session中并返回
	 * @return 一个与session同步的UserDataContext对象
	 */
	public static IContext getInstance() {

		/**
		 * 获得一个HttpSession，如果没有与当前请求的Session则不创建新的Session
		 */
		HttpSession session = StrutsWebData.getStrutsWebData().getRequest().getSession(false);

		/**
		 * 如果没有Session则表示也没有UserDataContext对象，
		 * 返回NULL
		 */
		if (session == null) {
			return null;
		}

		/**
		 * 从Session中获得这个对象
		 */
		UserDataContext userContext = (UserDataContext)session.getAttribute(USER_DATA_CONTEXT);

		/**
		 * 如果不存在则创建一个新的对象
		 */
		if (userContext == null) {
			synchronized(UserDataContext.class) {
				if (session.getAttribute(USER_DATA_CONTEXT) == null) {
					userContext = new UserDataContext();
					session.setAttribute(USER_DATA_CONTEXT, userContext);
				}
			}
		}

		return userContext;
	}
}
