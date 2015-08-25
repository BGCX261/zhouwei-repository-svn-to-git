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
package com.sitechasia.webx.core.web.struts1.action.aop;
import java.util.Map;
import java.util.Set;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.sitechasia.webx.core.web.struts1.action.StrutsAction;

/**
 * 用于控制对Action层进行AOP操作的管理器
 *
 * @author Administrator
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class ActionAOPManager  implements BeanPostProcessor{

	/**
	 * 包含了一组Advice的AdviceContainer
	 */
	private AdviceContainer container;

	/**
	 * 一个Spring Pointcut
	 */
	private Pointcut pointcut;

	/**
	 * 在bean的属性初始化完成之前不做任何工作
	 */
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        return bean;
    }

	/**
	 * 在bean的属性初始化完成之后进行处理
	 */
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
    	if (!(bean instanceof StrutsAction) || pointcut == null
				|| container == null || container.getAdvices() == null
				|| container.getAdvices().size() == 0) {
			return bean;
		}

    	if (getPointcut().getClassFilter().matches(bean.getClass())) {
    		Map<MethodMatcher,Set<Advice>> aopConfMap = ((StrutsAction)bean).getAopConf();
    		if (aopConfMap == null) return bean;
    		aopConfMap.put(getPointcut().getMethodMatcher(), container.getAdvices());
    	}

        return bean;
    }

	public Pointcut getPointcut() {
		return pointcut;
	}

	public void setPointcut(Pointcut pointcut) {
		this.pointcut = pointcut;
	}

	public AdviceContainer getContainer() {
		return container;
	}

	public void setContainer(AdviceContainer container) {
		this.container = container;
	}

}
