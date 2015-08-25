package org.christianschenk.reflect.caching;

import static org.christianschenk.reflect.caching.helper.ReflectionHelper.getMethodIdentifier;
import static org.christianschenk.reflect.caching.helper.ReflectionHelper.hasAnnotation;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.christianschenk.reflect.caching.Cachable;
import org.christianschenk.simplecache.SimpleCache;

public class CacheAdvice {

	private static final Logger log = Logger.getLogger(CacheAdvice.class);

	private SimpleCache<Object> cache;

	public void setCache(SimpleCache<Object> cache) {
		this.cache = cache;
	}

	public Object doCache(ProceedingJoinPoint pjp) {

		Signature sig = pjp.getSignature();
		MethodSignature methodSig = (MethodSignature) sig;
		Method method = methodSig.getMethod();
		Object[] args = pjp.getArgs();
		try {
			if (hasAnnotation(method, Cachable.class)) {
				String cacheKey = method.getAnnotation(Cachable.class).cacheKey();
				long expire = method.getAnnotation(Cachable.class).expire();
				if (cacheKey.equalsIgnoreCase("default")) {
					cacheKey = getMethodIdentifier(method, args);
				}
				Object object = this.cache.get(cacheKey);
				if (object != null) {
					return object;
				} else {
					object = pjp.proceed();
					this.cache.put(cacheKey, object, expire);
					return object;
				}
			} else
				return pjp.proceed();
		} catch (Throwable ex) {
			log.error(ex.getMessage());
			return null;
		}

	}
}
