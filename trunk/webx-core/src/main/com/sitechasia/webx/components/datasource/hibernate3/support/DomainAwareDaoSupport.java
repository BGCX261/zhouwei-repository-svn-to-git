/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.components.datasource.hibernate3.support;

import java.util.Hashtable;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sitechasia.webx.components.datasource.context.Domain2DS;
import com.sitechasia.webx.components.datasource.context.DomainContextHolder;
import com.sitechasia.webx.core.exception.SystemException;

/**
 * 多数据源的多SessionFactory实现
 *
 * @author Administrator
 * @version 1.2 , 2008/5/9
 * @since JDK1.5
 */
public class DomainAwareDaoSupport implements BeanFactoryAware {
	private BeanFactory bf;
	// private Log log = LogFactory.getLog(this.getClass());
	private HibernateDaoSupport dao = new DefaultDaoSupport();
	private static Map<String, HibernateTemplate> cache = new Hashtable<String, HibernateTemplate>();

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		bf = arg0;
	}

	protected HibernateTemplate getHibernateTemplate() {
		String _domain = DomainContextHolder.getMyDomain();
		if (!cache.containsKey(_domain)) {
			synchronized (cache) {
				if (!cache.containsKey(_domain)) {
					dao.setSessionFactory(new _C().getObject(_domain, bf));
					cache.put(_domain, dao.getHibernateTemplate());
				}
			}
		}
		return cache.get(_domain);
	}
}

class _C extends LocalSessionFactoryBean {
	private static Map<String, SessionFactory> cache = new Hashtable<String, SessionFactory>();
	private static final Logger logger = Logger.getLogger(_C.class);

	public SessionFactory getObject(String domain, BeanFactory bf) {
		if (!cache.containsKey(domain)) {
			try {
				logger.info("****creating new SessionFactory for " + domain);
				JndiDataSourceLookup dsl = (JndiDataSourceLookup) bf.getBean("ds-lookup");
				String _ds = ((Domain2DS) bf.getBean("Domain2DS")).toDS(domain);
				setDataSource(dsl.getDataSource(_ds));
				setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
				cache.put(domain, buildSessionFactory());
			} catch (Exception ex) {
				throw new SystemException("SessionFactory Creation Exception", ex);
			}
		}
		return cache.get(domain);
	}
}

class DefaultDaoSupport extends HibernateDaoSupport {
}