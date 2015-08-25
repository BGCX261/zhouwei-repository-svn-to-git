/** 
 * @{#} AbstractCache.java Create on 2008-6-12 上午10:14:55   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Cache抽象类
 * 
 * @author MarkDong
 * @version 1.0
 * @see ICache
 */
public abstract class AbstractCache implements ICache {
	protected final Log logger = LogFactory.getLog(this.getClass());
	private String strategy;
	
	protected final ClassPropertiesCache classPropCache = ClassPropertiesCache.getInstance();

	// 时间戳
	private AtomicLong timestamp = new AtomicLong(0l);
	// 实体Class对应ClassTokenKeyManager的HashMap
	private ConcurrentHashMap<Class<?>, ClassTokenKeyManager> classTokenMap = new ConcurrentHashMap<Class<?>, ClassTokenKeyManager>();
	// 配合上面HashMap使用的锁	
	private ReadWriteLock classTokenMapLock = new ReentrantReadWriteLock();

	public AbstractCache(String strategy) {
		this.strategy = strategy;
	}

	public final void clear(Class<?>... classes) throws CacheException {
		if(classes == null) return;
		try {
			classTokenMapLock.readLock().lock();
			for (Class<?> clazz : classes) {
				logger.debug("淘汰和" + clazz + "类相关的所有缓存");
				ClassTokenKeyManager mgr = classTokenMap.get(clazz);

				if (mgr == null) {
					logger.warn("没有找到指定的实体类:" + clazz);
					return;
				}

				// 取得所有Keys并删除
				SortedSet<Object> keys = mgr.getKeys();
				for (Object key : keys) {
					try {
						this.doRemove(key);
					} catch (Exception e) {
						// 忽略该错误
						logger.error("存取缓存发生错误", e);
					}
				}
				// 清空该manager
				mgr.clear();
			}
		} finally {
			classTokenMapLock.readLock().unlock();
		}
	}

	public final void clear() throws CacheException {
		logger.debug("清空缓存");
		try {
			// 清理当前缓存的各种内部信息
			classTokenMapLock.writeLock().lock();
			for (ClassTokenKeyManager mgr : classTokenMap.values()) {
				mgr.clear();
			}
			classTokenMap.clear();

			// 清理缓存实现类中的内容
			try {
				this.doClear();
			} catch (Exception e) {
				logger.error("存取Cache发生异常", e);
				throw new CacheException("存取Cache发生异常", e);
			}
		} finally {
			classTokenMapLock.writeLock().unlock();
		}
	}

	public final Object get(Object key) throws CacheException {
		try {
			Object value = this.doGet(key);
			return value;
		} catch (Exception e) {
			logger.error("存取Cache发生异常", e);
			throw new CacheException("存取Cache发生异常", e);
		}
	}

	public String getStrategyName() {
		return this.strategy;
	}

	public long nextTimestamp() {
		return timestamp.incrementAndGet();
	}

	public long createTimestamp(CacheToken... tokens) throws CacheException {
		if (tokens == null || tokens.length == 0) {
			logger.warn("未定义Token列表或列表中包含错误的Token");
			throw new CacheException("未定义Token列表或列表中包含错误的Token");
		}

		Map<Class<?>, SortedSet<CacheToken>> classMap = this.getClassFromTokens(tokens);
		if (classMap == null) {
			logger.warn("未定义Token列表或列表中包含错误的Token");
			throw new CacheException("未定义Token列表或列表中包含错误的Token");
		}

		long lastTimestamp = 0l;
		classTokenMapLock.readLock().lock();
		Set<Class<?>> clazzSet = classMap.keySet();
		// 循环处理所有clazz
		for (Class<?> clazz : clazzSet) {
			SortedSet<CacheToken> tokenSet = classMap.get(clazz);
			ClassTokenKeyManager mgr = this.getClassTokenKeyManager(clazz);
			long timestamp = mgr.createTimestamp(tokenSet);
			if (timestamp > lastTimestamp)
				lastTimestamp = timestamp;
		}

		return lastTimestamp;
	}

	public long onChange(Class<?> clazz) throws CacheException {
		ClassTokenKeyManager mgr = null;
		try {
			classTokenMapLock.readLock().lock();
			mgr = this.classTokenMap.get(clazz);
		} finally {
			classTokenMapLock.readLock().unlock();
		}
		
		if (mgr == null) {
			logger.warn("没有找到相应的Class" + clazz);
			return 0;
		}
		
		SortedSet<Object> keys = mgr.getKeys();
		for(Object key : keys) {
			try {
				this.doRemove(key);
			} catch (Exception e) {
				logger.error("存取Cache发生异常", e);
			}
		}
		mgr.clear();
		return keys.size();
	}
	
