/**
 * @{#} CustomerJdbcDomainDaoTest.java Create on 2008-5-22 下午01:49:29
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;
import com.sitechasia.webx.core.dao.hibernate3.UsersDO;
import com.sitechasia.webx.core.dao.jdbc.hsqldb.HsqldbPageSqlProvider;
import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.page.QueryResult;

/**
 *
 * 类说明:CustomerJdbcDomainDao类的单元测试
 *
 * @author Sunzhenying
 * @version 1.0
 * @see BaseJdbcDomainDao
 */
public class CustomerJdbcDomainDaoTest extends TestCase {
	protected final Logger logger = Logger.getLogger(getClass());

	CustomerJdbcDomainDao customerJdbcDomainDao ;
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	protected void setUp() throws Exception {
		super.setUp();
		

		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:.");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		//ObjectMapper mapper = new ObjectMapper(Customer.class);
		customerJdbcDomainDao = new  CustomerJdbcDomainDao();
		customerJdbcDomainDao.setDataSource(dataSource);
		customerJdbcDomainDao.setJdbcTemplate(jdbcTemplate);
		//customerJdbcDomainDao.setObjectMapper(mapper);
		customerJdbcDomainDao.setPageSqlProvider(new HsqldbPageSqlProvider());
		
		Connection conn = dataSource.getConnection();

		Statement statement=conn.createStatement();
		statement.executeUpdate("CREATE TABLE CUSTOMER(ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY, " +
								"NAME VARCHAR(256), " +
								"AGE INTEGER, " +
								"MEMO VARCHAR(256))");
		statement.executeUpdate("insert into CUSTOMER values(1,'admin', 30, 'Administrator')");
		statement.executeUpdate("insert into CUSTOMER values(2,'todd', 30, 'chengyun')");
		statement.executeUpdate("insert into CUSTOMER values(3,'markdong', 30, 'dongnan')");
		
		conn.commit();
		conn.close();
		
	}

