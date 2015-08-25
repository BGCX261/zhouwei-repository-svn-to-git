/**
 * @{#} BaseHibernateDomainDaoTest.java Create on 2008-5-21 下午02:00:46
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.hibernate3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.sitechasia.webx.core.page.Pagination;
import com.sitechasia.webx.core.page.QueryResult;

/**
 * BaseHibernateDomainDao的测试类
 *
 * @author todd
 * @version 1.5
 * @since JDK1.5
 */
public class BaseHibernateDomainDaoTest extends TestCase {

	BaseHibernateDomainDao<UsersDO> dao;
	protected final Logger logger = Logger.getLogger(getClass());

	Connection conn;
	Statement statement;
	Criteria criteria;



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
	 * 测试获取全部对象。
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findAll(int, int)} 的测试方法。
	 */
	public void testFindAll() {
		//测试分页
		QueryResult<UsersDO> result1 = dao.findAll(1,1);

		boolean isPaged1 = result1.isPaged();
		Pagination page1 = result1.getPagination();
		List<UsersDO> list1 = result1.getResults();

		logger.info("分页--->当前的分页情况为:" + isPaged1);
		assertEquals(true,isPaged1);


		logger.info("分页--->当前的页号为:" + page1.getPageNum());
		logger.info("分页--->每页的记录数为:" + page1.getPageSize());
		logger.info("分页--->总页数为:" + page1.getPageCount());
		logger.info("分页--->总的记录数为:" + page1.getRowCount());
		assertEquals(page1.getPageNum(), 1);
		assertEquals(page1.getPageSize(),1);
		assertEquals(page1.getPageCount(),2);
		assertEquals(page1.getRowCount(),2);

		logger.info("分页--->当前的记录数为:" + list1.size());
		assertEquals(list1.size(),1);

		//每页的记录数大于总记录数
		QueryResult<UsersDO> result3 = dao.findAll(5,1);

		boolean isPaged3 = result3.isPaged();
		Pagination page3 = result3.getPagination();
		List<UsersDO> list3 = result3.getResults();

		logger.info("分页3--->当前的分页情况为:" + isPaged3);
		assertEquals(true,isPaged3);


		logger.info("分页3--->当前的页号为:" + page3.getPageNum());
		logger.info("分页3--->每页的记录数为:" + page3.getPageSize());
		logger.info("分页3--->总页数为:" + page3.getPageCount());
		logger.info("分页3--->总的记录数为:" + page3.getRowCount());
		assertEquals(page3.getPageNum(), 1);
		assertEquals(page3.getPageSize(),5);
		assertEquals(page3.getPageCount(),1);
		assertEquals(page3.getRowCount(),2);

		logger.info("分页3--->当前的记录数为:" + list3.size());
		assertEquals(list3.size(),2);



		//当前的页号大于实际的总页数
		QueryResult<UsersDO> result4 = dao.findAll(5,5);

		boolean isPaged4 = result4.isPaged();
		Pagination page4 = result4.getPagination();
		List<UsersDO> list4 = result4.getResults();

		logger.info("分页4--->当前的分页情况为:" + isPaged4);
		assertEquals(true,isPaged4);


		logger.info("分页4--->当前的页号为:" + page4.getPageNum());
		logger.info("分页4--->每页的记录数为:" + page4.getPageSize());
		logger.info("分页4--->总页数为:" + page4.getPageCount());
		logger.info("分页4--->总的记录数为:" + page4.getRowCount());
		assertEquals(page4.getPageNum(), 5);
		assertEquals(page4.getPageSize(),5);
		assertEquals(page4.getPageCount(),1);
		assertEquals(page4.getRowCount(),2);

		logger.info("分页4--->当前的记录数为:" + list4.size());
		assertEquals(list4.size(),0);


		//当前的页号小于第一页
		QueryResult<UsersDO> result5 = dao.findAll(5,-1);

		boolean isPaged5 = result5.isPaged();
		Pagination page5 = result5.getPagination();
		List<UsersDO> list5 = result5.getResults();

		logger.info("分页5--->当前的分页情况为:" + isPaged5);
		assertEquals(false,isPaged5);


		logger.info("分页5--->当前的页号为:" + page5.getPageNum());
		logger.info("分页5--->每页的记录数为:" + page5.getPageSize());
		logger.info("分页5--->总页数为:" + page5.getPageCount());
		logger.info("分页5--->总的记录数为:" + page5.getRowCount());
		assertEquals(page5.getPageNum(), -1);
		assertEquals(page5.getPageSize(),5);
		assertEquals(page5.getPageCount(),1);
		assertEquals(page5.getRowCount(),2);

		logger.info("分页5--->当前的记录数为:" + list5.size());
		assertEquals(list5.size(),2);



		//测试不分页
		QueryResult<UsersDO> result2 = dao.findAll(0,0);

		boolean isPaged2 = result2.isPaged();
		Pagination page2 = result2.getPagination();
		List<UsersDO> list2 = result2.getResults();

		logger.info("不分页--->当前的分页情况为:" + isPaged2);
		assertEquals(false,isPaged2);

		logger.info("不分页--->当前的页号为:" + page2.getPageNum());
		logger.info("不分页--->每页的记录数为:" + page2.getPageSize());
		logger.info("不分页--->总页数为:" + page2.getPageCount());
		logger.info("不分页--->总的记录数为:" + page2.getRowCount());
		assertEquals(page2.getPageNum(), 0);
		assertEquals(page2.getPageSize(),0);
		assertEquals(page2.getPageCount(),0);
		assertEquals(page2.getRowCount(),2);

		logger.info("不分页--->当前的记录数为:" + list2.size());
		assertEquals(list2.size(),2);

	}

	/**
	 * 测试获取全部对象的查询结果类。
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listAll(int, int)} 的测试方法。
	 */
	public void testListAll() {
		List<UsersDO> list = printUser();
		assertEquals(list.size(), 2);
	}

	private List<UsersDO> printUser() {
		List<UsersDO> list = dao.listAll(0, 0);
		for(UsersDO user:list){
			logger.info("当前的编号为: " + user.getUserid() + " 用户为: " + user.getUsername());
		}

		logger.info("当前的记录数为:" + list.size());
		return list;
	}


	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#save(com.sitechasia.webx.core.model.IDomainObject)} 的测试方法。
	 * @throws SQLException
	 */
	public void testSave() throws SQLException {
		UsersDO user = new UsersDO(3,"姚博锋");
		dao.save(user);
		logger.info("\n save方法保存成功");

		printUser();

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#saveOrUpdate(com.sitechasia.webx.core.model.IDomainObject)} 的测试方法。
	 */
	public void testSaveOrUpdate() {
		UsersDO user = new UsersDO();
		user.setUsername("姚遥");
		dao.saveOrUpdate(user);
		UsersDO user2 = new UsersDO(1,"姚博文");
		dao.saveOrUpdate(user2);
		logger.info("\n saveOrUpdate方法保存成功");

		printUser();
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#saveOrUpdateAll(java.util.Collection)} 的测试方法。
	 */
	public void testSaveOrUpdateAll() {
		Collection<UsersDO> collection = new ArrayList<UsersDO>();
		UsersDO user = new UsersDO();
		user.setUsername("a");
		UsersDO user2 = new UsersDO(1,"姚博文");

		collection.add(user);
		collection.add(user2);
		dao.saveOrUpdateAll(collection);
		logger.info("\n saveOrUpdateAll方法保存成功");

		printUser();

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#update(com.sitechasia.webx.core.model.IDomainObject)} 的测试方法。
	 */
	public void testUpdate() {
		UsersDO user2 = new UsersDO(1,"姚博文");
		dao.update(user2);
		logger.info("\n update方法保存成功");

		printUser();
	}



	/**
	 * 测试取得当前实体类的所有记录数
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countAll()} 的测试方法。
	 */
	public void testCountAll() {
		long count = dao.countAll();

		logger.info("当前总的记录数为:" + count);
		assertEquals(count,2);

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#delete(com.sitechasia.webx.core.model.IDomainObject)} 的测试方法。
	 */
	public void testDelete() {
		UsersDO user = new UsersDO(1,"admin");
		dao.delete(user);
		logger.info("\n delete方法操作成功");

		printUser();
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#deleteById(java.io.Serializable)} 的测试方法。
	 */
	public void testDeleteById() {
		dao.deleteById(2);
		logger.info("\n deleteById方法操作成功,删除了编号为2的用户");

		printUser();
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#deleteByIds(java.io.Serializable[])} 的测试方法。
	 */
	public void testDeleteByIds() {
		dao.deleteByIds(new Integer[]{1,2});
		logger.info("\n deleteByIds方法操作成功,删除了编号为1,2的用户");

		printUser();
	}


	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByField(java.lang.String, java.lang.Object, int, int)} 的测试方法。
	 */
	public void testFindByField() {
		String field = "username";
		String value = "admin";
		QueryResult<UsersDO> result = dao.findByField(field, value, 0, 0);

		boolean isPaged6 = result.isPaged();
		Pagination page6 = result.getPagination();
		List<UsersDO> list = result.getResults();


		logger.info("不分页6--->当前的分页情况为:" + isPaged6);
		assertEquals(false,isPaged6);


		logger.info("不分页6--->当前的页号为:" + page6.getPageNum());
		logger.info("不分页6--->每页的记录数为:" + page6.getPageSize());
		logger.info("不分页6--->总页数为:" + page6.getPageCount());
		logger.info("不分页6--->总的记录数为:" + page6.getRowCount());
		assertEquals(page6.getPageNum(), 0);
		assertEquals(page6.getPageSize(),0);
		assertEquals(page6.getPageCount(),0);
		assertEquals(page6.getRowCount(),1);

		logger.info("不分页6--->当前的记录数为:" + list.size());
		UsersDO user = (UsersDO)list.get(0);
		logger.info("当前的编号为: " + user.getUserid() + " 用户为: " + user.getUsername());
		assertEquals(list.size(),1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByFieldLike(java.lang.String, java.lang.String, int, int)} 的测试方法。
	 */
	public void testFindByFieldLike() {
		String field = "username";
		String value = "ad";
		QueryResult<UsersDO> result = dao.findByFieldLike(field, value, 0, 0);

		boolean isPaged7 = result.isPaged();
		Pagination page7 = result.getPagination();
		List<UsersDO> list = result.getResults();


		logger.info("不分页7--->当前的不分页情况为:" + isPaged7);
		assertEquals(false,isPaged7);


		logger.info("不分页7--->当前的页号为:" + page7.getPageNum());
		logger.info("不分页7--->每页的记录数为:" + page7.getPageSize());
		logger.info("不分页7--->总页数为:" + page7.getPageCount());
		logger.info("不分页7--->总的记录数为:" + page7.getRowCount());
		assertEquals(page7.getPageNum(), 0);
		assertEquals(page7.getPageSize(),0);
		assertEquals(page7.getPageCount(),0);
		assertEquals(page7.getRowCount(),1);

		logger.info("不分页7--->当前的记录数为:" + list.size());
		UsersDO user = (UsersDO)list.get(0);
		logger.info("当前的编号为: " + user.getUserid() + " 用户为: " + user.getUsername());
		assertEquals(list.size(),1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByFields(java.lang.String[], java.lang.Object[], int, int)} 的测试方法。
	 */
	public void testFindByFields() {
		logger.info("***********************开始测试findByFields方法*******************************");
		String[] fields = new String[]{"userid","username"};
		Object[] values = new Object[]{1,"admin"};
		QueryResult<UsersDO> result = dao.findByFields(fields, values, 0, 0);

		boolean isPaged8 = result.isPaged();
		Pagination page8 = result.getPagination();
		List<UsersDO> list = result.getResults();


		logger.info("不分页8--->当前的不分页情况为:" + isPaged8);
		assertEquals(false,isPaged8);


		logger.info("不分页8--->当前的页号为:" + page8.getPageNum());
		logger.info("不分页8--->每页的记录数为:" + page8.getPageSize());
		logger.info("不分页8--->总页数为:" + page8.getPageCount());
		logger.info("不分页8--->总的记录数为:" + page8.getRowCount());
		assertEquals(page8.getPageNum(), 0);
		assertEquals(page8.getPageSize(),0);
		assertEquals(page8.getPageCount(),0);
		assertEquals(page8.getRowCount(),1);

		logger.info("不分页8--->当前的记录数为:" + list.size());
		UsersDO user = (UsersDO)list.get(0);
		logger.info("当前的编号为: " + user.getUserid() + " 用户为: " + user.getUsername());
		assertEquals(list.size(),1);


		fields = new String[]{"userid","username"};
		values = new Object[]{1,"adm"};
		result = dao.findByFields(fields, values, 0, 0);

		boolean isPaged9 = result.isPaged();
		Pagination page9 = result.getPagination();
		list = result.getResults();


		logger.info("不分页9--->当前的不分页情况为:" + isPaged9);
		assertEquals(false,isPaged9);


		logger.info("不分页9--->当前的页号为:" + page9.getPageNum());
		logger.info("不分页9--->每页的记录数为:" + page9.getPageSize());
		logger.info("不分页9--->总页数为:" + page9.getPageCount());
		logger.info("不分页9--->总的记录数为:" + page9.getRowCount());
		assertEquals(page9.getPageNum(), 0);
		assertEquals(page9.getPageSize(),0);
		assertEquals(page9.getPageCount(),0);
		assertEquals(page9.getRowCount(),0);

		logger.info("不分页9--->当前的记录数为:" + list.size());

		assertEquals(list.size(),0);
		logger.info("*************************测试findByFields方法结束********************************");
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByFieldsLike(java.lang.String[], java.lang.String[], int, int)} 的测试方法。
	 */
	public void testFindByFieldsLike() {
		logger.info("***********************开始测试findByFieldsLike方法*******************************");
		String[] fields = new String[]{"username","username"};
		String[] values = new String[]{"ad","in"};
		QueryResult<UsersDO> result = dao.findByFieldsLike(fields, values, 0, 0);

		boolean isPaged10 = result.isPaged();
		Pagination page10 = result.getPagination();
		List<UsersDO> list = result.getResults();


		logger.info("不分页10--->当前的不分页情况为:" + isPaged10);
		assertEquals(false,isPaged10);


		logger.info("不分页10--->当前的页号为:" + page10.getPageNum());
		logger.info("不分页10--->每页的记录数为:" + page10.getPageSize());
		logger.info("不分页10--->总页数为:" + page10.getPageCount());
		logger.info("不分页10--->总的记录数为:" + page10.getRowCount());
		assertEquals(page10.getPageNum(), 0);
		assertEquals(page10.getPageSize(),0);
		assertEquals(page10.getPageCount(),0);
		assertEquals(page10.getRowCount(),1);

		logger.info("不分页10--->当前的记录数为:" + list.size());
		UsersDO user = (UsersDO)list.get(0);
		logger.info("当前的编号为: " + user.getUserid() + " 用户为: " + user.getUsername());
		assertEquals(list.size(),1);


		fields = new String[]{"username"};
		values = new String[]{"ma"};
		result = dao.findByFieldsLike(fields, values, 0, 0);

		boolean isPaged11 = result.isPaged();
		Pagination page11 = result.getPagination();
		list = result.getResults();


		logger.info("不分页11--->当前的不分页情况为:" + isPaged11);
		assertEquals(false,isPaged11);


		logger.info("不分页11--->当前的页号为:" + page11.getPageNum());
		logger.info("不分页11--->每页的记录数为:" + page11.getPageSize());
		logger.info("不分页11--->总页数为:" + page11.getPageCount());
		logger.info("不分页11--->总的记录数为:" + page11.getRowCount());
		assertEquals(page11.getPageNum(), 0);
		assertEquals(page11.getPageSize(),0);
		assertEquals(page11.getPageCount(),0);
		assertEquals(page11.getRowCount(),0);

		logger.info("不分页11--->当前的记录数为:" + list.size());

		assertEquals(list.size(),0);
		logger.info("*************************测试findByFieldsLike方法结束********************************");
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findById(java.io.Serializable)} 的测试方法。
	 */
	public void testFindById() {
		logger.info("*************************测试findById方法开始********************************");
		UsersDO user = dao.get(2);
		assertEquals(user.getUserid(),new Integer(2));

		logger.info("查询到的结果编号为: " + user.getUserid() + " 姓名为 : " + user.getUsername());
		logger.info("\n findById方法操作成功");

		logger.info("*************************测试findById方法结束********************************");
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByQL(java.lang.String, int, int, java.lang.Object[])} 的测试方法。
	 */
	public void testFindByQL() {
		logger.info("*************************测试findByQL方法结束********************************");
		String hql = "from UsersDO where username=?";
		QueryResult<UsersDO> result = dao.findByQL(hql, 0, 0,"todd");

		boolean isPaged12 = result.isPaged();
		Pagination page12 = result.getPagination();
		List<UsersDO> list = result.getResults();


		logger.info("不分页12--->当前的不分页情况为:" + isPaged12);
		assertEquals(false,isPaged12);


		logger.info("不分页12--->当前的页号为:" + page12.getPageNum());
		logger.info("不分页12--->每页的记录数为:" + page12.getPageSize());
		logger.info("不分页12--->总页数为:" + page12.getPageCount());
		logger.info("不分页12--->总的记录数为:" + page12.getRowCount());
		assertEquals(page12.getPageNum(), 0);
		assertEquals(page12.getPageSize(),0);
		assertEquals(page12.getPageCount(),0);
		assertEquals(page12.getRowCount(),1);

		logger.info("不分页12--->当前的记录数为:" + list.size());
		for(UsersDO user:list){
			logger.info("当前的编号为: " + user.getUserid() + " 用户为: " + user.getUsername());
		}
		assertEquals(list.size(),1);
		logger.info("*************************测试findByQL方法结束********************************");
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#isExist(com.sitechasia.webx.core.model.IDomainObject, java.lang.String)} 的测试方法。
	 * @throws Exception
	 */
	public void testIsExist(){
		this.printUser();
		UsersDO user = dao.get(1);
		boolean isexist = dao.isExist(user,"username");
		assertEquals(isexist,false);
		logger.info("编号为1用户名为adm的用户按照编号进行判断是否存在结果为: " + isexist);

		UsersDO user1 = new UsersDO();
		user1.setUsername("alang");
		isexist = dao.isExist(user1,"username");
		assertEquals(isexist,false);
		logger.info("编号为3用户名为alang的用户按照编号和姓名进行判断是否存在结果为: " + isexist);

		UsersDO user2 = new UsersDO();
		user2.setUsername("admin");
		isexist = dao.isExist(user2,"username");
		assertEquals(isexist,true);
		logger.info("编号为3用户名为alang的用户按照编号和姓名进行判断是否存在结果为: " + isexist);

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByField(java.lang.String, java.lang.Object, int, int)} 的测试方法。
	 *
	 */
	public void testListByField() {
		String field = "username";
		String value = "admin";
		List<UsersDO> list = dao.listByField(field, value, 0, 0);
		assertEquals(list.size(),1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByFieldLike(java.lang.String, java.lang.String, int, int)} 的测试方法。
	 *
	 */
	public void testListByFieldLike() {
		String field = "username";
		String value = "ad";
		List<UsersDO> list = dao.listByFieldLike(field, value, 0, 0);
		assertEquals(list.size(),1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByFields(java.lang.String[], java.lang.Object[], int, int)} 的测试方法。
	 *
	 */
	public void testListByFields() {
		String[] fields = new String[]{"userid","username"};
		Object[] values = new Object[]{1,"admin"};
		List<UsersDO> list = dao.listByFields(fields, values, 0, 0);
		assertEquals(list.size(),1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByFieldsLike(java.lang.String[], java.lang.String[], int, int)} 的测试方法。
	 *
	 */
	public void testListByFieldsLike() {
		String[] fields = new String[]{"username","username"};
		String[] values = new String[]{"ad","in"};
		List<UsersDO> list = dao.listByFieldsLike(fields, values, 0, 0);
		assertEquals(list.size(),1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByQL(java.lang.String, int, int, java.lang.Object[])} 的测试方法。
	 *
	 */
	public void testListByQL() {
		//测试ehcache
		logger.info("*************第一次查询开始**************");
		List<UsersDO> users = dao.listByQL("from UsersDO", 0, 0);
		logger.info("*************第一次查询结束"+users.size()+"**************");
		logger.info("*************第二次查询开始**************");
		users = dao.listByQL("from UsersDO", 0, 0);
		logger.info("*************第二次查询结束"+users.size()+"**************");

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByField(java.lang.String, java.lang.Object)} 的测试方法。
	 *
	 */
	public void testCountByField() {
		String field = "username";
		String value = "admin";
		long count = dao.countByField(field, value);
		assertEquals(1,count);

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByFieldLike(java.lang.String, java.lang.String)} 的测试方法。
	 *
	 */
	public void testCountByFieldLike() {
		String field = "username";
		String value = "ad";
		long count = dao.countByFieldLike(field, value);
		assertEquals(1,count);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByFields(java.lang.String[], java.lang.Object[])} 的测试方法。
	 * 因为findByFields方法中实现了此方法的操作,所以不再作测试,可以参考testFindByFields测试方法
	 */
	public void testCountByFields() {
		String[] fields = new String[]{"username","userid"};
		Object[] values = new Object[]{"admin",1};
		long count = dao.countByFields(fields, values);
		assertEquals(1,count);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByFieldsLike(java.lang.String[], java.lang.String[])} 的测试方法。
	 *
	 */
	public void testCountByFieldsLike() {
		String[] fields = new String[]{"username","useremail"};
		String[] values = new String[]{"ad","ctdos"};
		long count = dao.countByFieldsLike(fields, values);
		assertEquals(0,count);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByQl(java.lang.String, java.lang.Object[])} 的测试方法。
	 *
	 */
	public void testCountByQl() {
		String hql = "from UsersDO where username=?";
		long count = dao.countByQl(hql, "todd");
		assertEquals(1,count);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByCriteria(org.hibernate.Criteria)} 的测试方法。
	 *
	 */
	public void testCountByCriteria() {
		//criteria.add(Restrictions.eq("username","todd"));
		long count = dao.countByCriteria(criteria);
		assertEquals(2,count);

	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByCriteria(org.hibernate.Criteria, int, int)} 的测试方法。
	 */
	public void testListByCriteria() {
		criteria.add(Restrictions.eq("username","todd"));
		List<UsersDO> list = dao.listByCriteria(criteria,0,0);
		assertEquals(1,list.size());
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByCriteria(org.hibernate.Criteria, int, int)} 的测试方法。
	 */
	public void testFindByCriteria() {
		QueryResult<UsersDO> result2 = dao.findByCriteria(criteria, 0, 0);



		boolean isPaged2 = result2.isPaged();
		Pagination page2 = result2.getPagination();
		List<UsersDO> list2 = result2.getResults();

		logger.info("不分页--->当前的分页情况为:" + isPaged2);
		assertEquals(false,isPaged2);

		logger.info("不分页--->当前的页号为:" + page2.getPageNum());
		logger.info("不分页--->每页的记录数为:" + page2.getPageSize());
		logger.info("不分页--->总页数为:" + page2.getPageCount());
		logger.info("不分页--->总的记录数为:" + page2.getRowCount());
		assertEquals(page2.getPageNum(), 0);
		assertEquals(page2.getPageSize(),0);
		assertEquals(page2.getPageCount(),0);
		assertEquals(page2.getRowCount(),2);

		logger.info("不分页--->当前的记录数为:" + list2.size());
		assertEquals(list2.size(),2);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#countByDetachedCriteria(org.hibernate.criterion.DetachedCriteria)} 的测试方法。
	 */
	public void testCountByDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UsersDO.class);
		detachedCriteria.add(Restrictions.or(Restrictions.eq("username","todd"),Restrictions.eq("username", "admin")));

		long count = dao.countByDetachedCriteria(detachedCriteria);
		assertEquals(count,2);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#listByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, int, int)} 的测试方法。
	 */
	public void testListByDetachedCriteria() {
		DetachedCriteria detachedCriteria = dao.getDetachedCriteria();
		//detachedCriteria.add(Restrictions.or(Restrictions.eq("username","todd"),Restrictions.eq("username", "admin")));
		detachedCriteria.add(Property.forName("username").eq("todd"));

		List<UsersDO> users = dao.listByDetachedCriteria(detachedCriteria, 0, 0);
		assertEquals(users.size(), 1);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#findByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, int, int)} 的测试方法。
	 */
	public void testFindByDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UsersDO.class);
		detachedCriteria.add(Restrictions.or(Restrictions.eq("username","todd"),Restrictions.eq("username", "admin")));
		//.createAlias("employees", "e").add(Restrictions.gt(("e.age"), new Integer(20)));;
//		detachedCriteria.add(Property.forName("sex").eq('F'));

		QueryResult<UsersDO> result2 = dao.findByDetachedCriteria(detachedCriteria, 0, 0);



		boolean isPaged2 = result2.isPaged();
		Pagination page2 = result2.getPagination();
		List<UsersDO> list2 = result2.getResults();

		logger.info("不分页--->当前的分页情况为:" + isPaged2);
		assertEquals(false,isPaged2);

		logger.info("不分页--->当前的页号为:" + page2.getPageNum());
		logger.info("不分页--->每页的记录数为:" + page2.getPageSize());
		logger.info("不分页--->总页数为:" + page2.getPageCount());
		logger.info("不分页--->总的记录数为:" + page2.getRowCount());
		assertEquals(page2.getPageNum(), 0);
		assertEquals(page2.getPageSize(),0);
		assertEquals(page2.getPageCount(),0);
		assertEquals(page2.getRowCount(),2);

		logger.info("不分页--->当前的记录数为:" + list2.size());
		assertEquals(list2.size(),2);
	}

	/**
	 * {@link com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao#load(java.io.Serializable)} 的测试方法。
	 */
	public void testLoad(){
		UsersDO user = dao.load(1);
		assertEquals(user.getUsername(),"admin");
	}

	public void testMerge(){
		UsersDO user = dao.findById(1);		
		UsersDO user2 = dao.merge(user);
		assertEquals(user.getUsername(),user2.getUsername());
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
		pros.put("hibernate.show_sql", "true");
		pros.put("hibernate.cache.use_query_cache", "true");
		pros.put("hibernate.cache.provider_class","org.hibernate.cache.EhCacheProvider");

		lsfb.setHibernateProperties(pros);
		lsfb.afterPropertiesSet();

		SessionFactory sf = (SessionFactory)lsfb.getObject();

		dao = new  BaseHibernateDomainDao<UsersDO>();
		dao.setSessionFactory(sf);

		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sf);

		dao.setHibernateTemplate(hibernateTemplate);
		dao.afterPropertiesSet();
		dao.entityClass=UsersDO.class;

		conn = sf.openSession().connection();

		criteria = sf.openSession().createCriteria(dao.getEntityClass());

		statement=conn.createStatement();
		statement.executeUpdate("CREATE TABLE users(userid INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,username VARCHAR(256),useremail varchar(100))");
		statement.executeUpdate("insert into users values(1,'admin','admin@sohu.com')");
		statement.executeUpdate("insert into users values(2,'todd','todd@ctods.com.cn')");
	}



}
