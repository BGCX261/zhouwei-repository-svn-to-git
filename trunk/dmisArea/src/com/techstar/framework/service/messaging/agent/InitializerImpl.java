package com.techstar.framework.service.messaging.agent;

import com.techstar.framework.service.messaging.engine.*;

/**
 * ����ʵ�ֳ�ʼ��
 * 
 * @author yangjun
 * 
 */
public class InitializerImpl extends Initializer {

	public InitializerImpl() {
	}

	protected void initialize() throws InitializeException {
		if (!Resources.initialized()) {
			Resources.initialize();
		}
	}

	/**
	 * add by caojian 2007-04-13
	 * 
	 * @param from
	 * @param to
	 * @throws InitializeException
	 */
	public void initialize(String from, String to) throws InitializeException {
		if (!Resources.initialized()) {
			Resources.initialize(from, to);
		}
	}
}
