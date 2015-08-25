package com.sitechasia.webx.core.utils.context;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.context.InMemoryContextCache;

public class InMemoryContextCacheTest extends TestCase {

	public void testSetGetAttribute() {
		InMemoryContextCache cache = new InMemoryContextCache();

		cache.set("key", "value");

		assertEquals("value", cache.get("key"));
	}

	public void testRemoveAttribute() {
		InMemoryContextCache cache = new InMemoryContextCache();

		cache.set("key", "value");

		assertEquals("value", cache.get("key"));

		cache.remove("key");

		assertTrue(cache.get("key") == null);
	}

	public void testClearAttribute() {
		InMemoryContextCache cache = new InMemoryContextCache();

		cache.set("key", "value");

		assertEquals("value", cache.get("key"));

		cache.clear();

		assertTrue(cache.get("key") == null);
	}

	public void testGetAttributeNames() {
		InMemoryContextCache cache = new InMemoryContextCache();

		cache.set("key", "value");
		cache.set("key2", "value2");

		assertEquals("value", cache.get("key"));

		assertTrue(cache.getKeys().size() == 2);
	}
}
