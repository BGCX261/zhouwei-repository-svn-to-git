package com.sitechasia.webx.core.web.i18n;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.GenericServlet;

import org.apache.log4j.Logger;

public class I18nMessageProvider implements MessageProvider, Reloadable {

	/**
	 * 资源文件是否改变
	 */
	private boolean propertiesIsChanged = false;

	/**
	 * timerTask
	 */
	private DaemonThread daemon ;

	/**
	 * 代表一个空的properties
	 */
	private final Properties NULL_PROPERTIES = new Properties();

	/**
	 * 代表一个不存在的文件
	 */
	private final String NOT_EXIST_FILE = "NOT_EXIST_FILE";

	/**
	 * 日志对象.
	 */
	private final Logger logger = Logger.getLogger(I18nMessageProvider.class);

	/**
	 * 最终的资源文件映射，key为Locale.toString(),value为所对应的合并以后的properties
	 */
	private Map<Locale, Properties> PropertyLocaleCache = new HashMap<Locale, Properties>();

	/**
	 * 本地资源文件在内存中的影射，key为文件的全路径文件名，value为所对应的properties
	 */
	private Map<String, Properties> localPropertyFileCache = new HashMap<String, Properties>();

	/**
	 * 默认的国际化字符串，在web.xml设置，支持多个默认配置,用";"或","或空白符隔开
	 */
	private String[] defaultLocales;

	/**
	 * GenericServlet
	 */
	private GenericServlet servlet;

	/**
	 * 提供全局资源文件的对象
	 */
	private I18nGlobalMessageProvider globalMessageProvider;

	/**
	 * request请求的jsp地址
	 */
	private String jspPath;

	/**
	 * Web上下文的地址
	 */
	private String contextPath;

	/**
	 * jsp文件所在的目录
	 */
	private String jspDirectory;

	/**
	 * 资源文件的真实全路径所组成的字符数组
	 */
	private String[] propertiesRealPathArray;

	/**
	 * 资源文件名称与最后修改时间的map
	 */
	private Map<String, Long> propertiesLastModifiedMapping;

	/**
	 * 请求的真实locale字符串
	 */
	private String currentLocale;

	public I18nMessageProvider(String jspPath, GenericServlet servlet) {

		this.jspPath = jspPath;

		this.servlet = servlet;

		globalMessageProvider = I18nGlobalMessageProvider.getInstance(servlet);

		init();

		//判断是否配置了热加载
		if(daemon!=null){
			// 注册进timertask
			daemon.regiester(this);
		}
		//注册进I18nGlobalMessageProvider
		globalMessageProvider.regiester(this);
	}

