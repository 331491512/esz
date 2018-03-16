package com.westangel.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.westangel.common.bean.ErrorMessage;

/**
 * 时间处理
 *
 * @author weichaoo
 */
public class TimeUtil {

    private final static DateFormat df = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * 格式化Date格式的时间，
     * 按格式输出
     *
     * @param date
     * @return 对Data类型的时间格式化成yyyy-MM-dd HH:mm:ss字符串格式
     */
    public static String getDateStrFromDate(Date date) {
        return df.format(date);
    }

    /**
     * 格式化时间戳格式时间
     * 时间戳为long
     *
     * @param timestamp
     * @return 对long的时间戳格式化成yyyy-MM-dd HH:mm:ss字符串格式
     */
    public static String getDateStrFromTimestamp(long timestamp) {
        return getDateStrFromDate(new Date(timestamp));
    }

    /**
     * 格式化时间戳格式时间
     * 时间戳为String
     *
     * @param timestampStr
     * @return 将String类型的时间戳格式化成yyyy-MM-dd HH:mm:ss字符串格式
     */
    public static String getDateStrFromTimestamp(String timestampStr) {
        return getDateStrFromTimestamp(Long.parseLong(timestampStr));
    }

    /**
     * 格式化unix时间戳格式时间
     * unix时间戳为long
     *
     * @param unixTimestamp
     * @return 将long型的unix时间戳格式化成yyyy-MM-dd HH:mm:ss字符串格式
     */
    public static String getDateStrFromUnixTimestamp(long unixTimestamp) {
        return getDateStrFromTimestamp(unixTimestamp * 1000);
    }

    /**
     * 格式化unix时间戳格式时间
     * unix时间戳为String
     *
     * @param unixTimestampStr
     * @return 将String类型的时间戳格式化成yyyy-MM-dd HH:mm:ss字符串格式
     */
    public static String getDateStrFromUnixTimestamp(String unixTimestampStr) {
        return getDateStrFromUnixTimestamp(Long.parseLong(unixTimestampStr));
    }


//    /**
//     * 得到unix时间戳
//     * 输入格式为：时间字符串格式：yyyy-MM-dd HH:mm:ss
//     * @param dateTime
//     * @return
//     */
//    public static long getUnixTimestamp(String dateTime) {
//	try {
//	    Date date = df.parse(dateTime);
//	    return date.getTime();
//	} catch (ParseException e) {
//	    e.printStackTrace();
//	}
//	return 0;
//    }
//

    /**
     * 从date格式到unix时间戳
     *
     * @param date
     * @return 返回unix时间戳
     */
    public static long getUnixTimestamp(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 从时间戳到unix时间戳
     *
     * @param timestamp
     * @return 返回unix时间戳
     */
    public static long getUnixTimestamp(long timestamp) {
        return timestamp / 1000;
    }


    /**
     * 从unix时间戳格式到Date格式
     * unix时间戳为long
     *
     * @param unixTimestamp
     * @return 返回Date时间，从unix时间戳格式转换
     */
    public static Date getDateFromUnixTimestamp(long unixTimestamp) {
        Date date = new Date(unixTimestamp * 1000);
        return date;
    }

    /**
     * 从unix时间戳格式到Date格式
     * unix时间戳为String
     *
     * @param unixTimestampStr
     * @return 返回Date类型时间
     */
    public static Date getDateFromUnixTimestamp(String unixTimestampStr) {
        return getDateFromUnixTimestamp(Long.parseLong(unixTimestampStr));
    }

    /**
     * 从时间戳格式到Date格式
     * 时间戳为long
     *
     * @param timestamp
     * @return 返回Date类型时间
     */
    public static Date getDateFromTimestamp(long timestamp) {
        return new Date(timestamp);
    }

    /**
     * 从时间戳格式到Date格式
     *
     * @param timestampStr
     * @return 返回Date类型时间
     */
    public static Date getDateFromTimestamp(String timestampStr) {
        return getDateFromTimestamp(Long.parseLong(timestampStr));
    }

    /**
     * 
    * @Title: timing 
    * @Description: 和当前时间差 
    * @param @param timeString
    * @param @return    设定文件 
    * @return Long    返回类型 
    * @throws
     */
    public static Long timingWithNow(String timeString) throws RuntimeException
    {
		Long timestamp = 0L;
		try {
			timestamp = df.parse(timeString).getTime();
		} catch (Exception e) {
			throw new RuntimeException();				
		} 
		
		return System.currentTimeMillis()-timestamp;
    }
}
