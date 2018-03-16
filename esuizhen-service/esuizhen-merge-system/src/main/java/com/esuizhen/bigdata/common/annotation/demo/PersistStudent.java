package com.esuizhen.bigdata.common.annotation.demo;

import java.lang.reflect.Method;

/**
 * Created by fqc on 16/11/21.
 */
public class PersistStudent {
    public static void main(String[] args) throws Exception {
        Class<?> stuClass = Class.forName("com.esuizhen.bigdata.common.annotation.demo.Student");

        Object c = stuClass.newInstance();
        Method[] methodArray = c.getClass().getDeclaredMethods();
        for (Method method : methodArray) {
            if (method.isAnnotationPresent(ValueBind.class)) {
                ValueBind annotation = method.getAnnotation(ValueBind.class);
                String type = String.valueOf(annotation.type());
                String value = annotation.value();
                if (type.equals("Integer")) {
                    method.invoke(c, new Integer[]{new Integer(value)});
                }else{
                    method.invoke(c, new String[]{value});
                }
            }
        }
        try {
           /* for (int i = 0; i < methodArray.length; i++) {
                if (methodArray[i].isAnnotationPresent(ValueBind.class)) {
                    ValueBind annotation = methodArray[i]
                            .getAnnotation(ValueBind.class);
                    String type = String.valueOf(annotation.type());
                    String value = annotation.value();
                    if (type.equals("Integer")) {
                        methodArray[i].invoke(c, new Integer[]{new Integer(
                                value)});
                    } else {
                        methodArray[i].invoke(c, new String[]{value});
                    }
                }
            }*/
            Student annotaedStudent = (Student) c;
            System.out.println("studentId====" + annotaedStudent.getId()
                    + "  studentnName====" + annotaedStudent.getName()
                    + "   student Age====" + annotaedStudent.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
