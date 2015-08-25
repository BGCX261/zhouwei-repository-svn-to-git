package com.sitechasia.webx.core.utils.populator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import junit.framework.TestCase;

import com.sitechasia.webx.core.utils.populator.ITypeConverter;
import com.sitechasia.webx.core.utils.populator.PriTypeConverter;
import com.sitechasia.webx.core.utils.populator.WebXTypeConverter;

public class WebXTypeConverterTest extends TestCase {


	public void testClone() {

		WebXTypeConverter converter = new WebXTypeConverter();

		Calendar cal = Calendar.getInstance();
		Calendar cal2 = (Calendar)converter.convertValue(cal, Calendar.class);
		assertTrue(cal != cal2);
		assertTrue(cal.equals(cal2));

		Integer i = 2;
		Integer i2 = (Integer)converter.convertValue(i, Integer.class);
		assertTrue(i == i2);

	}

	public void testNoConverterList() {
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.setConverters(null);

		Object result = converter.convertValue(5, String.class);

		assertTrue(result == null);
	}

	public void testString2Any() {

		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		String stringTestSameValue = (String)converter.convertValue("5", String.class);

		assertTrue("5" == stringTestSameValue);

		byte byteValue = (Byte)converter.convertValue("5", byte.class);

		assertEquals(5, byteValue);

		short shortValue = (Short)converter.convertValue("257", short.class);

		assertEquals(257, shortValue);

		int intValue = (Integer)converter.convertValue("65537", int.class);

		assertEquals(65537, intValue);

		long longValue = (Long)converter.convertValue("4294967298", long.class);

		assertEquals(4294967298L, longValue);

		Object byteObjectValue = converter.convertValue("5", Byte.class);

		assertEquals(new Byte((byte)5), byteObjectValue);

		Object shortObjectValue = converter.convertValue("257", Short.class);

		assertEquals(new Short((short)257), shortObjectValue);

		Object intObjectValue = converter.convertValue("65537", Integer.class);

		assertEquals(new Integer(65537), intObjectValue);

		Object longObjectValue = converter.convertValue("4294967298", Long.class);

		assertEquals(new Long(4294967298L), longObjectValue);

		boolean booleanValueTrue = (Boolean)converter.convertValue("true", boolean.class);

		assertEquals(true, booleanValueTrue);

		boolean booleanValueFalse = (Boolean)converter.convertValue("fAlse", boolean.class);

		assertEquals(false, booleanValueFalse);

		boolean booleanValueFalse2 = (Boolean)converter.convertValue(null, boolean.class);

		assertEquals(false, booleanValueFalse2);

		boolean booleanValueFalse3 = (Boolean)converter.convertValue("f", boolean.class);

		assertEquals(false, booleanValueFalse3);

		boolean booleanValueFalse4 = (Boolean)converter.convertValue("no", boolean.class);

		assertEquals(false, booleanValueFalse4);

		boolean booleanValueFalse5 = (Boolean)converter.convertValue("n", boolean.class);

		assertEquals(false, booleanValueFalse5);

		boolean booleanValueFalse6 = (Boolean)converter.convertValue("", boolean.class);

		assertEquals(false, booleanValueFalse6);

		Object charValue = converter.convertValue("csdfgsdgf", char.class);

		assertEquals('c', charValue);

		Object charValue1 = converter.convertValue("20", char.class);

		assertEquals((char)20, charValue1);

		Object floadValue1 = converter.convertValue(null, float.class);

		assertEquals(0F, floadValue1);

		Object floadValue2 = converter.convertValue("20", float.class);

		assertEquals(20F, floadValue2);

		Object floadValue3 = converter.convertValue("", float.class);

		assertEquals(0F, floadValue3);

		Object doubleValue1 = converter.convertValue(null, double.class);

		assertEquals(0.0, doubleValue1);

		Object doubleValue2 = converter.convertValue("20", double.class);

		assertEquals(20.0, doubleValue2);

		Object doubleValue3 = converter.convertValue("", double.class);

		assertEquals(0.0, doubleValue3);

		Object bigIntegerValue1 = converter.convertValue(null, BigInteger.class);
		assertEquals(null, bigIntegerValue1);

		Object bigIntegerValue2 = converter.convertValue("20", BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue2);

		Object bigDecimalValue1 = converter.convertValue(null, BigDecimal.class);
		assertEquals(null, bigDecimalValue1);

		Object bigDecimalValue2 = converter.convertValue("20.256", BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20.256), bigDecimalValue2);
	}

	public void testBoolean2Any() {
		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue(true, byte.class);

		assertEquals((byte)1, byteValue1);

		Object byteValue2 = converter.convertValue(false, byte.class);

		assertEquals((byte)0, byteValue2);

		Object shortValue1 = converter.convertValue(true, short.class);

		assertEquals((short)1, shortValue1);

		Object shortValue2 = converter.convertValue(false, short.class);

		assertEquals((short)0, shortValue2);

		Object intValue1 = converter.convertValue(true, int.class);

		assertEquals(1, intValue1);

		Object intValue2 = converter.convertValue(false, int.class);

		assertEquals(0, intValue2);

		Object longValue1 = converter.convertValue(true, long.class);

		assertEquals(1L, longValue1);

		Object longValue2 = converter.convertValue(false, long.class);

		assertEquals(0L, longValue2);

		Object floatValue1 = converter.convertValue(true, float.class);

		assertEquals(1F, floatValue1);

		Object floatValue2 = converter.convertValue(false, float.class);

		assertEquals(0F, floatValue2);

		Object doubleValue1 = converter.convertValue(true, double.class);

		assertEquals(1.0, doubleValue1);

		Object doubleValue2 = converter.convertValue(false, double.class);

		assertEquals(0.0, doubleValue2);

		Object stringValue1 = converter.convertValue(true, String.class);

		assertEquals("true", stringValue1);

		Object stringValue2 = converter.convertValue(false, String.class);

		assertEquals("false", stringValue2);

		Object charValue1 = converter.convertValue(true, char.class);

		assertEquals((char)1, charValue1);

		Object charValue2 = converter.convertValue(false, char.class);

		assertEquals((char)0, charValue2);

		Object bigIntegerValue1 = converter.convertValue(true, BigInteger.class);

		assertEquals(BigInteger.valueOf(1), bigIntegerValue1);

		Object bigIntegerValue2 = converter.convertValue(false, BigInteger.class);

		assertEquals(BigInteger.valueOf(0), bigIntegerValue2);

		Object bigDecimalValue1 = converter.convertValue(true, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(1), bigDecimalValue1);

		Object bigDecimalValue2 = converter.convertValue(false, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(0), bigDecimalValue2);
	}

	public void testByte2Any() {

		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object shortValue1 = converter.convertValue((byte)20, short.class);

		assertEquals((short)20, shortValue1);

		Object intValue1 = converter.convertValue((byte)20, int.class);

		assertEquals(20, intValue1);

		Object longValue1 = converter.convertValue((byte)20, long.class);

		assertEquals(20L, longValue1);

		Object floatValue1 = converter.convertValue((byte)20, float.class);

		assertEquals(20F, floatValue1);

		Object doubleValue1 = converter.convertValue((byte)20, double.class);

		assertEquals(20.0, doubleValue1);

		Object booleanValue1 = converter.convertValue((byte)20, boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue((byte)0, boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue((byte)20, char.class);

		assertEquals((char)20, charValue1);

		Object bigIntegerValue1 = converter.convertValue((byte)20, BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue((byte)20, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);

	}

	public void testShort2Any() {
		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object intValue1 = converter.convertValue((short)20, int.class);

		assertEquals(20, intValue1);

		Object longValue1 = converter.convertValue((short)20, long.class);

		assertEquals(20L, longValue1);

		Object floatValue1 = converter.convertValue((short)20, float.class);

		assertEquals(20F, floatValue1);

		Object doubleValue1 = converter.convertValue((short)20, double.class);

		assertEquals(20.0, doubleValue1);

		Object booleanValue1 = converter.convertValue((short)20, boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue((short)0, boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue((short)20, char.class);

		assertEquals((char)20, charValue1);

		Object bigIntegerValue1 = converter.convertValue((short)20, BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue((short)20, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);
	}

	public void testInt2Any() {
		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object longValue1 = converter.convertValue(20, long.class);

		assertEquals(20L, longValue1);

		Object floatValue1 = converter.convertValue(20, float.class);

		assertEquals(20F, floatValue1);

		Object doubleValue1 = converter.convertValue(20, double.class);

		assertEquals(20.0, doubleValue1);

		Object booleanValue1 = converter.convertValue(20, boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue(0, boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue(20, char.class);

		assertEquals((char)20, charValue1);

		Object bigIntegerValue1 = converter.convertValue(20, BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue(20, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);
	}

	public void testLong2Any() {
		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object floatValue1 = converter.convertValue(20L, float.class);

		assertEquals(20F, floatValue1);

		Object doubleValue1 = converter.convertValue(20L, double.class);

		assertEquals(20.0, doubleValue1);

		Object booleanValue1 = converter.convertValue(20L, boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue(0L, boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue(20L, char.class);

		assertEquals((char)20, charValue1);

		Object bigIntegerValue1 = converter.convertValue(20L, BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue(20L, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);
	}

	public void testFloat2Any() {

		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue((float)20, byte.class);

		assertEquals((byte)20, byteValue1);

		Object shortValue1 = converter.convertValue((float)20, short.class);

		assertEquals((short)20, shortValue1);

		Object intValue1 = converter.convertValue((float)20, int.class);

		assertEquals(20, intValue1);

		Object longValue1 = converter.convertValue((float)20, long.class);

		assertEquals(20L, longValue1);

		Object doubleValue1 = converter.convertValue((float)20, double.class);

		assertEquals(20.0, doubleValue1);

		Object booleanValue1 = converter.convertValue((float)20, boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue((float)0, boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue((float)20, char.class);

		assertEquals((char)20, charValue1);

		Object bigIntegerValue1 = converter.convertValue((float)20, BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue((float)20, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);
	}

	public void testDouble2Any() {

		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue((double)20, byte.class);

		assertEquals((byte)20, byteValue1);

		Object shortValue1 = converter.convertValue((double)20, short.class);

		assertEquals((short)20, shortValue1);

		Object intValue1 = converter.convertValue((double)20, int.class);

		assertEquals(20, intValue1);

		Object longValue1 = converter.convertValue((double)20, long.class);

		assertEquals(20L, longValue1);

		Object booleanValue1 = converter.convertValue((double)20, boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue((double)0, boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue((double)20, char.class);

		assertEquals((char)20, charValue1);

		Object bigIntegerValue1 = converter.convertValue((double)20, BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue((double)20, BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);
	}

	public void testChar2Any() {
		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue('a', byte.class);

		assertEquals((byte)'a', byteValue1);

		Object shortValue1 = converter.convertValue('a', short.class);

		assertEquals((short)'a', shortValue1);

		Object intValue1 = converter.convertValue('a', int.class);

		assertEquals((int)'a', intValue1);

		Object longValue1 = converter.convertValue('a', long.class);

		assertEquals((long)'a', longValue1);

		Object booleanValue1 = converter.convertValue('a', boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue((char)0, boolean.class);

		assertEquals(false, booleanValue2);

		Object floatValue1 = converter.convertValue('a', float.class);

		assertEquals((float)'a', floatValue1);

		Object doubleValue1 = converter.convertValue('a', double.class);

		assertEquals((double)'a', doubleValue1);

		Object bigIntegerValue1 = converter.convertValue('a', BigInteger.class);

		assertEquals(BigInteger.valueOf('a'), bigIntegerValue1);

		Object bigDecimalValue1 = converter.convertValue('a', BigDecimal.class);

		assertEquals(BigDecimal.valueOf('a'), bigDecimalValue1);
	}

	public void testBigInteger2Any() {

		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue(BigInteger.valueOf(20), byte.class);

		assertEquals((byte)20, byteValue1);

		Object shortValue1 = converter.convertValue(BigInteger.valueOf(20), short.class);

		assertEquals((short)20, shortValue1);

		Object intValue1 = converter.convertValue(BigInteger.valueOf(20), int.class);

		assertEquals((int)20, intValue1);

		Object longValue1 = converter.convertValue(BigInteger.valueOf(20), long.class);

		assertEquals((long)20, longValue1);

		Object booleanValue1 = converter.convertValue(BigInteger.valueOf(20), boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue(BigInteger.valueOf(0), boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue(BigInteger.valueOf(20), char.class);

		assertEquals((char)20, charValue1);

		Object floatValue1 = converter.convertValue(BigInteger.valueOf(20), float.class);

		assertEquals((float)20, floatValue1);

		Object doubleValue1 = converter.convertValue(BigInteger.valueOf(20), double.class);

		assertEquals((double)20, doubleValue1);

		Object bigDecimalValue1 = converter.convertValue(BigInteger.valueOf(20), BigDecimal.class);

		assertEquals(BigDecimal.valueOf(20), bigDecimalValue1);
	}

	public void testIntArray2StringArray() {
		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue(new int[]{1, 2}, String[].class);

		assertEquals("1", ((String[])byteValue1)[0]);
	}

	public void testBigDecimal2Any() {

		ITypeConverter subConverter = new PriTypeConverter();
		WebXTypeConverter converter = new WebXTypeConverter();
		converter.getConverters().add(subConverter);

		Object byteValue1 = converter.convertValue(BigDecimal.valueOf(20), byte.class);

		assertEquals((byte)20, byteValue1);

		Object shortValue1 = converter.convertValue(BigDecimal.valueOf(20), short.class);

		assertEquals((short)20, shortValue1);

		Object intValue1 = converter.convertValue(BigDecimal.valueOf(20), int.class);

		assertEquals((int)20, intValue1);

		Object longValue1 = converter.convertValue(BigDecimal.valueOf(20), long.class);

		assertEquals((long)20, longValue1);

		Object booleanValue1 = converter.convertValue(BigDecimal.valueOf(20), boolean.class);

		assertEquals(true, booleanValue1);

		Object booleanValue2 = converter.convertValue(BigDecimal.valueOf(0), boolean.class);

		assertEquals(false, booleanValue2);

		Object charValue1 = converter.convertValue(BigDecimal.valueOf(20), char.class);

		assertEquals((char)20, charValue1);

		Object floatValue1 = converter.convertValue(BigDecimal.valueOf(20), float.class);

		assertEquals((float)20, floatValue1);

		Object doubleValue1 = converter.convertValue(BigDecimal.valueOf(20), double.class);

		assertEquals((double)20, doubleValue1);

		Object bigIntegerValue1 = converter.convertValue(BigDecimal.valueOf(20), BigInteger.class);

		assertEquals(BigInteger.valueOf(20), bigIntegerValue1);
	}
}
