package com.techstar.framework.service.workflow.bus.test;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;

import com.techstar.framework.service.workflow.bus.IWorkflowService;
import com.techstar.framework.utils.TestHelper;

public class WorkflowServiceTest extends TestCase {

	private IWorkflowService workflowService;
	public WorkflowServiceTest(String name) {
		super(name);
		
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
		workflowService = (IWorkflowService)factory.getBean("iWorkflowService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		workflowService = null;
	}
	
	public void testFindLogsByProcessInstance() {
		fail("Not yet implemented");
	}

	public void testFindPooledTaskInstances() {
		fail("Not yet implemented");
	}

	public void testStart() {
		
		String processDefinition="websale";
		workflowService.start(processDefinition);
		//fail("Not yet implemented");
	}

	public void testSuspend() {
		fail("Not yet implemented");
	}

}
