package com.techstar.framework.utils.test;
/**
 * 单元测试类
 * Sep 11, 2006
 * @author xcf
 */
import org.springframework.beans.factory.BeanFactory;

import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.TestHelper;

import junit.framework.TestCase;

public class TestConfigurationHelper extends TestCase {

	public TestConfigurationHelper(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();		
	}
	
	//测试系统配置文件是否加载成功
	public void _testGetWSAddress() {
		// System.out.println("spring 中获取： " +
		// configHelper.getBackupLogFilePath() );
		System.out.println("得到发布地址: " + ConfigurationHelper.getWSAddress("name1"));
	}
	
	
//	测试系统配置文件是否加载成功
	public void testGetSql() {
		// System.out.println("spring中获取： " +
		// configHelper.getBackupLogFilePath() );
		System.out.println(ConfigurationHelper.getNamedSqlQuery("demo_queryAll"));
	}
	
}
