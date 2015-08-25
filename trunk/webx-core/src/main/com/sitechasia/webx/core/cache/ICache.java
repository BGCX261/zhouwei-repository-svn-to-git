/** 
 * @{#} ICache.java Create on 2008-6-11 上午10:44:07   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache;

/**
 * 可替换的缓存接口
 * 
 * @author MarkDong
 * @version 1.0
 */
public interface ICache {
	/**
	 * 从Cache中取得缓存内容
	 * 
	 * @param key 缓存键值
	 * @return 键值对应的缓存内容，键值不存在时返回null
	 * @throws CacheException 发生错误时抛出
	 */
	public Object get(final Object key) throws CacheException;

	/**
	 * 将内容放入缓存
	 * 
	 * @param timestamp 时间戳
	 * @param key 主键
	 * @param obj 需要缓存的对象
	 * @param tokens 缓存描述符
	 * @throws CacheException 发生错误时抛出
	 */
	public void put(final long timestamp, final Object key, final Object obj, CacheToken... tokens)
			throws CacheException;

	/**
	 * 根据键值删除一个缓存
	 * 
	 * @param key 键值
	 * @return 是否成功
	 * @throws CacheException 发生错误时抛出
	 */
	public boolean remove(final Object key) throws CacheException;

	/**
	 * 实体发生变化时的处理
	 * 
	 * @param clazz 实体类
	 * @return 受影响的key的数量
	 * @throws CacheException 发生错误时抛出
	 */
	public long onChange(final Class<?> clazz) throws CacheException;

	/**
	 * 实体发生变化时的处理
	 * 
	 * @param clazz 实体类
	 * @param obj 变化的实体对象
	 * @return 受影响的key的数量
	 * @throws CacheException 发生错误时抛出
	 */
	public long onChange(final Class<?> clazz, final Object obj) throws CacheException;

	/**
	 * 根据实体类属性变化值淘汰缓存
	 * 
	 * @param clazz 实体类
	 * @param property 属性名称
	 * @param value 属性值
	 * @return
	 */
	public long onChange(final Class<?> clazz, final String property, final Object value) throws CacheException;
	
	/**
	 * 清空缓存
	 * 
	 * @throws CacheException 发生错误时抛出
	 */
	public void clear() throws CacheException;

	/**
	 * 清空跟指定实体类相关的缓存
	 * 
	 * @param clazz 指定的实体类
	 * @throws CacheException 发生错误时抛出
	 */
	public void clear(Class<?>... clazz) throws CacheException;
	
	/**
	 * 取得当前缓存的策略名称
	 * 
	 * @return 策略名称
	 */
	public String getStrategyName();

	public long nextTimestamp();
	
	/**
	 * 根据tokens取得时间戳
	 * 
	 * @param tokens tokens列表
	 * @return 相关的时间戳
	 * @throws CacheException
	 */
	public long createTimestamp(CacheToken... tokens) throws CacheException;

}
