package com.sitechasia.webx.core.utils.commons;

import javax.servlet.http.Cookie;
import junit.framework.TestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import com.sitechasia.webx.core.utils.commons.WebUtils;

/**
	 * <p>Title: WebUtilsTest</p>
	 * <p>Description: WebUtils单元测试类</p>
	 *
	 * @author mashaojing
	 * @version 1.0
	 */
	public class WebUtilsTest extends TestCase {

		MockHttpServletRequest request=null;

		protected void setUp() throws Exception {
			super.setUp();
			request=new MockHttpServletRequest();
		}

		protected void tearDown() throws Exception {
			super.tearDown();
		}

		public void testGetCookieArrtibute() {

			Cookie[] cookieArray =new Cookie[1];
			Cookie cookie = new Cookie("name", "shaojing");
			cookieArray[0]=cookie;
			request.setCookies(cookieArray);
			assertEquals(WebUtils.getCookieArrtibute(request, "name"), "shaojing");
		}

		public void testGetRequestAttribute() {
			request.setAttribute("sex", "woman");
			request.setAttribute("age", 22);
			request.setAttribute("a", 'a');
			assertEquals(
					WebUtils.getRequestAttribute(request, "sex", String.class),
					"woman");
			assertEquals(WebUtils.getRequestAttribute(request, "age", int.class)
					.intValue(), 22);
			assertEquals(WebUtils.getRequestAttribute(request, "a", char.class)
					.charValue(), 'a');
		}

		public void testGetOrCreateSessionAttribute() {
			WebUtils.getOrCreateSessionAttribute(request, "birthday", String.class);
			request.setAttribute("birthday", "19800125");
			assertEquals(WebUtils.getRequestAttribute(request, "birthday",
					String.class), "19800125");
		}

		public void testGetHostname() {
			request.setRequestURI("http://localhost:8080/admin/");
			assertEquals(WebUtils.getHostname(request), "localhost");
			request.setServerName("myce");
			assertEquals(WebUtils.getHostname(request), "myce");
		}

		public void testGetReferer() {
			request.addHeader("Referer", "http://localhost:8080");
			assertEquals(WebUtils.getReferer(request), "http://localhost:8080");
		}

		public void testGetUserAgent() {
			request.addHeader("User-Agent", "firefox");
			assertEquals(WebUtils.getUserAgent(request), "firefox");
		}

		public void testGetHeaderAttribute() {
			request.addHeader("Referer", "http://www.myce.net.cn");
			assertEquals(WebUtils.getHeaderAttribute(request, "Referer"),
					"http://www.myce.net.cn");
		}

		public void testGetHeaderAttributeArray(){
			request.addHeader("url", "http://www.myce.net.cn");
			request.addHeader("url", "http://172.20.80.67");
			assertEquals(WebUtils.getHeaderAttributeArray(request, "url")[0],
					"http://www.myce.net.cn");
			assertEquals(WebUtils.getHeaderAttributeArray(request, "url")[1],
			"http://172.20.80.67");
		}
	}


