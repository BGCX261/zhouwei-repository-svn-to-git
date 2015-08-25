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
 * 用于产生Populator的工厂
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public final class PopulatorFactory {

	private PopulatorFactory(){}

	/**
	 * 默认的Populator
	 */
	private static final IPopulator populator;

	static {
		WebXPopulator webxPop = new WebXPopulator();

		BasePopulator requestPop = new ServletRequestBeanPopulator();
		requestPop.setConverter(ConverterFactory.getDefaultConverter());

		BasePopulator resultPop = new ResultSetBeanPopulator();
		resultPop.setConverter(ConverterFactory.getDefaultConverter());

		BasePopulator mapPop = new BeanMapPopulator();
		mapPop.setConverter(ConverterFactory.getDefaultConverter());

		BasePopulator beanPop = new BeanPopulator();
		beanPop.setConverter(ConverterFactory.getDefaultConverter());

		webxPop.getPopulators().add(beanPop);
		webxPop.getPopulators().add(mapPop);
		webxPop.getPopulators().add(resultPop);
		webxPop.getPopulators().add(requestPop);

		populator = webxPop;
	}

	/**
	 * 获得一个系统默认的Populator
	 * @return 系统默认的Populator
	 */
	public static IPopulator getDefaultPopulator() {
		return populator;
	}
}
