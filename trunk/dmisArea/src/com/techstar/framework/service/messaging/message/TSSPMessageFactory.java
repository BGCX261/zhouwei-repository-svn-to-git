package com.techstar.framework.service.messaging.message;

import java.io.*;
import javax.xml.soap.*;
import org.apache.axis.soap.MessageFactoryImpl;

/**
 * 
 * @author yangjun
 * 
 */
public class TSSPMessageFactory extends MessageFactory {

	public TSSPMessageFactory() {
	}

	public SOAPMessage createMessage(MimeHeaders headers,
			InputStream inputStream) throws IOException, SOAPException {
		if (headers == null) {
			headers = new MimeHeaders();
			PushbackInputStream pushbackInputStream = new PushbackInputStream(
					inputStream);
			int c = pushbackInputStream.read();
			pushbackInputStream.unread(c);
			inputStream = pushbackInputStream;
			if (c == 13) {
				headers.addHeader("Content-Type", "Multipart/Related");
				return new TSSPMessage(inputStream, headers);
			}
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte buf[] = new byte[4096];
			for (int len = 0; (len = inputStream.read(buf)) != -1;) {
				bout.write(buf, 0, len);
			}

			inputStream = new ByteArrayInputStream(bout.toByteArray());
			return new TSSPMessage(inputStream);
		} else {
			return new TSSPMessage(inputStream, headers);
		}
	}

	public SOAPMessage createMessage() throws SOAPException {
		MessageFactory factory = new MessageFactoryImpl();
		javax.xml.soap.SOAPEnvelope envelope = factory.createMessage()
				.getSOAPPart().getEnvelope();
		return new TSSPMessage(envelope, false);
	}

	public SOAPMessage createEXMessage(MimeHeaders headers,
			InputStream inputStream) throws IOException, SOAPException {
		if (headers == null) {
			headers = new MimeHeaders();
			PushbackInputStream pushbackInputStream = new PushbackInputStream(
					inputStream);
			int c = pushbackInputStream.read();
			pushbackInputStream.unread(c);
			inputStream = pushbackInputStream;
			if (c == 13) {
				headers.addHeader("Content-Type", "Multipart/Related");
				return new EXTSSPMessage(inputStream, headers);
			}
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte buf[] = new byte[4096];
			for (int len = 0; (len = inputStream.read(buf)) != -1;) {
				bout.write(buf, 0, len);
			}

			inputStream = new ByteArrayInputStream(bout.toByteArray());
			return new EXTSSPMessage(inputStream);
		} else {
			return new EXTSSPMessage(inputStream, headers);
		}
	}
}
