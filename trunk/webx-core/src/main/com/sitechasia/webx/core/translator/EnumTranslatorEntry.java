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

/**
 * 枚举项
 *
 * @author Steven
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class EnumTranslatorEntry {

	private Object value;

	private Object lable;

	/**
	 * @param value
	 * @param lable
	 */
	public EnumTranslatorEntry(Object value, Object lable) {
		this.value = value;
		this.lable = lable;
	}

	/**
	 *
	 */
	public EnumTranslatorEntry() {
	}

	/**
	 * @return Returns the value.
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return Returns the lable.
	 */
	public Object getLable() {
		return lable;
	}

	/**
	 * @param lable The lable to set.
	 */
	public void setLable(Object lable) {
		this.lable = lable;
	}

}
