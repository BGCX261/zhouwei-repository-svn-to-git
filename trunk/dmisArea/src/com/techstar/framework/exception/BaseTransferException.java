//Source file: C:\\test\\com\\techstar\\framework\\exception\\BaseTransferException.java

package com.techstar.framework.exception;


/**
 * 此类为基本传输异常
 * @author xcf
 */
public class BaseTransferException extends BaseException 
{
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
    * @roseuid 44EA607F00E3
    */
	/**
	    * @param cause
	    * @roseuid 44E13C19032D
	    */
	   public BaseTransferException(Throwable cause)   
	   {
		   super(cause);
	   }
	   
	   /**
	    * @param errorCode
	    * @param cause
	    * @roseuid 44E13C19032A
	    */
	   public BaseTransferException(String errorCode, Throwable cause) 
	   {	   
		   super(errorCode , cause);	   
	   }
	   
	   /**
	    * @param errorCode
	    * @roseuid 44E13C190328
	    */
	   public BaseTransferException(String errorCode) 
	   {
		   super(errorCode);
	   }     
}
