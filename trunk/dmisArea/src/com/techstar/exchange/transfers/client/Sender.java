package com.techstar.exchange.transfers.client;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.messaging.JAXMException;
import javax.xml.messaging.ProviderConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.time.StopWatch;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.techstar.framework.service.messaging.client.ConnectionFactoryImpl;
import com.techstar.framework.service.messaging.message.ContentType;
import com.techstar.framework.service.messaging.message.TSSPAttachment;
import com.techstar.framework.service.messaging.message.TSSPBody;
import com.techstar.framework.service.messaging.message.TSSPHeader;
import com.techstar.framework.service.messaging.message.TSSPMessage;
import com.techstar.framework.service.messaging.message.TSSPMessageFactory;
import com.techstar.framework.service.messaging.message.Util;

public class Sender {
	public Sender() {
		super();
	}

	public static byte[] packMessage() {
		ByteArrayOutputStream bytearrayoutputstream;
		TSSPMessageFactory tsspmessagefactory;
		bytearrayoutputstream = new ByteArrayOutputStream();
		tsspmessagefactory = new TSSPMessageFactory();
		byte abyte0[];
		try {
			TSSPMessage tsspmessage = (TSSPMessage) tsspmessagefactory
					.createMessage();
			TSSPHeader tsspheader = tsspmessage.createTSSPHeader();
			tsspheader.setTraceNumber(Util.generateTraceNumber());
			tsspheader.setFrom("gaj");
			tsspheader.setTo("sjpt");
			tsspheader.setTimestamp(Util.generateTimeStamp());
			tsspheader.setTitle("hello world");
			ContentType contenttype = ContentType.SP01A;
			tsspheader.setContentType(contenttype.getCode());
			tsspheader.setContentVersion(contenttype.getVersion());
			tsspmessage.setHeader(tsspheader);
			String s = "yangj@263.net";
			TSSPBody tsspbody = tsspmessage.createTSSPBody();
			tsspbody.setUri(contenttype.getUri());
			Object obj1 = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuilder = ((DocumentBuilderFactory) (obj1))
					.newDocumentBuilder();
			Document document = documentbuilder.newDocument();
			Element element = document.createElement("H1");
			Element element1 = document.createElement("Attachment");
			element1.setAttribute("href", s);
			element1.appendChild(document.createTextNode("hello world"));
			element.appendChild(element1);
			document.appendChild(element);
			tsspbody.setDocument(document);
			tsspmessage.setBody(tsspbody);
			obj1 = tsspmessage.createWSSPAttachment();
			((TSSPAttachment) (obj1)).setCid(s);
			((TSSPAttachment) (obj1)).setContent(
					"hello , this is a attachment", "text/plain");
			tsspmessage.addAttachment(((TSSPAttachment) (obj1)));
			tsspmessage.writeTo(bytearrayoutputstream);
		} catch (Exception ex) {

		}
		abyte0 = bytearrayoutputstream.toByteArray();
		return abyte0;

	}

	public static TSSPMessage packMessage2() {

		ByteArrayOutputStream bytearrayoutputstream;
		TSSPMessageFactory tsspmessagefactory;
		bytearrayoutputstream = new ByteArrayOutputStream();
		tsspmessagefactory = new TSSPMessageFactory();
		TSSPMessage tsspmessage = null;
		try {

			tsspmessage = (TSSPMessage) tsspmessagefactory.createMessage();
			TSSPHeader tsspheader = tsspmessage.createTSSPHeader();
			tsspheader.setTraceNumber(Util.generateTraceNumber());
			tsspheader.setFrom("haidian");
			tsspheader.setTo("zhongx");
			tsspheader.setTimestamp(Util.generateTimeStamp());
			tsspheader.setTitle("hello world");
			ContentType contenttype = ContentType.SP01A;
			tsspheader.setContentType(contenttype.getCode());
			tsspheader.setContentVersion(contenttype.getVersion());
			tsspmessage.setHeader(tsspheader);

			String s = "yangj@263.net";
			TSSPBody tsspbody = tsspmessage.createTSSPBody();
			tsspbody.setUri(contenttype.getUri());
			Object obj1 = DocumentBuilderFactory.newInstance();
			Object obj2 = ((DocumentBuilderFactory) (obj1))
					.newDocumentBuilder();
			Object obj3 = ((DocumentBuilder) (obj2)).newDocument();
			Object obj4 = ((Document) (obj3)).createElement("H1");
			Element element = ((Document) (obj3)).createElement("Attachment");
			element.setAttribute("href", s);
			element.appendChild(((Document) (obj3))
					.createTextNode("hello world"));
			((Element) (obj4)).appendChild(element);
			((Document) (obj3)).appendChild(((org.w3c.dom.Node) (obj4)));
			tsspbody.setDocument(((Document) (obj3)));
			tsspmessage.setBody(tsspbody);

			// obj1 = "C:\\temp\\test.txt";
			// obj2 = new FileInputStream(((String) (obj1)));

			// obj3 = new DataHandler(new FileDataSource(new File(((String)
			// (obj1)))));

			// obj4 = tsspmessage.createAttachmentPart(((DataHandler) (obj3)));

			// tsspmessage.addAttachment(((javax.xml.soap.AttachmentPart)
			// (obj4)));

			// ((FileInputStream) (obj2)).close();

			// tsspmessage.writeTo(bytearrayoutputstream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsspmessage;

	}

	public static void main(String[] args) {

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		long l2 = 0L;
		ConnectionFactoryImpl connectionfactoryimpl = new ConnectionFactoryImpl();
		ProviderConnection providerconnection = null;
		FileInputStream fileinputstream = null;

		try {
			providerconnection = connectionfactoryimpl.createConnection();
			providerconnection.send(packMessage2());
			l2 = System.currentTimeMillis() - l2;

		} catch (Exception exception1) {
			exception1.printStackTrace();
		} finally {
			if (providerconnection != null) {
				try {
					providerconnection.close();
				} catch (JAXMException jaxmexception) {
					jaxmexception.printStackTrace();
				}
			}
			if (fileinputstream != null) {
				try {
					fileinputstream.close();
				} catch (IOException ioexception) {
					ioexception.printStackTrace();
				}
			}
		}
		stopwatch.stop();
		System.out.println("sw time is" + stopwatch.getTime());
	}

}