	protected void tearDown() throws Exception {
		Connection conn = dataSource.getConnection();
		Statement statement=conn.createStatement();
		statement.executeUpdate("DROP TABLE CUSTOMER;");
	}
	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:countAll()
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#countAll()
	 */
	public void testCountAll() {
		long count = customerJdbcDomainDao.countAll();
		assertEquals(3, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:countByField(String field, Object value)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#countByField(String
	 *      field, Object value)
	 */
	public void testCountByField() {
		long count = customerJdbcDomainDao.countByField("name", "markdong");
		assertEquals(1, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:countByField(String field, String value)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#countByFieldLike(String
	 *      field, String value)
	 */

	public void testCountByFieldLike() {
		long count = customerJdbcDomainDao.countByFieldLike("name", "mark");
		assertEquals(1, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:countByFields(String[] fields, Object[]
	 * values)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#countByFields(String[]
	 *      fields, Object[] values)
	 */
	public void testCountByFields() {
		long count = customerJdbcDomainDao.countByFields(new String[] { "name",
				"memo" }, new Object[] { "markdong", "dongnan" });
		assertEquals(1, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:countByFieldsLike(String[] fields, String[]
	 * values)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#countByFieldsLike(String[]
	 *      fields, String[] values)
	 */
	public void testCountByFieldsLike() {
		long count = customerJdbcDomainDao.countByFieldsLike(new String[] {
				"name", "memo" }, new String[] { "mark", "nan" });
		assertEquals(1, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:countByQl(String ql, Object... args)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#countByQl(String
	 *      ql, Object... args)
	 */
	public void testCountByQl() {
		long count = customerJdbcDomainDao.countByQl(
				"select count(*) from customer where name=? and memo=?",
				new String[] { "markdong", "dongnan" });
		assertEquals(1, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:delete(IDomainObject obj)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#delete(IDomainObject
	 *      obj)
	 */
	public void testDelete() {
		long count = customerJdbcDomainDao.countAll();
		assertEquals(3, count);
		customerJdbcDomainDao.delete(new Customer(1, "name", 19, "memo"));
		count = customerJdbcDomainDao.countAll();
		assertEquals(2, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:deleteById(Serializable id)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#deleteByIds(Serializable[]
	 *      ids)
	 */
	public void testDeleteByIds() {
		long count = customerJdbcDomainDao.countAll();
		assertEquals(3, count);
		customerJdbcDomainDao.deleteByIds(new Serializable[] { 1, 3 });
		count = customerJdbcDomainDao.countAll();
		assertEquals(1, count);
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findAll(int pageSize, int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findAll(int
	 *      pageSize, int pageNum)
	 */
	public void testFindAll() {
		QueryResult<Customer> queryResult = customerJdbcDomainDao.findAll(2, 1);
		List<Customer> list = queryResult.getResults();
		assertEquals(2, list.size());
		queryResult = customerJdbcDomainDao.findAll(2, 2);
		list = queryResult.getResults();
		assertEquals(1, list.size());
		queryResult = customerJdbcDomainDao.findAll(2, 3);
		list = queryResult.getResults();
		assertEquals(0, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findByField(String field, Object value, int
	 * pageSize,int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findById(Serializable
	 *      id)
	 */
	public void testFindByField() {
		QueryResult<Customer> queryResult = customerJdbcDomainDao.findByField(
				"name", "markdong", 3, 1);
		List list = queryResult.getResults();
		assertEquals(1, list.size());
		queryResult = customerJdbcDomainDao.findByField(
				"name", "aaa", 3, 1);
		list = queryResult.getResults();
		assertEquals(0, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findByFieldLike(String field, String
	 * value,int pageSize, int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findByFieldLike(String
	 *      field, String value,int pageSize, int pageNum)
	 */
	public void testFindByFieldLike() {
		QueryResult<Customer> queryResult = customerJdbcDomainDao
				.findByFieldLike("name", "dong", 3, 1);
		List list = queryResult.getResults();
		assertEquals(1, list.size());
		queryResult = customerJdbcDomainDao.findByFieldLike("name", "dongdf", 3, 1);
		list = queryResult.getResults();
		assertEquals(0, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findByFields(String[] fields, Object[]
	 * values,int pageSize, int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findByFields(String[]
	 *      fields, Object[] values,int pageSize, int pageNum)
	 */
	public void testFindByFields() {
		QueryResult<Customer> queryResult = customerJdbcDomainDao.findByFields(
				new String[] { "name", "memo" },
				new Object[] { "markdong", "dongnan" }, 3, 1);
		List list = queryResult.getResults();
		assertEquals(1, list.size());
		queryResult = customerJdbcDomainDao.findByFields(
				new String[] { "name", "memo" },
				new Object[] { "markadfdong", "dongnan" }, 3, 1);
		list = queryResult.getResults();
		assertEquals(0, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findByFieldsLike(String[] fields, String[]
	 * values,int pageSize, int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findByFieldsLike(String[]
	 *      fields, String[] values,int pageSize, int pageNum)
	 */
	public void testFindByFieldsLike() {
		QueryResult<Customer> queryResult = customerJdbcDomainDao
				.findByFieldsLike(new String[] { "name", "memo" },
						new String[] { "mark", "nan" }, 3, 1);
		List list = queryResult.getResults();
		assertEquals(1, list.size());
		queryResult = customerJdbcDomainDao.findByFieldsLike(new String[] { "name", "memo" },
				new String[] { "mark", "nanasdf" }, 3, 1);
		list = queryResult.getResults();
		assertEquals(0, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findById(Serializable id)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findById(Serializable
	 *      id)
	 */
	public void testFindById() {
		Customer customer = (Customer) customerJdbcDomainDao.get(3);
		assertEquals("markdong", customer.getName());
		assertEquals("dongnan", customer.getMemo());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:findByQL(String ql, int pageSize, int
	 * pageNum,Object... args)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#findById(Serializable
	 *      id)
	 */
	public void testFindByQL() {
		QueryResult queryResult = customerJdbcDomainDao.findByQL(
				"select * from customer where name=?", 3, 1,
				new Object[] { "markdong" });
		List list = queryResult.getResults();
		assertEquals(1, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:isExist(IDomainObject obj, String fields)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#
	 */
	public void testIsExist() {
		logger.info("");
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:listAll(int pageSize, int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#listAll(int
	 *      pageSize, int pageNum)
	 */
	public void testListAll() {
		List list = customerJdbcDomainDao.listAll(5, 1);
		assertEquals(3, list.size());
		list = customerJdbcDomainDao.listAll(5, 2);
		assertEquals(0, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:listByField(String field, Object value, int
	 * pageSize,int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#listByField(String
	 *      field, Object value, int pageSize,int pageNum)
	 */
	public void testListByField() {
		List list = customerJdbcDomainDao.listByField("name", "markdong", 3, 1);
		assertEquals(1, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:listByFieldLike(String field, String value,
	 * int pageSize,int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#listByFieldLike(String
	 *      field, String value, int pageSize,int pageNum)
	 */
	public void testListByFieldLike() {
		List list = customerJdbcDomainDao.listByFieldLike("name", "don", 3, 1);
		assertEquals(1, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:listByFields(String[] fields, Object[]
	 * values, int pageSize,int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#listByFields(String[]
	 *      fields, Object[] values, int pageSize,int pageNum)
	 */
	public void testListByFields() {
		List list = customerJdbcDomainDao.listByFields(new String[] { "name",
				"memo" }, new Object[] { "markdong", "dongnan" }, 3, 1);
		assertEquals(1, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:listByFieldsLike(String[] fields, String[]
	 * values,int pageSize, int pageNum)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#listByFieldsLike(String[]
	 *      fields, String[] values,int pageSize, int pageNum)
	 */
	public void testListByFieldsLike() {
		List list = customerJdbcDomainDao.listByFieldsLike(new String[] {
				"name", "memo" }, new String[] { "don", "nan" }, 3, 1);
		assertEquals(1, list.size());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:listByQL(String ql, int pageSize, int
	 * pageNum,Object... args)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#listByQL(String
	 *      ql, int pageSize, int pageNum,Object... args)
	 */
	public void testListByQL() {
		List list = customerJdbcDomainDao.listByQL(
				"select * from customer where name=? and memo=?", 3, 1,
				new String[] { "markdong", "dongnan" });
		assertEquals(1, list.size());
		
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:save(IDomainObject obj)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#save(IDomainObject
	 *      obj)
	 */
	public void testSave() {
		Customer customer = new Customer(15, "name15", 19, "memo19");
		customerJdbcDomainDao.save(customer);
		Customer newCustomer = (Customer) customerJdbcDomainDao.get(15);
		assertEquals("name15", newCustomer.getName());
		assertEquals(19, newCustomer.getAge());
		assertEquals("memo19", newCustomer.getMemo());
	}

	/**
	 *
	 * 方法说明：测试类BaseJdbcDomainDao的方法:saveOrUpdate(IDomainObject obj)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#saveOrUpdate(IDomainObject
	 *      obj)
	 */
	public void testSaveOrUpdate() {
		Customer customer = new Customer(15, "name15", 19, "memo19");
		customerJdbcDomainDao.save(customer);
		Customer newCustomer = (Customer) customerJdbcDomainDao.get(15);
		assertEquals("name15", newCustomer.getName());
		assertEquals(19, newCustomer.getAge());
		assertEquals("memo19", newCustomer.getMemo());
		newCustomer.setAge(20);
		newCustomer.setMemo("memo20");
		customerJdbcDomainDao.saveOrUpdate(newCustomer);

		Customer newCustomer2 = (Customer) customerJdbcDomainDao.get(15);
		assertEquals("name15", newCustomer2.getName());
		assertEquals(20, newCustomer2.getAge());
		assertEquals("memo20", newCustomer2.getMemo());
		
	}

	/**
	 * 方法说明：测试类BaseJdbcDomainDao的方法:saveOrUpdateAll(Collection<D> objs)
	 *
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#saveOrUpdateAll(Collection<D>
	 *      objs)
	 */
	public void testSaveOrUpdateAll() {
		ArrayList list = new ArrayList();
		list.add(new Customer(16, "name16", 18, "memo16"));
		list.add(new Customer(17, "name17", 18, "memo17"));
		customerJdbcDomainDao.saveOrUpdateAll(list);
		Customer customer1 = customerJdbcDomainDao.get(16);
		Customer customer2 = customerJdbcDomainDao.get(17);
		
		assertEquals("name16", customer1.getName());
		assertEquals(18, customer1.getAge());
		assertEquals("memo16", customer1.getMemo());
		assertEquals("name17", customer2.getName());
		assertEquals(18, customer2.getAge());
		assertEquals("memo17", customer2.getMemo());
		
	}

	/**
	 *　
	 * 方法说明：测试类BaseJdbcDomainDao的方法:update(IDomainObject obj)
	 * @author Sunzhenying
	 * @see com.sitechasia.webx.core.dao.jdbc.BaseJdbcDomainDao#update(IDomainObject obj)
	 */
	public void testUpdate() {
		Customer customer = new Customer(15, "name15", 19, "memo19");
		customerJdbcDomainDao.save(customer);
		Customer newCustomer = (Customer) customerJdbcDomainDao.get(15);
		assertEquals("name15", newCustomer.getName());
		assertEquals(19, newCustomer.getAge());
		assertEquals("memo19", newCustomer.getMemo());
		newCustomer.setAge(20);
		newCustomer.setMemo("memo20");
		customerJdbcDomainDao.update(newCustomer);

		Customer newCustomer2 = (Customer) customerJdbcDomainDao.get(15);
		assertEquals("name15", newCustomer2.getName());
		assertEquals(20, newCustomer2.getAge());
		assertEquals("memo20", newCustomer2.getMemo());
	}
}