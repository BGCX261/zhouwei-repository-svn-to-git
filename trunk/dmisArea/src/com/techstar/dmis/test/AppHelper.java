package com.techstar.dmis.test;

import java.net.URL;

/**
 * 提供相关项目应用程序使用的方法
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author ${name}
 * @version 1.0
 */
public class AppHelper{
    private AppHelper() {
    }


    /**
     * 得到web目录所在的绝对路径
     * @return String web目录所在的绝对路径 eg. E:/work/framework/WebRoot
     */
    public static String getWebAppPath() {
    	AppHelper util = new AppHelper();
        /*
            like: E:\\work\\framework\\WebRoot\\WEB-INF\\classes\\com\\techstar\\framework\\utils
         */
        String clazzFilePath = util.getClassFilePath();
        String webPath = clazzFilePath.substring(0,
                                                 clazzFilePath.indexOf("WEB-INF"));
        return webPath;

    }

  
    /**
     * 获取classes文件的绝对路径
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
            strClassFileName = strClassName.substring(strPackageName.length() +
                1, strClassName.length());
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
        /*strURL = strURL.substring(strURL.indexOf('/') + 1,
                                  strURL.lastIndexOf('/'))*/;
        
        return strURL;
    }
    
    public static void main(String[] args) {
		//System.out.println(AppHelper.getWebAppPath());
    	
    	System.out.println(AppHelper.getPackageName());
	}
    
    private String getClassPackageName() {
        String strClassName = getClass().getName();
        String strPackageName = "";
        if (getClass().getPackage() != null) {
            strPackageName = getClass().getPackage().getName();
        }
        
        return strPackageName ;
    }
    
    public static String getPackageName() {
    	AppHelper util = new AppHelper();
        /*
            like: E:\\work\\framework\\WebRoot\\WEB-INF\\classes\\com\\techstar\\framework\\utils
         */
        String strPackageName = util.getClassPackageName();
        return strPackageName;

    }

}
