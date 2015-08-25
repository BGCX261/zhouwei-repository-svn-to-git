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
package com.sitechasia.webx.components.cache.memcached;

import java.util.Calendar;
import java.util.Map;
import net.sf.ehcache.CacheManager;
import org.apache.log4j.Logger;
import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.Timestamper;
import com.danga.MemCached.MemCachedClient;

/**
 * Hibernate中使用MemCached<br>
 * MemCached plugin for Hibernate
 *
 * @author sunyuantao
 * @version 1.2 , 2008/5/8
 * @since JDK1.5
 */
public class MemCache implements Cache {
	private static final Logger logger = Logger.getLogger(MemCache.class);
	private static final int SIXTY_THOUSAND_MS = 60000;
	private MemCachedClient mc;
	private int secondToLive;

	/**
	 * Creates a new Hibernate pluggable cache based on a cache name. <p/>
	 *
	 * @param name 这个cache的名称
	 * @param secondToLive 生存的秒数
	 */
	public MemCache(String name, int secondToLive) {
		mc = new MemCachedClient();
		mc.setCompressEnable(true);
		mc.setCompressThreshold(4096);
		this.secondToLive = secondToLive;
	}

	private String makeupKey(Object key) {
		return key.toString();
	}

	/**
	 * Gets a value of an element which matches the given key.
	 *
	 * @param key
	 *            the key of the element to return.
	 * @return The value placed into the cache with an earlier put, or null if not found or expired
	 * @throws CacheException
	 */
	public Object get(Object key) throws CacheException {
		if (logger.isDebugEnabled()) {
			logger.debug("key: " + key);
		}
		logger.info("get key == " + key);
		if (key == null) {
			return null;
		} else {
			Object rt = mc.get(makeupKey(key));
			if (rt == null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Element for " + key + " is null");
				}
				return null;
			} else {
				return rt;
			}
		}
	}

	public Object read(Object key) throws CacheException {
		return get(makeupKey(key));
	}

	/**
	 * Puts an object into the cache.
	 *
	 * @param key
	 *            a key
	 * @param value
	 *            a value
	 * @throws CacheException
	 *             if the {@link CacheManager} is shutdown or another {@link Exception} occurs.
	 */
	public void update(Object key, Object value) throws CacheException {
		put(makeupKey(key), value);
	}

	/**
	 * Puts an object into the cache.
	 *
	 * @param key
	 *            a key
	 * @param value
	 *            a value
	 * @throws CacheException
	 *             if the {@link CacheManager} is shutdown or another {@link Exception} occurs.
	 */
	public void put(Object key, Object value) throws CacheException {
		logger.info("put key == " + key);
		if (secondToLive <= 0)
			mc.set(makeupKey(key), value);
		else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, secondToLive);
			mc.set(makeupKey(key), value, cal.getTime());
		}
	}

	/**
	 * Removes the element which matches the key. <p/> If no element matches, nothing is removed and no Exception is
	 * thrown.
	 *
	 * @param key
	 *            the key of the element to remove
	 * @throws CacheException
	 */
	public void remove(Object key) throws CacheException {
		mc.delete(makeupKey(key), null);
	}

	/**
	 * Remove all elements in the cache, but leave the cache in a useable state.
	 *
	 * @throws CacheException
	 */
	public void clear() throws CacheException {
		mc.flushAll();
	}

	/**
	 * Remove the cache and make it unuseable.
	 *
	 * @throws CacheException
	 */
	public void destroy() throws CacheException {
	}

	/**
	 * Calls to this method should perform there own synchronization. It is provided for distributed caches. Because
	 * EHCache is not distributed this method does nothing.
	 */
	public void lock(Object key) throws CacheException {
	}

	/**
	 * Calls to this method should perform there own synchronization. It is provided for distributed caches. Because
	 * EHCache is not distributed this method does nothing.
	 */
	public void unlock(Object key) throws CacheException {
	}

	/**
	 * Gets the next timestamp;
	 */
	public long nextTimestamp() {
		return Timestamper.next();
	}

	/**
	 * Returns the lock timeout for this cache.
	 */
	public int getTimeout() {
		// 60 second lock timeout
		return Timestamper.ONE_MS * SIXTY_THOUSAND_MS;
	}

	public String getRegionName() {
		return null;
	}

	/**
	 * Warning: This method can be very expensive to run. Allow approximately 1 second per 1MB of entries. Running this
	 * method could create liveness problems because the object lock is held for a long period <p/>
	 *
	 * @return the approximate size of memory ehcache is using for the MemoryStore for this cache
	 */
	public long getSizeInMemory() {
		logger.warn("cann't getSizeInMemory in memcached!");
		throw new CacheException("cann't getSizeInMemory in memcached!");
	}

	public long getElementCountInMemory() {
		logger.warn("cann't getElementCountInMemory in memcached!");
		throw new CacheException("cann't getElementCountInMemory in memcached!");
	}

	public long getElementCountOnDisk() {
		logger.warn("cann't getElementCountOnDisk in memcached!");
		throw new CacheException("cann't getElementCountOnDisk in memcached!");
	}

	public Map toMap() {
		logger.warn("cann't toMap in memcached!");
		throw new CacheException("cann't toMap in memcached!");
	}

	public String toString() {
		return "MemCached(" + getRegionName() + ')';
	}
}
