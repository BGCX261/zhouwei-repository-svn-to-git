/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.web.struts1.action;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aopalliance.aop.Advice;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.taglib.html.Constants;
import org.apache.struts.upload.FormFile;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.MethodMatcher;
import org.springframework.core.Ordered;

import com.sitechasia.webx.core.annotation.Out;
import com.sitechasia.webx.core.annotation.Read;
import com.sitechasia.webx.core.annotation.Scope;
import com.sitechasia.webx.core.exception.UILayerException;
import com.sitechasia.webx.core.model.IValueObject;
import com.sitechasia.webx.core.utils.base.GenericsUtils;
import com.sitechasia.webx.core.utils.populator.BasePopulator;
import com.sitechasia.webx.core.utils.populator.ConverterFactory;
import com.sitechasia.webx.core.utils.populator.IPopulator;
import com.sitechasia.webx.core.utils.populator.ITypeConverter;
import com.sitechasia.webx.core.utils.populator.PopulatorFactory;
import com.sitechasia.webx.core.utils.populator.ServletRequestBeanPopulator;
import com.sitechasia.webx.core.web.i18n.MessageProviderFacade;
import com.sitechasia.webx.core.web.struts1.StrutsWebData;
import com.sitechasia.webx.core.web.struts1.action.aop.AbortFollowingProcessException;

/**
 * 简单封装Struts DispatchAction的基类.
 * 实现了以Annotation方式获取请求参数，并调用指定的方法.
 * 可以根据所调用方法的参数类型对请求参数进行自动转型，并支持Bean方式的方法参数.
 *
 * @author Zal
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */

public abstract class StrutsAction extends DispatchAction {

	/**
	 * 日志对象.
	 * 在子类中不必单独定义日志对象，直接使用这里生成的即可
	 */
	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * 代表操作成功的默认actionforward名称
	 */
	public static final String SUCCESS = "success";
	/**
	 * 向页面输出直接文本信息时的默认KEY
	 */
	public static final String DIRECTLY_MESSAGE_KEY = "message";
	private static final String DEFAULT_METHOD_NAME = "findAll";
	/**
	 * 存放页面数据的KEY
	 */
	public static final String WEBX_FORMDATA_KEY = "webxForm";

	/**
	 * 用于存储AOP信息的成员变量
	 */
	private Map<MethodMatcher,Set<Advice>> aopConf = new HashMap<MethodMatcher,Set<Advice>>();

	/**
	 * 用于存储方法前Advice的Cache
	 */
	private Map<Method, MethodBeforeAdvice[]> cacheBeforeAdvice = new HashMap<Method, MethodBeforeAdvice[]>();

	/**
	 * 用于存储方法后Advice的Cache
	 */
	private Map<Method, AfterReturningAdvice[]> cacheAfterAdvice = new HashMap<Method, AfterReturningAdvice[]>();

	/**
	 * 包可见的构造函数，保证用户不会直接继承于本类
	 */
	StrutsAction(){}

	/**
	 * aopConf成员的getter方法
	 * @return 用于存储AOP信息的成员变量
	 */
	public Map<MethodMatcher, Set<Advice>> getAopConf() {
		return aopConf;
	}

	/**
	 * aopConf成员的setter方法
	 * @param aopConf 用于存储AOP信息的成员变量
	 */
	public void setAopConf(Map<MethodMatcher, Set<Advice>> aopConf) {
		this.aopConf = aopConf;
	}

