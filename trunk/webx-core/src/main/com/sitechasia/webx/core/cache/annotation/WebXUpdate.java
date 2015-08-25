/** 
 * @{#} WebXCacheUpdate.java Create on 2008-7-9 下午01:44:26   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 针对特殊情况的强制刷新缓存的注解<br>
 * 本注解只接收classes数组，根据指定的实体类，强制删除所有缓存中跟该实体类相关的缓存值。
 * 此标签适用于直接更新数据库的方法。
 *    
 * @author MarkDong
 * @version 1.0   
 * @see WebXCache 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebXUpdate {
	Class<?>[] classes();	//类名称
}
