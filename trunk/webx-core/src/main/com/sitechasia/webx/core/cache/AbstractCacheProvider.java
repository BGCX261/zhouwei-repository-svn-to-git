/** 
 * @{#} AbstractCacheProvider.java Create on 2008-6-11 下午03:14:20   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CacheProvider的抽象类
 * 
 * @author Administrator
 * @version 1.0
 * @see
 */
public abstract class AbstractCacheProvider implements ICacheProvider {
	protected final Log logger = LogFactory.getLog(this.getClass());

	private final ConcurrentHashMap<String, ICache> cachesMap = new ConcurrentHashMap<String, ICache>();
	private Properties properties;
	private boolean simple = true;
	
	
	public boolean isSimple() {
		return simple;
	}

	/**
	 * 设置是否是简单模式
	 * 
	 * @param simple true or false
	 */
	public void setSimple(boolean simple) {
		this.simple = simple;
	}

	public final Object get(String strategy, Object key) throws CacheException {
		ICache cache = this.getCacheByStrategy(strategy);
		return cache.get(key);
	}

	public final ICache getCacheByStrategy(String strategy) throws CacheException {
		ICache cache = this.cachesMap.get(strategy);
		// 如果不存在，创建一个cache
		if (cache == null) {
			cache = this.buildCache(strategy);
			if (cache == null) {
				strategy = DEFAULT_REGION_NAME;
				logger.warn("发现错误的缓存名称，使用默认缓存名称：" + strategy);
				cache = this.cachesMap.get(strategy);
				if (cache == null) {
					cache = this.getDefaultCache();
				}
			}
			assert (cache != null);
			ICache prev = this.cachesMap.putIfAbsent(strategy, cache);
			if (prev != null && prev != cache) {
				logger.error("发现不同的Cache对应到了相同的策略名称，使用原有的Cache");
				cache.clear();
				cache = prev;
			}
		}
		return cache;
	}

	public final void start() {
		this.start(properties);
	}
	
	public long onChange(Class<?> clazz) throws CacheException {
		long count = 0l;
		for(ICache cache : cachesMap.values()) {
			count += cache.onChange(clazz);
		}
		return count;
	}
	
	public long onChange(Class<?> clazz, Object obj) throws CacheException {
		long count = 0l;
		for (ICache cache : cachesMap.values()) {
			count += cache.onChange(clazz, obj);
		}
		return count;
	}
	
	public long onChange(Class<?> clazz, String property, Object value) {
		long count = 0l;
		for (ICache cache : cachesMap.values()) {
			count += cache.onChange(clazz, property, value);
		}
		return count;
	}

	public void put(String strategy, long timestamp, Object key, Object value, CacheToken... tokens)
			throws CacheException {
		ICache cache = this.getCacheByStrategy(strategy);
		cache.put(timestamp, key, value, tokens);
	}

	public long createTimestamp(String strategy, CacheToken... tokens) {
		ICache cache = this.getCacheByStrategy(strategy);
		return cache.createTimestamp(tokens);
	}

	public boolean remove(String strategy, Object key) throws CacheException {
		ICache cache = this.getCacheByStrategy(strategy);
		return cache.remove(key);
	}

	public void clear(String strategy) throws CacheException {
		ICache cache = this.cachesMap.get(strategy);
		if(cache != null) cache.clear();
	}

	/**
	 * 设置参数
	 * 
	 * @param properties 参数列表，该参数会根据具体第三方包的不同而具有不同的参数名称
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * 根据策略名称取得ICache
	 * 
	 * @param regionName
	 * @return ICache对象，如果不存在该名称，则返回null
	 */
	protected abstract ICache buildCache(String strategy);

	/**
	 * 取得默认缓存
	 * 
	 * @return 默认缓存
	 */
	protected abstract ICache getDefaultCache();
	
	/**
	 * 根据配置参数启动缓存
	 *
	 * @param properties 配置参数列表
	 */
	protected abstract void start(Properties properties);
}
