package com.techstar.framework.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionServlet;

import com.techstar.framework.exception.BaseException;
import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.service.security.modelout.LoginOut;

/**
 * 基础安全AcitonServlet
 * 
 * @author caojian Jan 30, 2007
 * 
 */
public class SecurityActionServlet extends ActionServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(SecurityActionServlet.class);

	public void init() throws ServletException {
		try {
			super.init();
		} catch (RuntimeException e) {
			if (logger.isDebugEnabled()) {
				logger.debug("Error durring initial of filter: "
						+ e.getMessage());
			}
		}
	}

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			UserProfile userP = (UserProfile) (request.getSession()
					.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
			String sessionUser = (String) request.getSession().getAttribute(
					SecurityContext.SECURITY_USERNAME_SESSION_KEY);
			
			//TODO 专为framework中取权限树，在dims项目中删除
//			处理Portol
			if(StringUtils.isEmpty(sessionUser)){
				String uname = request.getParameter(SecurityContext.SECURITY_USERNAME_SESSION_KEY);
				if(StringUtils.isNotEmpty(uname)){
					sessionUser = uname;
					request.getSession().setAttribute(SecurityContext.SECURITY_USERNAME_SESSION_KEY, uname);
				}
			}
			
			// session中不存在用户权限信息则从cookie中取
			if (userP == null) {
				if (StringUtils.isEmpty(sessionUser)) {
					String cookieUser = this.getUserNameFromCookie(request);
					// cookie和session中均无用户则匿名登录
					if (StringUtils.isEmpty(cookieUser)) {
						// userP = UserProfile.ANONYMOUS;
					} else {
						userP = new UserProfile();
						userP = this.authenticate(userP, cookieUser);
						request.getSession().setAttribute(
								SecurityContext.SECURITY_USERNAME_SESSION_KEY,
								cookieUser);
					}
				} else {
					userP = new UserProfile();
					userP = this.authenticate(userP, sessionUser);
					this.setUserNameToCookie(response, sessionUser);
				}
			}
			if (userP != null) {
				request.getSession().setAttribute(
						SecurityContext.SECURITY_AUTHENTICATION_KEY, userP);
				ServiceLocator.setUserProfile(userP);
				String token = processToken(request, userP);
				ServiceLocator.setToken(token);
			}
		} catch (Exception e) {
			this.clearCookie(request, response);
			logger.error(e.getMessage(), e);
		}
		super.process(request, response);
	}

	/**
	 * @param request
	 * @param userP
	 * @return
	 * @throws BaseException
	 */
	private String processToken(HttpServletRequest request, UserProfile userP)
			throws BaseException {
		String token = (String) request.getSession().getAttribute(
				SecurityContext.SECURITY_TOKEN_KEY);
		if (StringUtils.isEmpty(token)) {
			token = ServiceLocator.getToken();
			if (StringUtils.isEmpty(token)) {
//				IWSAuthService auth = (IWSAuthService) ServiceLocator
//						.getInstance().getService("iWSAuthService");
				
				ISecurityService security = ServiceLocator.getSecurityService();
				LoginOut login = security.singleLogin(userP.getUserName());
				token = login.getUSERINFO().getTOKEN();
			}
			request.getSession().setAttribute(
					SecurityContext.SECURITY_TOKEN_KEY, token);
		}
		return token;
	}

	/**
	 * 验证用户
	 * 
	 * @param up
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	private UserProfile authenticate(UserProfile up, String userName)
			throws Exception {
		ISecurityService iSecurity = (ISecurityService) ServiceLocator
				.getInstance().getService("iSecurityService");
		up.setUserName(userName);
		up = iSecurity.authenticate(up);
		return up;
	}

	/**
	 * 从cookie中取当前登录用户名称
	 * 
	 * @param request
	 * @return
	 */
	private String getUserNameFromCookie(HttpServletRequest request) {
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return userName;
		int len = cookies.length;
		for (int i = 0; i < len; i++) {
			if (SecurityContext.SECURITY_USERNAME_COOKIE_KEY.equals(cookies[i]
					.getName())) {
				userName = cookies[i].getValue();
			}
		}
		return userName;
	}

	/**
	 * 将用户名存在cookie中
	 * 
	 * 
	 * 
	 * @param response
	 * @param userName
	 */
	private void setUserNameToCookie(HttpServletResponse response,
			String userName) {
		Cookie c = new Cookie(SecurityContext.SECURITY_USERNAME_COOKIE_KEY,
				userName);
		response.addCookie(c);
	}

	/**
	 * 退出程序
	 * 
	 * 
	 * 
	 * @param request
	 * @param reponse
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		clearSession(request, response);
		clearCookie(request, response);
	}

	/**
	 * 清除session中用户
	 * 
	 * 
	 * 
	 * @param request
	 * @param response
	 */
	private void clearSession(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute(
				SecurityContext.SECURITY_AUTHENTICATION_KEY, null);
		request.getSession().setAttribute(
				SecurityContext.SECURITY_USERNAME_SESSION_KEY, null);
		request.getSession().invalidate();

		ServiceLocator.setUserProfile(null);
	}

	/**
	 * 清除cookie中用户
	 * 
	 * 
	 * 
	 * @param request
	 * @param response
	 */
	private void clearCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			int len = cookies.length;
			for (int i = 0; i < len; i++) {
				if (SecurityContext.SECURITY_USERNAME_COOKIE_KEY
						.equals(cookies[i].getName())) {
					// get the exact auth cookie
					cookies[i].setMaxAge(0); // delete the cookie now!
					response.addCookie(cookies[i]);
				}
			}
		}
	}
}