package com.sitechasia.webx.core.utils.context;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.context.DataChannelContext;
import com.sitechasia.webx.core.utils.context.IContext;

public class DataChannelContextTest extends TestCase {

	public void testOneThread() {
		IContext context = DataChannelContext.getInstance();

		context.setAttribute("key", "value");

		IContext context2 = DataChannelContext.getInstance();

		assertEquals("value", context2.getAttribute("key"));
	}
}
