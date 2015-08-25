package com.techstar.framework.service.security.modelout;

public class ExceptionOut {
	private String NAME;

	private String CODE;

	private String MESSAGE;

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String code) {
		CODE = code;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String message) {
		MESSAGE = message;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}
}
