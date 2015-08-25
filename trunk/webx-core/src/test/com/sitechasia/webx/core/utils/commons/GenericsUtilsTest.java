package com.sitechasia.webx.core.utils.commons;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.base.GenericsUtils;

/**
 */
public class GenericsUtilsTest extends TestCase {

	/**
	 * 测试GenericsUtils的各种情况
	 */
	public void testGetGenericClass() {
		// 测试取出第1,2个范型类定义
		assertEquals(TestBean.class, GenericsUtils.getGenericClass(TestActualGenericsBean.class));
		assertEquals(TestBean2.class, GenericsUtils.getGenericClass(TestActualGenericsBean.class, 1));
		// 测试Index越界
		try {
			GenericsUtils.getGenericClass(TestActualGenericsBean.class, 2);
			fail("index outof box but no exception follow");
		} catch (IndexOutOfBoundsException e) {
			assertNotNull(e.getMessage());
		}
		// 测试无范型定义时返回Object.class
		assertEquals(Object.class, GenericsUtils.getGenericClass(TestActualGenericsBean2.class));
	}

	/**
	 * 带范型定义的父类
	 */
	class TestGenericsBean<T, T2> {

	}

	/**
	 * T1用到的类
	 */
	class TestBean {

	}

	/**
	 * T2用到的类
	 */
	class TestBean2 {

	}

	/**
	 * 定义了父类范型的子类
	 */
	class TestActualGenericsBean extends TestGenericsBean<TestBean, TestBean2> {

	}

	/**
	 * 没有定义父类范型的子类
	 */
	class TestActualGenericsBean2 extends TestGenericsBean {

	}
}
