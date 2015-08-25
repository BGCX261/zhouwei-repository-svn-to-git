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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

/**
 * 真正ActionHandler的Proxy，将Spring中的Bean做为Handler
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class ActivityHandlerProxy implements ActionHandler {

	private static final long serialVersionUID = -5994156593502472512L;

	/**
	 * 该Handler所调用的服务Bean
	 */
	private String service;
	/**
	 * 在所调用的服务Bean上所要做的操作
	 */
	private String operation;
	/**
	 * 表示所调用服务返回值的Key
	 */
	private String outKey;
	/**
	 * 表示所调用服务参数的Key，用","进行分隔
	 */
	private String inKeys;

	/**
	 * 该Proxy的入口，负责对所代理的服务进行调用
	 */
	public void execute(ExecutionContext executionContext) throws Exception {
		/**
		 * 获得流程中的用于参数传递的Map
		 */
		ContextInstance contextInstance = executionContext.getContextInstance();
		Map params = contextInstance.getTransientVariables();
		/**
		 * 调用真正的服务
		 */
		executeOperation(params);
	}

	/**
	 * 真正执行所指定的方法，并将将返回结果注入数据通道中
	 *
	 * @param params 数据通道
	 * @return 方法执行的返回结果
	 */
	private Object executeOperation(Map<String, Object> params) {
		Object serviceObj = BaseProcessExecutor.getBeanFactory().getBean(getService());
		List<Object> objList = new ArrayList<Object>();
		if (inKeys != null) {
			String[] inKeysArray = inKeys.split(",");
			for (String inKey : inKeysArray) {
				objList.add(params.get(inKey.trim()));
			}
		}
		Object returnObj = null;
		try {
			returnObj = getMethod(serviceObj).invoke(serviceObj, objList.toArray());
		} catch (Exception e) {
			throw new RuntimeException("Method Invoke Failed", e);
		}
		if (returnObj != null && outKey != null) {
			params.put(outKey.trim(), returnObj);
		}
		return returnObj;
	}

	/**
	 * 获得Method对象
	 *
	 * @return 获得Method对象
	 */
	private Method getMethod(Object obj) {
		Method method = null;
		Method[] methodsArray = obj.getClass().getMethods();
		for (Method methodIter : methodsArray) {
			if (methodIter.getName().equals(operation)) {
				method = methodIter;
				break;
			}
		}
		return method;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getOperation() {
		return operation;
	}

	public String getService() {
		return service;
	}

	public String getInKeys() {
		return inKeys;
	}

	public void setInKeys(String inKeys) {
		this.inKeys = inKeys;
	}

	public String getOutKey() {
		return outKey;
	}

	public void setOutKey(String outKey) {
		this.outKey = outKey;
	}
}
