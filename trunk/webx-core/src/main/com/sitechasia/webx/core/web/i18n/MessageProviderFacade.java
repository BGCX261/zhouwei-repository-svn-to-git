package com.sitechasia.webx.core.web.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.GenericServlet;

public class MessageProviderFacade {

	private static Map<String,I18nMessageProvider> messageProviderMapping = new HashMap<String,I18nMessageProvider>();

	public static Properties getLocaleProperties(String jsppath, GenericServlet servlet, Locale locale){

		if( messageProviderMapping.get(jsppath)== null){

			I18nMessageProvider messageProvider = new I18nMessageProvider(jsppath, servlet);

			messageProviderMapping.put(jsppath, messageProvider);
		}

		return  messageProviderMapping.get(jsppath).getProperties(locale);
	}

}
