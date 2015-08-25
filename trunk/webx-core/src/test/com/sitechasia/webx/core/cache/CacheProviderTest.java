/** 
 * @{#} CacheProviderTest.java Create on 2008-6-12 下午01:18:04   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache;

import com.sitechasia.webx.core.cache.ehcache.EhCacheProvider;

import junit.framework.TestCase;

/**
 * CacheProvider测试类
 * @author MarkDong
 * @version 1.0   
 */
public class CacheProviderTest extends TestCase {
	ICacheProvider cacheProvider;
	protected void setUp() {
		cacheProvider = new EhCacheProvider();
		cacheProvider.start();
	}
	
	protected void tearDown() {
		cacheProvider.stop();
		cacheProvider = null;
	}
	
	public void testGetCache() {
		ICache cache1 = cacheProvider.getCacheByStrategy("adfadsf");
		ICache cache2 = cacheProvider.getCacheByStrategy("dfadsfadf");
		assertEquals(cache1, cache2);
		ICache cache3 = cacheProvider.getCacheByStrategy(ICacheProvider.DEFAULT_REGION_NAME);
		assertEquals(cache1, cache3);
		
		assertEquals(cache1.getStrategyName(), cache2.getStrategyName());
		assertEquals(cache1.getStrategyName(), cache3.getStrategyName());
	}
	
}
