package com.sitechasia.webx.core.utils.commons;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.commons.SerialNumberUtils;

/**
 * <code>com.sitechasia.webx.core.util.SerialNumberUtils</code>单元测试用例
 * 
 * @author zane
 * 
 */
public class SerialNumberUtilsTest extends TestCase {

	/**
	 * 初始化
	 */
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	/**
	 * 反初始化
	 */
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testBuildSerial() {
		//
		String result;
		result = SerialNumberUtils.buildSerial(89, 1);
		assertEquals(result, "9");

		result = SerialNumberUtils.buildSerial(89, 2);
		assertEquals(result, "89");

		result = SerialNumberUtils.buildSerial(89, 5);
		assertEquals(result, "00089");

		//		
		result = SerialNumberUtils.buidSerial(89, 5, '*');
		assertEquals(result, "***89");

	}
}
