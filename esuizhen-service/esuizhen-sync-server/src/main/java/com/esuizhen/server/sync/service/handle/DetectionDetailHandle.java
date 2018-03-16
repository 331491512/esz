package com.esuizhen.server.sync.service.handle;

import com.esuizhen.server.sync.bean.server.DetectionDetailRes;
import com.esuizhen.server.sync.dao.server.TDetectionDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nidan on 2017年03月28 下午 18:50
 */
@Component
public class DetectionDetailHandle {

    @Autowired
    private TDetectionDetailDao detectionDetailDao;

    public void syncAddDetectionDetail(DetectionDetailRes detectionDetail) {
        detectionDetailDao.insertSelective(detectionDetail);
    }

    public void syncUpdateDetectionDetail(DetectionDetailRes detectionDetail) {
        detectionDetailDao.updateByPrimaryKeySelective(detectionDetail);
    }

    public void syncAddRealtimeDetectionDetail(DetectionDetailRes detectionDetail) {
        detectionDetailDao.insertRealtimeSelective(detectionDetail);
    }

    public void syncUpdateRealtimeDetectionDetail(DetectionDetailRes detectionDetail) {
        detectionDetailDao.updateRealtimeByPrimaryKeySelective(detectionDetail);
    }
}
