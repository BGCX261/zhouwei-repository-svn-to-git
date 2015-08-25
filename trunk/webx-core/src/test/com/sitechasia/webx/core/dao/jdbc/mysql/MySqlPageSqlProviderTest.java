package com.sitechasia.webx.core.dao.jdbc.mysql;

import junit.framework.TestCase;

public class MySqlPageSqlProviderTest extends TestCase {
	MySqlPageSqlProvider mysqlpage;
	public void setUp(){
		mysqlpage=new MySqlPageSqlProvider();
	}

	public void tearDown() throws Exception{
		super.tearDown();
	}

	public void testgetPageSql(){
		assertEquals("select top 10 from user limit 0,5",mysqlpage.getPageSql("select top 10 from user", 0,5));
		assertEquals("select top 10 from user",mysqlpage.getPageSql("select top 10 from user", -2,0));
	}
}
