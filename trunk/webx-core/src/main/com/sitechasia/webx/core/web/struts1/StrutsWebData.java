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
package com.sitechasia.webx.core.web.struts1;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.sitechasia.webx.core.annotation.Out;

/**
 * 一个struts多线程共享局部变量的类
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */

public final class StrutsWebData {
	private static final ThreadLocal strutsWebData = new StrutsWebDataThreadLocal();
	private static final String OUT_PARAMETERS = "out.parameters";
	private static final String MAPPING = "mapping";
	private static final String REQUEST = "request";
	private static final String RESPONSE = "response";
	//modified begin
	private static final String ACTIONFORM="actionForm";
	//modified end
	private static final String FORWARD = "FORWARD";

	private Map<String, Object> data = new HashMap<String, Object>();

	private StrutsWebData() {
	}

	public String getForward() {
		return (String)get(FORWARD);
	}

	public void setForward(String forward) {
		put(FORWARD, forward);
	}

	public ActionMapping getActionMapping() {
		return (ActionMapping) get(MAPPING);
	}

	public void setActionMapping(ActionMapping am) {
		put(MAPPING, am);
	}

	//modified begin
	public ActionForm getActionForm(){
		return (ActionForm) get(ACTIONFORM);
	}

	public void setActionForm(ActionForm form){
		put(ACTIONFORM,form);
	}
	//modified end

	public void setRequest(HttpServletRequest request) {
		put(REQUEST, request);
	}

	public HttpServletRequest getRequest() {
		return (HttpServletRequest) get(REQUEST);
	}

	public HttpServletResponse getResponse() {
		return (HttpServletResponse) get(RESPONSE);
	}

	public void setResponse(HttpServletResponse response) {
		put(RESPONSE, response);
	}

	/**
	 * 得到当前线程内上下文.
	 *
	 * @return 当前线程内上下文.
	 */
	public static StrutsWebData getStrutsWebData() {
		StrutsWebData data = (StrutsWebData) strutsWebData.get();
		if (data == null) {
			data = new StrutsWebData();
			strutsWebData.set(data);
		}
		return data;
	}

	private Object get(String key) {
		return data.get(key);
	}

	private void put(String key, Object value) {
		data.put(key, value);
	}

	/**
	 *
	 * 设置输出到request的参数map
	 *
	 * @param map
	 *
	 */
	public void setOutParameters(Map<Out, Object> map) {
		put(OUT_PARAMETERS, map);
	}

	/**
	 *
	 * @return 获得输出到request的参数map
	 *
	 */
	public Map<Out, Object> getOutParameters() {
		return (Map<Out, Object>) get(OUT_PARAMETERS);
	}

	private static final class StrutsWebDataThreadLocal extends ThreadLocal {
		protected Object initialValue() {
			return new StrutsWebData();
		}
	}
}
