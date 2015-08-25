package com.techstar.framework.service.messaging.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.xml.messaging.JAXMException;
import javax.xml.messaging.ProviderConnection;

import com.techstar.framework.ClassLoaderHelper;
import com.techstar.framework.service.messaging.message.TSSPMessage;

public class SoapJmsSimpleReceive {

	public static void main(String[] args) throws Exception{
		// print usage
		if (args.length != 1) {
			System.out.println("usage: SampleReceive <path>");
		}

		long unpackTime = 0;
		long recvTime = 0;
		long unpackMem = 0;
		long recvMem = 0;

//		String path = "c:\\temp\\";
		
    	Properties prop = new Properties();
        URL url = ClassLoaderHelper.getExtendResource("../message.properties");
        InputStream is = ClassLoaderHelper.getStream(url);
        prop.load(is);
		String path = prop.getProperty("receivepath");
		
		

		// 创建连接工厂
		ConnectionFactoryImpl factory = new ConnectionFactoryImpl();

		ProviderConnection connection = null;
		Receiver receiver = null;
		FileOutputStream fout = null;
		// 创建连接
		try {
			connection = factory.createConnection();
		} catch (JAXMException e) {
			e.printStackTrace();
			return;
		}
		;

		try {
			recvTime = System.currentTimeMillis();
			// 创建Receiver
			receiver = Receiver.createReceiver(connection);
			// 打开Receiver，同时开始动事务
			receiver.open();
			// 接收消息
			TSSPMessage message = (TSSPMessage) receiver.receive();

			recvTime = System.currentTimeMillis() - recvTime;
			recvMem = Runtime.getRuntime().totalMemory()
					- Runtime.getRuntime().freeMemory();
			unpackTime = System.currentTimeMillis();

			// 判断是否收到消息
			if (message == null) {
				System.out.println("no message");
			} else {	
				//取得路径信息
//	        	Properties unDecodedProp = new Properties();
//	            URL url = ClassLoaderHelper.getExtendResource("../message.properties");
//	            InputStream is = ClassLoaderHelper.getStream(url);
//	            unDecodedProp.load(is);
//	            String path = unDecodedProp.getProperty("path");
				
				// 如果收到消息，将消息写到文件中
				File file = new File(path, Long.toString(new Date().getTime()));
				fout = new FileOutputStream(file);
				message.writeTo(fout);
				System.out.println("received message, saved to :"
						+ file.getAbsolutePath());
			}
			unpackTime = System.currentTimeMillis() - unpackTime;
			unpackMem = Runtime.getRuntime().totalMemory()
					- Runtime.getRuntime().freeMemory();
			// 提交事务
			receiver.commit();

		} catch (Exception e) {
			e.printStackTrace();
			// 如果遇到异常，回滚事务，消息会回到队列中
			try {
				System.out.println("received message, rollback");
				receiver.rollback();
			} catch (JAXMException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 关闭Receiver
			if (receiver != null) {
				try {
					receiver.close();
				} catch (JAXMException e) {
					e.printStackTrace();
				}
			}
			// 关闭Connection
			if (connection != null) {
				try {
					connection.close();
				} catch (JAXMException e) {
					e.printStackTrace();
				}
			}
			// 关闭文件
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("接收耗时[" + recvTime / 1000 + "秒" + recvTime % 1000
				+ "毫秒]" + "，内存占用[" + recvMem / 1024 + "k]");
		System.out.println("解包耗时[" + unpackTime / 1000 + "秒" + unpackTime
				% 1000 + "毫秒]" + "，内存占用[" + unpackMem / 1024 + "k]");
	}
}
