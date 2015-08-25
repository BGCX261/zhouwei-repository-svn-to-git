/**
 * Create time 2007-12-27 下午01:58:23
 */
package com.sitechasia.webx.core.utils.base;

import java.io.File;
import java.io.IOException;
import com.sitechasia.webx.core.utils.commons.FileUtils;
import junit.framework.TestCase;

/**
 * <p>Title: ResourceFinderTest</p>
 * <p>Description: </p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class ResourceFinderTest extends TestCase {
	
	public void setUp() throws Exception{
		super.setUp();
	}
	
	public void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testgetSpring(){
		String[] rf=ResourceFinder.getSpring();
		assertEquals(rf[0],"modules/spring.xml");
	}
	
	public void testgetHbm(){
		assertEquals(ResourceFinder.getHbm().length,0);

	}
	
	public void testgetStruts(){
	assertEquals(ResourceFinder.getStruts()[0],"modules/struts.xml");
	}
}
