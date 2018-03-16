package com.esuizhen.server.sync.dao.temp;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.DetectionDetailRes;
import com.esuizhen.server.sync.model.temp.SyncEciDetectionDetail;

import java.util.List;

public interface TempEciDetectionDetailDao {

	void insert(SyncEciDetectionDetail eciDetectionDetail);

	List<DetectionDetailRes> getSyncDetectionDetailNote(TBatchDetailInfo detail);

	/**
	 * 实时库需要同步
	 * @param detail
	 * @return
	 */
	List<DetectionDetailRes> getSyncDetectionDetailNoteByRealtime(TBatchDetailInfo detail);
}
