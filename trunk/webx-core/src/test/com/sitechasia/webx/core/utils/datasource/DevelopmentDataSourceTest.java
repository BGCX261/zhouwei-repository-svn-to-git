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
package com.sitechasia.webx.core.utils.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 开发阶段使用的带有监控信息的数据库连接的测试类
 *
 * @author todd
 * @version 2.0
 * @since JDK1.5
 */
/**
 * @author Administrator
 *
 */
public class DevelopmentDataSourceTest extends TestCase  {

	 DriverManagerDataSource dataSource ;	//原始数据源
	 DevelopmentDataSource devDatasource;	//开发用数据源



	public void setUp() throws Exception {
		super.setUp();

		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:.");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		devDatasource = new DevelopmentDataSource();
		devDatasource.setWrappedDataSource(dataSource);

	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDevDataSource() {
		try {



			DevelopmentConnection conn1 = (DevelopmentConnection) devDatasource.getConnection();

			List<DevelopmentConnection> connections = devDatasource.getConnections();
			assertEquals(1, connections.size());

			for(int i = 0;i < connections.size();++i){
				System.out.println("=====================");
				DevelopmentConnection conn = (DevelopmentConnection) connections.get(i);
				System.out.println(conn.getCreationTime());
				printStack(conn,conn.getStackTraceElenments());
				System.out.println("=====================");
			}

			DevelopmentConnection conn2 = (DevelopmentConnection) devDatasource.getConnection();
			connections = devDatasource.getConnections();
			assertEquals(2, connections.size());
			for(int i = 0;i < connections.size();++i){
				System.out.println("=====================");
				DevelopmentConnection conn = (DevelopmentConnection)connections.get(i);
				System.out.println(conn.getCreationTime());
				printStack(conn,conn.getStackTraceElenments());
				System.out.println("=====================");
			}


			conn1.close();
			connections = devDatasource.getConnections();
			assertEquals(1, connections.size());
			conn2.close();
			connections = devDatasource.getConnections();
			assertEquals(0, connections.size());


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 打印堆栈的信息
	 *　
	 * @author todd
	 * @param stackTraceElenments 堆栈跟踪中的元素
	 * @see
	 */
	private void printStack(Connection connection,StackTraceElement[] stackTraceElenments){
			for(int i = 0;i < stackTraceElenments.length;++i){
				StackTraceElement element = stackTraceElenments[i];
				if(element.toString().indexOf("com.sitechasia.webx") != -1)
					System.out.println("当前的数据源为: " + dataSource.hashCode() + " .当前的连接为: " + connection.hashCode() + " 调用了" + element);
			}
	}


}
