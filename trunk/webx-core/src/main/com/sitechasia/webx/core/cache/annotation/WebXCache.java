/** 
 * @{#} WebXCache.java Create on 2008-6-27 上午10:16:08   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注释类<br>
 *   本注释接收如下几个参数：
 *   <ul>
 *   	<li>strategy</li>：缓存策略名称，如果不指定使用默认缓存
 *   	<li>classes</li>：表示和当前缓存相关的实体类。如果指定了多个classes，则其它参数失效，统一按MATCH_ALL处理。
 *   	<li>properties</li>：实体属性列表。
 *   	<li>operators</li>：比较操作符列表，参见CacheToken类中的常量定义。
 *   	<li>values</li>：属性对应的值。
 *   </ul> 
 *   
 *   对于功能明确的方法，可采用指定属性名称、匹配操作符和属性值的方式使用索引。对于通用功能或关联实体较多的方法可采用
 *   只指定实体类的方式使用索引。
 * @author MarkDong
 * @version 1.0   
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebXCache {
	String strategy() default "DEFAULT_CACHE";
	Class<?>[] classes();	//类名称
	String[] properties() default {};	//属性列表
	String[] values() default {};		//值列表
	int[] operators() default {};		//操作符列表
}
