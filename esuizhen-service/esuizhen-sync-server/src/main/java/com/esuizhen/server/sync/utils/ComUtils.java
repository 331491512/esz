package com.esuizhen.server.sync.utils;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nidan on 2017年03月20 下午 18:28
 */
public class ComUtils {

    /**
     * 转换表字段为字符串
     * @param map
     * @return map
  */
    public static Map<String, String> getColumns(LinkedHashMap map) {
        Map<String, String> hashmap=new HashMap<String,String>();
        StringBuilder cols=new StringBuilder();
        StringBuilder vals=new StringBuilder();
        for (Object columnName: map.keySet()) {
            cols.append(String.valueOf(columnName));
            cols.append(",");

            vals.append("\"");
            vals.append(String.valueOf(map.get(columnName)));
            vals.append("\",");
        }
        if(!StringUtils.isBlank(cols.toString())){
            hashmap.put("columnNames", cols.substring(0, cols.length()-1));
            hashmap.put("columnValues", vals.substring(0, vals.length()-1));
        }
        return hashmap;
    }
}
