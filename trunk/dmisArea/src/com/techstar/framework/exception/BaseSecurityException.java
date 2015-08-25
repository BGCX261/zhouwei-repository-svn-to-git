//Source file: C:\\test\\com\\techstar\\framework\\exception\\SecurityException.java

package com.techstar.framework.exception;


public class BaseSecurityException extends BaseException 
{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param cause
	 * @roseuid 44E13C19032D
	 */
	public BaseSecurityException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errorCode
	 * @param cause
	 * @roseuid 44E13C19032A
	 */
	public BaseSecurityException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	/**
	 * @param errorCode
	 * @roseuid 44E13C190328
	 */
	public BaseSecurityException(String errorCode) {
		super(errorCode);
	}
}
