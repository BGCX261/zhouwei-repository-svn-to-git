package com.sitechasia.webx.core.utils.dozer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class DozerConvertUtilImleTest extends TestCase {

	DozerConvertUtil dozerConvertUtil = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String[] resource = { "com/sitechasia/webx/core/utils/dozer/applicationContext.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		dozerConvertUtil = (DozerConvertUtil) ctx.getBean("dozerConvertUtil");
	}

	public void testDomainObjectToViewObject() {
		MyDO myDO = new MyDO();
		myDO.setField1("1");
		myDO.setFieldA("A");

		MyVO myVO = new MyVO();

		dozerConvertUtil.domainObjectToViewObject(myDO, myVO);

		assertEquals(1, myVO.getField1());
		assertEquals("A", myVO.getFieldB());
	}

	public void testDomainObjectsToViewObjects() {
		MyDO myDO = new MyDO();
		myDO.setField1("1");
		myDO.setFieldA("A");

		List myDO_list = new ArrayList();

		myDO_list.add(myDO);

		List myVO_list = dozerConvertUtil.domainObjectsToViewObjects(myDO_list,
				MyVO.class);

		MyVO myVO = (MyVO) myVO_list.get(0);

		assertEquals(1, myVO.getField1());
		assertEquals("A", myVO.getFieldB());
	}

	public void testViewObjectToDomainObject() {
		MyDO myDO = new MyDO();

		MyVO myVO = new MyVO();
		myVO.setField1(1);
		myVO.setFieldB("A");
		dozerConvertUtil.viewObjectToDomainObject(myVO, myDO);

		assertEquals("1", myDO.getField1());
		assertEquals("A", myDO.getFieldA());
	}

	public void testViewObjectsToDomainObjects() {
		MyVO myVO = new MyVO();
		myVO.setField1(1);
		myVO.setFieldB("A");

		List myVO_list = new ArrayList();

		myVO_list.add(myVO);

		List myDO_list = dozerConvertUtil.viewObjectsToDomainObjects(myVO_list,
				MyDO.class);

		MyDO myDO = (MyDO) myDO_list.get(0);

		assertEquals("1", myDO.getField1());
		assertEquals("A", myDO.getFieldA());
	}

}
