package com.esuizhen.server.sync.service;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;

/**
 * Created by Nidan on 2017年03月22 上午 10:42
 */
public interface SyncResultService {

    /**
     * 记录更新业务表同步结果
     * @param detail TBatchDetailInfo
     * @param resultId uuid
     * @param syncFlag 同步状态
     * @param cause 失败原因
     */
    public void recordSyncResult(TBatchDetailInfo detail,Object resultId,Integer syncFlag,String cause);

    /**
     * 记录同步结果（记录所有的）
     * @param detail TBatchDetailInfo
     * @param resultId uuid
     * @param syncFlag 同步状态
     * @param cause 失败原因
     */
    public void recordSyncResultHistory(TBatchDetailInfo detail,String resultId,Integer syncFlag,String cause);
}
