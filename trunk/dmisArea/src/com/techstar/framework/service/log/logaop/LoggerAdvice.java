//Source file: C:\\test\\com\\techstar\\framework\\service\\log\\logaop\\LoggerAdvice.java

package com.techstar.framework.service.log.logaop;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 此类定义了程序运行前、后日志处理
 * Sep 11, 2006
 * @author xcf
 */

public class LoggerAdvice implements MethodBeforeAdvice, AfterReturningAdvice 
{
   
   /**
    * @roseuid 44EA60B60164
    */
   public LoggerAdvice() 
   {
	   
   }
   
   /**
    * @param method
    * @param args
    * @param target
    * @roseuid 44E0386B00AA
    */
   public void before(java.lang.reflect.Method method, Object[] args,
			Object target) {
		Logger logger = Logger.getLogger(target.getClass());			
		StringBuffer args_temp = new StringBuffer("_传入参数:");
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				if( args[i] != null )
					args_temp.append(" " + args[i].toString());				
			}
		}else {
			args_temp.append(" 无参数");
		}
		
		logger.debug( target.getClass().getName() + "_" + method.getName() + args_temp.toString() );
	}
   
   /**
	 * @param retuVal
	 * @param method
	 * @param args
	 * @roseuid 44E038D803B3
	 */
   public void afterReturning(Object retuVal, Method method, Object[] args,
			Object target) {
		Logger logger = Logger.getLogger(target.getClass());
		StringBuffer args_temp = new StringBuffer("_返回结果:"); 		
		if (retuVal != null) {
			args_temp.append(" " +retuVal.toString());
		}else{
			args_temp.append(" 无返回结果或返回结果为null");
		}
		logger.debug( target.getClass().getName() + "_" + method.getName() + args_temp.toString() );
	}


}
