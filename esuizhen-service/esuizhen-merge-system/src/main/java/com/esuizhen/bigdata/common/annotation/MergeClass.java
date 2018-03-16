package com.esuizhen.bigdata.common.annotation;

import java.lang.annotation.*;

/**
 * Created by fqc on 16/11/21.
 */
@Target(ElementType.TYPE) //只能标注在方法上
@Retention(RetentionPolicy.RUNTIME)//可通过反射读取注解
@Documented//将此注解包含在Javadoc中。
/**
 * 修饰合并相关方法
 */
public @interface MergeClass {
    String value();
}
