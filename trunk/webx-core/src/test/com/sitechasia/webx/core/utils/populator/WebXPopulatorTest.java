package com.sitechasia.webx.core.utils.populator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import com.sitechasia.webx.core.utils.populator.IPopulator;
import com.sitechasia.webx.core.utils.populator.PopulatorFactory;

import junit.framework.TestCase;

public class WebXPopulatorTest extends TestCase {

	public void testSimpleCopy() {
		IPopulator populator = PopulatorFactory.getDefaultPopulator();

		A beanA = new A();
		B beanB = new B();

		beanA.setBigDecimalArrayValue(new BigDecimal[] { BigDecimal.valueOf(1),
				BigDecimal.valueOf(2) });

		beanA.setBigDecimalValue(BigDecimal.valueOf(1));

		beanA.setBigIntegerArrayValue(new BigInteger[] { BigInteger.valueOf(1),
				BigInteger.valueOf(2) });

		beanA.setBigIntegerValue(BigInteger.valueOf(1));

		beanA.setBooleanArrayValue(new boolean[] { true, false });

		beanA.setBooleanObjArrayValue(new Boolean[] { Boolean.TRUE,
				Boolean.FALSE });

		beanA.setBooleanObjValue(Boolean.TRUE);

		beanA.setBooleanValue(true);

		beanA.setByteArrayValue(new byte[] { 1, 2 });

		beanA.setByteObjArrayValue(new Byte[] { Byte.valueOf((byte) 1),
				Byte.valueOf((byte) 2) });

		beanA.setByteObjValue(Byte.valueOf((byte) 1));

		beanA.setByteValue((byte) 1);

		beanA.setCharArrayValue(new char[] { 'a', 'b' });

		beanA.setCharObjArrayValue(new Character[] { Character.valueOf('a'),
				Character.valueOf('b') });

		beanA.setCharObjValue(Character.valueOf('a'));

		beanA.setCharValue('a');

		beanA.setDoubleArrayValue(new double[] { 1.0, 2.0 });

		beanA.setDoubleObjArrayValue(new Double[] { Double.valueOf(1.0),
				Double.valueOf(2.0) });

		beanA.setDoubleObjValue(Double.valueOf(1.0));

		beanA.setDoubleValue(1.0);

		beanA.setFloatArrayValue(new float[] { 1.0F, 2.0F });

		beanA.setFloatObjArrayValue(new Float[] { Float.valueOf(1.0F),
				Float.valueOf(2.0F) });

		beanA.setFloatObjValue(Float.valueOf(1.0F));

		beanA.setFloatValue(1.0F);

		beanA.setIntArrayValue(new int[] { 1, 2 });

		beanA.setIntObjArrayValue(new Integer[] { Integer.valueOf(1),
				Integer.valueOf(2) });

		beanA.setIntObjValue(Integer.valueOf(1));

		beanA.setIntValue(1);

		beanA.setLongArrayValue(new long[] { 1, 2 });

		beanA.setLongObjArrayValue(new Long[] { Long.valueOf(1),
				Long.valueOf(2) });

		beanA.setLongObjValue(Long.valueOf(1));

		beanA.setLongValue(1);

		beanA.setShortArrayValue(new short[] { (short) 1, (short) 2 });

		beanA.setShortObjArrayValue(new Short[] { Short.valueOf((short) 1),
				Short.valueOf((short) 1) });

		beanA.setShortObjValue(Short.valueOf((short) 1));

		beanA.setShortValue((short) 1);

		beanA.setStringArrayValue(new String[] { "1", "2" });

		beanA.setStringValue("1");

		populator.populate(beanA, beanB, null, null);

		assertEquals(beanA.getIntValue(), beanB.getIntValue());
		assertEquals(beanA.getStringArrayValue()[0], beanB.getStringArrayValue()[0]);
	}

	public void testString2Int() {
		A beanA = new A();
		B beanB = new B();

		IPopulator populator = PopulatorFactory.getDefaultPopulator();

		beanA.setStringValue("255");

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("intValue", "stringValue");

		assertEquals(0, beanB.getIntValue());

		populator.populate(beanA, beanB, mapping, new String[]{"intValue"});

		assertEquals(0, beanB.getIntValue());

		populator.populate(beanA, beanB, mapping, null);

		assertEquals(255, beanB.getIntValue());
	}

