package com.esuizhen.bigdata.cmd.cmd_;

import com.esuizhen.bigdata.utils.PackageClassUtils;
import com.esuizhen.bigdata.utils.PropertyReaderUtils;

import java.util.ArrayList;
import java.util.List;

public class Producer {

    public static String MERGE_IMPL_PKG = "";


    //@Value("${mergeImplPkg}")//todo 还可以更进一步模仿spring的方式初始化或者直接托管注入
    //private static String pkgName;//com.esuizhen.bigdata.cmd.cmd_.impl

    public static List produceRequests() {
        List queue = new ArrayList();
        //可以通过反射包结构中的类而实例化，从而自行调用。
        //queue.add(new Engineer());
        //queue.add(new Politician());
        //queue.add(new Programmer());
        MERGE_IMPL_PKG = PropertyReaderUtils.getInstance("config/application.properties").getValue("merge.impl.pkg_test").toString();
        List<Object> classes = PackageClassUtils.instanceAllOfPkgClasses(MERGE_IMPL_PKG);
        queue.addAll(classes);
        return queue;
    }
}