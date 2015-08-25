package com.sitechasia.webx.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.validator.Arg;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResult;
import org.apache.commons.validator.ValidatorResults;
import org.springframework.context.MessageSource;

/**
 * 
 * 默认验证处理器 ，通过getErrors方法获得验证结果信息
 * 
 * @author zhou wei
 * @version 1.0
 */
public class DefaultBindingErrorProcessor implements BindingErrorProcessor {

	private MessageSource messageSource;

	private ValidatorFactory validatorFactory;

	/**
	 * 
	 * 加载MessageSource
	 * 
	 * @param messageSource
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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
	 * 获取MessageSource
	 * 
	 * @return
	 * @throws ValidatorException
	 */
	private MessageSource getMessageSource() throws ValidatorException {
		if (this.messageSource == null)
			throw new ValidatorException(DefaultBindingErrorProcessor.class
					.getName()
					+ " : " + " getMessageSource() is null");
		return this.messageSource;
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
			throw new ValidatorException(DefaultBindingErrorProcessor.class
					.getName()
					+ " : " + " validatorFactory is null");
		return this.validatorFactory;
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
				message_args[index] = getMessageSource().getMessage(
						args[index].getKey(), null, locale);
			}

			// 根据指定的property获得验证结果
			ValidatorResult result = results.getValidatorResult(propertyName);

			Iterator<String> actions = result.getActions();

			while (actions.hasNext()) {

				String actName = actions.next();

				ValidatorAction action = getValidatorResources()
						.getValidatorAction(actName);

				if (!result.isValid(actName)) {

					String message = getMessageSource().getMessage(
							action.getMsg(), message_args, locale);

					errors.add(message);

				}

			}

		}
		return errors.toArray(new String[errors.size()]);
	}
}
