package com.techstar.framework.utils.test;
/**
 * ��Ԫ������
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
	
	//����ϵͳ�����ļ��Ƿ���سɹ�
	public void _testGetWSAddress() {
		// System.out.println("spring �л�ȡ�� " +
		// configHelper.getBackupLogFilePath() );
		System.out.println("�õ�������ַ: " + ConfigurationHelper.getWSAddress("name1"));
	}
	
	
//	����ϵͳ�����ļ��Ƿ���سɹ�
	public void testGetSql() {
		// System.out.println("spring�л�ȡ�� " +
		// configHelper.getBackupLogFilePath() );
		System.out.println(ConfigurationHelper.getNamedSqlQuery("demo_queryAll"));
	}
	
}
