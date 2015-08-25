package com.sitechasia.webx.web.struts1.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * 
 * PropertyMessageResources工具类
 * 
 * @author zhou wei
 * @version 1.0
 */
public class WebxPropertyMessageResourcesUtil {

	// 消息文件信息
	private static Map<String, Long> propertiesCache = null;

	public static Map<String, Long> getPropertiesCache() {
		return propertiesCache;
	}

	private static ResourcePatternResolver resourcePatternResolver = null;

	static {
		propertiesCache = new HashMap<String, Long>();
		resourcePatternResolver = new PathMatchingResourcePatternResolver();
	}

	public static ResourcePatternResolver getResourcePatternResolver() {
		return resourcePatternResolver;
	}

	/**
	 * 
	 * 获取文件路径
	 * 
	 * @param configString
	 *            like
	 *            "classpath*:modules/i18n/*.properties;classpath*:modules/i18n/app.properties"
	 * @param localeKey
	 *            like "en_US"
	 * @return
	 */
	public static String[] getFilesPath(String configString, String localeKey) {

		List<String> filePath_ = new ArrayList<String>();

		String[] configs = StringUtils.tokenizeToStringArray(configString,
				ConfigurableWebApplicationContext.CONFIG_LOCATION_DELIMITERS);

		for (String config : configs) {

			String[] filesPath = getFilesPath(config);

			for (String filePath : filesPath) {

				if (localeKey.length() > 0
						&& org.apache.commons.lang.StringUtils.lastIndexOf(
								filePath, "_" + localeKey + ".properties") > 0)
					filePath_.add(filePath);
			}

		}
		return filePath_.toArray(new String[0]);
	}

	/**
	 * 
	 * 获取文件路径
	 * 
	 * @param regString
	 *            like "classpath*:modules/i18n/*.properties"
	 * @return
	 */
	public static String[] getFilesPath(String regString) {

		String[] resouceArray = null;

		try {
			Resource[] resources = resourcePatternResolver
					.getResources(regString);

			if (resources == null)
				return null;

			int size = resources.length;

			resouceArray = new String[size];

			for (int index = 0; index < size; index++) {
				Resource resource = resources[index];
				String path = resource.getURL().getPath();
				String realPath = path.substring(path.indexOf("classes") + 8);
				resouceArray[index] = realPath;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resouceArray;
	}

	/**
	 * 
	 * 获取待更新文件路径
	 * 
	 * @return
	 */
	public static String[] getFilesPath() {

		List<String> filesPath_ = new ArrayList<String>();

		Set<String> set = propertiesCache.keySet();

		Iterator<String> filePaths = set.iterator();

		while (filePaths.hasNext()) {

			String filePath = filePaths.next();

			try {
				long lastModified_file = getLastModifiedFromFile(filePath);
				long lastModified_cache = getLastModifiedFromCache(filePath);

				if (lastModified_cache < lastModified_file) {
					filesPath_.add(filePath);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return filesPath_.toArray(new String[0]);
	}

	/**
	 * 
	 * 添加指定的消息文件信息
	 * 
	 * @param filePath
	 */
	public static void addCache(String filePath) {
		try {
			propertiesCache.put(filePath, getLastModifiedFromFile(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 更新指定的消息文件信息
	 * 
	 * @param filePath
	 */
	public static void updateCache(String filePath) {
		addCache(filePath);
	}

	/**
	 * 
	 * 刷新消息文件信息
	 * 
	 */
	public static void refreshCache() {

		String[] filePaths = getFilesPath();

		for (String filePath : filePaths) {

			try {
				long lastModified_file = getLastModifiedFromFile(filePath);
				long lastModified_cache = getLastModifiedFromCache(filePath);

				if (lastModified_cache < lastModified_file) {
					updateCache(filePath);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 
	 * 获取指定文件的最后更新时间
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static long getLastModifiedFromFile(String filePath)
			throws IOException {
		return getResourcePatternResolver().getResource(filePath).getFile()
				.lastModified();
	}

	/**
	 * 
	 * 获取缓存中指定文件的最后更新时间
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static long getLastModifiedFromCache(String filePath)
			throws IOException {
		return propertiesCache.get(filePath);
	}

	/**
	 * 
	 * 获取指定文件的国际化关键字 ，比如"messages_zh_CN.properties"就是"zh_CN"
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String getLocaleKey(String filePath) throws IOException {

		File file = getResourcePatternResolver().getResource(filePath)
				.getFile();

		String fileName = file.getName();

		return fileName.substring(fileName.indexOf("_") + 1,
				fileName.length() - 11);
	}
}
