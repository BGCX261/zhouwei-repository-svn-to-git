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

import java.util.HashMap;
import java.util.Map;

/**
 * 一个单例的转换器
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class TranslatorFacade {

	private static TranslatorFacade instance;

	private Map<String,Translator> trans;

	/**
	 *
	 */
	private TranslatorFacade() {
		trans = new HashMap<String,Translator>();
	}

	/**
	 * @return 获得单例对象
	 */
	public static TranslatorFacade getInstance(){
		if(instance==null){
			instance = new TranslatorFacade();
		}
		return instance;
	}

	/**
	 * 获取指定名字的转换器
	 * @param name 名字
	 * @return 获取的转换器，如果没有找到，返回null
	 */
	public Translator getTranslator(String name){
		return this.trans.get(name);
	}

	/**
	 *  根据转换器名字转换指定的值
	 * @param name 转换器名字
	 * @param key 需要转换的值
	 * @return 转换的结果
	 */
	public Object translate(String name, Object key) {
		return this.trans.get(name).translate(key);
	}

	/**
	 * 根据转换器名字转换指定值为一个字符串
	 * @param name 转换器名字
	 * @param key 需要转换的值
	 * @return 转换的结果字符串
	 */
	public String translateAsString(String name, Object key) {
		return this.trans.get(name).translateAsString(key);
	}

	/**
	 * 注册转换器，每个转换器都需要注册（调用本方法）才能使用
	 * @param translator 需要注册的转换器
	 */
	public void register(Translator translator){
		this.trans.put(translator.getName(), translator);
	}

}
