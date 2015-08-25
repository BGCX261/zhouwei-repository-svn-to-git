package com.sitechasia.webx.core.web.i18n;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.GenericServlet;

import org.apache.log4j.Logger;

public class I18nGlobalMessageProvider implements MessageProvider, Reloadable{

	/**
	 * timerTask
	 */
	private DaemonThread daemon ;

	private static I18nGlobalMessageProvider provider;

	private I18nGlobalMessageProvider(GenericServlet servlet) {

		this.servlet = servlet;

		init(servlet);
		//判断是否配置了热加载
		if(daemon!=null){
			//将自身注册到timerTask中
			daemon.regiester(this);
		}
	}

	public static synchronized I18nGlobalMessageProvider getInstance(GenericServlet servlet){

		if(provider == null){

			provider = new I18nGlobalMessageProvider(servlet);
		}

		return provider;
	}

	/**
	 * 代表一个不存在的文件
	 */
	private final String NOT_EXIST_FILE = "NOT_EXIST_FILE";

	/**
	 * 代表一个空的properties
	 */
	private final Properties NULL_PROPERTIES = new Properties();

	/**
	 * 日志对象.
	 */
	private final Logger logger = Logger.getLogger(I18nGlobalMessageProvider.class);

	/**
	 * 全局资源文件在内存中的影射，key为文件的全路径文件名，value为所对应的properties
	 */
	private Map<String, Properties> globalPropertyFileCache = new HashMap<String, Properties>();

	/**
	 * 默认的国际化字符串，在web.xml设置，支持多个默认配置,用";"或","或空白符隔开
	 */
	private String[] defaultLocales;

	/**
	 * I18nMessageProvider对象集合
	 */
	private List<I18nMessageProvider> i18nMessageProviders = new ArrayList<I18nMessageProvider>();

	/**
	 * GenericServlet
	 */
	private GenericServlet servlet;

	/**
	 * Web上下文的地址
	 */
	private String contextPath;

	/**
	 * 全局资源文件所在的目录
	 */
	private String globalPropertiesDirectory;

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

	public Properties getProperties(Locale locale) {

		currentLocale = locale == null ? Locale.getDefault().toString()
				: locale.toString();

//		check();

		return getGlobalProperties(locale.toString());
	}

	public boolean check() {

		if (filesIsModified()) {

			logger.info("I18nGlobalMessageProvider的check方法显示=========全局资源文件发生改变");

			propertiesRealPathArray = listGlobalPropertiesNames();

			loadGlobalProperties();

			Iterator<I18nMessageProvider> iter = i18nMessageProviders.iterator();

			while(iter.hasNext()){

				iter.next().GlobalMessageChanged();
			}

			return true;
		}
		return false;
	}

	/**
	 * 判断资源文件是否被修改过
	 */
	private boolean filesIsModified() {

		// 从文件系统中将目前符合条件的资源文件取出
		String[] currentFileArray = listGlobalPropertiesNames();

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
	 * 初始化方法，对本类的默认Local进行初始化
	 */
	private void init(GenericServlet servlet) {
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

		if (globalPropertiesDirectory == null) {

			globalPropertiesDirectory = contextPath + "WEB-INF/";
		}

		if (propertiesRealPathArray == null) {

			propertiesRealPathArray = listGlobalPropertiesNames();
		}

		if (propertiesLastModifiedMapping == null) {

			propertiesLastModifiedMapping = getFileLastModified(propertiesRealPathArray);
		}

		 if (globalPropertyFileCache.size() == 0) {

			 loadGlobalProperties();
		 }

		 if(daemon == null){

				daemon = DaemonProvider.getDaemonInstance();
			}
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

	/**
	 * 获得全局资源文件对应的Properties
	 */
	private Properties getGlobalProperties(String locale) {

		String basePath = globalPropertiesDirectory + "action";

		return findPropertiesFromCache(basePath, locale, globalPropertyFileCache);
	}

	/**
	 * io操作，找到全局properties文件
	 */
	private String[] listGlobalPropertiesNames() {

		File globalPropertiesDir = new File(globalPropertiesDirectory);

		String[] allGlobalFiles = globalPropertiesDir
				.list(new GloablPropertiesFilter());
		//判断是否有WEB-INF文件夹
		if(allGlobalFiles == null){
			return new String[0];
		}

		//为全局资源文件添加完整路径
		for(int i = 0;i<allGlobalFiles.length;i++){

			allGlobalFiles[i] = globalPropertiesDirectory + allGlobalFiles[i];
		}

		return allGlobalFiles;
	}

	/**
	 * 将全局资源文件组装到全局资源文件缓存中
	 */
	private void loadGlobalProperties() {

		loadProperties(propertiesRealPathArray, globalPropertyFileCache);
	}

	/**
	 * 将资源文件组装到资源文件缓存中
	 */
	private void loadProperties(String[] propNames, Map propCache) {

		propCache.clear();

		for (String localPropName : propNames) {

			Properties properties = new Properties();

			InputStream is = getFileInputStream(localPropName);

			if (is == null)

				continue;
			try {
				properties.load(is);
			} catch (IOException e) {
				logger.debug(
						"--------------File Load Failed: " + localPropName, e);
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					logger.debug("--------------File Load Failed: "
							+ localPropName, e);
				}
			}


			propCache.put(localPropName, properties);
		}

		if(propCache.size()==0){

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

		while (localeString.length() >= 0) {

			String realName = baseName + localeString + ".properties";

			if (nameSet.contains(realName)) {

				return sourceMap.get(realName);
			}

			if(localeString.length()==0)
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
	private class GloablPropertiesFilter implements FilenameFilter {

		public boolean accept(File dir, String name) {

			return isGlobalProperties(name);
		}

		public boolean isGlobalProperties(String fileName) {

			if (fileName.toLowerCase().equals("action.properties")
					|| (fileName.toLowerCase().startsWith("action_") && fileName
							.toLowerCase().endsWith(".properties"))) {

				return true;
			} else {

				return false;
			}
		}
	}

//	/**
//	 * 回调方法，更新I18nMessageProvider对象的propertiesLocaleCache
//	 *
//	 */
//	public void messageProviderCallback(I18nMessageProvider i18nMessageProvider, Locale locale){
//
//		logger.info("I18nMessageProviderInstance======"+i18nMessageProvider+"调用了回调方法重新将资源文件进行了合并");
//
//		Properties golbalProperties = getGlobalProperties(locale.toString());
//
//		i18nMessageProvider.initCache(locale);
//	}

	/**
	 * 注册方法
	 */
	public void regiester(I18nMessageProvider i18nMessageProvider){

		i18nMessageProviders.add(i18nMessageProvider);
	}
}