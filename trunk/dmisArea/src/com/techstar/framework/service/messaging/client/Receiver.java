package com.techstar.framework.service.messaging.client;

import com.techstar.framework.service.messaging.engine.Engine;
import com.techstar.framework.service.messaging.engine.ReceiverException;
import com.techstar.framework.service.messaging.message.EXTSSPMessage;
import com.techstar.framework.service.messaging.message.TSSPMessage;
import com.techstar.framework.service.messaging.message.TSSPMessageFactory;
import java.io.IOException;
import javax.xml.messaging.JAXMException;
import javax.xml.messaging.ProviderConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.jms.BytesMessage;

public class Receiver {

	private ConnectionImpl connection;

	private com.techstar.framework.service.messaging.engine.Receiver engineReceiver;

	private boolean used;

	public static Receiver createReceiver() {
		try {
			ConnectionFactoryImpl factory = new ConnectionFactoryImpl();
			return new Receiver(factory.createConnection());
		} catch (JAXMException e) {
			throw new RuntimeException(e);
		}
	}

	public static Receiver createReceiver(ProviderConnection connection) {
		return new Receiver(connection);
	}

	private Receiver(ProviderConnection connection) {
		this.connection = null;
		engineReceiver = null;
		used = false;
		if (connection instanceof ConnectionImpl) {
			this.connection = (ConnectionImpl) connection;
			engineReceiver = this.connection.getEngine().getReceiver();
			return;
		}

	}

	public void open() throws JAXMException {
		try {
			engineReceiver.open();
			used = false;
		} catch (ReceiverException e) {
			throw new JAXMException(e);
		}
	}

	public SOAPMessage receive() throws JAXMException {
		if (used) {
			throw new JAXMException(
					"\u5DF2\u7ECF\u63A5\u6536\u8FC7\u6D88\u606F\uFF0C\u8BF7\u91CD\u65B0\u8C03\u7528Re"
							+ "ceiver.Open()\u63A5\u6536\u65B0\u6D88\u606F");
		}
		TSSPMessage message = null;
		try {
			if (engineReceiver.next()) {
				java.io.InputStream in = engineReceiver.getInputStream();
				MessageFactory factory = new TSSPMessageFactory();
				message = (TSSPMessage) factory.createMessage(null, in);
			} else {
				rollback();
			}
			return message;
		} catch (ReceiverException e) {
			throw new JAXMException("\u63A5\u6536\u5931\u8D25", e);
		} catch (IOException e) {
			throw new JAXMException("\u8BFB\u53D6\u6D88\u606F\u5931\u8D25", e);
		} catch (SOAPException e) {
			throw new JAXMException("SOAP\u89E3\u5305\u5931\u8D25", e);
		}
	}

	public SOAPMessage receiveEX() throws JAXMException {
		if (used) {
			throw new JAXMException(
					"\u5DF2\u7ECF\u63A5\u6536\u8FC7\u6D88\u606F\uFF0C\u8BF7\u91CD\u65B0\u8C03\u7528Re"
							+ "ceiver.Open()\u63A5\u6536\u65B0\u6D88\u606F");
		}
		SOAPMessage message = null;
		try {
			if (engineReceiver.next()) {
				java.io.InputStream in = engineReceiver.getInputStream();
				TSSPMessageFactory factory = new TSSPMessageFactory();
				message = (EXTSSPMessage)factory.createEXMessage(null, in);
			} else {
				rollback();
			}
			return message;
		} catch (ReceiverException e) {
			throw new JAXMException("\u63A5\u6536\u5931\u8D25", e);
		} catch (IOException e) {
			throw new JAXMException("\u8BFB\u53D6\u6D88\u606F\u5931\u8D25", e);
		} catch (SOAPException e) {
			throw new JAXMException("SOAP\u89E3\u5305\u5931\u8D25", e);
		}
	}

	public void commit() throws JAXMException {
		if (used) {
			return;
		}
		used = true;
		try {
			engineReceiver.commit();
		} catch (ReceiverException e) {
			throw new JAXMException(e);
		}
	}

	public void rollback() throws JAXMException {
		if (used) {
			return;
		}
		used = true;
		try {
			engineReceiver.rollback();
		} catch (ReceiverException e) {
			throw new JAXMException(e);
		}
	}

	public void close() throws JAXMException {
		try {
			engineReceiver.close();
		} catch (ReceiverException e) {
			throw new JAXMException(e);
		}
	}

	public SOAPMessage getSoapMessage(BytesMessage msg) throws JAXMException {

		TSSPMessage message = null;
		try {
			java.io.InputStream in = engineReceiver.getInputStream(msg);
			MessageFactory factory = new TSSPMessageFactory();
			message = (TSSPMessage) factory.createMessage(null, in);

			return message;
		} catch (ReceiverException e) {
			throw new JAXMException("\u63A5\u6536\u5931\u8D25", e);
		} catch (IOException e) {
			throw new JAXMException("\u8BFB\u53D6\u6D88\u606F\u5931\u8D25", e);
		} catch (SOAPException e) {
			throw new JAXMException("SOAP\u89E3\u5305\u5931\u8D25", e);
		}
	}
}