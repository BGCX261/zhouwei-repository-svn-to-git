package com.techstar.framework.utils;

import java.sql.Timestamp;

/**
 * 提供处理日期的方法
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author xcf
 */
public class DateHelper {
    /**
     * 获取当前日期字符串
     * @return 返回字符串如：20060828
     */
    public static String getCurrDateStr(){ 
    	Timestamp ts = new Timestamp(System.currentTimeMillis());
    	StringBuffer datestr = new StringBuffer("");
    	datestr.append(ts.toString().substring(0,4));
    	datestr.append(ts.toString().substring(5,7));
    	datestr.append(ts.toString().substring(8,10));
    	return datestr.toString();
    }

    //单元测试
    public static void main(String args[]){
    	System.out.println(DateHelper.getCurrDateStr());
    }

}
