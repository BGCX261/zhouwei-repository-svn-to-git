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
package com.sitechasia.webx.core.translator;

import org.springframework.beans.factory.InitializingBean;

/**
 * 转换器抽象类
 * 这种方式的好处是一次就能为bean的所有实例指定初始化回调，代价是应用程序和spring耦合
 * 执行完所有属性设置方法(即setXxx)将自动调用
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public abstract class AbstractNomalTranslator implements Translator,
		InitializingBean {

	protected String name;

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		if(this.name==null){
			throw new IllegalStateException("Translator name is requeid.");
		}
		TranslatorFacade.getInstance().register(this);
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
