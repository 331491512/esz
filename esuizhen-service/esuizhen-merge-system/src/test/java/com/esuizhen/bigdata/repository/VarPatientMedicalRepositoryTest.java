//package com.esuizhen.bigdata.repository;
//
//import com.esuizhen.bigdata.domain.ehr.VarPatientMedical;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.Timestamp;
//
///**
// * Created by fqc on 16/12/18.
// */
//@RunWith(SpringRunner.class)
//@Transactional
//@SpringBootTest
//public class VarPatientMedicalRepositoryTest {
//    @Autowired
//    VarPatientMedicalRepository repository;
//
//    @Test
//    public void findByPatientId() throws Exception {
//        VarPatientMedical bean = repository.findByPatientId(385151L);
//        Timestamp date = bean.getLatestOutHospitalDate();
//        System.out.println(date);
//    }
//
//}