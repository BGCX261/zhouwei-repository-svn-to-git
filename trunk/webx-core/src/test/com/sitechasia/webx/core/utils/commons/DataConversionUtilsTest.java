package com.sitechasia.webx.core.utils.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.sitechasia.webx.core.exception.FrameworkException;
import com.sitechasia.webx.core.utils.commons.DataConversionUtils;

public class DataConversionUtilsTest extends TestCase {

	private static final String TEST_EXCEL_FILE = "data_exchange_test.xls";

	private static final String TEST_PDF_FILE = "data_exchange_test.pdf";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPojos2excelFile() {
		Map titlePojoMap = new HashMap();
		titlePojoMap.put("name", "姓名");
		titlePojoMap.put("age", "年龄");
		List pojos = new ArrayList();
		DataConversionPojo pojo1 = new DataConversionPojo();
		pojo1.setName("单金");
		pojo1.setAge("27");
		pojos.add(0, pojo1);
		DataConversionPojo pojo2 = new DataConversionPojo();
		pojo2.setName("张三");
		pojo2.setAge("15");
		pojos.add(1, pojo2);
		try {
			DataConversionUtils.beans2excelFile(titlePojoMap, pojos, TEST_EXCEL_FILE);
		} catch (FrameworkException frwke) {
			frwke.getMessage();
		}
	}

	public void testExcelFile2pojos() {
		List attrs = new ArrayList();
		attrs.add("age");
		attrs.add("name");
		List pojos = null;
		try {
			pojos = DataConversionUtils.excelFile2beans(attrs, DataConversionPojo.class, TEST_EXCEL_FILE);
		} catch (FrameworkException frwke) {
			frwke.getMessage();
		}
//		for (Iterator i = pojos.iterator(); i.hasNext();) {
//			System.out.println(i.next().toString());
//		}
	}

	public void testPojos2pdf() {
		Map titlePojoMap = new HashMap();
		titlePojoMap.put("name", "姓名");
		titlePojoMap.put("age", "年龄");
		List pojos = new ArrayList();
		DataConversionPojo pojo1 = new DataConversionPojo();
		pojo1.setName("单金");
		pojo1.setAge("27");
		pojos.add(0, pojo1);
		DataConversionPojo pojo2 = new DataConversionPojo();
		pojo2.setName("张三");
		pojo2.setAge("15");
		pojos.add(1, pojo2);
		try {
			DataConversionUtils.beans2pdfFile(titlePojoMap, pojos, TEST_PDF_FILE);
		} catch (FrameworkException frwke) {
			frwke.getMessage();
		}
	}

}
