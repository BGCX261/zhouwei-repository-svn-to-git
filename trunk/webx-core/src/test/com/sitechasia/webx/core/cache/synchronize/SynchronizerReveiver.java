/** 
 * @{#} SynchronizerReveiverTest.java Create on 2008-7-29 下午05:22:59   
 *   
 * Copyright (c) 2006- by CE.   
 */   
package com.sitechasia.webx.core.cache.synchronize;

/**
 * TODO
 * 类说明:   
 * @author Administrator
 * @version 1.0   
 * @see  
 */
public class SynchronizerReveiver {
	public static void main(String args[]) {
		Synchronizer sync;
		sync = new Synchronizer();
		sync.setPropertyFile("file:D:/WorkSpaces/WebX-core/webx-core/bin/udp.xml");
		sync.init();
		
		while(true);
	}
}
