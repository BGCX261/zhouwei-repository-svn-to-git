/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.components.workflow.jbpm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;

import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.core.io.Resource;

/**
 * 默认提供的进行工作流调用的实现类
 *
 * @author Zal
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class BaseProcessExecutor implements IProcessExecutor, BeanFactoryAware {

	private static BeanFactory beanfactory;

	/**
	 * 本对象所执行的流程
	 */
	private ProcessDefinition definition;

	public void setBeanFactory(BeanFactory beanfactory) throws BeansException {
		if (BaseProcessExecutor.beanfactory != null) {
			BaseProcessExecutor.beanfactory = beanfactory;
		}
	}

	static BeanFactory getBeanFactory() {
		return beanfactory;
	}

	public void setDefinitionLocation(Resource definitionLocation)
			throws IOException {
		if (definitionLocation == null) {
			throw new FatalBeanException(
					"Property [definitionLocation] of class ["
							+ BaseProcessExecutor.class.getName()
							+ "] is required.");
		}

		InputStream inputStream = null;
		try {
			inputStream = definitionLocation.getInputStream();
			this.definition = ProcessDefinition
					.parseXmlInputStream(inputStream);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * 调用流程的方法
	 *
	 * @param params
	 *            向流程所传递的参数
	 */
	public ProcessResult execute(Map<String, Object> params) {
		/**
		 * 获得token
		 */
		ProcessInstance processInstance = new ProcessInstance(definition);
		Token token = processInstance.getRootToken();
		/**
		 * 获得context
		 */
		ContextInstance contextInstance = processInstance.getContextInstance();
		/**
		 * 在Context中放置用于存放临时参数的Map
		 */
		Map<String, Object> paramsMap = new Hashtable<String, Object>();
		if (params != null) {
			for (String key : params.keySet()) {
				Object value = params.get(key);
				if (key != null && value != null) {
					paramsMap.put(key, value);
				}
			}
		}
		contextInstance.setTransientVariables(paramsMap);
		/**
		 * 按照工作流的定义循环执行每个节点
		 */
		while (!token.hasEnded()) {
			/**
			 * 按照transition进行执行
			 */
			String transition = (String) contextInstance
					.getTransientVariable(TRANSITION_NAME);
			/**
			 * 将上一步的返回路径信息删除
			 */
			contextInstance.deleteTransientVariable(TRANSITION_NAME);
			/**
			 * 执行下一步
			 */
			if (transition != null && transition.length() > 0) {
				token.signal(transition);
			} else {
				token.signal();
			}
		}
		/**
		 * 决定返回至哪个页面
		 */
		String forwardPath = (String) contextInstance
				.getTransientVariable(FORWARD_NAME);
		contextInstance.deleteTransientVariable(FORWARD_NAME);

		/**
		 * 返回结果
		 */
		ProcessResult result = new ProcessResult();
		result.setForwardPath(forwardPath);
		result.setParams(contextInstance.getTransientVariables());
		return result;
	}
}
