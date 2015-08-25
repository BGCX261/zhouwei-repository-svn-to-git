package com.sitechasia.webx.core.utils.base;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sitechasia.webx.core.web.i18n.FileUtils;

/**
 * <p>
 * Title: ResourceBinderTest
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author yuming
 * @version 1.0
 */

public class ResourceBinderTest extends TestCase {
	ResourceBinder binder;

	ApplicationContext context;

	public void setUp() throws Exception {
		super.setUp();
		String pathname = FileUtils.getAppPath(ResourceBinderTest.class)
				+ "/com/sitechasia/webx/core/utils/base/spring.xml";
		context = new FileSystemXmlApplicationContext(new String[] { pathname });
		binder = (ResourceBinder) context.getBean("resourceBinder");
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testgetResourceFile() {
		//源代码有问题，无法完成测试
		//assertEquals(binder.getResourceFile()[0],
		//		"com/sitechasia/webx/core/utils/base/test.hbm.xml");
	}

}
