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

import java.util.Hashtable;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.CacheProvider;
import org.hibernate.cache.Timestamper;
import com.danga.MemCached.SockIOPool;

/**
 * Mecached在spring和hibernate中的配置<br>
 * Memcached plugin for Hibernate config (hibernate.properties and spring.xml)
 *
 * hibernate.properties
 *
 * <pre>
 *      hibernate.cache.provider_class = com.sitechasia.cache.memcached.MemcachedCacheProvider
 *
 *      memcached.servers = 210.51.171.153:11211
 *      memcached.failover = true
 *      memcached.initConn = 100
 *      memcached.minConn = 100
 *      memcached.maxConn = 250
 *      memcached.maintSleep = 30
 *      memcached.nagle = false
 *      memcached.socketTO = 3000
 *      memcached.aliveCheck = true
 *      memcached.region_name = 10s|20m|30h|40d
 * </pre>
 *
 * spring.xml
 *
 * <pre>
 *      &lt;prop key=&quot;cache.provider_class&quot;&gt;${hibernate.cache.provider_class}&lt;/prop&gt;
 *
 *      &lt;prop key=&quot;memcached.servers&quot;&gt;${memcached.servers}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.failover&quot;&gt;${memcached.failover}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.initConn&quot;&gt;${memcached.initConn}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.minConn&quot;&gt;${memcached.minConn}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.maxConn&quot;&gt;${memcached.maxConn}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.maintSleep&quot;&gt;${memcached.maintSleep}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.nagle&quot;&gt;${memcached.nagle}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.socketTO&quot;&gt;${memcached.socketTO}&lt;/prop&gt;
 *      &lt;prop key=&quot;memcached.aliveCheck&quot;&gt;${memcached.aliveCheck}&lt;/prop&gt;
 *
 *      &lt;prop key=&quot;memcached.[region_name]&quot;&gt;${memcached.region_name}&lt;/prop&gt;
 * </pre>
 *
 * @author sunyuantao
 * @version 1.2 , 2008/5/8
 * @since JDK1.5
 */
public class MemcachedCacheProvider implements CacheProvider {
	private static final Logger logger = Logger.getLogger(MemcachedCacheProvider.class);
	public final static String DEFAULT_REGION_NAME = "_DEFAULT_MEMCACHED_REGION";
	private Hashtable<String, MemCache> cacheManager;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.hibernate.cache.CacheProvider#start(java.util.Properties)
	 */
	public void start(Properties props) throws CacheException {
		SockIOPool pool = SockIOPool.getInstance();
		String servers = props.getProperty("memcached.servers");
		logger.info("servers == " + servers);
		if (StringUtils.isBlank(servers)) {
			throw new CacheException("configuration 'memcached.servers' get a empty value");
		}
		pool.setServers(servers.split(","));
		pool.setFailover(Boolean.valueOf(props.getProperty("memcached.failover")));
		pool.setInitConn(Integer.valueOf(props.getProperty("memcached.initConn")));
		pool.setMinConn(Integer.valueOf(props.getProperty("memcached.minConn")));
		pool.setMaxConn(Integer.valueOf(props.getProperty("memcached.maxConn")));
		pool.setMaintSleep(Integer.valueOf(props.getProperty("memcached.maintSleep")));
		pool.setNagle(Boolean.valueOf(props.getProperty("memcached.nagle")));
		pool.setSocketTO(Integer.valueOf(props.getProperty("memcached.socketTO")));
		pool.setAliveCheck(Boolean.valueOf(props.getProperty("memcached.aliveCheck")));
		pool.initialize();
		cacheManager = new Hashtable<String, MemCache>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.hibernate.cache.CacheProvider#buildCache(java.lang.String, java.util.Properties)
	 */
	public Cache buildCache(String name, Properties props) throws CacheException {
		if (StringUtils.isEmpty(name))
			name = DEFAULT_REGION_NAME;
		MemCache mCache = cacheManager.get(name);
		if (mCache == null) {
			String timeToLive = props.getProperty("memcached." + name);
			int secondToLive = -1;
			if (StringUtils.isNotBlank(timeToLive)) {
				timeToLive = timeToLive.toLowerCase().trim();
				secondToLive = getSeconds(timeToLive);
			}
			logger.info("Building cache named " + name + " using secondToLive is " + secondToLive);
			mCache = new MemCache(name, secondToLive);
			cacheManager.put(name, mCache);
		}
		return mCache;
	}

	private static int getSeconds(String str) {
		try {
			switch (str.charAt(str.length() - 1)) {
			case 's':
				return Integer.parseInt(str.substring(0, str.length() - 1));
			case 'm':
				return Integer.parseInt(str.substring(0, str.length() - 1)) * 60;
			case 'h':
				return Integer.parseInt(str.substring(0, str.length() - 1)) * 3600;
			case 'd':
				return Integer.parseInt(str.substring(0, str.length() - 1)) * 86400;
			default:
				return Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			logger.warn("Illegal configuration value : " + str, e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.hibernate.cache.CacheProvider#stop()
	 */
	public void stop() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.hibernate.cache.CacheProvider#isMinimalPutsEnabledByDefault()
	 */
	public boolean isMinimalPutsEnabledByDefault() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.hibernate.cache.CacheProvider#nextTimestamp()
	 */
	public long nextTimestamp() {
		return Timestamper.next();
	}
}