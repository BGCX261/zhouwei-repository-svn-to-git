package com.techstar.exchange.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;

import com.techstar.exchange.dto.bussiness.BhFaultlistDto;
import com.techstar.exchange.dto.bussiness.EtsEquipmentDto;
import com.techstar.exchange.dto.control.AttachmentDto;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.PersonDto;
import com.techstar.exchange.dto.control.QueryDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.service.utils.Constant;

public class Test {
	/**
	 * 测试发送业务对象信息
	 * */
	public void TestSend() throws Exception {
		// 控制DTO
		ControlDto dto = new ControlDto();
		dto.setAreaTaskId("001");
		dto.setBussinessSign("BhFaultlist");
		dto.setCenterTaskId("000");
		dto.setContentVersion("1");
		dto.setFrom("sj");
		dto.setIsTrigger("1");
		dto.setMethodName("method");
		dto.setObjectName("object");
//		dto.setTo("HD");
		dto.setType(Constant.MESSAGETYPE_BUSSINESS);
		
		dto.setNotifyContent("通知：接收到esb业务消息，请及时查收保护缺陷对象内容");
		
		RecvDto rdto = new RecvDto();
		rdto.setTo("hd");
		List pds = new ArrayList();
		rdto.setPersonDtos(pds); //带人员消息
		PersonDto pd = new PersonDto();
		pd.setPersonId("0001");
		pd.setMobile("13910209909");
		pds.add(pd);
		PersonDto pd1 = new PersonDto();
		pd1.setPersonId("0002");
		pd1.setMobile("13910209909");
		pds.add(pd1);
		
		RecvDto rdto1 = new RecvDto();
		rdto1.setTo("cy");
		
		List recvDtos = new ArrayList();
		recvDtos.add(rdto);
		recvDtos.add(rdto1);
		
		dto.setRecvDtos(recvDtos);
		
		
		List attachments = new ArrayList();
		AttachmentDto adto = new AttachmentDto();
		File f = new File("c:\\temp\\test1.txt");
		InputStream is = new FileInputStream(f);
		long length = f.length();
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		is.close();
		adto.setContent(bytes);
		adto.setId("00000001");
		attachments.add(adto);

		adto = new AttachmentDto();
		f = new File("c:\\temp\\test2.txt");
		is = new FileInputStream(f);
		length = f.length();
		bytes = new byte[(int) length];
		offset = 0;
		numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		is.close();
		adto.setContent(bytes);
		adto.setId("00000002");
		attachments.add(adto);

		dto.setAttachments(attachments);

		// 业务DTO
		BhFaultlistDto buss = new BhFaultlistDto();
		buss.setDataowner("测试3");
		buss.setFcontinuetime(1);
		buss.setFdispatchname("11111");
		buss.setFoccurredtime(new java.sql.Date(1998, 12, 11));
		buss.setSys_filltime(new java.sql.Timestamp(1998, 12, 11, 12, 9, 1, 1));
		EtsEquipmentDto ets = new EtsEquipmentDto();
		ets.setFeqpid("测试4");
		buss.setZbhfaultlist3(ets);

		IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());

		// 发送
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		service.sendMessage(dto, buss);

		stopwatch.stop();
		System.out.println("发送耗时: " + stopwatch.getTime());
	}
	
	
	/**
	 * 测试发送通知公告信息
	 * */
	public void TestSendNotify() throws Exception {
		// 控制DTO
		ControlDto dto = new ControlDto();
		dto.setFrom("HD");
//		dto.setTo("HD");
		dto.setType(Constant.MESSAGETYPE_NOTIFY);
		
		
		RecvDto rdto = new RecvDto();
		rdto.setTo("HD_1");
		List pds = new ArrayList();
		rdto.setPersonDtos(pds);
		PersonDto pd = new PersonDto();
		pd.setPersonId("test1");
		pd.setMobile("13910209909");
		pds.add(pd);
		PersonDto pd1 = new PersonDto();
		pd1.setPersonId("test2");
		pd1.setMobile("13910209909");
		pds.add(pd1);
		
		RecvDto rdto1 = new RecvDto();
		rdto1.setTo("HD_2");
		List pds1 = new ArrayList();
		rdto1.setPersonDtos(pds1);
		PersonDto pd2 = new PersonDto();
		pd2.setPersonId("test3");
		pd2.setMobile("13910209909");
		pds1.add(pd2);
		PersonDto pd3 = new PersonDto();
		pd3.setPersonId("test4");
		pd3.setMobile("13910209909");
		pds1.add(pd3);
		
		
		List recvDtos = new ArrayList();
		recvDtos.add(rdto);
		recvDtos.add(rdto1);
		
		dto.setRecvDtos(recvDtos);

		IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());

		// 发送

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		service.sendMessage(dto, "通知:劳动者光荣,五一放十天假,请大家假期注意安全,吃好喝好!");

		stopwatch.stop();
		System.out.println("发送耗时: " + stopwatch.getTime());
	}
	
	/**
	 * 测试接收业务消息
	 * */
	public void TestRecvBuss() throws Exception {
		IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());
