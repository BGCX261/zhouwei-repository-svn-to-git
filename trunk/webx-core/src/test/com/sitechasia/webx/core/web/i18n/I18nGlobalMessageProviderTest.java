package com.sitechasia.webx.core.web.i18n;

import java.util.Locale;

import junit.framework.TestCase;

public class I18nGlobalMessageProviderTest extends TestCase {
	public void testCheck() {
		GenericServletMock servlet = new GenericServletMock();
		I18nGlobalMessageProvider i18nGlobalMessageProvider = I18nGlobalMessageProvider
				.getInstance(servlet);
		// 没有改变资源文件
		assertFalse(i18nGlobalMessageProvider.check());
	}

	public void testGetProperties(){
		GenericServletMock servlet = new GenericServletMock();
		I18nGlobalMessageProvider i18nGlobalMessageProvider = I18nGlobalMessageProvider
				.getInstance(servlet);
		Locale locale_zh = Locale.CHINESE;
		Locale locale_zh_CN = Locale.CHINA;
		Locale locale_en = Locale.ENGLISH;
		assertNotNull(i18nGlobalMessageProvider.getProperties(locale_zh));
		assertNotNull(i18nGlobalMessageProvider.getProperties(locale_zh_CN));
		assertNotNull(i18nGlobalMessageProvider.getProperties(locale_en));
	}

}
