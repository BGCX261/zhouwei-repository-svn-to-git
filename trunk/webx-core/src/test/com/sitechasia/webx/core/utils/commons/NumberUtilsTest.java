package com.sitechasia.webx.core.utils.commons;

import java.math.BigDecimal;
import java.text.ParseException;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.commons.NumberUtils;

/**
 * <code>com.sitechasia.webx.core.util.NumberUtils</code>单元测试
 *
 * @author zane
 *
 */
public class NumberUtilsTest extends TestCase {

	/**
	 * 初始化
	 */
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	/**
	 * 反初始化
	 */
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testFormatDouble() {
		// test format(double d)
		assertEquals(NumberUtils.format(0.004d), "0.00");
		assertEquals(NumberUtils.format(0.005d), "0.00");
		assertEquals(NumberUtils.format(0.006d), "0.01");
		assertEquals(NumberUtils.format(0.007d), "0.01");
		assertEquals(NumberUtils.format(0.9d), "0.90");
		assertEquals(NumberUtils.format(990.9d), "990.90");
		assertEquals(NumberUtils.format(9990.9d), "9,990.90");
		assertEquals(NumberUtils.format(9999990.9d), "9,999,990.90");

		// test format(double d, String pattern)
		assertEquals(NumberUtils.format(9999990.9d, null), "9,999,990.90");
		assertEquals(NumberUtils.format(9999990.9d, ""), "9,999,990.90");
		assertEquals(NumberUtils.format(9999990.9d, "###0.00"), "9999990.90");

		// test format(Double d)
		assertNull(NumberUtils.format((Double) null));
		assertEquals(NumberUtils.format(Double.valueOf(9999990.9d)), "9,999,990.90");

		// test format(Double d, String pattern)
		assertNull(NumberUtils.format((Double) null, "###0.00"));
		assertEquals(NumberUtils.format(Double.valueOf(9999990.9d), "###0.00"), "9999990.90");

	}

	public void testFormatFloat() {
		// test format(Float f)
		assertNull(NumberUtils.format((Float) null));
		assertEquals(NumberUtils.format(Float.valueOf(9990.9f)), "9,990.90");

		// test format(Float f, String pattern)
		assertNull(NumberUtils.format((Float) null, "###0.00"));
		assertEquals(NumberUtils.format(Float.valueOf(9990.9f), "###0.00"), "9990.90");
	}

	public void testFormatLong() {
		// test format(long l)
		assertEquals(NumberUtils.format(0L), "0");
		assertEquals(NumberUtils.format(990L), "990");
		assertEquals(NumberUtils.format(9990L), "9,990");
		assertEquals(NumberUtils.format(9999990L), "9,999,990");

		// test format(long l, String pattern)
		assertEquals(NumberUtils.format(9999990L, null), "9,999,990");
		assertEquals(NumberUtils.format(9999990L, ""), "9,999,990");
		assertEquals(NumberUtils.format(9999990L, "###0"), "9999990");

		// test format(Long l)
		assertNull(NumberUtils.format((Long) null));
		assertEquals(NumberUtils.format(Long.valueOf(9999990L)), "9,999,990");

		// test format(Long l, String pattern)
		assertNull(NumberUtils.format((Long) null, "###0"));
		assertEquals(NumberUtils.format(Long.valueOf(9999990L), "###0"), "9999990");
	}

	public void testFormatInteger() {
		// test format(Integer i)
		assertNull(NumberUtils.format((Integer) null));
		assertEquals(NumberUtils.format(Integer.valueOf(9999990)), "9,999,990");

		// test format(Integer i, String pattern)
		assertNull(NumberUtils.format((Integer) null, "###0"));
		assertEquals(NumberUtils.format(Integer.valueOf(9999990), "###0"), "9999990");
	}

	public void testFormatShort() {
		// test format(Short i)
		assertNull(NumberUtils.format((Short) null));
		assertEquals(NumberUtils.format(new Short("9990")), "9,990");

		// test format(Short i, String pattern)
		assertNull(NumberUtils.format((Short) null, "###0"));
		assertEquals(NumberUtils.format(new Short("9990"), "###0"), "9990");
	}

