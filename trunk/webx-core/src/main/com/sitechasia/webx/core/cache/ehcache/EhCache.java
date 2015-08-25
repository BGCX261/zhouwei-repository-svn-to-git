/** 
 * @{#} EhCache.java Create on 2008-6-12 上午10:19:27   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.sitechasia.webx.core.cache.AbstractCache;
import com.sitechasia.webx.core.cache.CacheException;
import com.sitechasia.webx.core.cache.ICache;

/**
 * EhCache实现类   
 * @author MarkDong
 * @version 1.0   
 * @see  
 */
public class EhCache extends AbstractCache implements ICache {
	Cache cache = null;

	public EhCache(String strategy, Cache cache ) {
		super(strategy);
		this.cache = cache;
	}

	@Override
	protected boolean doClear() {
		cache.clearStatistics();
		return true;
	}

	@Override
	protected Object doGet(Object key) {
		Element element = cache.get(key);
		if(element == null) return null;
		return element.getObjectValue();
	}

	@Override
	protected void doPut(Object key, Object obj) {
		Element element = new Element(key, obj);
		cache.put(element);
	}

	@Override
	protected boolean doRemove(Object key) {
		return cache.remove(key);
	}
}