	/**
	 * 初始化方法，对本类的默认Local进行初始化
	 *
	 * @param servlet
	 *            web.xml中所配置的Servlet
	 */
	private void init() {
		if (defaultLocales == null) {

			String defaultLocale = servlet.getInitParameter("defaultLocale");

			if (defaultLocale == null) {

				defaultLocales = new String[] { "zh_CN" };

			} else {

				String[] tempDefaultLocales = defaultLocale.split("[,;\\s]");

				List<String> defaultLocaleList = new ArrayList<String>();

				Pattern fullLocalePattern = Pattern
						.compile("[a-zA-Z]{2}[_][a-zA-Z]{2}");

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
		}

		if (contextPath == null) {

			contextPath = convertDOSPath(servlet.getServletContext()
					.getRealPath("/"));
		}

		if (jspDirectory == null) {

			jspDirectory = contextPath
					+ jspPath.substring(0, jspPath.lastIndexOf("/") + 1);
		}

		if (propertiesRealPathArray == null) {

			propertiesRealPathArray = listLocalPropertiesNames();
		}

		if (propertiesLastModifiedMapping == null) {

			propertiesLastModifiedMapping = getFileLastModified(propertiesRealPathArray);
		}

		if (localPropertyFileCache.size() == 0) {

			loadLocalProperties();
		}

		if(daemon == null){

			daemon = DaemonProvider.getDaemonInstance();
		}
	}

	public Properties getProperties(Locale locale) {

		currentLocale = locale == null ? Locale.getDefault().toString()
				: locale.toString();

		if (!PropertyLocaleCache.containsKey(locale)){

			initCache(locale);

		}
		else if(propertiesIsChanged){

			initCache(locale);

			propertiesIsChanged = false;
		}

		return PropertyLocaleCache.get(locale);
	}

	/**
	 * 根据文件名，得到其最后修改时间
	 */
	private Map<String, Long> getFileLastModified(String[] fileNames) {

		Map<String, Long> map = new HashMap<String, Long>();

		for (String fileName : fileNames) {

			File file = new File(fileName);

			map.put(fileName, file.lastModified());
		}

		return map;
	}

	public boolean check() {

		if (filesIsModified()) {

			logger.info("I18nMessageProvider的check方法显示=========本地资源文件发生改变");

			propertiesRealPathArray = listLocalPropertiesNames();

			loadLocalProperties();

			propertiesIsChanged = true;
		}

		return propertiesIsChanged;
	}

	/**
	 * 判断资源文件是否被修改过
	 */
	private boolean filesIsModified() {

		// 从文件系统中将目前符合条件的资源文件取出
		String[] currentFileArray = listLocalPropertiesNames();

		// List<File> currentFileList = convertStringToFile(currentFileArray);

		Map<String, Long> currentFileMap = getFileLastModified(currentFileArray);

		if(propertiesLastModifiedMapping.size()!=currentFileMap.size()){

			propertiesLastModifiedMapping = getFileLastModified(currentFileArray);

			return true;
		}

		for (String currentFile : currentFileMap.keySet()) {

			if (!(propertiesLastModifiedMapping.containsKey(currentFile) && (new File(
					currentFile).lastModified() == propertiesLastModifiedMapping.get(currentFile)))) {

				propertiesLastModifiedMapping = getFileLastModified(currentFileArray);

				return true;
			}
		}
		return false;
	}

	/**
	 * 暴露给I18nGlobalMessageProvider的方法，在全局资源文件变化时将globalMessageIsChanged置为true
	 */
	public void GlobalMessageChanged(){
		propertiesIsChanged = true;
	}

	/**
	 * 初始化资源文件的缓存
	 *
	 * @param locale
	 */
	public void initCache(Locale locale) {

		Properties globalProperty = globalMessageProvider.getProperties(locale);

		Properties localProperty = getLocalProperties(currentLocale);

		 if (jspPath.indexOf(".jsp") < 0) {

		 PropertyLocaleCache.put(locale, globalProperty);
		 }

		 globalProperty = (Properties) globalProperty.clone();

		 globalProperty.putAll(localProperty);

		 PropertyLocaleCache.put(locale, globalProperty);
	}

	/**
	 * 根据文件真实路径数组获得所对应的文件列表
	 */
	private List<File> convertStringToFile(String[] nameArray) {

		List propertiesFileList = new ArrayList();

		for (String propertiesRealPath : nameArray) {

			File file = new File(propertiesRealPath);

			propertiesFileList.add(file);

		}

		return propertiesFileList;
	}

	/**
	 * 获得本地资源文件对应的Properties
	 */
	private Properties getLocalProperties(String locale) {

		String basePath = (contextPath + jspPath).substring(0,
				(contextPath + jspPath).lastIndexOf("."));

		return findPropertiesFromCache(basePath, locale, localPropertyFileCache);
	}

	/**
	 * io操作，找到所有本地properties文件，包括默认的资源文件
	 */
	private String[] listLocalPropertiesNames() {

		File jspDir = new File(jspDirectory);

		String[] allJspFiles = jspDir.list(new LocalPropertiesFilter());

		// 为本地资源文件添加完整路径
		for (int i = 0; i < allJspFiles.length; i++) {

			allJspFiles[i] = jspDirectory + allJspFiles[i];
		}

		return allJspFiles;
	}

	/**
	 * 将本地资源文件组装到本地资源文件缓存中
	 */
	private void loadLocalProperties() {

		loadProperties(propertiesRealPathArray, localPropertyFileCache);
	}

	/**
	 * 将资源文件组装到资源文件缓存中
	 */
	private void loadProperties(String[] propNames, Map propCache) {

		propCache.clear();

		for (String localePropName : propNames) {

			Properties properties = new Properties();

			InputStream is = getFileInputStream(localePropName);

			if (is == null)
				continue;

			try {

				properties.load(is);

			} catch (IOException e) {

				logger.debug("--------------File Load Failed: "
						+ localePropName, e);
			} finally {

				try {

					is.close();

				} catch (IOException e) {

					logger.debug("--------------File Load Failed: "
							+ localePropName, e);
				}
			}


			propCache.put(localePropName, properties);
		}

		if (propCache.size() == 0) {

			propCache.put(NOT_EXIST_FILE, NULL_PROPERTIES);
		}
	}

	/**
	 * 根据locale匹配Properties
	 *
	 * @param baseName
	 *            带路径但没有后缀的字符串。
	 */
	private Properties findPropertiesFromCache(String baseName, String locale,
			Map<String, Properties> sourceMap) {

		Set nameSet = sourceMap.keySet();

		String localeString = "_" + locale;
		//顺序1_en_CA.properties：1_en_CA.properties-->1_en.properties-->1.properties
		//顺序1_en.properties:1_en.properties-->1.properties
		while (localeString.length() >= 0) {

			String realName = baseName + localeString + ".properties";

			if (nameSet.contains(realName)) {

				return sourceMap.get(realName);
			}
			if (localeString.length() == 0)
				break;

			localeString = localeString.substring(0, localeString.length() - 3);
		}

		// 在与当前Locale相对应的没有找到的前提下去寻找与默认的Locale相对应的Properties
		for (String defaultLocale : defaultLocales) {

			String defaultString = "_" + defaultLocale;

//			while (defaultString.length() > 0) {

				String defaultName = baseName + defaultString + ".properties";

				if (nameSet.contains(defaultName)) {

					return sourceMap.get(defaultName);
				}

//				defaultString = defaultString.substring(0, defaultString
//						.length() - 3);
//			}
		}

		return NULL_PROPERTIES;
	}

	/**
	 * 取得文件输入流
	 *
	 * @param fileName
	 *            文件绝对路征
	 * @return 返回文件输入流,如果文件存在
	 */
	private InputStream getFileInputStream(String fileName) {

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

	/**
	 * 转义字符串，将url统一换成“/”形式
	 *
	 * @param strPath
	 *            需要转义的URL
	 * @return 转义之后的URL
	 */
	private static String convertDOSPath(String strPath) {

		// 使用正则表达式替换
		return strPath.replaceAll("\\\\", "/");
	}

	/**
	 *文件名过滤得内部类
	 */
	private class LocalPropertiesFilter implements FilenameFilter {

		public boolean accept(File dir, String name) {

			return isLocalProperties(name);
		}

		public boolean isLocalProperties(String fileName) {

			String prefixJspPath = jspPath.substring(
					jspPath.lastIndexOf("/") + 1, jspPath.lastIndexOf("."));

			if ((fileName.toLowerCase().endsWith(".properties") && fileName
					.toLowerCase().startsWith(prefixJspPath + "_"))
					|| fileName.toLowerCase().equals(
							prefixJspPath + ".properties")) {

				return true;

			} else {

				return false;

			}
		}

	}

}
