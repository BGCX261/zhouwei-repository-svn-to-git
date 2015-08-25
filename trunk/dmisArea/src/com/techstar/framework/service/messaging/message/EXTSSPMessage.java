package com.techstar.framework.service.messaging.message;

import java.util.Iterator;

import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;

import org.apache.axis.AxisFault;
import org.apache.axis.message.SOAPEnvelope;

import com.techstar.framework.service.messaging.message.TSSPMessage;

/**
 * 继承框架消息服务中的消息
 * @author caojian Apr 3, 2007
 * modify by xiongcf 2007-4-26 * 
 */
public class EXTSSPMessage extends TSSPMessage {

	
	private static final long serialVersionUID = 1L;
	private EXTSSPHeader header;

	public EXTSSPMessage(Object initialContents, boolean bodyInStream,
			MimeHeaders headers) {
		super(initialContents, bodyInStream, headers);
	}

	public EXTSSPMessage(Object initialContents, boolean bodyInStream,
			String contentType, String contentLocation) {
		super(initialContents, bodyInStream, contentType, contentLocation);
	}

	public EXTSSPMessage(Object initialContents, boolean bodyInStream) {
		super(initialContents, bodyInStream);
	}

	public EXTSSPMessage(Object initialContents, MimeHeaders headers) {
		super(initialContents, headers);
	}

	public EXTSSPMessage(Object initialContents) {
		super(initialContents);
	}

	public EXTSSPHeader createEXTSSPHeader() {
		return new EXTSSPHeader();
	}

	public void setHeader(EXTSSPHeader header) throws SOAPException {
		this.header = header;
		String prefix = "wssp";
		String headerUri = "http://WSSP/Header";
		SOAPEnvelope envelope = null;
		try {
			envelope = getSOAPEnvelope();
		} catch (AxisFault ex) {
			ex.printStackTrace();
		}
		envelope.getHeader().detachNode();
		org.apache.axis.message.SOAPHeader soapHeader = (org.apache.axis.message.SOAPHeader) envelope
				.addHeader();
		soapHeader.addChildElement("From", prefix, headerUri).addTextNode(
				header.getFrom());
		soapHeader.addChildElement("To", prefix, headerUri).addTextNode(
				header.getTo());
		soapHeader.addChildElement("BussinessSign", prefix, headerUri)
				.addTextNode(header.getBussinessSign());
		soapHeader.addChildElement("CenterTaskId", prefix, headerUri)
				.addTextNode(header.getCenterTaskId());
		soapHeader.addChildElement("AreaTaskId", prefix, headerUri)
				.addTextNode(header.getAreaTaskId());
		soapHeader.addChildElement("Type", prefix, headerUri).addTextNode(
				header.getType());
		soapHeader.addChildElement("ContentVersion", prefix, headerUri)
				.addTextNode(header.getContentVersion());
		soapHeader.addChildElement("IsTrigger", prefix, headerUri).addTextNode(
				header.getIsTrigger());
		soapHeader.addChildElement("ObjectName", prefix, headerUri)
				.addTextNode(header.getObjectName());
		soapHeader.addChildElement("MethodName", prefix, headerUri)
				.addTextNode(header.getMethodName());
		soapHeader.addChildElement("Timestamp", prefix, headerUri).addTextNode(
				header.getTimestamp());
		soapHeader.addChildElement("TraceNumber", prefix, headerUri)
				.addTextNode(header.getTraceNumber());
		soapHeader.addChildElement("NotifyContent",prefix,headerUri).addTextNode(header.getNotifyContent());
		saveChanges();
	}

	public EXTSSPHeader getEXHeader() throws SOAPException {
		EXTSSPHeader rHeader = new EXTSSPHeader();
		SOAPEnvelope envelope = null;
		try {
			envelope = getSOAPEnvelope();
		} catch (AxisFault ex) {
			throw new SOAPException("AxisFault" + ex);
		}
		SOAPHeader _header = envelope.getHeader();
		for (Iterator iterator = _header.getChildElements(); iterator.hasNext();) {
			SOAPElement _soapElement = (SOAPElement) iterator.next();
			if (_soapElement.getElementName().getLocalName().equals("From")) {
				rHeader.setFrom(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals("To")) {
				rHeader.setTo(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals("BussinessSign")) {
				rHeader.setBussinessSign(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals("CenterTaskId")) {
				rHeader.setCenterTaskId(_soapElement.getValue());
			}			
			if (_soapElement.getElementName().getLocalName().equals("AreaTaskId")) {
				rHeader.setAreaTaskId(_soapElement.getValue());
			}			
			if (_soapElement.getElementName().getLocalName().equals("Type")) {
				rHeader.setType(_soapElement.getValue());
			}			
			if (_soapElement.getElementName().getLocalName().equals(
					"ContentVersion")) {
				rHeader.setContentVersion(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals("IsTrigger")) {
				rHeader.setIsTrigger(_soapElement.getValue());
			}	
			if (_soapElement.getElementName().getLocalName().equals("ObjectName")) {
				rHeader.setObjectName(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals("MethodName")) {
				rHeader.setMethodName(_soapElement.getValue());
			}			
			if (_soapElement.getElementName().getLocalName()
					.equals("Timestamp")) {
				rHeader.setTimestamp(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals(
					"TraceNumber")) {
				rHeader.setTraceNumber(_soapElement.getValue());
			}
			if (_soapElement.getElementName().getLocalName().equals(
					"NotifyContent")) {
				rHeader.setNotifyContent(_soapElement.getValue());
			}
		}

		header = rHeader;
		return header;
	}
}
