//Source file: C:\\test\\com\\techstar\\framework\\service\\log\\ILogService.java

package com.techstar.framework.service.log;

import com.techstar.framework.service.dto.LogInfoDTO;
import com.techstar.framework.exception.BaseException;


/**
 * 此类为操作日志接口，提供保存日志、备份日志、查询日志方法
 * Sep 11, 2006
 * @author xcf
 */
public interface ILogService 
{
   
	 /**
	    * 该方法主要功能是保存传递进来的日志信息至数据库
	    * @param logInfoDto - 传递日志信息值对象
	    * @return Object
	    * @throws com.techstar.framework.exception.BaseException
	    * @roseuid 44E122670131
	    */
	   public Object saveLogToDb(LogInfoDTO logInfoDto) throws BaseException;
	   
	   /**
	    * 该方法主要功能是根据指定参数从数据库中查询日志信息
	    * @param logInfoDto - 查询包括日志人、操作时间段的组合，这些信息被封装在该对象
	    * @return java.util.List
	    * @throws com.techstar.framework.exception.BaseException
	    * @roseuid 44E122CC0257
	    */
	   public java.util.List queryLogInfo(LogInfoDTO logInfoDto) throws BaseException;
	   
	   /**
	    * 该方法主要功能是备份日志信息
	    * @return Object
	    * @throws com.techstar.framework.exception.BaseException
	    * @roseuid 44E122D701D5
	    */
	   public Object backupLogInfo() throws BaseException;
}
