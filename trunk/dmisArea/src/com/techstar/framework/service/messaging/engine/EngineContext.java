package com.techstar.framework.service.messaging.engine;

import java.util.Properties;

import com.techstar.framework.service.messaging.agent.InitializerImpl;

/**
 * 
 * @author yangjun
 * 
 */
public class EngineContext {

	private static Engine engineInstance = null;

	private Class sender;

	private Class receiver;

	private Class router;

	private Class initializer;

	public static Engine getEngineInstance() throws InitializeException {
		if (engineInstance == null) {
			EngineContext context = new EngineContext();
			Properties prop = loadConfig();
			context.config(prop);
			context.init();
			engineInstance = new Engine(context);
		}
		return engineInstance;
	}

	/**
	 * add by caojian 2007-04-13 
	 * The reason you can see
	 * ConnectionFactoryImpl.createConnection(from,to);
	 * 
	 * @param from
	 * @param to
	 * @return
	 * @throws InitializeException
	 */
	public static Engine getEngineInstance(String from, String to)
			throws InitializeException {
		if (engineInstance == null) {
			EngineContext context = new EngineContext();
			Properties prop = loadConfig();
			context.config(prop);
			context.init(from, to);
			engineInstance = new Engine(context);
		}
		return engineInstance;
	}

	private static Properties loadConfig() throws InitializeException {
		try {
			// File file = new
			// File("D:\\soft\\tomcat5.0.28\\webapps\\soapjms\\WEB-INF\\classes\\engine.properties");
			// System.out.println("system
			// get"+ClassLoader.getSystemClassLoader());
			// java.io.InputStream propFile =
			// ClassLoader.getSystemResourceAsStream("engine.properties");
			Properties prop = new Properties();
			prop
					.setProperty("sender",
							"com.techstar.framework.service.messaging.agent.SenderImpl");
			prop
					.setProperty("receiver",
							"com.techstar.framework.service.messaging.agent.ReceiverImpl");
			prop
					.setProperty("router",
							"com.techstar.framework.service.messaging.agent.RouterImpl");
			prop
					.setProperty("initializer",
							"com.techstar.framework.service.messaging.agent.InitializerImpl");
			// prop.load(propFile);
			return prop;
		} catch (Exception e) {
			throw new InitializeException(
					"\u8BFB\u53D6\u914D\u7F6E\u6587\u4EF6engine.properties\u5931\u8D25",
					e);
		}
	}

	private EngineContext() {
		sender = null;
		receiver = null;
		router = null;
		initializer = null;
	}

	protected Sender createSender() {
		try {
			return (Sender) sender.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Receiver createReceiver() {
		try {
			return (Receiver) receiver.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Router createRouter() {
		try {
			return (Router) router.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void config(Properties properties) throws InitializeException {
		try {
			if (properties.getProperty("sender") != null) {
				sender = Class.forName(properties.getProperty("sender"));
			}
			if (properties.getProperty("receiver") != null) {
				receiver = Class.forName(properties.getProperty("receiver"));
			}
			if (properties.getProperty("router") != null) {
				router = Class.forName(properties.getProperty("router"));
			}
			if (properties.getProperty("initializer") != null) {
				initializer = Class.forName(properties
						.getProperty("initializer"));
			}
		} catch (ClassNotFoundException e) {
			throw new InitializeException(
					"\u914D\u7F6E\u9519\u8BEF\uFF0C\u8BF7\u68C0\u67E5\u914D\u7F6E\u6587\u4EF6engine.p"
							+ "roperties", e);
		}
	}

	private void init() throws InitializeException {
		Initializer initializer = null;
		try {
			initializer = (Initializer) this.initializer.newInstance();
		} catch (InstantiationException e) {
			throw new InitializeException(e);
		} catch (IllegalAccessException e) {
			throw new InitializeException(e);
		}
		initializer.initialize();
	}
	
	/**
	 * add by caojian 2007-04-13
	 * @param from
	 * @param to
	 * @throws InitializeException
	 */
	private void init(String from, String to) throws InitializeException {
		InitializerImpl initializer = new InitializerImpl();
		initializer.initialize(from, to);
	}
}