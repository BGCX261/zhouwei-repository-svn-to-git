package com.sitechasia.webx.util.validate;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 
 * 验证用工具类
 * 
 * 
 * @author zhou wei
 * @version 1.0
 */
public class ValidateUtils {

	/**
	 * 
	 * 是否是Email格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(java.lang.String email) {
		if (StringUtils.isBlank(email))
			return false;
		String emailAddressPattern = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		return Pattern.compile(emailAddressPattern).matcher(email).matches();
	}

	/**
	 * 
	 * 是否是数字
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNumber(java.lang.String number) {
		return NumberUtils.isNumber(number);
	}

	/**
	 * 
	 * 指定的字符串是否为空
	 * 
	 * @param value
	 *            check ""," ",null
	 * @return
	 */
	public static boolean isBlankOrNull(String value) {
		return StringUtils.isBlank(value) || StringUtils.isEmpty(value);
	}

	/**
	 * 
	 * 指定的数字是否在指定的大小范围内
	 * 
	 * @param value
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static boolean isInRange(byte value, byte min, byte max) {
		return ((value >= min) && (value <= max));
	}

	/**
	 * 
	 * 指定的数字是否在指定的大小范围内
	 * 
	 * @param value
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static boolean isInRange(int value, int min, int max) {
		return ((value >= min) && (value <= max));
	}

	/**
	 * 
	 * 指定的数字是否在指定的大小范围内
	 * 
	 * @param value
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static boolean isInRange(float value, float min, float max) {
		return ((value >= min) && (value <= max));
	}

	/**
	 * 
	 * 指定的数字是否在指定的大小范围内
	 * 
	 * @param value
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static boolean isInRange(short value, short min, short max) {
		return ((value >= min) && (value <= max));
	}

	/**
	 * 
	 * 指定的数字是否在指定的大小范围内
	 * 
	 * @param value
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static boolean isInRange(long value, long min, long max) {
		return ((value >= min) && (value <= max));
	}

	/**
	 * 
	 * 指定的数字是否在指定的大小范围内
	 * 
	 * @param value
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @return
	 */
	public static boolean isInRange(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

	/**
	 * 
	 * 指定的字符串长度是否在指定长度范围内
	 * 
	 * @param value
	 * @param max
	 *            最大长度
	 * @return
	 */
	public static boolean maxLength(String value, int max) {
		return (value.length() <= max);
	}

	/**
	 * 
	 * 指定的字符串长度是否大于指定的长度
	 * 
	 * @param value
	 * @param min
	 *            最小长度
	 * @return
	 */
	public static boolean minLength(String value, int min) {
		return (value.length() >= min);
	}

}
