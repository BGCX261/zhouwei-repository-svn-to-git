package com.techstar.framework.service.messaging.client;

import javax.xml.messaging.JAXMException;
import javax.xml.messaging.ProviderConnection;
import javax.xml.messaging.ProviderConnectionFactory;

import com.techstar.framework.service.messaging.engine.Engine;
import com.techstar.framework.service.messaging.engine.EngineContext;
import com.techstar.framework.service.messaging.engine.InitializeException;

/**
 * 
 * @author yangjun
 * 
 */

public class ConnectionFactoryImpl extends ProviderConnectionFactory {

	private static Engine engine = null;

	public ConnectionFactoryImpl() {
	}

	/**
	 * 创建连接 
	 * add by caojian 2007-04-13
	 * The reason is that we can easily change 
	 * the sendqueue or reveivequeue  by the "from" and "to".
	 * 
	 * @param from
	 *            发送方标识
	 * @param to
	 *            接收方标识
	 * @return
	 * @throws JAXMException
	 */
	public ProviderConnection createConnection(String from, String to)
			throws JAXMException {
		if (engine == null) {
			try {
				engine = EngineContext.getEngineInstance(from, to);
			} catch (InitializeException e) {
				throw new JAXMException(e);
			}
		}
		return new ConnectionImpl(engine);
	}

	public ProviderConnection createConnection() throws JAXMException {
		if (engine == null) {
			try {
				engine = EngineContext.getEngineInstance();
			} catch (InitializeException e) {
				throw new JAXMException(e);
			}
		}
		return new ConnectionImpl(engine);
	}

}
