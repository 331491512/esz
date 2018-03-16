package net.demo;

import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;

import java.util.HashMap;

/**
 * Created by fqc on 16/12/23.
 */
public class TestUTC {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("UTC", DateTimeZone.UTC);
        DateTimeUtils.setDefaultTimeZoneNames(hashMap);
        System.out.println(new java.sql.Timestamp(DateTimeUtils.currentTimeMillis()));
    }
}
