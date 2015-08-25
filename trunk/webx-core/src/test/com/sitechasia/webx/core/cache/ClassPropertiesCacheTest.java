/** 
 * @{#} ClassPropertiesCacheTest.java Create on 2008-6-16 上午11:34:22   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache;

import junit.framework.TestCase;

/**
 * TODO
 * 类说明:   
 * @author Administrator
 * @version 1.0   
 * @see  
 */
public class ClassPropertiesCacheTest extends TestCase {
	ClassPropertiesCache cache = ClassPropertiesCache.getInstance();
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	public void testGetPropClass() {
		assertEquals(cache.getPropClass(EntityOne.class, "_int"), int.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Integer"), Integer.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_float"), float.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Float"), Float.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_double"), double.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Double"), Double.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_long"), long.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Long"), Long.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_byte"), byte.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Byte"), Byte.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_short"), short.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Short"), Short.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_char"), char.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_Character"), Character.class);
		assertEquals(cache.getPropClass(EntityOne.class, "_String"), String.class);
	}
	
	public void testCheckToken() {
		CacheToken token = null;
		//正常的测试
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_int", 1);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Integer", new Integer(1));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_byte", (byte)0x01);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Byte", new Byte((byte)0x01));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_float", 1.0f);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Float", new Float(1.0f));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_double", 1.0d);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Double", new Double(1.0D));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_short", (short)1);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Short", new Short((short)1));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_long", 1l);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Long", new Long(1l));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_char", (char)1);
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Character", new Character((char)1));
		assertEquals(true, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_String", "test");
		assertEquals(true, cache.checkToken(token));
		
		//错误的测试
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_String", 1);
		assertEquals(false, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_int", 1l);
		assertEquals(false, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_long", 1);
		assertEquals(false, cache.checkToken(token));
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_long", 1.0f);
		assertEquals(false, cache.checkToken(token));
		
	}
}
