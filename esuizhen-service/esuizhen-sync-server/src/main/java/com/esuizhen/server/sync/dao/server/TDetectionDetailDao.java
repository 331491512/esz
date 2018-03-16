package com.esuizhen.server.sync.dao.server;

import com.esuizhen.server.sync.bean.server.DetectionDetailRes;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public interface TDetectionDetailDao {

    void insertSelective(DetectionDetailRes record);

    void updateByPrimaryKeySelective(DetectionDetailRes record);

    /**
     * 同步同时向实时库中添加
     * @param detectionDetail
     */
    void insertRealtimeSelective(DetectionDetailRes detectionDetail);
    /**
     * 同步同时向实时库中更新
     * @param detectionDetail
     */
    void updateRealtimeByPrimaryKeySelective(DetectionDetailRes detectionDetail);
}