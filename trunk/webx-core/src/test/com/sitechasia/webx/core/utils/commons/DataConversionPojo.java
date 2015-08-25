package com.sitechasia.webx.core.utils.commons;

/**
 * [类名称描述]
 * <p>
 * --- 功 能 描 述 ---
 * </p>
 *
 * <p>
 * --- Refactory Log ---
 * </p>
 *
 * @author ShanJin
 * @since 2006-12-4
 */
public class DataConversionPojo {

	private String name;

	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name:" + name + ",age:" + age;
	}

}
