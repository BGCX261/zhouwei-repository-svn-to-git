package com.techstar.framework.utils.test;
/**
 * 单元测试类
 * Sep 11, 2006
 * @author xcf
 */
import org.springframework.beans.factory.BeanFactory;

import com.techstar.framework.utils.ExceptionCacheHelper;
import com.techstar.framework.utils.TestHelper;

import junit.framework.TestCase;

public class TestExceptionCacheHelper extends TestCase {

	
	public TestExceptionCacheHelper(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("exceptionCacheHelper");
	}

	protected void tearDown() throws Exception {
		super.tearDown();		
	}
	
	//测试异常信息文件是否加载成功
	public void testGetMessage() {

		System.out.println(ExceptionCacheHelper.getMessage("pps.dataAccessException"));

		System.out.println(ExceptionCacheHelper
				.getMessage("pps.mailServiceException"));

	}
}
