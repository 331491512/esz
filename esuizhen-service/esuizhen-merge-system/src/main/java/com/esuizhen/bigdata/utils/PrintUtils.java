package com.esuizhen.bigdata.utils;

import com.esuizhen.bigdata.merge.AbstractMergeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fqc on 16/12/7.
 */
public class PrintUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(AbstractMergeBean.class);

    public static void main(String[] args) {
        //全局设置的话ENABLE_PRINT = true; 打印
        //关闭的话，局部打印 传参true即可。
        ENABLE_PRINT = false;
        print("开始打印");
        print("开始打印", true);
        print("开始打印");
    }

    public static void print(String message, boolean isDebug) {
        if (isDebug) {
            System.out.println(String.format("======%s======", message));
        }
    }

    public static void print(String message) {
        print(message, ENABLE_PRINT);
    }

    /**
     * 打印模式 默认开启
     */
    public static boolean ENABLE_PRINT = true;

}

