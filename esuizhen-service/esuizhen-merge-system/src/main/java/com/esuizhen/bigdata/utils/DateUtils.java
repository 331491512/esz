package com.esuizhen.bigdata.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nidan on 2017年05月17 上午 11:00
 */
public class DateUtils {

    public static Date convertTimestampToDate(Timestamp timestamp){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        return calendar.getTime();
    }

}
