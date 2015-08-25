//Source file: C:\\test\\com\\techstar\\framework\\service\\security\\WSHelper.java

package com.techstar.framework.service.security.helper;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.techstar.framework.utils.ConfigurationHelper;

public class WSHelper {
	public WSHelper() {

	}

	/**
	 * webservices调用方法
	 * 
	 * @param method -
	 *            方法名称
	 * @param param1 -
	 *            参数一
	 * @return String
	 * @roseuid 44E92C030069
	 */
	public static String callWS(String method, String param1) throws Exception {
		String endpoint = ConfigurationHelper.getWSAddress("security");
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		call.setOperationName(new javax.xml.namespace.QName(
				"http://www.techstar.com.cn/security/ws", method));
		String result = (String) call.invoke(new Object[] { param1 });

		return result;
	}

	/**
	 * webservices调用方法
	 * 
	 * @param method -
	 *            方法名称
	 * @param param1 -
	 *            参数一
	 * @param param2 -
	 *            参数二
	 * @return String
	 * @roseuid 44E92C030069
	 */
	public static String callWS(String method, String param1, String param2)
			throws Exception {
		String endpoint = ConfigurationHelper.getWSAddress("security");
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		call.setOperationName(new javax.xml.namespace.QName(
				"http://www.techstar.com.cn/security/ws", method));
		String result = (String) call.invoke(new Object[] { param1, param2 });

		return result;
	}

	/**
	 * webservices调用方法
	 * 
	 * @param method -
	 *            方法名称
	 * @param param1 -
	 *            参数一
	 * @param param2 -
	 *            参数二
	 * @param param2 -
	 *            参数三
	 * @return String
	 * @roseuid 44E92C030069
	 */
	public static String callWS(String method, String param1, String param2,
			String param3) throws Exception {
		String endpoint = ConfigurationHelper.getWSAddress("security");
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		call.setOperationName(new javax.xml.namespace.QName(
				"http://www.techstar.com.cn/security/ws", method));
		String result = (String) call.invoke(new Object[] { param1, param2,
				param3 });

		return result;
	}
}
