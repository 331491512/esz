package com.esuizhen.bigdata.common.annotation.demo;

import com.esuizhen.bigdata.common.annotation.MergeClass;
import com.esuizhen.bigdata.common.annotation.MergeMethod;

/**
 * Created by fqc on 16/11/21.
 */
@MergeClass("mergeUser")
public class AnnotationDemo {
    @MergeMethod(description = "mergeUser")
    public void sayHello() {
        System.out.println("hello world!");
    }
}
