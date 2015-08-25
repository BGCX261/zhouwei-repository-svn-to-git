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
package com.sitechasia.webx.core.utils.context;

import java.util.Set;

/**
 * 所有Context实现的通用抽象基类，该基类本身并不能被实例化
 *
 * @author Zal
 * @version 1.2 , 2008/5/8
 * @since JDK1.5
 */
public abstract class BaseContext implements IContext {

	/**
	 * Context所使用的Cache，默认为InMemoryContextCache
	 */
	private IContextCache contextCache = new InMemoryContextCache();

	/**
	 * contextCache属性的Set方法，对null值则不进行付值
	 * @param contextCache 需要使用的contextCache
	 */
	public void setContextCache(IContextCache contextCache) {
		if (contextCache == null)
			return;

		IContextCache oldContextCache = this.contextCache;

		/**
		 * 通知原有Cache，将要从Context中解除绑定
		 */
		if (oldContextCache instanceof IContextCacheBindingListener) {
			((IContextCacheBindingListener) oldContextCache).beforeUnBind(this);
		}

		/**
		 * 通知新Cache，将要进行绑定
		 */
		if (contextCache instanceof IContextCacheBindingListener) {
			((IContextCacheBindingListener) contextCache).beforeBind(this);
		}

		this.contextCache = contextCache;

		/**
		 * 通知原有Cache，已经从Context中解除绑定
		 */
		if (oldContextCache instanceof IContextCacheBindingListener) {
			((IContextCacheBindingListener) oldContextCache).afterUnBind(this);
		}

		/**
		 * 通知新Cache，已经成功进行绑定
		 */
		if (contextCache instanceof IContextCacheBindingListener) {
			((IContextCacheBindingListener) contextCache).afterBind(this);
		}
	}

	/**
	 * contextCache属性的Get方法
	 *
	 * @return contextCache属性
	 */
	public IContextCache getContextCache() {
		return this.contextCache;
	}

	/**
	 * 向Context中存储一个值
	 * @param key 存储时所使用的键
	 * @param value 存储的值
	 */
	public void setAttribute(String key, Object value) {
		contextCache.set(key, value);
	}

	/**
	 * 从Context中获取一个所存储的值
	 * @param key 用于获得存储值的键
	 * @return 获得的所存储的值
	 */
	public Object getAttribute(String key) {
		return contextCache.get(key);
	}

	/**
	 * 从Context中删除一个所存储的值
	 * @param key 需要被删除值的键
	 * @return 所删除的值
	 */
	public Object removeAttribute(String key) {
		return contextCache.remove(key);
	}

	/**
	 * 清空Context中所存储的所有的值
	 */
	public void clearAttributes() {
		contextCache.clear();
	}

	/**
	 * 获得Context中所存储的所有的键的数组
	 * @return Context中所存储的所有的键
	 */
	public Set getAttributeNames() {
		return contextCache.getKeys();
	}
}
