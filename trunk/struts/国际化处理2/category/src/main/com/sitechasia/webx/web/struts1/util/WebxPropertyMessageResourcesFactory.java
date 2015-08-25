package com.sitechasia.webx.web.struts1.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.PropertyMessageResourcesFactory;

/**
 * 
 * PropertyMessageResourcesFactory的子类，通过Override createResources方法创建WebxPropertyMessageResources的实例
 * 
 * @author zhou wei
 * @version 1.0
 */

public class WebxPropertyMessageResourcesFactory extends
		PropertyMessageResourcesFactory {

	private static final long serialVersionUID = -6379852687473380646L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.util.PropertyMessageResourcesFactory#createResources
	 * (java.lang.String)
	 */
	public MessageResources createResources(String config) {
		
		
		String config_ = config;
		
		long defaultExpire = -1;
		
		//获取config_和defaultExpire
		if (config != null && config.length() > 0) {

			config_ = StringUtils.substringBefore(config, ("@"));
			String _config = StringUtils.substringAfter(config, ("@"));
			//
			String defaultExpire_ = StringUtils.substringBefore(_config, ("="));
			String _defaultExpire = StringUtils.substringAfter(_config, ("="));

			if (defaultExpire_.equalsIgnoreCase("defaultExpire")) {

				defaultExpire = NumberUtils.toInt(_defaultExpire, -1);

			}
		}

		return new WebxPropertyMessageResources(this, config_, this.returnNull,
				defaultExpire);

	}

}
