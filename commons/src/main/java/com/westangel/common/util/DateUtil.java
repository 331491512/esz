package com.westangel.common.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;


/**
 * 提供日期处理的简单工具类
 *
 * @author weichaoo
 */
public class DateUtil {
	/**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd
     * 
     * @since 1.0
     */
    public static final int DEFAULT = 0;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM
     * 
     * @since 1.0
     */
    public static final int YM = 1;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd
     * 
     * @since 1.0
     */
    public static final int YMR_SLASH = 11;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMdd
     * 
     * @since 1.0
     */
    public static final int NO_SLASH = 2;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMM
     * 
     * @since 1.0
     */
    public static final int YM_NO_SLASH = 3;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm:ss
     * 
     * @since 1.0
     */
    public static final int DATE_TIME = 4;

    /**
     * 变量：日期格式化类型 - 格式:yyyyMMddHHmmss
     * 
     * @since 1.0
     */
    public static final int DATE_TIME_NO_SLASH = 5;

    /**
     * 变量：日期格式化类型 - 格式:yyyy/MM/dd HH:mm
     * 
     * @since 1.0
     */
    public static final int DATE_HM = 6;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm:ss
     * 
     * @since 1.0
     */
    public static final int TIME = 7;

    /**
     * 变量：日期格式化类型 - 格式:HH:mm
     * 
     * @since 1.0
     */
    public static final int HM = 8;
    
    /**
     * 变量：日期格式化类型 - 格式:HHmmss
     * 
     * @since 1.0
     */
    public static final int LONG_TIME = 9;
    /**
     * 变量：日期格式化类型 - 格式:HHmm
     * 
     * @since 1.0
     */
    
    public static final int SHORT_TIME = 10;

    /**
     * 变量：日期格式化类型 - 格式:yyyy-MM-dd HH:mm:ss
     * 
     * @since 1.0
     */
    public static final int DATE_TIME_LINE = 12;
    
    public static final int DATE_TIME_LINE_SHORT = 13;
    
    /**
     * 
    * @Title: convertToStr 
    * @Description:  
    * @param @param type
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String convertToStr(Date date, int type) 
    {
    	String pattern = null;
        switch (type) {
        case DEFAULT:{
        		pattern = "yyyy/MM/dd";
        	}break;
        case YM:{
        		pattern = "yyyy/MM";
        	}break;
        case NO_SLASH:{
        		pattern = "yyyyMMdd";
        	}break;
        case YMR_SLASH:{
        		pattern = "yyyy-MM-dd";
        	}break;
        case YM_NO_SLASH:{
        		pattern = "yyyyMM";
        	}break;
        case DATE_TIME:{
        		pattern = "yyyy/MM/dd HH:mm:ss";
        	}break;
        case DATE_TIME_NO_SLASH:{
        		pattern = "yyyyMMddHHmmss";
        	}break;
        case DATE_HM:{
        		pattern = "yyyy/MM/dd HH:mm";
        	}break;
        case TIME:{
        		pattern = "HH:mm:ss";
        	}break;
        case HM:{
        		pattern = "HH:mm";
        	}break;
        case LONG_TIME:{
        		pattern = "HHmmss";
        	}break;
        case SHORT_TIME:{
        		pattern = "HHmm";
        	}break;
        case DATE_TIME_LINE:{
        		pattern = "yyyy-MM-dd HH:mm:ss";
        	}break;
        case DATE_TIME_LINE_SHORT:{
    		pattern = "yyyy-MM-dd HH:mm";
    	}break;
 	
        default:
            throw new IllegalArgumentException("Type undefined : " + type);
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);        
    }    
	
    /**
     * 取得和当前时间偏移量years年的日期 加上或者减去【years】年
     *
     * @param days
     */
    public static Date getOffsetYear(int years) {
    	Calendar calendar = Calendar.getInstance(Locale.CHINA);
    	calendar.add(Calendar.YEAR, years);
    	return calendar.getTime();
    }
    /**
     * 取得和当前时间偏移量months月的日期 加上或者减去【months】月
     *
     * @param days
     */
    public static Date getOffsetMonth(int months) {
    	Calendar calendar = Calendar.getInstance(Locale.CHINA);
    	calendar.add(Calendar.MONTH, months);
    	return calendar.getTime();
    }
    /**
     * 取得和当前时间偏移量weeks周的日期 加上或者减去【weeks】周
     *
     * @param days
     */
    public static Date getOffsetWeek(int weeks) {
    	Calendar calendar = Calendar.getInstance(Locale.CHINA);
    	calendar.add(Calendar.WEEK_OF_MONTH, weeks);
    	return calendar.getTime();
    }
    
