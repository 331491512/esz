package com.esuizhen.bigdata.common.annotation.demo;

import java.lang.annotation.*;

/**
 * Created by fqc on 16/11/21.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValueBind {
    enum FieldType {
        Integer, String
    }

    FieldType type();

    String value();
}
