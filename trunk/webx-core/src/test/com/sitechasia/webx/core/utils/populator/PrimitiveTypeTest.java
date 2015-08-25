package com.sitechasia.webx.core.utils.populator;

import java.math.BigDecimal;
import java.math.BigInteger;
import com.sitechasia.webx.core.utils.populator.PrimitiveType;

import junit.framework.TestCase;

public class PrimitiveTypeTest extends TestCase {
	public void testPrimitive() {
		assertFalse(PrimitiveType.isPriType(null));
		assertTrue(PrimitiveType.isPriType(String.class));
		assertTrue(PrimitiveType.isPriType(boolean.class));
		assertTrue(PrimitiveType.isPriType(byte.class));
		assertTrue(PrimitiveType.isPriType(short.class));
		assertTrue(PrimitiveType.isPriType(int.class));
		assertTrue(PrimitiveType.isPriType(long.class));
		assertTrue(PrimitiveType.isPriType(float.class));
		assertTrue(PrimitiveType.isPriType(double.class));
		assertTrue(PrimitiveType.isPriType(char.class));
		assertTrue(PrimitiveType.isPriType(Boolean.class));
		assertTrue(PrimitiveType.isPriType(Byte.class));
		assertTrue(PrimitiveType.isPriType(Short.class));
		assertTrue(PrimitiveType.isPriType(Integer.class));
		assertTrue(PrimitiveType.isPriType(Long.class));
		assertTrue(PrimitiveType.isPriType(Float.class));
		assertTrue(PrimitiveType.isPriType(Double.class));
		assertTrue(PrimitiveType.isPriType(Character.class));
		assertTrue(PrimitiveType.isPriType(BigInteger.class));
		assertTrue(PrimitiveType.isPriType(BigDecimal.class));
	}

	public void testPrimitiveArray() {
		assertFalse(PrimitiveType.isPriArrayType(null));
		assertTrue(PrimitiveType.isPriArrayType(String[].class));
		assertTrue(PrimitiveType.isPriArrayType(boolean[].class));
		assertTrue(PrimitiveType.isPriArrayType(byte[].class));
		assertTrue(PrimitiveType.isPriArrayType(short[].class));
		assertTrue(PrimitiveType.isPriArrayType(int[].class));
		assertTrue(PrimitiveType.isPriArrayType(long[].class));
		assertTrue(PrimitiveType.isPriArrayType(float[].class));
		assertTrue(PrimitiveType.isPriArrayType(double[].class));
		assertTrue(PrimitiveType.isPriArrayType(char[].class));
		assertTrue(PrimitiveType.isPriArrayType(Boolean[].class));
		assertTrue(PrimitiveType.isPriArrayType(Byte[].class));
		assertTrue(PrimitiveType.isPriArrayType(Short[].class));
		assertTrue(PrimitiveType.isPriArrayType(Integer[].class));
		assertTrue(PrimitiveType.isPriArrayType(Long[].class));
		assertTrue(PrimitiveType.isPriArrayType(Float[].class));
		assertTrue(PrimitiveType.isPriArrayType(Double[].class));
		assertTrue(PrimitiveType.isPriArrayType(Character[].class));
		assertTrue(PrimitiveType.isPriArrayType(BigInteger[].class));
		assertTrue(PrimitiveType.isPriArrayType(BigDecimal[].class));
	}
}
