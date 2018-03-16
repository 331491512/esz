package net.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 2016/12/21.
 */
public class TestDistinct {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1, "张三1", "威海");
        Teacher teacher2 = new Teacher(2, "张三2", "威海");
        Teacher teacher3 = new Teacher(3, "张三3", "威海");
        Teacher teacher4 = new Teacher(4, "张三4", "威海");
        Teacher teacher5 = new Teacher(5, "张三4", "威海");
        List<Teacher> tList = new ArrayList<>();
        tList.add(teacher1);
        tList.add(teacher2);
        tList.add(teacher3);
        tList.add(teacher4);
        tList.add(teacher5);

        System.out.println("原数据->0");
        //tList.forEach(System.out::println);

        System.out.println("distinc->1");
        //tList.stream().distinct();
        System.out.println(tList);
        System.out.println("distinct->2");
        List<Teacher> list2 = new ArrayList();
        //tList.stream().distinct().forEach(System.out::println);

        //tList.stream().distinct().forEach(teacher -> list2.add(teacher));//默认按照对象地址this==obj

        System.out.println("去重后的");
        //list2.forEach(System.out::println);

        List<Integer> allIds = new ArrayList<>();
        //tList.forEach(teacher -> allIds.add(teacher.getId()));
        System.out.println(allIds);
        List<Integer> distinctIds = new ArrayList<>();
        //list2.forEach(teacher -> distinctIds.add(teacher.getId()));
        System.out.println(distinctIds);
        allIds.removeAll(distinctIds);
        System.out.println(allIds);

        /*
        *
原数据->0
Teacher{id=1, name='张三1', address='威海'}
Teacher{id=2, name='张三2', address='威海'}
Teacher{id=3, name='张三3', address='威海'}
Teacher{id=4, name='张三4', address='威海'}
Teacher{id=5, name='张三4', address='威海'}
distinc->1
[Teacher{id=1, name='张三1', address='威海'}, Teacher{id=2, name='张三2', address='威海'}, Teacher{id=3, name='张三3', address='威海'}, Teacher{id=4, name='张三4', address='威海'}, Teacher{id=5, name='张三4', address='威海'}]
distinct->2
Teacher{id=1, name='张三1', address='威海'}
Teacher{id=2, name='张三2', address='威海'}
Teacher{id=3, name='张三3', address='威海'}
Teacher{id=4, name='张三4', address='威海'}
去重后的
Teacher{id=1, name='张三1', address='威海'}
Teacher{id=2, name='张三2', address='威海'}
Teacher{id=3, name='张三3', address='威海'}
Teacher{id=4, name='张三4', address='威海'}
[1, 2, 3, 4, 5]
[1, 2, 3, 4]
[5]
        *
        * */


    }
}

class Teacher {
    private int id;
    private String name;
    private String address;

    public Teacher(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        return address != null ? address.equals(teacher.address) : teacher.address == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
