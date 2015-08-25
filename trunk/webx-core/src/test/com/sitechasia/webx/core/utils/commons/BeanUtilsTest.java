/**
 * 
 */
package com.sitechasia.webx.core.utils.commons;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.base.BeanUtils;

/**
 * 
 */
public class BeanUtilsTest extends TestCase {
	Object a;

	/*
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		a = new Object() {
			private String name = "test a";

			private void print(String n) {
				System.out.println("printing in a : param:" + n);
			}

		};
	}

	/**
	 * Test method for
	 * {@link com.sitechasia.webx.core.utils.BeanUtils#getPrivateProperty(java.lang.Object, java.lang.String)}.
	 * 
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public void testGetPrivateProperty() throws IllegalAccessException, NoSuchFieldException {
		assertEquals("test a", BeanUtils.getPrivateProperty(a, "name"));
	}

	/**
	 * Test method for
	 * {@link com.sitechasia.webx.core.utils.BeanUtils#setPrivateProperty(java.lang.Object, java.lang.String, java.lang.Object)}.
	 * 
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public void testSetPrivateProperty() throws IllegalAccessException, NoSuchFieldException {
		assertEquals("test a", BeanUtils.getPrivateProperty(a, "name"));
		BeanUtils.setPrivateProperty(a, "name", "test test");
		assertEquals("test test", BeanUtils.getPrivateProperty(a, "name"));
	}

	/**
	 * Test method for
	 * {@link com.sitechasia.webx.core.utils.BeanUtils#invokePrivateMethod(java.lang.Object, java.lang.String, java.lang.Object[])}.
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	/**
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void testInvokePrivateMethod() throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		BeanUtils.invokePrivateMethod(a, "print", "x");
		assertEquals(1, 1);
	}

}
