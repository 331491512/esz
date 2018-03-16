package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.DetectionReportRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TDetectionReportDao {

    void insertSelective(DetectionReportRes record);

    void updateByPrimaryKeySelective(DetectionReportRes record);

    /**
     * 实时库需要添加
     * @param detectionReport
     */
    void insertRealtimeSelective(DetectionReportRes detectionReport);

    /**
     * 实时库需要添加
     * @param detectionReport
     */
    void updateRealtimeByPrimaryKeySelective(DetectionReportRes detectionReport);
}