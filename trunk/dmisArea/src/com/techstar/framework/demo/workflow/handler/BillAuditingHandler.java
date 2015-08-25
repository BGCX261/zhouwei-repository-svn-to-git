package com.techstar.framework.demo.workflow.handler;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.Assignable;

import com.techstar.framework.service.workflow.IAssignment;

public class BillAuditingHandler implements IAssignment{

	public void assign(Assignable assignable, ExecutionContext executionContext) throws Exception {
		// TODO Auto-generated method stub
		//assignable.setActorId("auditing");
		assignable.setPooledActors(new String[] { "auditing"});
	}



}