	public void testFormatNumber() {
		// 以BigDecimal为例
		// test format(Number number)
		BigDecimal number = new BigDecimal(0.004d);
		assertEquals(NumberUtils.format(number), "0.00");
		number = new BigDecimal(0.005d);
		assertEquals(NumberUtils.format(number), "0.01");
		number = new BigDecimal(0.006d);
		assertEquals(NumberUtils.format(number), "0.01");
		number = new BigDecimal(0.007d);
		assertEquals(NumberUtils.format(number), "0.01");
		number = new BigDecimal(0.9d);
		assertEquals(NumberUtils.format(number), "0.90");
		number = new BigDecimal(990.9d);
		assertEquals(NumberUtils.format(number), "990.90");
		number = new BigDecimal(9990.9d);
		assertEquals(NumberUtils.format(number), "9,990.90");
		number = new BigDecimal(9999990.9d);
		assertEquals(NumberUtils.format(number), "9,999,990.90");

		// test format(Number number, String pattern)
		number = null;
		assertNull(NumberUtils.format(number, "###0"));
		number = new BigDecimal(9999990.9d);
		assertEquals(NumberUtils.format(number, null), "9,999,990.90");
		number = new BigDecimal(9999990.9d);
		assertEquals(NumberUtils.format(number, ""), "9,999,990.90");
		number = new BigDecimal(9999990.9d);
		assertEquals(NumberUtils.format(number, "###0.00"), "9999990.90");
	}

	public void testFormatCurrency() {
		// test formatCurrency(double num)
		assertEquals(NumberUtils.formatCurrency(9999990.9d), "9,999,990.90");
		// test formatCurrency(Number number)
		assertNull(NumberUtils.formatCurrency((Number) null));
		assertEquals(NumberUtils.formatCurrency(Double.valueOf(9999990.9d)), "9,999,990.90");
	}

	public void testFormatPercent() {
		// test formatPercent(double num)
		assertEquals(NumberUtils.formatPercent(0.99d), "99.00%");
		assertEquals(NumberUtils.formatPercent(9999990.9d), "999,999,090.00%");
		// test formatPercent(Number number)
		assertNull(NumberUtils.formatPercent((Number) null));
		assertEquals(NumberUtils.formatPercent(Double.valueOf(9999990.9d)), "999,999,090.00%");
	}

	public void testParseNumber() throws ParseException {
		assertNull(NumberUtils.parse((String) null, (String) null));
		assertNull(NumberUtils.parse((String) null, ""));
		assertNull(NumberUtils.parse("", (String) null));
		assertNull(NumberUtils.parse("", ""));

		assertEquals(NumberUtils.parse("9999990.90", "###0.00"), new Double(9999990.90));
	}

	public void testParseShort() throws ParseException {
		assertNull(NumberUtils.parseShort((String) null));

		assertEquals(NumberUtils.parseShort("0"), new Short("0"));
		assertEquals(NumberUtils.parseShort("990"), new Short("990"));
		assertEquals(NumberUtils.parseShort("9,990"), new Short("9990"));
	}

	public void testParseInteger() throws ParseException {
		assertNull(NumberUtils.parseInteger((String) null));

		assertEquals(NumberUtils.parseInteger("0"), new Integer("0"));
		assertEquals(NumberUtils.parseInteger("990"), new Integer("990"));
		assertEquals(NumberUtils.parseInteger("9,990"), new Integer("9990"));
		assertEquals(NumberUtils.parseInteger("9,999,990"), new Integer("9999990"));
	}

	public void testParseLong() throws NumberFormatException, ParseException {
		assertNull(NumberUtils.parseLong((String) null));

		assertEquals(NumberUtils.parseLong("0"), new Long("0"));
		assertEquals(NumberUtils.parseLong("990"), new Long("990"));
		assertEquals(NumberUtils.parseLong("9,990"), new Long("9990"));
		assertEquals(NumberUtils.parseLong("9,999,990"), new Long("9999990"));
	}

	public void testParseFloat() throws ParseException {
		assertNull(NumberUtils.parseFloat((String) null));

		assertEquals(NumberUtils.parseFloat("0.90"), new Float("0.9"));
		assertEquals(NumberUtils.parseFloat("990.90"), new Float("990.9"));
		assertEquals(NumberUtils.parseFloat("9,990.90"), new Float("9990.9"));
		assertEquals(NumberUtils.parseFloat("9,999,990.90"), new Float("9999990.9"));
	}

	public void testParseDouble() throws ParseException {
		assertNull(NumberUtils.parseDouble((String) null));

		assertEquals(NumberUtils.parseDouble("0.90"), new Double("0.9"));
		assertEquals(NumberUtils.parseDouble("990.90"), new Double("990.9"));
		assertEquals(NumberUtils.parseDouble("9,990.90"), new Double("9990.9"));
		assertEquals(NumberUtils.parseDouble("9,999,990.90"), new Double("9999990.9"));
	}

	public void testParseCurrency() throws ParseException {
		assertNull(NumberUtils.parseCurrency((String) null));

		assertEquals(NumberUtils.parseCurrency("9,999,990.90"), new Double("9999990.9"));
	}

	public void testParsePercent() throws ParseException {
		assertNull(NumberUtils.parsePercent((String) null));

		assertEquals(NumberUtils.parsePercent("99.00%"), new Double("0.99"));
		assertEquals(NumberUtils.parsePercent("999,999,090.00%"), new Double("9999990.9"));
	}
}
