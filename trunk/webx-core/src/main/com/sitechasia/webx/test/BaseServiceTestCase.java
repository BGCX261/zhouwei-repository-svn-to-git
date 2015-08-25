package com.sitechasia.webx.test;

import org.jmock.MockObjectTestCase;

/**
 * service单元测试基类
 * 使用JMock独立测试Service层。 JMock用于解决Service的依赖，因为Service中需要调用DAO的方法，
 * 而单元测试的基本规则是一次只测试一个对象，JMock帮助把Service孤立起来，使它不会受到DAO的影响。
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public abstract class BaseServiceTestCase extends MockObjectTestCase {

	// ~ Constructors ===========================================================
	public BaseServiceTestCase() {}
}
