//Source file: C:\\test\\com\\techstar\\framework\\exception\\BaseServiceException.java

package com.techstar.framework.exception;


/**
 * 此类为服务层异常
 * @author xcf
 */
public class BaseServiceException extends BaseException 
{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
    * @param cause
    * @roseuid 44E13C19032D
    */
   public BaseServiceException(Throwable cause)   
   {
	   super(cause);
   }
   
   /**
    * @param errorCode
    * @param cause
    * @roseuid 44E13C19032A
    */
   public BaseServiceException(String errorCode, Throwable cause) 
   {	   
	   super(errorCode , cause);	   
   }
   
   /**
    * @param errorCode
    * @roseuid 44E13C190328
    */
   public BaseServiceException(String errorCode) 
   {
	   super(errorCode);
   }     
}
