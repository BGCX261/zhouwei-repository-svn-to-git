package com.techstar.dmis.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
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

	private static XmlBeanFactory factory = null;
	
	

	private ServiceLocator() {
	}

	public static synchronized ServiceLocator getInstance() {
		if (locator == null) {
			locator = new ServiceLocator();
			initFactory();
		}
		return locator;
	}

	public static void initFactory() {
		try {
			
			
			//factory = new XmlBeanFactory(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_jbpmcfg.xml"));
			factory = new XmlBeanFactory(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext.xml"));
			
			XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);		

			//reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext.xml"));
//			reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext.xml"));
			reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_dao.xml"));
			reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_workflow.xml"));

			reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_service.xml"));		
			reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_other.xml"));
			
			
			PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
			cfg.setLocation(new FileSystemResource(AppHelper.getWebAppPath()+"WEB-INF\\spring\\spring.properties"));
//			 now actually do the replacement
			cfg.postProcessBeanFactory(factory);
		} catch (BeansException ex) {
			logger.error(ex.getMessage());
		}
	}

	/**
	 * the common method of getting service
	 * 
	 * @param name
	 * @return
	 */
	public Object getService(String name) {
		return factory.getBean(name);
	}






}
