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
package com.sitechasia.webx.components.datasource.context;

/**
 * 包含了一个ThreadLocal对象，用于存储Http请求的域名部分。
 * 域名部分将在多数据源时用来选择数据源。
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class DomainContextHolder {
	private static ThreadLocal domain = new ThreadLocal();
	public static String getMyDomain(){
		return (String)domain.get();
	}
	public static void setMyDomain(String s){
		domain.set(s);
	}
}
