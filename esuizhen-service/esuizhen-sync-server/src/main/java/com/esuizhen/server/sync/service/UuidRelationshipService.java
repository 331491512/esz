package com.esuizhen.server.sync.service;

import java.util.LinkedHashMap;

/**
 * Created by Nidan on 2017年03月21 上午 11:50
 */
public interface UuidRelationshipService {

    /**
     * 获取正式库中的患者信息
     * @param map
     * @return
     */
    public LinkedHashMap getTruePatientInfo(LinkedHashMap map);
    /**
     * 
     * @author lichenghao
     * @title :getFinalUuid
     * @Description:获取uuid
     * @return String
     * @date 2017年3月21日 下午4:20:18
     */
    public String getFinalUuid(String uuid);
    
    /**
     * 
     * @author lichenghao
     * @title :getPatientId
     * @Description:获取患者Id
     * @return String
     * @date 2017年3月21日 下午4:20:27
     */
    public String getPatientId(String uuid);
    
    /**
     * 
     * @author lichenghao
     * @title :getDoctorId
     * @Description:获取医生Id
     * @return String
     * @date 2017年3月21日 下午4:20:36
     */
    public String getDoctorId(String uuid);
    
    /**
     * 
     * @author lichenghao
     * @title :getDeptId
     * @Description:获取科室Id
     * @return String
     * @date 2017年3月21日 下午4:20:45
     */
    public String getDeptId(String uuid);
}