//		QueryDto querydto = new QueryDto();
		/*querydto.setSign("BhFaultlist");
		querydto.setFrom("SJ");
		querydto.setTo("HD");*/
		List list = service.recvMessage(null);
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			List temp = (List)list.get(i);
			ControlDto dto = (ControlDto) temp.get(0);
			List attachments = dto.getAttachments();

			AttachmentDto adto = (AttachmentDto) attachments.get(0);
			System.out.println("attachemt:" + adto.getId());
			File f = new File("c:\\temp\\test3.txt");
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(adto.getContent());
			fos.flush();
			fos.close();
			
			adto = (AttachmentDto) attachments.get(1);
			System.out.println("attachemt:" + adto.getId());
			f = new File("c:\\temp\\test4.txt");
			fos = new FileOutputStream(f);
			fos.write(adto.getContent());		
			fos.flush();
			fos.close();
			
			System.out.println("control:");
			System.out.println("from:" + dto.getFrom());
			System.out.println("recvtime:" + dto.getRecvTime());
			
			BhFaultlistDto bdto = (BhFaultlistDto)temp.get(1);
			System.out.println("dataowner:" + bdto.getDataowner());
		}
		
		
		
		// System.out.println("")

	}
	
	/**
	 * 测试接收通知类消息
	 * */
	public void TestRecvNotify() throws Exception {
		IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());
		QueryDto querydto = new QueryDto();
		
		/*querydto.setFrom("SJ");
		querydto.setTo("HD");*/
		querydto.setPersonId("test4");
		
		List list = service.recvMessage(querydto,Constant.MESSAGETYPE_NOTIFY);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

	}
	
	
	/***
	 * 测试接收esb消息
	 * */
	public void TestRecv() throws Exception {
		IexchangeService service = (IexchangeService) (new ExchangeServiceImpl());

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		service.recvMessage();

		stopwatch.stop();
		System.out.println("接收耗时: " + stopwatch.getTime());
	}

	public static void main(String[] args) throws Exception {
		Test test = new Test();
//		 test.TestRecv();         //ok
		test.TestRecvBuss();      //ok
//		 test.TestSend();         //ok
//		test.TestSendNotify();   //ok
//		test.TestRecvNotify();   //ok
		 
		 
		 
		 
		 
//		TransBhFaultlistDto dto = new TransBhFaultlistDto();
//		dto.setZbhfaultlist3("1111");
//		List mappingFiles = new ArrayList();
//		mappingFiles.add("TransBhFaultlist.xml");
//		DozerBeanMapper mapper = new DozerBeanMapper();
//		mapper.setMappingFiles(mappingFiles);
//		Object o = mapper.map(dto, BhFaultlistDto.class);
//		BhFaultlistDto bdto = (BhFaultlistDto)o;
//		System.out.println("************" + bdto.getZbhfaultlist3().getFeqpid());
		
		
		/*RecvDto dto = new RecvDto();
		dto.setTo("HD");
		List pds = new ArrayList();
		dto.setPersonDtos(pds);
		PersonDto pd = new PersonDto();
		pd.setPersonId("0001");
		pd.setMobile("13910209909");
		pds.add(pd);
		PersonDto pd1 = new PersonDto();
		pd1.setPersonId("0002");
		pd1.setMobile("13910209909");
		pds.add(pd1);
		
		String xml = XStreamConvert.beanToXml(dto);
		System.out.println(xml);
		
		RecvDto obj = (RecvDto)XStreamConvert.xmlToBean(xml);
		System.out.println(obj.getTo());*/
	}
	
}
