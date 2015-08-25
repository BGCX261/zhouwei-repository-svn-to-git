package com.sitechasia.webx.core.utils.populator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import com.sitechasia.webx.core.utils.populator.BeanMapPopulator;
import com.sitechasia.webx.core.utils.populator.PriTypeConverter;
import com.sitechasia.webx.core.utils.populator.WebXTypeConverter;

import junit.framework.TestCase;

/**
 * <p>Title: BeanMapPopulatorTest</p>
 * <p>Description: BeanMapPopulator单元测试类</p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class BeanMapPopulatorTest extends TestCase {

	BeanMapPopulator populator;
	A beanA ;
	
	public void setUp() throws Exception{
		super.setUp();
		populator = new BeanMapPopulator();
		WebXTypeConverter converter = new WebXTypeConverter();
		PriTypeConverter priConverter = new PriTypeConverter();
		converter.getConverters().add(priConverter);
		populator.setConverter(converter);
		
		beanA = new A();
	}
	
	public void tearDown() throws Exception{
		super.tearDown();
		beanA=null;
		populator=null;
	}
	
	public void testMap2Bean() {
		
		Map map = new HashMap();
	
		map.put("stringValue", "test");
		populator.populate(map, beanA, null, null);
		assertEquals("test", beanA.getStringValue());

		map.put("booleanValue","false");
		populator.populate(map,beanA,null,null);
		assertEquals(false,beanA.isBooleanValue());

		map.put("byteValue", Byte.MIN_VALUE);
		populator.populate(map,beanA,null,null);
		assertEquals(Byte.MIN_VALUE,beanA.getByteValue());

		map.put("shortValue", 125);
		populator.populate(map,beanA,null,null);
		assertEquals(125,beanA.getShortValue());

		map.put("intValue", -1);
		populator.populate(map,beanA,null,null);
		assertEquals(-1,beanA.getIntValue());

		map.put("longValue", Long.MAX_VALUE);
		populator.populate(map,beanA,null,null);
		assertEquals(Long.MAX_VALUE,beanA.getLongValue());

		map.put("floatValue", Float.MAX_VALUE);
		populator.populate(map,beanA,null,null);
		assertEquals(Float.MAX_VALUE,beanA.getFloatValue());

		map.put("floatValue", -1.0F);
		populator.populate(map,beanA,null,null);
		assertEquals(-1.0F,beanA.getFloatValue());

		map.put("doubleValue", -1.0);
		populator.populate(map,beanA,null,null);
		assertEquals(-1.0,beanA.getDoubleValue());

		map.put("charValue", 'd');
		populator.populate(map,beanA,null,null);
		assertEquals('d',beanA.getCharValue());

		map.put("bigIntegerValue", BigInteger.valueOf(Long.MIN_VALUE));
		populator.populate(map,beanA,null,null);
		assertEquals(BigInteger.valueOf(Long.MIN_VALUE),beanA.getBigIntegerValue());

		map.put("bigDecimalValue", BigDecimal.valueOf(Double.MIN_VALUE));
		populator.populate(map,beanA,null,null);
		assertEquals( BigDecimal.valueOf(Double.MIN_VALUE),beanA.getBigDecimalValue());

		//object
		map.put("booleanObjValue",Boolean.FALSE);
		populator.populate(map,beanA,null,null);
		assertEquals(Boolean.FALSE,beanA.getBooleanObjValue());

		map.put("byteObjValue", Byte.valueOf(Byte.MIN_VALUE));
		populator.populate(map,beanA,null,null);
		assertEquals(Byte.valueOf(Byte.MIN_VALUE),beanA.getByteObjValue());

		map.put("shortObjValue", Short.valueOf((short)125));
		populator.populate(map,beanA,null,null);
		assertEquals(Short.valueOf((short)125),beanA.getShortObjValue());

		map.put("intObjValue", Integer.valueOf(1));
		populator.populate(map,beanA,null,null);
		assertEquals(Integer.valueOf(1),beanA.getIntObjValue());

		map.put("longObjValue", Long.valueOf(Long.MAX_VALUE));
		populator.populate(map,beanA,null,null);
		assertEquals(Long.valueOf(Long.MAX_VALUE),beanA.getLongObjValue());

		map.put("floatObjValue", Float.MAX_VALUE);
		populator.populate(map,beanA,null,null);
		assertEquals(Float.MAX_VALUE,beanA.getFloatObjValue());

		map.put("floatObjValue", -11.0F);
		populator.populate(map,beanA,null,null);
		assertEquals(-11.0F,beanA.getFloatObjValue());

		map.put("doubleObjValue", -1.0);
		populator.populate(map,beanA,null,null);
		assertEquals(-1.0,beanA.getDoubleObjValue());

		map.put("charObjValue", 'd');
		populator.populate(map,beanA,null,null);
		assertEquals(Character.valueOf('d'),beanA.getCharObjValue());

		map.put("stringArrayValue",new String[]{"myce","test"});
		populator.populate(map,beanA,null,null);
		assertEquals("myce",beanA.getStringArrayValue()[0]);
		assertEquals("test",beanA.getStringArrayValue()[1]);

		map.put("booleanArrayValue", (new boolean[]{false,true}));
		populator.populate(map,beanA,null,null);
		assertEquals(false,beanA.getBooleanArrayValue()[0]);
		assertEquals(true,beanA.getBooleanArrayValue()[1]);

		map.put("byteArrayValue", (new byte[]{56,34}));
		populator.populate(map,beanA,null,null);
		assertEquals(56,beanA.getByteArrayValue()[0]);

		map.put("shortArrayValue", (new short[]{96,84}));
		populator.populate(map,beanA,null,null);
		assertEquals(96,beanA.getShortArrayValue()[0]);

		map.put("intArrayValue", (new int[]{0,-1,1,Integer.MAX_VALUE,Integer.MIN_VALUE}));
		populator.populate(map,beanA,null,null);
		assertEquals(0,beanA.getIntArrayValue()[0]);

		map.put("longArrayValue", (new long[]{0,-1,1,Long.MAX_VALUE,Long.MIN_VALUE}));
		populator.populate(map,beanA,null,null);
		assertEquals(0,beanA.getLongArrayValue()[0]);

		map.put("floatArrayValue", (new float[]{Float.MAX_VALUE,Float.MIN_VALUE,1.0F}));
		populator.populate(map,beanA,null,null);
		assertEquals(Float.MAX_VALUE,beanA.getFloatArrayValue()[0]);

		map.put("doubleArrayValue", (new double[]{0.0,1.0,-1.0,Double.MAX_VALUE,Double.MIN_VALUE}));
		populator.populate(map,beanA,null,null);
		assertEquals(0.0,beanA.getDoubleArrayValue()[0]);

		map.put("charArrayValue", (new char[]{'a','z'}));
		populator.populate(map,beanA,null,null);
		assertEquals('a',beanA.getCharArrayValue()[0]);
		assertEquals('z',beanA.getCharArrayValue()[1]);

		map.put("booleanObjArrayValue", (new Boolean[]{Boolean.TRUE,Boolean.FALSE}));
		populator.populate(map,beanA,null,null);
		assertEquals(Boolean.TRUE,beanA.getBooleanObjArrayValue()[0]);
		assertEquals(Boolean.FALSE,beanA.getBooleanObjArrayValue()[1]);

		map.put("byteObjArrayValue", (new Byte[]{Byte.valueOf((byte)11),Byte.valueOf((byte)90)}));
		populator.populate(map,beanA,null,null);
		assertEquals(Byte.valueOf((byte)11),beanA.getByteObjArrayValue()[0]);
		assertEquals(Byte.valueOf((byte)90),beanA.getByteObjArrayValue()[1]);

		map.put("shortObjArrayValue", (new Short[]{Short.valueOf((short)99),Short.valueOf((short)90)}));
		populator.populate(map,beanA,null,null);
		assertEquals(Short.valueOf((short)99),beanA.getShortObjArrayValue()[0]);
		assertEquals(Short.valueOf((short)90),beanA.getShortObjArrayValue()[1]);

        map.put("longObjArrayValue", (new Long[]{Long.valueOf(990),Long.valueOf(9000)}));
		populator.populate(map,beanA,null,null);
		assertEquals(Long.valueOf(990),beanA.getLongObjArrayValue()[0]);
		assertEquals(Long.valueOf(9000),beanA.getLongObjArrayValue()[1]);


        map.put("floatObjArrayValue", (new Float[]{Float.valueOf(1.0F),Float.valueOf(-1.0F)}));
		populator.populate(map,beanA,null,null);
		assertEquals(Float.valueOf(1.0F),beanA.getFloatObjArrayValue()[0]);
		assertEquals(Float.valueOf(-1.0F),beanA.getFloatObjArrayValue()[1]);

        map.put("intObjArrayValue", (new int[]{Integer.valueOf(Integer.MAX_VALUE),Integer.valueOf(Integer.MIN_VALUE),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(-1)}));
		populator.populate(map,beanA,null,null);
		assertEquals(Integer.valueOf(Integer.MAX_VALUE),beanA.getIntObjArrayValue()[0]);
		assertEquals(Integer.valueOf(Integer.MIN_VALUE),beanA.getIntObjArrayValue()[1]);
		assertEquals(Integer.valueOf(0),beanA.getIntObjArrayValue()[2]);
		assertEquals(Integer.valueOf(1),beanA.getIntObjArrayValue()[3]);
		assertEquals(Integer.valueOf(-1),beanA.getIntObjArrayValue()[4]);


		map.put("doubleObjArrayValue", (new Double[]{Double.valueOf(1.0),Double.valueOf(-1.0),Double.valueOf(Double.MAX_VALUE),Double.valueOf(Double.MIN_VALUE),Double.valueOf(0.0)}));
		populator.populate(map,beanA,null,null);
		assertEquals(Double.valueOf(1.0),beanA.getDoubleObjArrayValue()[0]);
		assertEquals(Double.valueOf(-1.0),beanA.getDoubleObjArrayValue()[1]);
		assertEquals(Double.valueOf(Double.MAX_VALUE),beanA.getDoubleObjArrayValue()[2]);
		assertEquals(Double.valueOf(Double.MIN_VALUE),beanA.getDoubleObjArrayValue()[3]);
		assertEquals(Double.valueOf(0.0),beanA.getDoubleObjArrayValue()[4]);

		map.put("charObjArrayValue", (new Character[]{Character.valueOf('a'),Character.valueOf('z')}));
		populator.populate(map,beanA,null,null);
		assertEquals(Character.valueOf('a'),beanA.getCharObjArrayValue()[0]);
		assertEquals(Character.valueOf('z'),beanA.getCharObjArrayValue()[1]);

		}

	public void testBean2Map() {
		
		Map map = new HashMap();
		A beanA = new A();
		beanA.setStringValue("test");
		beanA.setIntValue(1);
		beanA.setLongValue(Long.MAX_VALUE);
		beanA.setDoubleValue(0.0);
		beanA.setFloatValue(1.0F);
		beanA.setShortValue((short)1);
		beanA.setByteValue((byte)1);
		beanA.setCharValue('A');
		beanA.setBooleanValue(false);
		beanA.setBigDecimalValue(BigDecimal.ONE);
		beanA.setBigIntegerValue(BigInteger.ONE);

		beanA.setIntObjValue(Integer.valueOf(1));
		beanA.setLongObjValue(Long.MIN_VALUE);
		beanA.setDoubleObjValue(Double.valueOf(0.0));
		beanA.setFloatObjValue(Float.valueOf(1.0F));
		beanA.setShortObjValue(Short.valueOf((short)1));
		beanA.setByteObjValue(Byte.valueOf((byte)1));
		beanA.setCharObjValue(Character.valueOf('A'));
		beanA.setBooleanObjValue(Boolean.valueOf(false));


		populator.populate(beanA, map, null, null);

		assertEquals(1, map.get("intValue"));
		assertEquals(Long.MAX_VALUE, map.get("longValue"));
		assertEquals(0.0, map.get("doubleValue"));
		assertEquals(1.0F, map.get("floatValue"));
		assertEquals((short)1, map.get("shortValue"));
		assertEquals((byte)1, map.get("byteValue"));
		assertEquals('A', map.get("charValue"));
		assertEquals(false,map.get("booleanValue"));
		assertEquals(BigDecimal.ONE,map.get("bigDecimalValue"));
		assertEquals(BigInteger.ONE,map.get("bigIntegerValue"));

		assertEquals(Integer.valueOf(1), map.get("intObjValue"));
		assertEquals(Long.MIN_VALUE, map.get("longObjValue"));
		assertEquals(Double.valueOf(0.0), map.get("doubleObjValue"));
		assertEquals(Float.valueOf(1.0F), map.get("floatObjValue"));
		assertEquals(Short.valueOf((short)1), map.get("shortObjValue"));
		assertEquals(Byte.valueOf((byte)1), map.get("byteObjValue"));
		assertEquals(Character.valueOf('A'), map.get("charObjValue"));
		assertEquals(Boolean.FALSE,map.get("booleanObjValue"));

	}

	public void testMap2Map() {
		
		Map map1 = new HashMap();
		Map map2 = new HashMap();
		map1.put("string", "test");
		map1.put("int",1);
		map1.put("long",Long.MAX_VALUE);
		map1.put("short",Short.MAX_VALUE);
		map1.put("byte",Byte.MAX_VALUE);
		map1.put("bigInteger",0);
		map1.put("char",'a');
		map1.put("boolean",false);
		map1.put("float",1.0F);
		map1.put("double",1.0);

		populator.populate(map1, map2, null, null);

		assertEquals("test", map2.get("string"));
		assertEquals(1, map2.get("int"));
		assertEquals(Long.MAX_VALUE, map2.get("long"));
		assertEquals(Short.MAX_VALUE, map2.get("short"));
		assertEquals(Byte.MAX_VALUE, map2.get("byte"));
		assertEquals('a', map2.get("char"));
		assertEquals(1.0, map2.get("double"));
		assertEquals(1.0F, map2.get("float"));
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

}
