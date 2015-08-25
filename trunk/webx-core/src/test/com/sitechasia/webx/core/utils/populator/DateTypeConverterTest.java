package com.sitechasia.webx.core.utils.populator;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.sitechasia.webx.core.utils.populator.DateTypeConverter;

import junit.framework.TestCase;

/**
 * <p>Title: DateTypeConverterTest</p>
 * <p>Description:DateTypeConverter单元测试类 </p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class DateTypeConverterTest extends TestCase {

	DateTypeConverter converter;
	public void setUp() throws Exception{
		super.setUp();
		converter = new DateTypeConverter();
	}
	
	public void tearDown() throws Exception{
		super.tearDown();
		converter=null;
	}
	
	public void testString2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Object result1 = converter.convertValue("1999-9-9", Long.class);
		assertTrue(result1 instanceof Long);
		assertEquals(dateFormat.parse("1999-9-9").getTime(), result1);

		Object result2 = converter.convertValue("1999-9-9", Date.class);
		assertTrue(result2 instanceof Date);
		assertEquals(dateFormat.parse("1999-9-9"), result2);

		Object result3 = converter.convertValue("1999-9-9", java.sql.Date.class);
		assertTrue(result3 instanceof java.sql.Date);
		assertEquals(dateFormat.parse("1999-9-9"), result3);

		Object result4 = converter.convertValue("1999-9-9", Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(dateFormat.parse("1999-9-9"), result4);

		Object result5 = converter.convertValue("1999-9-9", Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(dateFormat.parse("1999-9-9"), result5);

		Object result6 = converter.convertValue("1999-9-9", Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(dateFormat.parse("1999-9-9").getTime(), ((Calendar)result6).getTimeInMillis());
	}

	public void testLong2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = new Date(9999999999L);

		Object result1 = converter.convertValue(9999999999L, String.class);
		assertTrue(result1 instanceof String);
		assertEquals(dateFormat.format(date), result1);

		Object result2 = converter.convertValue(9999999999L, Date.class);
		assertTrue(result2 instanceof Date);
		assertEquals(date, result2);

		Object result3 = converter.convertValue(9999999999L, java.sql.Date.class);
		assertTrue(result3 instanceof java.sql.Date);
		assertEquals(date, result3);

		Object result4 = converter.convertValue(9999999999L, Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(date, result4);

		Object result5 = converter.convertValue(9999999999L, Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(date, result5);

		Object result6 = converter.convertValue(9999999999L, Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(date.getTime(), ((Calendar)result6).getTimeInMillis());
	}

	public void testUtilDate2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = new Date(9999999999L);

		Object result0 = converter.convertValue(date, Long.class);
		assertTrue(result0 instanceof Long);
		assertEquals(date.getTime(), result0);

		Object result1 = converter.convertValue(date, String.class);
		assertTrue(result1 instanceof String);
		assertEquals(dateFormat.format(date), result1);

		Object result3 = converter.convertValue(date, java.sql.Date.class);
		assertTrue(result3 instanceof java.sql.Date);
		assertEquals(date, result3);

		Object result4 = converter.convertValue(date, Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(date, result4);

		Object result5 = converter.convertValue(date, Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(date, result5);

		Object result6 = converter.convertValue(date, Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(date.getTime(), ((Calendar)result6).getTimeInMillis());
	}

	public void testSqlDate2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		java.sql.Date date = new java.sql.Date(9999999999L);

		Object result0 = converter.convertValue(date, Long.class);
		assertTrue(result0 instanceof Long);
		assertEquals(date.getTime(), result0);

		Object result1 = converter.convertValue(date, String.class);
		assertTrue(result1 instanceof String);
		assertEquals(dateFormat.format(date), result1);

		Object result2 = converter.convertValue(date, Date.class);
		assertTrue(result2 instanceof Date);
		assertEquals(date, result2);

		Object result4 = converter.convertValue(date, Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(date, result4);

		Object result5 = converter.convertValue(date, Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(date, result5);

		Object result6 = converter.convertValue(date, Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(date.getTime(), ((Calendar)result6).getTimeInMillis());
	}

	public void testTime2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Time date = new Time(9999999999L);

		Object result0 = converter.convertValue(date, Long.class);
		assertTrue(result0 instanceof Long);
		assertEquals(date.getTime(), result0);

		Object result1 = converter.convertValue(date, String.class);
		assertTrue(result1 instanceof String);
		assertEquals(dateFormat.format(date), result1);

		Object result2 = converter.convertValue(date, Date.class);
		assertTrue(result2 instanceof Date);
		assertEquals(date, result2);

		Object result3 = converter.convertValue(date, java.sql.Date.class);
		assertTrue(result3 instanceof java.sql.Date);
		assertEquals(date, result3);

		Object result4 = converter.convertValue(date, Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(date, result4);

		Object result5 = converter.convertValue(date, Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(date, result5);

		Object result6 = converter.convertValue(date, Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(date.getTime(), ((Calendar)result6).getTimeInMillis());
	}

	public void testTimestamp2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Timestamp date = new Timestamp(9999999999L);

		Object result0 = converter.convertValue(date, Long.class);
		assertTrue(result0 instanceof Long);
		assertEquals(date.getTime(), result0);

		Object result1 = converter.convertValue(date, String.class);
		assertTrue(result1 instanceof String);
		assertEquals(dateFormat.format(date), result1);

		Object result2 = converter.convertValue(date, Date.class);
		assertTrue(result2 instanceof Date);
		assertEquals(date, result2);

		Object result3 = converter.convertValue(date, java.sql.Date.class);
		assertTrue(result3 instanceof java.sql.Date);
		assertEquals(date.getTime(), ((Date)result3).getTime());

		Object result4 = converter.convertValue(date, Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(date.getTime(), ((Date)result4).getTime());

		Object result5 = converter.convertValue(date, Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(date.getTime(), ((Date)result5).getTime());

		Object result6 = converter.convertValue(date, Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(date.getTime(), ((Calendar)result6).getTimeInMillis());
	}

	public void testCalendar2Any() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		Calendar calendar = Calendar.getInstance();
		Timestamp date = new Timestamp(9999999999L);
		calendar.setTime(date);

		Object result0 = converter.convertValue(calendar, Long.class);
		assertTrue(result0 instanceof Long);
		assertEquals(date.getTime(), result0);

		Object result1 = converter.convertValue(calendar, String.class);
		assertTrue(result1 instanceof String);
		assertEquals(dateFormat.format(date), result1);

		Object result2 = converter.convertValue(calendar, Date.class);
		assertTrue(result2 instanceof Date);
		assertEquals(calendar.getTimeInMillis(), ((Date)result2).getTime());

		Object result3 = converter.convertValue(calendar, java.sql.Date.class);
		assertTrue(result3 instanceof java.sql.Date);
		assertEquals(date.getTime(), ((Date)result3).getTime());

		Object result4 = converter.convertValue(calendar, Time.class);
		assertTrue(result4 instanceof Time);
		assertEquals(date.getTime(), ((Date)result4).getTime());

		Object result5 = converter.convertValue(calendar, Timestamp.class);
		assertTrue(result5 instanceof Timestamp);
		assertEquals(date.getTime(), ((Date)result5).getTime());

		Object result6 = converter.convertValue(calendar, Calendar.class);
		assertTrue(result6 instanceof Calendar);
		assertEquals(calendar.getTimeInMillis(), ((Calendar)result6).getTimeInMillis());
	}
}
