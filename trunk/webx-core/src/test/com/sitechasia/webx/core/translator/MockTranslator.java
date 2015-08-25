/**
 * Create time 2007-12-11 下午12:11:09
 */
package com.sitechasia.webx.core.translator;

/**
 * <p>Title: MockTranslator</p>
 * <p>Description: </p>
 * 模拟一个转换器，形势如下：
 * 100分以下，对应字符串 新手上路
 * 100-300，对象以符串 熟练工
 * 300分以上，对象字符串 高级工
 * @author Steven
 * @version 1.0
 */
public class MockTranslator implements Translator {
	
	private static final String name = "testmock";

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#translate(java.lang.Object)
	 */
	public Object translate(Object obj) {
		
		return translateAsString(obj);
	}

	/* (non-Javadoc)
	 * @see com.sitechasia.webx.core.translator.Translator#translateAsString(java.lang.Object)
	 */
	public String translateAsString(Object obj) {
		if(obj==null)
			return "";
		int value = ((Integer)obj).intValue();
		String target = "";
		if(value<100){
			target = "新手上路";
		}
		else if(value<300){
			target = "熟练工";
		}
		else{
			target = "高级工";
		}
		return target;
	}

}
