/**
 * @{#} CommonHibernateDaoTest.java Create on 2008-5-23 下午03:11:50
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.hibernate3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.sitechasia.webx.core.page.Pagination;
import com.sitechasia.webx.core.page.QueryResult;

/**
 * TODO
 * 类说明:
 * @author Administrator
 * @version 1.0
 * @see
 */
/**
 * @author Administrator
 *
 */
public class CommonHibernateDaoTest extends TestCase {

	CommonHibernateDao dao;
	protected final Logger logger = Logger.getLogger(getClass());

	Connection conn;
	Statement statement;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		createConnection();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		statement.execute("drop table users");
		statement.close();
		conn.close();
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.CommonHibernateDao#findByHql(java.lang.String, int, int, java.lang.Object[])} 的测试方法。
	 */
	public void testFindByHql() {
		String hql = "from UsersDO where username=? or username = ?";
		Object[] args = new String[]{"admin","todd"};

		QueryResult<Object> result = dao.findByHql(hql, 0, 0, args);
		boolean isPaged1 = result.isPaged();
		Pagination page1 = result.getPagination();
		List<Object> list1 = result.getResults();

		logger.info("不分页--->当前的不分页情况为:" + isPaged1);
		assertEquals(false,isPaged1);


		logger.info("不分页--->当前的页号为:" + page1.getPageNum());
		logger.info("不分页--->每页的记录数为:" + page1.getPageSize());
		logger.info("不分页--->总页数为:" + page1.getPageCount());
		logger.info("不分页--->总的记录数为:" + page1.getRowCount());
		logger.info("不分页--->当前第一条记录的开始位置为:" + page1.getPageBeginIdx());
		assertEquals(page1.getPageNum(), 0);
		assertEquals(page1.getPageSize(),0);
		assertEquals(page1.getPageCount(),0);
		assertEquals(page1.getRowCount(),8);
		assertEquals(page1.getPageBeginIdx(),1);

		logger.info("不分页--->当前的记录数为:" + list1.size());
		assertEquals(list1.size(),8);


		logger.info("*******************************分页情况测试********************************************");

		result = dao.findByHql(hql, 2, 2, args);

		isPaged1 = result.isPaged();
		page1 = result.getPagination();
		list1 = result.getResults();
		for(Object user:list1){
			System.err.println(((UsersDO)user).getUsername());
		}

		logger.info("分页--->当前的分页情况为:" + isPaged1);
		assertEquals(true,isPaged1);


		logger.info("分页--->当前的页号为:" + page1.getPageNum());
		logger.info("分页--->每页的记录数为:" + page1.getPageSize());
		logger.info("分页--->总页数为:" + page1.getPageCount());
		logger.info("分页--->总的记录数为:" + page1.getRowCount());
		logger.info("分页--->当前第一条记录的开始位置为:" + page1.getPageBeginIdx());
		assertEquals(page1.getPageNum(), 2);
		assertEquals(page1.getPageSize(),2);
		assertEquals(page1.getPageCount(),4);
		assertEquals(page1.getRowCount(),8);
		assertEquals(page1.getPageBeginIdx(),3);

		logger.info("分页--->当前的记录数为:" + list1.size());
		assertEquals(list1.size(),2);
	}

	/**
	 * 初始化数据库连接
	 *　
	 * @throws Exception
	 * @throws SQLException
	 */
	protected void createConnection() throws Exception, SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:.");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		lsfb.setDataSource(dataSource);
		lsfb.setMappingResources(new String[]{"com/sitechasia/webx/core/dao/hibernate3/Users.hbm.xml"});

		Properties pros = new Properties();
		pros.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		pros.put("hibernate.show_sql", "false");
		pros.put("hibernate.cache.use_query_cache", "true");
		pros.put("hibernate.cache.provider_class","org.hibernate.cache.EhCacheProvider");

		lsfb.setHibernateProperties(pros);
		lsfb.afterPropertiesSet();

		SessionFactory sf = (SessionFactory)lsfb.getObject();

		dao = new  CommonHibernateDao();
		dao.setSessionFactory(sf);

		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sf);

		dao.setHibernateTemplate(hibernateTemplate);
		dao.afterPropertiesSet();

		conn = sf.openSession().connection();


		statement=conn.createStatement();
		statement.executeUpdate("CREATE TABLE users(userid INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,username VARCHAR(256),useremail varchar(100))");
		statement.executeUpdate("insert into users values(1,'admin','')");
		statement.executeUpdate("insert into users values(2,'todd','')");
		statement.executeUpdate("insert into users values(3,'admin','')");
		statement.executeUpdate("insert into users values(4,'todd','')");
		statement.executeUpdate("insert into users values(5,'admin','')");
		statement.executeUpdate("insert into users values(6,'todd','')");
		statement.executeUpdate("insert into users values(7,'admin','')");
		statement.executeUpdate("insert into users values(8,'todd','')");
	}



}
