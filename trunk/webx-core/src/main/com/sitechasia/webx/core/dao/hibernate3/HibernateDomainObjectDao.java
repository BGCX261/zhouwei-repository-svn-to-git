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
package com.sitechasia.webx.core.dao.hibernate3;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;

import com.sitechasia.webx.core.dao.IDomainObjectDao;
import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.utils.base.GenericsUtils;

/**
 *  负责为单个Domain对象提供CRUD操作的Hibernate DAO基类.
 *
 *  子类只要在类定义时指定所管理Domain对象的Class, 即拥有对单个Domain对象的CRUD操作.
 *
 * @author
 * @version 1.2
 * @since JDK1.5
 * @param <T>
 * 			业务对象的子类
 */

public abstract class HibernateDomainObjectDao<T extends IDomainObject> extends BaseHibernateDao implements IDomainObjectDao<T> {
	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#doSaveAll(java.util.Collection)
	 */
	public void doSaveAll(Collection<T> list) {
		genericSaveAll(getEntityClass(), list);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#doSave(java.lang.Object)
	 */
	public void doSave(T o) {
		genericSave(getEntityClass(), o);
	}

	/**
	 * DAO管理的Entity类型.
	 */
	protected Class<T> entityClass;

	/**
	 * 取得entityClass.
	 *
	 * JDK1.4不支持泛型的子类可以抛开Class<T> entityClass,重载此函数达到相同效果
	 *
	 * @return 对应实体类的类型
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	public HibernateDomainObjectDao() {
		entityClass = GenericsUtils.getGenericClass(getClass());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#findById(java.io.Serializable)
	 */
	public T findById(Serializable id) {
		return (T) genericGet(getEntityClass(), id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#findAll()
	 */
	public List<T> findAll() {
		return genericGetAll(getEntityClass());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#doDeleteById(java.io.Serializable)
	 */
	public void doDeleteById(Serializable id) {
		genericRemoveById(getEntityClass(), id);
	}

	/**
	 * 根据多个id批量删除对象
	 *
	 * @param ids
	 * 			编号组成的数组
	 */
	public void doDeleteByIds(Serializable[] ids) {
		for(Serializable id : ids) {
			doDeleteById(id);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#findBy(java.lang.String,
	 *      java.lang.Object)
	 */
	public List<T> findBy(String name, Object value) {
		return genericFindBy(getEntityClass(), name, value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IEntityDao#findUniqueBy(java.lang.String,
	 *      java.lang.Object)
	 */
	public T findUniqueBy(String name, Object value) {
		return (T) genericFindUniqueBy(getEntityClass(), name, value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IEntityDao#findByLike(java.lang.String,
	 *      java.lang.String)
	 */
	public List<T> findByLike(String name, String value) {
		return genericFindByLike(getEntityClass(), name, value);
	}

	/**
	 * 取得实体的查询对象
	 *
	 * @return 实体的查询对象
	 */
	protected Criteria getEntityCriteria() {
		return getEntityCriteria(getEntityClass());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#isNotUnique(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean isNotUnique(T entity, String names) {
		return isGenericNotUnique(getEntityClass(), entity, names);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sitechasia.webx.core.dao.IDomainObjectDao#doDelete(java.lang.Object)
	 */
	public void doDelete(T o) {
		genericRemove(entityClass, o);
	}
}