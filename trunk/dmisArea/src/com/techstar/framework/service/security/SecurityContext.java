package com.techstar.framework.service.security;

/**
 *
 * @author caojian Jan 31, 2007
 *
 */
public class SecurityContext {

	public static final String SECURITY_USERNAME_COOKIE_KEY="SECURITY_USERNAME_COOKIE";
	public static final String SECURITY_USERNAME_SESSION_KEY="username";
	
	public static final String SECURITY_AUTHENTICATION_KEY ="SECURITY_AUTHENTICATION";
	public static final String SECURITY_TOKEN_KEY ="SECURITY_TOKEN_KEY";
	
	
	//综合检修计划菜单父ID
	public static  String SECURITY_IMRP_MENU_KEY = "99999";
	
	
	
	
	
	public static final String SECURITY_FORM_USERNAME_KEY = "j_username";
	public static final String SECURITY_FORM_PASSWORD_KEY = "j_password";
	public static final String SECURITY_FORM_URL_KEY = "/j_security_check";
	public static final String SECURITY_TARGET_URL_KEY = "SECURITY_TARGET_URL";
	public static final String SECURITY_LAST_EXCEPTION_KEY ="SECURITY_LAST_EXCEPTION";
	

	public static final String SECURITY_AUTHENTICATION_COOKIE_KEY="SECURITY_AUTHENTICATION_COOKIE";

	public static final String SECURITY_WELCOMENEW_KEY ="SECURITY_WELCOMENEW";
	public static final String SECURITY_WELCOMENEW_COOKIE_KEY="SECURITY_WELCOMENEW_COOKIE";
  	
	public static final String SECURITY_LOGIN_FAILED_URL_KEY ="/login_failed.jsp";	
	public static final String DEFAULT_INDEX_FORM_URL_KEY = "/index.do";
	public static final String DEFAULT_LOGINFORM_URL_KEY = "/login.jsp";
	public static final String DEFAULT_LOGOUTFORM_URL_KEY = "/login.jsp"; 
	public static final String CHANGE_PASSWD_URL_KEY = "/changePassword.jsp";
	public static final String SECURITY_DENY_URL_KEY = "/forbidden.jsp";
	public static final String SECURITY_LOGOUT_KEY = "/logout.do";
	public static final String SECURITY_LOGIN_KEY = "/login.do";
	public static final String USER_MENU_KEY = "session.menu.key";	//store user's login menu
	
	//indication for userprofile status (The value mean: the account is avaliable)
	public static final String USER_LOCKED_STATUS = "1";//用户锁定状态 0--锁定 1--未锁定（默认）
	public static final String PASSWORD_EXPIRED_STATUS = "1";
	public static final String USER_FORBIDDEN_STATUS = "1";//用户禁用标记 0--禁用1--未禁用（默认）
	public static final String USER_INVALID_STATUS = "1";//用户过期标记 0--过期1--未过期（默认）
	
	public static final String SYSADMIN_ROLE_ID = "1000000000";
	public static final String ANONYMOUS_ID = "100001";
	
	public static final String SECURITY_RULE_NAME = "securityRuleName";//安全注册中业务规则名称

}
