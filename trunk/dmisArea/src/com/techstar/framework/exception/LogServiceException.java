//Source file: C:\\test\\com\\techstar\\framework\\exception\\MailServiceException.java

package com.techstar.framework.exception;


/**
 * 此类为邮件服务异常
 * @author xcf
 */
public class LogServiceException extends BaseException 
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param cause
	 * @roseuid 44E13C19032D
	 */
	public LogServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errorCode
	 * @param cause
	 * @roseuid 44E13C19032A
	 */
	public LogServiceException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	/**
	 * @param errorCode
	 * @roseuid 44E13C190328
	 */
	public LogServiceException(String errorCode) {
		super(errorCode);		
	}
}
