package com.techstar.dmis.service.workflow.impl.exception;

import org.springframework.dao.DataAccessException;

public class WorkflowException extends DataAccessException {

	public WorkflowException() {
		super("工作流错误,详情请查看日志");
	}
	
	/**
	 * Constructor for WorkflowExceptioin.
	 * @param msg message
	 */
	public WorkflowException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for WorkflowExceptioin.
	 * @param msg message
	 * @param ex root cause (usually from using a underlying
	 * data access API such as JDBC)
	 */
	public WorkflowException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
