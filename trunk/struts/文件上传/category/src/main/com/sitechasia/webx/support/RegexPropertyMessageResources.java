package com.sitechasia.webx.support;

import java.io.IOException;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * ReloadableResourceBundleMessageSource的子类，通过Override setBasenames方法，完成对通配符的支持：
 * 
 * <pre>
 * 	&lt;bean id=&quot;messageSource&quot; class=&quot;com.sitechasia.webx.support.RegexPropertyMessageResources&quot;&gt;
 * 		&lt;property name=&quot;basenames&quot;&gt;
 * 			&lt;list&gt;
 * 				&lt;value&gt;webx/validator/*.properties&lt;/value&gt;
 * 			&lt;/list&gt;
 * 		&lt;/property&gt;
 * 	&lt;/bean&gt;
 * </pre>
 * 
 * @author zhou wei
 * @version 1.0
 */
public class RegexPropertyMessageResources extends
		ReloadableResourceBundleMessageSource {

	protected static final Log log = LogFactory
			.getLog(RegexPropertyMessageResources.class);

	private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	private static String PROPERTY_POSTFIX = ".properties";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.support.ReloadableResourceBundleMessageSource
	 * #setBasenames(java.lang.String[])
	 */
	public void setBasenames(String[] baseNames) {

		String[] baseNames_ = new String[0];

		for (String baseName : baseNames) {
			String[] paths = getFilesPath(baseName);
			baseNames_ = (String[]) ArrayUtils.addAll(baseNames_, paths);
		}
		// 调用父类的setBasenames方法
		super.setBasenames(baseNames_);
	}

	/**
	 * 
	 * 获取文件路径
	 * 
	 * @param regString
	 *            like "classpath*:modules/i18n/*.properties"
	 * @return
	 */
	private String[] getFilesPath(String regString) {

		String[] resouceArray = null;

		// web环境需要特殊对待,原因是ReloadableResourceBundleMessageSource类中的setBasenames方法比较挑剔
		String web_postfix = "WEB-INF/classes/";

		boolean isWeb = StringUtils.containsIgnoreCase(regString, web_postfix);

		try {

			if (isWeb) {
				regString = StringUtils.remove(regString, web_postfix);
			}

			Resource[] resources = resourcePatternResolver
					.getResources(regString);

			if (resources == null)
				return null;

			int size = resources.length;

			resouceArray = new String[size];

			for (int index = 0; index < size; index++) {

				Resource resource = resources[index];

				String resourc_path = StringUtils.removeStart(this.getClass()
						.getResource("/").toString(), "file:/");

				String url_path = resource.getURL().getPath();

				String class_Path = StringUtils.remove(url_path, resourc_path);

				String path = class_Path.substring(0, class_Path
						.indexOf(PROPERTY_POSTFIX));

				if (isWeb) {
					path = web_postfix + path;
				}

				resouceArray[index] = path;

			}
		} catch (IOException e) {
			log.error(this.getClass().getSimpleName() + " getFilesPath("
					+ "regString" + ")" + e);
		}
		return resouceArray;
	}

}
