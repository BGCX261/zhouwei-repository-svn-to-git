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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 枚举转换器实现类
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
class EnumTranslatorImpl implements EnumTranslator {

	private Map<Object, EnumTranslatorEntry> keyMap;

	private List<EnumTranslatorEntry> items;

	private String etname;

	/**
	 * @param etname The etname to set.
	 */
	public void setEtname(String etname) {
		this.etname = etname;
	}

	/**
	 *
	 */
	public EnumTranslatorImpl() {
		this.keyMap = new HashMap<Object, EnumTranslatorEntry>();
		this.items = new ArrayList<EnumTranslatorEntry>();
	}

	/**
	 * @param item
	 */
	public  void addItem(EnumTranslatorEntry item)
	{
		if(item==null)
			return;

		keyMap.put(item.getValue(),item);
		this.items.add(item);
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.EnumTranslatorStore#getItems()
	 */
	public List<EnumTranslatorEntry> getItems() {
		return this.items;
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.EnumTranslatorStore#getKeymap()
	 */
	public Map<Object, EnumTranslatorEntry> getKeymap() {
		return this.keyMap;
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#getName()
	 */
	public String getName() {
		return etname;
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#translate(java.lang.Object)
	 */
	public Object translate(Object obj) {
		return this.keyMap.get(obj).getLable();
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#translateAsString(java.lang.Object)
	 */
	public String translateAsString(Object obj) {
		return this.keyMap.get(obj).getLable().toString();
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.EnumTranslator#size()
	 */
	public int size(){
		return items.size();
	}

}
