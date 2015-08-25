package com.sitechasia.webx.validator;

import java.util.Locale;
import org.apache.commons.validator.ValidatorException;

/**
 * 
 * 验证处理器接口 ，通过getErrors方法获得验证结果信息
 * 
 * @author zhou wei
 * @version 1.0
 */
public interface BindingErrorProcessor {

	/**
	 * 
	 * 获取验证信息
	 * 
	 * @param bean
	 *            java bean
	 * @param formKey
	 *            validator xml中的对应的form bean名称
	 * @param locale
	 * @return
	 * @throws ValidatorException
	 */
	public String[] getErrors(Object bean, String formKey, Locale locale)
			throws ValidatorException;

}
