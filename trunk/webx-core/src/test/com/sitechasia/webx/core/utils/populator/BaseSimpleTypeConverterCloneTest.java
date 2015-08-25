package com.sitechasia.webx.core.utils.populator;

import java.util.Calendar;
import junit.framework.TestCase;
import com.sitechasia.webx.core.utils.populator.BaseSimpleTypeConverter;

/**
 * <p>Title: BaseSimpleTypeConverterCloneTest</p>
 * <p>Description: 对对象复制的测试</p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class BaseSimpleTypeConverterCloneTest extends TestCase {

	private class CloneableTest extends BaseSimpleTypeConverter {

		protected Object doConvertValue(Object value, Class toType, Object... params) {

			return super.convertValue(value, toType);
		}
	}

	public void testCloneable() {

		BaseSimpleTypeConverter converter=new CloneableTest();
		Calendar c= Calendar.getInstance();
		Object o=converter.convertValue(c, Calendar.class);
		assertFalse(c==o);

		Person p = new Person("majing",25);
		Object pp = converter.convertValue(p, Person.class);
		assertTrue(p == pp);
		}

	class Person {
		private String name;

		private int age;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
	}


}
