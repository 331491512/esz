package com.esuizhen.bigdata.merge;

import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.service.EntityBakService;
import com.esuizhen.bigdata.utils.PackageClassUtils;
import com.esuizhen.bigdata.utils.PropertyReaderUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 扫描指定包下的业务实现类，加入队列
 */
public class Producer {

    public static String MERGE_IMPL_PKG = "";

    public static List produceRequests() {
        List queue = new ArrayList();
        MERGE_IMPL_PKG = PropertyReaderUtils.getInstance("config/application.properties").getValue("merge.impl.pkg").toString();
        List<Object> classes = PackageClassUtils.instanceAllOfPkgClasses(MERGE_IMPL_PKG);
        queue.addAll(classes);
        return queue;
    }

    //concurrent支持更好些
    public static ConcurrentLinkedQueue produceRequests2() {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        MERGE_IMPL_PKG = PropertyReaderUtils.getInstance("config/application.properties").getValue("merge.impl.pkg").toString();
        List<Object> classes = PackageClassUtils.instanceAllOfPkgClasses(MERGE_IMPL_PKG);
        queue.addAll(classes);
        return queue;
    }

    //
    public static ConcurrentLinkedQueue produceRequests2(String goalPatientId, List<String> otherPatientIds, String operatorId) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        MERGE_IMPL_PKG = PropertyReaderUtils.getInstance("config/application.properties").getValue("merge.impl.pkg").toString();
        List<Object> classes = PackageClassUtils.instanceAllOfPkgClasses(MERGE_IMPL_PKG, goalPatientId, otherPatientIds, operatorId);
        queue.addAll(classes);
        return queue;
    }


    public static ConcurrentLinkedQueue produceRequests3(Long goalPatientId, List<Long> otherPatientIds, MergePatientReq beanInfo, String operatorId, Map<String, JpaRepository> repositoryMap, EntityBakService entityBakService) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        MERGE_IMPL_PKG = PropertyReaderUtils.getInstance("config/application.properties").getValue("merge.impl.pkg").toString();
        List<Object> classes = PackageClassUtils.instanceAllOfPkgClassesAndInjectReposioty(MERGE_IMPL_PKG, goalPatientId, otherPatientIds, beanInfo, operatorId, repositoryMap, entityBakService);
        if(classes==null||classes.size()<1) {
            throw new NullPointerException("Constructor is not exist");
        }
        queue.addAll(classes);
        return queue;
    }


}