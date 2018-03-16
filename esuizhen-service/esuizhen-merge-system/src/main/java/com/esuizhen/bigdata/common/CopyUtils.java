package com.esuizhen.bigdata.common;

import com.esuizhen.bigdata.domain.mergebak.user.UPatientMergeBak;
import com.esuizhen.bigdata.domain.user.UPatient;
import org.springframework.beans.BeanUtils;

import java.io.*;

/**
 * Created by fqc on 16/12/22.
 */
public class CopyUtils {
    public static <T> T copy(Object source) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(source);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return (T) ois.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UPatient uPatient = new UPatient();
        uPatient.setPatientId(1L);
        UPatientMergeBak uPatientMergeBak = new UPatientMergeBak();
        //UPatientMergeBak copy = copy(uPatient); 原生基本的方式
        //System.out.println(uPatientMergeBak);
        BeanUtils.copyProperties(uPatient, uPatientMergeBak);
        System.out.println(uPatient.getPatientId());
        System.out.println(uPatientMergeBak.getPatientId());
    }
}
