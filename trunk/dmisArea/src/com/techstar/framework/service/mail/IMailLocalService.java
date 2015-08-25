//Source file: C:\\test\\com\\techstar\\framework\\service\\mail\\IMailLocalService.java

package com.techstar.framework.service.mail;

import com.techstar.framework.service.dto.MailObject;
import com.techstar.framework.exception.BaseException;


/**
 * 该类为mail本地服务接口，提供发送、接收邮件功能
 * Sep 11, 2006
 * @author xcf
 */
public interface IMailLocalService 
{
   
   /**
    * 发送mail
    * @param mailObject
    * @return Object
    * @throws com.techstar.framework.exception.BaseException
    * @roseuid 44E16D840212
    */
   public Object sendMail(MailObject mailObject) throws BaseException;
   
   /**
    * 接收mail
    * @param mailHost 接收邮箱主机
    * @param mailuser 接收邮箱地址
    * @param mailPwd  接收邮箱帐号密码
    * @return Object
    * @throws com.techstar.framework.exception.BaseException
    * @roseuid 44E16D840214
    */
   public Object receiveMail(String mailHost , String mailuser , String mailPwd) throws BaseException;
}
