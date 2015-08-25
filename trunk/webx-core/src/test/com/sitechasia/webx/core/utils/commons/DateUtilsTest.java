package com.sitechasia.webx.core.utils.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.TestCase;
import com.sitechasia.webx.core.utils.commons.DateUtils;

/**
 * <p>Title: DateUtilsTest</p>
 * <p>Description: </p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class DateUtilsTest extends TestCase {

	public void setUp() throws Exception {
		super.setUp();
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testStringToDate() {
		assertEquals(DateUtils.StringToDate("2007-08-29 12:30:10",
				"yyyy-MM-dd HH:mm:ss"), new Date(107, 7, 29, 12, 30, 10));
		assertEquals(DateUtils.StringToDate("2007-08-29", "yyyy-MM-dd"),
				new Date(107, 7, 29));
		assertEquals(DateUtils.StringToDate("08/29/2007", "MM/dd/yyyy"),
				new Date(107, 7, 29));
		assertEquals(DateUtils.StringToDate("200705111122", "yyyyMMddHHmm"),
				new Date(107, 4, 11, 11, 22));
		assertEquals(DateUtils.StringToDate("20070511", "yyyyMMdd"), new Date(
				107, 4, 11));
		assertEquals(DateUtils.StringToDate("05/11/2007 02:22",
				"MM/dd/yyyy HH:mm"), new Date(107, 4, 11, 2, 22));

	}

	public void testToSQLDate() {
		assertEquals(DateUtils.toSQLDate("08/29/2007", "MM/dd/yyyy"),
				new java.sql.Date(107, 7, 29));
		assertEquals(DateUtils.toSQLDate("2007-08-29", "yyyy-MM-dd"),
				new java.sql.Date(107, 7, 29));
		assertEquals(DateUtils.toSQLDate("20070829", "yyyyMMdd"),
				new java.sql.Date(107, 7, 29));
	}

	public void testToString() {

		assertEquals(DateUtils.toString(new Date(107, 4, 11), "yyyyMMdd"),
				"20070511");
		assertEquals(DateUtils.toString(new Date(107, 4, 11, 23, 02, 05),
				"yyyy-MM-dd HH:mm:ss"), "2007-05-11 23:02:05");
		assertEquals(DateUtils.toString(new Date(107, 4, 11), "yyyy-MM-dd"),
				"2007-05-11");
		assertEquals(DateUtils.toString(new Date(107, 4, 11), "MM/dd/yyyy"),
				"05/11/2007");
		assertEquals(DateUtils.toString(new Date(107, 4, 11, 11, 11),
				"yyyyMMddHHmm"), "200705111111");
		assertEquals(DateUtils.toString(new Date(107, 4, 11, 12, 12),
				"MM/dd/yyyy HH:mm"), "05/11/2007 12:12");
		assertEquals(DateUtils.toString(null, "MM/dd/yyyy HH:mm"), "");
	}

	public void testGetDateMilliFormat() throws ParseException {
		assertEquals(DateUtils.getDateMilliFormat(new Date(104, 11, 25, 02, 11,
				45)), "2004-12-25 02:11:45,000");
		
		String datestr=DateUtils.getDateMilliFormat();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(datestr);
		double datedouble=date.getTime();
		double systime=System.currentTimeMillis();
		assertEquals(datedouble,systime,2000);
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(107, 4, 11));
		assertEquals("2007-05-11 00:00:00,000", DateUtils
				.getDateMilliFormat(cal));
	}

	public void testGetDateSecondFormat() throws ParseException {
		
		String datestr=DateUtils.getDateSecondFormat();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(datestr);
		double datedouble=date.getTime();
		double systime=System.currentTimeMillis();
		assertEquals(datedouble,systime,2000);
		
		assertEquals(DateUtils.getDateSecondFormat(new Date(104, 11, 25, 02,
				11, 45)), "2004-12-25 02:11:45");
	}

	public void testParseCalendarSecondFormat() {
		assertEquals(DateUtils.parseCalendarSecondFormat("2007-04-08 11:44:32").getTime(),new Date(107,3,8,11,44,32));
	}

	public void testParseDateSecondFormat() {
		assertEquals(DateUtils.parseDateSecondFormat("2005-04-08 11:54:32"),
				new Date(105, 3, 8, 11, 54, 32));
	}

	public void testGetDateMinuteFormat() throws ParseException {
		String datestr=DateUtils.getDateMinuteFormat();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date=sdf.parse(datestr);
		double datedouble=date.getTime();
		double sysdate=System.currentTimeMillis();
		assertEquals(datedouble,sysdate,601000);
	}

	public void testGetDateMinuteFormatWithParam() {
		
		GregorianCalendar cal=new GregorianCalendar();
		cal.setTime(new Date(108,1,28,11,11));
		assertEquals(DateUtils.getDateMinuteFormat(cal),"2008-02-28 11:11");
		
		assertEquals(DateUtils.getDateMinuteFormat(new Date(102, 10, 11, 11,
				25, 10)), "2002-11-11 11:25");

	}

	public void testParseCalendarMinuteFormat() {
	assertEquals(DateUtils.parseCalendarMinuteFormat("2002-11-11 11:25:12").getTime(),new Date(102,10,11,11,25,00));
	}

	public void testParseDateMinuteFormat() {
		assertEquals(DateUtils.parseDateMinuteFormat("2002-05-11 11:25:12"),new Date(102,4,11,11,25,00));
	}

	public void testParseDateMilliFormat() {
		assertEquals(DateUtils.parseDateMilliFormat("2002-05-11 11:25:12,222").toString(),"Sat May 11 11:25:12 CST 2002");
	}

	public void testParseCalendarMilliFormat() {
		
		assertEquals(DateUtils.parseCalendarMilliFormat("2002-05-11 11:25:12,222").getTime().toString(),"Sat May 11 11:25:12 CST 2002");
	}

	public void testGetDateDayFormat() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 7, 29));
		assertEquals(DateUtils.getDateDayFormat(cal),"2008-08-29");
		assertEquals(DateUtils.getDateDayFormat(new Date(103, 11, 05, 10, 25,
				01)), "2003-12-05");
	}

	public void testGetFirstDayOfNextMonth() {
		assertEquals(DateUtils.getFirstDayOfNextMonth(new Date(107, 7, 29))
				.getDate(), 1);

		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.setTime(new Date(107, 7, 29));
		assertEquals(
				DateUtils.getFirstDayOfNextMonth(cal2).getTime().getDate(), 1);
	}

	public void testGetLastDayOfNextWeek() {
		assertEquals(DateUtils.getLastDayOfNextWeek(new Date(107, 7, 29))
				.getDate(), 8);
	}

	public void testGetNextWeekDay() {
		assertEquals(DateUtils.getNextWeekDay(new Date(107, 7, 29)), new Date(
				107, 7, 30));
		assertEquals(DateUtils.getNextWeekDay(new Date(107, 7, 24)), new Date(
				107, 7, 27));
		assertEquals(DateUtils.getNextWeekDay(new Date(107, 7, 25)), new Date(
				107, 7, 27));

		GregorianCalendar cal0 = new GregorianCalendar();
		cal0.setTime(new Date(107, 7, 25));
		assertEquals(DateUtils.getNextWeekDay(cal0).getTime(), new Date(107, 7,
				27));

		GregorianCalendar cal1 = new GregorianCalendar();
		cal1.setTime(new Date(107, 7, 24));
		assertEquals(DateUtils.getNextWeekDay(cal1).getTime(), new Date(107, 7,
				27));

		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.setTime(new Date(107, 7, 29));
		assertEquals(DateUtils.getNextWeekDay(cal2).getTime(), new Date(107, 7,
				30));
	}

	public void testGetLastDayOfNextMonth() {
		assertEquals(DateUtils.getLastDayOfNextMonth(new Date(107, 10, 23))
				.getDate(), 31);
	}

	public void testGetPreviousWeekDay() {
		assertEquals(DateUtils.getPreviousWeekDay(new Date(107, 7, 27)),
				new Date(107, 7, 24));
		assertEquals(DateUtils.getPreviousWeekDay(new Date(107, 7, 26)),
				new Date(107, 7, 24));

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(107, 7, 27));
		assertEquals(DateUtils.getPreviousWeekDay(cal), new Date(107, 7, 24));

		GregorianCalendar cal1 = new GregorianCalendar();
		cal1.setTime(new Date(107, 7, 26));
		assertEquals(DateUtils.getPreviousWeekDay(cal1), new Date(107, 7, 24));

		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.setTime(new Date(107, 7, 25));
		assertEquals(DateUtils.getPreviousWeekDay(cal2), new Date(107, 7, 24));

	}

	public void testGetLastDayOfMonthWithInt() {
		
		assertEquals(DateUtils.getLastDayOfMonth(4), 30);
		assertEquals(DateUtils.getLastDayOfMonth(2), 29);
		assertEquals(DateUtils.getLastDayOfMonth(13), -1);
		assertEquals(DateUtils.getLastDayOfMonth(2000, 2), 29);
		assertEquals(DateUtils.getLastDayOfMonth(2007, 2), 28);
		assertEquals(DateUtils.getLastDayOfMonth(2007, 3), 31);
		assertEquals(DateUtils.getLastDayOfMonth(2007, 13), -1);
	}

	
	public void testisLeapYear() {

		assertTrue(DateUtils.isLeapYear());
		assertTrue(DateUtils.isLeapYear(2008));
		assertFalse(DateUtils.isLeapYear(3000));
		assertFalse(DateUtils.isLeapYear(new Date(107, 1, 9)));

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 7, 29));
		assertTrue(DateUtils.isLeapYear(cal));
	}

	public void testParseCalendarDayFormat() {
		assertEquals(DateUtils.parseCalendarDayFormat("2004-01-01 10:10").getTime(),new Date(103,12,1));
	}

	public void testParseDateDayFormat() {
		assertEquals(DateUtils.parseDateDayFormat("2004-03-02 01:12:12"),new Date(104,2,2));
	}

	public void testGetDateFileFormat() throws ParseException {
		assertEquals(DateUtils.getDateFileFormat(new Date(109, 11, 22, 11, 22,
				33)), "2009-12-22_11-22-33");

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(107, 12, 1, 16, 10, 10));
		assertEquals(DateUtils.getDateFileFormat(cal), "2008-01-01_16-10-10");
		
		String datestr=DateUtils.getDateFileFormat();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date=sdf.parse(datestr);
		double datedouble=date.getTime();
		double sysdate=System.currentTimeMillis();
		assertEquals(datedouble,sysdate,3000);
	}

	public void testParseCalendarFileFormat() {
		assertEquals(DateUtils.getDateFormat(DateUtils.parseCalendarFileFormat(
				"2007-06-08_15-18-59").getTime(), "yyyy-MM-dd_HH-mm-ss"),
				"2007-06-08_15-18-59");
	}

	public void testParseDateFileFormat() {
		assertEquals(DateUtils.parseDateFileFormat("2007-09-08_15-18-59"),
				new Date(107, 8, 8, 15, 18, 59));

	}

	public void testGetDateW3CFormat() throws ParseException {
		String datestr=DateUtils.getDateW3CFormat();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(datestr);
		double datedouble=date.getTime();
		double sysdate=System.currentTimeMillis();
		assertEquals(datedouble,sysdate,3000);
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getDateW3CFormat(cal), "2008-03-20 11:11:11");
	}

	public void testParseCalendarW3CFormat() {
		assertEquals(DateUtils
		.parseCalendarW3CFormat("2007-09-08 11:11:11").getTime(),new Date(107,8,8,11,11,11));
	}

	public void testParseDateW3CFormat() {
		assertEquals(DateUtils.parseDateW3CFormat("2007-11-08 11:11:11"),
				new Date(107, 10, 8, 11, 11, 11));
		assertEquals(DateUtils.getDateW3CFormat(new Date(109, 11, 22, 11, 22,
				33)), "2009-12-22 11:22:33");
	}

	public void testGetDateFormat() {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getDateFormat(cal), "2008-03-20 11:11:11");
		assertEquals(DateUtils.getDateFormat(new Date(107, 7, 27)),
				"2007-08-27 00:00:00");

	}

	public void testParseCalendarFormat() {
		assertEquals(DateUtils.parseCalendarFormat("2007-11-15 11:11:11").getTime(),new Date(107,10,15,11,11,11));
	}

	public void testParseDateFormat() {
		assertEquals(DateUtils.parseDateFormat("2007-11-15 11:14:12"),
				new Date(107, 10, 15, 11, 14, 12));
	}

	public void testGetDateFormatWithFormat() {
		assertEquals(DateUtils.getDateFormat(new Date(107, 7, 31, 1, 1, 1),
				"yyyy-MM-dd HH:mm:ss"), "2007-08-31 01:01:01");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getDateFormat(cal, "yyyy-MM-dd HH:mm:ss"),
				"2008-03-20 11:11:11");
	}

	public void testParseCalendarFormatWithFormat() {
		assertEquals(DateUtils.parseCalendarFormat("2007-08-31 09:17:43",
		"yyyy-MM-dd HH:mm:ss").getTime(),new Date(107,7,31,9,17,43));

	}

	public void testParseDateFormatWithFormat() {
		assertEquals(DateUtils.parseDateFormat("2007-08-31 09:17:43",
				"yyyy-MM-dd HH:mm:ss"), new Date(107, 7, 31, 9, 17, 43));
	}

	public void testGetFirstDayOfNextWeek() {
		assertEquals(DateUtils.getFirstDayOfNextWeek(new Date(107, 7, 22))
				.getDate(), 26);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getFirstDayOfNextWeek(cal).getTime().getMonth(),
				2);
	}

	public void testGetNextMonth() {
		assertEquals(DateUtils.getNextMonth(new Date(107, 4, 11)).getMonth(), 5);
		Calendar nextMonth = Calendar.getInstance();
		nextMonth.add(Calendar.MONTH, 1);
		Date dd = nextMonth.getTime();
		assertEquals(DateUtils.getNextMonth(DateUtils.getCalendar()).getTime()
				.getMonth(), dd.getMonth());

	}

	public void testGetNextDay() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getNextDay(cal).getTime().getDate(), 21);
		assertEquals(DateUtils.getNextDay(cal).getTime().getMonth(), 2);
		assertEquals(DateUtils.getNextDay(new Date(107, 7, 29)).getDate(), 30);

	}

	public void testGetFirstDayOfMonth() {
		assertEquals(DateUtils.getFirstDayOfMonth(new Date(107, 4, 11)),
				new Date(107, 4, 1));
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getFirstDayOfMonth(cal).getTime().getMonth(), 2);
	}

	public void testGetNextWeek() {
		assertEquals(DateUtils.getNextWeek(new Date(107, 7, 29)).getDate(), 5);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date(108, 2, 20, 11, 11, 11));
		assertEquals(DateUtils.getNextWeek(cal).getTime().getMonth(), 2);

	}

	public void testGetLastDayOfWeek() {
		assertEquals(
				DateUtils.getLastDayOfWeek(new Date(107, 7, 29)).getDate(), 1);
		assertEquals(
				DateUtils.getLastDayOfWeek(new Date(107, 7, 27)).getDate(), 1);
		assertEquals(
				DateUtils.getLastDayOfWeek(new Date(107, 7, 28)).getDate(), 1);
		assertEquals(
				DateUtils.getLastDayOfWeek(new Date(107, 7, 30)).getDate(), 1);
		assertEquals(
				DateUtils.getLastDayOfWeek(new Date(107, 7, 31)).getDate(), 1);
		assertEquals(
				DateUtils.getLastDayOfWeek(new Date(107, 7, 26)).getDate(), 1);
		assertEquals(DateUtils.getLastDayOfWeek(new Date(107, 8, 1)).getDate(),
				1);

	}

	public void testGetFirstDayOfWeekWithDate() {
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 29))
				.getDate(), 26);
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 26))
				.getDate(), 26);
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 27))
				.getDate(), 26);
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 28))
				.getDate(), 26);
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 30))
				.getDate(), 26);
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 31))
				.getDate(), 26);
		assertEquals(DateUtils.getFirstDayOfWeek(new Date(107, 7, 25))
				.getDate(), 19);
	}

	public void testGetFirstDayOfWeekWithCaledar() {
		GregorianCalendar cal3 = new GregorianCalendar();
		cal3.setTime(new Date(107, 7, 29));
		assertEquals(DateUtils.getFirstDayOfWeek(cal3).getTime().getDate(), 26);
		GregorianCalendar cal31 = new GregorianCalendar();
		cal31.setTime(new Date(107, 7, 26));
		assertEquals(DateUtils.getFirstDayOfWeek(cal31).getTime().getDate(), 26);
		GregorianCalendar cal32 = new GregorianCalendar();
		cal32.setTime(new Date(107, 7, 27));
		assertEquals(DateUtils.getFirstDayOfWeek(cal32).getTime().getDate(), 26);
		GregorianCalendar cal33 = new GregorianCalendar();
		cal33.setTime(new Date(107, 7, 28));
		assertEquals(DateUtils.getFirstDayOfWeek(cal33).getTime().getDate(), 26);
		GregorianCalendar cal34 = new GregorianCalendar();
		cal34.setTime(new Date(107, 7, 30));
		assertEquals(DateUtils.getFirstDayOfWeek(cal34).getTime().getDate(), 26);
		GregorianCalendar cal35 = new GregorianCalendar();
		cal35.setTime(new Date(107, 7, 31));
		assertEquals(DateUtils.getFirstDayOfWeek(cal35).getTime().getDate(), 26);
		GregorianCalendar cal36 = new GregorianCalendar();
		cal36.setTime(new Date(107, 7, 25));
		assertEquals(DateUtils.getFirstDayOfWeek(cal36).getTime().getDate(), 19);

	}

	public void testGetLastDayOfMonthWithDate() {
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 02, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 01, 14))
				.getDate(), 28);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 03, 14))
				.getDate(), 30);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 04, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 05, 14))
				.getDate(), 30);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 06, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 07, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 8, 14))
				.getDate(), 30);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 9, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 10, 14))
				.getDate(), 30);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 11, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(107, 12, 14))
				.getDate(), 31);
		assertEquals(DateUtils.getLastDayOfMonth(new Date(108, 1, 14))
				.getDate(), 29);
	}

	public void testGetLastDayOfMonthWithCalendar() {
		GregorianCalendar cal11 = new GregorianCalendar();
		cal11.setTime(new Date(107, 01, 20));
		assertEquals(DateUtils.getLastDayOfMonth(cal11).getTime().getDate(), 28);

		GregorianCalendar cal12 = new GregorianCalendar();
		cal12.setTime(new Date(107, 2, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal12).getTime().getDate(), 31);

		GregorianCalendar cal13 = new GregorianCalendar();
		cal13.setTime(new Date(107, 3, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal13).getTime().getDate(), 30);

		GregorianCalendar cal14 = new GregorianCalendar();
		cal14.setTime(new Date(107, 4, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal14).getTime().getDate(), 31);

		GregorianCalendar cal15 = new GregorianCalendar();
		cal15.setTime(new Date(107, 5, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal15).getTime().getDate(), 30);

		GregorianCalendar cal16 = new GregorianCalendar();
		cal16.setTime(new Date(107, 6, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal16).getTime().getDate(), 31);

		GregorianCalendar cal17 = new GregorianCalendar();
		cal17.setTime(new Date(107, 7, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal17).getTime().getDate(), 31);

		GregorianCalendar cal18 = new GregorianCalendar();
		cal18.setTime(new Date(107, 8, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal18).getTime().getDate(), 30);

		GregorianCalendar cal19 = new GregorianCalendar();
		cal19.setTime(new Date(107, 9, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal19).getTime().getDate(), 31);

		GregorianCalendar cal111 = new GregorianCalendar();
		cal111.setTime(new Date(107, 10, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal111).getTime().getDate(),
				30);

		GregorianCalendar cal112 = new GregorianCalendar();
		cal112.setTime(new Date(107, 11, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal112).getTime().getDate(),
				31);

		GregorianCalendar cal113 = new GregorianCalendar();
		cal113.setTime(new Date(107, 12, 29));
		assertEquals(DateUtils.getLastDayOfMonth(cal113).getTime().getDate(),
				31);

		GregorianCalendar cal114 = new GregorianCalendar();
		cal114.setTime(new Date(108, 1, 24));
		assertEquals(DateUtils.getLastDayOfMonth(cal114).getTime().getDate(),
				29);

	}

	public void testToStringWithFormat() {
		assertEquals(DateUtils.toString(new Date(107, 7, 30), DateUtils
				.getDateFormat()), "08/30/2007");
		assertEquals(DateUtils.toString(new Date(107, 7, 30, 11, 11, 11),
				DateUtils.getDateTimeFormat()), "08/30/2007 11:11");
		assertEquals(DateUtils.toString(new Date(107, 7, 30, 11, 11, 11),
				DateUtils.getOraDateFormat()), "20070830");
		assertEquals(DateUtils.toString(new Date(107, 7, 30, 11, 11, 11),
				DateUtils.getOraDateTimeFormat()), "200708301111");
		assertEquals(
				DateUtils.toString(null, DateUtils.getOraDateTimeFormat()), "");
		assertEquals(
				DateUtils.toString(new Date(107, 7, 30, 11, 11, 11), true),
				"08/30/2007 11:11");
		assertEquals(DateUtils
				.toString(new Date(107, 7, 30, 11, 11, 11), false),
				"08/30/2007");

	}

	public void testToOraString() {
		assertEquals(DateUtils.toOraString(new Date(107, 7, 30, 11, 11, 11),
				true), "200708301111");
		assertEquals(DateUtils.toOraString(new Date(107, 7, 30, 11, 11, 11),
				false), "20070830");

	}
}
