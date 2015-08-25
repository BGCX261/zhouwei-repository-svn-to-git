package com.techstar.framework.utils;

import java.net.URL;
import java.util.Properties;

import com.techstar.framework.ClassLoaderHelper;

/**
 * 提供相关项目应用程序使用的方法
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author xcf
 * @version 1.0
 */
public class AppHelper {
	private AppHelper() {
	}

	/**
	 * 得到web目录所在的绝对路径
	 * 
	 * @return String web目录所在的绝对路径 eg. E:/work/framework/WebRoot
	 */
	public static String getWebAppPath() {
		AppHelper util = new AppHelper();
		Properties prop = ClassLoaderHelper.getProperties("../system.properties");
		
		String type = (String)prop.get("system.type");
		/*
		 * like:
		 * E:\\work\\framework\\WebRoot\\WEB-INF\\classes\\com\\techstar\\framework\\utils
		 */
		String clazzFilePath = util.getClassFilePath();
		String webPath = clazzFilePath.substring(0, clazzFilePath
				.indexOf("WEB-INF"));
		
		if( webPath.indexOf("file:")!=-1 ){
			webPath = webPath.substring(webPath.indexOf("file:")+6 , webPath.length());
		}
		
		if(type.equals("unix")){
			webPath = "//" + webPath; 
		}	
		System.out.println( "$$$$$$$$$$$$$$" +webPath );
		return webPath;

	}

	/**
	 * 获取classes文件的绝对路径
	 * 
	 * @return String
	 */
	private String getClassFilePath() {
		String strClassName = getClass().getName();
		String strPackageName = "";
		if (getClass().getPackage() != null) {
			strPackageName = getClass().getPackage().getName();
		}
		String strClassFileName = "";
		if (!"".equals(strPackageName)) {
			strClassFileName = strClassName.substring(
					strPackageName.length() + 1, strClassName.length());
		} else {
			strClassFileName = strClassName;
		}
		URL url = null;
		url = getClass().getResource(strClassFileName + ".class");

		String strURL = url.getFile();
		try {
			strURL = java.net.URLDecoder.decode(strURL, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		/*
		 * strURL = strURL.substring(strURL.indexOf('/') + 1,
		 * strURL.lastIndexOf('/'))
		 */;

		return strURL;
	}

	private String getClassPackageName() {
		String strClassName = getClass().getName();
		String strPackageName = "";
		if (getClass().getPackage() != null) {
			strPackageName = getClass().getPackage().getName();
		}

		return strPackageName;
	}

	public static String getPackageName() {
		AppHelper util = new AppHelper();
		/*
		 * like:
		 * E:\\work\\framework\\WebRoot\\WEB-INF\\classes\\com\\techstar\\framework\\utils
		 */
		String strPackageName = util.getClassPackageName();
		return strPackageName;
	}

	public static String getSpringConfigFilePath() {
		String springConfigFilePath = getWebAppPath() + "WEB-INF//spring//applicationContext.xml";
		return springConfigFilePath;
	}
	
	public static String getSpringConfigFilePathForBuss() {
		String springConfigFilePath = getWebAppPath() + "WEB-INF//spring//applicationContext_dmis_service.xml";
		return springConfigFilePath;
	}
	
	public static String changISO(String data) {

	    String s1 = "";
	    try {
	      byte[] temp = data.getBytes();
	      s1 = new String(temp, "iso-8859-1");
	    }
	    catch (Exception e) {}
	    return s1;
	  }

	  public static String changeGB2312(String data) {
	    String s1 = "";

	    try {

	      byte[] temp = data.getBytes("ISO8859-1");
	      s1 = new String(temp, "GB2312");
	    }
	    catch (Exception e) {
	      System.out.println("catch change exception" + e);
	    }
	    return s1;
	  }

	  public static String changeGBK(String data) {
	    String s1 = "";

	    try {

	      byte[] temp = data.getBytes("ISO8859-1");
	      s1 = new String(temp, "GBK");
	    }
	    catch (Exception e) {
	      System.out.println("catch change exception" + e);
	    }
	    return s1;
	  }
	  

	public static void main(String[] args) {
		// System.out.println(AppHelper.getWebAppPath());
		System.out.println(AppHelper.getPackageName());
		System.out.println(AppHelper.getSpringConfigFilePath());
	}
}
