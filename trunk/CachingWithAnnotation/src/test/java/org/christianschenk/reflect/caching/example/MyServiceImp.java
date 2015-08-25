package org.christianschenk.reflect.caching.example;

import org.christianschenk.reflect.caching.Cachable;

public class MyServiceImp implements MyService {

	@Override
	@Cachable(cacheKey="ak47",expire=15L)
	//@Cachable()
	public String hello(String name) {
		return "hello " + name;
	}

}