	/**
	 * 保存单条信息到Message的简化函数.
	 *
	 * @param key
	 *            代表指定信息的资源束Key
	 * @param params
	 *            对应资源束value需要的参数
	 */
	protected void saveMessage(String key, String... params) {
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, params));
		saveMessages(getRequest().getSession(), messages);
	}

	/**
	 * 直接保存文本信息(非i18n)到messages
	 *
	 * @param message
	 *            直接的文本信息
	 */
	protected void saveDirectlyMessage(String message) {
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(DIRECTLY_MESSAGE_KEY, message));
		saveMessages(getRequest().getSession(), messages);
	}

	/**
	 * 保存单条信息到Error的简化函数.
	 *
	 * @param key
	 *            代表指定信息的资源束Key
	 * @param params
	 *            对应资源束value需要的参数
	 */
	protected void saveError(String key, String... params) {
		ActionMessages errors = new ActionMessages();
		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(key, params));
		saveErrors(getRequest().getSession(), errors);
	}

	/**
	 * 直接保存文本信息(非i18n)errors
	 *
	 * @param message
	 *            直接的文本信息
	 */
	protected void saveDirectlyError(String message) {
		ActionMessages errors = new ActionMessages();
		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(DIRECTLY_MESSAGE_KEY, message));
		saveErrors(getRequest().getSession(), errors);
	}

	/**
	 * 直接输出纯字符串
	 * @param text
	 *            字符串内容
	 */
	public void renderText(String text) {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(text);
			response.flushBuffer();
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * 直接输出纯HTML
	 * @param html
	 *            HTML内容
	 */
	public void renderHtml(String html) {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(html);
			response.flushBuffer();
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * 直接输出纯XML
	 * @param xml
	 *            XML内容
	 */
	public void renderXML(String xml) {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/xml;charset=UTF-8");
			response.getWriter().write(xml);
			response.flushBuffer();
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * 直接输出二进制数组.
	 *
	 * 通常用于直接输出图片或者附件等
	 * @param mimetype
	 *            要输出的内容的MimeType
	 * @param content
	 *            要输出的内容
	 */
	public void renderBinary(String mimetype, byte[] content) {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType(mimetype);
			ServletOutputStream out = response.getOutputStream();
			BufferedOutputStream bo = new BufferedOutputStream(out, 1024);
			bo.write(content);
			bo.flush();
			bo.close();
			out.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * 直接输出二进制数组.
	 *
	 * 通常用于直接输出图片或者附件等
	 * @param mimetype
	 *            要输出的内容的MimeType
	 * @param source
	 *            包含要输出的内容的输入流
	 */
	public void renderBinary(String mimetype, InputStream source) {
		try {
			HttpServletResponse response = getResponse();
			response.setContentType(mimetype);
			ServletOutputStream out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			while (source.read(buffer) > 0) {
				out.write(buffer);
				out.flush();
			}
			out.close();
			source.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * Dispatch to the specified method.
	 *
	 * @since Struts 1.1
	 */
	@Override
	protected ActionForward dispatchMethod(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String name) throws Exception {

		//如果没有指定所调用的方法，则使用默认方法
		if (name == null)
			name = DEFAULT_METHOD_NAME;

		//获得所指定的方法
		Method method = getMethod(name);
		if (method == null) {
			throw new NoSuchMethodException("Can NOT find specified method: "
					+ name);
		}

		try {
			//将请求的基本信息存储到当前线程中以便以后使用
			StrutsWebData webData = StrutsWebData.getStrutsWebData();
			webData.setRequest(request);
			webData.setResponse(response);
			//modified begin
			webData.setActionForm(form);
			//modified end
			setAttribute(WEBX_FORMDATA_KEY, request.getParameterMap());

			//执行方法调用
			Object result = this.exec(method);

			//将方法执行完之后需要输出的对象输出到所指定的范围
			for (Entry<Out, Object> entry : webData.getOutParameters().entrySet()) {
				Out out = entry.getKey();
				setAttribute(out.key(), entry.getValue(), out.scope());
			}

			if (webData.getForward() != null) {
				return mapping.findForward(webData.getForward());
			}

			ActionForward forward;

			//如果应答已经flush,或者返回结果为String类型并且为null，则不进行forward
			if (response.isCommitted() || (result == null && method.getReturnType() == String.class))
				forward = null;

			//如果返回结果为String类型，则forward指定的地址
			else if (result instanceof String)
				forward = mapping.findForward((String) result);

			//否则取方法名为地址进行forward
			else
				forward = mapping.findForward(method.getName());

	        //************* add 贺帅彪 进行国际化处理***********/
			if (forward != null && getServlet() != null && getServlet().getInitParameter("defaultLocale") != null) {
//				Properties p = MessageLocale.getLocaleMessage(getRequest().getLocale(), getServlet(), forward.getPath());
				Properties p = MessageProviderFacade.getLocaleProperties(forward.getPath(), getServlet(), getRequest().getLocale());
				if(p == null) p = new Properties();
				setAttribute("key", p);
			}
	        //*********************************************/

			return forward;

		} catch (ClassCastException e) {
			String message = messages.getMessage("dispatch.return", mapping.getPath(), name);
			logger.error(message, e);
			throw e;
		} catch (IllegalAccessException e) {
			String message = messages.getMessage("dispatch.error", mapping.getPath(), name);
			logger.error(message, e);
			throw e;
		} catch (InvocationTargetException e) {
			// Rethrow the target exception if possible so that the
			// exception handling machinery can deal with it
			Throwable t = e.getTargetException();
			if (t instanceof Exception) {
				throw ((Exception) t);
			} else {
				String message = messages.getMessage("dispatch.error", mapping.getPath(), name);
				logger.error(message, e);
				throw new ServletException(t);
			}
		}
	}

	/**
	 * 供内部使用的调用所指定方法的方法
	 * @param method 所指定的需要被调用的方法
	 * @return 调用方法后所返回的结果
	 * @throws Exception
	 */
	private Object exec(Method method) throws Exception {

		//获得所调用方法的参数类型和所使用的Annotation数组
		Class[] type = method.getParameterTypes();
		Annotation[][] annotationArray = method.getParameterAnnotations();

		//用于存放调用参数的对象数组
		Object[] paramTarget = new Object[type.length];

		//用于存放需要输出结果的Map
		Map<Out, Object> outParameterMap = new HashMap<Out, Object>();

		//构造调用所需要的参数数组
		for (int i = 0; i < type.length; i++) {
			Class typeClasz = type[i];
			Annotation[] annotation = annotationArray[i];

			if (annotation == null || annotation.length == 0) {
				throw new UILayerException(
						"Must specify a @Read annotation for every parameter in method: "
								+ method.getName());
			}

			//**********add by mashaojing  read与out顺序无关 ***********/
			for(int j=0;j<annotation.length;j++) {
				if(annotation[j] instanceof Read) {
					Read read = (Read) annotation[j];

			//为了支持泛型
			if (typeClasz == Object.class || typeClasz == IValueObject.class)
				typeClasz = GenericsUtils.getGenericClass(clazz);
			else if (typeClasz == Serializable.class)
				typeClasz = GenericsUtils.getGenericClass(clazz, 1);
			else if (typeClasz == Serializable[].class)
				typeClasz = Array.newInstance(GenericsUtils.getGenericClass(clazz, 1), 0).getClass();

			// 循环生成当前的调用参数
			if(read.trimed())
            {
                Object objectParameter = getParameter(typeClasz, read);
                if(objectParameter == null)
                    paramTarget[i] = objectParameter;
                else
                if(objectParameter instanceof String)
                {
                    String stringPamater = (String)objectParameter;
                    paramTarget[i] = stringPamater.trim();
                } else
                {
                    Class beanClass = objectParameter.getClass();
                    Field fieldArray[] = beanClass.getDeclaredFields();
                    Field afield[] = fieldArray;
                    int k = 0;
                    for(int l = afield.length; k < l; k++)
                    {
                        Field field = afield[k];
                        field.setAccessible(true);
                        Object fieldValue = field.get(objectParameter);
                        if(fieldValue instanceof String)
                        {
                            String fieldName = field.getName();
                            String firstLetter = fieldName.substring(0, 1).toUpperCase();
                            String setMethodName = (new StringBuilder("set")).append(firstLetter).append(fieldName.substring(1)).toString();
                            String stringFieldValue = (String)fieldValue;
                            try
                            {
                                Method setMethod = beanClass.getMethod(setMethodName, new Class[] {
                                    field.getType()
                                });
                                setMethod.setAccessible(true);
                                setMethod.invoke(objectParameter, new Object[] {
                                    stringFieldValue.trim()
                                });
                            }
                            catch(Exception exception) { }
                        }
                    }

                    paramTarget[i] = objectParameter;
                }
            }
			// **********add by WangYonghui Rerquest参数trim可配置添加代码***********/
			/*if (read.trimed()) {
				Object objectParameter = getParameter(typeClasz, read);
				if (objectParameter == null) {
					paramTarget[i] = objectParameter;
				} else {
					if (objectParameter instanceof String) {// 参数对象是字符串
						String stringPamater = (String) objectParameter;
						paramTarget[i] = stringPamater.trim();
					} else {// 参数对象是Bean
						// 获得Bean的类型
						Class beanClass = objectParameter.getClass();
						// 通过类型获得类的属性数组
						Field[] fieldArray = beanClass.getDeclaredFields();
						// 遍历属性数组，如果属性类型是String就将属性值进行trim操作
						for (Field field : fieldArray) {
							// 取消java语言访问检查，即可以访问私有属性
							field.setAccessible(true);
							// 取得对象的属性值
							Object fieldValue = field.get(objectParameter);
							// 判断属性值是否为String
							if (fieldValue instanceof String) {
								String stringFieldValue = (String) fieldValue;
								// trim后重新设置新值
								field.set(objectParameter, stringFieldValue
										.trim());
							}
						}
						paramTarget[i] = objectParameter;
					}
				}
			}*/
			// ****************************************************/
			else {
				paramTarget[i] = getParameter(typeClasz, read);
			}

			//构造需要输出的结果
			if(annotation[j] instanceof Out) {
				Out out = (Out) annotation[j];
				if (out != null && paramTarget[i] != null) {
					outParameterMap.put(out, paramTarget[i]);
				}
			}
		}
	}
}

		StrutsWebData webData = StrutsWebData.getStrutsWebData();

		Object result = null;
		try {
			// 在此加入Before()方法
			methodBeforeAdvice(method, paramTarget);

			// 调用，并得到调用结果
			result = method.invoke(this, paramTarget);

			// 在此加入After()方法
			methodAfterAdvice(result, method, paramTarget);
		} catch(AbortFollowingProcessException e) {
			logger.debug("Process has bean aborted while processing method " + method.getName() + " chain", e);
			String forward = e.getForward();
			if (forward != null && forward.length() > 0) {
				webData.setForward(forward);
			}
		}

		if (method.getAnnotation(Out.class) != null && result != null) {
			outParameterMap.put(method.getAnnotation(Out.class), result);
		}

		webData.setOutParameters(outParameterMap);

		return result;
	}

	/**
	 * 调用方法前Advice
	 * @param method 所调用的方法
	 * @param paramTarget 调用方法时所使用的参数
	 * @throws Exception
	 */
	private void methodBeforeAdvice(Method method,Object[] paramTarget) throws Exception {
		if(getAopConf() == null || getAopConf().isEmpty()){
			return;
		}

		//获得Cache中所存储的方法前Advice
		MethodBeforeAdvice[] methodBeforeAdviceArray = cacheBeforeAdvice.get(method);

		//如果之前没有初始化过，则进行初始化
		if (methodBeforeAdviceArray == null) {
			synchronized (cacheBeforeAdvice) {
				if (cacheBeforeAdvice.get(method) == null) {
					List<Advice> tempBeforeAdviceList = new ArrayList<Advice>();
					for (MethodMatcher methodMatcher : getAopConf().keySet()) {
						if (methodMatcher.matches(method, this.getClass())) {
							for (Advice advice : getAopConf()
									.get(methodMatcher)) {
								if (advice instanceof MethodBeforeAdvice) {
									tempBeforeAdviceList.add(advice);
								}
							}
						}
					}
					sortList(tempBeforeAdviceList);
					cacheBeforeAdvice.put(method, tempBeforeAdviceList
							.toArray(new MethodBeforeAdvice[0]));
				}
				methodBeforeAdviceArray = cacheBeforeAdvice.get(method);
			}
		}

		//循环调用方法前Advice
		for (MethodBeforeAdvice advice : methodBeforeAdviceArray) {
			try {
				advice.before(method, paramTarget, this);
			} catch (Throwable t) {
				if (t instanceof Exception) {
					throw (Exception)t;
				} else {
					throw new ServletException(t);
				}
			}
		}
	}

	/**
	 * 调用方法后Advice
	 * @param object 所调用方法所返回的结果
	 * @param method 所调用的方法
	 * @param paramTarget 所调用方法的参数
	 * @throws Exception
	 */
	private void methodAfterAdvice(Object object,Method method,Object[] paramTarget) throws Exception {
		if(getAopConf() == null || getAopConf().isEmpty()){
			return;
		}

		//获得Cache中所存储的方法后Advice
		AfterReturningAdvice[] methodAfterAdviceArray = cacheAfterAdvice.get(method);

		//如果之前没有初始化过，则进行初始化
		if (methodAfterAdviceArray == null) {
			synchronized (cacheAfterAdvice) {
				if (cacheAfterAdvice.get(method) == null) {
					List<Advice> tempAfterAdviceList = new ArrayList<Advice>();
					for (MethodMatcher methodMatcher : getAopConf().keySet()) {
						if (methodMatcher.matches(method, this.getClass())) {
							for (Advice advice : getAopConf()
									.get(methodMatcher)) {
								if (advice instanceof AfterReturningAdvice) {
									tempAfterAdviceList.add(advice);
								}
							}
						}
					}
					sortList(tempAfterAdviceList);
					cacheAfterAdvice.put(method, tempAfterAdviceList
							.toArray(new AfterReturningAdvice[0]));
				}
				methodAfterAdviceArray = cacheAfterAdvice.get(method);
			}
		}

		//循环调用方法后Advice
		for (AfterReturningAdvice advice : methodAfterAdviceArray) {
			try {
				advice.afterReturning(object,method, paramTarget,this);
			} catch (Throwable t) {
				if (t instanceof Exception) {
					throw (Exception)t;
				} else {
					throw new ServletException(t);
				}
			}
		}
	}

	/**
	 * 对Advice列表进行排序的方法
	 * @param list Advice列表
	 */
	private void sortList(List<Advice> list){
		if(list == null || list.size() <= 1){
			return;
		}
		Collections.sort(list, new Comparator(){
			public int compare(Object o1, Object o2){
				int intNum1 = 0, intNum2 = 0;
				int result;
				if ((o1 instanceof Ordered) &&(o2 instanceof Ordered )){
					intNum1 = ((Ordered)o1).getOrder();
					intNum2 = ((Ordered)o2).getOrder();
				}
				result=intNum1 - intNum2;
				if(!(o1 instanceof Ordered )&&(o2 instanceof Ordered ))
					result=1;
				if(!(o2 instanceof Ordered )&&(o1 instanceof Ordered ))
					result=-1;
				return result;
			}
		 });
	}

	/**
	 * 将从Request Map中的获得的String数组重新注值，对空值的地方赋予默认值
	 *
	 * @param params
	 *            Request Map中的获得的String数组
	 * @param defaultValue
	 *            默认值
	 * @return 重新注值后的String数组
	 */
	private String[] refillParameters(String[] params, String defaultValue) {
		if (params == null)
			return null;

		for (int i = 0; i < params.length; i++) {
			if (params[i] == null || params[i].length() == 0) {
				params[i] = useDefaultValue(defaultValue) ? defaultValue : null;
			}
		}
		return params;
	}

	/**
	 * 判断是否使用默认值
	 *
	 * @param defaultValue
	 *            默认值
	 * @return 是否使用默认值
	 */
	private boolean useDefaultValue(String defaultValue) {
		return defaultValue != null && !defaultValue.equals("WEBX_CORE_ANNOTATION_READ_DEFAULTVALUE_DEFAULT");
	}

	/**
	 * 获得转换后的方法参数的对象
	 *
	 * @param type
	 *            需要转换成的类型
	 * @param parameters
	 *            请求参数的Map
	 * @param key
	 *            请求参数的Map中需要转换对象的Key
	 * @param defaultValue
	 *            转换所使用的默认值
	 * @return 转换后的对象
	 */
	private Object getParameter(Class type, Read read) {

		//获得属性key的值
		String key = read.key();

		//如果有key值则代表该Annotation所描述的参数不是一个Bean
		if (key != null && key.length() > 0) {
			Object value = null;
			//modified begin
			if(type == FormFile.class || type == InputStream.class){
				if (StrutsWebData.getStrutsWebData().getActionForm()==null) {
					throw new UILayerException(
							"Must specify a form-bean for multipart usage ");
				}
				value = StrutsWebData.getStrutsWebData().getActionForm().getMultipartRequestHandler().getFileElements().get(key);
			}
			else{
			//modified end
			switch (read.scope()) {
			case REQUEST:
				value = getAttribute(key, Scope.REQUEST);
				break;
			case SESSION:
				value = getAttribute(key, Scope.SESSION);
				break;
			case APPLICATION:
				value = getAttribute(key, Scope.APPLICATION);
				break;
			default:
				String defaultValue = read.defaultValue();
				String[] params = (String[]) ((Map) getAttribute(
						WEBX_FORMDATA_KEY, Scope.REQUEST)).get(key);
				if (params == null) {
					params = useDefaultValue(defaultValue) ? new String[1]
							: new String[0];
				}
				if (params.length < 1) {
					if (type.isArray()) {
						value = params;
					} else if (useDefaultValue(defaultValue)) {
						value = defaultValue;
					}
				} else if (params.length == 1) {
					value = type.isArray() ? refillParameters(params,
							defaultValue) : refillParameters(params,
							defaultValue)[0];
				} else {
					if (type.isArray()) {
						value = refillParameters(params, defaultValue);
					} else {
						if (useDefaultValue(defaultValue)) {
							value = defaultValue;
						} else {
							value = (params[0] == null || params[0].length() == 0) ? null : params[0];
						}
					}
				}
			}
			//modified begin
			}
			//modified end
			return getConverter(read.converter()).convertValue(value, type);

		//否则代表本Annotation所描述的参数是一个Bean
		} else {
			Object obj;
			try {
				obj = type.newInstance();
			} catch (InstantiationException e) {
				logger
						.debug(
								"InstantiationException happened when initializing bussiness object",
								e);
				return null;
			} catch (IllegalAccessException e) {
				logger
						.debug(
								"IllegalAccessException happened when initializing bussiness object",
								e);
				return null;
			}

			getPopulator(read.converter()).populate(getRequest(), obj, null, null);
            //modified begin
			if ((this.getRequest().getContentType() != null)
		            && (this.getRequest().getContentType().startsWith("multipart/form-data"))
		            && (this.getRequest().getMethod().equalsIgnoreCase("POST"))) {
				try {
					Map files = StrutsWebData.getStrutsWebData().getActionForm().getMultipartRequestHandler().getFileElements();
					getPopulator(read.converter()).populate(files, obj, null, null);
				} catch (Exception e) {
					throw new UILayerException(
					"Exception happened when using multipart/form-data ", e);
				}
			}
			//modified end
			return obj;
		}
	}

	/**
	 * 获得一个在属性中所定义了的Converter
	 * @param propertyName
	 * @return
	 */
	private ITypeConverter getConverter(String propertyName) {

		//如果为默认值，则使用默认的Converter
		if (propertyName.equals("WEBX_CORE_ANNOTATION_READ_CONVERTER_DEFAULT")) {
			return ConverterFactory.getDefaultConverter();
		}

		//否则搜索本对象内所指定的Converter
		try {
			//获得所有的属性
			PropertyDescriptor[] thisDescriptors = Introspector.getBeanInfo(
					this.getClass()).getPropertyDescriptors();

			//获得所指定属性的Get方法
			Method converterReadMethod = null;
			for (PropertyDescriptor descriptor : thisDescriptors) {
				if (propertyName.equals(descriptor.getName())) {
					converterReadMethod = descriptor.getReadMethod();
					break;
				}
			}

			//定义需要返回的Converter
			ITypeConverter returnConverter = null;

			//如果所指定的属性没有Get方法，则直接使用成员变量
			if (converterReadMethod == null) {
				Field field = this.getClass().getDeclaredField(propertyName);
				if (field == null) {
					return ConverterFactory.getDefaultConverter();
				}
				field.setAccessible(true);
				returnConverter = (ITypeConverter)field.get(this);

			//如果有Get方法，则使用Get方法获得值
			} else {
				converterReadMethod.setAccessible(true);
				returnConverter = (ITypeConverter)converterReadMethod.invoke(this, new Object[0]);
			}

			return returnConverter;
		} catch (Exception e) {
			logger.debug("Can not get converter, default converter will be use", e);
			return ConverterFactory.getDefaultConverter();
		}
	}

	/**
	 * 获得一个用于Bean注值的Populator
	 * @param converter
	 * @return
	 */
	private IPopulator getPopulator(String propertyName) {

		if (propertyName.equals("WEBX_CORE_ANNOTATION_READ_CONVERTER_DEFAULT")) {
			return PopulatorFactory.getDefaultPopulator();
		}

		BasePopulator populator = new ServletRequestBeanPopulator();
		populator.setConverter(this.getConverter(propertyName));
		return populator;
	}

	@Override
	/**
	 * 以名称作为匹配条件搜索指定方法
	 */
	protected Method getMethod(String name) {
		if (!methods.containsKey(name)) {
			synchronized (methods) {
				if (!methods.containsKey(name)) {
					OUTER: for (Class clazz = this.getClass(); clazz != StrutsAction.class; clazz = clazz
							.getSuperclass()) {
						Method[] tempMethods = clazz.getDeclaredMethods();
						for (Method tempMethod : tempMethods) {
							if (Modifier.PUBLIC == tempMethod.getModifiers() && tempMethod.getName().equals(name)) {
								methods.put(name, tempMethod);
								break OUTER;
							}
						}
					}
				}
			}
		}
		return (Method) methods.get(name);
	}

	/**
	 * 用于获取所调用的方法名，当以"_"开始时则直接使用真实方法名
	 */
	@Override
	protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String parameter) throws Exception {
		return parameter.charAt(0) == '_' ? parameter.substring(1) : request.getParameter(parameter);
	}

	/**
	 * 将数据存放在request对象中
	 *
	 * @param key
	 * @param obj
	 */
	@Deprecated
	protected void putValueInRequest(String key, Object obj) {
		setAttribute(key, obj, Scope.REQUEST);
	}

	/**
	 * 将数据存放在session对象中
	 *
	 * @param key
	 * @param obj
	 */
	@Deprecated
	protected void putValueInSession(String key, Object obj) {
		setAttribute(key, obj, Scope.SESSION);
	}

	/**
	 * 将数据存放在application对象中
	 *
	 * @param key
	 * @param obj
	 */
	@Deprecated
	protected void putValueInApplication(String key, Object obj) {
		setAttribute(key, obj, Scope.APPLICATION);
	}

	/**
	 *
	 * @param key
	 * @return 从Request获取Value
	 */
	@Deprecated
	protected Object getValueFromRequest(String key) {
		return getAttribute(key, Scope.REQUEST);
	}

	/**
	 *
	 * @param key
	 * @return 从Session获取Value
	 */
	@Deprecated
	protected Object getValueFromSession(String key) {
		return getAttribute(key, Scope.SESSION);
	}

	/**
	 *
	 * @param key
	 * @return 从Application中获取Value
	 */
	@Deprecated
	protected Object getValueFromApplication(String key) {
		return getAttribute(key, Scope.APPLICATION);
	}

	/**
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return StrutsWebData.getStrutsWebData().getRequest();
	}

	/**
	 * @return HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return StrutsWebData.getStrutsWebData().getResponse();
	}

	/**
	 * 向Request或Session或ApplicationContext中放置Attribute
	 *
	 * @param key
	 * @param value
	 */
	protected void setAttribute(String key, Object value, Scope scope) {
		if (scope == null) scope = Scope.REQUEST;
		switch (scope) {
		case SESSION:
			getRequest().getSession().setAttribute(key, value);
			break;
		case APPLICATION:
			getRequest().getSession().getServletContext().setAttribute(key,
					value);
			break;
		default:
			getRequest().setAttribute(key, value);
		}
	}

	/**
	 * 向Request中放置Attribute
	 *
	 * @param key
	 * @param value
	 */
	protected void setAttribute(String key, Object value) {
		setAttribute(key, value, null);
	}

	/**
	 * 从Request,Session,ApplicationContext中获得一个Attribute
	 * 该方法将按照Request, Session, ApplicationContext的顺序搜索指定的Attribute
	 * @param key
	 * @return Attribut的值
	 */
	protected Object getAttribute(String key) {
		Object value = getAttribute(key, Scope.REQUEST);
		if (value == null) {
			value = getAttribute(key, Scope.SESSION);
			if (value == null) {
				value = getAttribute(key, Scope.APPLICATION);
			}
		}
		return value;
	}

	/**
	 * 从Request或Session或ApplicationContext中获得一个Attribute
	 *
	 * @param key
	 * @return Attribut的值
	 */
	protected Object getAttribute(String key, Scope scope) {
		if (scope == null) return getAttribute(key);
		switch (scope) {
		case SESSION:
			return getRequest().getSession().getAttribute(key);
		case APPLICATION:
			return getRequest().getSession().getServletContext().getAttribute(key);
		default:
			return getRequest().getAttribute(key);
		}
	}

	/**
	 * 从Request, Session和Application中删除一个属性
	 * @param key
	 * @param scope
	 */
	protected void removeAttribute(String key, Scope scope) {
		if (scope == null) scope = Scope.REQUEST;
		switch (scope) {
		case SESSION:
			getRequest().getSession().removeAttribute(key);
			break;
		case APPLICATION:
			getRequest().getSession().getServletContext().removeAttribute(key);
			break;
		default:
			getRequest().removeAttribute(key);
		}
	}

	/**
	 * 从Request中删除一个属性
	 * @param key
	 */
	protected void removeAttribute(String key) {
		removeAttribute(key, Scope.REQUEST);
	}

	/**
	 * @param key
	 */
	@Deprecated
	protected void removeValueFromRequest(String key) {
		getRequest().removeAttribute(key);
	}

	//以下是解决Token被覆盖的问题而重载的方法
	private static String WEBX_TOKEN = "WebX-Core Token"; 
	@Override
	protected boolean isTokenValid(HttpServletRequest request, boolean reset) {
		super.isTokenValid(request, reset);		//忽略Struts默认的token验证机制
		
		HttpSession session = request.getSession();
		if(session == null) {
			return false;
		}

		Set<String> tokenSet = this.getTokenSet(session);	//存放在session中的tokenSet
		String savedToken = (String) request.getParameter(Constants.TOKEN_KEY);	//页面提交过来的token

		if (savedToken == null) {
            return false;
        }
		
		if(tokenSet.contains(savedToken)) {
			//如果包含，从set中删除过期token，返回true
			tokenSet.remove(savedToken);
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected boolean isTokenValid(HttpServletRequest request) {
		return this.isTokenValid(request, false);
	}

	@Override
	protected void saveToken(HttpServletRequest request) {
		//FIXME: 如果用户打开form而不提交，该Key则不能从tokenSet中删除
		//影响应该不大，session过期后会清空
		super.saveToken(request);	//首先向session中写入一个token，供FormTag使用
        HttpSession session = request.getSession();
        if(session == null)	return;
        //再从session中取得token加入自定义的TokenSet
        String token = (String) session.getAttribute(Globals.TRANSACTION_TOKEN_KEY);
        Set<String> tokenSet = this.getTokenSet(session);
        tokenSet.add(token);
	}
	
	/**
	 * 从session中取得自定义的TokenSet属性
	 */
	private Set<String> getTokenSet(HttpSession session) {
        Set<String> tokenSet = (Set<String>) session.getAttribute(WEBX_TOKEN);
        if(tokenSet == null) {	
        	tokenSet = new HashSet<String>();
        	session.setAttribute(WEBX_TOKEN, tokenSet);
        }	
        return tokenSet;
	}
}
