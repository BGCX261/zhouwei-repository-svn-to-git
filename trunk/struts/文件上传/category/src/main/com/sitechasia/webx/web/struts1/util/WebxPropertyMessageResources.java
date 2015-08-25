package com.sitechasia.webx.web.struts1.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResourcesFactory;
import org.apache.struts.util.PropertyMessageResources;
import org.springframework.core.io.Resource;

/**
 * 
 * PropertyMessageResources的子类，通过Override loadLocale方法，实现按照指定的通配符完成Properties文件的加载,注意struts配置文件中的写法:
 * 
 * <pre>
 * &lt;message-resources parameter=&quot;classpath*:modules/*.properties&quot; factory=&quot;com.sitechasia.webx.web.struts1.util.WebxPropertyMessageResourcesFactory&quot;&gt;
 * </pre>
 * 
 * 同时检查已经加载的Properties文件是否修改，如果修改了，则重新load该文件
 * 
 * 
 * @author zhou wei
 * @version 1.0
 */

public class WebxPropertyMessageResources extends PropertyMessageResources {

	private static final long serialVersionUID = -5405050536511597579L;

	protected static final Log log = LogFactory
			.getLog(WebxPropertyMessageResources.class);

	private final ExecutorService threads;

	/**
	 * @param factory
	 * @param config
	 *            Properties通配符
	 * @param returnNull
	 * @param defaultExpire
	 *            -1 不进行检查; 0 每一秒检查一次; 大于0 按照指定的分钟
	 */
	public WebxPropertyMessageResources(MessageResourcesFactory factory,
			String config, boolean returnNull, long defaultExpire) {

		super(factory, config, returnNull);

		if (defaultExpire < 0)
			this.threads = null;
		else if (defaultExpire == 0)
			this.threads = Executors.newFixedThreadPool(64);
		else
			this.threads = Executors.newFixedThreadPool(8);

		check(defaultExpire);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.util.PropertyMessageResources#loadLocale(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected synchronized void loadLocale(String localeKey) {
		if (locales.get(localeKey) != null) {
			return;
		} else {
			locales.put(localeKey, localeKey);
		}

		Properties props = new Properties();

		doLoad(props, localeKey);

		if (props.size() < 1) {
			return;
		}
		putMessagesOperation(props, localeKey);

		props = null;
	}

	/**
	 * 
	 * 写入消息
	 * 
	 * @param props
	 * @param localeKey
	 */
	@SuppressWarnings("unchecked")
	private void putMessagesOperation(Properties props, String localeKey) {

		synchronized (messages) {
			Iterator names = props.keySet().iterator();
			while (names.hasNext()) {
				String key = (String) names.next();
				if (log.isTraceEnabled()) {
					log.trace("  Saving message key '"
							+ messageKey(localeKey, key));
				}
				messages
						.put(messageKey(localeKey, key), props.getProperty(key));

			}
		}

	}

	/**
	 * 
	 * 更新消息
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	private void refreshMessagesOperation() {

		String[] filesPath = WebxPropertyMessageResourcesUtil.getFilesPath();

		for (String filePath : filesPath) {

			InputStream is = null;

			try {

				Resource resource = WebxPropertyMessageResourcesUtil
						.getResourcePatternResolver().getResource(filePath);

				if (resource.exists())
					is = new java.io.FileInputStream(resource.getFile()
							.getPath());

				String localeKey = WebxPropertyMessageResourcesUtil
						.getLocaleKey(filePath);

				Properties props = new Properties();

				props.load(is);

				putMessagesOperation(props, localeKey);

				WebxPropertyMessageResourcesUtil.refreshCache();

				props = null;

			} catch (IOException e) {
				log.error("refreshMessagesOperation()", e);
			} finally {
				try {
					if (is != null)
						is.close();

				} catch (IOException e) {
					log.error("refreshMessagesOperation()", e);
				}
			}
		}

	}

	/**
	 * 
	 * 完成Properties load动作,装入消息,注意struts配置文件中的写法:
	 * 
	 * <pre>
	 * &lt;message-resources parameter=&quot;classpath*:modules/*.properties&quot; factory=&quot;com.sitechasia.webx.web.struts1.util.WebxPropertyMessageResourcesFactory&quot;&gt;
	 * </pre>
	 * 
	 * @param props
	 * @param localeKey
	 */
	private void doLoad(Properties props, String localeKey) {

		String[] filesPath = WebxPropertyMessageResourcesUtil.getFilesPath(
				this.config, localeKey);

		for (String filePath : filesPath) {

			InputStream is = getClassLoader().getResourceAsStream(filePath);

			try {

				props.load(is);

				WebxPropertyMessageResourcesUtil.addCache(filePath);

			} catch (IOException e) {
				log.error("doLoad(props, localeKey)", e);
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					log.error("doLoad(props, localeKey)", e);
				}
			}
		}

	}

	/**
	 * 
	 * 获取当前ClassLoader
	 * 
	 * @return
	 */
	private ClassLoader getClassLoader() {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = this.getClass().getClassLoader();
		}
		return classLoader;
	}

	/**
	 * 
	 * 检查文件更新，注意这块只是检查更新文件，如果文件被删除破损无法读取等则不进行更新消息操作
	 * 
	 */
	private void check(long defaultExpire) {

		if (defaultExpire < 0)
			return;

		if (defaultExpire == 0)
			Executors.newScheduledThreadPool(2).scheduleWithFixedDelay(
					this.doCheck(), 1, 1, TimeUnit.SECONDS);
		else
			Executors.newScheduledThreadPool(2).scheduleWithFixedDelay(
					this.doCheck(), defaultExpire, defaultExpire,
					TimeUnit.MINUTES);
	}

	/**
	 * 
	 * 执行检查动作
	 * 
	 */
	private final Runnable doCheck() {
		return new Runnable() {
			public void run() {
				threads.execute(doRefresh());
			}
		};
	}

	/**
	 * 
	 * 执行刷新动作
	 * 
	 */
	private Runnable doRefresh() {
		return new Runnable() {
			public void run() {
				refreshMessagesOperation();
			}
		};
	}

}
