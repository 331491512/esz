package com.esuizhen.server.sync.service;

import com.esuizhen.server.sync.bean.*;

import java.util.List;

public interface BatchService {
	/**
	 * 
	 * @author lichenghao
	 * @title :getBatchInfo
	 * @Description:获取批次
	 * @return TBatchInfo
	 * @date 2017年3月18日 下午2:37:46
	 */
	TBatchInfo getBatchInfo(BatchInfoGetReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateBatchProcess
	 * @Description:修改批次状态
	 * @return void
	 * @date 2017年3月18日 下午2:37:57
	 */
	void updateBatchProcess(BatchProcessUpdateReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :pushBatchData
	 * @Description:数据推送
	 * @return void
	 * @date 2017年3月18日 下午2:38:09
	 */
	void pushBatchData(BatchDataPushReq req);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getBatChDataResult
	 * @Description:批次结果获取
	 * @return List<TBatchDataResultInfo>
	 * @date 2017年3月18日 下午2:39:41
	 */
	List<TBatchDataResultInfo> getBatchDataResult(BatchDataResultGetReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :doBatchProcess
	 * @Description:批次处理
	 * @return void
	 * @date 2017年3月21日 上午11:02:47
	 */
	void doBatchProcess(BatchProcessDoReq req);

	/**
	 * 被合并的已同步患者推送
	 * @param req
	 */
    void pushPatientMergeInfo(PatientMergeInfoSyncReq req);
    
    /**
     * 
     * @author lichenghao
     * @title :loadingBatch
     * @Description:加载批次
     * @return void
     * @date 2017年4月21日 下午2:13:12
     */
	void loadingBatch();
}