	public void testInt2Int() {
		A beanA = new A();
		B beanB = new B();

		IPopulator populator = PopulatorFactory.getDefaultPopulator();

		beanA.setIntObjValue(1);

		assertEquals(0, beanB.getIntValue());

		populator.populate(beanA, beanB, null, null);

		assertEquals(new Integer(1), beanB.getIntObjValue());

		beanA.setIntObjValue(null);

		populator.populate(beanA, beanB, null, null);

		assertEquals(null, beanB.getIntObjValue());

		beanA.setIntObjValue(null);

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("intValue", "intObjValue");

		populator.populate(beanA, mapping, null, null);

		assertEquals(0, beanB.getIntValue());

	}

	public void testMap2Bean() {
		IPopulator populator = PopulatorFactory.getDefaultPopulator();

		Map map = new HashMap();
		A beanA = new A();

		map.put("stringValue", "test");

		populator.populate(map, beanA, null, null);

		assertEquals("test", beanA.getStringValue());
	}

	public void testBean2Map() {
		IPopulator populator = PopulatorFactory.getDefaultPopulator();

		Map map = new HashMap();
		A beanA = new A();
		beanA.setStringValue("test");

		populator.populate(beanA, map, null, null);

		assertEquals("test", map.get("stringValue"));
	}

	public void testMap2Map() {
		IPopulator populator = PopulatorFactory.getDefaultPopulator();

		Map map1 = new HashMap();
		Map map2 = new HashMap();
		map1.put("string", "test");

		populator.populate(map1, map2, null, null);

		assertEquals("test", map2.get("string"));
	}

	public class A {
		private String stringValue;

		private boolean booleanValue;

		private byte byteValue;

		private short shortValue;

		private int intValue;

		private long longValue;

		private float floatValue;

		private double doubleValue;

		private char charValue;

		private Boolean booleanObjValue;

		private Byte byteObjValue;

		private Short shortObjValue;

		private Integer intObjValue;

		private Long longObjValue;

		private Float floatObjValue;

		private Double doubleObjValue;

		private Character charObjValue;

		private BigInteger bigIntegerValue;

		private BigDecimal bigDecimalValue;

		private String[] stringArrayValue;

		private boolean[] booleanArrayValue;

		private byte[] byteArrayValue;

		private short[] shortArrayValue;

		private int[] intArrayValue;

		private long[] longArrayValue;

		private float[] floatArrayValue;

		private double[] doubleArrayValue;

		private char[] charArrayValue;

		private Boolean[] booleanObjArrayValue;

		private Byte[] byteObjArrayValue;

		private Short[] shortObjArrayValue;

		private Integer[] intObjArrayValue;

		private Long[] longObjArrayValue;

		private Float[] floatObjArrayValue;

		private Double[] doubleObjArrayValue;

		private Character[] charObjArrayValue;

		private BigInteger[] bigIntegerArrayValue;

		private BigDecimal[] bigDecimalArrayValue;

		public BigDecimal[] getBigDecimalArrayValue() {
			return bigDecimalArrayValue;
		}

		public void setBigDecimalArrayValue(BigDecimal[] bigDecimalArrayValue) {
			this.bigDecimalArrayValue = bigDecimalArrayValue;
		}

		public BigDecimal getBigDecimalValue() {
			return bigDecimalValue;
		}

		public void setBigDecimalValue(BigDecimal bigDecimalValue) {
			this.bigDecimalValue = bigDecimalValue;
		}

		public BigInteger[] getBigIntegerArrayValue() {
			return bigIntegerArrayValue;
		}

		public void setBigIntegerArrayValue(BigInteger[] bigIntegerArrayValue) {
			this.bigIntegerArrayValue = bigIntegerArrayValue;
		}

		public BigInteger getBigIntegerValue() {
			return bigIntegerValue;
		}

		public void setBigIntegerValue(BigInteger bigIntegerValue) {
			this.bigIntegerValue = bigIntegerValue;
		}

		public boolean[] getBooleanArrayValue() {
			return booleanArrayValue;
		}

		public void setBooleanArrayValue(boolean[] booleanArrayValue) {
			this.booleanArrayValue = booleanArrayValue;
		}

		public Boolean[] getBooleanObjArrayValue() {
			return booleanObjArrayValue;
		}

		public void setBooleanObjArrayValue(Boolean[] booleanObjArrayValue) {
			this.booleanObjArrayValue = booleanObjArrayValue;
		}

		public Boolean getBooleanObjValue() {
			return booleanObjValue;
		}

		public void setBooleanObjValue(Boolean booleanObjValue) {
			this.booleanObjValue = booleanObjValue;
		}

		public boolean isBooleanValue() {
			return booleanValue;
		}

		public void setBooleanValue(boolean booleanValue) {
			this.booleanValue = booleanValue;
		}

