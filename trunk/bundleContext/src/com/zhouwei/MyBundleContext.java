package com.zhouwei;

import org.osgi.framework.BundleContext;



public class MyBundleContext {

	private BundleContext bundleContext;

	
	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	void start (){
		System.out.println("start ........");
		System.out.println(bundleContext.getBundles().toString());
	}
	
	void stop(){
		System.out.println("stop ........");
	}

}
