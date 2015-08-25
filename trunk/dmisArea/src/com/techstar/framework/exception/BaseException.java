package com.techstar.framework.exception;

import com.techstar.framework.utils.ExceptionCacheHelper;

/**
 * @author xcf
 * ����Ϊ����ܵ��쳣�����࣬�����쳣�̳д���
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �쳣����
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
	 * �õ��쳣����
	 * @return String
	 * @roseuid 44E9125B01EB
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 * �õ��쳣��Ϣ
	 * @return String
	 * @roseuid 44E916C303E5
	 */
	public String getMessage() {
		return ExceptionCacheHelper.getMessage(this.errorCode);
	}
}
