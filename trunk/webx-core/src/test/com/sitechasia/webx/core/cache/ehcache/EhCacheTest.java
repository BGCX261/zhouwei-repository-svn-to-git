/** 
 * @{#} EhCacheTest.java Create on 2008-6-23 下午03:36:40   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.ehcache;

import com.sitechasia.webx.core.cache.CacheToken;
import com.sitechasia.webx.core.cache.EntityOne;
import com.sitechasia.webx.core.cache.ICache;
import com.sitechasia.webx.core.cache.ICacheProvider;

import junit.framework.TestCase;

/**
 * EhCache测试类
 * @author MarkDong
 * @version 1.0   
 * @see   
 */
public class EhCacheTest extends TestCase {
	ICacheProvider provider = new EhCacheProvider();
	
	public void testEhCache() {
		provider.start();
		ICache cache = provider.getCacheByStrategy("asdfa");
		
		CacheToken token11 = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_int", 1);
		CacheToken token12 = new CacheToken(EntityOne.class, CacheToken.GREAT_EQUALS, "_long", 1l);
		CacheToken token13 = new CacheToken(EntityOne.class, CacheToken.LESS_THAN, "_Float", 3f);

		long timestamp = cache.createTimestamp(token11, token12, token13);
		assertEquals(3, timestamp);
		timestamp = cache.createTimestamp(token11);
		assertEquals(2, timestamp);
		timestamp = cache.createTimestamp(token11, token12, token13);
		assertEquals(3, timestamp);
		
		cache.put(timestamp, "key1", "value1", token11);
		cache.put(timestamp, "key2", "value2", token11, token12);
		cache.put(timestamp, "key3", "value3", token11, token12, token13);
		
		String value = (String) cache.get("key1");
		assertEquals("value1", value);
		value = (String) cache.get("key2");
		assertEquals("value2", value);
		value = (String) cache.get("key3");
		assertEquals("value3", value);
		
		EntityOne entity = new EntityOne();
		entity.set_Float(2f);
		cache.onChange(EntityOne.class, entity);
		value = (String) cache.get("key1");
		assertEquals("value1", value);
		value = (String) cache.get("key2");
		assertEquals("value2", value);
		value = (String) cache.get("key3");
		assertEquals(null, value);
		
		entity = new EntityOne();
		entity.set_long(2l);
		cache.onChange(EntityOne.class, entity);
		value = (String) cache.get("key1");
		assertEquals("value1", value);
		value = (String) cache.get("key2");
		assertEquals(null, value);
		value = (String) cache.get("key3");
		assertEquals(null, value);
		
		entity = new EntityOne();
		entity.set_int(1);
		cache.onChange(EntityOne.class, entity);
		value = (String) cache.get("key1");
		assertEquals(null, value);
		value = (String) cache.get("key2");
		assertEquals(null, value);
		value = (String) cache.get("key3");
		assertEquals(null, value);
		
		timestamp = cache.createTimestamp(token11, token12, token13);
		cache.put(timestamp, "key1", "value1", token11);
		cache.put(timestamp, "key2", "value2", token11, token12);
		cache.put(timestamp, "key3", "value3", token11, token12, token13);
		
		value = (String) cache.get("key1");
		assertEquals("value1", value);
		value = (String) cache.get("key2");
		assertEquals("value2", value);
		value = (String) cache.get("key3");
		assertEquals("value3", value);

		entity = new EntityOne();
		entity.set_int(1);
		cache.onChange(EntityOne.class, entity);
		value = (String) cache.get("key1");
		assertEquals(null, value);
		value = (String) cache.get("key2");
		assertEquals(null, value);
		value = (String) cache.get("key3");
		assertEquals(null, value);
	}
}
