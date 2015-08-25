package com.sitechasia.webx.core.support;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.sitechasia.webx.core.support.Page;

/**
 */
public class PageTest extends TestCase {
	Page page ;
	Page page1 ;
	public void setUp() throws Exception{
		super.setUp();
		page = new Page();
		page1=new Page(500, 1512, 25, new ArrayList());
	}
	
	public void tearDown() throws Exception{
		super.tearDown();
	}
	public void testWithDefaultData() throws Exception {
		
		assertEquals(0, page.getTotalPageCount());
		assertEquals(1, page.getCurrentPageNo());
		assertFalse(page.hasNextPage());
		assertFalse(page.hasPreviousPage());
	}

	public void testWithSimpleData() throws Exception {
		Page page = new Page(0, 100, 20, new ArrayList());
		assertEquals(5, page.getTotalPageCount());
		assertEquals(1, page.getCurrentPageNo());
		assertTrue(page.hasNextPage());
		assertFalse(page.hasPreviousPage());
	}

	public void testWithNormalData() throws Exception {
		Page page = new Page(316, 1512, 25, new ArrayList());
		assertEquals(61, page.getTotalPageCount());
		assertEquals(13, page.getCurrentPageNo());
		assertEquals(page.getPageSize(),25);
		assertEquals(page.getTotalCount(),1512);
		assertTrue(page.hasNextPage());
		assertTrue(page.hasPreviousPage());
	}

	public void testGetStartOfPage() throws Exception {
		assertEquals(0, Page.getStartOfPage(1, 20));
		assertEquals(0,Page.getStartOfPage(1));
		assertEquals(20,Page.getStartOfPage(2));
		assertEquals(25,Page.getStartOfPage(2,25));
	}
	
	public void testGetEndIndex(){
		Page page = new Page(6, 10, 6, new ArrayList());
		assertEquals(page.getEndIndex(),9);
		
		assertEquals(page1.getEndIndex(),21*25-1);
		assertTrue(page1.isEmpty());
	}

	public void testGetStartIndex(){
		assertEquals(page.getStartIndex(),0);
		assertEquals(page1.getStartIndex(),500);
		}
	
	public void testSetGetlist(){
		ArrayList list=new ArrayList();
		page.setResult(list);
		assertTrue(page.getResult() instanceof ArrayList);
		
		
	}
}
