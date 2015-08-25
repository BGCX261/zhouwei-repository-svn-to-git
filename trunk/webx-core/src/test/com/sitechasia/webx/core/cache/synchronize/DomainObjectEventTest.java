package com.sitechasia.webx.core.cache.synchronize;

import junit.framework.TestCase;

import org.jgroups.util.Util;

public class DomainObjectEventTest extends TestCase {
	
	public void testDomainObjectEvent() throws Exception {
		DomainObjectEvent event1 = new DomainObjectEvent(String.class);
		byte[] bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		DomainObjectEvent event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);
		
		event1 = new DomainObjectEvent(String.class, "MarkDong", new UserDefinedSerializable("mark", "MarkDong"));
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);

		event1 = new DomainObjectEvent(String.class, "MarkDong", new Integer(100));
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);
		
		event1 = new DomainObjectEvent(String.class, "MarkDong", new Double(123.123123));
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);

		event1 = new DomainObjectEvent(String.class, "MarkDong", new Double(123.123123));
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);

		event1 = new DomainObjectEvent(String.class, "MarkDong", 1234.234);
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);
		
		event1 = new DomainObjectEvent(String.class, "MarkDong", "阿道夫");
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);

		//测试超长字符串
		String long_str = "阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" + 
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫" +
							"阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫阿道夫";
		long_str = long_str + long_str + long_str + long_str + long_str;
		long_str = long_str + long_str + long_str + long_str + long_str;
		long_str = long_str + long_str + long_str + long_str + long_str;
		long_str = long_str + long_str + long_str + long_str + long_str;
		
		event1 = new DomainObjectEvent(String.class, "MarkDong", long_str);
		bytes = Util.objectToByteBuffer(event1);
		System.out.println(bytes.length);
		event2 = (DomainObjectEvent)Util.objectFromByteBuffer(bytes);
		assertEvent(event1, event2);
	}
	
	
	
	private void assertEvent(DomainObjectEvent event1, DomainObjectEvent event2) {
		assertEquals(event2.getSimple(), event1.getSimple());
		assertEquals(event2.getEntityClass(), event1.getEntityClass());
		assertEquals(event2.getProperty(), event1.getProperty());
		assertEquals(event2.getValue(), event1.getValue());
		
	}
}
