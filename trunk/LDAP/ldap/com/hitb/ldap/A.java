package com.hitb.ldap;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PropertiesConfiguration config = new PropertiesConfiguration("com/hitb/ldap/ak.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
