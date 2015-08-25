/** 
 * @{#} ICacheProvider.java Create on 2008-6-11 上午10:42:46   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache;

import java.util.Properties;

/**
 * 参考Hibnerate的CacheProvider接口，提供可替换的缓存接口层
 * 
 * @author MarkDong
 * @version 1.0
 */
public interface ICacheProvider {
	static final String DEFAULT_REGION_NAME = "default";

	/**
	 * 启动缓存
	 * 
	 * @param properties 配置信息
	 */
	void start() throws CacheException;

	/**
	 * 停止缓存
	 */
	void stop() throws CacheException;

	/**
	 * 是否是简单模式
	 * 
	 * @return true of false
	 */
	boolean isSimple();
	
	/**
	 * 向缓存中添加内容
	 * 
	 * @param strategy 缓存策略名称
	 * @param timestamp 时间戳
	 * @param key 缓存主键
	 * @param value 缓存的值
	 * @param tokens 缓存标识
	 */
	void put(final String strategy, final long timestamp, final Object key, final Object value,
			final CacheToken... tokens) throws CacheException;

	/**
	 * 从缓存中取得内容
	 * 
	 * @param strategy 缓存策略名称
	 * @param key 缓存主键
	 * @return 缓存中的内容。如果没有返回null。
	 */
	Object get(final String strategy, final Object key) throws CacheException;

	/**
	 * 删除缓存内容 
	 * 
	 * @param strategy 缓存策略名称
	 * @param key 缓存主键
	 * @return 是否成功
	 * @throws CacheException 
	 */
	boolean remove(final String strategy, final Object key) throws CacheException;
	
	/**
	 * 实体类变化时的回调函数
	 * 
	 * @param clazz 实体类
	 * @return 受影响的缓存数量
	 */
	long onChange(final Class<?> clazz) throws CacheException;

	/**
	 * 实体类变化时的回调函数
	 * 
	 * @param clazz 实体类
	 * @param obj 变化的对象
	 * @return 受影响的缓存数量
	 */
	long onChange(final Class<?> clazz, Object obj) throws CacheException;

	/**
	 * 根据实体类属性变化值淘汰缓存
	 * 
	 * @param clazz 实体类
	 * @param property 属性名称
	 * @param value 属性值
	 * @return
	 */
	long onChange(final Class<?> clazz, final String property, final Object value) throws CacheException;

	/**
	 * 创建时间戳
	 * 
	 * @param strategy 策略名称
	 * @param tokes 缓存标识数组
	 * @return 时间戳
	 */
	long createTimestamp(final String strategy, final CacheToken... tokes);
	
	/**
	 * 通过缓存策略名称取得对应的Cache对象
	 * 
	 * @param strategy 缓存策略名称
	 * @return 对应的Cache。如果没有返回默认Cache
	 */
	ICache getCacheByStrategy(final String strategy) throws CacheException;
	
	/**
	 * 清空指定策略
	 * 
	 * @param strategy 策略名称
	 */
	void clear(final String strategy) throws CacheException;
}
