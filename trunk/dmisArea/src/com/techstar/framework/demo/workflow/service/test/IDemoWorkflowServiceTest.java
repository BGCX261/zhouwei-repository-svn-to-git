package com.techstar.framework.demo.workflow.service.test;

import org.springframework.beans.factory.BeanFactory;

import junit.framework.TestCase;

import com.techstar.framework.utils.TestHelper;
import com.techstar.framework.demo.workflow.service.IDemoWorkflowService;;

public class IDemoWorkflowServiceTest extends TestCase {

	private IDemoWorkflowService demoWorkflowService;
	public IDemoWorkflowServiceTest(String name) {
		super(name);
		
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
		demoWorkflowService = (IDemoWorkflowService)factory.getBean("iDemoWorkflowService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		demoWorkflowService = null;
	}
	
	public void testFindLogsByProcessInstance() {
		fail("Not yet implemented");
	}

	public void testFindPooledTaskInstances() {
		fail("Not yet implemented");
	}

	public void testStart() {
		
		String processDefinition="websale";
		demoWorkflowService.start(processDefinition);
		//fail("Not yet implemented");
	}

	public void testSuspend() {
		fail("Not yet implemented");
	}

}
