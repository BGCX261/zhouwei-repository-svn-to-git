package com.sitechasia.webx.core.utils.base;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 提供对class根目录访问的控制，由于Spring上下文使用ClassPath Context
 *
 * @author <a href="mailto:zhoumengchun@myce.net.cn">mczhou</a>
 * @author todd
 * @version 1.2 , 2008/5/7
 * @since JDK1.5
 */
public class ResourceFinder {

   /**
    * 得到Spring配置文件
    */
   public static String[] getSpring(){
	   String[] list=getFile("classpath*:modules/**/spring-conf/*.xml");
	   String[] allList = new String[list.length+1];
	   allList[0]= "modules/spring.xml";
	   for(int i=0;i<list.length;i++){
		   allList[i+1]=list[i];
	   }
	   return allList;
   }

   /**
    * 得到映射文件
    */
   public static String[] getHbm(){
	   String[] list=getFile("classpath*:modules/**/hibernate-conf/*.hbm.xml");
	   return list;
   }

   /**
    * 得到Struts配置文件
    */
   public static String[] getStruts(){
	   String[] list=getFile("classpath*:modules/**/struts-conf/*.xml");
	   String[] allList = new String[list.length+1];
	   allList[0]= "modules/struts.xml";
	   for(int i=0;i<list.length;i++){
		   allList[i+1]=list[i];
	   }
	   return allList;
   }

   /**
    * 得到文件的相对路径数组
    * @param regString
    * 			文件的路径
    * @return
    */
   public static String[] getFile(String regString){
	       String[] resouceArray=null;
			try {
				ResourcePatternResolver rpr=new PathMatchingResourcePatternResolver();
				Resource[] rs=rpr.getResources(regString);
				if(rs==null){
					return null;
				}
				resouceArray=new String[rs.length];
				int i=0;
				for(Resource c:rs){
					String realPath=c.getURL().getPath();
					String xdpath=realPath.substring(realPath.indexOf("classes")+8);
					resouceArray[i]=xdpath;
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	   return resouceArray;
   }
}