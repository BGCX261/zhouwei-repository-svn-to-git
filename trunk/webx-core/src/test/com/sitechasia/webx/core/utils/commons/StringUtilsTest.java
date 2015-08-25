package com.sitechasia.webx.core.utils.commons;

import junit.framework.TestCase;
import com.sitechasia.webx.core.utils.commons.StringUtils;

/**
 * <p>Title: StringUtilsTest</p>
 * <p>Description: 字符串工具类单元测试</p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class StringUtilsTest extends TestCase {

	public void setUp() throws Exception{
		super.setUp();
	}
	
	public void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testKillNull(){
		assertEquals("", StringUtils.killNull(null));
		assertEquals("", StringUtils.killNull("NULL"));
		assertEquals("string", StringUtils.killNull("string"));
	}
	
	public void testTrim(){
		assertEquals("abc", StringUtils.trim(" abc "));
		assertEquals("", StringUtils.trim("NULL"));
	}
	
	public void testStringToASCII(){
		assertEquals("9748655766746780", StringUtils.stringToASCII("a0A9BICO"));
	}
	
	public void testIsStrLegal(){
		assertTrue(StringUtils.isStrLegal("aa", new String[] { "fsdf", "cd",
				"tyut", "aa" }));
		assertFalse(StringUtils.isStrLegal("aba", new String[] { "fsdf", "cd",
				"tyut", "aa" }));
		assertTrue(StringUtils.isStrLegal("myce.net.cn", 10, 20));
		assertFalse(StringUtils.isStrLegal(" ", 10, 20));
	}
	
	public void testIsStrLegalOrEmpty(){
		assertTrue(StringUtils.isStrLegalOrEmpty("myce", 4));
		assertFalse(StringUtils.isStrLegalOrEmpty("myce", 3));
		assertTrue(StringUtils.isStrLegalOrEmpty(null, 10));
	}
	
	public void testIsNumLegal(){
		assertTrue(StringUtils.isNumLegal("65465746870"));
		assertTrue(StringUtils.isNumLegal("5477300800",5,10));
		assertFalse(StringUtils.isNumLegal("7567HFGH767"));
	}
	
	public void testIsDateLegal(){
		assertTrue(StringUtils.isDateLegal("2007-02-01"));
		assertFalse(StringUtils.isDateLegal(""));
		assertFalse(StringUtils.isDateLegal("2007-0-12-01"));
		assertFalse(StringUtils.isDateLegal("07-02-01"));
		assertFalse(StringUtils.isDateLegal("2oo7-09-01"));
	}
	
	public void testReplace(){
		assertEquals("myce.net.cn", StringUtils.replace("myce.NET.cn", "NET",
		"net"));
		assertEquals("myce.net.cnnetnet", StringUtils.replace("myce.NET.cnNETNET", "NET","net",false));
	}
	
	public void testReplaceHtmlCode(){
		assertEquals("", StringUtils.replaceHtmlCode(""));
		assertEquals("&ltscript", StringUtils.replaceHtmlCode("<script"));
		assertEquals("&lt/script", StringUtils.replaceHtmlCode("</script"));
		assertEquals("&ltmarquee", StringUtils.replaceHtmlCode("<marquee"));
		assertEquals("&lt/marquee", StringUtils.replaceHtmlCode("</marquee"));
		assertEquals("<BR>", StringUtils.replaceHtmlCode("\r\n"));
		assertEquals("FGDF_onbeforeunloadGFDG", StringUtils
				.replaceHtmlCode("FGDFonbeforeunloadGFDG"));
	}
	
	public void testReplaceHtmlToText(){
		assertEquals("&lthtml&gt", StringUtils.replaceHtmlToText("<html>"));
		assertEquals("ht&ampml", StringUtils.replaceHtmlToText("ht&ml"));
		assertEquals("myce", StringUtils.replaceHtmlToText("my\nce\r"));
	}
	
	public void testSetNbsp(){
		assertEquals("my&nbsp;ce&nbsp;", StringUtils.setNbsp("my ce "));
	}
	
	public void testToChi(){
		assertEquals("myce", StringUtils.toChi("myce"));
	}
	
	public void testReplaceSql(){
		assertEquals("where name=''majing''", StringUtils.replaceSql("where name='majing'"));
	}
	
	public void testEncode(){
		assertEquals("html", StringUtils.encode("html"));
	}
	
	public void testSmilies(){
		assertEquals("abc<IMG border=0 SRC=images/brow/regular_smile.gif>abc",StringUtils.smilies("abc/:)abc"));
	}
	
	public void testGetExtension(){
		assertEquals("java", StringUtils.getExtension("D:/eclipse/workspace/core/test.JAVA"));
	}
	
	public void testGetPrefix(){
		assertEquals("mashaojing", StringUtils.getPrefix("mashaojing.doc"));
	}
}
