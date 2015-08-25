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
package com.sitechasia.webx.core.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.service.IValueObjectBaseService;

/**
 * 使用泛型的服务层基类
 * 子类只要在类定义时指定所管理Domain对象的Class, 即拥有对Domain对象的CRUD操作.以及批量删除添加及修改
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 * @param <D>
 * 			一个业务对象DO
 */

public abstract class BaseDOService<D extends IDomainObject> extends BaseDomainDaoService<D> implements IValueObjectBaseService<D> {

	/**
	 * 根据属性名和属性值查询对象.
	 *
	 * @param name
	 *            查询条件的属性名
	 * @param value
	 *            查询条件
	 *
	 * @return 符合条件的对象列表
	 */
	public List<D> findBy(String name, Object value) {
		return getDao().findBy(name, value);
	}

	/**
	 * 根据属性名和属性值以Like AnyWhere方式查询对象.
	 *
	 * @param name
	 *            查询条件的属性名
	 * @param value
	 *            查询条件
	 * @return 符合条件的对象列表
	 */
	public List<D> findByLike(String name, String value) {
		return getDao().findByLike(name, value);// <html:form>
	}

	/**
	 * 根据属性名和属性值查询单个对象.
	 *
	 * @param name
	 *            查询条件的属性名
	 * @param value
	 *            查询条件
	 * @return 符合条件的对象
	 */
	public D findUniqueBy(String name, Object value) {
		return getDao().findUniqueBy(name, value);
	}

	/**
	 * 根据ID获取对象.
	 *
	 * @param id
	 *            指定的ID
	 * @return 符合条件的对象
	 */
	public D findById(Serializable id) {
		return getDao().findById(id);
	}

	/**
	 * 获取全部对象.
	 *
	 * @return 对象列表
	 */
	public List<D> findAll() {
		return getDao().findAll();
	}

	/**
	 * 判断对象某些属性的值在数据库中不存在重复.
	 *
	 * @param domainObject
	 *            指定的对象
	 *
	 * @param names
	 *            在POJO里不能重复的属性列表,以逗号分割 如"name,loginid,password"
	 * @return 包含重复的内容返回true，否则返回false
	 */
	public boolean isNotUnique(D entity, String names) {
		return getDao().isNotUnique(entity, names);
	}

	/**
	 * 删除指定的实体对象.
	 *
	 * @param o
	 *            指定的对象
	 */
	public void doDelete(D o) {
		getDao().doDelete(o);
	}

	/**
	 * 根据ID移除对象.
	 *
	 * @param id
	 *            指定的ID
	 */
	public void doDeleteById(Serializable id) {
		getDao().doDeleteById(id);
	}

	/**
	 * 删除多个对象
	 * @param ids
	 */
	public void doDeleteByIds(Serializable[] ids) {
		getDao().doDeleteByIds(ids);
	}

	/**
	 * 保存对象.
	 *
	 * @param o
	 *            指定的对象
	 */
	public void doSave(D o) {
		getDao().doSave(o);
	}

	/**
	 * 保存一系列对象.
	 *
	 * @param list
	 *            指定的对象list
	 */
	public void doSaveAll(Collection<D> list) {
		getDao().doSaveAll(list);
	}
}