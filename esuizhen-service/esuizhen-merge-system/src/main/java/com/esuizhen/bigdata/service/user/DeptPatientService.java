package com.esuizhen.bigdata.service.user;

import java.util.List;

/**
 * Created by Nidan on 2017年07月25 上午 10:29
 */
public interface DeptPatientService {
    /**
     * 合并患者科室信息
     * @param goalPatientId
     * @param otherPatientIds
     */
    public void mergeDeptPatient(Long goalPatientId, List<Long> otherPatientIds);
    /**
     * 撤销合并
     * @param patientId
     */
    public void revokeMergeDeptPatient(Long patientId);

}
