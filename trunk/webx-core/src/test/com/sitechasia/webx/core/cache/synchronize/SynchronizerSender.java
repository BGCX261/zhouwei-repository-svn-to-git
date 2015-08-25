/** 
 * @{#} SynchronizerTest.java Create on 2008-7-29 下午03:32:57   
 *   
 * Copyright (c) 2006- by CE.   
 */
package com.sitechasia.webx.core.cache.synchronize;

import org.jgroups.util.Util;

import junit.framework.TestCase;

/**
 * 同步器测试
 * 
 * @author MarkDong
 * @version 1.0
 * @see
 */
public class SynchronizerSender {
	public static void main(String args[]) {

		Synchronizer sync;

		sync = new Synchronizer();
		sync.setPropertyFile("file:D:/WorkSpaces/WebX-core/webx-core/bin/udp.xml");
		sync.init();
		DomainObjectEvent event1 = new DomainObjectEvent(String.class);

		while (true)
			sync.send(event1);
	}
}
