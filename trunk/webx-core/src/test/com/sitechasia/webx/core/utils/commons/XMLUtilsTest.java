package com.sitechasia.webx.core.utils.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.TestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.sitechasia.webx.core.utils.commons.XMLUtils;

/**
 * <p>Title: XMLUtilsTest</p>
 * <p>Description:XML工具类的单元测试 </p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class XMLUtilsTest extends TestCase {

	String pathname;
	Element RootElement;
	protected void setUp() throws Exception {
		super.setUp();
		pathname = XMLUtilsTest.class.getResource("/com/sitechasia/webx/core/utils/commons/book.xml").getFile();
		RootElement=XMLUtils.getRootElement(pathname);
	}

	protected void tearDown() throws Exception {
		pathname="";
		RootElement=null;
		super.tearDown();
	}

	public void testNewDocument(){
		assertTrue(XMLUtils.newDocument() instanceof Document);
	}
	
	public void testCreateRootElement(){
		assertTrue(XMLUtils.createRootElement("myce") instanceof Element);
	}
	
	public void testGetRootElement() throws FileNotFoundException{
		
		assertEquals(RootElement.getNodeName(),"books");
		assertNull(XMLUtils.getRootElement(""));
		
		File file=new File(pathname);
		InputStream is=new FileInputStream(file);
		Element rootElement=XMLUtils.getRootElement(new InputSource(is));
		assertEquals(rootElement.getNodeName(),"books");
		InputStream is1=null;
		InputSource isource=null;
		assertNull(XMLUtils.getRootElement(is1));
		assertNull(XMLUtils.getRootElement(isource));
	}
	
	public void testGetChildElements(){
		Element element=null;
		assertNull(XMLUtils.getChildElements(element));
		assertNull(XMLUtils.getChildElements(element,"name"));
		Element[] elements=XMLUtils.getChildElements(RootElement);

		assertEquals(elements.length,3);
		assertTrue(elements[0].hasAttributes());
		assertEquals(elements[0].getAttributeNode("email").getNodeName(),"email");
		assertEquals(elements[0].getAttribute("email"),"mashaojing@myce.net.cn");
		assertFalse(elements[1].hasAttributes());
		assertTrue(elements[0].hasChildNodes());
		assertTrue(elements[1].hasChildNodes());
		assertEquals(elements[0].getNodeName(),"book");
		assertEquals(elements[1].getNodeName(),"book1");
		
		Element[] childelements=XMLUtils.getChildElements(RootElement,"book");
		assertEquals(childelements.length,2);
		Element element0=childelements[0];
		Element element1=childelements[1];

		assertTrue(element0.hasAttributes());
		assertFalse(element1.hasAttributes());
		assertEquals(element1.getNodeName(),"book");
		assertEquals(XMLUtils.getChildElements(elements[1]).length,2);
		assertEquals(XMLUtils.getChildElements(elements[1],"name1").length,1);
		assertEquals(XMLUtils.getChildElements(RootElement,"javabook").length,0);
		
	}
	
	public void testGetElementValues(){
		Element element=null;
		assertNull(XMLUtils.getElementValues(element));
		assertNull(XMLUtils.getElementValue(element));
		
		Element[] elements=XMLUtils.getChildElements(RootElement);
		Element[] grandsonElements=XMLUtils.getChildElements(elements[1]);
		assertEquals(XMLUtils.getElementValues(grandsonElements[1])[0],"20");
		assertEquals(XMLUtils.getElementValue(grandsonElements[1]),"20");
	}
	
	public void testGetChildElement(){
		Element element=null;
		assertNull(XMLUtils.getChildElement(element));
		assertNull(XMLUtils.getChildElement(element,"book"));
		Element bookelement=XMLUtils.getChildElement(RootElement,"book");
		Element book1element=XMLUtils.getChildElement(RootElement,"book1");
		assertTrue(bookelement.hasAttributes());
		assertFalse(book1element.hasAttributes());
		assertEquals(XMLUtils.getChildElement(RootElement).getNodeName(),"book");
		
		Element[] elements=XMLUtils.getChildElements(RootElement);
		assertEquals(XMLUtils.getChildElement(elements[0]).getNodeName(),"name");
		assertEquals(XMLUtils.getChildElement(elements[1]).getNodeName(),"name1");
	}
	
	public void testGetChildNodes(){
		Node node=null;
		assertNull(XMLUtils.getChildNodes(node));
		Element[] elements=XMLUtils.getChildElements(RootElement);
		assertEquals(XMLUtils.getChildNodes(RootElement).length,7);
		assertEquals(XMLUtils.getChildNodes(elements[0]).length,5);
	}
	
	public void testFindElementByAttr(){
		Element element=null;
		assertNull(XMLUtils.findElementByAttr(element,"NAME","name"));
		assertEquals(XMLUtils.findElementByAttr(RootElement,"email","mashaojing@myce.net.cn").getNodeName(),"book");
		assertEquals(XMLUtils.findElementByAttr(RootElement,"date","2007-07-22",true).getNodeName(),"price1");
		   
	}
	
	public void testGetAttribute(){
		XMLUtils.setAttribute(RootElement,"fff","ggg");
		assertEquals(XMLUtils.getAttribute(RootElement,"fff"),"ggg");
		assertEquals(XMLUtils.getAttribute(RootElement,"","aaa"),"aaa");
		
	}
	
	public void testFindElementByName(){
		Element[] elements=XMLUtils.getChildElements(RootElement);
		assertEquals(XMLUtils.findElementByName(RootElement,"price").getFirstChild().getNodeValue(),"36");
	    assertEquals(XMLUtils.findElementByName(RootElement,"name").getNodeName(),"name");
	    assertEquals(XMLUtils.findElementByName(RootElement,"book").getAttribute("email"),"mashaojing@myce.net.cn");
	    assertTrue(XMLUtils.findElementByName(RootElement,"book1").hasChildNodes());
	    assertEquals(XMLUtils.findElementByName(elements[1],"price1").getFirstChild().getNodeValue(),"20");
	    assertNull(XMLUtils.findElementByName(RootElement,""));
	    assertNull(XMLUtils.findElementByName(elements[1],""));
	}
	
	public void testFormatXml(){
		assertEquals(XMLUtils.formatXml(RootElement).substring(2,5),"xml");
	}
	
	public void testTransformerWrite() throws Exception{
		RootElement=XMLUtils.getRootElement(pathname);
		XMLUtils.transformerWrite(RootElement,pathname);
	 }
	
	public void testTransformerWriteWithFile() throws Exception{
		File file=new File(pathname);
		RootElement=XMLUtils.getRootElement(pathname);
		XMLUtils.transformerWrite(RootElement,file);
	}
}
