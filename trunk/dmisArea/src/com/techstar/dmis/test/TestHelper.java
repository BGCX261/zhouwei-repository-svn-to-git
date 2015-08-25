package com.techstar.dmis.test;

/**
 * 此类用于实现JUNIT测试方法
 * @author
 * @date
 */
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class TestHelper {
		
	public static BeanFactory createBeanFactory(String project) {
		BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(reg);
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+"WEB-INF\\spring\\applicationContext.xml" ));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+"WEB-INF\\spring\\applicationContext_"+project+"_test.xml"));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+"WEB-INF\\spring\\applicationContext_"+project+"_service.xml"));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+"WEB-INF\\spring\\applicationContext_"+project+"_workflow.xml"));				
		BeanFactory bf=(BeanFactory)reg;
		return bf;
	}
}
