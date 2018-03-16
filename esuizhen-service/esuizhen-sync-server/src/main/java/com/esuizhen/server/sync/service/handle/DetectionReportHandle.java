package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.DetectionReportRes;
import com.esuizhen.server.sync.dao.server.TDetectionReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nidan on 2017年03月28 下午 18:52
 */
@Component
public class DetectionReportHandle {

    @Autowired
    private TDetectionReportDao detectionReportDao;

    public void syncAddDetectionReport(DetectionReportRes detectionReport) {
        detectionReportDao.insertSelective(detectionReport);
    }

    public void syncUpdateDetectionReport(DetectionReportRes detectionReport) {
        detectionReportDao.updateByPrimaryKeySelective(detectionReport);
    }

    public void syncRealtimeAddDetectionReport(DetectionReportRes detectionReport) {
        detectionReportDao.insertRealtimeSelective(detectionReport);
    }

    public void syncRealtimeUpdateDetectionReport(DetectionReportRes detectionReport) {
        detectionReportDao.updateRealtimeByPrimaryKeySelective(detectionReport);
    }
}
