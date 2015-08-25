package com.sitechasia.webx.core.utils.populator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.sitechasia.webx.core.utils.populator.BeanPopulator;
import com.sitechasia.webx.core.utils.populator.PriTypeConverter;
import com.sitechasia.webx.core.utils.populator.WebXTypeConverter;

import junit.framework.TestCase;

/**
 * <p>Title: BeanPopulatorTest</p>
 * <p>Description:BeanPopulator单元测试类</p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class BeanPopulatorTest extends TestCase {

	BeanPopulator populator;
	A beanA;
	B beanB;
	
	public void setUp() throws Exception{
		super.setUp();
		populator = new BeanPopulator();
		WebXTypeConverter converter = new WebXTypeConverter();
		PriTypeConverter priConverter = new PriTypeConverter();
		converter.getConverters().add(priConverter);
		populator.setConverter(converter);
		
		beanA=new A();
		beanB=new B();
	}
	
	public void tearDown() throws Exception{
		super.tearDown();
		beanA=null;
		beanB=null;
		populator=null;
		
	}
	
	public void testChar2Any(){
	   	Map<String,String> mapping=new HashMap<String,String>();
    	mapping.put("charObjValue","charValue");
	    beanA.setCharValue('B');
	    populator.populate(beanA,beanB,mapping,null);
	    assertEquals(Character.valueOf('B'),beanB.getCharObjValue());

	    Map<String,String> mapping1=new HashMap<String,String>();
    	mapping1.put("charValue","charObjValue");
	    beanA.setCharObjValue(Character.valueOf('R'));
	    populator.populate(beanA,beanB,mapping1,null);
	    assertEquals('R',beanB.getCharValue());

	   Map<String,String> mapping2=new HashMap<String,String>();
    	mapping2.put("charObjArrayValue","charArrayValue");
	    beanA.setCharArrayValue(new char[] {'d','g','j'});
	    populator.populate(beanA,beanB,mapping2,null);
	    assertEquals(Character.valueOf('d'),beanB.getCharObjArrayValue()[0]);
	    assertEquals(Character.valueOf('g'),beanB.getCharObjArrayValue()[1]);
	    assertEquals(Character.valueOf('j'),beanB.getCharObjArrayValue()[2]);

	    Map<String,String> mapping3=new HashMap<String,String>();
    	mapping3.put("charArrayValue","charObjArrayValue");
	    beanA.setCharObjArrayValue(new Character[] { Character.valueOf('a'),
				Character.valueOf('b')});
	    populator.populate(beanA,beanB,mapping3,null);
	    assertEquals('a',beanB.getCharArrayValue()[0]);
	    assertEquals('b',beanB.getCharArrayValue()[1]);

	    beanA.setCharValue('a');
		Map<String, String> mappinga = new HashMap<String, String>();
		mappinga.put("stringValue", "charValue");
		populator.populate(beanA, beanB, mappinga, null);
		assertEquals("a", beanB.getStringValue());

	    Map<String,String> mapping4=new HashMap<String,String>();
    	mapping4.put("intValue","charValue");
	    beanA.setCharValue('C');
	    populator.populate(beanA,beanB,mapping4,null);
	    assertEquals((int)'C',beanB.getCharValue());

	    Map<String,String> mapping5=new HashMap<String,String>();
    	mapping5.put("intValue","charObjValue");
	    beanA.setCharObjValue(Character.valueOf('C'));
	    populator.populate(beanA,beanB,mapping5,null);
	    assertEquals((int)'C',beanB.getIntValue());

	    Map<String,String> mapping6=new HashMap<String,String>();
    	mapping6.put("booleanValue","charValue");
	    beanA.setCharValue('z');
	    populator.populate(beanA,beanB,mapping6,null);
	   assertTrue(beanB.getBooleanValue());

	    Map<String,String> mapping7=new HashMap<String,String>();
    	mapping7.put("longValue","charValue");
	    beanA.setCharValue('a');
	    populator.populate(beanA,beanB,mapping7,null);
	    assertEquals((long)'a',beanB.getLongValue());

	    Map<String,String> mapping8=new HashMap<String,String>();
    	mapping8.put("doubleValue","charValue");
	    beanA.setCharValue('a');
	    populator.populate(beanA,beanB,mapping8,null);
	    assertEquals((double)'a',beanB.getDoubleValue());

	    Map<String,String> mapping9=new HashMap<String,String>();
    	mapping9.put("bigIntegerValue","charValue");
	    beanA.setCharValue('z');
	    populator.populate(beanA,beanB,mapping9,null);
	   assertEquals(BigInteger.valueOf('z'),beanB.getBigIntegerValue());

	    Map<String,String> mapping01=new HashMap<String,String>();
     	mapping01.put("bigDecimalValue","charValue");
	    beanA.setCharValue('z');
	    populator.populate(beanA,beanB,mapping01,null);
	   assertEquals(BigDecimal.valueOf('z'),beanB.getBigDecimalValue());

	   Map<String,String> mapping02=new HashMap<String,String>();
    	mapping02.put("stringValue","charValue");
	    beanA.setCharValue('d');
	    populator.populate(beanA,beanB,mapping02,null);
	   assertEquals("d",beanB.getStringValue());

	   Map<String,String> mapping06=new HashMap<String,String>();
	   mapping06.put("booleanObjValue","charValue");
	    beanA.setCharValue('z');
	    populator.populate(beanA,beanB,mapping06,null);
	   assertTrue(beanB.getBooleanObjValue());

	   Map<String,String> mapping07=new HashMap<String,String>();
	    mapping07.put("longObjValue","charValue");
	    beanA.setCharValue('a');
	    populator.populate(beanA,beanB,mapping07,null);
	   assertEquals(Long.valueOf((long)'a'),beanB.getLongObjValue());

	    Map<String,String> mapping08=new HashMap<String,String>();
     	mapping08.put("doubleObjValue","charValue");
	    beanA.setCharValue('a');
	    populator.populate(beanA,beanB,mapping08,null);
	    assertEquals(Double.valueOf((double)'a'),beanB.getDoubleObjValue());
	}

	 public void testFloat2Any(){
	       	Map<String,String> mapping=new HashMap<String,String>();
	    	mapping.put("floatObjValue","floatValue");
	    	beanA.setFloatValue(1.0F);
	    	populator.populate(beanA,beanB,mapping,null);
	    	assertEquals(Float.valueOf(1.0F),beanB.getFloatObjValue());

	    	Map<String,String> mapping2=new HashMap<String,String>();
	    	mapping.put("floatValue","floatObjValue");
	    	beanA.setFloatObjValue(Float.valueOf(1.0F));
	    	populator.populate(beanA,beanB,mapping2,null);
	    	assertEquals(1.0F,beanB.getFloatValue());

	    	Map<String,String> mapping3=new HashMap<String,String>();
	    	mapping3.put("floatArrayValue","floatObjArrayValue");
	    	beanA.setFloatObjArrayValue(new Float[] {Float.valueOf(1.0F),Float.valueOf(2.0F)});
	    	populator.populate(beanA,beanB,mapping3,null);
	    	assertEquals(1.0F,beanB.getFloatArrayValue()[0]);


	    	Map<String,String> mapping4=new HashMap<String,String>();
	    	mapping4.put("floatObjArrayValue","floatArrayValue");
	    	beanA.setFloatArrayValue(new float[] { 1.0F, 2.0F });
	    	populator.populate(beanA,beanB,mapping4,null);
	    	assertEquals(Float.valueOf(1.0F),beanB.getFloatObjArrayValue()[0]);

	    	Map<String,String> mapping11=new HashMap<String,String>();
	    	mapping11.put("intValue","floatValue");
	    	beanA.setFloatValue(10.9F);
	    	populator.populate(beanA,beanB,mapping11,null);
	    	assertEquals((int)10.9F,beanB.getIntValue());

	       	Map<String,String> mapping0=new HashMap<String,String>();
	    	mapping0.put("intObjValue","floatValue");
	    	beanA.setFloatValue(10.8F);
	    	populator.populate(beanA,beanB,mapping0,null);
	    	assertEquals(Integer.valueOf((int)10.8F),beanB.getIntObjValue());

//Array
	    	Map<String,String> mappinga=new HashMap<String,String>();
	    	mappinga.put("intArrayValue","floatArrayValue");
	    	beanA.setFloatArrayValue(new float[] {10.3F,20.4F,30.5F,40.6F});
	    	populator.populate(beanA,beanB,mappinga,null);
	    	assertEquals((int)10.3F,beanB.getIntArrayValue()[0]);
	    	assertEquals((int)20.4F,beanB.getIntArrayValue()[1]);
	    	assertEquals((int)30.5F,beanB.getIntArrayValue()[2]);
	    	assertEquals((int)40.6F,beanB.getIntArrayValue()[3]);

	    	Map<String,String> mappingb=new HashMap<String,String>();
	    	mappingb.put("intObjArrayValue","floatArrayValue");
	    	beanA.setFloatArrayValue(new float[] {110.2F,210.6F,310.3F,410.4F});
	    	populator.populate(beanA,beanB,mappingb,null);
	    	assertEquals(Integer.valueOf((int)110.2F),beanB.getIntObjArrayValue()[0]);
	    	assertEquals(Integer.valueOf((int)210.6F),beanB.getIntObjArrayValue()[1]);
	    	assertEquals(Integer.valueOf((int)310.3F),beanB.getIntObjArrayValue()[2]);
	    	assertEquals(Integer.valueOf((int)410.4F),beanB.getIntObjArrayValue()[3]);

	    	Map<String,String> mappingc=new HashMap<String,String>();
	    	mappingc.put("doubleValue","floatValue");
	    	beanA.setFloatValue(12.6F);
	    	populator.populate(beanA,beanB,mappingc,null);
	    	assertEquals((double)12.6F,beanB.getDoubleValue());

	    	Map<String,String> mappingd=new HashMap<String,String>();
	    	mappingd.put("doubleObjValue","floatValue");
	    	beanA.setFloatValue(12.6F);
	    	populator.populate(beanA,beanB,mappingd,null);
	    	assertEquals(Double.valueOf((double)12.6F),beanB.getDoubleObjValue());

	    	Map<String,String> mapping1=new HashMap<String,String>();
	    	mapping1.put("doubleValue","floatObjValue");
	    	beanA.setFloatObjValue(Float.valueOf(112.98989F));
	    	populator.populate(beanA,beanB,mapping1,null);
	    	assertEquals((double)112.98989F,beanB.getDoubleValue());

	    	//array
	    	Map<String,String> mapping7=new HashMap<String,String>();
	    	mapping7.put("doubleObjArrayValue","floatArrayValue");
	    	beanA.setFloatArrayValue(new float[]{404.34F,506.23F,100.545F});
	    	populator.populate(beanA,beanB,mapping7,null);
	    	assertEquals(Double.valueOf((double)404.34F),beanB.getDoubleObjArrayValue()[0]);
	    	assertEquals(Double.valueOf((double)506.23F),beanB.getDoubleObjArrayValue()[1]);
	    	assertEquals(Double.valueOf((double)100.545F),beanB.getDoubleObjArrayValue()[2]);

	    	Map<String,String> mapping03=new HashMap<String,String>();
	    	mapping03.put("doubleArrayValue","floatArrayValue");
	    	beanA.setFloatArrayValue(new float[]{44.3443F,56.232F,10.131F});
	    	populator.populate(beanA,beanB,mapping03,null);
	    	assertEquals((double)44.3443F,beanB.getDoubleArrayValue()[0]);
	    	assertEquals((double)56.232F,beanB.getDoubleArrayValue()[1]);
	    	assertEquals((double)10.131F,beanB.getDoubleArrayValue()[2]);

	        Map<String,String> mapping9=new HashMap<String,String>();
	    	mapping9.put("doubleArrayValue","floatObjArrayValue");
	    	beanA.setFloatObjArrayValue(new Float[]{Float.valueOf(504.066F),Float.valueOf(506.06F),Float.valueOf(500.06F)});
	    	populator.populate(beanA,beanB,mapping9,null);
	    	assertEquals((double)504.066F,beanB.getDoubleArrayValue()[0]);
	    	assertEquals((double)506.06F,beanB.getDoubleArrayValue()[1]);
	    	assertEquals((double)500.06F,beanB.getDoubleArrayValue()[2]);


	  	  	Map<String,String> mapping01=new HashMap<String,String>();
	  	    mapping01.put("doubleObjArrayValue","floatObjArrayValue");
	  	    beanA.setFloatObjArrayValue(new Float[]{Float.valueOf(1504.055F),Float.valueOf(1506.011F),Float.valueOf(5100.044F)});
	  	    populator.populate(beanA,beanB,mapping01,null);
	  	    assertEquals(Double.valueOf((double)1504.055F),beanB.getDoubleObjArrayValue()[0]);
	  	    assertEquals(Double.valueOf((double)1506.011F),beanB.getDoubleObjArrayValue()[1]);
	  	    assertEquals(Double.valueOf((double)5100.044F),beanB.getDoubleObjArrayValue()[2]);

	    	Map<String,String> mapping5=new HashMap<String,String>();
	    	mapping5.put("stringValue","floatValue");
	    	beanA.setFloatValue(12.6F);
	    	populator.populate(beanA,beanB,mapping5,null);
	    	assertEquals(Float.toString(12.6F),beanB.getStringValue());

	    	Map<String,String> mapping07=new HashMap<String,String>();
	    	mapping07.put("stringValue","floatObjValue");
	    	beanA.setFloatObjValue(Float.valueOf(12.66F));
	    	populator.populate(beanA,beanB,mapping07,null);
	    	assertEquals(Float.toString(12.66F),beanB.getStringValue());

	    	Map<String,String> mapping6=new HashMap<String,String>();
	    	mapping6.put("longValue","floatValue");
	    	beanA.setFloatValue(12.6F);
	    	populator.populate(beanA,beanB,mapping6,null);
	    	assertEquals((long)12.6F,beanB.getLongValue());
	 }

	 public void testDouble2Any(){
	    	Map<String,String> mapping0=new HashMap<String,String>();
	    	mapping0.put("floatValue","doubleValue");
	    	beanA.setDoubleValue(2.645645);
	    	populator.populate(beanA,beanB,mapping0,null);
	    	assertEquals((float)2.645645,beanB.getFloatValue());

	    	Map<String,String> mapping01=new HashMap<String,String>();
	    	mapping01.put("booleanValue","doubleValue");
	    	beanA.setDoubleValue(0.0);
	    	populator.populate(beanA,beanB,mapping01,null);
	    	assertFalse(beanB.getBooleanValue());

	    	Map<String,String> mapping02=new HashMap<String,String>();
	    	mapping02.put("doubleObjValue","doubleValue");
	    	beanA.setDoubleValue(0.0);
	    	populator.populate(beanA,beanB,mapping02,null);
	    	assertEquals(Double.valueOf(0.0),beanB.getDoubleObjValue());

	    	Map<String,String> mapping1=new HashMap<String,String>();
	    	mapping1.put("doubleValue","doubleObjValue");
	    	beanA.setDoubleObjValue(Double.valueOf(111.03));
	    	populator.populate(beanA,beanB,mapping1,null);
	    	assertEquals(111.03,beanB.getDoubleValue());

	    	Map<String,String> mapping2=new HashMap<String,String>();
	    	mapping2.put("doubleArrayValue","doubleObjArrayValue");
	    	beanA.setDoubleObjArrayValue(new Double[] { Double.valueOf(10.0),
	    		Double.valueOf(20.0) });
	    	populator.populate(beanA,beanB,mapping2,null);
	    	assertEquals(10.0,beanB.getDoubleArrayValue()[0]);
	    	assertEquals(20.0,beanB.getDoubleArrayValue()[1]);

	    	Map<String,String> mapping3=new HashMap<String,String>();
	    	mapping3.put("doubleObjArrayValue","doubleArrayValue");
	    	beanA.setDoubleArrayValue(new double[] { 11.0, 12.0 });
	    	populator.populate(beanA,beanB,mapping3,null);
	    	assertEquals(Double.valueOf(11.0),beanB.getDoubleObjArrayValue()[0]);
	    	assertEquals(Double.valueOf(12.0),beanB.getDoubleObjArrayValue()[1]);

	    	Map<String,String> mapping=new HashMap<String,String>();
	    	mapping.put("intValue","doubleValue");
	    	beanA.setDoubleValue(11.0);
	    	populator.populate(beanA,beanB,mapping,null);
	    	assertEquals(11,beanB.getIntValue());

	    	Map<String,String> mapping10=new HashMap<String,String>();
	    	mapping10.put("intObjValue","doubleValue");
	    	beanA.setDoubleValue(101.0);
	    	populator.populate(beanA,beanB,mapping10,null);
	    	assertEquals(Integer.valueOf(101),beanB.getIntObjValue());

	    	Map<String,String> mapping4=new HashMap<String,String>();
	    	mapping4.put("intArrayValue","doubleArrayValue");
	    	beanA.setDoubleArrayValue(new double[] {120.044,155.066,580.055});
	    	populator.populate(beanA,beanB,mapping4,null);
	    	assertEquals((int)120.044,beanB.getIntArrayValue()[0]);
	    	assertEquals((int)155.066,beanB.getIntArrayValue()[1]);
	    	assertEquals((int)580.055,beanB.getIntArrayValue()[2]);

	    	Map<String,String> mapping5=new HashMap<String,String>();
	    	mapping5.put("intObjArrayValue","doubleArrayValue");
	    	beanA.setDoubleArrayValue(new double[] {1001.3434,110.044,740.043});
	    	populator.populate(beanA,beanB,mapping5,null);
	    	assertEquals(Integer.valueOf((int)1001.3434),beanB.getIntObjArrayValue()[0]);
	    	assertEquals(Integer.valueOf((int)110.044),beanB.getIntObjArrayValue()[1]);
	    	assertEquals(Integer.valueOf((int)740.043),beanB.getIntObjArrayValue()[2]);

	    	Map<String,String> mapping03=new HashMap<String,String>();
	    	mapping03.put("bigIntegerValue","doubleValue");
	    	beanA.setDoubleValue(Double.MAX_VALUE);
	    	populator.populate(beanA,beanB,mapping03,null);
	    	assertEquals(BigInteger.valueOf((long)Double.MAX_VALUE),beanB.getBigIntegerValue());

	    	Map<String,String> mapping04=new HashMap<String,String>();
	    	mapping04.put("bigDecimalValue","doubleValue");
	    	beanA.setDoubleValue(90.0);
	    	populator.populate(beanA,beanB,mapping04,null);
	    	assertEquals(BigDecimal.valueOf((long)90.0),beanB.getBigDecimalValue());

	    	Map<String,String> mapping12=new HashMap<String,String>();
	    	mapping12.put("floatValue","doubleObjValue");
	    	beanA.setDoubleObjValue(Double.valueOf(442.6868));
	    	populator.populate(beanA,beanB,mapping12,null);
	    	assertEquals((float)442.6868,beanB.getFloatValue());

	    	Map<String,String> mapping50=new HashMap<String,String>();
	    	mapping50.put("floatObjValue","doubleValue");
	    	beanA.setDoubleValue(42.04535);
	    	populator.populate(beanA,beanB,mapping50,null);
	    	assertEquals(Float.valueOf(42.04535F),beanB.getFloatObjValue());

	 	    Map<String,String> mapping6=new HashMap<String,String>();
	    	mapping6.put("floatArrayValue","doubleArrayValue");
	    	beanA.setDoubleArrayValue(new double[]{44.5,16.5435,10.2456});
	    	populator.populate(beanA,beanB,mapping6,null);
	    	assertEquals((float)44.5,beanB.getFloatArrayValue()[0]);
	    	assertEquals((float)16.5435,beanB.getFloatArrayValue()[1]);
	    	assertEquals((float)10.2456,beanB.getFloatArrayValue()[2]);

	    	Map<String,String> mapping8=new HashMap<String,String>();
	    	mapping8.put("floatObjArrayValue","doubleArrayValue");
	    	beanA.setDoubleArrayValue(new double[]{144.5,116.0,110.0});
	    	populator.populate(beanA,beanB,mapping8,null);
	    	assertEquals(Float.valueOf(144.5F),beanB.getFloatObjArrayValue()[0]);
	    	assertEquals(Float.valueOf(116.0F),beanB.getFloatObjArrayValue()[1]);
	    	assertEquals(Float.valueOf(110.0F),beanB.getFloatObjArrayValue()[2]);

	    	Map<String,String> mapping100=new HashMap<String,String>();
	    	mapping100.put("floatArrayValue","doubleObjArrayValue");
	    	beanA.setDoubleObjArrayValue(new Double[]{Double.valueOf(14.115),Double.valueOf(12.066),Double.valueOf(11.044)});
	    	populator.populate(beanA,beanB,mapping100,null);
	    	assertEquals((float)14.115,beanB.getFloatArrayValue()[0]);
	    	assertEquals((float)12.066,beanB.getFloatArrayValue()[1]);
	    	assertEquals((float)11.044,beanB.getFloatArrayValue()[2]);

	    	Map<String,String> mapping00=new HashMap<String,String>();
	    	mapping00.put("floatObjArrayValue","doubleObjArrayValue");
	    	beanA.setDoubleObjArrayValue(new Double[]{Double.valueOf(14.5),Double.valueOf(11.606),Double.valueOf(144.056)});
	    	populator.populate(beanA,beanB,mapping00,null);
	    	assertEquals(Float.valueOf((float)14.5),beanB.getFloatObjArrayValue()[0]);
	    	assertEquals(Float.valueOf((float)11.606),beanB.getFloatObjArrayValue()[1]);
	    	assertEquals(Float.valueOf((float)144.056),beanB.getFloatObjArrayValue()[2]);

	    	Map<String,String> mapping05=new HashMap<String,String>();
	    	mapping05.put("stringValue","doubleValue");
	    	beanA.setDoubleValue(42.04535);
	    	populator.populate(beanA,beanB,mapping05,null);
	    	assertEquals(Double.toString(42.04535),beanB.getStringValue());

	    	Map<String,String> mapping06=new HashMap<String,String>();
	    	mapping06.put("stringValue","doubleObjValue");
	    	beanA.setDoubleObjValue(Double.valueOf(42.045));
	    	populator.populate(beanA,beanB,mapping06,null);
	    	assertEquals(Double.toString(42.045),beanB.getStringValue());

	    	Map<String,String> mapping07=new HashMap<String,String>();
	    	mapping07.put("stringArrayValue","doubleArrayValue");
	    	beanA.setDoubleArrayValue(new double[]{104.5,101.606,1404.056});
	    	populator.populate(beanA,beanB,mapping07,null);
	    	assertEquals(Double.toString(104.5),beanB.getStringArrayValue()[0]);
    	    assertEquals(Double.toString(101.606),beanB.getStringArrayValue()[1]);
    	    assertEquals(Double.toString(1404.056),beanB.getStringArrayValue()[2]);

	    	Map<String,String> mapping08=new HashMap<String,String>();
	    	mapping08.put("stringArrayValue","doubleObjArrayValue");
	    	beanA.setDoubleObjArrayValue(new Double[]{Double.valueOf(140.5),Double.valueOf(110.606),Double.valueOf(1440.056)});
	    	populator.populate(beanA,beanB,mapping08,null);
	    	assertEquals(Double.toString(140.5),beanB.getStringArrayValue()[0]);
	    	assertEquals(Double.toString(110.606),beanB.getStringArrayValue()[1]);
	    	assertEquals(Double.toString(1440.056),beanB.getStringArrayValue()[2]);
	 }

    public void testBigInteger2Any(){
       	Map<String,String> mapping=new HashMap<String,String>();
    	mapping.put("bigDecimalValue","bigIntegerValue");

    	beanA.setBigIntegerValue(BigInteger.valueOf(1));
    	populator.populate(beanA,beanB,mapping,null);
    	assertEquals(BigDecimal.valueOf(1),beanB.getBigDecimalValue());

    	beanA.setBigIntegerValue(BigInteger.valueOf(-1));
    	populator.populate(beanA,beanB,mapping,null);
    	assertEquals(BigDecimal.valueOf(-1),beanB.getBigDecimalValue());

    	beanA.setBigIntegerValue(BigInteger.valueOf(0));
    	populator.populate(beanA,beanB,mapping,null);
    	assertEquals(BigDecimal.valueOf(0),beanB.getBigDecimalValue());

      	Map<String,String> mapping1=new HashMap<String,String>();
    	mapping1.put("bigDecimalArrayValue","bigIntegerArrayValue");
    	beanA.setBigIntegerArrayValue(new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(3),
    			BigInteger.valueOf(Long.MAX_VALUE),BigInteger.valueOf(Long.MIN_VALUE)});
    	populator.populate(beanA,beanB,mapping1,null);
    	assertEquals(BigDecimal.valueOf(2),beanB.getBigDecimalArrayValue()[0]);
    	assertEquals(BigDecimal.valueOf(3),beanB.getBigDecimalArrayValue()[1]);
    	assertEquals(BigDecimal.valueOf(Long.MAX_VALUE),beanB.getBigDecimalArrayValue()[2]);
    	assertEquals(BigDecimal.valueOf(Long.MIN_VALUE),beanB.getBigDecimalArrayValue()[3]);

    	Map<String,String> mapping0=new HashMap<String,String>();
    	mapping0.put("stringValue","bigIntegerValue");

    	beanA.setBigIntegerValue(BigInteger.valueOf(1));
    	populator.populate(beanA,beanB,mapping0,null);
    	assertEquals("1",beanB.getStringValue());

    	beanA.setBigIntegerValue(BigInteger.valueOf(-1));
    	populator.populate(beanA,beanB,mapping0,null);
    	assertEquals("-1",beanB.getStringValue());

    	beanA.setBigIntegerValue(BigInteger.valueOf(0));
    	populator.populate(beanA,beanB,mapping0,null);
    	assertEquals("0",beanB.getStringValue());

    	beanA.setBigIntegerArrayValue(new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(3)});
    	Map<String,String> mapping01=new HashMap<String,String>();
    	mapping01.put("stringArrayValue","bigIntegerArrayValue");
    	populator.populate(beanA,beanB,mapping01,null);
     	assertEquals("2",beanB.getStringArrayValue()[0]);
     	assertEquals("3",beanB.getStringArrayValue()[1]);
    }

    public void testBigDecimal2Any(){
       	Map<String,String> mapping=new HashMap<String,String>();
    	mapping.put("bigIntegerValue","bigDecimalValue");

    	beanA.setBigDecimalValue(BigDecimal.valueOf(0));
    	populator.populate(beanA,beanB,mapping,null);
    	assertEquals(BigInteger.valueOf(0),beanB.getBigIntegerValue());

    	beanA.setBigDecimalValue(BigDecimal.valueOf(1));
    	populator.populate(beanA,beanB,mapping,null);
    	assertEquals(BigInteger.valueOf(1),beanB.getBigIntegerValue());

    	beanA.setBigDecimalValue(BigDecimal.valueOf(-1));
    	populator.populate(beanA,beanB,mapping,null);
    	assertEquals(BigInteger.valueOf(-1),beanB.getBigIntegerValue());

      	Map<String,String> mapping1=new HashMap<String,String>();
    	mapping1.put("bigIntegerArrayValue","bigDecimalArrayValue");

    	beanA.setBigDecimalArrayValue(new BigDecimal[]{BigDecimal.valueOf(2),BigDecimal.valueOf(3)});
    	populator.populate(beanA,beanB,mapping1,null);
    	assertEquals(BigInteger.valueOf(2),beanB.getBigIntegerArrayValue()[0]);
    	assertEquals(BigInteger.valueOf(3),beanB.getBigIntegerArrayValue()[1]);

//    	biginteger2string
    	Map<String,String> mapping0=new HashMap<String,String>();
    	mapping0.put("stringValue","bigDecimalValue");

    	beanA.setBigDecimalValue(BigDecimal.valueOf(1));
    	populator.populate(beanA,beanB,mapping0,null);
    	assertEquals("1",beanB.getStringValue());

    	beanA.setBigDecimalValue(BigDecimal.valueOf(-1));
    	populator.populate(beanA,beanB,mapping0,null);
    	assertEquals("-1",beanB.getStringValue());

    	beanA.setBigDecimalValue(BigDecimal.valueOf(0));
    	populator.populate(beanA,beanB,mapping0,null);
    	assertEquals("0",beanB.getStringValue());

    	beanA.setBigDecimalArrayValue(new BigDecimal[]{BigDecimal.valueOf(2),BigDecimal.valueOf(3)});
    	Map<String,String> mapping2=new HashMap<String,String>();
    	mapping2.put("stringArrayValue","bigDecimalArrayValue");
    	populator.populate(beanA,beanB,mapping2,null);
     	assertEquals("2",beanB.getStringArrayValue()[0]);
     	assertEquals("3",beanB.getStringArrayValue()[1]);
    }

    public void testString2Any(){
       	Map<String,String> mapping2=new HashMap<String,String>();
    	mapping2.put("bigIntegerValue","stringValue");

    	beanA.setStringValue("0");
       	populator.populate(beanA,beanB,mapping2,null);
        assertEquals(BigInteger.valueOf(0),beanB.getBigIntegerValue());

        beanA.setStringValue("1");
       	populator.populate(beanA,beanB,mapping2,null);
        assertEquals(BigInteger.valueOf(1),beanB.getBigIntegerValue());

        beanA.setStringValue("-1");
       	populator.populate(beanA,beanB,mapping2,null);
        assertEquals(BigInteger.valueOf(-1),beanB.getBigIntegerValue());

        beanA.setStringArrayValue(new String[]{"2","3"});
    	Map<String,String> mapping3=new HashMap<String,String>();
    	mapping3.put("bigIntegerArrayValue","stringArrayValue");
    	populator.populate(beanA,beanB,mapping3,null);
      	assertEquals(BigInteger.valueOf(2),beanB.getBigIntegerArrayValue()[0]);
    	assertEquals(BigInteger.valueOf(3),beanB.getBigIntegerArrayValue()[1]);

    	//string2bigdecimal
    	Map<String,String> mapping02=new HashMap<String,String>();
    	mapping02.put("bigDecimalValue","stringValue");

    	beanA.setStringValue("0");
       	populator.populate(beanA,beanB,mapping02,null);
        assertEquals(BigDecimal.valueOf(0),beanB.getBigDecimalValue());

        beanA.setStringValue("1");
       	populator.populate(beanA,beanB,mapping02,null);
        assertEquals(BigDecimal.valueOf(1),beanB.getBigDecimalValue());

        beanA.setStringValue("-1");
       	populator.populate(beanA,beanB,mapping02,null);
        assertEquals(BigDecimal.valueOf(-1),beanB.getBigDecimalValue());

        beanA.setStringArrayValue(new String[]{"2","3"});
    	Map<String,String> mapping03=new HashMap<String,String>();
    	mapping03.put("bigDecimalArrayValue","stringArrayValue");
    	populator.populate(beanA,beanB,mapping03,null);
      	assertEquals(BigDecimal.valueOf(2),beanB.getBigDecimalArrayValue()[0]);
    	assertEquals(BigDecimal.valueOf(3),beanB.getBigDecimalArrayValue()[1]);

    	beanA.setStringValue("255");

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("intValue", "stringValue");
		assertEquals(0, beanB.getIntValue());
		populator.populate(beanA, beanB, mapping, new String[]{"intValue"});
		assertEquals(0, beanB.getIntValue());
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(255, beanB.getIntValue());

		beanA.setStringValue("hgfhfAv");
		Map<String, String> mapping1 = new HashMap<String, String>();
		mapping1.put("charValue", "stringValue");
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals('h', beanB.getCharValue());
		beanA.setStringValue("hA7");
		Map<String, String> mapping003 = new HashMap<String, String>();
		mapping003.put("charArrayValue", "stringValue");
		populator.populate(beanA, beanB, mapping003, null);
		
		beanA.setStringArrayValue(new String[]{"aja","Xs"});
		Map<String, String> mapping4 = new HashMap<String, String>();
		mapping4.put("stringValue", "stringArrayValue");
		populator.populate(beanA, beanB, mapping4, null);
  }

	public void testInt2Any() {
		
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

		beanA.setIntValue(1);
		assertEquals(0, beanB.getShortValue());

		populator.populate(beanA, beanB, null, null);
		assertEquals(0, beanB.getShortValue());

		Map<String, String> mapping1 = new HashMap<String, String>();
		mapping1.put("shortValue", "intValue");
		beanA.setIntValue(0);
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals(0, beanB.getShortValue());

		beanA.setIntValue(-1);
		populator.populate(beanA,beanB,mapping1,null);
		assertEquals(-1,beanB.getShortValue());

		beanA.setIntValue(1);
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals(1, beanB.getShortValue());

		beanA.setIntValue(Short.MIN_VALUE);
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals(Short.MIN_VALUE, beanB.getShortValue());

		beanA.setIntValue(Short.MAX_VALUE);
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals(Short.MAX_VALUE, beanB.getShortValue());

		beanA.setIntValue((short)(Short.MAX_VALUE+1));
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals((short)(Short.MAX_VALUE+1), beanB.getShortValue());

		beanA.setIntValue((short)(Short.MIN_VALUE-1));
		populator.populate(beanA, beanB, mapping1, null);
		assertEquals((short)(Short.MIN_VALUE-1), beanB.getShortValue());

		beanA.setIntValue(1);
		assertEquals(0, beanB.getByteValue());

		populator.populate(beanA, beanB, null, null);
		assertEquals(0, beanB.getByteValue());

		Map<String, String> mapping0 = new HashMap<String, String>();
		mapping0.put("byteValue", "intValue");
		beanA.setIntValue(0);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(0, beanB.getByteValue());

		beanA.setIntValue(-1);
		populator.populate(beanA,beanB,mapping0,null);
		assertEquals(-1,beanB.getByteValue());

	    beanA.setIntValue(1);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(1, beanB.getByteValue());

		beanA.setIntValue(Byte.MIN_VALUE);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(Byte.MIN_VALUE, beanB.getByteValue());

		beanA.setIntValue(Byte.MAX_VALUE);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(Byte.MAX_VALUE, beanB.getByteValue());

	    beanA.setIntValue((byte)(Byte.MIN_VALUE-1));
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals((byte)(Byte.MIN_VALUE-1), beanB.getByteValue());

        beanA.setIntValue((byte)(Byte.MAX_VALUE+1));
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals((byte)(Byte.MAX_VALUE+1), beanB.getByteValue());

		beanA.setIntValue(1);
		assertEquals(0.0, beanB.getDoubleValue());

		populator.populate(beanA, beanB, null, null);
		assertEquals(0.0, beanB.getDoubleValue());

		Map<String, String> mapping00 = new HashMap<String, String>();
		mapping00.put("doubleValue", "intValue");
		beanA.setIntValue(-1);
		populator.populate(beanA,beanB,mapping00,null);
		assertEquals(-1.0,beanB.getDoubleValue());

		beanA.setIntValue(1);
		populator.populate(beanA, beanB, mapping00, null);
		assertEquals(1.0, beanB.getDoubleValue());

		beanA.setIntValue(0);
		populator.populate(beanA, beanB, mapping00, null);
		assertEquals(0.0, beanB.getDoubleValue());

		beanA.setIntValue(213);
		populator.populate(beanA,beanB,mapping00,null);
		assertEquals(213.0,beanB.getDoubleValue());

		beanA.setIntValue(Integer.MAX_VALUE);
		populator.populate(beanA,beanB,mapping00,null);
		assertEquals(2147483647.0,beanB.getDoubleValue());

		beanA.setIntValue(-2147483648);
		populator.populate(beanA,beanB,mapping00,null);
		assertEquals(-2147483648.0,beanB.getDoubleValue());

		Map<String,String> mapping3=new HashMap<String,String>();
    	mapping3.put("doubleObjValue","intValue");
    	beanA.setIntValue(110);
    	populator.populate(beanA,beanB,mapping3,null);
    	assertEquals(Double.valueOf(110.0),beanB.getDoubleObjValue());

    	Map<String,String> mapping6=new HashMap<String,String>();
    	mapping6.put("doubleArrayValue","intArrayValue");
    	beanA.setIntArrayValue(new int[] {111,230,583});
    	populator.populate(beanA,beanB,mapping6,null);
    	assertEquals(111.0,beanB.getDoubleArrayValue()[0]);

     	Map<String,String> mapping7=new HashMap<String,String>();
    	mapping7.put("doubleObjArrayValue","intArrayValue");
    	beanA.setIntArrayValue(new int[]{110,120});
    	populator.populate(beanA,beanB,mapping7,null);
    	assertEquals(Double.valueOf(110.0),beanB.getDoubleObjArrayValue()[0]);
	}

	public void testShort2Any() {
		
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("byteValue", "shortValue");

		beanA.setShortValue((short)0);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(0, beanB.getByteValue());

		beanA.setShortValue((short)-1);
		populator.populate(beanA,beanB,mapping,null);
		assertEquals(-1,beanB.getByteValue());

	   beanA.setShortValue((short)1);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(1, beanB.getByteValue());

		beanA.setShortValue(Byte.MIN_VALUE);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(Byte.MIN_VALUE, beanB.getByteValue());

		beanA.setShortValue(Byte.MAX_VALUE);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(Byte.MAX_VALUE, beanB.getByteValue());

       beanA.setShortValue((byte)(Byte.MIN_VALUE-1));
		populator.populate(beanA, beanB, mapping, null);
		assertEquals((byte)(Byte.MIN_VALUE-1), beanB.getByteValue());

        beanA.setShortValue((byte)(Byte.MAX_VALUE+1));
		populator.populate(beanA, beanB, mapping, null);
		assertEquals((byte)(Byte.MAX_VALUE+1), beanB.getByteValue());
	}

	public void testLong2Any() {
	
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("intValue", "longValue");

		beanA.setLongValue(0);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(0, beanB.getIntValue());

		beanA.setLongValue(-1);
		populator.populate(beanA,beanB,mapping,null);
		assertEquals(-1,beanB.getIntValue());

	    beanA.setLongValue(1);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(1, beanB.getIntValue());

		beanA.setLongValue(Integer.MIN_VALUE);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(Integer.MIN_VALUE, beanB.getIntValue());

		beanA.setLongValue(Integer.MAX_VALUE);
		populator.populate(beanA, beanB, mapping, null);
		assertEquals(Integer.MAX_VALUE, beanB.getIntValue());

		beanA.setLongValue((int)(Integer.MAX_VALUE+1));
		populator.populate(beanA, beanB, mapping, null);
		assertEquals((int)(Integer.MAX_VALUE+1), beanB.getIntValue());

        beanA.setLongValue((int)(Integer.MIN_VALUE-1));
		populator.populate(beanA, beanB, mapping, null);
		assertEquals((int)(Integer.MIN_VALUE-1), beanB.getIntValue());


		Map<String, String> mapping0 = new HashMap<String, String>();
		mapping0.put("shortValue", "longValue");
		beanA.setLongValue(0);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(0, beanB.getShortValue());

		beanA.setLongValue(-1);
		populator.populate(beanA,beanB,mapping0,null);
		assertEquals(-1,beanB.getShortValue());

	    beanA.setLongValue(1);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(1, beanB.getShortValue());

		beanA.setLongValue(Short.MIN_VALUE);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(Short.MIN_VALUE, beanB.getShortValue());

		beanA.setLongValue(Short.MAX_VALUE);
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals(Short.MAX_VALUE, beanB.getShortValue());

	    beanA.setLongValue((short)(Short.MIN_VALUE-1));
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals((short)(Short.MIN_VALUE-1), beanB.getShortValue());

        beanA.setLongValue((short)(Short.MAX_VALUE+1));
		populator.populate(beanA, beanB, mapping0, null);
		assertEquals((short)(Short.MAX_VALUE+1), beanB.getShortValue());
	}

	public void testBoolean2Any() {
		beanA.setBooleanValue(false);
		populator.populate(beanA, beanB, null, null);
		assertEquals(false, beanB.getBooleanValue());

		beanA.setBooleanValue(true);
		populator.populate(beanA, beanB, null, null);
		assertEquals(true, beanB.getBooleanValue());

		beanA.setBooleanObjValue(Boolean.FALSE);
		populator.populate(beanA, beanB, null, null);
		assertEquals(Boolean.FALSE, beanB.getBooleanObjValue());

		beanA.setBooleanObjValue(Boolean.TRUE);
		populator.populate(beanA, beanB, null, null);
		assertEquals(Boolean.TRUE, beanB.getBooleanObjValue());

		beanA.setBooleanObjValue(Boolean.FALSE);
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("booleanValue", "booleanObjValue");
		populator.populate(beanA,beanB,mapping,null);
		assertEquals(false, beanB.getBooleanValue());

		beanA.setBooleanObjValue(Boolean.TRUE);
		populator.populate(beanA,beanB,mapping,null);
		assertEquals(true, beanB.getBooleanValue());

		beanA.setBooleanValue(false);
		Map<String, String> mapping1 = new HashMap<String, String>();
		mapping1.put("booleanObjValue", "booleanValue");
		populator.populate(beanA,beanB,mapping1,null);
		assertEquals(Boolean.FALSE, beanB.getBooleanObjValue());

		beanA.setBooleanValue(true);
		populator.populate(beanA,beanB,mapping1,null);
		assertEquals(Boolean.TRUE, beanB.getBooleanObjValue());

		beanA.setBooleanArrayValue(new boolean[]{false,true});
		Map<String, String> mapping2 = new HashMap<String, String>();
		mapping2.put("booleanObjArrayValue", "booleanArrayValue");
		populator.populate(beanA,beanB,mapping2,null);
		assertEquals(Boolean.FALSE,beanB.getBooleanObjArrayValue()[0]);
		assertEquals(Boolean.TRUE,beanB.getBooleanObjArrayValue()[1]);

		beanA.setBooleanObjArrayValue(new Boolean[]{Boolean.FALSE,Boolean.TRUE});
		Map<String, String> mapping3 = new HashMap<String, String>();
		mapping2.put("booleanArrayValue", "booleanObjArrayValue");
		populator.populate(beanA,beanB,mapping3,null);
		assertEquals(false,beanB.getBooleanArrayValue()[0]);
		assertEquals(true,beanB.getBooleanArrayValue()[1]);
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

		public boolean getBooleanValue(){
			return booleanValue;
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

		public boolean getBooleanValue(){
			return booleanValue;
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
