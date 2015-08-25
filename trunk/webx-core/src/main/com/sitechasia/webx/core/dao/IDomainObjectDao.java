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
package com.sitechasia.webx.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.sitechasia.webx.core.model.IDomainObject;

/**
 * 针对单个DomainObject对象的操作定义. 不依赖于具体ORM实现方案.
 *
 * @author todd
 * @version 1.2
 * @since JDK1.5
 * @param <D>
 * 		   业务对象的子类\
 * 
 * @deprecated
 * @see IDomainDao
 */

public interface IDomainObjectDao<D extends IDomainObject> extends IDao {
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
	List<D> findBy(String name, Object value);

	/**
	 * 根据属性名和属性值以Like AnyWhere方式查询对象.
	 *
	 * @param name
	 *            查询条件的属性名
	 * @param value
	 *            查询条件
	 * @return 符合条件的对象列表
	 */
	List<D> findByLike(String name, String value);

	/**
	 * 根据属性名和属性值查询单个对象.
	 *
	 * @param name
	 *            查询条件的属性名
	 * @param value
	 *            查询条件
	 * @return 符合条件的对象
	 */
	D findUniqueBy(String name, Object value);

	/**
	 * 根据ID获取对象.
	 *
	 * @param id
	 *            指定的ID
	 * @return 符合条件的对象
	 */
	D findById(Serializable id);

	/**
	 * 获取全部对象.
	 *
	 * @return 对象列表
	 */
	List<D> findAll();

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
	boolean isNotUnique(D domainObject, String names);

	/**
	 * 删除指定的实体对象.
	 *
	 * @param o
	 *            指定的对象
	 */
	void doDelete(D o);

	/**
	 * 根据ID移除对象.
	 *
	 * @param id
	 *            指定的ID
	 */
	void doDeleteById(Serializable id);

	/**
	 * 根据多个id批量删除对象
	 * @param ids 指定的多个ID
	 */
	void doDeleteByIds(Serializable[] ids);

	/**
	 * 保存对象.
	 *
	 * @param o
	 *            指定的对象
	 */
	void doSave(D o);

	/**
	 * 保存一系列对象.
	 *
	 * @param list
	 *            指定的对象list
	 */
	void doSaveAll(Collection<D> list);
}
