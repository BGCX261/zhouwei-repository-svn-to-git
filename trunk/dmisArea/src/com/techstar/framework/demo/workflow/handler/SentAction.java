package com.techstar.framework.demo.workflow.handler;

import org.jbpm.graph.exe.ExecutionContext;

import com.techstar.framework.service.workflow.IAction;

public class SentAction implements IAction {

	public void execute(ExecutionContext executionContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("发送了一份邮件");
		executionContext.leaveNode();
	}

}
