package com.zhouwei.dozer;

import net.sf.dozer.util.mapping.converters.CustomConverter;

public class MyCustomConverter implements CustomConverter {

	@SuppressWarnings("unchecked")
	public Object convert(Object destination, Object source, Class destClass,
			Class sourceClass) {
		A a = (A) source;
		B b = (B) destination;
		if (a.getCode() == 1) {
			b.setCode("中国");
		}
		return b;
	}
}
