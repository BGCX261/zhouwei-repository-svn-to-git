package com.techstar.framework.exception;

import com.techstar.framework.utils.ExceptionCacheHelper;

/**
 * @author xcf
 * 此类为本框架的异常基本类，所有异常继承此类
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 异常代码
	 */
	private String errorCode;

	/**
	 * @param cause
	 * @roseuid 44E13C19032D
	 */
	public BaseException(Throwable cause) {
		super(cause);		
	}

	/**
	 * @param errorCode
	 * @param cause
	 * @roseuid 44E13C19032A
	 */
	public BaseException(String errorCode, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param errorCode
	 * @roseuid 44E13C190328
	 */
	public BaseException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}
	/**
	 * 得到异常代码
	 * @return String
	 * @roseuid 44E9125B01EB
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 * 得到异常信息
	 * @return String
	 * @roseuid 44E916C303E5
	 */
	public String getMessage() {
		return ExceptionCacheHelper.getMessage(this.errorCode);
	}
}
