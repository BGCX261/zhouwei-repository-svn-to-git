package com.sitechasia.webx.core.web.i18n;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.GenericServlet;

import org.apache.log4j.Logger;

/**
 *
 * 功能描述：进行页面与组件国际化类
 *
 * @author 贺帅彪
 * @create date : 2007-8-30
 */
public final class MessageLocale {

	/**
	 * 代表一个不存在的文件
	 */
	private static final String NOT_EXIST_FILE = "NOT_EXIST_FILE";

	/**
	 * 日志对象.
	 */
	private static final Logger logger = Logger.getLogger(MessageLocale.class);

	/**
	 * 默认的国际化字符串，在web.xml设置，支持多个默认配置,用";"或","或空白符隔开
	 */
	private static String[] defaultLocales;

	/**
	 * Web上下文的地址
	 */
	private static String realPath;

	/**
	 * 资源文件在内存中的影射，key为文件的全路径文件名，value为所对应的properties
	 */
	private static Map<String, Properties> propertyFileCache = new HashMap<String, Properties>();

	/**
	 * 请求资源和实际资源的对应关系表，key代表所请求的资源文件路径，value代表实际所赋予的资源文件路径
	 */
	private static Map<String, String> propertyFileMapping = new HashMap<String, String>();

	/**
	 * 为资源文件Cache初始化一个代表不存在的文件
	 */
	static {
		propertyFileCache.put(NOT_EXIST_FILE, new Properties());
	}

	/**
	 * 本类的私有构造函数
	 */
	private MessageLocale() {
	}

	/**
	 * 读取国际化资源文件
	 *
	 * @param requestLocale
	 *            请求所使用的Locale
	 * @param servlet
	 *            一个StrutsAction的Servlet
	 * @param jspPath
	 *            所应显示的jsp文件的全路径地址
	 * @return 与页面对应的资源属性文件和全局资源属性文件
	 */
	public static Properties getLocaleMessage(Locale requestLocale,
			GenericServlet servlet, String jspPath) {

		init(servlet);

		String currentLocale = requestLocale == null ? Locale.getDefault()
				.toString() : requestLocale.toString();

		Properties resultProperties = getGlobalProperties(servlet
				.getServletName(), currentLocale);

		if (jspPath.indexOf(".jsp") < 0) {
			return resultProperties;
		}

		Properties actionProperties = getLocalProperties(jspPath, currentLocale);

		resultProperties = (Properties) resultProperties.clone();
		resultProperties.putAll(actionProperties);
		return resultProperties;
	}

	/**
	 * 初始化方法，对本类的默认Local和应用的Context进行初始化
	 *
	 * @param servlet
	 *            web.xml中所配置的Servlet
	 */
	private static void init(GenericServlet servlet) {
		if (defaultLocales == null || realPath == null) {
			String defaultLocale = servlet.getInitParameter("defaultLocale");

			if (defaultLocale == null) {
				defaultLocales = new String[] { "zh_CN" };
			} else {
				String[] tempDefaultLocales = defaultLocale.split("[,;\\s]");
				List<String> defaultLocaleList = new ArrayList<String>();

				Pattern fullLocalePattern = Pattern.compile("[a-zA-Z]{2}[_][a-zA-Z]{2}");
				Pattern langLocalePattern = Pattern.compile("[a-zA-Z]{2}");
				for (String locale : tempDefaultLocales) {
					if (locale != null
							&& (fullLocalePattern.matcher(locale).matches() || langLocalePattern
									.matcher(locale).matches())) {
						defaultLocaleList.add(locale);
					}
				}

				defaultLocales = defaultLocaleList.toArray(new String[0]);
			}

			realPath = servlet.getServletContext().getRealPath("/");
		}
	}

	/**
	 * 获得全局的资源文件
	 *
	 * @param globalName
	 *            全局资源配置文件的基本名称
	 * @param currentLocale
	 *            当前所请求的Local
	 * @return 全局资源文件的Properties对象
	 */
	private static Properties getGlobalProperties(String globalName,
			String currentLocale) {
		String baseFilePath = realPath + "WEB-INF/" + globalName + "_";

		return loadedProperty(baseFilePath, currentLocale);
	}

	/**
	 * 获得本地资源文件
	 *
	 * @param servlet
	 *            web.xml中所配置的Servlet
	 * @param jspPath
	 *            所应显示的jsp文件的全路径地址
	 * @param currentLocale
	 *            当前所请求的Local
	 * @return 本地资源文件的Properties对象
	 */
	private static Properties getLocalProperties(String jspPath,
			String currentLocale) {
		jspPath = jspPath.substring(0, jspPath.indexOf(".jsp"));
		String baseFilePath = realPath + jspPath + "_";

		return loadedProperty(baseFilePath, currentLocale);
	}

