package com.techstar.framework.service.mail.test;

/**
 * 单元测试类
 * Sep 11, 2006
 * @author xcf
 */
import java.util.List;

import org.springframework.beans.factory.BeanFactory;

import junit.framework.TestCase;

import com.techstar.framework.exception.BaseException;
import com.techstar.framework.service.dto.MailObject;
import com.techstar.framework.service.mail.IMailLocalService;
import com.techstar.framework.utils.ConfigurationHelper;
import com.techstar.framework.utils.TestHelper;

public class TestMailServiceImpl extends TestCase {

	public TestMailServiceImpl(String name) {
		super(name);
	}
	private IMailLocalService service;
	//预先装载一下xml配置文件
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
		service = (IMailLocalService)factory.getBean("iMailLocalService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
	
	//测试发送简单邮件
	public void _testSendTextMail() {
		MailObject object = new MailObject();
		object.setRecipients(new String[]{"xiongcf@163.com"});
		object.setText("hello!");
		object.setTopic("test mail 中文");		
		try {
			System.out.println("================开始发送邮件=================");
			service.sendMail(object);
			System.out.println("================邮件发送完毕=================");
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	测试发送带附件邮件(发送邮箱信息取默认信息)
	public void _testSendAttachmentMail() {
		MailObject object = new MailObject();
		object.setRecipients(new String[]{"xiongcf@163.com"});
		object.setTocc(new String[]{"xcf@pps.com.cn","caojian@pps.com.cn"});
		object.setText("hello11111!");
		object.setTopic("附件");
		//附件都统一上传到配置文件中所配的服务器路径中
		object.setAttachements(new String[]{ConfigurationHelper.getMailUploadFilePath()+"dao结构1.png",ConfigurationHelper.getMailUploadFilePath()+"基础开发平台升级.gif"});
		
		try {
			System.out.println("================开始发送邮件=================");
			service.sendMail(object);
			System.out.println("================邮件发送完毕=================");
			
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	测试发送带附件邮件(发送邮箱信息自定义传入参数)
	public void _testSendAttachmentMailWithSetSender() {
		MailObject object = new MailObject();
		object.setRecipients(new String[]{"xiongcf@163.com"});
		object.setText("hello!");
		object.setTopic("附件");
		object.setAttachements(new String[]{ConfigurationHelper.getMailUploadFilePath()+"基础开发平台升级.gif"});
		object.setSender("XXX@163.com");
		object.setSenderHost("smtp.163.com");
		object.setSenderPwd("XXX");
		
		try {
			System.out.println("================开始发送邮件=================");
			service.sendMail(object);
			System.out.println("================邮件发送完毕=================");
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//测试接收邮件
	public void testReceiveMail(){
		try {
			
			//接收邮件
			System.out.println("================开始接收邮件=================");
			List mos = (List)service.receiveMail("pop3.163.com","xiongcf@163.com","XXXXXX");
			if( mos !=  null ){
				for(int i=0; i<mos.size(); i++){
					MailObject mo = (MailObject)mos.get(i);
					System.out.println(mo.getText() + "  " + mo.getSendDate() );
					if(mo.getAttachements()!=null){
						for (int j = 0; j < mo.getAttachements().length; j++) {
							System.out.println(mo.getAttachements()[j]);
						}
					}
				}
			}
			System.out.println("================邮件接收完毕==================");
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
