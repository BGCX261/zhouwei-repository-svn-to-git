package com.sitechasia.webx.core.utils.dozer;

import com.sitechasia.webx.core.model.IViewObject;

public class MyVO implements IViewObject{
	private int field1;
	private String fieldB;

	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public String getFieldB() {
		return fieldB;
	}

	public void setFieldB(String fieldB) {
		this.fieldB = fieldB;
	}

}