	/**
	 * 开始对资源文件进行装载
	 *
	 * @param baseFilePath
	 *            基本的装载文件的路径
	 * @param currentLocale 当前所请求的Local
	 * @return 已装载的资源文件的Properties对象
	 */
	private static Properties loadedProperty(String baseFilePath, String currentLocale) {

		String requestFile = baseFilePath + currentLocale + ".properties";

		if (!propertyFileMapping.containsKey(requestFile)) {
			synchronized (propertyFileMapping) {
				if (!propertyFileMapping.containsKey(requestFile)) {
					String[][] searchingFiles = new String[defaultLocales.length + 1][2];
					searchingFiles[0][0] = requestFile;
					searchingFiles[0][1] = currentLocale;

					for (int i = 1; i < searchingFiles.length; i++) {
						String defaultLocale = defaultLocales[i - 1];
						searchingFiles[i][0] = baseFilePath + defaultLocale
								+ ".properties";
						searchingFiles[i][1] = defaultLocale;
					}

					propertyFileMapping.put(requestFile,
							searchUsedFile(searchingFiles));
				}
			}
		}

		return propertyFileCache.get(propertyFileMapping.get(requestFile));
	}

	/**
	 * 搜索应该使用的文件
	 *
	 * @param searchingFiles
	 *            被搜索的文件列表
	 * @return 真正使用的文件
	 */
	private static String searchUsedFile(String[][] searchingFiles) {
		for (String[] searchFile : searchingFiles) {
			String usedFile = searchSingleLocalFile(searchFile[0], searchFile[1].length() == 5);

			if (usedFile != null) {
				return usedFile;
			}
		}

		return NOT_EXIST_FILE;
	}

	/**
	 * 对某一Local的文件进行搜索，顺序为 全文件名 --> 只带语言的文件名 --> 基本文件名
	 *
	 * @param searchFile
	 *            被搜索的文件
	 * @param isFullLocale 代表所请求的请求路径的Locale是否为全信息或只由语言信息
	 * @return 真实被加载的文件名，如果都不存在则返回null
	 */
	private static String searchSingleLocalFile(String searchFile, boolean isFullLocale) {
		String usedFile = searchFile;
		if (!loadPropertiesFromFile(usedFile)) {
			usedFile = getLanguagePropertiesName(searchFile);
			if (!loadPropertiesFromFile(usedFile)) {
				if (isFullLocale) {
					usedFile = getBasePropertiesName(searchFile);
					if (!loadPropertiesFromFile(usedFile)) {
						usedFile = null;
					}
				} else {
					usedFile = null;
				}
			}
		}

		return usedFile;
	}

	/**
	 * 获得只有语言部分的资源文件名
	 *
	 * @param fullName
	 *            全路径文件名
	 * @return 只有语言部分的资源文件名
	 */
	private static String getLanguagePropertiesName(String fullName) {
		StringBuilder langName = new StringBuilder().append(fullName);
		int i = langName.length() - 14;
		return langName.replace(i, i + 3, "").toString();
	}

	/**
	 * 获得基本资源文件名
	 *
	 * @param fullName
	 *            全路径文件名
	 * @return 基本资源文件名
	 */
	private static String getBasePropertiesName(String fullName) {
		StringBuilder langName = new StringBuilder().append(fullName);
		int i = langName.length() - 17;
		return langName.replace(i, i + 6, "").toString();
	}

	/**
	 * 加载资源属性文件，设入对应的cache
	 *
	 * @param fileName
	 *            文件路征
	 * @return 如果加载成功，返回true ,否则返回false
	 */
	private static boolean loadPropertiesFromFile(String fileName) {
		if (!propertyFileCache.containsKey(fileName)) {
			InputStream is = getFileInputStream(fileName);
			if (is == null)
				return false;

			Properties resultProperties = new Properties();
			try {
				resultProperties.load(is);
			} catch (IOException e) {
				logger.debug("--------------File Load Failed: " + fileName, e);
				return false;
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					logger.debug("--------------File Load Failed: " + fileName,
							e);
					return false;
				}
			}

			propertyFileCache.put(fileName, resultProperties);
		}
		return true;
	}

	/**
	 * 取得文件输入流
	 *
	 * @param fileName
	 *            文件绝对路征
	 * @return 返回文件输入流,如果文件存在
	 */
	private static InputStream getFileInputStream(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				logger.debug("--------------File Not Found: " + fileName, e);
			}
		}

		return null;
	}
}
