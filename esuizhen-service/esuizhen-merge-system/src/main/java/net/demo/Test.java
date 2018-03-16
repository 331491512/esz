package net.demo;

import com.esuizhen.bigdata.domain.user.UPatientFamily;

import java.util.ArrayList;

/**
 * Created by fqc on 16/12/19.
 */
public class Test {
    public static void main(String[] args) {
       /* Test test = new Test();
        for (int i = 0; i < 100; i++) {
            test.process();
        }*/
        testDistinct();
    }

    private Integer i = 0;

    public void process() {
        //Consumer<Integer> c = (i) -> System.out.println(++this.i);
        //c.accept(i);
    }

    /**
     * 模拟去重
     */
    public static void testDistinct() {
        UPatientFamily uPatientFamily1 = new UPatientFamily();
        uPatientFamily1.setId(1000L);
        uPatientFamily1.setPatientId(1000L);
        uPatientFamily1.setFamilyName("张三");
        uPatientFamily1.setFamilyPhone("15201098976");
        uPatientFamily1.setAddress("山东威海");

        UPatientFamily uPatientFamily2 = new UPatientFamily();
        uPatientFamily2.setId(1001L);
        uPatientFamily2.setPatientId(1000L);
        uPatientFamily2.setFamilyName("张三");
        uPatientFamily2.setFamilyPhone("15201098977");
        uPatientFamily2.setAddress("山东威海");

        UPatientFamily uPatientFamily3 = new UPatientFamily();
        uPatientFamily3.setId(1002L);
        uPatientFamily3.setPatientId(1000L);
        uPatientFamily3.setFamilyName("张三");
        uPatientFamily3.setFamilyPhone("15201098978");
        uPatientFamily3.setAddress("山东威海");

        UPatientFamily uPatientFamily4 = new UPatientFamily();
        uPatientFamily4.setId(1003L);
        uPatientFamily4.setPatientId(1000L);
        uPatientFamily4.setFamilyName("张三");
        uPatientFamily4.setFamilyPhone("15201098978");
        uPatientFamily4.setAddress("山东威海");

        ArrayList<UPatientFamily> uPatientFamilies =new ArrayList<>();
        uPatientFamilies.add(uPatientFamily1);
        uPatientFamilies.add(uPatientFamily2);
        uPatientFamilies.add(uPatientFamily3);
        uPatientFamilies.add(uPatientFamily4);
        //Lists.newArrayList(uPatientFamily1, uPatientFamily2, uPatientFamily3, uPatientFamily4);
        //uPatientFamilies.forEach(System.out::println);
        System.out.println("去重1");
        //uPatientFamilies.stream().distinct();
        //uPatientFamilies.forEach(System.out::println);
        ArrayList<UPatientFamily> list = new ArrayList<>();

        //uPatientFamilies.stream().distinct().forEach(uPatientFamily -> {
        //    list.add(uPatientFamily);
        //});

        System.out.println("去重2");
        //uPatientFamilies.stream().distinct().forEach(System.out::println);

        //uPatientFamilies.
        System.out.println("需要去重掉的联系人为:->");
        list.removeAll(uPatientFamilies); //f..ck这时候去除是相同的了
        //uPatientFamilies.removeAll(list);
        //uPatientFamilies.forEach(System.out::println);

    }

}
