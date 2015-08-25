/**
 * Create time 2007-12-27 下午03:07:37
 */
package com.sitechasia.webx.core.utils.base;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sitechasia.webx.core.utils.commons.FileUtils;
import com.sitechasia.webx.core.utils.commons.XMLUtils;
import com.sitechasia.webx.core.utils.commons.XMLUtilsTest;

import junit.framework.TestCase;

/**
 * <p>Title: SpringContextTest</p>
 * <p>Description: </p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class SpringContextTest extends TestCase {

	ApplicationContext context;
	protected void setUp() throws Exception {
		super.setUp();
		String pathname=SpringContextTest.class.getResource("/com/sitechasia/webx/core/utils/base/spring.xml").getFile();
			
//		File file=new File("spring.xml");
//		file.createNewFile();
//		String absolutePath=file.getAbsolutePath();
//		absolutePath=FileUtils.convertPath(absolutePath);
				
		context = new FileSystemXmlApplicationContext(
				new String[] {pathname });
				
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testsetContext() throws IOException{
		
		SpringContext.setContext(context);
		assertTrue(SpringContext.getContext().containsBean("SpringContext"));
		assertNotNull(SpringContext.getBean("SpringContext"));
	}
}
