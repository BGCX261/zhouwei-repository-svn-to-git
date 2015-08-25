package com.sitechasia.webx.validator.test;

import java.util.Locale;
import org.apache.commons.validator.ValidatorException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sitechasia.webx.validator.DefaultBindingErrorProcessor;

import junit.framework.TestCase;

public class MyTester extends TestCase {

	private  static DefaultBindingErrorProcessor defaultBindingErrorProcessor;

	private final static ValidateBean bean = new ValidateBean();

	static {

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath*:com/sitechasia/webx/validator/test/spring-validator.xml");

			defaultBindingErrorProcessor = (DefaultBindingErrorProcessor) context
					.getBean("defaultBindingErrorProcessor");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testRequired() throws ValidatorException {
		print();
	}

	public void testOnlyReturnErrors() throws ValidatorException {

		bean.setLastName("Tester");
		bean.setFirstName("John");
		bean.setStreet1("1 Test Street");
		bean.setCity("Testville");
		bean.setState("TE");
		bean.setPostalCode("12345");
		bean.setAge("Too Old");

		print();

	}

	public void testAllPass() throws ValidatorException {

		bean.setAge("123");

		print();

	}

	private void print() throws ValidatorException {

		String[] errors = defaultBindingErrorProcessor.getErrors(bean,
				"ValidateBean", Locale.CHINA);

		if (errors.length > 0) {
			System.out.println("print errors: " + errors.length);
		} else {
			return;
		}

		for (String error : errors)
			System.out.println(error);
	}

}
