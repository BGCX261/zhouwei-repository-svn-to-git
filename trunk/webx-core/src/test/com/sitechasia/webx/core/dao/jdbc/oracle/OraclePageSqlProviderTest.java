package com.sitechasia.webx.core.dao.jdbc.oracle;

import junit.framework.TestCase;
import com.sitechasia.webx.core.dao.jdbc.oracle.OraclePageSqlProvider;

/**
 *
 * Oracle分页
 *
 */
public class OraclePageSqlProviderTest extends TestCase {

	OraclePageSqlProvider oraclepage;
	
	public void setUp(){
	oraclepage=new OraclePageSqlProvider();
	}

public void tearDown() throws Exception{
	super.tearDown();
}

public void testgetPageSql(){
	assertEquals("SELECT * FROM(SELECT rownum as rid,A.* FROM( select top 10 from user) A)WHERE rid >=2 AND rid<8",oraclepage.getPageSql("select top 10 from user", 2,5));
	assertEquals("select top 10 from user",oraclepage.getPageSql("select top 10 from user", -2,0));
}
}