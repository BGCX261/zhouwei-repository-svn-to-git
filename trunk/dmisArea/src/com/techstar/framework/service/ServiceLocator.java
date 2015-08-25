package com.techstar.framework.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.utils.AppHelper;

/**
 * 定位framework中提供的服务类
 * 
 * 
 * 
 * 加载的文件为applicationContext.xml 此类还提供用户权限信息的存储与检索
 * 
 * 
 * 
 * @author caojian Jan 31, 2007
 * 
 */
public class ServiceLocator {
	private static final Logger logger = Logger.getLogger(ServiceLocator.class);

	private static ServiceLocator locator = null;

	private static ThreadLocal authKey = new ThreadLocal();

	private static ThreadLocal tokenKey = new ThreadLocal();

	private ServiceLocator() {
	}

	public static synchronized ServiceLocator getInstance() {
		if (locator == null) {
			locator = new ServiceLocator();
		}
		return locator;
	}

	public static BeanFactory createBeanFactory() {
		XmlBeanFactory factory = null;
		try {
			Resource res = new FileSystemResource(AppHelper
					.getSpringConfigFilePath());
			factory = new XmlBeanFactory(res);
		} catch (BeansException ex) {
			logger.error(ex.getMessage());
		}
		return factory;
	}
	public static BeanFactory createBeanFactoryForBuss() {
		XmlBeanFactory factory = null;
		try {
			Resource res = new FileSystemResource(AppHelper.getSpringConfigFilePathForBuss());
			factory = new XmlBeanFactory(res);
		} catch (BeansException ex) {
			logger.error(ex.getMessage());
		}
		return factory;
	}
	/**
	 * the common method of getting service
	 * 
	 * @param name
	 * @return
	 */
	public Object getService(String name) {
		return createBeanFactory().getBean(name);
	}

	public Object getServiceForBuss(String name) {
		return createBeanFactoryForBuss().getBean(name);
	}
	public static ISecurityService getSecurityService() {
		return (ISecurityService) createBeanFactory().getBean(
				"iSecurityService");
	}

	public static String getToken() {
		return (String) tokenKey.get();
	}

	public static void setToken(String token) {
		tokenKey.set(token);
	}

	public static void setUserProfile(UserProfile up) {
		authKey.set(up);
	}

	/**
	 * get user's current login profile return null if user doesn't login at all
	 * 
	 * @return
	 */
	public static UserProfile getUserProfile() {
		Object up = authKey.get();
		if (up != null && up instanceof UserProfile) {
			return (UserProfile) up;
		}
		return UserProfile.ANONYMOUS;
	}

}
