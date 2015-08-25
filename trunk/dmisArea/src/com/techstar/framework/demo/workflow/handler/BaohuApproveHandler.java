package com.techstar.framework.demo.workflow.handler;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.Assignable;

import com.techstar.framework.service.workflow.IAssignment;

public class BaohuApproveHandler implements IAssignment {

	public void assign(Assignable assignable, ExecutionContext arg1) throws Exception {
		// TODO Auto-generated method stub
		assignable.setPooledActors(new String[] { "baohu"});
	}

}
