package com.sitechasia.webx.core.utils.commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.sitechasia.webx.core.utils.commons.ConfigFileUtils;

import junit.framework.TestCase;

public class ConfigFileUtilsTest extends TestCase {

	public File file;

	public void setUp() throws Exception{
		super.setUp();
		//super.fail();
	}

	public void tearDown() throws Exception{
		super.tearDown();
	}

	public void testSaveReadandDeleteProperties() throws IOException{
		file=new File("test.properties");
		file.createNewFile();
		Map<String, String> map = new HashMap<String, String>();
	    map.put("年龄","２７");
	    map.put("姓名","马静");
	    map.put("name","mary");
	    ConfigFileUtils.saveProperties(file,map,null);
	    Properties pro=ConfigFileUtils.readProperties(file);
	    assertEquals(pro.getProperty("姓名"),"马静");
	    assertEquals(pro.getProperty("年龄"),"２７");
	    assertEquals(pro.getProperty("name"),"mary");
	    ConfigFileUtils.deleteProperties(file,"name");
		pro=ConfigFileUtils.readProperties(file);
		assertEquals(pro.getProperty("name"),null);
	}
}

