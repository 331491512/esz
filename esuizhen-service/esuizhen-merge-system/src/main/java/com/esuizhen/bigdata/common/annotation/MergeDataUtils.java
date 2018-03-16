package com.esuizhen.bigdata.common.annotation;

import com.esuizhen.bigdata.common.annotation.MergeMethod.OperationEnum;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fqc on 16/11/21.
 */
public class MergeDataUtils {
    public static void main(String[] args) throws Exception {
        getClassInfo("com.esuizhen.bigdata.controller.AuthorController");
    }

    public static Map getClassInfo(String qualifiedName) throws ClassNotFoundException {
        //Class<?> clazz = Class.forName("com.esuizhen.bigdata.controller.AuthorController");
        Class<?> clazz = Class.forName(qualifiedName);
        Method[] methods = clazz.getDeclaredMethods();
        Map map = new HashMap<String, List>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MergeMethod.class)) {
                System.out.println(method.getName());
                //方法名
                map.put("methodName", method.getName());
                MergeMethod annotation = method.getAnnotation(MergeMethod.class);
                OperationEnum[] operationTypes = annotation.operationType();

                List list = new ArrayList();
                for (OperationEnum operationType : operationTypes) {
                    System.out.println(operationType);
                    //方法类型
                    list.add(operationType);

                }
                map.put("operationType", list);
            }
        }
        //map.forEach((o, o2) -> System.out.println(o+"->"+o2));
        return map;
    }
}