	public long onChange(Class<?> clazz, Object obj) throws CacheException {
		ClassTokenKeyManager mgr = null;
		try {
			classTokenMapLock.readLock().lock();
			mgr = this.classTokenMap.get(clazz);
		} finally {
			classTokenMapLock.readLock().unlock();
		}

		if (mgr == null) {
			logger.warn("没有找到相应的Class" + clazz);
			return 0;
		}

		SortedSet<Object> keys = mgr.getAffectedKeys(obj);
		for (Object key : keys) {
			try {
				this.doRemove(key);
			} catch (Exception e) {
				logger.error("存取Cache发生异常", e);
			}
		}

		return keys.size();
	}
	
	public long onChange(Class<?> clazz, String property, Object value) {
		ClassTokenKeyManager mgr = null;
		
		if (mgr == null) {
			logger.warn("没有找到相应的Class" + clazz);
			return 0;
		}

		SortedSet<Object> keys = mgr.getAffectedKeys(property, value);
		for (Object key : keys) {
			try {
				this.doRemove(key);
			} catch (Exception e) {
				logger.error("存取Cache发生异常", e);
			}
		}

		return keys.size();
	}

	public void put(long timestamp, Object key, Object obj, CacheToken... tokens) throws CacheException {
		// 1、根据tokens获取所有相关的Class，同时校验tokens的正确性
		Map<Class<?>, SortedSet<CacheToken>> classMap = this.getClassFromTokens(tokens);
		if (classMap == null) {
			logger.warn("未定义Token列表或列表中包含错误的Token");
			return;
		}

		// 准备相应的数据
		Set<Class<?>> clazzSet = classMap.keySet();
		boolean hasExpired = false;
		for (Class<?> clazz : clazzSet) {
			SortedSet<CacheToken> tokenSet = classMap.get(clazz);
			ClassTokenKeyManager mgr = this.getClassTokenKeyManager(clazz);

			if (mgr.getLastTimestamp(tokenSet) > timestamp) {
				logger.warn("时间戳已经过期，放弃缓存");
				hasExpired = true;
				break;
			} else {
				if (mgr.addKey(tokenSet, key) == false) {
					hasExpired = true;
					break;
				}
			}
		}

		if (!hasExpired) {
			try {
				this.doPut(key, obj);
			} catch (Exception e) {
				logger.error("添加缓存发生错误", e);
				throw new CacheException("添加缓存发生异常", e);
			}
		}
	}

	public boolean remove(Object key) throws CacheException {
		// TODO 前置处理
		try {
			return this.doRemove(key);
		} catch (Exception e) {
			logger.error("存取Cache发生异常", e);
			throw new CacheException("存取Cache发生异常", e);
		}
	}

	/**
	 * 取得指定实体类的缓存管理对象
	 * 
	 * @author MarkDong
	 * @param clazz 指定的实体类
	 * @return 缓存管理对象
	 */
	protected ClassTokenKeyManager getClassTokenKeyManager(Class<?> clazz) {
		try {
			classTokenMapLock.readLock().lock();
			ClassTokenKeyManager mgr = classTokenMap.get(clazz);
			if (mgr == null) {
				mgr = new ClassTokenKeyManager(clazz, this);
				ClassTokenKeyManager prev = classTokenMap.putIfAbsent(clazz, mgr);
				if (prev != null)
					mgr = prev;
			}
			return mgr;
		} finally {
			classTokenMapLock.readLock().unlock();
		}
	}
	
	/**
	 * 根据传入的tokens列表，对Token进行排序滤重等操作<br>
	 * 
	 * @author MarkDong
	 * @param tokens Token对象列表
	 * @return Class-Token的map，如果为null，则表示tokens中有错误
	 */
	protected Map<Class<?>, SortedSet<CacheToken>> getClassFromTokens(CacheToken... tokens) {
		if (tokens == null || tokens.length == 0)
			return null;

		Map<Class<?>, SortedSet<CacheToken>> map = new HashMap<Class<?>, SortedSet<CacheToken>>();
		for (CacheToken token : tokens) {
			if (!classPropCache.checkToken(token)) {
				logger.warn("发现错误的Token" + token);
				map.clear();
				return null;
			}
			SortedSet<CacheToken> tokenList = map.get(token.getClazz());
			if (tokenList == null) {
				tokenList = new TreeSet<CacheToken>();
				map.put(token.getClazz(), tokenList);
			}
			tokenList.add(token);
		}
		return map;
	}

	 		
	protected abstract Object doGet(Object key);
	protected abstract void doPut(Object key, Object obj);
	protected abstract boolean doRemove(Object key);
	protected abstract boolean doClear();
}
