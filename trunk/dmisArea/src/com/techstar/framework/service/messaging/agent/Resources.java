package com.techstar.framework.service.messaging.agent;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.techstar.framework.ClassLoaderHelper;
import com.techstar.framework.service.messaging.engine.InitializeException;

/**
 * 
 * @author yangjun
 * 
 */
public class Resources {

	public static final String JNDI_PROVIDER_URL = "JNDI_PROVIDER_URL";

	public static final String JNDI_INITIAL_CONTEXT_FACTORY = "JNDI_INITIAL_CONTEXT_FACTORY";

	public static final String QUEUE_CONNECTION_FACTORY = "QUEUE_CONNECTION_FACTORY";

	public static final String SEND_QUEUE = "SEND_QUEUE";

	public static final String RECV_QUEUE = "RECV_QUEUE";

	public static final String LOCAL_NODE = "LOCAL_NODE";

	public static final String RECV_WAIT_TIME = "RECV_WAIT_TIME";

	private static Queue sendQueue = null;

	private static Queue recvQueue = null;

	private static QueueConnectionFactory factory = null;

	private static String localNode = null;

	private static long waitTime = 1000L;

	public Resources() {
	}

	public static boolean initialized() {
		return factory != null && sendQueue != null && recvQueue != null;
	}

	public static void initialize() throws InitializeException {
		Properties config = loadConfig();
		lookupObjects(config.getProperty("JNDI_PROVIDER_URL"), config
				.getProperty("JNDI_INITIAL_CONTEXT_FACTORY"), config
				.getProperty("QUEUE_CONNECTION_FACTORY"), config
				.getProperty("SEND_QUEUE"), config.getProperty("RECV_QUEUE"));
		try {
			localNode = config.getProperty("LOCAL_NODE");
			waitTime = Long.parseLong(config.getProperty("RECV_WAIT_TIME"));
		} catch (Exception e) {
			throw new InitializeException(e);
		}
	}

	public static void initialize(String from, String to)
			throws InitializeException {
		String sendQueue = from;
		String recvQueue = to;
		
		
		Properties config = loadConfig();
		lookupObjects(config.getProperty("JNDI_PROVIDER_URL"), config
				.getProperty("JNDI_INITIAL_CONTEXT_FACTORY"), config
				.getProperty("QUEUE_CONNECTION_FACTORY"), sendQueue, recvQueue);
		
		
		try {
			localNode = config.getProperty("LOCAL_NODE");
			waitTime = Long.parseLong(config.getProperty("RECV_WAIT_TIME"));
		} catch (Exception e) {
			throw new InitializeException(e);
		}
	}

	public static QueueConnectionFactory getFactory() {
		return factory;
	}

	public static Queue getRecvQueue() {
		return recvQueue;
	}

	public static Queue getSendQueue() {
		return sendQueue;
	}

	public static String getLocalNode() {
		return localNode;
	}

	public static long getWaitTime() {
		return waitTime;
	}

	private static Properties loadConfig() throws InitializeException {
		try {
			// java.io.InputStream cfgFile =
			// ClassLoader.getSystemResourceAsStream("agent.properties");

			Properties unDecodedProp = new Properties();
			URL url = ClassLoaderHelper
					.getExtendResource("../message.properties");
			InputStream is = ClassLoaderHelper.getStream(url);
			unDecodedProp.load(is);

			// unDecodedProp.setProperty("JNDI_INITIAL_CONTEXT_FACTORY","org.exolab.jms.jndi.InitialContextFactory");
			// unDecodedProp.setProperty("JNDI_PROVIDER_URL","tcp://127.0.0.1:3035/");
			// unDecodedProp.setProperty("SEND_QUEUE","queue3");
			// unDecodedProp.setProperty("RECV_QUEUE","queue3");
			// unDecodedProp.setProperty("QUEUE_CONNECTION_FACTORY","ConnectionFactory");
			// unDecodedProp.setProperty("LOCAL_NODE","0108");
			// unDecodedProp.setProperty("RECV_WAIT_TIME","10000");

			// Properties unDecodedProp = new Properties();
			// //
			// unDecodedProp.setProperty("JNDI_INITIAL_CONTEXT_FACTORY","tongtech.jms.jndi.JmsContextFactory");
			// unDecodedProp.setProperty("JNDI_PROVIDER_URL","tlkq://200.200.200.143:10241/");
			// unDecodedProp.setProperty("SEND_QUEUE","send");
			// unDecodedProp.setProperty("RECV_QUEUE","recv");
			// unDecodedProp.setProperty("QUEUE_CONNECTION_FACTORY","jmsfactory");
			// unDecodedProp.setProperty("LOCAL_NODE","yang");
			// unDecodedProp.setProperty("RECV_WAIT_TIME","10000");

			Properties decodecProp = new Properties();

			String key;
			String value;
			for (Enumeration enu = unDecodedProp.keys(); enu.hasMoreElements(); decodecProp
					.put(key, value)) {
				key = (String) enu.nextElement();
				value = unDecodedProp.getProperty(key);
				byte bs[] = value.getBytes("ISO-8859-1");
				value = new String(bs, "GBK");
			}

			return decodecProp;
		} catch (Exception e) {
			throw new InitializeException(
					"\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6agent.properties\u5931\u8D25",
					e);
		}
	}

	private static void lookupObjects(String providerUrl,
			String contextFactory, String connectionFactory, String send_Queue,
			String recv_Queue) throws InitializeException {
		System.out.println("***********************");
		System.out.println("providerUrl:" + providerUrl);
		System.out.println("contextFactory:" + contextFactory);
		System.out.println("connectionFactory:" + connectionFactory);
		System.out.println("send_Queue:" + send_Queue);
		System.out.println("recv_Queue:" + recv_Queue);
		
		Properties prop = new Properties();
		prop.put("java.naming.provider.url", providerUrl);
		prop.put("java.naming.factory.initial", contextFactory);
		InitialContext ctx = null;
		try {
			ctx = new InitialContext(prop);
			Object sendQuee = ctx.lookup(send_Queue);
			Object recvQuee = ctx.lookup(recv_Queue);

			sendQueue = (Queue) sendQuee;
			recvQueue = (Queue) recvQuee;

			factory = (QueueConnectionFactory) ctx.lookup(connectionFactory);
		} catch (NamingException e) {
			throw new InitializeException(
					"\u4E0D\u80FD\u901A\u8FC7jndi\u67E5\u627E\u961F\u5217", e);
		} finally {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e) {
				}
			}
		}
		return;
	}

}
