package com.esuizhen.bigdata.common;

public class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(final String name, final int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        //test04();
        //test05();
    }


    /**
     * 原始反人类的方式(匿名内部类方式)
     */
    /*private static void test01() {
        //ArrayList<Human> humen = new ArrayList<Human>(new Human("kobe", 1), new Human("james", 2));
        ArrayList<Human> list = Lists.newArrayList(new Human("kobe", 1), new Human("james", 2));
        //list.sort(new Comparator<Human>() {
            Collections.sort(list, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        //Assert.assertThat(list.get(0), equalTo(new Human("james", 2)));
       // list.forEach(System.out::println);
    }*/

    /**
     * lambda方式 带有类型参数
     */
    /*private static void test02() {
        ArrayList<Human> list = Lists.newArrayList(new Human("kobe", 1), new Human("james", 2));
        //list.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
        //list.forEach(System.out::println);
    }*/

    /**
     * java8清爽实现(lambda方式,类型自动推测)
     */
    /*private static void test03() {
        //ArrayList<Human> humen = new ArrayList<Human>(new Human("kobe", 1), new Human("james", 2));
        ArrayList<Human> list = Lists.newArrayList(new Human("kobe", 1), new Human("james", 2), new Human("smith", 3), new Human("allen", 4));
        //list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        //Assert.assertThat(list.get(0), equalTo(new Human("james", 2)));
        //list.forEach(System.out::println);
    }*/

    /**
     * 单独提取comparator
     */
    /*private static void test04() {
        ArrayList<Human> list = Lists.newArrayList(new Human("kobe", 1), new Human("james", 2), new Human("smith", 3), new Human("allen", 4));
        //(o1,o2)->o1.getName; 如果没有泛型的定义将无法编译
        //Comparator<Human> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        //list.sort(comparator);
    }*/

    /**********多属性判断**************************/

    /*private static void test05() {
        ArrayList<Human> list = Lists.newArrayList(
                new Human("kobe", 1), new Human("james", 2),
                new Human("smith", 3), new Human("allen", 4),
                new Human("smith", 2), new Human("allen", 5)
        );
        //list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        PrintUtils.ENABLE_PRINT = true;
        PrintUtils.print("按名称排序");
        //list.forEach(System.out::println);

        *//*list.sort((o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                //return o1.getAge() - o2.getAge();//升序
                return o2.getAge() - o1.getAge();//降序
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });*//*
        PrintUtils.print("[名称、年龄]多条件排序(名称一样后按照年龄排序)");
        //list.forEach(System.out::println);
    }*/


}