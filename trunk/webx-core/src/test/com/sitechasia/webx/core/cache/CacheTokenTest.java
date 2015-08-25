/** 
 * @{#} CacheTokenTest.java Create on 2008-6-19 下午04:33:17   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache;

import junit.framework.TestCase;

/**
 * CacheToken测试类
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public class CacheTokenTest extends TestCase {
	public void testIsMatch() {
		CacheToken token = new CacheToken(EntityOne.class, CacheToken.GREAT_EQUALS, "_int", 1);
		EntityOne entity = new EntityOne();
		assertEquals(false, token.isMatch(entity));
		entity.set_int(0);
		assertEquals(false, token.isMatch(entity));
		entity.set_int(1);
		assertEquals(true, token.isMatch(entity));
		entity.set_int(2);
		assertEquals(true, token.isMatch(entity));
		
		token = new CacheToken(EntityOne.class, CacheToken.GREAT_THAN, "_int", 2);
		entity.set_int(2);
		assertEquals(false, token.isMatch(entity));
		entity.set_int(5);
		assertEquals(true, token.isMatch(entity));
		
		token = new CacheToken(EntityOne.class, CacheToken.MATCH_ALL, "_int", 234);
		assertEquals(true, token.isMatch(entity));
		entity = null;
		assertEquals(false, token.isMatch(entity));
		
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_Long", 234l);
		entity = new EntityOne();
		entity.set_Long(234l);
		assertEquals(true, token.isMatch(entity));
		entity.set_Long(123l);
		assertEquals(false, token.isMatch(entity));
		
		token = new CacheToken(EntityOne.class, CacheToken.GREAT_THAN, "_float", 1.1f);
		entity.set_float(1.5f);
		assertEquals(true, token.isMatch(entity));
		entity.set_float(0.5f);
		assertEquals(false, token.isMatch(entity));
		
		token = new CacheToken(EntityOne.class, CacheToken.EQUALS, "_double", 1.000000001d);
		entity.set_double(1.000000001d);
		assertEquals(true, token.isMatch(entity));
		
	}
	
}