		public byte[] getByteArrayValue() {
			return byteArrayValue;
		}

		public void setByteArrayValue(byte[] byteArrayValue) {
			this.byteArrayValue = byteArrayValue;
		}

		public Byte[] getByteObjArrayValue() {
			return byteObjArrayValue;
		}

		public void setByteObjArrayValue(Byte[] byteObjArrayValue) {
			this.byteObjArrayValue = byteObjArrayValue;
		}

		public Byte getByteObjValue() {
			return byteObjValue;
		}

		public void setByteObjValue(Byte byteObjValue) {
			this.byteObjValue = byteObjValue;
		}

		public byte getByteValue() {
			return byteValue;
		}

		public void setByteValue(byte byteValue) {
			this.byteValue = byteValue;
		}

		public char[] getCharArrayValue() {
			return charArrayValue;
		}

		public void setCharArrayValue(char[] charArrayValue) {
			this.charArrayValue = charArrayValue;
		}

		public Character[] getCharObjArrayValue() {
			return charObjArrayValue;
		}

		public void setCharObjArrayValue(Character[] charObjArrayValue) {
			this.charObjArrayValue = charObjArrayValue;
		}

		public Character getCharObjValue() {
			return charObjValue;
		}

		public void setCharObjValue(Character charObjValue) {
			this.charObjValue = charObjValue;
		}

		public char getCharValue() {
			return charValue;
		}

		public void setCharValue(char charValue) {
			this.charValue = charValue;
		}

		public double[] getDoubleArrayValue() {
			return doubleArrayValue;
		}

		public void setDoubleArrayValue(double[] doubleArrayValue) {
			this.doubleArrayValue = doubleArrayValue;
		}

		public Double[] getDoubleObjArrayValue() {
			return doubleObjArrayValue;
		}

		public void setDoubleObjArrayValue(Double[] doubleObjArrayValue) {
			this.doubleObjArrayValue = doubleObjArrayValue;
		}

		public Double getDoubleObjValue() {
			return doubleObjValue;
		}

		public void setDoubleObjValue(Double doubleObjValue) {
			this.doubleObjValue = doubleObjValue;
		}

		public double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public float[] getFloatArrayValue() {
			return floatArrayValue;
		}

		public void setFloatArrayValue(float[] floatArrayValue) {
			this.floatArrayValue = floatArrayValue;
		}

		public Float[] getFloatObjArrayValue() {
			return floatObjArrayValue;
		}

		public void setFloatObjArrayValue(Float[] floatObjArrayValue) {
			this.floatObjArrayValue = floatObjArrayValue;
		}

		public Float getFloatObjValue() {
			return floatObjValue;
		}

		public void setFloatObjValue(Float floatObjValue) {
			this.floatObjValue = floatObjValue;
		}

		public float getFloatValue() {
			return floatValue;
		}

		public void setFloatValue(float floatValue) {
			this.floatValue = floatValue;
		}

		public int[] getIntArrayValue() {
			return intArrayValue;
		}

		public void setIntArrayValue(int[] intArrayValue) {
			this.intArrayValue = intArrayValue;
		}

		public Integer[] getIntObjArrayValue() {
			return intObjArrayValue;
		}

		public void setIntObjArrayValue(Integer[] intObjArrayValue) {
			this.intObjArrayValue = intObjArrayValue;
		}

		public Integer getIntObjValue() {
			return intObjValue;
		}

		public void setIntObjValue(Integer intObjValue) {
			this.intObjValue = intObjValue;
		}

		public int getIntValue() {
			return intValue;
		}

		public void setIntValue(int intValue) {
			this.intValue = intValue;
		}

		public long[] getLongArrayValue() {
			return longArrayValue;
		}

		public void setLongArrayValue(long[] longArrayValue) {
			this.longArrayValue = longArrayValue;
		}

		public Long[] getLongObjArrayValue() {
			return longObjArrayValue;
		}

		public void setLongObjArrayValue(Long[] longObjArrayValue) {
			this.longObjArrayValue = longObjArrayValue;
		}

		public Long getLongObjValue() {
			return longObjValue;
		}

		public void setLongObjValue(Long longObjValue) {
			this.longObjValue = longObjValue;
		}

		public long getLongValue() {
			return longValue;
		}

		public void setLongValue(long longValue) {
			this.longValue = longValue;
		}

		public short[] getShortArrayValue() {
			return shortArrayValue;
		}

		public void setShortArrayValue(short[] shortArrayValue) {
			this.shortArrayValue = shortArrayValue;
		}

		public Short[] getShortObjArrayValue() {
			return shortObjArrayValue;
		}

