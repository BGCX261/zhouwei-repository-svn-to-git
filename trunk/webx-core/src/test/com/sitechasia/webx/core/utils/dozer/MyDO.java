package com.sitechasia.webx.core.utils.dozer;

import com.sitechasia.webx.core.model.IDomainObject;

public class MyDO implements IDomainObject{
	private String field1;
	private String fieldA;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getFieldA() {
		return fieldA;
	}

	public void setFieldA(String fieldA) {
		this.fieldA = fieldA;
	}
}
