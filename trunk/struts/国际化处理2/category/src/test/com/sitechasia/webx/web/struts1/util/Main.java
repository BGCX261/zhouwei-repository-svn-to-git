package com.sitechasia.webx.web.struts1.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.math.*;
import org.apache.commons.lang.StringUtils;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String config = "classpath*:modules/**/i18n/*.properties@defaultExpire";
		print(config);
		
		InputStream is = Class.class.getResourceAsStream("/modules/frame/i18n/CategoryEdit_zh_CN.properties");
		
		Properties props = new Properties();

		props.load(is);
		
		props.load(is);
		
	}

	private static void print(String config) {

		String config_ = config;

		int defaultExpire = -1;

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
	}

}
