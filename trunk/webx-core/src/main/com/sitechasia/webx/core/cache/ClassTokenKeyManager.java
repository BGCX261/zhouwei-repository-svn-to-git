/** 
 * @{#} ClassTokenKeyManager.java Create on 2008-6-16 下午04:33:52   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类、Token及Key值的管理类
 * 
 * @author MarkDong
 * @version 1.0
 * @see
 */
public class ClassTokenKeyManager {
	private Class<? extends Object> clazz;
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	private ICache cache;
	// token对应Key列表的map对象
	ConcurrentHashMap<CacheToken, TokenKeys> tokenKeyMap = new ConcurrentHashMap<CacheToken, TokenKeys>();

	public ClassTokenKeyManager(Class<? extends Object> clazz, ICache cache) {
		super();
		this.clazz = clazz;
		this.cache = cache;
	}

	public Class<? extends Object> getClazz() {
		return clazz;
	}

	/**
	 * 根据变化的实体，取得受到影响的key值列表<br>
	 * 
	 * @return 受影响的key值列表
	 */
	public SortedSet<Object> getAffectedKeys(Object obj) {
		try {
			this.lock.readLock().lock();
			Set<CacheToken> tokens = this.tokenKeyMap.keySet();
			SortedSet<Object> affectedKeys = new TreeSet<Object>();
			for (CacheToken token : tokens) {
				if (token.isMatch(obj)) {
					// 处理受影响的token
					TokenKeys keys = this.tokenKeyMap.get(token);
					try {
						keys.lock.writeLock().lock();
						affectedKeys.addAll(keys.keys);
						keys.keys.clear();
						keys.timestamp = this.cache.nextTimestamp();
					} finally {
						keys.lock.writeLock().unlock();
					}
				}
			}
			return affectedKeys;
		} finally {
			this.lock.readLock().unlock();
		}
	}
	
	/**
	 * 根据属性变化值获取受影响的Key值列表
	 * 
	 * @param property 属性名称
	 * @param oldValue 属性原有值
	 * @param newValue 属性新值
	 * @return
	 */
	public SortedSet<Object> getAffectedKeys(String property, Object value) {
		try {
			this.lock.readLock().lock();
			Set<CacheToken> tokens = this.tokenKeyMap.keySet();
			SortedSet<Object> affectedKeys = new TreeSet<Object>();
			for (CacheToken token : tokens) {
				if (token.isMatch(property, value)) {
					// 处理受影响的token
					TokenKeys keys = this.tokenKeyMap.get(token);
					try {
						keys.lock.writeLock().lock();
						affectedKeys.addAll(keys.keys);
						keys.keys.clear();
						keys.timestamp = this.cache.nextTimestamp();
					} finally {
						keys.lock.writeLock().unlock();
					}
				}
			}
			return affectedKeys;
		} finally {
			this.lock.readLock().unlock();
		}
		
	}

	/**
	 * 加入Key值
	 * 
	 * @param tokens token列表
	 * @param key 缓存Key值
	 */
	public boolean addKey(SortedSet<CacheToken> tokens, Object key) {
		try {
			this.lock.readLock().lock();
			for (CacheToken token : tokens) {
				TokenKeys tokenKeys = this.tokenKeyMap.get(token);
				if(tokenKeys == null) {
					//如果此时为空，说明执行过clear操作，放弃该缓存
					return false;
				}
				try {
					tokenKeys.lock.writeLock().lock();
					tokenKeys.addKey(key);
				} finally {
					tokenKeys.lock.writeLock().unlock();
				}
			}
			return true;
		} finally {
			this.lock.readLock().unlock();
		}
	}

	/**
	 * 根据Tokens创建时间戳，将最后的时间戳返回
	 * 
	 * @param tokens token列表
	 */
	public long createTimestamp(SortedSet<CacheToken> tokens) {
		long lastTimestamp = 0l;
		try {
			this.lock.readLock().lock();
			for (CacheToken token : tokens) {
				TokenKeys keys = this.tokenKeyMap.get(token);
				if (keys == null) {
					long timestamp = this.cache.nextTimestamp();
					keys = new TokenKeys(token, timestamp);
					TokenKeys prev = this.tokenKeyMap.putIfAbsent(token, keys);
					if (prev != null)
						keys = prev;
				}
				try {
					keys.lock.readLock().lock();
					if (keys.timestamp > lastTimestamp)
						lastTimestamp = keys.timestamp;
				} finally {
					keys.lock.readLock().unlock();
				}
			}
		} finally {
			this.lock.readLock().unlock();
		}

		return lastTimestamp;
	}

	/**
	 * 获取指定Token列表的最后时间戳
	 * 
	 * @author MarkDong
	 * @param tokens tokens列表
	 * @return 最后的时间戳
	 */
	public long getLastTimestamp(SortedSet<CacheToken> tokens) {
		long timestamp = 0l;
		try {
			this.lock.readLock().lock();
			for (CacheToken token : tokens) {
				TokenKeys keys = this.tokenKeyMap.get(token);
				try {
					keys.lock.readLock().lock();
					if (keys.timestamp > timestamp)
						timestamp = keys.timestamp;
				} finally {
					keys.lock.readLock().unlock();
				}
			}
		} finally {
			this.lock.readLock().unlock();
		}
		return timestamp;
	}

	public void clear() {
		try {
			this.lock.writeLock().lock();
			// TODO: need implements
			for(TokenKeys keys : this.tokenKeyMap.values()) {
				keys.clear();
			}
			this.tokenKeyMap.clear();
			this.cache.nextTimestamp();
		} finally {
			this.lock.writeLock().unlock();
		}
	}
	
	/**
	 * 取得当前被管理的所有缓存Key值，不重复
	 * 
	 * @return 被管理的key值
	 */
	public SortedSet<Object> getKeys() {
		SortedSet<Object> keys = new TreeSet<Object>();
		try {
			this.lock.readLock().lock();
			
			for(TokenKeys tokenKeys : tokenKeyMap.values()) {
				try {
					tokenKeys.lock.readLock().lock();
					keys.add(tokenKeys.keys);
				} finally {
					tokenKeys.lock.readLock().unlock();
				}
			}
		} finally {
			this.lock.readLock().unlock();
		}
		return keys;
	}

	class TokenKeys {
		TokenKeys(CacheToken token, long timestamp) {
			this.token = new CacheToken(token);
			this.timestamp = timestamp;
		}

		CacheToken token;
		long timestamp;
		SortedSet<Object> keys = new TreeSet<Object>();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		void addKey(Object key) {
			keys.add(key);
		}
		
		void clear() {
			this.token = null;
			keys.clear();
		}
	}
}
