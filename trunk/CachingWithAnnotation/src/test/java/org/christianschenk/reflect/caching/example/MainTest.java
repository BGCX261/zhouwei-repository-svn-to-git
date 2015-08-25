package org.christianschenk.reflect.caching.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		MyService myService = (MyService) context.getBean("myService");
		System.out.println("&&&&&&&&&&&&&:" + myService.hello("zhou wei"));
		System.out.println("&&&&&&&&&&&&&:" + myService.hello("zhou wei"));
		System.out.println("&&&&&&&&&&&&&:" + myService.hello("feng"));
		System.out.println("&&&&&&&&&&&&&:" + myService.hello("xiaopangzi"));
	}

}
