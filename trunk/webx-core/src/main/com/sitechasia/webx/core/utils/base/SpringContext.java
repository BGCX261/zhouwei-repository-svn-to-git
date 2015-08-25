package com.sitechasia.webx.core.utils.base;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 为spring获得上下文写的一个类.
 *
 * @author <a href="mailto:zhoumengchun@myce.net.cn">mczhou</a>
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
@Deprecated
public final class SpringContext {

	private static final Logger logger = Logger.getLogger(SpringContext.class);
	/** 唯一的ApplicationContext */
	private static ApplicationContext context;

//	private

	/** 防止被别人实例化对象 */
	private SpringContext() {
	}

	/**
	 * 初始化唯一的ApplicationContext
	 *
	 */
	private static void init() {
		try {
			String[] realfiles = ResourceFinder.getSpring();
			try {
				context = new ClassPathXmlApplicationContext(realfiles);
			} catch (RuntimeException e) {
				logger.error("error in init spring context--", e);
			}
		} catch (Throwable t) {
			logger.error("error in init spring context--", t);
		}
	}

	/**
	 * 提供给别人调用的接口
	 *
	 * @param serviceName
	 * @return 获取bean对象
	 */
	public static Object getBean(final String serviceName) {
		logger.info("context--" + context);
		if (context == null) {
			synchronized (SpringContext.class) {
				if (context == null) {
					init();
				}
			}
		}
		logger.info("context--" + context);
		return context.getBean(serviceName);
	}

	/**
	 * @return 获取上下文
	 */
	public static ApplicationContext getContext() {
		if (context == null) {
			synchronized (SpringContext.class) {
				if (context == null) {
					init();
				}
			}
		}
		return context;
	}

	/**
	 * @param context
	 */
	public static void setContext(ApplicationContext context) {
		SpringContext.context = context;
	}
}
