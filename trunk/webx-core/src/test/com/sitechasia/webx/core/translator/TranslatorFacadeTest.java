package com.sitechasia.webx.core.translator;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TranslatorFacadeTest extends TestCase {

	protected void setUp() throws Exception {
		XMLEnumTranslatorBuilder xetb = new XMLEnumTranslatorBuilder();
		String path = "classpath:com/sitechasia/webx/core/translator/dictionary.xml";
		String path2 = "classpath:com/sitechasia/webx/core/translator/dic2.xml";
		List<String> paths = new ArrayList<String>();
		paths.add(path);
		paths.add(path2);
		xetb.setFilepaths(paths);
		xetb.afterPropertiesSet();
	}

	public void testTranslateStringObject() {
		Object xx = TranslatorFacade.getInstance().translate("sex", "F");
		super.assertEquals("美女", xx);
	}

	public void testTranslateAsStringStringObject() {
		String xx = TranslatorFacade.getInstance().translateAsString("sex", "F");
		super.assertEquals("美女", xx);
		String tt = TranslatorFacade.getInstance().translateAsString("country", "101");
		super.assertEquals("美国", tt);
		
		String zz = TranslatorFacade.getInstance().translateAsString("test", "xx");
		super.assertEquals("嘻嘻", zz);
	}
	
	public void testGetTranslator()
	{
		EnumTranslator et = (EnumTranslator)TranslatorFacade.getInstance().getTranslator("sex");
		List<EnumTranslatorEntry> list = et.getItems();
		for(int i=0;i<list.size();i++){
			EnumTranslatorEntry entry = list.get(i);
			System.out.println(entry.getValue().toString()+"["+entry.getLable().toString()+"]");
		}
	}
	
	public void testNomalTranslator()
	{
		MockTranslator mt = new MockTranslator();
		TranslatorFacade.getInstance().register(mt);
		
		String zz = TranslatorFacade.getInstance().translateAsString("test", "xx");
		super.assertEquals("嘻嘻", zz);
		String aa = TranslatorFacade.getInstance().translateAsString("testmock", 58);
		String bb = TranslatorFacade.getInstance().translateAsString("testmock", 100);
		String cc = TranslatorFacade.getInstance().translateAsString("testmock", 132);
		String dd = TranslatorFacade.getInstance().translateAsString("testmock", 258);
		String ee = TranslatorFacade.getInstance().translateAsString("testmock", 300);
		String ff = TranslatorFacade.getInstance().translateAsString("testmock", 384);
		super.assertEquals("新手上路", aa);
		super.assertEquals("熟练工", bb);
		super.assertEquals("熟练工", cc);
		super.assertEquals("熟练工", dd);
		super.assertEquals("高级工", ee);
		super.assertEquals("高级工", ff);
	}

}
