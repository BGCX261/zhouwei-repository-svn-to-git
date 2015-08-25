package com.techstar.dmis.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理类
 * @author yjb
 *
 */
public class DateUtil {

	public static Timestamp getCurrentTimestamp(){
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		Timestamp time = Timestamp.valueOf(date);
		return time;
	}
	
	/**
	   * 将String类型日期转化成java.sql.Date类型"2003-01-01"格式
	   * @param str String
	   * @param format String
	   * @return Date
	   * @author sbt 2007-4-11 
	   */
	  public static java.sql.Date stringToSqlDate(String str) {
		  if (str==null) {
	          return null;
	      }
	      SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
	      java.util.Date date = null;
	      try
	      {
	          date = sdf.parse(str);
	      }
	      catch(Exception e)
	      {
	          return null;
	      }
	      return new java.sql.Date(date.getTime());
	  }
	  
		public static String getCurrentTimestampForString(){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		}
		
		
		
	  //是否月初
	  public static boolean isMonthBegin(){
		  String time = getCurrentTimestampForString();
		  if("01".equals(getCurrentDay()))
			  return true;
		  else
			  return false;
	  }

	  //当前日
	  public static String getCurrentDay(){
		  String time = getCurrentTimestampForString();
		  return time.substring(8,10);
	  }	
	  
	  //当前月
	  public static String getCurrentMonth(){
		  String time = getCurrentTimestampForString();
		  return time.substring(5,7);
	  }
	
	  //当前年
	  public static String getCurrentYear(){
		  String time = getCurrentTimestampForString();
		  return time.substring(0,4);
	  }	  
	  
	  public static void main(String[] str){
		  String time = DateUtil.getCurrentTimestampForString();
		  System.out.println(time.substring(5,7));
		  //if(substr(date("Ymd"),6,2)=="01") 
		  System.out.println(time);
	  }	  
	
}