		public void setShortObjArrayValue(Short[] shortObjArrayValue) {
			this.shortObjArrayValue = shortObjArrayValue;
		}

		public Short getShortObjValue() {
			return shortObjValue;
		}

		public void setShortObjValue(Short shortObjValue) {
			this.shortObjValue = shortObjValue;
		}

		public short getShortValue() {
			return shortValue;
		}

		public void setShortValue(short shortValue) {
			this.shortValue = shortValue;
		}

		public String[] getStringArrayValue() {
			return stringArrayValue;
		}

		public void setStringArrayValue(String[] stringArrayValue) {
			this.stringArrayValue = stringArrayValue;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}
	}

	public class B {
		private String stringValue;

		private boolean booleanValue;

		private byte byteValue;

		private short shortValue;

		private int intValue;

		private long longValue;

		private float floatValue;

		private double doubleValue;

		private char charValue;

		private Boolean booleanObjValue;

		private Byte byteObjValue;

		private Short shortObjValue;

		private Integer intObjValue;

		private Long longObjValue;

		private Float floatObjValue;

		private Double doubleObjValue;

		private Character charObjValue;

		private BigInteger bigIntegerValue;

		private BigDecimal bigDecimalValue;

		private String[] stringArrayValue;

		private boolean[] booleanArrayValue;

		private byte[] byteArrayValue;

		private short[] shortArrayValue;

		private int[] intArrayValue;

		private long[] longArrayValue;

		private float[] floatArrayValue;

		private double[] doubleArrayValue;

		private char[] charArrayValue;

		private Boolean[] booleanObjArrayValue;

		private Byte[] byteObjArrayValue;

		private Short[] shortObjArrayValue;

		private Integer[] intObjArrayValue;

		private Long[] longObjArrayValue;

		private Float[] floatObjArrayValue;

		private Double[] doubleObjArrayValue;

		private Character[] charObjArrayValue;

		private BigInteger[] bigIntegerArrayValue;

		private BigDecimal[] bigDecimalArrayValue;

		public BigDecimal[] getBigDecimalArrayValue() {
			return bigDecimalArrayValue;
		}

		public void setBigDecimalArrayValue(BigDecimal[] bigDecimalArrayValue) {
			this.bigDecimalArrayValue = bigDecimalArrayValue;
		}

		public BigDecimal getBigDecimalValue() {
			return bigDecimalValue;
		}

		public void setBigDecimalValue(BigDecimal bigDecimalValue) {
			this.bigDecimalValue = bigDecimalValue;
		}

		public BigInteger[] getBigIntegerArrayValue() {
			return bigIntegerArrayValue;
		}

		public void setBigIntegerArrayValue(BigInteger[] bigIntegerArrayValue) {
			this.bigIntegerArrayValue = bigIntegerArrayValue;
		}

		public BigInteger getBigIntegerValue() {
			return bigIntegerValue;
		}

		public void setBigIntegerValue(BigInteger bigIntegerValue) {
			this.bigIntegerValue = bigIntegerValue;
		}

		public boolean[] getBooleanArrayValue() {
			return booleanArrayValue;
		}

		public void setBooleanArrayValue(boolean[] booleanArrayValue) {
			this.booleanArrayValue = booleanArrayValue;
		}

		public Boolean[] getBooleanObjArrayValue() {
			return booleanObjArrayValue;
		}

		public void setBooleanObjArrayValue(Boolean[] booleanObjArrayValue) {
			this.booleanObjArrayValue = booleanObjArrayValue;
		}

		public Boolean getBooleanObjValue() {
			return booleanObjValue;
		}

		public void setBooleanObjValue(Boolean booleanObjValue) {
			this.booleanObjValue = booleanObjValue;
		}

		public boolean isBooleanValue() {
			return booleanValue;
		}

		public void setBooleanValue(boolean booleanValue) {
			this.booleanValue = booleanValue;
		}

		public byte[] getByteArrayValue() {
			return byteArrayValue;
		}

		public void setByteArrayValue(byte[] byteArrayValue) {
			this.byteArrayValue = byteArrayValue;
		}

		public Byte[] getByteObjArrayValue() {
			return byteObjArrayValue;
		}

		public void setByteObjArrayValue(Byte[] byteObjArrayValue) {
			this.byteObjArrayValue = byteObjArrayValue;
		}

		public Byte getByteObjValue() {
			return byteObjValue;
		}

		public void setByteObjValue(Byte byteObjValue) {
			this.byteObjValue = byteObjValue;
		}

		public byte getByteValue() {
			return byteValue;
		}

