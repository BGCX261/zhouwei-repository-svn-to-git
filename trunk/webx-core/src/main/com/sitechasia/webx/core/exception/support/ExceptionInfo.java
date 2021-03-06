package com.sitechasia.webx.core.exception.support;

/**
 * 对每种类型的异常,根据配置的xml文件翻译得到此类异常的详细描述信息
 *
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public class ExceptionInfo {
	private Class clazz;
	private String code;
	private String type;
	private int severity;
	private String description;

	public ExceptionInfo() {
	}

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the severity.
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            The severity to set.
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the className.
	 */
	public Class getClazz() {
		return clazz;
	}

	/**
	 * @param clazz
	 */
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
}
