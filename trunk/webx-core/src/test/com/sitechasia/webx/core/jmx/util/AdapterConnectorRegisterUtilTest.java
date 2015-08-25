package com.sitechasia.webx.core.jmx.util;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

import junit.framework.TestCase;

import com.sitechasia.webx.components.jmx.util.AdapterConnectorRegisterUtil;
import com.sitechasia.webx.components.jmx.util.AdapterConnectorType;

public class AdapterConnectorRegisterUtilTest extends TestCase {

	public void testRegister() {


		MBeanServer server = MBeanServerFactory.newMBeanServer();
		AdapterConnectorRegisterUtil register = new AdapterConnectorRegisterUtil(server);

		register.createRegister(AdapterConnectorType.DefaultRMIConnector).register();

		register.createRegister(AdapterConnectorType.SunHtmlAdapter).register();
	}
}
