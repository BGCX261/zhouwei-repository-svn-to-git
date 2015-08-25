/**
 *
 */
package com.sitechasia.webx.core.utils.commons;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import com.sitechasia.webx.core.utils.commons.RandomUtils;


/**
 * <p>Title: RandomUtilsTest</p>
 * <p>Description:RandomUtils单元测试类</p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class RandomUtilsTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testRandom() throws Exception{
		RandomUtils.setCharset("0-z");
		RandomUtils.setLength("20");
		RandomUtils.generateRandomObject();
		String str = RandomUtils.getRandom();
		assertEquals(str.length(),20);
		HashMap map=new HashMap();
		map.put("a","a");
		RandomUtils.setHmap(map);
		RandomUtils.setAllchars(true);
		RandomUtils.setAlgorithm("random");
	}
}
