package com.sitechasia.webx.core.web.i18n;

public class DaemonProvider {

	private static DaemonThread demon;

//	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{
//			"classpath*:modules/spring.xml","classpath*:modules/**/spring-conf/*.xml"});

	public static DaemonThread getDaemonInstance(){

		return demon;
	}

	public static void setDaemonInstance(DaemonThread dem){

		demon = dem;
	}
}
