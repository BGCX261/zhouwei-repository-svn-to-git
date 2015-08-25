package com.techstar.exchange.transfers.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.techstar.framework.ClassLoaderHelper;
import com.techstar.framework.utils.ConfigurationHelper;

public class MessageConfig {

	public static final String path = "../message.properties";

	public MessageConfig() {
		super();
	}

	public static String getValue(String key) throws Exception {
		Properties prop = new Properties();
		URL url = ClassLoaderHelper.getExtendResource(path);
		InputStream is = ClassLoaderHelper.getStream(url);
		prop.load(is);
		return prop.getProperty(key);
	}
	

	public static Class getTransDtoClassByName(String name) throws Exception {
		String dtoName = getValue("transDtoPackage") + "." + name;
//		System.out.print("transDtoName:" + dtoName);
		return Class.forName(dtoName).newInstance().getClass();
	}
	
	public static Class getBussDtoClassByName(String name) throws Exception {
		String dtoName = getValue("bussDtoPackage") + "." + name;
//		System.out.print("bussDtoName:" + dtoName);
		return Class.forName(dtoName).newInstance().getClass();
	}
}
