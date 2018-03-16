package com.esuizhen.bigdata.common.annotation.demo;

/**
 * Created by fqc on 16/11/21.
 */

public class Student {
    private String name;
    private Integer age;

    private Integer Id;


    @ValueBind(type = ValueBind.FieldType.Integer, value = "1")
    public void setId(Integer id) {
        Id = id;
    }
    public Integer getId() {
        return Id;
    }
    public String getName() {
        return name;
    }

    @ValueBind(type = ValueBind.FieldType.String, value = "kobe")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @ValueBind(type = ValueBind.FieldType.Integer, value = "18")
    public void setAge(Integer age) {
        this.age = age;
    }
}
