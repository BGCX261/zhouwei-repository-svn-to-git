package com.sitechasia.webx.core.web.i18n;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import junit.framework.TestCase;

public class I18nMessageProviderTest extends TestCase {
	public void testGetProperties() {
		String jsppath = "/com/sitechasia/webx/core/web/i18n/login.jsp";

		GenericServletMock servlet = new GenericServletMock();

		Locale locale_zh = Locale.CHINESE;

		Locale locale_zh_CN = Locale.CHINA;

		Locale locale_en = Locale.ENGLISH;

		I18nMessageProvider i18nMessageProvider = new I18nMessageProvider(
				jsppath, servlet);

		Properties properties_zh = i18nMessageProvider.getProperties(locale_zh);

		Properties properties_zh_CN = i18nMessageProvider
				.getProperties(locale_zh_CN);

		Properties properties_en = i18nMessageProvider.getProperties(locale_en);

		assertEquals(properties_zh.get("name"), "login_zh");
		assertEquals(properties_zh_CN.get("name"), "login_zh_CN");
		assertEquals(properties_en.get("name"), "login_en");

	}

	public void testCheck() {
		String jsppath = "/com/sitechasia/webx/core/web/i18n/login.jsp";
		String jsppath2 = "/com/sitechasia/webx/core/web/i18n/logout.jsp";

		GenericServletMock servlet = new GenericServletMock();

		I18nMessageProvider i18nMessageProvider = new I18nMessageProvider(
				jsppath, servlet);

		I18nMessageProvider i18nMessageProvider2 = new I18nMessageProvider(
				jsppath2, servlet);

		// 没有改变资源文件
		assertFalse(i18nMessageProvider.check());

		// 改变了资源文件
		modifySourceFile();
		assertTrue(i18nMessageProvider2.check());

	}

	// 修改配置文件
	public void modifySourceFile() {
		String apppath = FileUtils.getAppPath(I18nMessageProviderTest.class);
		try {
			FileReader fr = new FileReader(apppath
					+ "/com/sitechasia/webx/core/web/i18n/logout_zh.properties");
			String oldCon = "";
			int c;
			while ((c = fr.read()) != -1)
				oldCon += (char) c;
			fr.close();
			FileWriter fw = new FileWriter(apppath
					+ "/com/sitechasia/webx/core/web/i18n/logout_zh.properties");
			fw.write(oldCon);
			fw.write("insert to the file end.");
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
