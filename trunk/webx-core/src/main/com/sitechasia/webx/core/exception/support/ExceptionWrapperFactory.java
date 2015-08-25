package com.sitechasia.webx.core.exception.support;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.sitechasia.webx.core.utils.base.ResourceFinder;

/**
 * 异常信息包装工厂类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */

public class ExceptionWrapperFactory {
	private static final Logger logger = Logger.getLogger(ExceptionWrapperFactory.class);
	public static final String EXCEPTION_INFO_CONFIG_FILENAMES = "modules/**/exception-info/*.xml";
	/**
	 * 映射,键是异常类名,值是异常信息
	 */
	private Map exceptionInfos = new HashMap();
	// 工厂的单例
	private static ExceptionWrapperFactory instance = new ExceptionWrapperFactory();

	protected ExceptionWrapperFactory() {
		ListableBeanFactory bf = null;
		try {
			String[] theList = ResourceFinder.getFile(EXCEPTION_INFO_CONFIG_FILENAMES);
			String[] allList = new String[theList.length + 1];
			allList[0] = "modules/exception-info.xml";
			for (int i = 0; i < theList.length; i++) {
				allList[i + 1] = theList[i];
			}
			bf = new ClassPathXmlApplicationContext(allList);
			if (bf == null) {
				exceptionInfos = new HashMap(0);
				return;
			}
			String[] beanNames = bf.getBeanNamesForType(ExceptionInfo.class);// for
			for (int i = 0; i < beanNames.length; i++) {
				ExceptionInfo exceptionInfo = (ExceptionInfo) bf.getBean(beanNames[i]);
				exceptionInfos.put(exceptionInfo.getClazz(), exceptionInfo);
			}
		} catch (BeanDefinitionStoreException ex) {
			logger.warn("Error loading exception infos from config file. Message: " + ex.getMessage());
			exceptionInfos = new HashMap(0);
		}
	}

	protected Resource loadResource(String path) {
		return new ClassPathResource(path);
	}

	/**
	 * 在exception-info.xml搜索最匹配的异常信息
	 *
	 * @param cause
	 * @return return ExceptionInfo,如果未找到匹配的记录,return null.
	 */
	protected ExceptionInfo getExceptionInfo(Throwable cause) {
		ExceptionInfo exceptionInfo = (ExceptionInfo) exceptionInfos.get(cause.getClass());
		/**
		 * 如果不能直接找到对应的异常信息,查找其最近的父类
		 */
		if (exceptionInfo == null) {
			Class childClass = cause.getClass();
			Class parentClass = null;
			for (Iterator iter = exceptionInfos.keySet().iterator(); iter.hasNext();) {
				Class clazz = (Class) iter.next();
				// 如果是cause的父类
				if (clazz.isAssignableFrom(childClass)) {
					// 如果parentClass是clazz的父类
					if (parentClass == null || parentClass.isAssignableFrom(clazz)) {
						parentClass = clazz;
					}
				}
			}
			if (parentClass != null) {
				exceptionInfo = (ExceptionInfo) exceptionInfos.get(parentClass);
			}
		}
		return exceptionInfo;
	}

	/**
	 * 得到信息包装类
	 *
	 * @param cause
	 * @return 异常信息包装类
	 */
	public static ExceptionWrapper getExceptionWrapper(Throwable cause) {
		ExceptionInfo exceptionInfo = ExceptionWrapperFactory.getInstance().getExceptionInfo(cause);
		return new ExceptionWrapper(exceptionInfo, cause);
	}

	/**
	 * 得到一个异常信息包装工厂类的实例
	 *
	 * @return Returns the instance.
	 */
	public static ExceptionWrapperFactory getInstance() {
		return instance;
	}
}
