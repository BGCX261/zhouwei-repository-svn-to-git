package com.techstar.dmis.service.message.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.techstar.dmis.service.IDdDoutageplanService;
import com.techstar.dmis.service.IZdhSrapplicationService;
import com.techstar.dmis.service.ServiceLocator;
import com.techstar.dmis.service.message.IGenBussDataFromMessage;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.QueryDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.techstar.framework.utils.AppHelper;
/**
 * 进程所调用的类,根据tonglink所接收的消息，生成本地的业务数据
 * @author sbt
 *
 */
public class GenBussDataFromMessageImp implements IGenBussDataFromMessage {
	public void genBussData () {
		try {
			/***********获取message.properties中的key值********************/
			//发送方服务IP
			String provider_url = MessageConfig.getValue("JNDI_PROVIDER_URL");
			//发送方编码
			String local_node = MessageConfig.getValue("LOCAL_NODE");
			//接收方编码(以逗号隔开的)
			String recv_queues = MessageConfig.getValue("RECV_QUEUE");
			/*
			//市局
			String recv_queueForSJ = recv_queues.split(",")[0];
			//城区
			String recv_queueForCQ = recv_queues.split(",")[1];
			*/
			//模块名称(以逗号隔开的)
			String modules = MessageConfig.getValue("MODULE");
			
			//消息传递对象的包结构
			String transDtoPackage = MessageConfig.getValue("transDtoPackage");
			
			//业务对象的包结构
			String bussDtoPackage = MessageConfig.getValue("bussDtoPackage");
			
			//dozer映射文件的绝对路径
			String mappingFileHome = MessageConfig.getValue("mappingFileHome");
			/*************获取接收到的数据****************/
			System.out.println("测试接收  0:");
			IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());
			System.out.println("测试接收  1:");
            //获取接收到的数据，并进行解析
			QueryDto querydto = new QueryDto();
			querydto.setSign("DdDoutageplan");
			List list = service.recvMessage(querydto);
			//List list = service.recvMessage(null);
			System.out.println("测试接收  2:"); 			
			for (int i = 0; i < list.size(); i++) {
				
				//System.out.println("####"+list.get(i).getClass());
				List messagePer = (List)list.get(i);
				
				
				for (int m=0;m<messagePer.size();m++){
					System.out.println("#####"+messagePer.get(m).getClass());
				}
				
				
				//控制dto,第一个元素存放控制dto
				ControlDto dto = (ControlDto) messagePer.get(0);
				//获取附件
				//List attachments = dto.getAttachments();
				//获取service               
				String serviceName = dto.getObjectName();
				//System.out.println("serviceName="+serviceName);
				//获取业务中所以执行的方法
				String mothodName = dto.getMethodName();
				//System.out.println("mothodName="+mothodName);
				//获取serviceImp对象
				Object serviceImpl = ServiceLocator.getInstance().getService(serviceName);
				//System.out.println("获取serviceImp对象");
				//获取业务中所以执行的方法
				Class[] parameterTypes = new Class[1];//这里你要调用的方法只有一个参数 

				parameterTypes[0] = java.util.List.class;//这个参数的类型是List[] 	
				Method objMeth = serviceImpl.getClass().getMethod(mothodName,parameterTypes);
				//System.out.println("objMeth="+objMeth.getName()+"  "+objMeth.getParameterTypes());
				Object[] messagePers = new Object[1];
				messagePers[0] = messagePer;
				
				//System.out.println("执行业务方法");
				//执行业务方法
				objMeth.invoke(serviceImpl,messagePers);
				//System.out.println("执行业务方法111");
				//objMeth.invoke(serviceImpl.getClass(),null);
				
			}
			//System.out.println("测试接收:"+com.techstar.dmis.util.DateUtil.getCurrentTimestamp());
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	



	/*private  static Object getSpringBean(String arg) {
		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext.xml"));
		
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);		

//		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext.xml"));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_dao.xml"));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_workflow.xml"));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_service.xml"));		
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_other.xml"));
		reader.loadBeanDefinitions(new FileSystemResource(AppHelper.getWebAppPath()+ "WEB-INF//spring//applicationContext_dmis_jbpmcfg.xml"));
		
		
		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
		cfg.setLocation(new FileSystemResource(AppHelper.getWebAppPath()+"WEB-INF\\spring\\spring.properties"));
//		 now actually do the replacement
		cfg.postProcessBeanFactory(factory);
		Object obj = factory.getBean(arg);
		return obj;
	}*/
	
	
	public static void main(String args[]){
		
//		IZdhSrapplicationService service1 = (IZdhSrapplicationService)ServiceLocator.getInstance().getService("iZdhSrapplicationService");
//		service1.listZdhSrappeqprel();
//		
//		IDdDoutageplanService service2 = (IDdDoutageplanService)ServiceLocator.getInstance().getService("iDdDoutageplanService");
//		service2.listDayplancoopraterel();
		GenBussDataFromMessageImp a=new GenBussDataFromMessageImp();
		a.genBussData();
		
		
		
		
	}

}
