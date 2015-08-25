package com.techstar.exchange.transfers.message;


import java.io.StringReader;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.axis.soap.MessageFactoryImpl;
import org.jdom.input.SAXBuilder;
import org.jdom.output.DOMOutputter;

import com.techstar.exchange.dto.control.AttachmentDto;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.utils.Constant;
import com.techstar.framework.service.messaging.message.EXTSSPHeader;
import com.techstar.framework.service.messaging.message.EXTSSPMessage;
import com.techstar.framework.service.messaging.message.TSSPBody;
import com.techstar.framework.service.messaging.message.TSSPMessageFactory;
import com.techstar.framework.service.messaging.message.Util;

public class EXTSSPMessageFactory extends TSSPMessageFactory {

	public EXTSSPMessageFactory() {
		super();
	}
	
	/**
	 * @param dto
	 * @param content
	 * modify by xcf 2007-4-20 增加类型参数及相应的处理
	 * 2007-4-26 增加通知消息内容
	 * @param type 0-发送业务消息 1-发送通知或公告消息
	 * */
	public EXTSSPMessage genMessage(ControlDto dto, String content)
			throws Exception {
		/** 新建消息 */
		EXTSSPMessage extsspmessage = (EXTSSPMessage) createMessage();

		/** 构造消息头 */
		EXTSSPHeader extsspheader = extsspmessage.createEXTSSPHeader();

		// 发送方编码
		extsspheader.setFrom(dto.getFrom());
		// 接收方编码
		extsspheader.setTo(dto.getTo());
		// 业务标识
		extsspheader.setBussinessSign(dto.getBussinessSign());
		// 中心任务Id
		extsspheader.setCenterTaskId(dto.getCenterTaskId());
		// 二级单位任务Id
		extsspheader.setAreaTaskId(dto.getAreaTaskId());
		// 类型
		extsspheader.setType(dto.getType());
		// 版本
		extsspheader.setContentVersion(dto.getContentVersion());
		// 是否触发器
		extsspheader.setIsTrigger(dto.getIsTrigger());
		// 业务对象名称
		extsspheader.setObjectName(dto.getObjectName());
		// 业务方法名称
		extsspheader.setMethodName(dto.getMethodName());
		
		//add by xcf 增加通知消息内容
		extsspheader.setNotifyContent(dto.getNotifyContent());
		
		extsspheader.setTraceNumber(Util.generateTraceNumber());

		extsspheader.setTimestamp(Util.generateTimeStamp());
		
		extsspmessage.setHeader(extsspheader);

//		if( dto.getType().equalsIgnoreCase(Constant.MESSAGETYPE_BUSSINESS)){ //是业务消息,则将业务对象对应的xml构造成消息体
		/** 构造消息体 */
			TSSPBody tsspbody = extsspmessage.createTSSPBody();
			
			// URI
			tsspbody.setUri(EXContentType.uri + dto.getBussinessSign());
	
			// 将jdom转化为w3cdom
			SAXBuilder builder = new SAXBuilder(false);
			org.jdom.Document doc = builder.build(new StringReader(content));
			org.w3c.dom.Document domDoc = null;
			org.jdom.output.DOMOutputter domoutputter = new DOMOutputter();
			domDoc = domoutputter.output(doc);
	
			tsspbody.setDocument(domDoc);
			extsspmessage.setBody(tsspbody);
//		}

		/** 如果有附件则增加附件 */
		List attachments = dto.getAttachments();
		if (attachments != null) {
			for (int i = 0; i < attachments.size(); i++) {
				AttachmentDto adto = (AttachmentDto) attachments.get(i);
				DataHandler dh = new DataHandler(new ByteArrayDataSource(adto
						.getContent(), "application/octet-stream"));
				AttachmentPart ap = extsspmessage.createAttachmentPart(dh);
				ap.setContentId(adto.getId());
				extsspmessage.addAttachment(ap);
			}
		}
		
		/*if( !dto.getType().equalsIgnoreCase(Constant.MESSAGETYPE_BUSSINESS) ){//是通知、公告类消息，则将消息内容放在附件中
			DataHandler dh = new DataHandler(new ByteArrayDataSource(content, "application/octet-stream"));
			AttachmentPart ap = extsspmessage.createAttachmentPart(dh);
			ap.setContentId(Constant.PREFIX_MSG);
			extsspmessage.addAttachment(ap);
		}
		*/
		/** 如果有人员信息，则构建附件 */
		List recvDtos = dto.getRecvDtos();
		if (recvDtos != null) {
			for (int i = 0; i < recvDtos.size(); i++) {
				RecvDto rd = (RecvDto)recvDtos.get(i);
				if (rd.getPersonDtos() != null && rd.getPersonDtos().size() > 0) {
					DataHandler dh = new DataHandler(new ByteArrayDataSource(rd
							.toXmlStr(), "application/octet-stream"));
					AttachmentPart ap = extsspmessage.createAttachmentPart(dh);
					ap.setContentId(Constant.PREFIX_PERSON);
					extsspmessage.addAttachment(ap);
				}
			}
		}

//		 String path = MessageConfig.getValue("attachment");
		
		/* FileInputStream fis = new FileInputStream(path);
		 byte[] b = new byte[2500];
		 int l;
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 while ((l = fis.read(b)) != -1) {
		 bos.write(b, 0, l);
		 }
		 fis.close();
		 byte[] att = bos.toByteArray();*/
		/* File file = new File(path);
		FileOutputStream fout = new FileOutputStream(file);
		extsspmessage.writeTo(fout);
		System.out.println("received message, saved to :"
				+ file.getAbsolutePath());*/

		return extsspmessage;
	}

	public SOAPMessage createMessage() throws SOAPException {
		MessageFactory factory = new MessageFactoryImpl();
		javax.xml.soap.SOAPEnvelope envelope = factory.createMessage()
				.getSOAPPart().getEnvelope();
		return new EXTSSPMessage(envelope, false);
	}
}