		public void setByteValue(byte byteValue) {
			this.byteValue = byteValue;
		}

		public char[] getCharArrayValue() {
			return charArrayValue;
		}

		public void setCharArrayValue(char[] charArrayValue) {
			this.charArrayValue = charArrayValue;
		}

		public Character[] getCharObjArrayValue() {
			return charObjArrayValue;
		}

		public void setCharObjArrayValue(Character[] charObjArrayValue) {
			this.charObjArrayValue = charObjArrayValue;
		}

		public Character getCharObjValue() {
			return charObjValue;
		}

		public void setCharObjValue(Character charObjValue) {
			this.charObjValue = charObjValue;
		}

		public char getCharValue() {
			return charValue;
		}

		public void setCharValue(char charValue) {
			this.charValue = charValue;
		}

		public double[] getDoubleArrayValue() {
			return doubleArrayValue;
		}

		public void setDoubleArrayValue(double[] doubleArrayValue) {
			this.doubleArrayValue = doubleArrayValue;
		}

		public Double[] getDoubleObjArrayValue() {
			return doubleObjArrayValue;
		}

		public void setDoubleObjArrayValue(Double[] doubleObjArrayValue) {
			this.doubleObjArrayValue = doubleObjArrayValue;
		}

		public Double getDoubleObjValue() {
			return doubleObjValue;
		}

		public void setDoubleObjValue(Double doubleObjValue) {
			this.doubleObjValue = doubleObjValue;
		}

		public double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public float[] getFloatArrayValue() {
			return floatArrayValue;
		}

		public void setFloatArrayValue(float[] floatArrayValue) {
			this.floatArrayValue = floatArrayValue;
		}

		public Float[] getFloatObjArrayValue() {
			return floatObjArrayValue;
		}

		public void setFloatObjArrayValue(Float[] floatObjArrayValue) {
			this.floatObjArrayValue = floatObjArrayValue;
		}

		public Float getFloatObjValue() {
			return floatObjValue;
		}

		public void setFloatObjValue(Float floatObjValue) {
			this.floatObjValue = floatObjValue;
		}

		public float getFloatValue() {
			return floatValue;
		}

		public void setFloatValue(float floatValue) {
			this.floatValue = floatValue;
		}

		public int[] getIntArrayValue() {
			return intArrayValue;
		}

		public void setIntArrayValue(int[] intArrayValue) {
			this.intArrayValue = intArrayValue;
		}

		public Integer[] getIntObjArrayValue() {
			return intObjArrayValue;
		}

		public void setIntObjArrayValue(Integer[] intObjArrayValue) {
			this.intObjArrayValue = intObjArrayValue;
		}

		public Integer getIntObjValue() {
			return intObjValue;
		}

		public void setIntObjValue(Integer intObjValue) {
			this.intObjValue = intObjValue;
		}

		public int getIntValue() {
			return intValue;
		}

		public void setIntValue(int intValue) {
			this.intValue = intValue;
		}

		public long[] getLongArrayValue() {
			return longArrayValue;
		}

		public void setLongArrayValue(long[] longArrayValue) {
			this.longArrayValue = longArrayValue;
		}

		public Long[] getLongObjArrayValue() {
			return longObjArrayValue;
		}

		public void setLongObjArrayValue(Long[] longObjArrayValue) {
			this.longObjArrayValue = longObjArrayValue;
		}

		public Long getLongObjValue() {
			return longObjValue;
		}

		public void setLongObjValue(Long longObjValue) {
			this.longObjValue = longObjValue;
		}

		public long getLongValue() {
			return longValue;
		}

		public void setLongValue(long longValue) {
			this.longValue = longValue;
		}

		public short[] getShortArrayValue() {
			return shortArrayValue;
		}

		public void setShortArrayValue(short[] shortArrayValue) {
			this.shortArrayValue = shortArrayValue;
		}

		public Short[] getShortObjArrayValue() {
			return shortObjArrayValue;
		}

		public void setShortObjArrayValue(Short[] shortObjArrayValue) {
			this.shortObjArrayValue = shortObjArrayValue;
		}

		public Short getShortObjValue() {
			return shortObjValue;
		}

		public void setShortObjValue(Short shortObjValue) {
			this.shortObjValue = shortObjValue;
		}

		public short getShortValue() {
			return shortValue;
		}

		public void setShortValue(short shortValue) {
			this.shortValue = shortValue;
		}

		public String[] getStringArrayValue() {
			return stringArrayValue;
		}

		public void setStringArrayValue(String[] stringArrayValue) {
			this.stringArrayValue = stringArrayValue;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}
	}
}