    /**
     * 取得和当前时间偏移量days天的日期 加上或者减去【days】天
     *
     * @param days
     */
    public static Date getOffsetDate(int days) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    /**
     * 取得和给定时间偏移量days天的日期 加上或者减去【days】天
     *
     * @param date
     * @param days
     */
    public static Date getOffsetDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    /**
     * 取得和当前时间偏移量hours个小时的Date 加上或减去hours个小时
     *
     * @param hours
     * @return Date
     */
    public static Date getOffsetHours(int hours) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * 取得和给定时间偏移量hours个小时的Date 加上或减去hours个小时
     *
     * @param date
     * @param hours
     * @return Date
     */
    public static Date getOffsetHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * 取得和当前时间偏移量minutes分钟的Date，加上或减去minutes分钟
     *
     * @param minutes
     * @return Date
     */
    public static Date getOffsetMinutes(int minutes) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 取得和给定时间偏移量minutes分钟的Date，加上或减去minutes分钟
     *
     * @param date
     * @param minutes
     * @return Date
     */
    public static Date getOffsetMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * 取得当天时间的最大值
     *
     * @return Date
     */
    public static Date getCeilingOfCurrentDay() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,
                calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,
                calendar.getActualMaximum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * 取得当天时间的最小值
     *
     * @return Date
     */
    public static Date getFloorOfCurrentDay() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,
                calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,
                calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND,
                calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTime();
    }

    /**
     * 取得该时间的一日内的最大值
     *
     * @param date
     */
    public static Date getCeilingOfDay(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,
                calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,
                calendar.getActualMaximum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * 取得该时间的一日内的最小值
     *
     * @param date
     */
    public static Date getFloorOfDay(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,
                calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,
                calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND,
                calendar.getActualMinimum(Calendar.MILLISECOND));
        return calendar.getTime();
    }

    /**
     * 取得该时间的一月内的最大值
     *
     * @param date
     * @return Date
     */
    public static Date getCeilingOfMouth(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,
                calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,
                calendar.getActualMaximum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * 取得该时间的一月内的最小值
     *
     * @param date
     */
    public static Date getFloorOfMouth(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY,
                calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,
                calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND,
                calendar.getActualMinimum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * 简单的格式化日期 yyyy-MM-dd
     *
     * @param date
     * @return String
     */
    public static String getDateOfDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 简单的格式化日期 pattern
     *
     * @param date
     * @return String
     */
    public static String getDateOfDay(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 取得和给定时间偏移量days天的日期 加上或者减去【days】天
     *
     * @param dateStr   时间，字符串格式
     * @param days      时间偏移量
     * @param formmater 时间格式
     * @return String
     */
    public static String getOffsetDay(String dateStr, int days, String formmater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formmater);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
            // long myTime = (date.getTime() / 1000) + days * 24 * 60 * 60;
            date = getOffsetDate(date, days);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
        return sdf.format(date);
    }


    /** 
     * 将给定的字符串格式的时间，转换为Unix时间戳(unix_timestamp)
     */
    public static long getUnixTime(String dateStr){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date ;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			date = new Date();
		}
    	return date.getTime()/1000;
    	
    }
    
    public static String getDateTimeStr(long unixTime){
    	 String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(unixTime*1000));  
    	 return date;  
    }
    public static String getDateStr(long unixTime){
   	 String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(unixTime)); 
   	 return date;  
   }
    public static String getDateTimeShortStr(Date date){
     	 if(date==null) return "";
     	  
     	 return convertToStr(date,DATE_TIME_LINE_SHORT);
   }
   
    public static String getDateTimeStr(Date date){
    	 if(date==null) return "";
      	 return convertToStr(date,DATE_TIME_LINE); //"yyyy-MM-dd HH:mm:ss";
      }
    
    public static String getDateStr(Date date){
   	 if(date==null) return "";
     	 return convertToStr(date,YMR_SLASH); //"yyyy-MM-dd";
     }
       
	/**
	 * 为给定的时间增加小时
	 * 
	 * @param date
	 *            当前时间
	 * @param Hours
	 *            增加的小时
	 * @return 增加小时后的时间
	 */
	public static Date addTimeByHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}
    
	/**
	 * 判断两个日期的大小
	 */
	public static int comparDate(Date date1,Date date2){
		if(null == date1 || null == date2){
			return -1;
		}else if(date1.getTime() > date2.getTime()){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	* 字符串转换到时间格式
	* @param dateStr 需要转换的字符串
	* @param formatStr 需要格式的目标字符串 举例 yyyy-MM-dd
	* @return Date 返回转换后的时间
	* @throws ParseException 转换异常
	*/
	public static Date stringToDate(String dateStr,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		if(StringUtils.isNotEmpty(dateStr)){
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
				date = new Date();
			}
		}
		return date;
	}
	
	public static String getIntervalTimeStr(int intervalTime) {
		// TODO Auto-generated method stub
		String s="";
		float interval=(float)intervalTime;
		if(intervalTime>=60){
			if(interval%60<6 || interval%60>54) //也就是小数点后<0.1,则取整数位
			{
				DecimalFormat df = new DecimalFormat("0");
				s = df.format(interval/60)+"小时";
			}
			else{
				DecimalFormat df = new DecimalFormat("0.0");
				s=df.format(interval/60)+"小时";
			}
		}
		else
			s = intervalTime +"分钟";
		return s;
	}
	
	/**
	 * 按照当前时间顺延
	 * @author lichenghao
	 * @title :offsetDate
	 * @Description:TODO
	 * @return Date
	 * @date 2016年3月23日 上午11:17:45
	 */
	public static Date getFactOffsetMinutes(int minus){
		return getFactOffsetMinutes(null,minus);
	}
	
	/**
	 * 按照给定时间顺延
	 * @author lichenghao
	 * @title :getFactOffsetMinutes
	 * @Description:TODO
	 * @return Date
	 * @date 2016年3月23日 上午11:19:53
	 */
	public static Date getFactOffsetMinutes(Date date,int minus){
		if(minus==0){
			return offsetDate(Calendar.MINUTE, minus, date);
		}
		if(minus%1440==0){
			int day = minus/1440;
			if(day%365==0){
				return offsetDate(Calendar.YEAR, day/365, date);
			}else if(day%30==0){
				return offsetDate(Calendar.MONTH, day/30, date);
			}else{
				return offsetDate(Calendar.DAY_OF_MONTH, day, date);
			}
		}else{
			return offsetDate(Calendar.MINUTE, minus, date);
		}
	}
	
	
	/**
	 * 按照给定格式 日期 变量 进行时间偏移
	 * @author lichenghao
	 * @title :offsetDate
	 * @Description:TODO
	 * @return Date
	 * @date 2016年3月23日 上午11:18:25
	 */
	public static Date offsetDate(int fieId,int size,Date date){
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		if(date!=null)
			calendar.setTime(date);
        calendar.add(fieId, size);
        return calendar.getTime();
	}
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param minDate 较小的时间 
     * @param maxDate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date minDate, Date maxDate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        minDate=sdf.parse(sdf.format(minDate));  
        maxDate=sdf.parse(sdf.format(maxDate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(minDate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(maxDate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }
	
    public static void  main(String[] argv){
    	long tt = new Date().getTime();
    	String str = DateUtil.getDateStr(1375286400000l);
    	System.out.println(str);
    	str = DateUtil.getDateStr(DateUtil.getOffsetWeek(1));
    	System.out.println(str);
    	str = DateUtil.getDateStr(DateUtil.getOffsetMonth(1));
    	System.out.println(str);
    	str = DateUtil.getDateStr(DateUtil.getOffsetYear(1));
    	System.out.println(str);
    }

    public static Date convertToDate(String str){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=sdf.parse(str);
        } catch (ParseException e) {
            LogUtil.logError.error("日期转换出错：{}",e.getMessage());
        }
        return date;
    }
}
