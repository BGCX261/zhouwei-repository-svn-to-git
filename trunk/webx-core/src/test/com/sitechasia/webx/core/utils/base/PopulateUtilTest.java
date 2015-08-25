/**
 * Create time 2008-1-7 下午04:10:32
 */
package com.sitechasia.webx.core.utils.base;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * <p>
 * Title: PopulateUtilsTest
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author WangYonghui
 * @version 1.0
 */
public class PopulateUtilTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPopulate() throws Exception {
		A a = new A("30", "wyh", "male", "grade 1", "59.99");

		B b1 = new B();
		PopulateUtil.populate(a, b1);
		assertEquals(b1.getAge(), 30);
		assertEquals(b1.getScore(), 59.99);
		assertEquals(b1.getName(), "wyh");

		B b2 = new B();
		/*
		 * 指定注值时源对象中属性和目标对象中属性的对应关系，
		 * Map中的Key为目标对象属性的名称;Value为源对象属性的名称.
		 */
		Map<String,String> propertiesMapping1 = new HashMap<String,String>();
		propertiesMapping1.put("age", "age");
		propertiesMapping1.put("score", "age");

		PopulateUtil.populate(a, b2, propertiesMapping1);
		assertEquals(b2.getAge(), 30);
		assertEquals(b2.getScore(), 30.0);
		assertEquals(b2.getName(), "wyh");

		B b3 = new B();
		/*
		 * 指定目标对象中需要被忽略的属性名称的String数组。
		 */
		String[] ignoreProperties1 = new String[]{"name","age"};

		PopulateUtil.populate(a, b3, ignoreProperties1);
		assertTrue(b3.getAge() == 0);
		assertEquals(b3.getScore(), 59.99);
		assertNull(b3.getName());

		B b4 = new B(29, "hh", "female", "grade 2", 59.99);
		Map<String,String> propertiesMapping2 = new HashMap<String,String>();
		propertiesMapping2.put("grade", "gender");
		propertiesMapping2.put("gender", "grade");
		String[] ignoreProperties2 = new String[]{"name","age"};
		PopulateUtil.populate(a, b4, propertiesMapping2, ignoreProperties2);
		assertEquals(b4.getGender(), "grade 1");
		assertEquals(b4.getGrade(), "male");
		assertEquals(b4.getAge(), 29);
		assertEquals(b4.getScore(), 59.99);
		assertEquals(b4.getName(), "hh");
	}

	// source
	public class A {

		private String age;

		private String name;

		private String gender;

		private String grade;

		private String score;

		public A() {
			super();
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}

		public A(String age, String name, String gender, String grade,
				String score) {
			super();
			this.age = age;
			this.name = name;
			this.gender = gender;
			this.grade = grade;
			this.score = score;
		}
	}

	// target
	public class B {

		private int age;

		private String name;

		private String gender;

		private String grade;

		private double score;

		public B() {
			super();
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

		public B(int age, String name, String gender, String grade,
				double score) {
			super();
			this.age = age;
			this.name = name;
			this.gender = gender;
			this.grade = grade;
			this.score = score;
		}
	}
}