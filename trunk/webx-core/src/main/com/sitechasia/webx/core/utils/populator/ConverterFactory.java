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
package com.sitechasia.webx.core.utils.populator;

/**
 * 用于产生Converter的工厂
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class ConverterFactory {

	private ConverterFactory(){}

	/**
	 * 默认的转换器
	 */
	private static final ITypeConverter converter;

	static {
		WebXTypeConverter webxConv = new WebXTypeConverter();
		ITypeConverter priConv = new PriTypeConverter();
		ITypeConverter dateConv = new DateTypeConverter();
        //modified begin
		ITypeConverter formfileConv = new FormFileConverter();
		//modified end
		ITypeConverter lobConv = new LobTypeConverter();

		webxConv.getConverters().add(priConv);
		webxConv.getConverters().add(dateConv);
        //modified begin
		webxConv.getConverters().add(formfileConv);
		//modified end
		webxConv.getConverters().add(lobConv);

		converter = webxConv;
	}

	/**
	 * 获得一个系统默认的Converter
	 * @return 系统默认的Converter
	 */
	public static ITypeConverter getDefaultConverter() {
		return converter;
	}
}
