package com.esuizhen.server.sync.dao.sc;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

import java.util.List;

/**
 * Created by Nidan on 2017年03月22 下午 17:27
 */
public interface InhospitalNoteSyncResultServerDao {

    //插入结果
    public int insert(Object obj);
    //获取同步结果
    List<TBatchDataResultInfo> getBatchDataResult(@Param("batchId")String batchId);
}
