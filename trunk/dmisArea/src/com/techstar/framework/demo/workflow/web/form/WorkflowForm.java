package com.techstar.framework.demo.workflow.web.form;

import org.apache.struts.action.ActionForm;

public class WorkflowForm extends ActionForm{

	private String actor = null;

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
