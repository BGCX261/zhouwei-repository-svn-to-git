// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2005-6-28 10:32:05
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DateUtil.java

package com.techstar.framework.ui.web.tag.engine;

import java.text.*;
import java.util.*;

public class DateUtil {

    public DateUtil() {
    }
    
    

    protected static final float normalizedJulian(float JD) {
        float f = (float) Math.round(JD + 0.5F) - 0.5F;
        return f;
    }

    public static final Date toDate(float JD) {
        float Z = normalizedJulian(JD) + 0.5F;
        float W = (int) ((Z - 1867216F) / 36524.25F);
        float X = (int) (W / 4F);
        float A = (Z + 1.0F + W) - X;
        float B = A + 1524F;
        float C = (int) (((double) B - 122.09999999999999D) / 365.25D);
        float D = (int) (365.25F * C);
        float E = (int) ((double) (B - D) / 30.600100000000001D);
        float F = (int) (30.6001F * E);
        int day = (int) (B - D - F);
        int month = (int) (E - 1.0F);
        if (month > 12)
            month -= 12;
        int year = (int) (C - 4715F);
        if (month > 2)
            year--;
        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month - 1);
        c.set(5, day);
        return c.getTime();
    }

    public static final int daysBetween(Date early, Date late) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(early);
        c2.setTime(late);
        return daysBetween(c1, c2);
    }

    public static final int daysBetween(Calendar early, Calendar late) {
        return (int) (toJulian(late) - toJulian(early));
    }

    public static final float toJulian(Calendar c) {
        int Y = c.get(1);
        int M = c.get(2);
        int D = c.get(5);
        int A = Y / 100;
        int B = A / 4;
        int C = (2 - A) + B;
        float E = (int) (365.25F * (float) (Y + 4716));
        float F = (int) (30.6001F * (float) (M + 1));
        float JD = ((float) (C + D) + E + F) - 1524.5F;
        return JD;
    }

    public static final float toJulian(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return toJulian(c);
    }

    public static final String dateIncrease(String isoString, String fmt,
            int field, int amount) {
        try {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            cal.setTime(stringToDate(isoString, fmt, true));
            cal.add(field, amount);
            return dateToString(cal.getTime(), fmt);
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static final java.sql.Date stringToSqlDate(String datestr,String fmt){
    	Date date = stringToDate(datestr, fmt);
    	return new java.sql.Date(date.getTime());
    }

    public static final String roll(String isoString, String fmt, int field,
            boolean up) throws ParseException {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(stringToDate(isoString, fmt));
        cal.roll(field, up);
        return dateToString(cal.getTime(), fmt);
    }

    public static final String roll(String isoString, int field, boolean up)
            throws ParseException {
        return roll(isoString, DATETIME_PATTERN, field, up);
    }

    public static Date stringToDate(String dateText, String format,
            boolean lenient) {
        if (dateText == null)
            return null;
        DateFormat df = null;
        try {
            if (format == null)
                df = new SimpleDateFormat();
            else
                df = new SimpleDateFormat(format);
            df.setLenient(false);
            return df.parse(dateText);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date stringToDate(String dateString, String format) {
        return stringToDate(dateString, format, LENIENT_DATE);
    }

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, "yyyy-MM-dd", LENIENT_DATE);
    }

    public static String dateToString(Date date, String pattern) {
        if (date == null)
            return null;
        try {
            SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
            sfDate.setLenient(false);
            return sfDate.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    public static Date getCurrentDateTime() {
        Calendar calNow = Calendar.getInstance();
        Date dtNow = calNow.getTime();
        return dtNow;
    }

    public static String getCurrentDateString(String pattern) {
        return dateToString(getCurrentDateTime(), pattern);
    }

    public static String getCurrentDateString() {
        return dateToString(getCurrentDateTime(), "yyyy-MM-dd");
    }

    public static String dateToStringWithTime(Date date) {
        return dateToString(date, DATETIME_PATTERN);
    }

    public static Date dateIncreaseByDay(Date date, int days) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static Date dateIncreaseByMonth(Date date, int mnt) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);
        cal.add(2, mnt);
        return cal.getTime();
    }

    public static Date dateIncreaseByYear(Date date, int mnt) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);
        cal.add(1, mnt);
        return cal.getTime();
    }

    public static String dateIncreaseByDay(String date, int days) {
        return dateIncreaseByDay(date, "yyyyMMdd", days);
    }

    public static String dateIncreaseByDay(String date, String fmt, int days) {
        return dateIncrease(date, fmt, 5, days);
    }

    public static String stringToString(String src, String srcfmt, String desfmt) {
        return dateToString(stringToDate(src, srcfmt), desfmt);
    }
    /**
	   * 将String类型日期转化成java.sql.Timestamp类型"2003-01-01"格式
	   * @param str String
	   * @param format String
	   * @return Timestamp
	   * @author sbt 2007-04-06 
	   */
	  public static java.sql.Timestamp stringToTimestamp(String str,String format) {
	      if (str==null||format==null) {
	          return null;
	      }
	      SimpleDateFormat sdf = new  SimpleDateFormat(format);
	      java.util.Date date = null;
	      try
	      {
	          date = sdf.parse(str);
	      }
	      catch(Exception e)
	      {
	          return null;
	      }
	      return new java.sql.Timestamp(date.getTime());
	}
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";

    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

    public static String DATETIME_PATTERN = "yyyy-MM-dd hh:mm:ss";

    private static boolean LENIENT_DATE = false;

}