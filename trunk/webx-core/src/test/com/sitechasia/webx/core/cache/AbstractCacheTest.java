/** 
 * @{#} AbstractCacheTest.java Create on 2008-6-18 上午09:50:09   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache;

import java.util.Map;
import java.util.SortedSet;

import junit.framework.TestCase;

/**
 * 对AbstractCache中的方法进行测试
 * @author Administrator
 * @version 1.0   
 * @see  
 */
public class AbstractCacheTest extends TestCase {
	MockCache cache = new MockCache("test");
	
	public void testGetClassFromTokens() {
		//第一组实例
		CacheToken token11 = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_int", 1);
		CacheToken token12 = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_long", 1l);
		CacheToken token13 = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_String", "test");
		CacheToken token21 = new CacheToken(EntityTwo.class, CacheToken.EQUALS, "nameTwo", "test2");
		CacheToken token22 = new CacheToken(EntityTwo.class, CacheToken.EQUALS, "intTwo", 2);
		CacheToken token31 = new CacheToken(EntityThree.class, CacheToken.EQUALS, "intThree", 3);
		CacheToken token32 = new CacheToken(EntityThree.class, CacheToken.EQUALS, "nameThree", "test3");
		CacheToken token33 = new CacheToken(EntityThree.class, CacheToken.EQUALS, "longThree", 3l);

		//第二组，和第一组重复的实例
		CacheToken token11Too = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_int", 1);
		CacheToken token12Too = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_long", 1l);
		CacheToken token13Too = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_String", "test");
		CacheToken token21Too = new CacheToken(EntityTwo.class, CacheToken.EQUALS, "nameTwo", "test2");
		CacheToken token22Too = new CacheToken(EntityTwo.class, CacheToken.EQUALS, "intTwo", 2);
		CacheToken token31Too = new CacheToken(EntityThree.class, CacheToken.EQUALS, "intThree", 3);
		CacheToken token32Too = new CacheToken(EntityThree.class, CacheToken.EQUALS, "nameThree", "test3");
		CacheToken token33Too = new CacheToken(EntityThree.class, CacheToken.EQUALS, "longThree", 3l);

		//第三组，错误实例
		CacheToken errorToken1 = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_intadsf", 1);
		CacheToken errorToken2 = new CacheToken(EntityTwo.class, CacheToken.EQUALS, "_intadsf", 1);
		CacheToken errorToken3 = new CacheToken(EntityThree.class, CacheToken.EQUALS, "_intadsf", 1);
		
		Map<Class<? extends Object>, SortedSet<CacheToken>> map;
		SortedSet<CacheToken> set;
		
		//正常测试
		map = cache.getClassFromTokens(token11, token12, token13);
		assertEquals(1, map.size());
		set = map.get(EntityOne.class);
		assertEquals(3, set.size());
		
		map = cache.getClassFromTokens(token21, token22);
		assertEquals(1, map.size());
		set = map.get(EntityTwo.class);
		assertEquals(2, set.size());
		
		//重复值的测试
		map = cache.getClassFromTokens(token11, token13, token11Too, token13Too);
		assertEquals(1, map.size());
		set = map.get(EntityOne.class);
		assertEquals(2, set.size());
		
		//错误值的测试
		map = cache.getClassFromTokens(token11, token22, token31);
		assertEquals(3, map.size());
		map = cache.getClassFromTokens(token11, token22, token31, errorToken1, errorToken2);
		assertEquals(null, map);
	}
	
	public void testCache() {
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
		EntityOne entity1 = new EntityOne();
		entity1.set_int(1);
		long affectedSize = cache.onChange(EntityOne.class, entity1);
		assertEquals(3, affectedSize);
		cache.put(timestamp, "key4", "value4", token11, token12, token13);
		
	}
	
	
	class MockCache extends AbstractCache {
		public MockCache(String strategy) {
			super(strategy);
		}

		@Override
		protected boolean doClear() throws CacheException {
			return false;
		}

		@Override
		protected Object doGet(Object key) throws CacheException {
			return null;
		}

		@Override
		protected void doPut(Object key, Object obj) throws CacheException {
		}

		@Override
		protected boolean doRemove(Object key) throws CacheException {
			return false;
		}
	}
	
	
}
