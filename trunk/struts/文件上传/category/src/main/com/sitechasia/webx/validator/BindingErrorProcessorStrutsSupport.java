package com.sitechasia.webx.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Arg;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResult;
import org.apache.commons.validator.ValidatorResults;
import org.apache.struts.Globals;
import org.apache.struts.util.MessageResources;

/**
 * 
 * 验证处理器Struts 支持类 ，通过getErrors方法获得验证结果信息
 * 
 * @author zhou wei
 * @version 1.0
 */
public class BindingErrorProcessorStrutsSupport implements
		BindingErrorProcessor {

	private ValidatorFactory validatorFactory;

	private HttpServletRequest strutsServletRequest;

	private MessageResources messageResources;

	/**
	 * 
	 * 加载ValidatorFactory
	 * 
	 * @param validatorFactory
	 */
	public void setValidatorFactory(ValidatorFactory validatorFactory) {
		this.validatorFactory = validatorFactory;
	}

	/**
	 * 
	 * 获取ValidatorFactory
	 * 
	 * @return
	 * @throws ValidatorException
	 */
	private ValidatorFactory getValidatorFactory() throws ValidatorException {
		if (this.validatorFactory == null)
			throw new ValidatorException(
					BindingErrorProcessorStrutsSupport.class.getName() + " : "
							+ " validatorFactory is null");
		return this.validatorFactory;
	}

	/**
	 * 
	 * 加载Struts HttpServletRequest
	 * 
	 * @param strutsServletRequest
	 * @throws ValidatorException
	 */
	public void setStrutsServletRequest(HttpServletRequest strutsServletRequest)
			throws ValidatorException {
		this.strutsServletRequest = strutsServletRequest;
		this.messageResources = (MessageResources) this
				.getStrutsServletRequest().getAttribute(Globals.MESSAGES_KEY);
	}

	/**
	 * 
	 * 获取Struts HttpServletRequest
	 * 
	 * @return
	 * @throws ValidatorException
	 */
	private HttpServletRequest getStrutsServletRequest()
			throws ValidatorException {
		if (this.strutsServletRequest == null)
			throw new ValidatorException(
					BindingErrorProcessorStrutsSupport.class.getName() + " : "
							+ " strutsServletRequest is null");

		return this.strutsServletRequest;
	}

	/**
	 * 
	 * 获取Struts MessageResources
	 * 
	 * @return
	 * @throws ValidatorException
	 */
	private MessageResources getMessageResources() throws ValidatorException {
		if (this.messageResources == null)
			throw new ValidatorException(
					BindingErrorProcessorStrutsSupport.class.getName() + " : "
							+ " messageResources is null");
		return this.messageResources;
	}

	/**
	 * 
	 * 获取ValidatorResources
	 * 
	 * @return
	 * @throws ValidatorException
	 */
	private ValidatorResources getValidatorResources()
			throws ValidatorException {
		return getValidatorFactory().getValidatorResources();
	}

	/**
	 * 
	 * 获取Validator实例
	 * 
	 * @param bean
	 *            java bean
	 * @param formKey
	 *            validator xml中的对应的form bean名称
	 * @return
	 * @throws ValidatorException
	 */
	private Validator getValidator(Object bean, String formKey)
			throws ValidatorException {
		return getValidatorFactory().getValidator(formKey, bean);
	}

	/**
	 * 
	 * 获取验证信息
	 * 
	 * @param bean
	 *            java bean
	 * @param formKey
	 *            validator xml中的对应的form bean名称
	 * @return
	 * @throws ValidatorException
	 */
	public String[] getErrors(Object bean, String formKey)
			throws ValidatorException {

		Locale locale = getStrutsServletRequest().getLocale();
		// 调用 getErrors
		return getErrors(bean, formKey, locale);

	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.validator.BindingErrorProcessor#getErrors(java.lang.Object, java.lang.String, java.util.Locale)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String[] getErrors(Object bean, String formKey, Locale locale)
			throws ValidatorException {

		List<String> errors = new ArrayList<String>();

		// 获取validator
		Validator validator = getValidator(bean, formKey);

		Form form = getValidatorResources().getForm(locale, formKey);

		// 获取验证结果
		ValidatorResults results = validator.validate();

		Iterator<String> propertyNames = results.getPropertyNames().iterator();

		while (propertyNames.hasNext()) {

			String propertyName = propertyNames.next();

			// 通过property获取validator xml中的field
			Field field = form.getField(propertyName);

			// 查找field中的Arg参数
			Arg[] args = field.getArgs(formKey);

			int args_length = args.length;

			String[] message_args = new String[args_length];

			for (int index = 0; index < args_length; index++) {
				message_args[index] = getMessageResources().getMessage(locale,
						args[index].getKey());
			}

			// 根据指定的property获得验证结果
			ValidatorResult result = results.getValidatorResult(propertyName);

			Iterator<String> actions = result.getActions();

			while (actions.hasNext()) {

				String actName = actions.next();

				ValidatorAction action = getValidatorResources()
						.getValidatorAction(actName);

				if (!result.isValid(actName)) {

					String message = getMessageResources().getMessage(locale,
							action.getMsg(), message_args);

					errors.add(message);

				}

			}

		}
		return errors.toArray(new String[errors.size()]);
	}
}
