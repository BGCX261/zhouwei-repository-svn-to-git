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
package com.sitechasia.webx.core.utils.commons;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * web相关操作的工具类. 重载Spring WebUtils中的函数
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class WebUtils extends org.springframework.web.util.WebUtils {
	/**
	 * 获取Session中的某个属性
	 *
	 * @param <T>
	 * @param name
	 *            session中变量名称
	 * @param clazz
	 *            session中变量的类型
	 * @param request
	 *            Http请求对象
	 * @return 获取到的变量值
	 *
	 * <pre>
	 * //取出一个Cart类型的名称为cart的session变量
	 * WebUtils.getOrCreateSessionAttribute(request, &quot;cart&quot;, Cart.Class);
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getOrCreateSessionAttribute(HttpServletRequest request, final String name, final Class<T> clazz) {
		return (T) getOrCreateSessionAttribute(request.getSession(), name, clazz);
	}

	/**
	 * 从http请求中获取指定名称的属性对象
	 *
	 * @param <T>
	 * @param req
	 *            http请求
	 * @param name
	 *            属性名称
	 * @param clazz
	 *            属性类型的类对象
	 * @return 属性对象
	 *
	 * <pre>
	 * //取出一个Cart类型的名称为cart的请求属性
	 * WebUtils.getRequestAttribute(request, &quot;cart&quot;, Cart.Class);
	 * //相当于传统的 (Cart)request.getAttribute(&quot;cart&quot;);
	 * //但不再需要造型
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getRequestAttribute(HttpServletRequest req, final String name, final Class<T> clazz) {
		return (T) req.getAttribute(name);
	}

	/**
	 * 从http请求中获取指定名称的Cookie信息
	 *
	 * @param req
	 *            http请求
	 * @param name
	 *            cookie名称
	 * @return 取得的cookie值
	 *
	 * <pre>
	 * //取出一个名称为cart的Cookie值
	 * WebUtils.getCookieAttribute(request, &quot;cart&quot;);
	 * </pre>
	 */
	public static String getCookieArrtibute(HttpServletRequest req, final String name) {
		return getCookie(req, name).getValue();
	}

	/**
	 * 请求URL中的主机
	 *
	 * @param req
	 *            http请求对象
	 * @return 主机名
	 *
	 * <pre>
	 * String hostname = WebUtils.getHostname(request);
	 * </pre>
	 */
	public static String getHostname(HttpServletRequest req) {
		return req.getServerName();
	}

	/**
	 * 访问来源. 包含一个URL，用户从该URL代表的页面出发访问当前请求的页面。
	 *
	 * @param req
	 *            http请求对象
	 * @return 访问来源
	 *
	 * <pre>
	 * String referer = WebUtil.getReferer(request);
	 * </pre>
	 */
	public static String getReferer(HttpServletRequest req) {
		return getHeaderAttribute(req, "Referer");
	}

	/**
	 * 浏览器类型. 如果Servlet返回的内容与浏览器类型有关则该值非常有用。
	 *
	 * @param req
	 *            http请求对象
	 * @return 浏览器类型
	 *
	 * <pre>
	 * String userAgent = WebUtils.getUserAgent(request);
	 * </pre>
	 */
	public static String getUserAgent(HttpServletRequest req) {
		return getHeaderAttribute(req, "User-Agent");
	}

	/**
	 * 取得指定的请求头信息
	 *
	 * @param req
	 *            http请求对象
	 * @param name
	 *            头信息名称，参考<a
	 *            href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html#sec5.3">W3C-HTTP标准</a>
	 * @return 头信息内容
	 *
	 * <pre>
	 * String info = WebUtils.getHeaderAttribute(request, &quot;Accept-Charset&quot;);//请求接受的字符集，结果类 &quot;en, zh, zh_CN&quot;
	 * </pre>
	 */
	public static String getHeaderAttribute(HttpServletRequest req, String name) {
		return req.getHeader(name);
	}

	/**
	 * 取得指定的请求头信息. 与 {@link #getHeaderAttribute(HttpServletRequest, String)}
	 * 的区别在于对于内容为多个值的头信息 （如Accept-Charset等）这个方法返回的是一个数组，而{@link #getHeaderAttribute(HttpServletRequest, String)}返回的是一个用逗号拼起来的字符串
	 *
	 * @param req
	 *            http请求对象
	 * @param name
	 *            头信息名称，参考<a
	 *            href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html#sec5.3">W3C-HTTP标准</a>
	 * @return 头信息内容
	 *
	 * <pre>
	 * String[] info = WebUtils.getHeaderAttributeArray(request, &quot;Accept-Charset&quot;);//请求接受的字符集，结果类似｛&quot;en&quot;,&quot;zh&quot;,&quot;zh_CN&quot;}
	 * </pre>
	 */
	public static String[] getHeaderAttributeArray(HttpServletRequest req, String name) {
		Enumeration e = req.getHeaders(name);
		if (e == null || !e.hasMoreElements())
			return null;
		List<String> tmp = new ArrayList<String>();
		while (e.hasMoreElements()) {
			tmp.add((String) e.nextElement());
		}
		return tmp.toArray(new String[tmp.size()]);
	}
}
