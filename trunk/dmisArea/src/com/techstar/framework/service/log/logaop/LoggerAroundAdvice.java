//Source file: C:\\test\\com\\techstar\\framework\\service\\log\\logaop\\LoggerAroundAdvice.java

package com.techstar.framework.service.log.logaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;


/**
 *  此类定义了环绕程序运行的日志处理，主要记录程序从开始运行到结束总共运行的时间
 * Sep 11, 2006
 * @author xcf
 */
public class LoggerAroundAdvice implements MethodInterceptor {

	/**
	 * @param invoke
	 * @return Object
	 * @throws Throwable
	 * @roseuid 44E039C5038A
	 */
	public Object invoke(MethodInvocation invoke) throws Throwable {
		Logger logger = Logger.getLogger(invoke.getClass());
		long start = System.currentTimeMillis();
		Object result = invoke.proceed();
		long end = System.currentTimeMillis();
		long elapsed = end - start;
		logger.info("使用时间" + elapsed);
		return result;
	}
}
