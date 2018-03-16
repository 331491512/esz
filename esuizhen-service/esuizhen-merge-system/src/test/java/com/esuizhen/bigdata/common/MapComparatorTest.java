package com.esuizhen.bigdata.common;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by fqc on 16/12/9.
 */
public class MapComparatorTest {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        hashMap.put("kobe", 1);
        hashMap.put("james", 2);
        hashMap.put("allen", 3);
        hashMap.put("paul", 4);
        hashMap.put("qian", 5);

        treeMap.put("kobe", 1);
        treeMap.put("james", 2);
        treeMap.put("allen", 3);
        treeMap.put("paul", 4);
        treeMap.put("qian", 5);


        // sort as words  default
        //hashMap.forEach((k, v) -> System.out.println(k + "->" + v));
        System.out.println("----------------忧伤的分隔符----------------");
        //treeMap.forEach((k, v) -> System.out.println(k + "->" + v));

    }
}
