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

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

/**
 * Activity和Decision流程代理
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */

public class ActivityWithDecisionProxy extends ActivityHandlerProxy implements ActionHandler {

	private static final long serialVersionUID = 4871958728999174148L;

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

	public String getPathDecision() {
		return pathDecision;
	}

	public void setPathDecision(String pathDecision) {
		this.pathDecision = pathDecision;
	}

	public void execute(ExecutionContext executionContext) throws Exception {
		/**
		 * 执行Activity流程
		 */
		super.execute(executionContext);

		/**
		 * 执行Decision流程
		 */
		DecisionHandlerProxy decision = new DecisionHandlerProxy();
		decision.setDependens(this.getDependens());
		decision.setForward(this.getForward());
		decision.setPathDecision(this.getPathDecision());
		decision.execute(executionContext);
	}
}
