package com.sitechasia.webx.core.web.i18n;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletMock extends GenericServlet{

	public GenericServletMock(){}

	public void destory(){

	}

	public String getInitParameter(String name){

		return "zh;zh_CN;";
	}

	public Enumeration getInitParameterNames() {
		return null;
	}

	public ServletConfig getServletConfig(){
		return null;
	}

	public ServletContext getServletContext(){
		ServletContextMock contextMock = new ServletContextMock();
		return contextMock;
	}

	public String getServletInfo(){
		return null;
	}

	public String getServletName(){
		return null;
	}

	public void init(){

	}

	public void init(ServletConfig config){

	}

	public void log(String msg){

	}

	public void log(String message, Throwable t){

	}

	public void service(ServletRequest req, ServletResponse res){}

	class ServletContextMock implements ServletContext{

		public Object getAttribute(String arg0) {
			return null;
		}

		public Enumeration getAttributeNames() {
			return null;
		}

		public ServletContext getContext(String arg0) {
			return null;
		}

		public String getInitParameter(String arg0) {
			return null;
		}

		public Enumeration getInitParameterNames() {
			return null;
		}

		public int getMajorVersion() {
			return 0;
		}

		public String getMimeType(String arg0) {
			return null;
		}

		public int getMinorVersion() {
			return 0;
		}

		public RequestDispatcher getNamedDispatcher(String arg0) {
			return null;
		}

		public String getRealPath(String arg0) {
			String s = FileUtils.getAppPath(GenericServletMock.class);
			return s;
		}

		public RequestDispatcher getRequestDispatcher(String arg0) {
			return null;
		}

		public URL getResource(String arg0) throws MalformedURLException {
			return null;
		}

		public InputStream getResourceAsStream(String arg0) {
			return null;
		}

		public Set getResourcePaths(String arg0) {

			return null;
		}

		public String getServerInfo() {

			return null;
		}

		public Servlet getServlet(String arg0) throws ServletException {

			return null;
		}

		public String getServletContextName() {

			return null;
		}

		public Enumeration getServletNames() {

			return null;
		}

		public Enumeration getServlets() {

			return null;
		}

		public void log(String arg0) {

		}

		public void log(Exception arg0, String arg1) {

		}

		public void log(String arg0, Throwable arg1) {

		}

		public void removeAttribute(String arg0) {

		}

		public void setAttribute(String arg0, Object arg1) {

		}

	}
}
