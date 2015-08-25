/*
 * Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sitechasia.webx.validator;

import java.util.Locale;

import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorResources;


/**
 * 
 * ValidatorFactory工厂类
 * 
 * @author zhou wei
 * @version 1.0
 */
public interface ValidatorFactory {

	/**
	 * 
	 * 根据bean和validato xml中的对应的form bean名称获取Validator实例对象
	 * 
	 * @param beanName validator xml中的对应的form bean名称
	 * @param bean java bean 对象
	 * @return
	 */
	public Validator getValidator(String beanName, Object bean);

	/**
	 * 
	 * validato xml中是否存在指定Locale的form定义
	 * 
	 * @param beanName validato xml中的对应的form bean名称
	 * @param locale
	 * @return
	 */
	public boolean hasRulesForBean(String beanName, Locale locale);

	/**
	 * 
	 * 获取ValidatorResources
	 * 
	 * @return
	 */
	public ValidatorResources getValidatorResources();

}
