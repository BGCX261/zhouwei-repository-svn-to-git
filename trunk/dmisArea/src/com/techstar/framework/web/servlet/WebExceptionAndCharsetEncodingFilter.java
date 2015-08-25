package com.techstar.framework.web.servlet;

/**
 * 统一处理web异常的filter
 * 并统一处理字符串
 * Sep 11, 2006
 * @author xcf
 * @author sbt 2006-12-11
 */
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.techstar.framework.exception.BaseException;

public class WebExceptionAndCharsetEncodingFilter implements Filter {
	private FilterConfig config = null;

	private String defaultEncode = "UTF-8";

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		if (config.getInitParameter("Charset") != null) {
			defaultEncode = config.getInitParameter("Charset");
		}
	}

	public void destroy() {
		this.config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		try {
			req.setCharacterEncoding(defaultEncode);
			chain.doFilter(request, response);
		} catch (Exception ce) {
			// 记录日志
			if (ce instanceof BaseException) {
				Logger logger = Logger.getLogger("error");
				BaseException basece = (BaseException) ce;
				logger.error("截获web自定义异常:" + basece.getErrorCode() + "_"
						+ basece.getMessage(), ce);
				rep.sendRedirect(req.getContextPath() + "/pages/error.jsp");
			} else {
				Logger logger = Logger.getLogger("error");
				logger.error("截获web异常", ce);
				rep.sendRedirect(req.getContextPath() + "/pages/error.jsp");
			}
		}
	}
}
