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

import java.util.Map;

import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

/**
 * 用于进行分支选择的代理类
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class DecisionHandlerProxy implements ActionHandler {

	private static final long serialVersionUID = -1820137005088950304L;

	/**
	 * 用于决定路径选择的接口
	 */
	private String pathDecision;

	/**
	 * 进行路径选择时所需要的参数
	 */
	private String dependens;

	/**
	 * 若该节点可以跳出流程，该项代表跳出时所代表的调用流程端的转向
	 */
	private String forward;

	/**
	 * 该代理类的入口
	 */
	public void execute(ExecutionContext executionContext) throws Exception {
		ContextInstance contextInstance = executionContext.getContextInstance();
		Map params = contextInstance.getTransientVariables();

		/**
		 * 根据参数确定路径和分支
		 */
		String transitionName = null;
		if (getPathDecision() != null && getPathDecision().length() > 0) {
			IPathDecision decisionImpl = (IPathDecision) BaseProcessExecutor.getBeanFactory().getBean(getPathDecision());
			String[] dependensArray = dependens.split(",");
			Object[] dependesObjs = new Object[dependensArray.length];

			for (int i = 0; i < dependensArray.length; i++) {
				dependesObjs[i] = params.get(dependensArray[i].trim());
			}

			transitionName = decisionImpl.calculatePath(dependesObjs);
		}

		/**
		 * 设置路径信息
		 */
		if (transitionName != null && transitionName.length() > 0) {
			contextInstance.setTransientVariable(IProcessExecutor.TRANSITION_NAME, transitionName);
		}

		/**
		 * 设置forward信息
		 */
		if (getForward() != null && getForward().length() > 0) {
			contextInstance.setTransientVariable(IProcessExecutor.FORWARD_NAME, getForward());
		}
	}

	public String getPathDecision() {
		return pathDecision;
	}

	public void setPathDecision(String pathDecision) {
		this.pathDecision = pathDecision;
	}

	public String getDependens() {
		return dependens;
	}

	public void setDependens(String dependens) {
		this.dependens = dependens;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}
}
