package com.sitechasia.webx.web.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartResolver;

public class WebxFileUploadFilter implements Filter {

	protected static final Log log = LogFactory
			.getLog(WebxFileUploadFilter.class);

	private MultipartResolver multipartResolver;

	public MultipartResolver getMultipartResolver() {
		if (this.multipartResolver == null)
			new MultipartException("multipartResolver is null");
		return this.multipartResolver;
	}

	public void setMultipartResolver(MultipartResolver multipartResolver) {
		this.multipartResolver = multipartResolver;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse,
			FilterChain chain) {
		try {
			WebxFileUploadUtil.doFileUpload(getMultipartResolver(),
					(HttpServletRequest) request);
		} catch (MultipartException e) {
			log.error(ExceptionUtils.getFullStackTrace(e));
		} finally {
			try {
				chain.doFilter(request, reponse);
			} catch (IOException e) {
				log.error(ExceptionUtils.getFullStackTrace(e));
			} catch (ServletException e) {
				log.error(ExceptionUtils.getFullStackTrace(e));
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
