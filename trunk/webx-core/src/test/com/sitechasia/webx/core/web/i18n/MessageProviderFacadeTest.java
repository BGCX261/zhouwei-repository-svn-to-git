package com.sitechasia.webx.core.web.i18n;

import java.util.Locale;
import java.util.Properties;

import junit.framework.TestCase;

public class MessageProviderFacadeTest extends TestCase {
	public void testGetLocaleProperties() {

		String jsppath = "/com/sitechasia/webx/core/web/i18n/login.jsp";

		GenericServletMock servlet = new GenericServletMock();

		Locale locale_zh = Locale.CHINESE;

		Locale locale_zh_CN = Locale.CHINA;

		Locale locale_en = Locale.ENGLISH;

		Properties properties_zh = MessageProviderFacade.getLocaleProperties(
				jsppath, servlet, locale_zh);

		Properties properties_zh_CN = MessageProviderFacade
				.getLocaleProperties(jsppath, servlet, locale_zh_CN);

		 Properties properties_en =
		 MessageProviderFacade.getLocaleProperties(jsppath, servlet,
		 locale_en);

		assertEquals(properties_zh.get("name"), "login_zh");
		assertEquals(properties_zh_CN.get("name"), "login_zh_CN");
		assertEquals(properties_en.get("name"), "login_en");
	}
}
