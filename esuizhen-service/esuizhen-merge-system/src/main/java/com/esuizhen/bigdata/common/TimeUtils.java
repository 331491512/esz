package com.esuizhen.bigdata.common;

import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * Created by fqc on 16/12/24.
 */
public class TimeUtils {

    public static Timestamp getCurrentTimestamp() {
        /*HashMap hashMap = new HashMap();
        hashMap.put("UTC", DateTimeZone.UTC);
        DateTimeUtils.setDefaultTimeZoneNames(hashMap);*/
        //Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Timestamp currentTime = new Timestamp(DateTimeUtils.currentTimeMillis());
        return currentTime;
    }

}
