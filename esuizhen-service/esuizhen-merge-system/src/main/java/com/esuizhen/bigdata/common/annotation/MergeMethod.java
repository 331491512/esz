package com.esuizhen.bigdata.common.annotation;

import java.lang.annotation.*;

/**
 * Created by fqc on 16/11/21.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MergeMethod {

    enum OperationEnum{
        add,
        update,
        delete,
        merge,
        select
    }

    String description() default "for merge";

    //boolean isAnnotation() default true;

    OperationEnum[] operationType() default OperationEnum.merge;

}
