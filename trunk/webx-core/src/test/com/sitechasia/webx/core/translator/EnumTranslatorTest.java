package com.sitechasia.webx.core.translator;


import com.sitechasia.webx.core.translator.EnumTranslatorImpl;
import com.sitechasia.webx.core.translator.EnumTranslatorEntry;

import junit.framework.TestCase;

public class EnumTranslatorTest extends TestCase {
	
	EnumTranslatorImpl et = new EnumTranslatorImpl();
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		EnumTranslatorEntry item0 = new EnumTranslatorEntry();
		item0.setValue("F");
		item0.setLable("女");
		EnumTranslatorEntry item1 = new EnumTranslatorEntry();
		item1.setValue("M");
		item1.setLable("男");
		this.et.addItem(item0);
		this.et.addItem(item1);
		
	}

	public void testTranslate() {
		Object target = et.translateAsString("F");
		System.out.println(target.toString());
		super.assertEquals(target, "女");
		super.assertEquals(et.translate("M"), "男");
	}

	public void testTranslateAsString() {
		String target = et.translateAsString("F");
		super.assertEquals(target, "女");
	}

	public void testSize() {
		super.assertEquals(2, this.et.size());
	}
	
}
