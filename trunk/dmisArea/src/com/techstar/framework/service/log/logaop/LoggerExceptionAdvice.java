//Source file: C:\\test\\com\\techstar\\framework\\service\\log\\logaop\\LoggerExceptionAdvice.java

package com.techstar.framework.service.log.logaop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;

import com.techstar.framework.exception.BaseSecurityException;
import com.techstar.framework.exception.BaseServiceException;
import com.techstar.framework.exception.BaseTransferException;
import com.techstar.framework.exception.LogServiceException;
import com.techstar.framework.exception.MailServiceException;

/**
 *  此类定义了程序出现异常时的日志处理
 * Sep 11, 2006
 * @author xcf
 */
public class LoggerExceptionAdvice implements ThrowsAdvice {

	/**
	 * @roseuid 44EA60B60193
	 */
	public LoggerExceptionAdvice() {

	}

	/**
	 * @param method
	 * @param args
	 * @param target
	 * @param ex
	 * @roseuid 44E03A1603E5
	 */
	public void afterThrowing(Method m, Object[] args, Object target,
			Exception ex) {	
		if (!(ex instanceof DataAccessException)
				&& !(ex instanceof MailServiceException)
				&& !(ex instanceof BaseSecurityException)
				&& !(ex instanceof BaseTransferException)
				&& !(ex instanceof LogServiceException)) {
			ex = new BaseServiceException("pps.serviceException", ex);
		}
		
		Logger logger = Logger.getLogger("error");
		StringBuffer errormsg = new StringBuffer();
		errormsg.append(target.getClass().getName());
		errormsg.append("_");
		errormsg.append(m.getName());
		errormsg.append(": ");
		errormsg.append(ex.getMessage());
		logger.error(errormsg.toString(), ex);

		
	}
}
