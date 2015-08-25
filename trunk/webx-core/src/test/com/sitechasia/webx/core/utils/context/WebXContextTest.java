package com.sitechasia.webx.core.utils.context;

import junit.framework.TestCase;

/**
 *
 * <p>Title: WebXContextTest</p>
 * <p>Description: </p>
 *
 * @author WangYonghui
 * @version 1.0
 */
public class WebXContextTest extends TestCase{

	protected void setUp() throws Exception{
		super.setUp();
	}

	protected void tearDown() throws Exception{
		super.tearDown();
	}

	public void testGetApplicationContext(){
		IContext context = WebXContext.getApplicationContext();
		assertEquals(context.getClass(),ApplicationContext.class);
	}

	public void testGetDataChannelContext(){
		IContext context = WebXContext.getDataChannelContext();
		assertEquals(context.getClass(),DataChannelContext.class);
	}

//	public void testGetUserDataContext(){
//		IContext context = WebXContext.getUserDataContext();
//		assertEquals(context.getClass(),UserDataContext.class);
//	}
}
