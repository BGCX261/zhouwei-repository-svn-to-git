//Source file: C:\\test\\com\\techstar\\framework\\exception\\MailServiceException.java

package com.techstar.framework.exception;


/**
 * 此类为邮件服务异常
 * @author xcf
 */
public class MailServiceException extends BaseException 
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param cause
	 * @roseuid 44E13C19032D
	 */
	public MailServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errorCode
	 * @param cause
	 * @roseuid 44E13C19032A
	 */
	public MailServiceException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	/**
	 * @param errorCode
	 * @roseuid 44E13C190328
	 */
	public MailServiceException(String errorCode) {
		super(errorCode);		
	}
}
