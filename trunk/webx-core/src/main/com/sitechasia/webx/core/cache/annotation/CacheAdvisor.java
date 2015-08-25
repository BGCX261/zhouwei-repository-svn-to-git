/** 
 * @{#} CacheAdvisor.java Create on 2008-6-30 上午09:31:30   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import com.sitechasia.webx.core.cache.CacheException;
import com.sitechasia.webx.core.cache.CacheToken;
import com.sitechasia.webx.core.cache.ClassPropertiesCache;
import com.sitechasia.webx.core.cache.ICacheProvider;

/**
 * Cache相关标签的拦截器。<br>
 * 针对WebXCache和WebXUpdate的拦截处理方法
 * 
 * @author MarkDong
 * @version 1.0
 * @see WebXCache;WebXUpdate
 */
public class CacheAdvisor {
	protected Log logger = LogFactory.getLog(getClass());

	private ICacheProvider webxCacheProvider = null;

	/**
	 * WebXUpdate标签拦截处理方法
	 * 
	 * @param pjp 拦截点
	 * @return 被拦截的方法返回值
	 * @throws Throwable 异常
	 */
	public Object doUpdate(ProceedingJoinPoint pjp) throws Throwable {
		if (this.webxCacheProvider != null) {
			Signature sig = pjp.getSignature();
			assert (sig instanceof MethodSignature);
			MethodSignature methodSig = (MethodSignature) sig;
			Method method = methodSig.getMethod();
			WebXUpdate update = method.getAnnotation(WebXUpdate.class);
			
			Class<?>[] clazzes = update.classes();
			for(Class<?> clazz : clazzes)
				this.webxCacheProvider.onChange(clazz);
			
		} 
		return pjp.proceed();
	}
	/**
	 * WebXCache标签拦截处理方法
	 * 
	 * @author MarkDong
	 * @param pjp 拦截点
	 * @return 被拦截的方法返回值
	 * @throws Throwable 异常
	 */
	public Object doCache(ProceedingJoinPoint pjp) throws Throwable {
		// 根据Method内容拼装Key值
		Object retValue = null;
		if (this.webxCacheProvider != null) {
			Signature sig = pjp.getSignature();
			assert (sig instanceof MethodSignature);
			MethodSignature methodSig = (MethodSignature) sig;
			Method method = methodSig.getMethod();
			WebXCache cache = method.getAnnotation(WebXCache.class);

			String key = createKey(pjp);
			retValue = this.webxCacheProvider.get(cache.strategy(), key);
			if (retValue == null) {
				CacheToken[] tokens = null;
				long timestamp = 0l;
				try{
					tokens = createTokens(pjp, cache);
					timestamp = this.webxCacheProvider.createTimestamp(cache.strategy(), tokens);
				} catch(Exception e) {
					logger.error("构造缓存时发生错误", e);
				}
				retValue = pjp.proceed();
				if (retValue != null) {
					try{
						this.webxCacheProvider.put(cache.strategy(), timestamp, key, retValue, tokens);
					} catch(Exception e) {
						logger.error("构造缓存时发生错误", e);
					}
				}
			}
		} else {
			retValue = pjp.proceed();
		}

		return retValue;
	}

	
	/**
	 * 根据Method内容创建缓存key值
	 * 
	 * @param method 方法描述
	 * @return 缓存key值
	 */
	private String createKey(ProceedingJoinPoint pjp) {
		Signature sig = pjp.getSignature();
		assert (sig instanceof MethodSignature);
		MethodSignature methodSig = (MethodSignature) sig;
		Method method = methodSig.getMethod();

		StringBuilder key = new StringBuilder(128);
		// 拼接方法所属的包名及方法名
		key.append(method.getDeclaringClass().toString());
		key.append(":").append(method.getName());
		// 拼接所有参数
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			key.append(":").append(arg.getClass().toString()); // 拼装参数类型
			key.append(":").append(arg); // 拼装参数值
		}
		logger.debug("创建缓存Key：" + key);
		return key.toString();
	}

	/**
	 * 根据Method内容和Cache Annotation信息创建CacheToken
	 * 
	 * @param pjp 方法描述
	 * @param cache Cache Annotation信息
	 * @return CacheToken数组
	 */
	private CacheToken[] createTokens(ProceedingJoinPoint pjp, WebXCache cache) {
		List<CacheToken> tokens = new ArrayList<CacheToken>();
		Class<?>[] classes = cache.classes();

		if (classes.length > 1) {
			// 如果指定了多个实体类，那么全部按MATCH_ALL处理
			for (Class<?> clazz : classes) {
				CacheToken token = new CacheToken(clazz, CacheToken.MATCH_ALL, null, null);
				tokens.add(token);
			}
		} else {
			// 单一实体类的处理
			Class<?> clazz = classes[0];
			String[] properties = cache.properties();
			int[] operators = cache.operators();
			String[] values = cache.values();
			if (operators.length == 0 || properties.length == 0 || values.length == 0
					|| operators.length != properties.length || properties.length != values.length) {
				logger.warn("Cache Annotation未指定相关属性或指定错误，以默认的MATCH_ALL处理。");
				// 仅指定了clazz，按MATCH_ALL处理
				CacheToken token = new CacheToken(clazz, CacheToken.MATCH_ALL, null, null);
				tokens.add(token);
			} else {
				// 处理所有property
				for (int i = 0; i < operators.length; i++) {
					int operator = operators[i];
					if (operator == CacheToken.MATCH_ALL) {
						// 如有含有MATCH_ALL，放弃其它的
						CacheToken token = new CacheToken(clazz, CacheToken.MATCH_ALL, null, null);
						tokens.clear();
						tokens.add(token);
						break;
					}

					String property = properties[i];
					String strValue = values[i];
					Object value;
					if (strValue.indexOf('@') == 0) {
						// 以@开始标识取某个参数的值
						strValue = strValue.substring(1);
						value = getNamedParameter(pjp, strValue);
					} else if (strValue.indexOf('#') == 0) {
						strValue = strValue.substring(1);
						int index = Integer.parseInt(strValue);
						value = getIndexedParameter(pjp, index);
					} else if (strValue != null) {
						value = ClassPropertiesCache.getInstance().transportPropertyValue(clazz, property, strValue);
						if (value == null) {
							logger.debug("CacheToken转换失败");
							continue;
						}
					} else {
						value = strValue;
					}
					CacheToken token = new CacheToken(clazz, operator, property, value);
					tokens.add(token);
				}
			}
		}
		CacheToken[] tokenArray = new CacheToken[tokens.size()];
		tokens.toArray(tokenArray);
		return tokenArray;
	}

	public void setWebxCacheProvider(ICacheProvider webxCacheProvider) {
		this.webxCacheProvider = webxCacheProvider;
	}

	/**
	 * 根据参数名称获取参数值<br>
	 * 由于必须要用Aspect Compiler编译才能拦截到参数名称，所以目前暂时不支持此功能。
	 * @param pjp 拦截点信息
	 * @param param 参数名称
	 * @return 参数值
	 */
	private Object getNamedParameter(ProceedingJoinPoint pjp, String param) {
		Object value = null;
		Signature sig = pjp.getSignature();
		assert (sig instanceof MethodSignature);
		MethodSignature methodSig = (MethodSignature) sig;

		String[] params = methodSig.getParameterNames();
		int i = 0;
		for (i = 0; i < params.length; i++) {
			if (param.equals(params[i]))
				break;
		}

		if (i == params.length)
			return value;

		Object[] args = pjp.getArgs();
		return args[i];
	}

	/**
	 * 根据序号获取参数
	 * 
	 * @param pjp 拦截点信息
	 * @param index 参数序号
	 * @return 参数值
	 */
	private Object getIndexedParameter(ProceedingJoinPoint pjp, int index) {
		Object[] args = pjp.getArgs();
		if (index <= 0 || index > args.length)
			throw new CacheException("非法的参数序号");

		return args[index - 1];
	}

}
